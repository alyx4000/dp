package external.sdk.pendo.io.mozilla.javascript;

import androidx.webkit.ProxyConfig;
import external.sdk.pendo.io.mozilla.javascript.Parser;
import external.sdk.pendo.io.mozilla.javascript.ast.ArrayComprehension;
import external.sdk.pendo.io.mozilla.javascript.ast.ArrayComprehensionLoop;
import external.sdk.pendo.io.mozilla.javascript.ast.ArrayLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.Assignment;
import external.sdk.pendo.io.mozilla.javascript.ast.AstNode;
import external.sdk.pendo.io.mozilla.javascript.ast.AstRoot;
import external.sdk.pendo.io.mozilla.javascript.ast.Block;
import external.sdk.pendo.io.mozilla.javascript.ast.BreakStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.CatchClause;
import external.sdk.pendo.io.mozilla.javascript.ast.ConditionalExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.ContinueStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.DestructuringForm;
import external.sdk.pendo.io.mozilla.javascript.ast.DoLoop;
import external.sdk.pendo.io.mozilla.javascript.ast.ElementGet;
import external.sdk.pendo.io.mozilla.javascript.ast.EmptyExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.ExpressionStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.ForInLoop;
import external.sdk.pendo.io.mozilla.javascript.ast.ForLoop;
import external.sdk.pendo.io.mozilla.javascript.ast.FunctionCall;
import external.sdk.pendo.io.mozilla.javascript.ast.FunctionNode;
import external.sdk.pendo.io.mozilla.javascript.ast.GeneratorExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.GeneratorExpressionLoop;
import external.sdk.pendo.io.mozilla.javascript.ast.IfStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.InfixExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.Jump;
import external.sdk.pendo.io.mozilla.javascript.ast.Label;
import external.sdk.pendo.io.mozilla.javascript.ast.LabeledStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.LetNode;
import external.sdk.pendo.io.mozilla.javascript.ast.Loop;
import external.sdk.pendo.io.mozilla.javascript.ast.Name;
import external.sdk.pendo.io.mozilla.javascript.ast.NewExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.NumberLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.ObjectLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.ObjectProperty;
import external.sdk.pendo.io.mozilla.javascript.ast.ParenthesizedExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.PropertyGet;
import external.sdk.pendo.io.mozilla.javascript.ast.RegExpLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.ReturnStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.Scope;
import external.sdk.pendo.io.mozilla.javascript.ast.ScriptNode;
import external.sdk.pendo.io.mozilla.javascript.ast.StringLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.SwitchCase;
import external.sdk.pendo.io.mozilla.javascript.ast.SwitchStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.ThrowStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.TryStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.UnaryExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.VariableDeclaration;
import external.sdk.pendo.io.mozilla.javascript.ast.WhileLoop;
import external.sdk.pendo.io.mozilla.javascript.ast.WithStatement;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlDotQuery;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlElemRef;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlExpression;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlFragment;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlLiteral;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlMemberGet;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlPropRef;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlRef;
import external.sdk.pendo.io.mozilla.javascript.ast.XmlString;
import external.sdk.pendo.io.mozilla.javascript.ast.Yield;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class IRFactory extends Parser {
    private static final int ALWAYS_FALSE_BOOLEAN = -1;
    private static final int ALWAYS_TRUE_BOOLEAN = 1;
    private static final int LOOP_DO_WHILE = 0;
    private static final int LOOP_FOR = 2;
    private static final int LOOP_WHILE = 1;
    private Decompiler decompiler;

    public IRFactory() {
        this.decompiler = new Decompiler();
    }

    private static void addSwitchCase(Node node, Node node2, Node node3) {
        if (node.getType() != 130) {
            throw Kit.codeBug();
        }
        Jump jump = (Jump) node.getFirstChild();
        if (jump.getType() != 115) {
            throw Kit.codeBug();
        }
        Node newTarget = Node.newTarget();
        if (node2 != null) {
            Jump jump2 = new Jump(116, node2);
            jump2.target = newTarget;
            jump.addChildToBack(jump2);
        } else {
            jump.setDefault(newTarget);
        }
        node.addChildToBack(newTarget);
        node.addChildToBack(node3);
    }

    private Node arrayCompTransformHelper(ArrayComprehension arrayComprehension, String str) {
        ArrayComprehensionLoop arrayComprehensionLoop;
        Scope createLoopNode;
        int i;
        String str2;
        this.decompiler.addToken(84);
        int lineno = arrayComprehension.getLineno();
        Node transform = transform(arrayComprehension.getResult());
        List<ArrayComprehensionLoop> loops = arrayComprehension.getLoops();
        int size = loops.size();
        Node[] nodeArr = new Node[size];
        Node[] nodeArr2 = new Node[size];
        Node node = transform;
        for (int i2 = 0; i2 < size; i2++) {
            ArrayComprehensionLoop arrayComprehensionLoop2 = loops.get(i2);
            this.decompiler.addName(" ");
            this.decompiler.addToken(120);
            if (arrayComprehensionLoop2.isForEach()) {
                this.decompiler.addName("each ");
            }
            this.decompiler.addToken(88);
            AstNode iterator = arrayComprehensionLoop2.getIterator();
            if (iterator.getType() == 39) {
                str2 = iterator.getString();
                this.decompiler.addName(str2);
            } else {
                decompile(iterator);
                String nextTempName = this.currentScriptOrFn.getNextTempName();
                defineSymbol(88, nextTempName, false);
                node = createBinary(90, createAssignment(91, iterator, createName(nextTempName)), node);
                str2 = nextTempName;
            }
            Node createName = createName(str2);
            defineSymbol(154, str2, false);
            nodeArr[i2] = createName;
            if (arrayComprehensionLoop2.isForOf()) {
                this.decompiler.addName("of ");
            } else {
                this.decompiler.addToken(52);
            }
            nodeArr2[i2] = transform(arrayComprehensionLoop2.getIteratedObject());
            this.decompiler.addToken(89);
        }
        Node createCallOrNew = createCallOrNew(38, createPropertyGet(createName(str), null, "push", 0));
        Node node2 = new Node(134, createCallOrNew, lineno);
        if (arrayComprehension.getFilter() != null) {
            this.decompiler.addName(" ");
            this.decompiler.addToken(113);
            this.decompiler.addToken(88);
            node2 = createIf(transform(arrayComprehension.getFilter()), node2, null, lineno);
            this.decompiler.addToken(89);
        }
        Node node3 = node2;
        int i3 = size - 1;
        int i4 = 0;
        while (i3 >= 0) {
            try {
                arrayComprehensionLoop = loops.get(i3);
                createLoopNode = createLoopNode(null, arrayComprehensionLoop.getLineno());
                pushScope(createLoopNode);
                i = i4 + 1;
            } catch (Throwable th) {
                th = th;
            }
            try {
                Node node4 = createCallOrNew;
                node3 = createForIn(154, createLoopNode, nodeArr[i3], nodeArr2[i3], node3, arrayComprehensionLoop.isForEach(), arrayComprehensionLoop.isForOf());
                i3--;
                createCallOrNew = node4;
                i4 = i;
            } catch (Throwable th2) {
                th = th2;
                i4 = i;
                for (int i5 = 0; i5 < i4; i5++) {
                    popScope();
                }
                throw th;
            }
        }
        Node node5 = createCallOrNew;
        for (int i6 = 0; i6 < i4; i6++) {
            popScope();
        }
        this.decompiler.addToken(85);
        node5.addChildToBack(node);
        return node3;
    }

    private static void closeSwitch(Node node) {
        if (node.getType() != 130) {
            throw Kit.codeBug();
        }
        Jump jump = (Jump) node.getFirstChild();
        if (jump.getType() != 115) {
            throw Kit.codeBug();
        }
        Node newTarget = Node.newTarget();
        jump.target = newTarget;
        Node node2 = jump.getDefault();
        if (node2 == null) {
            node2 = newTarget;
        }
        node.addChildAfter(makeJump(5, node2), jump);
        node.addChildToBack(newTarget);
    }

    private Node createAssignment(int i, Node node, Node node2) {
        int i2;
        Node makeReference = makeReference(node);
        if (makeReference == null) {
            if (node.getType() != 66 && node.getType() != 67) {
                reportError("msg.bad.assign.left");
                return node2;
            }
            if (i == 91) {
                return createDestructuringAssignment(-1, node, node2);
            }
            reportError("msg.bad.destruct.op");
            return node2;
        }
        switch (i) {
            case 91:
                return simpleAssignment(makeReference, node2);
            case 92:
                i2 = 9;
                break;
            case 93:
                i2 = 10;
                break;
            case 94:
                i2 = 11;
                break;
            case 95:
                i2 = 18;
                break;
            case 96:
                i2 = 19;
                break;
            case 97:
                i2 = 20;
                break;
            case 98:
                i2 = 21;
                break;
            case 99:
                i2 = 22;
                break;
            case 100:
                i2 = 23;
                break;
            case 101:
                i2 = 24;
                break;
            case 102:
                i2 = 25;
                break;
            default:
                throw Kit.codeBug();
        }
        int type = makeReference.getType();
        if (type == 33 || type == 36) {
            return new Node(type == 33 ? 140 : 141, makeReference.getFirstChild(), makeReference.getLastChild(), new Node(i2, new Node(139), node2));
        }
        if (type == 39) {
            return new Node(8, Node.newString(49, makeReference.getString()), new Node(i2, makeReference, node2));
        }
        if (type != 68) {
            throw Kit.codeBug();
        }
        Node firstChild = makeReference.getFirstChild();
        checkMutableReference(firstChild);
        return new Node(143, firstChild, new Node(i2, new Node(139), node2));
    }

    private static Node createBinary(int i, Node node, Node node2) {
        String numberToString;
        if (i == 105) {
            int isAlwaysDefinedBoolean = isAlwaysDefinedBoolean(node);
            if (isAlwaysDefinedBoolean == 1) {
                return node;
            }
            if (isAlwaysDefinedBoolean == -1) {
                return node2;
            }
        } else if (i != 106) {
            switch (i) {
                case 21:
                    int i2 = node.type;
                    if (i2 == 41) {
                        int i3 = node2.type;
                        if (i3 == 41) {
                            numberToString = node2.getString();
                        } else if (i3 == 40) {
                            numberToString = ScriptRuntime.numberToString(node2.getDouble(), 10);
                        }
                        node.setString(node.getString().concat(numberToString));
                        return node;
                    }
                    if (i2 == 40) {
                        int i4 = node2.type;
                        if (i4 == 40) {
                            node.setDouble(node.getDouble() + node2.getDouble());
                            return node;
                        }
                        if (i4 == 41) {
                            node2.setString(ScriptRuntime.numberToString(node.getDouble(), 10).concat(node2.getString()));
                            return node2;
                        }
                    }
                    break;
                case 22:
                    if (node.type == 40) {
                        double d = node.getDouble();
                        if (node2.type == 40) {
                            node.setDouble(d - node2.getDouble());
                            return node;
                        }
                        if (d == 0.0d) {
                            return new Node(29, node2);
                        }
                    } else if (node2.type == 40 && node2.getDouble() == 0.0d) {
                        return new Node(28, node);
                    }
                    break;
                case 23:
                    if (node.type == 40) {
                        double d2 = node.getDouble();
                        if (node2.type == 40) {
                            node.setDouble(d2 * node2.getDouble());
                            return node;
                        }
                        if (d2 == 1.0d) {
                            return new Node(28, node2);
                        }
                    } else if (node2.type == 40 && node2.getDouble() == 1.0d) {
                        return new Node(28, node);
                    }
                    break;
                case 24:
                    if (node2.type == 40) {
                        double d3 = node2.getDouble();
                        if (node.type == 40) {
                            node.setDouble(node.getDouble() / d3);
                            return node;
                        }
                        if (d3 == 1.0d) {
                            return new Node(28, node);
                        }
                    }
                    break;
            }
        } else {
            int isAlwaysDefinedBoolean2 = isAlwaysDefinedBoolean(node);
            if (isAlwaysDefinedBoolean2 == -1) {
                return node;
            }
            if (isAlwaysDefinedBoolean2 == 1) {
                return node2;
            }
        }
        return new Node(i, node, node2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
    
        if (r5.getLastChild().getString().equals("eval") != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private external.sdk.pendo.io.mozilla.javascript.Node createCallOrNew(int r4, external.sdk.pendo.io.mozilla.javascript.Node r5) {
        /*
            r3 = this;
            int r0 = r5.getType()
            r1 = 39
            java.lang.String r2 = "eval"
            if (r0 != r1) goto L1f
            java.lang.String r0 = r5.getString()
            boolean r1 = r0.equals(r2)
            if (r1 == 0) goto L15
            goto L35
        L15:
            java.lang.String r1 = "With"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L37
            r0 = 2
            goto L38
        L1f:
            int r0 = r5.getType()
            r1 = 33
            if (r0 != r1) goto L37
            external.sdk.pendo.io.mozilla.javascript.Node r0 = r5.getLastChild()
            java.lang.String r0 = r0.getString()
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L37
        L35:
            r0 = 1
            goto L38
        L37:
            r0 = 0
        L38:
            external.sdk.pendo.io.mozilla.javascript.Node r1 = new external.sdk.pendo.io.mozilla.javascript.Node
            r1.<init>(r4, r5)
            if (r0 == 0) goto L47
            r3.setRequiresActivation()
            r4 = 10
            r1.putIntProp(r4, r0)
        L47:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.IRFactory.createCallOrNew(int, external.sdk.pendo.io.mozilla.javascript.Node):external.sdk.pendo.io.mozilla.javascript.Node");
    }

    private Node createCatch(String str, Node node, Node node2, int i) {
        if (node == null) {
            node = new Node(129);
        }
        return new Node(125, createName(str), node, node2, i);
    }

    private static Node createCondExpr(Node node, Node node2, Node node3) {
        int isAlwaysDefinedBoolean = isAlwaysDefinedBoolean(node);
        return isAlwaysDefinedBoolean == 1 ? node2 : isAlwaysDefinedBoolean == -1 ? node3 : new Node(103, node, node2, node3);
    }

    private Node createElementGet(Node node, String str, Node node2, int i) {
        if (str != null || i != 0) {
            return createMemberRefGet(node, str, node2, i);
        }
        if (node != null) {
            return new Node(36, node, node2);
        }
        throw Kit.codeBug();
    }

    private static Node createExprStatementNoReturn(Node node, int i) {
        return new Node(134, node, i);
    }

    private static Node createFor(Scope scope, Node node, Node node2, Node node3, Node node4) {
        if (node.getType() != 154) {
            return createLoop(scope, 2, node4, node2, node, node3);
        }
        Scope splitScope = Scope.splitScope(scope);
        splitScope.setType(154);
        splitScope.addChildrenToBack(node);
        splitScope.addChildToBack(createLoop(scope, 2, node4, node2, new Node(129), node3));
        return splitScope;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private external.sdk.pendo.io.mozilla.javascript.Node createForIn(int r20, external.sdk.pendo.io.mozilla.javascript.Node r21, external.sdk.pendo.io.mozilla.javascript.Node r22, external.sdk.pendo.io.mozilla.javascript.Node r23, external.sdk.pendo.io.mozilla.javascript.Node r24, boolean r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.IRFactory.createForIn(int, external.sdk.pendo.io.mozilla.javascript.Node, external.sdk.pendo.io.mozilla.javascript.Node, external.sdk.pendo.io.mozilla.javascript.Node, external.sdk.pendo.io.mozilla.javascript.Node, boolean, boolean):external.sdk.pendo.io.mozilla.javascript.Node");
    }

    private static Node createIf(Node node, Node node2, Node node3, int i) {
        int isAlwaysDefinedBoolean = isAlwaysDefinedBoolean(node);
        if (isAlwaysDefinedBoolean == 1) {
            return node2;
        }
        if (isAlwaysDefinedBoolean == -1) {
            return node3 != null ? node3 : new Node(130, i);
        }
        Node node4 = new Node(130, i);
        Node newTarget = Node.newTarget();
        Jump jump = new Jump(7, node);
        jump.target = newTarget;
        node4.addChildToBack(jump);
        node4.addChildrenToBack(node2);
        if (node3 != null) {
            Node newTarget2 = Node.newTarget();
            node4.addChildToBack(makeJump(5, newTarget2));
            node4.addChildToBack(newTarget);
            node4.addChildrenToBack(node3);
            node4.addChildToBack(newTarget2);
        } else {
            node4.addChildToBack(newTarget);
        }
        return node4;
    }

    private static Node createIncDec(int i, boolean z, Node node) {
        Node makeReference = makeReference(node);
        int type = makeReference.getType();
        if (type != 33 && type != 36 && type != 39 && type != 68) {
            throw Kit.codeBug();
        }
        Node node2 = new Node(i, makeReference);
        int i2 = i == 108 ? 1 : 0;
        if (z) {
            i2 |= 2;
        }
        node2.putIntProp(13, i2);
        return node2;
    }

    private static Node createLoop(Jump jump, int i, Node node, Node node2, Node node3, Node node4) {
        Node newTarget = Node.newTarget();
        Node newTarget2 = Node.newTarget();
        if (i == 2 && node2.getType() == 129) {
            node2 = new Node(45);
        }
        Jump jump2 = new Jump(6, node2);
        jump2.target = newTarget;
        Node newTarget3 = Node.newTarget();
        jump.addChildToBack(newTarget);
        jump.addChildrenToBack(node);
        if (i == 1 || i == 2) {
            jump.addChildrenToBack(new Node(129, jump.getLineno()));
        }
        jump.addChildToBack(newTarget2);
        jump.addChildToBack(jump2);
        jump.addChildToBack(newTarget3);
        jump.target = newTarget3;
        if (i == 1 || i == 2) {
            jump.addChildToFront(makeJump(5, newTarget2));
            if (i == 2) {
                int type = node3.getType();
                if (type != 129) {
                    if (type != 123 && type != 154) {
                        node3 = new Node(134, node3);
                    }
                    jump.addChildToFront(node3);
                }
                newTarget2 = Node.newTarget();
                jump.addChildAfter(newTarget2, node);
                if (node4.getType() != 129) {
                    jump.addChildAfter(new Node(134, node4), newTarget2);
                }
            }
        }
        jump.setContinue(newTarget2);
        return jump;
    }

    private Scope createLoopNode(Node node, int i) {
        Scope createScopeNode = createScopeNode(133, i);
        if (node != null) {
            ((Jump) node).setLoop(createScopeNode);
        }
        return createScopeNode;
    }

    private Node createMemberRefGet(Node node, String str, Node node2, int i) {
        Node node3;
        Node node4 = str != null ? str.equals(ProxyConfig.MATCH_ALL_SCHEMES) ? new Node(42) : createName(str) : null;
        if (node == null) {
            node3 = str == null ? new Node(80, node2) : new Node(81, node4, node2);
        } else {
            node3 = str == null ? new Node(78, node, node2) : new Node(79, node, node4, node2);
        }
        if (i != 0) {
            node3.putIntProp(16, i);
        }
        return new Node(68, node3);
    }

    private Node createPropertyGet(Node node, String str, String str2, int i) {
        if (str != null || i != 0) {
            return createMemberRefGet(node, str, Node.newString(str2), i | 1);
        }
        if (node == null) {
            return createName(str2);
        }
        checkActivationName(str2, 33);
        if (!ScriptRuntime.isSpecialProperty(str2)) {
            return new Node(33, node, Node.newString(str2));
        }
        Node node2 = new Node(72, node);
        node2.putProp(17, str2);
        return new Node(68, node2);
    }

    private static Node createString(String str) {
        return Node.newString(str);
    }

    private Node createTryCatchFinally(Node node, Node node2, Node node3, int i) {
        boolean z = false;
        boolean z2 = node3 != null && (node3.getType() != 130 || node3.hasChildren());
        if (node.getType() == 130 && !node.hasChildren() && !z2) {
            return node;
        }
        boolean hasChildren = node2.hasChildren();
        if (!z2 && !hasChildren) {
            return node;
        }
        Node node4 = new Node(142);
        Jump jump = new Jump(82, node, i);
        jump.putProp(3, node4);
        int i2 = 5;
        if (hasChildren) {
            Node newTarget = Node.newTarget();
            jump.addChildToBack(makeJump(5, newTarget));
            Node newTarget2 = Node.newTarget();
            jump.target = newTarget2;
            jump.addChildToBack(newTarget2);
            Node node5 = new Node(142);
            Node firstChild = node2.getFirstChild();
            int i3 = 0;
            while (firstChild != null) {
                int lineno = firstChild.getLineno();
                Node firstChild2 = firstChild.getFirstChild();
                Node next = firstChild2.getNext();
                Node next2 = next.getNext();
                firstChild.removeChild(firstChild2);
                firstChild.removeChild(next);
                firstChild.removeChild(next2);
                next2.addChildToBack(new Node(3));
                next2.addChildToBack(makeJump(i2, newTarget));
                if (next.getType() == 129) {
                    z = true;
                } else {
                    next2 = createIf(next, next2, null, lineno);
                }
                Node node6 = new Node(57, firstChild2, createUseLocal(node4));
                node6.putProp(3, node5);
                node6.putIntProp(14, i3);
                node5.addChildToBack(node6);
                node5.addChildToBack(createWith(createUseLocal(node5), next2, lineno));
                firstChild = firstChild.getNext();
                i3++;
                i2 = 5;
            }
            jump.addChildToBack(node5);
            if (!z) {
                Node node7 = new Node(51);
                node7.putProp(3, node4);
                jump.addChildToBack(node7);
            }
            jump.addChildToBack(newTarget);
        }
        if (z2) {
            Node newTarget3 = Node.newTarget();
            jump.setFinally(newTarget3);
            jump.addChildToBack(makeJump(136, newTarget3));
            Node newTarget4 = Node.newTarget();
            jump.addChildToBack(makeJump(5, newTarget4));
            jump.addChildToBack(newTarget3);
            Node node8 = new Node(126, node3);
            node8.putProp(3, node4);
            jump.addChildToBack(node8);
            jump.addChildToBack(newTarget4);
        }
        node4.addChildToBack(jump);
        return node4;
    }

    private static Node createUnary(int i, Node node) {
        int type = node.getType();
        switch (i) {
            case 26:
                int isAlwaysDefinedBoolean = isAlwaysDefinedBoolean(node);
                if (isAlwaysDefinedBoolean != 0) {
                    int i2 = isAlwaysDefinedBoolean == 1 ? 44 : 45;
                    if (type != 45 && type != 44) {
                        return new Node(i2);
                    }
                    node.setType(i2);
                    return node;
                }
                break;
            case 27:
                if (type == 40) {
                    node.setDouble(~ScriptRuntime.toInt32(node.getDouble()));
                    return node;
                }
                break;
            case 29:
                if (type == 40) {
                    node.setDouble(-node.getDouble());
                    return node;
                }
                break;
            case 31:
                if (type == 39) {
                    node.setType(49);
                    return new Node(i, node, Node.newString(node.getString()));
                }
                if (type == 33 || type == 36) {
                    Node firstChild = node.getFirstChild();
                    Node lastChild = node.getLastChild();
                    node.removeChild(firstChild);
                    node.removeChild(lastChild);
                    return new Node(i, firstChild, lastChild);
                }
                if (type != 68) {
                    return new Node(i, new Node(45), node);
                }
                Node firstChild2 = node.getFirstChild();
                node.removeChild(firstChild2);
                return new Node(70, firstChild2);
            case 32:
                if (type == 39) {
                    node.setType(138);
                    return node;
                }
                break;
        }
        return new Node(i, node);
    }

    private static Node createUseLocal(Node node) {
        if (142 != node.getType()) {
            throw Kit.codeBug();
        }
        Node node2 = new Node(54);
        node2.putProp(3, node);
        return node2;
    }

    private Node createWith(Node node, Node node2, int i) {
        setRequiresActivation();
        Node node3 = new Node(130, i);
        node3.addChildToBack(new Node(2, node));
        node3.addChildrenToBack(new Node(124, node2, i));
        node3.addChildToBack(new Node(3));
        return node3;
    }

    private Node genExprTransformHelper(GeneratorExpression generatorExpression) {
        GeneratorExpressionLoop generatorExpressionLoop;
        Scope createLoopNode;
        int i;
        String str;
        this.decompiler.addToken(88);
        int lineno = generatorExpression.getLineno();
        Node transform = transform(generatorExpression.getResult());
        List<GeneratorExpressionLoop> loops = generatorExpression.getLoops();
        int size = loops.size();
        Node[] nodeArr = new Node[size];
        Node[] nodeArr2 = new Node[size];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            GeneratorExpressionLoop generatorExpressionLoop2 = loops.get(i3);
            this.decompiler.addName(" ");
            this.decompiler.addToken(120);
            this.decompiler.addToken(88);
            AstNode iterator = generatorExpressionLoop2.getIterator();
            if (iterator.getType() == 39) {
                str = iterator.getString();
                this.decompiler.addName(str);
            } else {
                decompile(iterator);
                String nextTempName = this.currentScriptOrFn.getNextTempName();
                defineSymbol(88, nextTempName, false);
                transform = createBinary(90, createAssignment(91, iterator, createName(nextTempName)), transform);
                str = nextTempName;
            }
            Node createName = createName(str);
            defineSymbol(154, str, false);
            nodeArr[i3] = createName;
            if (generatorExpressionLoop2.isForOf()) {
                this.decompiler.addName("of ");
            } else {
                this.decompiler.addToken(52);
            }
            nodeArr2[i3] = transform(generatorExpressionLoop2.getIteratedObject());
            this.decompiler.addToken(89);
        }
        Node node = new Node(134, new Node(73, transform, generatorExpression.getLineno()), lineno);
        if (generatorExpression.getFilter() != null) {
            this.decompiler.addName(" ");
            this.decompiler.addToken(113);
            this.decompiler.addToken(88);
            node = createIf(transform(generatorExpression.getFilter()), node, null, lineno);
            this.decompiler.addToken(89);
        }
        Node node2 = node;
        int i4 = size - 1;
        int i5 = 0;
        while (i4 >= 0) {
            try {
                generatorExpressionLoop = loops.get(i4);
                createLoopNode = createLoopNode(null, generatorExpressionLoop.getLineno());
                pushScope(createLoopNode);
                i = i5 + 1;
            } catch (Throwable th) {
                th = th;
            }
            try {
                node2 = createForIn(154, createLoopNode, nodeArr[i4], nodeArr2[i4], node2, generatorExpressionLoop.isForEach(), generatorExpressionLoop.isForOf());
                i4--;
                i5 = i;
            } catch (Throwable th2) {
                th = th2;
                i5 = i;
                while (i2 < i5) {
                    popScope();
                    i2++;
                }
                throw th;
            }
        }
        while (i2 < i5) {
            popScope();
            i2++;
        }
        this.decompiler.addToken(89);
        return node2;
    }

    private Object getPropKey(Node node) {
        String value;
        if (node instanceof Name) {
            value = ((Name) node).getIdentifier();
            this.decompiler.addName(value);
        } else {
            if (!(node instanceof StringLiteral)) {
                if (!(node instanceof NumberLiteral)) {
                    throw Kit.codeBug();
                }
                double number = ((NumberLiteral) node).getNumber();
                this.decompiler.addNumber(number);
                return ScriptRuntime.getIndexObject(number);
            }
            value = ((StringLiteral) node).getValue();
            this.decompiler.addString(value);
        }
        return ScriptRuntime.getIndexObject(value);
    }

    private static Node initFunction(FunctionNode functionNode, int i, Node node, int i2) {
        Name functionName;
        functionNode.setFunctionType(i2);
        functionNode.addChildToBack(node);
        if (functionNode.getFunctionCount() != 0) {
            functionNode.setRequiresActivation();
        }
        if (i2 == 2 && (functionName = functionNode.getFunctionName()) != null && functionName.length() != 0 && functionNode.getSymbol(functionName.getIdentifier()) == null) {
            functionNode.putSymbol(new external.sdk.pendo.io.mozilla.javascript.ast.Symbol(110, functionName.getIdentifier()));
            node.addChildrenToFront(new Node(134, new Node(8, Node.newString(49, functionName.getIdentifier()), new Node(64))));
        }
        Node lastChild = node.getLastChild();
        if (lastChild == null || lastChild.getType() != 4) {
            node.addChildToBack(new Node(4));
        }
        Node newString = Node.newString(110, functionNode.getName());
        newString.putIntProp(1, i);
        return newString;
    }

    private static int isAlwaysDefinedBoolean(Node node) {
        int type = node.getType();
        if (type == 40) {
            double d = node.getDouble();
            return (Double.isNaN(d) || d == 0.0d) ? -1 : 1;
        }
        if (type == 42 || type == 44) {
            return -1;
        }
        return type != 45 ? 0 : 1;
    }

    private static Jump makeJump(int i, Node node) {
        Jump jump = new Jump(i);
        jump.target = node;
        return jump;
    }

    private static Node makeReference(Node node) {
        int type = node.getType();
        if (type != 33 && type != 36 && type != 68) {
            if (type == 38) {
                node.setType(71);
                return new Node(68, node);
            }
            if (type != 39) {
                return null;
            }
        }
        return node;
    }

    private Node transformArrayComp(ArrayComprehension arrayComprehension) {
        int lineno = arrayComprehension.getLineno();
        Scope createScopeNode = createScopeNode(158, lineno);
        String nextTempName = this.currentScriptOrFn.getNextTempName();
        pushScope(createScopeNode);
        try {
            defineSymbol(154, nextTempName, false);
            Node node = new Node(130, lineno);
            node.addChildToBack(new Node(134, createAssignment(91, createName(nextTempName), createCallOrNew(30, createName("Array"))), lineno));
            node.addChildToBack(arrayCompTransformHelper(arrayComprehension, nextTempName));
            createScopeNode.addChildToBack(node);
            createScopeNode.addChildToBack(createName(nextTempName));
            return createScopeNode;
        } finally {
            popScope();
        }
    }

    private Node transformArrayLiteral(ArrayLiteral arrayLiteral) {
        if (arrayLiteral.isDestructuring()) {
            return arrayLiteral;
        }
        this.decompiler.addToken(84);
        List<AstNode> elements = arrayLiteral.getElements();
        Node node = new Node(66);
        ArrayList arrayList = null;
        for (int i = 0; i < elements.size(); i++) {
            AstNode astNode = elements.get(i);
            if (astNode.getType() != 129) {
                node.addChildToBack(transform(astNode));
            } else {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(Integer.valueOf(i));
            }
            if (i < elements.size() - 1) {
                this.decompiler.addToken(90);
            }
        }
        this.decompiler.addToken(85);
        node.putIntProp(21, arrayLiteral.getDestructuringLength());
        if (arrayList != null) {
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
            }
            node.putProp(11, iArr);
        }
        return node;
    }

    private Node transformAssignment(Assignment assignment) {
        AstNode astNode;
        AstNode removeParens = removeParens(assignment.getLeft());
        if (isDestructuring(removeParens)) {
            decompile(removeParens);
            astNode = removeParens;
        } else {
            astNode = transform(removeParens);
        }
        this.decompiler.addToken(assignment.getType());
        return createAssignment(assignment.getType(), astNode, transform(assignment.getRight()));
    }

    private Node transformBlock(AstNode astNode) {
        boolean z = astNode instanceof Scope;
        if (z) {
            pushScope((Scope) astNode);
        }
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<Node> it = astNode.iterator();
            while (it.hasNext()) {
                arrayList.add(transform((AstNode) it.next()));
            }
            astNode.removeChildren();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                astNode.addChildToBack((Node) it2.next());
            }
            return astNode;
        } finally {
            if (z) {
                popScope();
            }
        }
    }

    private Node transformBreak(BreakStatement breakStatement) {
        this.decompiler.addToken(121);
        if (breakStatement.getBreakLabel() != null) {
            this.decompiler.addName(breakStatement.getBreakLabel().getIdentifier());
        }
        this.decompiler.addEOL(83);
        return breakStatement;
    }

    private Node transformCondExpr(ConditionalExpression conditionalExpression) {
        Node transform = transform(conditionalExpression.getTestExpression());
        this.decompiler.addToken(103);
        Node transform2 = transform(conditionalExpression.getTrueExpression());
        this.decompiler.addToken(104);
        return createCondExpr(transform, transform2, transform(conditionalExpression.getFalseExpression()));
    }

    private Node transformContinue(ContinueStatement continueStatement) {
        this.decompiler.addToken(122);
        if (continueStatement.getLabel() != null) {
            this.decompiler.addName(continueStatement.getLabel().getIdentifier());
        }
        this.decompiler.addEOL(83);
        return continueStatement;
    }

    private Node transformDefaultXmlNamepace(UnaryExpression unaryExpression) {
        this.decompiler.addToken(117);
        this.decompiler.addName(" xml");
        this.decompiler.addName(" namespace");
        this.decompiler.addToken(91);
        return createUnary(75, transform(unaryExpression.getOperand()));
    }

    private Node transformDoLoop(DoLoop doLoop) {
        doLoop.setType(133);
        pushScope(doLoop);
        try {
            this.decompiler.addToken(119);
            this.decompiler.addEOL(86);
            Node transform = transform(doLoop.getBody());
            this.decompiler.addToken(87);
            this.decompiler.addToken(118);
            this.decompiler.addToken(88);
            Node transform2 = transform(doLoop.getCondition());
            this.decompiler.addToken(89);
            this.decompiler.addEOL(83);
            return createLoop(doLoop, 0, transform, transform2, null, null);
        } finally {
            popScope();
        }
    }

    private Node transformElementGet(ElementGet elementGet) {
        Node transform = transform(elementGet.getTarget());
        this.decompiler.addToken(84);
        Node transform2 = transform(elementGet.getElement());
        this.decompiler.addToken(85);
        return new Node(36, transform, transform2);
    }

    private Node transformExprStmt(ExpressionStatement expressionStatement) {
        Node transform = transform(expressionStatement.getExpression());
        this.decompiler.addEOL(83);
        return new Node(expressionStatement.getType(), transform, expressionStatement.getLineno());
    }

    private Node transformForInLoop(ForInLoop forInLoop) {
        this.decompiler.addToken(120);
        if (forInLoop.isForEach()) {
            this.decompiler.addName("each ");
        }
        this.decompiler.addToken(88);
        forInLoop.setType(133);
        pushScope(forInLoop);
        try {
            AstNode iterator = forInLoop.getIterator();
            int type = iterator instanceof VariableDeclaration ? ((VariableDeclaration) iterator).getType() : -1;
            Node transform = transform(iterator);
            if (forInLoop.isForOf()) {
                this.decompiler.addName("of ");
            } else {
                this.decompiler.addToken(52);
            }
            Node transform2 = transform(forInLoop.getIteratedObject());
            this.decompiler.addToken(89);
            this.decompiler.addEOL(86);
            Node transform3 = transform(forInLoop.getBody());
            this.decompiler.addEOL(87);
            return createForIn(type, forInLoop, transform, transform2, transform3, forInLoop.isForEach(), forInLoop.isForOf());
        } finally {
            popScope();
        }
    }

    private Node transformForLoop(ForLoop forLoop) {
        this.decompiler.addToken(120);
        this.decompiler.addToken(88);
        forLoop.setType(133);
        Scope scope = this.currentScope;
        this.currentScope = forLoop;
        try {
            Node transform = transform(forLoop.getInitializer());
            this.decompiler.addToken(83);
            Node transform2 = transform(forLoop.getCondition());
            this.decompiler.addToken(83);
            Node transform3 = transform(forLoop.getIncrement());
            this.decompiler.addToken(89);
            this.decompiler.addEOL(86);
            Node transform4 = transform(forLoop.getBody());
            this.decompiler.addEOL(87);
            return createFor(forLoop, transform, transform2, transform3, transform4);
        } finally {
            this.currentScope = scope;
        }
    }

    private Node transformFunction(FunctionNode functionNode) {
        int functionType = functionNode.getFunctionType();
        int markFunctionStart = this.decompiler.markFunctionStart(functionType);
        Node decompileFunctionHeader = decompileFunctionHeader(functionNode);
        int addFunction = this.currentScriptOrFn.addFunction(functionNode);
        Parser.PerFunctionVariables perFunctionVariables = new Parser.PerFunctionVariables(functionNode);
        try {
            Node node = (Node) functionNode.getProp(23);
            functionNode.removeProp(23);
            int lineno = functionNode.getBody().getLineno();
            this.nestingOfFunction++;
            Node transform = transform(functionNode.getBody());
            if (!functionNode.isExpressionClosure()) {
                this.decompiler.addToken(87);
            }
            functionNode.setEncodedSourceBounds(markFunctionStart, this.decompiler.markFunctionEnd(markFunctionStart));
            if (functionType != 2 && !functionNode.isExpressionClosure()) {
                this.decompiler.addToken(1);
            }
            if (node != null) {
                transform.addChildToFront(new Node(134, node, lineno));
            }
            int functionType2 = functionNode.getFunctionType();
            Node initFunction = initFunction(functionNode, addFunction, transform, functionType2);
            if (decompileFunctionHeader != null) {
                initFunction = createAssignment(91, decompileFunctionHeader, initFunction);
                if (functionType2 != 2) {
                    initFunction = createExprStatementNoReturn(initFunction, functionNode.getLineno());
                }
            }
            return initFunction;
        } finally {
            this.nestingOfFunction--;
            perFunctionVariables.restore();
        }
    }

    private Node transformFunctionCall(FunctionCall functionCall) {
        Node createCallOrNew = createCallOrNew(38, transform(functionCall.getTarget()));
        createCallOrNew.setLineno(functionCall.getLineno());
        this.decompiler.addToken(88);
        List<AstNode> arguments = functionCall.getArguments();
        for (int i = 0; i < arguments.size(); i++) {
            createCallOrNew.addChildToBack(transform(arguments.get(i)));
            if (i < arguments.size() - 1) {
                this.decompiler.addToken(90);
            }
        }
        this.decompiler.addToken(89);
        return createCallOrNew;
    }

    private Node transformGenExpr(GeneratorExpression generatorExpression) {
        FunctionNode functionNode = new FunctionNode();
        functionNode.setSourceName(this.currentScriptOrFn.getNextTempName());
        functionNode.setIsGenerator();
        functionNode.setFunctionType(2);
        functionNode.setRequiresActivation();
        int functionType = functionNode.getFunctionType();
        int markFunctionStart = this.decompiler.markFunctionStart(functionType);
        Node decompileFunctionHeader = decompileFunctionHeader(functionNode);
        int addFunction = this.currentScriptOrFn.addFunction(functionNode);
        Parser.PerFunctionVariables perFunctionVariables = new Parser.PerFunctionVariables(functionNode);
        try {
            Node node = (Node) functionNode.getProp(23);
            functionNode.removeProp(23);
            int i = generatorExpression.lineno;
            this.nestingOfFunction++;
            Node genExprTransformHelper = genExprTransformHelper(generatorExpression);
            if (!functionNode.isExpressionClosure()) {
                this.decompiler.addToken(87);
            }
            functionNode.setEncodedSourceBounds(markFunctionStart, this.decompiler.markFunctionEnd(markFunctionStart));
            if (functionType != 2 && !functionNode.isExpressionClosure()) {
                this.decompiler.addToken(1);
            }
            if (node != null) {
                genExprTransformHelper.addChildToFront(new Node(134, node, i));
            }
            int functionType2 = functionNode.getFunctionType();
            Node initFunction = initFunction(functionNode, addFunction, genExprTransformHelper, functionType2);
            if (decompileFunctionHeader != null) {
                initFunction = createAssignment(91, decompileFunctionHeader, initFunction);
                if (functionType2 != 2) {
                    initFunction = createExprStatementNoReturn(initFunction, functionNode.getLineno());
                }
            }
            this.nestingOfFunction--;
            perFunctionVariables.restore();
            Node createCallOrNew = createCallOrNew(38, initFunction);
            createCallOrNew.setLineno(generatorExpression.getLineno());
            this.decompiler.addToken(88);
            this.decompiler.addToken(89);
            return createCallOrNew;
        } catch (Throwable th) {
            this.nestingOfFunction--;
            perFunctionVariables.restore();
            throw th;
        }
    }

    private Node transformIf(IfStatement ifStatement) {
        Node node;
        this.decompiler.addToken(113);
        this.decompiler.addToken(88);
        Node transform = transform(ifStatement.getCondition());
        this.decompiler.addToken(89);
        this.decompiler.addEOL(86);
        Node transform2 = transform(ifStatement.getThenPart());
        if (ifStatement.getElsePart() != null) {
            this.decompiler.addToken(87);
            this.decompiler.addToken(114);
            this.decompiler.addEOL(86);
            node = transform(ifStatement.getElsePart());
        } else {
            node = null;
        }
        this.decompiler.addEOL(87);
        return createIf(transform, transform2, node, ifStatement.getLineno());
    }

    private Node transformInfix(InfixExpression infixExpression) {
        Node transform = transform(infixExpression.getLeft());
        this.decompiler.addToken(infixExpression.getType());
        Node transform2 = transform(infixExpression.getRight());
        if (infixExpression instanceof XmlDotQuery) {
            this.decompiler.addToken(89);
        }
        return createBinary(infixExpression.getType(), transform, transform2);
    }

    private Node transformLabeledStatement(LabeledStatement labeledStatement) {
        Decompiler decompiler;
        Label firstLabel = labeledStatement.getFirstLabel();
        List<Label> labels = labeledStatement.getLabels();
        this.decompiler.addName(firstLabel.getName());
        int i = 104;
        if (labels.size() > 1) {
            for (Label label : labels.subList(1, labels.size())) {
                this.decompiler.addEOL(104);
                this.decompiler.addName(label.getName());
            }
        }
        if (labeledStatement.getStatement().getType() == 130) {
            this.decompiler.addToken(67);
            decompiler = this.decompiler;
            i = 86;
        } else {
            decompiler = this.decompiler;
        }
        decompiler.addEOL(i);
        Node transform = transform(labeledStatement.getStatement());
        if (labeledStatement.getStatement().getType() == 130) {
            this.decompiler.addEOL(87);
        }
        Node newTarget = Node.newTarget();
        Node node = new Node(130, firstLabel, transform, newTarget);
        firstLabel.target = newTarget;
        return node;
    }

    private Node transformLetNode(LetNode letNode) {
        pushScope(letNode);
        try {
            this.decompiler.addToken(154);
            this.decompiler.addToken(88);
            Node transformVariableInitializers = transformVariableInitializers(letNode.getVariables());
            this.decompiler.addToken(89);
            letNode.addChildToBack(transformVariableInitializers);
            boolean z = letNode.getType() == 159;
            if (letNode.getBody() != null) {
                if (z) {
                    this.decompiler.addName(" ");
                } else {
                    this.decompiler.addEOL(86);
                }
                letNode.addChildToBack(transform(letNode.getBody()));
                if (!z) {
                    this.decompiler.addEOL(87);
                }
            }
            return letNode;
        } finally {
            popScope();
        }
    }

    private Node transformLiteral(AstNode astNode) {
        this.decompiler.addToken(astNode.getType());
        return astNode;
    }

    private Node transformName(Name name) {
        this.decompiler.addName(name.getIdentifier());
        return name;
    }

    private Node transformNewExpr(NewExpression newExpression) {
        this.decompiler.addToken(30);
        Node createCallOrNew = createCallOrNew(30, transform(newExpression.getTarget()));
        createCallOrNew.setLineno(newExpression.getLineno());
        List<AstNode> arguments = newExpression.getArguments();
        this.decompiler.addToken(88);
        for (int i = 0; i < arguments.size(); i++) {
            createCallOrNew.addChildToBack(transform(arguments.get(i)));
            if (i < arguments.size() - 1) {
                this.decompiler.addToken(90);
            }
        }
        this.decompiler.addToken(89);
        if (newExpression.getInitializer() != null) {
            createCallOrNew.addChildToBack(transformObjectLiteral(newExpression.getInitializer()));
        }
        return createCallOrNew;
    }

    private Node transformNumber(NumberLiteral numberLiteral) {
        this.decompiler.addNumber(numberLiteral.getNumber());
        return numberLiteral;
    }

    private Node transformObjectLiteral(ObjectLiteral objectLiteral) {
        Object[] objArr;
        if (objectLiteral.isDestructuring()) {
            return objectLiteral;
        }
        this.decompiler.addToken(86);
        List<ObjectProperty> elements = objectLiteral.getElements();
        Node node = new Node(67);
        if (elements.isEmpty()) {
            objArr = ScriptRuntime.emptyArgs;
        } else {
            int size = elements.size();
            Object[] objArr2 = new Object[size];
            int i = 0;
            for (ObjectProperty objectProperty : elements) {
                if (objectProperty.isGetterMethod()) {
                    this.decompiler.addToken(152);
                } else if (objectProperty.isSetterMethod()) {
                    this.decompiler.addToken(153);
                } else if (objectProperty.isNormalMethod()) {
                    this.decompiler.addToken(Token.METHOD);
                }
                int i2 = i + 1;
                objArr2[i] = getPropKey(objectProperty.getLeft());
                if (!objectProperty.isMethod()) {
                    this.decompiler.addToken(67);
                }
                Node transform = transform(objectProperty.getRight());
                if (objectProperty.isGetterMethod()) {
                    transform = createUnary(152, transform);
                } else if (objectProperty.isSetterMethod()) {
                    transform = createUnary(153, transform);
                } else if (objectProperty.isNormalMethod()) {
                    transform = createUnary(Token.METHOD, transform);
                }
                node.addChildToBack(transform);
                if (i2 < size) {
                    this.decompiler.addToken(90);
                }
                i = i2;
            }
            objArr = objArr2;
        }
        this.decompiler.addToken(87);
        node.putProp(12, objArr);
        return node;
    }

    private Node transformParenExpr(ParenthesizedExpression parenthesizedExpression) {
        AstNode expression = parenthesizedExpression.getExpression();
        this.decompiler.addToken(88);
        int i = 1;
        while (expression instanceof ParenthesizedExpression) {
            this.decompiler.addToken(88);
            i++;
            expression = ((ParenthesizedExpression) expression).getExpression();
        }
        Node transform = transform(expression);
        for (int i2 = 0; i2 < i; i2++) {
            this.decompiler.addToken(89);
        }
        transform.putProp(19, Boolean.TRUE);
        return transform;
    }

    private Node transformPropertyGet(PropertyGet propertyGet) {
        Node transform = transform(propertyGet.getTarget());
        String identifier = propertyGet.getProperty().getIdentifier();
        this.decompiler.addToken(109);
        this.decompiler.addName(identifier);
        return createPropertyGet(transform, null, identifier, 0);
    }

    private Node transformRegExp(RegExpLiteral regExpLiteral) {
        this.decompiler.addRegexp(regExpLiteral.getValue(), regExpLiteral.getFlags());
        this.currentScriptOrFn.addRegExp(regExpLiteral);
        return regExpLiteral;
    }

    private Node transformReturn(ReturnStatement returnStatement) {
        Boolean bool = Boolean.TRUE;
        boolean equals = bool.equals(returnStatement.getProp(25));
        boolean equals2 = bool.equals(returnStatement.getProp(27));
        if (!equals) {
            this.decompiler.addToken(4);
        } else if (!equals2) {
            this.decompiler.addName(" ");
        }
        AstNode returnValue = returnStatement.getReturnValue();
        Node transform = returnValue == null ? null : transform(returnValue);
        if (!equals) {
            this.decompiler.addEOL(83);
        }
        return returnValue == null ? new Node(4, returnStatement.getLineno()) : new Node(4, transform, returnStatement.getLineno());
    }

    private Node transformScript(ScriptNode scriptNode) {
        this.decompiler.addToken(137);
        if (this.currentScope != null) {
            Kit.codeBug();
        }
        this.currentScope = scriptNode;
        Node node = new Node(130);
        Iterator<Node> it = scriptNode.iterator();
        while (it.hasNext()) {
            node.addChildToBack(transform((AstNode) it.next()));
        }
        scriptNode.removeChildren();
        Node firstChild = node.getFirstChild();
        if (firstChild != null) {
            scriptNode.addChildrenToBack(firstChild);
        }
        return scriptNode;
    }

    private Node transformString(StringLiteral stringLiteral) {
        this.decompiler.addString(stringLiteral.getValue());
        return Node.newString(stringLiteral.getValue());
    }

    private Node transformSwitch(SwitchStatement switchStatement) {
        Node node;
        this.decompiler.addToken(115);
        this.decompiler.addToken(88);
        Node transform = transform(switchStatement.getExpression());
        this.decompiler.addToken(89);
        switchStatement.addChildToBack(transform);
        Node node2 = new Node(130, switchStatement, switchStatement.getLineno());
        this.decompiler.addEOL(86);
        for (SwitchCase switchCase : switchStatement.getCases()) {
            AstNode expression = switchCase.getExpression();
            if (expression != null) {
                this.decompiler.addToken(116);
                node = transform(expression);
            } else {
                this.decompiler.addToken(117);
                node = null;
            }
            this.decompiler.addEOL(104);
            List<AstNode> statements = switchCase.getStatements();
            Block block = new Block();
            if (statements != null) {
                Iterator<AstNode> it = statements.iterator();
                while (it.hasNext()) {
                    block.addChildToBack(transform(it.next()));
                }
            }
            addSwitchCase(node2, node, block);
        }
        this.decompiler.addEOL(87);
        closeSwitch(node2);
        return node2;
    }

    private Node transformThrow(ThrowStatement throwStatement) {
        this.decompiler.addToken(50);
        Node transform = transform(throwStatement.getExpression());
        this.decompiler.addEOL(83);
        return new Node(50, transform, throwStatement.getLineno());
    }

    private Node transformTry(TryStatement tryStatement) {
        Node node;
        Node emptyExpression;
        this.decompiler.addToken(82);
        this.decompiler.addEOL(86);
        Node transform = transform(tryStatement.getTryBlock());
        this.decompiler.addEOL(87);
        Block block = new Block();
        for (CatchClause catchClause : tryStatement.getCatchClauses()) {
            this.decompiler.addToken(125);
            this.decompiler.addToken(88);
            String identifier = catchClause.getVarName().getIdentifier();
            this.decompiler.addName(identifier);
            AstNode catchCondition = catchClause.getCatchCondition();
            if (catchCondition != null) {
                this.decompiler.addName(" ");
                this.decompiler.addToken(113);
                emptyExpression = transform(catchCondition);
            } else {
                emptyExpression = new EmptyExpression();
            }
            this.decompiler.addToken(89);
            this.decompiler.addEOL(86);
            Node transform2 = transform(catchClause.getBody());
            this.decompiler.addEOL(87);
            block.addChildToBack(createCatch(identifier, emptyExpression, transform2, catchClause.getLineno()));
        }
        if (tryStatement.getFinallyBlock() != null) {
            this.decompiler.addToken(126);
            this.decompiler.addEOL(86);
            node = transform(tryStatement.getFinallyBlock());
            this.decompiler.addEOL(87);
        } else {
            node = null;
        }
        return createTryCatchFinally(transform, block, node, tryStatement.getLineno());
    }

    private Node transformUnary(UnaryExpression unaryExpression) {
        int type = unaryExpression.getType();
        if (type == 75) {
            return transformDefaultXmlNamepace(unaryExpression);
        }
        if (unaryExpression.isPrefix()) {
            this.decompiler.addToken(type);
        }
        Node transform = transform(unaryExpression.getOperand());
        if (unaryExpression.isPostfix()) {
            this.decompiler.addToken(type);
        }
        return (type == 107 || type == 108) ? createIncDec(type, unaryExpression.isPostfix(), transform) : createUnary(type, transform);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private external.sdk.pendo.io.mozilla.javascript.Node transformVariableInitializers(external.sdk.pendo.io.mozilla.javascript.ast.VariableDeclaration r9) {
        /*
            r8 = this;
            java.util.List r0 = r9.getVariables()
            int r1 = r0.size()
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
        Ld:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L6a
            java.lang.Object r3 = r0.next()
            external.sdk.pendo.io.mozilla.javascript.ast.VariableInitializer r3 = (external.sdk.pendo.io.mozilla.javascript.ast.VariableInitializer) r3
            external.sdk.pendo.io.mozilla.javascript.ast.AstNode r4 = r3.getTarget()
            external.sdk.pendo.io.mozilla.javascript.ast.AstNode r5 = r3.getInitializer()
            boolean r6 = r3.isDestructuring()
            if (r6 == 0) goto L2b
            r8.decompile(r4)
            goto L2f
        L2b:
            external.sdk.pendo.io.mozilla.javascript.Node r4 = r8.transform(r4)
        L2f:
            if (r5 == 0) goto L3d
            external.sdk.pendo.io.mozilla.javascript.Decompiler r6 = r8.decompiler
            r7 = 91
            r6.addToken(r7)
            external.sdk.pendo.io.mozilla.javascript.Node r5 = r8.transform(r5)
            goto L3e
        L3d:
            r5 = 0
        L3e:
            boolean r3 = r3.isDestructuring()
            if (r3 == 0) goto L53
            if (r5 != 0) goto L47
            goto L58
        L47:
            int r3 = r9.getType()
            external.sdk.pendo.io.mozilla.javascript.Node r3 = r8.createDestructuringAssignment(r3, r4, r5)
            r9.addChildToBack(r3)
            goto L5b
        L53:
            if (r5 == 0) goto L58
            r4.addChildToBack(r5)
        L58:
            r9.addChildToBack(r4)
        L5b:
            int r3 = r2 + 1
            int r4 = r1 + (-1)
            if (r2 >= r4) goto L68
            external.sdk.pendo.io.mozilla.javascript.Decompiler r2 = r8.decompiler
            r4 = 90
            r2.addToken(r4)
        L68:
            r2 = r3
            goto Ld
        L6a:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.IRFactory.transformVariableInitializers(external.sdk.pendo.io.mozilla.javascript.ast.VariableDeclaration):external.sdk.pendo.io.mozilla.javascript.Node");
    }

    private Node transformVariables(VariableDeclaration variableDeclaration) {
        this.decompiler.addToken(variableDeclaration.getType());
        transformVariableInitializers(variableDeclaration);
        AstNode parent = variableDeclaration.getParent();
        if (!(parent instanceof Loop) && !(parent instanceof LetNode)) {
            this.decompiler.addEOL(83);
        }
        return variableDeclaration;
    }

    private Node transformWhileLoop(WhileLoop whileLoop) {
        this.decompiler.addToken(118);
        whileLoop.setType(133);
        pushScope(whileLoop);
        try {
            this.decompiler.addToken(88);
            Node transform = transform(whileLoop.getCondition());
            this.decompiler.addToken(89);
            this.decompiler.addEOL(86);
            Node transform2 = transform(whileLoop.getBody());
            this.decompiler.addEOL(87);
            return createLoop(whileLoop, 1, transform2, transform, null, null);
        } finally {
            popScope();
        }
    }

    private Node transformWith(WithStatement withStatement) {
        this.decompiler.addToken(124);
        this.decompiler.addToken(88);
        Node transform = transform(withStatement.getExpression());
        this.decompiler.addToken(89);
        this.decompiler.addEOL(86);
        Node transform2 = transform(withStatement.getStatement());
        this.decompiler.addEOL(87);
        return createWith(transform, transform2, withStatement.getLineno());
    }

    private Node transformXmlLiteral(XmlLiteral xmlLiteral) {
        Node createBinary;
        Node node = new Node(30, xmlLiteral.getLineno());
        List<XmlFragment> fragments = xmlLiteral.getFragments();
        node.addChildToBack(createName(((XmlString) fragments.get(0)).getXml().trim().startsWith("<>") ? "XMLList" : "XML"));
        Node node2 = null;
        for (XmlFragment xmlFragment : fragments) {
            if (xmlFragment instanceof XmlString) {
                String xml = ((XmlString) xmlFragment).getXml();
                this.decompiler.addName(xml);
                if (node2 == null) {
                    node2 = createString(xml);
                } else {
                    createBinary = createString(xml);
                }
            } else {
                XmlExpression xmlExpression = (XmlExpression) xmlFragment;
                boolean isXmlAttribute = xmlExpression.isXmlAttribute();
                this.decompiler.addToken(86);
                Node createString = xmlExpression.getExpression() instanceof EmptyExpression ? createString("") : transform(xmlExpression.getExpression());
                this.decompiler.addToken(87);
                createBinary = isXmlAttribute ? createBinary(21, createBinary(21, createString("\""), createUnary(76, createString)), createString("\"")) : createUnary(77, createString);
            }
            node2 = createBinary(21, node2, createBinary);
        }
        node.addChildToBack(node2);
        return node;
    }

    private Node transformXmlMemberGet(XmlMemberGet xmlMemberGet) {
        Decompiler decompiler;
        XmlRef memberRef = xmlMemberGet.getMemberRef();
        Node transform = transform(xmlMemberGet.getLeft());
        int i = memberRef.isAttributeAccess() ? 2 : 0;
        int i2 = 144;
        if (xmlMemberGet.getType() == 144) {
            i |= 4;
            decompiler = this.decompiler;
        } else {
            decompiler = this.decompiler;
            i2 = 109;
        }
        decompiler.addToken(i2);
        return transformXmlRef(transform, memberRef, i);
    }

    private Node transformXmlRef(Node node, XmlRef xmlRef, int i) {
        if ((i & 2) != 0) {
            this.decompiler.addToken(148);
        }
        Name namespace = xmlRef.getNamespace();
        String identifier = namespace != null ? namespace.getIdentifier() : null;
        if (identifier != null) {
            this.decompiler.addName(identifier);
            this.decompiler.addToken(145);
        }
        if (xmlRef instanceof XmlPropRef) {
            String identifier2 = ((XmlPropRef) xmlRef).getPropName().getIdentifier();
            this.decompiler.addName(identifier2);
            return createPropertyGet(node, identifier, identifier2, i);
        }
        this.decompiler.addToken(84);
        Node transform = transform(((XmlElemRef) xmlRef).getExpression());
        this.decompiler.addToken(85);
        return createElementGet(node, identifier, transform, i);
    }

    private Node transformYield(Yield yield) {
        this.decompiler.addToken(yield.getType());
        Node transform = yield.getValue() == null ? null : transform(yield.getValue());
        return transform != null ? new Node(yield.getType(), transform, yield.getLineno()) : new Node(yield.getType(), yield.getLineno());
    }

    void decompile(AstNode astNode) {
        int type = astNode.getType();
        if (type == 33) {
            decompilePropertyGet((PropertyGet) astNode);
        }
        if (type == 36) {
            decompileElementGet((ElementGet) astNode);
            return;
        }
        if (type == 43) {
            this.decompiler.addToken(astNode.getType());
            return;
        }
        if (type != 129) {
            if (type == 66) {
                decompileArrayLiteral((ArrayLiteral) astNode);
                return;
            }
            if (type == 67) {
                decompileObjectLiteral((ObjectLiteral) astNode);
                return;
            }
            switch (type) {
                case 39:
                    this.decompiler.addName(((Name) astNode).getIdentifier());
                    break;
                case 40:
                    this.decompiler.addNumber(((NumberLiteral) astNode).getNumber());
                    break;
                case 41:
                    this.decompiler.addString(((StringLiteral) astNode).getValue());
                    break;
                default:
                    Kit.codeBug("unexpected token: " + Token.typeToName(astNode.getType()));
                    break;
            }
        }
    }

    void decompileArrayLiteral(ArrayLiteral arrayLiteral) {
        this.decompiler.addToken(84);
        List<AstNode> elements = arrayLiteral.getElements();
        int size = elements.size();
        for (int i = 0; i < size; i++) {
            decompile(elements.get(i));
            if (i < size - 1) {
                this.decompiler.addToken(90);
            }
        }
        this.decompiler.addToken(85);
    }

    void decompileElementGet(ElementGet elementGet) {
        decompile(elementGet.getTarget());
        this.decompiler.addToken(84);
        decompile(elementGet.getElement());
        this.decompiler.addToken(85);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    external.sdk.pendo.io.mozilla.javascript.Node decompileFunctionHeader(external.sdk.pendo.io.mozilla.javascript.ast.FunctionNode r9) {
        /*
            r8 = this;
            external.sdk.pendo.io.mozilla.javascript.ast.Name r0 = r9.getFunctionName()
            if (r0 == 0) goto L10
            external.sdk.pendo.io.mozilla.javascript.Decompiler r0 = r8.decompiler
            java.lang.String r1 = r9.getName()
            r0.addName(r1)
            goto L1f
        L10:
            external.sdk.pendo.io.mozilla.javascript.ast.AstNode r0 = r9.getMemberExprNode()
            if (r0 == 0) goto L1f
            external.sdk.pendo.io.mozilla.javascript.ast.AstNode r0 = r9.getMemberExprNode()
            external.sdk.pendo.io.mozilla.javascript.Node r0 = r8.transform(r0)
            goto L20
        L1f:
            r0 = 0
        L20:
            int r1 = r9.getFunctionType()
            r2 = 4
            r3 = 0
            r4 = 1
            if (r1 != r2) goto L2b
            r1 = r4
            goto L2c
        L2b:
            r1 = r3
        L2c:
            if (r1 == 0) goto L37
            int r2 = r9.getLp()
            r5 = -1
            if (r2 != r5) goto L37
            r2 = r4
            goto L38
        L37:
            r2 = r3
        L38:
            if (r2 != 0) goto L41
            external.sdk.pendo.io.mozilla.javascript.Decompiler r5 = r8.decompiler
            r6 = 88
            r5.addToken(r6)
        L41:
            java.util.List r5 = r9.getParams()
        L45:
            int r6 = r5.size()
            if (r3 >= r6) goto L65
            java.lang.Object r6 = r5.get(r3)
            external.sdk.pendo.io.mozilla.javascript.ast.AstNode r6 = (external.sdk.pendo.io.mozilla.javascript.ast.AstNode) r6
            r8.decompile(r6)
            int r6 = r5.size()
            int r6 = r6 - r4
            if (r3 >= r6) goto L62
            external.sdk.pendo.io.mozilla.javascript.Decompiler r6 = r8.decompiler
            r7 = 90
            r6.addToken(r7)
        L62:
            int r3 = r3 + 1
            goto L45
        L65:
            if (r2 != 0) goto L6e
            external.sdk.pendo.io.mozilla.javascript.Decompiler r2 = r8.decompiler
            r3 = 89
            r2.addToken(r3)
        L6e:
            if (r1 == 0) goto L77
            external.sdk.pendo.io.mozilla.javascript.Decompiler r1 = r8.decompiler
            r2 = 165(0xa5, float:2.31E-43)
            r1.addToken(r2)
        L77:
            boolean r9 = r9.isExpressionClosure()
            if (r9 != 0) goto L84
            external.sdk.pendo.io.mozilla.javascript.Decompiler r9 = r8.decompiler
            r1 = 86
            r9.addEOL(r1)
        L84:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.IRFactory.decompileFunctionHeader(external.sdk.pendo.io.mozilla.javascript.ast.FunctionNode):external.sdk.pendo.io.mozilla.javascript.Node");
    }

    void decompileObjectLiteral(ObjectLiteral objectLiteral) {
        this.decompiler.addToken(86);
        List<ObjectProperty> elements = objectLiteral.getElements();
        int size = elements.size();
        for (int i = 0; i < size; i++) {
            ObjectProperty objectProperty = elements.get(i);
            boolean equals = Boolean.TRUE.equals(objectProperty.getProp(26));
            decompile(objectProperty.getLeft());
            if (!equals) {
                this.decompiler.addToken(104);
                decompile(objectProperty.getRight());
            }
            if (i < size - 1) {
                this.decompiler.addToken(90);
            }
        }
        this.decompiler.addToken(87);
    }

    void decompilePropertyGet(PropertyGet propertyGet) {
        decompile(propertyGet.getTarget());
        this.decompiler.addToken(109);
        decompile(propertyGet.getProperty());
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean isDestructuring(Node node) {
        return (node instanceof DestructuringForm) && ((DestructuringForm) node).isDestructuring();
    }

    public Node transform(AstNode astNode) {
        int type = astNode.getType();
        if (type == 66) {
            return transformArrayLiteral((ArrayLiteral) astNode);
        }
        if (type == 67) {
            return transformObjectLiteral((ObjectLiteral) astNode);
        }
        if (type == 129) {
            return astNode;
        }
        if (type == 130) {
            return transformBlock(astNode);
        }
        switch (type) {
            case 4:
                return transformReturn((ReturnStatement) astNode);
            case 30:
                return transformNewExpr((NewExpression) astNode);
            case 33:
                return transformPropertyGet((PropertyGet) astNode);
            case 36:
                return transformElementGet((ElementGet) astNode);
            case 48:
                return transformRegExp((RegExpLiteral) astNode);
            case 50:
                return transformThrow((ThrowStatement) astNode);
            case 73:
            case Token.YIELD_STAR /* 166 */:
                return transformYield((Yield) astNode);
            case 82:
                return transformTry((TryStatement) astNode);
            case 103:
                return transformCondExpr((ConditionalExpression) astNode);
            case 110:
                return transformFunction((FunctionNode) astNode);
            case 113:
                return transformIf((IfStatement) astNode);
            case 115:
                return transformSwitch((SwitchStatement) astNode);
            case 124:
                return transformWith((WithStatement) astNode);
            case 137:
                return transformScript((ScriptNode) astNode);
            case 158:
                return transformArrayComp((ArrayComprehension) astNode);
            case Token.DEBUGGER /* 161 */:
                break;
            case Token.GENEXPR /* 163 */:
                return transformGenExpr((GeneratorExpression) astNode);
            default:
                switch (type) {
                    case 38:
                        return transformFunctionCall((FunctionCall) astNode);
                    case 39:
                        return transformName((Name) astNode);
                    case 40:
                        return transformNumber((NumberLiteral) astNode);
                    case 41:
                        return transformString((StringLiteral) astNode);
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                        break;
                    default:
                        switch (type) {
                            case 118:
                                return transformWhileLoop((WhileLoop) astNode);
                            case 119:
                                return transformDoLoop((DoLoop) astNode);
                            case 120:
                                return astNode instanceof ForInLoop ? transformForInLoop((ForInLoop) astNode) : transformForLoop((ForLoop) astNode);
                            case 121:
                                return transformBreak((BreakStatement) astNode);
                            case 122:
                                return transformContinue((ContinueStatement) astNode);
                            default:
                                if (astNode instanceof ExpressionStatement) {
                                    return transformExprStmt((ExpressionStatement) astNode);
                                }
                                if (astNode instanceof Assignment) {
                                    return transformAssignment((Assignment) astNode);
                                }
                                if (astNode instanceof UnaryExpression) {
                                    return transformUnary((UnaryExpression) astNode);
                                }
                                if (astNode instanceof XmlMemberGet) {
                                    return transformXmlMemberGet((XmlMemberGet) astNode);
                                }
                                if (astNode instanceof InfixExpression) {
                                    return transformInfix((InfixExpression) astNode);
                                }
                                if (astNode instanceof VariableDeclaration) {
                                    return transformVariables((VariableDeclaration) astNode);
                                }
                                if (astNode instanceof ParenthesizedExpression) {
                                    return transformParenExpr((ParenthesizedExpression) astNode);
                                }
                                if (astNode instanceof LabeledStatement) {
                                    return transformLabeledStatement((LabeledStatement) astNode);
                                }
                                if (astNode instanceof LetNode) {
                                    return transformLetNode((LetNode) astNode);
                                }
                                if (astNode instanceof XmlRef) {
                                    return transformXmlRef((XmlRef) astNode);
                                }
                                if (astNode instanceof XmlLiteral) {
                                    return transformXmlLiteral((XmlLiteral) astNode);
                                }
                                throw new IllegalArgumentException("Can't transform: " + astNode);
                        }
                }
        }
        return transformLiteral(astNode);
    }

    public ScriptNode transformTree(AstRoot astRoot) {
        this.currentScriptOrFn = astRoot;
        this.inUseStrictDirective = astRoot.isInStrictMode();
        int currentOffset = this.decompiler.getCurrentOffset();
        ScriptNode scriptNode = (ScriptNode) transform(astRoot);
        scriptNode.setEncodedSourceBounds(currentOffset, this.decompiler.getCurrentOffset());
        if (this.compilerEnv.isGeneratingSource()) {
            scriptNode.setEncodedSource(this.decompiler.getEncodedSource());
        }
        this.decompiler = null;
        return scriptNode;
    }

    public IRFactory(CompilerEnvirons compilerEnvirons) {
        this(compilerEnvirons, compilerEnvirons.getErrorReporter());
    }

    private Node transformXmlRef(XmlRef xmlRef) {
        return transformXmlRef(null, xmlRef, xmlRef.isAttributeAccess() ? 2 : 0);
    }

    public IRFactory(CompilerEnvirons compilerEnvirons, ErrorReporter errorReporter) {
        super(compilerEnvirons, errorReporter);
        this.decompiler = new Decompiler();
    }
}
