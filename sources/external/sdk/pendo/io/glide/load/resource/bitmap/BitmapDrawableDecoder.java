package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import external.sdk.pendo.io.glide.load.Options;
import sdk.pendo.io.i0.j;
import sdk.pendo.io.q.i;

/* loaded from: classes2.dex */
public class BitmapDrawableDecoder<DataType> implements i<DataType, BitmapDrawable> {
    private final i<DataType, Bitmap> decoder;
    private final Resources resources;

    public BitmapDrawableDecoder(Context context, i<DataType, Bitmap> iVar) {
        this(context.getResources(), iVar);
    }

    @Override // sdk.pendo.io.q.i
    public sdk.pendo.io.t.c<BitmapDrawable> decode(DataType datatype, int i, int i2, Options options) {
        return LazyBitmapDrawableResource.obtain(this.resources, this.decoder.decode(datatype, i, i2, options));
    }

    @Override // sdk.pendo.io.q.i
    public boolean handles(DataType datatype, Options options) {
        return this.decoder.handles(datatype, options);
    }

    public BitmapDrawableDecoder(Resources resources, i<DataType, Bitmap> iVar) {
        this.resources = (Resources) j.a(resources);
        this.decoder = (i) j.a(iVar);
    }

    @Deprecated
    public BitmapDrawableDecoder(Resources resources, sdk.pendo.io.u.b bVar, i<DataType, Bitmap> iVar) {
        this(resources, iVar);
    }
}
