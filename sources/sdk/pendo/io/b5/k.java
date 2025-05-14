package sdk.pendo.io.b5;

import java.security.PublicKey;
import sdk.pendo.io.y4.i1;

/* loaded from: classes6.dex */
public class k extends m {
    public k(h hVar, PublicKey publicKey) {
        super(hVar, publicKey, (short) 2, "NoneWithDSA");
    }

    @Override // sdk.pendo.io.b5.m, sdk.pendo.io.z4.f0
    public sdk.pendo.io.z4.e0 a(sdk.pendo.io.y4.d0 d0Var) {
        i1 a2 = d0Var.a();
        if (a2 == null || this.c != a2.b() || sdk.pendo.io.y4.i0.b(a2.a()) == 20) {
            return null;
        }
        return this.f916a.a(d0Var, this.b);
    }
}
