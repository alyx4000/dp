package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class UnsortedSegmentProdOptions extends Table {
    public void unpackTo(UnsortedSegmentProdOptionsT unsortedSegmentProdOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static UnsortedSegmentProdOptions getRootAsUnsortedSegmentProdOptions(ByteBuffer byteBuffer) {
        return getRootAsUnsortedSegmentProdOptions(byteBuffer, new UnsortedSegmentProdOptions());
    }

    public static UnsortedSegmentProdOptions getRootAsUnsortedSegmentProdOptions(ByteBuffer byteBuffer, UnsortedSegmentProdOptions unsortedSegmentProdOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return unsortedSegmentProdOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public UnsortedSegmentProdOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startUnsortedSegmentProdOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endUnsortedSegmentProdOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public UnsortedSegmentProdOptions get(int i) {
            return get(new UnsortedSegmentProdOptions(), i);
        }

        public UnsortedSegmentProdOptions get(UnsortedSegmentProdOptions unsortedSegmentProdOptions, int i) {
            return unsortedSegmentProdOptions.__assign(UnsortedSegmentProdOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public UnsortedSegmentProdOptionsT unpack() {
        UnsortedSegmentProdOptionsT unsortedSegmentProdOptionsT = new UnsortedSegmentProdOptionsT();
        unpackTo(unsortedSegmentProdOptionsT);
        return unsortedSegmentProdOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, UnsortedSegmentProdOptionsT unsortedSegmentProdOptionsT) {
        if (unsortedSegmentProdOptionsT == null) {
            return 0;
        }
        startUnsortedSegmentProdOptions(flatBufferBuilder);
        return endUnsortedSegmentProdOptions(flatBufferBuilder);
    }
}
