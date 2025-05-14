package external.sdk.pendo.io.mozilla.javascript.ast;

import external.sdk.pendo.io.mozilla.javascript.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class FunctionNode extends ScriptNode {
    public static final int ARROW_FUNCTION = 4;
    public static final int FUNCTION_EXPRESSION = 2;
    public static final int FUNCTION_EXPRESSION_STATEMENT = 3;
    public static final int FUNCTION_STATEMENT = 1;
    private static final List<AstNode> NO_PARAMS = Collections.unmodifiableList(new ArrayList());
    private AstNode body;
    private Form functionForm;
    private Name functionName;
    private int functionType;
    private List<Node> generatorResumePoints;
    private boolean isES6Generator;
    private boolean isExpressionClosure;
    private boolean isGenerator;
    private Map<Node, int[]> liveLocals;
    private int lp;
    private AstNode memberExprNode;
    private boolean needsActivation;
    private List<AstNode> params;
    private int rp;

    public enum Form {
        FUNCTION,
        GETTER,
        SETTER,
        METHOD
    }

    public FunctionNode() {
        this.functionForm = Form.FUNCTION;
        this.lp = -1;
        this.rp = -1;
        this.type = 110;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.ScriptNode
    public int addFunction(FunctionNode functionNode) {
        int addFunction = super.addFunction(functionNode);
        if (getFunctionCount() > 0) {
            this.needsActivation = true;
        }
        return addFunction;
    }

    public void addLiveLocals(Node node, int[] iArr) {
        if (this.liveLocals == null) {
            this.liveLocals = new HashMap();
        }
        this.liveLocals.put(node, iArr);
    }

    public void addParam(AstNode astNode) {
        assertNotNull(astNode);
        if (this.params == null) {
            this.params = new ArrayList();
        }
        this.params.add(astNode);
        astNode.setParent(this);
    }

    public void addResumptionPoint(Node node) {
        if (this.generatorResumePoints == null) {
            this.generatorResumePoints = new ArrayList();
        }
        this.generatorResumePoints.add(node);
    }

    public AstNode getBody() {
        return this.body;
    }

    public Name getFunctionName() {
        return this.functionName;
    }

    public int getFunctionType() {
        return this.functionType;
    }

    public Map<Node, int[]> getLiveLocals() {
        return this.liveLocals;
    }

    public int getLp() {
        return this.lp;
    }

    public AstNode getMemberExprNode() {
        return this.memberExprNode;
    }

    public String getName() {
        Name name = this.functionName;
        return name != null ? name.getIdentifier() : "";
    }

    public List<AstNode> getParams() {
        List<AstNode> list = this.params;
        return list != null ? list : NO_PARAMS;
    }

    public List<Node> getResumptionPoints() {
        return this.generatorResumePoints;
    }

    public int getRp() {
        return this.rp;
    }

    public boolean isES6Generator() {
        return this.isES6Generator;
    }

    public boolean isExpressionClosure() {
        return this.isExpressionClosure;
    }

    public boolean isGenerator() {
        return this.isGenerator;
    }

    public boolean isGetterMethod() {
        return this.functionForm == Form.GETTER;
    }

    public boolean isMethod() {
        Form form = this.functionForm;
        return form == Form.GETTER || form == Form.SETTER || form == Form.METHOD;
    }

    public boolean isNormalMethod() {
        return this.functionForm == Form.METHOD;
    }

    public boolean isParam(AstNode astNode) {
        List<AstNode> list = this.params;
        if (list == null) {
            return false;
        }
        return list.contains(astNode);
    }

    public boolean isSetterMethod() {
        return this.functionForm == Form.SETTER;
    }

    public boolean requiresActivation() {
        return this.needsActivation;
    }

    public void setBody(AstNode astNode) {
        assertNotNull(astNode);
        this.body = astNode;
        if (Boolean.TRUE.equals(astNode.getProp(25))) {
            setIsExpressionClosure(true);
        }
        int position = astNode.getPosition() + astNode.getLength();
        astNode.setParent(this);
        setLength(position - this.position);
        setEncodedSourceBounds(this.position, position);
    }

    public void setFunctionIsGetterMethod() {
        this.functionForm = Form.GETTER;
    }

    public void setFunctionIsNormalMethod() {
        this.functionForm = Form.METHOD;
    }

    public void setFunctionIsSetterMethod() {
        this.functionForm = Form.SETTER;
    }

    public void setFunctionName(Name name) {
        this.functionName = name;
        if (name != null) {
            name.setParent(this);
        }
    }

    public void setFunctionType(int i) {
        this.functionType = i;
    }

    public void setIsES6Generator() {
        this.isES6Generator = true;
        this.isGenerator = true;
    }

    public void setIsExpressionClosure(boolean z) {
        this.isExpressionClosure = z;
    }

    public void setIsGenerator() {
        this.isGenerator = true;
    }

    public void setLp(int i) {
        this.lp = i;
    }

    public void setMemberExprNode(AstNode astNode) {
        this.memberExprNode = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
    }

    public void setParams(List<AstNode> list) {
        if (list == null) {
            this.params = null;
            return;
        }
        List<AstNode> list2 = this.params;
        if (list2 != null) {
            list2.clear();
        }
        Iterator<AstNode> it = list.iterator();
        while (it.hasNext()) {
            addParam(it.next());
        }
    }

    public void setParens(int i, int i2) {
        this.lp = i;
        this.rp = i2;
    }

    public void setRequiresActivation() {
        this.needsActivation = true;
    }

    public void setRp(int i) {
        this.rp = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0091  */
    @Override // external.sdk.pendo.io.mozilla.javascript.ast.Scope, external.sdk.pendo.io.mozilla.javascript.ast.Jump, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toSource(int r9) {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = r8.functionType
            r2 = 4
            r3 = 1
            r4 = 0
            if (r1 != r2) goto Le
            r1 = r3
            goto Lf
        Le:
            r1 = r4
        Lf:
            boolean r2 = r8.isMethod()
            if (r2 != 0) goto L23
            java.lang.String r2 = r8.makeIndent(r9)
            r0.append(r2)
            if (r1 != 0) goto L23
            java.lang.String r2 = "function"
            r0.append(r2)
        L23:
            external.sdk.pendo.io.mozilla.javascript.ast.Name r2 = r8.functionName
            java.lang.String r5 = " "
            if (r2 == 0) goto L35
            r0.append(r5)
            external.sdk.pendo.io.mozilla.javascript.ast.Name r2 = r8.functionName
            java.lang.String r2 = r2.toSource(r4)
            r0.append(r2)
        L35:
            java.util.List<external.sdk.pendo.io.mozilla.javascript.ast.AstNode> r2 = r8.params
            if (r2 != 0) goto L3f
            java.lang.String r2 = "() "
        L3b:
            r0.append(r2)
            goto L5a
        L3f:
            if (r1 == 0) goto L4d
            int r6 = r8.lp
            r7 = -1
            if (r6 != r7) goto L4d
            r8.printList(r2, r0)
            r0.append(r5)
            goto L5a
        L4d:
            java.lang.String r2 = "("
            r0.append(r2)
            java.util.List<external.sdk.pendo.io.mozilla.javascript.ast.AstNode> r2 = r8.params
            r8.printList(r2, r0)
            java.lang.String r2 = ") "
            goto L3b
        L5a:
            if (r1 == 0) goto L61
            java.lang.String r1 = "=> "
            r0.append(r1)
        L61:
            boolean r1 = r8.isExpressionClosure
            if (r1 == 0) goto L91
            external.sdk.pendo.io.mozilla.javascript.ast.AstNode r9 = r8.getBody()
            external.sdk.pendo.io.mozilla.javascript.Node r1 = r9.getLastChild()
            boolean r1 = r1 instanceof external.sdk.pendo.io.mozilla.javascript.ast.ReturnStatement
            if (r1 == 0) goto L89
            external.sdk.pendo.io.mozilla.javascript.Node r9 = r9.getLastChild()
            external.sdk.pendo.io.mozilla.javascript.ast.ReturnStatement r9 = (external.sdk.pendo.io.mozilla.javascript.ast.ReturnStatement) r9
            external.sdk.pendo.io.mozilla.javascript.ast.AstNode r9 = r9.getReturnValue()
            java.lang.String r9 = r9.toSource(r4)
            r0.append(r9)
            int r9 = r8.functionType
            if (r9 != r3) goto La0
            java.lang.String r9 = ";"
            goto L9d
        L89:
            r0.append(r5)
            java.lang.String r9 = r9.toSource(r4)
            goto L9d
        L91:
            external.sdk.pendo.io.mozilla.javascript.ast.AstNode r1 = r8.getBody()
            java.lang.String r9 = r1.toSource(r9)
            java.lang.String r9 = r9.trim()
        L9d:
            r0.append(r9)
        La0:
            int r9 = r8.functionType
            if (r9 == r3) goto Laa
            boolean r9 = r8.isMethod()
            if (r9 == 0) goto Laf
        Laa:
            java.lang.String r9 = "\n"
            r0.append(r9)
        Laf:
            java.lang.String r9 = r0.toString()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.ast.FunctionNode.toSource(int):java.lang.String");
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.ScriptNode, external.sdk.pendo.io.mozilla.javascript.ast.Scope, external.sdk.pendo.io.mozilla.javascript.ast.Jump, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        AstNode astNode;
        if (nodeVisitor.visit(this)) {
            Name name = this.functionName;
            if (name != null) {
                name.visit(nodeVisitor);
            }
            Iterator<AstNode> it = getParams().iterator();
            while (it.hasNext()) {
                it.next().visit(nodeVisitor);
            }
            getBody().visit(nodeVisitor);
            if (this.isExpressionClosure || (astNode = this.memberExprNode) == null) {
                return;
            }
            astNode.visit(nodeVisitor);
        }
    }

    public FunctionNode(int i) {
        super(i);
        this.functionForm = Form.FUNCTION;
        this.lp = -1;
        this.rp = -1;
        this.type = 110;
    }

    public FunctionNode(int i, Name name) {
        super(i);
        this.functionForm = Form.FUNCTION;
        this.lp = -1;
        this.rp = -1;
        this.type = 110;
        setFunctionName(name);
    }
}
