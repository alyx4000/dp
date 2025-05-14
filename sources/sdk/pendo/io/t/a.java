package sdk.pendo.io.t;

/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1540a = new C0234a();
    public static final a b = new b();
    public static final a c = new c();
    public static final a d = new d();
    public static final a e = new e();

    /* renamed from: sdk.pendo.io.t.a$a, reason: collision with other inner class name */
    class C0234a extends a {
        C0234a() {
        }

        @Override // sdk.pendo.io.t.a
        public boolean a() {
            return true;
        }

        @Override // sdk.pendo.io.t.a
        public boolean b() {
            return true;
        }

        @Override // sdk.pendo.io.t.a
        public boolean a(sdk.pendo.io.q.a aVar) {
            return aVar == sdk.pendo.io.q.a.REMOTE;
        }

        @Override // sdk.pendo.io.t.a
        public boolean a(boolean z, sdk.pendo.io.q.a aVar, sdk.pendo.io.q.c cVar) {
            return (aVar == sdk.pendo.io.q.a.RESOURCE_DISK_CACHE || aVar == sdk.pendo.io.q.a.MEMORY_CACHE) ? false : true;
        }
    }

    class b extends a {
        b() {
        }

        @Override // sdk.pendo.io.t.a
        public boolean a() {
            return false;
        }

        @Override // sdk.pendo.io.t.a
        public boolean a(sdk.pendo.io.q.a aVar) {
            return false;
        }

        @Override // sdk.pendo.io.t.a
        public boolean a(boolean z, sdk.pendo.io.q.a aVar, sdk.pendo.io.q.c cVar) {
            return false;
        }

        @Override // sdk.pendo.io.t.a
        public boolean b() {
            return false;
        }
    }

    class c extends a {
        c() {
        }

        @Override // sdk.pendo.io.t.a
        public boolean a() {
            return true;
        }

        @Override // sdk.pendo.io.t.a
        public boolean a(boolean z, sdk.pendo.io.q.a aVar, sdk.pendo.io.q.c cVar) {
            return false;
        }

        @Override // sdk.pendo.io.t.a
        public boolean b() {
            return false;
        }

        @Override // sdk.pendo.io.t.a
        public boolean a(sdk.pendo.io.q.a aVar) {
            return (aVar == sdk.pendo.io.q.a.DATA_DISK_CACHE || aVar == sdk.pendo.io.q.a.MEMORY_CACHE) ? false : true;
        }
    }

    class e extends a {
        e() {
        }

        @Override // sdk.pendo.io.t.a
        public boolean a() {
            return true;
        }

        @Override // sdk.pendo.io.t.a
        public boolean b() {
            return true;
        }

        @Override // sdk.pendo.io.t.a
        public boolean a(sdk.pendo.io.q.a aVar) {
            return aVar == sdk.pendo.io.q.a.REMOTE;
        }

        @Override // sdk.pendo.io.t.a
        public boolean a(boolean z, sdk.pendo.io.q.a aVar, sdk.pendo.io.q.c cVar) {
            return ((z && aVar == sdk.pendo.io.q.a.DATA_DISK_CACHE) || aVar == sdk.pendo.io.q.a.LOCAL) && cVar == sdk.pendo.io.q.c.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean a(sdk.pendo.io.q.a aVar);

    public abstract boolean a(boolean z, sdk.pendo.io.q.a aVar, sdk.pendo.io.q.c cVar);

    public abstract boolean b();

    class d extends a {
        d() {
        }

        @Override // sdk.pendo.io.t.a
        public boolean a() {
            return false;
        }

        @Override // sdk.pendo.io.t.a
        public boolean a(sdk.pendo.io.q.a aVar) {
            return false;
        }

        @Override // sdk.pendo.io.t.a
        public boolean b() {
            return true;
        }

        @Override // sdk.pendo.io.t.a
        public boolean a(boolean z, sdk.pendo.io.q.a aVar, sdk.pendo.io.q.c cVar) {
            return (aVar == sdk.pendo.io.q.a.RESOURCE_DISK_CACHE || aVar == sdk.pendo.io.q.a.MEMORY_CACHE) ? false : true;
        }
    }
}
