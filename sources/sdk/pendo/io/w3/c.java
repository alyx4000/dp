package sdk.pendo.io.w3;

import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.f;
import sdk.pendo.io.m3.g;
import sdk.pendo.io.m3.j0;
import sdk.pendo.io.m3.s1;
import sdk.pendo.io.m3.t;
import sdk.pendo.io.m3.w;
import sdk.pendo.io.m3.z1;

/* loaded from: classes4.dex */
public class c extends t implements f {
    private g f;

    public c(sdk.pendo.io.c4.c cVar) {
        this.f = cVar;
    }

    public static c a(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj instanceof s1) {
            return new c((s1) obj);
        }
        if (!(obj instanceof j0)) {
            return new c(sdk.pendo.io.c4.c.a(obj));
        }
        j0 j0Var = (j0) obj;
        return j0Var.n() == 1 ? new c(sdk.pendo.io.c4.c.a(j0Var, true)) : new c(w.a(j0Var, true));
    }

    @Override // sdk.pendo.io.m3.t, sdk.pendo.io.m3.g
    public a0 b() {
        g gVar = this.f;
        return gVar instanceof w ? new z1(true, 2, gVar) : new z1(true, 1, gVar);
    }

    public c(w wVar) {
        this.f = wVar;
    }
}
