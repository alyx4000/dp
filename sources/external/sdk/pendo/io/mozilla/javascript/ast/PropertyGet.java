package external.sdk.pendo.io.mozilla.javascript.ast;

/* loaded from: classes2.dex */
public class PropertyGet extends InfixExpression {
    public PropertyGet() {
        this.type = 33;
    }

    public Name getProperty() {
        return (Name) getRight();
    }

    public AstNode getTarget() {
        return getLeft();
    }

    public void setProperty(Name name) {
        setRight(name);
    }

    public void setTarget(AstNode astNode) {
        setLeft(astNode);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.InfixExpression, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i) + getLeft().toSource(0) + "." + getRight().toSource(0);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.InfixExpression, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            getTarget().visit(nodeVisitor);
            getProperty().visit(nodeVisitor);
        }
    }

    public PropertyGet(int i) {
        super(i);
        this.type = 33;
    }

    public PropertyGet(int i, int i2) {
        super(i, i2);
        this.type = 33;
    }

    public PropertyGet(int i, int i2, AstNode astNode, Name name) {
        super(i, i2, astNode, name);
        this.type = 33;
    }

    public PropertyGet(AstNode astNode, Name name) {
        super(astNode, name);
        this.type = 33;
    }

    public PropertyGet(AstNode astNode, Name name, int i) {
        super(33, astNode, name, i);
        this.type = 33;
    }
}
