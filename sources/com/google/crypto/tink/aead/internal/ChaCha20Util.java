package com.google.crypto.tink.aead.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import org.tensorflow.lite.schema.BuiltinOptions;

/* loaded from: classes5.dex */
final class ChaCha20Util {
    static final int BLOCK_SIZE_IN_BYTES = 64;
    static final int BLOCK_SIZE_IN_INTS = 16;
    static final int KEY_SIZE_IN_BYTES = 32;
    static final int KEY_SIZE_IN_INTS = 8;
    private static final int[] SIGMA = toIntArray(new byte[]{BuiltinOptions.BatchMatMulOptions, BuiltinOptions.UnsortedSegmentMinOptions, BuiltinOptions.ReadVariableOptions, BuiltinOptions.ScatterNdOptions, BuiltinOptions.HashtableSizeOptions, BuiltinOptions.SegmentSumOptions, BuiltinOptions.StridedSliceOptions, BuiltinOptions.TileOptions, BuiltinOptions.SparseToDenseOptions, 45, BuiltinOptions.SelectV2Options, BuiltinOptions.UnsortedSegmentSumOptions, BuiltinOptions.GeluOptions, BuiltinOptions.BatchMatMulOptions, BuiltinOptions.StridedSliceOptions, BuiltinOptions.HashtableOptions});

    private static int rotateLeft(int x, int y) {
        return (x >>> (-y)) | (x << y);
    }

    static void setSigmaAndKey(int[] state, final int[] key) {
        int[] iArr = SIGMA;
        System.arraycopy(iArr, 0, state, 0, iArr.length);
        System.arraycopy(key, 0, state, iArr.length, 8);
    }

    static void shuffleState(final int[] state) {
        for (int i = 0; i < 10; i++) {
            quarterRound(state, 0, 4, 8, 12);
            quarterRound(state, 1, 5, 9, 13);
            quarterRound(state, 2, 6, 10, 14);
            quarterRound(state, 3, 7, 11, 15);
            quarterRound(state, 0, 5, 10, 15);
            quarterRound(state, 1, 6, 11, 12);
            quarterRound(state, 2, 7, 8, 13);
            quarterRound(state, 3, 4, 9, 14);
        }
    }

    static void quarterRound(int[] x, int a2, int b, int c, int d) {
        int i = x[a2] + x[b];
        x[a2] = i;
        int rotateLeft = rotateLeft(i ^ x[d], 16);
        x[d] = rotateLeft;
        int i2 = x[c] + rotateLeft;
        x[c] = i2;
        int rotateLeft2 = rotateLeft(x[b] ^ i2, 12);
        x[b] = rotateLeft2;
        int i3 = x[a2] + rotateLeft2;
        x[a2] = i3;
        int rotateLeft3 = rotateLeft(x[d] ^ i3, 8);
        x[d] = rotateLeft3;
        int i4 = x[c] + rotateLeft3;
        x[c] = i4;
        x[b] = rotateLeft(x[b] ^ i4, 7);
    }

    static int[] toIntArray(final byte[] input) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(input).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    private ChaCha20Util() {
    }
}
