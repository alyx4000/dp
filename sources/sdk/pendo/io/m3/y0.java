package sdk.pendo.io.m3;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class y0 implements x {
    private f0 f;

    y0(f0 f0Var) {
        this.f = f0Var;
    }

    @Override // sdk.pendo.io.m3.x
    public InputStream a() {
        return new g1(this.f);
    }

    @Override // sdk.pendo.io.m3.g
    public a0 b() {
        try {
            return e();
        } catch (IOException e) {
            throw new z("IOException converting stream to byte array: " + e.getMessage(), e);
        }
    }

    @Override // sdk.pendo.io.m3.r2
    public a0 e() {
        return a(this.f);
    }

    static x0 a(f0 f0Var) {
        return new x0(sdk.pendo.io.f5.a.a(new g1(f0Var)));
    }
}
