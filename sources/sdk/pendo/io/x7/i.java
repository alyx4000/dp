package sdk.pendo.io.x7;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class i implements Serializable {
    private static volatile long w0 = 1;
    private h A;
    private c f0;
    private b s;
    private final AtomicBoolean t0 = new AtomicBoolean(false);
    private final AtomicBoolean u0 = new AtomicBoolean(false);
    private final CountDownLatch v0 = new CountDownLatch(1);
    private final String f = e() + ":" + getClass().getSimpleName();

    public c a() {
        return this.f0;
    }

    public synchronized h b() {
        return this.A;
    }

    public boolean c() {
        return this.t0.get();
    }

    protected long e() {
        long j = w0;
        w0 = 1 + j;
        return j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f == ((i) obj).f;
    }

    protected void g() {
        this.t0.set(true);
        this.v0.countDown();
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    public String toString() {
        return this.f;
    }

    protected void a(b<? extends i> bVar) {
        this.s = bVar;
    }

    void a(c cVar) {
        this.f0 = cVar;
    }

    public synchronized void a(h hVar) {
        this.A = hVar;
    }
}
