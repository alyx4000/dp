package sdk.pendo.io.i7;

/* loaded from: classes6.dex */
public enum b {
    ERROR(40, "ERROR"),
    WARN(30, "WARN"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, "TRACE");

    private int levelInt;
    private String levelStr;

    b(int i, String str) {
        this.levelInt = i;
        this.levelStr = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.levelStr;
    }
}
