package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import external.sdk.pendo.io.glide.load.Options;
import sdk.pendo.io.q.i;

/* loaded from: classes2.dex */
public final class ParcelFileDescriptorBitmapDecoder implements i<ParcelFileDescriptor, Bitmap> {
    private final b downsampler;

    public ParcelFileDescriptorBitmapDecoder(b bVar) {
        this.downsampler = bVar;
    }

    @Override // sdk.pendo.io.q.i
    public sdk.pendo.io.t.c<Bitmap> decode(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, Options options) {
        return this.downsampler.a(parcelFileDescriptor, i, i2, options);
    }

    @Override // sdk.pendo.io.q.i
    public boolean handles(ParcelFileDescriptor parcelFileDescriptor, Options options) {
        return this.downsampler.a(parcelFileDescriptor);
    }
}
