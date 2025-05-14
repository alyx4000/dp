package external.sdk.pendo.io.mozilla.javascript;

import external.sdk.pendo.io.mozilla.javascript.ast.FunctionNode;
import external.sdk.pendo.io.mozilla.javascript.ast.ScriptNode;

/* loaded from: classes2.dex */
public class NodeTransformer {
    private boolean hasFinally;
    private ObjArray loopEnds;
    private ObjArray loops;

    private static Node addBeforeCurrent(Node node, Node node2, Node node3, Node node4) {
        if (node2 == null) {
            if (node3 != node.getFirstChild()) {
                Kit.codeBug();
            }
            node.addChildToFront(node4);
        } else {
            if (node3 != node2.getNext()) {
                Kit.codeBug();
            }
            node.addChildAfter(node4, node2);
        }
        return node4;
    }

    private static Node replaceCurrent(Node node, Node node2, Node node3, Node node4) {
        if (node2 == null) {
            if (node3 != node.getFirstChild()) {
                Kit.codeBug();
            }
        } else if (node2.next == node3) {
            node.replaceChildAfter(node2, node4);
            return node4;
        }
        node.replaceChild(node3, node4);
        return node4;
    }

    private void transformCompilationUnit(ScriptNode scriptNode, boolean z) {
        this.loops = new ObjArray();
        this.loopEnds = new ObjArray();
        this.hasFinally = false;
        boolean z2 = scriptNode.getType() != 110 || ((FunctionNode) scriptNode).requiresActivation();
        scriptNode.flattenSymbolTable(!z2);
        transformCompilationUnit_r(scriptNode, scriptNode, scriptNode, z2, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x016c  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r13v7, types: [external.sdk.pendo.io.mozilla.javascript.ast.Scope] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void transformCompilationUnit_r(external.sdk.pendo.io.mozilla.javascript.ast.ScriptNode r19, external.sdk.pendo.io.mozilla.javascript.Node r20, external.sdk.pendo.io.mozilla.javascript.ast.Scope r21, boolean r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 970
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NodeTransformer.transformCompilationUnit_r(external.sdk.pendo.io.mozilla.javascript.ast.ScriptNode, external.sdk.pendo.io.mozilla.javascript.Node, external.sdk.pendo.io.mozilla.javascript.ast.Scope, boolean, boolean):void");
    }

    public final void transform(ScriptNode scriptNode, CompilerEnvirons compilerEnvirons) {
        transform(scriptNode, false, compilerEnvirons);
    }

    protected void visitCall(Node node, ScriptNode scriptNode) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x01b0, code lost:
    
        if ((r4 instanceof external.sdk.pendo.io.mozilla.javascript.ast.Scope) != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01c8, code lost:
    
        r4 = (external.sdk.pendo.io.mozilla.javascript.ast.Scope) r4;
        r1 = r4.getParentScope();
        r2 = (external.sdk.pendo.io.mozilla.javascript.ast.Scope) r21;
        r4.setParentScope(r2);
        r2.setParentScope(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01c6, code lost:
    
        if ((r4 instanceof external.sdk.pendo.io.mozilla.javascript.ast.Scope) != false) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected external.sdk.pendo.io.mozilla.javascript.Node visitLet(boolean r18, external.sdk.pendo.io.mozilla.javascript.Node r19, external.sdk.pendo.io.mozilla.javascript.Node r20, external.sdk.pendo.io.mozilla.javascript.Node r21) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NodeTransformer.visitLet(boolean, external.sdk.pendo.io.mozilla.javascript.Node, external.sdk.pendo.io.mozilla.javascript.Node, external.sdk.pendo.io.mozilla.javascript.Node):external.sdk.pendo.io.mozilla.javascript.Node");
    }

    protected void visitNew(Node node, ScriptNode scriptNode) {
    }

    public final void transform(ScriptNode scriptNode, boolean z, CompilerEnvirons compilerEnvirons) {
        if (compilerEnvirons.getLanguageVersion() >= 200 && scriptNode.isInStrictMode()) {
            z = true;
        }
        transformCompilationUnit(scriptNode, z);
        for (int i = 0; i != scriptNode.getFunctionCount(); i++) {
            transform(scriptNode.getFunctionNode(i), z, compilerEnvirons);
        }
    }
}
