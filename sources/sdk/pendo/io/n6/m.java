package sdk.pendo.io.n6;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlinx.coroutines.channels.ChannelSegment$$ExternalSyntheticBackportWithForwarding0;

/* loaded from: classes6.dex */
public final class m extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, sdk.pendo.io.b6.b {
    final Runnable f;
    static final Object s = new Object();
    static final Object A = new Object();
    static final Object f0 = new Object();
    static final Object t0 = new Object();

    public m(Runnable runnable, sdk.pendo.io.e6.a aVar) {
        super(3);
        this.f = runnable;
        lazySet(0, aVar);
    }

    @Override // sdk.pendo.io.b6.b
    public boolean a() {
        Object obj = get(0);
        return obj == s || obj == t0;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // sdk.pendo.io.b6.b
    public void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        while (true) {
            Object obj5 = get(1);
            if (obj5 == t0 || obj5 == (obj3 = A) || obj5 == (obj4 = f0)) {
                break;
            }
            boolean z = get(2) != Thread.currentThread();
            if (z) {
                obj3 = obj4;
            }
            if (ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(this, 1, obj5, obj3)) {
                if (obj5 != null) {
                    ((Future) obj5).cancel(z);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == t0 || obj == (obj2 = s) || obj == null) {
                return;
            }
        } while (!ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(this, 0, obj, obj2));
        ((sdk.pendo.io.e6.a) obj).c(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        boolean m;
        Object obj4;
        Object obj5;
        lazySet(2, Thread.currentThread());
        try {
            this.f.run();
        } finally {
            try {
                lazySet(2, null);
                obj4 = get(0);
                if (obj4 != s) {
                    ((sdk.pendo.io.e6.a) obj4).c(this);
                }
                do {
                    obj5 = get(1);
                    if (obj5 != A) {
                        return;
                    } else {
                        return;
                    }
                } while (!ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(this, 1, obj5, t0));
            } catch (Throwable th) {
                do {
                    if (obj == obj2) {
                        break;
                    } else if (obj == obj3) {
                        break;
                    }
                } while (!m);
            }
        }
        lazySet(2, null);
        obj4 = get(0);
        if (obj4 != s && ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(this, 0, obj4, t0) && obj4 != null) {
            ((sdk.pendo.io.e6.a) obj4).c(this);
        }
        do {
            obj5 = get(1);
            if (obj5 != A || obj5 == f0) {
                return;
            }
        } while (!ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(this, 1, obj5, t0));
    }

    public void a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == t0) {
                return;
            }
            if (obj == A) {
                future.cancel(false);
                return;
            } else if (obj == f0) {
                future.cancel(true);
                return;
            }
        } while (!ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(this, 1, obj, future));
    }
}
