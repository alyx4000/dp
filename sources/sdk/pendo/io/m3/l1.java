package sdk.pendo.io.m3;

import java.io.IOException;

/* loaded from: classes6.dex */
public class l1 implements g, r2 {
    private f0 f;

    public l1(f0 f0Var) {
        this.f = f0Var;
    }

    static h2 a(f0 f0Var) {
        try {
            return new h2(f0Var.b());
        } catch (IllegalArgumentException e) {
            throw new j(e.getMessage(), e);
        }
    }

    @Override // sdk.pendo.io.m3.g
    public a0 b() {
        try {
            return e();
        } catch (IOException e) {
            throw new z("unable to get DER object", e);
        } catch (IllegalArgumentException e2) {
            throw new z("unable to get DER object", e2);
        }
    }

    @Override // sdk.pendo.io.m3.r2
    public a0 e() {
        return a(this.f);
    }
}
