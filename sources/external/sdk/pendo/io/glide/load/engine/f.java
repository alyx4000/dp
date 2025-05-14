package external.sdk.pendo.io.glide.load.engine;

import external.sdk.pendo.io.glide.Registry;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.ResourceEncoder;
import external.sdk.pendo.io.glide.load.Transformation;
import external.sdk.pendo.io.glide.load.engine.g;
import external.sdk.pendo.io.glide.load.model.b;
import external.sdk.pendo.io.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class f<Transcode> {

    /* renamed from: a, reason: collision with root package name */
    private final List<b.a<?>> f667a = new ArrayList();
    private final List<sdk.pendo.io.q.f> b = new ArrayList();
    private external.sdk.pendo.io.glide.b c;
    private Object d;
    private int e;
    private int f;
    private Class<?> g;
    private g.e h;
    private Options i;
    private Map<Class<?>, Transformation<?>> j;
    private Class<Transcode> k;
    private boolean l;
    private boolean m;
    private sdk.pendo.io.q.f n;
    private sdk.pendo.io.o.b o;
    private sdk.pendo.io.t.a p;
    private boolean q;
    private boolean r;

    f() {
    }

    void a() {
        this.c = null;
        this.d = null;
        this.n = null;
        this.g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.f667a.clear();
        this.l = false;
        this.b.clear();
        this.m = false;
    }

    sdk.pendo.io.u.a b() {
        return this.c.a();
    }

    List<sdk.pendo.io.q.f> c() {
        if (!this.m) {
            this.m = true;
            this.b.clear();
            List<b.a<?>> g = g();
            int size = g.size();
            for (int i = 0; i < size; i++) {
                b.a<?> aVar = g.get(i);
                if (!this.b.contains(aVar.f683a)) {
                    this.b.add(aVar.f683a);
                }
                for (int i2 = 0; i2 < aVar.b.size(); i2++) {
                    if (!this.b.contains(aVar.b.get(i2))) {
                        this.b.add(aVar.b.get(i2));
                    }
                }
            }
        }
        return this.b;
    }

    external.sdk.pendo.io.glide.load.engine.cache.a d() {
        return this.h.a();
    }

    sdk.pendo.io.t.a e() {
        return this.p;
    }

    int f() {
        return this.f;
    }

    List<b.a<?>> g() {
        if (!this.l) {
            this.l = true;
            this.f667a.clear();
            List a2 = this.c.g().a((Registry) this.d);
            int size = a2.size();
            for (int i = 0; i < size; i++) {
                b.a<?> buildLoadData = ((external.sdk.pendo.io.glide.load.model.b) a2.get(i)).buildLoadData(this.d, this.e, this.f, this.i);
                if (buildLoadData != null) {
                    this.f667a.add(buildLoadData);
                }
            }
        }
        return this.f667a;
    }

    Class<?> h() {
        return this.d.getClass();
    }

    Options i() {
        return this.i;
    }

    sdk.pendo.io.o.b j() {
        return this.o;
    }

    List<Class<?>> k() {
        return this.c.g().c(this.d.getClass(), this.g, this.k);
    }

    sdk.pendo.io.q.f l() {
        return this.n;
    }

    Class<?> m() {
        return this.k;
    }

    int n() {
        return this.e;
    }

    boolean o() {
        return this.r;
    }

    <Data> p<Data, ?, Transcode> a(Class<Data> cls) {
        return this.c.g().b(cls, this.g, this.k);
    }

    <Z> Transformation<Z> b(Class<Z> cls) {
        Transformation<Z> transformation = (Transformation) this.j.get(cls);
        if (transformation == null) {
            Iterator<Map.Entry<Class<?>, Transformation<?>>> it = this.j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, Transformation<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    transformation = (Transformation) next.getValue();
                    break;
                }
            }
        }
        if (transformation != null) {
            return transformation;
        }
        if (this.j.isEmpty() && this.q) {
            throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
        }
        return UnitTransformation.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean c(Class<?> cls) {
        return a((Class) cls) != null;
    }

    List<external.sdk.pendo.io.glide.load.model.b<File, ?>> a(File file) {
        return this.c.g().a((Registry) file);
    }

    boolean b(sdk.pendo.io.t.c<?> cVar) {
        return this.c.g().b(cVar);
    }

    <Z> ResourceEncoder<Z> a(sdk.pendo.io.t.c<Z> cVar) {
        return this.c.g().a((sdk.pendo.io.t.c) cVar);
    }

    <X> sdk.pendo.io.q.d<X> a(X x) {
        return this.c.g().c(x);
    }

    /* JADX WARN: Multi-variable type inference failed */
    <R> void a(external.sdk.pendo.io.glide.b bVar, Object obj, sdk.pendo.io.q.f fVar, int i, int i2, sdk.pendo.io.t.a aVar, Class<?> cls, Class<R> cls2, sdk.pendo.io.o.b bVar2, Options options, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, g.e eVar) {
        this.c = bVar;
        this.d = obj;
        this.n = fVar;
        this.e = i;
        this.f = i2;
        this.p = aVar;
        this.g = cls;
        this.h = eVar;
        this.k = cls2;
        this.o = bVar2;
        this.i = options;
        this.j = map;
        this.q = z;
        this.r = z2;
    }

    boolean a(sdk.pendo.io.q.f fVar) {
        List<b.a<?>> g = g();
        int size = g.size();
        for (int i = 0; i < size; i++) {
            if (g.get(i).f683a.equals(fVar)) {
                return true;
            }
        }
        return false;
    }
}
