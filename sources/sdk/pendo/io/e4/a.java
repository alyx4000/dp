package sdk.pendo.io.e4;

import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.d0;
import sdk.pendo.io.m3.j0;
import sdk.pendo.io.m3.t;
import sdk.pendo.io.m3.v;
import sdk.pendo.io.m3.w1;

/* loaded from: classes6.dex */
public class a extends t {
    private v f;
    private sdk.pendo.io.m3.g s;

    public a(v vVar) {
        this.f = vVar;
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
        sdk.pendo.io.m3.h hVar = new sdk.pendo.io.m3.h(2);
        hVar.a(this.f);
        sdk.pendo.io.m3.g gVar = this.s;
        if (gVar != null) {
            hVar.a(gVar);
        }
        return new w1(hVar);
    }

    public v h() {
        return this.f;
    }

    public sdk.pendo.io.m3.g i() {
        return this.s;
    }

    public a(v vVar, sdk.pendo.io.m3.g gVar) {
        this.f = vVar;
        this.s = gVar;
    }

    public static a a(j0 j0Var, boolean z) {
        return a(d0.a(j0Var, z));
    }

    private a(d0 d0Var) {
        if (d0Var.size() < 1 || d0Var.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + d0Var.size());
        }
        this.f = v.a(d0Var.a(0));
        this.s = d0Var.size() == 2 ? d0Var.a(1) : null;
    }
}
