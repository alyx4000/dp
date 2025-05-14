package external.sdk.pendo.io.mozilla.javascript.tools.idswitch;

/* loaded from: classes2.dex */
public class IdValuePair {
    public final String id;
    public final int idLength;
    private int lineNumber;
    public final String value;

    public IdValuePair(String str, String str2) {
        this.idLength = str.length();
        this.id = str;
        this.value = str2;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(int i) {
        this.lineNumber = i;
    }
}
