package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import sdk.pendo.io.i0.j;
import sdk.pendo.io.i0.k;
import sdk.pendo.io.q.f;

/* loaded from: classes2.dex */
public final class RoundedCorners extends BitmapTransformation {
    private static final String ID = "external.sdk.pendo.io.glide.load.resource.bitmap.RoundedCorners";
    private static final byte[] ID_BYTES = ID.getBytes(f.f1506a);
    private final int roundingRadius;

    public RoundedCorners(int i) {
        j.a(i > 0, "roundingRadius must be greater than 0.");
        this.roundingRadius = i;
    }

    @Override // sdk.pendo.io.q.f
    public boolean equals(Object obj) {
        return (obj instanceof RoundedCorners) && this.roundingRadius == ((RoundedCorners) obj).roundingRadius;
    }

    @Override // sdk.pendo.io.q.f
    public int hashCode() {
        return k.a(-1519465048, k.b(this.roundingRadius));
    }

    @Override // external.sdk.pendo.io.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(sdk.pendo.io.u.b bVar, Bitmap bitmap, int i, int i2) {
        return sdk.pendo.io.y.b.b(bVar, bitmap, this.roundingRadius);
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation, sdk.pendo.io.q.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.roundingRadius).array());
    }
}
