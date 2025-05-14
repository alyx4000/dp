package sdk.pendo.io.h1;

import java.util.LinkedHashMap;
import java.util.Map;
import sdk.pendo.io.d1.e;
import sdk.pendo.io.k1.g;
import sdk.pendo.io.k1.h;

/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    protected sdk.pendo.io.u0.b f1154a = new sdk.pendo.io.u0.b();
    private Map<String, Object> b = new LinkedHashMap();
    private String c;
    private String d;

    public String a() {
        if (this.d == null) {
            this.d = this.f1154a.c(b());
        }
        return this.d;
    }

    public String b() {
        if (this.c == null) {
            this.c = sdk.pendo.io.x0.a.a((Map<String, ?>) this.b);
        }
        return this.c;
    }

    public String c(String str) {
        return h.b(this.b, str);
    }

    void d(String str) {
        this.d = str;
        String b = this.f1154a.b(str);
        this.c = b;
        this.b = sdk.pendo.io.x0.a.a(b);
    }

    public Long a(String str) {
        return h.a(this.b, str);
    }

    public Object b(String str) {
        return this.b.get(str);
    }

    public e a(String str, String str2) {
        Map map = (Map) b(str);
        if (map == null) {
            return null;
        }
        e a2 = e.a.a((Map<String, Object>) map, str2);
        if (a2.i() == null) {
            return a2;
        }
        throw new g(str + " header contains a private key, which it most definitely should not.");
    }
}
