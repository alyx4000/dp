package sdk.pendo.io.c8;

import android.os.Handler;
import android.os.HandlerThread;
import java.io.File;
import java.io.IOException;
import java.lang.Thread;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.g9.h;
import sdk.pendo.io.logging.PendoLogger;

/* loaded from: classes6.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private File f958a;
    private int b;
    private int c;
    private final AtomicInteger d;
    private final AtomicInteger e;
    private float f;
    private float g;
    private final AtomicLong h;
    private final AtomicBoolean i;
    private boolean j;
    private boolean k;
    private e l;
    private Runnable m;
    private final Runnable n;
    private final d o;

    /* renamed from: sdk.pendo.io.c8.a$a, reason: collision with other inner class name */
    class RunnableC0095a implements Runnable {
        RunnableC0095a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.d.get() > 0) {
                a aVar = a.this;
                aVar.o.a(aVar.j);
            } else {
                a.this.a(r0.b);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    File file = a.this.f958a;
                    if (file != null && file.length() != 0) {
                        if (a.this.h.get() >= a.this.f958a.length()) {
                            sdk.pendo.io.g9.h.a(a.this.f958a);
                        } else if (a.this.h.get() > 0) {
                            a aVar = a.this;
                            String a2 = sdk.pendo.io.g9.h.a(aVar.f958a, aVar.h.get(), (h.a) null);
                            sdk.pendo.io.g9.h.a(a.this.f958a);
                            if (!a2.isEmpty()) {
                                sdk.pendo.io.g9.h.a(a.this.f958a, a2.getBytes(Charset.forName("UTF-8")));
                            }
                        }
                        AtomicInteger atomicInteger = a.this.d;
                        atomicInteger.set(atomicInteger.get() - a.this.e.get());
                    }
                    a.this.m();
                } catch (Exception e) {
                    PendoLogger.e(e, e.getMessage(), new Object[0]);
                }
            } finally {
                a.this.a(r1.b);
            }
        }
    }

    class c implements h.a {
        c() {
        }

        @Override // sdk.pendo.io.g9.h.a
        public void a(long j) {
            a.this.h.set(j);
            if (j > 0) {
                a aVar = a.this;
                aVar.e.set(aVar.d.get());
                a.this.i.set(true);
            }
        }
    }

    interface d {
        void a(boolean z);
    }

    static class e extends HandlerThread {
        private Handler f;
        private Thread.UncaughtExceptionHandler s;

        /* renamed from: sdk.pendo.io.c8.a$e$a, reason: collision with other inner class name */
        class C0096a implements Thread.UncaughtExceptionHandler {
            C0096a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                PendoLogger.e(th, thread.getName() + " " + th.getMessage(), new Object[0]);
            }
        }

        public e(String str) {
            super(str);
        }

        public void a(Runnable runnable) {
            if (this.f == null) {
                a();
            }
            this.f.post(runnable);
        }

        public void b(Runnable runnable) {
            Handler handler = this.f;
            if (handler != null) {
                handler.removeCallbacks(runnable);
            }
        }

        public void a(Runnable runnable, long j) {
            if (this.f == null) {
                a();
            }
            this.f.postDelayed(runnable, j);
        }

        public void a() {
            this.f = new Handler(getLooper());
            C0096a c0096a = new C0096a();
            this.s = c0096a;
            setUncaughtExceptionHandler(c0096a);
        }
    }

    a(String str, int i, int i2, float f, float f2, d dVar) {
        AtomicInteger atomicInteger = new AtomicInteger();
        this.d = atomicInteger;
        this.e = new AtomicInteger();
        this.h = new AtomicLong();
        this.i = new AtomicBoolean();
        this.m = new RunnableC0095a();
        this.n = new b();
        this.b = i;
        this.c = i2;
        this.o = dVar;
        this.f = f;
        this.g = f2;
        try {
            File a2 = sdk.pendo.io.g9.h.a(PendoInternal.m(), str);
            this.f958a = a2;
            if (a2.length() > 0) {
                atomicInteger.set(a());
            }
            c();
            a(this.b);
        } catch (IOException e2) {
            PendoLogger.e(e2, e2.getMessage(), new Object[0]);
            this.f958a = null;
            this.l.quit();
        } catch (Exception e3) {
            PendoLogger.e(e3, e3.getMessage(), new Object[0]);
            this.l.quit();
        }
    }

    private int a() {
        return e().length - 1;
    }

    private synchronized void c() {
        e eVar = new e(this.f958a.getName() + " worker");
        this.l = eVar;
        eVar.start();
        this.l.a();
    }

    private synchronized String[] e() {
        return sdk.pendo.io.g9.h.a(this.f958a, 0L, (h.a) null).split("\\}\\|\\{");
    }

    private boolean k() {
        return this.i.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.i.set(false);
        this.h.set(0L);
        this.e.set(0);
    }

    synchronized void b() {
        File file = this.f958a;
        if (file != null) {
            sdk.pendo.io.g9.h.a(file);
            this.d.set(0);
            m();
            o();
        }
    }

    synchronized void d() {
        File file = this.f958a;
        if (file != null) {
            if (!file.delete()) {
                PendoLogger.w("AnalyticEventsBuffer couldn't delete the file " + this.f958a.getName(), new Object[0]);
            }
            m();
            o();
            this.f958a = null;
        }
        e eVar = this.l;
        if (eVar != null) {
            eVar.quit();
        }
    }

    public synchronized e f() {
        if (this.l == null) {
            c();
        }
        return this.l;
    }

    int g() {
        return this.e.get();
    }

    synchronized String h() {
        return sdk.pendo.io.g9.h.a(this.f958a, 0L, new c());
    }

    int i() {
        return this.d.get();
    }

    synchronized void j() {
        if (this.f958a != null && this.f != -1.0f && r0.length() > this.f) {
            long length = (long) (this.f958a.length() - (this.f * this.g));
            String a2 = sdk.pendo.io.g9.h.a(this.f958a, length, (h.a) null);
            int length2 = a2.split("\\}\\|\\{").length - 1;
            int i = this.d.get() - length2;
            int indexOf = a2.indexOf("}|{");
            float length3 = length + a2.substring(0, indexOf).length();
            this.d.set(length2);
            if (this.h.get() > length3) {
                this.h.set((long) (r1.get() - length3));
                AtomicInteger atomicInteger = this.e;
                atomicInteger.set(atomicInteger.get() - i);
            } else {
                this.h.set(0L);
                this.e.set(0);
            }
            sdk.pendo.io.g9.h.a(this.f958a);
            if (this.d.get() > 0) {
                sdk.pendo.io.g9.h.a(this.f958a, a2.substring(indexOf).getBytes(Charset.forName("UTF-8")));
            }
        }
    }

    public synchronized String l() {
        return sdk.pendo.io.g9.h.a(this.f958a, 0L, (h.a) null);
    }

    public void n() {
        this.i.set(false);
    }

    synchronized void o() {
        this.k = false;
        f().b(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(boolean z) {
        if (k()) {
            j();
            return;
        }
        if (this.d.get() >= this.c || z) {
            o();
            this.j = z;
            this.m.run();
            this.j = false;
        }
    }

    synchronized void b(final boolean z) {
        f().a(new Runnable() { // from class: sdk.pendo.io.c8.a$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.a(z);
            }
        });
    }

    synchronized void d(boolean z) {
        if (z) {
            f().a(this.n);
        } else {
            this.n.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, int i, boolean z) {
        if (sdk.pendo.io.g9.h.a(this.f958a, str.getBytes(Charset.forName("UTF-8")))) {
            this.d.addAndGet(i);
        }
        a(z);
    }

    synchronized void b(final String str, final int i, final boolean z) {
        if (this.d.get() == 0 && !this.k) {
            a(this.b);
        }
        if (str.isEmpty()) {
            return;
        }
        f().a(new Runnable() { // from class: sdk.pendo.io.c8.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                a.this.a(str, i, z);
            }
        });
    }

    synchronized void a(int i, int i2, float f) {
        this.b = i;
        this.c = i2;
        this.f = f;
    }

    synchronized void a(long j) {
        if (!sdk.pendo.io.t8.a.d()) {
            this.k = true;
            f().a(this.m, j * 1000);
        }
    }
}
