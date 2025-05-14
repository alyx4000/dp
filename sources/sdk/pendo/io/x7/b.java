package sdk.pendo.io.x7;

import java.util.concurrent.Executor;
import sdk.pendo.io.x7.g;
import sdk.pendo.io.x7.i;

/* loaded from: classes4.dex */
public class b<C extends i> {

    /* renamed from: a, reason: collision with root package name */
    private final h f1751a;
    private k b;
    private Executor c;
    private final g d;
    private boolean e;
    private e f;

    public class a implements sdk.pendo.io.y7.c<i> {
        public a() {
        }

        @Override // sdk.pendo.io.y7.c
        public void a(sdk.pendo.io.z7.b bVar, i iVar) {
            String str = "Execution Error in StateHolder [" + bVar.c() + "] ";
            if (bVar.b() != null) {
                str = str + "on EventHolder [" + bVar.b() + "] ";
            }
            b.this.f.a("Error", new Exception(str + "with Context [" + bVar.a() + "] ", bVar));
        }
    }

    protected b(h hVar) {
        g gVar = new g();
        this.d = gVar;
        this.e = false;
        this.f = new f();
        this.f1751a = hVar;
        gVar.a(g.a.ERROR, (h) null, (c) null, new a());
    }

    private void b(h hVar, C c) {
        if (c.c()) {
            return;
        }
        try {
            if (b()) {
                this.f.a("when enter %s for %s <<<", hVar, c);
            }
            this.d.b(hVar, c);
            if (b()) {
                this.f.a("when enter %s for %s >>>", hVar, c);
            }
            if (this.b.a(hVar)) {
                a(hVar, (h) c);
            }
        } catch (Exception e) {
            a(new sdk.pendo.io.z7.b(hVar, null, e, "Execution Error in [whenEnter] handler", c));
        }
    }

    private void c(h hVar, C c) {
        if (c.c()) {
            return;
        }
        try {
            if (b()) {
                this.f.a("when leave %s for %s <<<", hVar, c);
            }
            this.d.c(hVar, c);
            if (b()) {
                this.f.a("when leave %s for %s >>>", hVar, c);
            }
        } catch (Exception e) {
            a(new sdk.pendo.io.z7.b(hVar, null, e, "Execution Error in [whenLeave] handler", c));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void a(sdk.pendo.io.z7.b bVar) {
        this.d.a(bVar);
        a(bVar.c(), (h) bVar.a());
    }

    private void c() {
        if (this.c == null) {
            this.c = new sdk.pendo.io.x7.a();
        }
    }

    protected void a(h hVar, C c) {
        if (c.c()) {
            return;
        }
        try {
            if (b()) {
                this.f.a("terminating context %s", c);
            }
            c.g();
            this.d.a(hVar, c);
        } catch (Exception e) {
            this.f.a("Execution Error in [whenTerminate] handler", e);
        }
    }

    protected boolean b() {
        return this.e;
    }

    protected void a(Runnable runnable, C c) {
        if (c.c()) {
            return;
        }
        this.c.execute(runnable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C1 extends i> b<C1> b(h hVar, sdk.pendo.io.y7.a<C1> aVar) {
        this.d.a(g.a.STATE_LEAVE, hVar, (c) null, aVar);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C1 extends i> b<C1> a(Executor executor) {
        this.c = executor;
        return this;
    }

    protected h a() {
        return this.f1751a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void a(boolean z, i iVar, h hVar) {
        h b;
        if (!z && (b = iVar.b()) != null) {
            c(b, iVar);
        }
        iVar.a(hVar);
        b(hVar, (h) iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void a(j jVar, c cVar, h hVar, i iVar) {
        try {
            h d = jVar.d();
            if (b()) {
                this.f.a("when triggered %s in %s for %s <<<", cVar, hVar, iVar);
            }
            this.d.a(cVar, hVar, d, (h) iVar);
            iVar.a(cVar);
            if (b()) {
                this.f.a("when triggered %s in %s for %s >>>", cVar, hVar, iVar);
            }
            a(d, false, (boolean) iVar);
        } catch (Exception e) {
            a(new sdk.pendo.io.z7.b(hVar, cVar, e, "Execution Error in [trigger]", iVar));
        }
    }

    protected void a(boolean z) {
        this.b = new k(j.a(), !z);
    }

    public boolean a(c cVar, C c) {
        try {
            return a(cVar, true, (boolean) c);
        } catch (sdk.pendo.io.z7.c unused) {
            return false;
        }
    }

    protected void a(final h hVar, final boolean z, final C c) {
        a(new Runnable() { // from class: sdk.pendo.io.x7.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                b.this.a(z, c, hVar);
            }
        }, (Runnable) c);
    }

    public void a(boolean z, C c) {
        h b;
        boolean z2;
        c();
        c.a(this);
        if (c.b() == null) {
            b = this.f1751a;
            z2 = false;
        } else {
            if (!z) {
                return;
            }
            b = c.b();
            z2 = true;
        }
        a(b, z2, (boolean) c);
    }

    private boolean a(final c cVar, boolean z, final C c) {
        if (c.c()) {
            return false;
        }
        final h b = c.b();
        final j a2 = this.b.a(b, cVar);
        if (a2 != null) {
            a(new Runnable() { // from class: sdk.pendo.io.x7.b$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a(a2, cVar, b, c);
                }
            }, (Runnable) c);
        } else if (!z) {
            throw new sdk.pendo.io.z7.c("Invalid Event: " + cVar + " triggered while in State: " + c.b() + " for " + c);
        }
        return a2 != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C1 extends i> b<C1> a(h hVar, sdk.pendo.io.y7.a<C1> aVar) {
        this.d.a(g.a.STATE_ENTER, hVar, (c) null, aVar);
        return this;
    }
}
