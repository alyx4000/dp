package sdk.pendo.io.e9;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.d6.e;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.x5.j;

/* loaded from: classes6.dex */
public final class b {
    private static final b c = new b();

    /* renamed from: a, reason: collision with root package name */
    private String f1036a;
    private final sdk.pendo.io.w6.a<c> b;

    class a implements ComponentCallbacks2 {
        a() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i) {
            PendoLogger.d("Test = level = " + i, new Object[0]);
            if (i >= 20) {
                b.this.b.onNext(c.IN_BACKGROUND);
            }
        }
    }

    /* renamed from: sdk.pendo.io.e9.b$b, reason: collision with other inner class name */
    class C0124b implements e<c> {
        C0124b() {
        }

        @Override // sdk.pendo.io.d6.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(c cVar) {
            PendoLogger.d("AppFlow: " + cVar.name(), new Object[0]);
        }
    }

    public enum c {
        IN_BACKGROUND,
        IN_FOREGROUND
    }

    private b() {
        sdk.pendo.io.w6.a<c> b = sdk.pendo.io.w6.a.b(c.IN_FOREGROUND);
        this.b = b;
        Context m = PendoInternal.m();
        if (m != null) {
            m.registerComponentCallbacks(new a());
        }
        b.a(sdk.pendo.io.d9.c.a(new C0124b(), "ApplicationFlowManager app flow state observer"));
    }

    public static synchronized b e() {
        b bVar;
        synchronized (b.class) {
            bVar = c;
        }
        return bVar;
    }

    public void a() {
        this.b.onNext(c.IN_BACKGROUND);
    }

    public void b() {
        this.b.onNext(c.IN_FOREGROUND);
    }

    public j<c> c() {
        return a(false);
    }

    public c d() {
        return this.b.o();
    }

    public boolean f() {
        return c.IN_BACKGROUND.equals(d());
    }

    public j<c> a(boolean z) {
        sdk.pendo.io.w6.a<c> aVar = this.b;
        return z ? aVar.d() : aVar;
    }

    public void a(String str) {
        this.f1036a = str;
    }
}
