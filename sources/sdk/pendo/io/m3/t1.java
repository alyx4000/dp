package sdk.pendo.io.m3;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class t1 implements x {
    private q2 f;

    t1(q2 q2Var) {
        this.f = q2Var;
    }

    @Override // sdk.pendo.io.m3.x
    public InputStream a() {
        return this.f;
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
        return new s1(this.f.e());
    }
}
