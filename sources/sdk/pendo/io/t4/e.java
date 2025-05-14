package sdk.pendo.io.t4;

import java.util.List;
import java.util.Vector;
import sdk.pendo.io.t4.f0;
import sdk.pendo.io.t4.w1;

/* loaded from: classes6.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    private final p0 f1572a;
    private final sdk.pendo.io.b5.h b;
    private final sdk.pendo.io.r4.j c;
    private final sdk.pendo.io.r4.k d;
    private final x0 e = new x0(this);
    private final x0 f = new x0(this);
    private final f0.c g;
    private final w1.b h;

    e(p0 p0Var, sdk.pendo.io.b5.h hVar, sdk.pendo.io.r4.j jVar, sdk.pendo.io.r4.k kVar) {
        this.f1572a = p0Var;
        this.b = hVar;
        this.c = jVar;
        this.d = kVar;
        f0.c b = f0.b(p0Var.h(), hVar);
        this.g = b;
        this.h = w1.b(p0Var.h(), hVar, b);
    }

    List<w1> a(boolean z, s0 s0Var, sdk.pendo.io.y4.v0[] v0VarArr, f0.b bVar) {
        return w1.a(this.h, z, s0Var, v0VarArr, bVar);
    }

    p0 b() {
        return this.f1572a;
    }

    sdk.pendo.io.b5.h c() {
        return this.b;
    }

    x0 d() {
        return this.f;
    }

    sdk.pendo.io.r4.j e() {
        return this.c;
    }

    sdk.pendo.io.r4.k f() {
        return this.d;
    }

    x0 a() {
        return this.e;
    }

    f0.b a(s0 s0Var, sdk.pendo.io.y4.v0[] v0VarArr) {
        return f0.b(this.g, s0Var, v0VarArr);
    }

    List<w1> a(Vector<sdk.pendo.io.y4.i1> vector) {
        return w1.a(this.h, vector);
    }
}
