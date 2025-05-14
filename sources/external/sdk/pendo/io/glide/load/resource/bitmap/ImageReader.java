package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import external.sdk.pendo.io.glide.load.ImageHeaderParser;
import external.sdk.pendo.io.glide.load.data.InputStreamRewinder;
import external.sdk.pendo.io.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.InputStream;
import java.util.List;
import sdk.pendo.io.i0.j;

/* loaded from: classes2.dex */
interface ImageReader {

    public static final class InputStreamImageReader implements ImageReader {
        private final sdk.pendo.io.u.a byteArrayPool;
        private final InputStreamRewinder dataRewinder;
        private final List<ImageHeaderParser> parsers;

        InputStreamImageReader(InputStream inputStream, List<ImageHeaderParser> list, sdk.pendo.io.u.a aVar) {
            this.byteArrayPool = (sdk.pendo.io.u.a) j.a(aVar);
            this.parsers = (List) j.a(list);
            this.dataRewinder = new InputStreamRewinder(inputStream, aVar);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(this.dataRewinder.rewindAndGet(), null, options);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() {
            return external.sdk.pendo.io.glide.load.a.a(this.parsers, this.dataRewinder.rewindAndGet(), this.byteArrayPool);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType getImageType() {
            return external.sdk.pendo.io.glide.load.a.b(this.parsers, this.dataRewinder.rewindAndGet(), this.byteArrayPool);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
            this.dataRewinder.fixMarkLimits();
        }
    }

    public static final class ParcelFileDescriptorImageReader implements ImageReader {
        private final sdk.pendo.io.u.a byteArrayPool;
        private final ParcelFileDescriptorRewinder dataRewinder;
        private final List<ImageHeaderParser> parsers;

        ParcelFileDescriptorImageReader(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, sdk.pendo.io.u.a aVar) {
            this.byteArrayPool = (sdk.pendo.io.u.a) j.a(aVar);
            this.parsers = (List) j.a(list);
            this.dataRewinder = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options options) {
            return BitmapFactory.decodeFileDescriptor(this.dataRewinder.rewindAndGet().getFileDescriptor(), null, options);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() {
            return external.sdk.pendo.io.glide.load.a.a(this.parsers, this.dataRewinder, this.byteArrayPool);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType getImageType() {
            return external.sdk.pendo.io.glide.load.a.b(this.parsers, this.dataRewinder, this.byteArrayPool);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }
    }

    Bitmap decodeBitmap(BitmapFactory.Options options);

    int getImageOrientation();

    ImageHeaderParser.ImageType getImageType();

    void stopGrowingBuffers();
}
