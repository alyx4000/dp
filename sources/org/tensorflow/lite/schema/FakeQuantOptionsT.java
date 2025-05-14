package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class FakeQuantOptionsT {
    private float min = 0.0f;
    private float max = 0.0f;
    private int numBits = 0;
    private boolean narrowRange = false;

    public float getMin() {
        return this.min;
    }

    public void setMin(float f) {
        this.min = f;
    }

    public float getMax() {
        return this.max;
    }

    public void setMax(float f) {
        this.max = f;
    }

    public int getNumBits() {
        return this.numBits;
    }

    public void setNumBits(int i) {
        this.numBits = i;
    }

    public boolean getNarrowRange() {
        return this.narrowRange;
    }

    public void setNarrowRange(boolean z) {
        this.narrowRange = z;
    }
}
