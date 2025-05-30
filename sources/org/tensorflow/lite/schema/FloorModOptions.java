package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class FloorModOptions extends Table {
    public void unpackTo(FloorModOptionsT floorModOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static FloorModOptions getRootAsFloorModOptions(ByteBuffer byteBuffer) {
        return getRootAsFloorModOptions(byteBuffer, new FloorModOptions());
    }

    public static FloorModOptions getRootAsFloorModOptions(ByteBuffer byteBuffer, FloorModOptions floorModOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return floorModOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public FloorModOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startFloorModOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endFloorModOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public FloorModOptions get(int i) {
            return get(new FloorModOptions(), i);
        }

        public FloorModOptions get(FloorModOptions floorModOptions, int i) {
            return floorModOptions.__assign(FloorModOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public FloorModOptionsT unpack() {
        FloorModOptionsT floorModOptionsT = new FloorModOptionsT();
        unpackTo(floorModOptionsT);
        return floorModOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, FloorModOptionsT floorModOptionsT) {
        if (floorModOptionsT == null) {
            return 0;
        }
        startFloorModOptions(flatBufferBuilder);
        return endFloorModOptions(flatBufferBuilder);
    }
}
