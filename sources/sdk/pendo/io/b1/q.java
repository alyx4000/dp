package sdk.pendo.io.b1;

import android.support.v4.media.session.PlaybackStateCompat;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import sdk.pendo.io.b1.d;

/* loaded from: classes6.dex */
public class q extends sdk.pendo.io.a1.f implements p {
    private static final byte[] k = {0};
    private d f;
    private i g;
    private sdk.pendo.io.c1.e h;
    private long i = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
    private int j = 12;

    public static class a extends q {
        public a() {
            super("PBES2-HS256+A128KW", "HmacSHA256", new d.a().g());
        }
    }

    public static class b extends q {
        public b() {
            super("PBES2-HS384+A192KW", "HmacSHA384", new d.b().g());
        }
    }

    public static class c extends q {
        public c() {
            super("PBES2-HS512+A256KW", "HmacSHA512", new d.c().g());
        }
    }

    public q(String str, String str2, d dVar) {
        a(str);
        b("n/a");
        this.h = new sdk.pendo.io.c1.e(str2);
        a(sdk.pendo.io.i1.h.SYMMETRIC);
        c("PBKDF2");
        this.f = dVar;
        this.g = new i(dVar.f(), "AES");
    }

    private Key a(Key key, Long l, byte[] bArr, sdk.pendo.io.w0.a aVar) {
        return new SecretKeySpec(this.h.a(key.getEncoded(), sdk.pendo.io.k1.a.a(sdk.pendo.io.k1.j.b(c()), k, bArr), l.intValue(), this.g.b(), aVar.c().e()), this.g.a());
    }

    public void b(Key key) {
        sdk.pendo.io.h1.d.b(key);
    }

    @Override // sdk.pendo.io.a1.a
    public boolean d() {
        return this.f.d();
    }

    @Override // sdk.pendo.io.b1.p
    public Key a(sdk.pendo.io.a1.g gVar, byte[] bArr, i iVar, sdk.pendo.io.h1.b bVar, sdk.pendo.io.w0.a aVar) {
        return this.f.a(this.f.a(gVar.b(), bVar, aVar), bArr, iVar, bVar, aVar);
    }

    @Override // sdk.pendo.io.b1.p
    public sdk.pendo.io.a1.g a(Key key, sdk.pendo.io.h1.b bVar, sdk.pendo.io.w0.a aVar) {
        return new sdk.pendo.io.a1.g(a(key, bVar.a("p2c"), new sdk.pendo.io.u0.b().a(bVar.c("p2s")), aVar));
    }

    @Override // sdk.pendo.io.b1.p
    public void a(Key key, g gVar) {
        b(key);
    }
}
