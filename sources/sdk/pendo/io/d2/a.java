package sdk.pendo.io.d2;

import sdk.pendo.io.f2.k;

/* loaded from: classes6.dex */
public class a {
    public static int c;

    /* renamed from: a, reason: collision with root package name */
    private int f982a;
    private d b;

    static {
        c = System.getProperty("JSON_SMART_SIMPLE") != null ? 4032 : -1;
    }

    public a(int i) {
        this.f982a = i;
    }

    private d a() {
        if (this.b == null) {
            this.b = new d(this.f982a);
        }
        return this.b;
    }

    public Object a(String str) {
        return a().b(str);
    }

    public <T> T a(String str, k<T> kVar) {
        return (T) a().a(str, kVar);
    }
}
