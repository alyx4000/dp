package sdk.pendo.io.o7;

import com.extole.android.sdk.impl.http.HttpRequest;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import expo.modules.updates.UpdatesConfiguration;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.fileupload.FileUploadBase;
import sdk.pendo.io.m7.a;
import sdk.pendo.io.n7.d;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.c0;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.e;
import sdk.pendo.io.w2.e0;
import sdk.pendo.io.w2.v;
import sdk.pendo.io.w2.x;
import sdk.pendo.io.w2.z;

/* loaded from: classes6.dex */
public class b extends sdk.pendo.io.o7.a {
    private static final Logger q;
    private static boolean r;

    class a implements a.InterfaceC0197a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f1467a;

        /* renamed from: sdk.pendo.io.o7.b$a$a, reason: collision with other inner class name */
        class RunnableC0216a implements Runnable {
            final /* synthetic */ Object[] f;

            RunnableC0216a(Object[] objArr) {
                this.f = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f1467a.a("responseHeaders", this.f[0]);
            }
        }

        a(b bVar) {
            this.f1467a = bVar;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            sdk.pendo.io.u7.a.a(new RunnableC0216a(objArr));
        }
    }

    /* renamed from: sdk.pendo.io.o7.b$b, reason: collision with other inner class name */
    class C0217b implements a.InterfaceC0197a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f1468a;

        C0217b(b bVar) {
            this.f1468a = bVar;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            this.f1468a.a(UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, objArr[0]);
        }
    }

    class c implements a.InterfaceC0197a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f1469a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f1469a.run();
            }
        }

        c(Runnable runnable) {
            this.f1469a = runnable;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            sdk.pendo.io.u7.a.a(new a());
        }
    }

    class d implements a.InterfaceC0197a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f1470a;

        class a implements Runnable {
            final /* synthetic */ Object[] f;

            a(Object[] objArr) {
                this.f = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Exception exc;
                Object[] objArr = this.f;
                if (objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof Exception) {
                        exc = (Exception) obj;
                        d.this.f1470a.a("xhr post error", exc);
                    }
                }
                exc = null;
                d.this.f1470a.a("xhr post error", exc);
            }
        }

        d(b bVar) {
            this.f1470a = bVar;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            sdk.pendo.io.u7.a.a(new a(objArr));
        }
    }

    class e implements a.InterfaceC0197a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f1471a;

        class a implements Runnable {
            final /* synthetic */ Object[] f;

            a(Object[] objArr) {
                this.f = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object[] objArr = this.f;
                Object obj = objArr.length > 0 ? objArr[0] : null;
                if (obj instanceof String) {
                    e.this.f1471a.b((String) obj);
                } else if (obj instanceof byte[]) {
                    e.this.f1471a.a((byte[]) obj);
                }
            }
        }

        e(b bVar) {
            this.f1471a = bVar;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            sdk.pendo.io.u7.a.a(new a(objArr));
        }
    }

    class f implements a.InterfaceC0197a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f1472a;

        class a implements Runnable {
            final /* synthetic */ Object[] f;

            a(Object[] objArr) {
                this.f = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Exception exc;
                Object[] objArr = this.f;
                if (objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof Exception) {
                        exc = (Exception) obj;
                        f.this.f1472a.a("xhr poll error", exc);
                    }
                }
                exc = null;
                f.this.f1472a.a("xhr poll error", exc);
            }
        }

        f(b bVar) {
            this.f1472a = bVar;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            sdk.pendo.io.u7.a.a(new a(objArr));
        }
    }

    public static class g extends sdk.pendo.io.m7.a {
        private static final x h = x.c("application/octet-stream");
        private static final x i = x.c("text/plain;charset=UTF-8");
        private String b;
        private String c;
        private Object d;
        private e.a e;
        private d0 f;
        private sdk.pendo.io.w2.e g;

        class a implements sdk.pendo.io.w2.f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ g f1473a;

            a(g gVar) {
                this.f1473a = gVar;
            }

            @Override // sdk.pendo.io.w2.f
            public void a(sdk.pendo.io.w2.e eVar, IOException iOException) {
                this.f1473a.a(iOException);
            }

            @Override // sdk.pendo.io.w2.f
            public void a(sdk.pendo.io.w2.e eVar, d0 d0Var) {
                g gVar = this.f1473a;
                gVar.f = d0Var;
                gVar.b(d0Var.getHeaders().b());
                try {
                    if (d0Var.s()) {
                        this.f1473a.c();
                    } else {
                        this.f1473a.a(new IOException(Integer.toString(d0Var.getCom.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String())));
                    }
                } finally {
                    d0Var.close();
                }
            }
        }

        /* renamed from: sdk.pendo.io.o7.b$g$b, reason: collision with other inner class name */
        public static class C0218b {

            /* renamed from: a, reason: collision with root package name */
            public String f1474a;
            public String b;
            public Object c;
            public e.a d;
        }

        public g(C0218b c0218b) {
            String str = c0218b.b;
            this.b = str == null ? "GET" : str;
            this.c = c0218b.f1474a;
            this.d = c0218b.c;
            e.a aVar = c0218b.d;
            this.e = aVar == null ? new z() : aVar;
        }

        private void a(byte[] bArr) {
            a("data", bArr);
            d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            e0 b = this.f.b();
            try {
                if ("application/octet-stream".equalsIgnoreCase(b.getS().getMediaType())) {
                    a(b.b());
                } else {
                    b(b.p());
                }
            } catch (IOException e) {
                a(e);
            }
        }

        private void d() {
            a("success", new Object[0]);
        }

        public void b() {
            if (b.r) {
                b.q.fine(String.format("xhr open %s: %s", this.b, this.c));
            }
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            if ("POST".equals(this.b)) {
                treeMap.put(FileUploadBase.CONTENT_TYPE, this.d instanceof byte[] ? new LinkedList(Collections.singletonList("application/octet-stream")) : new LinkedList(Collections.singletonList("text/plain;charset=UTF-8")));
            }
            treeMap.put(HttpRequest.HEADER_ACCEPT, new LinkedList(Collections.singletonList(ApiConstant.ALL_MEDIA_TYPE)));
            a(treeMap);
            if (b.r) {
                Logger logger = b.q;
                Object[] objArr = new Object[2];
                objArr[0] = this.c;
                Object obj = this.d;
                if (obj instanceof byte[]) {
                    obj = Arrays.toString((byte[]) obj);
                }
                objArr[1] = obj;
                logger.fine(String.format("sending xhr with url %s | data %s", objArr));
            }
            b0.a aVar = new b0.a();
            for (Map.Entry<String, List<String>> entry : treeMap.entrySet()) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    aVar.a(entry.getKey(), it.next());
                }
            }
            Object obj2 = this.d;
            sdk.pendo.io.w2.e a2 = this.e.a(aVar.a(v.c(this.c)).a(this.b, obj2 instanceof byte[] ? c0.a(h, (byte[]) obj2) : obj2 instanceof String ? c0.a(i, (String) obj2) : null).a());
            this.g = a2;
            a2.a(new a(this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Exception exc) {
            a("error", exc);
        }

        private void b(String str) {
            a("data", str);
            d();
        }

        private void a(Map<String, List<String>> map) {
            a(UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, map);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(Map<String, List<String>> map) {
            a("responseHeaders", map);
        }
    }

    static {
        Logger logger = Logger.getLogger(b.class.getName());
        q = logger;
        r = logger.isLoggable(Level.FINE);
    }

    public b(d.C0211d c0211d) {
        super(c0211d);
    }

    @Override // sdk.pendo.io.o7.a
    protected void h() {
        q.fine("xhr poll");
        g k = k();
        k.b("data", new e(this));
        k.b("error", new f(this));
        k.b();
    }

    protected g k() {
        return a((g.C0218b) null);
    }

    private void a(Object obj, Runnable runnable) {
        g.C0218b c0218b = new g.C0218b();
        c0218b.b = "POST";
        c0218b.c = obj;
        g a2 = a(c0218b);
        a2.b("success", new c(runnable));
        a2.b("error", new d(this));
        a2.b();
    }

    @Override // sdk.pendo.io.o7.a
    protected void a(String str, Runnable runnable) {
        a((Object) str, runnable);
    }

    @Override // sdk.pendo.io.o7.a
    protected void a(byte[] bArr, Runnable runnable) {
        a((Object) bArr, runnable);
    }

    protected g a(g.C0218b c0218b) {
        if (c0218b == null) {
            c0218b = new g.C0218b();
        }
        c0218b.f1474a = j();
        c0218b.d = this.n;
        g gVar = new g(c0218b);
        gVar.b(UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, new C0217b(this)).b("responseHeaders", new a(this));
        return gVar;
    }
}
