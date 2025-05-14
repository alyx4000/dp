package external.sdk.pendo.io.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import external.sdk.pendo.io.glide.gifdecoder.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.UByte;

/* loaded from: classes2.dex */
public class StandardGifDecoder implements a {
    private static final int BYTES_PER_INTEGER = 4;
    private static final int COLOR_TRANSPARENT_BLACK = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    private static final String TAG = "StandardGifDecoder";
    private int[] act;
    private Bitmap.Config bitmapConfig;
    private final a.InterfaceC0053a bitmapProvider;
    private byte[] block;
    private int downsampledHeight;
    private int downsampledWidth;
    private int framePointer;
    private c header;
    private Boolean isFirstFrameTransparent;
    private byte[] mainPixels;
    private int[] mainScratch;
    private d parser;
    private final int[] pct;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private int sampleSize;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;

    public StandardGifDecoder(a.InterfaceC0053a interfaceC0053a) {
        this.pct = new int[256];
        this.bitmapConfig = Bitmap.Config.ARGB_8888;
        this.bitmapProvider = interfaceC0053a;
        this.header = new c();
    }

    private int averageColorsNear(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.sampleSize + i; i9++) {
            byte[] bArr = this.mainPixels;
            if (i9 >= bArr.length || i9 >= i2) {
                break;
            }
            int i10 = this.act[bArr[i9] & UByte.MAX_VALUE];
            if (i10 != 0) {
                i7 += (i10 >> 24) & 255;
                i6 += (i10 >> 16) & 255;
                i5 += (i10 >> 8) & 255;
                i4 += i10 & 255;
                i8++;
            }
        }
        int i11 = i + i3;
        for (int i12 = i11; i12 < this.sampleSize + i11; i12++) {
            byte[] bArr2 = this.mainPixels;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.act[bArr2[i12] & UByte.MAX_VALUE];
            if (i13 != 0) {
                i7 += (i13 >> 24) & 255;
                i6 += (i13 >> 16) & 255;
                i5 += (i13 >> 8) & 255;
                i4 += i13 & 255;
                i8++;
            }
        }
        if (i8 == 0) {
            return 0;
        }
        return ((i7 / i8) << 24) | ((i6 / i8) << 16) | ((i5 / i8) << 8) | (i4 / i8);
    }

    private void copyCopyIntoScratchRobust(b bVar) {
        Boolean bool;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = this.mainScratch;
        int i6 = bVar.d;
        int i7 = this.sampleSize;
        int i8 = i6 / i7;
        int i9 = bVar.b / i7;
        int i10 = bVar.c / i7;
        int i11 = bVar.f628a / i7;
        boolean z = this.framePointer == 0;
        int i12 = this.downsampledWidth;
        int i13 = this.downsampledHeight;
        byte[] bArr = this.mainPixels;
        int[] iArr2 = this.act;
        Boolean bool2 = this.isFirstFrameTransparent;
        int i14 = 8;
        int i15 = 0;
        int i16 = 0;
        int i17 = 1;
        while (true) {
            bool = bool2;
            if (i16 >= i8) {
                break;
            }
            if (bVar.e) {
                if (i15 >= i8) {
                    int i18 = i17 + 1;
                    i = i8;
                    if (i18 == 2) {
                        i15 = 4;
                        i17 = i18;
                    } else if (i18 != 3) {
                        i17 = i18;
                        if (i18 == 4) {
                            i15 = 1;
                            i14 = 2;
                        }
                    } else {
                        i14 = 4;
                        i17 = i18;
                        i15 = 2;
                    }
                } else {
                    i = i8;
                }
                i2 = i15 + i14;
            } else {
                i = i8;
                i2 = i15;
                i15 = i16;
            }
            int i19 = i15 + i9;
            boolean z2 = i7 == 1;
            if (i19 < i13) {
                int i20 = i19 * i12;
                int i21 = i20 + i11;
                int i22 = i21 + i10;
                int i23 = i20 + i12;
                if (i23 < i22) {
                    i22 = i23;
                }
                i3 = i2;
                int i24 = i16 * i7 * bVar.c;
                if (z2) {
                    int i25 = i21;
                    while (true) {
                        i4 = i9;
                        if (i25 >= i22) {
                            break;
                        }
                        int i26 = iArr2[bArr[i24] & UByte.MAX_VALUE];
                        if (i26 != 0) {
                            iArr[i25] = i26;
                        } else if (z && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i24 += i7;
                        i25++;
                        i9 = i4;
                    }
                } else {
                    i4 = i9;
                    int i27 = ((i22 - i21) * i7) + i24;
                    int i28 = i21;
                    while (true) {
                        i5 = i10;
                        if (i28 < i22) {
                            int averageColorsNear = averageColorsNear(i24, i27, bVar.c);
                            if (averageColorsNear != 0) {
                                iArr[i28] = averageColorsNear;
                            } else if (z && bool == null) {
                                bool = Boolean.TRUE;
                            }
                            i24 += i7;
                            i28++;
                            i10 = i5;
                        }
                    }
                    bool2 = bool;
                    i16++;
                    i9 = i4;
                    i8 = i;
                    i10 = i5;
                    i15 = i3;
                }
            } else {
                i3 = i2;
                i4 = i9;
            }
            i5 = i10;
            bool2 = bool;
            i16++;
            i9 = i4;
            i8 = i;
            i10 = i5;
            i15 = i3;
        }
        if (this.isFirstFrameTransparent == null) {
            this.isFirstFrameTransparent = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    private void copyIntoScratchFast(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.mainScratch;
        int i = bVar2.d;
        int i2 = bVar2.b;
        int i3 = bVar2.c;
        int i4 = bVar2.f628a;
        boolean z = this.framePointer == 0;
        int i5 = this.downsampledWidth;
        byte[] bArr = this.mainPixels;
        int[] iArr2 = this.act;
        int i6 = 0;
        byte b = -1;
        while (i6 < i) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            int i10 = i7 + i5;
            if (i10 < i9) {
                i9 = i10;
            }
            int i11 = bVar2.c * i6;
            int i12 = i8;
            while (i12 < i9) {
                byte b2 = bArr[i11];
                int i13 = i;
                int i14 = b2 & UByte.MAX_VALUE;
                if (i14 != b) {
                    int i15 = iArr2[i14];
                    if (i15 != 0) {
                        iArr[i12] = i15;
                    } else {
                        b = b2;
                    }
                }
                i11++;
                i12++;
                i = i13;
            }
            i6++;
            bVar2 = bVar;
        }
        Boolean bool = this.isFirstFrameTransparent;
        this.isFirstFrameTransparent = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.isFirstFrameTransparent == null && z && b != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v12, types: [short] */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    private void decodeBitmapData(b bVar) {
        int i;
        int i2;
        short s;
        StandardGifDecoder standardGifDecoder = this;
        if (bVar != null) {
            standardGifDecoder.rawData.position(bVar.j);
        }
        if (bVar == null) {
            c cVar = standardGifDecoder.header;
            i = cVar.f;
            i2 = cVar.g;
        } else {
            i = bVar.c;
            i2 = bVar.d;
        }
        int i3 = i * i2;
        byte[] bArr = standardGifDecoder.mainPixels;
        if (bArr == null || bArr.length < i3) {
            standardGifDecoder.mainPixels = standardGifDecoder.bitmapProvider.obtainByteArray(i3);
        }
        byte[] bArr2 = standardGifDecoder.mainPixels;
        if (standardGifDecoder.prefix == null) {
            standardGifDecoder.prefix = new short[4096];
        }
        short[] sArr = standardGifDecoder.prefix;
        if (standardGifDecoder.suffix == null) {
            standardGifDecoder.suffix = new byte[4096];
        }
        byte[] bArr3 = standardGifDecoder.suffix;
        if (standardGifDecoder.pixelStack == null) {
            standardGifDecoder.pixelStack = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        byte[] bArr4 = standardGifDecoder.pixelStack;
        int readByte = readByte();
        int i4 = 1 << readByte;
        int i5 = i4 + 1;
        int i6 = i4 + 2;
        int i7 = readByte + 1;
        int i8 = (1 << i7) - 1;
        int i9 = 0;
        for (int i10 = 0; i10 < i4; i10++) {
            sArr[i10] = 0;
            bArr3[i10] = (byte) i10;
        }
        byte[] bArr5 = standardGifDecoder.block;
        int i11 = i7;
        int i12 = i6;
        int i13 = i8;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = -1;
        while (true) {
            if (i9 >= i3) {
                break;
            }
            if (i14 == 0) {
                i14 = readBlock();
                if (i14 <= 0) {
                    standardGifDecoder.status = 3;
                    break;
                }
                i18 = 0;
            }
            i16 += (bArr5[i18] & UByte.MAX_VALUE) << i17;
            i18++;
            i14--;
            int i22 = i17 + 8;
            int i23 = i20;
            int i24 = i21;
            int i25 = i11;
            int i26 = i7;
            int i27 = i12;
            while (true) {
                if (i22 < i25) {
                    i20 = i23;
                    i11 = i25;
                    i17 = i22;
                    i12 = i27;
                    i7 = i26;
                    i21 = i24;
                    break;
                }
                int i28 = i6;
                int i29 = i16 & i13;
                i16 >>= i25;
                i22 -= i25;
                if (i29 == i4) {
                    i13 = i8;
                    i25 = i26;
                    i27 = i28;
                    i6 = i27;
                    i24 = -1;
                } else {
                    if (i29 == i5) {
                        i17 = i22;
                        i12 = i27;
                        i20 = i23;
                        i7 = i26;
                        i6 = i28;
                        i21 = i24;
                        i11 = i25;
                        break;
                    }
                    if (i24 == -1) {
                        bArr2[i15] = bArr3[i29];
                        i15++;
                        i9++;
                        i24 = i29;
                        i23 = i24;
                        i6 = i28;
                        i22 = i22;
                    } else {
                        if (i29 >= i27) {
                            bArr4[i19] = (byte) i23;
                            i19++;
                            s = i24;
                        } else {
                            s = i29;
                        }
                        while (s >= i4) {
                            bArr4[i19] = bArr3[s];
                            i19++;
                            s = sArr[s];
                        }
                        i23 = bArr3[s] & UByte.MAX_VALUE;
                        byte b = (byte) i23;
                        bArr2[i15] = b;
                        while (true) {
                            i15++;
                            i9++;
                            if (i19 <= 0) {
                                break;
                            }
                            i19--;
                            bArr2[i15] = bArr4[i19];
                        }
                        byte[] bArr6 = bArr4;
                        if (i27 < 4096) {
                            sArr[i27] = (short) i24;
                            bArr3[i27] = b;
                            i27++;
                            if ((i27 & i13) == 0 && i27 < 4096) {
                                i25++;
                                i13 += i27;
                            }
                        }
                        i24 = i29;
                        i6 = i28;
                        i22 = i22;
                        bArr4 = bArr6;
                    }
                }
            }
            standardGifDecoder = this;
        }
        Arrays.fill(bArr2, i15, i3, (byte) 0);
    }

    private d getHeaderParser() {
        if (this.parser == null) {
            this.parser = new d();
        }
        return this.parser;
    }

    private Bitmap getNextBitmap() {
        Boolean bool = this.isFirstFrameTransparent;
        Bitmap obtain = this.bitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.bitmapConfig);
        obtain.setHasAlpha(true);
        return obtain;
    }

    private int readBlock() {
        int readByte = readByte();
        if (readByte <= 0) {
            return readByte;
        }
        ByteBuffer byteBuffer = this.rawData;
        byteBuffer.get(this.block, 0, Math.min(readByte, byteBuffer.remaining()));
        return readByte;
    }

    private int readByte() {
        return this.rawData.get() & UByte.MAX_VALUE;
    }

    private Bitmap setPixels(b bVar, b bVar2) {
        int i;
        int i2;
        Bitmap bitmap;
        int[] iArr = this.mainScratch;
        int i3 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.previousImage;
            if (bitmap2 != null) {
                this.bitmapProvider.release(bitmap2);
            }
            this.previousImage = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.g == 3 && this.previousImage == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i2 = bVar2.g) > 0) {
            if (i2 == 2) {
                if (!bVar.f) {
                    c cVar = this.header;
                    int i4 = cVar.l;
                    if (bVar.k == null || cVar.j != bVar.h) {
                        i3 = i4;
                    }
                }
                int i5 = bVar2.d;
                int i6 = this.sampleSize;
                int i7 = i5 / i6;
                int i8 = bVar2.b / i6;
                int i9 = bVar2.c / i6;
                int i10 = bVar2.f628a / i6;
                int i11 = this.downsampledWidth;
                int i12 = (i8 * i11) + i10;
                int i13 = (i7 * i11) + i12;
                while (i12 < i13) {
                    int i14 = i12 + i9;
                    for (int i15 = i12; i15 < i14; i15++) {
                        iArr[i15] = i3;
                    }
                    i12 += this.downsampledWidth;
                }
            } else if (i2 == 3 && (bitmap = this.previousImage) != null) {
                int i16 = this.downsampledWidth;
                bitmap.getPixels(iArr, 0, i16, 0, 0, i16, this.downsampledHeight);
            }
        }
        decodeBitmapData(bVar);
        if (bVar.e || this.sampleSize != 1) {
            copyCopyIntoScratchRobust(bVar);
        } else {
            copyIntoScratchFast(bVar);
        }
        if (this.savePrevious && ((i = bVar.g) == 0 || i == 1)) {
            if (this.previousImage == null) {
                this.previousImage = getNextBitmap();
            }
            Bitmap bitmap3 = this.previousImage;
            int i17 = this.downsampledWidth;
            bitmap3.setPixels(iArr, 0, i17, 0, 0, i17, this.downsampledHeight);
        }
        Bitmap nextBitmap = getNextBitmap();
        int i18 = this.downsampledWidth;
        nextBitmap.setPixels(iArr, 0, i18, 0, 0, i18, this.downsampledHeight);
        return nextBitmap;
    }

    @Override // external.sdk.pendo.io.glide.gifdecoder.a
    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.c;
    }

    @Override // external.sdk.pendo.io.glide.gifdecoder.a
    public void clear() {
        this.header = null;
        byte[] bArr = this.mainPixels;
        if (bArr != null) {
            this.bitmapProvider.release(bArr);
        }
        int[] iArr = this.mainScratch;
        if (iArr != null) {
            this.bitmapProvider.release(iArr);
        }
        Bitmap bitmap = this.previousImage;
        if (bitmap != null) {
            this.bitmapProvider.release(bitmap);
        }
        this.previousImage = null;
        this.rawData = null;
        this.isFirstFrameTransparent = null;
        byte[] bArr2 = this.block;
        if (bArr2 != null) {
            this.bitmapProvider.release(bArr2);
        }
    }

    @Override // external.sdk.pendo.io.glide.gifdecoder.a
    public int getByteSize() {
        return this.rawData.limit() + this.mainPixels.length + (this.mainScratch.length * 4);
    }

    @Override // external.sdk.pendo.io.glide.gifdecoder.a
    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    @Override // external.sdk.pendo.io.glide.gifdecoder.a
    public ByteBuffer getData() {
        return this.rawData;
    }

    public int getDelay(int i) {
        if (i >= 0) {
            c cVar = this.header;
            if (i < cVar.c) {
                return cVar.e.get(i).i;
            }
        }
        return -1;
    }

    @Override // external.sdk.pendo.io.glide.gifdecoder.a
    public int getFrameCount() {
        return this.header.c;
    }

    public int getHeight() {
        return this.header.g;
    }

    @Deprecated
    public int getLoopCount() {
        int i = this.header.m;
        if (i == -1) {
            return 1;
        }
        return i;
    }

    public int getNetscapeLoopCount() {
        return this.header.m;
    }

    @Override // external.sdk.pendo.io.glide.gifdecoder.a
    public int getNextDelay() {
        int i;
        if (this.header.c <= 0 || (i = this.framePointer) < 0) {
            return 0;
        }
        return getDelay(i);
    }

    @Override // external.sdk.pendo.io.glide.gifdecoder.a
    public synchronized Bitmap getNextFrame() {
        if (this.header.c <= 0 || this.framePointer < 0) {
            String str = TAG;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to decode frame, frameCount=" + this.header.c + ", framePointer=" + this.framePointer);
            }
            this.status = 1;
        }
        int i = this.status;
        if (i != 1 && i != 2) {
            this.status = 0;
            if (this.block == null) {
                this.block = this.bitmapProvider.obtainByteArray(255);
            }
            b bVar = this.header.e.get(this.framePointer);
            int i2 = this.framePointer - 1;
            b bVar2 = i2 >= 0 ? this.header.e.get(i2) : null;
            int[] iArr = bVar.k;
            if (iArr == null) {
                iArr = this.header.f629a;
            }
            this.act = iArr;
            if (iArr == null) {
                String str2 = TAG;
                if (Log.isLoggable(str2, 3)) {
                    Log.d(str2, "No valid color table found for frame #" + this.framePointer);
                }
                this.status = 1;
                return null;
            }
            if (bVar.f) {
                System.arraycopy(iArr, 0, this.pct, 0, iArr.length);
                int[] iArr2 = this.pct;
                this.act = iArr2;
                iArr2[bVar.h] = 0;
                if (bVar.g == 2 && this.framePointer == 0) {
                    this.isFirstFrameTransparent = Boolean.TRUE;
                }
            }
            return setPixels(bVar, bVar2);
        }
        String str3 = TAG;
        if (Log.isLoggable(str3, 3)) {
            Log.d(str3, "Unable to decode frame, status=" + this.status);
        }
        return null;
    }

    public int getStatus() {
        return this.status;
    }

    @Override // external.sdk.pendo.io.glide.gifdecoder.a
    public int getTotalIterationCount() {
        int i = this.header.m;
        if (i == -1) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        return i + 1;
    }

    public int getWidth() {
        return this.header.f;
    }

    public int read(InputStream inputStream, int i) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i > 0 ? i + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e) {
                Log.w(TAG, "Error reading data from stream", e);
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                Log.w(TAG, "Error closing stream", e2);
            }
        }
        return this.status;
    }

    @Override // external.sdk.pendo.io.glide.gifdecoder.a
    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    public synchronized void setData(c cVar, ByteBuffer byteBuffer) {
        setData(cVar, byteBuffer, 1);
    }

    @Override // external.sdk.pendo.io.glide.gifdecoder.a
    public void setDefaultBitmapConfig(Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
        }
        this.bitmapConfig = config;
    }

    public StandardGifDecoder(a.InterfaceC0053a interfaceC0053a, c cVar, ByteBuffer byteBuffer) {
        this(interfaceC0053a, cVar, byteBuffer, 1);
    }

    public synchronized int read(byte[] bArr) {
        c c = getHeaderParser().a(bArr).c();
        this.header = c;
        if (bArr != null) {
            setData(c, bArr);
        }
        return this.status;
    }

    public synchronized void setData(c cVar, ByteBuffer byteBuffer, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
        int highestOneBit = Integer.highestOneBit(i);
        this.status = 0;
        this.header = cVar;
        this.framePointer = -1;
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.rawData = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        this.savePrevious = false;
        Iterator<b> it = cVar.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().g == 3) {
                this.savePrevious = true;
                break;
            }
        }
        this.sampleSize = highestOneBit;
        int i2 = cVar.f;
        this.downsampledWidth = i2 / highestOneBit;
        int i3 = cVar.g;
        this.downsampledHeight = i3 / highestOneBit;
        this.mainPixels = this.bitmapProvider.obtainByteArray(i2 * i3);
        this.mainScratch = this.bitmapProvider.obtainIntArray(this.downsampledWidth * this.downsampledHeight);
    }

    public StandardGifDecoder(a.InterfaceC0053a interfaceC0053a, c cVar, ByteBuffer byteBuffer, int i) {
        this(interfaceC0053a);
        setData(cVar, byteBuffer, i);
    }

    public synchronized void setData(c cVar, byte[] bArr) {
        setData(cVar, ByteBuffer.wrap(bArr));
    }
}
