package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import external.sdk.pendo.io.glide.load.Transformation;
import sdk.pendo.io.i0.k;

/* loaded from: classes2.dex */
public abstract class BitmapTransformation implements Transformation<Bitmap> {
    protected abstract Bitmap transform(sdk.pendo.io.u.b bVar, Bitmap bitmap, int i, int i2);

    @Override // external.sdk.pendo.io.glide.load.Transformation
    public final sdk.pendo.io.t.c<Bitmap> transform(Context context, sdk.pendo.io.t.c<Bitmap> cVar, int i, int i2) {
        if (!k.b(i, i2)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        sdk.pendo.io.u.b c = external.sdk.pendo.io.glide.a.a(context).c();
        Bitmap bitmap = cVar.get();
        if (i == Integer.MIN_VALUE) {
            i = bitmap.getWidth();
        }
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getHeight();
        }
        Bitmap transform = transform(c, bitmap, i, i2);
        return bitmap.equals(transform) ? cVar : BitmapResource.obtain(transform, c);
    }
}
