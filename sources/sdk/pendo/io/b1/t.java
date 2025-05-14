package sdk.pendo.io.b1;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import sdk.pendo.io.w0.a;

/* loaded from: classes6.dex */
public abstract class t extends sdk.pendo.io.a1.f implements p {
    private AlgorithmParameterSpec g;
    protected final sdk.pendo.io.h7.a f = sdk.pendo.io.h7.b.a(getClass());
    protected boolean h = true;

    public t(String str, String str2) {
        b(str);
        a(str2);
    }

    private a.C0258a a(sdk.pendo.io.w0.a aVar) {
        return this.h ? aVar.c() : aVar.a();
    }

    void a(Cipher cipher, int i, Key key) {
        AlgorithmParameterSpec algorithmParameterSpec = this.g;
        if (algorithmParameterSpec == null) {
            cipher.init(i, key);
        } else {
            cipher.init(i, key, algorithmParameterSpec);
        }
    }

    @Override // sdk.pendo.io.b1.p
    public Key a(sdk.pendo.io.a1.g gVar, byte[] bArr, i iVar, sdk.pendo.io.h1.b bVar, sdk.pendo.io.w0.a aVar) {
        Cipher a2 = gVar.a();
        String a3 = iVar.a();
        try {
            return a(aVar).c() == a.b.DECRYPT ? new SecretKeySpec(a2.doFinal(bArr), a3) : a2.unwrap(bArr, a3, 3);
        } catch (Exception e) {
            if (this.f.a()) {
                this.f.b("Key unwrap/decrypt failed. Substituting a randomly generated CEK and proceeding. {}", sdk.pendo.io.k1.b.a(e, o.class));
            }
            return new SecretKeySpec(sdk.pendo.io.k1.a.d(iVar.b()), a3);
        }
    }

    protected j a(Key key, i iVar, byte[] bArr, sdk.pendo.io.w0.a aVar) {
        Cipher a2 = f.a(e(), a(aVar).a());
        try {
            a(a2, 3, key);
            return new j(bArr, a2.wrap(new SecretKeySpec(bArr, iVar.a())));
        } catch (InvalidAlgorithmParameterException e) {
            e = e;
            throw new sdk.pendo.io.k1.g("Unable to encrypt (" + a2.getAlgorithm() + ") the Content Encryption Key: " + e, e);
        } catch (InvalidKeyException e2) {
            throw new sdk.pendo.io.k1.f("Unable to encrypt (" + a2.getAlgorithm() + ") the Content Encryption Key: " + e2, e2);
        } catch (IllegalBlockSizeException e3) {
            e = e3;
            throw new sdk.pendo.io.k1.g("Unable to encrypt (" + a2.getAlgorithm() + ") the Content Encryption Key: " + e, e);
        }
    }

    public j a(Key key, i iVar, sdk.pendo.io.h1.b bVar, byte[] bArr, sdk.pendo.io.w0.a aVar) {
        if (bArr == null) {
            bArr = sdk.pendo.io.k1.a.d(iVar.b());
        }
        return a(key, iVar, bArr, aVar);
    }

    @Override // sdk.pendo.io.b1.p
    public sdk.pendo.io.a1.g a(Key key, sdk.pendo.io.h1.b bVar, sdk.pendo.io.w0.a aVar) {
        a.C0258a a2 = a(aVar);
        Cipher a3 = f.a(e(), a2.a());
        try {
            a(a3, a2.c() == a.b.DECRYPT ? 2 : 4, key);
            return new sdk.pendo.io.a1.g(a3);
        } catch (InvalidAlgorithmParameterException e) {
            throw new sdk.pendo.io.k1.g("Unable to initialize cipher (" + a3.getAlgorithm() + ") for key unwrap/decrypt - " + e, e);
        } catch (InvalidKeyException e2) {
            throw new sdk.pendo.io.k1.f("Unable to initialize cipher (" + a3.getAlgorithm() + ") for key unwrap/decrypt - " + e2, e2);
        }
    }

    public void a(AlgorithmParameterSpec algorithmParameterSpec) {
        this.g = algorithmParameterSpec;
    }
}
