package com.facebook.imageformat;

import com.facebook.common.internal.Ints;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imageformat.ImageFormat;
import javax.annotation.Nullable;
import org.tensorflow.lite.schema.BuiltinOptions;

/* loaded from: classes3.dex */
public class DefaultImageFormatChecker implements ImageFormat.FormatChecker {
    private static final byte[] BMP_HEADER;
    private static final int BMP_HEADER_LENGTH;
    private static final byte[] DNG_HEADER_II;
    private static final int DNG_HEADER_LENGTH;
    private static final byte[] DNG_HEADER_MM;
    private static final int EXTENDED_WEBP_HEADER_LENGTH = 21;
    private static final byte[] GIF_HEADER_87A;
    private static final byte[] GIF_HEADER_89A;
    private static final int GIF_HEADER_LENGTH = 6;
    private static final int HEIF_HEADER_LENGTH = 12;
    private static final byte[] HEIF_HEADER_PREFIX;
    private static final byte[][] HEIF_HEADER_SUFFIXES;
    private static final byte[] ICO_HEADER;
    private static final int ICO_HEADER_LENGTH;
    private static final byte[] JPEG_HEADER;
    private static final int JPEG_HEADER_LENGTH;
    private static final byte[] PNG_HEADER;
    private static final int PNG_HEADER_LENGTH;
    private static final int SIMPLE_WEBP_HEADER_LENGTH = 20;
    final int MAX_HEADER_LENGTH = Ints.max(21, 20, JPEG_HEADER_LENGTH, PNG_HEADER_LENGTH, 6, BMP_HEADER_LENGTH, ICO_HEADER_LENGTH, 12);
    private boolean mUseNewOrder = false;

    public void setUseNewOrder(boolean z) {
        this.mUseNewOrder = z;
    }

    @Override // com.facebook.imageformat.ImageFormat.FormatChecker
    public int getHeaderSize() {
        return this.MAX_HEADER_LENGTH;
    }

    @Override // com.facebook.imageformat.ImageFormat.FormatChecker
    @Nullable
    public final ImageFormat determineFormat(byte[] bArr, int i) {
        Preconditions.checkNotNull(bArr);
        if (!this.mUseNewOrder && WebpSupportStatus.isWebpHeader(bArr, 0, i)) {
            return getWebpFormat(bArr, i);
        }
        if (isJpegHeader(bArr, i)) {
            return DefaultImageFormats.JPEG;
        }
        if (isPngHeader(bArr, i)) {
            return DefaultImageFormats.PNG;
        }
        if (this.mUseNewOrder && WebpSupportStatus.isWebpHeader(bArr, 0, i)) {
            return getWebpFormat(bArr, i);
        }
        if (isGifHeader(bArr, i)) {
            return DefaultImageFormats.GIF;
        }
        if (isBmpHeader(bArr, i)) {
            return DefaultImageFormats.BMP;
        }
        if (isIcoHeader(bArr, i)) {
            return DefaultImageFormats.ICO;
        }
        if (isHeifHeader(bArr, i)) {
            return DefaultImageFormats.HEIF;
        }
        if (isDngHeader(bArr, i)) {
            return DefaultImageFormats.DNG;
        }
        return ImageFormat.UNKNOWN;
    }

    private static ImageFormat getWebpFormat(byte[] bArr, int i) {
        Preconditions.checkArgument(Boolean.valueOf(WebpSupportStatus.isWebpHeader(bArr, 0, i)));
        if (WebpSupportStatus.isSimpleWebpHeader(bArr, 0)) {
            return DefaultImageFormats.WEBP_SIMPLE;
        }
        if (WebpSupportStatus.isLosslessWebpHeader(bArr, 0)) {
            return DefaultImageFormats.WEBP_LOSSLESS;
        }
        if (WebpSupportStatus.isExtendedWebpHeader(bArr, 0, i)) {
            if (WebpSupportStatus.isAnimatedWebpHeader(bArr, 0)) {
                return DefaultImageFormats.WEBP_ANIMATED;
            }
            if (WebpSupportStatus.isExtendedWebpHeaderWithAlpha(bArr, 0)) {
                return DefaultImageFormats.WEBP_EXTENDED_WITH_ALPHA;
            }
            return DefaultImageFormats.WEBP_EXTENDED;
        }
        return ImageFormat.UNKNOWN;
    }

    static {
        byte[] bArr = {-1, -40, -1};
        JPEG_HEADER = bArr;
        JPEG_HEADER_LENGTH = bArr.length;
        byte[] bArr2 = {-119, BuiltinOptions.UniqueOptions, BuiltinOptions.AbsOptions, BuiltinOptions.UnidirectionalSequenceLSTMOptions, 13, 10, BuiltinOptions.TransposeOptions, 10};
        PNG_HEADER = bArr2;
        PNG_HEADER_LENGTH = bArr2.length;
        GIF_HEADER_87A = ImageFormatCheckerUtils.asciiBytes("GIF87a");
        GIF_HEADER_89A = ImageFormatCheckerUtils.asciiBytes("GIF89a");
        byte[] asciiBytes = ImageFormatCheckerUtils.asciiBytes("BM");
        BMP_HEADER = asciiBytes;
        BMP_HEADER_LENGTH = asciiBytes.length;
        byte[] bArr3 = {0, 0, 1, 0};
        ICO_HEADER = bArr3;
        ICO_HEADER_LENGTH = bArr3.length;
        HEIF_HEADER_PREFIX = ImageFormatCheckerUtils.asciiBytes("ftyp");
        HEIF_HEADER_SUFFIXES = new byte[][]{ImageFormatCheckerUtils.asciiBytes("heic"), ImageFormatCheckerUtils.asciiBytes("heix"), ImageFormatCheckerUtils.asciiBytes("hevc"), ImageFormatCheckerUtils.asciiBytes("hevx"), ImageFormatCheckerUtils.asciiBytes("mif1"), ImageFormatCheckerUtils.asciiBytes("msf1")};
        byte[] bArr4 = {BuiltinOptions.RangeOptions, BuiltinOptions.RangeOptions, BuiltinOptions.NegOptions, 0};
        DNG_HEADER_II = bArr4;
        DNG_HEADER_MM = new byte[]{BuiltinOptions.MirrorPadOptions, BuiltinOptions.MirrorPadOptions, 0, BuiltinOptions.NegOptions};
        DNG_HEADER_LENGTH = bArr4.length;
    }

    private static boolean isJpegHeader(byte[] bArr, int i) {
        byte[] bArr2 = JPEG_HEADER;
        return i >= bArr2.length && ImageFormatCheckerUtils.startsWithPattern(bArr, bArr2);
    }

    private static boolean isPngHeader(byte[] bArr, int i) {
        byte[] bArr2 = PNG_HEADER;
        return i >= bArr2.length && ImageFormatCheckerUtils.startsWithPattern(bArr, bArr2);
    }

    private static boolean isGifHeader(byte[] bArr, int i) {
        if (i < 6) {
            return false;
        }
        return ImageFormatCheckerUtils.startsWithPattern(bArr, GIF_HEADER_87A) || ImageFormatCheckerUtils.startsWithPattern(bArr, GIF_HEADER_89A);
    }

    private static boolean isBmpHeader(byte[] bArr, int i) {
        byte[] bArr2 = BMP_HEADER;
        if (i < bArr2.length) {
            return false;
        }
        return ImageFormatCheckerUtils.startsWithPattern(bArr, bArr2);
    }

    private static boolean isIcoHeader(byte[] bArr, int i) {
        byte[] bArr2 = ICO_HEADER;
        if (i < bArr2.length) {
            return false;
        }
        return ImageFormatCheckerUtils.startsWithPattern(bArr, bArr2);
    }

    private static boolean isHeifHeader(byte[] bArr, int i) {
        if (i < 12 || bArr[3] < 8 || !ImageFormatCheckerUtils.hasPatternAt(bArr, HEIF_HEADER_PREFIX, 4)) {
            return false;
        }
        for (byte[] bArr2 : HEIF_HEADER_SUFFIXES) {
            if (ImageFormatCheckerUtils.hasPatternAt(bArr, bArr2, 8)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDngHeader(byte[] bArr, int i) {
        return i >= DNG_HEADER_LENGTH && (ImageFormatCheckerUtils.startsWithPattern(bArr, DNG_HEADER_II) || ImageFormatCheckerUtils.startsWithPattern(bArr, DNG_HEADER_MM));
    }
}
