package sdk.pendo.io.t1;

/* loaded from: classes6.dex */
public class b extends a {

    /* renamed from: a, reason: collision with root package name */
    private Double f1542a;
    private Double b;

    public b() {
        Double valueOf = Double.valueOf(0.0d);
        this.f1542a = valueOf;
        this.b = valueOf;
    }

    @Override // sdk.pendo.io.t1.a
    protected Number a() {
        return this.b.doubleValue() != 0.0d ? Double.valueOf(this.f1542a.doubleValue() / this.b.doubleValue()) : Double.valueOf(0.0d);
    }

    @Override // sdk.pendo.io.t1.a
    protected void a(Number number) {
        this.b = Double.valueOf(this.b.doubleValue() + 1.0d);
        this.f1542a = Double.valueOf(this.f1542a.doubleValue() + number.doubleValue());
    }
}
