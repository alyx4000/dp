package sdk.pendo.io.f2;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import sdk.pendo.io.f2.a;
import sdk.pendo.io.f2.b;

/* loaded from: classes6.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<Type, k<?>> f1072a;
    public k<sdk.pendo.io.b2.c> b;
    public k<sdk.pendo.io.b2.c> c;

    public j() {
        ConcurrentHashMap<Type, k<?>> concurrentHashMap = new ConcurrentHashMap<>(100);
        this.f1072a = concurrentHashMap;
        concurrentHashMap.put(Date.class, b.c);
        concurrentHashMap.put(int[].class, a.c);
        concurrentHashMap.put(Integer[].class, a.d);
        concurrentHashMap.put(short[].class, a.c);
        concurrentHashMap.put(Short[].class, a.d);
        concurrentHashMap.put(long[].class, a.k);
        concurrentHashMap.put(Long[].class, a.l);
        concurrentHashMap.put(byte[].class, a.g);
        concurrentHashMap.put(Byte[].class, a.h);
        concurrentHashMap.put(char[].class, a.i);
        concurrentHashMap.put(Character[].class, a.j);
        concurrentHashMap.put(float[].class, a.m);
        concurrentHashMap.put(Float[].class, a.n);
        concurrentHashMap.put(double[].class, a.o);
        concurrentHashMap.put(Double[].class, a.p);
        concurrentHashMap.put(boolean[].class, a.q);
        concurrentHashMap.put(Boolean[].class, a.r);
        this.b = new g(this);
        this.c = new i(this);
        concurrentHashMap.put(sdk.pendo.io.b2.c.class, this.b);
        concurrentHashMap.put(sdk.pendo.io.b2.b.class, this.b);
        concurrentHashMap.put(sdk.pendo.io.b2.a.class, this.b);
        concurrentHashMap.put(sdk.pendo.io.b2.d.class, this.b);
    }

    public <T> k<T> a(Class<T> cls) {
        k<T> kVar = (k) this.f1072a.get(cls);
        if (kVar != null) {
            return kVar;
        }
        if (cls instanceof Class) {
            if (Map.class.isAssignableFrom(cls)) {
                kVar = new h<>(this, cls);
            } else if (List.class.isAssignableFrom(cls)) {
                kVar = new h<>(this, cls);
            }
            if (kVar != null) {
                this.f1072a.put(cls, kVar);
                return kVar;
            }
        }
        k<T> qVar = cls.isArray() ? new a.q<>(this, cls) : List.class.isAssignableFrom(cls) ? new c<>(this, cls) : Map.class.isAssignableFrom(cls) ? new e<>(this, cls) : new b.C0132b<>(this, cls);
        this.f1072a.putIfAbsent(cls, qVar);
        return qVar;
    }

    public <T> k<T> a(ParameterizedType parameterizedType) {
        k<T> kVar = (k) this.f1072a.get(parameterizedType);
        if (kVar != null) {
            return kVar;
        }
        Class cls = (Class) parameterizedType.getRawType();
        if (List.class.isAssignableFrom(cls)) {
            kVar = new d<>(this, parameterizedType);
        } else if (Map.class.isAssignableFrom(cls)) {
            kVar = new f<>(this, parameterizedType);
        }
        this.f1072a.putIfAbsent(parameterizedType, kVar);
        return kVar;
    }

    public <T> k<T> a(Type type) {
        return type instanceof ParameterizedType ? a((ParameterizedType) type) : a((Class) type);
    }

    public <T> void a(Class<T> cls, k<T> kVar) {
        this.f1072a.put(cls, kVar);
    }
}
