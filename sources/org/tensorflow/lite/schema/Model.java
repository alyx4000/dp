package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.IntVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.tensorflow.lite.schema.Buffer;
import org.tensorflow.lite.schema.Metadata;
import org.tensorflow.lite.schema.OperatorCode;
import org.tensorflow.lite.schema.SignatureDef;
import org.tensorflow.lite.schema.SubGraph;

/* loaded from: classes6.dex */
public final class Model extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static Model getRootAsModel(ByteBuffer byteBuffer) {
        return getRootAsModel(byteBuffer, new Model());
    }

    public static Model getRootAsModel(ByteBuffer byteBuffer, Model model) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return model.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public static boolean ModelBufferHasIdentifier(ByteBuffer byteBuffer) {
        return __has_identifier(byteBuffer, "TFL3");
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public Model __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public long version() {
        if (__offset(4) != 0) {
            return this.bb.getInt(r0 + this.bb_pos) & BodyPartID.bodyIdMax;
        }
        return 0L;
    }

    public OperatorCode operatorCodes(int i) {
        return operatorCodes(new OperatorCode(), i);
    }

    public OperatorCode operatorCodes(OperatorCode operatorCode, int i) {
        int __offset = __offset(6);
        if (__offset != 0) {
            return operatorCode.__assign(__indirect(__vector(__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int operatorCodesLength() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public OperatorCode.Vector operatorCodesVector() {
        return operatorCodesVector(new OperatorCode.Vector());
    }

    public OperatorCode.Vector operatorCodesVector(OperatorCode.Vector vector) {
        int __offset = __offset(6);
        if (__offset != 0) {
            return vector.__assign(__vector(__offset), 4, this.bb);
        }
        return null;
    }

    public SubGraph subgraphs(int i) {
        return subgraphs(new SubGraph(), i);
    }

    public SubGraph subgraphs(SubGraph subGraph, int i) {
        int __offset = __offset(8);
        if (__offset != 0) {
            return subGraph.__assign(__indirect(__vector(__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int subgraphsLength() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public SubGraph.Vector subgraphsVector() {
        return subgraphsVector(new SubGraph.Vector());
    }

    public SubGraph.Vector subgraphsVector(SubGraph.Vector vector) {
        int __offset = __offset(8);
        if (__offset != 0) {
            return vector.__assign(__vector(__offset), 4, this.bb);
        }
        return null;
    }

    public String description() {
        int __offset = __offset(10);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer descriptionAsByteBuffer() {
        return __vector_as_bytebuffer(10, 1);
    }

    public ByteBuffer descriptionInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 10, 1);
    }

    public Buffer buffers(int i) {
        return buffers(new Buffer(), i);
    }

    public Buffer buffers(Buffer buffer, int i) {
        int __offset = __offset(12);
        if (__offset != 0) {
            return buffer.__assign(__indirect(__vector(__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int buffersLength() {
        int __offset = __offset(12);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public Buffer.Vector buffersVector() {
        return buffersVector(new Buffer.Vector());
    }

    public Buffer.Vector buffersVector(Buffer.Vector vector) {
        int __offset = __offset(12);
        if (__offset != 0) {
            return vector.__assign(__vector(__offset), 4, this.bb);
        }
        return null;
    }

    public int metadataBuffer(int i) {
        int __offset = __offset(14);
        if (__offset != 0) {
            return this.bb.getInt(__vector(__offset) + (i * 4));
        }
        return 0;
    }

    public int metadataBufferLength() {
        int __offset = __offset(14);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public IntVector metadataBufferVector() {
        return metadataBufferVector(new IntVector());
    }

    public IntVector metadataBufferVector(IntVector intVector) {
        int __offset = __offset(14);
        if (__offset != 0) {
            return intVector.__assign(__vector(__offset), this.bb);
        }
        return null;
    }

    public ByteBuffer metadataBufferAsByteBuffer() {
        return __vector_as_bytebuffer(14, 4);
    }

    public ByteBuffer metadataBufferInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 14, 4);
    }

    public Metadata metadata(int i) {
        return metadata(new Metadata(), i);
    }

    public Metadata metadata(Metadata metadata, int i) {
        int __offset = __offset(16);
        if (__offset != 0) {
            return metadata.__assign(__indirect(__vector(__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int metadataLength() {
        int __offset = __offset(16);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public Metadata.Vector metadataVector() {
        return metadataVector(new Metadata.Vector());
    }

    public Metadata.Vector metadataVector(Metadata.Vector vector) {
        int __offset = __offset(16);
        if (__offset != 0) {
            return vector.__assign(__vector(__offset), 4, this.bb);
        }
        return null;
    }

    public SignatureDef signatureDefs(int i) {
        return signatureDefs(new SignatureDef(), i);
    }

    public SignatureDef signatureDefs(SignatureDef signatureDef, int i) {
        int __offset = __offset(18);
        if (__offset != 0) {
            return signatureDef.__assign(__indirect(__vector(__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int signatureDefsLength() {
        int __offset = __offset(18);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public SignatureDef.Vector signatureDefsVector() {
        return signatureDefsVector(new SignatureDef.Vector());
    }

    public SignatureDef.Vector signatureDefsVector(SignatureDef.Vector vector) {
        int __offset = __offset(18);
        if (__offset != 0) {
            return vector.__assign(__vector(__offset), 4, this.bb);
        }
        return null;
    }

    public static int createModel(FlatBufferBuilder flatBufferBuilder, long j, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        flatBufferBuilder.startTable(8);
        addSignatureDefs(flatBufferBuilder, i7);
        addMetadata(flatBufferBuilder, i6);
        addMetadataBuffer(flatBufferBuilder, i5);
        addBuffers(flatBufferBuilder, i4);
        addDescription(flatBufferBuilder, i3);
        addSubgraphs(flatBufferBuilder, i2);
        addOperatorCodes(flatBufferBuilder, i);
        addVersion(flatBufferBuilder, j);
        return endModel(flatBufferBuilder);
    }

    public static void startModel(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(8);
    }

    public static void addVersion(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(0, (int) j, 0);
    }

    public static void addOperatorCodes(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static int createOperatorCodesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startOperatorCodesVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addSubgraphs(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(2, i, 0);
    }

    public static int createSubgraphsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startSubgraphsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addDescription(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(3, i, 0);
    }

    public static void addBuffers(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(4, i, 0);
    }

    public static int createBuffersVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startBuffersVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addMetadataBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(5, i, 0);
    }

    public static int createMetadataBufferVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addInt(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startMetadataBufferVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addMetadata(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(6, i, 0);
    }

    public static int createMetadataVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startMetadataVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addSignatureDefs(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(7, i, 0);
    }

    public static int createSignatureDefsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startSignatureDefsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static int endModel(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static void finishModelBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finish(i, "TFL3");
    }

    public static void finishSizePrefixedModelBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finishSizePrefixed(i, "TFL3");
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public Model get(int i) {
            return get(new Model(), i);
        }

        public Model get(Model model, int i) {
            return model.__assign(Model.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public ModelT unpack() {
        ModelT modelT = new ModelT();
        unpackTo(modelT);
        return modelT;
    }

    public void unpackTo(ModelT modelT) {
        modelT.setVersion(version());
        OperatorCodeT[] operatorCodeTArr = new OperatorCodeT[operatorCodesLength()];
        int i = 0;
        while (true) {
            OperatorCodeT operatorCodeT = null;
            if (i >= operatorCodesLength()) {
                break;
            }
            if (operatorCodes(i) != null) {
                operatorCodeT = operatorCodes(i).unpack();
            }
            operatorCodeTArr[i] = operatorCodeT;
            i++;
        }
        modelT.setOperatorCodes(operatorCodeTArr);
        SubGraphT[] subGraphTArr = new SubGraphT[subgraphsLength()];
        for (int i2 = 0; i2 < subgraphsLength(); i2++) {
            subGraphTArr[i2] = subgraphs(i2) != null ? subgraphs(i2).unpack() : null;
        }
        modelT.setSubgraphs(subGraphTArr);
        modelT.setDescription(description());
        BufferT[] bufferTArr = new BufferT[buffersLength()];
        for (int i3 = 0; i3 < buffersLength(); i3++) {
            bufferTArr[i3] = buffers(i3) != null ? buffers(i3).unpack() : null;
        }
        modelT.setBuffers(bufferTArr);
        int[] iArr = new int[metadataBufferLength()];
        for (int i4 = 0; i4 < metadataBufferLength(); i4++) {
            iArr[i4] = metadataBuffer(i4);
        }
        modelT.setMetadataBuffer(iArr);
        MetadataT[] metadataTArr = new MetadataT[metadataLength()];
        for (int i5 = 0; i5 < metadataLength(); i5++) {
            metadataTArr[i5] = metadata(i5) != null ? metadata(i5).unpack() : null;
        }
        modelT.setMetadata(metadataTArr);
        SignatureDefT[] signatureDefTArr = new SignatureDefT[signatureDefsLength()];
        for (int i6 = 0; i6 < signatureDefsLength(); i6++) {
            signatureDefTArr[i6] = signatureDefs(i6) != null ? signatureDefs(i6).unpack() : null;
        }
        modelT.setSignatureDefs(signatureDefTArr);
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, ModelT modelT) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        if (modelT == null) {
            return 0;
        }
        if (modelT.getOperatorCodes() != null) {
            int[] iArr = new int[modelT.getOperatorCodes().length];
            int i6 = 0;
            for (OperatorCodeT operatorCodeT : modelT.getOperatorCodes()) {
                iArr[i6] = OperatorCode.pack(flatBufferBuilder, operatorCodeT);
                i6++;
            }
            i = createOperatorCodesVector(flatBufferBuilder, iArr);
        } else {
            i = 0;
        }
        if (modelT.getSubgraphs() != null) {
            int[] iArr2 = new int[modelT.getSubgraphs().length];
            int i7 = 0;
            for (SubGraphT subGraphT : modelT.getSubgraphs()) {
                iArr2[i7] = SubGraph.pack(flatBufferBuilder, subGraphT);
                i7++;
            }
            i2 = createSubgraphsVector(flatBufferBuilder, iArr2);
        } else {
            i2 = 0;
        }
        int createString = modelT.getDescription() == null ? 0 : flatBufferBuilder.createString(modelT.getDescription());
        if (modelT.getBuffers() != null) {
            int[] iArr3 = new int[modelT.getBuffers().length];
            int i8 = 0;
            for (BufferT bufferT : modelT.getBuffers()) {
                iArr3[i8] = Buffer.pack(flatBufferBuilder, bufferT);
                i8++;
            }
            i3 = createBuffersVector(flatBufferBuilder, iArr3);
        } else {
            i3 = 0;
        }
        int createMetadataBufferVector = modelT.getMetadataBuffer() != null ? createMetadataBufferVector(flatBufferBuilder, modelT.getMetadataBuffer()) : 0;
        if (modelT.getMetadata() != null) {
            int[] iArr4 = new int[modelT.getMetadata().length];
            int i9 = 0;
            for (MetadataT metadataT : modelT.getMetadata()) {
                iArr4[i9] = Metadata.pack(flatBufferBuilder, metadataT);
                i9++;
            }
            i4 = createMetadataVector(flatBufferBuilder, iArr4);
        } else {
            i4 = 0;
        }
        if (modelT.getSignatureDefs() != null) {
            int[] iArr5 = new int[modelT.getSignatureDefs().length];
            SignatureDefT[] signatureDefs = modelT.getSignatureDefs();
            int length = signatureDefs.length;
            int i10 = 0;
            while (i5 < length) {
                iArr5[i10] = SignatureDef.pack(flatBufferBuilder, signatureDefs[i5]);
                i10++;
                i5++;
            }
            i5 = createSignatureDefsVector(flatBufferBuilder, iArr5);
        }
        return createModel(flatBufferBuilder, modelT.getVersion(), i, i2, createString, i3, createMetadataBufferVector, i4, i5);
    }
}
