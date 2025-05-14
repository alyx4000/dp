package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class BatchMatMulOptionsT {
    private boolean adjX = false;
    private boolean adjY = false;
    private boolean asymmetricQuantizeInputs = false;

    public boolean getAdjX() {
        return this.adjX;
    }

    public void setAdjX(boolean z) {
        this.adjX = z;
    }

    public boolean getAdjY() {
        return this.adjY;
    }

    public void setAdjY(boolean z) {
        this.adjY = z;
    }

    public boolean getAsymmetricQuantizeInputs() {
        return this.asymmetricQuantizeInputs;
    }

    public void setAsymmetricQuantizeInputs(boolean z) {
        this.asymmetricQuantizeInputs = z;
    }
}
