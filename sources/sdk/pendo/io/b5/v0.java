package sdk.pendo.io.b5;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.jcajce.spec.XDHParameterSpec;
import sdk.pendo.io.y4.h2;

/* loaded from: classes6.dex */
public class v0 implements sdk.pendo.io.z4.p {

    /* renamed from: a, reason: collision with root package name */
    protected final h f928a;

    public v0(h hVar) {
        this.f928a = hVar;
    }

    public r0 a(PrivateKey privateKey, PublicKey publicKey) {
        try {
            byte[] a2 = this.f928a.a(XDHParameterSpec.X448, privateKey, publicKey, "TlsPremasterSecret");
            if (a2 == null || a2.length != 56) {
                throw new sdk.pendo.io.z4.i("invalid secret calculated");
            }
            if (sdk.pendo.io.d5.a.a(a2, 0, a2.length)) {
                throw new h2((short) 40);
            }
            return this.f928a.d(a2);
        } catch (GeneralSecurityException e) {
            throw new sdk.pendo.io.z4.i("cannot calculate secret", e);
        }
    }

    public KeyPair b() {
        try {
            KeyPairGenerator a2 = this.f928a.g().a(XDHParameterSpec.X448);
            a2.initialize(448, this.f928a.h());
            return a2.generateKeyPair();
        } catch (GeneralSecurityException e) {
            throw c.b("unable to create key pair: " + e.getMessage(), e);
        }
    }

    @Override // sdk.pendo.io.z4.p
    public sdk.pendo.io.z4.e a() {
        return new u0(this);
    }

    public PublicKey a(byte[] bArr) {
        return x0.a(this.f928a, XDHParameterSpec.X448, sdk.pendo.io.t3.a.c, bArr);
    }

    public byte[] a(PublicKey publicKey) {
        return x0.a(publicKey);
    }
}
