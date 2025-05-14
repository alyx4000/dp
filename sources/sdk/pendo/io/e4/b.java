package sdk.pendo.io.e4;

import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.d0;
import sdk.pendo.io.m3.t;

/* loaded from: classes6.dex */
public class b extends t {
    a A;
    d0 f;
    sdk.pendo.io.m3.c f0;
    h s;

    private b(d0 d0Var) {
        this.f = d0Var;
        if (d0Var.size() != 3) {
            throw new IllegalArgumentException("sequence wrong size for a certificate");
        }
        this.s = h.a(d0Var.a(0));
        this.A = a.a(d0Var.a(1));
        this.f0 = sdk.pendo.io.m3.c.a(d0Var.a(2));
    }

    public static b a(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(d0.a(obj));
        }
        return null;
    }

    @Override // sdk.pendo.io.m3.t, sdk.pendo.io.m3.g
    public a0 b() {
        return this.f;
    }

    public sdk.pendo.io.c4.c h() {
        return this.s.j();
    }

    public h i() {
        return this.s;
    }
}
