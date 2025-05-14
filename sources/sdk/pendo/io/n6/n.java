package sdk.pendo.io.n6;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f1423a;
    public static final int b;
    static final AtomicReference<ScheduledExecutorService> c = new AtomicReference<>();
    static final Map<ScheduledThreadPoolExecutor, Object> d = new ConcurrentHashMap();

    static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = new ArrayList(n.d.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    n.d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    static final class b implements sdk.pendo.io.d6.h<String, String> {
        b() {
        }

        @Override // sdk.pendo.io.d6.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(String str) {
            return System.getProperty(str);
        }
    }

    static {
        b bVar = new b();
        boolean a2 = a(true, "rx2.purge-enabled", true, true, (sdk.pendo.io.d6.h<String, String>) bVar);
        f1423a = a2;
        b = a(a2, "rx2.purge-period-seconds", 1, 1, bVar);
        a();
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        a(f1423a, newScheduledThreadPool);
        return newScheduledThreadPool;
    }

    static boolean a(boolean z, String str, boolean z2, boolean z3, sdk.pendo.io.d6.h<String, String> hVar) {
        if (!z) {
            return z3;
        }
        try {
            String apply = hVar.apply(str);
            return apply == null ? z2 : "true".equals(apply);
        } catch (Throwable unused) {
            return z2;
        }
    }

    static int a(boolean z, String str, int i, int i2, sdk.pendo.io.d6.h<String, String> hVar) {
        if (!z) {
            return i2;
        }
        try {
            String apply = hVar.apply(str);
            return apply == null ? i : Integer.parseInt(apply);
        } catch (Throwable unused) {
            return i;
        }
    }

    public static void a() {
        a(f1423a);
    }

    static void a(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    static void a(boolean z) {
        if (!z) {
            return;
        }
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = c;
            ScheduledExecutorService scheduledExecutorService = atomicReference.get();
            if (scheduledExecutorService != null) {
                return;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new j("RxSchedulerPurge"));
            if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, scheduledExecutorService, newScheduledThreadPool)) {
                a aVar = new a();
                long j = b;
                newScheduledThreadPool.scheduleAtFixedRate(aVar, j, j, TimeUnit.SECONDS);
                return;
            }
            newScheduledThreadPool.shutdownNow();
        }
    }
}
