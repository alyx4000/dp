package com.google.crypto.tink.mac.internal;

import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes5.dex */
public final class AesUtil {
    public static final int BLOCK_SIZE = 16;

    public static byte[] dbl(final byte[] value) {
        if (value.length != 16) {
            throw new IllegalArgumentException("value must be a block.");
        }
        byte[] bArr = new byte[16];
        for (int i = 0; i < 16; i++) {
            byte b = (byte) ((value[i] << 1) & 254);
            bArr[i] = b;
            if (i < 15) {
                bArr[i] = (byte) (((byte) ((value[i + 1] >> 7) & 1)) | b);
            }
        }
        bArr[15] = (byte) (((byte) ((value[0] >> 7) & 135)) ^ bArr[15]);
        return bArr;
    }

    public static byte[] cmacPad(final byte[] x) {
        if (x.length >= 16) {
            throw new IllegalArgumentException("x must be smaller than a block.");
        }
        byte[] copyOf = Arrays.copyOf(x, 16);
        copyOf[x.length] = ByteCompanionObject.MIN_VALUE;
        return copyOf;
    }

    private AesUtil() {
    }
}
