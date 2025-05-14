package external.sdk.pendo.io.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import external.sdk.pendo.io.glide.Registry;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.ResourceEncoder;
import external.sdk.pendo.io.glide.load.Transformation;
import external.sdk.pendo.io.glide.load.engine.e;
import external.sdk.pendo.io.glide.load.engine.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import sdk.pendo.io.j0.a;

/* loaded from: classes2.dex */
class g<R> implements e.a, Runnable, Comparable<g<?>>, a.f {
    private int A0;
    private int B0;
    private sdk.pendo.io.t.a C0;
    private Options D0;
    private b<R> E0;
    private int F0;
    private h G0;
    private EnumC0061g H0;
    private long I0;
    private boolean J0;
    private Object K0;
    private Thread L0;
    private sdk.pendo.io.q.f M0;
    private sdk.pendo.io.q.f N0;
    private Object O0;
    private sdk.pendo.io.q.a P0;
    private external.sdk.pendo.io.glide.load.data.a<?> Q0;
    private volatile external.sdk.pendo.io.glide.load.engine.e R0;
    private volatile boolean S0;
    private volatile boolean T0;
    private boolean U0;
    private final e f0;
    private final Pools.Pool<g<?>> t0;
    private external.sdk.pendo.io.glide.b w0;
    private sdk.pendo.io.q.f x0;
    private sdk.pendo.io.o.b y0;
    private k z0;
    private final external.sdk.pendo.io.glide.load.engine.f<R> f = new external.sdk.pendo.io.glide.load.engine.f<>();
    private final List<Throwable> s = new ArrayList();
    private final sdk.pendo.io.j0.c A = sdk.pendo.io.j0.c.a();
    private final d<?> u0 = new d<>();
    private final f v0 = new f();

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f668a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[sdk.pendo.io.q.c.values().length];
            c = iArr;
            try {
                iArr[sdk.pendo.io.q.c.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[sdk.pendo.io.q.c.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[h.values().length];
            b = iArr2;
            try {
                iArr2[h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[EnumC0061g.values().length];
            f668a = iArr3;
            try {
                iArr3[EnumC0061g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f668a[EnumC0061g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f668a[EnumC0061g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    interface b<R> {
        void a(g<?> gVar);

        void onLoadFailed(n nVar);

        void onResourceReady(sdk.pendo.io.t.c<R> cVar, sdk.pendo.io.q.a aVar, boolean z);
    }

    private final class c<Z> implements h.a<Z> {

        /* renamed from: a, reason: collision with root package name */
        private final sdk.pendo.io.q.a f669a;

        c(sdk.pendo.io.q.a aVar) {
            this.f669a = aVar;
        }

        @Override // external.sdk.pendo.io.glide.load.engine.h.a
        public sdk.pendo.io.t.c<Z> a(sdk.pendo.io.t.c<Z> cVar) {
            return g.this.a(this.f669a, cVar);
        }
    }

    private static class d<Z> {

        /* renamed from: a, reason: collision with root package name */
        private sdk.pendo.io.q.f f670a;
        private ResourceEncoder<Z> b;
        private q<Z> c;

        d() {
        }

        void a() {
            this.f670a = null;
            this.b = null;
            this.c = null;
        }

        boolean b() {
            return this.c != null;
        }

        void a(e eVar, Options options) {
            sdk.pendo.io.j0.b.a("DecodeJob.encode");
            try {
                eVar.a().put(this.f670a, new external.sdk.pendo.io.glide.load.engine.d(this.b, this.c, options));
            } finally {
                this.c.c();
                sdk.pendo.io.j0.b.a();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void a(sdk.pendo.io.q.f fVar, ResourceEncoder<X> resourceEncoder, q<X> qVar) {
            this.f670a = fVar;
            this.b = resourceEncoder;
            this.c = qVar;
        }
    }

    interface e {
        external.sdk.pendo.io.glide.load.engine.cache.a a();
    }

    private static class f {

        /* renamed from: a, reason: collision with root package name */
        private boolean f671a;
        private boolean b;
        private boolean c;

        f() {
        }

        private boolean a(boolean z) {
            return (this.c || z || this.b) && this.f671a;
        }

        synchronized boolean b() {
            this.c = true;
            return a(false);
        }

        synchronized void c() {
            this.b = false;
            this.f671a = false;
            this.c = false;
        }

        synchronized boolean a() {
            this.b = true;
            return a(false);
        }

        synchronized boolean b(boolean z) {
            this.f671a = true;
            return a(z);
        }
    }

    /* renamed from: external.sdk.pendo.io.glide.load.engine.g$g, reason: collision with other inner class name */
    private enum EnumC0061g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    private enum h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    g(e eVar, Pools.Pool<g<?>> pool) {
        this.f0 = eVar;
        this.t0 = pool;
    }

    private void d() {
        sdk.pendo.io.t.c<R> cVar;
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Retrieved data", this.I0, "data: " + this.O0 + ", cache key: " + this.M0 + ", fetcher: " + this.Q0);
        }
        try {
            cVar = a(this.Q0, (external.sdk.pendo.io.glide.load.data.a<?>) this.O0, this.P0);
        } catch (n e2) {
            e2.a(this.N0, this.P0);
            this.s.add(e2);
            cVar = null;
        }
        if (cVar != null) {
            b(cVar, this.P0, this.U0);
        } else {
            k();
        }
    }

    private external.sdk.pendo.io.glide.load.engine.e e() {
        int i = a.b[this.G0.ordinal()];
        if (i == 1) {
            return new r(this.f, this);
        }
        if (i == 2) {
            return new external.sdk.pendo.io.glide.load.engine.b(this.f, this);
        }
        if (i == 3) {
            return new u(this.f, this);
        }
        if (i == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.G0);
    }

    private int f() {
        return this.y0.ordinal();
    }

    private void g() {
        m();
        this.E0.onLoadFailed(new n("Failed to load resource", new ArrayList(this.s)));
        i();
    }

    private void h() {
        if (this.v0.a()) {
            j();
        }
    }

    private void i() {
        if (this.v0.b()) {
            j();
        }
    }

    private void j() {
        this.v0.c();
        this.u0.a();
        this.f.a();
        this.S0 = false;
        this.w0 = null;
        this.x0 = null;
        this.D0 = null;
        this.y0 = null;
        this.z0 = null;
        this.E0 = null;
        this.G0 = null;
        this.R0 = null;
        this.L0 = null;
        this.M0 = null;
        this.O0 = null;
        this.P0 = null;
        this.Q0 = null;
        this.I0 = 0L;
        this.T0 = false;
        this.K0 = null;
        this.s.clear();
        this.t0.release(this);
    }

    private void k() {
        this.L0 = Thread.currentThread();
        this.I0 = sdk.pendo.io.i0.f.a();
        boolean z = false;
        while (!this.T0 && this.R0 != null && !(z = this.R0.b())) {
            this.G0 = a(this.G0);
            this.R0 = e();
            if (this.G0 == h.SOURCE) {
                a();
                return;
            }
        }
        if ((this.G0 == h.FINISHED || this.T0) && !z) {
            g();
        }
    }

    private void l() {
        int i = a.f668a[this.H0.ordinal()];
        if (i == 1) {
            this.G0 = a(h.INITIALIZE);
            this.R0 = e();
        } else if (i != 2) {
            if (i != 3) {
                throw new IllegalStateException("Unrecognized run reason: " + this.H0);
            }
            d();
            return;
        }
        k();
    }

    private void m() {
        Throwable th;
        this.A.b();
        if (!this.S0) {
            this.S0 = true;
            return;
        }
        if (this.s.isEmpty()) {
            th = null;
        } else {
            List<Throwable> list = this.s;
            th = list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(g<?> gVar) {
        int f2 = f() - gVar.f();
        return f2 == 0 ? this.F0 - gVar.F0 : f2;
    }

    @Override // sdk.pendo.io.j0.a.f
    public sdk.pendo.io.j0.c b() {
        return this.A;
    }

    public void c() {
        this.T0 = true;
        external.sdk.pendo.io.glide.load.engine.e eVar = this.R0;
        if (eVar != null) {
            eVar.cancel();
        }
    }

    boolean n() {
        h a2 = a(h.INITIALIZE);
        return a2 == h.RESOURCE_CACHE || a2 == h.DATA_CACHE;
    }

    @Override // java.lang.Runnable
    public void run() {
        sdk.pendo.io.j0.b.a("DecodeJob#run(model=%s)", this.K0);
        external.sdk.pendo.io.glide.load.data.a<?> aVar = this.Q0;
        try {
            try {
                try {
                    if (this.T0) {
                        g();
                        if (aVar != null) {
                            aVar.cleanup();
                        }
                        sdk.pendo.io.j0.b.a();
                        return;
                    }
                    l();
                    if (aVar != null) {
                        aVar.cleanup();
                    }
                    sdk.pendo.io.j0.b.a();
                } catch (Throwable th) {
                    if (Log.isLoggable("DecodeJob", 3)) {
                        Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.T0 + ", stage: " + this.G0, th);
                    }
                    if (this.G0 != h.ENCODE) {
                        this.s.add(th);
                        g();
                    }
                    throw th;
                }
            } catch (external.sdk.pendo.io.glide.load.engine.a e2) {
                throw e2;
            }
        } catch (Throwable th2) {
            if (aVar != null) {
                aVar.cleanup();
            }
            sdk.pendo.io.j0.b.a();
            throw th2;
        }
    }

    private <Data> sdk.pendo.io.t.c<R> a(external.sdk.pendo.io.glide.load.data.a<?> aVar, Data data, sdk.pendo.io.q.a aVar2) {
        if (data == null) {
            aVar.cleanup();
            return null;
        }
        try {
            long a2 = sdk.pendo.io.i0.f.a();
            sdk.pendo.io.t.c<R> a3 = a((g<R>) data, aVar2);
            if (Log.isLoggable("DecodeJob", 2)) {
                a("Decoded result " + a3, a2);
            }
            return a3;
        } finally {
            aVar.cleanup();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(sdk.pendo.io.t.c<R> cVar, sdk.pendo.io.q.a aVar, boolean z) {
        q qVar;
        if (cVar instanceof sdk.pendo.io.t.b) {
            ((sdk.pendo.io.t.b) cVar).initialize();
        }
        if (this.u0.b()) {
            cVar = q.b(cVar);
            qVar = cVar;
        } else {
            qVar = 0;
        }
        a(cVar, aVar, z);
        this.G0 = h.ENCODE;
        try {
            if (this.u0.b()) {
                this.u0.a(this.f0, this.D0);
            }
            h();
        } finally {
            if (qVar != 0) {
                qVar.c();
            }
        }
    }

    private <Data> sdk.pendo.io.t.c<R> a(Data data, sdk.pendo.io.q.a aVar) {
        return a((g<R>) data, aVar, (p<g<R>, ResourceType, R>) this.f.a((Class) data.getClass()));
    }

    private h a(h hVar) {
        int i = a.b[hVar.ordinal()];
        if (i == 1) {
            return this.C0.a() ? h.DATA_CACHE : a(h.DATA_CACHE);
        }
        if (i == 2) {
            return this.J0 ? h.FINISHED : h.SOURCE;
        }
        if (i == 3 || i == 4) {
            return h.FINISHED;
        }
        if (i == 5) {
            return this.C0.b() ? h.RESOURCE_CACHE : a(h.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + hVar);
    }

    private Options a(sdk.pendo.io.q.a aVar) {
        Options options = this.D0;
        boolean z = aVar == sdk.pendo.io.q.a.RESOURCE_DISK_CACHE || this.f.o();
        sdk.pendo.io.q.g<Boolean> gVar = external.sdk.pendo.io.glide.load.resource.bitmap.b.j;
        Boolean bool = (Boolean) options.get(gVar);
        if (bool != null && (!bool.booleanValue() || z)) {
            return options;
        }
        Options options2 = new Options();
        options2.putAll(this.D0);
        options2.set(gVar, Boolean.valueOf(z));
        return options2;
    }

    g<R> a(external.sdk.pendo.io.glide.b bVar, Object obj, k kVar, sdk.pendo.io.q.f fVar, int i, int i2, Class<?> cls, Class<R> cls2, sdk.pendo.io.o.b bVar2, sdk.pendo.io.t.a aVar, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options options, b<R> bVar3, int i3) {
        this.f.a(bVar, obj, fVar, i, i2, aVar, cls, cls2, bVar2, options, map, z, z2, this.f0);
        this.w0 = bVar;
        this.x0 = fVar;
        this.y0 = bVar2;
        this.z0 = kVar;
        this.A0 = i;
        this.B0 = i2;
        this.C0 = aVar;
        this.J0 = z3;
        this.D0 = options;
        this.E0 = bVar3;
        this.F0 = i3;
        this.H0 = EnumC0061g.INITIALIZE;
        this.K0 = obj;
        return this;
    }

    private void a(String str, long j) {
        a(str, j, (String) null);
    }

    private void a(String str, long j, String str2) {
        Log.v("DecodeJob", str + " in " + sdk.pendo.io.i0.f.a(j) + ", load key: " + this.z0 + (str2 != null ? ", " + str2 : "") + ", thread: " + Thread.currentThread().getName());
    }

    private void a(sdk.pendo.io.t.c<R> cVar, sdk.pendo.io.q.a aVar, boolean z) {
        m();
        this.E0.onResourceReady(cVar, aVar, z);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e.a
    public void a(sdk.pendo.io.q.f fVar, Exception exc, external.sdk.pendo.io.glide.load.data.a<?> aVar, sdk.pendo.io.q.a aVar2) {
        aVar.cleanup();
        n nVar = new n("Fetching data failed", exc);
        nVar.a(fVar, aVar2, aVar.getDataClass());
        this.s.add(nVar);
        if (Thread.currentThread() == this.L0) {
            k();
        } else {
            this.H0 = EnumC0061g.SWITCH_TO_SOURCE_SERVICE;
            this.E0.a(this);
        }
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e.a
    public void a(sdk.pendo.io.q.f fVar, Object obj, external.sdk.pendo.io.glide.load.data.a<?> aVar, sdk.pendo.io.q.a aVar2, sdk.pendo.io.q.f fVar2) {
        this.M0 = fVar;
        this.O0 = obj;
        this.Q0 = aVar;
        this.P0 = aVar2;
        this.N0 = fVar2;
        this.U0 = fVar != this.f.c().get(0);
        if (Thread.currentThread() != this.L0) {
            this.H0 = EnumC0061g.DECODE_DATA;
            this.E0.a(this);
        } else {
            sdk.pendo.io.j0.b.a("DecodeJob.decodeFromRetrievedData");
            try {
                d();
            } finally {
                sdk.pendo.io.j0.b.a();
            }
        }
    }

    <Z> sdk.pendo.io.t.c<Z> a(sdk.pendo.io.q.a aVar, sdk.pendo.io.t.c<Z> cVar) {
        sdk.pendo.io.t.c<Z> cVar2;
        Transformation<Z> transformation;
        sdk.pendo.io.q.c cVar3;
        sdk.pendo.io.q.f cVar4;
        Class<?> cls = cVar.get().getClass();
        ResourceEncoder<Z> resourceEncoder = null;
        if (aVar != sdk.pendo.io.q.a.RESOURCE_DISK_CACHE) {
            Transformation<Z> b2 = this.f.b(cls);
            transformation = b2;
            cVar2 = b2.transform(this.w0, cVar, this.A0, this.B0);
        } else {
            cVar2 = cVar;
            transformation = null;
        }
        if (!cVar.equals(cVar2)) {
            cVar.recycle();
        }
        if (this.f.b((sdk.pendo.io.t.c<?>) cVar2)) {
            resourceEncoder = this.f.a((sdk.pendo.io.t.c) cVar2);
            cVar3 = resourceEncoder.getEncodeStrategy(this.D0);
        } else {
            cVar3 = sdk.pendo.io.q.c.NONE;
        }
        ResourceEncoder resourceEncoder2 = resourceEncoder;
        if (!this.C0.a(!this.f.a(this.M0), aVar, cVar3)) {
            return cVar2;
        }
        if (resourceEncoder2 == null) {
            throw new Registry.NoResultEncoderAvailableException(cVar2.get().getClass());
        }
        int i = a.c[cVar3.ordinal()];
        if (i == 1) {
            cVar4 = new external.sdk.pendo.io.glide.load.engine.c(this.M0, this.x0);
        } else {
            if (i != 2) {
                throw new IllegalArgumentException("Unknown strategy: " + cVar3);
            }
            cVar4 = new s(this.f.b(), this.M0, this.x0, this.A0, this.B0, transformation, cls, this.D0);
        }
        q b3 = q.b(cVar2);
        this.u0.a(cVar4, resourceEncoder2, b3);
        return b3;
    }

    void a(boolean z) {
        if (this.v0.b(z)) {
            j();
        }
    }

    @Override // external.sdk.pendo.io.glide.load.engine.e.a
    public void a() {
        this.H0 = EnumC0061g.SWITCH_TO_SOURCE_SERVICE;
        this.E0.a(this);
    }

    private <Data, ResourceType> sdk.pendo.io.t.c<R> a(Data data, sdk.pendo.io.q.a aVar, p<Data, ResourceType, R> pVar) {
        Options a2 = a(aVar);
        external.sdk.pendo.io.glide.load.data.b<Data> b2 = this.w0.g().b((Registry) data);
        try {
            return pVar.a(b2, a2, this.A0, this.B0, new c(aVar));
        } finally {
            b2.cleanup();
        }
    }
}
