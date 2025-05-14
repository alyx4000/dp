package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class GreaterOptions extends Table {
    public void unpackTo(GreaterOptionsT greaterOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static GreaterOptions getRootAsGreaterOptions(ByteBuffer byteBuffer) {
        return getRootAsGreaterOptions(byteBuffer, new GreaterOptions());
    }

    public static GreaterOptions getRootAsGreaterOptions(ByteBuffer byteBuffer, GreaterOptions greaterOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return greaterOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public GreaterOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startGreaterOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endGreaterOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public GreaterOptions get(int i) {
            return get(new GreaterOptions(), i);
        }

        public GreaterOptions get(GreaterOptions greaterOptions, int i) {
            return greaterOptions.__assign(GreaterOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public GreaterOptionsT unpack() {
        GreaterOptionsT greaterOptionsT = new GreaterOptionsT();
        unpackTo(greaterOptionsT);
        return greaterOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, GreaterOptionsT greaterOptionsT) {
        if (greaterOptionsT == null) {
            return 0;
        }
        startGreaterOptions(flatBufferBuilder);
        return endGreaterOptions(flatBufferBuilder);
    }
}
