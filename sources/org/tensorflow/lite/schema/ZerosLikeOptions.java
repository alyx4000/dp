package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class ZerosLikeOptions extends Table {
    public void unpackTo(ZerosLikeOptionsT zerosLikeOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static ZerosLikeOptions getRootAsZerosLikeOptions(ByteBuffer byteBuffer) {
        return getRootAsZerosLikeOptions(byteBuffer, new ZerosLikeOptions());
    }

    public static ZerosLikeOptions getRootAsZerosLikeOptions(ByteBuffer byteBuffer, ZerosLikeOptions zerosLikeOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return zerosLikeOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public ZerosLikeOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startZerosLikeOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endZerosLikeOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public ZerosLikeOptions get(int i) {
            return get(new ZerosLikeOptions(), i);
        }

        public ZerosLikeOptions get(ZerosLikeOptions zerosLikeOptions, int i) {
            return zerosLikeOptions.__assign(ZerosLikeOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public ZerosLikeOptionsT unpack() {
        ZerosLikeOptionsT zerosLikeOptionsT = new ZerosLikeOptionsT();
        unpackTo(zerosLikeOptionsT);
        return zerosLikeOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, ZerosLikeOptionsT zerosLikeOptionsT) {
        if (zerosLikeOptionsT == null) {
            return 0;
        }
        startZerosLikeOptions(flatBufferBuilder);
        return endZerosLikeOptions(flatBufferBuilder);
    }
}
