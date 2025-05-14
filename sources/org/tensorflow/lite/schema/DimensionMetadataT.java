package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class DimensionMetadataT {
    private byte format = 0;
    private int denseSize = 0;
    private SparseIndexVectorUnion arraySegments = null;
    private SparseIndexVectorUnion arrayIndices = null;

    public byte getFormat() {
        return this.format;
    }

    public void setFormat(byte b) {
        this.format = b;
    }

    public int getDenseSize() {
        return this.denseSize;
    }

    public void setDenseSize(int i) {
        this.denseSize = i;
    }

    public SparseIndexVectorUnion getArraySegments() {
        return this.arraySegments;
    }

    public void setArraySegments(SparseIndexVectorUnion sparseIndexVectorUnion) {
        this.arraySegments = sparseIndexVectorUnion;
    }

    public SparseIndexVectorUnion getArrayIndices() {
        return this.arrayIndices;
    }

    public void setArrayIndices(SparseIndexVectorUnion sparseIndexVectorUnion) {
        this.arrayIndices = sparseIndexVectorUnion;
    }
}
