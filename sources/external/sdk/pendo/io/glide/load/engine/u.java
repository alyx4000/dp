package external.sdk.pendo.io.glide.load.engine;

import android.util.Log;
import external.sdk.pendo.io.glide.load.data.a;
import external.sdk.pendo.io.glide.load.engine.e;
import external.sdk.pendo.io.glide.load.model.b;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
class u implements e, e.a {
    private int A;
    private final f<?> f;
    private b f0;
    private final e.a s;
    private Object t0;
    private volatile b.a<?> u0;
    private c v0;

    class a implements a.InterfaceC0055a<Object> {
        final /* synthetic */ b.a f;

        a(b.a aVar) {
            this.f = aVar;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a.InterfaceC0055a
        public void a(Object obj) {
            if (u.this.a(this.f)) {
                u.this.a(this.f, obj);
            }
        }

        @Override // external.sdk.pendo.io.glide.load.data.a.InterfaceC0055a
        public void a(Exception exc) {
            if (u.this.a(this.f)) {
                u.this.a(this.f, exc);
            }
        }
    }

    u(f<?> fVar, e.a aVar) {
        this.f = fVar;
        this.s = aVar;
    }

    private void a(Object obj) {
        long a2 = sdk.pendo.io.i0.f.a();
        try {
            sdk.pendo.io.q.d<X> a3 = this.f.a((f<?>) obj);
            d dVar = new d(a3, obj, this.f.i());
            this.v0 = new c(this.u0.f683a, this.f.l());
            this.f.d().put(this.v0, dVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.v0 + ", data: " + obj + ", encoder: " + a3 + ", duration: " + sdk.pendo.io.i0.f.a(a2));
            }
            this.u0.c.cleanup();
            this.f0 = new b(Collections.singletonList(this.u0.f683a), this.f, this);
        } catch (Throwable th) {
            this.u0.c.cleanup();
            throw th;
        }
    }

    private boolean c() {
        return this.A < this.f.g().size();
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e
    public boolean b() {
        Object obj = this.t0;
        if (obj != null) {
            this.t0 = null;
            a(obj);
        }
        b bVar = this.f0;
        if (bVar != null && bVar.b()) {
            return true;
        }
        this.f0 = null;
        this.u0 = null;
        boolean z = false;
        while (!z && c()) {
            List<b.a<?>> g = this.f.g();
            int i = this.A;
            this.A = i + 1;
            this.u0 = g.get(i);
            if (this.u0 != null && (this.f.e().a(this.u0.c.getDataSource()) || this.f.c(this.u0.c.getDataClass()))) {
                b(this.u0);
                z = true;
            }
        }
        return z;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e
    public void cancel() {
        b.a<?> aVar = this.u0;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    private void b(b.a<?> aVar) {
        this.u0.c.loadData(this.f.j(), new a(aVar));
    }

    boolean a(b.a<?> aVar) {
        b.a<?> aVar2 = this.u0;
        return aVar2 != null && aVar2 == aVar;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e.a
    public void a(sdk.pendo.io.q.f fVar, Exception exc, external.sdk.pendo.io.glide.load.data.a<?> aVar, sdk.pendo.io.q.a aVar2) {
        this.s.a(fVar, exc, aVar, this.u0.c.getDataSource());
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e.a
    public void a(sdk.pendo.io.q.f fVar, Object obj, external.sdk.pendo.io.glide.load.data.a<?> aVar, sdk.pendo.io.q.a aVar2, sdk.pendo.io.q.f fVar2) {
        this.s.a(fVar, obj, aVar, this.u0.c.getDataSource(), fVar);
    }

    void a(b.a<?> aVar, Object obj) {
        sdk.pendo.io.t.a e = this.f.e();
        if (obj != null && e.a(aVar.c.getDataSource())) {
            this.t0 = obj;
            this.s.a();
        } else {
            e.a aVar2 = this.s;
            sdk.pendo.io.q.f fVar = aVar.f683a;
            external.sdk.pendo.io.glide.load.data.a<?> aVar3 = aVar.c;
            aVar2.a(fVar, obj, aVar3, aVar3.getDataSource(), this.v0);
        }
    }

    void a(b.a<?> aVar, Exception exc) {
        e.a aVar2 = this.s;
        c cVar = this.v0;
        external.sdk.pendo.io.glide.load.data.a<?> aVar3 = aVar.c;
        aVar2.a(cVar, exc, aVar3, aVar3.getDataSource());
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e.a
    public void a() {
        throw new UnsupportedOperationException();
    }
}
