package external.sdk.pendo.io.glide.load;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import java.security.MessageDigest;
import sdk.pendo.io.i0.b;
import sdk.pendo.io.q.f;
import sdk.pendo.io.q.g;

/* loaded from: classes2.dex */
public final class Options implements f {
    private final ArrayMap<g<?>, Object> values = new b();

    @Override // sdk.pendo.io.q.f
    public boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.values.equals(((Options) obj).values);
        }
        return false;
    }

    public <T> T get(g<T> gVar) {
        return this.values.containsKey(gVar) ? (T) this.values.get(gVar) : gVar.b();
    }

    @Override // sdk.pendo.io.q.f
    public int hashCode() {
        return this.values.hashCode();
    }

    public void putAll(Options options) {
        this.values.putAll((SimpleArrayMap<? extends g<?>, ? extends Object>) options.values);
    }

    public <T> Options set(g<T> gVar, T t) {
        this.values.put(gVar, t);
        return this;
    }

    public String toString() {
        return "Options{values=" + this.values + '}';
    }

    @Override // sdk.pendo.io.q.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        for (int i = 0; i < this.values.size(); i++) {
            updateDiskCacheKey(this.values.keyAt(i), this.values.valueAt(i), messageDigest);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void updateDiskCacheKey(g<T> gVar, Object obj, MessageDigest messageDigest) {
        gVar.a((g<T>) obj, messageDigest);
    }
}
