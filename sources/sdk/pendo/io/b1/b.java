package sdk.pendo.io.b1;

import expo.modules.securestore.encryptors.AESEncryptor;

/* loaded from: classes6.dex */
public class b extends sdk.pendo.io.a1.f implements g {
    private i f;
    private s g;

    public static class a extends b {
        public a() {
            super("A128GCM", 128);
        }
    }

    /* renamed from: sdk.pendo.io.b1.b$b, reason: collision with other inner class name */
    public static class C0089b extends b {
        public C0089b() {
            super("A192GCM", 192);
        }
    }

    public static class c extends b {
        public c() {
            super("A256GCM", 256);
        }
    }

    public b(String str, int i) {
        a(str);
        b(AESEncryptor.AES_CIPHER);
        a(sdk.pendo.io.i1.h.SYMMETRIC);
        c("AES");
        this.f = new i(sdk.pendo.io.k1.a.b(i), "AES");
        this.g = new s(e(), 16);
    }

    @Override // sdk.pendo.io.b1.g
    public byte[] a(k kVar, byte[] bArr, byte[] bArr2, sdk.pendo.io.h1.b bVar, sdk.pendo.io.w0.a aVar) {
        byte[] c2 = kVar.c();
        return this.g.a(new sdk.pendo.io.i1.a(bArr2), c2, kVar.b(), kVar.a(), bArr, h.b(bVar, aVar));
    }

    @Override // sdk.pendo.io.b1.g
    public i b() {
        return this.f;
    }

    @Override // sdk.pendo.io.a1.a
    public boolean d() {
        return this.g.a(this.f841a, b().b(), 12, c());
    }
}
