package external.sdk.pendo.io.mozilla.javascript.ast;

/* loaded from: classes2.dex */
public class ForInLoop extends Loop {
    protected int eachPosition;
    protected int inPosition;
    protected boolean isForEach;
    protected boolean isForOf;
    protected AstNode iteratedObject;
    protected AstNode iterator;

    public ForInLoop() {
        this.inPosition = -1;
        this.eachPosition = -1;
        this.type = 120;
    }

    public int getEachPosition() {
        return this.eachPosition;
    }

    public int getInPosition() {
        return this.inPosition;
    }

    public AstNode getIteratedObject() {
        return this.iteratedObject;
    }

    public AstNode getIterator() {
        return this.iterator;
    }

    public boolean isForEach() {
        return this.isForEach;
    }

    public boolean isForOf() {
        return this.isForOf;
    }

    public void setEachPosition(int i) {
        this.eachPosition = i;
    }

    public void setInPosition(int i) {
        this.inPosition = i;
    }

    public void setIsForEach(boolean z) {
        this.isForEach = z;
    }

    public void setIsForOf(boolean z) {
        this.isForOf = z;
    }

    public void setIteratedObject(AstNode astNode) {
        assertNotNull(astNode);
        this.iteratedObject = astNode;
        astNode.setParent(this);
    }

    public void setIterator(AstNode astNode) {
        assertNotNull(astNode);
        this.iterator = astNode;
        astNode.setParent(this);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.Scope, external.sdk.pendo.io.mozilla.javascript.ast.Jump, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append("for ");
        if (isForEach()) {
            sb.append("each ");
        }
        sb.append("(");
        sb.append(this.iterator.toSource(0));
        sb.append(this.isForOf ? " of " : " in ");
        sb.append(this.iteratedObject.toSource(0));
        sb.append(") ");
        if (this.body.getType() == 130) {
            sb.append(this.body.toSource(i).trim()).append("\n");
        } else {
            sb.append("\n").append(this.body.toSource(i + 1));
        }
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.Scope, external.sdk.pendo.io.mozilla.javascript.ast.Jump, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.iterator.visit(nodeVisitor);
            this.iteratedObject.visit(nodeVisitor);
            this.body.visit(nodeVisitor);
        }
    }

    public ForInLoop(int i) {
        super(i);
        this.inPosition = -1;
        this.eachPosition = -1;
        this.type = 120;
    }

    public ForInLoop(int i, int i2) {
        super(i, i2);
        this.inPosition = -1;
        this.eachPosition = -1;
        this.type = 120;
    }
}
