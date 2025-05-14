package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class PowOptions extends Table {
    public void unpackTo(PowOptionsT powOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static PowOptions getRootAsPowOptions(ByteBuffer byteBuffer) {
        return getRootAsPowOptions(byteBuffer, new PowOptions());
    }

    public static PowOptions getRootAsPowOptions(ByteBuffer byteBuffer, PowOptions powOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return powOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public PowOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startPowOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endPowOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public PowOptions get(int i) {
            return get(new PowOptions(), i);
        }

        public PowOptions get(PowOptions powOptions, int i) {
            return powOptions.__assign(PowOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public PowOptionsT unpack() {
        PowOptionsT powOptionsT = new PowOptionsT();
        unpackTo(powOptionsT);
        return powOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, PowOptionsT powOptionsT) {
        if (powOptionsT == null) {
            return 0;
        }
        startPowOptions(flatBufferBuilder);
        return endPowOptions(flatBufferBuilder);
    }
}
