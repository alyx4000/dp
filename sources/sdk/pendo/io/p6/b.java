package sdk.pendo.io.p6;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.q6.d;

/* loaded from: classes6.dex */
public class b extends AtomicInteger implements sdk.pendo.io.w5.c {
    sdk.pendo.io.w5.c f;
    long s;
    final boolean u0;
    volatile boolean v0;
    protected boolean w0;
    final AtomicReference<sdk.pendo.io.w5.c> A = new AtomicReference<>();
    final AtomicLong f0 = new AtomicLong();
    final AtomicLong t0 = new AtomicLong();

    public b(boolean z) {
        this.u0 = z;
    }

    final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        b();
    }

    final void b() {
        int i = 1;
        long j = 0;
        sdk.pendo.io.w5.c cVar = null;
        do {
            sdk.pendo.io.w5.c cVar2 = this.A.get();
            if (cVar2 != null) {
                cVar2 = this.A.getAndSet(null);
            }
            long j2 = this.f0.get();
            if (j2 != 0) {
                j2 = this.f0.getAndSet(0L);
            }
            long j3 = this.t0.get();
            if (j3 != 0) {
                j3 = this.t0.getAndSet(0L);
            }
            sdk.pendo.io.w5.c cVar3 = this.f;
            if (this.v0) {
                if (cVar3 != null) {
                    cVar3.cancel();
                    this.f = null;
                }
                if (cVar2 != null) {
                    cVar2.cancel();
                }
            } else {
                long j4 = this.s;
                if (j4 != Long.MAX_VALUE) {
                    j4 = d.a(j4, j2);
                    if (j4 != Long.MAX_VALUE) {
                        j4 -= j3;
                        if (j4 < 0) {
                            c.b(j4);
                            j4 = 0;
                        }
                    }
                    this.s = j4;
                }
                if (cVar2 != null) {
                    if (cVar3 != null && this.u0) {
                        cVar3.cancel();
                    }
                    this.f = cVar2;
                    if (j4 != 0) {
                        j = d.a(j, j4);
                        cVar = cVar2;
                    }
                } else if (cVar3 != null && j2 != 0) {
                    j = d.a(j, j2);
                    cVar = cVar3;
                }
            }
            i = addAndGet(-i);
        } while (i != 0);
        if (j != 0) {
            cVar.a(j);
        }
    }

    public final void c(long j) {
        if (this.w0) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            d.a(this.t0, j);
            a();
            return;
        }
        long j2 = this.s;
        if (j2 != Long.MAX_VALUE) {
            long j3 = j2 - j;
            if (j3 < 0) {
                c.b(j3);
                j3 = 0;
            }
            this.s = j3;
        }
        if (decrementAndGet() == 0) {
            return;
        }
        b();
    }

    public void cancel() {
        if (this.v0) {
            return;
        }
        this.v0 = true;
        a();
    }

    @Override // sdk.pendo.io.w5.c
    public final void a(long j) {
        if (!c.c(j) || this.w0) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            d.a(this.f0, j);
            a();
            return;
        }
        long j2 = this.s;
        if (j2 != Long.MAX_VALUE) {
            long a2 = d.a(j2, j);
            this.s = a2;
            if (a2 == Long.MAX_VALUE) {
                this.w0 = true;
            }
        }
        sdk.pendo.io.w5.c cVar = this.f;
        if (decrementAndGet() != 0) {
            b();
        }
        if (cVar != null) {
            cVar.a(j);
        }
    }

    public final void b(sdk.pendo.io.w5.c cVar) {
        if (this.v0) {
            cVar.cancel();
            return;
        }
        sdk.pendo.io.f6.b.a(cVar, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            sdk.pendo.io.w5.c andSet = this.A.getAndSet(cVar);
            if (andSet != null && this.u0) {
                andSet.cancel();
            }
            a();
            return;
        }
        sdk.pendo.io.w5.c cVar2 = this.f;
        if (cVar2 != null && this.u0) {
            cVar2.cancel();
        }
        this.f = cVar;
        long j = this.s;
        if (decrementAndGet() != 0) {
            b();
        }
        if (j != 0) {
            cVar.a(j);
        }
    }
}
