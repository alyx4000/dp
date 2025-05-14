package sdk.pendo.io.e4;

import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.d0;
import sdk.pendo.io.m3.j0;
import sdk.pendo.io.m3.j1;
import sdk.pendo.io.m3.q;
import sdk.pendo.io.m3.t;
import sdk.pendo.io.m3.w1;
import sdk.pendo.io.m3.z1;

/* loaded from: classes6.dex */
public class h extends t {
    q A;
    e A0;
    d0 f;
    a f0;
    q s;
    sdk.pendo.io.c4.c t0;
    i u0;
    i v0;
    sdk.pendo.io.c4.c w0;
    g x0;
    sdk.pendo.io.m3.c y0;
    sdk.pendo.io.m3.c z0;

    private h(d0 d0Var) {
        int i;
        boolean z;
        boolean z2;
        this.f = d0Var;
        if (d0Var.a(0) instanceof j0) {
            this.s = q.a((j0) d0Var.a(0), true);
            i = 0;
        } else {
            this.s = new q(0L);
            i = -1;
        }
        if (this.s.a(0)) {
            z2 = false;
            z = true;
        } else if (this.s.a(1)) {
            z = false;
            z2 = true;
        } else {
            if (!this.s.a(2)) {
                throw new IllegalArgumentException("version number not recognised");
            }
            z = false;
            z2 = false;
        }
        this.A = q.a(d0Var.a(i + 1));
        this.f0 = a.a(d0Var.a(i + 2));
        this.t0 = sdk.pendo.io.c4.c.a(d0Var.a(i + 3));
        d0 d0Var2 = (d0) d0Var.a(i + 4);
        this.u0 = i.a(d0Var2.a(0));
        this.v0 = i.a(d0Var2.a(1));
        this.w0 = sdk.pendo.io.c4.c.a(d0Var.a(i + 5));
        int i2 = i + 6;
        this.x0 = g.a(d0Var.a(i2));
        int size = (d0Var.size() - i2) - 1;
        if (size != 0 && z) {
            throw new IllegalArgumentException("version 1 certificate contains extra data");
        }
        while (size > 0) {
            j0 j0Var = (j0) d0Var.a(i2 + size);
            int n = j0Var.n();
            if (n == 1) {
                this.y0 = j1.b(j0Var, false);
            } else if (n == 2) {
                this.z0 = j1.b(j0Var, false);
            } else {
                if (n != 3) {
                    throw new IllegalArgumentException("Unknown tag encountered in structure: " + j0Var.n());
                }
                if (z2) {
                    throw new IllegalArgumentException("version 2 certificate cannot contain extensions");
                }
                this.A0 = e.a(d0.a(j0Var, true));
            }
            size--;
        }
    }

    public static h a(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj != null) {
            return new h(d0.a(obj));
        }
        return null;
    }

    @Override // sdk.pendo.io.m3.t, sdk.pendo.io.m3.g
    public a0 b() {
        if (sdk.pendo.io.d5.g.a("external.sdk.pendo.io.org.bouncycastle.x509.allow_non-der_tbscert") != null && !sdk.pendo.io.d5.g.b("external.sdk.pendo.io.org.bouncycastle.x509.allow_non-der_tbscert")) {
            sdk.pendo.io.m3.h hVar = new sdk.pendo.io.m3.h();
            if (!this.s.a(0)) {
                hVar.a(new z1(true, 0, this.s));
            }
            hVar.a(this.A);
            hVar.a(this.f0);
            hVar.a(this.t0);
            sdk.pendo.io.m3.h hVar2 = new sdk.pendo.io.m3.h(2);
            hVar2.a(this.u0);
            hVar2.a(this.v0);
            hVar.a(new w1(hVar2));
            sdk.pendo.io.m3.g gVar = this.w0;
            if (gVar == null) {
                gVar = new w1();
            }
            hVar.a(gVar);
            hVar.a(this.x0);
            sdk.pendo.io.m3.c cVar = this.y0;
            if (cVar != null) {
                hVar.a(new z1(false, 1, cVar));
            }
            sdk.pendo.io.m3.c cVar2 = this.z0;
            if (cVar2 != null) {
                hVar.a(new z1(false, 2, cVar2));
            }
            e eVar = this.A0;
            if (eVar != null) {
                hVar.a(new z1(true, 3, eVar));
            }
            return new w1(hVar);
        }
        return this.f;
    }

    public i h() {
        return this.v0;
    }

    public e i() {
        return this.A0;
    }

    public sdk.pendo.io.c4.c j() {
        return this.t0;
    }

    public sdk.pendo.io.m3.c k() {
        return this.y0;
    }

    public q l() {
        return this.A;
    }

    public a m() {
        return this.f0;
    }

    public i n() {
        return this.u0;
    }

    public sdk.pendo.io.c4.c o() {
        return this.w0;
    }

    public g p() {
        return this.x0;
    }

    public sdk.pendo.io.m3.c q() {
        return this.z0;
    }
}
