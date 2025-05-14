package sdk.pendo.io.a5;

import sdk.pendo.io.z4.b0;

/* loaded from: classes6.dex */
public abstract class a implements sdk.pendo.io.z4.h {
    @Override // sdk.pendo.io.z4.h
    public b0 a(b0 b0Var) {
        if (b0Var instanceof b) {
            return b(((b) b0Var).d());
        }
        throw new IllegalArgumentException("unrecognized TlsSecret - cannot copy data: " + b0Var.getClass().getName());
    }
}
