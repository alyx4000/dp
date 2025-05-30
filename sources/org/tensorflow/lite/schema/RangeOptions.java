package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class RangeOptions extends Table {
    public void unpackTo(RangeOptionsT rangeOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static RangeOptions getRootAsRangeOptions(ByteBuffer byteBuffer) {
        return getRootAsRangeOptions(byteBuffer, new RangeOptions());
    }

    public static RangeOptions getRootAsRangeOptions(ByteBuffer byteBuffer, RangeOptions rangeOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return rangeOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public RangeOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startRangeOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endRangeOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public RangeOptions get(int i) {
            return get(new RangeOptions(), i);
        }

        public RangeOptions get(RangeOptions rangeOptions, int i) {
            return rangeOptions.__assign(RangeOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public RangeOptionsT unpack() {
        RangeOptionsT rangeOptionsT = new RangeOptionsT();
        unpackTo(rangeOptionsT);
        return rangeOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, RangeOptionsT rangeOptionsT) {
        if (rangeOptionsT == null) {
            return 0;
        }
        startRangeOptions(flatBufferBuilder);
        return endRangeOptions(flatBufferBuilder);
    }
}
