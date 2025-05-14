package sdk.pendo.io.a;

import sdk.pendo.io.a.c;

/* loaded from: classes6.dex */
final class a0 extends z {
    private final c0 c;
    private final int d;
    private final int e;
    private int f;
    private b g;
    private b h;
    private b i;
    private b j;
    private c k;

    a0(c0 c0Var, String str, String str2, String str3) {
        super(589824);
        this.c = c0Var;
        this.d = c0Var.f(str);
        this.e = c0Var.f(str2);
        if (str3 != null) {
            this.f = c0Var.f(str3);
        }
    }

    @Override // sdk.pendo.io.a.z
    public void a() {
    }

    final void a(c.a aVar) {
        aVar.b(this.k);
    }

    int b() {
        int a2 = c.a(this.c, 0, this.f) + 6 + b.a(this.g, this.h, this.i, this.j);
        c cVar = this.k;
        return cVar != null ? a2 + cVar.a(this.c) : a2;
    }

    void a(d dVar) {
        dVar.d(this.d).d(this.e);
        int i = this.f != 0 ? 1 : 0;
        if (this.g != null) {
            i++;
        }
        if (this.h != null) {
            i++;
        }
        if (this.i != null) {
            i++;
        }
        if (this.j != null) {
            i++;
        }
        c cVar = this.k;
        if (cVar != null) {
            i += cVar.a();
        }
        dVar.d(i);
        c.a(this.c, 0, this.f, dVar);
        b.a(this.c, this.g, this.h, this.i, this.j, dVar);
        c cVar2 = this.k;
        if (cVar2 != null) {
            cVar2.a(this.c, dVar);
        }
    }

    @Override // sdk.pendo.io.a.z
    public a a(String str, boolean z) {
        if (z) {
            b a2 = b.a(this.c, str, this.g);
            this.g = a2;
            return a2;
        }
        b a3 = b.a(this.c, str, this.h);
        this.h = a3;
        return a3;
    }

    @Override // sdk.pendo.io.a.z
    public void a(c cVar) {
        cVar.c = this.k;
        this.k = cVar;
    }

    @Override // sdk.pendo.io.a.z
    public a a(int i, e0 e0Var, String str, boolean z) {
        if (z) {
            b a2 = b.a(this.c, i, e0Var, str, this.i);
            this.i = a2;
            return a2;
        }
        b a3 = b.a(this.c, i, e0Var, str, this.j);
        this.j = a3;
        return a3;
    }
}
