package sdk.pendo.io.n8;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import sdk.pendo.io.activities.PendoGuideVisualActivity;
import sdk.pendo.io.d6.h;
import sdk.pendo.io.d6.j;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.x5.m;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f1442a;
    private static volatile sdk.pendo.io.w6.a<e> b = sdk.pendo.io.w6.a.n();

    class a implements j<Long> {
        final /* synthetic */ AtomicBoolean f;

        a(AtomicBoolean atomicBoolean) {
            this.f = atomicBoolean;
        }

        @Override // sdk.pendo.io.d6.j
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(Long l) {
            return !this.f.get();
        }
    }

    /* renamed from: sdk.pendo.io.n8.b$b, reason: collision with other inner class name */
    class C0212b implements sdk.pendo.io.d6.e<Long> {
        final /* synthetic */ sdk.pendo.io.w6.a A;
        final /* synthetic */ Activity f;
        final /* synthetic */ sdk.pendo.io.f7.a f0;
        final /* synthetic */ String s;
        final /* synthetic */ AtomicBoolean t0;

        C0212b(Activity activity, String str, sdk.pendo.io.w6.a aVar, sdk.pendo.io.f7.a aVar2, AtomicBoolean atomicBoolean) {
            this.f = activity;
            this.s = str;
            this.A = aVar;
            this.f0 = aVar2;
            this.t0 = atomicBoolean;
        }

        @Override // sdk.pendo.io.d6.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Long l) {
            for (Fragment fragment : ((FragmentActivity) this.f).getSupportFragmentManager().getFragments()) {
                if (fragment != null && fragment.isVisible() && fragment.isMenuVisible() && !fragment.getClass().getSimpleName().equals(this.s)) {
                    PendoLogger.d("New Fragment =  " + fragment.getClass().getSimpleName(), new Object[0]);
                    this.A.onNext(this.f0);
                    this.t0.set(true);
                    return;
                }
            }
        }
    }

    class c implements h<e, sdk.pendo.io.f7.a> {
        c() {
        }

        @Override // sdk.pendo.io.d6.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public sdk.pendo.io.f7.a apply(e eVar) {
            return eVar.b;
        }
    }

    class d implements j<e> {
        final /* synthetic */ e f;

        d(e eVar) {
            this.f = eVar;
        }

        @Override // sdk.pendo.io.d6.j
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(e eVar) {
            return eVar.a(this.f);
        }
    }

    private static final class e {

        /* renamed from: a, reason: collision with root package name */
        final int f1443a;
        final sdk.pendo.io.f7.a b;

        private e(int i, sdk.pendo.io.f7.a aVar) {
            this.f1443a = i;
            this.b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static e a(Activity activity, sdk.pendo.io.f7.a aVar) {
            return new e(a(activity), aVar);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.f1443a == eVar.f1443a && this.b.equals(eVar.b);
        }

        public int hashCode() {
            return (this.f1443a * 37) + (this.b.hashCode() * 23);
        }

        private static int a(Activity activity) {
            if (activity instanceof PendoGuideVisualActivity) {
                return 0;
            }
            return activity.getLocalClassName().hashCode();
        }

        public boolean a(Object obj) {
            e eVar;
            int i;
            return (equals(obj) || !(obj instanceof e) || (i = (eVar = (e) obj).f1443a) == 0 || this.f1443a == i || !this.b.equals(eVar.b)) ? false : true;
        }
    }

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f1442a == null) {
                f1442a = new b();
            }
            bVar = f1442a;
        }
        return bVar;
    }

    void a(Activity activity, sdk.pendo.io.f7.a aVar) {
        if (activity instanceof PendoGuideVisualActivity) {
            return;
        }
        b.onNext(e.a(activity, aVar));
    }

    public sdk.pendo.io.b6.b a(Activity activity, sdk.pendo.io.f7.a aVar, String str, sdk.pendo.io.d6.e<sdk.pendo.io.f7.a> eVar) {
        sdk.pendo.io.w6.a n = sdk.pendo.io.w6.a.n();
        if ((activity instanceof FragmentActivity) && str != null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            PendoLogger.d("Current Fragment =  " + str, new Object[0]);
            sdk.pendo.io.x5.j.c(250L, TimeUnit.MILLISECONDS, sdk.pendo.io.v6.a.a()).b(new a(atomicBoolean)).a(sdk.pendo.io.d9.c.a(new C0212b(activity, str, n, aVar, atomicBoolean), "ActivityLifeCycleEventsObserver interval observable for fragment change observer"));
        }
        return b.a(new d(e.a(activity, aVar))).c(new c()).c((m<? extends R>) n).a(sdk.pendo.io.a6.a.a()).a(eVar, new sdk.pendo.io.a9.a("ActivityLifeCycleEventsObserver observer error consumer"));
    }
}
