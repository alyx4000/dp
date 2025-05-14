package sdk.pendo.io.b5;

import java.security.SecureRandom;

/* loaded from: classes6.dex */
class e implements sdk.pendo.io.z4.w {

    /* renamed from: a, reason: collision with root package name */
    private final sdk.pendo.io.j4.f f902a;

    e(SecureRandom secureRandom, byte[] bArr) {
        byte[] bArr2 = new byte[32];
        secureRandom.nextBytes(bArr2);
        this.f902a = new sdk.pendo.io.j4.g(secureRandom, false).a(bArr).a(new sdk.pendo.io.h4.d(), bArr2, false);
    }

    @Override // sdk.pendo.io.z4.w
    public byte[] a(int i) {
        byte[] bArr = new byte[i];
        this.f902a.nextBytes(bArr);
        return bArr;
    }
}
