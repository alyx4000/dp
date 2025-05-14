package sdk.pendo.io.m3;

import java.io.IOException;

/* loaded from: classes6.dex */
public class n2 implements g, r2 {
    private f0 f;

    n2(f0 f0Var) {
        this.f = f0Var;
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
        return i2.b(this.f.b());
    }
}
