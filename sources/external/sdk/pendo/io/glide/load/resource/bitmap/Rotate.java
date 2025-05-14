package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import sdk.pendo.io.i0.k;
import sdk.pendo.io.q.f;

/* loaded from: classes2.dex */
public class Rotate extends BitmapTransformation {
    private static final String ID = "external.sdk.pendo.io.glide.load.resource.bitmap.Rotate";
    private static final byte[] ID_BYTES = ID.getBytes(f.f1506a);
    private final int degreesToRotate;

    public Rotate(int i) {
        this.degreesToRotate = i;
    }

    @Override // sdk.pendo.io.q.f
    public boolean equals(Object obj) {
        return (obj instanceof Rotate) && this.degreesToRotate == ((Rotate) obj).degreesToRotate;
    }

    @Override // sdk.pendo.io.q.f
    public int hashCode() {
        return k.a(34013362, k.b(this.degreesToRotate));
    }

    @Override // external.sdk.pendo.io.glide.load.resource.bitmap.BitmapTransformation
    protected Bitmap transform(sdk.pendo.io.u.b bVar, Bitmap bitmap, int i, int i2) {
        return sdk.pendo.io.y.b.a(bitmap, this.degreesToRotate);
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation, sdk.pendo.io.q.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.degreesToRotate).array());
    }
}
