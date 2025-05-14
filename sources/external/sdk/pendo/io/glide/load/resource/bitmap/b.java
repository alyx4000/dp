package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import external.sdk.pendo.io.glide.load.ImageHeaderParser;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.data.ParcelFileDescriptorRewinder;
import external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader;
import external.sdk.pendo.io.glide.load.resource.bitmap.a;
import io.sentry.protocol.ViewHierarchyNode;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import sdk.pendo.io.i0.f;
import sdk.pendo.io.i0.j;
import sdk.pendo.io.i0.k;
import sdk.pendo.io.q.g;
import sdk.pendo.io.q.h;

/* loaded from: classes2.dex */
public final class b {
    public static final g<sdk.pendo.io.q.b> f = g.a("external.sdk.pendo.io.glide.load.resource.bitmap.Downsampler.DecodeFormat", sdk.pendo.io.q.b.DEFAULT);
    public static final g<h> g = g.a("external.sdk.pendo.io.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", h.SRGB);

    @Deprecated
    public static final g<external.sdk.pendo.io.glide.load.resource.bitmap.a> h = external.sdk.pendo.io.glide.load.resource.bitmap.a.h;
    public static final g<Boolean> i;
    public static final g<Boolean> j;
    private static final Set<String> k;
    private static final InterfaceC0066b l;
    private static final Set<ImageHeaderParser.ImageType> m;
    private static final Queue<BitmapFactory.Options> n;

    /* renamed from: a, reason: collision with root package name */
    private final sdk.pendo.io.u.b f699a;
    private final DisplayMetrics b;
    private final sdk.pendo.io.u.a c;
    private final List<ImageHeaderParser> d;
    private final d e = d.b();

    class a implements InterfaceC0066b {
        a() {
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.b.InterfaceC0066b
        public void a() {
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.b.InterfaceC0066b
        public void a(sdk.pendo.io.u.b bVar, Bitmap bitmap) {
        }
    }

    /* renamed from: external.sdk.pendo.io.glide.load.resource.bitmap.b$b, reason: collision with other inner class name */
    public interface InterfaceC0066b {
        void a();

        void a(sdk.pendo.io.u.b bVar, Bitmap bitmap);
    }

    static {
        Boolean bool = Boolean.FALSE;
        i = g.a("external.sdk.pendo.io.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        j = g.a("external.sdk.pendo.io.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        k = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        l = new a();
        m = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        n = k.a(0);
    }

    public b(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, sdk.pendo.io.u.b bVar, sdk.pendo.io.u.a aVar) {
        this.d = list;
        this.b = (DisplayMetrics) j.a(displayMetrics);
        this.f699a = (sdk.pendo.io.u.b) j.a(bVar);
        this.c = (sdk.pendo.io.u.a) j.a(aVar);
    }

    private static int a(double d) {
        return c((d / (r1 / r0)) * c(b(d) * d));
    }

    private static boolean a(int i2) {
        return i2 == 90 || i2 == 270;
    }

    private boolean a(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    private static int b(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    private static int c(double d) {
        return (int) (d + 0.5d);
    }

    private static void c(BitmapFactory.Options options) {
        d(options);
        Queue<BitmapFactory.Options> queue = n;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void d(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.inPreferredColorSpace = null;
        options.outColorSpace = null;
        options.outConfig = null;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public boolean a(InputStream inputStream) {
        return true;
    }

    public boolean a(ByteBuffer byteBuffer) {
        return true;
    }

    private void a(ImageReader imageReader, sdk.pendo.io.q.b bVar, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        boolean z3;
        if (this.e.a(i2, i3, options, z, z2)) {
            return;
        }
        if (bVar == sdk.pendo.io.q.b.PREFER_ARGB_8888) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            z3 = imageReader.getImageType().hasAlpha();
        } catch (IOException e) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + bVar, e);
            }
            z3 = false;
        }
        Bitmap.Config config = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    private static int[] b(ImageReader imageReader, BitmapFactory.Options options, InterfaceC0066b interfaceC0066b, sdk.pendo.io.u.b bVar) {
        options.inJustDecodeBounds = true;
        a(imageReader, options, interfaceC0066b, bVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static void a(ImageHeaderParser.ImageType imageType, ImageReader imageReader, InterfaceC0066b interfaceC0066b, sdk.pendo.io.u.b bVar, external.sdk.pendo.io.glide.load.resource.bitmap.a aVar, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) {
        int i7;
        int i8;
        int floor;
        int floor2;
        if (i3 <= 0 || i4 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i5 + ViewHierarchyNode.JsonKeys.X + i6 + "]");
                return;
            }
            return;
        }
        if (a(i2)) {
            i8 = i3;
            i7 = i4;
        } else {
            i7 = i3;
            i8 = i4;
        }
        float b = aVar.b(i7, i8, i5, i6);
        if (b <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + b + " from: " + aVar + ", source: [" + i3 + ViewHierarchyNode.JsonKeys.X + i4 + "], target: [" + i5 + ViewHierarchyNode.JsonKeys.X + i6 + "]");
        }
        a.g a2 = aVar.a(i7, i8, i5, i6);
        if (a2 == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f2 = i7;
        float f3 = i8;
        int c = i7 / c(b * f2);
        int c2 = i8 / c(b * f3);
        a.g gVar = a.g.MEMORY;
        int max = Math.max(1, Integer.highestOneBit(a2 == gVar ? Math.max(c, c2) : Math.min(c, c2)));
        if (a2 == gVar && max < 1.0f / b) {
            max <<= 1;
        }
        options.inSampleSize = max;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float min = Math.min(max, 8);
            floor = (int) Math.ceil(f2 / min);
            floor2 = (int) Math.ceil(f3 / min);
            int i9 = max / 8;
            if (i9 > 0) {
                floor /= i9;
                floor2 /= i9;
            }
        } else if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
            float f4 = max;
            floor = (int) Math.floor(f2 / f4);
            floor2 = (int) Math.floor(f3 / f4);
        } else if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
            float f5 = max;
            floor = Math.round(f2 / f5);
            floor2 = Math.round(f3 / f5);
        } else if (i7 % max == 0 && i8 % max == 0) {
            floor = i7 / max;
            floor2 = i8 / max;
        } else {
            int[] b2 = b(imageReader, options, interfaceC0066b, bVar);
            floor = b2[0];
            floor2 = b2[1];
        }
        double b3 = aVar.b(floor, floor2, i5, i6);
        options.inTargetDensity = a(b3);
        options.inDensity = b(b3);
        if (b(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (Log.isLoggable("Downsampler", 2)) {
            Log.v("Downsampler", "Calculate scaling, source: [" + i3 + ViewHierarchyNode.JsonKeys.X + i4 + "], degreesToRotate: " + i2 + ", target: [" + i5 + ViewHierarchyNode.JsonKeys.X + i6 + "], power of two scaled: [" + floor + ViewHierarchyNode.JsonKeys.X + floor2 + "], exact scale factor: " + b + ", power of 2 sample size: " + max + ", adjusted scale factor: " + b3 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    private static boolean b(BitmapFactory.Options options) {
        int i2;
        int i3 = options.inTargetDensity;
        return i3 > 0 && (i2 = options.inDensity) > 0 && i3 != i2;
    }

    public sdk.pendo.io.t.c<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, Options options) {
        return a(new ImageReader.ParcelFileDescriptorImageReader(parcelFileDescriptor, this.d, this.c), i2, i3, options, l);
    }

    private sdk.pendo.io.t.c<Bitmap> a(ImageReader imageReader, int i2, int i3, Options options, InterfaceC0066b interfaceC0066b) {
        byte[] bArr = (byte[]) this.c.get(65536, byte[].class);
        BitmapFactory.Options a2 = a();
        a2.inTempStorage = bArr;
        sdk.pendo.io.q.b bVar = (sdk.pendo.io.q.b) options.get(f);
        h hVar = (h) options.get(g);
        external.sdk.pendo.io.glide.load.resource.bitmap.a aVar = (external.sdk.pendo.io.glide.load.resource.bitmap.a) options.get(external.sdk.pendo.io.glide.load.resource.bitmap.a.h);
        boolean booleanValue = ((Boolean) options.get(i)).booleanValue();
        g<Boolean> gVar = j;
        try {
            return BitmapResource.obtain(a(imageReader, a2, aVar, bVar, hVar, options.get(gVar) != null && ((Boolean) options.get(gVar)).booleanValue(), i2, i3, booleanValue, interfaceC0066b), this.f699a);
        } finally {
            c(a2);
            this.c.put(bArr);
        }
    }

    public sdk.pendo.io.t.c<Bitmap> a(InputStream inputStream, int i2, int i3, Options options) {
        return a(inputStream, i2, i3, options, l);
    }

    public sdk.pendo.io.t.c<Bitmap> a(InputStream inputStream, int i2, int i3, Options options, InterfaceC0066b interfaceC0066b) {
        return a(new ImageReader.InputStreamImageReader(inputStream, this.d, this.c), i2, i3, options, interfaceC0066b);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01af A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0193  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Bitmap a(external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader r29, android.graphics.BitmapFactory.Options r30, external.sdk.pendo.io.glide.load.resource.bitmap.a r31, sdk.pendo.io.q.b r32, sdk.pendo.io.q.h r33, boolean r34, int r35, int r36, boolean r37, external.sdk.pendo.io.glide.load.resource.bitmap.b.InterfaceC0066b r38) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.glide.load.resource.bitmap.b.a(external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader, android.graphics.BitmapFactory$Options, external.sdk.pendo.io.glide.load.resource.bitmap.a, sdk.pendo.io.q.b, sdk.pendo.io.q.h, boolean, int, int, boolean, external.sdk.pendo.io.glide.load.resource.bitmap.b$b):android.graphics.Bitmap");
    }

    private static Bitmap a(ImageReader imageReader, BitmapFactory.Options options, InterfaceC0066b interfaceC0066b, sdk.pendo.io.u.b bVar) {
        Bitmap a2;
        if (!options.inJustDecodeBounds) {
            interfaceC0066b.a();
            imageReader.stopGrowingBuffers();
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        String str = options.outMimeType;
        sdk.pendo.io.y.b.a().lock();
        try {
            try {
                a2 = imageReader.decodeBitmap(options);
            } catch (IllegalArgumentException e) {
                IOException a3 = a(e, i2, i3, str, options);
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", a3);
                }
                Bitmap bitmap = options.inBitmap;
                if (bitmap == null) {
                    throw a3;
                }
                try {
                    bVar.put(bitmap);
                    options.inBitmap = null;
                    a2 = a(imageReader, options, interfaceC0066b, bVar);
                } catch (IOException unused) {
                    throw a3;
                }
            }
            return a2;
        } finally {
            sdk.pendo.io.y.b.a().unlock();
        }
    }

    private static String a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + ViewHierarchyNode.JsonKeys.X + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options a() {
        BitmapFactory.Options poll;
        synchronized (b.class) {
            Queue<BitmapFactory.Options> queue = n;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                d(poll);
            }
        }
        return poll;
    }

    private static String a(BitmapFactory.Options options) {
        return a(options.inBitmap);
    }

    public boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.isSupported();
    }

    private static void a(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        Log.v("Downsampler", "Decoded " + a(bitmap) + " from [" + i2 + ViewHierarchyNode.JsonKeys.X + i3 + "] " + str + " with inBitmap " + a(options) + " for [" + i4 + ViewHierarchyNode.JsonKeys.X + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + f.a(j2));
    }

    private static IOException a(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + a(options), illegalArgumentException);
    }

    private static void a(BitmapFactory.Options options, sdk.pendo.io.u.b bVar, int i2, int i3) {
        if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        }
        Bitmap.Config config = options.outConfig;
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = bVar.getDirty(i2, i3, config);
    }
}
