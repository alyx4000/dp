package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class MaximumMinimumOptions extends Table {
    public void unpackTo(MaximumMinimumOptionsT maximumMinimumOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static MaximumMinimumOptions getRootAsMaximumMinimumOptions(ByteBuffer byteBuffer) {
        return getRootAsMaximumMinimumOptions(byteBuffer, new MaximumMinimumOptions());
    }

    public static MaximumMinimumOptions getRootAsMaximumMinimumOptions(ByteBuffer byteBuffer, MaximumMinimumOptions maximumMinimumOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return maximumMinimumOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public MaximumMinimumOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startMaximumMinimumOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endMaximumMinimumOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public MaximumMinimumOptions get(int i) {
            return get(new MaximumMinimumOptions(), i);
        }

        public MaximumMinimumOptions get(MaximumMinimumOptions maximumMinimumOptions, int i) {
            return maximumMinimumOptions.__assign(MaximumMinimumOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public MaximumMinimumOptionsT unpack() {
        MaximumMinimumOptionsT maximumMinimumOptionsT = new MaximumMinimumOptionsT();
        unpackTo(maximumMinimumOptionsT);
        return maximumMinimumOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, MaximumMinimumOptionsT maximumMinimumOptionsT) {
        if (maximumMinimumOptionsT == null) {
            return 0;
        }
        startMaximumMinimumOptions(flatBufferBuilder);
        return endMaximumMinimumOptions(flatBufferBuilder);
    }
}
