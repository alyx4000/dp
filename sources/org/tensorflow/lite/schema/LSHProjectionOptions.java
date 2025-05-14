package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class LSHProjectionOptions extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static LSHProjectionOptions getRootAsLSHProjectionOptions(ByteBuffer byteBuffer) {
        return getRootAsLSHProjectionOptions(byteBuffer, new LSHProjectionOptions());
    }

    public static LSHProjectionOptions getRootAsLSHProjectionOptions(ByteBuffer byteBuffer, LSHProjectionOptions lSHProjectionOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return lSHProjectionOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public LSHProjectionOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public byte type() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return this.bb.get(__offset + this.bb_pos);
        }
        return (byte) 0;
    }

    public static int createLSHProjectionOptions(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.startTable(1);
        addType(flatBufferBuilder, b);
        return endLSHProjectionOptions(flatBufferBuilder);
    }

    public static void startLSHProjectionOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(1);
    }

    public static void addType(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.addByte(0, b, 0);
    }

    public static int endLSHProjectionOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public LSHProjectionOptions get(int i) {
            return get(new LSHProjectionOptions(), i);
        }

        public LSHProjectionOptions get(LSHProjectionOptions lSHProjectionOptions, int i) {
            return lSHProjectionOptions.__assign(LSHProjectionOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public LSHProjectionOptionsT unpack() {
        LSHProjectionOptionsT lSHProjectionOptionsT = new LSHProjectionOptionsT();
        unpackTo(lSHProjectionOptionsT);
        return lSHProjectionOptionsT;
    }

    public void unpackTo(LSHProjectionOptionsT lSHProjectionOptionsT) {
        lSHProjectionOptionsT.setType(type());
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, LSHProjectionOptionsT lSHProjectionOptionsT) {
        if (lSHProjectionOptionsT == null) {
            return 0;
        }
        return createLSHProjectionOptions(flatBufferBuilder, lSHProjectionOptionsT.getType());
    }
}
