package external.sdk.pendo.io.glide.load.model;

import androidx.core.util.Pools;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.data.a;
import external.sdk.pendo.io.glide.load.engine.n;
import external.sdk.pendo.io.glide.load.model.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import sdk.pendo.io.i0.j;
import sdk.pendo.io.q.f;

/* loaded from: classes2.dex */
class d<Model, Data> implements b<Model, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final List<b<Model, Data>> f687a;
    private final Pools.Pool<List<Throwable>> b;

    static class a<Data> implements external.sdk.pendo.io.glide.load.data.a<Data>, a.InterfaceC0055a<Data> {
        private int A;
        private final List<external.sdk.pendo.io.glide.load.data.a<Data>> f;
        private sdk.pendo.io.o.b f0;
        private final Pools.Pool<List<Throwable>> s;
        private a.InterfaceC0055a<? super Data> t0;
        private List<Throwable> u0;
        private boolean v0;

        a(List<external.sdk.pendo.io.glide.load.data.a<Data>> list, Pools.Pool<List<Throwable>> pool) {
            this.s = pool;
            j.a(list);
            this.f = list;
            this.A = 0;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a.InterfaceC0055a
        public void a(Data data) {
            if (data != null) {
                this.t0.a((a.InterfaceC0055a<? super Data>) data);
            } else {
                a();
            }
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cancel() {
            this.v0 = true;
            Iterator<external.sdk.pendo.io.glide.load.data.a<Data>> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cleanup() {
            List<Throwable> list = this.u0;
            if (list != null) {
                this.s.release(list);
            }
            this.u0 = null;
            Iterator<external.sdk.pendo.io.glide.load.data.a<Data>> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().cleanup();
            }
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public Class<Data> getDataClass() {
            return this.f.get(0).getDataClass();
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public sdk.pendo.io.q.a getDataSource() {
            return this.f.get(0).getDataSource();
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void loadData(sdk.pendo.io.o.b bVar, a.InterfaceC0055a<? super Data> interfaceC0055a) {
            this.f0 = bVar;
            this.t0 = interfaceC0055a;
            this.u0 = this.s.acquire();
            this.f.get(this.A).loadData(bVar, this);
            if (this.v0) {
                cancel();
            }
        }

        @Override // external.sdk.pendo.io.glide.load.data.a.InterfaceC0055a
        public void a(Exception exc) {
            ((List) j.a(this.u0)).add(exc);
            a();
        }

        private void a() {
            if (this.v0) {
                return;
            }
            if (this.A < this.f.size() - 1) {
                this.A++;
                loadData(this.f0, this.t0);
            } else {
                j.a(this.u0);
                this.t0.a((Exception) new n("Fetch failed", new ArrayList(this.u0)));
            }
        }
    }

    d(List<b<Model, Data>> list, Pools.Pool<List<Throwable>> pool) {
        this.f687a = list;
        this.b = pool;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public b.a<Data> buildLoadData(Model model, int i, int i2, Options options) {
        b.a<Data> buildLoadData;
        int size = this.f687a.size();
        ArrayList arrayList = new ArrayList(size);
        f fVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            b<Model, Data> bVar = this.f687a.get(i3);
            if (bVar.handles(model) && (buildLoadData = bVar.buildLoadData(model, i, i2, options)) != null) {
                fVar = buildLoadData.f683a;
                arrayList.add(buildLoadData.c);
            }
        }
        if (arrayList.isEmpty() || fVar == null) {
            return null;
        }
        return new b.a<>(fVar, new a(arrayList, this.b));
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(Model model) {
        Iterator<b<Model, Data>> it = this.f687a.iterator();
        while (it.hasNext()) {
            if (it.next().handles(model)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f687a.toArray()) + '}';
    }
}
