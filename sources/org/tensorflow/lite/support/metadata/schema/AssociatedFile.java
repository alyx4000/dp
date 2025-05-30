package org.tensorflow.lite.support.metadata.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class AssociatedFile extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static AssociatedFile getRootAsAssociatedFile(ByteBuffer byteBuffer) {
        return getRootAsAssociatedFile(byteBuffer, new AssociatedFile());
    }

    public static AssociatedFile getRootAsAssociatedFile(ByteBuffer byteBuffer, AssociatedFile associatedFile) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return associatedFile.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public AssociatedFile __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public String name() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer nameAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer nameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public String description() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer descriptionAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer descriptionInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public byte type() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return this.bb.get(__offset + this.bb_pos);
        }
        return (byte) 0;
    }

    public String locale() {
        int __offset = __offset(10);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer localeAsByteBuffer() {
        return __vector_as_bytebuffer(10, 1);
    }

    public ByteBuffer localeInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 10, 1);
    }

    public String version() {
        int __offset = __offset(12);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer versionAsByteBuffer() {
        return __vector_as_bytebuffer(12, 1);
    }

    public ByteBuffer versionInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 12, 1);
    }

    public static int createAssociatedFile(FlatBufferBuilder flatBufferBuilder, int i, int i2, byte b, int i3, int i4) {
        flatBufferBuilder.startTable(5);
        addVersion(flatBufferBuilder, i4);
        addLocale(flatBufferBuilder, i3);
        addDescription(flatBufferBuilder, i2);
        addName(flatBufferBuilder, i);
        addType(flatBufferBuilder, b);
        return endAssociatedFile(flatBufferBuilder);
    }

    public static void startAssociatedFile(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(5);
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static void addDescription(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static void addType(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.addByte(2, b, 0);
    }

    public static void addLocale(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(3, i, 0);
    }

    public static void addVersion(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(4, i, 0);
    }

    public static int endAssociatedFile(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public AssociatedFile get(int i) {
            return get(new AssociatedFile(), i);
        }

        public AssociatedFile get(AssociatedFile associatedFile, int i) {
            return associatedFile.__assign(AssociatedFile.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public AssociatedFileT unpack() {
        AssociatedFileT associatedFileT = new AssociatedFileT();
        unpackTo(associatedFileT);
        return associatedFileT;
    }

    public void unpackTo(AssociatedFileT associatedFileT) {
        associatedFileT.setName(name());
        associatedFileT.setDescription(description());
        associatedFileT.setType(type());
        associatedFileT.setLocale(locale());
        associatedFileT.setVersion(version());
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, AssociatedFileT associatedFileT) {
        if (associatedFileT == null) {
            return 0;
        }
        return createAssociatedFile(flatBufferBuilder, associatedFileT.getName() == null ? 0 : flatBufferBuilder.createString(associatedFileT.getName()), associatedFileT.getDescription() == null ? 0 : flatBufferBuilder.createString(associatedFileT.getDescription()), associatedFileT.getType(), associatedFileT.getLocale() == null ? 0 : flatBufferBuilder.createString(associatedFileT.getLocale()), associatedFileT.getVersion() != null ? flatBufferBuilder.createString(associatedFileT.getVersion()) : 0);
    }
}
