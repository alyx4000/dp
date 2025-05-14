package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class LogSoftmaxOptions extends Table {
    public void unpackTo(LogSoftmaxOptionsT logSoftmaxOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static LogSoftmaxOptions getRootAsLogSoftmaxOptions(ByteBuffer byteBuffer) {
        return getRootAsLogSoftmaxOptions(byteBuffer, new LogSoftmaxOptions());
    }

    public static LogSoftmaxOptions getRootAsLogSoftmaxOptions(ByteBuffer byteBuffer, LogSoftmaxOptions logSoftmaxOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return logSoftmaxOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public LogSoftmaxOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startLogSoftmaxOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endLogSoftmaxOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public LogSoftmaxOptions get(int i) {
            return get(new LogSoftmaxOptions(), i);
        }

        public LogSoftmaxOptions get(LogSoftmaxOptions logSoftmaxOptions, int i) {
            return logSoftmaxOptions.__assign(LogSoftmaxOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public LogSoftmaxOptionsT unpack() {
        LogSoftmaxOptionsT logSoftmaxOptionsT = new LogSoftmaxOptionsT();
        unpackTo(logSoftmaxOptionsT);
        return logSoftmaxOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, LogSoftmaxOptionsT logSoftmaxOptionsT) {
        if (logSoftmaxOptionsT == null) {
            return 0;
        }
        startLogSoftmaxOptions(flatBufferBuilder);
        return endLogSoftmaxOptions(flatBufferBuilder);
    }
}
