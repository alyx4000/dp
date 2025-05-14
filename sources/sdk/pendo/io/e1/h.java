package sdk.pendo.io.e1;

import java.security.Key;

/* loaded from: classes6.dex */
public class h extends sdk.pendo.io.a1.f implements f {
    public h() {
        a("none");
        a(sdk.pendo.io.i1.h.NONE);
    }

    private void b(Key key) {
        if (key != null) {
            throw new sdk.pendo.io.k1.f("JWS Plaintext (alg=none) must not use a key.");
        }
    }

    @Override // sdk.pendo.io.e1.f
    public void a(Key key) {
        b(key);
    }

    @Override // sdk.pendo.io.a1.a
    public boolean d() {
        return true;
    }

    @Override // sdk.pendo.io.e1.f
    public boolean a(byte[] bArr, Key key, byte[] bArr2, sdk.pendo.io.w0.a aVar) {
        b(key);
        return bArr.length == 0;
    }
}
