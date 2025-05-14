package sdk.pendo.io.w6;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import sdk.pendo.io.q6.a;
import sdk.pendo.io.q6.g;
import sdk.pendo.io.q6.i;
import sdk.pendo.io.x5.o;

/* loaded from: classes4.dex */
public final class a<T> extends d<T> {
    private static final Object[] w0 = new Object[0];
    static final C0266a[] x0 = new C0266a[0];
    static final C0266a[] y0 = new C0266a[0];
    final ReadWriteLock A;
    final AtomicReference<Object> f;
    final Lock f0;
    final AtomicReference<C0266a<T>[]> s;
    final Lock t0;
    final AtomicReference<Throwable> u0;
    long v0;

    /* renamed from: sdk.pendo.io.w6.a$a, reason: collision with other inner class name */
    static final class C0266a<T> implements sdk.pendo.io.b6.b, a.InterfaceC0228a<Object> {
        boolean A;
        final o<? super T> f;
        boolean f0;
        final a<T> s;
        sdk.pendo.io.q6.a<Object> t0;
        boolean u0;
        volatile boolean v0;
        long w0;

        C0266a(o<? super T> oVar, a<T> aVar) {
            this.f = oVar;
            this.s = aVar;
        }

        void a(Object obj, long j) {
            if (this.v0) {
                return;
            }
            if (!this.u0) {
                synchronized (this) {
                    if (this.v0) {
                        return;
                    }
                    if (this.w0 == j) {
                        return;
                    }
                    if (this.f0) {
                        sdk.pendo.io.q6.a<Object> aVar = this.t0;
                        if (aVar == null) {
                            aVar = new sdk.pendo.io.q6.a<>(4);
                            this.t0 = aVar;
                        }
                        aVar.a((sdk.pendo.io.q6.a<Object>) obj);
                        return;
                    }
                    this.A = true;
                    this.u0 = true;
                }
            }
            test(obj);
        }

        void b() {
            if (this.v0) {
                return;
            }
            synchronized (this) {
                if (this.v0) {
                    return;
                }
                if (this.A) {
                    return;
                }
                a<T> aVar = this.s;
                Lock lock = aVar.f0;
                lock.lock();
                this.w0 = aVar.v0;
                Object obj = aVar.f.get();
                lock.unlock();
                this.f0 = obj != null;
                this.A = true;
                if (obj == null || test(obj)) {
                    return;
                }
                c();
            }
        }

        void c() {
            sdk.pendo.io.q6.a<Object> aVar;
            while (!this.v0) {
                synchronized (this) {
                    aVar = this.t0;
                    if (aVar == null) {
                        this.f0 = false;
                        return;
                    }
                    this.t0 = null;
                }
                aVar.a((a.InterfaceC0228a<? super Object>) this);
            }
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            if (this.v0) {
                return;
            }
            this.v0 = true;
            this.s.b((C0266a) this);
        }

        @Override // sdk.pendo.io.q6.a.InterfaceC0228a, sdk.pendo.io.d6.j
        public boolean test(Object obj) {
            return this.v0 || i.a(obj, this.f);
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.v0;
        }
    }

    a() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.A = reentrantReadWriteLock;
        this.f0 = reentrantReadWriteLock.readLock();
        this.t0 = reentrantReadWriteLock.writeLock();
        this.s = new AtomicReference<>(x0);
        this.f = new AtomicReference<>();
        this.u0 = new AtomicReference<>();
    }

    public static <T> a<T> b(T t) {
        return new a<>(t);
    }

    public static <T> a<T> n() {
        return new a<>();
    }

    boolean a(C0266a<T> c0266a) {
        C0266a<T>[] c0266aArr;
        C0266a[] c0266aArr2;
        do {
            c0266aArr = this.s.get();
            if (c0266aArr == y0) {
                return false;
            }
            int length = c0266aArr.length;
            c0266aArr2 = new C0266a[length + 1];
            System.arraycopy(c0266aArr, 0, c0266aArr2, 0, length);
            c0266aArr2[length] = c0266a;
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.s, c0266aArr, c0266aArr2));
        return true;
    }

    void c(Object obj) {
        this.t0.lock();
        this.v0++;
        this.f.lazySet(obj);
        this.t0.unlock();
    }

    C0266a<T>[] d(Object obj) {
        AtomicReference<C0266a<T>[]> atomicReference = this.s;
        C0266a<T>[] c0266aArr = y0;
        C0266a<T>[] andSet = atomicReference.getAndSet(c0266aArr);
        if (andSet != c0266aArr) {
            c(obj);
        }
        return andSet;
    }

    public T o() {
        Object obj = this.f.get();
        if (i.b(obj) || i.c(obj)) {
            return null;
        }
        return (T) i.a(obj);
    }

    @Override // sdk.pendo.io.x5.o
    public void onComplete() {
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.u0, null, g.f1515a)) {
            Object a2 = i.a();
            for (C0266a<T> c0266a : d(a2)) {
                c0266a.a(a2, this.v0);
            }
        }
    }

    @Override // sdk.pendo.io.x5.o
    public void onError(Throwable th) {
        sdk.pendo.io.f6.b.a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.u0, null, th)) {
            sdk.pendo.io.t6.a.b(th);
            return;
        }
        Object a2 = i.a(th);
        for (C0266a<T> c0266a : d(a2)) {
            c0266a.a(a2, this.v0);
        }
    }

    @Override // sdk.pendo.io.x5.o
    public void onNext(T t) {
        sdk.pendo.io.f6.b.a((Object) t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.u0.get() != null) {
            return;
        }
        Object d = i.d(t);
        c(d);
        for (C0266a<T> c0266a : this.s.get()) {
            c0266a.a(d, this.v0);
        }
    }

    @Override // sdk.pendo.io.x5.o
    public void onSubscribe(sdk.pendo.io.b6.b bVar) {
        if (this.u0.get() != null) {
            bVar.dispose();
        }
    }

    public boolean p() {
        return i.b(this.f.get());
    }

    public boolean q() {
        Object obj = this.f.get();
        return (obj == null || i.b(obj) || i.c(obj)) ? false : true;
    }

    a(T t) {
        this();
        this.f.lazySet(sdk.pendo.io.f6.b.a((Object) t, "defaultValue is null"));
    }

    void b(C0266a<T> c0266a) {
        C0266a<T>[] c0266aArr;
        C0266a[] c0266aArr2;
        do {
            c0266aArr = this.s.get();
            int length = c0266aArr.length;
            if (length == 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (c0266aArr[i] == c0266a) {
                    break;
                } else {
                    i++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                c0266aArr2 = x0;
            } else {
                C0266a[] c0266aArr3 = new C0266a[length - 1];
                System.arraycopy(c0266aArr, 0, c0266aArr3, 0, i);
                System.arraycopy(c0266aArr, i + 1, c0266aArr3, i, (length - i) - 1);
                c0266aArr2 = c0266aArr3;
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.s, c0266aArr, c0266aArr2));
    }

    @Override // sdk.pendo.io.x5.j
    protected void b(o<? super T> oVar) {
        C0266a<T> c0266a = new C0266a<>(oVar, this);
        oVar.onSubscribe(c0266a);
        if (a((C0266a) c0266a)) {
            if (c0266a.v0) {
                b((C0266a) c0266a);
                return;
            } else {
                c0266a.b();
                return;
            }
        }
        Throwable th = this.u0.get();
        if (th == g.f1515a) {
            oVar.onComplete();
        } else {
            oVar.onError(th);
        }
    }
}
