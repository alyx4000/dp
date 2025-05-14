package sdk.pendo.io.m3;

import java.io.IOException;

/* loaded from: classes6.dex */
public class e1 implements g, r2 {
    final f0 A;
    final int f;
    final int s;

    e1(int i, int i2, f0 f0Var) {
        this.f = i;
        this.s = i2;
        this.A = f0Var;
    }

    @Override // sdk.pendo.io.m3.g
    public a0 b() {
        try {
            return e();
        } catch (IOException e) {
            throw new z(e.getMessage());
        }
    }

    @Override // sdk.pendo.io.m3.r2
    public a0 e() {
        return this.A.a(this.f, this.s);
    }
}
