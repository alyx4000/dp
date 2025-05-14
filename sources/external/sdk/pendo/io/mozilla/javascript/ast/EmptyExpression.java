package external.sdk.pendo.io.mozilla.javascript.ast;

/* loaded from: classes2.dex */
public class EmptyExpression extends AstNode {
    public EmptyExpression() {
        this.type = 129;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    public EmptyExpression(int i) {
        super(i);
        this.type = 129;
    }

    public EmptyExpression(int i, int i2) {
        super(i, i2);
        this.type = 129;
    }
}
