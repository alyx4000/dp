package sdk.pendo.io.o8;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private long f1477a;
    private String b;
    private String c;
    private String d;

    public a(long j, String str, String str2) {
        this.d = str2;
        this.b = str;
        this.f1477a = j;
    }

    public final String toString() {
        return "[Timestamp: " + Long.toString(this.f1477a) + ", Logging Level: " + this.d + ", Message: " + this.b + ", " + (this.c != null ? "Exception: " + this.c + ", " : "") + "]";
    }

    public a(long j, String str, String str2, String str3) {
        this.d = str3;
        this.b = str;
        this.f1477a = j;
        this.c = str2;
    }
}
