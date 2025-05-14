package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.util.Log;
import external.sdk.pendo.io.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import kotlin.UByte;
import sdk.pendo.io.i0.j;

/* loaded from: classes2.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {
    static final int EXIF_MAGIC_NUMBER = 65496;
    static final int EXIF_SEGMENT_TYPE = 225;
    private static final int GIF_HEADER = 4671814;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    private static final int MARKER_EOI = 217;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int PNG_HEADER = -1991225785;
    private static final int RIFF_HEADER = 1380533830;
    private static final int SEGMENT_SOS = 218;
    static final int SEGMENT_START_ID = 255;
    private static final String TAG = "DfltImageHeaderParser";
    private static final int VP8_HEADER = 1448097792;
    private static final int VP8_HEADER_MASK = -256;
    private static final int VP8_HEADER_TYPE_EXTENDED = 88;
    private static final int VP8_HEADER_TYPE_LOSSLESS = 76;
    private static final int VP8_HEADER_TYPE_MASK = 255;
    private static final int WEBP_EXTENDED_ALPHA_FLAG = 16;
    private static final int WEBP_HEADER = 1464156752;
    private static final int WEBP_LOSSLESS_ALPHA_FLAG = 8;
    private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(Charset.forName("UTF-8"));
    private static final int[] BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    private static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f692a;

        a(ByteBuffer byteBuffer) {
            this.f692a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public short a() {
            if (this.f692a.remaining() >= 1) {
                return (short) (this.f692a.get() & UByte.MAX_VALUE);
            }
            throw new c.a();
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public int b() {
            return (a() << 8) | a();
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public long skip(long j) {
            int min = (int) Math.min(this.f692a.remaining(), j);
            ByteBuffer byteBuffer = this.f692a;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public int a(byte[] bArr, int i) {
            int min = Math.min(i, this.f692a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f692a.get(bArr, 0, min);
            return min;
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f693a;

        b(byte[] bArr, int i) {
            this.f693a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        short a(int i) {
            if (a(i, 2)) {
                return this.f693a.getShort(i);
            }
            return (short) -1;
        }

        int b(int i) {
            if (a(i, 4)) {
                return this.f693a.getInt(i);
            }
            return -1;
        }

        private boolean a(int i, int i2) {
            return this.f693a.remaining() - i >= i2;
        }

        int a() {
            return this.f693a.remaining();
        }

        void a(ByteOrder byteOrder) {
            this.f693a.order(byteOrder);
        }
    }

    private interface c {

        public static final class a extends IOException {
            a() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a(byte[] bArr, int i);

        short a();

        int b();

        long skip(long j);
    }

    private static final class d implements c {

        /* renamed from: a, reason: collision with root package name */
        private final InputStream f694a;

        d(InputStream inputStream) {
            this.f694a = inputStream;
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public short a() {
            int read = this.f694a.read();
            if (read != -1) {
                return (short) read;
            }
            throw new c.a();
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public int b() {
            return (a() << 8) | a();
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public long skip(long j) {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f694a.skip(j2);
                if (skip <= 0) {
                    if (this.f694a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.DefaultImageHeaderParser.c
        public int a(byte[] bArr, int i) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < i && (i3 = this.f694a.read(bArr, i2, i - i2)) != -1) {
                i2 += i3;
            }
            if (i2 == 0 && i3 == -1) {
                throw new c.a();
            }
            return i2;
        }
    }

    private static int calcTagOffset(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    private int getOrientation(c cVar, sdk.pendo.io.u.a aVar) {
        try {
            int b2 = cVar.b();
            if (!handles(b2)) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Parser doesn't handle magic number: " + b2);
                }
                return -1;
            }
            int moveToExifSegmentAndGetLength = moveToExifSegmentAndGetLength(cVar);
            if (moveToExifSegmentAndGetLength == -1) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) aVar.get(moveToExifSegmentAndGetLength, byte[].class);
            try {
                return parseExifSegment(cVar, bArr, moveToExifSegmentAndGetLength);
            } finally {
                aVar.put(bArr);
            }
        } catch (c.a unused) {
            return -1;
        }
    }

    private ImageHeaderParser.ImageType getType(c cVar) {
        try {
            int b2 = cVar.b();
            if (b2 == EXIF_MAGIC_NUMBER) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int a2 = (b2 << 8) | cVar.a();
            if (a2 == GIF_HEADER) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int a3 = (a2 << 8) | cVar.a();
            if (a3 == PNG_HEADER) {
                cVar.skip(21L);
                try {
                    return cVar.a() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (c.a unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (a3 != RIFF_HEADER) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            cVar.skip(4L);
            if (((cVar.b() << 16) | cVar.b()) != WEBP_HEADER) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int b3 = (cVar.b() << 16) | cVar.b();
            if ((b3 & (-256)) != VP8_HEADER) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i = b3 & 255;
            if (i == 88) {
                cVar.skip(4L);
                return (cVar.a() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
            if (i != 76) {
                return ImageHeaderParser.ImageType.WEBP;
            }
            cVar.skip(4L);
            return (cVar.a() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
        } catch (c.a unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    private static boolean handles(int i) {
        return (i & EXIF_MAGIC_NUMBER) == EXIF_MAGIC_NUMBER || i == MOTOROLA_TIFF_MAGIC_NUMBER || i == INTEL_TIFF_MAGIC_NUMBER;
    }

    private boolean hasJpegExifPreamble(byte[] bArr, int i) {
        boolean z = bArr != null && i > JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length;
        if (z) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
                if (i2 >= bArr2.length) {
                    break;
                }
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
                i2++;
            }
        }
        return z;
    }

    private int moveToExifSegmentAndGetLength(c cVar) {
        short a2;
        int b2;
        long j;
        long skip;
        do {
            short a3 = cVar.a();
            if (a3 != 255) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Unknown segmentId=" + ((int) a3));
                }
                return -1;
            }
            a2 = cVar.a();
            if (a2 == 218) {
                return -1;
            }
            if (a2 == 217) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            b2 = cVar.b() - 2;
            if (a2 == 225) {
                return b2;
            }
            j = b2;
            skip = cVar.skip(j);
        } while (skip == j);
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Unable to skip enough data, type: " + ((int) a2) + ", wanted to skip: " + b2 + ", but actually skipped: " + skip);
        }
        return -1;
    }

    private static int parseExifSegment(b bVar) {
        ByteOrder byteOrder;
        StringBuilder sb;
        StringBuilder sb2;
        String sb3;
        StringBuilder append;
        short a2 = bVar.a(6);
        if (a2 != INTEL_TIFF_MAGIC_NUMBER) {
            if (a2 != MOTOROLA_TIFF_MAGIC_NUMBER && Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unknown endianness = " + ((int) a2));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        bVar.a(byteOrder);
        int b2 = bVar.b(10) + 6;
        short a3 = bVar.a(b2);
        for (int i = 0; i < a3; i++) {
            int calcTagOffset = calcTagOffset(b2, i);
            short a4 = bVar.a(calcTagOffset);
            if (a4 == 274) {
                short a5 = bVar.a(calcTagOffset + 2);
                if (a5 >= 1 && a5 <= 12) {
                    int b3 = bVar.b(calcTagOffset + 4);
                    if (b3 >= 0) {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Got tagIndex=" + i + " tagType=" + ((int) a4) + " formatCode=" + ((int) a5) + " componentCount=" + b3);
                        }
                        int i2 = b3 + BYTES_PER_FORMAT[a5];
                        if (i2 <= 4) {
                            int i3 = calcTagOffset + 8;
                            if (i3 >= 0 && i3 <= bVar.a()) {
                                if (i2 >= 0 && i2 + i3 <= bVar.a()) {
                                    return bVar.a(i3);
                                }
                                if (Log.isLoggable(TAG, 3)) {
                                    append = new StringBuilder("Illegal number of bytes for TI tag data tagType=");
                                    sb2 = append.append((int) a4);
                                }
                            } else if (Log.isLoggable(TAG, 3)) {
                                append = new StringBuilder("Illegal tagValueOffset=").append(i3).append(" tagType=");
                                sb2 = append.append((int) a4);
                            }
                        } else if (Log.isLoggable(TAG, 3)) {
                            sb = new StringBuilder("Got byte count > 4, not orientation, continuing, formatCode=");
                            sb2 = sb.append((int) a5);
                        }
                    } else if (Log.isLoggable(TAG, 3)) {
                        sb3 = "Negative tiff component count";
                        Log.d(TAG, sb3);
                    }
                } else if (Log.isLoggable(TAG, 3)) {
                    sb = new StringBuilder("Got invalid format code = ");
                    sb2 = sb.append((int) a5);
                }
                sb3 = sb2.toString();
                Log.d(TAG, sb3);
            }
        }
        return -1;
    }

    private int parseExifSegment(c cVar, byte[] bArr, int i) {
        int a2 = cVar.a(bArr, i);
        if (a2 != i) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Unable to read exif segment data, length: " + i + ", actually read: " + a2);
            }
            return -1;
        }
        if (hasJpegExifPreamble(bArr, i)) {
            return parseExifSegment(new b(bArr, i));
        }
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Missing jpeg exif preamble");
        }
        return -1;
    }

    @Override // external.sdk.pendo.io.glide.load.ImageHeaderParser
    public int getOrientation(InputStream inputStream, sdk.pendo.io.u.a aVar) {
        return getOrientation(new d((InputStream) j.a(inputStream)), (sdk.pendo.io.u.a) j.a(aVar));
    }

    @Override // external.sdk.pendo.io.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(InputStream inputStream) {
        return getType(new d((InputStream) j.a(inputStream)));
    }

    public int getOrientation(ByteBuffer byteBuffer, sdk.pendo.io.u.a aVar) {
        return getOrientation(new a((ByteBuffer) j.a(byteBuffer)), (sdk.pendo.io.u.a) j.a(aVar));
    }

    @Override // external.sdk.pendo.io.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(ByteBuffer byteBuffer) {
        return getType(new a((ByteBuffer) j.a(byteBuffer)));
    }
}
