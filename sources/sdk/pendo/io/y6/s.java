package sdk.pendo.io.y6;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import sdk.pendo.io.w2.c0;
import sdk.pendo.io.w2.e;
import sdk.pendo.io.w2.e0;
import sdk.pendo.io.w2.z;
import sdk.pendo.io.y6.a;
import sdk.pendo.io.y6.c;
import sdk.pendo.io.y6.f;

/* loaded from: classes4.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Method, t<?>> f1856a = new ConcurrentHashMap();
    final e.a b;
    final sdk.pendo.io.w2.v c;
    final List<f.a> d;
    final List<c.a> e;

    @Nullable
    final Executor f;
    final boolean g;

    class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private final o f1857a = o.e();
        private final Object[] b = new Object[0];
        final /* synthetic */ Class c;

        a(Class cls) {
            this.c = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        @Nullable
        public Object invoke(Object obj, Method method, @Nullable Object[] objArr) {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (objArr == null) {
                objArr = this.b;
            }
            return this.f1857a.a(method) ? this.f1857a.a(method, this.c, obj, objArr) : s.this.a(method).a(objArr);
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final o f1858a;

        @Nullable
        private e.a b;

        @Nullable
        private sdk.pendo.io.w2.v c;
        private final List<f.a> d;
        private final List<c.a> e;

        @Nullable
        private Executor f;
        private boolean g;

        public b() {
            this(o.e());
        }

        public b a(c.a aVar) {
            this.e.add((c.a) Objects.requireNonNull(aVar, "factory == null"));
            return this;
        }

        b(o oVar) {
            this.d = new ArrayList();
            this.e = new ArrayList();
            this.f1858a = oVar;
        }

        public b a(f.a aVar) {
            this.d.add((f.a) Objects.requireNonNull(aVar, "factory == null"));
            return this;
        }

        public b a(String str) {
            Objects.requireNonNull(str, "baseUrl == null");
            return a(sdk.pendo.io.w2.v.a(str));
        }

        public b a(sdk.pendo.io.w2.v vVar) {
            Objects.requireNonNull(vVar, "baseUrl == null");
            if (!"".equals(vVar.k().get(r0.size() - 1))) {
                throw new IllegalArgumentException("baseUrl must end in /: " + vVar);
            }
            this.c = vVar;
            return this;
        }

        public s a() {
            if (this.c == null) {
                throw new IllegalStateException("Base URL required.");
            }
            e.a aVar = this.b;
            if (aVar == null) {
                aVar = new z();
            }
            e.a aVar2 = aVar;
            Executor executor = this.f;
            if (executor == null) {
                executor = this.f1858a.a();
            }
            Executor executor2 = executor;
            ArrayList arrayList = new ArrayList(this.e);
            arrayList.addAll(this.f1858a.a(executor2));
            ArrayList arrayList2 = new ArrayList(this.d.size() + 1 + this.f1858a.c());
            arrayList2.add(new sdk.pendo.io.y6.a());
            arrayList2.addAll(this.d);
            arrayList2.addAll(this.f1858a.b());
            return new s(aVar2, this.c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor2, this.g);
        }

        public b a(e.a aVar) {
            this.b = (e.a) Objects.requireNonNull(aVar, "factory == null");
            return this;
        }

        public b a(z zVar) {
            return a((e.a) Objects.requireNonNull(zVar, "client == null"));
        }
    }

    s(e.a aVar, sdk.pendo.io.w2.v vVar, List<f.a> list, List<c.a> list2, @Nullable Executor executor, boolean z) {
        this.b = aVar;
        this.c = vVar;
        this.d = list;
        this.e = list2;
        this.f = executor;
        this.g = z;
    }

    public c<?, ?> a(Type type, Annotation[] annotationArr) {
        return a((c.a) null, type, annotationArr);
    }

    public <T> f<e0, T> b(Type type, Annotation[] annotationArr) {
        return a((f.a) null, type, annotationArr);
    }

    public <T> f<T, String> c(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            f<T, String> fVar = (f<T, String>) this.d.get(i).stringConverter(type, annotationArr, this);
            if (fVar != null) {
                return fVar;
            }
        }
        return a.d.f1819a;
    }

    private void b(Class<?> cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(cls);
        while (!arrayDeque.isEmpty()) {
            Class<?> cls2 = (Class) arrayDeque.removeFirst();
            if (cls2.getTypeParameters().length != 0) {
                StringBuilder append = new StringBuilder("Type parameters are unsupported on ").append(cls2.getName());
                if (cls2 != cls) {
                    append.append(" which is an interface of ").append(cls.getName());
                }
                throw new IllegalArgumentException(append.toString());
            }
            Collections.addAll(arrayDeque, cls2.getInterfaces());
        }
        if (this.g) {
            o e = o.e();
            for (Method method : cls.getDeclaredMethods()) {
                if (!e.a(method) && !Modifier.isStatic(method.getModifiers())) {
                    a(method);
                }
            }
        }
    }

    public <T> T a(Class<T> cls) {
        b(cls);
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    t<?> a(Method method) {
        t<?> tVar;
        t<?> tVar2 = this.f1856a.get(method);
        if (tVar2 != null) {
            return tVar2;
        }
        synchronized (this.f1856a) {
            tVar = this.f1856a.get(method);
            if (tVar == null) {
                tVar = t.a(this, method);
                this.f1856a.put(method, tVar);
            }
        }
        return tVar;
    }

    public c<?, ?> a(@Nullable c.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int indexOf = this.e.indexOf(aVar) + 1;
        int size = this.e.size();
        for (int i = indexOf; i < size; i++) {
            c<?, ?> a2 = this.e.get(i).a(type, annotationArr, this);
            if (a2 != null) {
                return a2;
            }
        }
        StringBuilder append = new StringBuilder("Could not locate call adapter for ").append(type).append(".\n");
        if (aVar != null) {
            append.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                append.append("\n   * ").append(this.e.get(i2).getClass().getName());
            }
            append.append('\n');
        }
        append.append("  Tried:");
        int size2 = this.e.size();
        while (indexOf < size2) {
            append.append("\n   * ").append(this.e.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(append.toString());
    }

    public <T> f<T, c0> a(@Nullable f.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int indexOf = this.d.indexOf(aVar) + 1;
        int size = this.d.size();
        for (int i = indexOf; i < size; i++) {
            f<T, c0> fVar = (f<T, c0>) this.d.get(i).requestBodyConverter(type, annotationArr, annotationArr2, this);
            if (fVar != null) {
                return fVar;
            }
        }
        StringBuilder append = new StringBuilder("Could not locate RequestBody converter for ").append(type).append(".\n");
        if (aVar != null) {
            append.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                append.append("\n   * ").append(this.d.get(i2).getClass().getName());
            }
            append.append('\n');
        }
        append.append("  Tried:");
        int size2 = this.d.size();
        while (indexOf < size2) {
            append.append("\n   * ").append(this.d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(append.toString());
    }

    public <T> f<e0, T> a(@Nullable f.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int indexOf = this.d.indexOf(aVar) + 1;
        int size = this.d.size();
        for (int i = indexOf; i < size; i++) {
            f<e0, T> fVar = (f<e0, T>) this.d.get(i).responseBodyConverter(type, annotationArr, this);
            if (fVar != null) {
                return fVar;
            }
        }
        StringBuilder append = new StringBuilder("Could not locate ResponseBody converter for ").append(type).append(".\n");
        if (aVar != null) {
            append.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                append.append("\n   * ").append(this.d.get(i2).getClass().getName());
            }
            append.append('\n');
        }
        append.append("  Tried:");
        int size2 = this.d.size();
        while (indexOf < size2) {
            append.append("\n   * ").append(this.d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(append.toString());
    }

    public <T> f<T, c0> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return a(null, type, annotationArr, annotationArr2);
    }
}
