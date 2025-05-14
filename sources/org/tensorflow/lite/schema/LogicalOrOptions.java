package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class LogicalOrOptions extends Table {
    public void unpackTo(LogicalOrOptionsT logicalOrOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static LogicalOrOptions getRootAsLogicalOrOptions(ByteBuffer byteBuffer) {
        return getRootAsLogicalOrOptions(byteBuffer, new LogicalOrOptions());
    }

    public static LogicalOrOptions getRootAsLogicalOrOptions(ByteBuffer byteBuffer, LogicalOrOptions logicalOrOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return logicalOrOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public LogicalOrOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startLogicalOrOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endLogicalOrOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public LogicalOrOptions get(int i) {
            return get(new LogicalOrOptions(), i);
        }

        public LogicalOrOptions get(LogicalOrOptions logicalOrOptions, int i) {
            return logicalOrOptions.__assign(LogicalOrOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public LogicalOrOptionsT unpack() {
        LogicalOrOptionsT logicalOrOptionsT = new LogicalOrOptionsT();
        unpackTo(logicalOrOptionsT);
        return logicalOrOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, LogicalOrOptionsT logicalOrOptionsT) {
        if (logicalOrOptionsT == null) {
            return 0;
        }
        startLogicalOrOptions(flatBufferBuilder);
        return endLogicalOrOptions(flatBufferBuilder);
    }
}
