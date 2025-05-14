package sdk.pendo.io.a1;

import java.security.Security;
import java.util.Arrays;
import sdk.pendo.io.b1.a;
import sdk.pendo.io.b1.b;
import sdk.pendo.io.b1.c;
import sdk.pendo.io.b1.d;
import sdk.pendo.io.b1.l;
import sdk.pendo.io.b1.m;
import sdk.pendo.io.b1.n;
import sdk.pendo.io.b1.p;
import sdk.pendo.io.b1.q;
import sdk.pendo.io.b1.r;
import sdk.pendo.io.e1.b;
import sdk.pendo.io.e1.d;
import sdk.pendo.io.e1.g;
import sdk.pendo.io.e1.h;

/* loaded from: classes6.dex */
public class e {
    private static final sdk.pendo.io.h7.a e = sdk.pendo.io.h7.b.a((Class<?>) e.class);
    private static final e f = new e();

    /* renamed from: a, reason: collision with root package name */
    private d<sdk.pendo.io.e1.f> f840a;
    private d<p> b;
    private d<sdk.pendo.io.b1.g> c;
    private d<sdk.pendo.io.m1.a> d;

    private e() {
        f();
    }

    public static e b() {
        return f;
    }

    private void f() {
        String property = System.getProperty("java.version");
        String property2 = System.getProperty("java.vendor");
        String property3 = System.getProperty("java.home");
        String arrays = Arrays.toString(Security.getProviders());
        sdk.pendo.io.h7.a aVar = e;
        aVar.a("Initializing jose4j (running with Java {} from {} at {} with {} security providers installed)...", property, property2, property3, arrays);
        long currentTimeMillis = System.currentTimeMillis();
        d<sdk.pendo.io.e1.f> dVar = new d<>("alg", sdk.pendo.io.e1.f.class);
        this.f840a = dVar;
        dVar.b(new h());
        this.f840a.b(new d.a());
        this.f840a.b(new d.b());
        this.f840a.b(new d.c());
        this.f840a.b(new sdk.pendo.io.e1.c());
        this.f840a.b(new b.a());
        this.f840a.b(new b.C0116b());
        this.f840a.b(new b.c());
        this.f840a.b(new b.d());
        this.f840a.b(new g.d());
        this.f840a.b(new g.e());
        this.f840a.b(new g.f());
        this.f840a.b(new g.a());
        this.f840a.b(new g.b());
        this.f840a.b(new g.c());
        aVar.b("JWS signature algorithms: {}", this.f840a.a());
        d<p> dVar2 = new d<>("alg", p.class);
        this.b = dVar2;
        dVar2.b(new r.a());
        this.b.b(new r.c());
        this.b.b(new r.b());
        this.b.b(new l());
        this.b.b(new d.a());
        this.b.b(new d.b());
        this.b.b(new d.c());
        this.b.b(new m());
        this.b.b(new n.a());
        this.b.b(new n.b());
        this.b.b(new n.c());
        this.b.b(new q.a());
        this.b.b(new q.b());
        this.b.b(new q.c());
        this.b.b(new c.a());
        this.b.b(new c.b());
        this.b.b(new c.C0090c());
        aVar.b("JWE key management algorithms: {}", this.b.a());
        d<sdk.pendo.io.b1.g> dVar3 = new d<>("enc", sdk.pendo.io.b1.g.class);
        this.c = dVar3;
        dVar3.b(new a.C0088a());
        this.c.b(new a.b());
        this.c.b(new a.c());
        this.c.b(new b.a());
        this.c.b(new b.C0089b());
        this.c.b(new b.c());
        aVar.b("JWE content encryption algorithms: {}", this.c.a());
        d<sdk.pendo.io.m1.a> dVar4 = new d<>("zip", sdk.pendo.io.m1.a.class);
        this.d = dVar4;
        dVar4.b(new sdk.pendo.io.m1.b());
        aVar.b("JWE compression algorithms: {}", this.d.a());
        aVar.b("Initialized jose4j in {}ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public d<sdk.pendo.io.m1.a> a() {
        return this.d;
    }

    public d<sdk.pendo.io.b1.g> c() {
        return this.c;
    }

    public d<p> d() {
        return this.b;
    }

    public d<sdk.pendo.io.e1.f> e() {
        return this.f840a;
    }
}
