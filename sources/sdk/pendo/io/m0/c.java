package sdk.pendo.io.m0;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Type, sdk.pendo.io.k0.e<?>> f1353a;
    private final boolean b;

    /* JADX INFO: Add missing generic type declarations: [T] */
    class a<T> implements sdk.pendo.io.m0.h<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f1354a;

        a(Type type) {
            this.f1354a = type;
        }

        @Override // sdk.pendo.io.m0.h
        public T a() {
            Type type = this.f1354a;
            if (!(type instanceof ParameterizedType)) {
                throw new sdk.pendo.io.k0.j("Invalid EnumMap type: " + this.f1354a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) new EnumMap((Class) type2);
            }
            throw new sdk.pendo.io.k0.j("Invalid EnumMap type: " + this.f1354a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class b<T> implements sdk.pendo.io.m0.h<T> {
        b() {
        }

        @Override // sdk.pendo.io.m0.h
        public T a() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: sdk.pendo.io.m0.c$c, reason: collision with other inner class name */
    class C0195c<T> implements sdk.pendo.io.m0.h<T> {
        C0195c() {
        }

        @Override // sdk.pendo.io.m0.h
        public T a() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class d<T> implements sdk.pendo.io.m0.h<T> {
        d() {
        }

        @Override // sdk.pendo.io.m0.h
        public T a() {
            return (T) new TreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class e<T> implements sdk.pendo.io.m0.h<T> {
        e() {
        }

        @Override // sdk.pendo.io.m0.h
        public T a() {
            return (T) new LinkedHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class f<T> implements sdk.pendo.io.m0.h<T> {
        f() {
        }

        @Override // sdk.pendo.io.m0.h
        public T a() {
            return (T) new sdk.pendo.io.m0.g();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class g<T> implements sdk.pendo.io.m0.h<T> {

        /* renamed from: a, reason: collision with root package name */
        private final sdk.pendo.io.m0.l f1360a = sdk.pendo.io.m0.l.a();
        final /* synthetic */ Class b;

        g(Class cls) {
            this.b = cls;
        }

        @Override // sdk.pendo.io.m0.h
        public T a() {
            try {
                return (T) this.f1360a.b(this.b);
            } catch (Exception e) {
                throw new RuntimeException("Unable to create instance of " + this.b + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class h<T> implements sdk.pendo.io.m0.h<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f1361a;

        h(String str) {
            this.f1361a = str;
        }

        @Override // sdk.pendo.io.m0.h
        public T a() {
            throw new sdk.pendo.io.k0.j(this.f1361a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class i<T> implements sdk.pendo.io.m0.h<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ sdk.pendo.io.k0.e f1362a;
        final /* synthetic */ Type b;

        i(sdk.pendo.io.k0.e eVar, Type type) {
            this.f1362a = eVar;
            this.b = type;
        }

        @Override // sdk.pendo.io.m0.h
        public T a() {
            return (T) this.f1362a.a(this.b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class j<T> implements sdk.pendo.io.m0.h<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ sdk.pendo.io.k0.e f1363a;
        final /* synthetic */ Type b;

        j(sdk.pendo.io.k0.e eVar, Type type) {
            this.f1363a = eVar;
            this.b = type;
        }

        @Override // sdk.pendo.io.m0.h
        public T a() {
            return (T) this.f1363a.a(this.b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class k<T> implements sdk.pendo.io.m0.h<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f1364a;

        k(String str) {
            this.f1364a = str;
        }

        @Override // sdk.pendo.io.m0.h
        public T a() {
            throw new sdk.pendo.io.k0.j(this.f1364a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class l<T> implements sdk.pendo.io.m0.h<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor f1365a;

        l(Constructor constructor) {
            this.f1365a = constructor;
        }

        @Override // sdk.pendo.io.m0.h
        public T a() {
            try {
                return (T) this.f1365a.newInstance(new Object[0]);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Failed to invoke " + this.f1365a + " with no args", e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to invoke " + this.f1365a + " with no args", e3.getTargetException());
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class m<T> implements sdk.pendo.io.m0.h<T> {
        m() {
        }

        @Override // sdk.pendo.io.m0.h
        public T a() {
            return (T) new TreeSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class n<T> implements sdk.pendo.io.m0.h<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f1367a;

        n(Type type) {
            this.f1367a = type;
        }

        @Override // sdk.pendo.io.m0.h
        public T a() {
            Type type = this.f1367a;
            if (!(type instanceof ParameterizedType)) {
                throw new sdk.pendo.io.k0.j("Invalid EnumSet type: " + this.f1367a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            throw new sdk.pendo.io.k0.j("Invalid EnumSet type: " + this.f1367a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class o<T> implements sdk.pendo.io.m0.h<T> {
        o() {
        }

        @Override // sdk.pendo.io.m0.h
        public T a() {
            return (T) new LinkedHashSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class p<T> implements sdk.pendo.io.m0.h<T> {
        p() {
        }

        @Override // sdk.pendo.io.m0.h
        public T a() {
            return (T) new ArrayDeque();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class q<T> implements sdk.pendo.io.m0.h<T> {
        q() {
        }

        @Override // sdk.pendo.io.m0.h
        public T a() {
            return (T) new ArrayList();
        }
    }

    public c(Map<Type, sdk.pendo.io.k0.e<?>> map, boolean z) {
        this.f1353a = map;
        this.b = z;
    }

    private <T> sdk.pendo.io.m0.h<T> b(Class<? super T> cls) {
        return this.b ? new g(cls) : new h("Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public <T> sdk.pendo.io.m0.h<T> a(sdk.pendo.io.q0.a<T> aVar) {
        Type b2 = aVar.b();
        Class<? super T> a2 = aVar.a();
        sdk.pendo.io.k0.e<?> eVar = this.f1353a.get(b2);
        if (eVar != null) {
            return new i(eVar, b2);
        }
        sdk.pendo.io.k0.e<?> eVar2 = this.f1353a.get(a2);
        if (eVar2 != null) {
            return new j(eVar2, b2);
        }
        sdk.pendo.io.m0.h<T> a3 = a(a2);
        if (a3 != null) {
            return a3;
        }
        sdk.pendo.io.m0.h<T> a4 = a(b2, a2);
        return a4 != null ? a4 : b(a2);
    }

    public String toString() {
        return this.f1353a.toString();
    }

    private <T> sdk.pendo.io.m0.h<T> a(Class<? super T> cls) {
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            String b2 = sdk.pendo.io.p0.a.b(declaredConstructor);
            return b2 != null ? new k(b2) : new l(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> sdk.pendo.io.m0.h<T> a(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new m() : EnumSet.class.isAssignableFrom(cls) ? new n(type) : Set.class.isAssignableFrom(cls) ? new o() : Queue.class.isAssignableFrom(cls) ? new p() : new q();
        }
        if (Map.class.isAssignableFrom(cls)) {
            return cls == EnumMap.class ? new a(type) : ConcurrentNavigableMap.class.isAssignableFrom(cls) ? new b() : ConcurrentMap.class.isAssignableFrom(cls) ? new C0195c() : SortedMap.class.isAssignableFrom(cls) ? new d() : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(sdk.pendo.io.q0.a.a(((ParameterizedType) type).getActualTypeArguments()[0]).a())) ? new f() : new e();
        }
        return null;
    }
}
