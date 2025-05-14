package sdk.pendo.io.b5;

import java.io.OutputStream;
import java.security.Signature;
import java.security.SignatureException;
import sdk.pendo.io.y4.h2;

/* loaded from: classes6.dex */
class e0 implements sdk.pendo.io.z4.e0 {

    /* renamed from: a, reason: collision with root package name */
    private final Signature f903a;
    private final OutputStream b;
    private final byte[] c;

    e0(Signature signature, byte[] bArr) {
        this.f903a = signature;
        this.b = sdk.pendo.io.m4.a.a(signature);
        this.c = bArr;
    }

    @Override // sdk.pendo.io.z4.e0
    public OutputStream a() {
        return this.b;
    }

    @Override // sdk.pendo.io.z4.e0
    public boolean b() {
        try {
            return this.f903a.verify(this.c);
        } catch (SignatureException e) {
            throw new h2((short) 80, (Throwable) e);
        }
    }
}
