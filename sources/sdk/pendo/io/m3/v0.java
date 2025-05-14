package sdk.pendo.io.m3;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class v0 implements d {
    private f0 f;
    private f1 s;

    v0(f0 f0Var) {
        this.f = f0Var;
    }

    static u0 a(f0 f0Var) {
        f1 f1Var = new f1(f0Var, false);
        return new u0(sdk.pendo.io.f5.a.a(f1Var), f1Var.b());
    }

    @Override // sdk.pendo.io.m3.g
    public a0 b() {
        try {
            return e();
        } catch (IOException e) {
            throw new z("IOException converting stream to byte array: " + e.getMessage(), e);
        }
    }

    @Override // sdk.pendo.io.m3.d
    public int d() {
        return this.s.b();
    }

    @Override // sdk.pendo.io.m3.r2
    public a0 e() {
        return a(this.f);
    }

    @Override // sdk.pendo.io.m3.d
    public InputStream f() {
        f1 f1Var = new f1(this.f, false);
        this.s = f1Var;
        return f1Var;
    }
}
