package external.sdk.pendo.io.glide.load.engine;

import external.sdk.pendo.io.glide.load.data.a;
import external.sdk.pendo.io.glide.load.engine.e;
import external.sdk.pendo.io.glide.load.model.b;
import java.io.File;
import java.util.List;

/* loaded from: classes2.dex */
class r implements e, a.InterfaceC0055a<Object> {
    private int A;
    private final e.a f;
    private int f0 = -1;
    private final f<?> s;
    private sdk.pendo.io.q.f t0;
    private List<external.sdk.pendo.io.glide.load.model.b<File, ?>> u0;
    private int v0;
    private volatile b.a<?> w0;
    private File x0;
    private s y0;

    r(f<?> fVar, e.a aVar) {
        this.s = fVar;
        this.f = aVar;
    }

    private boolean a() {
        return this.v0 < this.u0.size();
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e
    public boolean b() {
        List<sdk.pendo.io.q.f> c = this.s.c();
        boolean z = false;
        if (c.isEmpty()) {
            return false;
        }
        List<Class<?>> k = this.s.k();
        if (k.isEmpty()) {
            if (File.class.equals(this.s.m())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.s.h() + " to " + this.s.m());
        }
        while (true) {
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
            if (i2 >= k.size()) {
                int i3 = this.A + 1;
                this.A = i3;
                if (i3 >= c.size()) {
                    return false;
                }
                this.f0 = 0;
            }
            sdk.pendo.io.q.f fVar = c.get(this.A);
            Class<?> cls = k.get(this.f0);
            this.y0 = new s(this.s.b(), fVar, this.s.l(), this.s.n(), this.s.f(), this.s.b(cls), cls, this.s.i());
            File file = this.s.d().get(this.y0);
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

    @Override // external.sdk.pendo.io.glide.load.data.a.InterfaceC0055a
    public void a(Object obj) {
        this.f.a(this.t0, obj, this.w0.c, sdk.pendo.io.q.a.RESOURCE_DISK_CACHE, this.y0);
    }

    @Override // external.sdk.pendo.io.glide.load.data.a.InterfaceC0055a
    public void a(Exception exc) {
        this.f.a(this.y0, exc, this.w0.c, sdk.pendo.io.q.a.RESOURCE_DISK_CACHE);
    }
}
