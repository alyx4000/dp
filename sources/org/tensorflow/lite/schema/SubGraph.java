package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.IntVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.tensorflow.lite.schema.Operator;
import org.tensorflow.lite.schema.Tensor;

/* loaded from: classes6.dex */
public final class SubGraph extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static SubGraph getRootAsSubGraph(ByteBuffer byteBuffer) {
        return getRootAsSubGraph(byteBuffer, new SubGraph());
    }

    public static SubGraph getRootAsSubGraph(ByteBuffer byteBuffer, SubGraph subGraph) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return subGraph.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public SubGraph __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public Tensor tensors(int i) {
        return tensors(new Tensor(), i);
    }

    public Tensor tensors(Tensor tensor, int i) {
        int __offset = __offset(4);
        if (__offset != 0) {
            return tensor.__assign(__indirect(__vector(__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int tensorsLength() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public Tensor.Vector tensorsVector() {
        return tensorsVector(new Tensor.Vector());
    }

    public Tensor.Vector tensorsVector(Tensor.Vector vector) {
        int __offset = __offset(4);
        if (__offset != 0) {
            return vector.__assign(__vector(__offset), 4, this.bb);
        }
        return null;
    }

    public int inputs(int i) {
        int __offset = __offset(6);
        if (__offset != 0) {
            return this.bb.getInt(__vector(__offset) + (i * 4));
        }
        return 0;
    }

    public int inputsLength() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public IntVector inputsVector() {
        return inputsVector(new IntVector());
    }

    public IntVector inputsVector(IntVector intVector) {
        int __offset = __offset(6);
        if (__offset != 0) {
            return intVector.__assign(__vector(__offset), this.bb);
        }
        return null;
    }

    public ByteBuffer inputsAsByteBuffer() {
        return __vector_as_bytebuffer(6, 4);
    }

    public ByteBuffer inputsInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 4);
    }

    public int outputs(int i) {
        int __offset = __offset(8);
        if (__offset != 0) {
            return this.bb.getInt(__vector(__offset) + (i * 4));
        }
        return 0;
    }

    public int outputsLength() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public IntVector outputsVector() {
        return outputsVector(new IntVector());
    }

    public IntVector outputsVector(IntVector intVector) {
        int __offset = __offset(8);
        if (__offset != 0) {
            return intVector.__assign(__vector(__offset), this.bb);
        }
        return null;
    }

    public ByteBuffer outputsAsByteBuffer() {
        return __vector_as_bytebuffer(8, 4);
    }

    public ByteBuffer outputsInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 4);
    }

    public Operator operators(int i) {
        return operators(new Operator(), i);
    }

    public Operator operators(Operator operator, int i) {
        int __offset = __offset(10);
        if (__offset != 0) {
            return operator.__assign(__indirect(__vector(__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int operatorsLength() {
        int __offset = __offset(10);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public Operator.Vector operatorsVector() {
        return operatorsVector(new Operator.Vector());
    }

    public Operator.Vector operatorsVector(Operator.Vector vector) {
        int __offset = __offset(10);
        if (__offset != 0) {
            return vector.__assign(__vector(__offset), 4, this.bb);
        }
        return null;
    }

    public String name() {
        int __offset = __offset(12);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer nameAsByteBuffer() {
        return __vector_as_bytebuffer(12, 1);
    }

    public ByteBuffer nameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 12, 1);
    }

    public static int createSubGraph(FlatBufferBuilder flatBufferBuilder, int i, int i2, int i3, int i4, int i5) {
        flatBufferBuilder.startTable(5);
        addName(flatBufferBuilder, i5);
        addOperators(flatBufferBuilder, i4);
        addOutputs(flatBufferBuilder, i3);
        addInputs(flatBufferBuilder, i2);
        addTensors(flatBufferBuilder, i);
        return endSubGraph(flatBufferBuilder);
    }

    public static void startSubGraph(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(5);
    }

    public static void addTensors(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static int createTensorsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startTensorsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addInputs(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static int createInputsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addInt(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startInputsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addOutputs(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(2, i, 0);
    }

    public static int createOutputsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addInt(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startOutputsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addOperators(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(3, i, 0);
    }

    public static int createOperatorsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startOperatorsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(4, i, 0);
    }

    public static int endSubGraph(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public SubGraph get(int i) {
            return get(new SubGraph(), i);
        }

        public SubGraph get(SubGraph subGraph, int i) {
            return subGraph.__assign(SubGraph.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public SubGraphT unpack() {
        SubGraphT subGraphT = new SubGraphT();
        unpackTo(subGraphT);
        return subGraphT;
    }

    public void unpackTo(SubGraphT subGraphT) {
        TensorT[] tensorTArr = new TensorT[tensorsLength()];
        int i = 0;
        while (true) {
            TensorT tensorT = null;
            if (i >= tensorsLength()) {
                break;
            }
            if (tensors(i) != null) {
                tensorT = tensors(i).unpack();
            }
            tensorTArr[i] = tensorT;
            i++;
        }
        subGraphT.setTensors(tensorTArr);
        int[] iArr = new int[inputsLength()];
        for (int i2 = 0; i2 < inputsLength(); i2++) {
            iArr[i2] = inputs(i2);
        }
        subGraphT.setInputs(iArr);
        int[] iArr2 = new int[outputsLength()];
        for (int i3 = 0; i3 < outputsLength(); i3++) {
            iArr2[i3] = outputs(i3);
        }
        subGraphT.setOutputs(iArr2);
        OperatorT[] operatorTArr = new OperatorT[operatorsLength()];
        for (int i4 = 0; i4 < operatorsLength(); i4++) {
            operatorTArr[i4] = operators(i4) != null ? operators(i4).unpack() : null;
        }
        subGraphT.setOperators(operatorTArr);
        subGraphT.setName(name());
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, SubGraphT subGraphT) {
        int i;
        int i2;
        if (subGraphT == null) {
            return 0;
        }
        if (subGraphT.getTensors() != null) {
            int[] iArr = new int[subGraphT.getTensors().length];
            int i3 = 0;
            for (TensorT tensorT : subGraphT.getTensors()) {
                iArr[i3] = Tensor.pack(flatBufferBuilder, tensorT);
                i3++;
            }
            i = createTensorsVector(flatBufferBuilder, iArr);
        } else {
            i = 0;
        }
        int createInputsVector = subGraphT.getInputs() != null ? createInputsVector(flatBufferBuilder, subGraphT.getInputs()) : 0;
        int createOutputsVector = subGraphT.getOutputs() != null ? createOutputsVector(flatBufferBuilder, subGraphT.getOutputs()) : 0;
        if (subGraphT.getOperators() != null) {
            int[] iArr2 = new int[subGraphT.getOperators().length];
            int i4 = 0;
            for (OperatorT operatorT : subGraphT.getOperators()) {
                iArr2[i4] = Operator.pack(flatBufferBuilder, operatorT);
                i4++;
            }
            i2 = createOperatorsVector(flatBufferBuilder, iArr2);
        } else {
            i2 = 0;
        }
        return createSubGraph(flatBufferBuilder, i, createInputsVector, createOutputsVector, i2, subGraphT.getName() != null ? flatBufferBuilder.createString(subGraphT.getName()) : 0);
    }
}
