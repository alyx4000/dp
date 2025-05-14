package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import external.sdk.pendo.io.glide.load.Options;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import sdk.pendo.io.q.g;
import sdk.pendo.io.q.i;

/* loaded from: classes2.dex */
public class VideoDecoder<T> implements i<T, Bitmap> {
    public static final long DEFAULT_FRAME = -1;
    static final int DEFAULT_FRAME_OPTION = 2;
    private static final String TAG = "VideoDecoder";
    private final sdk.pendo.io.u.b bitmapPool;
    private final e factory;
    private final f<T> initializer;
    public static final sdk.pendo.io.q.g<Long> TARGET_FRAME = sdk.pendo.io.q.g.a("external.sdk.pendo.io.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());
    public static final sdk.pendo.io.q.g<Integer> FRAME_OPTION = sdk.pendo.io.q.g.a("external.sdk.pendo.io.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());
    private static final e DEFAULT_FACTORY = new e();

    class a implements g.b<Long> {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f696a = ByteBuffer.allocate(8);

        a() {
        }

        @Override // sdk.pendo.io.q.g.b
        public void a(byte[] bArr, Long l, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f696a) {
                this.f696a.position(0);
                messageDigest.update(this.f696a.putLong(l.longValue()).array());
            }
        }
    }

    class b implements g.b<Integer> {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f697a = ByteBuffer.allocate(4);

        b() {
        }

        @Override // sdk.pendo.io.q.g.b
        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f697a) {
                this.f697a.position(0);
                messageDigest.update(this.f697a.putInt(num.intValue()).array());
            }
        }
    }

    private static final class c implements f<AssetFileDescriptor> {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.VideoDecoder.f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    static final class d implements f<ByteBuffer> {

        class a extends MediaDataSource {
            final /* synthetic */ ByteBuffer f;

            a(ByteBuffer byteBuffer) {
                this.f = byteBuffer;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return this.f.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j, byte[] bArr, int i, int i2) {
                if (j >= this.f.limit()) {
                    return -1;
                }
                this.f.position((int) j);
                int min = Math.min(i2, this.f.remaining());
                this.f.get(bArr, i, min);
                return min;
            }
        }

        d() {
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.VideoDecoder.f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new a(byteBuffer));
        }
    }

    static class e {
        e() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    interface f<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    static final class g implements f<ParcelFileDescriptor> {
        g() {
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.VideoDecoder.f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    private static final class h extends RuntimeException {
        h() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    VideoDecoder(sdk.pendo.io.u.b bVar, f<T> fVar) {
        this(bVar, fVar, DEFAULT_FACTORY);
    }

    public static i<AssetFileDescriptor, Bitmap> asset(sdk.pendo.io.u.b bVar) {
        return new VideoDecoder(bVar, new c(null));
    }

    public static i<ByteBuffer, Bitmap> byteBuffer(sdk.pendo.io.u.b bVar) {
        return new VideoDecoder(bVar, new d());
    }

    private static Bitmap decodeFrame(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, external.sdk.pendo.io.glide.load.resource.bitmap.a aVar) {
        Bitmap decodeScaledFrame = (Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || aVar == external.sdk.pendo.io.glide.load.resource.bitmap.a.f) ? null : decodeScaledFrame(mediaMetadataRetriever, j, i, i2, i3, aVar);
        if (decodeScaledFrame == null) {
            decodeScaledFrame = decodeOriginalFrame(mediaMetadataRetriever, j, i);
        }
        if (decodeScaledFrame != null) {
            return decodeScaledFrame;
        }
        throw new h();
    }

    private static Bitmap decodeOriginalFrame(MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }

    private static Bitmap decodeScaledFrame(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, external.sdk.pendo.io.glide.load.resource.bitmap.a aVar) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                parseInt2 = parseInt;
                parseInt = parseInt2;
            }
            float b2 = aVar.b(parseInt, parseInt2, i2, i3);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(parseInt * b2), Math.round(b2 * parseInt2));
        } catch (Throwable th) {
            if (!Log.isLoggable(TAG, 3)) {
                return null;
            }
            Log.d(TAG, "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
            return null;
        }
    }

    public static i<ParcelFileDescriptor, Bitmap> parcel(sdk.pendo.io.u.b bVar) {
        return new VideoDecoder(bVar, new g());
    }

    @Override // sdk.pendo.io.q.i
    public sdk.pendo.io.t.c<Bitmap> decode(T t, int i, int i2, Options options) {
        long longValue = ((Long) options.get(TARGET_FRAME)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        Integer num = (Integer) options.get(FRAME_OPTION);
        if (num == null) {
            num = 2;
        }
        external.sdk.pendo.io.glide.load.resource.bitmap.a aVar = (external.sdk.pendo.io.glide.load.resource.bitmap.a) options.get(external.sdk.pendo.io.glide.load.resource.bitmap.a.h);
        if (aVar == null) {
            aVar = external.sdk.pendo.io.glide.load.resource.bitmap.a.g;
        }
        external.sdk.pendo.io.glide.load.resource.bitmap.a aVar2 = aVar;
        MediaMetadataRetriever a2 = this.factory.a();
        try {
            this.initializer.a(a2, t);
            Bitmap decodeFrame = decodeFrame(a2, longValue, num.intValue(), i, i2, aVar2);
            a2.release();
            return BitmapResource.obtain(decodeFrame, this.bitmapPool);
        } catch (Throwable th) {
            a2.release();
            throw th;
        }
    }

    @Override // sdk.pendo.io.q.i
    public boolean handles(T t, Options options) {
        return true;
    }

    VideoDecoder(sdk.pendo.io.u.b bVar, f<T> fVar, e eVar) {
        this.bitmapPool = bVar;
        this.initializer = fVar;
        this.factory = eVar;
    }
}
