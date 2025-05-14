package sdk.pendo.io.j6;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
public final class b<T, C extends Collection<? super T>> extends sdk.pendo.io.j6.a<T, C> {
    final int A;
    final int f0;
    final Callable<C> t0;

    static final class a<T, C extends Collection<? super T>> implements sdk.pendo.io.x5.e<T>, sdk.pendo.io.w5.c {
        final int A;
        final sdk.pendo.io.w5.b<? super C> f;
        C f0;
        final Callable<C> s;
        sdk.pendo.io.w5.c t0;
        boolean u0;
        int v0;

        a(sdk.pendo.io.w5.b<? super C> bVar, int i, Callable<C> callable) {
            this.f = bVar;
            this.A = i;
            this.s = callable;
        }

        @Override // sdk.pendo.io.x5.e, sdk.pendo.io.w5.b
        public void a(sdk.pendo.io.w5.c cVar) {
            if (sdk.pendo.io.p6.c.a(this.t0, cVar)) {
                this.t0 = cVar;
                this.f.a(this);
            }
        }

        @Override // sdk.pendo.io.w5.c
        public void cancel() {
            this.t0.cancel();
        }

        @Override // sdk.pendo.io.w5.b
        public void onComplete() {
            if (this.u0) {
                return;
            }
            this.u0 = true;
            C c = this.f0;
            if (c != null && !c.isEmpty()) {
                this.f.onNext(c);
            }
            this.f.onComplete();
        }

        @Override // sdk.pendo.io.w5.b
        public void onError(Throwable th) {
            if (this.u0) {
                sdk.pendo.io.t6.a.b(th);
            } else {
                this.u0 = true;
                this.f.onError(th);
            }
        }

        @Override // sdk.pendo.io.w5.b
        public void onNext(T t) {
            if (this.u0) {
                return;
            }
            C c = this.f0;
            if (c == null) {
                try {
                    c = (C) sdk.pendo.io.f6.b.a(this.s.call(), "The bufferSupplier returned a null buffer");
                    this.f0 = c;
                } catch (Throwable th) {
                    sdk.pendo.io.c6.b.b(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            c.add(t);
            int i = this.v0 + 1;
            if (i != this.A) {
                this.v0 = i;
                return;
            }
            this.v0 = 0;
            this.f0 = null;
            this.f.onNext(c);
        }

        @Override // sdk.pendo.io.w5.c
        public void a(long j) {
            if (sdk.pendo.io.p6.c.c(j)) {
                this.t0.a(sdk.pendo.io.q6.d.b(j, this.A));
            }
        }
    }

    /* renamed from: sdk.pendo.io.j6.b$b, reason: collision with other inner class name */
    static final class C0162b<T, C extends Collection<? super T>> extends AtomicLong implements sdk.pendo.io.x5.e<T>, sdk.pendo.io.w5.c, sdk.pendo.io.d6.d {
        final int A;
        final sdk.pendo.io.w5.b<? super C> f;
        final int f0;
        final Callable<C> s;
        sdk.pendo.io.w5.c v0;
        boolean w0;
        int x0;
        volatile boolean y0;
        long z0;
        final AtomicBoolean u0 = new AtomicBoolean();
        final ArrayDeque<C> t0 = new ArrayDeque<>();

        C0162b(sdk.pendo.io.w5.b<? super C> bVar, int i, int i2, Callable<C> callable) {
            this.f = bVar;
            this.A = i;
            this.f0 = i2;
            this.s = callable;
        }

        @Override // sdk.pendo.io.x5.e, sdk.pendo.io.w5.b
        public void a(sdk.pendo.io.w5.c cVar) {
            if (sdk.pendo.io.p6.c.a(this.v0, cVar)) {
                this.v0 = cVar;
                this.f.a(this);
            }
        }

        @Override // sdk.pendo.io.w5.c
        public void cancel() {
            this.y0 = true;
            this.v0.cancel();
        }

        @Override // sdk.pendo.io.d6.d
        public boolean getAsBoolean() {
            return this.y0;
        }

        @Override // sdk.pendo.io.w5.b
        public void onComplete() {
            if (this.w0) {
                return;
            }
            this.w0 = true;
            long j = this.z0;
            if (j != 0) {
                sdk.pendo.io.q6.d.c(this, j);
            }
            sdk.pendo.io.q6.m.a(this.f, this.t0, this, this);
        }

        @Override // sdk.pendo.io.w5.b
        public void onError(Throwable th) {
            if (this.w0) {
                sdk.pendo.io.t6.a.b(th);
                return;
            }
            this.w0 = true;
            this.t0.clear();
            this.f.onError(th);
        }

        @Override // sdk.pendo.io.w5.b
        public void onNext(T t) {
            if (this.w0) {
                return;
            }
            ArrayDeque<C> arrayDeque = this.t0;
            int i = this.x0;
            int i2 = i + 1;
            if (i == 0) {
                try {
                    arrayDeque.offer((Collection) sdk.pendo.io.f6.b.a(this.s.call(), "The bufferSupplier returned a null buffer"));
                } catch (Throwable th) {
                    sdk.pendo.io.c6.b.b(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            Collection collection = (Collection) arrayDeque.peek();
            if (collection != null && collection.size() + 1 == this.A) {
                arrayDeque.poll();
                collection.add(t);
                this.z0++;
                this.f.onNext(collection);
            }
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                ((Collection) it.next()).add(t);
            }
            if (i2 == this.f0) {
                i2 = 0;
            }
            this.x0 = i2;
        }

        @Override // sdk.pendo.io.w5.c
        public void a(long j) {
            long b;
            if (!sdk.pendo.io.p6.c.c(j) || sdk.pendo.io.q6.m.b(j, this.f, this.t0, this, this)) {
                return;
            }
            if (this.u0.get() || !this.u0.compareAndSet(false, true)) {
                b = sdk.pendo.io.q6.d.b(this.f0, j);
            } else {
                b = sdk.pendo.io.q6.d.a(this.A, sdk.pendo.io.q6.d.b(this.f0, j - 1));
            }
            this.v0.a(b);
        }
    }

    static final class c<T, C extends Collection<? super T>> extends AtomicInteger implements sdk.pendo.io.x5.e<T>, sdk.pendo.io.w5.c {
        final int A;
        final sdk.pendo.io.w5.b<? super C> f;
        final int f0;
        final Callable<C> s;
        C t0;
        sdk.pendo.io.w5.c u0;
        boolean v0;
        int w0;

        c(sdk.pendo.io.w5.b<? super C> bVar, int i, int i2, Callable<C> callable) {
            this.f = bVar;
            this.A = i;
            this.f0 = i2;
            this.s = callable;
        }

        @Override // sdk.pendo.io.x5.e, sdk.pendo.io.w5.b
        public void a(sdk.pendo.io.w5.c cVar) {
            if (sdk.pendo.io.p6.c.a(this.u0, cVar)) {
                this.u0 = cVar;
                this.f.a(this);
            }
        }

        @Override // sdk.pendo.io.w5.c
        public void cancel() {
            this.u0.cancel();
        }

        @Override // sdk.pendo.io.w5.b
        public void onComplete() {
            if (this.v0) {
                return;
            }
            this.v0 = true;
            C c = this.t0;
            this.t0 = null;
            if (c != null) {
                this.f.onNext(c);
            }
            this.f.onComplete();
        }

        @Override // sdk.pendo.io.w5.b
        public void onError(Throwable th) {
            if (this.v0) {
                sdk.pendo.io.t6.a.b(th);
                return;
            }
            this.v0 = true;
            this.t0 = null;
            this.f.onError(th);
        }

        @Override // sdk.pendo.io.w5.b
        public void onNext(T t) {
            if (this.v0) {
                return;
            }
            C c = this.t0;
            int i = this.w0;
            int i2 = i + 1;
            if (i == 0) {
                try {
                    c = (C) sdk.pendo.io.f6.b.a(this.s.call(), "The bufferSupplier returned a null buffer");
                    this.t0 = c;
                } catch (Throwable th) {
                    sdk.pendo.io.c6.b.b(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            if (c != null) {
                c.add(t);
                if (c.size() == this.A) {
                    this.t0 = null;
                    this.f.onNext(c);
                }
            }
            if (i2 == this.f0) {
                i2 = 0;
            }
            this.w0 = i2;
        }

        @Override // sdk.pendo.io.w5.c
        public void a(long j) {
            if (sdk.pendo.io.p6.c.c(j)) {
                if (get() != 0 || !compareAndSet(0, 1)) {
                    this.u0.a(sdk.pendo.io.q6.d.b(this.f0, j));
                    return;
                }
                this.u0.a(sdk.pendo.io.q6.d.a(sdk.pendo.io.q6.d.b(j, this.A), sdk.pendo.io.q6.d.b(this.f0 - this.A, j - 1)));
            }
        }
    }

    public b(sdk.pendo.io.x5.d<T> dVar, int i, int i2, Callable<C> callable) {
        super(dVar);
        this.A = i;
        this.f0 = i2;
        this.t0 = callable;
    }

    @Override // sdk.pendo.io.x5.d
    public void b(sdk.pendo.io.w5.b<? super C> bVar) {
        sdk.pendo.io.x5.d<T> dVar;
        sdk.pendo.io.x5.e<? super T> c0162b;
        int i = this.A;
        int i2 = this.f0;
        if (i == i2) {
            this.s.a((sdk.pendo.io.x5.e) new a(bVar, i, this.t0));
            return;
        }
        if (i2 > i) {
            dVar = this.s;
            c0162b = new c<>(bVar, this.A, this.f0, this.t0);
        } else {
            dVar = this.s;
            c0162b = new C0162b<>(bVar, this.A, this.f0, this.t0);
        }
        dVar.a((sdk.pendo.io.x5.e) c0162b);
    }
}
