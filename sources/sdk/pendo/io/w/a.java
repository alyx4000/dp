package sdk.pendo.io.w;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class a implements ExecutorService {
    private static final long b = TimeUnit.SECONDS.toMillis(10);
    private static volatile int c;

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f1693a;

    /* renamed from: sdk.pendo.io.w.a$a, reason: collision with other inner class name */
    public static final class C0254a {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f1694a;
        private int b;
        private int c;
        private c d = c.d;
        private String e;
        private long f;

        C0254a(boolean z) {
            this.f1694a = z;
        }

        public a a() {
            if (TextUtils.isEmpty(this.e)) {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.e);
            }
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.b, this.c, this.f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new b(this.e, this.d, this.f1694a));
            if (this.f != 0) {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
            return new a(threadPoolExecutor);
        }

        public C0254a a(String str) {
            this.e = str;
            return this;
        }

        public C0254a a(int i) {
            this.b = i;
            this.c = i;
            return this;
        }
    }

    private static final class b implements ThreadFactory {
        final boolean A;
        private final String f;
        private int f0;
        final c s;

        /* renamed from: sdk.pendo.io.w.a$b$a, reason: collision with other inner class name */
        class C0255a extends Thread {
            C0255a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                if (b.this.A) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    b.this.s.a(th);
                }
            }
        }

        b(String str, c cVar, boolean z) {
            this.f = str;
            this.s = cVar;
            this.A = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            C0255a c0255a;
            c0255a = new C0255a(runnable, "glide-" + this.f + "-thread-" + this.f0);
            this.f0++;
            return c0255a;
        }
    }

    public interface c {

        /* renamed from: a, reason: collision with root package name */
        public static final c f1695a = new C0256a();
        public static final c b;
        public static final c c;
        public static final c d;

        /* renamed from: sdk.pendo.io.w.a$c$a, reason: collision with other inner class name */
        class C0256a implements c {
            C0256a() {
            }

            @Override // sdk.pendo.io.w.a.c
            public void a(Throwable th) {
            }
        }

        class b implements c {
            b() {
            }

            @Override // sdk.pendo.io.w.a.c
            public void a(Throwable th) {
                if (th == null || !Log.isLoggable("GlideExecutor", 6)) {
                    return;
                }
                Log.e("GlideExecutor", "Request threw uncaught throwable", th);
            }
        }

        /* renamed from: sdk.pendo.io.w.a$c$c, reason: collision with other inner class name */
        class C0257c implements c {
            C0257c() {
            }

            @Override // sdk.pendo.io.w.a.c
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        }

        static {
            b bVar = new b();
            b = bVar;
            c = new C0257c();
            d = bVar;
        }

        void a(Throwable th);
    }

    a(ExecutorService executorService) {
        this.f1693a = executorService;
    }

    public static int a() {
        if (c == 0) {
            c = Math.min(4, sdk.pendo.io.w.b.a());
        }
        return c;
    }

    public static C0254a b() {
        return new C0254a(true).a(a() >= 4 ? 2 : 1).a("animation");
    }

    public static a c() {
        return b().a();
    }

    public static C0254a d() {
        return new C0254a(true).a(1).a("disk-cache");
    }

    public static a e() {
        return d().a();
    }

    public static C0254a f() {
        return new C0254a(false).a(a()).a("source");
    }

    public static a g() {
        return f().a();
    }

    public static a h() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new b("source-unlimited", c.d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.f1693a.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f1693a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.f1693a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return (T) this.f1693a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f1693a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f1693a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f1693a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.f1693a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.f1693a.submit(runnable);
    }

    public String toString() {
        return this.f1693a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return this.f1693a.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return (T) this.f1693a.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.f1693a.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.f1693a.submit(callable);
    }
}
