package external.sdk.pendo.io.mozilla.javascript.optimizer;

import androidx.core.app.NotificationCompat;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import external.sdk.pendo.io.mozilla.javascript.CompilerEnvirons;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Kit;
import external.sdk.pendo.io.mozilla.javascript.Node;
import external.sdk.pendo.io.mozilla.javascript.Token;
import external.sdk.pendo.io.mozilla.javascript.ast.FunctionNode;
import external.sdk.pendo.io.mozilla.javascript.ast.Jump;
import external.sdk.pendo.io.mozilla.javascript.ast.ScriptNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import sdk.pendo.io.events.ConditionData;
import sdk.pendo.io.v2.c;

/* loaded from: classes2.dex */
class BodyCodegen {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ECMAERROR_EXCEPTION = 2;
    private static final int EVALUATOR_EXCEPTION = 1;
    private static final int EXCEPTION_MAX = 5;
    private static final int FINALLY_EXCEPTION = 4;
    static final int GENERATOR_START = 0;
    static final int GENERATOR_TERMINATE = -1;
    static final int GENERATOR_YIELD_START = 1;
    private static final int JAVASCRIPT_EXCEPTION = 0;
    private static final int MAX_LOCALS = 1024;
    private static final int THROWABLE_EXCEPTION = 3;
    private short argsLocal;
    c cfw;
    Codegen codegen;
    CompilerEnvirons compilerEnv;
    private short contextLocal;
    private int enterAreaStartLabel;
    private int epilogueLabel;
    private Map<Node, FinallyReturnPoint> finallys;
    private short firstFreeLocal;
    private OptFunctionNode fnCurrent;
    private short funObjLocal;
    private short generatorStateLocal;
    private int generatorSwitch;
    private boolean hasVarsInRegs;
    private boolean inDirectCallFunction;
    private boolean inLocalBlock;
    private boolean isGenerator;
    private boolean itsForcedObjectParameters;
    private int itsLineNumber;
    private short itsOneArgArray;
    private short itsZeroArgArray;
    private List<Node> literals;
    private int[] locals;
    private short localsMax;
    private short operationLocal;
    private short popvLocal;
    private int savedCodeOffset;
    ScriptNode scriptOrFn;
    public int scriptOrFnIndex;
    private short thisObjLocal;
    private short[] varRegisters;
    private short variableObjectLocal;
    private ExceptionManager exceptionManager = new ExceptionManager();
    private int maxLocals = 0;
    private int maxStack = 0;
    private int unnestedYieldCount = 0;
    private IdentityHashMap<Node, String> unnestedYields = new IdentityHashMap<>();

    private class ExceptionManager {
        private LinkedList<ExceptionInfo> exceptionInfo = new LinkedList<>();

        private class ExceptionInfo {
            Node finallyBlock;
            int[] handlerLabels = new int[5];
            int[] exceptionStarts = new int[5];
            Node currentFinally = null;

            ExceptionInfo(Jump jump, Node node) {
                this.finallyBlock = node;
            }
        }

        ExceptionManager() {
        }

        private void endCatch(ExceptionInfo exceptionInfo, int i, int i2) {
            int i3 = exceptionInfo.exceptionStarts[i];
            if (i3 == 0) {
                throw new IllegalStateException("bad exception start");
            }
            if (BodyCodegen.this.cfw.u(i3) != BodyCodegen.this.cfw.u(i2)) {
                BodyCodegen.this.cfw.a(exceptionInfo.exceptionStarts[i], i2, exceptionInfo.handlerLabels[i], BodyCodegen.exceptionTypeToName(i));
            }
        }

        private ExceptionInfo getTop() {
            return this.exceptionInfo.getLast();
        }

        void addHandler(int i, int i2, int i3) {
            ExceptionInfo top = getTop();
            top.handlerLabels[i] = i2;
            top.exceptionStarts[i] = i3;
        }

        void markInlineFinallyEnd(Node node, int i) {
            LinkedList<ExceptionInfo> linkedList = this.exceptionInfo;
            ListIterator<ExceptionInfo> listIterator = linkedList.listIterator(linkedList.size());
            while (listIterator.hasPrevious()) {
                ExceptionInfo previous = listIterator.previous();
                for (int i2 = 0; i2 < 5; i2++) {
                    if (previous.handlerLabels[i2] != 0 && previous.currentFinally == node) {
                        previous.exceptionStarts[i2] = i;
                        previous.currentFinally = null;
                    }
                }
                if (previous.finallyBlock == node) {
                    return;
                }
            }
        }

        void markInlineFinallyStart(Node node, int i) {
            LinkedList<ExceptionInfo> linkedList = this.exceptionInfo;
            ListIterator<ExceptionInfo> listIterator = linkedList.listIterator(linkedList.size());
            while (listIterator.hasPrevious()) {
                ExceptionInfo previous = listIterator.previous();
                for (int i2 = 0; i2 < 5; i2++) {
                    if (previous.handlerLabels[i2] != 0 && previous.currentFinally == null) {
                        endCatch(previous, i2, i);
                        previous.exceptionStarts[i2] = 0;
                        previous.currentFinally = node;
                    }
                }
                if (previous.finallyBlock == node) {
                    return;
                }
            }
        }

        void popExceptionInfo() {
            this.exceptionInfo.removeLast();
        }

        void pushExceptionInfo(Jump jump) {
            this.exceptionInfo.add(new ExceptionInfo(jump, BodyCodegen.getFinallyAtTarget(jump.getFinally())));
        }

        int removeHandler(int i, int i2) {
            ExceptionInfo top = getTop();
            int i3 = top.handlerLabels[i];
            if (i3 == 0) {
                return 0;
            }
            endCatch(top, i, i2);
            top.handlerLabels[i] = 0;
            return i3;
        }

        void setHandlers(int[] iArr, int i) {
            for (int i2 = 0; i2 < iArr.length; i2++) {
                int i3 = iArr[i2];
                if (i3 != 0) {
                    addHandler(i2, i3, i);
                }
            }
        }
    }

    static class FinallyReturnPoint {
        public List<Integer> jsrPoints = new ArrayList();
        public int tableLabel = 0;

        FinallyReturnPoint() {
        }
    }

    BodyCodegen() {
    }

    private void addDoubleWrap() {
        addOptRuntimeInvoke("wrapDouble", "(D)Ljava/lang/Double;");
    }

    private void addGoto(Node node, int i) {
        this.cfw.a(i, getTargetLabel(node));
    }

    private void addGotoWithReturn(Node node) {
        FinallyReturnPoint finallyReturnPoint = this.finallys.get(node);
        this.cfw.k(finallyReturnPoint.jsrPoints.size());
        addGoto(node, Token.LAST_TOKEN);
        this.cfw.b(87);
        int a2 = this.cfw.a();
        this.cfw.w(a2);
        finallyReturnPoint.jsrPoints.add(Integer.valueOf(a2));
    }

    private void addInstructionCount() {
        addInstructionCount(Math.max(this.cfw.g() - this.savedCodeOffset, 1));
    }

    private void addJumpedBooleanWrap(int i, int i2) {
        this.cfw.w(i2);
        int a2 = this.cfw.a();
        this.cfw.a(178, "java/lang/Boolean", "FALSE", "Ljava/lang/Boolean;");
        this.cfw.a(Token.LAST_TOKEN, a2);
        this.cfw.w(i);
        this.cfw.a(178, "java/lang/Boolean", "TRUE", "Ljava/lang/Boolean;");
        this.cfw.w(a2);
        this.cfw.q(-1);
    }

    private void addLoadPropertyIds(Object[] objArr, int i) {
        addNewObjectArray(i);
        for (int i2 = 0; i2 != i; i2++) {
            this.cfw.b(89);
            this.cfw.l(i2);
            Object obj = objArr[i2];
            if (obj instanceof String) {
                this.cfw.e((String) obj);
            } else {
                this.cfw.l(((Integer) obj).intValue());
                addScriptRuntimeInvoke("wrapInt", "(I)Ljava/lang/Integer;");
            }
            this.cfw.b(83);
        }
    }

    private void addLoadPropertyValues(Node node, Node node2, int i) {
        int i2 = 0;
        if (!this.isGenerator) {
            addNewObjectArray(i);
            while (i2 != i) {
                this.cfw.b(89);
                this.cfw.l(i2);
                int type = node2.getType();
                if (type == 152 || type == 153 || type == 164) {
                    generateExpression(node2.getFirstChild(), node);
                } else {
                    generateExpression(node2, node);
                }
                this.cfw.b(83);
                node2 = node2.getNext();
                i2++;
            }
            return;
        }
        for (int i3 = 0; i3 != i; i3++) {
            int type2 = node2.getType();
            if (type2 == 152 || type2 == 153 || type2 == 164) {
                generateExpression(node2.getFirstChild(), node);
            } else {
                generateExpression(node2, node);
            }
            node2 = node2.getNext();
        }
        addNewObjectArray(i);
        while (i2 != i) {
            this.cfw.b(90);
            this.cfw.b(95);
            this.cfw.l((i - i2) - 1);
            this.cfw.b(95);
            this.cfw.b(83);
            i2++;
        }
    }

    private void addNewObjectArray(int i) {
        if (i != 0) {
            this.cfw.l(i);
            this.cfw.a(189, "java/lang/Object");
            return;
        }
        short s = this.itsZeroArgArray;
        if (s >= 0) {
            this.cfw.c((int) s);
        } else {
            this.cfw.a(178, "external/sdk/pendo/io/mozilla/javascript/ScriptRuntime", "emptyArgs", "[Ljava/lang/Object;");
        }
    }

    private void addObjectToDouble() {
        addScriptRuntimeInvoke("toNumber", "(Ljava/lang/Object;)D");
    }

    private void addOptRuntimeInvoke(String str, String str2) {
        this.cfw.b(184, "external/sdk/pendo/io/mozilla/javascript/optimizer/OptRuntime", str, str2);
    }

    private void addScriptRuntimeInvoke(String str, String str2) {
        this.cfw.b(184, "external.sdk.pendo.io.mozilla.javascript.ScriptRuntime", str, str2);
    }

    private void dcpLoadAsNumber(int i) {
        this.cfw.c(i);
        this.cfw.a(178, "java/lang/Void", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/Class;");
        int a2 = this.cfw.a();
        this.cfw.a(Token.ARROW, a2);
        short h = this.cfw.h();
        this.cfw.c(i);
        addObjectToDouble();
        int a3 = this.cfw.a();
        this.cfw.a(Token.LAST_TOKEN, a3);
        this.cfw.a(a2, h);
        this.cfw.e(i + 1);
        this.cfw.w(a3);
    }

    private void dcpLoadAsObject(int i) {
        this.cfw.c(i);
        this.cfw.a(178, "java/lang/Void", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/Class;");
        int a2 = this.cfw.a();
        this.cfw.a(Token.ARROW, a2);
        short h = this.cfw.h();
        this.cfw.c(i);
        int a3 = this.cfw.a();
        this.cfw.a(Token.LAST_TOKEN, a3);
        this.cfw.a(a2, h);
        this.cfw.e(i + 1);
        addDoubleWrap();
        this.cfw.w(a3);
    }

    private void decReferenceWordLocal(short s) {
        this.locals[s] = r0[s] - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String exceptionTypeToName(int i) {
        if (i == 0) {
            return "external/sdk/pendo/io/mozilla/javascript/JavaScriptException";
        }
        if (i == 1) {
            return "external/sdk/pendo/io/mozilla/javascript/EvaluatorException";
        }
        if (i == 2) {
            return "external/sdk/pendo/io/mozilla/javascript/EcmaError";
        }
        if (i == 3) {
            return "java/lang/Throwable";
        }
        if (i == 4) {
            return null;
        }
        throw Kit.codeBug();
    }

    private Node findNestedYield(Node node) {
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNext()) {
            if (firstChild.getType() == 73 || firstChild.getType() == 166) {
                return firstChild;
            }
            Node findNestedYield = findNestedYield(firstChild);
            if (findNestedYield != null) {
                return findNestedYield;
            }
        }
        return null;
    }

    private void genSimpleCompare(int i, int i2, int i3) {
        c cVar;
        int i4;
        if (i2 == -1) {
            throw Codegen.badTree();
        }
        switch (i) {
            case 14:
                this.cfw.b(152);
                cVar = this.cfw;
                i4 = 155;
                break;
            case 15:
                this.cfw.b(152);
                cVar = this.cfw;
                i4 = 158;
                break;
            case 16:
                this.cfw.b(151);
                cVar = this.cfw;
                i4 = 157;
                break;
            case 17:
                this.cfw.b(151);
                cVar = this.cfw;
                i4 = 156;
                break;
            default:
                throw Codegen.badTree();
        }
        cVar.a(i4, i2);
        if (i3 != -1) {
            this.cfw.a(Token.LAST_TOKEN, i3);
        }
    }

    private void generateActivationExit() {
        if (this.fnCurrent == null || this.hasVarsInRegs) {
            throw Kit.codeBug();
        }
        this.cfw.c((int) this.contextLocal);
        addScriptRuntimeInvoke("exitActivationFunction", "(Lorg/mozilla/javascript/Context;)V");
    }

    private void generateArrayLiteralFactory(Node node, int i) {
        String str = this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + i;
        initBodyGeneration();
        short s = this.firstFreeLocal;
        short s2 = (short) (s + 1);
        this.firstFreeLocal = s2;
        this.argsLocal = s;
        this.localsMax = s2;
        this.cfw.b(str, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;", (short) 2);
        visitArrayLiteral(node, node.getFirstChild(), true);
        this.cfw.b(176);
        this.cfw.c((short) (this.localsMax + 1));
    }

    private void generateCallArgArray(Node node, Node node2, boolean z) {
        short s;
        int i = 0;
        for (Node node3 = node2; node3 != null; node3 = node3.getNext()) {
            i++;
        }
        if (i != 1 || (s = this.itsOneArgArray) < 0) {
            addNewObjectArray(i);
        } else {
            this.cfw.c((int) s);
        }
        for (int i2 = 0; i2 != i; i2++) {
            if (!this.isGenerator) {
                this.cfw.b(89);
                this.cfw.l(i2);
            }
            if (z) {
                int nodeIsDirectCallParameter = nodeIsDirectCallParameter(node2);
                if (nodeIsDirectCallParameter >= 0) {
                    dcpLoadAsObject(nodeIsDirectCallParameter);
                } else {
                    generateExpression(node2, node);
                    if (node2.getIntProp(8, -1) == 0) {
                        addDoubleWrap();
                    }
                }
            } else {
                generateExpression(node2, node);
            }
            if (this.isGenerator) {
                short newWordLocal = getNewWordLocal();
                this.cfw.d(newWordLocal);
                this.cfw.a(192, "[Ljava/lang/Object;");
                this.cfw.b(89);
                this.cfw.l(i2);
                this.cfw.c((int) newWordLocal);
                releaseWordLocal(newWordLocal);
            }
            this.cfw.b(83);
            node2 = node2.getNext();
        }
    }

    private void generateCatchBlock(int i, short s, int i2, int i3, int i4) {
        if (i4 == 0) {
            i4 = this.cfw.a();
        }
        this.cfw.v(i4);
        this.cfw.d(i3);
        this.cfw.c((int) s);
        this.cfw.d(this.variableObjectLocal);
        this.cfw.a(Token.LAST_TOKEN, i2);
    }

    private void generateCheckForThrowOrClose(int i, boolean z, int i2) {
        int a2 = this.cfw.a();
        int a3 = this.cfw.a();
        this.cfw.w(a2);
        this.cfw.c((int) this.argsLocal);
        generateThrowJavaScriptException();
        this.cfw.w(a3);
        this.cfw.c((int) this.argsLocal);
        this.cfw.a(192, "java/lang/Throwable");
        this.cfw.b(191);
        if (i != -1) {
            this.cfw.w(i);
        }
        if (!z) {
            this.cfw.d(this.generatorSwitch, i2);
        }
        this.cfw.h(this.operationLocal);
        this.cfw.k(2);
        this.cfw.a(Token.LETEXPR, a3);
        this.cfw.h(this.operationLocal);
        this.cfw.k(1);
        this.cfw.a(Token.LETEXPR, a2);
    }

    private void generateEpilogue() {
        if (this.compilerEnv.isGenerateObserverCount()) {
            addInstructionCount();
        }
        if (this.isGenerator) {
            Map<Node, int[]> liveLocals = ((FunctionNode) this.scriptOrFn).getLiveLocals();
            if (liveLocals != null) {
                List<Node> resumptionPoints = ((FunctionNode) this.scriptOrFn).getResumptionPoints();
                for (int i = 0; i < resumptionPoints.size(); i++) {
                    Node node = resumptionPoints.get(i);
                    int[] iArr = liveLocals.get(node);
                    if (iArr != null) {
                        this.cfw.d(this.generatorSwitch, getNextGeneratorState(node));
                        generateGetGeneratorLocalsState();
                        for (int i2 = 0; i2 < iArr.length; i2++) {
                            this.cfw.b(89);
                            this.cfw.k(i2);
                            this.cfw.b(50);
                            this.cfw.d(iArr[i2]);
                        }
                        this.cfw.b(87);
                        this.cfw.a(Token.LAST_TOKEN, getTargetLabel(node));
                    }
                }
            }
            Map<Node, FinallyReturnPoint> map = this.finallys;
            if (map != null) {
                for (Map.Entry<Node, FinallyReturnPoint> entry : map.entrySet()) {
                    if (entry.getKey().getType() == 126) {
                        FinallyReturnPoint value = entry.getValue();
                        this.cfw.a(value.tableLabel, (short) 1);
                        int c = this.cfw.c(0, value.jsrPoints.size() - 1);
                        this.cfw.x(c);
                        int i3 = 0;
                        for (int i4 = 0; i4 < value.jsrPoints.size(); i4++) {
                            this.cfw.d(c, i3);
                            this.cfw.a(Token.LAST_TOKEN, value.jsrPoints.get(i4).intValue());
                            i3++;
                        }
                    }
                }
            }
        }
        int i5 = this.epilogueLabel;
        if (i5 != -1) {
            this.cfw.w(i5);
        }
        if (this.isGenerator) {
            if (((FunctionNode) this.scriptOrFn).getResumptionPoints() != null) {
                this.cfw.x(this.generatorSwitch);
            }
            generateSetGeneratorResumptionPoint(-1);
            this.cfw.c((int) this.variableObjectLocal);
            this.cfw.c((int) this.generatorStateLocal);
            addOptRuntimeInvoke("throwStopIteration", "(Ljava/lang/Object;Ljava/lang/Object;)V");
            Codegen.pushUndefined(this.cfw);
        } else if (!this.hasVarsInRegs) {
            if (this.fnCurrent != null) {
                generateActivationExit();
                this.cfw.b(176);
                int a2 = this.cfw.a();
                this.cfw.v(a2);
                short newWordLocal = getNewWordLocal();
                this.cfw.d(newWordLocal);
                generateActivationExit();
                this.cfw.c((int) newWordLocal);
                releaseWordLocal(newWordLocal);
                this.cfw.b(191);
                this.cfw.a(this.enterAreaStartLabel, this.epilogueLabel, a2, (String) null);
                return;
            }
            this.cfw.c((int) this.popvLocal);
        }
        this.cfw.b(176);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:217:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x044e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void generateExpression(external.sdk.pendo.io.mozilla.javascript.Node r18, external.sdk.pendo.io.mozilla.javascript.Node r19) {
        /*
            Method dump skipped, instructions count: 1522
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.optimizer.BodyCodegen.generateExpression(external.sdk.pendo.io.mozilla.javascript.Node, external.sdk.pendo.io.mozilla.javascript.Node):void");
    }

    private void generateFunctionAndThisObj(Node node, Node node2) {
        String str;
        String str2;
        int type = node.getType();
        int type2 = node.getType();
        if (type2 != 33) {
            if (type2 == 34) {
                throw Kit.codeBug();
            }
            if (type2 != 36) {
                if (type2 != 39) {
                    generateExpression(node, node2);
                    this.cfw.c((int) this.contextLocal);
                    str = "getValueFunctionAndThis";
                    str2 = "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/Callable;";
                } else {
                    this.cfw.e(node.getString());
                    this.cfw.c((int) this.contextLocal);
                    this.cfw.c((int) this.variableObjectLocal);
                    str = "getNameFunctionAndThis";
                    str2 = "(Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Callable;";
                }
                addScriptRuntimeInvoke(str, str2);
                this.cfw.c((int) this.contextLocal);
                addScriptRuntimeInvoke("lastStoredScriptable", "(Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/Scriptable;");
            }
        }
        Node firstChild = node.getFirstChild();
        generateExpression(firstChild, node);
        Node next = firstChild.getNext();
        if (type == 33) {
            this.cfw.e(next.getString());
            this.cfw.c((int) this.contextLocal);
            this.cfw.c((int) this.variableObjectLocal);
            str = "getPropFunctionAndThis";
            str2 = "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Callable;";
        } else {
            generateExpression(next, node);
            if (node.getIntProp(8, -1) != -1) {
                addDoubleWrap();
            }
            this.cfw.c((int) this.contextLocal);
            this.cfw.c((int) this.variableObjectLocal);
            str = "getElemFunctionAndThis";
            str2 = "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Callable;";
        }
        addScriptRuntimeInvoke(str, str2);
        this.cfw.c((int) this.contextLocal);
        addScriptRuntimeInvoke("lastStoredScriptable", "(Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/Scriptable;");
    }

    private void generateGenerator() {
        this.cfw.b(this.codegen.getBodyMethodName(this.scriptOrFn), this.codegen.getBodyMethodSignature(this.scriptOrFn), (short) 10);
        initBodyGeneration();
        short s = this.firstFreeLocal;
        short s2 = (short) (s + 1);
        this.firstFreeLocal = s2;
        this.argsLocal = s;
        this.localsMax = s2;
        if (this.fnCurrent != null) {
            this.cfw.c((int) this.funObjLocal);
            this.cfw.b(185, "external/sdk/pendo/io/mozilla/javascript/Scriptable", "getParentScope", "()Lorg/mozilla/javascript/Scriptable;");
            this.cfw.d(this.variableObjectLocal);
        }
        this.cfw.c((int) this.funObjLocal);
        this.cfw.c((int) this.variableObjectLocal);
        this.cfw.c((int) this.argsLocal);
        this.cfw.a(this.scriptOrFn.isInStrictMode());
        addScriptRuntimeInvoke("createFunctionActivation", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Z)Lorg/mozilla/javascript/Scriptable;");
        this.cfw.d(this.variableObjectLocal);
        this.cfw.a(187, this.codegen.mainClassName);
        this.cfw.b(89);
        this.cfw.c((int) this.variableObjectLocal);
        this.cfw.c((int) this.contextLocal);
        this.cfw.l(this.scriptOrFnIndex);
        this.cfw.b(183, this.codegen.mainClassName, "<init>", "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;I)V");
        generateNestedFunctionInits();
        this.cfw.c((int) this.variableObjectLocal);
        this.cfw.c((int) this.thisObjLocal);
        this.cfw.k(this.maxLocals);
        this.cfw.k(this.maxStack);
        addOptRuntimeInvoke("createNativeGenerator", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;II)Lorg/mozilla/javascript/Scriptable;");
        this.cfw.b(176);
        this.cfw.c((short) (this.localsMax + 1));
    }

    private void generateGetGeneratorLocalsState() {
        this.cfw.c((int) this.generatorStateLocal);
        addOptRuntimeInvoke("getGeneratorLocalsState", "(Ljava/lang/Object;)[Ljava/lang/Object;");
    }

    private void generateGetGeneratorResumptionPoint() {
        this.cfw.c((int) this.generatorStateLocal);
        this.cfw.a(180, "external/sdk/pendo/io/mozilla/javascript/optimizer/OptRuntime$GeneratorState", "resumptionPoint", "I");
    }

    private void generateGetGeneratorStackState() {
        this.cfw.c((int) this.generatorStateLocal);
        addOptRuntimeInvoke("getGeneratorStackState", "(Ljava/lang/Object;)[Ljava/lang/Object;");
    }

    private void generateIfJump(Node node, Node node2, int i, int i2) {
        int type = node.getType();
        Node firstChild = node.getFirstChild();
        if (type == 26) {
            generateIfJump(firstChild, node, i2, i);
            return;
        }
        if (type != 46 && type != 47) {
            if (type != 52 && type != 53) {
                if (type == 105 || type == 106) {
                    int a2 = this.cfw.a();
                    if (type == 106) {
                        generateIfJump(firstChild, node, a2, i2);
                    } else {
                        generateIfJump(firstChild, node, i, a2);
                    }
                    this.cfw.w(a2);
                    generateIfJump(firstChild.getNext(), node, i, i2);
                    return;
                }
                switch (type) {
                    case 12:
                    case 13:
                        break;
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                        break;
                    default:
                        generateExpression(node, node2);
                        addScriptRuntimeInvoke("toBoolean", "(Ljava/lang/Object;)Z");
                        this.cfw.a(154, i);
                        this.cfw.a(Token.LAST_TOKEN, i2);
                        break;
                }
                return;
            }
            visitIfJumpRelOp(node, firstChild, i, i2);
            return;
        }
        visitIfJumpEqOp(node, firstChild, i, i2);
    }

    private void generateIntegerUnwrap() {
        this.cfw.b(182, "java/lang/Integer", "intValue", "()I");
    }

    private void generateIntegerWrap() {
        this.cfw.b(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
    }

    private void generateLocalYieldPoint(Node node, boolean z) {
        c cVar;
        int h = this.cfw.h();
        int i = this.maxStack;
        if (i <= h) {
            i = h;
        }
        this.maxStack = i;
        if (h != 0) {
            generateGetGeneratorStackState();
            for (int i2 = 0; i2 < h; i2++) {
                this.cfw.b(90);
                this.cfw.b(95);
                this.cfw.k(i2);
                this.cfw.b(95);
                this.cfw.b(83);
            }
            this.cfw.b(87);
        }
        Node firstChild = node.getFirstChild();
        if (firstChild != null) {
            generateExpression(firstChild, node);
        } else {
            Codegen.pushUndefined(this.cfw);
        }
        if (node.getType() == 166) {
            this.cfw.a(187, "external/sdk/pendo/io/mozilla/javascript/ES6Generator$YieldStarResult");
            this.cfw.b(90);
            this.cfw.b(95);
            this.cfw.b(183, "external/sdk/pendo/io/mozilla/javascript/ES6Generator$YieldStarResult", "<init>", "(Ljava/lang/Object;)V");
        }
        int nextGeneratorState = getNextGeneratorState(node);
        generateSetGeneratorResumptionPoint(nextGeneratorState);
        boolean generateSaveLocals = generateSaveLocals(node);
        this.cfw.b(176);
        generateCheckForThrowOrClose(getTargetLabel(node), generateSaveLocals, nextGeneratorState);
        if (h != 0) {
            generateGetGeneratorStackState();
            while (true) {
                h--;
                cVar = this.cfw;
                if (h < 0) {
                    break;
                }
                cVar.b(89);
                this.cfw.k(h);
                this.cfw.b(50);
                this.cfw.b(95);
            }
            cVar.b(87);
        }
        if (z) {
            this.cfw.c((int) this.argsLocal);
        }
    }

    private void generateNestedFunctionInits() {
        int functionCount = this.scriptOrFn.getFunctionCount();
        for (int i = 0; i != functionCount; i++) {
            OptFunctionNode optFunctionNode = OptFunctionNode.get(this.scriptOrFn, i);
            if (optFunctionNode.fnode.getFunctionType() == 1) {
                visitFunction(optFunctionNode, 1);
            }
        }
    }

    private void generateObjectLiteralFactory(Node node, int i) {
        String str = this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + i;
        initBodyGeneration();
        short s = this.firstFreeLocal;
        short s2 = (short) (s + 1);
        this.firstFreeLocal = s2;
        this.argsLocal = s;
        this.localsMax = s2;
        this.cfw.b(str, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;", (short) 2);
        visitObjectLiteral(node, node.getFirstChild(), true);
        this.cfw.b(176);
        this.cfw.c((short) (this.localsMax + 1));
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0248 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void generatePrologue() {
        /*
            Method dump skipped, instructions count: 871
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.optimizer.BodyCodegen.generatePrologue():void");
    }

    private boolean generateSaveLocals(Node node) {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.firstFreeLocal; i3++) {
            if (this.locals[i3] != 0) {
                i2++;
            }
        }
        if (i2 == 0) {
            ((FunctionNode) this.scriptOrFn).addLiveLocals(node, null);
            return false;
        }
        int i4 = this.maxLocals;
        if (i4 <= i2) {
            i4 = i2;
        }
        this.maxLocals = i4;
        int[] iArr = new int[i2];
        int i5 = 0;
        for (int i6 = 0; i6 < this.firstFreeLocal; i6++) {
            if (this.locals[i6] != 0) {
                iArr[i5] = i6;
                i5++;
            }
        }
        ((FunctionNode) this.scriptOrFn).addLiveLocals(node, iArr);
        generateGetGeneratorLocalsState();
        while (true) {
            c cVar = this.cfw;
            if (i >= i2) {
                cVar.b(87);
                return true;
            }
            cVar.b(89);
            this.cfw.k(i);
            this.cfw.c(iArr[i]);
            this.cfw.b(83);
            i++;
        }
    }

    private void generateSetGeneratorResumptionPoint(int i) {
        this.cfw.c((int) this.generatorStateLocal);
        this.cfw.k(i);
        this.cfw.a(181, "external/sdk/pendo/io/mozilla/javascript/optimizer/OptRuntime$GeneratorState", "resumptionPoint", "I");
    }

    private void generateSetGeneratorReturnValue() {
        this.cfw.c((int) this.generatorStateLocal);
        this.cfw.b(95);
        addOptRuntimeInvoke("setGeneratorReturnValue", "(Ljava/lang/Object;Ljava/lang/Object;)V");
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0294  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void generateStatement(external.sdk.pendo.io.mozilla.javascript.Node r9) {
        /*
            Method dump skipped, instructions count: 830
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.optimizer.BodyCodegen.generateStatement(external.sdk.pendo.io.mozilla.javascript.Node):void");
    }

    private void generateThrowJavaScriptException() {
        this.cfw.a(187, "external/sdk/pendo/io/mozilla/javascript/JavaScriptException");
        this.cfw.b(90);
        this.cfw.b(95);
        this.cfw.e(this.scriptOrFn.getSourceName());
        this.cfw.l(this.itsLineNumber);
        this.cfw.b(183, "external/sdk/pendo/io/mozilla/javascript/JavaScriptException", "<init>", "(Ljava/lang/Object;Ljava/lang/String;I)V");
        this.cfw.b(191);
    }

    private void generateYieldPoint(Node node, boolean z) {
        if (this.unnestedYields.containsKey(node)) {
            if (z) {
                this.cfw.c((int) this.variableObjectLocal);
                this.cfw.d(this.unnestedYields.get(node));
                this.cfw.c((int) this.contextLocal);
                this.cfw.c((int) this.variableObjectLocal);
                addScriptRuntimeInvoke("getObjectPropNoWarn", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
                return;
            }
            return;
        }
        Node findNestedYield = findNestedYield(node);
        if (findNestedYield != null) {
            generateYieldPoint(findNestedYield, true);
            String str = "__nested__yield__" + this.unnestedYieldCount;
            this.unnestedYieldCount++;
            this.cfw.c((int) this.variableObjectLocal);
            this.cfw.b(95);
            this.cfw.d(str);
            this.cfw.b(95);
            this.cfw.c((int) this.contextLocal);
            addScriptRuntimeInvoke("setObjectProp", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
            this.cfw.b(87);
            this.unnestedYields.put(findNestedYield, str);
        }
        generateLocalYieldPoint(node, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Node getFinallyAtTarget(Node node) {
        Node next;
        if (node == null) {
            return null;
        }
        if (node.getType() == 126) {
            return node;
        }
        if (node.getType() == 132 && (next = node.getNext()) != null && next.getType() == 126) {
            return next;
        }
        throw Kit.codeBug("bad finally target");
    }

    private static int getLocalBlockRegister(Node node) {
        return ((Node) node.getProp(3)).getExistingIntProp(2);
    }

    private short getNewWordIntern(int i) {
        int i2;
        int[] iArr = this.locals;
        int i3 = this.firstFreeLocal;
        if (i > 1) {
            loop0: while (true) {
                if (i3 + i > 1024) {
                    i3 = -1;
                    break;
                }
                i2 = 0;
                while (i2 < i) {
                    int i4 = iArr[i3 + i2];
                    i2++;
                    if (i4 != 0) {
                        break;
                    }
                }
                break loop0;
                i3 += i2;
            }
        }
        if (i3 != -1) {
            iArr[i3] = 1;
            if (i > 1) {
                iArr[i3 + 1] = 1;
            }
            if (i > 2) {
                iArr[i3 + 2] = 1;
            }
            if (i3 != this.firstFreeLocal) {
                return (short) i3;
            }
            for (int i5 = i + i3; i5 < 1024; i5++) {
                if (iArr[i5] == 0) {
                    short s = (short) i5;
                    this.firstFreeLocal = s;
                    if (this.localsMax < s) {
                        this.localsMax = s;
                    }
                    return (short) i3;
                }
            }
        }
        throw Context.reportRuntimeError("Program too complex (out of locals)");
    }

    private short getNewWordLocal() {
        return getNewWordIntern(1);
    }

    private short getNewWordPairLocal(boolean z) {
        return getNewWordIntern(z ? 3 : 2);
    }

    private int getNextGeneratorState(Node node) {
        return ((FunctionNode) this.scriptOrFn).getResumptionPoints().indexOf(node) + 1;
    }

    private int getTargetLabel(Node node) {
        int labelId = node.labelId();
        if (labelId != -1) {
            return labelId;
        }
        int a2 = this.cfw.a();
        node.labelId(a2);
        return a2;
    }

    private void incReferenceWordLocal(short s) {
        int[] iArr = this.locals;
        iArr[s] = iArr[s] + 1;
    }

    private void initBodyGeneration() {
        int paramAndVarCount;
        this.varRegisters = null;
        if (this.scriptOrFn.getType() == 110) {
            OptFunctionNode optFunctionNode = OptFunctionNode.get(this.scriptOrFn);
            this.fnCurrent = optFunctionNode;
            boolean z = !optFunctionNode.fnode.requiresActivation();
            this.hasVarsInRegs = z;
            if (z && (paramAndVarCount = this.fnCurrent.fnode.getParamAndVarCount()) != 0) {
                this.varRegisters = new short[paramAndVarCount];
            }
            boolean isTargetOfDirectCall = this.fnCurrent.isTargetOfDirectCall();
            this.inDirectCallFunction = isTargetOfDirectCall;
            if (isTargetOfDirectCall && !this.hasVarsInRegs) {
                Codegen.badTree();
            }
        } else {
            this.fnCurrent = null;
            this.hasVarsInRegs = false;
            this.inDirectCallFunction = false;
        }
        this.locals = new int[1024];
        this.funObjLocal = (short) 0;
        this.contextLocal = (short) 1;
        this.variableObjectLocal = (short) 2;
        this.thisObjLocal = (short) 3;
        this.localsMax = (short) 4;
        this.firstFreeLocal = (short) 4;
        this.popvLocal = (short) -1;
        this.argsLocal = (short) -1;
        this.itsZeroArgArray = (short) -1;
        this.itsOneArgArray = (short) -1;
        this.epilogueLabel = -1;
        this.enterAreaStartLabel = -1;
        this.generatorStateLocal = (short) -1;
    }

    private void inlineFinally(Node node) {
        int a2 = this.cfw.a();
        int a3 = this.cfw.a();
        this.cfw.w(a2);
        inlineFinally(node, a2, a3);
        this.cfw.w(a3);
    }

    private static boolean isArithmeticNode(Node node) {
        int type = node.getType();
        return type == 22 || type == 25 || type == 24 || type == 23;
    }

    private int nodeIsDirectCallParameter(Node node) {
        if (node.getType() != 55 || !this.inDirectCallFunction || this.itsForcedObjectParameters) {
            return -1;
        }
        int varIndex = this.fnCurrent.getVarIndex(node);
        if (this.fnCurrent.isParameter(varIndex)) {
            return this.varRegisters[varIndex];
        }
        return -1;
    }

    private void releaseWordLocal(short s) {
        if (s < this.firstFreeLocal) {
            this.firstFreeLocal = s;
        }
        this.locals[s] = 0;
    }

    private void saveCurrentCodeOffset() {
        this.savedCodeOffset = this.cfw.g();
    }

    private void updateLineNumber(Node node) {
        int lineno = node.getLineno();
        this.itsLineNumber = lineno;
        if (lineno == -1) {
            return;
        }
        this.cfw.a((short) lineno);
    }

    private boolean varIsDirectCallParameter(int i) {
        return this.fnCurrent.isParameter(i) && this.inDirectCallFunction && !this.itsForcedObjectParameters;
    }

    private void visitArithmetic(Node node, int i, Node node2, Node node3) {
        if (node.getIntProp(8, -1) != -1) {
            generateExpression(node2, node);
            generateExpression(node2.getNext(), node);
            this.cfw.b(i);
            return;
        }
        boolean isArithmeticNode = isArithmeticNode(node3);
        generateExpression(node2, node);
        if (!isArithmeticNode(node2)) {
            addObjectToDouble();
        }
        generateExpression(node2.getNext(), node);
        if (!isArithmeticNode(node2.getNext())) {
            addObjectToDouble();
        }
        this.cfw.b(i);
        if (isArithmeticNode) {
            return;
        }
        addDoubleWrap();
    }

    private void visitArrayLiteral(Node node, Node node2, boolean z) {
        int i = 0;
        int i2 = 0;
        for (Node node3 = node2; node3 != null; node3 = node3.getNext()) {
            i2++;
        }
        if (!z && ((i2 > 10 || this.cfw.g() > 30000) && !this.hasVarsInRegs && !this.isGenerator && !this.inLocalBlock)) {
            if (this.literals == null) {
                this.literals = new LinkedList();
            }
            this.literals.add(node);
            String str = this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + this.literals.size();
            this.cfw.c((int) this.funObjLocal);
            this.cfw.c((int) this.contextLocal);
            this.cfw.c((int) this.variableObjectLocal);
            this.cfw.c((int) this.thisObjLocal);
            this.cfw.c((int) this.argsLocal);
            this.cfw.b(182, this.codegen.mainClassName, str, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
            return;
        }
        if (this.isGenerator) {
            for (int i3 = 0; i3 != i2; i3++) {
                generateExpression(node2, node);
                node2 = node2.getNext();
            }
            addNewObjectArray(i2);
            while (i != i2) {
                this.cfw.b(90);
                this.cfw.b(95);
                this.cfw.l((i2 - i) - 1);
                this.cfw.b(95);
                this.cfw.b(83);
                i++;
            }
        } else {
            addNewObjectArray(i2);
            while (i != i2) {
                this.cfw.b(89);
                this.cfw.l(i);
                generateExpression(node2, node);
                this.cfw.b(83);
                node2 = node2.getNext();
                i++;
            }
        }
        int[] iArr = (int[]) node.getProp(11);
        if (iArr == null) {
            this.cfw.b(1);
            this.cfw.b(3);
        } else {
            this.cfw.e(OptRuntime.encodeIntArray(iArr));
            this.cfw.l(iArr.length);
        }
        this.cfw.c((int) this.contextLocal);
        this.cfw.c((int) this.variableObjectLocal);
        addOptRuntimeInvoke("newArrayLiteral", "([Ljava/lang/Object;Ljava/lang/String;ILorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void visitBitOp(external.sdk.pendo.io.mozilla.javascript.Node r7, int r8, external.sdk.pendo.io.mozilla.javascript.Node r9) {
        /*
            r6 = this;
            r0 = 8
            r1 = -1
            int r0 = r7.getIntProp(r0, r1)
            r6.generateExpression(r9, r7)
            r2 = 20
            r3 = 126(0x7e, float:1.77E-43)
            java.lang.String r4 = "(Ljava/lang/Object;)I"
            java.lang.String r5 = "toInt32"
            if (r8 != r2) goto L43
            java.lang.String r8 = "toUint32"
            java.lang.String r0 = "(Ljava/lang/Object;)J"
            r6.addScriptRuntimeInvoke(r8, r0)
            external.sdk.pendo.io.mozilla.javascript.Node r8 = r9.getNext()
            r6.generateExpression(r8, r7)
            r6.addScriptRuntimeInvoke(r5, r4)
            sdk.pendo.io.v2.c r7 = r6.cfw
            r8 = 31
            r7.l(r8)
            sdk.pendo.io.v2.c r7 = r6.cfw
            r7.b(r3)
            sdk.pendo.io.v2.c r7 = r6.cfw
            r8 = 125(0x7d, float:1.75E-43)
            r7.b(r8)
            sdk.pendo.io.v2.c r7 = r6.cfw
            r8 = 138(0x8a, float:1.93E-43)
            r7.b(r8)
            r6.addDoubleWrap()
            return
        L43:
            if (r0 != r1) goto L53
            r6.addScriptRuntimeInvoke(r5, r4)
            external.sdk.pendo.io.mozilla.javascript.Node r9 = r9.getNext()
            r6.generateExpression(r9, r7)
            r6.addScriptRuntimeInvoke(r5, r4)
            goto L62
        L53:
            java.lang.String r2 = "(D)I"
            r6.addScriptRuntimeInvoke(r5, r2)
            external.sdk.pendo.io.mozilla.javascript.Node r9 = r9.getNext()
            r6.generateExpression(r9, r7)
            r6.addScriptRuntimeInvoke(r5, r2)
        L62:
            r7 = 18
            if (r8 == r7) goto L87
            r7 = 19
            if (r8 == r7) goto L82
            switch(r8) {
                case 9: goto L7d;
                case 10: goto L78;
                case 11: goto L72;
                default: goto L6d;
            }
        L6d:
            java.lang.RuntimeException r7 = external.sdk.pendo.io.mozilla.javascript.optimizer.Codegen.badTree()
            throw r7
        L72:
            sdk.pendo.io.v2.c r7 = r6.cfw
            r7.b(r3)
            goto L8e
        L78:
            sdk.pendo.io.v2.c r7 = r6.cfw
            r8 = 130(0x82, float:1.82E-43)
            goto L8b
        L7d:
            sdk.pendo.io.v2.c r7 = r6.cfw
            r8 = 128(0x80, float:1.8E-43)
            goto L8b
        L82:
            sdk.pendo.io.v2.c r7 = r6.cfw
            r8 = 122(0x7a, float:1.71E-43)
            goto L8b
        L87:
            sdk.pendo.io.v2.c r7 = r6.cfw
            r8 = 120(0x78, float:1.68E-43)
        L8b:
            r7.b(r8)
        L8e:
            sdk.pendo.io.v2.c r7 = r6.cfw
            r8 = 135(0x87, float:1.89E-43)
            r7.b(r8)
            if (r0 != r1) goto L9a
            r6.addDoubleWrap()
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.optimizer.BodyCodegen.visitBitOp(external.sdk.pendo.io.mozilla.javascript.Node, int, external.sdk.pendo.io.mozilla.javascript.Node):void");
    }

    private void visitDotQuery(Node node, Node node2) {
        updateLineNumber(node);
        generateExpression(node2, node);
        this.cfw.c((int) this.variableObjectLocal);
        addScriptRuntimeInvoke("enterDotQuery", "(Ljava/lang/Object;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
        this.cfw.d(this.variableObjectLocal);
        this.cfw.b(1);
        int a2 = this.cfw.a();
        this.cfw.w(a2);
        this.cfw.b(87);
        generateExpression(node2.getNext(), node);
        addScriptRuntimeInvoke("toBoolean", "(Ljava/lang/Object;)Z");
        this.cfw.c((int) this.variableObjectLocal);
        addScriptRuntimeInvoke("updateDotQuery", "(ZLorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
        this.cfw.b(89);
        this.cfw.a(198, a2);
        this.cfw.c((int) this.variableObjectLocal);
        addScriptRuntimeInvoke("leaveDotQuery", "(Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
        this.cfw.d(this.variableObjectLocal);
    }

    private void visitFunction(OptFunctionNode optFunctionNode, int i) {
        int index = this.codegen.getIndex(optFunctionNode.fnode);
        this.cfw.a(187, this.codegen.mainClassName);
        this.cfw.b(89);
        this.cfw.c((int) this.variableObjectLocal);
        this.cfw.c((int) this.contextLocal);
        this.cfw.l(index);
        this.cfw.b(183, this.codegen.mainClassName, "<init>", "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;I)V");
        if (i == 4) {
            this.cfw.c((int) this.contextLocal);
            this.cfw.c((int) this.variableObjectLocal);
            this.cfw.c((int) this.thisObjLocal);
            addOptRuntimeInvoke("bindThis", "(Lorg/mozilla/javascript/NativeFunction;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Function;");
        }
        if (i == 2 || i == 4) {
            return;
        }
        this.cfw.l(i);
        this.cfw.c((int) this.variableObjectLocal);
        this.cfw.c((int) this.contextLocal);
        addOptRuntimeInvoke("initFunction", "(Lorg/mozilla/javascript/NativeFunction;ILorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;)V");
    }

    private void visitGetProp(Node node, Node node2) {
        generateExpression(node2, node);
        Node next = node2.getNext();
        generateExpression(next, node);
        if (node.getType() == 34) {
            this.cfw.c((int) this.contextLocal);
            this.cfw.c((int) this.variableObjectLocal);
            addScriptRuntimeInvoke("getObjectPropNoWarn", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
        } else if (node2.getType() == 43 && next.getType() == 41) {
            this.cfw.c((int) this.contextLocal);
            addScriptRuntimeInvoke("getObjectProp", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;");
        } else {
            this.cfw.c((int) this.contextLocal);
            this.cfw.c((int) this.variableObjectLocal);
            addScriptRuntimeInvoke("getObjectProp", "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
        }
    }

    private void visitGetVar(Node node) {
        if (!this.hasVarsInRegs) {
            Kit.codeBug();
        }
        int varIndex = this.fnCurrent.getVarIndex(node);
        short s = this.varRegisters[varIndex];
        if (varIsDirectCallParameter(varIndex)) {
            if (node.getIntProp(8, -1) != -1) {
                dcpLoadAsNumber(s);
                return;
            } else {
                dcpLoadAsObject(s);
                return;
            }
        }
        if (this.fnCurrent.isNumberVar(varIndex)) {
            this.cfw.e(s);
        } else {
            this.cfw.c((int) s);
        }
    }

    private void visitGoto(Jump jump, int i, Node node) {
        Node node2 = jump.target;
        if (i != 6 && i != 7) {
            if (i != 136) {
                addGoto(node2, Token.LAST_TOKEN);
                return;
            } else if (this.isGenerator) {
                addGotoWithReturn(node2);
                return;
            } else {
                inlineFinally(node2);
                return;
            }
        }
        if (node == null) {
            throw Codegen.badTree();
        }
        int targetLabel = getTargetLabel(node2);
        int a2 = this.cfw.a();
        if (i == 6) {
            generateIfJump(node, jump, targetLabel, a2);
        } else {
            generateIfJump(node, jump, a2, targetLabel);
        }
        this.cfw.w(a2);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void visitIfJumpEqOp(external.sdk.pendo.io.mozilla.javascript.Node r18, external.sdk.pendo.io.mozilla.javascript.Node r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.optimizer.BodyCodegen.visitIfJumpEqOp(external.sdk.pendo.io.mozilla.javascript.Node, external.sdk.pendo.io.mozilla.javascript.Node, int, int):void");
    }

    private void visitIfJumpRelOp(Node node, Node node2, int i, int i2) {
        if (i == -1 || i2 == -1) {
            throw Codegen.badTree();
        }
        int type = node.getType();
        Node next = node2.getNext();
        if (type == 53 || type == 52) {
            generateExpression(node2, node);
            generateExpression(next, node);
            this.cfw.c((int) this.contextLocal);
            addScriptRuntimeInvoke(type == 53 ? "instanceOf" : "in", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;)Z");
            this.cfw.a(154, i);
            this.cfw.a(Token.LAST_TOKEN, i2);
            return;
        }
        int intProp = node.getIntProp(8, -1);
        int nodeIsDirectCallParameter = nodeIsDirectCallParameter(node2);
        int nodeIsDirectCallParameter2 = nodeIsDirectCallParameter(next);
        if (intProp != -1) {
            if (intProp != 2) {
                generateExpression(node2, node);
            } else if (nodeIsDirectCallParameter != -1) {
                dcpLoadAsNumber(nodeIsDirectCallParameter);
            } else {
                generateExpression(node2, node);
                addObjectToDouble();
            }
            if (intProp != 1) {
                generateExpression(next, node);
            } else if (nodeIsDirectCallParameter2 != -1) {
                dcpLoadAsNumber(nodeIsDirectCallParameter2);
            } else {
                generateExpression(next, node);
                addObjectToDouble();
            }
            genSimpleCompare(type, i, i2);
            return;
        }
        if (nodeIsDirectCallParameter == -1 || nodeIsDirectCallParameter2 == -1) {
            generateExpression(node2, node);
            generateExpression(next, node);
        } else {
            short h = this.cfw.h();
            int a2 = this.cfw.a();
            this.cfw.c(nodeIsDirectCallParameter);
            this.cfw.a(178, "java/lang/Void", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/Class;");
            this.cfw.a(Token.YIELD_STAR, a2);
            this.cfw.e(nodeIsDirectCallParameter + 1);
            dcpLoadAsNumber(nodeIsDirectCallParameter2);
            genSimpleCompare(type, i, i2);
            if (h != this.cfw.h()) {
                throw Codegen.badTree();
            }
            this.cfw.w(a2);
            int a3 = this.cfw.a();
            this.cfw.c(nodeIsDirectCallParameter2);
            this.cfw.a(178, "java/lang/Void", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/Class;");
            this.cfw.a(Token.YIELD_STAR, a3);
            this.cfw.c(nodeIsDirectCallParameter);
            addObjectToDouble();
            this.cfw.e(nodeIsDirectCallParameter2 + 1);
            genSimpleCompare(type, i, i2);
            if (h != this.cfw.h()) {
                throw Codegen.badTree();
            }
            this.cfw.w(a3);
            this.cfw.c(nodeIsDirectCallParameter);
            this.cfw.c(nodeIsDirectCallParameter2);
        }
        if (type == 17 || type == 16) {
            this.cfw.b(95);
        }
        addScriptRuntimeInvoke((type == 14 || type == 16) ? "cmp_LT" : "cmp_LE", "(Ljava/lang/Object;Ljava/lang/Object;)Z");
        this.cfw.a(154, i);
        this.cfw.a(Token.LAST_TOKEN, i2);
    }

    private void visitIncDec(Node node) {
        String str;
        String str2;
        int existingIntProp = node.getExistingIntProp(13);
        Node firstChild = node.getFirstChild();
        int type = firstChild.getType();
        if (type == 33) {
            Node firstChild2 = firstChild.getFirstChild();
            generateExpression(firstChild2, node);
            generateExpression(firstChild2.getNext(), node);
            this.cfw.c((int) this.contextLocal);
            this.cfw.c((int) this.variableObjectLocal);
            this.cfw.l(existingIntProp);
            str = "propIncrDecr";
            str2 = "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;";
        } else {
            if (type == 34) {
                throw Kit.codeBug();
            }
            if (type == 36) {
                Node firstChild3 = firstChild.getFirstChild();
                generateExpression(firstChild3, node);
                generateExpression(firstChild3.getNext(), node);
                this.cfw.c((int) this.contextLocal);
                this.cfw.c((int) this.variableObjectLocal);
                this.cfw.l(existingIntProp);
                if (firstChild3.getNext().getIntProp(8, -1) != -1) {
                    addOptRuntimeInvoke("elemIncrDecr", "(Ljava/lang/Object;DLorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;");
                    return;
                } else {
                    addScriptRuntimeInvoke("elemIncrDecr", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;");
                    return;
                }
            }
            if (type == 39) {
                this.cfw.c((int) this.variableObjectLocal);
                this.cfw.e(firstChild.getString());
                this.cfw.c((int) this.contextLocal);
                this.cfw.l(existingIntProp);
                str = "nameIncrDecr";
                str2 = "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Lorg/mozilla/javascript/Context;I)Ljava/lang/Object;";
            } else {
                if (type == 55) {
                    if (!this.hasVarsInRegs) {
                        Kit.codeBug();
                    }
                    boolean z = (existingIntProp & 2) != 0;
                    int varIndex = this.fnCurrent.getVarIndex(firstChild);
                    short s = this.varRegisters[varIndex];
                    boolean z2 = this.fnCurrent.fnode.getParamAndVarConst()[varIndex];
                    int intProp = node.getIntProp(8, -1);
                    if (z2) {
                        if (intProp != -1) {
                            this.cfw.e(s + (varIsDirectCallParameter(varIndex) ? 1 : 0));
                            if (z) {
                                return;
                            }
                            this.cfw.b(1.0d);
                            if ((existingIntProp & 1) == 0) {
                                this.cfw.b(99);
                                return;
                            } else {
                                this.cfw.b(103);
                                return;
                            }
                        }
                        if (varIsDirectCallParameter(varIndex)) {
                            dcpLoadAsObject(s);
                        } else {
                            this.cfw.c((int) s);
                        }
                        if (z) {
                            this.cfw.b(89);
                            addObjectToDouble();
                            this.cfw.b(88);
                            return;
                        } else {
                            addObjectToDouble();
                            this.cfw.b(1.0d);
                            if ((existingIntProp & 1) == 0) {
                                this.cfw.b(99);
                            } else {
                                this.cfw.b(103);
                            }
                        }
                    } else {
                        if (intProp != -1) {
                            boolean varIsDirectCallParameter = varIsDirectCallParameter(varIndex);
                            c cVar = this.cfw;
                            int i = s + (varIsDirectCallParameter ? 1 : 0);
                            cVar.e(i);
                            if (z) {
                                this.cfw.b(92);
                            }
                            this.cfw.b(1.0d);
                            if ((existingIntProp & 1) == 0) {
                                this.cfw.b(99);
                            } else {
                                this.cfw.b(103);
                            }
                            if (!z) {
                                this.cfw.b(92);
                            }
                            this.cfw.f(i);
                            return;
                        }
                        if (varIsDirectCallParameter(varIndex)) {
                            dcpLoadAsObject(s);
                        } else {
                            this.cfw.c((int) s);
                        }
                        addObjectToDouble();
                        if (z) {
                            this.cfw.b(92);
                        }
                        this.cfw.b(1.0d);
                        if ((existingIntProp & 1) == 0) {
                            this.cfw.b(99);
                        } else {
                            this.cfw.b(103);
                        }
                        addDoubleWrap();
                        if (!z) {
                            this.cfw.b(89);
                        }
                        this.cfw.d(s);
                        if (!z) {
                            return;
                        }
                    }
                    addDoubleWrap();
                    return;
                }
                if (type != 68) {
                    Codegen.badTree();
                    return;
                }
                generateExpression(firstChild.getFirstChild(), node);
                this.cfw.c((int) this.contextLocal);
                this.cfw.c((int) this.variableObjectLocal);
                this.cfw.l(existingIntProp);
                str = "refIncrDecr";
                str2 = "(Lorg/mozilla/javascript/Ref;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;";
            }
        }
        addScriptRuntimeInvoke(str, str2);
    }

    private void visitObjectLiteral(Node node, Node node2, boolean z) {
        boolean z2;
        c cVar;
        int i;
        Object[] objArr = (Object[]) node.getProp(12);
        int length = objArr.length;
        if (!z && ((length > 10 || this.cfw.g() > 30000) && !this.hasVarsInRegs && !this.isGenerator && !this.inLocalBlock)) {
            if (this.literals == null) {
                this.literals = new LinkedList();
            }
            this.literals.add(node);
            String str = this.codegen.getBodyMethodName(this.scriptOrFn) + "_literal" + this.literals.size();
            this.cfw.c((int) this.funObjLocal);
            this.cfw.c((int) this.contextLocal);
            this.cfw.c((int) this.variableObjectLocal);
            this.cfw.c((int) this.thisObjLocal);
            this.cfw.c((int) this.argsLocal);
            this.cfw.b(182, this.codegen.mainClassName, str, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
            return;
        }
        if (this.isGenerator) {
            addLoadPropertyValues(node, node2, length);
            addLoadPropertyIds(objArr, length);
            this.cfw.b(95);
        } else {
            addLoadPropertyIds(objArr, length);
            addLoadPropertyValues(node, node2, length);
        }
        Node node3 = node2;
        for (int i2 = 0; i2 != length; i2++) {
            int type = node3.getType();
            if (type == 152 || type == 153) {
                z2 = true;
                break;
            }
            node3 = node3.getNext();
        }
        z2 = false;
        if (z2) {
            this.cfw.l(length);
            this.cfw.a(188, 10);
            for (int i3 = 0; i3 != length; i3++) {
                this.cfw.b(89);
                this.cfw.l(i3);
                int type2 = node2.getType();
                if (type2 == 152) {
                    cVar = this.cfw;
                    i = 2;
                } else if (type2 == 153) {
                    cVar = this.cfw;
                    i = 4;
                } else {
                    cVar = this.cfw;
                    i = 3;
                }
                cVar.b(i);
                this.cfw.b(79);
                node2 = node2.getNext();
            }
        } else {
            this.cfw.b(1);
        }
        this.cfw.c((int) this.contextLocal);
        this.cfw.c((int) this.variableObjectLocal);
        addScriptRuntimeInvoke("newObjectLiteral", "([Ljava/lang/Object;[Ljava/lang/Object;[ILorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
    }

    private void visitOptimizedCall(Node node, OptFunctionNode optFunctionNode, int i, Node node2) {
        short newWordLocal;
        Node next = node2.getNext();
        String str = this.codegen.mainClassName;
        if (i == 30) {
            generateExpression(node2, node);
            newWordLocal = 0;
        } else {
            generateFunctionAndThisObj(node2, node);
            newWordLocal = getNewWordLocal();
            this.cfw.d(newWordLocal);
        }
        int a2 = this.cfw.a();
        int a3 = this.cfw.a();
        this.cfw.b(89);
        this.cfw.a(193, str);
        this.cfw.a(153, a3);
        this.cfw.a(192, str);
        this.cfw.b(89);
        this.cfw.a(180, str, "_id", "I");
        this.cfw.l(this.codegen.getIndex(optFunctionNode.fnode));
        this.cfw.a(160, a3);
        this.cfw.c((int) this.contextLocal);
        this.cfw.c((int) this.variableObjectLocal);
        c cVar = this.cfw;
        if (i == 30) {
            cVar.b(1);
        } else {
            cVar.c((int) newWordLocal);
        }
        for (Node node3 = next; node3 != null; node3 = node3.getNext()) {
            int nodeIsDirectCallParameter = nodeIsDirectCallParameter(node3);
            if (nodeIsDirectCallParameter >= 0) {
                this.cfw.c(nodeIsDirectCallParameter);
                this.cfw.e(nodeIsDirectCallParameter + 1);
            } else if (node3.getIntProp(8, -1) == 0) {
                this.cfw.a(178, "java/lang/Void", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/Class;");
                generateExpression(node3, node);
            } else {
                generateExpression(node3, node);
                this.cfw.b(0.0d);
            }
        }
        this.cfw.a(178, "external/sdk/pendo/io/mozilla/javascript/ScriptRuntime", "emptyArgs", "[Ljava/lang/Object;");
        c cVar2 = this.cfw;
        Codegen codegen = this.codegen;
        String str2 = codegen.mainClassName;
        FunctionNode functionNode = optFunctionNode.fnode;
        cVar2.b(184, str2, i == 30 ? codegen.getDirectCtorName(functionNode) : codegen.getBodyMethodName(functionNode), this.codegen.getBodyMethodSignature(optFunctionNode.fnode));
        this.cfw.a(Token.LAST_TOKEN, a2);
        this.cfw.w(a3);
        this.cfw.c((int) this.contextLocal);
        this.cfw.c((int) this.variableObjectLocal);
        if (i != 30) {
            this.cfw.c((int) newWordLocal);
            releaseWordLocal(newWordLocal);
        }
        generateCallArgArray(node, next, true);
        if (i == 30) {
            addScriptRuntimeInvoke("newObject", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
        } else {
            this.cfw.b(185, "external/sdk/pendo/io/mozilla/javascript/Callable", NotificationCompat.CATEGORY_CALL, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;");
        }
        this.cfw.w(a2);
    }

    private void visitSetConst(Node node, Node node2) {
        String string = node.getFirstChild().getString();
        while (node2 != null) {
            generateExpression(node2, node);
            node2 = node2.getNext();
        }
        this.cfw.c((int) this.contextLocal);
        this.cfw.e(string);
        addScriptRuntimeInvoke("setConst", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Ljava/lang/String;)Ljava/lang/Object;");
    }

    private void visitSetConstVar(Node node, Node node2, boolean z) {
        short h;
        c cVar;
        int i;
        if (!this.hasVarsInRegs) {
            Kit.codeBug();
        }
        int varIndex = this.fnCurrent.getVarIndex(node);
        generateExpression(node2.getNext(), node);
        boolean z2 = node.getIntProp(8, -1) != -1;
        short s = this.varRegisters[varIndex];
        int a2 = this.cfw.a();
        int a3 = this.cfw.a();
        if (z2) {
            int i2 = s + 2;
            this.cfw.h(i2);
            this.cfw.a(154, a3);
            h = this.cfw.h();
            this.cfw.l(1);
            this.cfw.i(i2);
            this.cfw.f(s);
            c cVar2 = this.cfw;
            if (z) {
                cVar2.e(s);
                this.cfw.a(a3, h);
            } else {
                cVar2.a(Token.LAST_TOKEN, a2);
                this.cfw.a(a3, h);
                cVar = this.cfw;
                i = 88;
                cVar.b(i);
            }
        } else {
            int i3 = s + 1;
            this.cfw.h(i3);
            this.cfw.a(154, a3);
            h = this.cfw.h();
            this.cfw.l(1);
            this.cfw.i(i3);
            this.cfw.d(s);
            c cVar3 = this.cfw;
            if (z) {
                cVar3.c((int) s);
                this.cfw.a(a3, h);
            } else {
                cVar3.a(Token.LAST_TOKEN, a2);
                this.cfw.a(a3, h);
                cVar = this.cfw;
                i = 87;
                cVar.b(i);
            }
        }
        this.cfw.w(a2);
    }

    private void visitSetElem(int i, Node node, Node node2) {
        String str;
        String str2;
        String str3;
        String str4;
        generateExpression(node2, node);
        Node next = node2.getNext();
        if (i == 141) {
            this.cfw.b(89);
        }
        generateExpression(next, node);
        Node next2 = next.getNext();
        boolean z = node.getIntProp(8, -1) != -1;
        if (i == 141) {
            c cVar = this.cfw;
            if (z) {
                cVar.b(93);
                this.cfw.c((int) this.contextLocal);
                this.cfw.c((int) this.variableObjectLocal);
                str3 = "getObjectIndex";
                str4 = "(Ljava/lang/Object;DLorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            } else {
                cVar.b(90);
                this.cfw.c((int) this.contextLocal);
                this.cfw.c((int) this.variableObjectLocal);
                str3 = "getObjectElem";
                str4 = "(Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            }
            addScriptRuntimeInvoke(str3, str4);
        }
        generateExpression(next2, node);
        this.cfw.c((int) this.contextLocal);
        this.cfw.c((int) this.variableObjectLocal);
        if (z) {
            str = "setObjectIndex";
            str2 = "(Ljava/lang/Object;DLjava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
        } else {
            str = "setObjectElem";
            str2 = "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
        }
        addScriptRuntimeInvoke(str, str2);
    }

    private void visitSetName(Node node, Node node2) {
        String string = node.getFirstChild().getString();
        while (node2 != null) {
            generateExpression(node2, node);
            node2 = node2.getNext();
        }
        this.cfw.c((int) this.contextLocal);
        this.cfw.c((int) this.variableObjectLocal);
        this.cfw.e(string);
        addScriptRuntimeInvoke("setName", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Ljava/lang/Object;");
    }

    private void visitSetProp(int i, Node node, Node node2) {
        String str;
        generateExpression(node2, node);
        Node next = node2.getNext();
        if (i == 140) {
            this.cfw.b(89);
        }
        generateExpression(next, node);
        Node next2 = next.getNext();
        if (i == 140) {
            this.cfw.b(90);
            if (node2.getType() == 43 && next.getType() == 41) {
                this.cfw.c((int) this.contextLocal);
                str = "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;Lorg/mozilla/javascript/Context;)Ljava/lang/Object;";
            } else {
                this.cfw.c((int) this.contextLocal);
                this.cfw.c((int) this.variableObjectLocal);
                str = "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            }
            addScriptRuntimeInvoke("getObjectProp", str);
        }
        generateExpression(next2, node);
        this.cfw.c((int) this.contextLocal);
        this.cfw.c((int) this.variableObjectLocal);
        addScriptRuntimeInvoke("setObjectProp", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;");
    }

    private void visitSetVar(Node node, Node node2, boolean z) {
        c cVar;
        int i;
        if (!this.hasVarsInRegs) {
            Kit.codeBug();
        }
        int varIndex = this.fnCurrent.getVarIndex(node);
        generateExpression(node2.getNext(), node);
        boolean z2 = node.getIntProp(8, -1) != -1;
        short s = this.varRegisters[varIndex];
        if (this.fnCurrent.fnode.getParamAndVarConst()[varIndex]) {
            if (z) {
                return;
            }
            if (z2) {
                cVar = this.cfw;
                i = 88;
            } else {
                cVar = this.cfw;
                i = 87;
            }
            cVar.b(i);
            return;
        }
        if (!varIsDirectCallParameter(varIndex)) {
            boolean isNumberVar = this.fnCurrent.isNumberVar(varIndex);
            if (!z2) {
                if (isNumberVar) {
                    Kit.codeBug();
                }
                this.cfw.d(s);
                if (z) {
                    this.cfw.c((int) s);
                    return;
                }
                return;
            }
            if (isNumberVar) {
                this.cfw.f(s);
                if (z) {
                    this.cfw.e(s);
                    return;
                }
                return;
            }
            if (z) {
                this.cfw.b(92);
            }
            addDoubleWrap();
        } else {
            if (z2) {
                if (z) {
                    this.cfw.b(92);
                }
                this.cfw.c((int) s);
                this.cfw.a(178, "java/lang/Void", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/Class;");
                int a2 = this.cfw.a();
                int a3 = this.cfw.a();
                this.cfw.a(Token.ARROW, a2);
                short h = this.cfw.h();
                addDoubleWrap();
                this.cfw.d(s);
                this.cfw.a(Token.LAST_TOKEN, a3);
                this.cfw.a(a2, h);
                this.cfw.f(s + 1);
                this.cfw.w(a3);
                return;
            }
            if (z) {
                this.cfw.b(89);
            }
        }
        this.cfw.d(s);
    }

    private void visitSpecialCall(Node node, int i, int i2, Node node2) {
        String str;
        String str2;
        this.cfw.c((int) this.contextLocal);
        if (i == 30) {
            generateExpression(node2, node);
        } else {
            generateFunctionAndThisObj(node2, node);
        }
        generateCallArgArray(node, node2.getNext(), false);
        c cVar = this.cfw;
        if (i == 30) {
            cVar.c((int) this.variableObjectLocal);
            this.cfw.c((int) this.thisObjLocal);
            this.cfw.l(i2);
            str = "newObjectSpecial";
            str2 = "(Lorg/mozilla/javascript/Context;Ljava/lang/Object;[Ljava/lang/Object;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;I)Ljava/lang/Object;";
        } else {
            cVar.c((int) this.variableObjectLocal);
            this.cfw.c((int) this.thisObjLocal);
            this.cfw.l(i2);
            String sourceName = this.scriptOrFn.getSourceName();
            c cVar2 = this.cfw;
            if (sourceName == null) {
                sourceName = "";
            }
            cVar2.e(sourceName);
            this.cfw.l(this.itsLineNumber);
            str = "callSpecial";
            str2 = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;ILjava/lang/String;I)Ljava/lang/Object;";
        }
        addOptRuntimeInvoke(str, str2);
    }

    private void visitStandardCall(Node node, Node node2) {
        String str;
        String str2;
        if (node.getType() != 38) {
            throw Codegen.badTree();
        }
        Node next = node2.getNext();
        int type = node2.getType();
        if (next == null) {
            if (type == 39) {
                this.cfw.e(node2.getString());
                str = "callName0";
                str2 = "(Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            } else if (type == 33) {
                Node firstChild = node2.getFirstChild();
                generateExpression(firstChild, node);
                this.cfw.e(firstChild.getNext().getString());
                str = "callProp0";
                str2 = "(Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            } else {
                if (type == 34) {
                    throw Kit.codeBug();
                }
                generateFunctionAndThisObj(node2, node);
                str = "call0";
                str2 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            }
        } else if (type == 39) {
            String string = node2.getString();
            generateCallArgArray(node, next, false);
            this.cfw.e(string);
            str = "callName";
            str2 = "([Ljava/lang/Object;Ljava/lang/String;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
        } else {
            int i = 0;
            for (Node node3 = next; node3 != null; node3 = node3.getNext()) {
                i++;
            }
            generateFunctionAndThisObj(node2, node);
            if (i == 1) {
                generateExpression(next, node);
                str = "call1";
                str2 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            } else if (i == 2) {
                generateExpression(next, node);
                generateExpression(next.getNext(), node);
                str = "call2";
                str2 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            } else {
                generateCallArgArray(node, next, false);
                str = "callN";
                str2 = "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;";
            }
        }
        this.cfw.c((int) this.contextLocal);
        this.cfw.c((int) this.variableObjectLocal);
        addOptRuntimeInvoke(str, str2);
    }

    private void visitStandardNew(Node node, Node node2) {
        if (node.getType() != 30) {
            throw Codegen.badTree();
        }
        Node next = node2.getNext();
        generateExpression(node2, node);
        this.cfw.c((int) this.contextLocal);
        this.cfw.c((int) this.variableObjectLocal);
        generateCallArgArray(node, next, false);
        addScriptRuntimeInvoke("newObject", "(Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
    }

    private void visitStrictSetName(Node node, Node node2) {
        String string = node.getFirstChild().getString();
        while (node2 != null) {
            generateExpression(node2, node);
            node2 = node2.getNext();
        }
        this.cfw.c((int) this.contextLocal);
        this.cfw.c((int) this.variableObjectLocal);
        this.cfw.e(string);
        addScriptRuntimeInvoke("strictSetName", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Ljava/lang/Object;");
    }

    private void visitSwitch(Jump jump, Node node) {
        generateExpression(node, jump);
        short newWordLocal = getNewWordLocal();
        this.cfw.d(newWordLocal);
        Node node2 = node;
        while (true) {
            Jump jump2 = (Jump) node2.getNext();
            if (jump2 == null) {
                releaseWordLocal(newWordLocal);
                return;
            } else {
                if (jump2.getType() != 116) {
                    throw Codegen.badTree();
                }
                generateExpression(jump2.getFirstChild(), jump2);
                this.cfw.c((int) newWordLocal);
                addScriptRuntimeInvoke("shallowEq", "(Ljava/lang/Object;Ljava/lang/Object;)Z");
                addGoto(jump2.target, 154);
                node2 = jump2;
            }
        }
    }

    private void visitTryCatchFinally(Jump jump, Node node) {
        int i;
        int i2;
        short newWordLocal = getNewWordLocal();
        this.cfw.c((int) this.variableObjectLocal);
        this.cfw.d(newWordLocal);
        int a2 = this.cfw.a();
        this.cfw.a(a2, (short) 0);
        Node node2 = jump.target;
        Node node3 = jump.getFinally();
        int[] iArr = new int[5];
        this.exceptionManager.pushExceptionInfo(jump);
        if (node2 != null) {
            iArr[0] = this.cfw.a();
            iArr[1] = this.cfw.a();
            iArr[2] = this.cfw.a();
            Context currentContext = Context.getCurrentContext();
            if (currentContext != null && currentContext.hasFeature(13)) {
                iArr[3] = this.cfw.a();
            }
        }
        if (node3 != null) {
            iArr[4] = this.cfw.a();
        }
        this.exceptionManager.setHandlers(iArr, a2);
        if (this.isGenerator && node3 != null) {
            FinallyReturnPoint finallyReturnPoint = new FinallyReturnPoint();
            if (this.finallys == null) {
                this.finallys = new HashMap();
            }
            this.finallys.put(node3, finallyReturnPoint);
            this.finallys.put(node3.getNext(), finallyReturnPoint);
        }
        for (Node node4 = node; node4 != null; node4 = node4.getNext()) {
            if (node4 == node2) {
                int targetLabel = getTargetLabel(node2);
                this.exceptionManager.removeHandler(0, targetLabel);
                this.exceptionManager.removeHandler(1, targetLabel);
                this.exceptionManager.removeHandler(2, targetLabel);
                this.exceptionManager.removeHandler(3, targetLabel);
            }
            generateStatement(node4);
        }
        int a3 = this.cfw.a();
        this.cfw.a(Token.LAST_TOKEN, a3);
        int localBlockRegister = getLocalBlockRegister(jump);
        if (node2 != null) {
            int labelId = node2.labelId();
            i = localBlockRegister;
            i2 = a3;
            generateCatchBlock(0, newWordLocal, labelId, localBlockRegister, iArr[0]);
            generateCatchBlock(1, newWordLocal, labelId, localBlockRegister, iArr[1]);
            generateCatchBlock(2, newWordLocal, labelId, localBlockRegister, iArr[2]);
            Context currentContext2 = Context.getCurrentContext();
            if (currentContext2 != null && currentContext2.hasFeature(13)) {
                generateCatchBlock(3, newWordLocal, labelId, i, iArr[3]);
            }
        } else {
            i = localBlockRegister;
            i2 = a3;
        }
        if (node3 != null) {
            int a4 = this.cfw.a();
            int a5 = this.cfw.a();
            this.cfw.v(a4);
            if (!this.isGenerator) {
                this.cfw.w(iArr[4]);
            }
            int i3 = i;
            this.cfw.d(i3);
            this.cfw.c((int) newWordLocal);
            this.cfw.d(this.variableObjectLocal);
            int labelId2 = node3.labelId();
            if (this.isGenerator) {
                addGotoWithReturn(node3);
            } else {
                inlineFinally(node3, iArr[4], a5);
            }
            this.cfw.c(i3);
            if (this.isGenerator) {
                this.cfw.a(192, "java/lang/Throwable");
            }
            this.cfw.b(191);
            this.cfw.w(a5);
            if (this.isGenerator) {
                this.cfw.a(a2, labelId2, a4, (String) null);
            }
        }
        releaseWordLocal(newWordLocal);
        this.cfw.w(i2);
        if (this.isGenerator) {
            return;
        }
        this.exceptionManager.popExceptionInfo();
    }

    private void visitTypeofname(Node node) {
        int indexForNameNode;
        if (!this.hasVarsInRegs || (indexForNameNode = this.fnCurrent.fnode.getIndexForNameNode(node)) < 0) {
            this.cfw.c((int) this.variableObjectLocal);
            this.cfw.e(node.getString());
            addScriptRuntimeInvoke("typeofName", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Ljava/lang/String;");
            return;
        }
        if (this.fnCurrent.isNumberVar(indexForNameNode)) {
            this.cfw.e(ConditionData.NUMBER_VALUE);
            return;
        }
        if (!varIsDirectCallParameter(indexForNameNode)) {
            this.cfw.c((int) this.varRegisters[indexForNameNode]);
            addScriptRuntimeInvoke("typeof", "(Ljava/lang/Object;)Ljava/lang/String;");
            return;
        }
        short s = this.varRegisters[indexForNameNode];
        this.cfw.c((int) s);
        this.cfw.a(178, "java/lang/Void", CredentialProviderBaseController.TYPE_TAG, "Ljava/lang/Class;");
        int a2 = this.cfw.a();
        this.cfw.a(Token.ARROW, a2);
        short h = this.cfw.h();
        this.cfw.c((int) s);
        addScriptRuntimeInvoke("typeof", "(Ljava/lang/Object;)Ljava/lang/String;");
        int a3 = this.cfw.a();
        this.cfw.a(Token.LAST_TOKEN, a3);
        this.cfw.a(a2, h);
        this.cfw.e(ConditionData.NUMBER_VALUE);
        this.cfw.w(a3);
    }

    void generateBodyCode() {
        this.isGenerator = Codegen.isGenerator(this.scriptOrFn);
        initBodyGeneration();
        if (this.isGenerator) {
            this.cfw.b(this.codegen.getBodyMethodName(this.scriptOrFn) + "_gen", "(" + this.codegen.mainClassSignature + "Lexternal/sdk/pendo/io/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;", (short) 10);
        } else {
            this.cfw.b(this.codegen.getBodyMethodName(this.scriptOrFn), this.codegen.getBodyMethodSignature(this.scriptOrFn), (short) 10);
        }
        generatePrologue();
        generateStatement(this.fnCurrent != null ? this.scriptOrFn.getLastChild() : this.scriptOrFn);
        generateEpilogue();
        this.cfw.c((short) (this.localsMax + 1));
        if (this.isGenerator) {
            generateGenerator();
        }
        if (this.literals != null) {
            for (int i = 0; i < this.literals.size(); i++) {
                Node node = this.literals.get(i);
                int type = node.getType();
                if (type == 66) {
                    generateArrayLiteralFactory(node, i + 1);
                } else if (type != 67) {
                    Kit.codeBug(Token.typeToName(type));
                } else {
                    generateObjectLiteralFactory(node, i + 1);
                }
            }
        }
    }

    private void addInstructionCount(int i) {
        this.cfw.c((int) this.contextLocal);
        this.cfw.l(i);
        addScriptRuntimeInvoke("addInstructionCount", "(Lorg/mozilla/javascript/Context;I)V");
    }

    private short getNewWordLocal(boolean z) {
        return getNewWordIntern(z ? 2 : 1);
    }

    private void inlineFinally(Node node, int i, int i2) {
        Node finallyAtTarget = getFinallyAtTarget(node);
        finallyAtTarget.resetTargets();
        this.exceptionManager.markInlineFinallyStart(finallyAtTarget, i);
        for (Node firstChild = finallyAtTarget.getFirstChild(); firstChild != null; firstChild = firstChild.getNext()) {
            generateStatement(firstChild);
        }
        this.exceptionManager.markInlineFinallyEnd(finallyAtTarget, i2);
    }
}
