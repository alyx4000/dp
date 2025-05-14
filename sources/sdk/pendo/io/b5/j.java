package sdk.pendo.io.b5;

import java.security.PrivateKey;
import sdk.pendo.io.y4.i1;

/* loaded from: classes6.dex */
public class j extends l {
    public j(h hVar, PrivateKey privateKey) {
        super(hVar, privateKey, (short) 2, "NoneWithDSA");
    }

    @Override // sdk.pendo.io.b5.l, sdk.pendo.io.z4.c0
    public sdk.pendo.io.z4.d0 a(i1 i1Var) {
        if (i1Var == null || this.c != i1Var.b() || sdk.pendo.io.y4.i0.b(i1Var.a()) == 20) {
            return null;
        }
        return this.f914a.a(i1Var, this.b, true);
    }
}
