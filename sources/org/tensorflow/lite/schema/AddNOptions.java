package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class AddNOptions extends Table {
    public void unpackTo(AddNOptionsT addNOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static AddNOptions getRootAsAddNOptions(ByteBuffer byteBuffer) {
        return getRootAsAddNOptions(byteBuffer, new AddNOptions());
    }

    public static AddNOptions getRootAsAddNOptions(ByteBuffer byteBuffer, AddNOptions addNOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return addNOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public AddNOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startAddNOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endAddNOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public AddNOptions get(int i) {
            return get(new AddNOptions(), i);
        }

        public AddNOptions get(AddNOptions addNOptions, int i) {
            return addNOptions.__assign(AddNOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public AddNOptionsT unpack() {
        AddNOptionsT addNOptionsT = new AddNOptionsT();
        unpackTo(addNOptionsT);
        return addNOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, AddNOptionsT addNOptionsT) {
        if (addNOptionsT == null) {
            return 0;
        }
        startAddNOptions(flatBufferBuilder);
        return endAddNOptions(flatBufferBuilder);
    }
}
