package sdk.pendo.io.b3;

import androidx.core.app.NotificationCompat;
import io.sentry.SentryLockReason;
import java.lang.ref.Reference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.b3.e;

@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001b\u0018\u0000 *2\u00020\u0001:\u0001\u0007B'\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010%\u001a\u00020\u0004\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J.\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006+"}, d2 = {"Lsdk/pendo/io/b3/g;", "", "Lsdk/pendo/io/b3/f;", "connection", "", "now", "", "a", "Lsdk/pendo/io/w2/a;", SentryLockReason.JsonKeys.ADDRESS, "Lsdk/pendo/io/b3/e;", NotificationCompat.CATEGORY_CALL, "", "Lsdk/pendo/io/w2/f0;", "routes", "", "requireMultiplexed", "", "b", "I", "maxIdleConnections", "J", "keepAliveDurationNs", "Lsdk/pendo/io/a3/d;", "c", "Lsdk/pendo/io/a3/d;", "cleanupQueue", "sdk/pendo/io/b3/g$b", "d", "Lsdk/pendo/io/b3/g$b;", "cleanupTask", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "e", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "connections", "Lsdk/pendo/io/a3/e;", "taskRunner", "keepAliveDuration", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;IJLjava/util/concurrent/TimeUnit;)V", "f", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int maxIdleConnections;

    /* renamed from: b, reason: from kotlin metadata */
    private final long keepAliveDurationNs;

    /* renamed from: c, reason: from kotlin metadata */
    private final sdk.pendo.io.a3.d cleanupQueue;

    /* renamed from: d, reason: from kotlin metadata */
    private final b cleanupTask;

    /* renamed from: e, reason: from kotlin metadata */
    private final ConcurrentLinkedQueue<f> connections;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"sdk/pendo/io/b3/g$b", "Lsdk/pendo/io/a3/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class b extends sdk.pendo.io.a3.a {
        b(String str) {
            super(str, false, 2, null);
        }

        @Override // sdk.pendo.io.a3.a
        public long e() {
            return g.this.a(System.nanoTime());
        }
    }

    public g(sdk.pendo.io.a3.e taskRunner, int i, long j, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        this.maxIdleConnections = i;
        this.keepAliveDurationNs = timeUnit.toNanos(j);
        this.cleanupQueue = taskRunner.e();
        this.cleanupTask = new b(sdk.pendo.io.x2.b.i + " ConnectionPool");
        this.connections = new ConcurrentLinkedQueue<>();
        if (!(j > 0)) {
            throw new IllegalArgumentException(("keepAliveDuration <= 0: " + j).toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0028, code lost:
    
        if (r1.k() != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(sdk.pendo.io.w2.a r4, sdk.pendo.io.b3.e r5, java.util.List<sdk.pendo.io.w2.f0> r6, boolean r7) {
        /*
            r3 = this;
            java.lang.String r0 = "address"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.concurrent.ConcurrentLinkedQueue<sdk.pendo.io.b3.f> r0 = r3.connections
            java.util.Iterator r0 = r0.iterator()
        L10:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L3d
            java.lang.Object r1 = r0.next()
            sdk.pendo.io.b3.f r1 = (sdk.pendo.io.b3.f) r1
            java.lang.String r2 = "connection"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            monitor-enter(r1)
            if (r7 == 0) goto L2a
            boolean r2 = r1.k()     // Catch: java.lang.Throwable -> L3a
            if (r2 == 0) goto L36
        L2a:
            boolean r2 = r1.a(r4, r6)     // Catch: java.lang.Throwable -> L3a
            if (r2 == 0) goto L36
            r5.a(r1)     // Catch: java.lang.Throwable -> L3a
            monitor-exit(r1)
            r4 = 1
            return r4
        L36:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L3a
            monitor-exit(r1)
            goto L10
        L3a:
            r4 = move-exception
            monitor-exit(r1)
            throw r4
        L3d:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.b3.g.a(sdk.pendo.io.w2.a, sdk.pendo.io.b3.e, java.util.List, boolean):boolean");
    }

    public final void b(f connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (sdk.pendo.io.x2.b.h && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
        }
        this.connections.add(connection);
        sdk.pendo.io.a3.d.a(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
    }

    public final long a(long now) {
        Iterator<f> it = this.connections.iterator();
        int i = 0;
        long j = Long.MIN_VALUE;
        f fVar = null;
        int i2 = 0;
        while (it.hasNext()) {
            f connection = it.next();
            Intrinsics.checkNotNullExpressionValue(connection, "connection");
            synchronized (connection) {
                if (a(connection, now) > 0) {
                    i2++;
                } else {
                    i++;
                    long idleAtNs = now - connection.getIdleAtNs();
                    if (idleAtNs > j) {
                        fVar = connection;
                        j = idleAtNs;
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        long j2 = this.keepAliveDurationNs;
        if (j < j2 && i <= this.maxIdleConnections) {
            if (i > 0) {
                return j2 - j;
            }
            if (i2 > 0) {
                return j2;
            }
            return -1L;
        }
        Intrinsics.checkNotNull(fVar);
        synchronized (fVar) {
            if (!fVar.f().isEmpty()) {
                return 0L;
            }
            if (fVar.getIdleAtNs() + j != now) {
                return 0L;
            }
            fVar.b(true);
            this.connections.remove(fVar);
            sdk.pendo.io.x2.b.a(fVar.c());
            if (this.connections.isEmpty()) {
                this.cleanupQueue.a();
            }
            return 0L;
        }
    }

    public final boolean a(f connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (sdk.pendo.io.x2.b.h && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
        }
        if (!connection.getNoNewExchanges() && this.maxIdleConnections != 0) {
            sdk.pendo.io.a3.d.a(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            return false;
        }
        connection.b(true);
        this.connections.remove(connection);
        if (this.connections.isEmpty()) {
            this.cleanupQueue.a();
        }
        return true;
    }

    private final int a(f connection, long now) {
        if (sdk.pendo.io.x2.b.h && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
        }
        List<Reference<e>> f = connection.f();
        int i = 0;
        while (i < f.size()) {
            Reference<e> reference = f.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                Intrinsics.checkNotNull(reference, "null cannot be cast to non-null type okhttp3.internal.connection.RealCall.CallReference");
                sdk.pendo.io.f3.h.INSTANCE.d().a("A connection to " + connection.getRoute().getIo.sentry.SentryLockReason.JsonKeys.ADDRESS java.lang.String().getUrl() + " was leaked. Did you forget to close a response body?", ((e.b) reference).getCallStackTrace());
                f.remove(i);
                connection.b(true);
                if (f.isEmpty()) {
                    connection.a(now - this.keepAliveDurationNs);
                    return 0;
                }
            }
        }
        return f.size();
    }
}
