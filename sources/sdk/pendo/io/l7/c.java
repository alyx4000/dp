package sdk.pendo.io.l7;

import androidx.core.app.NotificationCompat;
import io.sentry.ProfilingTraceData;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import sdk.pendo.io.l7.d;
import sdk.pendo.io.m7.a;
import sdk.pendo.io.n7.c;
import sdk.pendo.io.t7.b;
import sdk.pendo.io.t7.d;
import sdk.pendo.io.w2.e;
import sdk.pendo.io.w2.h0;

/* loaded from: classes6.dex */
public class c extends sdk.pendo.io.m7.a {
    private static final Logger w = Logger.getLogger(c.class.getName());
    static h0.a x;
    static e.a y;
    p b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;
    private long h;
    private long i;
    private double j;
    private sdk.pendo.io.k7.a k;
    private long l;
    private Set<sdk.pendo.io.l7.e> m;
    private Date n;
    private URI o;
    private List<sdk.pendo.io.t7.c> p;
    private Queue<d.b> q;
    private o r;
    sdk.pendo.io.n7.c s;
    private d.b t;
    private d.a u;
    ConcurrentHashMap<String, sdk.pendo.io.l7.e> v;

    class a implements Runnable {
        final /* synthetic */ n f;

        /* renamed from: sdk.pendo.io.l7.c$a$a, reason: collision with other inner class name */
        class C0183a implements a.InterfaceC0197a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f1320a;

            C0183a(c cVar) {
                this.f1320a = cVar;
            }

            @Override // sdk.pendo.io.m7.a.InterfaceC0197a
            public void call(Object... objArr) {
                this.f1320a.a(NotificationCompat.CATEGORY_TRANSPORT, objArr);
            }
        }

        class b implements a.InterfaceC0197a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f1321a;

            b(c cVar) {
                this.f1321a = cVar;
            }

            @Override // sdk.pendo.io.m7.a.InterfaceC0197a
            public void call(Object... objArr) {
                this.f1321a.e();
                n nVar = a.this.f;
                if (nVar != null) {
                    nVar.a(null);
                }
            }
        }

        /* renamed from: sdk.pendo.io.l7.c$a$c, reason: collision with other inner class name */
        class C0184c implements a.InterfaceC0197a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f1322a;

            C0184c(c cVar) {
                this.f1322a = cVar;
            }

            @Override // sdk.pendo.io.m7.a.InterfaceC0197a
            public void call(Object... objArr) {
                Object obj = objArr.length > 0 ? objArr[0] : null;
                c.w.fine("connect_error");
                this.f1322a.b();
                c cVar = this.f1322a;
                cVar.b = p.CLOSED;
                cVar.b("connect_error", obj);
                if (a.this.f != null) {
                    a.this.f.a(new sdk.pendo.io.l7.f("Connection error", obj instanceof Exception ? (Exception) obj : null));
                } else {
                    this.f1322a.d();
                }
            }
        }

        class d extends TimerTask {
            final /* synthetic */ sdk.pendo.io.n7.c A;
            final /* synthetic */ long f;
            final /* synthetic */ c f0;
            final /* synthetic */ d.b s;

            /* renamed from: sdk.pendo.io.l7.c$a$d$a, reason: collision with other inner class name */
            class RunnableC0185a implements Runnable {
                RunnableC0185a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    c.w.fine(String.format(Locale.US, "connect attempt timed out after %d", Long.valueOf(d.this.f)));
                    d.this.s.destroy();
                    d.this.A.b();
                    d.this.A.a("error", new sdk.pendo.io.l7.f(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT));
                    d dVar = d.this;
                    dVar.f0.b("connect_timeout", Long.valueOf(dVar.f));
                }
            }

            d(long j, d.b bVar, sdk.pendo.io.n7.c cVar, c cVar2) {
                this.f = j;
                this.s = bVar;
                this.A = cVar;
                this.f0 = cVar2;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                sdk.pendo.io.u7.a.a(new RunnableC0185a());
            }
        }

        class e implements d.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Timer f1323a;

            e(Timer timer) {
                this.f1323a = timer;
            }

            @Override // sdk.pendo.io.l7.d.b
            public void destroy() {
                this.f1323a.cancel();
            }
        }

        a(n nVar) {
            this.f = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            p pVar;
            Logger logger = c.w;
            Level level = Level.FINE;
            if (logger.isLoggable(level)) {
                logger.fine(String.format(Locale.US, "readyState %s", c.this.b));
            }
            p pVar2 = c.this.b;
            if (pVar2 == p.OPEN || pVar2 == (pVar = p.OPENING)) {
                return;
            }
            if (logger.isLoggable(level)) {
                logger.fine(String.format(Locale.US, "opening %s", c.this.o));
            }
            c cVar = c.this;
            c cVar2 = c.this;
            cVar.s = new m(cVar2.o, cVar2.r);
            c cVar3 = c.this;
            sdk.pendo.io.n7.c cVar4 = cVar3.s;
            cVar3.b = pVar;
            cVar3.d = false;
            cVar4.b(NotificationCompat.CATEGORY_TRANSPORT, new C0183a(cVar3));
            d.b a2 = sdk.pendo.io.l7.d.a(cVar4, AbstractCircuitBreaker.PROPERTY_NAME, new b(cVar3));
            d.b a3 = sdk.pendo.io.l7.d.a(cVar4, "error", new C0184c(cVar3));
            long j = c.this.l;
            if (j >= 0) {
                logger.fine(String.format(Locale.US, "connection attempt will timeout after %d", Long.valueOf(j)));
                Timer timer = new Timer();
                timer.schedule(new d(j, a2, cVar4, cVar3), j);
                c.this.q.add(new e(timer));
            }
            c.this.q.add(a2);
            c.this.q.add(a3);
            c.this.s.h();
        }
    }

    class b implements d.b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f1324a;

        b(c cVar) {
            this.f1324a = cVar;
        }

        @Override // sdk.pendo.io.t7.d.b.a
        public void call(Object[] objArr) {
            for (Object obj : objArr) {
                if (obj instanceof String) {
                    this.f1324a.s.e((String) obj);
                } else if (obj instanceof byte[]) {
                    this.f1324a.s.a((byte[]) obj);
                }
            }
            c cVar = this.f1324a;
            cVar.f = false;
            cVar.j();
        }
    }

    /* renamed from: sdk.pendo.io.l7.c$c, reason: collision with other inner class name */
    class C0186c extends TimerTask {
        final /* synthetic */ c f;

        /* renamed from: sdk.pendo.io.l7.c$c$a */
        class a implements Runnable {

            /* renamed from: sdk.pendo.io.l7.c$c$a$a, reason: collision with other inner class name */
            class C0187a implements n {
                C0187a() {
                }

                @Override // sdk.pendo.io.l7.c.n
                public void a(Exception exc) {
                    if (exc == null) {
                        c.w.fine("reconnect success");
                        C0186c.this.f.h();
                        return;
                    }
                    c.w.fine("reconnect attempt error");
                    c cVar = C0186c.this.f;
                    cVar.e = false;
                    cVar.l();
                    C0186c.this.f.b("reconnect_error", exc);
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C0186c.this.f.d) {
                    return;
                }
                c.w.fine("attempting reconnect");
                int b = C0186c.this.f.k.b();
                C0186c.this.f.b("reconnect_attempt", Integer.valueOf(b));
                C0186c.this.f.b("reconnecting", Integer.valueOf(b));
                c cVar = C0186c.this.f;
                if (cVar.d) {
                    return;
                }
                cVar.a(new C0187a());
            }
        }

        C0186c(c cVar) {
            this.f = cVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            sdk.pendo.io.u7.a.a(new a());
        }
    }

    class d implements d.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Timer f1326a;

        d(Timer timer) {
            this.f1326a = timer;
        }

        @Override // sdk.pendo.io.l7.d.b
        public void destroy() {
            this.f1326a.cancel();
        }
    }

    class e implements a.InterfaceC0197a {
        e() {
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                c.this.d((String) obj);
            } else if (obj instanceof byte[]) {
                c.this.a((byte[]) obj);
            }
        }
    }

    class f implements a.InterfaceC0197a {
        f() {
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            c.this.f();
        }
    }

    class g implements a.InterfaceC0197a {
        g() {
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            c.this.g();
        }
    }

    class h implements a.InterfaceC0197a {
        h() {
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            c.this.a((Exception) objArr[0]);
        }
    }

    class i implements a.InterfaceC0197a {
        i() {
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            c.this.c((String) objArr[0]);
        }
    }

    class j implements d.a.InterfaceC0242a {
        j() {
        }

        @Override // sdk.pendo.io.t7.d.a.InterfaceC0242a
        public void a(sdk.pendo.io.t7.c cVar) {
            c.this.a(cVar);
        }
    }

    class k implements a.InterfaceC0197a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f1333a;
        final /* synthetic */ sdk.pendo.io.l7.e b;

        k(c cVar, sdk.pendo.io.l7.e eVar) {
            this.f1333a = cVar;
            this.b = eVar;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            this.f1333a.m.add(this.b);
        }
    }

    class l implements a.InterfaceC0197a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ sdk.pendo.io.l7.e f1334a;
        final /* synthetic */ c b;
        final /* synthetic */ String c;

        l(sdk.pendo.io.l7.e eVar, c cVar, String str) {
            this.f1334a = eVar;
            this.b = cVar;
            this.c = str;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            this.f1334a.b = this.b.b(this.c);
        }
    }

    private static class m extends sdk.pendo.io.n7.c {
        m(URI uri, c.u uVar) {
            super(uri, uVar);
        }
    }

    public interface n {
        void a(Exception exc);
    }

    public static class o extends c.u {
        public int s;
        public long t;
        public long u;
        public double v;
        public d.b w;
        public d.a x;
        public boolean r = true;
        public long y = 20000;
    }

    enum p {
        CLOSED,
        OPENING,
        OPEN
    }

    public c() {
        this(null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        w.fine("cleanup");
        while (true) {
            d.b poll = this.q.poll();
            if (poll == null) {
                this.u.a((d.a.InterfaceC0242a) null);
                this.p.clear();
                this.f = false;
                this.n = null;
                this.u.destroy();
                return;
            }
            poll.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (!this.e && this.c && this.k.b() == 0) {
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        w.fine(AbstractCircuitBreaker.PROPERTY_NAME);
        b();
        this.b = p.OPEN;
        a(AbstractCircuitBreaker.PROPERTY_NAME, new Object[0]);
        sdk.pendo.io.n7.c cVar = this.s;
        this.q.add(sdk.pendo.io.l7.d.a(cVar, "data", new e()));
        this.q.add(sdk.pendo.io.l7.d.a(cVar, "ping", new f()));
        this.q.add(sdk.pendo.io.l7.d.a(cVar, "pong", new g()));
        this.q.add(sdk.pendo.io.l7.d.a(cVar, "error", new h()));
        this.q.add(sdk.pendo.io.l7.d.a(cVar, "close", new i()));
        this.u.a(new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.n = new Date();
        b("ping", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Object[] objArr = new Object[1];
        objArr[0] = Long.valueOf(this.n != null ? new Date().getTime() - this.n.getTime() : 0L);
        b("pong", objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        int b2 = this.k.b();
        this.e = false;
        this.k.c();
        o();
        b("reconnect", Integer.valueOf(b2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.p.isEmpty() || this.f) {
            return;
        }
        b(this.p.remove(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.e || this.d) {
            return;
        }
        if (this.k.b() >= this.g) {
            w.fine("reconnect failed");
            this.k.c();
            b("reconnect_failed", new Object[0]);
            this.e = false;
            return;
        }
        long a2 = this.k.a();
        w.fine(String.format(Locale.US, "will wait %dms before reconnect attempt", Long.valueOf(a2)));
        this.e = true;
        Timer timer = new Timer();
        timer.schedule(new C0186c(this), a2);
        this.q.add(new d(timer));
    }

    private void o() {
        for (Map.Entry<String, sdk.pendo.io.l7.e> entry : this.v.entrySet()) {
            String key = entry.getKey();
            entry.getValue().b = b(key);
        }
    }

    void a(sdk.pendo.io.l7.e eVar) {
        this.m.remove(eVar);
        if (this.m.isEmpty()) {
            c();
        }
    }

    void c() {
        w.fine("disconnect");
        this.d = true;
        this.e = false;
        if (this.b != p.OPEN) {
            b();
        }
        this.k.c();
        this.b = p.CLOSED;
        sdk.pendo.io.n7.c cVar = this.s;
        if (cVar != null) {
            cVar.b();
        }
    }

    public c i() {
        return a((n) null);
    }

    public final double k() {
        return this.j;
    }

    public final long m() {
        return this.h;
    }

    public final long n() {
        return this.i;
    }

    public c(URI uri, o oVar) {
        this.m = new HashSet();
        oVar = oVar == null ? new o() : oVar;
        if (oVar.b == null) {
            oVar.b = "/socket.io";
        }
        if (oVar.j == null) {
            oVar.j = x;
        }
        if (oVar.k == null) {
            oVar.k = y;
        }
        this.r = oVar;
        this.v = new ConcurrentHashMap<>();
        this.q = new LinkedList();
        a(oVar.r);
        int i2 = oVar.s;
        a(i2 == 0 ? Integer.MAX_VALUE : i2);
        long j2 = oVar.t;
        a(j2 == 0 ? 1000L : j2);
        long j3 = oVar.u;
        b(j3 == 0 ? 5000L : j3);
        double d2 = oVar.v;
        a(d2 == 0.0d ? 0.5d : d2);
        this.k = new sdk.pendo.io.k7.a().b(m()).a(n()).a(k());
        c(oVar.y);
        this.b = p.CLOSED;
        this.o = uri;
        this.f = false;
        this.p = new ArrayList();
        d.b bVar = oVar.w;
        this.t = bVar == null ? new b.c() : bVar;
        d.a aVar = oVar.x;
        this.u = aVar == null ? new b.C0241b() : aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr) {
        this.u.a(bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, Object... objArr) {
        a(str, objArr);
        Iterator<sdk.pendo.io.l7.e> it = this.v.values().iterator();
        while (it.hasNext()) {
            it.next().a(str, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        w.fine("onclose");
        b();
        this.k.c();
        this.b = p.CLOSED;
        a("close", str);
        if (!this.c || this.d) {
            return;
        }
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        this.u.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(sdk.pendo.io.t7.c cVar) {
        a("packet", cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        return ("/".equals(str) ? "" : str + "#") + this.s.e();
    }

    public c c(long j2) {
        this.l = j2;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Exception exc) {
        w.log(Level.FINE, "error", (Throwable) exc);
        b("error", exc);
    }

    void b(sdk.pendo.io.t7.c cVar) {
        Logger logger = w;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format(Locale.US, "writing packet %s", cVar));
        }
        String str = cVar.f;
        if (str != null && !str.isEmpty() && cVar.f1635a == 0) {
            cVar.c += "?" + cVar.f;
        }
        if (this.f) {
            this.p.add(cVar);
        } else {
            this.f = true;
            this.t.a(cVar, new b(this));
        }
    }

    public c a(n nVar) {
        sdk.pendo.io.u7.a.a(new a(nVar));
        return this;
    }

    public c b(long j2) {
        this.i = j2;
        sdk.pendo.io.k7.a aVar = this.k;
        if (aVar != null) {
            aVar.a(j2);
        }
        return this;
    }

    public c a(double d2) {
        this.j = d2;
        sdk.pendo.io.k7.a aVar = this.k;
        if (aVar != null) {
            aVar.a(d2);
        }
        return this;
    }

    public c a(boolean z) {
        this.c = z;
        return this;
    }

    public c a(int i2) {
        this.g = i2;
        return this;
    }

    public c a(long j2) {
        this.h = j2;
        sdk.pendo.io.k7.a aVar = this.k;
        if (aVar != null) {
            aVar.b(j2);
        }
        return this;
    }

    public sdk.pendo.io.l7.e a(String str, o oVar) {
        sdk.pendo.io.l7.e eVar = this.v.get(str);
        if (eVar != null) {
            return eVar;
        }
        sdk.pendo.io.l7.e eVar2 = new sdk.pendo.io.l7.e(this, str, oVar);
        sdk.pendo.io.l7.e putIfAbsent = this.v.putIfAbsent(str, eVar2);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        eVar2.b("connecting", new k(this, eVar2));
        eVar2.b("connect", new l(eVar2, this, str));
        return eVar2;
    }
}
