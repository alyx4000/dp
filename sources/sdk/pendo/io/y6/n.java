package sdk.pendo.io.y6;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import sdk.pendo.io.w2.c0;
import sdk.pendo.io.w2.y;

/* loaded from: classes4.dex */
abstract class n<T> {

    class a extends n<Iterable<T>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // sdk.pendo.io.y6.n
        public void a(sdk.pendo.io.y6.p pVar, @Nullable Iterable<T> iterable) {
            if (iterable == null) {
                return;
            }
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                n.this.a(pVar, it.next());
            }
        }
    }

    class b extends n<Object> {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // sdk.pendo.io.y6.n
        void a(sdk.pendo.io.y6.p pVar, @Nullable Object obj) {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                n.this.a(pVar, Array.get(obj, i));
            }
        }
    }

    static final class c<T> extends n<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f1835a;
        private final int b;
        private final sdk.pendo.io.y6.f<T, c0> c;

        c(Method method, int i, sdk.pendo.io.y6.f<T, c0> fVar) {
            this.f1835a = method;
            this.b = i;
            this.c = fVar;
        }

        @Override // sdk.pendo.io.y6.n
        void a(sdk.pendo.io.y6.p pVar, @Nullable T t) {
            if (t == null) {
                throw w.a(this.f1835a, this.b, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                pVar.a(this.c.convert(t));
            } catch (IOException e) {
                throw w.a(this.f1835a, e, this.b, "Unable to convert " + t + " to RequestBody", new Object[0]);
            }
        }
    }

    static final class d<T> extends n<T> {

        /* renamed from: a, reason: collision with root package name */
        private final String f1836a;
        private final sdk.pendo.io.y6.f<T, String> b;
        private final boolean c;

        d(String str, sdk.pendo.io.y6.f<T, String> fVar, boolean z) {
            this.f1836a = (String) Objects.requireNonNull(str, "name == null");
            this.b = fVar;
            this.c = z;
        }

        @Override // sdk.pendo.io.y6.n
        void a(sdk.pendo.io.y6.p pVar, @Nullable T t) {
            String convert;
            if (t == null || (convert = this.b.convert(t)) == null) {
                return;
            }
            pVar.a(this.f1836a, convert, this.c);
        }
    }

    static final class e<T> extends n<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f1837a;
        private final int b;
        private final sdk.pendo.io.y6.f<T, String> c;
        private final boolean d;

        e(Method method, int i, sdk.pendo.io.y6.f<T, String> fVar, boolean z) {
            this.f1837a = method;
            this.b = i;
            this.c = fVar;
            this.d = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // sdk.pendo.io.y6.n
        public void a(sdk.pendo.io.y6.p pVar, @Nullable Map<String, T> map) {
            if (map == null) {
                throw w.a(this.f1837a, this.b, "Field map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw w.a(this.f1837a, this.b, "Field map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw w.a(this.f1837a, this.b, "Field map contained null value for key '" + key + "'.", new Object[0]);
                }
                String convert = this.c.convert(value);
                if (convert == null) {
                    throw w.a(this.f1837a, this.b, "Field map value '" + value + "' converted to null by " + this.c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                pVar.a(key, convert, this.d);
            }
        }
    }

    static final class f<T> extends n<T> {

        /* renamed from: a, reason: collision with root package name */
        private final String f1838a;
        private final sdk.pendo.io.y6.f<T, String> b;

        f(String str, sdk.pendo.io.y6.f<T, String> fVar) {
            this.f1838a = (String) Objects.requireNonNull(str, "name == null");
            this.b = fVar;
        }

        @Override // sdk.pendo.io.y6.n
        void a(sdk.pendo.io.y6.p pVar, @Nullable T t) {
            String convert;
            if (t == null || (convert = this.b.convert(t)) == null) {
                return;
            }
            pVar.a(this.f1838a, convert);
        }
    }

    static final class g<T> extends n<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f1839a;
        private final int b;
        private final sdk.pendo.io.y6.f<T, String> c;

        g(Method method, int i, sdk.pendo.io.y6.f<T, String> fVar) {
            this.f1839a = method;
            this.b = i;
            this.c = fVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // sdk.pendo.io.y6.n
        public void a(sdk.pendo.io.y6.p pVar, @Nullable Map<String, T> map) {
            if (map == null) {
                throw w.a(this.f1839a, this.b, "Header map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw w.a(this.f1839a, this.b, "Header map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw w.a(this.f1839a, this.b, "Header map contained null value for key '" + key + "'.", new Object[0]);
                }
                pVar.a(key, this.c.convert(value));
            }
        }
    }

    static final class h extends n<sdk.pendo.io.w2.u> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f1840a;
        private final int b;

        h(Method method, int i) {
            this.f1840a = method;
            this.b = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // sdk.pendo.io.y6.n
        public void a(sdk.pendo.io.y6.p pVar, @Nullable sdk.pendo.io.w2.u uVar) {
            if (uVar == null) {
                throw w.a(this.f1840a, this.b, "Headers parameter must not be null.", new Object[0]);
            }
            pVar.a(uVar);
        }
    }

    static final class i<T> extends n<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f1841a;
        private final int b;
        private final sdk.pendo.io.w2.u c;
        private final sdk.pendo.io.y6.f<T, c0> d;

        i(Method method, int i, sdk.pendo.io.w2.u uVar, sdk.pendo.io.y6.f<T, c0> fVar) {
            this.f1841a = method;
            this.b = i;
            this.c = uVar;
            this.d = fVar;
        }

        @Override // sdk.pendo.io.y6.n
        void a(sdk.pendo.io.y6.p pVar, @Nullable T t) {
            if (t == null) {
                return;
            }
            try {
                pVar.a(this.c, this.d.convert(t));
            } catch (IOException e) {
                throw w.a(this.f1841a, this.b, "Unable to convert " + t + " to RequestBody", e);
            }
        }
    }

    static final class j<T> extends n<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f1842a;
        private final int b;
        private final sdk.pendo.io.y6.f<T, c0> c;
        private final String d;

        j(Method method, int i, sdk.pendo.io.y6.f<T, c0> fVar, String str) {
            this.f1842a = method;
            this.b = i;
            this.c = fVar;
            this.d = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // sdk.pendo.io.y6.n
        public void a(sdk.pendo.io.y6.p pVar, @Nullable Map<String, T> map) {
            if (map == null) {
                throw w.a(this.f1842a, this.b, "Part map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw w.a(this.f1842a, this.b, "Part map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw w.a(this.f1842a, this.b, "Part map contained null value for key '" + key + "'.", new Object[0]);
                }
                pVar.a(sdk.pendo.io.w2.u.a("Content-Disposition", "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.d), this.c.convert(value));
            }
        }
    }

    static final class k<T> extends n<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f1843a;
        private final int b;
        private final String c;
        private final sdk.pendo.io.y6.f<T, String> d;
        private final boolean e;

        k(Method method, int i, String str, sdk.pendo.io.y6.f<T, String> fVar, boolean z) {
            this.f1843a = method;
            this.b = i;
            this.c = (String) Objects.requireNonNull(str, "name == null");
            this.d = fVar;
            this.e = z;
        }

        @Override // sdk.pendo.io.y6.n
        void a(sdk.pendo.io.y6.p pVar, @Nullable T t) {
            if (t == null) {
                throw w.a(this.f1843a, this.b, "Path parameter \"" + this.c + "\" value must not be null.", new Object[0]);
            }
            pVar.b(this.c, this.d.convert(t), this.e);
        }
    }

    static final class l<T> extends n<T> {

        /* renamed from: a, reason: collision with root package name */
        private final String f1844a;
        private final sdk.pendo.io.y6.f<T, String> b;
        private final boolean c;

        l(String str, sdk.pendo.io.y6.f<T, String> fVar, boolean z) {
            this.f1844a = (String) Objects.requireNonNull(str, "name == null");
            this.b = fVar;
            this.c = z;
        }

        @Override // sdk.pendo.io.y6.n
        void a(sdk.pendo.io.y6.p pVar, @Nullable T t) {
            String convert;
            if (t == null || (convert = this.b.convert(t)) == null) {
                return;
            }
            pVar.c(this.f1844a, convert, this.c);
        }
    }

    static final class m<T> extends n<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f1845a;
        private final int b;
        private final sdk.pendo.io.y6.f<T, String> c;
        private final boolean d;

        m(Method method, int i, sdk.pendo.io.y6.f<T, String> fVar, boolean z) {
            this.f1845a = method;
            this.b = i;
            this.c = fVar;
            this.d = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // sdk.pendo.io.y6.n
        public void a(sdk.pendo.io.y6.p pVar, @Nullable Map<String, T> map) {
            if (map == null) {
                throw w.a(this.f1845a, this.b, "Query map was null", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw w.a(this.f1845a, this.b, "Query map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw w.a(this.f1845a, this.b, "Query map contained null value for key '" + key + "'.", new Object[0]);
                }
                String convert = this.c.convert(value);
                if (convert == null) {
                    throw w.a(this.f1845a, this.b, "Query map value '" + value + "' converted to null by " + this.c.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                pVar.c(key, convert, this.d);
            }
        }
    }

    /* renamed from: sdk.pendo.io.y6.n$n, reason: collision with other inner class name */
    static final class C0275n<T> extends n<T> {

        /* renamed from: a, reason: collision with root package name */
        private final sdk.pendo.io.y6.f<T, String> f1846a;
        private final boolean b;

        C0275n(sdk.pendo.io.y6.f<T, String> fVar, boolean z) {
            this.f1846a = fVar;
            this.b = z;
        }

        @Override // sdk.pendo.io.y6.n
        void a(sdk.pendo.io.y6.p pVar, @Nullable T t) {
            if (t == null) {
                return;
            }
            pVar.c(this.f1846a.convert(t), null, this.b);
        }
    }

    static final class o extends n<y.c> {

        /* renamed from: a, reason: collision with root package name */
        static final o f1847a = new o();

        private o() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // sdk.pendo.io.y6.n
        public void a(sdk.pendo.io.y6.p pVar, @Nullable y.c cVar) {
            if (cVar != null) {
                pVar.a(cVar);
            }
        }
    }

    static final class p extends n<Object> {

        /* renamed from: a, reason: collision with root package name */
        private final Method f1848a;
        private final int b;

        p(Method method, int i) {
            this.f1848a = method;
            this.b = i;
        }

        @Override // sdk.pendo.io.y6.n
        void a(sdk.pendo.io.y6.p pVar, @Nullable Object obj) {
            if (obj == null) {
                throw w.a(this.f1848a, this.b, "@Url parameter is null.", new Object[0]);
            }
            pVar.a(obj);
        }
    }

    static final class q<T> extends n<T> {

        /* renamed from: a, reason: collision with root package name */
        final Class<T> f1849a;

        q(Class<T> cls) {
            this.f1849a = cls;
        }

        @Override // sdk.pendo.io.y6.n
        void a(sdk.pendo.io.y6.p pVar, @Nullable T t) {
            pVar.a((Class<Class<T>>) this.f1849a, (Class<T>) t);
        }
    }

    n() {
    }

    final n<Object> a() {
        return new b();
    }

    abstract void a(sdk.pendo.io.y6.p pVar, @Nullable T t);

    final n<Iterable<T>> b() {
        return new a();
    }
}
