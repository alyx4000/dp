package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.IntVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.tensorflow.lite.schema.VariantSubType;

/* loaded from: classes6.dex */
public final class Tensor extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static Tensor getRootAsTensor(ByteBuffer byteBuffer) {
        return getRootAsTensor(byteBuffer, new Tensor());
    }

    public static Tensor getRootAsTensor(ByteBuffer byteBuffer, Tensor tensor) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return tensor.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public Tensor __assign(int i, ByteBuffer byteBuffer) {
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

    public long buffer() {
        if (__offset(8) != 0) {
            return this.bb.getInt(r0 + this.bb_pos) & BodyPartID.bodyIdMax;
        }
        return 0L;
    }

    public String name() {
        int __offset = __offset(10);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer nameAsByteBuffer() {
        return __vector_as_bytebuffer(10, 1);
    }

    public ByteBuffer nameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 10, 1);
    }

    public QuantizationParameters quantization() {
        return quantization(new QuantizationParameters());
    }

    public QuantizationParameters quantization(QuantizationParameters quantizationParameters) {
        int __offset = __offset(12);
        if (__offset != 0) {
            return quantizationParameters.__assign(__indirect(__offset + this.bb_pos), this.bb);
        }
        return null;
    }

    public boolean isVariable() {
        int __offset = __offset(14);
        return (__offset == 0 || this.bb.get(__offset + this.bb_pos) == 0) ? false : true;
    }

    public SparsityParameters sparsity() {
        return sparsity(new SparsityParameters());
    }

    public SparsityParameters sparsity(SparsityParameters sparsityParameters) {
        int __offset = __offset(16);
        if (__offset != 0) {
            return sparsityParameters.__assign(__indirect(__offset + this.bb_pos), this.bb);
        }
        return null;
    }

    public int shapeSignature(int i) {
        int __offset = __offset(18);
        if (__offset != 0) {
            return this.bb.getInt(__vector(__offset) + (i * 4));
        }
        return 0;
    }

    public int shapeSignatureLength() {
        int __offset = __offset(18);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public IntVector shapeSignatureVector() {
        return shapeSignatureVector(new IntVector());
    }

    public IntVector shapeSignatureVector(IntVector intVector) {
        int __offset = __offset(18);
        if (__offset != 0) {
            return intVector.__assign(__vector(__offset), this.bb);
        }
        return null;
    }

    public ByteBuffer shapeSignatureAsByteBuffer() {
        return __vector_as_bytebuffer(18, 4);
    }

    public ByteBuffer shapeSignatureInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 18, 4);
    }

    public boolean hasRank() {
        int __offset = __offset(20);
        return (__offset == 0 || this.bb.get(__offset + this.bb_pos) == 0) ? false : true;
    }

    public VariantSubType variantTensors(int i) {
        return variantTensors(new VariantSubType(), i);
    }

    public VariantSubType variantTensors(VariantSubType variantSubType, int i) {
        int __offset = __offset(22);
        if (__offset != 0) {
            return variantSubType.__assign(__indirect(__vector(__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int variantTensorsLength() {
        int __offset = __offset(22);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public VariantSubType.Vector variantTensorsVector() {
        return variantTensorsVector(new VariantSubType.Vector());
    }

    public VariantSubType.Vector variantTensorsVector(VariantSubType.Vector vector) {
        int __offset = __offset(22);
        if (__offset != 0) {
            return vector.__assign(__vector(__offset), 4, this.bb);
        }
        return null;
    }

    public static int createTensor(FlatBufferBuilder flatBufferBuilder, int i, byte b, long j, int i2, int i3, boolean z, int i4, int i5, boolean z2, int i6) {
        flatBufferBuilder.startTable(10);
        addVariantTensors(flatBufferBuilder, i6);
        addShapeSignature(flatBufferBuilder, i5);
        addSparsity(flatBufferBuilder, i4);
        addQuantization(flatBufferBuilder, i3);
        addName(flatBufferBuilder, i2);
        addBuffer(flatBufferBuilder, j);
        addShape(flatBufferBuilder, i);
        addHasRank(flatBufferBuilder, z2);
        addIsVariable(flatBufferBuilder, z);
        addType(flatBufferBuilder, b);
        return endTensor(flatBufferBuilder);
    }

    public static void startTensor(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(10);
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

    public static void addBuffer(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(2, (int) j, 0);
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(3, i, 0);
    }

    public static void addQuantization(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(4, i, 0);
    }

    public static void addIsVariable(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.addBoolean(5, z, false);
    }

    public static void addSparsity(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(6, i, 0);
    }

    public static void addShapeSignature(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(7, i, 0);
    }

    public static int createShapeSignatureVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addInt(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startShapeSignatureVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addHasRank(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.addBoolean(8, z, false);
    }

    public static void addVariantTensors(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(9, i, 0);
    }

    public static int createVariantTensorsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startVariantTensorsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static int endTensor(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public Tensor get(int i) {
            return get(new Tensor(), i);
        }

        public Tensor get(Tensor tensor, int i) {
            return tensor.__assign(Tensor.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public TensorT unpack() {
        TensorT tensorT = new TensorT();
        unpackTo(tensorT);
        return tensorT;
    }

    public void unpackTo(TensorT tensorT) {
        int[] iArr = new int[shapeLength()];
        for (int i = 0; i < shapeLength(); i++) {
            iArr[i] = shape(i);
        }
        tensorT.setShape(iArr);
        tensorT.setType(type());
        tensorT.setBuffer(buffer());
        tensorT.setName(name());
        if (quantization() != null) {
            tensorT.setQuantization(quantization().unpack());
        } else {
            tensorT.setQuantization(null);
        }
        tensorT.setIsVariable(isVariable());
        if (sparsity() != null) {
            tensorT.setSparsity(sparsity().unpack());
        } else {
            tensorT.setSparsity(null);
        }
        int[] iArr2 = new int[shapeSignatureLength()];
        for (int i2 = 0; i2 < shapeSignatureLength(); i2++) {
            iArr2[i2] = shapeSignature(i2);
        }
        tensorT.setShapeSignature(iArr2);
        tensorT.setHasRank(hasRank());
        VariantSubTypeT[] variantSubTypeTArr = new VariantSubTypeT[variantTensorsLength()];
        for (int i3 = 0; i3 < variantTensorsLength(); i3++) {
            variantSubTypeTArr[i3] = variantTensors(i3) != null ? variantTensors(i3).unpack() : null;
        }
        tensorT.setVariantTensors(variantSubTypeTArr);
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, TensorT tensorT) {
        int i = 0;
        if (tensorT == null) {
            return 0;
        }
        int createShapeVector = tensorT.getShape() != null ? createShapeVector(flatBufferBuilder, tensorT.getShape()) : 0;
        int createString = tensorT.getName() == null ? 0 : flatBufferBuilder.createString(tensorT.getName());
        int pack = tensorT.getQuantization() == null ? 0 : QuantizationParameters.pack(flatBufferBuilder, tensorT.getQuantization());
        int pack2 = tensorT.getSparsity() == null ? 0 : SparsityParameters.pack(flatBufferBuilder, tensorT.getSparsity());
        int createShapeSignatureVector = tensorT.getShapeSignature() != null ? createShapeSignatureVector(flatBufferBuilder, tensorT.getShapeSignature()) : 0;
        if (tensorT.getVariantTensors() != null) {
            int[] iArr = new int[tensorT.getVariantTensors().length];
            VariantSubTypeT[] variantTensors = tensorT.getVariantTensors();
            int length = variantTensors.length;
            int i2 = 0;
            while (i < length) {
                iArr[i2] = VariantSubType.pack(flatBufferBuilder, variantTensors[i]);
                i2++;
                i++;
            }
            i = createVariantTensorsVector(flatBufferBuilder, iArr);
        }
        return createTensor(flatBufferBuilder, createShapeVector, tensorT.getType(), tensorT.getBuffer(), createString, pack, tensorT.getIsVariable(), pack2, createShapeSignatureVector, tensorT.getHasRank(), i);
    }
}
