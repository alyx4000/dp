package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class GreaterEqualOptions extends Table {
    public void unpackTo(GreaterEqualOptionsT greaterEqualOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static GreaterEqualOptions getRootAsGreaterEqualOptions(ByteBuffer byteBuffer) {
        return getRootAsGreaterEqualOptions(byteBuffer, new GreaterEqualOptions());
    }

    public static GreaterEqualOptions getRootAsGreaterEqualOptions(ByteBuffer byteBuffer, GreaterEqualOptions greaterEqualOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return greaterEqualOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public GreaterEqualOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startGreaterEqualOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endGreaterEqualOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public GreaterEqualOptions get(int i) {
            return get(new GreaterEqualOptions(), i);
        }

        public GreaterEqualOptions get(GreaterEqualOptions greaterEqualOptions, int i) {
            return greaterEqualOptions.__assign(GreaterEqualOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public GreaterEqualOptionsT unpack() {
        GreaterEqualOptionsT greaterEqualOptionsT = new GreaterEqualOptionsT();
        unpackTo(greaterEqualOptionsT);
        return greaterEqualOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, GreaterEqualOptionsT greaterEqualOptionsT) {
        if (greaterEqualOptionsT == null) {
            return 0;
        }
        startGreaterEqualOptions(flatBufferBuilder);
        return endGreaterEqualOptions(flatBufferBuilder);
    }
}
