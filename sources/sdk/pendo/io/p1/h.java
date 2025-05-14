package sdk.pendo.io.p1;

import sdk.pendo.io.n1.l;

/* loaded from: classes6.dex */
public class h extends c {
    private static final sdk.pendo.io.h7.a d = sdk.pendo.io.h7.b.a((Class<?>) h.class);

    /* renamed from: a, reason: collision with root package name */
    private final j f1488a;
    private final i b;
    private final j c;

    public h(j jVar, i iVar, j jVar2) {
        this.f1488a = jVar;
        this.b = iVar;
        this.c = jVar2;
        d.a("ExpressionNode {}", toString());
    }

    @Override // sdk.pendo.io.n1.l
    public boolean a(l.a aVar) {
        j jVar = this.f1488a;
        j jVar2 = this.c;
        if (jVar.n()) {
            jVar = this.f1488a.e().b(aVar);
        }
        if (this.c.n()) {
            jVar2 = this.c.e().b(aVar);
        }
        a a2 = b.a(this.b);
        if (a2 != null) {
            return a2.a(jVar, jVar2, aVar);
        }
        return false;
    }

    public String toString() {
        return this.b == i.EXISTS ? this.f1488a.toString() : this.f1488a.toString() + " " + this.b.toString() + " " + this.c.toString();
    }
}
