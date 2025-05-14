package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import external.sdk.pendo.io.glide.load.Options;
import java.io.InputStream;
import sdk.pendo.io.q.i;

/* loaded from: classes2.dex */
public final class InputStreamBitmapImageDecoderResourceDecoder implements i<InputStream, Bitmap> {
    private final BitmapImageDecoderResourceDecoder wrapped = new BitmapImageDecoderResourceDecoder();

    @Override // sdk.pendo.io.q.i
    public sdk.pendo.io.t.c<Bitmap> decode(InputStream inputStream, int i, int i2, Options options) {
        return this.wrapped.decode(ImageDecoder.createSource(sdk.pendo.io.i0.a.a(inputStream)), i, i2, options);
    }

    @Override // sdk.pendo.io.q.i
    public boolean handles(InputStream inputStream, Options options) {
        return true;
    }
}
