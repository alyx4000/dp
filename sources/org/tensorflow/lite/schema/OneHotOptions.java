package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class OneHotOptions extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static OneHotOptions getRootAsOneHotOptions(ByteBuffer byteBuffer) {
        return getRootAsOneHotOptions(byteBuffer, new OneHotOptions());
    }

    public static OneHotOptions getRootAsOneHotOptions(ByteBuffer byteBuffer, OneHotOptions oneHotOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return oneHotOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public OneHotOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public int axis() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return this.bb.getInt(__offset + this.bb_pos);
        }
        return 0;
    }

    public static int createOneHotOptions(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startTable(1);
        addAxis(flatBufferBuilder, i);
        return endOneHotOptions(flatBufferBuilder);
    }

    public static void startOneHotOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(1);
    }

    public static void addAxis(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addInt(0, i, 0);
    }

    public static int endOneHotOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public OneHotOptions get(int i) {
            return get(new OneHotOptions(), i);
        }

        public OneHotOptions get(OneHotOptions oneHotOptions, int i) {
            return oneHotOptions.__assign(OneHotOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public OneHotOptionsT unpack() {
        OneHotOptionsT oneHotOptionsT = new OneHotOptionsT();
        unpackTo(oneHotOptionsT);
        return oneHotOptionsT;
    }

    public void unpackTo(OneHotOptionsT oneHotOptionsT) {
        oneHotOptionsT.setAxis(axis());
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, OneHotOptionsT oneHotOptionsT) {
        if (oneHotOptionsT == null) {
            return 0;
        }
        return createOneHotOptions(flatBufferBuilder, oneHotOptionsT.getAxis());
    }
}
