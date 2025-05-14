package sdk.pendo.io.b1;

import java.security.Key;

/* loaded from: classes6.dex */
public class l extends sdk.pendo.io.a1.f implements p {
    public l() {
        a("dir");
        a(sdk.pendo.io.i1.h.SYMMETRIC);
        c("oct");
    }

    private void b(Key key, g gVar) {
        int length;
        int b;
        sdk.pendo.io.h1.d.b(key);
        if (key.getEncoded() != null && (b = gVar.b().b()) != (length = key.getEncoded().length)) {
            throw new sdk.pendo.io.k1.f("Invalid key for " + c() + " with " + gVar.c() + ", expected a " + sdk.pendo.io.k1.a.a(b) + " bit key but a " + sdk.pendo.io.k1.a.a(length) + " bit key was provided.");
        }
    }

    @Override // sdk.pendo.io.b1.p
    public Key a(sdk.pendo.io.a1.g gVar, byte[] bArr, i iVar, sdk.pendo.io.h1.b bVar, sdk.pendo.io.w0.a aVar) {
        Key b = gVar.b();
        if (bArr.length == 0) {
            return b;
        }
        throw new sdk.pendo.io.k1.f("An empty octet sequence is to be used as the JWE Encrypted Key value when utilizing direct encryption but this JWE has " + bArr.length + " octets in the encrypted key part.");
    }

    @Override // sdk.pendo.io.a1.a
    public boolean d() {
        return true;
    }

    @Override // sdk.pendo.io.b1.p
    public sdk.pendo.io.a1.g a(Key key, sdk.pendo.io.h1.b bVar, sdk.pendo.io.w0.a aVar) {
        return new sdk.pendo.io.a1.g(key);
    }

    @Override // sdk.pendo.io.b1.p
    public void a(Key key, g gVar) {
        b(key, gVar);
    }
}
