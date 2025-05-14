package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import external.sdk.pendo.io.glide.load.Options;
import java.nio.ByteBuffer;
import sdk.pendo.io.q.i;

/* loaded from: classes2.dex */
public class ByteBufferBitmapDecoder implements i<ByteBuffer, Bitmap> {
    private final b downsampler;

    public ByteBufferBitmapDecoder(b bVar) {
        this.downsampler = bVar;
    }

    @Override // sdk.pendo.io.q.i
    public sdk.pendo.io.t.c<Bitmap> decode(ByteBuffer byteBuffer, int i, int i2, Options options) {
        return this.downsampler.a(sdk.pendo.io.i0.a.c(byteBuffer), i, i2, options);
    }

    @Override // sdk.pendo.io.q.i
    public boolean handles(ByteBuffer byteBuffer, Options options) {
        return this.downsampler.a(byteBuffer);
    }
}
