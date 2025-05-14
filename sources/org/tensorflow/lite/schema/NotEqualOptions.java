package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class NotEqualOptions extends Table {
    public void unpackTo(NotEqualOptionsT notEqualOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static NotEqualOptions getRootAsNotEqualOptions(ByteBuffer byteBuffer) {
        return getRootAsNotEqualOptions(byteBuffer, new NotEqualOptions());
    }

    public static NotEqualOptions getRootAsNotEqualOptions(ByteBuffer byteBuffer, NotEqualOptions notEqualOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return notEqualOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public NotEqualOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startNotEqualOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endNotEqualOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public NotEqualOptions get(int i) {
            return get(new NotEqualOptions(), i);
        }

        public NotEqualOptions get(NotEqualOptions notEqualOptions, int i) {
            return notEqualOptions.__assign(NotEqualOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public NotEqualOptionsT unpack() {
        NotEqualOptionsT notEqualOptionsT = new NotEqualOptionsT();
        unpackTo(notEqualOptionsT);
        return notEqualOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, NotEqualOptionsT notEqualOptionsT) {
        if (notEqualOptionsT == null) {
            return 0;
        }
        startNotEqualOptions(flatBufferBuilder);
        return endNotEqualOptions(flatBufferBuilder);
    }
}
