package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class FloorDivOptions extends Table {
    public void unpackTo(FloorDivOptionsT floorDivOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static FloorDivOptions getRootAsFloorDivOptions(ByteBuffer byteBuffer) {
        return getRootAsFloorDivOptions(byteBuffer, new FloorDivOptions());
    }

    public static FloorDivOptions getRootAsFloorDivOptions(ByteBuffer byteBuffer, FloorDivOptions floorDivOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return floorDivOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public FloorDivOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startFloorDivOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endFloorDivOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public FloorDivOptions get(int i) {
            return get(new FloorDivOptions(), i);
        }

        public FloorDivOptions get(FloorDivOptions floorDivOptions, int i) {
            return floorDivOptions.__assign(FloorDivOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public FloorDivOptionsT unpack() {
        FloorDivOptionsT floorDivOptionsT = new FloorDivOptionsT();
        unpackTo(floorDivOptionsT);
        return floorDivOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, FloorDivOptionsT floorDivOptionsT) {
        if (floorDivOptionsT == null) {
            return 0;
        }
        startFloorDivOptions(flatBufferBuilder);
        return endFloorDivOptions(flatBufferBuilder);
    }
}
