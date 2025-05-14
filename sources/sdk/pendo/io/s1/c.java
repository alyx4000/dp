package sdk.pendo.io.s1;

import sdk.pendo.io.o1.g;

/* loaded from: classes6.dex */
public class c implements a {

    /* renamed from: a, reason: collision with root package name */
    private final g f1535a;
    private final Object b;
    private final sdk.pendo.io.n1.a c;

    public c(g gVar, Object obj, sdk.pendo.io.n1.a aVar) {
        this.f1535a = gVar;
        this.b = obj;
        this.c = aVar;
    }

    @Override // sdk.pendo.io.s1.a
    public Object get() {
        g gVar = this.f1535a;
        Object obj = this.b;
        return gVar.a(obj, obj, this.c).getValue();
    }
}
