package external.sdk.pendo.io.mozilla.javascript.ast;

import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;

/* loaded from: classes2.dex */
public class StringLiteral extends AstNode {
    private char quoteChar;
    private String value;

    public StringLiteral() {
        this.type = 41;
    }

    public char getQuoteCharacter() {
        return this.quoteChar;
    }

    public String getValue() {
        return this.value;
    }

    public void setQuoteCharacter(char c) {
        this.quoteChar = c;
    }

    public void setValue(String str) {
        assertNotNull(str);
        this.value = str;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i) + this.quoteChar + ScriptRuntime.escapeString(this.value, this.quoteChar) + this.quoteChar;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    public StringLiteral(int i) {
        super(i);
        this.type = 41;
    }

    public String getValue(boolean z) {
        return !z ? this.value : this.quoteChar + this.value + this.quoteChar;
    }

    public StringLiteral(int i, int i2) {
        super(i, i2);
        this.type = 41;
    }
}
