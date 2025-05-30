package com.google.flatbuffers;

import java.nio.ByteBuffer;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes5.dex */
public final class IntVector extends BaseVector {
    public IntVector __assign(int i, ByteBuffer byteBuffer) {
        __reset(i, 4, byteBuffer);
        return this;
    }

    public int get(int i) {
        return this.bb.getInt(__element(i));
    }

    public long getAsUnsigned(int i) {
        return get(i) & BodyPartID.bodyIdMax;
    }
}
