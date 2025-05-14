package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class UnsortedSegmentMaxOptions extends Table {
    public void unpackTo(UnsortedSegmentMaxOptionsT unsortedSegmentMaxOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static UnsortedSegmentMaxOptions getRootAsUnsortedSegmentMaxOptions(ByteBuffer byteBuffer) {
        return getRootAsUnsortedSegmentMaxOptions(byteBuffer, new UnsortedSegmentMaxOptions());
    }

    public static UnsortedSegmentMaxOptions getRootAsUnsortedSegmentMaxOptions(ByteBuffer byteBuffer, UnsortedSegmentMaxOptions unsortedSegmentMaxOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return unsortedSegmentMaxOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public UnsortedSegmentMaxOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startUnsortedSegmentMaxOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endUnsortedSegmentMaxOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public UnsortedSegmentMaxOptions get(int i) {
            return get(new UnsortedSegmentMaxOptions(), i);
        }

        public UnsortedSegmentMaxOptions get(UnsortedSegmentMaxOptions unsortedSegmentMaxOptions, int i) {
            return unsortedSegmentMaxOptions.__assign(UnsortedSegmentMaxOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public UnsortedSegmentMaxOptionsT unpack() {
        UnsortedSegmentMaxOptionsT unsortedSegmentMaxOptionsT = new UnsortedSegmentMaxOptionsT();
        unpackTo(unsortedSegmentMaxOptionsT);
        return unsortedSegmentMaxOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, UnsortedSegmentMaxOptionsT unsortedSegmentMaxOptionsT) {
        if (unsortedSegmentMaxOptionsT == null) {
            return 0;
        }
        startUnsortedSegmentMaxOptions(flatBufferBuilder);
        return endUnsortedSegmentMaxOptions(flatBufferBuilder);
    }
}
