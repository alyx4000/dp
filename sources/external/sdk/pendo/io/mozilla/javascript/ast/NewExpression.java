package external.sdk.pendo.io.mozilla.javascript.ast;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class NewExpression extends FunctionCall {
    private ObjectLiteral initializer;

    public NewExpression() {
        this.type = 30;
    }

    public ObjectLiteral getInitializer() {
        return this.initializer;
    }

    public void setInitializer(ObjectLiteral objectLiteral) {
        this.initializer = objectLiteral;
        if (objectLiteral != null) {
            objectLiteral.setParent(this);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.FunctionCall, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append("new ");
        sb.append(this.target.toSource(0));
        sb.append("(");
        List<AstNode> list = this.arguments;
        if (list != null) {
            printList(list, sb);
        }
        sb.append(")");
        if (this.initializer != null) {
            sb.append(" ");
            sb.append(this.initializer.toSource(0));
        }
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.FunctionCall, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.target.visit(nodeVisitor);
            Iterator<AstNode> it = getArguments().iterator();
            while (it.hasNext()) {
                it.next().visit(nodeVisitor);
            }
            ObjectLiteral objectLiteral = this.initializer;
            if (objectLiteral != null) {
                objectLiteral.visit(nodeVisitor);
            }
        }
    }

    public NewExpression(int i) {
        super(i);
        this.type = 30;
    }

    public NewExpression(int i, int i2) {
        super(i, i2);
        this.type = 30;
    }
}
