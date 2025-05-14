package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class TransposeOptions extends Table {
    public void unpackTo(TransposeOptionsT transposeOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static TransposeOptions getRootAsTransposeOptions(ByteBuffer byteBuffer) {
        return getRootAsTransposeOptions(byteBuffer, new TransposeOptions());
    }

    public static TransposeOptions getRootAsTransposeOptions(ByteBuffer byteBuffer, TransposeOptions transposeOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return transposeOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public TransposeOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startTransposeOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endTransposeOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public TransposeOptions get(int i) {
            return get(new TransposeOptions(), i);
        }

        public TransposeOptions get(TransposeOptions transposeOptions, int i) {
            return transposeOptions.__assign(TransposeOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public TransposeOptionsT unpack() {
        TransposeOptionsT transposeOptionsT = new TransposeOptionsT();
        unpackTo(transposeOptionsT);
        return transposeOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, TransposeOptionsT transposeOptionsT) {
        if (transposeOptionsT == null) {
            return 0;
        }
        startTransposeOptions(flatBufferBuilder);
        return endTransposeOptions(flatBufferBuilder);
    }
}
