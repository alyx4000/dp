package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class OperatorCodeT {
    private byte deprecatedBuiltinCode = 0;
    private String customCode = null;
    private int version = 1;
    private int builtinCode = 0;

    public byte getDeprecatedBuiltinCode() {
        return this.deprecatedBuiltinCode;
    }

    public void setDeprecatedBuiltinCode(byte b) {
        this.deprecatedBuiltinCode = b;
    }

    public String getCustomCode() {
        return this.customCode;
    }

    public void setCustomCode(String str) {
        this.customCode = str;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public int getBuiltinCode() {
        return this.builtinCode;
    }

    public void setBuiltinCode(int i) {
        this.builtinCode = i;
    }
}
