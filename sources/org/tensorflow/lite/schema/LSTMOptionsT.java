package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class LSTMOptionsT {
    private byte fusedActivationFunction = 0;
    private float cellClip = 0.0f;
    private float projClip = 0.0f;
    private byte kernelType = 0;
    private boolean asymmetricQuantizeInputs = false;

    public byte getFusedActivationFunction() {
        return this.fusedActivationFunction;
    }

    public void setFusedActivationFunction(byte b) {
        this.fusedActivationFunction = b;
    }

    public float getCellClip() {
        return this.cellClip;
    }

    public void setCellClip(float f) {
        this.cellClip = f;
    }

    public float getProjClip() {
        return this.projClip;
    }

    public void setProjClip(float f) {
        this.projClip = f;
    }

    public byte getKernelType() {
        return this.kernelType;
    }

    public void setKernelType(byte b) {
        this.kernelType = b;
    }

    public boolean getAsymmetricQuantizeInputs() {
        return this.asymmetricQuantizeInputs;
    }

    public void setAsymmetricQuantizeInputs(boolean z) {
        this.asymmetricQuantizeInputs = z;
    }
}
