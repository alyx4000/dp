package external.sdk.pendo.io.glide.load.engine;

import java.security.MessageDigest;

/* loaded from: classes2.dex */
final class c implements sdk.pendo.io.q.f {
    private final sdk.pendo.io.q.f b;
    private final sdk.pendo.io.q.f c;

    c(sdk.pendo.io.q.f fVar, sdk.pendo.io.q.f fVar2) {
        this.b = fVar;
        this.c = fVar2;
    }

    @Override // sdk.pendo.io.q.f
    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.b.equals(cVar.b) && this.c.equals(cVar.c);
    }

    @Override // sdk.pendo.io.q.f
    public int hashCode() {
        return (this.b.hashCode() * 31) + this.c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.b + ", signature=" + this.c + '}';
    }

    @Override // sdk.pendo.io.q.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.b.updateDiskCacheKey(messageDigest);
        this.c.updateDiskCacheKey(messageDigest);
    }
}
