package sdk.pendo.io.w3;

import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.d0;
import sdk.pendo.io.m3.h;
import sdk.pendo.io.m3.j0;
import sdk.pendo.io.m3.t;
import sdk.pendo.io.m3.w1;
import sdk.pendo.io.m3.z1;

/* loaded from: classes4.dex */
public class a extends t {
    b f;
    d s;

    private a(d0 d0Var) {
        this.f = b.a(d0Var.a(0));
        if (d0Var.size() == 2) {
            this.s = d.a((j0) d0Var.a(1), true);
        }
    }

    public static a a(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(d0.a(obj));
        }
        return null;
    }

    @Override // sdk.pendo.io.m3.t, sdk.pendo.io.m3.g
    public a0 b() {
        h hVar = new h(2);
        hVar.a(this.f);
        d dVar = this.s;
        if (dVar != null) {
            hVar.a(new z1(true, 0, dVar));
        }
        return new w1(hVar);
    }
}
