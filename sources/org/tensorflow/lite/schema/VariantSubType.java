package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.IntVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class VariantSubType extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static VariantSubType getRootAsVariantSubType(ByteBuffer byteBuffer) {
        return getRootAsVariantSubType(byteBuffer, new VariantSubType());
    }

    public static VariantSubType getRootAsVariantSubType(ByteBuffer byteBuffer, VariantSubType variantSubType) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return variantSubType.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public VariantSubType __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public int shape(int i) {
        int __offset = __offset(4);
        if (__offset != 0) {
            return this.bb.getInt(__vector(__offset) + (i * 4));
        }
        return 0;
    }

    public int shapeLength() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public IntVector shapeVector() {
        return shapeVector(new IntVector());
    }

    public IntVector shapeVector(IntVector intVector) {
        int __offset = __offset(4);
        if (__offset != 0) {
            return intVector.__assign(__vector(__offset), this.bb);
        }
        return null;
    }

    public ByteBuffer shapeAsByteBuffer() {
        return __vector_as_bytebuffer(4, 4);
    }

    public ByteBuffer shapeInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 4);
    }

    public byte type() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return this.bb.get(__offset + this.bb_pos);
        }
        return (byte) 0;
    }

    public boolean hasRank() {
        int __offset = __offset(8);
        return (__offset == 0 || this.bb.get(__offset + this.bb_pos) == 0) ? false : true;
    }

    public static int createVariantSubType(FlatBufferBuilder flatBufferBuilder, int i, byte b, boolean z) {
        flatBufferBuilder.startTable(3);
        addShape(flatBufferBuilder, i);
        addHasRank(flatBufferBuilder, z);
        addType(flatBufferBuilder, b);
        return endVariantSubType(flatBufferBuilder);
    }

    public static void startVariantSubType(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(3);
    }

    public static void addShape(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static int createShapeVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addInt(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startShapeVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addType(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.addByte(1, b, 0);
    }

    public static void addHasRank(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.addBoolean(2, z, false);
    }

    public static int endVariantSubType(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public VariantSubType get(int i) {
            return get(new VariantSubType(), i);
        }

        public VariantSubType get(VariantSubType variantSubType, int i) {
            return variantSubType.__assign(VariantSubType.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public VariantSubTypeT unpack() {
        VariantSubTypeT variantSubTypeT = new VariantSubTypeT();
        unpackTo(variantSubTypeT);
        return variantSubTypeT;
    }

    public void unpackTo(VariantSubTypeT variantSubTypeT) {
        int[] iArr = new int[shapeLength()];
        for (int i = 0; i < shapeLength(); i++) {
            iArr[i] = shape(i);
        }
        variantSubTypeT.setShape(iArr);
        variantSubTypeT.setType(type());
        variantSubTypeT.setHasRank(hasRank());
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, VariantSubTypeT variantSubTypeT) {
        if (variantSubTypeT == null) {
            return 0;
        }
        return createVariantSubType(flatBufferBuilder, variantSubTypeT.getShape() != null ? createShapeVector(flatBufferBuilder, variantSubTypeT.getShape()) : 0, variantSubTypeT.getType(), variantSubTypeT.getHasRank());
    }
}
