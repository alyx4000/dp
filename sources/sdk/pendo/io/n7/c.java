package sdk.pendo.io.n7;

import androidx.core.app.NotificationCompat;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import io.sentry.Session;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.json.JSONException;
import sdk.pendo.io.m7.a;
import sdk.pendo.io.n7.d;
import sdk.pendo.io.w2.e;
import sdk.pendo.io.w2.h0;
import sdk.pendo.io.w2.z;

/* loaded from: classes6.dex */
public class c extends sdk.pendo.io.m7.a {
    private static final Logger C = Logger.getLogger(c.class.getName());
    private static boolean D = false;
    private static h0.a E;
    private static e.a F;
    private static z G;
    private ScheduledExecutorService A;
    private final a.InterfaceC0197a B;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    int g;
    private int h;
    private int i;
    private long j;
    private long k;
    private String l;
    String m;
    private String n;
    private String o;
    private List<String> p;
    private Map<String, d.C0211d> q;
    private List<String> r;
    private Map<String, String> s;
    LinkedList<sdk.pendo.io.p7.b> t;
    sdk.pendo.io.n7.d u;
    private Future v;
    private Future w;
    private h0.a x;
    private e.a y;
    private v z;

    class a implements a.InterfaceC0197a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a.InterfaceC0197a f1425a;

        a(a.InterfaceC0197a interfaceC0197a) {
            this.f1425a = interfaceC0197a;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            this.f1425a.call("transport closed");
        }
    }

    class b implements a.InterfaceC0197a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a.InterfaceC0197a f1426a;

        b(a.InterfaceC0197a interfaceC0197a) {
            this.f1426a = interfaceC0197a;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            this.f1426a.call("socket closed");
        }
    }

    /* renamed from: sdk.pendo.io.n7.c$c, reason: collision with other inner class name */
    class C0208c implements a.InterfaceC0197a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ sdk.pendo.io.n7.d[] f1427a;
        final /* synthetic */ a.InterfaceC0197a b;

        C0208c(sdk.pendo.io.n7.d[] dVarArr, a.InterfaceC0197a interfaceC0197a) {
            this.f1427a = dVarArr;
            this.b = interfaceC0197a;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            sdk.pendo.io.n7.d dVar = (sdk.pendo.io.n7.d) objArr[0];
            sdk.pendo.io.n7.d dVar2 = this.f1427a[0];
            if (dVar2 == null || dVar.c.equals(dVar2.c)) {
                return;
            }
            Logger logger = c.C;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format(Locale.US, "'%s' works - aborting '%s'", dVar.c, this.f1427a[0].c));
            }
            this.b.call(new Object[0]);
        }
    }

    class d implements Runnable {
        final /* synthetic */ a.InterfaceC0197a A;
        final /* synthetic */ sdk.pendo.io.n7.d[] f;
        final /* synthetic */ a.InterfaceC0197a f0;
        final /* synthetic */ a.InterfaceC0197a s;
        final /* synthetic */ c t0;
        final /* synthetic */ a.InterfaceC0197a u0;
        final /* synthetic */ a.InterfaceC0197a v0;

        d(sdk.pendo.io.n7.d[] dVarArr, a.InterfaceC0197a interfaceC0197a, a.InterfaceC0197a interfaceC0197a2, a.InterfaceC0197a interfaceC0197a3, c cVar, a.InterfaceC0197a interfaceC0197a4, a.InterfaceC0197a interfaceC0197a5) {
            this.f = dVarArr;
            this.s = interfaceC0197a;
            this.A = interfaceC0197a2;
            this.f0 = interfaceC0197a3;
            this.t0 = cVar;
            this.u0 = interfaceC0197a4;
            this.v0 = interfaceC0197a5;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f[0].a(AbstractCircuitBreaker.PROPERTY_NAME, this.s);
            this.f[0].a("error", this.A);
            this.f[0].a("close", this.f0);
            this.t0.a("close", this.u0);
            this.t0.a("upgrading", this.v0);
        }
    }

    class e implements Runnable {
        final /* synthetic */ c f;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = e.this.f;
                if (cVar.z == v.CLOSED) {
                    return;
                }
                cVar.c("ping timeout");
            }
        }

        e(c cVar) {
            this.f = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            sdk.pendo.io.u7.a.a(new a());
        }
    }

    class f implements Runnable {
        final /* synthetic */ c f;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger logger = c.C;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(String.format(Locale.US, "writing ping packet - expecting pong within %sms", Long.valueOf(f.this.f.k)));
                }
                f.this.f.i();
                c cVar = f.this.f;
                cVar.a(cVar.k);
            }
        }

        f(c cVar) {
            this.f = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            sdk.pendo.io.u7.a.a(new a());
        }
    }

    class g implements Runnable {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a("ping", new Object[0]);
            }
        }

        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.b("ping", new a());
        }
    }

    class h implements Runnable {
        final /* synthetic */ String f;
        final /* synthetic */ Runnable s;

        h(String str, Runnable runnable) {
            this.f = str;
            this.s = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a("message", this.f, this.s);
        }
    }

    class i implements Runnable {
        final /* synthetic */ byte[] f;
        final /* synthetic */ Runnable s;

        i(byte[] bArr, Runnable runnable) {
            this.f = bArr;
            this.s = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a("message", this.f, this.s);
        }
    }

    class j implements a.InterfaceC0197a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f1428a;

        j(Runnable runnable) {
            this.f1428a = runnable;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            this.f1428a.run();
        }
    }

    class k implements a.InterfaceC0197a {
        k() {
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            c.this.a(objArr.length > 0 ? ((Long) objArr[0]).longValue() : 0L);
        }
    }

    class l implements Runnable {

        class a implements Runnable {
            final /* synthetic */ c f;

            a(c cVar) {
                this.f = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f.a("error", new sdk.pendo.io.n7.a("No transports available"));
            }
        }

        l() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:
        
            if (r0.p.contains("websocket") != false) goto L14;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
                sdk.pendo.io.n7.c r0 = sdk.pendo.io.n7.c.this
                boolean r1 = sdk.pendo.io.n7.c.m3150$$Nest$fgetf(r0)
                if (r1 == 0) goto L1b
                boolean r1 = sdk.pendo.io.n7.c.m3169$$Nest$sfgetD()
                if (r1 == 0) goto L1b
                java.util.List r0 = sdk.pendo.io.n7.c.m3152$$Nest$fgetp(r0)
                java.lang.String r1 = "websocket"
                boolean r0 = r0.contains(r1)
                if (r0 == 0) goto L1b
                goto L40
            L1b:
                sdk.pendo.io.n7.c r0 = sdk.pendo.io.n7.c.this
                java.util.List r0 = sdk.pendo.io.n7.c.m3152$$Nest$fgetp(r0)
                int r0 = r0.size()
                if (r0 != 0) goto L32
                sdk.pendo.io.n7.c r0 = sdk.pendo.io.n7.c.this
                sdk.pendo.io.n7.c$l$a r1 = new sdk.pendo.io.n7.c$l$a
                r1.<init>(r0)
                sdk.pendo.io.u7.a.b(r1)
                return
            L32:
                sdk.pendo.io.n7.c r0 = sdk.pendo.io.n7.c.this
                java.util.List r0 = sdk.pendo.io.n7.c.m3152$$Nest$fgetp(r0)
                r1 = 0
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
            L40:
                sdk.pendo.io.n7.c r0 = sdk.pendo.io.n7.c.this
                sdk.pendo.io.n7.c$v r2 = sdk.pendo.io.n7.c.v.OPENING
                sdk.pendo.io.n7.c.m3155$$Nest$fputz(r0, r2)
                sdk.pendo.io.n7.d r0 = sdk.pendo.io.n7.c.m3162$$Nest$mb(r0, r1)
                sdk.pendo.io.n7.c r1 = sdk.pendo.io.n7.c.this
                sdk.pendo.io.n7.c.m3160$$Nest$ma(r1, r0)
                r0.g()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.n7.c.l.run():void");
        }
    }

    class m implements Runnable {

        class a implements Runnable {
            final /* synthetic */ c f;

            a(c cVar) {
                this.f = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f.c("forced close");
                c.C.fine("socket closing - telling transport to close");
                this.f.u.b();
            }
        }

        class b implements a.InterfaceC0197a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f1430a;
            final /* synthetic */ a.InterfaceC0197a[] b;
            final /* synthetic */ Runnable c;

            b(c cVar, a.InterfaceC0197a[] interfaceC0197aArr, Runnable runnable) {
                this.f1430a = cVar;
                this.b = interfaceC0197aArr;
                this.c = runnable;
            }

            @Override // sdk.pendo.io.m7.a.InterfaceC0197a
            public void call(Object... objArr) {
                this.f1430a.a("upgrade", this.b[0]);
                this.f1430a.a("upgradeError", this.b[0]);
                this.c.run();
            }
        }

        /* renamed from: sdk.pendo.io.n7.c$m$c, reason: collision with other inner class name */
        class RunnableC0209c implements Runnable {
            final /* synthetic */ c f;
            final /* synthetic */ a.InterfaceC0197a[] s;

            RunnableC0209c(c cVar, a.InterfaceC0197a[] interfaceC0197aArr) {
                this.f = cVar;
                this.s = interfaceC0197aArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f.c("upgrade", this.s[0]);
                this.f.c("upgradeError", this.s[0]);
            }
        }

        class d implements a.InterfaceC0197a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Runnable f1431a;
            final /* synthetic */ Runnable b;

            d(Runnable runnable, Runnable runnable2) {
                this.f1431a = runnable;
                this.b = runnable2;
            }

            @Override // sdk.pendo.io.m7.a.InterfaceC0197a
            public void call(Object... objArr) {
                (c.this.e ? this.f1431a : this.b).run();
            }
        }

        m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            v vVar = cVar.z;
            if (vVar == v.OPENING || vVar == v.OPEN) {
                cVar.z = v.CLOSING;
                a aVar = new a(cVar);
                a.InterfaceC0197a[] interfaceC0197aArr = new a.InterfaceC0197a[1];
                interfaceC0197aArr[0] = new b(cVar, interfaceC0197aArr, aVar);
                RunnableC0209c runnableC0209c = new RunnableC0209c(cVar, interfaceC0197aArr);
                if (c.this.t.size() > 0) {
                    c.this.c("drain", new d(runnableC0209c, aVar));
                } else if (c.this.e) {
                    runnableC0209c.run();
                } else {
                    aVar.run();
                }
            }
        }
    }

    class n implements a.InterfaceC0197a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f1432a;

        n(c cVar) {
            this.f1432a = cVar;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            this.f1432a.c("transport close");
        }
    }

    class o implements a.InterfaceC0197a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f1433a;

        o(c cVar) {
            this.f1433a = cVar;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            this.f1433a.a(objArr.length > 0 ? (Exception) objArr[0] : null);
        }
    }

    class p implements a.InterfaceC0197a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f1434a;

        p(c cVar) {
            this.f1434a = cVar;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            this.f1434a.a(objArr.length > 0 ? (sdk.pendo.io.p7.b) objArr[0] : null);
        }
    }

    class q implements a.InterfaceC0197a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f1435a;

        q(c cVar) {
            this.f1435a = cVar;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            this.f1435a.f();
        }
    }

    class r implements a.InterfaceC0197a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean[] f1436a;
        final /* synthetic */ String b;
        final /* synthetic */ sdk.pendo.io.n7.d[] c;
        final /* synthetic */ c d;
        final /* synthetic */ Runnable[] e;

        class a implements a.InterfaceC0197a {

            /* renamed from: sdk.pendo.io.n7.c$r$a$a, reason: collision with other inner class name */
            class RunnableC0210a implements Runnable {
                RunnableC0210a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    r rVar = r.this;
                    if (rVar.f1436a[0] || v.CLOSED == rVar.d.z) {
                        return;
                    }
                    c.C.fine("changing transport and sending upgrade packet");
                    r.this.e[0].run();
                    r rVar2 = r.this;
                    rVar2.d.a(rVar2.c[0]);
                    r.this.c[0].a(new sdk.pendo.io.p7.b[]{new sdk.pendo.io.p7.b("upgrade")});
                    r rVar3 = r.this;
                    rVar3.d.a("upgrade", rVar3.c[0]);
                    r rVar4 = r.this;
                    rVar4.c[0] = null;
                    c cVar = rVar4.d;
                    cVar.e = false;
                    cVar.c();
                }
            }

            a() {
            }

            @Override // sdk.pendo.io.m7.a.InterfaceC0197a
            public void call(Object... objArr) {
                if (r.this.f1436a[0]) {
                    return;
                }
                sdk.pendo.io.p7.b bVar = (sdk.pendo.io.p7.b) objArr[0];
                if (!"pong".equals(bVar.f1498a) || !"probe".equals(bVar.b)) {
                    Logger logger = c.C;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(String.format(Locale.US, "probe transport '%s' failed", r.this.b));
                    }
                    sdk.pendo.io.n7.a aVar = new sdk.pendo.io.n7.a("probe error");
                    r rVar = r.this;
                    aVar.f = rVar.c[0].c;
                    rVar.d.a("upgradeError", aVar);
                    return;
                }
                Logger logger2 = c.C;
                Level level = Level.FINE;
                if (logger2.isLoggable(level)) {
                    logger2.fine(String.format(Locale.US, "probe transport '%s' pong", r.this.b));
                }
                r rVar2 = r.this;
                c cVar = rVar2.d;
                cVar.e = true;
                cVar.a("upgrading", rVar2.c[0]);
                sdk.pendo.io.n7.d dVar = r.this.c[0];
                if (dVar == null) {
                    return;
                }
                c.D = "websocket".equals(dVar.c);
                if (logger2.isLoggable(level)) {
                    logger2.fine(String.format(Locale.US, "pausing current transport '%s'", r.this.d.u.c));
                }
                ((sdk.pendo.io.o7.a) r.this.d.u).a((Runnable) new RunnableC0210a());
            }
        }

        r(boolean[] zArr, String str, sdk.pendo.io.n7.d[] dVarArr, c cVar, Runnable[] runnableArr) {
            this.f1436a = zArr;
            this.b = str;
            this.c = dVarArr;
            this.d = cVar;
            this.e = runnableArr;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            if (this.f1436a[0]) {
                return;
            }
            Logger logger = c.C;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format(Locale.US, "probe transport '%s' opened", this.b));
            }
            this.c[0].a(new sdk.pendo.io.p7.b[]{new sdk.pendo.io.p7.b("ping", "probe")});
            this.c[0].c("packet", new a());
        }
    }

    class s implements a.InterfaceC0197a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean[] f1438a;
        final /* synthetic */ Runnable[] b;
        final /* synthetic */ sdk.pendo.io.n7.d[] c;

        s(boolean[] zArr, Runnable[] runnableArr, sdk.pendo.io.n7.d[] dVarArr) {
            this.f1438a = zArr;
            this.b = runnableArr;
            this.c = dVarArr;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            boolean[] zArr = this.f1438a;
            if (zArr[0]) {
                return;
            }
            zArr[0] = true;
            this.b[0].run();
            this.c[0].b();
            this.c[0] = null;
        }
    }

    class t implements a.InterfaceC0197a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ sdk.pendo.io.n7.d[] f1439a;
        final /* synthetic */ a.InterfaceC0197a b;
        final /* synthetic */ String c;
        final /* synthetic */ c d;

        t(sdk.pendo.io.n7.d[] dVarArr, a.InterfaceC0197a interfaceC0197a, String str, c cVar) {
            this.f1439a = dVarArr;
            this.b = interfaceC0197a;
            this.c = str;
            this.d = cVar;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            Object obj = objArr[0];
            sdk.pendo.io.n7.a aVar = obj instanceof Exception ? new sdk.pendo.io.n7.a("probe error", (Exception) obj) : obj instanceof String ? new sdk.pendo.io.n7.a("probe error: " + ((String) obj)) : new sdk.pendo.io.n7.a("probe error");
            aVar.f = this.f1439a[0].c;
            this.b.call(new Object[0]);
            Logger logger = c.C;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format(Locale.US, "probe transport \"%s\" failed because of error: %s", this.c, obj));
            }
            this.d.a("upgradeError", aVar);
        }
    }

    public static class u extends d.C0211d {
        public String[] l;
        public boolean m = true;
        public boolean n;
        public String o;
        public String p;
        public Map<String, d.C0211d> q;

        /* JADX INFO: Access modifiers changed from: private */
        public static u a(URI uri, u uVar) {
            if (uVar == null) {
                uVar = new u();
            }
            uVar.o = uri.getHost();
            uVar.d = "https".equals(uri.getScheme()) || "wss".equals(uri.getScheme());
            uVar.f = uri.getPort();
            String rawQuery = uri.getRawQuery();
            if (rawQuery != null) {
                uVar.p = rawQuery;
            }
            return uVar;
        }
    }

    private enum v {
        OPENING,
        OPEN,
        CLOSING,
        CLOSED;

        @Override // java.lang.Enum
        public String toString() {
            return super.toString().toLowerCase(Locale.US);
        }
    }

    public c() {
        this(new u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.z == v.CLOSED || !this.u.b || this.e || this.t.size() == 0) {
            return;
        }
        Logger logger = C;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format(Locale.US, "flushing %d packets in socket", Integer.valueOf(this.t.size())));
        }
        this.i = this.t.size();
        sdk.pendo.io.n7.d dVar = this.u;
        LinkedList<sdk.pendo.io.p7.b> linkedList = this.t;
        dVar.a((sdk.pendo.io.p7.b[]) linkedList.toArray(new sdk.pendo.io.p7.b[linkedList.size()]));
        a("flush", new Object[0]);
    }

    private ScheduledExecutorService d() {
        ScheduledExecutorService scheduledExecutorService = this.A;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            this.A = Executors.newSingleThreadScheduledExecutor();
        }
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        for (int i2 = 0; i2 < this.i; i2++) {
            this.t.poll();
        }
        this.i = 0;
        if (this.t.size() == 0) {
            a("drain", new Object[0]);
        } else {
            c();
        }
    }

    private void g() {
        Logger logger = C;
        logger.fine("socket open");
        v vVar = v.OPEN;
        this.z = vVar;
        D = "websocket".equals(this.u.c);
        a(AbstractCircuitBreaker.PROPERTY_NAME, new Object[0]);
        c();
        if (this.z == vVar && this.c && (this.u instanceof sdk.pendo.io.o7.a)) {
            logger.fine("starting upgrade probes");
            Iterator<String> it = this.r.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        sdk.pendo.io.u7.a.a(new g());
    }

    private void j() {
        Future future = this.w;
        if (future != null) {
            future.cancel(false);
        }
        this.w = d().schedule(new f(this), this.j, TimeUnit.MILLISECONDS);
    }

    List<String> a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (this.p.contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public c b() {
        sdk.pendo.io.u7.a.a(new m());
        return this;
    }

    public String e() {
        return this.l;
    }

    public c h() {
        sdk.pendo.io.u7.a.a(new l());
        return this;
    }

    public c(URI uri, u uVar) {
        this(uri != null ? u.a(uri, uVar) : uVar);
    }

    private void a(String str, Exception exc) {
        v vVar = v.OPENING;
        v vVar2 = this.z;
        if (vVar == vVar2 || v.OPEN == vVar2 || v.CLOSING == vVar2) {
            Logger logger = C;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format(Locale.US, "socket close with reason: %s", str));
            }
            Future future = this.w;
            if (future != null) {
                future.cancel(false);
            }
            Future future2 = this.v;
            if (future2 != null) {
                future2.cancel(false);
            }
            ScheduledExecutorService scheduledExecutorService = this.A;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdown();
            }
            this.u.a("close");
            this.u.b();
            this.u.a();
            this.z = v.CLOSED;
            this.l = null;
            a("close", str, exc);
            this.t.clear();
            this.i = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public sdk.pendo.io.n7.d b(String str) {
        sdk.pendo.io.n7.d bVar;
        Logger logger = C;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format(Locale.US, "creating transport '%s'", str));
        }
        HashMap hashMap = new HashMap(this.s);
        hashMap.put("EIO", String.valueOf(3));
        hashMap.put(NotificationCompat.CATEGORY_TRANSPORT, str);
        String str2 = this.l;
        if (str2 != null) {
            hashMap.put(Session.JsonKeys.SID, str2);
        }
        d.C0211d c0211d = this.q.get(str);
        d.C0211d c0211d2 = new d.C0211d();
        c0211d2.h = hashMap;
        c0211d2.i = this;
        c0211d2.f1440a = c0211d != null ? c0211d.f1440a : this.m;
        c0211d2.f = c0211d != null ? c0211d.f : this.g;
        c0211d2.d = c0211d != null ? c0211d.d : this.b;
        c0211d2.b = c0211d != null ? c0211d.b : this.n;
        c0211d2.e = c0211d != null ? c0211d.e : this.d;
        c0211d2.c = c0211d != null ? c0211d.c : this.o;
        c0211d2.g = c0211d != null ? c0211d.g : this.h;
        c0211d2.k = c0211d != null ? c0211d.k : this.y;
        c0211d2.j = c0211d != null ? c0211d.j : this.x;
        if ("websocket".equals(str)) {
            bVar = new sdk.pendo.io.o7.c(c0211d2);
        } else {
            if (!"polling".equals(str)) {
                throw new RuntimeException();
            }
            bVar = new sdk.pendo.io.o7.b(c0211d2);
        }
        a(NotificationCompat.CATEGORY_TRANSPORT, bVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        a(str, (Exception) null);
    }

    private void d(String str) {
        Logger logger = C;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format(Locale.US, "probing transport '%s'", str));
        }
        sdk.pendo.io.n7.d[] dVarArr = {b(str)};
        boolean[] zArr = {false};
        D = false;
        Runnable[] runnableArr = {new d(dVarArr, r13, r14, r15, this, r8, r7)};
        r rVar = new r(zArr, str, dVarArr, this, runnableArr);
        s sVar = new s(zArr, runnableArr, dVarArr);
        t tVar = new t(dVarArr, sVar, str, this);
        a aVar = new a(tVar);
        b bVar = new b(tVar);
        C0208c c0208c = new C0208c(dVarArr, sVar);
        dVarArr[0].c(AbstractCircuitBreaker.PROPERTY_NAME, rVar);
        dVarArr[0].c("error", tVar);
        dVarArr[0].c("close", aVar);
        c("close", bVar);
        c("upgrading", c0208c);
        dVarArr[0].g();
    }

    public void e(String str) {
        c(str, (Runnable) null);
    }

    public c(u uVar) {
        this.t = new LinkedList<>();
        this.B = new k();
        String str = uVar.o;
        if (str != null) {
            if (str.split(":").length > 2) {
                int indexOf = str.indexOf(91);
                str = indexOf != -1 ? str.substring(indexOf + 1) : str;
                int lastIndexOf = str.lastIndexOf(93);
                if (lastIndexOf != -1) {
                    str = str.substring(0, lastIndexOf);
                }
            }
            uVar.f1440a = str;
        }
        boolean z = uVar.d;
        this.b = z;
        if (uVar.f == -1) {
            uVar.f = z ? 443 : 80;
        }
        String str2 = uVar.f1440a;
        this.m = str2 == null ? AndroidInfoHelpers.DEVICE_LOCALHOST : str2;
        this.g = uVar.f;
        String str3 = uVar.p;
        this.s = str3 != null ? sdk.pendo.io.s7.a.a(str3) : new HashMap<>();
        this.c = uVar.m;
        StringBuilder sb = new StringBuilder();
        String str4 = uVar.b;
        this.n = sb.append((str4 == null ? "/engine.io" : str4).replaceAll("/$", "")).append("/").toString();
        String str5 = uVar.c;
        this.o = str5 == null ? "t" : str5;
        this.d = uVar.e;
        String[] strArr = uVar.l;
        this.p = new ArrayList(Arrays.asList(strArr == null ? new String[]{"polling", "websocket"} : strArr));
        Map<String, d.C0211d> map = uVar.q;
        this.q = map == null ? new HashMap<>() : map;
        int i2 = uVar.g;
        this.h = i2 == 0 ? 843 : i2;
        this.f = uVar.n;
        e.a aVar = uVar.k;
        aVar = aVar == null ? F : aVar;
        this.y = aVar;
        h0.a aVar2 = uVar.j;
        this.x = aVar2 == null ? E : aVar2;
        if (aVar == null) {
            if (G == null) {
                G = new z();
            }
            this.y = G;
        }
        if (this.x == null) {
            if (G == null) {
                G = new z();
            }
            this.x = G;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Exception exc) {
        Logger logger = C;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format(Locale.US, "socket error %s", exc));
        }
        D = false;
        a("error", exc);
        a("transport error", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, Runnable runnable) {
        a(new sdk.pendo.io.p7.b(str), runnable);
    }

    public void c(String str, Runnable runnable) {
        a(str, runnable);
    }

    private void a(sdk.pendo.io.n7.b bVar) {
        a("handshake", bVar);
        String str = bVar.f1424a;
        this.l = str;
        this.u.d.put(Session.JsonKeys.SID, str);
        this.r = a(Arrays.asList(bVar.b));
        this.j = bVar.c;
        this.k = bVar.d;
        g();
        if (v.CLOSED == this.z) {
            return;
        }
        j();
        a("heartbeat", this.B);
        b("heartbeat", this.B);
    }

    public void b(byte[] bArr, Runnable runnable) {
        a(bArr, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        Future future = this.v;
        if (future != null) {
            future.cancel(false);
        }
        if (j2 <= 0) {
            j2 = this.j + this.k;
        }
        this.v = d().schedule(new e(this), j2, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(sdk.pendo.io.p7.b bVar) {
        v vVar = this.z;
        if (vVar != v.OPENING && vVar != v.OPEN && vVar != v.CLOSING) {
            Logger logger = C;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format(Locale.US, "packet received with socket readyState '%s'", this.z));
                return;
            }
            return;
        }
        Logger logger2 = C;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(String.format(Locale.US, "socket received: type '%s', data '%s'", bVar.f1498a, bVar.b));
        }
        a("packet", bVar);
        a("heartbeat", new Object[0]);
        if (AbstractCircuitBreaker.PROPERTY_NAME.equals(bVar.f1498a)) {
            try {
                a(new sdk.pendo.io.n7.b((String) bVar.b));
                return;
            } catch (JSONException e2) {
                a("error", new sdk.pendo.io.n7.a(e2));
                return;
            }
        }
        if ("pong".equals(bVar.f1498a)) {
            j();
            a("pong", new Object[0]);
        } else if ("error".equals(bVar.f1498a)) {
            sdk.pendo.io.n7.a aVar = new sdk.pendo.io.n7.a("server error");
            aVar.s = bVar.b;
            a(aVar);
        } else if ("message".equals(bVar.f1498a)) {
            a("data", bVar.b);
            a("message", bVar.b);
        }
    }

    public void a(String str, Runnable runnable) {
        sdk.pendo.io.u7.a.a(new h(str, runnable));
    }

    public void a(byte[] bArr, Runnable runnable) {
        sdk.pendo.io.u7.a.a(new i(bArr, runnable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, Runnable runnable) {
        a(new sdk.pendo.io.p7.b(str, str2), runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, byte[] bArr, Runnable runnable) {
        a(new sdk.pendo.io.p7.b(str, bArr), runnable);
    }

    private void a(sdk.pendo.io.p7.b bVar, Runnable runnable) {
        v vVar = v.CLOSING;
        v vVar2 = this.z;
        if (vVar == vVar2 || v.CLOSED == vVar2) {
            return;
        }
        a("packetCreate", bVar);
        this.t.offer(bVar);
        if (runnable != null) {
            c("flush", new j(runnable));
        }
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(sdk.pendo.io.n7.d dVar) {
        Logger logger = C;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            logger.fine(String.format(Locale.US, "setting transport %s", dVar.c));
        }
        if (this.u != null) {
            if (logger.isLoggable(level)) {
                logger.fine(String.format(Locale.US, "clearing existing transport %s", this.u.c));
            }
            this.u.a();
        }
        this.u = dVar;
        dVar.b("drain", new q(this)).b("packet", new p(this)).b("error", new o(this)).b("close", new n(this));
    }

    public void a(byte[] bArr) {
        b(bArr, (Runnable) null);
    }
}
