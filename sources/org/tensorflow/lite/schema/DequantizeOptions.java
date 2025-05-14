package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class DequantizeOptions extends Table {
    public void unpackTo(DequantizeOptionsT dequantizeOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static DequantizeOptions getRootAsDequantizeOptions(ByteBuffer byteBuffer) {
        return getRootAsDequantizeOptions(byteBuffer, new DequantizeOptions());
    }

    public static DequantizeOptions getRootAsDequantizeOptions(ByteBuffer byteBuffer, DequantizeOptions dequantizeOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return dequantizeOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public DequantizeOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startDequantizeOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endDequantizeOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public DequantizeOptions get(int i) {
            return get(new DequantizeOptions(), i);
        }

        public DequantizeOptions get(DequantizeOptions dequantizeOptions, int i) {
            return dequantizeOptions.__assign(DequantizeOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public DequantizeOptionsT unpack() {
        DequantizeOptionsT dequantizeOptionsT = new DequantizeOptionsT();
        unpackTo(dequantizeOptionsT);
        return dequantizeOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, DequantizeOptionsT dequantizeOptionsT) {
        if (dequantizeOptionsT == null) {
            return 0;
        }
        startDequantizeOptions(flatBufferBuilder);
        return endDequantizeOptions(flatBufferBuilder);
    }
}
