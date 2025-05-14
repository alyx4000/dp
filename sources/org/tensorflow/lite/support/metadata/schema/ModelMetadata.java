package org.tensorflow.lite.support.metadata.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.tensorflow.lite.support.metadata.schema.AssociatedFile;
import org.tensorflow.lite.support.metadata.schema.SubGraphMetadata;

/* loaded from: classes6.dex */
public final class ModelMetadata extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static ModelMetadata getRootAsModelMetadata(ByteBuffer byteBuffer) {
        return getRootAsModelMetadata(byteBuffer, new ModelMetadata());
    }

    public static ModelMetadata getRootAsModelMetadata(ByteBuffer byteBuffer, ModelMetadata modelMetadata) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return modelMetadata.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public static boolean ModelMetadataBufferHasIdentifier(ByteBuffer byteBuffer) {
        return __has_identifier(byteBuffer, "M001");
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public ModelMetadata __assign(int i, ByteBuffer byteBuffer) {
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

    public String version() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer versionAsByteBuffer() {
        return __vector_as_bytebuffer(8, 1);
    }

    public ByteBuffer versionInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 8, 1);
    }

    public SubGraphMetadata subgraphMetadata(int i) {
        return subgraphMetadata(new SubGraphMetadata(), i);
    }

    public SubGraphMetadata subgraphMetadata(SubGraphMetadata subGraphMetadata, int i) {
        int __offset = __offset(10);
        if (__offset != 0) {
            return subGraphMetadata.__assign(__indirect(__vector(__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int subgraphMetadataLength() {
        int __offset = __offset(10);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public SubGraphMetadata.Vector subgraphMetadataVector() {
        return subgraphMetadataVector(new SubGraphMetadata.Vector());
    }

    public SubGraphMetadata.Vector subgraphMetadataVector(SubGraphMetadata.Vector vector) {
        int __offset = __offset(10);
        if (__offset != 0) {
            return vector.__assign(__vector(__offset), 4, this.bb);
        }
        return null;
    }

    public String author() {
        int __offset = __offset(12);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer authorAsByteBuffer() {
        return __vector_as_bytebuffer(12, 1);
    }

    public ByteBuffer authorInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 12, 1);
    }

    public String license() {
        int __offset = __offset(14);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer licenseAsByteBuffer() {
        return __vector_as_bytebuffer(14, 1);
    }

    public ByteBuffer licenseInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 14, 1);
    }

    public AssociatedFile associatedFiles(int i) {
        return associatedFiles(new AssociatedFile(), i);
    }

    public AssociatedFile associatedFiles(AssociatedFile associatedFile, int i) {
        int __offset = __offset(16);
        if (__offset != 0) {
            return associatedFile.__assign(__indirect(__vector(__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int associatedFilesLength() {
        int __offset = __offset(16);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public AssociatedFile.Vector associatedFilesVector() {
        return associatedFilesVector(new AssociatedFile.Vector());
    }

    public AssociatedFile.Vector associatedFilesVector(AssociatedFile.Vector vector) {
        int __offset = __offset(16);
        if (__offset != 0) {
            return vector.__assign(__vector(__offset), 4, this.bb);
        }
        return null;
    }

    public String minParserVersion() {
        int __offset = __offset(18);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer minParserVersionAsByteBuffer() {
        return __vector_as_bytebuffer(18, 1);
    }

    public ByteBuffer minParserVersionInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 18, 1);
    }

    public static int createModelMetadata(FlatBufferBuilder flatBufferBuilder, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        flatBufferBuilder.startTable(8);
        addMinParserVersion(flatBufferBuilder, i8);
        addAssociatedFiles(flatBufferBuilder, i7);
        addLicense(flatBufferBuilder, i6);
        addAuthor(flatBufferBuilder, i5);
        addSubgraphMetadata(flatBufferBuilder, i4);
        addVersion(flatBufferBuilder, i3);
        addDescription(flatBufferBuilder, i2);
        addName(flatBufferBuilder, i);
        return endModelMetadata(flatBufferBuilder);
    }

    public static void startModelMetadata(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(8);
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static void addDescription(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static void addVersion(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(2, i, 0);
    }

    public static void addSubgraphMetadata(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(3, i, 0);
    }

    public static int createSubgraphMetadataVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startSubgraphMetadataVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addAuthor(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(4, i, 0);
    }

    public static void addLicense(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(5, i, 0);
    }

    public static void addAssociatedFiles(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(6, i, 0);
    }

    public static int createAssociatedFilesVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startAssociatedFilesVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addMinParserVersion(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(7, i, 0);
    }

    public static int endModelMetadata(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static void finishModelMetadataBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finish(i, "M001");
    }

    public static void finishSizePrefixedModelMetadataBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finishSizePrefixed(i, "M001");
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public ModelMetadata get(int i) {
            return get(new ModelMetadata(), i);
        }

        public ModelMetadata get(ModelMetadata modelMetadata, int i) {
            return modelMetadata.__assign(ModelMetadata.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public ModelMetadataT unpack() {
        ModelMetadataT modelMetadataT = new ModelMetadataT();
        unpackTo(modelMetadataT);
        return modelMetadataT;
    }

    public void unpackTo(ModelMetadataT modelMetadataT) {
        modelMetadataT.setName(name());
        modelMetadataT.setDescription(description());
        modelMetadataT.setVersion(version());
        SubGraphMetadataT[] subGraphMetadataTArr = new SubGraphMetadataT[subgraphMetadataLength()];
        int i = 0;
        while (true) {
            SubGraphMetadataT subGraphMetadataT = null;
            if (i >= subgraphMetadataLength()) {
                break;
            }
            if (subgraphMetadata(i) != null) {
                subGraphMetadataT = subgraphMetadata(i).unpack();
            }
            subGraphMetadataTArr[i] = subGraphMetadataT;
            i++;
        }
        modelMetadataT.setSubgraphMetadata(subGraphMetadataTArr);
        modelMetadataT.setAuthor(author());
        modelMetadataT.setLicense(license());
        AssociatedFileT[] associatedFileTArr = new AssociatedFileT[associatedFilesLength()];
        for (int i2 = 0; i2 < associatedFilesLength(); i2++) {
            associatedFileTArr[i2] = associatedFiles(i2) != null ? associatedFiles(i2).unpack() : null;
        }
        modelMetadataT.setAssociatedFiles(associatedFileTArr);
        modelMetadataT.setMinParserVersion(minParserVersion());
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, ModelMetadataT modelMetadataT) {
        int i;
        int i2;
        if (modelMetadataT == null) {
            return 0;
        }
        int createString = modelMetadataT.getName() == null ? 0 : flatBufferBuilder.createString(modelMetadataT.getName());
        int createString2 = modelMetadataT.getDescription() == null ? 0 : flatBufferBuilder.createString(modelMetadataT.getDescription());
        int createString3 = modelMetadataT.getVersion() == null ? 0 : flatBufferBuilder.createString(modelMetadataT.getVersion());
        if (modelMetadataT.getSubgraphMetadata() != null) {
            int[] iArr = new int[modelMetadataT.getSubgraphMetadata().length];
            int i3 = 0;
            for (SubGraphMetadataT subGraphMetadataT : modelMetadataT.getSubgraphMetadata()) {
                iArr[i3] = SubGraphMetadata.pack(flatBufferBuilder, subGraphMetadataT);
                i3++;
            }
            i = createSubgraphMetadataVector(flatBufferBuilder, iArr);
        } else {
            i = 0;
        }
        int createString4 = modelMetadataT.getAuthor() == null ? 0 : flatBufferBuilder.createString(modelMetadataT.getAuthor());
        int createString5 = modelMetadataT.getLicense() == null ? 0 : flatBufferBuilder.createString(modelMetadataT.getLicense());
        if (modelMetadataT.getAssociatedFiles() != null) {
            int[] iArr2 = new int[modelMetadataT.getAssociatedFiles().length];
            int i4 = 0;
            for (AssociatedFileT associatedFileT : modelMetadataT.getAssociatedFiles()) {
                iArr2[i4] = AssociatedFile.pack(flatBufferBuilder, associatedFileT);
                i4++;
            }
            i2 = createAssociatedFilesVector(flatBufferBuilder, iArr2);
        } else {
            i2 = 0;
        }
        return createModelMetadata(flatBufferBuilder, createString, createString2, createString3, i, createString4, createString5, i2, modelMetadataT.getMinParserVersion() != null ? flatBufferBuilder.createString(modelMetadataT.getMinParserVersion()) : 0);
    }
}
