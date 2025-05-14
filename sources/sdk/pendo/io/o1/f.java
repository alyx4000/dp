package sdk.pendo.io.o1;

import sdk.pendo.io.n1.j;

/* loaded from: classes6.dex */
public class f implements j {

    /* renamed from: a, reason: collision with root package name */
    private final sdk.pendo.io.n1.a f1452a;

    public f(sdk.pendo.io.n1.a aVar) {
        this.f1452a = aVar;
    }

    @Override // sdk.pendo.io.n1.j
    public sdk.pendo.io.n1.b a(String str) {
        i.a(str, "json string can not be null or empty", new Object[0]);
        return new e(this.f1452a.f().a(str), this.f1452a);
    }
}
