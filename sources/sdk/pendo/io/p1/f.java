package sdk.pendo.io.p1;

/* loaded from: classes6.dex */
public enum f {
    AND("&&"),
    NOT("!"),
    OR("||");

    private final String operatorString;

    f(String str) {
        this.operatorString = str;
    }

    public String b() {
        return this.operatorString;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.operatorString;
    }
}
