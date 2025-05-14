package sdk.pendo.io.t1;

/* loaded from: classes6.dex */
public class e extends a {

    /* renamed from: a, reason: collision with root package name */
    private Double f1545a;
    private Double b;
    private Double c;

    public e() {
        Double valueOf = Double.valueOf(0.0d);
        this.f1545a = valueOf;
        this.b = valueOf;
        this.c = valueOf;
    }

    @Override // sdk.pendo.io.t1.a
    protected Number a() {
        return Double.valueOf(Math.sqrt((this.f1545a.doubleValue() / this.c.doubleValue()) - (((this.b.doubleValue() * this.b.doubleValue()) / this.c.doubleValue()) / this.c.doubleValue())));
    }

    @Override // sdk.pendo.io.t1.a
    protected void a(Number number) {
        this.b = Double.valueOf(this.b.doubleValue() + number.doubleValue());
        this.f1545a = Double.valueOf(this.f1545a.doubleValue() + (number.doubleValue() * number.doubleValue()));
        this.c = Double.valueOf(this.c.doubleValue() + 1.0d);
    }
}
