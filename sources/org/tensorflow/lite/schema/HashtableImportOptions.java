package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class HashtableImportOptions extends Table {
    public void unpackTo(HashtableImportOptionsT hashtableImportOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static HashtableImportOptions getRootAsHashtableImportOptions(ByteBuffer byteBuffer) {
        return getRootAsHashtableImportOptions(byteBuffer, new HashtableImportOptions());
    }

    public static HashtableImportOptions getRootAsHashtableImportOptions(ByteBuffer byteBuffer, HashtableImportOptions hashtableImportOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return hashtableImportOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public HashtableImportOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startHashtableImportOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endHashtableImportOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public HashtableImportOptions get(int i) {
            return get(new HashtableImportOptions(), i);
        }

        public HashtableImportOptions get(HashtableImportOptions hashtableImportOptions, int i) {
            return hashtableImportOptions.__assign(HashtableImportOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public HashtableImportOptionsT unpack() {
        HashtableImportOptionsT hashtableImportOptionsT = new HashtableImportOptionsT();
        unpackTo(hashtableImportOptionsT);
        return hashtableImportOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, HashtableImportOptionsT hashtableImportOptionsT) {
        if (hashtableImportOptionsT == null) {
            return 0;
        }
        startHashtableImportOptions(flatBufferBuilder);
        return endHashtableImportOptions(flatBufferBuilder);
    }
}
