package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class SparsityParametersT {
    private int[] traversalOrder = null;
    private int[] blockMap = null;
    private DimensionMetadataT[] dimMetadata = null;

    public int[] getTraversalOrder() {
        return this.traversalOrder;
    }

    public void setTraversalOrder(int[] iArr) {
        this.traversalOrder = iArr;
    }

    public int[] getBlockMap() {
        return this.blockMap;
    }

    public void setBlockMap(int[] iArr) {
        this.blockMap = iArr;
    }

    public DimensionMetadataT[] getDimMetadata() {
        return this.dimMetadata;
    }

    public void setDimMetadata(DimensionMetadataT[] dimensionMetadataTArr) {
        this.dimMetadata = dimensionMetadataTArr;
    }
}
