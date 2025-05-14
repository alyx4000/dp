package sdk.pendo.io.v1;

import java.util.Iterator;

/* loaded from: classes4.dex */
public class q extends j {
    private static final d f = new a();

    class a implements d {
        a() {
        }

        @Override // sdk.pendo.io.v1.q.d
        public boolean a(Object obj) {
            return false;
        }
    }

    private static final class b implements d {

        /* renamed from: a, reason: collision with root package name */
        private final g f1664a;

        private b(g gVar) {
            this.f1664a = gVar;
        }

        @Override // sdk.pendo.io.v1.q.d
        public boolean a(Object obj) {
            return this.f1664a.e().e(obj);
        }
    }

    private static final class c implements d {

        /* renamed from: a, reason: collision with root package name */
        private final g f1665a;
        private n b;

        private c(j jVar, g gVar) {
            this.f1665a = gVar;
            this.b = (n) jVar;
        }

        @Override // sdk.pendo.io.v1.q.d
        public boolean a(Object obj) {
            return this.b.a(obj, this.f1665a.g(), this.f1665a.a(), this.f1665a);
        }
    }

    private interface d {
        boolean a(Object obj);
    }

    private static final class e implements d {

        /* renamed from: a, reason: collision with root package name */
        private final g f1666a;
        private o b;

        private e(j jVar, g gVar) {
            this.f1666a = gVar;
            this.b = (o) jVar;
        }

        @Override // sdk.pendo.io.v1.q.d
        public boolean a(Object obj) {
            if (!this.f1666a.e().a(obj)) {
                return false;
            }
            if (!this.b.e()) {
                return true;
            }
            if (this.b.b() && this.f1666a.f().contains(sdk.pendo.io.n1.i.DEFAULT_PATH_LEAF_TO_NULL)) {
                return true;
            }
            return this.f1666a.e().c(obj).containsAll(this.b.h());
        }
    }

    private static final class f implements d {
        private f() {
        }

        @Override // sdk.pendo.io.v1.q.d
        public boolean a(Object obj) {
            return true;
        }
    }

    q() {
    }

    private static d a(j jVar, g gVar) {
        return jVar instanceof o ? new e(jVar, gVar) : jVar instanceof sdk.pendo.io.v1.c ? new b(gVar) : jVar instanceof r ? new f() : jVar instanceof n ? new c(jVar, gVar) : f;
    }

    public static void b(j jVar, String str, sdk.pendo.io.o1.h hVar, Object obj, g gVar, d dVar) {
        int i = 0;
        if (dVar.a(obj)) {
            if (jVar.b()) {
                jVar.a(str, hVar, obj, gVar);
            } else {
                j g = jVar.g();
                Iterator<?> it = gVar.e().f(obj).iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    g.a(str + "[" + i2 + "]", hVar, it.next(), gVar);
                    i2++;
                }
            }
        }
        Iterator<?> it2 = gVar.e().f(obj).iterator();
        while (it2.hasNext()) {
            a(jVar, str + "[" + i + "]", sdk.pendo.io.o1.h.a(obj, i), it2.next(), gVar, dVar);
            i++;
        }
    }

    public static void c(j jVar, String str, sdk.pendo.io.o1.h hVar, Object obj, g gVar, d dVar) {
        if (dVar.a(obj)) {
            jVar.a(str, hVar, obj, gVar);
        }
        for (String str2 : gVar.e().c(obj)) {
            String str3 = str + "['" + str2 + "']";
            Object a2 = gVar.e().a(obj, str2);
            if (a2 != sdk.pendo.io.x1.b.f1745a) {
                a(jVar, str3, sdk.pendo.io.o1.h.a(obj, str2), a2, gVar, dVar);
            }
        }
    }

    @Override // sdk.pendo.io.v1.j
    public String a() {
        return "..";
    }

    @Override // sdk.pendo.io.v1.j
    public boolean e() {
        return false;
    }

    @Override // sdk.pendo.io.v1.j
    public void a(String str, sdk.pendo.io.o1.h hVar, Object obj, g gVar) {
        j g = g();
        a(g, str, hVar, obj, gVar, a(g, gVar));
    }

    public static void a(j jVar, String str, sdk.pendo.io.o1.h hVar, Object obj, g gVar, d dVar) {
        if (gVar.e().a(obj)) {
            c(jVar, str, hVar, obj, gVar, dVar);
        } else if (gVar.e().e(obj)) {
            b(jVar, str, hVar, obj, gVar, dVar);
        }
    }
}
