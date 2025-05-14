package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class SquareOptions extends Table {
    public void unpackTo(SquareOptionsT squareOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static SquareOptions getRootAsSquareOptions(ByteBuffer byteBuffer) {
        return getRootAsSquareOptions(byteBuffer, new SquareOptions());
    }

    public static SquareOptions getRootAsSquareOptions(ByteBuffer byteBuffer, SquareOptions squareOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return squareOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public SquareOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startSquareOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endSquareOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public SquareOptions get(int i) {
            return get(new SquareOptions(), i);
        }

        public SquareOptions get(SquareOptions squareOptions, int i) {
            return squareOptions.__assign(SquareOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public SquareOptionsT unpack() {
        SquareOptionsT squareOptionsT = new SquareOptionsT();
        unpackTo(squareOptionsT);
        return squareOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, SquareOptionsT squareOptionsT) {
        if (squareOptionsT == null) {
            return 0;
        }
        startSquareOptions(flatBufferBuilder);
        return endSquareOptions(flatBufferBuilder);
    }
}
