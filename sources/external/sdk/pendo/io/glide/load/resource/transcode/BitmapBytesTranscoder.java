package external.sdk.pendo.io.glide.load.resource.transcode;

import android.graphics.Bitmap;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.resource.bytes.BytesResource;
import java.io.ByteArrayOutputStream;
import sdk.pendo.io.b0.a;
import sdk.pendo.io.t.c;

/* loaded from: classes2.dex */
public class BitmapBytesTranscoder implements a<Bitmap, byte[]> {
    private final Bitmap.CompressFormat compressFormat;
    private final int quality;

    public BitmapBytesTranscoder() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // sdk.pendo.io.b0.a
    public c<byte[]> transcode(c<Bitmap> cVar, Options options) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        cVar.get().compress(this.compressFormat, this.quality, byteArrayOutputStream);
        cVar.recycle();
        return new BytesResource(byteArrayOutputStream.toByteArray());
    }

    public BitmapBytesTranscoder(Bitmap.CompressFormat compressFormat, int i) {
        this.compressFormat = compressFormat;
        this.quality = i;
    }
}
