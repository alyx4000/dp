package sdk.pendo.io.v1;

import java.util.Arrays;

/* loaded from: classes4.dex */
public class f implements sdk.pendo.io.o1.g {
    private static final sdk.pendo.io.h7.a c = sdk.pendo.io.h7.b.a((Class<?>) f.class);

    /* renamed from: a, reason: collision with root package name */
    private final p f1655a;
    private final boolean b;

    public f(p pVar, boolean z) {
        this.f1655a = a(pVar);
        this.b = z;
    }

    @Override // sdk.pendo.io.o1.g
    public sdk.pendo.io.o1.d a(Object obj, Object obj2, sdk.pendo.io.n1.a aVar) {
        return a(obj, obj2, aVar, false);
    }

    @Override // sdk.pendo.io.o1.g
    public boolean b() {
        return this.b;
    }

    @Override // sdk.pendo.io.o1.g
    public boolean c() {
        return this.f1655a.c();
    }

    public String toString() {
        return this.f1655a.toString();
    }

    public sdk.pendo.io.o1.d a(Object obj, Object obj2, sdk.pendo.io.n1.a aVar, boolean z) {
        sdk.pendo.io.h7.a aVar2 = c;
        if (aVar2.a()) {
            aVar2.b("Evaluating path: {}", toString());
        }
        g gVar = new g(this, obj2, aVar, z);
        try {
            this.f1655a.a("", gVar.d() ? sdk.pendo.io.o1.h.a(obj2) : sdk.pendo.io.o1.h.s, obj, gVar);
        } catch (sdk.pendo.io.o1.c unused) {
        }
        return gVar;
    }

    private p a(p pVar) {
        if (!pVar.i() || !(pVar.g() instanceof q)) {
            return pVar;
        }
        j jVar = pVar;
        j jVar2 = null;
        while (true) {
            jVar = jVar.g();
            if (jVar == null || (jVar instanceof h)) {
                break;
            }
            jVar2 = jVar;
        }
        if (!(jVar instanceof h)) {
            return pVar;
        }
        jVar2.b(null);
        pVar.d(jVar2);
        sdk.pendo.io.q1.b bVar = new sdk.pendo.io.q1.b();
        bVar.a(new f(pVar, true));
        bVar.a(sdk.pendo.io.q1.a.PATH);
        ((h) jVar).a(Arrays.asList(bVar));
        p pVar2 = new p('$');
        pVar2.d(jVar);
        pVar2.b(jVar);
        return pVar2;
    }

    @Override // sdk.pendo.io.o1.g
    public boolean a() {
        return this.f1655a.i();
    }
}
