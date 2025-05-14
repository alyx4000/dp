package external.sdk.pendo.io.mozilla.javascript.ast;

/* loaded from: classes2.dex */
public class EmptyStatement extends AstNode {
    public EmptyStatement() {
        this.type = 129;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i)).append(";\n");
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    public EmptyStatement(int i) {
        super(i);
        this.type = 129;
    }

    public EmptyStatement(int i, int i2) {
        super(i, i2);
        this.type = 129;
    }
}
