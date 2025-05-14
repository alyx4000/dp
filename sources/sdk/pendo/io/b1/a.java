package sdk.pendo.io.b1;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: classes6.dex */
public class a extends sdk.pendo.io.a1.f implements g {
    private final String f;
    private final int g;
    private final i h;

    /* renamed from: sdk.pendo.io.b1.a$a, reason: collision with other inner class name */
    public static class C0088a extends a {
        public C0088a() {
            super("A128CBC-HS256", 32, "HmacSHA256", 16);
        }
    }

    public static class b extends a {
        public b() {
            super("A192CBC-HS384", 48, "HmacSHA384", 24);
        }
    }

    public static class c extends a {
        public c() {
            super("A256CBC-HS512", 64, "HmacSHA512", 32);
        }
    }

    public a(String str, int i, String str2, int i2) {
        a(str);
        this.h = new i(i, "AES");
        this.f = str2;
        this.g = i2;
        b("AES/CBC/PKCS5Padding");
        a(sdk.pendo.io.i1.h.SYMMETRIC);
        c("AES");
    }

    private byte[] b(byte[] bArr) {
        return sdk.pendo.io.k1.a.a(sdk.pendo.io.k1.a.a(bArr));
    }

    @Override // sdk.pendo.io.b1.g
    public byte[] a(k kVar, byte[] bArr, byte[] bArr2, sdk.pendo.io.h1.b bVar, sdk.pendo.io.w0.a aVar) {
        String b2 = h.b(bVar, aVar);
        String c2 = h.c(bVar, aVar);
        byte[] c3 = kVar.c();
        byte[] b3 = kVar.b();
        byte[] a2 = kVar.a();
        if (!sdk.pendo.io.k1.a.a(a2, sdk.pendo.io.k1.a.a(sdk.pendo.io.l1.a.a(f(), new sdk.pendo.io.i1.f(sdk.pendo.io.k1.a.c(bArr2)), c2).doFinal(sdk.pendo.io.k1.a.a(bArr, c3, b3, b(bArr))), 0, g()))) {
            throw new sdk.pendo.io.k1.d("Authentication tag check failed. Message=" + new sdk.pendo.io.u0.b().a(a2));
        }
        sdk.pendo.io.i1.a aVar2 = new sdk.pendo.io.i1.a(sdk.pendo.io.k1.a.e(bArr2));
        Cipher a3 = f.a(e(), b2);
        try {
            a3.init(2, aVar2, new IvParameterSpec(c3));
            try {
                return a3.doFinal(b3);
            } catch (BadPaddingException | IllegalBlockSizeException e) {
                throw new sdk.pendo.io.k1.g(e.toString(), e);
            }
        } catch (InvalidAlgorithmParameterException e2) {
            throw new sdk.pendo.io.k1.g(e2.toString(), e2);
        } catch (InvalidKeyException e3) {
            throw new sdk.pendo.io.k1.g("Invalid key for " + e(), e3);
        }
    }

    @Override // sdk.pendo.io.a1.a
    public boolean d() {
        return e.a(e(), b().b() / 2);
    }

    public String f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    @Override // sdk.pendo.io.b1.g
    public i b() {
        return this.h;
    }
}
