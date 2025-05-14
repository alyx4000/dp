package sdk.pendo.io.a3;

import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import io.sentry.SentryEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0003\u0005\u0006\rB\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000e¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0005\u0010\u000bJ\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\u0004R\u0017\u0010\u0012\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001dR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lsdk/pendo/io/a3/e;", "", "Lsdk/pendo/io/a3/a;", "task", "", "a", "b", "", "delayNanos", "Lsdk/pendo/io/a3/d;", "taskQueue", "(Lsdk/pendo/io/a3/d;)V", "e", "c", "Lsdk/pendo/io/a3/e$a;", "Lsdk/pendo/io/a3/e$a;", "getBackend", "()Lokhttp3/internal/concurrent/TaskRunner$Backend;", "backend", "", "I", "nextQueueName", "", "Z", "coordinatorWaiting", "d", "J", "coordinatorWakeUpAt", "", "Ljava/util/List;", "busyQueues", "f", "readyQueues", "Ljava/lang/Runnable;", "g", "Ljava/lang/Runnable;", "runnable", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner$Backend;)V", "h", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: h, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final e i = new e(new c(sdk.pendo.io.x2.b.a(sdk.pendo.io.x2.b.i + " TaskRunner", true)));
    private static final Logger j;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final a backend;

    /* renamed from: b, reason: from kotlin metadata */
    private int nextQueueName;

    /* renamed from: c, reason: from kotlin metadata */
    private boolean coordinatorWaiting;

    /* renamed from: d, reason: from kotlin metadata */
    private long coordinatorWakeUpAt;

    /* renamed from: e, reason: from kotlin metadata */
    private final List<sdk.pendo.io.a3.d> busyQueues;

    /* renamed from: f, reason: from kotlin metadata */
    private final List<sdk.pendo.io.a3.d> readyQueues;

    /* renamed from: g, reason: from kotlin metadata */
    private final Runnable runnable;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/a3/e$a;", "", "", "a", "Lsdk/pendo/io/a3/e;", "taskRunner", "", "nanos", "Ljava/lang/Runnable;", "runnable", "execute", "okhttp"}, k = 1, mv = {1, 8, 0})
    public interface a {
        long a();

        void a(e taskRunner);

        void a(e taskRunner, long nanos);

        void execute(Runnable runnable);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lsdk/pendo/io/a3/e$b;", "", "Ljava/util/logging/Logger;", SentryEvent.JsonKeys.LOGGER, "Ljava/util/logging/Logger;", "a", "()Ljava/util/logging/Logger;", "Lsdk/pendo/io/a3/e;", "INSTANCE", "Lsdk/pendo/io/a3/e;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    /* renamed from: sdk.pendo.io.a3.e$b, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Logger a() {
            return e.j;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\f¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/a3/e$c;", "Lsdk/pendo/io/a3/e$a;", "", "a", "Lsdk/pendo/io/a3/e;", "taskRunner", "", "nanos", "Ljava/lang/Runnable;", "runnable", "execute", "Ljava/util/concurrent/ThreadPoolExecutor;", "Ljava/util/concurrent/ThreadPoolExecutor;", "executor", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "<init>", "(Ljava/util/concurrent/ThreadFactory;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class c implements a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final ThreadPoolExecutor executor;

        public c(ThreadFactory threadFactory) {
            Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
            this.executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // sdk.pendo.io.a3.e.a
        public void a(e taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            taskRunner.notify();
        }

        @Override // sdk.pendo.io.a3.e.a
        public void execute(Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.executor.execute(runnable);
        }

        @Override // sdk.pendo.io.a3.e.a
        public void a(e taskRunner, long nanos) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            long j = nanos / 1000000;
            long j2 = nanos - (1000000 * j);
            if (j > 0 || nanos > 0) {
                taskRunner.wait(j, (int) j2);
            }
        }

        @Override // sdk.pendo.io.a3.e.a
        public long a() {
            return System.nanoTime();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"sdk/pendo/io/a3/e$d", "Ljava/lang/Runnable;", "", "run", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            sdk.pendo.io.a3.a b;
            long j;
            while (true) {
                e eVar = e.this;
                synchronized (eVar) {
                    b = eVar.b();
                }
                if (b == null) {
                    return;
                }
                sdk.pendo.io.a3.d queue = b.getQueue();
                Intrinsics.checkNotNull(queue);
                e eVar2 = e.this;
                boolean isLoggable = e.INSTANCE.a().isLoggable(Level.FINE);
                if (isLoggable) {
                    j = queue.getTaskRunner().getBackend().a();
                    b.b(b, queue, "starting");
                } else {
                    j = -1;
                }
                try {
                    try {
                        eVar2.b(b);
                        Unit unit = Unit.INSTANCE;
                        if (isLoggable) {
                            b.b(b, queue, "finished run in " + b.a(queue.getTaskRunner().getBackend().a() - j));
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    if (isLoggable) {
                        b.b(b, queue, "failed a run in " + b.a(queue.getTaskRunner().getBackend().a() - j));
                    }
                    throw th;
                }
            }
        }
    }

    static {
        Logger logger = Logger.getLogger(e.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(TaskRunner::class.java.name)");
        j = logger;
    }

    public e(a backend) {
        Intrinsics.checkNotNullParameter(backend, "backend");
        this.backend = backend;
        this.nextQueueName = ModuleDescriptor.MODULE_VERSION;
        this.busyQueues = new ArrayList();
        this.readyQueues = new ArrayList();
        this.runnable = new d();
    }

    public final sdk.pendo.io.a3.a b() {
        boolean z;
        if (sdk.pendo.io.x2.b.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        while (!this.readyQueues.isEmpty()) {
            long a2 = this.backend.a();
            Iterator<sdk.pendo.io.a3.d> it = this.readyQueues.iterator();
            long j2 = Long.MAX_VALUE;
            sdk.pendo.io.a3.a aVar = null;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                sdk.pendo.io.a3.a aVar2 = it.next().e().get(0);
                long max = Math.max(0L, aVar2.getNextExecuteNanoTime() - a2);
                if (max > 0) {
                    j2 = Math.min(max, j2);
                } else {
                    if (aVar != null) {
                        z = true;
                        break;
                    }
                    aVar = aVar2;
                }
            }
            if (aVar != null) {
                a(aVar);
                if (z || (!this.coordinatorWaiting && (!this.readyQueues.isEmpty()))) {
                    this.backend.execute(this.runnable);
                }
                return aVar;
            }
            if (this.coordinatorWaiting) {
                if (j2 < this.coordinatorWakeUpAt - a2) {
                    this.backend.a(this);
                }
                return null;
            }
            this.coordinatorWaiting = true;
            this.coordinatorWakeUpAt = a2 + j2;
            try {
                try {
                    this.backend.a(this, j2);
                } catch (InterruptedException unused) {
                    c();
                }
            } finally {
                this.coordinatorWaiting = false;
            }
        }
        return null;
    }

    public final void c() {
        int size = this.busyQueues.size();
        while (true) {
            size--;
            if (-1 >= size) {
                break;
            } else {
                this.busyQueues.get(size).b();
            }
        }
        for (int size2 = this.readyQueues.size() - 1; -1 < size2; size2--) {
            sdk.pendo.io.a3.d dVar = this.readyQueues.get(size2);
            dVar.b();
            if (dVar.e().isEmpty()) {
                this.readyQueues.remove(size2);
            }
        }
    }

    /* renamed from: d, reason: from getter */
    public final a getBackend() {
        return this.backend;
    }

    public final sdk.pendo.io.a3.d e() {
        int i2;
        synchronized (this) {
            i2 = this.nextQueueName;
            this.nextQueueName = i2 + 1;
        }
        return new sdk.pendo.io.a3.d(this, "Q" + i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(sdk.pendo.io.a3.a task) {
        if (sdk.pendo.io.x2.b.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        currentThread.setName(task.getName());
        try {
            long e = task.e();
            synchronized (this) {
                a(task, e);
                Unit unit = Unit.INSTANCE;
            }
            currentThread.setName(name);
        } catch (Throwable th) {
            synchronized (this) {
                a(task, -1L);
                Unit unit2 = Unit.INSTANCE;
                currentThread.setName(name);
                throw th;
            }
        }
    }

    private final void a(sdk.pendo.io.a3.a task, long delayNanos) {
        if (sdk.pendo.io.x2.b.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        sdk.pendo.io.a3.d queue = task.getQueue();
        Intrinsics.checkNotNull(queue);
        if (!(queue.getActiveTask() == task)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        boolean cancelActiveTask = queue.getCancelActiveTask();
        queue.a(false);
        queue.a((sdk.pendo.io.a3.a) null);
        this.busyQueues.remove(queue);
        if (delayNanos != -1 && !cancelActiveTask && !queue.getShutdown()) {
            queue.a(task, delayNanos, true);
        }
        if (!queue.e().isEmpty()) {
            this.readyQueues.add(queue);
        }
    }

    private final void a(sdk.pendo.io.a3.a task) {
        if (sdk.pendo.io.x2.b.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        task.a(-1L);
        sdk.pendo.io.a3.d queue = task.getQueue();
        Intrinsics.checkNotNull(queue);
        queue.e().remove(task);
        this.readyQueues.remove(queue);
        queue.a(task);
        this.busyQueues.add(queue);
    }

    public final void a(sdk.pendo.io.a3.d taskQueue) {
        Intrinsics.checkNotNullParameter(taskQueue, "taskQueue");
        if (sdk.pendo.io.x2.b.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        if (taskQueue.getActiveTask() == null) {
            if (!taskQueue.e().isEmpty()) {
                sdk.pendo.io.x2.b.a(this.readyQueues, taskQueue);
            } else {
                this.readyQueues.remove(taskQueue);
            }
        }
        if (this.coordinatorWaiting) {
            this.backend.a(this);
        } else {
            this.backend.execute(this.runnable);
        }
    }
}
