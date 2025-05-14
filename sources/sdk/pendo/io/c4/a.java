package sdk.pendo.io.c4;

import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.d0;
import sdk.pendo.io.m3.g;
import sdk.pendo.io.m3.h;
import sdk.pendo.io.m3.t;
import sdk.pendo.io.m3.v;
import sdk.pendo.io.m3.w1;

/* loaded from: classes6.dex */
public class a extends t {
    private v f;
    private g s;

    private a(d0 d0Var) {
        this.f = (v) d0Var.a(0);
        this.s = d0Var.a(1);
    }

    public static a a(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(d0.a(obj));
        }
        throw new IllegalArgumentException("null value in getInstance()");
    }

    @Override // sdk.pendo.io.m3.t, sdk.pendo.io.m3.g
    public a0 b() {
        h hVar = new h(2);
        hVar.a(this.f);
        hVar.a(this.s);
        return new w1(hVar);
    }

    public v h() {
        return this.f;
    }

    public g i() {
        return this.s;
    }
}
