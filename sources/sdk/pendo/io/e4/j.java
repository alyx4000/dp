package sdk.pendo.io.e4;

import sdk.pendo.io.m3.j1;
import sdk.pendo.io.m3.q;
import sdk.pendo.io.m3.w1;
import sdk.pendo.io.m3.z1;

/* loaded from: classes6.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    z1 f1025a = new z1(true, 0, new q(2));
    q b;
    a c;
    sdk.pendo.io.c4.c d;
    i e;
    i f;
    sdk.pendo.io.c4.c g;
    g h;
    e i;
    private boolean j;
    private j1 k;
    private j1 l;

    public h a() {
        if (this.b == null || this.c == null || this.d == null || this.e == null || this.f == null || ((this.g == null && !this.j) || this.h == null)) {
            throw new IllegalStateException("not all mandatory fields set in V3 TBScertificate generator");
        }
        sdk.pendo.io.m3.h hVar = new sdk.pendo.io.m3.h(10);
        hVar.a(this.f1025a);
        hVar.a(this.b);
        hVar.a(this.c);
        hVar.a(this.d);
        sdk.pendo.io.m3.h hVar2 = new sdk.pendo.io.m3.h(2);
        hVar2.a(this.e);
        hVar2.a(this.f);
        hVar.a(new w1(hVar2));
        sdk.pendo.io.m3.g gVar = this.g;
        if (gVar == null) {
            gVar = new w1();
        }
        hVar.a(gVar);
        hVar.a(this.h);
        j1 j1Var = this.k;
        if (j1Var != null) {
            hVar.a(new z1(false, 1, j1Var));
        }
        j1 j1Var2 = this.l;
        if (j1Var2 != null) {
            hVar.a(new z1(false, 2, j1Var2));
        }
        e eVar = this.i;
        if (eVar != null) {
            hVar.a(new z1(true, 3, eVar));
        }
        return h.a(new w1(hVar));
    }

    public void b(i iVar) {
        this.e = iVar;
    }

    public void a(i iVar) {
        this.f = iVar;
    }

    public void b(sdk.pendo.io.c4.c cVar) {
        this.g = cVar;
    }

    public void a(e eVar) {
        d a2;
        this.i = eVar;
        if (eVar == null || (a2 = eVar.a(d.w0)) == null || !a2.j()) {
            return;
        }
        this.j = true;
    }

    public void b(j1 j1Var) {
        this.l = j1Var;
    }

    public void a(sdk.pendo.io.c4.c cVar) {
        this.d = cVar;
    }

    public void a(j1 j1Var) {
        this.k = j1Var;
    }

    public void a(q qVar) {
        this.b = qVar;
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    public void a(g gVar) {
        this.h = gVar;
    }
}
