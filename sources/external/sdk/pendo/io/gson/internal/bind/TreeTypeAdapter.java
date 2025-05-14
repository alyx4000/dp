package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import sdk.pendo.io.k0.g;
import sdk.pendo.io.k0.h;
import sdk.pendo.io.k0.i;
import sdk.pendo.io.k0.o;
import sdk.pendo.io.k0.p;
import sdk.pendo.io.k0.u;
import sdk.pendo.io.m0.k;
import sdk.pendo.io.r0.c;

/* loaded from: classes2.dex */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {

    /* renamed from: a, reason: collision with root package name */
    private final p<T> f738a;
    private final h<T> b;
    final Gson c;
    private final sdk.pendo.io.q0.a<T> d;
    private final u e;
    private final TreeTypeAdapter<T>.b f = new b();
    private volatile TypeAdapter<T> g;

    private static final class SingleTypeFactory implements u {
        private final Class<?> A;
        private final sdk.pendo.io.q0.a<?> f;
        private final p<?> f0;
        private final boolean s;
        private final h<?> t0;

        SingleTypeFactory(Object obj, sdk.pendo.io.q0.a<?> aVar, boolean z, Class<?> cls) {
            p<?> pVar = obj instanceof p ? (p) obj : null;
            this.f0 = pVar;
            h<?> hVar = obj instanceof h ? (h) obj : null;
            this.t0 = hVar;
            sdk.pendo.io.m0.a.a((pVar == null && hVar == null) ? false : true);
            this.f = aVar;
            this.s = z;
            this.A = cls;
        }

        @Override // sdk.pendo.io.k0.u
        public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.q0.a<T> aVar) {
            sdk.pendo.io.q0.a<?> aVar2 = this.f;
            if (aVar2 != null ? aVar2.equals(aVar) || (this.s && this.f.b() == aVar.a()) : this.A.isAssignableFrom(aVar.a())) {
                return new TreeTypeAdapter(this.f0, this.t0, gson, aVar, this);
            }
            return null;
        }
    }

    private final class b implements o, g {
        private b() {
        }
    }

    public TreeTypeAdapter(p<T> pVar, h<T> hVar, Gson gson, sdk.pendo.io.q0.a<T> aVar, u uVar) {
        this.f738a = pVar;
        this.b = hVar;
        this.c = gson;
        this.d = aVar;
        this.e = uVar;
    }

    public static u a(sdk.pendo.io.q0.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, aVar.b() == aVar.a(), null);
    }

    private TypeAdapter<T> b() {
        TypeAdapter<T> typeAdapter = this.g;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> a2 = this.c.a(this.e, this.d);
        this.g = a2;
        return a2;
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public T a(sdk.pendo.io.r0.a aVar) {
        if (this.b == null) {
            return b().a(aVar);
        }
        i a2 = k.a(aVar);
        if (a2.i()) {
            return null;
        }
        return this.b.deserialize(a2, this.d.b(), this.f);
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public void a(c cVar, T t) {
        p<T> pVar = this.f738a;
        if (pVar == null) {
            b().a(cVar, t);
        } else if (t == null) {
            cVar.s();
        } else {
            k.a(pVar.a(t, this.d.b(), this.f), cVar);
        }
    }
}
