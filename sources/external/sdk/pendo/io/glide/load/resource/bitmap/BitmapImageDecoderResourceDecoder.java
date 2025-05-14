package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import external.sdk.pendo.io.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import external.sdk.pendo.io.glide.load.resource.ImageDecoderResourceDecoder;
import io.sentry.protocol.ViewHierarchyNode;

/* loaded from: classes2.dex */
public final class BitmapImageDecoderResourceDecoder extends ImageDecoderResourceDecoder<Bitmap> {
    private static final String TAG = "BitmapImageDecoder";
    private final sdk.pendo.io.u.b bitmapPool = new BitmapPoolAdapter();

    @Override // external.sdk.pendo.io.glide.load.resource.ImageDecoderResourceDecoder
    protected sdk.pendo.io.t.c<Bitmap> decode(ImageDecoder.Source source, int i, int i2, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) {
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "Decoded [" + decodeBitmap.getWidth() + ViewHierarchyNode.JsonKeys.X + decodeBitmap.getHeight() + "] for [" + i + ViewHierarchyNode.JsonKeys.X + i2 + "]");
        }
        return new BitmapResource(decodeBitmap, this.bitmapPool);
    }
}
