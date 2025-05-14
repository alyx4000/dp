package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class ReadVariableOptions extends Table {
    public void unpackTo(ReadVariableOptionsT readVariableOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static ReadVariableOptions getRootAsReadVariableOptions(ByteBuffer byteBuffer) {
        return getRootAsReadVariableOptions(byteBuffer, new ReadVariableOptions());
    }

    public static ReadVariableOptions getRootAsReadVariableOptions(ByteBuffer byteBuffer, ReadVariableOptions readVariableOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return readVariableOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public ReadVariableOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startReadVariableOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endReadVariableOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public ReadVariableOptions get(int i) {
            return get(new ReadVariableOptions(), i);
        }

        public ReadVariableOptions get(ReadVariableOptions readVariableOptions, int i) {
            return readVariableOptions.__assign(ReadVariableOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public ReadVariableOptionsT unpack() {
        ReadVariableOptionsT readVariableOptionsT = new ReadVariableOptionsT();
        unpackTo(readVariableOptionsT);
        return readVariableOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, ReadVariableOptionsT readVariableOptionsT) {
        if (readVariableOptionsT == null) {
            return 0;
        }
        startReadVariableOptions(flatBufferBuilder);
        return endReadVariableOptions(flatBufferBuilder);
    }
}
