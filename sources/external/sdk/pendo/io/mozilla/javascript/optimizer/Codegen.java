package external.sdk.pendo.io.mozilla.javascript.optimizer;

import androidx.core.app.NotificationCompat;
import external.sdk.pendo.io.mozilla.javascript.CompilerEnvirons;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Evaluator;
import external.sdk.pendo.io.mozilla.javascript.Function;
import external.sdk.pendo.io.mozilla.javascript.GeneratedClassLoader;
import external.sdk.pendo.io.mozilla.javascript.NativeFunction;
import external.sdk.pendo.io.mozilla.javascript.ObjArray;
import external.sdk.pendo.io.mozilla.javascript.ObjToIntMap;
import external.sdk.pendo.io.mozilla.javascript.RhinoException;
import external.sdk.pendo.io.mozilla.javascript.Script;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.SecurityController;
import external.sdk.pendo.io.mozilla.javascript.Token;
import external.sdk.pendo.io.mozilla.javascript.ast.FunctionNode;
import external.sdk.pendo.io.mozilla.javascript.ast.Name;
import external.sdk.pendo.io.mozilla.javascript.ast.ScriptNode;
import io.sentry.protocol.SentryThread;
import java.util.HashMap;
import java.util.List;
import sdk.pendo.io.utilities.script.JavascriptRunner;
import sdk.pendo.io.v2.c;

/* loaded from: classes2.dex */
public class Codegen implements Evaluator {
    static final String DEFAULT_MAIN_METHOD_CLASS = "external.sdk.pendo.io.mozilla.javascript.optimizer.OptRuntime";
    static final String FUNCTION_CONSTRUCTOR_SIGNATURE = "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;I)V";
    static final String FUNCTION_INIT_SIGNATURE = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)V";
    static final String ID_FIELD_NAME = "_id";
    static final String REGEXP_INIT_METHOD_NAME = "_reInit";
    static final String REGEXP_INIT_METHOD_SIGNATURE = "(Lorg/mozilla/javascript/Context;)V";
    private static final String SUPER_CLASS_NAME = "external.sdk.pendo.io.mozilla.javascript.NativeFunction";
    private static final Object globalLock = new Object();
    private static int globalSerialClassCounter;
    private CompilerEnvirons compilerEnv;
    private ObjArray directCallTargets;
    private double[] itsConstantList;
    private int itsConstantListSize;
    String mainClassName;
    String mainClassSignature;
    private String mainMethodClass = DEFAULT_MAIN_METHOD_CLASS;
    private ObjToIntMap scriptOrFnIndexes;
    ScriptNode[] scriptOrFnNodes;

    private static void addDoubleWrap(c cVar) {
        cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/optimizer/OptRuntime", "wrapDouble", "(D)Ljava/lang/Double;");
    }

    static RuntimeException badTree() {
        throw new RuntimeException("Bad tree in codegen");
    }

    private static void collectScriptNodes_r(ScriptNode scriptNode, ObjArray objArray) {
        objArray.add(scriptNode);
        int functionCount = scriptNode.getFunctionCount();
        for (int i = 0; i != functionCount; i++) {
            collectScriptNodes_r(scriptNode.getFunctionNode(i), objArray);
        }
    }

    private Class<?> defineClass(Object obj, Object obj2) {
        Object[] objArr = (Object[]) obj;
        String str = (String) objArr[0];
        byte[] bArr = (byte[]) objArr[1];
        GeneratedClassLoader createLoader = SecurityController.createLoader(getClass().getClassLoader(), obj2);
        try {
            Class<?> defineClass = createLoader.defineClass(str, bArr);
            createLoader.linkClass(defineClass);
            return defineClass;
        } catch (IllegalArgumentException | SecurityException e) {
            throw new RuntimeException("Malformed optimizer package " + e);
        }
    }

    private void emitConstantDudeInitializers(c cVar) {
        int i = this.itsConstantListSize;
        if (i == 0) {
            return;
        }
        cVar.b("<clinit>", "()V", (short) 24);
        double[] dArr = this.itsConstantList;
        for (int i2 = 0; i2 != i; i2++) {
            double d = dArr[i2];
            String str = "_k" + i2;
            String staticConstantWrapperType = getStaticConstantWrapperType(d);
            cVar.a(str, staticConstantWrapperType, (short) 10);
            int i3 = (int) d;
            if (i3 == d) {
                cVar.l(i3);
                cVar.b(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            } else {
                cVar.b(d);
                addDoubleWrap(cVar);
            }
            cVar.a(179, this.mainClassName, str, staticConstantWrapperType);
        }
        cVar.b(177);
        cVar.c((short) 0);
    }

    private void emitDirectConstructor(c cVar, OptFunctionNode optFunctionNode) {
        cVar.b(getDirectCtorName(optFunctionNode.fnode), getBodyMethodSignature(optFunctionNode.fnode), (short) 10);
        int paramCount = optFunctionNode.fnode.getParamCount();
        int i = (paramCount * 3) + 4;
        int i2 = i + 1;
        cVar.c(0);
        cVar.c(1);
        cVar.c(2);
        cVar.b(182, "external/sdk/pendo/io/mozilla/javascript/BaseFunction", "createObject", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
        cVar.d(i2);
        cVar.c(0);
        cVar.c(1);
        cVar.c(2);
        cVar.c(i2);
        for (int i3 = 0; i3 < paramCount; i3++) {
            int i4 = i3 * 3;
            cVar.c(i4 + 4);
            cVar.e(i4 + 5);
        }
        cVar.c(i);
        cVar.b(184, this.mainClassName, getBodyMethodName(optFunctionNode.fnode), getBodyMethodSignature(optFunctionNode.fnode));
        int a2 = cVar.a();
        cVar.b(89);
        cVar.a(193, "external/sdk/pendo/io/mozilla/javascript/Scriptable");
        cVar.a(153, a2);
        cVar.a(192, "external/sdk/pendo/io/mozilla/javascript/Scriptable");
        cVar.b(176);
        cVar.w(a2);
        cVar.c(i2);
        cVar.b(176);
        cVar.c((short) (i2 + 1));
    }

    private void emitRegExpInit(c cVar) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            ScriptNode[] scriptNodeArr = this.scriptOrFnNodes;
            if (i2 == scriptNodeArr.length) {
                break;
            }
            i3 += scriptNodeArr[i2].getRegexpCount();
            i2++;
        }
        if (i3 == 0) {
            return;
        }
        short s = 10;
        cVar.b(REGEXP_INIT_METHOD_NAME, REGEXP_INIT_METHOD_SIGNATURE, (short) 10);
        cVar.a("_reInitDone", "Z", (short) 74);
        cVar.a(178, this.mainClassName, "_reInitDone", "Z");
        int a2 = cVar.a();
        cVar.a(153, a2);
        cVar.b(177);
        cVar.w(a2);
        cVar.c(0);
        cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/ScriptRuntime", "checkRegExpProxy", "(Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/RegExpProxy;");
        cVar.d(1);
        int i4 = 0;
        while (true) {
            ScriptNode[] scriptNodeArr2 = this.scriptOrFnNodes;
            if (i4 == scriptNodeArr2.length) {
                cVar.l(1);
                cVar.a(179, this.mainClassName, "_reInitDone", "Z");
                cVar.b(177);
                cVar.c((short) 2);
                return;
            }
            ScriptNode scriptNode = scriptNodeArr2[i4];
            int regexpCount = scriptNode.getRegexpCount();
            int i5 = i;
            while (i5 != regexpCount) {
                String compiledRegexpName = getCompiledRegexpName(scriptNode, i5);
                String regexpString = scriptNode.getRegexpString(i5);
                String regexpFlags = scriptNode.getRegexpFlags(i5);
                cVar.a(compiledRegexpName, "Ljava/lang/Object;", s);
                cVar.c(1);
                cVar.c(i);
                cVar.e(regexpString);
                if (regexpFlags == null) {
                    cVar.b(1);
                } else {
                    cVar.e(regexpFlags);
                }
                cVar.b(185, "external/sdk/pendo/io/mozilla/javascript/RegExpProxy", "compileRegExp", "(Lorg/mozilla/javascript/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;");
                cVar.a(179, this.mainClassName, compiledRegexpName, "Ljava/lang/Object;");
                i5++;
                i = 0;
                s = 10;
            }
            i4++;
            i = 0;
            s = 10;
        }
    }

    private void generateCallMethod(c cVar, boolean z) {
        int i;
        int paramCount;
        cVar.b(NotificationCompat.CATEGORY_CALL, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;", (short) 17);
        int a2 = cVar.a();
        cVar.c(1);
        cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/ScriptRuntime", "hasTopCall", "(Lorg/mozilla/javascript/Context;)Z");
        cVar.a(154, a2);
        int i2 = 0;
        cVar.c(0);
        cVar.c(1);
        cVar.c(2);
        cVar.c(3);
        cVar.c(4);
        cVar.a(z);
        cVar.b(184, "external/sdk/pendo/io/mozilla/javascript/ScriptRuntime", "doTopCall", "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Z)Ljava/lang/Object;");
        cVar.b(176);
        cVar.w(a2);
        cVar.c(0);
        cVar.c(1);
        cVar.c(2);
        cVar.c(3);
        cVar.c(4);
        int length = this.scriptOrFnNodes.length;
        boolean z2 = 2 <= length;
        if (z2) {
            cVar.b();
            cVar.a(180, cVar.f(), ID_FIELD_NAME, "I");
            i = cVar.c(1, length - 1);
        } else {
            i = 0;
        }
        int i3 = 0;
        short s = 0;
        while (i3 != length) {
            ScriptNode scriptNode = this.scriptOrFnNodes[i3];
            if (z2) {
                if (i3 == 0) {
                    cVar.x(i);
                    s = cVar.h();
                } else {
                    cVar.a(i, i3 - 1, s);
                }
            }
            if (scriptNode.getType() == 110) {
                OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode);
                if (optFunctionNode.isTargetOfDirectCall() && (paramCount = optFunctionNode.fnode.getParamCount()) != 0) {
                    for (int i4 = i2; i4 != paramCount; i4++) {
                        cVar.b(190);
                        cVar.l(i4);
                        int a3 = cVar.a();
                        int a4 = cVar.a();
                        cVar.a(Token.METHOD, a3);
                        cVar.c(4);
                        cVar.l(i4);
                        cVar.b(50);
                        cVar.a(Token.LAST_TOKEN, a4);
                        cVar.w(a3);
                        pushUndefined(cVar);
                        cVar.w(a4);
                        cVar.q(-1);
                        cVar.b(0.0d);
                        cVar.c(4);
                    }
                }
            }
            cVar.b(184, this.mainClassName, getBodyMethodName(scriptNode), getBodyMethodSignature(scriptNode));
            cVar.b(176);
            i3++;
            i2 = 0;
        }
        cVar.c((short) 5);
    }

    private byte[] generateCode(String str) {
        boolean z = true;
        boolean z2 = this.scriptOrFnNodes[0].getType() == 137;
        ScriptNode[] scriptNodeArr = this.scriptOrFnNodes;
        if (scriptNodeArr.length <= 1 && z2) {
            z = false;
        }
        boolean isInStrictMode = scriptNodeArr[0].isInStrictMode();
        c cVar = new c(this.mainClassName, SUPER_CLASS_NAME, this.compilerEnv.isGenerateDebugInfo() ? this.scriptOrFnNodes[0].getSourceName() : null);
        cVar.a(ID_FIELD_NAME, "I", (short) 2);
        if (z) {
            generateFunctionConstructor(cVar);
        }
        if (z2) {
            cVar.c("external/sdk/pendo/io/mozilla/javascript/Script");
            generateScriptCtor(cVar);
            generateMain(cVar);
            generateExecute(cVar);
        }
        generateCallMethod(cVar, isInStrictMode);
        generateResumeGenerator(cVar);
        generateNativeFunctionOverrides(cVar, str);
        int length = this.scriptOrFnNodes.length;
        for (int i = 0; i != length; i++) {
            ScriptNode scriptNode = this.scriptOrFnNodes[i];
            BodyCodegen bodyCodegen = new BodyCodegen();
            bodyCodegen.cfw = cVar;
            bodyCodegen.codegen = this;
            bodyCodegen.compilerEnv = this.compilerEnv;
            bodyCodegen.scriptOrFn = scriptNode;
            bodyCodegen.scriptOrFnIndex = i;
            bodyCodegen.generateBodyCode();
            if (scriptNode.getType() == 110) {
                OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode);
                generateFunctionInit(cVar, optFunctionNode);
                if (optFunctionNode.isTargetOfDirectCall()) {
                    emitDirectConstructor(cVar, optFunctionNode);
                }
            }
        }
        emitRegExpInit(cVar);
        emitConstantDudeInitializers(cVar);
        return cVar.j();
    }

    private static void generateExecute(c cVar) {
        cVar.b("exec", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;", (short) 17);
        cVar.b();
        cVar.c(1);
        cVar.c(2);
        cVar.b(89);
        cVar.b(1);
        cVar.b(182, cVar.f(), NotificationCompat.CATEGORY_CALL, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;");
        cVar.b(176);
        cVar.c((short) 3);
    }

    private void generateFunctionConstructor(c cVar) {
        int i;
        cVar.b("<init>", FUNCTION_CONSTRUCTOR_SIGNATURE, (short) 1);
        short s = 0;
        cVar.c(0);
        cVar.b(183, SUPER_CLASS_NAME, "<init>", "()V");
        cVar.b();
        cVar.h(3);
        cVar.a(181, cVar.f(), ID_FIELD_NAME, "I");
        cVar.b();
        cVar.c(2);
        cVar.c(1);
        int i2 = this.scriptOrFnNodes[0].getType() == 137 ? 1 : 0;
        int length = this.scriptOrFnNodes.length;
        if (i2 == length) {
            throw badTree();
        }
        boolean z = 2 <= length - i2;
        if (z) {
            cVar.h(3);
            i = cVar.c(i2 + 1, length - 1);
        } else {
            i = 0;
        }
        for (int i3 = i2; i3 != length; i3++) {
            if (z) {
                if (i3 == i2) {
                    cVar.x(i);
                    s = cVar.h();
                } else {
                    cVar.a(i, (i3 - 1) - i2, s);
                }
            }
            cVar.b(183, this.mainClassName, getFunctionInitMethodName(OptFunctionNode.get(this.scriptOrFnNodes[i3])), FUNCTION_INIT_SIGNATURE);
            cVar.b(177);
        }
        cVar.c((short) 4);
    }

    private void generateFunctionInit(c cVar, OptFunctionNode optFunctionNode) {
        cVar.b(getFunctionInitMethodName(optFunctionNode), FUNCTION_INIT_SIGNATURE, (short) 18);
        cVar.b();
        cVar.c(1);
        cVar.c(2);
        cVar.b(182, "external/sdk/pendo/io/mozilla/javascript/NativeFunction", "initScriptFunction", FUNCTION_INIT_SIGNATURE);
        if (optFunctionNode.fnode.getRegexpCount() != 0) {
            cVar.c(1);
            cVar.b(184, this.mainClassName, REGEXP_INIT_METHOD_NAME, REGEXP_INIT_METHOD_SIGNATURE);
        }
        cVar.b(177);
        cVar.c((short) 3);
    }

    private void generateMain(c cVar) {
        cVar.b(SentryThread.JsonKeys.MAIN, "([Ljava/lang/String;)V", (short) 9);
        cVar.a(187, cVar.f());
        cVar.b(89);
        cVar.b(183, cVar.f(), "<init>", "()V");
        cVar.b(42);
        cVar.b(184, this.mainMethodClass, SentryThread.JsonKeys.MAIN, "(Lorg/mozilla/javascript/Script;[Ljava/lang/String;)V");
        cVar.b(177);
        cVar.c((short) 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void generateNativeFunctionOverrides(sdk.pendo.io.v2.c r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.optimizer.Codegen.generateNativeFunctionOverrides(sdk.pendo.io.v2.c, java.lang.String):void");
    }

    private void generateResumeGenerator(c cVar) {
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (true) {
            ScriptNode[] scriptNodeArr = this.scriptOrFnNodes;
            if (i2 >= scriptNodeArr.length) {
                break;
            }
            if (isGenerator(scriptNodeArr[i2])) {
                z = true;
            }
            i2++;
        }
        if (!z) {
            return;
        }
        cVar.b("resumeGenerator", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", (short) 17);
        cVar.c(0);
        cVar.c(1);
        cVar.c(2);
        cVar.c(4);
        cVar.c(5);
        cVar.h(3);
        cVar.b();
        cVar.a(180, cVar.f(), ID_FIELD_NAME, "I");
        int c = cVar.c(0, this.scriptOrFnNodes.length - 1);
        cVar.x(c);
        int a2 = cVar.a();
        while (true) {
            ScriptNode[] scriptNodeArr2 = this.scriptOrFnNodes;
            if (i >= scriptNodeArr2.length) {
                cVar.w(a2);
                pushUndefined(cVar);
                cVar.b(176);
                cVar.c((short) 6);
                return;
            }
            ScriptNode scriptNode = scriptNodeArr2[i];
            cVar.a(c, i, 6);
            if (isGenerator(scriptNode)) {
                cVar.b(184, this.mainClassName, getBodyMethodName(scriptNode) + "_gen", "(" + this.mainClassSignature + "Lexternal/sdk/pendo/io/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;");
                cVar.b(176);
            } else {
                cVar.a(Token.LAST_TOKEN, a2);
            }
            i++;
        }
    }

    private static void generateScriptCtor(c cVar) {
        cVar.b("<init>", "()V", (short) 1);
        cVar.b();
        cVar.b(183, SUPER_CLASS_NAME, "<init>", "()V");
        cVar.b();
        cVar.l(0);
        cVar.a(181, cVar.f(), ID_FIELD_NAME, "I");
        cVar.b(177);
        cVar.c((short) 1);
    }

    private static String getStaticConstantWrapperType(double d) {
        return ((double) ((int) d)) == d ? "Ljava/lang/Integer;" : "Ljava/lang/Double;";
    }

    private static void initOptFunctions_r(ScriptNode scriptNode) {
        int functionCount = scriptNode.getFunctionCount();
        for (int i = 0; i != functionCount; i++) {
            FunctionNode functionNode = scriptNode.getFunctionNode(i);
            new OptFunctionNode(functionNode);
            initOptFunctions_r(functionNode);
        }
    }

    private void initScriptNodesData(ScriptNode scriptNode) {
        ObjArray objArray = new ObjArray();
        collectScriptNodes_r(scriptNode, objArray);
        int size = objArray.size();
        ScriptNode[] scriptNodeArr = new ScriptNode[size];
        this.scriptOrFnNodes = scriptNodeArr;
        objArray.toArray(scriptNodeArr);
        this.scriptOrFnIndexes = new ObjToIntMap(size);
        for (int i = 0; i != size; i++) {
            this.scriptOrFnIndexes.put(this.scriptOrFnNodes[i], i);
        }
    }

    static boolean isGenerator(ScriptNode scriptNode) {
        return scriptNode.getType() == 110 && ((FunctionNode) scriptNode).isGenerator();
    }

    static void pushUndefined(c cVar) {
        cVar.a(178, "external/sdk/pendo/io/mozilla/javascript/Undefined", "instance", "Ljava/lang/Object;");
    }

    private void transform(ScriptNode scriptNode) {
        initOptFunctions_r(scriptNode);
        int optimizationLevel = this.compilerEnv.getOptimizationLevel();
        HashMap hashMap = null;
        if (optimizationLevel > 0 && scriptNode.getType() == 137) {
            int functionCount = scriptNode.getFunctionCount();
            for (int i = 0; i != functionCount; i++) {
                OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode, i);
                if (optFunctionNode.fnode.getFunctionType() == 1) {
                    String name = optFunctionNode.fnode.getName();
                    if (name.length() != 0) {
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        hashMap.put(name, optFunctionNode);
                    }
                }
            }
        }
        if (hashMap != null) {
            this.directCallTargets = new ObjArray();
        }
        new OptTransformer(hashMap, this.directCallTargets).transform(scriptNode, this.compilerEnv);
        if (optimizationLevel > 0) {
            new Optimizer().optimize(scriptNode);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Evaluator
    public void captureStackInfo(RhinoException rhinoException) {
        throw new UnsupportedOperationException();
    }

    String cleanName(ScriptNode scriptNode) {
        if (!(scriptNode instanceof FunctionNode)) {
            return JavascriptRunner.SCRIPT_NAME;
        }
        Name functionName = ((FunctionNode) scriptNode).getFunctionName();
        return functionName == null ? "anonymous" : functionName.getIdentifier();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Evaluator
    public Object compile(CompilerEnvirons compilerEnvirons, ScriptNode scriptNode, String str, boolean z) {
        int i;
        synchronized (globalLock) {
            i = globalSerialClassCounter + 1;
            globalSerialClassCounter = i;
        }
        String str2 = "c";
        if (scriptNode.getSourceName().length() > 0) {
            str2 = scriptNode.getSourceName().replaceAll("\\W", "_");
            if (!Character.isJavaIdentifierStart(str2.charAt(0))) {
                str2 = "_" + str2;
            }
        }
        String str3 = "external.sdk.pendo.io.mozilla.javascript.gen." + str2 + "_" + i;
        return new Object[]{str3, compileToClassFile(compilerEnvirons, str3, scriptNode, str, z)};
    }

    public byte[] compileToClassFile(CompilerEnvirons compilerEnvirons, String str, ScriptNode scriptNode, String str2, boolean z) {
        this.compilerEnv = compilerEnvirons;
        transform(scriptNode);
        if (z) {
            scriptNode = scriptNode.getFunctionNode(0);
        }
        initScriptNodesData(scriptNode);
        this.mainClassName = str;
        this.mainClassSignature = c.g(str);
        return generateCode(str2);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Evaluator
    public Function createFunctionObject(Context context, Scriptable scriptable, Object obj, Object obj2) {
        try {
            return (NativeFunction) defineClass(obj, obj2).getConstructors()[0].newInstance(scriptable, context, 0);
        } catch (Exception e) {
            throw new RuntimeException("Unable to instantiate compiled class:" + e.toString());
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Evaluator
    public Script createScriptObject(Object obj, Object obj2) {
        try {
            return (Script) defineClass(obj, obj2).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Unable to instantiate compiled class:" + e.toString());
        }
    }

    String getBodyMethodName(ScriptNode scriptNode) {
        return "_c_" + cleanName(scriptNode) + "_" + getIndex(scriptNode);
    }

    String getBodyMethodSignature(ScriptNode scriptNode) {
        StringBuilder sb = new StringBuilder("(");
        sb.append(this.mainClassSignature);
        sb.append("Lexternal/sdk/pendo/io/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;");
        if (scriptNode.getType() == 110) {
            OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode);
            if (optFunctionNode.isTargetOfDirectCall()) {
                int paramCount = optFunctionNode.fnode.getParamCount();
                for (int i = 0; i != paramCount; i++) {
                    sb.append("Ljava/lang/Object;D");
                }
            }
        }
        sb.append("[Ljava/lang/Object;)Ljava/lang/Object;");
        return sb.toString();
    }

    String getCompiledRegexpName(ScriptNode scriptNode, int i) {
        return "_re" + getIndex(scriptNode) + "_" + i;
    }

    String getDirectCtorName(ScriptNode scriptNode) {
        return "_n" + getIndex(scriptNode);
    }

    String getFunctionInitMethodName(OptFunctionNode optFunctionNode) {
        return "_i" + getIndex(optFunctionNode.fnode);
    }

    int getIndex(ScriptNode scriptNode) {
        return this.scriptOrFnIndexes.getExisting(scriptNode);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Evaluator
    public String getPatchedStack(RhinoException rhinoException, String str) {
        throw new UnsupportedOperationException();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Evaluator
    public List<String> getScriptStack(RhinoException rhinoException) {
        throw new UnsupportedOperationException();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Evaluator
    public String getSourcePositionFromStack(Context context, int[] iArr) {
        throw new UnsupportedOperationException();
    }

    void pushNumberAsObject(c cVar, double d) {
        String str;
        if (d == 0.0d) {
            if (1.0d / d > 0.0d) {
                str = "zeroObj";
                cVar.a(178, "external/sdk/pendo/io/mozilla/javascript/ScriptRuntime", str, "Ljava/lang/Double;");
                return;
            }
            cVar.b(d);
            addDoubleWrap(cVar);
        }
        if (d == 1.0d) {
            cVar.a(178, "external/sdk/pendo/io/mozilla/javascript/optimizer/OptRuntime", "oneObj", "Ljava/lang/Double;");
            return;
        }
        if (d == -1.0d) {
            cVar.a(178, "external/sdk/pendo/io/mozilla/javascript/optimizer/OptRuntime", "minusOneObj", "Ljava/lang/Double;");
            return;
        }
        if (Double.isNaN(d)) {
            str = "NaNobj";
            cVar.a(178, "external/sdk/pendo/io/mozilla/javascript/ScriptRuntime", str, "Ljava/lang/Double;");
            return;
        }
        int i = this.itsConstantListSize;
        if (i < 2000) {
            int i2 = 0;
            if (i == 0) {
                this.itsConstantList = new double[64];
            } else {
                double[] dArr = this.itsConstantList;
                int i3 = 0;
                while (i3 != i && dArr[i3] != d) {
                    i3++;
                }
                if (i == dArr.length) {
                    double[] dArr2 = new double[i * 2];
                    System.arraycopy(this.itsConstantList, 0, dArr2, 0, i);
                    this.itsConstantList = dArr2;
                }
                i2 = i3;
            }
            if (i2 == i) {
                this.itsConstantList[i] = d;
                this.itsConstantListSize = i + 1;
            }
            cVar.a(178, this.mainClassName, "_k" + i2, getStaticConstantWrapperType(d));
            return;
        }
        cVar.b(d);
        addDoubleWrap(cVar);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Evaluator
    public void setEvalScriptFlag(Script script) {
        throw new UnsupportedOperationException();
    }

    public void setMainMethodClass(String str) {
        this.mainMethodClass = str;
    }
}
