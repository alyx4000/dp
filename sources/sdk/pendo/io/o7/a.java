package sdk.pendo.io.o7;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import sdk.pendo.io.m7.a;
import sdk.pendo.io.n7.d;
import sdk.pendo.io.p7.c;

/* loaded from: classes6.dex */
public abstract class a extends sdk.pendo.io.n7.d {
    private static final Logger p = Logger.getLogger(a.class.getName());
    private boolean o;

    /* renamed from: sdk.pendo.io.o7.a$a, reason: collision with other inner class name */
    class RunnableC0214a implements Runnable {
        final /* synthetic */ Runnable f;

        /* renamed from: sdk.pendo.io.o7.a$a$a, reason: collision with other inner class name */
        class RunnableC0215a implements Runnable {
            final /* synthetic */ a f;

            RunnableC0215a(a aVar) {
                this.f = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.p.fine("paused");
                ((sdk.pendo.io.n7.d) this.f).l = d.e.PAUSED;
                RunnableC0214a.this.f.run();
            }
        }

        /* renamed from: sdk.pendo.io.o7.a$a$b */
        class b implements a.InterfaceC0197a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int[] f1462a;
            final /* synthetic */ Runnable b;

            b(int[] iArr, Runnable runnable) {
                this.f1462a = iArr;
                this.b = runnable;
            }

            @Override // sdk.pendo.io.m7.a.InterfaceC0197a
            public void call(Object... objArr) {
                a.p.fine("pre-pause polling complete");
                int[] iArr = this.f1462a;
                int i = iArr[0] - 1;
                iArr[0] = i;
                if (i == 0) {
                    this.b.run();
                }
            }
        }

        /* renamed from: sdk.pendo.io.o7.a$a$c */
        class c implements a.InterfaceC0197a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int[] f1463a;
            final /* synthetic */ Runnable b;

            c(int[] iArr, Runnable runnable) {
                this.f1463a = iArr;
                this.b = runnable;
            }

            @Override // sdk.pendo.io.m7.a.InterfaceC0197a
            public void call(Object... objArr) {
                a.p.fine("pre-pause writing complete");
                int[] iArr = this.f1463a;
                int i = iArr[0] - 1;
                iArr[0] = i;
                if (i == 0) {
                    this.b.run();
                }
            }
        }

        RunnableC0214a(Runnable runnable) {
            this.f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            ((sdk.pendo.io.n7.d) aVar).l = d.e.PAUSED;
            RunnableC0215a runnableC0215a = new RunnableC0215a(aVar);
            a aVar2 = a.this;
            boolean z = aVar2.o;
            if (!z && aVar2.b) {
                runnableC0215a.run();
                return;
            }
            int[] iArr = {0};
            if (z) {
                a.p.fine("we are currently polling - waiting to pause");
                iArr[0] = iArr[0] + 1;
                a.this.c("pollComplete", new b(iArr, runnableC0215a));
            }
            if (a.this.b) {
                return;
            }
            a.p.fine("we are currently writing - waiting to pause");
            iArr[0] = iArr[0] + 1;
            a.this.c("drain", new c(iArr, runnableC0215a));
        }
    }

    class b implements c.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f1464a;

        b(a aVar) {
            this.f1464a = aVar;
        }

        @Override // sdk.pendo.io.p7.c.e
        public boolean a(sdk.pendo.io.p7.b bVar, int i, int i2) {
            if (((sdk.pendo.io.n7.d) this.f1464a).l == d.e.OPENING) {
                this.f1464a.f();
            }
            if ("close".equals(bVar.f1498a)) {
                this.f1464a.e();
                return false;
            }
            this.f1464a.a(bVar);
            return true;
        }
    }

    class c implements a.InterfaceC0197a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f1465a;

        c(a aVar) {
            this.f1465a = aVar;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            a.p.fine("writing close packet");
            try {
                this.f1465a.b(new sdk.pendo.io.p7.b[]{new sdk.pendo.io.p7.b("close")});
            } catch (sdk.pendo.io.v7.b e) {
                throw new RuntimeException(e);
            }
        }
    }

    class d implements Runnable {
        final /* synthetic */ a f;

        d(a aVar) {
            this.f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = this.f;
            aVar.b = true;
            aVar.a("drain", new Object[0]);
        }
    }

    class e implements c.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f1466a;
        final /* synthetic */ Runnable b;

        e(a aVar, Runnable runnable) {
            this.f1466a = aVar;
            this.b = runnable;
        }

        @Override // sdk.pendo.io.p7.c.f
        public void a(Object obj) {
            if (obj instanceof byte[]) {
                this.f1466a.a((byte[]) obj, this.b);
            } else if (obj instanceof String) {
                this.f1466a.a((String) obj, this.b);
            } else {
                a.p.warning("Unexpected data: " + obj);
            }
        }
    }

    public a(d.C0211d c0211d) {
        super(c0211d);
        this.c = "polling";
    }

    private void a(Object obj) {
        Logger logger = p;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            logger.fine(String.format("polling got data %s", obj));
        }
        b bVar = new b(this);
        if (obj instanceof String) {
            sdk.pendo.io.p7.c.a((String) obj, bVar);
        } else if (obj instanceof byte[]) {
            sdk.pendo.io.p7.c.a((byte[]) obj, bVar);
        }
        if (this.l != d.e.CLOSED) {
            this.o = false;
            a("pollComplete", new Object[0]);
            if (this.l == d.e.OPEN) {
                i();
            } else if (logger.isLoggable(level)) {
                logger.fine(String.format("ignoring poll - transport state '%s'", this.l));
            }
        }
    }

    private void i() {
        p.fine("polling");
        this.o = true;
        h();
        a("poll", new Object[0]);
    }

    protected abstract void a(String str, Runnable runnable);

    protected abstract void a(byte[] bArr, Runnable runnable);

    @Override // sdk.pendo.io.n7.d
    protected void d() {
        i();
    }

    protected abstract void h();

    protected String j() {
        Map map = this.d;
        if (map == null) {
            map = new HashMap();
        }
        String str = this.e ? "https" : "http";
        if (this.f) {
            map.put(this.j, sdk.pendo.io.w7.a.a());
        }
        String a2 = sdk.pendo.io.s7.a.a((Map<String, String>) map);
        String str2 = (this.g <= 0 || ((!"https".equals(str) || this.g == 443) && (!"http".equals(str) || this.g == 80))) ? "" : ":" + this.g;
        if (a2.length() > 0) {
            a2 = "?" + a2;
        }
        return str + "://" + (this.i.contains(":") ? "[" + this.i + "]" : this.i) + str2 + this.h + a2;
    }

    @Override // sdk.pendo.io.n7.d
    protected void c() {
        c cVar = new c(this);
        if (this.l == d.e.OPEN) {
            p.fine("transport open - closing");
            cVar.call(new Object[0]);
        } else {
            p.fine("transport not open - deferring close");
            c(AbstractCircuitBreaker.PROPERTY_NAME, cVar);
        }
    }

    @Override // sdk.pendo.io.n7.d
    protected void b(String str) {
        a((Object) str);
    }

    @Override // sdk.pendo.io.n7.d
    protected void b(sdk.pendo.io.p7.b[] bVarArr) {
        this.b = false;
        sdk.pendo.io.p7.c.a(bVarArr, new e(this, new d(this)));
    }

    @Override // sdk.pendo.io.n7.d
    protected void a(byte[] bArr) {
        a((Object) bArr);
    }

    public void a(Runnable runnable) {
        sdk.pendo.io.u7.a.a(new RunnableC0214a(runnable));
    }
}
