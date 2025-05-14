package sdk.pendo.io.m6;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import sdk.pendo.io.g6.f;
import sdk.pendo.io.q6.l;

/* loaded from: classes6.dex */
public final class b<E> extends AtomicReferenceArray<E> implements f<E> {
    private static final Integer u0 = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    long A;
    final int f;
    final AtomicLong f0;
    final AtomicLong s;
    final int t0;

    public b(int i) {
        super(l.a(i));
        this.f = length() - 1;
        this.s = new AtomicLong();
        this.f0 = new AtomicLong();
        this.t0 = Math.min(i / 4, u0.intValue());
    }

    int a(long j) {
        return ((int) j) & this.f;
    }

    int a(long j, int i) {
        return ((int) j) & i;
    }

    E b(int i) {
        return get(i);
    }

    void c(long j) {
        this.s.lazySet(j);
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
        return this.s.get() == this.f0.get();
    }

    @Override // sdk.pendo.io.g6.g
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        int i = this.f;
        long j = this.s.get();
        int a2 = a(j, i);
        if (j >= this.A) {
            long j2 = this.t0 + j;
            if (b(a(j2, i)) == null) {
                this.A = j2;
            } else if (b(a2) != null) {
                return false;
            }
        }
        a(a2, (int) e);
        c(j + 1);
        return true;
    }

    @Override // sdk.pendo.io.g6.f, sdk.pendo.io.g6.g
    public E poll() {
        long j = this.f0.get();
        int a2 = a(j);
        E b = b(a2);
        if (b == null) {
            return null;
        }
        b(j + 1);
        a(a2, (int) null);
        return b;
    }

    void b(long j) {
        this.f0.lazySet(j);
    }

    void a(int i, E e) {
        lazySet(i, e);
    }
}
