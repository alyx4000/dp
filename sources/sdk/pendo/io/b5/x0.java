package sdk.pendo.io.b5;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.asn1.ASN1Encoding;
import sdk.pendo.io.y4.h2;

/* loaded from: classes6.dex */
class x0 {
    private static X509EncodedKeySpec a(sdk.pendo.io.m3.v vVar, byte[] bArr) {
        return new X509EncodedKeySpec(new sdk.pendo.io.e4.g(new sdk.pendo.io.e4.a(vVar), bArr).a(ASN1Encoding.DER));
    }

    static PublicKey a(h hVar, String str, sdk.pendo.io.m3.v vVar, byte[] bArr) {
        try {
            KeyFactory i = hVar.g().i(str);
            i.getProvider();
            return i.generatePublic(a(vVar, bArr));
        } catch (Exception e) {
            throw new h2((short) 47, (Throwable) e);
        }
    }

    static byte[] a(PublicKey publicKey) {
        if (publicKey instanceof sdk.pendo.io.l4.a) {
            return ((sdk.pendo.io.l4.a) publicKey).d();
        }
        if (!"X.509".equals(publicKey.getFormat())) {
            throw new h2((short) 80, "Public key format unrecognized");
        }
        try {
            return sdk.pendo.io.e4.g.a(publicKey.getEncoded()).i().k();
        } catch (Exception e) {
            throw new h2((short) 80, (Throwable) e);
        }
    }
}
