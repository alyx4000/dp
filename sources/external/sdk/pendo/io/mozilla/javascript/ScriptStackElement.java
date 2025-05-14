package external.sdk.pendo.io.mozilla.javascript;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class ScriptStackElement implements Serializable {
    private static final long serialVersionUID = -6416688260860477449L;
    public final String fileName;
    public final String functionName;
    public final int lineNumber;

    public ScriptStackElement(String str, String str2, int i) {
        this.fileName = str;
        this.functionName = str2;
        this.lineNumber = i;
    }

    private void appendV8Location(StringBuilder sb) {
        sb.append(this.fileName).append(':');
        int i = this.lineNumber;
        if (i <= -1) {
            i = 0;
        }
        sb.append(i).append(":0");
    }

    public void renderJavaStyle(StringBuilder sb) {
        sb.append("\tat ").append(this.fileName);
        if (this.lineNumber > -1) {
            sb.append(':').append(this.lineNumber);
        }
        if (this.functionName != null) {
            sb.append(" (").append(this.functionName).append(')');
        }
    }

    public void renderMozillaStyle(StringBuilder sb) {
        String str = this.functionName;
        if (str != null) {
            sb.append(str).append("()");
        }
        sb.append('@').append(this.fileName);
        if (this.lineNumber > -1) {
            sb.append(':').append(this.lineNumber);
        }
    }

    public void renderV8Style(StringBuilder sb) {
        sb.append("    at ");
        String str = this.functionName;
        if (str == null || "anonymous".equals(str) || "undefined".equals(this.functionName)) {
            appendV8Location(sb);
            return;
        }
        sb.append(this.functionName).append(" (");
        appendV8Location(sb);
        sb.append(')');
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        renderMozillaStyle(sb);
        return sb.toString();
    }
}
