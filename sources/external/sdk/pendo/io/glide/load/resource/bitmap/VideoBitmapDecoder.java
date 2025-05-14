package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import external.sdk.pendo.io.glide.load.resource.bitmap.VideoDecoder;

@Deprecated
/* loaded from: classes2.dex */
public class VideoBitmapDecoder extends VideoDecoder<ParcelFileDescriptor> {
    public VideoBitmapDecoder(Context context) {
        this(external.sdk.pendo.io.glide.a.a(context).c());
    }

    public VideoBitmapDecoder(sdk.pendo.io.u.b bVar) {
        super(bVar, new VideoDecoder.g());
    }
}
