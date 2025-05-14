package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import external.sdk.pendo.io.glide.load.Transformation;
import java.security.MessageDigest;
import sdk.pendo.io.i0.j;

@Deprecated
/* loaded from: classes2.dex */
public class BitmapDrawableTransformation implements Transformation<BitmapDrawable> {
    private final Transformation<Drawable> wrapped;

    public BitmapDrawableTransformation(Transformation<Bitmap> transformation) {
        this.wrapped = (Transformation) j.a(new DrawableTransformation(transformation, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static sdk.pendo.io.t.c<BitmapDrawable> convertToBitmapDrawableResource(sdk.pendo.io.t.c<Drawable> cVar) {
        if (cVar.get() instanceof BitmapDrawable) {
            return cVar;
        }
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + cVar.get());
    }

    private static sdk.pendo.io.t.c<Drawable> convertToDrawableResource(sdk.pendo.io.t.c<BitmapDrawable> cVar) {
        return cVar;
    }

    @Override // sdk.pendo.io.q.f
    public boolean equals(Object obj) {
        if (obj instanceof BitmapDrawableTransformation) {
            return this.wrapped.equals(((BitmapDrawableTransformation) obj).wrapped);
        }
        return false;
    }

    @Override // sdk.pendo.io.q.f
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation
    public sdk.pendo.io.t.c<BitmapDrawable> transform(Context context, sdk.pendo.io.t.c<BitmapDrawable> cVar, int i, int i2) {
        return convertToBitmapDrawableResource(this.wrapped.transform(context, convertToDrawableResource(cVar), i, i2));
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation, sdk.pendo.io.q.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.wrapped.updateDiskCacheKey(messageDigest);
    }
}
