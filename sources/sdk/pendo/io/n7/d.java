package sdk.pendo.io.n7;

import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import sdk.pendo.io.w2.e;
import sdk.pendo.io.w2.h0;

/* loaded from: classes6.dex */
public abstract class d extends sdk.pendo.io.m7.a {
    public boolean b;
    public String c;
    public Map<String, String> d;
    protected boolean e;
    protected boolean f;
    protected int g;
    protected String h;
    protected String i;
    protected String j;
    protected sdk.pendo.io.n7.c k;
    protected e l;
    protected h0.a m;
    protected e.a n;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            e eVar = dVar.l;
            if (eVar == e.CLOSED || eVar == null) {
                dVar.l = e.OPENING;
                dVar.d();
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            e eVar = dVar.l;
            if (eVar == e.OPENING || eVar == e.OPEN) {
                dVar.c();
                d.this.e();
            }
        }
    }

    class c implements Runnable {
        final /* synthetic */ sdk.pendo.io.p7.b[] f;

        c(sdk.pendo.io.p7.b[] bVarArr) {
            this.f = bVarArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            if (dVar.l != e.OPEN) {
                throw new RuntimeException("Transport not open");
            }
            try {
                dVar.b(this.f);
            } catch (sdk.pendo.io.v7.b e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: sdk.pendo.io.n7.d$d, reason: collision with other inner class name */
    public static class C0211d {

        /* renamed from: a, reason: collision with root package name */
        public String f1440a;
        public String b;
        public String c;
        public boolean d;
        public boolean e;
        public int f = -1;
        public int g = -1;
        public Map<String, String> h;
        protected sdk.pendo.io.n7.c i;
        public h0.a j;
        public e.a k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public enum e {
        OPENING,
        OPEN,
        CLOSED,
        PAUSED;

        @Override // java.lang.Enum
        public String toString() {
            return super.toString().toLowerCase(Locale.US);
        }
    }

    public d(C0211d c0211d) {
        this.h = c0211d.b;
        this.i = c0211d.f1440a;
        this.g = c0211d.f;
        this.e = c0211d.d;
        this.d = c0211d.h;
        this.j = c0211d.c;
        this.f = c0211d.e;
        this.k = c0211d.i;
        this.m = c0211d.j;
        this.n = c0211d.k;
    }

    protected void a(byte[] bArr) {
        a(sdk.pendo.io.p7.c.b(bArr));
    }

    public d b() {
        sdk.pendo.io.u7.a.a(new b());
        return this;
    }

    protected abstract void b(sdk.pendo.io.p7.b[] bVarArr);

    protected abstract void c();

    protected abstract void d();

    protected void e() {
        this.l = e.CLOSED;
        a("close", new Object[0]);
    }

    protected void f() {
        this.l = e.OPEN;
        this.b = true;
        a(AbstractCircuitBreaker.PROPERTY_NAME, new Object[0]);
    }

    public d g() {
        sdk.pendo.io.u7.a.a(new a());
        return this;
    }

    protected d a(String str, Exception exc) {
        a("error", new sdk.pendo.io.n7.a(str, exc));
        return this;
    }

    protected void b(String str) {
        a(sdk.pendo.io.p7.c.a(str));
    }

    protected void a(sdk.pendo.io.p7.b bVar) {
        a("packet", bVar);
    }

    public void a(sdk.pendo.io.p7.b[] bVarArr) {
        sdk.pendo.io.u7.a.a(new c(bVarArr));
    }
}
