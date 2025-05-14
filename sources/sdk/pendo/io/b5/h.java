package sdk.pendo.io.b5;

import expo.modules.securestore.encryptors.AESEncryptor;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.bouncycastle.jcajce.spec.XDHParameterSpec;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import sdk.pendo.io.y4.h2;
import sdk.pendo.io.y4.i1;
import sdk.pendo.io.y4.j1;
import sdk.pendo.io.y4.l3;
import sdk.pendo.io.y4.z1;

/* loaded from: classes6.dex */
public class h extends sdk.pendo.io.a5.a {

    /* renamed from: a, reason: collision with root package name */
    private final sdk.pendo.io.p4.b f907a;
    private final SecureRandom b;
    private final SecureRandom c;
    private final Hashtable d = new Hashtable();
    private final Hashtable e = new Hashtable();
    private final Hashtable f = new Hashtable();

    class a implements sdk.pendo.io.z4.y {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ sdk.pendo.io.c5.a f908a;

        a(sdk.pendo.io.c5.a aVar) {
            this.f908a = aVar;
        }

        @Override // sdk.pendo.io.z4.y
        public BigInteger a(BigInteger bigInteger) {
            try {
                return this.f908a.a(bigInteger);
            } catch (IllegalArgumentException e) {
                throw new h2((short) 47, (Throwable) e);
            }
        }
    }

    protected h(sdk.pendo.io.p4.b bVar, SecureRandom secureRandom, SecureRandom secureRandom2) {
        this.f907a = bVar;
        this.b = secureRandom;
        this.c = secureRandom2;
    }

    private sdk.pendo.io.a5.d e(sdk.pendo.io.z4.j jVar, int i, int i2) {
        return new sdk.pendo.io.a5.d(jVar, a("Camellia/GCM/NoPadding", "Camellia", i, true), a("Camellia/GCM/NoPadding", "Camellia", i, false), i, i2, 3);
    }

    @Override // sdk.pendo.io.z4.h
    public boolean a(short s) {
        switch (s) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                return true;
            default:
                switch (s) {
                    case 26:
                    case 27:
                    case 28:
                        return true;
                    default:
                        return false;
                }
        }
    }

    public byte[] a(String str, PrivateKey privateKey, PublicKey publicKey, String str2) {
        KeyAgreement g = this.f907a.g(str);
        g.init(privateKey);
        g.doPhase(publicKey, true);
        try {
            return g.generateSecret(str2).getEncoded();
        } catch (NoSuchAlgorithmException e) {
            if (XDHParameterSpec.X25519.equals(str) || XDHParameterSpec.X448.equals(str)) {
                return g.generateSecret();
            }
            throw e;
        }
    }

    protected sdk.pendo.io.a5.g b(String str, String str2, int i, boolean z) {
        return new i0(this.f907a.d(str), str2, i, z);
    }

    protected sdk.pendo.io.a5.g c(String str, String str2, int i, boolean z) {
        return new j0(this.f907a.d(str), str2, z);
    }

    @Override // sdk.pendo.io.z4.h
    public boolean c() {
        return true;
    }

    r0 d(byte[] bArr) {
        return new r0(this, bArr);
    }

    @Override // sdk.pendo.io.z4.h
    public boolean d() {
        return true;
    }

    @Override // sdk.pendo.io.z4.h
    public boolean e() {
        return true;
    }

    @Override // sdk.pendo.io.z4.h
    public boolean e(int i) {
        return true;
    }

    Cipher f() {
        try {
            return g().d("RSA/NONE/PKCS1Padding");
        } catch (GeneralSecurityException unused) {
            return g().d("RSA/ECB/PKCS1Padding");
        }
    }

    public sdk.pendo.io.z4.s g(int i) {
        return b(sdk.pendo.io.z4.k.a(i));
    }

    protected sdk.pendo.io.z4.s h(int i) {
        if (i == 1) {
            return new f(a(i(1)), 16, 64);
        }
        if (i == 2) {
            return new f(a(i(2)), 20, 64);
        }
        if (i == 3) {
            return new f(a(i(4)), 32, 64);
        }
        if (i == 4) {
            return new f(a(i(5)), 48, 128);
        }
        if (i == 5) {
            return new f(a(i(6)), 64, 128);
        }
        throw new h2((short) 80);
    }

    String i(int i) {
        switch (i) {
            case 1:
                return MessageDigestAlgorithms.MD5;
            case 2:
                return "SHA-1";
            case 3:
                return McElieceCCA2KeyGenParameterSpec.SHA224;
            case 4:
                return "SHA-256";
            case 5:
                return "SHA-384";
            case 6:
                return "SHA-512";
            case 7:
                return "SM3";
            default:
                throw new IllegalArgumentException("invalid CryptoHashAlgorithm: " + i);
        }
    }

    String j(int i) {
        switch (i) {
            case 1:
                return "HmacMD5";
            case 2:
                return "HmacSHA1";
            case 3:
                return "HmacSHA224";
            case 4:
                return "HmacSHA256";
            case 5:
                return "HmacSHA384";
            case 6:
                return "HmacSHA512";
            case 7:
                return "HmacSM3";
            default:
                throw new IllegalArgumentException("invalid CryptoHashAlgorithm: " + i);
        }
    }

    public AlgorithmParameters k(int i) {
        if (sdk.pendo.io.y4.p0.p(i)) {
            if (i == 29 || i == 30) {
                return null;
            }
        } else {
            if (sdk.pendo.io.y4.p0.o(i)) {
                return b.a(this, sdk.pendo.io.y4.p0.b(i));
            }
            if (sdk.pendo.io.y4.p0.l(i)) {
                return sdk.pendo.io.b5.a.a(this, z1.b(i));
            }
        }
        throw new IllegalArgumentException("NamedGroup not supported: " + sdk.pendo.io.y4.p0.g(i));
    }

    public AlgorithmParameters l(int i) {
        int a2;
        if (!j1.h(i) || (a2 = j1.a(i)) < 0) {
            return null;
        }
        String i2 = i(a2);
        String str = w0.a(i2) + "WITHRSAANDMGF1";
        AlgorithmParameterSpec a3 = w0.a(a2, i2, g());
        Signature f = g().f(str);
        f.setParameter(a3);
        return f.getParameters();
    }

    public boolean m(int i) {
        if (i == 1800) {
            return false;
        }
        short e = j1.e(i);
        int a2 = j1.a(i);
        return a2 != 1 ? a2 != 3 ? a(e) : !f0.a() && a(e) : 1 == e && a(e);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected Boolean n(int i) {
        String str = "ARIA/GCM/NoPadding";
        int i2 = 256;
        switch (i) {
            case 0:
                return Boolean.TRUE;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return Boolean.FALSE;
            case 7:
                str = "DESede/CBC/NoPadding";
                i2 = 192;
                return Boolean.valueOf(a(str, i2));
            case 8:
                str = "AES/CBC/NoPadding";
                i2 = 128;
                return Boolean.valueOf(a(str, i2));
            case 9:
                str = "AES/CBC/NoPadding";
                return Boolean.valueOf(a(str, i2));
            case 10:
                str = AESEncryptor.AES_CIPHER;
                i2 = 128;
                return Boolean.valueOf(a(str, i2));
            case 11:
                str = AESEncryptor.AES_CIPHER;
                return Boolean.valueOf(a(str, i2));
            case 12:
                str = "Camellia/CBC/NoPadding";
                i2 = 128;
                return Boolean.valueOf(a(str, i2));
            case 13:
                str = "Camellia/CBC/NoPadding";
                return Boolean.valueOf(a(str, i2));
            case 14:
                str = "SEED/CBC/NoPadding";
                i2 = 128;
                return Boolean.valueOf(a(str, i2));
            case 15:
            case 16:
                str = "AES/CCM/NoPadding";
                i2 = 128;
                return Boolean.valueOf(a(str, i2));
            case 17:
            case 18:
                str = "AES/CCM/NoPadding";
                return Boolean.valueOf(a(str, i2));
            case 19:
                str = "Camellia/GCM/NoPadding";
                i2 = 128;
                return Boolean.valueOf(a(str, i2));
            case 20:
                str = "Camellia/GCM/NoPadding";
                return Boolean.valueOf(a(str, i2));
            case 21:
                return Boolean.valueOf(a("ChaCha7539", 256) && b("Poly1305"));
            case 22:
                str = "ARIA/CBC/NoPadding";
                i2 = 128;
                return Boolean.valueOf(a(str, i2));
            case 23:
                str = "ARIA/CBC/NoPadding";
                return Boolean.valueOf(a(str, i2));
            case 24:
                i2 = 128;
                return Boolean.valueOf(a(str, i2));
            case 25:
                return Boolean.valueOf(a(str, i2));
            case 26:
                str = "SM4/CCM/NoPadding";
                i2 = 128;
                return Boolean.valueOf(a(str, i2));
            case 27:
                str = "SM4/GCM/NoPadding";
                i2 = 128;
                return Boolean.valueOf(a(str, i2));
            case 28:
                str = "SM4/CBC/NoPadding";
                i2 = 128;
                return Boolean.valueOf(a(str, i2));
            default:
                return null;
        }
    }

    protected Boolean o(int i) {
        try {
            if (!sdk.pendo.io.y4.p0.p(i)) {
                if (sdk.pendo.io.y4.p0.o(i)) {
                    return Boolean.valueOf(b.c(this, sdk.pendo.io.y4.p0.b(i)));
                }
                if (sdk.pendo.io.y4.p0.l(i)) {
                    return Boolean.valueOf(sdk.pendo.io.b5.a.c(this, z1.b(i)));
                }
                return null;
            }
            if (i == 29) {
                this.f907a.g(XDHParameterSpec.X25519);
                return Boolean.TRUE;
            }
            if (i != 30) {
                return null;
            }
            this.f907a.g(XDHParameterSpec.X448);
            return Boolean.TRUE;
        } catch (GeneralSecurityException unused) {
            return Boolean.FALSE;
        }
    }

    private sdk.pendo.io.a5.d b(sdk.pendo.io.z4.j jVar, int i, int i2) {
        return new sdk.pendo.io.a5.d(jVar, a("AES/CCM/NoPadding", "AES", i, true), a("AES/CCM/NoPadding", "AES", i, false), i, i2, 1);
    }

    private sdk.pendo.io.a5.d c(sdk.pendo.io.z4.j jVar, int i, int i2) {
        return new sdk.pendo.io.a5.d(jVar, a(AESEncryptor.AES_CIPHER, "AES", i, true), a(AESEncryptor.AES_CIPHER, "AES", i, false), i, i2, 3);
    }

    private sdk.pendo.io.a5.d d(sdk.pendo.io.z4.j jVar, int i, int i2) {
        return new sdk.pendo.io.a5.d(jVar, a("ARIA/GCM/NoPadding", "ARIA", i, true), a("ARIA/GCM/NoPadding", "ARIA", i, false), i, i2, 3);
    }

    protected sdk.pendo.io.a5.e a(String str, String str2, int i, boolean z) {
        return new h0(this.f907a, str, str2, i, z);
    }

    @Override // sdk.pendo.io.z4.h
    public boolean f(int i) {
        Integer b = sdk.pendo.io.d5.d.b(i);
        synchronized (this.e) {
            Boolean bool = (Boolean) this.e.get(b);
            if (bool != null) {
                return bool.booleanValue();
            }
            Boolean o = o(i);
            if (o == null) {
                return false;
            }
            synchronized (this.e) {
                Boolean bool2 = (Boolean) this.e.put(b, o);
                if (bool2 != null && o != bool2) {
                    this.e.put(b, bool2);
                    o = bool2;
                }
            }
            return o.booleanValue();
        }
    }

    public sdk.pendo.io.p4.b g() {
        return this.f907a;
    }

    public SecureRandom h() {
        return this.b;
    }

    private sdk.pendo.io.a5.d b(sdk.pendo.io.z4.j jVar) {
        return new sdk.pendo.io.a5.d(jVar, a("SM4/CCM/NoPadding", "SM4", 16, true), a("SM4/CCM/NoPadding", "SM4", 16, false), 16, 16, 1);
    }

    private sdk.pendo.io.a5.d c(sdk.pendo.io.z4.j jVar) {
        return new sdk.pendo.io.a5.d(jVar, a("SM4/GCM/NoPadding", "SM4", 16, true), a("SM4/GCM/NoPadding", "SM4", 16, false), 16, 16, 3);
    }

    protected sdk.pendo.io.a5.g a(sdk.pendo.io.z4.j jVar, String str, int i, boolean z) {
        String str2 = str + "/CBC/NoPadding";
        return sdk.pendo.io.a5.h.b(jVar) ? b(str2, str, i, z) : c(str2, str, i, z);
    }

    @Override // sdk.pendo.io.z4.h
    public sdk.pendo.io.z4.t d(int i) {
        try {
            return a(i(i));
        } catch (GeneralSecurityException e) {
            throw c.a("unable to create message digest:" + e.getMessage(), e);
        }
    }

    @Override // sdk.pendo.io.z4.h
    public sdk.pendo.io.z4.f a(byte[] bArr) {
        return new g(this, bArr);
    }

    @Override // sdk.pendo.io.z4.h
    public sdk.pendo.io.z4.s b(int i) {
        String j = j(i);
        try {
            return new q0(i, this.f907a.b(j), j);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException("cannot create HMAC: " + j, e);
        }
    }

    @Override // sdk.pendo.io.z4.h
    public sdk.pendo.io.z4.w c(byte[] bArr) {
        return new e(this.c, bArr);
    }

    private sdk.pendo.io.z4.g a(sdk.pendo.io.z4.j jVar) {
        return new sdk.pendo.io.a5.d(jVar, new k0(this.f907a, true), new k0(this.f907a, false), 32, 16, 2);
    }

    protected sdk.pendo.io.a5.i b(sdk.pendo.io.z4.j jVar, int i) {
        return new sdk.pendo.io.a5.i(jVar, a(jVar, i), a(jVar, i));
    }

    @Override // sdk.pendo.io.z4.h
    public sdk.pendo.io.z4.g a(sdk.pendo.io.z4.j jVar, int i, int i2) {
        try {
            if (i == 0) {
                return b(jVar, i2);
            }
            switch (i) {
                case 7:
                    return a(jVar, "DESede", 24, i2);
                case 8:
                    return a(jVar, "AES", 16, i2);
                case 9:
                    return a(jVar, "AES", 32, i2);
                case 10:
                    return c(jVar, 16, 16);
                case 11:
                    return c(jVar, 32, 16);
                case 12:
                    return a(jVar, "Camellia", 16, i2);
                case 13:
                    return a(jVar, "Camellia", 32, i2);
                case 14:
                    return a(jVar, "SEED", 16, i2);
                case 15:
                    return b(jVar, 16, 16);
                case 16:
                    return b(jVar, 16, 8);
                case 17:
                    return b(jVar, 32, 16);
                case 18:
                    return b(jVar, 32, 8);
                case 19:
                    return e(jVar, 16, 16);
                case 20:
                    return e(jVar, 32, 16);
                case 21:
                    return a(jVar);
                case 22:
                    return a(jVar, "ARIA", 16, i2);
                case 23:
                    return a(jVar, "ARIA", 32, i2);
                case 24:
                    return d(jVar, 16, 16);
                case 25:
                    return d(jVar, 32, 16);
                case 26:
                    return b(jVar);
                case 27:
                    return c(jVar);
                case 28:
                    return a(jVar, "SM4", 16, i2);
                default:
                    throw new h2((short) 80);
            }
        } catch (GeneralSecurityException e) {
            throw new sdk.pendo.io.z4.i("cannot create cipher: " + e.getMessage(), e);
        }
    }

    @Override // sdk.pendo.io.z4.h
    public sdk.pendo.io.z4.b0 b(byte[] bArr) {
        return d(sdk.pendo.io.d5.a.a(bArr));
    }

    @Override // sdk.pendo.io.z4.h
    public sdk.pendo.io.z4.b0 c(int i) {
        return d(new byte[sdk.pendo.io.z4.k.d(i)]);
    }

    protected sdk.pendo.io.z4.g a(sdk.pendo.io.z4.j jVar, String str, int i, int i2) {
        return new sdk.pendo.io.a5.f(jVar, a(jVar, str, i, true), a(jVar, str, i, false), a(jVar, i2), a(jVar, i2), i);
    }

    @Override // sdk.pendo.io.z4.h
    public boolean b() {
        return (f0.a() || a((short) 7) || a((short) 8)) ? false : true;
    }

    @Override // sdk.pendo.io.z4.h
    public sdk.pendo.io.z4.m a(sdk.pendo.io.z4.l lVar) {
        return new n0(this, lVar);
    }

    protected boolean b(String str) {
        try {
            this.f907a.b(str);
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    @Override // sdk.pendo.io.z4.h
    public sdk.pendo.io.z4.p a(sdk.pendo.io.z4.o oVar) {
        int a2 = oVar.a();
        return a2 != 29 ? a2 != 30 ? new p0(this, oVar) : new v0(this) : new t0(this);
    }

    protected sdk.pendo.io.z4.t a(String str) {
        return new x(this.f907a.h(str));
    }

    protected sdk.pendo.io.z4.s a(sdk.pendo.io.z4.j jVar, int i) {
        return sdk.pendo.io.a5.h.a(jVar) ? h(i) : g(i);
    }

    @Override // sdk.pendo.io.z4.h
    public sdk.pendo.io.z4.y a(sdk.pendo.io.z4.a0 a0Var) {
        sdk.pendo.io.c5.a aVar = new sdk.pendo.io.c5.a();
        BigInteger[] a2 = a0Var.a();
        aVar.a(new sdk.pendo.io.z4.c(a2[0], a2[1]), d(2), h());
        return new a(aVar);
    }

    protected sdk.pendo.io.z4.d0 a(String str, AlgorithmParameterSpec algorithmParameterSpec, PrivateKey privateKey, boolean z) {
        try {
            Signature f = g().f(str);
            if (algorithmParameterSpec != null) {
                f.setParameter(algorithmParameterSpec);
            }
            f.initSign(privateKey, z ? h() : null);
            return new d0(f);
        } catch (GeneralSecurityException e) {
            throw new h2((short) 80, (Throwable) e);
        }
    }

    protected sdk.pendo.io.z4.d0 a(i1 i1Var, PrivateKey privateKey, boolean z) {
        return a(f0.a(i1Var), (AlgorithmParameterSpec) null, privateKey, z);
    }

    protected sdk.pendo.io.z4.e0 a(String str, AlgorithmParameterSpec algorithmParameterSpec, byte[] bArr, PublicKey publicKey) {
        try {
            Signature f = g().f(str);
            if (algorithmParameterSpec != null) {
                f.setParameter(algorithmParameterSpec);
            }
            f.initVerify(publicKey);
            return new e0(f, bArr);
        } catch (GeneralSecurityException e) {
            throw new h2((short) 80, (Throwable) e);
        }
    }

    protected sdk.pendo.io.z4.e0 a(sdk.pendo.io.y4.d0 d0Var, PublicKey publicKey) {
        return a(f0.a(d0Var.a()), (AlgorithmParameterSpec) null, d0Var.b(), publicKey);
    }

    protected sdk.pendo.io.z4.d0 a(String str, AlgorithmParameterSpec algorithmParameterSpec, PrivateKey privateKey, boolean z, PublicKey publicKey) {
        try {
            Signature f = g().f(str);
            Signature f2 = g().f(str);
            if (algorithmParameterSpec != null) {
                f.setParameter(algorithmParameterSpec);
                f2.setParameter(algorithmParameterSpec);
            }
            f.initSign(privateKey, z ? h() : null);
            f2.initVerify(publicKey);
            return new g0(f, f2);
        } catch (GeneralSecurityException e) {
            throw new h2((short) 80, (Throwable) e);
        }
    }

    protected sdk.pendo.io.z4.d0 a(i1 i1Var, PrivateKey privateKey, boolean z, PublicKey publicKey) {
        return a(f0.a(i1Var), null, privateKey, z, publicKey);
    }

    @Override // sdk.pendo.io.z4.h
    public sdk.pendo.io.z4.b0 a(sdk.pendo.io.y4.v0 v0Var) {
        byte[] bArr = new byte[48];
        h().nextBytes(bArr);
        l3.a(v0Var, bArr, 0);
        return d(bArr);
    }

    @Override // sdk.pendo.io.z4.h
    public boolean a(int i) {
        Integer b = sdk.pendo.io.d5.d.b(i);
        synchronized (this.d) {
            Boolean bool = (Boolean) this.d.get(b);
            if (bool != null) {
                return bool.booleanValue();
            }
            Boolean n = n(i);
            if (n == null) {
                return false;
            }
            synchronized (this.d) {
                Boolean bool2 = (Boolean) this.d.put(b, n);
                if (bool2 != null && n != bool2) {
                    this.d.put(b, bool2);
                    n = bool2;
                }
            }
            return n.booleanValue();
        }
    }

    @Override // sdk.pendo.io.z4.h
    public boolean a() {
        Boolean bool;
        synchronized (this.f) {
            Boolean bool2 = (Boolean) this.f.get("KE_RSA");
            if (bool2 != null) {
                return bool2.booleanValue();
            }
            try {
                f();
                bool = Boolean.TRUE;
            } catch (GeneralSecurityException unused) {
                bool = Boolean.FALSE;
            }
            synchronized (this.f) {
                Boolean bool3 = (Boolean) this.f.put("KE_RSA", bool);
                if (bool3 != null && bool != bool3) {
                    this.f.put("KE_RSA", bool3);
                    bool = bool3;
                }
            }
            return bool.booleanValue();
        }
    }

    protected boolean a(String str, int i) {
        try {
            this.f907a.d(str);
            return Cipher.getMaxAllowedKeyLength(str) >= i;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
