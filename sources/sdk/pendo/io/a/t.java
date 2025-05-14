package sdk.pendo.io.a;

/* loaded from: classes6.dex */
public final class t extends IndexOutOfBoundsException {
    private final String A;
    private final String f;
    private final int f0;
    private final String s;

    public t(String str, String str2, String str3, int i) {
        super("Method too large: " + str + "." + str2 + " " + str3);
        this.f = str;
        this.s = str2;
        this.A = str3;
        this.f0 = i;
    }
}
