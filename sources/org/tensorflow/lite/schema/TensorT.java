package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class TensorT {
    private int[] shape = null;
    private byte type = 0;
    private long buffer = 0;
    private String name = null;
    private QuantizationParametersT quantization = null;
    private boolean isVariable = false;
    private SparsityParametersT sparsity = null;
    private int[] shapeSignature = null;
    private boolean hasRank = false;
    private VariantSubTypeT[] variantTensors = null;

    public int[] getShape() {
        return this.shape;
    }

    public void setShape(int[] iArr) {
        this.shape = iArr;
    }

    public byte getType() {
        return this.type;
    }

    public void setType(byte b) {
        this.type = b;
    }

    public long getBuffer() {
        return this.buffer;
    }

    public void setBuffer(long j) {
        this.buffer = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public QuantizationParametersT getQuantization() {
        return this.quantization;
    }

    public void setQuantization(QuantizationParametersT quantizationParametersT) {
        this.quantization = quantizationParametersT;
    }

    public boolean getIsVariable() {
        return this.isVariable;
    }

    public void setIsVariable(boolean z) {
        this.isVariable = z;
    }

    public SparsityParametersT getSparsity() {
        return this.sparsity;
    }

    public void setSparsity(SparsityParametersT sparsityParametersT) {
        this.sparsity = sparsityParametersT;
    }

    public int[] getShapeSignature() {
        return this.shapeSignature;
    }

    public void setShapeSignature(int[] iArr) {
        this.shapeSignature = iArr;
    }

    public boolean getHasRank() {
        return this.hasRank;
    }

    public void setHasRank(boolean z) {
        this.hasRank = z;
    }

    public VariantSubTypeT[] getVariantTensors() {
        return this.variantTensors;
    }

    public void setVariantTensors(VariantSubTypeT[] variantSubTypeTArr) {
        this.variantTensors = variantSubTypeTArr;
    }
}
