package sdk.pendo.io.n6;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
public final class j extends AtomicLong implements ThreadFactory {
    final boolean A;
    final String f;
    final int s;

    static final class a extends Thread implements i {
        a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public j(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        String str = this.f + '-' + incrementAndGet();
        Thread aVar = this.A ? new a(runnable, str) : new Thread(runnable, str);
        aVar.setPriority(this.s);
        aVar.setDaemon(true);
        return aVar;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return "RxThreadFactory[" + this.f + "]";
    }

    public j(String str, int i) {
        this(str, i, false);
    }

    public j(String str, int i, boolean z) {
        this.f = str;
        this.s = i;
        this.A = z;
    }
}
