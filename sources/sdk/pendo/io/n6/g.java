package sdk.pendo.io.n6;

import java.util.concurrent.ThreadFactory;
import sdk.pendo.io.x5.p;

/* loaded from: classes6.dex */
public final class g extends sdk.pendo.io.x5.p {
    private static final j d = new j("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    final ThreadFactory c;

    public g() {
        this(d);
    }

    @Override // sdk.pendo.io.x5.p
    public p.c a() {
        return new h(this.c);
    }

    public g(ThreadFactory threadFactory) {
        this.c = threadFactory;
    }
}
