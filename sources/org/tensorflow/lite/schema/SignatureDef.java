package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.tensorflow.lite.schema.TensorMap;

/* loaded from: classes6.dex */
public final class SignatureDef extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static SignatureDef getRootAsSignatureDef(ByteBuffer byteBuffer) {
        return getRootAsSignatureDef(byteBuffer, new SignatureDef());
    }

    public static SignatureDef getRootAsSignatureDef(ByteBuffer byteBuffer, SignatureDef signatureDef) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return signatureDef.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public SignatureDef __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public TensorMap inputs(int i) {
        return inputs(new TensorMap(), i);
    }

    public TensorMap inputs(TensorMap tensorMap, int i) {
        int __offset = __offset(4);
        if (__offset != 0) {
            return tensorMap.__assign(__indirect(__vector(__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int inputsLength() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public TensorMap.Vector inputsVector() {
        return inputsVector(new TensorMap.Vector());
    }

    public TensorMap.Vector inputsVector(TensorMap.Vector vector) {
        int __offset = __offset(4);
        if (__offset != 0) {
            return vector.__assign(__vector(__offset), 4, this.bb);
        }
        return null;
    }

    public TensorMap outputs(int i) {
        return outputs(new TensorMap(), i);
    }

    public TensorMap outputs(TensorMap tensorMap, int i) {
        int __offset = __offset(6);
        if (__offset != 0) {
            return tensorMap.__assign(__indirect(__vector(__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int outputsLength() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public TensorMap.Vector outputsVector() {
        return outputsVector(new TensorMap.Vector());
    }

    public TensorMap.Vector outputsVector(TensorMap.Vector vector) {
        int __offset = __offset(6);
        if (__offset != 0) {
            return vector.__assign(__vector(__offset), 4, this.bb);
        }
        return null;
    }

    public String signatureKey() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer signatureKeyAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer signatureKeyInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public long subgraphIndex() {
        if (__offset(12) != 0) {
            return this.bb.getInt(r0 + this.bb_pos) & BodyPartID.bodyIdMax;
        }
        return 0L;
    }

    public static int createSignatureDef(FlatBufferBuilder flatBufferBuilder, int i, int i2, int i3, long j) {
        flatBufferBuilder.startTable(5);
        addSubgraphIndex(flatBufferBuilder, j);
        addSignatureKey(flatBufferBuilder, i3);
        addOutputs(flatBufferBuilder, i2);
        addInputs(flatBufferBuilder, i);
        return endSignatureDef(flatBufferBuilder);
    }

    public static void startSignatureDef(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(5);
    }

    public static void addInputs(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static int createInputsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startInputsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addOutputs(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static int createOutputsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startOutputsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addSignatureKey(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(2, i, 0);
    }

    public static void addSubgraphIndex(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(4, (int) j, 0);
    }

    public static int endSignatureDef(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public SignatureDef get(int i) {
            return get(new SignatureDef(), i);
        }

        public SignatureDef get(SignatureDef signatureDef, int i) {
            return signatureDef.__assign(SignatureDef.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public SignatureDefT unpack() {
        SignatureDefT signatureDefT = new SignatureDefT();
        unpackTo(signatureDefT);
        return signatureDefT;
    }

    public void unpackTo(SignatureDefT signatureDefT) {
        TensorMapT[] tensorMapTArr = new TensorMapT[inputsLength()];
        int i = 0;
        while (true) {
            TensorMapT tensorMapT = null;
            if (i >= inputsLength()) {
                break;
            }
            if (inputs(i) != null) {
                tensorMapT = inputs(i).unpack();
            }
            tensorMapTArr[i] = tensorMapT;
            i++;
        }
        signatureDefT.setInputs(tensorMapTArr);
        TensorMapT[] tensorMapTArr2 = new TensorMapT[outputsLength()];
        for (int i2 = 0; i2 < outputsLength(); i2++) {
            tensorMapTArr2[i2] = outputs(i2) != null ? outputs(i2).unpack() : null;
        }
        signatureDefT.setOutputs(tensorMapTArr2);
        signatureDefT.setSignatureKey(signatureKey());
        signatureDefT.setSubgraphIndex(subgraphIndex());
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, SignatureDefT signatureDefT) {
        int i;
        int i2;
        if (signatureDefT == null) {
            return 0;
        }
        if (signatureDefT.getInputs() != null) {
            int[] iArr = new int[signatureDefT.getInputs().length];
            int i3 = 0;
            for (TensorMapT tensorMapT : signatureDefT.getInputs()) {
                iArr[i3] = TensorMap.pack(flatBufferBuilder, tensorMapT);
                i3++;
            }
            i = createInputsVector(flatBufferBuilder, iArr);
        } else {
            i = 0;
        }
        if (signatureDefT.getOutputs() != null) {
            int[] iArr2 = new int[signatureDefT.getOutputs().length];
            int i4 = 0;
            for (TensorMapT tensorMapT2 : signatureDefT.getOutputs()) {
                iArr2[i4] = TensorMap.pack(flatBufferBuilder, tensorMapT2);
                i4++;
            }
            i2 = createOutputsVector(flatBufferBuilder, iArr2);
        } else {
            i2 = 0;
        }
        return createSignatureDef(flatBufferBuilder, i, i2, signatureDefT.getSignatureKey() != null ? flatBufferBuilder.createString(signatureDefT.getSignatureKey()) : 0, signatureDefT.getSubgraphIndex());
    }
}
