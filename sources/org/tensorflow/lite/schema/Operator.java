package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.BooleanVector;
import com.google.flatbuffers.ByteVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.IntVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UByte;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes6.dex */
public final class Operator extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static Operator getRootAsOperator(ByteBuffer byteBuffer) {
        return getRootAsOperator(byteBuffer, new Operator());
    }

    public static Operator getRootAsOperator(ByteBuffer byteBuffer, Operator operator) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return operator.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public Operator __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public long opcodeIndex() {
        if (__offset(4) != 0) {
            return this.bb.getInt(r0 + this.bb_pos) & BodyPartID.bodyIdMax;
        }
        return 0L;
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

    public byte builtinOptionsType() {
        int __offset = __offset(10);
        if (__offset != 0) {
            return this.bb.get(__offset + this.bb_pos);
        }
        return (byte) 0;
    }

    public Table builtinOptions(Table table) {
        int __offset = __offset(12);
        if (__offset != 0) {
            return __union(table, __offset + this.bb_pos);
        }
        return null;
    }

    public int customOptions(int i) {
        int __offset = __offset(14);
        if (__offset != 0) {
            return this.bb.get(__vector(__offset) + (i * 1)) & UByte.MAX_VALUE;
        }
        return 0;
    }

    public int customOptionsLength() {
        int __offset = __offset(14);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public ByteVector customOptionsVector() {
        return customOptionsVector(new ByteVector());
    }

    public ByteVector customOptionsVector(ByteVector byteVector) {
        int __offset = __offset(14);
        if (__offset != 0) {
            return byteVector.__assign(__vector(__offset), this.bb);
        }
        return null;
    }

    public ByteBuffer customOptionsAsByteBuffer() {
        return __vector_as_bytebuffer(14, 1);
    }

    public ByteBuffer customOptionsInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 14, 1);
    }

    public byte customOptionsFormat() {
        int __offset = __offset(16);
        if (__offset != 0) {
            return this.bb.get(__offset + this.bb_pos);
        }
        return (byte) 0;
    }

    public boolean mutatingVariableInputs(int i) {
        int __offset = __offset(18);
        return (__offset == 0 || this.bb.get(__vector(__offset) + (i * 1)) == 0) ? false : true;
    }

    public int mutatingVariableInputsLength() {
        int __offset = __offset(18);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public BooleanVector mutatingVariableInputsVector() {
        return mutatingVariableInputsVector(new BooleanVector());
    }

    public BooleanVector mutatingVariableInputsVector(BooleanVector booleanVector) {
        int __offset = __offset(18);
        if (__offset != 0) {
            return booleanVector.__assign(__vector(__offset), this.bb);
        }
        return null;
    }

    public ByteBuffer mutatingVariableInputsAsByteBuffer() {
        return __vector_as_bytebuffer(18, 1);
    }

    public ByteBuffer mutatingVariableInputsInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 18, 1);
    }

    public int intermediates(int i) {
        int __offset = __offset(20);
        if (__offset != 0) {
            return this.bb.getInt(__vector(__offset) + (i * 4));
        }
        return 0;
    }

    public int intermediatesLength() {
        int __offset = __offset(20);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public IntVector intermediatesVector() {
        return intermediatesVector(new IntVector());
    }

    public IntVector intermediatesVector(IntVector intVector) {
        int __offset = __offset(20);
        if (__offset != 0) {
            return intVector.__assign(__vector(__offset), this.bb);
        }
        return null;
    }

    public ByteBuffer intermediatesAsByteBuffer() {
        return __vector_as_bytebuffer(20, 4);
    }

    public ByteBuffer intermediatesInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 20, 4);
    }

    public static int createOperator(FlatBufferBuilder flatBufferBuilder, long j, int i, int i2, byte b, int i3, int i4, byte b2, int i5, int i6) {
        flatBufferBuilder.startTable(9);
        addIntermediates(flatBufferBuilder, i6);
        addMutatingVariableInputs(flatBufferBuilder, i5);
        addCustomOptions(flatBufferBuilder, i4);
        addBuiltinOptions(flatBufferBuilder, i3);
        addOutputs(flatBufferBuilder, i2);
        addInputs(flatBufferBuilder, i);
        addOpcodeIndex(flatBufferBuilder, j);
        addCustomOptionsFormat(flatBufferBuilder, b2);
        addBuiltinOptionsType(flatBufferBuilder, b);
        return endOperator(flatBufferBuilder);
    }

    public static void startOperator(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(9);
    }

    public static void addOpcodeIndex(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(0, (int) j, 0);
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

    public static void addBuiltinOptionsType(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.addByte(3, b, 0);
    }

    public static void addBuiltinOptions(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(4, i, 0);
    }

    public static void addCustomOptions(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(5, i, 0);
    }

    public static int createCustomOptionsVector(FlatBufferBuilder flatBufferBuilder, byte[] bArr) {
        return flatBufferBuilder.createByteVector(bArr);
    }

    public static int createCustomOptionsVector(FlatBufferBuilder flatBufferBuilder, ByteBuffer byteBuffer) {
        return flatBufferBuilder.createByteVector(byteBuffer);
    }

    public static void startCustomOptionsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(1, i, 1);
    }

    public static void addCustomOptionsFormat(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.addByte(6, b, 0);
    }

    public static void addMutatingVariableInputs(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(7, i, 0);
    }

    public static int createMutatingVariableInputsVector(FlatBufferBuilder flatBufferBuilder, boolean[] zArr) {
        flatBufferBuilder.startVector(1, zArr.length, 1);
        for (int length = zArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addBoolean(zArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startMutatingVariableInputsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(1, i, 1);
    }

    public static void addIntermediates(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(8, i, 0);
    }

    public static int createIntermediatesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addInt(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startIntermediatesVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static int endOperator(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public Operator get(int i) {
            return get(new Operator(), i);
        }

        public Operator get(Operator operator, int i) {
            return operator.__assign(Operator.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public OperatorT unpack() {
        OperatorT operatorT = new OperatorT();
        unpackTo(operatorT);
        return operatorT;
    }

    public void unpackTo(OperatorT operatorT) {
        operatorT.setOpcodeIndex(opcodeIndex());
        int[] iArr = new int[inputsLength()];
        for (int i = 0; i < inputsLength(); i++) {
            iArr[i] = inputs(i);
        }
        operatorT.setInputs(iArr);
        int[] iArr2 = new int[outputsLength()];
        for (int i2 = 0; i2 < outputsLength(); i2++) {
            iArr2[i2] = outputs(i2);
        }
        operatorT.setOutputs(iArr2);
        BuiltinOptionsUnion builtinOptionsUnion = new BuiltinOptionsUnion();
        byte builtinOptionsType = builtinOptionsType();
        builtinOptionsUnion.setType(builtinOptionsType);
        switch (builtinOptionsType) {
            case 1:
                Table builtinOptions = builtinOptions(new Conv2DOptions());
                builtinOptionsUnion.setValue(builtinOptions != null ? ((Conv2DOptions) builtinOptions).unpack() : null);
                break;
            case 2:
                Table builtinOptions2 = builtinOptions(new DepthwiseConv2DOptions());
                builtinOptionsUnion.setValue(builtinOptions2 != null ? ((DepthwiseConv2DOptions) builtinOptions2).unpack() : null);
                break;
            case 3:
                Table builtinOptions3 = builtinOptions(new ConcatEmbeddingsOptions());
                builtinOptionsUnion.setValue(builtinOptions3 != null ? ((ConcatEmbeddingsOptions) builtinOptions3).unpack() : null);
                break;
            case 4:
                Table builtinOptions4 = builtinOptions(new LSHProjectionOptions());
                builtinOptionsUnion.setValue(builtinOptions4 != null ? ((LSHProjectionOptions) builtinOptions4).unpack() : null);
                break;
            case 5:
                Table builtinOptions5 = builtinOptions(new Pool2DOptions());
                builtinOptionsUnion.setValue(builtinOptions5 != null ? ((Pool2DOptions) builtinOptions5).unpack() : null);
                break;
            case 6:
                Table builtinOptions6 = builtinOptions(new SVDFOptions());
                builtinOptionsUnion.setValue(builtinOptions6 != null ? ((SVDFOptions) builtinOptions6).unpack() : null);
                break;
            case 7:
                Table builtinOptions7 = builtinOptions(new RNNOptions());
                builtinOptionsUnion.setValue(builtinOptions7 != null ? ((RNNOptions) builtinOptions7).unpack() : null);
                break;
            case 8:
                Table builtinOptions8 = builtinOptions(new FullyConnectedOptions());
                builtinOptionsUnion.setValue(builtinOptions8 != null ? ((FullyConnectedOptions) builtinOptions8).unpack() : null);
                break;
            case 9:
                Table builtinOptions9 = builtinOptions(new SoftmaxOptions());
                builtinOptionsUnion.setValue(builtinOptions9 != null ? ((SoftmaxOptions) builtinOptions9).unpack() : null);
                break;
            case 10:
                Table builtinOptions10 = builtinOptions(new ConcatenationOptions());
                builtinOptionsUnion.setValue(builtinOptions10 != null ? ((ConcatenationOptions) builtinOptions10).unpack() : null);
                break;
            case 11:
                Table builtinOptions11 = builtinOptions(new AddOptions());
                builtinOptionsUnion.setValue(builtinOptions11 != null ? ((AddOptions) builtinOptions11).unpack() : null);
                break;
            case 12:
                Table builtinOptions12 = builtinOptions(new L2NormOptions());
                builtinOptionsUnion.setValue(builtinOptions12 != null ? ((L2NormOptions) builtinOptions12).unpack() : null);
                break;
            case 13:
                Table builtinOptions13 = builtinOptions(new LocalResponseNormalizationOptions());
                builtinOptionsUnion.setValue(builtinOptions13 != null ? ((LocalResponseNormalizationOptions) builtinOptions13).unpack() : null);
                break;
            case 14:
                Table builtinOptions14 = builtinOptions(new LSTMOptions());
                builtinOptionsUnion.setValue(builtinOptions14 != null ? ((LSTMOptions) builtinOptions14).unpack() : null);
                break;
            case 15:
                Table builtinOptions15 = builtinOptions(new ResizeBilinearOptions());
                builtinOptionsUnion.setValue(builtinOptions15 != null ? ((ResizeBilinearOptions) builtinOptions15).unpack() : null);
                break;
            case 16:
                Table builtinOptions16 = builtinOptions(new CallOptions());
                builtinOptionsUnion.setValue(builtinOptions16 != null ? ((CallOptions) builtinOptions16).unpack() : null);
                break;
            case 17:
                Table builtinOptions17 = builtinOptions(new ReshapeOptions());
                builtinOptionsUnion.setValue(builtinOptions17 != null ? ((ReshapeOptions) builtinOptions17).unpack() : null);
                break;
            case 18:
                Table builtinOptions18 = builtinOptions(new SkipGramOptions());
                builtinOptionsUnion.setValue(builtinOptions18 != null ? ((SkipGramOptions) builtinOptions18).unpack() : null);
                break;
            case 19:
                Table builtinOptions19 = builtinOptions(new SpaceToDepthOptions());
                builtinOptionsUnion.setValue(builtinOptions19 != null ? ((SpaceToDepthOptions) builtinOptions19).unpack() : null);
                break;
            case 20:
                Table builtinOptions20 = builtinOptions(new EmbeddingLookupSparseOptions());
                builtinOptionsUnion.setValue(builtinOptions20 != null ? ((EmbeddingLookupSparseOptions) builtinOptions20).unpack() : null);
                break;
            case 21:
                Table builtinOptions21 = builtinOptions(new MulOptions());
                builtinOptionsUnion.setValue(builtinOptions21 != null ? ((MulOptions) builtinOptions21).unpack() : null);
                break;
            case 22:
                Table builtinOptions22 = builtinOptions(new PadOptions());
                builtinOptionsUnion.setValue(builtinOptions22 != null ? ((PadOptions) builtinOptions22).unpack() : null);
                break;
            case 23:
                Table builtinOptions23 = builtinOptions(new GatherOptions());
                builtinOptionsUnion.setValue(builtinOptions23 != null ? ((GatherOptions) builtinOptions23).unpack() : null);
                break;
            case 24:
                Table builtinOptions24 = builtinOptions(new BatchToSpaceNDOptions());
                builtinOptionsUnion.setValue(builtinOptions24 != null ? ((BatchToSpaceNDOptions) builtinOptions24).unpack() : null);
                break;
            case 25:
                Table builtinOptions25 = builtinOptions(new SpaceToBatchNDOptions());
                builtinOptionsUnion.setValue(builtinOptions25 != null ? ((SpaceToBatchNDOptions) builtinOptions25).unpack() : null);
                break;
            case 26:
                Table builtinOptions26 = builtinOptions(new TransposeOptions());
                builtinOptionsUnion.setValue(builtinOptions26 != null ? ((TransposeOptions) builtinOptions26).unpack() : null);
                break;
            case 27:
                Table builtinOptions27 = builtinOptions(new ReducerOptions());
                builtinOptionsUnion.setValue(builtinOptions27 != null ? ((ReducerOptions) builtinOptions27).unpack() : null);
                break;
            case 28:
                Table builtinOptions28 = builtinOptions(new SubOptions());
                builtinOptionsUnion.setValue(builtinOptions28 != null ? ((SubOptions) builtinOptions28).unpack() : null);
                break;
            case 29:
                Table builtinOptions29 = builtinOptions(new DivOptions());
                builtinOptionsUnion.setValue(builtinOptions29 != null ? ((DivOptions) builtinOptions29).unpack() : null);
                break;
            case 30:
                Table builtinOptions30 = builtinOptions(new SqueezeOptions());
                builtinOptionsUnion.setValue(builtinOptions30 != null ? ((SqueezeOptions) builtinOptions30).unpack() : null);
                break;
            case 31:
                Table builtinOptions31 = builtinOptions(new SequenceRNNOptions());
                builtinOptionsUnion.setValue(builtinOptions31 != null ? ((SequenceRNNOptions) builtinOptions31).unpack() : null);
                break;
            case 32:
                Table builtinOptions32 = builtinOptions(new StridedSliceOptions());
                builtinOptionsUnion.setValue(builtinOptions32 != null ? ((StridedSliceOptions) builtinOptions32).unpack() : null);
                break;
            case 33:
                Table builtinOptions33 = builtinOptions(new ExpOptions());
                builtinOptionsUnion.setValue(builtinOptions33 != null ? ((ExpOptions) builtinOptions33).unpack() : null);
                break;
            case 34:
                Table builtinOptions34 = builtinOptions(new TopKV2Options());
                builtinOptionsUnion.setValue(builtinOptions34 != null ? ((TopKV2Options) builtinOptions34).unpack() : null);
                break;
            case 35:
                Table builtinOptions35 = builtinOptions(new SplitOptions());
                builtinOptionsUnion.setValue(builtinOptions35 != null ? ((SplitOptions) builtinOptions35).unpack() : null);
                break;
            case 36:
                Table builtinOptions36 = builtinOptions(new LogSoftmaxOptions());
                builtinOptionsUnion.setValue(builtinOptions36 != null ? ((LogSoftmaxOptions) builtinOptions36).unpack() : null);
                break;
            case 37:
                Table builtinOptions37 = builtinOptions(new CastOptions());
                builtinOptionsUnion.setValue(builtinOptions37 != null ? ((CastOptions) builtinOptions37).unpack() : null);
                break;
            case 38:
                Table builtinOptions38 = builtinOptions(new DequantizeOptions());
                builtinOptionsUnion.setValue(builtinOptions38 != null ? ((DequantizeOptions) builtinOptions38).unpack() : null);
                break;
            case 39:
                Table builtinOptions39 = builtinOptions(new MaximumMinimumOptions());
                builtinOptionsUnion.setValue(builtinOptions39 != null ? ((MaximumMinimumOptions) builtinOptions39).unpack() : null);
                break;
            case 40:
                Table builtinOptions40 = builtinOptions(new ArgMaxOptions());
                builtinOptionsUnion.setValue(builtinOptions40 != null ? ((ArgMaxOptions) builtinOptions40).unpack() : null);
                break;
            case 41:
                Table builtinOptions41 = builtinOptions(new LessOptions());
                builtinOptionsUnion.setValue(builtinOptions41 != null ? ((LessOptions) builtinOptions41).unpack() : null);
                break;
            case 42:
                Table builtinOptions42 = builtinOptions(new NegOptions());
                builtinOptionsUnion.setValue(builtinOptions42 != null ? ((NegOptions) builtinOptions42).unpack() : null);
                break;
            case 43:
                Table builtinOptions43 = builtinOptions(new PadV2Options());
                builtinOptionsUnion.setValue(builtinOptions43 != null ? ((PadV2Options) builtinOptions43).unpack() : null);
                break;
            case 44:
                Table builtinOptions44 = builtinOptions(new GreaterOptions());
                builtinOptionsUnion.setValue(builtinOptions44 != null ? ((GreaterOptions) builtinOptions44).unpack() : null);
                break;
            case 45:
                Table builtinOptions45 = builtinOptions(new GreaterEqualOptions());
                builtinOptionsUnion.setValue(builtinOptions45 != null ? ((GreaterEqualOptions) builtinOptions45).unpack() : null);
                break;
            case 46:
                Table builtinOptions46 = builtinOptions(new LessEqualOptions());
                builtinOptionsUnion.setValue(builtinOptions46 != null ? ((LessEqualOptions) builtinOptions46).unpack() : null);
                break;
            case 47:
                Table builtinOptions47 = builtinOptions(new SelectOptions());
                builtinOptionsUnion.setValue(builtinOptions47 != null ? ((SelectOptions) builtinOptions47).unpack() : null);
                break;
            case 48:
                Table builtinOptions48 = builtinOptions(new SliceOptions());
                builtinOptionsUnion.setValue(builtinOptions48 != null ? ((SliceOptions) builtinOptions48).unpack() : null);
                break;
            case 49:
                Table builtinOptions49 = builtinOptions(new TransposeConvOptions());
                builtinOptionsUnion.setValue(builtinOptions49 != null ? ((TransposeConvOptions) builtinOptions49).unpack() : null);
                break;
            case 50:
                Table builtinOptions50 = builtinOptions(new SparseToDenseOptions());
                builtinOptionsUnion.setValue(builtinOptions50 != null ? ((SparseToDenseOptions) builtinOptions50).unpack() : null);
                break;
            case 51:
                Table builtinOptions51 = builtinOptions(new TileOptions());
                builtinOptionsUnion.setValue(builtinOptions51 != null ? ((TileOptions) builtinOptions51).unpack() : null);
                break;
            case 52:
                Table builtinOptions52 = builtinOptions(new ExpandDimsOptions());
                builtinOptionsUnion.setValue(builtinOptions52 != null ? ((ExpandDimsOptions) builtinOptions52).unpack() : null);
                break;
            case 53:
                Table builtinOptions53 = builtinOptions(new EqualOptions());
                builtinOptionsUnion.setValue(builtinOptions53 != null ? ((EqualOptions) builtinOptions53).unpack() : null);
                break;
            case 54:
                Table builtinOptions54 = builtinOptions(new NotEqualOptions());
                builtinOptionsUnion.setValue(builtinOptions54 != null ? ((NotEqualOptions) builtinOptions54).unpack() : null);
                break;
            case 55:
                Table builtinOptions55 = builtinOptions(new ShapeOptions());
                builtinOptionsUnion.setValue(builtinOptions55 != null ? ((ShapeOptions) builtinOptions55).unpack() : null);
                break;
            case 56:
                Table builtinOptions56 = builtinOptions(new PowOptions());
                builtinOptionsUnion.setValue(builtinOptions56 != null ? ((PowOptions) builtinOptions56).unpack() : null);
                break;
            case 57:
                Table builtinOptions57 = builtinOptions(new ArgMinOptions());
                builtinOptionsUnion.setValue(builtinOptions57 != null ? ((ArgMinOptions) builtinOptions57).unpack() : null);
                break;
            case 58:
                Table builtinOptions58 = builtinOptions(new FakeQuantOptions());
                builtinOptionsUnion.setValue(builtinOptions58 != null ? ((FakeQuantOptions) builtinOptions58).unpack() : null);
                break;
            case 59:
                Table builtinOptions59 = builtinOptions(new PackOptions());
                builtinOptionsUnion.setValue(builtinOptions59 != null ? ((PackOptions) builtinOptions59).unpack() : null);
                break;
            case 60:
                Table builtinOptions60 = builtinOptions(new LogicalOrOptions());
                builtinOptionsUnion.setValue(builtinOptions60 != null ? ((LogicalOrOptions) builtinOptions60).unpack() : null);
                break;
            case 61:
                Table builtinOptions61 = builtinOptions(new OneHotOptions());
                builtinOptionsUnion.setValue(builtinOptions61 != null ? ((OneHotOptions) builtinOptions61).unpack() : null);
                break;
            case 62:
                Table builtinOptions62 = builtinOptions(new LogicalAndOptions());
                builtinOptionsUnion.setValue(builtinOptions62 != null ? ((LogicalAndOptions) builtinOptions62).unpack() : null);
                break;
            case 63:
                Table builtinOptions63 = builtinOptions(new LogicalNotOptions());
                builtinOptionsUnion.setValue(builtinOptions63 != null ? ((LogicalNotOptions) builtinOptions63).unpack() : null);
                break;
            case 64:
                Table builtinOptions64 = builtinOptions(new UnpackOptions());
                builtinOptionsUnion.setValue(builtinOptions64 != null ? ((UnpackOptions) builtinOptions64).unpack() : null);
                break;
            case 65:
                Table builtinOptions65 = builtinOptions(new FloorDivOptions());
                builtinOptionsUnion.setValue(builtinOptions65 != null ? ((FloorDivOptions) builtinOptions65).unpack() : null);
                break;
            case 66:
                Table builtinOptions66 = builtinOptions(new SquareOptions());
                builtinOptionsUnion.setValue(builtinOptions66 != null ? ((SquareOptions) builtinOptions66).unpack() : null);
                break;
            case 67:
                Table builtinOptions67 = builtinOptions(new ZerosLikeOptions());
                builtinOptionsUnion.setValue(builtinOptions67 != null ? ((ZerosLikeOptions) builtinOptions67).unpack() : null);
                break;
            case 68:
                Table builtinOptions68 = builtinOptions(new FillOptions());
                builtinOptionsUnion.setValue(builtinOptions68 != null ? ((FillOptions) builtinOptions68).unpack() : null);
                break;
            case 69:
                Table builtinOptions69 = builtinOptions(new BidirectionalSequenceLSTMOptions());
                builtinOptionsUnion.setValue(builtinOptions69 != null ? ((BidirectionalSequenceLSTMOptions) builtinOptions69).unpack() : null);
                break;
            case 70:
                Table builtinOptions70 = builtinOptions(new BidirectionalSequenceRNNOptions());
                builtinOptionsUnion.setValue(builtinOptions70 != null ? ((BidirectionalSequenceRNNOptions) builtinOptions70).unpack() : null);
                break;
            case 71:
                Table builtinOptions71 = builtinOptions(new UnidirectionalSequenceLSTMOptions());
                builtinOptionsUnion.setValue(builtinOptions71 != null ? ((UnidirectionalSequenceLSTMOptions) builtinOptions71).unpack() : null);
                break;
            case 72:
                Table builtinOptions72 = builtinOptions(new FloorModOptions());
                builtinOptionsUnion.setValue(builtinOptions72 != null ? ((FloorModOptions) builtinOptions72).unpack() : null);
                break;
            case 73:
                Table builtinOptions73 = builtinOptions(new RangeOptions());
                builtinOptionsUnion.setValue(builtinOptions73 != null ? ((RangeOptions) builtinOptions73).unpack() : null);
                break;
            case 74:
                Table builtinOptions74 = builtinOptions(new ResizeNearestNeighborOptions());
                builtinOptionsUnion.setValue(builtinOptions74 != null ? ((ResizeNearestNeighborOptions) builtinOptions74).unpack() : null);
                break;
            case 75:
                Table builtinOptions75 = builtinOptions(new LeakyReluOptions());
                builtinOptionsUnion.setValue(builtinOptions75 != null ? ((LeakyReluOptions) builtinOptions75).unpack() : null);
                break;
            case 76:
                Table builtinOptions76 = builtinOptions(new SquaredDifferenceOptions());
                builtinOptionsUnion.setValue(builtinOptions76 != null ? ((SquaredDifferenceOptions) builtinOptions76).unpack() : null);
                break;
            case 77:
                Table builtinOptions77 = builtinOptions(new MirrorPadOptions());
                builtinOptionsUnion.setValue(builtinOptions77 != null ? ((MirrorPadOptions) builtinOptions77).unpack() : null);
                break;
            case 78:
                Table builtinOptions78 = builtinOptions(new AbsOptions());
                builtinOptionsUnion.setValue(builtinOptions78 != null ? ((AbsOptions) builtinOptions78).unpack() : null);
                break;
            case 79:
                Table builtinOptions79 = builtinOptions(new SplitVOptions());
                builtinOptionsUnion.setValue(builtinOptions79 != null ? ((SplitVOptions) builtinOptions79).unpack() : null);
                break;
            case 80:
                Table builtinOptions80 = builtinOptions(new UniqueOptions());
                builtinOptionsUnion.setValue(builtinOptions80 != null ? ((UniqueOptions) builtinOptions80).unpack() : null);
                break;
            case 81:
                Table builtinOptions81 = builtinOptions(new ReverseV2Options());
                builtinOptionsUnion.setValue(builtinOptions81 != null ? ((ReverseV2Options) builtinOptions81).unpack() : null);
                break;
            case 82:
                Table builtinOptions82 = builtinOptions(new AddNOptions());
                builtinOptionsUnion.setValue(builtinOptions82 != null ? ((AddNOptions) builtinOptions82).unpack() : null);
                break;
            case 83:
                Table builtinOptions83 = builtinOptions(new GatherNdOptions());
                builtinOptionsUnion.setValue(builtinOptions83 != null ? ((GatherNdOptions) builtinOptions83).unpack() : null);
                break;
            case 84:
                Table builtinOptions84 = builtinOptions(new CosOptions());
                builtinOptionsUnion.setValue(builtinOptions84 != null ? ((CosOptions) builtinOptions84).unpack() : null);
                break;
            case 85:
                Table builtinOptions85 = builtinOptions(new WhereOptions());
                builtinOptionsUnion.setValue(builtinOptions85 != null ? ((WhereOptions) builtinOptions85).unpack() : null);
                break;
            case 86:
                Table builtinOptions86 = builtinOptions(new RankOptions());
                builtinOptionsUnion.setValue(builtinOptions86 != null ? ((RankOptions) builtinOptions86).unpack() : null);
                break;
            case 87:
                Table builtinOptions87 = builtinOptions(new ReverseSequenceOptions());
                builtinOptionsUnion.setValue(builtinOptions87 != null ? ((ReverseSequenceOptions) builtinOptions87).unpack() : null);
                break;
            case 88:
                Table builtinOptions88 = builtinOptions(new MatrixDiagOptions());
                builtinOptionsUnion.setValue(builtinOptions88 != null ? ((MatrixDiagOptions) builtinOptions88).unpack() : null);
                break;
            case 89:
                Table builtinOptions89 = builtinOptions(new QuantizeOptions());
                builtinOptionsUnion.setValue(builtinOptions89 != null ? ((QuantizeOptions) builtinOptions89).unpack() : null);
                break;
            case 90:
                Table builtinOptions90 = builtinOptions(new MatrixSetDiagOptions());
                builtinOptionsUnion.setValue(builtinOptions90 != null ? ((MatrixSetDiagOptions) builtinOptions90).unpack() : null);
                break;
            case 91:
                Table builtinOptions91 = builtinOptions(new HardSwishOptions());
                builtinOptionsUnion.setValue(builtinOptions91 != null ? ((HardSwishOptions) builtinOptions91).unpack() : null);
                break;
            case 92:
                Table builtinOptions92 = builtinOptions(new IfOptions());
                builtinOptionsUnion.setValue(builtinOptions92 != null ? ((IfOptions) builtinOptions92).unpack() : null);
                break;
            case 93:
                Table builtinOptions93 = builtinOptions(new WhileOptions());
                builtinOptionsUnion.setValue(builtinOptions93 != null ? ((WhileOptions) builtinOptions93).unpack() : null);
                break;
            case 94:
                Table builtinOptions94 = builtinOptions(new DepthToSpaceOptions());
                builtinOptionsUnion.setValue(builtinOptions94 != null ? ((DepthToSpaceOptions) builtinOptions94).unpack() : null);
                break;
            case 95:
                Table builtinOptions95 = builtinOptions(new NonMaxSuppressionV4Options());
                builtinOptionsUnion.setValue(builtinOptions95 != null ? ((NonMaxSuppressionV4Options) builtinOptions95).unpack() : null);
                break;
            case 96:
                Table builtinOptions96 = builtinOptions(new NonMaxSuppressionV5Options());
                builtinOptionsUnion.setValue(builtinOptions96 != null ? ((NonMaxSuppressionV5Options) builtinOptions96).unpack() : null);
                break;
            case 97:
                Table builtinOptions97 = builtinOptions(new ScatterNdOptions());
                builtinOptionsUnion.setValue(builtinOptions97 != null ? ((ScatterNdOptions) builtinOptions97).unpack() : null);
                break;
            case 98:
                Table builtinOptions98 = builtinOptions(new SelectV2Options());
                builtinOptionsUnion.setValue(builtinOptions98 != null ? ((SelectV2Options) builtinOptions98).unpack() : null);
                break;
            case 99:
                Table builtinOptions99 = builtinOptions(new DensifyOptions());
                builtinOptionsUnion.setValue(builtinOptions99 != null ? ((DensifyOptions) builtinOptions99).unpack() : null);
                break;
            case 100:
                Table builtinOptions100 = builtinOptions(new SegmentSumOptions());
                builtinOptionsUnion.setValue(builtinOptions100 != null ? ((SegmentSumOptions) builtinOptions100).unpack() : null);
                break;
            case 101:
                Table builtinOptions101 = builtinOptions(new BatchMatMulOptions());
                builtinOptionsUnion.setValue(builtinOptions101 != null ? ((BatchMatMulOptions) builtinOptions101).unpack() : null);
                break;
            case 102:
                Table builtinOptions102 = builtinOptions(new CumsumOptions());
                builtinOptionsUnion.setValue(builtinOptions102 != null ? ((CumsumOptions) builtinOptions102).unpack() : null);
                break;
            case 103:
                Table builtinOptions103 = builtinOptions(new CallOnceOptions());
                builtinOptionsUnion.setValue(builtinOptions103 != null ? ((CallOnceOptions) builtinOptions103).unpack() : null);
                break;
            case 104:
                Table builtinOptions104 = builtinOptions(new BroadcastToOptions());
                builtinOptionsUnion.setValue(builtinOptions104 != null ? ((BroadcastToOptions) builtinOptions104).unpack() : null);
                break;
            case 105:
                Table builtinOptions105 = builtinOptions(new Rfft2dOptions());
                builtinOptionsUnion.setValue(builtinOptions105 != null ? ((Rfft2dOptions) builtinOptions105).unpack() : null);
                break;
            case 106:
                Table builtinOptions106 = builtinOptions(new Conv3DOptions());
                builtinOptionsUnion.setValue(builtinOptions106 != null ? ((Conv3DOptions) builtinOptions106).unpack() : null);
                break;
            case 107:
                Table builtinOptions107 = builtinOptions(new HashtableOptions());
                builtinOptionsUnion.setValue(builtinOptions107 != null ? ((HashtableOptions) builtinOptions107).unpack() : null);
                break;
            case 108:
                Table builtinOptions108 = builtinOptions(new HashtableFindOptions());
                builtinOptionsUnion.setValue(builtinOptions108 != null ? ((HashtableFindOptions) builtinOptions108).unpack() : null);
                break;
            case 109:
                Table builtinOptions109 = builtinOptions(new HashtableImportOptions());
                builtinOptionsUnion.setValue(builtinOptions109 != null ? ((HashtableImportOptions) builtinOptions109).unpack() : null);
                break;
            case 110:
                Table builtinOptions110 = builtinOptions(new HashtableSizeOptions());
                builtinOptionsUnion.setValue(builtinOptions110 != null ? ((HashtableSizeOptions) builtinOptions110).unpack() : null);
                break;
            case 111:
                Table builtinOptions111 = builtinOptions(new VarHandleOptions());
                builtinOptionsUnion.setValue(builtinOptions111 != null ? ((VarHandleOptions) builtinOptions111).unpack() : null);
                break;
            case 112:
                Table builtinOptions112 = builtinOptions(new ReadVariableOptions());
                builtinOptionsUnion.setValue(builtinOptions112 != null ? ((ReadVariableOptions) builtinOptions112).unpack() : null);
                break;
            case 113:
                Table builtinOptions113 = builtinOptions(new AssignVariableOptions());
                builtinOptionsUnion.setValue(builtinOptions113 != null ? ((AssignVariableOptions) builtinOptions113).unpack() : null);
                break;
            case 114:
                Table builtinOptions114 = builtinOptions(new RandomOptions());
                builtinOptionsUnion.setValue(builtinOptions114 != null ? ((RandomOptions) builtinOptions114).unpack() : null);
                break;
            case 115:
                Table builtinOptions115 = builtinOptions(new BucketizeOptions());
                builtinOptionsUnion.setValue(builtinOptions115 != null ? ((BucketizeOptions) builtinOptions115).unpack() : null);
                break;
            case 116:
                Table builtinOptions116 = builtinOptions(new GeluOptions());
                builtinOptionsUnion.setValue(builtinOptions116 != null ? ((GeluOptions) builtinOptions116).unpack() : null);
                break;
            case 117:
                Table builtinOptions117 = builtinOptions(new DynamicUpdateSliceOptions());
                builtinOptionsUnion.setValue(builtinOptions117 != null ? ((DynamicUpdateSliceOptions) builtinOptions117).unpack() : null);
                break;
            case 118:
                Table builtinOptions118 = builtinOptions(new UnsortedSegmentProdOptions());
                builtinOptionsUnion.setValue(builtinOptions118 != null ? ((UnsortedSegmentProdOptions) builtinOptions118).unpack() : null);
                break;
            case 119:
                Table builtinOptions119 = builtinOptions(new UnsortedSegmentMaxOptions());
                builtinOptionsUnion.setValue(builtinOptions119 != null ? ((UnsortedSegmentMaxOptions) builtinOptions119).unpack() : null);
                break;
            case 120:
                Table builtinOptions120 = builtinOptions(new UnsortedSegmentMinOptions());
                builtinOptionsUnion.setValue(builtinOptions120 != null ? ((UnsortedSegmentMinOptions) builtinOptions120).unpack() : null);
                break;
            case 121:
                Table builtinOptions121 = builtinOptions(new UnsortedSegmentSumOptions());
                builtinOptionsUnion.setValue(builtinOptions121 != null ? ((UnsortedSegmentSumOptions) builtinOptions121).unpack() : null);
                break;
            case 122:
                Table builtinOptions122 = builtinOptions(new ATan2Options());
                builtinOptionsUnion.setValue(builtinOptions122 != null ? ((ATan2Options) builtinOptions122).unpack() : null);
                break;
            case 123:
                Table builtinOptions123 = builtinOptions(new SignOptions());
                builtinOptionsUnion.setValue(builtinOptions123 != null ? ((SignOptions) builtinOptions123).unpack() : null);
                break;
        }
        operatorT.setBuiltinOptions(builtinOptionsUnion);
        int[] iArr3 = new int[customOptionsLength()];
        for (int i3 = 0; i3 < customOptionsLength(); i3++) {
            iArr3[i3] = customOptions(i3);
        }
        operatorT.setCustomOptions(iArr3);
        operatorT.setCustomOptionsFormat(customOptionsFormat());
        boolean[] zArr = new boolean[mutatingVariableInputsLength()];
        for (int i4 = 0; i4 < mutatingVariableInputsLength(); i4++) {
            zArr[i4] = mutatingVariableInputs(i4);
        }
        operatorT.setMutatingVariableInputs(zArr);
        int[] iArr4 = new int[intermediatesLength()];
        for (int i5 = 0; i5 < intermediatesLength(); i5++) {
            iArr4[i5] = intermediates(i5);
        }
        operatorT.setIntermediates(iArr4);
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, OperatorT operatorT) {
        int i;
        if (operatorT == null) {
            return 0;
        }
        int createInputsVector = operatorT.getInputs() != null ? createInputsVector(flatBufferBuilder, operatorT.getInputs()) : 0;
        int createOutputsVector = operatorT.getOutputs() != null ? createOutputsVector(flatBufferBuilder, operatorT.getOutputs()) : 0;
        byte type = operatorT.getBuiltinOptions() == null ? (byte) 0 : operatorT.getBuiltinOptions().getType();
        int pack = operatorT.getBuiltinOptions() == null ? 0 : BuiltinOptionsUnion.pack(flatBufferBuilder, operatorT.getBuiltinOptions());
        if (operatorT.getCustomOptions() != null) {
            byte[] bArr = new byte[operatorT.getCustomOptions().length];
            int i2 = 0;
            for (int i3 : operatorT.getCustomOptions()) {
                bArr[i2] = (byte) i3;
                i2++;
            }
            i = createCustomOptionsVector(flatBufferBuilder, bArr);
        } else {
            i = 0;
        }
        return createOperator(flatBufferBuilder, operatorT.getOpcodeIndex(), createInputsVector, createOutputsVector, type, pack, i, operatorT.getCustomOptionsFormat(), operatorT.getMutatingVariableInputs() != null ? createMutatingVariableInputsVector(flatBufferBuilder, operatorT.getMutatingVariableInputs()) : 0, operatorT.getIntermediates() != null ? createIntermediatesVector(flatBufferBuilder, operatorT.getIntermediates()) : 0);
    }
}
