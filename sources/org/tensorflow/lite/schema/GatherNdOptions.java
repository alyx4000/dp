package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class GatherNdOptions extends Table {
    public void unpackTo(GatherNdOptionsT gatherNdOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static GatherNdOptions getRootAsGatherNdOptions(ByteBuffer byteBuffer) {
        return getRootAsGatherNdOptions(byteBuffer, new GatherNdOptions());
    }

    public static GatherNdOptions getRootAsGatherNdOptions(ByteBuffer byteBuffer, GatherNdOptions gatherNdOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return gatherNdOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public GatherNdOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startGatherNdOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endGatherNdOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public GatherNdOptions get(int i) {
            return get(new GatherNdOptions(), i);
        }

        public GatherNdOptions get(GatherNdOptions gatherNdOptions, int i) {
            return gatherNdOptions.__assign(GatherNdOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public GatherNdOptionsT unpack() {
        GatherNdOptionsT gatherNdOptionsT = new GatherNdOptionsT();
        unpackTo(gatherNdOptionsT);
        return gatherNdOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, GatherNdOptionsT gatherNdOptionsT) {
        if (gatherNdOptionsT == null) {
            return 0;
        }
        startGatherNdOptions(flatBufferBuilder);
        return endGatherNdOptions(flatBufferBuilder);
    }
}
