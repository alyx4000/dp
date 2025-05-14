package external.sdk.pendo.io.mozilla.javascript.ast;

/* loaded from: classes2.dex */
public class XmlMemberGet extends InfixExpression {
    public XmlMemberGet() {
        this.type = 144;
    }

    private String dotsToString() {
        int type = getType();
        if (type == 109) {
            return ".";
        }
        if (type == 144) {
            return "..";
        }
        throw new IllegalArgumentException("Invalid type of XmlMemberGet: " + getType());
    }

    public XmlRef getMemberRef() {
        return (XmlRef) getRight();
    }

    public AstNode getTarget() {
        return getLeft();
    }

    public void setProperty(XmlRef xmlRef) {
        setRight(xmlRef);
    }

    public void setTarget(AstNode astNode) {
        setLeft(astNode);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.InfixExpression, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i) + getLeft().toSource(0) + dotsToString() + getRight().toSource(0);
    }

    public XmlMemberGet(int i) {
        super(i);
        this.type = 144;
    }

    public XmlMemberGet(int i, int i2) {
        super(i, i2);
        this.type = 144;
    }

    public XmlMemberGet(int i, int i2, AstNode astNode, XmlRef xmlRef) {
        super(i, i2, astNode, xmlRef);
        this.type = 144;
    }

    public XmlMemberGet(AstNode astNode, XmlRef xmlRef) {
        super(astNode, xmlRef);
        this.type = 144;
    }

    public XmlMemberGet(AstNode astNode, XmlRef xmlRef, int i) {
        super(144, astNode, xmlRef, i);
        this.type = 144;
    }
}
