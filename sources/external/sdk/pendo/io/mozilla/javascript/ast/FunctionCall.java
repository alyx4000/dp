package external.sdk.pendo.io.mozilla.javascript.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class FunctionCall extends AstNode {
    protected static final List<AstNode> NO_ARGS = Collections.unmodifiableList(new ArrayList());
    protected List<AstNode> arguments;
    protected int lp;
    protected int rp;
    protected AstNode target;

    public FunctionCall() {
        this.lp = -1;
        this.rp = -1;
        this.type = 38;
    }

    public void addArgument(AstNode astNode) {
        assertNotNull(astNode);
        if (this.arguments == null) {
            this.arguments = new ArrayList();
        }
        this.arguments.add(astNode);
        astNode.setParent(this);
    }

    public List<AstNode> getArguments() {
        List<AstNode> list = this.arguments;
        return list != null ? list : NO_ARGS;
    }

    public int getLp() {
        return this.lp;
    }

    public int getRp() {
        return this.rp;
    }

    public AstNode getTarget() {
        return this.target;
    }

    public void setArguments(List<AstNode> list) {
        if (list == null) {
            this.arguments = null;
            return;
        }
        List<AstNode> list2 = this.arguments;
        if (list2 != null) {
            list2.clear();
        }
        Iterator<AstNode> it = list.iterator();
        while (it.hasNext()) {
            addArgument(it.next());
        }
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

    public void setTarget(AstNode astNode) {
        assertNotNull(astNode);
        this.target = astNode;
        astNode.setParent(this);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append(this.target.toSource(0));
        sb.append("(");
        List<AstNode> list = this.arguments;
        if (list != null) {
            printList(list, sb);
        }
        sb.append(")");
        if (getInlineComment() != null) {
            sb.append(getInlineComment().toSource(i)).append("\n");
        }
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.target.visit(nodeVisitor);
            Iterator<AstNode> it = getArguments().iterator();
            while (it.hasNext()) {
                it.next().visit(nodeVisitor);
            }
        }
    }

    public FunctionCall(int i) {
        super(i);
        this.lp = -1;
        this.rp = -1;
        this.type = 38;
    }

    public FunctionCall(int i, int i2) {
        super(i, i2);
        this.lp = -1;
        this.rp = -1;
        this.type = 38;
    }
}
