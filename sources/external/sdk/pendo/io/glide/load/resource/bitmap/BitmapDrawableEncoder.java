package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.ResourceEncoder;
import java.io.File;

/* loaded from: classes2.dex */
public class BitmapDrawableEncoder implements ResourceEncoder<BitmapDrawable> {
    private final sdk.pendo.io.u.b bitmapPool;
    private final ResourceEncoder<Bitmap> encoder;

    public BitmapDrawableEncoder(sdk.pendo.io.u.b bVar, ResourceEncoder<Bitmap> resourceEncoder) {
        this.bitmapPool = bVar;
        this.encoder = resourceEncoder;
    }

    @Override // external.sdk.pendo.io.glide.load.ResourceEncoder
    public sdk.pendo.io.q.c getEncodeStrategy(Options options) {
        return this.encoder.getEncodeStrategy(options);
    }

    @Override // external.sdk.pendo.io.glide.load.ResourceEncoder, sdk.pendo.io.q.d
    public boolean encode(sdk.pendo.io.t.c<BitmapDrawable> cVar, File file, Options options) {
        return this.encoder.encode(new BitmapResource(cVar.get().getBitmap(), this.bitmapPool), file, options);
    }
}
