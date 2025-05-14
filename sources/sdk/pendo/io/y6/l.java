package sdk.pendo.io.y6;

import java.io.IOException;
import java.util.Objects;
import javax.annotation.Nullable;
import sdk.pendo.io.k3.a0;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.e;
import sdk.pendo.io.w2.e0;
import sdk.pendo.io.w2.x;

/* loaded from: classes4.dex */
final class l<T> implements sdk.pendo.io.y6.b<T> {
    private final e.a A;
    private final q f;
    private final f<e0, T> f0;
    private final Object[] s;
    private volatile boolean t0;

    @Nullable
    private sdk.pendo.io.w2.e u0;

    @Nullable
    private Throwable v0;
    private boolean w0;

    class a implements sdk.pendo.io.w2.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f1830a;

        a(d dVar) {
            this.f1830a = dVar;
        }

        private void a(Throwable th) {
            try {
                this.f1830a.a(l.this, th);
            } catch (Throwable th2) {
                w.a(th2);
                th2.printStackTrace();
            }
        }

        @Override // sdk.pendo.io.w2.f
        public void a(sdk.pendo.io.w2.e eVar, IOException iOException) {
            a(iOException);
        }

        @Override // sdk.pendo.io.w2.f
        public void a(sdk.pendo.io.w2.e eVar, d0 d0Var) {
            try {
                try {
                    this.f1830a.a(l.this, l.this.a(d0Var));
                } catch (Throwable th) {
                    w.a(th);
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                w.a(th2);
                a(th2);
            }
        }
    }

    static final class b extends e0 {
        private final sdk.pendo.io.k3.f A;

        @Nullable
        IOException f0;
        private final e0 s;

        class a extends sdk.pendo.io.k3.j {
            a(a0 a0Var) {
                super(a0Var);
            }

            @Override // sdk.pendo.io.k3.j, sdk.pendo.io.k3.a0
            public long c(sdk.pendo.io.k3.d dVar, long j) {
                try {
                    return super.c(dVar, j);
                } catch (IOException e) {
                    b.this.f0 = e;
                    throw e;
                }
            }
        }

        b(e0 e0Var) {
            this.s = e0Var;
            this.A = sdk.pendo.io.k3.o.a(new a(e0Var.getSource()));
        }

        @Override // sdk.pendo.io.w2.e0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.s.close();
        }

        @Override // sdk.pendo.io.w2.e0
        /* renamed from: m */
        public long getContentLength() {
            return this.s.getContentLength();
        }

        @Override // sdk.pendo.io.w2.e0
        /* renamed from: n */
        public x getS() {
            return this.s.getS();
        }

        @Override // sdk.pendo.io.w2.e0
        /* renamed from: o */
        public sdk.pendo.io.k3.f getSource() {
            return this.A;
        }

        void q() {
            IOException iOException = this.f0;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    static final class c extends e0 {
        private final long A;

        @Nullable
        private final x s;

        c(@Nullable x xVar, long j) {
            this.s = xVar;
            this.A = j;
        }

        @Override // sdk.pendo.io.w2.e0
        /* renamed from: m */
        public long getContentLength() {
            return this.A;
        }

        @Override // sdk.pendo.io.w2.e0
        /* renamed from: n */
        public x getS() {
            return this.s;
        }

        @Override // sdk.pendo.io.w2.e0
        /* renamed from: o */
        public sdk.pendo.io.k3.f getSource() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    l(q qVar, Object[] objArr, e.a aVar, f<e0, T> fVar) {
        this.f = qVar;
        this.s = objArr;
        this.A = aVar;
        this.f0 = fVar;
    }

    private sdk.pendo.io.w2.e d() {
        sdk.pendo.io.w2.e a2 = this.A.a(this.f.a(this.s));
        if (a2 != null) {
            return a2;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    private sdk.pendo.io.w2.e f() {
        sdk.pendo.io.w2.e eVar = this.u0;
        if (eVar != null) {
            return eVar;
        }
        Throwable th = this.v0;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            sdk.pendo.io.w2.e d = d();
            this.u0 = d;
            return d;
        } catch (IOException | Error | RuntimeException e) {
            w.a(e);
            this.v0 = e;
            throw e;
        }
    }

    @Override // sdk.pendo.io.y6.b
    public void a(d<T> dVar) {
        sdk.pendo.io.w2.e eVar;
        Throwable th;
        Objects.requireNonNull(dVar, "callback == null");
        synchronized (this) {
            if (this.w0) {
                throw new IllegalStateException("Already executed.");
            }
            this.w0 = true;
            eVar = this.u0;
            th = this.v0;
            if (eVar == null && th == null) {
                try {
                    sdk.pendo.io.w2.e d = d();
                    this.u0 = d;
                    eVar = d;
                } catch (Throwable th2) {
                    th = th2;
                    w.a(th);
                    this.v0 = th;
                }
            }
        }
        if (th != null) {
            dVar.a(this, th);
            return;
        }
        if (this.t0) {
            eVar.cancel();
        }
        eVar.a(new a(dVar));
    }

    @Override // sdk.pendo.io.y6.b
    public r<T> b() {
        sdk.pendo.io.w2.e f;
        synchronized (this) {
            if (this.w0) {
                throw new IllegalStateException("Already executed.");
            }
            this.w0 = true;
            f = f();
        }
        if (this.t0) {
            f.cancel();
        }
        return a(f.b());
    }

    @Override // sdk.pendo.io.y6.b
    /* renamed from: c, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public l<T> clone() {
        return new l<>(this.f, this.s, this.A, this.f0);
    }

    @Override // sdk.pendo.io.y6.b
    public void cancel() {
        sdk.pendo.io.w2.e eVar;
        this.t0 = true;
        synchronized (this) {
            eVar = this.u0;
        }
        if (eVar != null) {
            eVar.cancel();
        }
    }

    @Override // sdk.pendo.io.y6.b
    public boolean e() {
        boolean z = true;
        if (this.t0) {
            return true;
        }
        synchronized (this) {
            sdk.pendo.io.w2.e eVar = this.u0;
            if (eVar == null || !eVar.getCanceled()) {
                z = false;
            }
        }
        return z;
    }

    r<T> a(d0 d0Var) {
        e0 b2 = d0Var.b();
        d0 a2 = d0Var.v().a(new c(b2.getS(), b2.getContentLength())).a();
        int i = a2.getCom.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String();
        if (i < 200 || i >= 300) {
            try {
                return r.a(w.a(b2), a2);
            } finally {
                b2.close();
            }
        }
        if (i == 204 || i == 205) {
            b2.close();
            return r.a((Object) null, a2);
        }
        b bVar = new b(b2);
        try {
            return r.a(this.f0.convert(bVar), a2);
        } catch (RuntimeException e) {
            bVar.q();
            throw e;
        }
    }

    @Override // sdk.pendo.io.y6.b
    public synchronized b0 a() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create request.", e);
        }
        return f().getOriginalRequest();
    }
}
