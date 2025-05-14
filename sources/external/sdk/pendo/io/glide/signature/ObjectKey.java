package external.sdk.pendo.io.glide.signature;

import java.security.MessageDigest;
import sdk.pendo.io.i0.j;
import sdk.pendo.io.q.f;

/* loaded from: classes2.dex */
public final class ObjectKey implements f {
    private final Object object;

    public ObjectKey(Object obj) {
        this.object = j.a(obj);
    }

    @Override // sdk.pendo.io.q.f
    public boolean equals(Object obj) {
        if (obj instanceof ObjectKey) {
            return this.object.equals(((ObjectKey) obj).object);
        }
        return false;
    }

    @Override // sdk.pendo.io.q.f
    public int hashCode() {
        return this.object.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.object + '}';
    }

    @Override // sdk.pendo.io.q.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(this.object.toString().getBytes(f.f1506a));
    }
}
