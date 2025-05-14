package sdk.pendo.io.b1;

import expo.modules.securestore.encryptors.AESEncryptor;
import io.sentry.protocol.ViewHierarchyNode;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes6.dex */
public class c extends sdk.pendo.io.a1.f implements p {
    private s f;
    private int g;

    public static class a extends c {
        public a() {
            super("A128GCMKW", sdk.pendo.io.k1.a.b(128));
        }
    }

    public static class b extends c {
        public b() {
            super("A192GCMKW", sdk.pendo.io.k1.a.b(192));
        }
    }

    /* renamed from: sdk.pendo.io.b1.c$c, reason: collision with other inner class name */
    public static class C0090c extends c {
        public C0090c() {
            super("A256GCMKW", sdk.pendo.io.k1.a.b(256));
        }
    }

    public c(String str, int i) {
        a(str);
        b(AESEncryptor.AES_CIPHER);
        a(sdk.pendo.io.i1.h.SYMMETRIC);
        c("oct");
        this.f = new s(e(), 16);
        this.g = i;
    }

    @Override // sdk.pendo.io.b1.p
    public Key a(sdk.pendo.io.a1.g gVar, byte[] bArr, i iVar, sdk.pendo.io.h1.b bVar, sdk.pendo.io.w0.a aVar) {
        return new SecretKeySpec(this.f.a(bArr, new sdk.pendo.io.u0.b().a(bVar.c(ViewHierarchyNode.JsonKeys.TAG)), (byte[]) null, gVar.a()), iVar.a());
    }

    void b(Key key) {
        sdk.pendo.io.h1.d.a(key, c(), this.g);
    }

    @Override // sdk.pendo.io.a1.a
    public boolean d() {
        return this.f.a(this.f841a, this.g, 12, c());
    }

    @Override // sdk.pendo.io.b1.p
    public sdk.pendo.io.a1.g a(Key key, sdk.pendo.io.h1.b bVar, sdk.pendo.io.w0.a aVar) {
        return new sdk.pendo.io.a1.g(this.f.a(key, new sdk.pendo.io.u0.b().a(bVar.c(AESEncryptor.IV_PROPERTY)), 2, aVar.c().a()));
    }

    @Override // sdk.pendo.io.b1.p
    public void a(Key key, g gVar) {
        b(key);
    }
}
