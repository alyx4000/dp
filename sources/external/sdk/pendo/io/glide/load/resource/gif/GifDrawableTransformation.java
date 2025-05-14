package external.sdk.pendo.io.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import external.sdk.pendo.io.glide.a;
import external.sdk.pendo.io.glide.load.Transformation;
import external.sdk.pendo.io.glide.load.resource.bitmap.BitmapResource;
import java.security.MessageDigest;
import sdk.pendo.io.i0.j;
import sdk.pendo.io.t.c;

/* loaded from: classes2.dex */
public class GifDrawableTransformation implements Transformation<GifDrawable> {
    private final Transformation<Bitmap> wrapped;

    public GifDrawableTransformation(Transformation<Bitmap> transformation) {
        this.wrapped = (Transformation) j.a(transformation);
    }

    @Override // sdk.pendo.io.q.f
    public boolean equals(Object obj) {
        if (obj instanceof GifDrawableTransformation) {
            return this.wrapped.equals(((GifDrawableTransformation) obj).wrapped);
        }
        return false;
    }

    @Override // sdk.pendo.io.q.f
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation
    public c<GifDrawable> transform(Context context, c<GifDrawable> cVar, int i, int i2) {
        GifDrawable gifDrawable = cVar.get();
        c<Bitmap> bitmapResource = new BitmapResource(gifDrawable.getFirstFrame(), a.a(context).c());
        c<Bitmap> transform = this.wrapped.transform(context, bitmapResource, i, i2);
        if (!bitmapResource.equals(transform)) {
            bitmapResource.recycle();
        }
        gifDrawable.setFrameTransformation(this.wrapped, transform.get());
        return cVar;
    }

    @Override // external.sdk.pendo.io.glide.load.Transformation, sdk.pendo.io.q.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.wrapped.updateDiskCacheKey(messageDigest);
    }
}
