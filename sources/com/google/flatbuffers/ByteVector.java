package com.google.flatbuffers;

import java.nio.ByteBuffer;
import kotlin.UByte;

/* loaded from: classes5.dex */
public final class ByteVector extends BaseVector {
    public ByteVector __assign(int i, ByteBuffer byteBuffer) {
        __reset(i, 1, byteBuffer);
        return this;
    }

    public byte get(int i) {
        return this.bb.get(__element(i));
    }

    public int getAsUnsigned(int i) {
        return get(i) & UByte.MAX_VALUE;
    }
}
