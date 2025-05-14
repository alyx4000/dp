package external.sdk.pendo.io.glide.load.engine;

import external.sdk.pendo.io.glide.load.data.a;
import external.sdk.pendo.io.glide.load.engine.e;
import external.sdk.pendo.io.glide.load.model.b;
import java.io.File;
import java.util.List;

/* loaded from: classes2.dex */
class b implements e, a.InterfaceC0055a<Object> {
    private final e.a A;
    private final List<sdk.pendo.io.q.f> f;
    private int f0;
    private final f<?> s;
    private sdk.pendo.io.q.f t0;
    private List<external.sdk.pendo.io.glide.load.model.b<File, ?>> u0;
    private int v0;
    private volatile b.a<?> w0;
    private File x0;

    b(f<?> fVar, e.a aVar) {
        this(fVar.c(), fVar, aVar);
    }

    private boolean a() {
        return this.v0 < this.u0.size();
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e
    public boolean b() {
        while (true) {
            boolean z = false;
            if (this.u0 != null && a()) {
                this.w0 = null;
                while (!z && a()) {
                    List<external.sdk.pendo.io.glide.load.model.b<File, ?>> list = this.u0;
                    int i = this.v0;
                    this.v0 = i + 1;
                    this.w0 = list.get(i).buildLoadData(this.x0, this.s.n(), this.s.f(), this.s.i());
                    if (this.w0 != null && this.s.c(this.w0.c.getDataClass())) {
                        this.w0.c.loadData(this.s.j(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.f0 + 1;
            this.f0 = i2;
            if (i2 >= this.f.size()) {
                return false;
            }
            sdk.pendo.io.q.f fVar = this.f.get(this.f0);
            File file = this.s.d().get(new c(fVar, this.s.l()));
            this.x0 = file;
            if (file != null) {
                this.t0 = fVar;
                this.u0 = this.s.a(file);
                this.v0 = 0;
            }
        }
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e
    public void cancel() {
        b.a<?> aVar = this.w0;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    b(List<sdk.pendo.io.q.f> list, f<?> fVar, e.a aVar) {
        this.f0 = -1;
        this.f = list;
        this.s = fVar;
        this.A = aVar;
    }

    @Override // external.sdk.pendo.io.glide.load.data.a.InterfaceC0055a
    public void a(Object obj) {
        this.A.a(this.t0, obj, this.w0.c, sdk.pendo.io.q.a.DATA_DISK_CACHE, this.t0);
    }

    @Override // external.sdk.pendo.io.glide.load.data.a.InterfaceC0055a
    public void a(Exception exc) {
        this.A.a(this.t0, exc, this.w0.c, sdk.pendo.io.q.a.DATA_DISK_CACHE);
    }
}
