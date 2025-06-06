package external.sdk.pendo.io.mozilla.javascript;

/* loaded from: classes2.dex */
public class EvaluatorException extends RhinoException {
    private static final long serialVersionUID = -8743165779676009808L;

    public EvaluatorException(String str) {
        super(str);
    }

    @Deprecated
    public int getColumnNumber() {
        return columnNumber();
    }

    @Deprecated
    public int getLineNumber() {
        return lineNumber();
    }

    @Deprecated
    public String getLineSource() {
        return lineSource();
    }

    @Deprecated
    public String getSourceName() {
        return sourceName();
    }

    public EvaluatorException(String str, String str2, int i) {
        this(str, str2, i, null, 0);
    }

    public EvaluatorException(String str, String str2, int i, String str3, int i2) {
        super(str);
        recordErrorOrigin(str2, i, str3, i2);
    }
}
