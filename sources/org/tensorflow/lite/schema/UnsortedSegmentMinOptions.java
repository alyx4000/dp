package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class UnsortedSegmentMinOptions extends Table {
    public void unpackTo(UnsortedSegmentMinOptionsT unsortedSegmentMinOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static UnsortedSegmentMinOptions getRootAsUnsortedSegmentMinOptions(ByteBuffer byteBuffer) {
        return getRootAsUnsortedSegmentMinOptions(byteBuffer, new UnsortedSegmentMinOptions());
    }

    public static UnsortedSegmentMinOptions getRootAsUnsortedSegmentMinOptions(ByteBuffer byteBuffer, UnsortedSegmentMinOptions unsortedSegmentMinOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return unsortedSegmentMinOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public UnsortedSegmentMinOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startUnsortedSegmentMinOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endUnsortedSegmentMinOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public UnsortedSegmentMinOptions get(int i) {
            return get(new UnsortedSegmentMinOptions(), i);
        }

        public UnsortedSegmentMinOptions get(UnsortedSegmentMinOptions unsortedSegmentMinOptions, int i) {
            return unsortedSegmentMinOptions.__assign(UnsortedSegmentMinOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public UnsortedSegmentMinOptionsT unpack() {
        UnsortedSegmentMinOptionsT unsortedSegmentMinOptionsT = new UnsortedSegmentMinOptionsT();
        unpackTo(unsortedSegmentMinOptionsT);
        return unsortedSegmentMinOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, UnsortedSegmentMinOptionsT unsortedSegmentMinOptionsT) {
        if (unsortedSegmentMinOptionsT == null) {
            return 0;
        }
        startUnsortedSegmentMinOptions(flatBufferBuilder);
        return endUnsortedSegmentMinOptions(flatBufferBuilder);
    }
}
