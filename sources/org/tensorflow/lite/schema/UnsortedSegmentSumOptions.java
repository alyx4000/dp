package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class UnsortedSegmentSumOptions extends Table {
    public void unpackTo(UnsortedSegmentSumOptionsT unsortedSegmentSumOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static UnsortedSegmentSumOptions getRootAsUnsortedSegmentSumOptions(ByteBuffer byteBuffer) {
        return getRootAsUnsortedSegmentSumOptions(byteBuffer, new UnsortedSegmentSumOptions());
    }

    public static UnsortedSegmentSumOptions getRootAsUnsortedSegmentSumOptions(ByteBuffer byteBuffer, UnsortedSegmentSumOptions unsortedSegmentSumOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return unsortedSegmentSumOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public UnsortedSegmentSumOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startUnsortedSegmentSumOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endUnsortedSegmentSumOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public UnsortedSegmentSumOptions get(int i) {
            return get(new UnsortedSegmentSumOptions(), i);
        }

        public UnsortedSegmentSumOptions get(UnsortedSegmentSumOptions unsortedSegmentSumOptions, int i) {
            return unsortedSegmentSumOptions.__assign(UnsortedSegmentSumOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public UnsortedSegmentSumOptionsT unpack() {
        UnsortedSegmentSumOptionsT unsortedSegmentSumOptionsT = new UnsortedSegmentSumOptionsT();
        unpackTo(unsortedSegmentSumOptionsT);
        return unsortedSegmentSumOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, UnsortedSegmentSumOptionsT unsortedSegmentSumOptionsT) {
        if (unsortedSegmentSumOptionsT == null) {
            return 0;
        }
        startUnsortedSegmentSumOptions(flatBufferBuilder);
        return endUnsortedSegmentSumOptions(flatBufferBuilder);
    }
}
