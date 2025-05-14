package org.tensorflow.lite.support.metadata.schema;

/* loaded from: classes6.dex */
public class NormalizationOptionsT {
    private float[] mean = null;
    private float[] std = null;

    public float[] getMean() {
        return this.mean;
    }

    public void setMean(float[] fArr) {
        this.mean = fArr;
    }

    public float[] getStd() {
        return this.std;
    }

    public void setStd(float[] fArr) {
        this.std = fArr;
    }
}
