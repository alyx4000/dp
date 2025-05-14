package external.sdk.pendo.io.glide.load.engine;

import android.os.Process;
import external.sdk.pendo.io.glide.load.engine.m;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
final class ActiveResources {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f642a;
    private final Executor b;
    final Map<sdk.pendo.io.q.f, c> c;
    private final ReferenceQueue<m<?>> d;
    private m.a e;
    private volatile boolean f;
    private volatile DequeuedResourceCallback g;

    interface DequeuedResourceCallback {
        void a();
    }

    class a implements ThreadFactory {

        /* renamed from: external.sdk.pendo.io.glide.load.engine.ActiveResources$a$a, reason: collision with other inner class name */
        class RunnableC0056a implements Runnable {
            final /* synthetic */ Runnable f;

            RunnableC0056a(Runnable runnable) {
                this.f = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.f.run();
            }
        }

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(new RunnableC0056a(runnable), "glide-active-resources");
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActiveResources.this.a();
        }
    }

    static final class c extends WeakReference<m<?>> {

        /* renamed from: a, reason: collision with root package name */
        final sdk.pendo.io.q.f f643a;
        final boolean b;
        sdk.pendo.io.t.c<?> c;

        c(sdk.pendo.io.q.f fVar, m<?> mVar, ReferenceQueue<? super m<?>> referenceQueue, boolean z) {
            super(mVar, referenceQueue);
            this.f643a = (sdk.pendo.io.q.f) sdk.pendo.io.i0.j.a(fVar);
            this.c = (mVar.c() && z) ? (sdk.pendo.io.t.c) sdk.pendo.io.i0.j.a(mVar.b()) : null;
            this.b = mVar.c();
        }

        void a() {
            this.c = null;
            clear();
        }
    }

    ActiveResources(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new a()));
    }

    synchronized void a(sdk.pendo.io.q.f fVar, m<?> mVar) {
        c put = this.c.put(fVar, new c(fVar, mVar, this.d, this.f642a));
        if (put != null) {
            put.a();
        }
    }

    synchronized m<?> b(sdk.pendo.io.q.f fVar) {
        c cVar = this.c.get(fVar);
        if (cVar == null) {
            return null;
        }
        m<?> mVar = cVar.get();
        if (mVar == null) {
            a(cVar);
        }
        return mVar;
    }

    ActiveResources(boolean z, Executor executor) {
        this.c = new HashMap();
        this.d = new ReferenceQueue<>();
        this.f642a = z;
        this.b = executor;
        executor.execute(new b());
    }

    void a() {
        while (!this.f) {
            try {
                a((c) this.d.remove());
                DequeuedResourceCallback dequeuedResourceCallback = this.g;
                if (dequeuedResourceCallback != null) {
                    dequeuedResourceCallback.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    void b() {
        this.f = true;
        Executor executor = this.b;
        if (executor instanceof ExecutorService) {
            sdk.pendo.io.i0.e.a((ExecutorService) executor);
        }
    }

    void a(c cVar) {
        sdk.pendo.io.t.c<?> cVar2;
        synchronized (this) {
            this.c.remove(cVar.f643a);
            if (cVar.b && (cVar2 = cVar.c) != null) {
                this.e.onResourceReleased(cVar.f643a, new m<>(cVar2, true, false, cVar.f643a, this.e));
            }
        }
    }

    synchronized void a(sdk.pendo.io.q.f fVar) {
        c remove = this.c.remove(fVar);
        if (remove != null) {
            remove.a();
        }
    }

    void a(m.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.e = aVar;
            }
        }
    }
}
