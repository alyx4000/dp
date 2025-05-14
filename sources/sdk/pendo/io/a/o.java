package sdk.pendo.io.a;

import sdk.pendo.io.a.c;

/* loaded from: classes6.dex */
final class o extends n {
    private final c0 c;
    private final int d;
    private final int e;
    private final int f;
    private int g;
    private int h;
    private b i;
    private b j;
    private b k;
    private b l;
    private c m;

    o(c0 c0Var, int i, String str, String str2, String str3, Object obj) {
        super(589824);
        this.c = c0Var;
        this.d = i;
        this.e = c0Var.f(str);
        this.f = c0Var.f(str2);
        if (str3 != null) {
            this.g = c0Var.f(str3);
        }
        if (obj != null) {
            this.h = c0Var.a(obj).f814a;
        }
    }

    @Override // sdk.pendo.io.a.n
    public void a() {
    }

    final void a(c.a aVar) {
        aVar.b(this.m);
    }

    int b() {
        int i;
        if (this.h != 0) {
            this.c.f("ConstantValue");
            i = 16;
        } else {
            i = 8;
        }
        int a2 = i + c.a(this.c, this.d, this.g) + b.a(this.i, this.j, this.k, this.l);
        c cVar = this.m;
        return cVar != null ? a2 + cVar.a(this.c) : a2;
    }

    void a(d dVar) {
        boolean z = this.c.e() < 49;
        dVar.d((~(z ? 4096 : 0)) & this.d).d(this.e).d(this.f);
        int i = this.h != 0 ? 1 : 0;
        int i2 = this.d;
        if ((i2 & 4096) != 0 && z) {
            i++;
        }
        if (this.g != 0) {
            i++;
        }
        if ((131072 & i2) != 0) {
            i++;
        }
        if (this.i != null) {
            i++;
        }
        if (this.j != null) {
            i++;
        }
        if (this.k != null) {
            i++;
        }
        if (this.l != null) {
            i++;
        }
        c cVar = this.m;
        if (cVar != null) {
            i += cVar.a();
        }
        dVar.d(i);
        if (this.h != 0) {
            dVar.d(this.c.f("ConstantValue")).c(2).d(this.h);
        }
        c.a(this.c, this.d, this.g, dVar);
        b.a(this.c, this.i, this.j, this.k, this.l, dVar);
        c cVar2 = this.m;
        if (cVar2 != null) {
            cVar2.a(this.c, dVar);
        }
    }

    @Override // sdk.pendo.io.a.n
    public a a(String str, boolean z) {
        if (z) {
            b a2 = b.a(this.c, str, this.i);
            this.i = a2;
            return a2;
        }
        b a3 = b.a(this.c, str, this.j);
        this.j = a3;
        return a3;
    }

    @Override // sdk.pendo.io.a.n
    public void a(c cVar) {
        cVar.c = this.m;
        this.m = cVar;
    }

    @Override // sdk.pendo.io.a.n
    public a a(int i, e0 e0Var, String str, boolean z) {
        if (z) {
            b a2 = b.a(this.c, i, e0Var, str, this.k);
            this.k = a2;
            return a2;
        }
        b a3 = b.a(this.c, i, e0Var, str, this.l);
        this.l = a3;
        return a3;
    }
}
