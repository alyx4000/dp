package sdk.pendo.io.w3;

import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.d0;
import sdk.pendo.io.m3.h;
import sdk.pendo.io.m3.j0;
import sdk.pendo.io.m3.t;
import sdk.pendo.io.m3.v;
import sdk.pendo.io.m3.w;
import sdk.pendo.io.m3.w1;

/* loaded from: classes4.dex */
public class d extends t {
    v f;
    w s;

    private d(d0 d0Var) {
        this.f = (v) d0Var.a(0);
        this.s = (w) d0Var.a(1);
    }

    public static d a(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(d0.a(obj));
        }
        return null;
    }

    @Override // sdk.pendo.io.m3.t, sdk.pendo.io.m3.g
    public a0 b() {
        h hVar = new h(2);
        hVar.a(this.f);
        hVar.a(this.s);
        return new w1(hVar);
    }

    public static d a(j0 j0Var, boolean z) {
        return a(d0.a(j0Var, z));
    }
}
