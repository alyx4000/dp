package sdk.pendo.io.v;

import androidx.core.util.Pools;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sdk.pendo.io.i0.g;
import sdk.pendo.io.i0.j;
import sdk.pendo.io.i0.k;
import sdk.pendo.io.j0.a;
import sdk.pendo.io.j0.c;
import sdk.pendo.io.q.f;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final g<f, String> f1648a = new g<>(1000);
    private final Pools.Pool<C0246b> b = sdk.pendo.io.j0.a.a(10, new a());

    class a implements a.d<C0246b> {
        a() {
        }

        @Override // sdk.pendo.io.j0.a.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0246b a() {
            try {
                return new C0246b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: sdk.pendo.io.v.b$b, reason: collision with other inner class name */
    private static final class C0246b implements a.f {
        final MessageDigest f;
        private final c s = c.a();

        C0246b(MessageDigest messageDigest) {
            this.f = messageDigest;
        }

        @Override // sdk.pendo.io.j0.a.f
        public c b() {
            return this.s;
        }
    }

    private String a(f fVar) {
        C0246b c0246b = (C0246b) j.a(this.b.acquire());
        try {
            fVar.updateDiskCacheKey(c0246b.f);
            return k.a(c0246b.f.digest());
        } finally {
            this.b.release(c0246b);
        }
    }

    public String b(f fVar) {
        String str;
        synchronized (this.f1648a) {
            str = this.f1648a.get(fVar);
        }
        if (str == null) {
            str = a(fVar);
        }
        synchronized (this.f1648a) {
            this.f1648a.put(fVar, str);
        }
        return str;
    }
}
