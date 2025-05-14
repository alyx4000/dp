package external.sdk.pendo.io.mozilla.javascript.ast;

/* loaded from: classes2.dex */
public class Name extends AstNode {
    private String identifier;
    private Scope scope;

    public Name() {
        this.type = 39;
    }

    public Scope getDefiningScope() {
        Scope enclosingScope = getEnclosingScope();
        String identifier = getIdentifier();
        if (enclosingScope == null) {
            return null;
        }
        return enclosingScope.getDefiningScope(identifier);
    }

    public String getIdentifier() {
        return this.identifier;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Node
    public Scope getScope() {
        return this.scope;
    }

    public boolean isLocalName() {
        Scope definingScope = getDefiningScope();
        return (definingScope == null || definingScope.getParentScope() == null) ? false : true;
    }

    public int length() {
        String str = this.identifier;
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    public void setIdentifier(String str) {
        assertNotNull(str);
        this.identifier = str;
        setLength(str.length());
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Node
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder append = new StringBuilder().append(makeIndent(i));
        String str = this.identifier;
        if (str == null) {
            str = "<null>";
        }
        return append.append(str).toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    public Name(int i) {
        super(i);
        this.type = 39;
    }

    public Name(int i, int i2) {
        super(i, i2);
        this.type = 39;
    }

    public Name(int i, int i2, String str) {
        super(i, i2);
        this.type = 39;
        setIdentifier(str);
    }

    public Name(int i, String str) {
        super(i);
        this.type = 39;
        setIdentifier(str);
        setLength(str.length());
    }
}
