package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class QuantizationParametersT {
    private float[] min = null;
    private float[] max = null;
    private float[] scale = null;
    private long[] zeroPoint = null;
    private QuantizationDetailsUnion details = null;
    private int quantizedDimension = 0;

    public float[] getMin() {
        return this.min;
    }

    public void setMin(float[] fArr) {
        this.min = fArr;
    }

    public float[] getMax() {
        return this.max;
    }

    public void setMax(float[] fArr) {
        this.max = fArr;
    }

    public float[] getScale() {
        return this.scale;
    }

    public void setScale(float[] fArr) {
        this.scale = fArr;
    }

    public long[] getZeroPoint() {
        return this.zeroPoint;
    }

    public void setZeroPoint(long[] jArr) {
        this.zeroPoint = jArr;
    }

    public QuantizationDetailsUnion getDetails() {
        return this.details;
    }

    public void setDetails(QuantizationDetailsUnion quantizationDetailsUnion) {
        this.details = quantizationDetailsUnion;
    }

    public int getQuantizedDimension() {
        return this.quantizedDimension;
    }

    public void setQuantizedDimension(int i) {
        this.quantizedDimension = i;
    }
}
