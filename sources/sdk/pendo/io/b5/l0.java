package sdk.pendo.io.b5;

import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import javax.crypto.Cipher;
import kotlin.UByte;
import sdk.pendo.io.y4.t1;

/* loaded from: classes6.dex */
public class l0 implements t1 {

    /* renamed from: a, reason: collision with root package name */
    protected h f915a;
    protected sdk.pendo.io.y4.l b;
    protected PrivateKey c;

    public l0(h hVar, sdk.pendo.io.y4.l lVar, PrivateKey privateKey) {
        if (hVar == null) {
            throw new IllegalArgumentException("'crypto' cannot be null");
        }
        if (lVar == null) {
            throw new IllegalArgumentException("'certificate' cannot be null");
        }
        if (lVar.d()) {
            throw new IllegalArgumentException("'certificate' cannot be empty");
        }
        if (privateKey == null) {
            throw new IllegalArgumentException("'privateKey' cannot be null");
        }
        if (!(privateKey instanceof RSAPrivateKey) && !"RSA".equals(privateKey.getAlgorithm())) {
            throw new IllegalArgumentException("'privateKey' type not supported: " + privateKey.getClass().getName());
        }
        this.f915a = hVar;
        this.b = lVar;
        this.c = privateKey;
    }

    @Override // sdk.pendo.io.y4.t1
    public sdk.pendo.io.z4.b0 a(sdk.pendo.io.z4.j jVar, byte[] bArr) {
        return a(jVar, this.c, bArr);
    }

    @Override // sdk.pendo.io.y4.v1
    public sdk.pendo.io.y4.l a() {
        return this.b;
    }

    protected sdk.pendo.io.z4.b0 a(sdk.pendo.io.z4.j jVar, PrivateKey privateKey, byte[] bArr) {
        SecureRandom h = this.f915a.h();
        sdk.pendo.io.y4.v0 b = jVar.b();
        byte[] bArr2 = new byte[48];
        h.nextBytes(bArr2);
        byte[] a2 = sdk.pendo.io.d5.a.a(bArr2);
        try {
            Cipher f = this.f915a.f();
            f.init(2, privateKey, h);
            byte[] doFinal = f.doFinal(bArr);
            if (doFinal != null) {
                if (doFinal.length == 48) {
                    a2 = doFinal;
                }
            }
        } catch (Exception unused) {
        }
        int d = (((b.d() ^ (a2[1] & UByte.MAX_VALUE)) | (b.c() ^ (a2[0] & UByte.MAX_VALUE))) - 1) >> 31;
        for (int i = 0; i < 48; i++) {
            a2[i] = (byte) ((a2[i] & d) | (bArr2[i] & (~d)));
        }
        return this.f915a.b(a2);
    }
}
