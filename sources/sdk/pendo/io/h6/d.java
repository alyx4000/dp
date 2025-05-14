package sdk.pendo.io.h6;

import java.util.concurrent.CountDownLatch;
import sdk.pendo.io.x5.o;

/* loaded from: classes6.dex */
public abstract class d<T> extends CountDownLatch implements o<T>, sdk.pendo.io.b6.b {
    sdk.pendo.io.b6.b A;
    T f;
    volatile boolean f0;
    Throwable s;

    public d() {
        super(1);
    }

    @Override // sdk.pendo.io.b6.b
    public final boolean a() {
        return this.f0;
    }

    public final T b() {
        if (getCount() != 0) {
            try {
                sdk.pendo.io.q6.e.a();
                await();
            } catch (InterruptedException e) {
                dispose();
                throw sdk.pendo.io.q6.g.a(e);
            }
        }
        Throwable th = this.s;
        if (th == null) {
            return this.f;
        }
        throw sdk.pendo.io.q6.g.a(th);
    }

    @Override // sdk.pendo.io.b6.b
    public final void dispose() {
        this.f0 = true;
        sdk.pendo.io.b6.b bVar = this.A;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    @Override // sdk.pendo.io.x5.o
    public final void onComplete() {
        countDown();
    }

    @Override // sdk.pendo.io.x5.o
    public final void onSubscribe(sdk.pendo.io.b6.b bVar) {
        this.A = bVar;
        if (this.f0) {
            bVar.dispose();
        }
    }
}
