package sdk.pendo.io.e4;

import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.d0;
import sdk.pendo.io.m3.t;
import sdk.pendo.io.m3.v;
import sdk.pendo.io.m3.w;
import sdk.pendo.io.m3.w1;

/* loaded from: classes6.dex */
public class d extends t {
    private w A;
    private v f;
    private boolean s;
    public static final v f0 = new v("2.5.29.9").m();
    public static final v t0 = new v("2.5.29.14").m();
    public static final v u0 = new v("2.5.29.15").m();
    public static final v v0 = new v("2.5.29.16").m();
    public static final v w0 = new v("2.5.29.17").m();
    public static final v x0 = new v("2.5.29.18").m();
    public static final v y0 = new v("2.5.29.19").m();
    public static final v z0 = new v("2.5.29.20").m();
    public static final v A0 = new v("2.5.29.21").m();
    public static final v B0 = new v("2.5.29.23").m();
    public static final v C0 = new v("2.5.29.24").m();
    public static final v D0 = new v("2.5.29.27").m();
    public static final v E0 = new v("2.5.29.28").m();
    public static final v F0 = new v("2.5.29.29").m();
    public static final v G0 = new v("2.5.29.30").m();
    public static final v H0 = new v("2.5.29.31").m();
    public static final v I0 = new v("2.5.29.32").m();
    public static final v J0 = new v("2.5.29.33").m();
    public static final v K0 = new v("2.5.29.35").m();
    public static final v L0 = new v("2.5.29.36").m();
    public static final v M0 = new v("2.5.29.37").m();
    public static final v N0 = new v("2.5.29.46").m();
    public static final v O0 = new v("2.5.29.54").m();
    public static final v P0 = new v("1.3.6.1.5.5.7.1.1").m();
    public static final v Q0 = new v("1.3.6.1.5.5.7.1.11").m();
    public static final v R0 = new v("1.3.6.1.5.5.7.1.12").m();
    public static final v S0 = new v("1.3.6.1.5.5.7.1.2").m();
    public static final v T0 = new v("1.3.6.1.5.5.7.1.3").m();
    public static final v U0 = new v("1.3.6.1.5.5.7.1.4").m();
    public static final v V0 = new v("2.5.29.56").m();
    public static final v W0 = new v("2.5.29.55").m();
    public static final v X0 = new v("2.5.29.60").m();

    private d(d0 d0Var) {
        sdk.pendo.io.m3.g a2;
        if (d0Var.size() == 2) {
            this.f = v.a(d0Var.a(0));
            this.s = false;
            a2 = d0Var.a(1);
        } else {
            if (d0Var.size() != 3) {
                throw new IllegalArgumentException("Bad sequence size: " + d0Var.size());
            }
            this.f = v.a(d0Var.a(0));
            this.s = sdk.pendo.io.m3.e.a(d0Var.a(1)).k();
            a2 = d0Var.a(2);
        }
        this.A = w.a(a2);
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
        sdk.pendo.io.m3.h hVar = new sdk.pendo.io.m3.h(3);
        hVar.a(this.f);
        if (this.s) {
            hVar.a(sdk.pendo.io.m3.e.b(true));
        }
        hVar.a(this.A);
        return new w1(hVar);
    }

    @Override // sdk.pendo.io.m3.t
    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return dVar.h().b(h()) && dVar.i().b(i()) && dVar.j() == j();
    }

    public v h() {
        return this.f;
    }

    @Override // sdk.pendo.io.m3.t
    public int hashCode() {
        return j() ? i().hashCode() ^ h().hashCode() : ~(i().hashCode() ^ h().hashCode());
    }

    public w i() {
        return this.A;
    }

    public boolean j() {
        return this.s;
    }
}
