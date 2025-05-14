package sdk.pendo.io.t1;

/* loaded from: classes6.dex */
public class d extends a {

    /* renamed from: a, reason: collision with root package name */
    private Double f1544a = Double.valueOf(Double.MAX_VALUE);

    @Override // sdk.pendo.io.t1.a
    protected Number a() {
        return this.f1544a;
    }

    @Override // sdk.pendo.io.t1.a
    protected void a(Number number) {
        if (this.f1544a.doubleValue() > number.doubleValue()) {
            this.f1544a = Double.valueOf(number.doubleValue());
        }
    }
}
