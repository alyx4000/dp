package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.security.MessageDigest;
import sdk.pendo.io.q.f;

/* loaded from: classes2.dex */
public class FitCenter extends BitmapTransformation {
    private static final String ID = "external.sdk.pendo.io.glide.load.resource.bitmap.FitCenter";
    private static final byte[] ID_BYTES = ID.getBytes(f.f1506a);

    @Override // sdk.pendo.io.q.f
    public boolean equals(Object obj) {
        return obj instanceof FitCenter;
    }

    @Override // sdk.pendo.io.q.f
    public int hashCode() {
        return 1450097935;
    }

    @Override // external.sdk.pendo.io.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(sdk.pendo.io.u.b bVar, Bitmap bitmap, int i, int i2) {
        return sdk.pendo.io.y.b.d(bVar, bitmap, i, i2);
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation, sdk.pendo.io.q.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
