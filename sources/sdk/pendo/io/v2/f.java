package sdk.pendo.io.v2;

/* loaded from: classes4.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    private String f1674a;
    private String b;
    private String c;
    private int d = -1;

    f(String str, String str2, String str3) {
        this.f1674a = str;
        this.b = str2;
        this.c = str3;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f1674a.equals(fVar.f1674a) && this.b.equals(fVar.b) && this.c.equals(fVar.c);
    }

    public int hashCode() {
        if (this.d == -1) {
            this.d = (this.f1674a.hashCode() ^ this.b.hashCode()) ^ this.c.hashCode();
        }
        return this.d;
    }
}
