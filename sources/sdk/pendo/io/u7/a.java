package sdk.pendo.io.u7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public class a extends Thread {
    private static a A;
    private static ExecutorService f0;
    private static final Logger f = Logger.getLogger(a.class.getName());
    private static final ThreadFactory s = new ThreadFactoryC0244a();
    private static int t0 = 0;

    /* renamed from: sdk.pendo.io.u7.a$a, reason: collision with other inner class name */
    class ThreadFactoryC0244a implements ThreadFactory {
        ThreadFactoryC0244a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            a aVar = new a(runnable);
            a.A = aVar;
            aVar.setName("EventThread");
            a.A.setDaemon(Thread.currentThread().isDaemon());
            return a.A;
        }
    }

    class b implements Runnable {
        final /* synthetic */ Runnable f;

        b(Runnable runnable) {
            this.f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f.run();
                synchronized (a.class) {
                    int i = a.t0 - 1;
                    a.t0 = i;
                    if (i == 0) {
                        a.f0.shutdown();
                        a.f0 = null;
                        a.A = null;
                    }
                }
            } catch (Throwable th) {
                try {
                    a.f.log(Level.SEVERE, "Task threw exception", th);
                    throw th;
                } catch (Throwable th2) {
                    synchronized (a.class) {
                        int i2 = a.t0 - 1;
                        a.t0 = i2;
                        if (i2 == 0) {
                            a.f0.shutdown();
                            a.f0 = null;
                            a.A = null;
                        }
                        throw th2;
                    }
                }
            }
        }
    }

    private a(Runnable runnable) {
        super(runnable);
    }

    public static void a(Runnable runnable) {
        if (a()) {
            runnable.run();
        } else {
            b(runnable);
        }
    }

    public static void b(Runnable runnable) {
        ExecutorService executorService;
        synchronized (a.class) {
            t0++;
            if (f0 == null) {
                f0 = Executors.newSingleThreadExecutor(s);
            }
            executorService = f0;
        }
        executorService.execute(new b(runnable));
    }

    public static boolean a() {
        return Thread.currentThread() == A;
    }
}
