package sdk.pendo.io.k3;

import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.common.callercontext.ContextChain;
import external.sdk.pendo.io.mozilla.javascript.ES6Iterator;
import io.sentry.ProfilingTraceData;
import io.sentry.protocol.SentryStackFrame;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0002\f\u0004B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\t\u001a\u00020\u0005H\u0014J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0012\u0010\f\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0001J\u0012\u0010\u0004\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lsdk/pendo/io/k3/c;", "Lsdk/pendo/io/k3/b0;", "", "now", "b", "", "l", "", "m", "n", "Lsdk/pendo/io/k3/y;", "sink", "a", "Lsdk/pendo/io/k3/a0;", "source", "Ljava/io/IOException;", "cause", "f", "Z", "inQueue", "g", "Lsdk/pendo/io/k3/c;", ES6Iterator.NEXT_METHOD, "h", "J", "timeoutAt", "<init>", "()V", ContextChain.TAG_INFRA, "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public class c extends b0 {

    /* renamed from: i, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ReentrantLock j;
    private static final Condition k;
    private static final long l;
    private static final long m;
    private static c n;

    /* renamed from: f, reason: from kotlin metadata */
    private boolean inQueue;

    /* renamed from: g, reason: from kotlin metadata */
    private c next;

    /* renamed from: h, reason: from kotlin metadata */
    private long timeoutAt;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0011\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lsdk/pendo/io/k3/c$a;", "", "Lsdk/pendo/io/k3/c;", "node", "", "timeoutNanos", "", "hasDeadline", "", "a", "()Lsdk/pendo/io/k3/c;", "Ljava/util/concurrent/locks/ReentrantLock;", SentryStackFrame.JsonKeys.LOCK, "Ljava/util/concurrent/locks/ReentrantLock;", "c", "()Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/Condition;", "condition", "Ljava/util/concurrent/locks/Condition;", "b", "()Ljava/util/concurrent/locks/Condition;", "IDLE_TIMEOUT_MILLIS", "J", "IDLE_TIMEOUT_NANOS", "", "TIMEOUT_WRITE_SIZE", "I", "head", "Lsdk/pendo/io/k3/c;", "<init>", "()V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
    /* renamed from: sdk.pendo.io.k3.c$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Condition b() {
            return c.k;
        }

        public final ReentrantLock c() {
            return c.j;
        }

        public final c a() {
            c cVar = c.n;
            Intrinsics.checkNotNull(cVar);
            c cVar2 = cVar.next;
            long nanoTime = System.nanoTime();
            if (cVar2 == null) {
                b().await(c.l, TimeUnit.MILLISECONDS);
                c cVar3 = c.n;
                Intrinsics.checkNotNull(cVar3);
                if (cVar3.next != null || System.nanoTime() - nanoTime < c.m) {
                    return null;
                }
                return c.n;
            }
            long b = cVar2.b(nanoTime);
            if (b > 0) {
                b().await(b, TimeUnit.NANOSECONDS);
                return null;
            }
            c cVar4 = c.n;
            Intrinsics.checkNotNull(cVar4);
            cVar4.next = cVar2.next;
            cVar2.next = null;
            return cVar2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean a(c node) {
            ReentrantLock c = c.INSTANCE.c();
            c.lock();
            try {
                if (!node.inQueue) {
                    return false;
                }
                node.inQueue = false;
                for (c cVar = c.n; cVar != null; cVar = cVar.next) {
                    if (cVar.next == node) {
                        cVar.next = node.next;
                        node.next = null;
                        return false;
                    }
                }
                c.unlock();
                return true;
            } finally {
                c.unlock();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:16:0x005e A[Catch: all -> 0x00a4, TryCatch #0 {all -> 0x00a4, blocks: (B:3:0x0009, B:5:0x0011, B:7:0x001a, B:8:0x002a, B:11:0x0036, B:12:0x0042, B:13:0x004a, B:14:0x0055, B:16:0x005e, B:18:0x006e, B:21:0x0073, B:23:0x0083, B:24:0x008c, B:31:0x0046, B:32:0x0092, B:33:0x0097, B:34:0x0098, B:35:0x00a3), top: B:2:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0083 A[Catch: all -> 0x00a4, TryCatch #0 {all -> 0x00a4, blocks: (B:3:0x0009, B:5:0x0011, B:7:0x001a, B:8:0x002a, B:11:0x0036, B:12:0x0042, B:13:0x004a, B:14:0x0055, B:16:0x005e, B:18:0x006e, B:21:0x0073, B:23:0x0083, B:24:0x008c, B:31:0x0046, B:32:0x0092, B:33:0x0097, B:34:0x0098, B:35:0x00a3), top: B:2:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0073 A[EDGE_INSN: B:28:0x0073->B:21:0x0073 BREAK  A[LOOP:0: B:14:0x0055->B:18:0x006e], SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a(sdk.pendo.io.k3.c r6, long r7, boolean r9) {
            /*
                r5 = this;
                sdk.pendo.io.k3.c$a r0 = sdk.pendo.io.k3.c.INSTANCE
                java.util.concurrent.locks.ReentrantLock r0 = r0.c()
                r0.lock()
                boolean r1 = sdk.pendo.io.k3.c.a(r6)     // Catch: java.lang.Throwable -> La4
                r2 = 1
                r1 = r1 ^ r2
                if (r1 == 0) goto L98
                sdk.pendo.io.k3.c.a(r6, r2)     // Catch: java.lang.Throwable -> La4
                sdk.pendo.io.k3.c r1 = sdk.pendo.io.k3.c.h()     // Catch: java.lang.Throwable -> La4
                if (r1 != 0) goto L2a
                sdk.pendo.io.k3.c r1 = new sdk.pendo.io.k3.c     // Catch: java.lang.Throwable -> La4
                r1.<init>()     // Catch: java.lang.Throwable -> La4
                sdk.pendo.io.k3.c.c(r1)     // Catch: java.lang.Throwable -> La4
                sdk.pendo.io.k3.c$b r1 = new sdk.pendo.io.k3.c$b     // Catch: java.lang.Throwable -> La4
                r1.<init>()     // Catch: java.lang.Throwable -> La4
                r1.start()     // Catch: java.lang.Throwable -> La4
            L2a:
                long r1 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> La4
                r3 = 0
                int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
                if (r3 == 0) goto L40
                if (r9 == 0) goto L40
                long r3 = r6.c()     // Catch: java.lang.Throwable -> La4
                long r3 = r3 - r1
                long r7 = java.lang.Math.min(r7, r3)     // Catch: java.lang.Throwable -> La4
                goto L42
            L40:
                if (r3 == 0) goto L44
            L42:
                long r7 = r7 + r1
                goto L4a
            L44:
                if (r9 == 0) goto L92
                long r7 = r6.c()     // Catch: java.lang.Throwable -> La4
            L4a:
                sdk.pendo.io.k3.c.b(r6, r7)     // Catch: java.lang.Throwable -> La4
                long r7 = sdk.pendo.io.k3.c.a(r6, r1)     // Catch: java.lang.Throwable -> La4
                sdk.pendo.io.k3.c r9 = sdk.pendo.io.k3.c.h()     // Catch: java.lang.Throwable -> La4
            L55:
                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch: java.lang.Throwable -> La4
                sdk.pendo.io.k3.c r3 = sdk.pendo.io.k3.c.b(r9)     // Catch: java.lang.Throwable -> La4
                if (r3 == 0) goto L73
                sdk.pendo.io.k3.c r3 = sdk.pendo.io.k3.c.b(r9)     // Catch: java.lang.Throwable -> La4
                kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch: java.lang.Throwable -> La4
                long r3 = sdk.pendo.io.k3.c.a(r3, r1)     // Catch: java.lang.Throwable -> La4
                int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
                if (r3 >= 0) goto L6e
                goto L73
            L6e:
                sdk.pendo.io.k3.c r9 = sdk.pendo.io.k3.c.b(r9)     // Catch: java.lang.Throwable -> La4
                goto L55
            L73:
                sdk.pendo.io.k3.c r7 = sdk.pendo.io.k3.c.b(r9)     // Catch: java.lang.Throwable -> La4
                sdk.pendo.io.k3.c.a(r6, r7)     // Catch: java.lang.Throwable -> La4
                sdk.pendo.io.k3.c.a(r9, r6)     // Catch: java.lang.Throwable -> La4
                sdk.pendo.io.k3.c r6 = sdk.pendo.io.k3.c.h()     // Catch: java.lang.Throwable -> La4
                if (r9 != r6) goto L8c
                sdk.pendo.io.k3.c$a r6 = sdk.pendo.io.k3.c.INSTANCE     // Catch: java.lang.Throwable -> La4
                java.util.concurrent.locks.Condition r6 = r6.b()     // Catch: java.lang.Throwable -> La4
                r6.signal()     // Catch: java.lang.Throwable -> La4
            L8c:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> La4
                r0.unlock()
                return
            L92:
                java.lang.AssertionError r6 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> La4
                r6.<init>()     // Catch: java.lang.Throwable -> La4
                throw r6     // Catch: java.lang.Throwable -> La4
            L98:
                java.lang.String r6 = "Unbalanced enter/exit"
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> La4
                java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> La4
                r7.<init>(r6)     // Catch: java.lang.Throwable -> La4
                throw r7     // Catch: java.lang.Throwable -> La4
            La4:
                r6 = move-exception
                r0.unlock()
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.k3.c.Companion.a(sdk.pendo.io.k3.c, long, boolean):void");
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lsdk/pendo/io/k3/c$b;", "Ljava/lang/Thread;", "", "run", "<init>", "()V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
    private static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ReentrantLock c;
            c a2;
            while (true) {
                try {
                    Companion companion = c.INSTANCE;
                    c = companion.c();
                    c.lock();
                    try {
                        a2 = companion.a();
                    } finally {
                        c.unlock();
                    }
                } catch (InterruptedException unused) {
                    continue;
                }
                if (a2 == c.n) {
                    c.n = null;
                    return;
                }
                Unit unit = Unit.INSTANCE;
                c.unlock();
                if (a2 != null) {
                    a2.n();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"sdk/pendo/io/k3/c$c", "Lsdk/pendo/io/k3/y;", "Lsdk/pendo/io/k3/d;", "source", "", "byteCount", "", "a", "flush", "close", "Lsdk/pendo/io/k3/c;", "", "toString", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
    /* renamed from: sdk.pendo.io.k3.c$c, reason: collision with other inner class name */
    public static final class C0170c implements y {
        final /* synthetic */ y s;

        C0170c(y yVar) {
            this.s = yVar;
        }

        @Override // sdk.pendo.io.k3.y
        /* renamed from: a, reason: from getter and merged with bridge method [inline-methods] */
        public c d() {
            return c.this;
        }

        @Override // sdk.pendo.io.k3.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            c cVar = c.this;
            y yVar = this.s;
            cVar.l();
            try {
                yVar.close();
                Unit unit = Unit.INSTANCE;
                if (cVar.m()) {
                    throw cVar.a((IOException) null);
                }
            } catch (IOException e) {
                if (!cVar.m()) {
                    throw e;
                }
                throw cVar.a(e);
            } finally {
                cVar.m();
            }
        }

        @Override // sdk.pendo.io.k3.y, java.io.Flushable
        public void flush() {
            c cVar = c.this;
            y yVar = this.s;
            cVar.l();
            try {
                yVar.flush();
                Unit unit = Unit.INSTANCE;
                if (cVar.m()) {
                    throw cVar.a((IOException) null);
                }
            } catch (IOException e) {
                if (!cVar.m()) {
                    throw e;
                }
                throw cVar.a(e);
            } finally {
                cVar.m();
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.s + ')';
        }

        @Override // sdk.pendo.io.k3.y
        public void a(sdk.pendo.io.k3.d source, long byteCount) {
            Intrinsics.checkNotNullParameter(source, "source");
            sdk.pendo.io.k3.b.a(source.getSize(), 0L, byteCount);
            while (true) {
                long j = 0;
                if (byteCount <= 0) {
                    return;
                }
                v vVar = source.head;
                while (true) {
                    Intrinsics.checkNotNull(vVar);
                    if (j >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                        break;
                    }
                    j += vVar.limit - vVar.pos;
                    if (j >= byteCount) {
                        j = byteCount;
                        break;
                    }
                    vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
                }
                c cVar = c.this;
                y yVar = this.s;
                cVar.l();
                try {
                    yVar.a(source, j);
                    Unit unit = Unit.INSTANCE;
                    if (cVar.m()) {
                        throw cVar.a((IOException) null);
                    }
                    byteCount -= j;
                } catch (IOException e) {
                    if (!cVar.m()) {
                        throw e;
                    }
                    throw cVar.a(e);
                } finally {
                    cVar.m();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"sdk/pendo/io/k3/c$d", "Lsdk/pendo/io/k3/a0;", "Lsdk/pendo/io/k3/d;", "sink", "", "byteCount", "c", "", "close", "Lsdk/pendo/io/k3/c;", "a", "", "toString", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
    public static final class d implements a0 {
        final /* synthetic */ a0 s;

        d(a0 a0Var) {
            this.s = a0Var;
        }

        @Override // sdk.pendo.io.k3.a0
        /* renamed from: a, reason: from getter and merged with bridge method [inline-methods] */
        public c d() {
            return c.this;
        }

        @Override // sdk.pendo.io.k3.a0
        public long c(sdk.pendo.io.k3.d sink, long byteCount) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            c cVar = c.this;
            a0 a0Var = this.s;
            cVar.l();
            try {
                long c = a0Var.c(sink, byteCount);
                if (cVar.m()) {
                    throw cVar.a((IOException) null);
                }
                return c;
            } catch (IOException e) {
                if (cVar.m()) {
                    throw cVar.a(e);
                }
                throw e;
            } finally {
                cVar.m();
            }
        }

        @Override // sdk.pendo.io.k3.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            c cVar = c.this;
            a0 a0Var = this.s;
            cVar.l();
            try {
                a0Var.close();
                Unit unit = Unit.INSTANCE;
                if (cVar.m()) {
                    throw cVar.a((IOException) null);
                }
            } catch (IOException e) {
                if (!cVar.m()) {
                    throw e;
                }
                throw cVar.a(e);
            } finally {
                cVar.m();
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.s + ')';
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        j = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        Intrinsics.checkNotNullExpressionValue(newCondition, "newCondition(...)");
        k = newCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        l = millis;
        m = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void l() {
        long timeoutNanos = getTimeoutNanos();
        boolean hasDeadline = getHasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            INSTANCE.a(this, timeoutNanos, hasDeadline);
        }
    }

    public final boolean m() {
        return INSTANCE.a(this);
    }

    protected void n() {
    }

    public final IOException a(IOException cause) {
        return b(cause);
    }

    protected IOException b(IOException cause) {
        InterruptedIOException interruptedIOException = new InterruptedIOException(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT);
        if (cause != null) {
            interruptedIOException.initCause(cause);
        }
        return interruptedIOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long b(long now) {
        return this.timeoutAt - now;
    }

    public final y a(y sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new C0170c(sink);
    }

    public final a0 a(a0 source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new d(source);
    }
}
