package sdk.pendo.io.m3;

import java.io.IOException;

/* loaded from: classes6.dex */
public class c1 implements g, r2 {
    private f0 f;

    c1(f0 f0Var) {
        this.f = f0Var;
    }

    static b1 a(f0 f0Var) {
        return new b1(f0Var.b());
    }

    @Override // sdk.pendo.io.m3.g
    public a0 b() {
        try {
            return e();
        } catch (IOException e) {
            throw new z(e.getMessage(), e);
        }
    }

    @Override // sdk.pendo.io.m3.r2
    public a0 e() {
        return a(this.f);
    }
}
