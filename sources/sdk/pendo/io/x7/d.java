package sdk.pendo.io.x7;

import sdk.pendo.io.x7.i;

/* loaded from: classes4.dex */
public class d<C extends i> {

    /* renamed from: a, reason: collision with root package name */
    private b<C> f1753a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private c f1754a;

        private a(c cVar) {
            this.f1754a = cVar;
        }

        public j a(h hVar) {
            return new j(this.f1754a, hVar, false);
        }
    }

    private d(h hVar) {
        this.f1753a = new b<>(hVar);
    }

    public static <C extends i> d<C> a(h hVar) {
        return new d<>(hVar);
    }

    public static a a(c cVar) {
        return new a(cVar);
    }

    public <C1 extends i> b<C1> a(boolean z, j... jVarArr) {
        for (j jVar : jVarArr) {
            jVar.a(this.f1753a.a());
        }
        this.f1753a.a(z);
        return this.f1753a;
    }

    public <C1 extends i> b<C1> a(j... jVarArr) {
        return a(false, jVarArr);
    }
}
