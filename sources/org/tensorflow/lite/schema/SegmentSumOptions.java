package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class SegmentSumOptions extends Table {
    public void unpackTo(SegmentSumOptionsT segmentSumOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static SegmentSumOptions getRootAsSegmentSumOptions(ByteBuffer byteBuffer) {
        return getRootAsSegmentSumOptions(byteBuffer, new SegmentSumOptions());
    }

    public static SegmentSumOptions getRootAsSegmentSumOptions(ByteBuffer byteBuffer, SegmentSumOptions segmentSumOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return segmentSumOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public SegmentSumOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startSegmentSumOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endSegmentSumOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public SegmentSumOptions get(int i) {
            return get(new SegmentSumOptions(), i);
        }

        public SegmentSumOptions get(SegmentSumOptions segmentSumOptions, int i) {
            return segmentSumOptions.__assign(SegmentSumOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public SegmentSumOptionsT unpack() {
        SegmentSumOptionsT segmentSumOptionsT = new SegmentSumOptionsT();
        unpackTo(segmentSumOptionsT);
        return segmentSumOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, SegmentSumOptionsT segmentSumOptionsT) {
        if (segmentSumOptionsT == null) {
            return 0;
        }
        startSegmentSumOptions(flatBufferBuilder);
        return endSegmentSumOptions(flatBufferBuilder);
    }
}
