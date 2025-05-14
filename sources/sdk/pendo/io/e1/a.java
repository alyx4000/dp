package sdk.pendo.io.e1;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import sdk.pendo.io.w0.a;

/* loaded from: classes6.dex */
public abstract class a extends sdk.pendo.io.a1.f implements f {
    private final sdk.pendo.io.h7.a f = sdk.pendo.io.h7.b.a(getClass());
    private AlgorithmParameterSpec g;

    public a(String str, String str2, String str3) {
        a(str);
        b(str2);
        a(sdk.pendo.io.i1.h.ASYMMETRIC);
        c(str3);
    }

    private Signature a(sdk.pendo.io.w0.a aVar) {
        a.C0258a c = aVar.c();
        String h = c.h();
        String e = e();
        c.g();
        try {
            Signature signature = h == null ? Signature.getInstance(e) : Signature.getInstance(e, h);
            AlgorithmParameterSpec algorithmParameterSpec = this.g;
            if (algorithmParameterSpec != null) {
                try {
                    signature.setParameter(algorithmParameterSpec);
                } catch (UnsupportedOperationException e2) {
                    if (this.f.a()) {
                        this.f.a("Unable to set algorithm parameter spec on Signature (java algorithm name: " + e + ") so ignoring the UnsupportedOperationException and relying on the default parameters.", (Throwable) e2);
                    }
                }
            }
            return signature;
        } catch (InvalidAlgorithmParameterException e3) {
            throw new sdk.pendo.io.k1.g("Invalid algorithm parameter (" + this.g + ") for: " + e, e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new sdk.pendo.io.k1.g("Unable to get an implementation of algorithm name: " + e, e4);
        } catch (NoSuchProviderException e5) {
            throw new sdk.pendo.io.k1.g("Unable to get an implementation of " + e + " for provider " + h, e5);
        }
    }

    private void b(Key key) {
        if (key == null) {
            throw new sdk.pendo.io.k1.f("Key cannot be null");
        }
    }

    private String c(Key key) {
        return "The given key (" + (key == null ? "key is null" : "algorithm=" + key.getAlgorithm()) + ") is not valid ";
    }

    public abstract void a(PublicKey publicKey);

    @Override // sdk.pendo.io.a1.a
    public boolean d() {
        try {
            return a(new sdk.pendo.io.w0.a()) != null;
        } catch (Exception e) {
            this.f.a(c() + " via " + e() + " is NOT available from the underlying JCE (" + sdk.pendo.io.k1.b.a(e) + ").");
            return false;
        }
    }

    private void a(Signature signature, Key key, sdk.pendo.io.w0.a aVar) {
        try {
            PrivateKey privateKey = (PrivateKey) key;
            SecureRandom b = aVar.b();
            if (b == null) {
                signature.initSign(privateKey);
            } else {
                signature.initSign(privateKey, b);
            }
        } catch (InvalidKeyException e) {
            throw new sdk.pendo.io.k1.f(c(key) + "for " + e(), e);
        }
    }

    private void a(Signature signature, Key key) {
        try {
            signature.initVerify((PublicKey) key);
        } catch (InvalidKeyException e) {
            throw new sdk.pendo.io.k1.f(c(key) + "for " + e(), e);
        }
    }

    public sdk.pendo.io.a1.g a(Key key, sdk.pendo.io.w0.a aVar) {
        Signature a2 = a(aVar);
        a(a2, key, aVar);
        return new sdk.pendo.io.a1.g(a2);
    }

    protected void a(AlgorithmParameterSpec algorithmParameterSpec) {
        this.g = algorithmParameterSpec;
    }

    public byte[] a(sdk.pendo.io.a1.g gVar, byte[] bArr) {
        Signature d = gVar.d();
        try {
            d.update(bArr);
            return d.sign();
        } catch (SignatureException e) {
            throw new sdk.pendo.io.k1.g("Problem creating signature.", e);
        }
    }

    @Override // sdk.pendo.io.e1.f
    public void a(Key key) {
        b(key);
        try {
            a((PublicKey) key);
        } catch (ClassCastException e) {
            throw new sdk.pendo.io.k1.f(c(key) + "(not a public key or is the wrong type of key) for " + e() + "/" + c() + " " + e);
        }
    }

    @Override // sdk.pendo.io.e1.f
    public boolean a(byte[] bArr, Key key, byte[] bArr2, sdk.pendo.io.w0.a aVar) {
        Signature a2 = a(aVar);
        a(a2, key);
        try {
            a2.update(bArr2);
            return a2.verify(bArr);
        } catch (SignatureException e) {
            if (!this.f.a()) {
                return false;
            }
            this.f.a("Problem verifying " + c() + " signature: " + sdk.pendo.io.k1.b.a(e));
            return false;
        }
    }
}
