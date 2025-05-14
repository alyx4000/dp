package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class DepthwiseConv2DOptionsT {
    private byte padding = 0;
    private int strideW = 0;
    private int strideH = 0;
    private int depthMultiplier = 0;
    private byte fusedActivationFunction = 0;
    private int dilationWFactor = 1;
    private int dilationHFactor = 1;

    public byte getPadding() {
        return this.padding;
    }

    public void setPadding(byte b) {
        this.padding = b;
    }

    public int getStrideW() {
        return this.strideW;
    }

    public void setStrideW(int i) {
        this.strideW = i;
    }

    public int getStrideH() {
        return this.strideH;
    }

    public void setStrideH(int i) {
        this.strideH = i;
    }

    public int getDepthMultiplier() {
        return this.depthMultiplier;
    }

    public void setDepthMultiplier(int i) {
        this.depthMultiplier = i;
    }

    public byte getFusedActivationFunction() {
        return this.fusedActivationFunction;
    }

    public void setFusedActivationFunction(byte b) {
        this.fusedActivationFunction = b;
    }

    public int getDilationWFactor() {
        return this.dilationWFactor;
    }

    public void setDilationWFactor(int i) {
        this.dilationWFactor = i;
    }

    public int getDilationHFactor() {
        return this.dilationHFactor;
    }

    public void setDilationHFactor(int i) {
        this.dilationHFactor = i;
    }
}
