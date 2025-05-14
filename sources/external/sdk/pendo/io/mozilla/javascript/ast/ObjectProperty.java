package external.sdk.pendo.io.mozilla.javascript.ast;

import external.sdk.pendo.io.mozilla.javascript.Token;

/* loaded from: classes2.dex */
public class ObjectProperty extends InfixExpression {
    public ObjectProperty() {
        this.type = 104;
    }

    public boolean isGetterMethod() {
        return this.type == 152;
    }

    public boolean isMethod() {
        return isGetterMethod() || isSetterMethod() || isNormalMethod();
    }

    public boolean isNormalMethod() {
        return this.type == 164;
    }

    public boolean isSetterMethod() {
        return this.type == 153;
    }

    public void setIsGetterMethod() {
        this.type = 152;
    }

    public void setIsNormalMethod() {
        this.type = Token.METHOD;
    }

    public void setIsSetterMethod() {
        this.type = 153;
    }

    public void setNodeType(int i) {
        if (i != 104 && i != 152 && i != 153 && i != 164) {
            throw new IllegalArgumentException("invalid node type: " + i);
        }
        setType(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0030  */
    @Override // external.sdk.pendo.io.mozilla.javascript.ast.InfixExpression, external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toSource(int r7) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "\n"
            r0.<init>(r1)
            int r1 = r7 + 1
            java.lang.String r2 = r6.makeIndent(r1)
            r0.append(r2)
            boolean r2 = r6.isGetterMethod()
            if (r2 == 0) goto L1c
            java.lang.String r2 = "get "
        L18:
            r0.append(r2)
            goto L25
        L1c:
            boolean r2 = r6.isSetterMethod()
            if (r2 == 0) goto L25
            java.lang.String r2 = "set "
            goto L18
        L25:
            external.sdk.pendo.io.mozilla.javascript.ast.AstNode r2 = r6.left
            int r3 = r6.getType()
            r4 = 0
            r5 = 104(0x68, float:1.46E-43)
            if (r3 != r5) goto L31
            r7 = r4
        L31:
            java.lang.String r7 = r2.toSource(r7)
            r0.append(r7)
            int r7 = r6.type
            if (r7 != r5) goto L41
            java.lang.String r7 = ": "
            r0.append(r7)
        L41:
            external.sdk.pendo.io.mozilla.javascript.ast.AstNode r7 = r6.right
            int r2 = r6.getType()
            if (r2 != r5) goto L4a
            r1 = r4
        L4a:
            java.lang.String r7 = r7.toSource(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.ast.ObjectProperty.toSource(int):java.lang.String");
    }

    public ObjectProperty(int i) {
        super(i);
        this.type = 104;
    }

    public ObjectProperty(int i, int i2) {
        super(i, i2);
        this.type = 104;
    }
}
