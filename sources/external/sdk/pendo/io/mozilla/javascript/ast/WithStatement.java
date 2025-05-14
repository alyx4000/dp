package external.sdk.pendo.io.mozilla.javascript.ast;

/* loaded from: classes2.dex */
public class WithStatement extends AstNode {
    private AstNode expression;
    private int lp;
    private int rp;
    private AstNode statement;

    public WithStatement() {
        this.lp = -1;
        this.rp = -1;
        this.type = 124;
    }

    public AstNode getExpression() {
        return this.expression;
    }

    public int getLp() {
        return this.lp;
    }

    public int getRp() {
        return this.rp;
    }

    public AstNode getStatement() {
        return this.statement;
    }

    public void setExpression(AstNode astNode) {
        assertNotNull(astNode);
        this.expression = astNode;
        astNode.setParent(this);
    }

    public void setLp(int i) {
        this.lp = i;
    }

    public void setParens(int i, int i2) {
        this.lp = i;
        this.rp = i2;
    }

    public void setRp(int i) {
        this.rp = i;
    }

    public void setStatement(AstNode astNode) {
        assertNotNull(astNode);
        this.statement = astNode;
        astNode.setParent(this);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append("with (");
        sb.append(this.expression.toSource(0));
        sb.append(") ");
        if (getInlineComment() != null) {
            sb.append(getInlineComment().toSource(i + 1));
        }
        if (this.statement.getType() == 130) {
            if (getInlineComment() != null) {
                sb.append("\n");
            }
            sb.append(this.statement.toSource(i).trim());
            sb.append("\n");
        } else {
            sb.append("\n").append(this.statement.toSource(i + 1));
        }
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.expression.visit(nodeVisitor);
            this.statement.visit(nodeVisitor);
        }
    }

    public WithStatement(int i) {
        super(i);
        this.lp = -1;
        this.rp = -1;
        this.type = 124;
    }

    public WithStatement(int i, int i2) {
        super(i, i2);
        this.lp = -1;
        this.rp = -1;
        this.type = 124;
    }
}
