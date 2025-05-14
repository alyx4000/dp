package sdk.pendo.io.b5;

import java.io.OutputStream;
import java.security.Signature;
import java.security.SignatureException;
import sdk.pendo.io.y4.h2;

/* loaded from: classes6.dex */
class g0 implements sdk.pendo.io.z4.d0 {

    /* renamed from: a, reason: collision with root package name */
    private final Signature f906a;
    private final Signature b;
    private final OutputStream c;

    g0(Signature signature, Signature signature2) {
        OutputStream a2 = sdk.pendo.io.m4.a.a(signature);
        OutputStream a3 = sdk.pendo.io.m4.a.a(signature2);
        this.f906a = signature;
        this.b = signature2;
        this.c = new sdk.pendo.io.f5.c(a2, a3);
    }

    @Override // sdk.pendo.io.z4.d0
    public OutputStream a() {
        return this.c;
    }

    @Override // sdk.pendo.io.z4.d0
    public byte[] b() {
        try {
            byte[] sign = this.f906a.sign();
            if (this.b.verify(sign)) {
                return sign;
            }
            throw new h2((short) 80);
        } catch (SignatureException e) {
            throw new h2((short) 80, (Throwable) e);
        }
    }
}
