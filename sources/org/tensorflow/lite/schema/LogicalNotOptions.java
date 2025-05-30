package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class LogicalNotOptions extends Table {
    public void unpackTo(LogicalNotOptionsT logicalNotOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static LogicalNotOptions getRootAsLogicalNotOptions(ByteBuffer byteBuffer) {
        return getRootAsLogicalNotOptions(byteBuffer, new LogicalNotOptions());
    }

    public static LogicalNotOptions getRootAsLogicalNotOptions(ByteBuffer byteBuffer, LogicalNotOptions logicalNotOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return logicalNotOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public LogicalNotOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startLogicalNotOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endLogicalNotOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public LogicalNotOptions get(int i) {
            return get(new LogicalNotOptions(), i);
        }

        public LogicalNotOptions get(LogicalNotOptions logicalNotOptions, int i) {
            return logicalNotOptions.__assign(LogicalNotOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public LogicalNotOptionsT unpack() {
        LogicalNotOptionsT logicalNotOptionsT = new LogicalNotOptionsT();
        unpackTo(logicalNotOptionsT);
        return logicalNotOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, LogicalNotOptionsT logicalNotOptionsT) {
        if (logicalNotOptionsT == null) {
            return 0;
        }
        startLogicalNotOptions(flatBufferBuilder);
        return endLogicalNotOptions(flatBufferBuilder);
    }
}
