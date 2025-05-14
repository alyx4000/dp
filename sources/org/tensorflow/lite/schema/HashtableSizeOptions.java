package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class HashtableSizeOptions extends Table {
    public void unpackTo(HashtableSizeOptionsT hashtableSizeOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static HashtableSizeOptions getRootAsHashtableSizeOptions(ByteBuffer byteBuffer) {
        return getRootAsHashtableSizeOptions(byteBuffer, new HashtableSizeOptions());
    }

    public static HashtableSizeOptions getRootAsHashtableSizeOptions(ByteBuffer byteBuffer, HashtableSizeOptions hashtableSizeOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return hashtableSizeOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public HashtableSizeOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startHashtableSizeOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endHashtableSizeOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public HashtableSizeOptions get(int i) {
            return get(new HashtableSizeOptions(), i);
        }

        public HashtableSizeOptions get(HashtableSizeOptions hashtableSizeOptions, int i) {
            return hashtableSizeOptions.__assign(HashtableSizeOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public HashtableSizeOptionsT unpack() {
        HashtableSizeOptionsT hashtableSizeOptionsT = new HashtableSizeOptionsT();
        unpackTo(hashtableSizeOptionsT);
        return hashtableSizeOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, HashtableSizeOptionsT hashtableSizeOptionsT) {
        if (hashtableSizeOptionsT == null) {
            return 0;
        }
        startHashtableSizeOptions(flatBufferBuilder);
        return endHashtableSizeOptions(flatBufferBuilder);
    }
}
