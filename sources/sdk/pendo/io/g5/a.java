package sdk.pendo.io.g5;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f1118a;
    private String b;

    public a(String str, String str2) {
        this.f1118a = str;
        this.b = str2;
    }

    private int a(String str) {
        if (str == null) {
            return 1;
        }
        return str.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return aVar == this || (a(this.f1118a, aVar.f1118a) && a(this.b, aVar.b));
    }

    public int hashCode() {
        return a(this.f1118a) + (a(this.b) * 31);
    }

    private boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }
}
