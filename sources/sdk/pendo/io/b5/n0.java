package sdk.pendo.io.b5;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Arrays;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import sdk.pendo.io.y4.h2;
import sdk.pendo.io.y4.z1;

/* loaded from: classes6.dex */
public class n0 implements sdk.pendo.io.z4.m {

    /* renamed from: a, reason: collision with root package name */
    protected final h f919a;
    protected final sdk.pendo.io.z4.l b;
    protected final DHParameterSpec c;

    public n0(h hVar, sdk.pendo.io.z4.l lVar) {
        DHParameterSpec b;
        sdk.pendo.io.z4.a a2 = z1.a(lVar);
        if (a2 == null || (b = a.b(hVar, a2)) == null) {
            throw new IllegalArgumentException("No DH configuration provided");
        }
        this.f919a = hVar;
        this.b = lVar;
        this.c = b;
    }

    public r0 a(DHPrivateKey dHPrivateKey, DHPublicKey dHPublicKey) {
        return a(this.f919a, dHPrivateKey, dHPublicKey, this.b.c());
    }

    public DHPublicKey b(byte[] bArr) {
        try {
            return (DHPublicKey) this.f919a.g().i("DiffieHellman").generatePublic(a.a(a(bArr), this.c));
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            throw new h2((short) 40, (Throwable) e2);
        }
    }

    public static r0 a(h hVar, DHPrivateKey dHPrivateKey, DHPublicKey dHPublicKey, boolean z) {
        try {
            byte[] a2 = hVar.a("DiffieHellman", dHPrivateKey, dHPublicKey, "TlsPremasterSecret");
            if (z) {
                int a3 = a(dHPrivateKey.getParams());
                byte[] bArr = new byte[a3];
                System.arraycopy(a2, 0, bArr, a3 - a2.length, a2.length);
                Arrays.fill(a2, (byte) 0);
                a2 = bArr;
            }
            return hVar.d(a2);
        } catch (GeneralSecurityException e) {
            throw new sdk.pendo.io.z4.i("cannot calculate secret", e);
        }
    }

    public KeyPair b() {
        try {
            KeyPairGenerator a2 = this.f919a.g().a("DiffieHellman");
            a2.initialize(this.c, this.f919a.h());
            return a2.generateKeyPair();
        } catch (GeneralSecurityException e) {
            throw new sdk.pendo.io.z4.i("unable to create key pair", e);
        }
    }

    @Override // sdk.pendo.io.z4.m
    public sdk.pendo.io.z4.e a() {
        return new m0(this);
    }

    public BigInteger a(byte[] bArr) {
        if (!this.b.c() || a(this.c) == bArr.length) {
            return new BigInteger(1, bArr);
        }
        throw new h2((short) 47);
    }

    public byte[] a(DHPublicKey dHPublicKey) {
        return a(this.c, true, dHPublicKey.getY());
    }

    private static byte[] a(DHParameterSpec dHParameterSpec, boolean z, BigInteger bigInteger) {
        return z ? sdk.pendo.io.d5.b.a(a(dHParameterSpec), bigInteger) : sdk.pendo.io.d5.b.a(bigInteger);
    }

    private static int a(DHParameterSpec dHParameterSpec) {
        return (dHParameterSpec.getP().bitLength() + 7) / 8;
    }
}
