package sdk.pendo.io.a;

/* loaded from: classes6.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private final int f828a;
    private final String b;
    private final String c;
    private final String d;
    private final boolean e;

    public q(int i, String str, String str2, String str3, boolean z) {
        this.f828a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = z;
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.f828a;
    }

    public boolean e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f828a == qVar.f828a && this.e == qVar.e && this.b.equals(qVar.b) && this.c.equals(qVar.c) && this.d.equals(qVar.d);
    }

    public int hashCode() {
        return this.f828a + (this.e ? 64 : 0) + (this.b.hashCode() * this.c.hashCode() * this.d.hashCode());
    }

    public String toString() {
        return this.b + '.' + this.c + this.d + " (" + this.f828a + (this.e ? " itf" : "") + ')';
    }
}
