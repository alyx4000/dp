package sdk.pendo.io.b1;

import java.security.Key;
import sdk.pendo.io.b1.d;

/* loaded from: classes6.dex */
public class n extends sdk.pendo.io.a1.f implements p {
    private d f;
    private i g;
    private m h;

    public static class a extends n {
        public a() {
            super("ECDH-ES+A128KW", new d.a().g());
        }
    }

    public static class b extends n {
        public b() {
            super("ECDH-ES+A192KW", new d.b().g());
        }
    }

    public static class c extends n {
        public c() {
            super("ECDH-ES+A256KW", new d.c().g());
        }
    }

    public n(String str, d dVar) {
        a(str);
        b("N/A");
        c("EC");
        a(sdk.pendo.io.i1.h.ASYMMETRIC);
        this.f = dVar;
        this.h = new m("alg");
        this.g = new i(dVar.f(), "AES");
    }

    @Override // sdk.pendo.io.b1.p
    public Key a(sdk.pendo.io.a1.g gVar, byte[] bArr, i iVar, sdk.pendo.io.h1.b bVar, sdk.pendo.io.w0.a aVar) {
        return this.f.a(this.f.a(this.h.a(gVar, sdk.pendo.io.k1.a.f1251a, this.g, bVar, aVar), bVar, aVar), bArr, iVar, bVar, aVar);
    }

    @Override // sdk.pendo.io.a1.a
    public boolean d() {
        return this.h.d() && this.f.d();
    }

    @Override // sdk.pendo.io.b1.p
    public sdk.pendo.io.a1.g a(Key key, sdk.pendo.io.h1.b bVar, sdk.pendo.io.w0.a aVar) {
        return this.h.a(key, bVar, aVar);
    }

    @Override // sdk.pendo.io.b1.p
    public void a(Key key, g gVar) {
        this.h.a(key, gVar);
    }
}
