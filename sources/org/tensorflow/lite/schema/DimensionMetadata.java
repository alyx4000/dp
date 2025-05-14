package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class DimensionMetadata extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static DimensionMetadata getRootAsDimensionMetadata(ByteBuffer byteBuffer) {
        return getRootAsDimensionMetadata(byteBuffer, new DimensionMetadata());
    }

    public static DimensionMetadata getRootAsDimensionMetadata(ByteBuffer byteBuffer, DimensionMetadata dimensionMetadata) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return dimensionMetadata.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public DimensionMetadata __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public byte format() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return this.bb.get(__offset + this.bb_pos);
        }
        return (byte) 0;
    }

    public int denseSize() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return this.bb.getInt(__offset + this.bb_pos);
        }
        return 0;
    }

    public byte arraySegmentsType() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return this.bb.get(__offset + this.bb_pos);
        }
        return (byte) 0;
    }

    public Table arraySegments(Table table) {
        int __offset = __offset(10);
        if (__offset != 0) {
            return __union(table, __offset + this.bb_pos);
        }
        return null;
    }

    public byte arrayIndicesType() {
        int __offset = __offset(12);
        if (__offset != 0) {
            return this.bb.get(__offset + this.bb_pos);
        }
        return (byte) 0;
    }

    public Table arrayIndices(Table table) {
        int __offset = __offset(14);
        if (__offset != 0) {
            return __union(table, __offset + this.bb_pos);
        }
        return null;
    }

    public static int createDimensionMetadata(FlatBufferBuilder flatBufferBuilder, byte b, int i, byte b2, int i2, byte b3, int i3) {
        flatBufferBuilder.startTable(6);
        addArrayIndices(flatBufferBuilder, i3);
        addArraySegments(flatBufferBuilder, i2);
        addDenseSize(flatBufferBuilder, i);
        addArrayIndicesType(flatBufferBuilder, b3);
        addArraySegmentsType(flatBufferBuilder, b2);
        addFormat(flatBufferBuilder, b);
        return endDimensionMetadata(flatBufferBuilder);
    }

    public static void startDimensionMetadata(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(6);
    }

    public static void addFormat(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.addByte(0, b, 0);
    }

    public static void addDenseSize(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addInt(1, i, 0);
    }

    public static void addArraySegmentsType(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.addByte(2, b, 0);
    }

    public static void addArraySegments(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(3, i, 0);
    }

    public static void addArrayIndicesType(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.addByte(4, b, 0);
    }

    public static void addArrayIndices(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(5, i, 0);
    }

    public static int endDimensionMetadata(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public DimensionMetadata get(int i) {
            return get(new DimensionMetadata(), i);
        }

        public DimensionMetadata get(DimensionMetadata dimensionMetadata, int i) {
            return dimensionMetadata.__assign(DimensionMetadata.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public DimensionMetadataT unpack() {
        DimensionMetadataT dimensionMetadataT = new DimensionMetadataT();
        unpackTo(dimensionMetadataT);
        return dimensionMetadataT;
    }

    public void unpackTo(DimensionMetadataT dimensionMetadataT) {
        dimensionMetadataT.setFormat(format());
        dimensionMetadataT.setDenseSize(denseSize());
        SparseIndexVectorUnion sparseIndexVectorUnion = new SparseIndexVectorUnion();
        byte arraySegmentsType = arraySegmentsType();
        sparseIndexVectorUnion.setType(arraySegmentsType);
        if (arraySegmentsType == 1) {
            Table arraySegments = arraySegments(new Int32Vector());
            sparseIndexVectorUnion.setValue(arraySegments != null ? ((Int32Vector) arraySegments).unpack() : null);
        } else if (arraySegmentsType == 2) {
            Table arraySegments2 = arraySegments(new Uint16Vector());
            sparseIndexVectorUnion.setValue(arraySegments2 != null ? ((Uint16Vector) arraySegments2).unpack() : null);
        } else if (arraySegmentsType == 3) {
            Table arraySegments3 = arraySegments(new Uint8Vector());
            sparseIndexVectorUnion.setValue(arraySegments3 != null ? ((Uint8Vector) arraySegments3).unpack() : null);
        }
        dimensionMetadataT.setArraySegments(sparseIndexVectorUnion);
        SparseIndexVectorUnion sparseIndexVectorUnion2 = new SparseIndexVectorUnion();
        byte arrayIndicesType = arrayIndicesType();
        sparseIndexVectorUnion2.setType(arrayIndicesType);
        if (arrayIndicesType == 1) {
            Table arrayIndices = arrayIndices(new Int32Vector());
            sparseIndexVectorUnion2.setValue(arrayIndices != null ? ((Int32Vector) arrayIndices).unpack() : null);
        } else if (arrayIndicesType == 2) {
            Table arrayIndices2 = arrayIndices(new Uint16Vector());
            sparseIndexVectorUnion2.setValue(arrayIndices2 != null ? ((Uint16Vector) arrayIndices2).unpack() : null);
        } else if (arrayIndicesType == 3) {
            Table arrayIndices3 = arrayIndices(new Uint8Vector());
            sparseIndexVectorUnion2.setValue(arrayIndices3 != null ? ((Uint8Vector) arrayIndices3).unpack() : null);
        }
        dimensionMetadataT.setArrayIndices(sparseIndexVectorUnion2);
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, DimensionMetadataT dimensionMetadataT) {
        if (dimensionMetadataT == null) {
            return 0;
        }
        return createDimensionMetadata(flatBufferBuilder, dimensionMetadataT.getFormat(), dimensionMetadataT.getDenseSize(), dimensionMetadataT.getArraySegments() == null ? (byte) 0 : dimensionMetadataT.getArraySegments().getType(), dimensionMetadataT.getArraySegments() == null ? 0 : SparseIndexVectorUnion.pack(flatBufferBuilder, dimensionMetadataT.getArraySegments()), dimensionMetadataT.getArrayIndices() == null ? (byte) 0 : dimensionMetadataT.getArrayIndices().getType(), dimensionMetadataT.getArrayIndices() != null ? SparseIndexVectorUnion.pack(flatBufferBuilder, dimensionMetadataT.getArrayIndices()) : 0);
    }
}
