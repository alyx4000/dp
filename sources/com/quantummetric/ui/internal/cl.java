package com.quantummetric.ui.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import io.sentry.protocol.SentryThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes5.dex */
public final class cl {
    private static Handler b;

    /* renamed from: a, reason: collision with root package name */
    private static final ExecutorService f172a = Executors.newFixedThreadPool(6);
    private static final Handler c = new Handler(Looper.getMainLooper());

    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f173a;

        a(Runnable runnable) {
            this.f173a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f173a.run();
            } catch (Throwable unused) {
            }
        }
    }

    static void a(a aVar) {
        c.removeCallbacks(aVar);
    }

    static void a(Runnable runnable) {
        f172a.execute(new a(runnable));
    }

    static void a(Runnable runnable, int i) {
        if (b == null) {
            HandlerThread handlerThread = new HandlerThread("HandlerTread");
            handlerThread.start();
            b = new Handler(handlerThread.getLooper());
        }
        b.postDelayed(new a(runnable), i);
    }

    static boolean a() {
        return Thread.currentThread().getName().equals(SentryThread.JsonKeys.MAIN);
    }

    static a b(Runnable runnable, int i) {
        a aVar = new a(runnable);
        c.postDelayed(aVar, i);
        return aVar;
    }

    static void b(Runnable runnable) {
        if (b == null) {
            HandlerThread handlerThread = new HandlerThread("HandlerTread");
            handlerThread.start();
            b = new Handler(handlerThread.getLooper());
        }
        b.post(new a(runnable));
    }

    public static void c(Runnable runnable) {
        c.post(new a(runnable));
    }
}
