package org.brotli.dec;

import kotlin.UByte;

/* loaded from: classes6.dex */
final class IntReader {
    private byte[] byteBuffer;
    private int[] intBuffer;

    IntReader() {
    }

    static void init(IntReader intReader, byte[] bArr, int[] iArr) {
        intReader.byteBuffer = bArr;
        intReader.intBuffer = iArr;
    }

    static void convert(IntReader intReader, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int[] iArr = intReader.intBuffer;
            byte[] bArr = intReader.byteBuffer;
            int i3 = i2 * 4;
            iArr[i2] = ((bArr[i3 + 3] & UByte.MAX_VALUE) << 24) | (bArr[i3] & UByte.MAX_VALUE) | ((bArr[i3 + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i3 + 2] & UByte.MAX_VALUE) << 16);
        }
    }
}
