package sdk.pendo.io.j0;

/* loaded from: classes6.dex */
public abstract class c {

    private static class b extends c {

        /* renamed from: a, reason: collision with root package name */
        private volatile boolean f1218a;

        b() {
            super();
        }

        @Override // sdk.pendo.io.j0.c
        public void a(boolean z) {
            this.f1218a = z;
        }

        @Override // sdk.pendo.io.j0.c
        public void b() {
            if (this.f1218a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    private c() {
    }

    public static c a() {
        return new b();
    }

    abstract void a(boolean z);

    public abstract void b();
}
