package org.tensorflow.lite.support.metadata.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.tensorflow.lite.support.metadata.schema.AssociatedFile;
import org.tensorflow.lite.support.metadata.schema.ProcessUnit;
import org.tensorflow.lite.support.metadata.schema.TensorGroup;
import org.tensorflow.lite.support.metadata.schema.TensorMetadata;

/* loaded from: classes6.dex */
public final class SubGraphMetadata extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static SubGraphMetadata getRootAsSubGraphMetadata(ByteBuffer byteBuffer) {
        return getRootAsSubGraphMetadata(byteBuffer, new SubGraphMetadata());
    }

    public static SubGraphMetadata getRootAsSubGraphMetadata(ByteBuffer byteBuffer, SubGraphMetadata subGraphMetadata) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return subGraphMetadata.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public SubGraphMetadata __assign(int i, ByteBuffer byteBuffer) {
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

    public TensorMetadata inputTensorMetadata(int i) {
        return inputTensorMetadata(new TensorMetadata(), i);
    }

    public TensorMetadata inputTensorMetadata(TensorMetadata tensorMetadata, int i) {
        int __offset = __offset(8);
        if (__offset != 0) {
            return tensorMetadata.__assign(__indirect(__vector(__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int inputTensorMetadataLength() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public TensorMetadata.Vector inputTensorMetadataVector() {
        return inputTensorMetadataVector(new TensorMetadata.Vector());
    }

    public TensorMetadata.Vector inputTensorMetadataVector(TensorMetadata.Vector vector) {
        int __offset = __offset(8);
        if (__offset != 0) {
            return vector.__assign(__vector(__offset), 4, this.bb);
        }
        return null;
    }

    public TensorMetadata outputTensorMetadata(int i) {
        return outputTensorMetadata(new TensorMetadata(), i);
    }

    public TensorMetadata outputTensorMetadata(TensorMetadata tensorMetadata, int i) {
        int __offset = __offset(10);
        if (__offset != 0) {
            return tensorMetadata.__assign(__indirect(__vector(__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int outputTensorMetadataLength() {
        int __offset = __offset(10);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public TensorMetadata.Vector outputTensorMetadataVector() {
        return outputTensorMetadataVector(new TensorMetadata.Vector());
    }

    public TensorMetadata.Vector outputTensorMetadataVector(TensorMetadata.Vector vector) {
        int __offset = __offset(10);
        if (__offset != 0) {
            return vector.__assign(__vector(__offset), 4, this.bb);
        }
        return null;
    }

    public AssociatedFile associatedFiles(int i) {
        return associatedFiles(new AssociatedFile(), i);
    }

    public AssociatedFile associatedFiles(AssociatedFile associatedFile, int i) {
        int __offset = __offset(12);
        if (__offset != 0) {
            return associatedFile.__assign(__indirect(__vector(__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int associatedFilesLength() {
        int __offset = __offset(12);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public AssociatedFile.Vector associatedFilesVector() {
        return associatedFilesVector(new AssociatedFile.Vector());
    }

    public AssociatedFile.Vector associatedFilesVector(AssociatedFile.Vector vector) {
        int __offset = __offset(12);
        if (__offset != 0) {
            return vector.__assign(__vector(__offset), 4, this.bb);
        }
        return null;
    }

    public ProcessUnit inputProcessUnits(int i) {
        return inputProcessUnits(new ProcessUnit(), i);
    }

    public ProcessUnit inputProcessUnits(ProcessUnit processUnit, int i) {
        int __offset = __offset(14);
        if (__offset != 0) {
            return processUnit.__assign(__indirect(__vector(__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int inputProcessUnitsLength() {
        int __offset = __offset(14);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public ProcessUnit.Vector inputProcessUnitsVector() {
        return inputProcessUnitsVector(new ProcessUnit.Vector());
    }

    public ProcessUnit.Vector inputProcessUnitsVector(ProcessUnit.Vector vector) {
        int __offset = __offset(14);
        if (__offset != 0) {
            return vector.__assign(__vector(__offset), 4, this.bb);
        }
        return null;
    }

    public ProcessUnit outputProcessUnits(int i) {
        return outputProcessUnits(new ProcessUnit(), i);
    }

    public ProcessUnit outputProcessUnits(ProcessUnit processUnit, int i) {
        int __offset = __offset(16);
        if (__offset != 0) {
            return processUnit.__assign(__indirect(__vector(__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int outputProcessUnitsLength() {
        int __offset = __offset(16);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public ProcessUnit.Vector outputProcessUnitsVector() {
        return outputProcessUnitsVector(new ProcessUnit.Vector());
    }

    public ProcessUnit.Vector outputProcessUnitsVector(ProcessUnit.Vector vector) {
        int __offset = __offset(16);
        if (__offset != 0) {
            return vector.__assign(__vector(__offset), 4, this.bb);
        }
        return null;
    }

    public TensorGroup inputTensorGroups(int i) {
        return inputTensorGroups(new TensorGroup(), i);
    }

    public TensorGroup inputTensorGroups(TensorGroup tensorGroup, int i) {
        int __offset = __offset(18);
        if (__offset != 0) {
            return tensorGroup.__assign(__indirect(__vector(__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int inputTensorGroupsLength() {
        int __offset = __offset(18);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public TensorGroup.Vector inputTensorGroupsVector() {
        return inputTensorGroupsVector(new TensorGroup.Vector());
    }

    public TensorGroup.Vector inputTensorGroupsVector(TensorGroup.Vector vector) {
        int __offset = __offset(18);
        if (__offset != 0) {
            return vector.__assign(__vector(__offset), 4, this.bb);
        }
        return null;
    }

    public TensorGroup outputTensorGroups(int i) {
        return outputTensorGroups(new TensorGroup(), i);
    }

    public TensorGroup outputTensorGroups(TensorGroup tensorGroup, int i) {
        int __offset = __offset(20);
        if (__offset != 0) {
            return tensorGroup.__assign(__indirect(__vector(__offset) + (i * 4)), this.bb);
        }
        return null;
    }

    public int outputTensorGroupsLength() {
        int __offset = __offset(20);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public TensorGroup.Vector outputTensorGroupsVector() {
        return outputTensorGroupsVector(new TensorGroup.Vector());
    }

    public TensorGroup.Vector outputTensorGroupsVector(TensorGroup.Vector vector) {
        int __offset = __offset(20);
        if (__offset != 0) {
            return vector.__assign(__vector(__offset), 4, this.bb);
        }
        return null;
    }

    public static int createSubGraphMetadata(FlatBufferBuilder flatBufferBuilder, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        flatBufferBuilder.startTable(9);
        addOutputTensorGroups(flatBufferBuilder, i9);
        addInputTensorGroups(flatBufferBuilder, i8);
        addOutputProcessUnits(flatBufferBuilder, i7);
        addInputProcessUnits(flatBufferBuilder, i6);
        addAssociatedFiles(flatBufferBuilder, i5);
        addOutputTensorMetadata(flatBufferBuilder, i4);
        addInputTensorMetadata(flatBufferBuilder, i3);
        addDescription(flatBufferBuilder, i2);
        addName(flatBufferBuilder, i);
        return endSubGraphMetadata(flatBufferBuilder);
    }

    public static void startSubGraphMetadata(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(9);
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static void addDescription(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static void addInputTensorMetadata(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(2, i, 0);
    }

    public static int createInputTensorMetadataVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startInputTensorMetadataVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addOutputTensorMetadata(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(3, i, 0);
    }

    public static int createOutputTensorMetadataVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startOutputTensorMetadataVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addAssociatedFiles(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(4, i, 0);
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

    public static void addInputProcessUnits(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(5, i, 0);
    }

    public static int createInputProcessUnitsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startInputProcessUnitsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addOutputProcessUnits(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(6, i, 0);
    }

    public static int createOutputProcessUnitsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startOutputProcessUnitsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addInputTensorGroups(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(7, i, 0);
    }

    public static int createInputTensorGroupsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startInputTensorGroupsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addOutputTensorGroups(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(8, i, 0);
    }

    public static int createOutputTensorGroupsVector(FlatBufferBuilder flatBufferBuilder, int[] iArr) {
        flatBufferBuilder.startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addOffset(iArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startOutputTensorGroupsVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static int endSubGraphMetadata(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public SubGraphMetadata get(int i) {
            return get(new SubGraphMetadata(), i);
        }

        public SubGraphMetadata get(SubGraphMetadata subGraphMetadata, int i) {
            return subGraphMetadata.__assign(SubGraphMetadata.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public SubGraphMetadataT unpack() {
        SubGraphMetadataT subGraphMetadataT = new SubGraphMetadataT();
        unpackTo(subGraphMetadataT);
        return subGraphMetadataT;
    }

    public void unpackTo(SubGraphMetadataT subGraphMetadataT) {
        subGraphMetadataT.setName(name());
        subGraphMetadataT.setDescription(description());
        TensorMetadataT[] tensorMetadataTArr = new TensorMetadataT[inputTensorMetadataLength()];
        int i = 0;
        while (true) {
            TensorMetadataT tensorMetadataT = null;
            if (i >= inputTensorMetadataLength()) {
                break;
            }
            if (inputTensorMetadata(i) != null) {
                tensorMetadataT = inputTensorMetadata(i).unpack();
            }
            tensorMetadataTArr[i] = tensorMetadataT;
            i++;
        }
        subGraphMetadataT.setInputTensorMetadata(tensorMetadataTArr);
        TensorMetadataT[] tensorMetadataTArr2 = new TensorMetadataT[outputTensorMetadataLength()];
        for (int i2 = 0; i2 < outputTensorMetadataLength(); i2++) {
            tensorMetadataTArr2[i2] = outputTensorMetadata(i2) != null ? outputTensorMetadata(i2).unpack() : null;
        }
        subGraphMetadataT.setOutputTensorMetadata(tensorMetadataTArr2);
        AssociatedFileT[] associatedFileTArr = new AssociatedFileT[associatedFilesLength()];
        for (int i3 = 0; i3 < associatedFilesLength(); i3++) {
            associatedFileTArr[i3] = associatedFiles(i3) != null ? associatedFiles(i3).unpack() : null;
        }
        subGraphMetadataT.setAssociatedFiles(associatedFileTArr);
        ProcessUnitT[] processUnitTArr = new ProcessUnitT[inputProcessUnitsLength()];
        for (int i4 = 0; i4 < inputProcessUnitsLength(); i4++) {
            processUnitTArr[i4] = inputProcessUnits(i4) != null ? inputProcessUnits(i4).unpack() : null;
        }
        subGraphMetadataT.setInputProcessUnits(processUnitTArr);
        ProcessUnitT[] processUnitTArr2 = new ProcessUnitT[outputProcessUnitsLength()];
        for (int i5 = 0; i5 < outputProcessUnitsLength(); i5++) {
            processUnitTArr2[i5] = outputProcessUnits(i5) != null ? outputProcessUnits(i5).unpack() : null;
        }
        subGraphMetadataT.setOutputProcessUnits(processUnitTArr2);
        TensorGroupT[] tensorGroupTArr = new TensorGroupT[inputTensorGroupsLength()];
        for (int i6 = 0; i6 < inputTensorGroupsLength(); i6++) {
            tensorGroupTArr[i6] = inputTensorGroups(i6) != null ? inputTensorGroups(i6).unpack() : null;
        }
        subGraphMetadataT.setInputTensorGroups(tensorGroupTArr);
        TensorGroupT[] tensorGroupTArr2 = new TensorGroupT[outputTensorGroupsLength()];
        for (int i7 = 0; i7 < outputTensorGroupsLength(); i7++) {
            tensorGroupTArr2[i7] = outputTensorGroups(i7) != null ? outputTensorGroups(i7).unpack() : null;
        }
        subGraphMetadataT.setOutputTensorGroups(tensorGroupTArr2);
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, SubGraphMetadataT subGraphMetadataT) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        if (subGraphMetadataT == null) {
            return 0;
        }
        int createString = subGraphMetadataT.getName() == null ? 0 : flatBufferBuilder.createString(subGraphMetadataT.getName());
        int createString2 = subGraphMetadataT.getDescription() == null ? 0 : flatBufferBuilder.createString(subGraphMetadataT.getDescription());
        if (subGraphMetadataT.getInputTensorMetadata() != null) {
            int[] iArr = new int[subGraphMetadataT.getInputTensorMetadata().length];
            int i8 = 0;
            for (TensorMetadataT tensorMetadataT : subGraphMetadataT.getInputTensorMetadata()) {
                iArr[i8] = TensorMetadata.pack(flatBufferBuilder, tensorMetadataT);
                i8++;
            }
            i = createInputTensorMetadataVector(flatBufferBuilder, iArr);
        } else {
            i = 0;
        }
        if (subGraphMetadataT.getOutputTensorMetadata() != null) {
            int[] iArr2 = new int[subGraphMetadataT.getOutputTensorMetadata().length];
            int i9 = 0;
            for (TensorMetadataT tensorMetadataT2 : subGraphMetadataT.getOutputTensorMetadata()) {
                iArr2[i9] = TensorMetadata.pack(flatBufferBuilder, tensorMetadataT2);
                i9++;
            }
            i2 = createOutputTensorMetadataVector(flatBufferBuilder, iArr2);
        } else {
            i2 = 0;
        }
        if (subGraphMetadataT.getAssociatedFiles() != null) {
            int[] iArr3 = new int[subGraphMetadataT.getAssociatedFiles().length];
            int i10 = 0;
            for (AssociatedFileT associatedFileT : subGraphMetadataT.getAssociatedFiles()) {
                iArr3[i10] = AssociatedFile.pack(flatBufferBuilder, associatedFileT);
                i10++;
            }
            i3 = createAssociatedFilesVector(flatBufferBuilder, iArr3);
        } else {
            i3 = 0;
        }
        if (subGraphMetadataT.getInputProcessUnits() != null) {
            int[] iArr4 = new int[subGraphMetadataT.getInputProcessUnits().length];
            int i11 = 0;
            for (ProcessUnitT processUnitT : subGraphMetadataT.getInputProcessUnits()) {
                iArr4[i11] = ProcessUnit.pack(flatBufferBuilder, processUnitT);
                i11++;
            }
            i4 = createInputProcessUnitsVector(flatBufferBuilder, iArr4);
        } else {
            i4 = 0;
        }
        if (subGraphMetadataT.getOutputProcessUnits() != null) {
            int[] iArr5 = new int[subGraphMetadataT.getOutputProcessUnits().length];
            int i12 = 0;
            for (ProcessUnitT processUnitT2 : subGraphMetadataT.getOutputProcessUnits()) {
                iArr5[i12] = ProcessUnit.pack(flatBufferBuilder, processUnitT2);
                i12++;
            }
            i5 = createOutputProcessUnitsVector(flatBufferBuilder, iArr5);
        } else {
            i5 = 0;
        }
        if (subGraphMetadataT.getInputTensorGroups() != null) {
            int[] iArr6 = new int[subGraphMetadataT.getInputTensorGroups().length];
            int i13 = 0;
            for (TensorGroupT tensorGroupT : subGraphMetadataT.getInputTensorGroups()) {
                iArr6[i13] = TensorGroup.pack(flatBufferBuilder, tensorGroupT);
                i13++;
            }
            i6 = createInputTensorGroupsVector(flatBufferBuilder, iArr6);
        } else {
            i6 = 0;
        }
        if (subGraphMetadataT.getOutputTensorGroups() != null) {
            int[] iArr7 = new int[subGraphMetadataT.getOutputTensorGroups().length];
            TensorGroupT[] outputTensorGroups = subGraphMetadataT.getOutputTensorGroups();
            int length = outputTensorGroups.length;
            int i14 = 0;
            while (i7 < length) {
                iArr7[i14] = TensorGroup.pack(flatBufferBuilder, outputTensorGroups[i7]);
                i14++;
                i7++;
            }
            i7 = createOutputTensorGroupsVector(flatBufferBuilder, iArr7);
        }
        return createSubGraphMetadata(flatBufferBuilder, createString, createString2, i, i2, i3, i4, i5, i6, i7);
    }
}
