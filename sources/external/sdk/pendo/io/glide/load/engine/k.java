package external.sdk.pendo.io.glide.load.engine;

import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.Transformation;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: classes2.dex */
class k implements sdk.pendo.io.q.f {
    private final Object b;
    private final int c;
    private final int d;
    private final Class<?> e;
    private final Class<?> f;
    private final sdk.pendo.io.q.f g;
    private final Map<Class<?>, Transformation<?>> h;
    private final Options i;
    private int j;

    k(Object obj, sdk.pendo.io.q.f fVar, int i, int i2, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options) {
        this.b = sdk.pendo.io.i0.j.a(obj);
        this.g = (sdk.pendo.io.q.f) sdk.pendo.io.i0.j.a(fVar, "Signature must not be null");
        this.c = i;
        this.d = i2;
        this.h = (Map) sdk.pendo.io.i0.j.a(map);
        this.e = (Class) sdk.pendo.io.i0.j.a(cls, "Resource class must not be null");
        this.f = (Class) sdk.pendo.io.i0.j.a(cls2, "Transcode class must not be null");
        this.i = (Options) sdk.pendo.io.i0.j.a(options);
    }

    @Override // sdk.pendo.io.q.f
    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.b.equals(kVar.b) && this.g.equals(kVar.g) && this.d == kVar.d && this.c == kVar.c && this.h.equals(kVar.h) && this.e.equals(kVar.e) && this.f.equals(kVar.f) && this.i.equals(kVar.i);
    }

    @Override // sdk.pendo.io.q.f
    public int hashCode() {
        if (this.j == 0) {
            int hashCode = this.b.hashCode();
            this.j = hashCode;
            int hashCode2 = (((((hashCode * 31) + this.g.hashCode()) * 31) + this.c) * 31) + this.d;
            this.j = hashCode2;
            int hashCode3 = (hashCode2 * 31) + this.h.hashCode();
            this.j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.e.hashCode();
            this.j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f.hashCode();
            this.j = hashCode5;
            this.j = (hashCode5 * 31) + this.i.hashCode();
        }
        return this.j;
    }

    public String toString() {
        return "EngineKey{model=" + this.b + ", width=" + this.c + ", height=" + this.d + ", resourceClass=" + this.e + ", transcodeClass=" + this.f + ", signature=" + this.g + ", hashCode=" + this.j + ", transformations=" + this.h + ", options=" + this.i + '}';
    }

    @Override // sdk.pendo.io.q.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
