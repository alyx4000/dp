package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class ExpOptions extends Table {
    public void unpackTo(ExpOptionsT expOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static ExpOptions getRootAsExpOptions(ByteBuffer byteBuffer) {
        return getRootAsExpOptions(byteBuffer, new ExpOptions());
    }

    public static ExpOptions getRootAsExpOptions(ByteBuffer byteBuffer, ExpOptions expOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return expOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public ExpOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startExpOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endExpOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public ExpOptions get(int i) {
            return get(new ExpOptions(), i);
        }

        public ExpOptions get(ExpOptions expOptions, int i) {
            return expOptions.__assign(ExpOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public ExpOptionsT unpack() {
        ExpOptionsT expOptionsT = new ExpOptionsT();
        unpackTo(expOptionsT);
        return expOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, ExpOptionsT expOptionsT) {
        if (expOptionsT == null) {
            return 0;
        }
        startExpOptions(flatBufferBuilder);
        return endExpOptions(flatBufferBuilder);
    }
}
