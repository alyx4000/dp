package sdk.pendo.io.m6;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import sdk.pendo.io.g6.f;
import sdk.pendo.io.q6.l;

/* loaded from: classes6.dex */
public final class c<T> implements f<T> {
    static final int x0 = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object y0 = new Object();
    long A;
    final int f0;
    int s;
    AtomicReferenceArray<Object> t0;
    final int u0;
    AtomicReferenceArray<Object> v0;
    final AtomicLong f = new AtomicLong();
    final AtomicLong w0 = new AtomicLong();

    public c(int i) {
        int a2 = l.a(Math.max(8, i));
        int i2 = a2 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a2 + 1);
        this.t0 = atomicReferenceArray;
        this.f0 = i2;
        b(a2);
        this.v0 = atomicReferenceArray;
        this.u0 = i2;
        this.A = i2 - 1;
        b(0L);
    }

    private static int a(long j, int i) {
        return c(((int) j) & i);
    }

    private void b(int i) {
        this.s = Math.min(i / 4, x0);
    }

    private static int c(int i) {
        return i;
    }

    private long d() {
        return this.f.get();
    }

    @Override // sdk.pendo.io.g6.g
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // sdk.pendo.io.g6.g
    public boolean isEmpty() {
        return d() == c();
    }

    @Override // sdk.pendo.io.g6.g
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.t0;
        long b = b();
        int i = this.f0;
        int a2 = a(b, i);
        if (b < this.A) {
            return a(atomicReferenceArray, t, b, a2);
        }
        long j = this.s + b;
        if (a(atomicReferenceArray, a(j, i)) == null) {
            this.A = j - 1;
            return a(atomicReferenceArray, t, b, a2);
        }
        if (a(atomicReferenceArray, a(1 + b, i)) == null) {
            return a(atomicReferenceArray, t, b, a2);
        }
        a(atomicReferenceArray, b, a2, t, i);
        return true;
    }

    @Override // sdk.pendo.io.g6.f, sdk.pendo.io.g6.g
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.v0;
        long a2 = a();
        int i = this.u0;
        int a3 = a(a2, i);
        T t = (T) a(atomicReferenceArray, a3);
        boolean z = t == y0;
        if (t == null || z) {
            if (z) {
                return a(b(atomicReferenceArray, i + 1), a2, i);
            }
            return null;
        }
        a(atomicReferenceArray, a3, (Object) null);
        a(a2 + 1);
        return t;
    }

    private long a() {
        return this.w0.get();
    }

    private long b() {
        return this.f.get();
    }

    private long c() {
        return this.w0.get();
    }

    private static <E> Object a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    private AtomicReferenceArray<Object> b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int c = c(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) a(atomicReferenceArray, c);
        a(atomicReferenceArray, c, (Object) null);
        return atomicReferenceArray2;
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.v0 = atomicReferenceArray;
        int a2 = a(j, i);
        T t = (T) a(atomicReferenceArray, a2);
        if (t != null) {
            a(atomicReferenceArray, a2, (Object) null);
            a(j + 1);
        }
        return t;
    }

    private void b(long j) {
        this.f.lazySet(j);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.t0 = atomicReferenceArray2;
        this.A = (j2 + j) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, y0);
        b(j + 1);
    }

    private void a(long j) {
        this.w0.lazySet(j);
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, c(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        a(atomicReferenceArray, i, t);
        b(j + 1);
        return true;
    }
}
