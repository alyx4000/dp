package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.security.MessageDigest;
import sdk.pendo.io.q.f;

/* loaded from: classes2.dex */
public class CircleCrop extends BitmapTransformation {
    private static final String ID = "external.sdk.pendo.io.glide.load.resource.bitmap.CircleCrop.1";
    private static final byte[] ID_BYTES = ID.getBytes(f.f1506a);
    private static final int VERSION = 1;

    @Override // sdk.pendo.io.q.f
    public boolean equals(Object obj) {
        return obj instanceof CircleCrop;
    }

    @Override // sdk.pendo.io.q.f
    public int hashCode() {
        return 1909665626;
    }

    @Override // external.sdk.pendo.io.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(sdk.pendo.io.u.b bVar, Bitmap bitmap, int i, int i2) {
        return sdk.pendo.io.y.b.c(bVar, bitmap, i, i2);
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation, sdk.pendo.io.q.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
