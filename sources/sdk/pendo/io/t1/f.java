package sdk.pendo.io.t1;

/* loaded from: classes6.dex */
public class f extends a {

    /* renamed from: a, reason: collision with root package name */
    private Double f1546a = Double.valueOf(0.0d);

    @Override // sdk.pendo.io.t1.a
    protected Number a() {
        return this.f1546a;
    }

    @Override // sdk.pendo.io.t1.a
    protected void a(Number number) {
        this.f1546a = Double.valueOf(this.f1546a.doubleValue() + number.doubleValue());
    }
}
