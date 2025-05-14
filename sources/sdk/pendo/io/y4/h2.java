package sdk.pendo.io.y4;

/* loaded from: classes4.dex */
public class h2 extends f2 {
    protected short s;

    public h2(short s) {
        this(s, (String) null);
    }

    public short a() {
        return this.s;
    }

    public h2(short s, String str) {
        this(s, str, null);
    }

    private static String a(short s, String str) {
        String b = g.b(s);
        return str != null ? b + "; " + str : b;
    }

    public h2(short s, String str, Throwable th) {
        super(a(s, str), th);
        this.s = s;
    }

    public h2(short s, Throwable th) {
        this(s, null, th);
    }
}
