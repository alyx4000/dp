package external.sdk.pendo.io.glide.load.resource.gif;

import android.graphics.Bitmap;
import external.sdk.pendo.io.glide.gifdecoder.a;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.resource.bitmap.BitmapResource;
import sdk.pendo.io.q.i;
import sdk.pendo.io.t.c;
import sdk.pendo.io.u.b;

/* loaded from: classes2.dex */
public final class GifFrameResourceDecoder implements i<a, Bitmap> {
    private final b bitmapPool;

    public GifFrameResourceDecoder(b bVar) {
        this.bitmapPool = bVar;
    }

    @Override // sdk.pendo.io.q.i
    public c<Bitmap> decode(a aVar, int i, int i2, Options options) {
        return BitmapResource.obtain(aVar.getNextFrame(), this.bitmapPool);
    }

    @Override // sdk.pendo.io.q.i
    public boolean handles(a aVar, Options options) {
        return true;
    }
}
