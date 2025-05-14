package sdk.pendo.io.y4;

/* loaded from: classes4.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f1809a;
    private final int b;

    x0(int i, int i2) {
        this.f1809a = i;
        this.b = i2;
    }

    static x0 a(x0 x0Var, x0 x0Var2) {
        return new x0(x0Var.b() + x0Var2.b(), x0Var.a() + x0Var2.a());
    }

    public int b() {
        return this.f1809a;
    }

    static x0 a(x0 x0Var, int i) {
        return new x0(x0Var.b() + i, x0Var.a());
    }

    public int a() {
        return this.b;
    }
}
