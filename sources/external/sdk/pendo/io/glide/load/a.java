package external.sdk.pendo.io.glide.load;

import external.sdk.pendo.io.glide.load.ImageHeaderParser;
import external.sdk.pendo.io.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: external.sdk.pendo.io.glide.load.a$a, reason: collision with other inner class name */
    class C0054a implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InputStream f631a;

        C0054a(InputStream inputStream) {
            this.f631a = inputStream;
        }

        @Override // external.sdk.pendo.io.glide.load.a.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.getType(this.f631a);
            } finally {
                this.f631a.reset();
            }
        }
    }

    class b implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ByteBuffer f632a;

        b(ByteBuffer byteBuffer) {
            this.f632a = byteBuffer;
        }

        @Override // external.sdk.pendo.io.glide.load.a.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
            return imageHeaderParser.getType(this.f632a);
        }
    }

    class c implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ParcelFileDescriptorRewinder f633a;
        final /* synthetic */ sdk.pendo.io.u.a b;

        c(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, sdk.pendo.io.u.a aVar) {
            this.f633a = parcelFileDescriptorRewinder;
            this.b = aVar;
        }

        @Override // external.sdk.pendo.io.glide.load.a.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
            sdk.pendo.io.y.a aVar;
            try {
                aVar = new sdk.pendo.io.y.a(new FileInputStream(this.f633a.rewindAndGet().getFileDescriptor()), this.b);
            } catch (Throwable th) {
                th = th;
                aVar = null;
            }
            try {
                ImageHeaderParser.ImageType type = imageHeaderParser.getType(aVar);
                try {
                    aVar.close();
                } catch (IOException unused) {
                }
                this.f633a.rewindAndGet();
                return type;
            } catch (Throwable th2) {
                th = th2;
                if (aVar != null) {
                    try {
                        aVar.close();
                    } catch (IOException unused2) {
                    }
                }
                this.f633a.rewindAndGet();
                throw th;
            }
        }
    }

    class d implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InputStream f634a;
        final /* synthetic */ sdk.pendo.io.u.a b;

        d(InputStream inputStream, sdk.pendo.io.u.a aVar) {
            this.f634a = inputStream;
            this.b = aVar;
        }

        @Override // external.sdk.pendo.io.glide.load.a.f
        public int a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.getOrientation(this.f634a, this.b);
            } finally {
                this.f634a.reset();
            }
        }
    }

    class e implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ParcelFileDescriptorRewinder f635a;
        final /* synthetic */ sdk.pendo.io.u.a b;

        e(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, sdk.pendo.io.u.a aVar) {
            this.f635a = parcelFileDescriptorRewinder;
            this.b = aVar;
        }

        @Override // external.sdk.pendo.io.glide.load.a.f
        public int a(ImageHeaderParser imageHeaderParser) {
            sdk.pendo.io.y.a aVar;
            try {
                aVar = new sdk.pendo.io.y.a(new FileInputStream(this.f635a.rewindAndGet().getFileDescriptor()), this.b);
            } catch (Throwable th) {
                th = th;
                aVar = null;
            }
            try {
                int orientation = imageHeaderParser.getOrientation(aVar, this.b);
                try {
                    aVar.close();
                } catch (IOException unused) {
                }
                this.f635a.rewindAndGet();
                return orientation;
            } catch (Throwable th2) {
                th = th2;
                if (aVar != null) {
                    try {
                        aVar.close();
                    } catch (IOException unused2) {
                    }
                }
                this.f635a.rewindAndGet();
                throw th;
            }
        }
    }

    private interface f {
        int a(ImageHeaderParser imageHeaderParser);
    }

    private interface g {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser);
    }

    public static int a(List<ImageHeaderParser> list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, sdk.pendo.io.u.a aVar) {
        return a(list, new e(parcelFileDescriptorRewinder, aVar));
    }

    public static ImageHeaderParser.ImageType b(List<ImageHeaderParser> list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, sdk.pendo.io.u.a aVar) {
        return a(list, new c(parcelFileDescriptorRewinder, aVar));
    }

    public static int a(List<ImageHeaderParser> list, InputStream inputStream, sdk.pendo.io.u.a aVar) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new sdk.pendo.io.y.a(inputStream, aVar);
        }
        inputStream.mark(5242880);
        return a(list, new d(inputStream, aVar));
    }

    public static ImageHeaderParser.ImageType b(List<ImageHeaderParser> list, InputStream inputStream, sdk.pendo.io.u.a aVar) {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new sdk.pendo.io.y.a(inputStream, aVar);
        }
        inputStream.mark(5242880);
        return a(list, new C0054a(inputStream));
    }

    private static int a(List<ImageHeaderParser> list, f fVar) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int a2 = fVar.a(list.get(i));
            if (a2 != -1) {
                return a2;
            }
        }
        return -1;
    }

    public static ImageHeaderParser.ImageType a(List<ImageHeaderParser> list, ByteBuffer byteBuffer) {
        return byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : a(list, new b(byteBuffer));
    }

    private static ImageHeaderParser.ImageType a(List<ImageHeaderParser> list, g gVar) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageHeaderParser.ImageType a2 = gVar.a(list.get(i));
            if (a2 != ImageHeaderParser.ImageType.UNKNOWN) {
                return a2;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
