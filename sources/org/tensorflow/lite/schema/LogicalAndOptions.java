package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class LogicalAndOptions extends Table {
    public void unpackTo(LogicalAndOptionsT logicalAndOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static LogicalAndOptions getRootAsLogicalAndOptions(ByteBuffer byteBuffer) {
        return getRootAsLogicalAndOptions(byteBuffer, new LogicalAndOptions());
    }

    public static LogicalAndOptions getRootAsLogicalAndOptions(ByteBuffer byteBuffer, LogicalAndOptions logicalAndOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return logicalAndOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public LogicalAndOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startLogicalAndOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endLogicalAndOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public LogicalAndOptions get(int i) {
            return get(new LogicalAndOptions(), i);
        }

        public LogicalAndOptions get(LogicalAndOptions logicalAndOptions, int i) {
            return logicalAndOptions.__assign(LogicalAndOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public LogicalAndOptionsT unpack() {
        LogicalAndOptionsT logicalAndOptionsT = new LogicalAndOptionsT();
        unpackTo(logicalAndOptionsT);
        return logicalAndOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, LogicalAndOptionsT logicalAndOptionsT) {
        if (logicalAndOptionsT == null) {
            return 0;
        }
        startLogicalAndOptions(flatBufferBuilder);
        return endLogicalAndOptions(flatBufferBuilder);
    }
}
