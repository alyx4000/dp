package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class ScatterNdOptions extends Table {
    public void unpackTo(ScatterNdOptionsT scatterNdOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static ScatterNdOptions getRootAsScatterNdOptions(ByteBuffer byteBuffer) {
        return getRootAsScatterNdOptions(byteBuffer, new ScatterNdOptions());
    }

    public static ScatterNdOptions getRootAsScatterNdOptions(ByteBuffer byteBuffer, ScatterNdOptions scatterNdOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return scatterNdOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public ScatterNdOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startScatterNdOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endScatterNdOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public ScatterNdOptions get(int i) {
            return get(new ScatterNdOptions(), i);
        }

        public ScatterNdOptions get(ScatterNdOptions scatterNdOptions, int i) {
            return scatterNdOptions.__assign(ScatterNdOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public ScatterNdOptionsT unpack() {
        ScatterNdOptionsT scatterNdOptionsT = new ScatterNdOptionsT();
        unpackTo(scatterNdOptionsT);
        return scatterNdOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, ScatterNdOptionsT scatterNdOptionsT) {
        if (scatterNdOptionsT == null) {
            return 0;
        }
        startScatterNdOptions(flatBufferBuilder);
        return endScatterNdOptions(flatBufferBuilder);
    }
}
