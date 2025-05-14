package sdk.pendo.io.n8;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import sdk.pendo.io.d6.e;
import sdk.pendo.io.d6.h;
import sdk.pendo.io.d6.j;
import sdk.pendo.io.f7.f;
import sdk.pendo.io.g9.h0;
import sdk.pendo.io.g9.w;
import sdk.pendo.io.logging.PendoLogger;

/* loaded from: classes6.dex */
public final class c {
    private static volatile c g;
    private final sdk.pendo.io.w6.a<Boolean> b = sdk.pendo.io.w6.a.b(Boolean.FALSE);
    private final sdk.pendo.io.w6.a<sdk.pendo.io.f7.a> c = sdk.pendo.io.w6.a.n();
    private final sdk.pendo.io.w6.a<ArrayList<Activity>> d = sdk.pendo.io.w6.a.b(new ArrayList());
    private final sdk.pendo.io.w6.a<w<Activity>> e = sdk.pendo.io.w6.a.b(new w(null));
    private final AtomicBoolean f = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    private final sdk.pendo.io.d9.a f1444a = new sdk.pendo.io.d9.a(c(), b());

    class a implements h<List<Activity>, Activity> {
        a() {
        }

        @Override // sdk.pendo.io.d6.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Activity apply(List<Activity> list) {
            return list.get(list.size() - 1);
        }
    }

    class b implements j<List<Activity>> {
        b() {
        }

        @Override // sdk.pendo.io.d6.j
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(List<Activity> list) {
            return (list == null || list.isEmpty()) ? false : true;
        }
    }

    private c() {
        a().a(new e() { // from class: sdk.pendo.io.n8.c$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                c.this.a((h0) obj);
            }
        }, new e() { // from class: sdk.pendo.io.n8.c$$ExternalSyntheticLambda1
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                c.a((Throwable) obj);
            }
        });
    }

    public static synchronized c g() {
        c cVar;
        synchronized (c.class) {
            if (g == null) {
                g = new c();
            }
            cVar = g;
        }
        return cVar;
    }

    public synchronized void a(Activity activity) {
        if (!this.f.getAndSet(false)) {
            ArrayList<Activity> o = this.d.o();
            o.add(activity);
            this.d.onNext(o);
        }
    }

    public sdk.pendo.io.x5.j<sdk.pendo.io.f7.a> b() {
        return i().a(new sdk.pendo.io.b9.a(sdk.pendo.io.f7.a.PAUSE));
    }

    public sdk.pendo.io.x5.j<sdk.pendo.io.f7.a> c() {
        return i().a(new sdk.pendo.io.b9.a(sdk.pendo.io.f7.a.RESUME));
    }

    public List<Activity> d() {
        return this.d.o();
    }

    public String e() {
        Activity f = f();
        if (f == null) {
            return null;
        }
        return f.getLocalClassName();
    }

    public synchronized Activity f() {
        ArrayList<Activity> o = this.d.o();
        int size = o.size() - 1;
        if (size < 0) {
            return null;
        }
        return o.get(size);
    }

    public synchronized Activity h() {
        return this.e.o().a();
    }

    public sdk.pendo.io.x5.j<sdk.pendo.io.f7.a> i() {
        return this.c;
    }

    public synchronized void j() {
        this.f.set(true);
    }

    public void k() {
        this.f1444a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ h0 b(sdk.pendo.io.f7.a aVar) {
        return new h0();
    }

    public sdk.pendo.io.x5.j<Activity> a(sdk.pendo.io.f7.a aVar) {
        return this.d.a(new b()).c(new a()).a(f.a(this.c, aVar));
    }

    public void c(sdk.pendo.io.f7.a aVar) {
        this.c.onNext(aVar);
    }

    public sdk.pendo.io.x5.j<h0> a() {
        return i().a(new sdk.pendo.io.b9.a(sdk.pendo.io.f7.a.CREATE)).c(new h() { // from class: sdk.pendo.io.n8.c$$ExternalSyntheticLambda2
            @Override // sdk.pendo.io.d6.h
            public final Object apply(Object obj) {
                h0 b2;
                b2 = c.b((sdk.pendo.io.f7.a) obj);
                return b2;
            }
        });
    }

    public synchronized void b(Activity activity) {
        if (!this.f.getAndSet(false)) {
            ArrayList<Activity> o = this.d.o();
            o.remove(activity);
            if (o.isEmpty()) {
                this.e.onNext(new w<>(activity));
            }
            this.d.onNext(o);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(h0 h0Var) {
        this.b.onNext(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Throwable th) {
        PendoLogger.w(th, "First Activity on create observable error", new Object[0]);
    }

    public synchronized void a(String str) {
        w<Activity> o = this.e.o();
        if (!o.getIsEmpty() && o.a().getLocalClassName().equals(str)) {
            this.e.onNext(new w<>(null));
        }
    }
}
