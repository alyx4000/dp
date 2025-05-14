package sdk.pendo.io.b5;

import java.io.OutputStream;
import java.security.Signature;
import java.security.SignatureException;
import sdk.pendo.io.y4.h2;

/* loaded from: classes6.dex */
class d0 implements sdk.pendo.io.z4.d0 {

    /* renamed from: a, reason: collision with root package name */
    private final Signature f901a;
    private final OutputStream b;

    d0(Signature signature) {
        this.f901a = signature;
        this.b = sdk.pendo.io.m4.a.a(signature);
    }

    @Override // sdk.pendo.io.z4.d0
    public OutputStream a() {
        return this.b;
    }

    @Override // sdk.pendo.io.z4.d0
    public byte[] b() {
        try {
            return this.f901a.sign();
        } catch (SignatureException e) {
            throw new h2((short) 80, (Throwable) e);
        }
    }
}
