package sdk.pendo.io.p1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import sdk.pendo.io.n1.l;
import sdk.pendo.io.p1.k;

/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<sdk.pendo.io.p1.i, sdk.pendo.io.p1.a> f1484a;

    private static class a implements sdk.pendo.io.p1.a {
        private a() {
        }

        @Override // sdk.pendo.io.p1.a
        public boolean a(sdk.pendo.io.p1.j jVar, sdk.pendo.io.p1.j jVar2, l.a aVar) {
            k.C0224k i = jVar2.i();
            if (!jVar.l()) {
                return false;
            }
            sdk.pendo.io.p1.j b = jVar.c().b(aVar);
            if (!b.r()) {
                return true;
            }
            k.C0224k i2 = b.i();
            Iterator<sdk.pendo.io.p1.j> it = i.iterator();
            while (it.hasNext()) {
                if (!i2.a(it.next())) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: sdk.pendo.io.p1.b$b, reason: collision with other inner class name */
    private static class C0223b implements sdk.pendo.io.p1.a {
        private C0223b() {
        }

        @Override // sdk.pendo.io.p1.a
        public boolean a(sdk.pendo.io.p1.j jVar, sdk.pendo.io.p1.j jVar2, l.a aVar) {
            if (jVar2.l()) {
                jVar2 = jVar2.c().b(aVar);
                if (jVar2.q()) {
                    return false;
                }
            }
            k.C0224k i = jVar2.i();
            if (jVar.l()) {
                jVar = jVar.c().b(aVar);
                if (jVar.q()) {
                    return false;
                }
            }
            Iterator<sdk.pendo.io.p1.j> it = jVar.i().iterator();
            while (it.hasNext()) {
                sdk.pendo.io.p1.j next = it.next();
                Iterator<sdk.pendo.io.p1.j> it2 = i.iterator();
                while (it2.hasNext()) {
                    if (next.equals(it2.next())) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private static class c implements sdk.pendo.io.p1.a {
        private c() {
        }

        @Override // sdk.pendo.io.p1.a
        public boolean a(sdk.pendo.io.p1.j jVar, sdk.pendo.io.p1.j jVar2, l.a aVar) {
            if (jVar.p() && jVar2.p()) {
                return jVar.h().a(jVar2.h().s());
            }
            if (!jVar.l()) {
                return false;
            }
            sdk.pendo.io.p1.j b = jVar.c().b(aVar);
            if (b.q()) {
                return false;
            }
            return b.i().a(jVar2);
        }
    }

    private static class d implements sdk.pendo.io.p1.a {
        private d() {
        }

        @Override // sdk.pendo.io.p1.a
        public boolean a(sdk.pendo.io.p1.j jVar, sdk.pendo.io.p1.j jVar2, l.a aVar) {
            return jVar.p() ? jVar.h().isEmpty() == jVar2.a().s() : jVar.l() && jVar.c().d(aVar) == jVar2.a().s();
        }
    }

    private static class e implements sdk.pendo.io.p1.a {
        private e() {
        }

        @Override // sdk.pendo.io.p1.a
        public boolean a(sdk.pendo.io.p1.j jVar, sdk.pendo.io.p1.j jVar2, l.a aVar) {
            return (jVar.l() && jVar2.l()) ? jVar.c().a(jVar2.c(), aVar) : jVar.equals(jVar2);
        }
    }

    private static class f implements sdk.pendo.io.p1.a {
        private f() {
        }

        @Override // sdk.pendo.io.p1.a
        public boolean a(sdk.pendo.io.p1.j jVar, sdk.pendo.io.p1.j jVar2, l.a aVar) {
            if (jVar.k() || jVar2.k()) {
                return jVar.a().s() == jVar2.a().s();
            }
            throw new sdk.pendo.io.n1.h("Failed to evaluate exists expression");
        }
    }

    private static class g implements sdk.pendo.io.p1.a {
        private g() {
        }

        @Override // sdk.pendo.io.p1.a
        public boolean a(sdk.pendo.io.p1.j jVar, sdk.pendo.io.p1.j jVar2, l.a aVar) {
            if (jVar.m() && jVar2.m()) {
                return jVar.d().s().compareTo(jVar2.d().s()) >= 0;
            }
            k.e d = jVar.d();
            k.e d2 = jVar2.d();
            return (d.s() == null || d2.s() == null || d.s().compareTo(d2.s()) < 0) ? false : true;
        }
    }

    private static class h implements sdk.pendo.io.p1.a {
        private h() {
        }

        @Override // sdk.pendo.io.p1.a
        public boolean a(sdk.pendo.io.p1.j jVar, sdk.pendo.io.p1.j jVar2, l.a aVar) {
            if (jVar.m() && jVar2.m()) {
                return jVar.d().s().compareTo(jVar2.d().s()) > 0;
            }
            k.e d = jVar.d();
            k.e d2 = jVar2.d();
            return (d.s() == null || d2.s() == null || d.s().compareTo(d2.s()) <= 0) ? false : true;
        }
    }

    private static class i implements sdk.pendo.io.p1.a {
        private i() {
        }

        @Override // sdk.pendo.io.p1.a
        public boolean a(sdk.pendo.io.p1.j jVar, sdk.pendo.io.p1.j jVar2, l.a aVar) {
            k.C0224k i;
            if (jVar2.l()) {
                sdk.pendo.io.p1.j b = jVar2.c().b(aVar);
                if (b.q()) {
                    return false;
                }
                i = b.i();
            } else {
                try {
                    i = jVar2.i();
                } catch (sdk.pendo.io.n1.f unused) {
                    return false;
                }
            }
            return i.a(jVar);
        }
    }

    private static class j implements sdk.pendo.io.p1.a {
        private j() {
        }

        @Override // sdk.pendo.io.p1.a
        public boolean a(sdk.pendo.io.p1.j jVar, sdk.pendo.io.p1.j jVar2, l.a aVar) {
            if (jVar.m() && jVar2.m()) {
                return jVar.d().s().compareTo(jVar2.d().s()) <= 0;
            }
            k.e d = jVar.d();
            k.e d2 = jVar2.d();
            return (d.s() == null || d2.s() == null || d.s().compareTo(d2.s()) > 0) ? false : true;
        }
    }

    private static class k implements sdk.pendo.io.p1.a {
        private k() {
        }

        @Override // sdk.pendo.io.p1.a
        public boolean a(sdk.pendo.io.p1.j jVar, sdk.pendo.io.p1.j jVar2, l.a aVar) {
            if (jVar.m() && jVar2.m()) {
                return jVar.d().s().compareTo(jVar2.d().s()) < 0;
            }
            k.e d = jVar.d();
            k.e d2 = jVar2.d();
            return (d.s() == null || d2.s() == null || d.s().compareTo(d2.s()) >= 0) ? false : true;
        }
    }

    private static class l implements sdk.pendo.io.p1.a {
        private l() {
        }

        @Override // sdk.pendo.io.p1.a
        public boolean a(sdk.pendo.io.p1.j jVar, sdk.pendo.io.p1.j jVar2, l.a aVar) {
            if (jVar2.l()) {
                jVar2 = jVar2.c().b(aVar);
                if (jVar2.q()) {
                    return false;
                }
            }
            k.C0224k i = jVar2.i();
            if (jVar.l()) {
                jVar = jVar.c().b(aVar);
                if (jVar.q()) {
                    return false;
                }
            }
            Iterator<sdk.pendo.io.p1.j> it = jVar.i().iterator();
            while (it.hasNext()) {
                sdk.pendo.io.p1.j next = it.next();
                Iterator<sdk.pendo.io.p1.j> it2 = i.iterator();
                while (it2.hasNext()) {
                    if (next.equals(it2.next())) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    private static class m implements sdk.pendo.io.p1.a {
        private m() {
        }

        @Override // sdk.pendo.io.p1.a
        public boolean a(sdk.pendo.io.p1.j jVar, sdk.pendo.io.p1.j jVar2, l.a aVar) {
            return !((sdk.pendo.io.p1.a) b.f1484a.get(sdk.pendo.io.p1.i.EQ)).a(jVar, jVar2, aVar);
        }
    }

    private static class n implements sdk.pendo.io.p1.a {
        private n() {
        }

        @Override // sdk.pendo.io.p1.a
        public boolean a(sdk.pendo.io.p1.j jVar, sdk.pendo.io.p1.j jVar2, l.a aVar) {
            return !((sdk.pendo.io.p1.a) b.f1484a.get(sdk.pendo.io.p1.i.IN)).a(jVar, jVar2, aVar);
        }
    }

    private static class o implements sdk.pendo.io.p1.a {
        private o() {
        }

        @Override // sdk.pendo.io.p1.a
        public boolean a(sdk.pendo.io.p1.j jVar, sdk.pendo.io.p1.j jVar2, l.a aVar) {
            jVar2.g();
            throw null;
        }
    }

    private static class p implements sdk.pendo.io.p1.a {
        private p() {
        }

        @Override // sdk.pendo.io.p1.a
        public boolean a(sdk.pendo.io.p1.j jVar, sdk.pendo.io.p1.j jVar2, l.a aVar) {
            if (jVar.o() ^ jVar2.o()) {
                return jVar.o() ? a(jVar.f(), a(jVar2)) : a(jVar2.f(), a(jVar));
            }
            return false;
        }

        private String a(sdk.pendo.io.p1.j jVar) {
            return (jVar.p() || jVar.m()) ? jVar.h().s() : jVar.k() ? jVar.a().toString() : "";
        }

        private boolean a(k.g gVar, String str) {
            return gVar.s().matcher(str).matches();
        }
    }

    private static class q implements sdk.pendo.io.p1.a {
        private q() {
        }

        @Override // sdk.pendo.io.p1.a
        public boolean a(sdk.pendo.io.p1.j jVar, sdk.pendo.io.p1.j jVar2, l.a aVar) {
            if (!jVar2.m()) {
                return false;
            }
            int intValue = jVar2.d().s().intValue();
            return jVar.p() ? jVar.h().t() == intValue : jVar.l() && jVar.c().f(aVar) == intValue;
        }
    }

    private static class r implements sdk.pendo.io.p1.a {
        private r() {
        }

        @Override // sdk.pendo.io.p1.a
        public boolean a(sdk.pendo.io.p1.j jVar, sdk.pendo.io.p1.j jVar2, l.a aVar) {
            if (jVar2.l()) {
                jVar2 = jVar2.c().b(aVar);
                if (jVar2.q()) {
                    return false;
                }
            }
            k.C0224k i = jVar2.i();
            if (jVar.l()) {
                jVar = jVar.c().b(aVar);
                if (jVar.q()) {
                    return false;
                }
            }
            return jVar.i().a(i);
        }
    }

    private static class s implements sdk.pendo.io.p1.a {
        private s() {
        }

        @Override // sdk.pendo.io.p1.a
        public boolean a(sdk.pendo.io.p1.j jVar, sdk.pendo.io.p1.j jVar2, l.a aVar) {
            return jVar2.b().s() == jVar.a(aVar);
        }
    }

    private static class t implements sdk.pendo.io.p1.a {
        private t() {
        }

        @Override // sdk.pendo.io.p1.a
        public boolean a(sdk.pendo.io.p1.j jVar, sdk.pendo.io.p1.j jVar2, l.a aVar) {
            if (jVar.getClass().equals(jVar2.getClass())) {
                return ((sdk.pendo.io.p1.a) b.f1484a.get(sdk.pendo.io.p1.i.EQ)).a(jVar, jVar2, aVar);
            }
            return false;
        }
    }

    private static class u implements sdk.pendo.io.p1.a {
        private u() {
        }

        @Override // sdk.pendo.io.p1.a
        public boolean a(sdk.pendo.io.p1.j jVar, sdk.pendo.io.p1.j jVar2, l.a aVar) {
            return !((sdk.pendo.io.p1.a) b.f1484a.get(sdk.pendo.io.p1.i.TSEQ)).a(jVar, jVar2, aVar);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f1484a = hashMap;
        hashMap.put(sdk.pendo.io.p1.i.EXISTS, new f());
        hashMap.put(sdk.pendo.io.p1.i.NE, new m());
        hashMap.put(sdk.pendo.io.p1.i.TSNE, new u());
        hashMap.put(sdk.pendo.io.p1.i.EQ, new e());
        hashMap.put(sdk.pendo.io.p1.i.TSEQ, new t());
        hashMap.put(sdk.pendo.io.p1.i.LT, new k());
        hashMap.put(sdk.pendo.io.p1.i.LTE, new j());
        hashMap.put(sdk.pendo.io.p1.i.GT, new h());
        hashMap.put(sdk.pendo.io.p1.i.GTE, new g());
        hashMap.put(sdk.pendo.io.p1.i.REGEX, new p());
        hashMap.put(sdk.pendo.io.p1.i.SIZE, new q());
        hashMap.put(sdk.pendo.io.p1.i.EMPTY, new d());
        hashMap.put(sdk.pendo.io.p1.i.IN, new i());
        hashMap.put(sdk.pendo.io.p1.i.NIN, new n());
        hashMap.put(sdk.pendo.io.p1.i.ALL, new a());
        hashMap.put(sdk.pendo.io.p1.i.CONTAINS, new c());
        hashMap.put(sdk.pendo.io.p1.i.MATCHES, new o());
        hashMap.put(sdk.pendo.io.p1.i.TYPE, new s());
        hashMap.put(sdk.pendo.io.p1.i.SUBSETOF, new r());
        hashMap.put(sdk.pendo.io.p1.i.ANYOF, new C0223b());
        hashMap.put(sdk.pendo.io.p1.i.NONEOF, new l());
    }

    public static sdk.pendo.io.p1.a a(sdk.pendo.io.p1.i iVar) {
        return f1484a.get(iVar);
    }
}
