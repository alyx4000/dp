package sdk.pendo.io.e2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.text.Typography;

/* loaded from: classes6.dex */
public class d {
    public static final sdk.pendo.io.e2.e<sdk.pendo.io.b2.f> c = new j();
    public static final sdk.pendo.io.e2.e<sdk.pendo.io.b2.f> d = new k();
    public static final sdk.pendo.io.e2.e<sdk.pendo.io.b2.c> e = new l();
    public static final sdk.pendo.io.e2.e<sdk.pendo.io.b2.b> f = new m();
    public static final sdk.pendo.io.e2.e<Iterable<? extends Object>> g = new n();
    public static final sdk.pendo.io.e2.e<Enum<?>> h = new o();
    public static final sdk.pendo.io.e2.e<Map<String, ? extends Object>> i = new p();
    public static final sdk.pendo.io.e2.e<Object> j = new sdk.pendo.io.e2.c();
    public static final sdk.pendo.io.e2.e<Object> k = new sdk.pendo.io.e2.b();
    public static final sdk.pendo.io.e2.e<Object> l = new sdk.pendo.io.e2.a();
    public static final sdk.pendo.io.e2.e<Object> m = new q();

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Class<?>, sdk.pendo.io.e2.e<?>> f999a = new ConcurrentHashMap<>();
    private LinkedList<s> b = new LinkedList<>();

    class a implements sdk.pendo.io.e2.e<Double> {
        a() {
        }

        @Override // sdk.pendo.io.e2.e
        public void a(Double d, Appendable appendable, sdk.pendo.io.b2.g gVar) {
            appendable.append(d.isInfinite() ? "null" : d.toString());
        }
    }

    class b implements sdk.pendo.io.e2.e<Date> {
        b() {
        }

        @Override // sdk.pendo.io.e2.e
        public void a(Date date, Appendable appendable, sdk.pendo.io.b2.g gVar) {
            appendable.append(Typography.quote);
            sdk.pendo.io.b2.i.a(date.toString(), appendable, gVar);
            appendable.append(Typography.quote);
        }
    }

    class c implements sdk.pendo.io.e2.e<Float> {
        c() {
        }

        @Override // sdk.pendo.io.e2.e
        public void a(Float f, Appendable appendable, sdk.pendo.io.b2.g gVar) {
            appendable.append(f.isInfinite() ? "null" : f.toString());
        }
    }

    /* renamed from: sdk.pendo.io.e2.d$d, reason: collision with other inner class name */
    class C0117d implements sdk.pendo.io.e2.e<int[]> {
        C0117d() {
        }

        @Override // sdk.pendo.io.e2.e
        public void a(int[] iArr, Appendable appendable, sdk.pendo.io.b2.g gVar) {
            gVar.c(appendable);
            boolean z = false;
            for (int i : iArr) {
                if (z) {
                    gVar.i(appendable);
                } else {
                    z = true;
                }
                appendable.append(Integer.toString(i));
            }
            gVar.d(appendable);
        }
    }

    class e implements sdk.pendo.io.e2.e<short[]> {
        e() {
        }

        @Override // sdk.pendo.io.e2.e
        public void a(short[] sArr, Appendable appendable, sdk.pendo.io.b2.g gVar) {
            gVar.c(appendable);
            boolean z = false;
            for (short s : sArr) {
                if (z) {
                    gVar.i(appendable);
                } else {
                    z = true;
                }
                appendable.append(Short.toString(s));
            }
            gVar.d(appendable);
        }
    }

    class f implements sdk.pendo.io.e2.e<long[]> {
        f() {
        }

        @Override // sdk.pendo.io.e2.e
        public void a(long[] jArr, Appendable appendable, sdk.pendo.io.b2.g gVar) {
            gVar.c(appendable);
            boolean z = false;
            for (long j : jArr) {
                if (z) {
                    gVar.i(appendable);
                } else {
                    z = true;
                }
                appendable.append(Long.toString(j));
            }
            gVar.d(appendable);
        }
    }

    class g implements sdk.pendo.io.e2.e<float[]> {
        g() {
        }

        @Override // sdk.pendo.io.e2.e
        public void a(float[] fArr, Appendable appendable, sdk.pendo.io.b2.g gVar) {
            gVar.c(appendable);
            boolean z = false;
            for (float f : fArr) {
                if (z) {
                    gVar.i(appendable);
                } else {
                    z = true;
                }
                appendable.append(Float.toString(f));
            }
            gVar.d(appendable);
        }
    }

    class h implements sdk.pendo.io.e2.e<double[]> {
        h() {
        }

        @Override // sdk.pendo.io.e2.e
        public void a(double[] dArr, Appendable appendable, sdk.pendo.io.b2.g gVar) {
            gVar.c(appendable);
            boolean z = false;
            for (double d : dArr) {
                if (z) {
                    gVar.i(appendable);
                } else {
                    z = true;
                }
                appendable.append(Double.toString(d));
            }
            gVar.d(appendable);
        }
    }

    class i implements sdk.pendo.io.e2.e<boolean[]> {
        i() {
        }

        @Override // sdk.pendo.io.e2.e
        public void a(boolean[] zArr, Appendable appendable, sdk.pendo.io.b2.g gVar) {
            gVar.c(appendable);
            boolean z = false;
            for (boolean z2 : zArr) {
                if (z) {
                    gVar.i(appendable);
                } else {
                    z = true;
                }
                appendable.append(Boolean.toString(z2));
            }
            gVar.d(appendable);
        }
    }

    class j implements sdk.pendo.io.e2.e<sdk.pendo.io.b2.f> {
        j() {
        }

        @Override // sdk.pendo.io.e2.e
        public <E extends sdk.pendo.io.b2.f> void a(E e, Appendable appendable, sdk.pendo.io.b2.g gVar) {
            e.a(appendable);
        }
    }

    class k implements sdk.pendo.io.e2.e<sdk.pendo.io.b2.f> {
        k() {
        }

        @Override // sdk.pendo.io.e2.e
        public <E extends sdk.pendo.io.b2.f> void a(E e, Appendable appendable, sdk.pendo.io.b2.g gVar) {
            e.a(appendable, gVar);
        }
    }

    class l implements sdk.pendo.io.e2.e<sdk.pendo.io.b2.c> {
        l() {
        }

        @Override // sdk.pendo.io.e2.e
        public <E extends sdk.pendo.io.b2.c> void a(E e, Appendable appendable, sdk.pendo.io.b2.g gVar) {
            appendable.append(e.a(gVar));
        }
    }

    class m implements sdk.pendo.io.e2.e<sdk.pendo.io.b2.b> {
        m() {
        }

        @Override // sdk.pendo.io.e2.e
        public <E extends sdk.pendo.io.b2.b> void a(E e, Appendable appendable, sdk.pendo.io.b2.g gVar) {
            appendable.append(e.c());
        }
    }

    class n implements sdk.pendo.io.e2.e<Iterable<? extends Object>> {
        n() {
        }

        @Override // sdk.pendo.io.e2.e
        public <E extends Iterable<? extends Object>> void a(E e, Appendable appendable, sdk.pendo.io.b2.g gVar) {
            gVar.c(appendable);
            boolean z = true;
            for (Object obj : e) {
                if (z) {
                    gVar.e(appendable);
                    z = false;
                } else {
                    gVar.a(appendable);
                }
                if (obj == null) {
                    appendable.append("null");
                } else {
                    sdk.pendo.io.b2.i.a(obj, appendable, gVar);
                }
                gVar.b(appendable);
            }
            gVar.d(appendable);
        }
    }

    class o implements sdk.pendo.io.e2.e<Enum<?>> {
        o() {
        }

        @Override // sdk.pendo.io.e2.e
        public <E extends Enum<?>> void a(E e, Appendable appendable, sdk.pendo.io.b2.g gVar) {
            gVar.a(appendable, e.name());
        }
    }

    class p implements sdk.pendo.io.e2.e<Map<String, ? extends Object>> {
        p() {
        }

        @Override // sdk.pendo.io.e2.e
        public <E extends Map<String, ? extends Object>> void a(E e, Appendable appendable, sdk.pendo.io.b2.g gVar) {
            gVar.j(appendable);
            boolean z = true;
            for (Map.Entry entry : e.entrySet()) {
                Object value = entry.getValue();
                if (value != null || !gVar.a()) {
                    if (z) {
                        gVar.h(appendable);
                        z = false;
                    } else {
                        gVar.i(appendable);
                    }
                    d.a(entry.getKey().toString(), value, appendable, gVar);
                }
            }
            gVar.k(appendable);
        }
    }

    class q implements sdk.pendo.io.e2.e<Object> {
        q() {
        }

        @Override // sdk.pendo.io.e2.e
        public void a(Object obj, Appendable appendable, sdk.pendo.io.b2.g gVar) {
            appendable.append(obj.toString());
        }
    }

    class r implements sdk.pendo.io.e2.e<String> {
        r() {
        }

        @Override // sdk.pendo.io.e2.e
        public void a(String str, Appendable appendable, sdk.pendo.io.b2.g gVar) {
            gVar.a(appendable, str);
        }
    }

    static class s {

        /* renamed from: a, reason: collision with root package name */
        public Class<?> f1010a;
        public sdk.pendo.io.e2.e<?> b;

        public s(Class<?> cls, sdk.pendo.io.e2.e<?> eVar) {
            this.f1010a = cls;
            this.b = eVar;
        }
    }

    public d() {
        a();
    }

    public sdk.pendo.io.e2.e a(Class cls) {
        return this.f999a.get(cls);
    }

    public sdk.pendo.io.e2.e b(Class<?> cls) {
        Iterator<s> it = this.b.iterator();
        while (it.hasNext()) {
            s next = it.next();
            if (next.f1010a.isAssignableFrom(cls)) {
                return next.b;
            }
        }
        return null;
    }

    public void a() {
        a(new r(), String.class);
        a(new a(), Double.class);
        a(new b(), Date.class);
        a(new c(), Float.class);
        sdk.pendo.io.e2.e<?> eVar = m;
        a(eVar, Integer.class, Long.class, Byte.class, Short.class, BigInteger.class, BigDecimal.class);
        a(eVar, Boolean.class);
        a(new C0117d(), int[].class);
        a(new e(), short[].class);
        a(new f(), long[].class);
        a(new g(), float[].class);
        a(new h(), double[].class);
        a(new i(), boolean[].class);
        a(sdk.pendo.io.b2.f.class, d);
        a(sdk.pendo.io.b2.e.class, c);
        a(sdk.pendo.io.b2.c.class, e);
        a(sdk.pendo.io.b2.b.class, f);
        a(Map.class, i);
        a(Iterable.class, g);
        a(Enum.class, h);
        a(Number.class, eVar);
    }

    public void b(Class<?> cls, sdk.pendo.io.e2.e<?> eVar) {
        this.b.addLast(new s(cls, eVar));
    }

    public <T> void a(sdk.pendo.io.e2.e<T> eVar, Class<?>... clsArr) {
        for (Class<?> cls : clsArr) {
            this.f999a.put(cls, eVar);
        }
    }

    public void a(Class<?> cls, sdk.pendo.io.e2.e<?> eVar) {
        b(cls, eVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r1, java.lang.Object r2, java.lang.Appendable r3, sdk.pendo.io.b2.g r4) {
        /*
            if (r1 != 0) goto L8
            java.lang.String r1 = "null"
        L4:
            r3.append(r1)
            goto L1a
        L8:
            boolean r0 = r4.a(r1)
            if (r0 != 0) goto Lf
            goto L4
        Lf:
            r0 = 34
            r3.append(r0)
            sdk.pendo.io.b2.i.a(r1, r3, r4)
            r3.append(r0)
        L1a:
            r4.g(r3)
            boolean r1 = r2 instanceof java.lang.String
            if (r1 == 0) goto L27
            java.lang.String r2 = (java.lang.String) r2
            r4.a(r3, r2)
            goto L2a
        L27:
            sdk.pendo.io.b2.i.a(r2, r3, r4)
        L2a:
            r4.f(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.e2.d.a(java.lang.String, java.lang.Object, java.lang.Appendable, sdk.pendo.io.b2.g):void");
    }
}
