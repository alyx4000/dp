package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class CastOptions extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static CastOptions getRootAsCastOptions(ByteBuffer byteBuffer) {
        return getRootAsCastOptions(byteBuffer, new CastOptions());
    }

    public static CastOptions getRootAsCastOptions(ByteBuffer byteBuffer, CastOptions castOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return castOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public CastOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public byte inDataType() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return this.bb.get(__offset + this.bb_pos);
        }
        return (byte) 0;
    }

    public byte outDataType() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return this.bb.get(__offset + this.bb_pos);
        }
        return (byte) 0;
    }

    public static int createCastOptions(FlatBufferBuilder flatBufferBuilder, byte b, byte b2) {
        flatBufferBuilder.startTable(2);
        addOutDataType(flatBufferBuilder, b2);
        addInDataType(flatBufferBuilder, b);
        return endCastOptions(flatBufferBuilder);
    }

    public static void startCastOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(2);
    }

    public static void addInDataType(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.addByte(0, b, 0);
    }

    public static void addOutDataType(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.addByte(1, b, 0);
    }

    public static int endCastOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public CastOptions get(int i) {
            return get(new CastOptions(), i);
        }

        public CastOptions get(CastOptions castOptions, int i) {
            return castOptions.__assign(CastOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public CastOptionsT unpack() {
        CastOptionsT castOptionsT = new CastOptionsT();
        unpackTo(castOptionsT);
        return castOptionsT;
    }

    public void unpackTo(CastOptionsT castOptionsT) {
        castOptionsT.setInDataType(inDataType());
        castOptionsT.setOutDataType(outDataType());
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, CastOptionsT castOptionsT) {
        if (castOptionsT == null) {
            return 0;
        }
        return createCastOptions(flatBufferBuilder, castOptionsT.getInDataType(), castOptionsT.getOutDataType());
    }
}
