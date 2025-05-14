package sdk.pendo.io.o7;

import expo.modules.updates.UpdatesConfiguration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;
import sdk.pendo.io.k3.g;
import sdk.pendo.io.n7.d;
import sdk.pendo.io.p7.c;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.h0;
import sdk.pendo.io.w2.i0;
import sdk.pendo.io.w2.z;

/* loaded from: classes6.dex */
public class c extends d {
    private static final Logger p = Logger.getLogger(sdk.pendo.io.o7.b.class.getName());
    private h0 o;

    class a extends i0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f1475a;

        /* renamed from: sdk.pendo.io.o7.c$a$a, reason: collision with other inner class name */
        class RunnableC0219a implements Runnable {
            final /* synthetic */ Map f;

            RunnableC0219a(Map map) {
                this.f = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f1475a.a("responseHeaders", this.f);
                a.this.f1475a.f();
            }
        }

        class b implements Runnable {
            final /* synthetic */ String f;

            b(String str) {
                this.f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f1475a.b(this.f);
            }
        }

        /* renamed from: sdk.pendo.io.o7.c$a$c, reason: collision with other inner class name */
        class RunnableC0220c implements Runnable {
            final /* synthetic */ g f;

            RunnableC0220c(g gVar) {
                this.f = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f1475a.a(this.f.n());
            }
        }

        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f1475a.e();
            }
        }

        class e implements Runnable {
            final /* synthetic */ Throwable f;

            e(Throwable th) {
                this.f = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f1475a.a("websocket error", (Exception) this.f);
            }
        }

        a(c cVar) {
            this.f1475a = cVar;
        }

        @Override // sdk.pendo.io.w2.i0
        public void a(h0 h0Var, int i, String str) {
            sdk.pendo.io.u7.a.a(new d());
        }

        @Override // sdk.pendo.io.w2.i0
        public void a(h0 h0Var, Throwable th, d0 d0Var) {
            if (th instanceof Exception) {
                sdk.pendo.io.u7.a.a(new e(th));
            }
        }

        @Override // sdk.pendo.io.w2.i0
        public void a(h0 h0Var, String str) {
            if (str == null) {
                return;
            }
            sdk.pendo.io.u7.a.a(new b(str));
        }

        @Override // sdk.pendo.io.w2.i0
        public void a(h0 h0Var, g gVar) {
            if (gVar == null) {
                return;
            }
            sdk.pendo.io.u7.a.a(new RunnableC0220c(gVar));
        }

        @Override // sdk.pendo.io.w2.i0
        public void a(h0 h0Var, d0 d0Var) {
            sdk.pendo.io.u7.a.a(new RunnableC0219a(d0Var.getHeaders().b()));
        }
    }

    class b implements Runnable {
        final /* synthetic */ c f;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = b.this.f;
                cVar.b = true;
                cVar.a("drain", new Object[0]);
            }
        }

        b(c cVar) {
            this.f = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            sdk.pendo.io.u7.a.b(new a());
        }
    }

    /* renamed from: sdk.pendo.io.o7.c$c, reason: collision with other inner class name */
    class C0221c implements c.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f1476a;
        final /* synthetic */ int[] b;
        final /* synthetic */ Runnable c;

        C0221c(c cVar, int[] iArr, Runnable runnable) {
            this.f1476a = cVar;
            this.b = iArr;
            this.c = runnable;
        }

        @Override // sdk.pendo.io.p7.c.f
        public void a(Object obj) {
            try {
                if (obj instanceof String) {
                    this.f1476a.o.a((String) obj);
                } else if (obj instanceof byte[]) {
                    this.f1476a.o.c(g.a((byte[]) obj));
                }
            } catch (IllegalStateException unused) {
                c.p.fine("websocket closed before we could write");
            }
            int[] iArr = this.b;
            int i = iArr[0] - 1;
            iArr[0] = i;
            if (i == 0) {
                this.c.run();
            }
        }
    }

    public c(d.C0211d c0211d) {
        super(c0211d);
        this.c = "websocket";
    }

    @Override // sdk.pendo.io.n7.d
    protected void c() {
        h0 h0Var = this.o;
        if (h0Var != null) {
            h0Var.a(1000, "");
            this.o = null;
        }
    }

    @Override // sdk.pendo.io.n7.d
    protected void d() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        a(UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, treeMap);
        h0.a aVar = this.m;
        if (aVar == null) {
            aVar = new z();
        }
        b0.a b2 = new b0.a().b(h());
        for (Map.Entry entry : treeMap.entrySet()) {
            Iterator it = ((List) entry.getValue()).iterator();
            while (it.hasNext()) {
                b2.a((String) entry.getKey(), (String) it.next());
            }
        }
        this.o = aVar.a(b2.a(), new a(this));
    }

    protected String h() {
        Map map = this.d;
        if (map == null) {
            map = new HashMap();
        }
        String str = this.e ? "wss" : "ws";
        String str2 = (this.g <= 0 || ((!"wss".equals(str) || this.g == 443) && (!"ws".equals(str) || this.g == 80))) ? "" : ":" + this.g;
        if (this.f) {
            map.put(this.j, sdk.pendo.io.w7.a.a());
        }
        String a2 = sdk.pendo.io.s7.a.a((Map<String, String>) map);
        if (a2.length() > 0) {
            a2 = "?" + a2;
        }
        return str + "://" + (this.i.contains(":") ? "[" + this.i + "]" : this.i) + str2 + this.h + a2;
    }

    @Override // sdk.pendo.io.n7.d
    protected void b(sdk.pendo.io.p7.b[] bVarArr) {
        this.b = false;
        b bVar = new b(this);
        int[] iArr = {bVarArr.length};
        for (sdk.pendo.io.p7.b bVar2 : bVarArr) {
            d.e eVar = this.l;
            if (eVar != d.e.OPENING && eVar != d.e.OPEN) {
                return;
            }
            sdk.pendo.io.p7.c.c(bVar2, new C0221c(this, iArr, bVar));
        }
    }
}
