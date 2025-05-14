package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class SquaredDifferenceOptions extends Table {
    public void unpackTo(SquaredDifferenceOptionsT squaredDifferenceOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static SquaredDifferenceOptions getRootAsSquaredDifferenceOptions(ByteBuffer byteBuffer) {
        return getRootAsSquaredDifferenceOptions(byteBuffer, new SquaredDifferenceOptions());
    }

    public static SquaredDifferenceOptions getRootAsSquaredDifferenceOptions(ByteBuffer byteBuffer, SquaredDifferenceOptions squaredDifferenceOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return squaredDifferenceOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public SquaredDifferenceOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startSquaredDifferenceOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endSquaredDifferenceOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public SquaredDifferenceOptions get(int i) {
            return get(new SquaredDifferenceOptions(), i);
        }

        public SquaredDifferenceOptions get(SquaredDifferenceOptions squaredDifferenceOptions, int i) {
            return squaredDifferenceOptions.__assign(SquaredDifferenceOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public SquaredDifferenceOptionsT unpack() {
        SquaredDifferenceOptionsT squaredDifferenceOptionsT = new SquaredDifferenceOptionsT();
        unpackTo(squaredDifferenceOptionsT);
        return squaredDifferenceOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, SquaredDifferenceOptionsT squaredDifferenceOptionsT) {
        if (squaredDifferenceOptionsT == null) {
            return 0;
        }
        startSquaredDifferenceOptions(flatBufferBuilder);
        return endSquaredDifferenceOptions(flatBufferBuilder);
    }
}
