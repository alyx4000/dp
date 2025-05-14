package sdk.pendo.io.actions.configurations;

import java.util.concurrent.atomic.AtomicInteger;
import sdk.pendo.io.l0.c;

/* loaded from: classes6.dex */
public final class GuideCapping {
    public static final String INSERT_CAPPING_CONSUMED = "consumed";
    public static final String INSERT_CAPPING_MAX_SESSION_IMPRESSIONS = "maxSessionImpressions";
    public static final int UNLIMITED_MAX_SESSION_IMPRESSIONS = -1;

    @c(INSERT_CAPPING_MAX_SESSION_IMPRESSIONS)
    private volatile int mMaxSessionImpressions = -1;
    private volatile transient AtomicInteger mConsumed = new AtomicInteger(0);

    public synchronized boolean canConsumeOne() {
        boolean z;
        if (this.mMaxSessionImpressions != -1) {
            z = this.mConsumed.get() < this.mMaxSessionImpressions;
        }
        return z;
    }

    public synchronized boolean consumeOne() {
        if (this.mMaxSessionImpressions == -1) {
            return true;
        }
        if (this.mConsumed.get() >= this.mMaxSessionImpressions) {
            return false;
        }
        this.mConsumed.getAndIncrement();
        return true;
    }

    public synchronized int getConsumed() {
        return this.mConsumed.get();
    }

    public synchronized int getMaxSessionImpressions() {
        return this.mMaxSessionImpressions;
    }

    public synchronized void setConsumed(int i) {
        this.mConsumed.set(i);
    }

    public synchronized void setMaxSessionImpressions(int i) {
        this.mMaxSessionImpressions = i;
    }

    public synchronized String toString() {
        return "{maxSessionImpressions = " + this.mMaxSessionImpressions + ", consumed = " + this.mConsumed + ", }";
    }
}
