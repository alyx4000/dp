package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class NegOptions extends Table {
    public void unpackTo(NegOptionsT negOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static NegOptions getRootAsNegOptions(ByteBuffer byteBuffer) {
        return getRootAsNegOptions(byteBuffer, new NegOptions());
    }

    public static NegOptions getRootAsNegOptions(ByteBuffer byteBuffer, NegOptions negOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return negOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public NegOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startNegOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endNegOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public NegOptions get(int i) {
            return get(new NegOptions(), i);
        }

        public NegOptions get(NegOptions negOptions, int i) {
            return negOptions.__assign(NegOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public NegOptionsT unpack() {
        NegOptionsT negOptionsT = new NegOptionsT();
        unpackTo(negOptionsT);
        return negOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, NegOptionsT negOptionsT) {
        if (negOptionsT == null) {
            return 0;
        }
        startNegOptions(flatBufferBuilder);
        return endNegOptions(flatBufferBuilder);
    }
}
