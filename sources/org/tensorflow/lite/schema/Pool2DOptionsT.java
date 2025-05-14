package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class Pool2DOptionsT {
    private byte padding = 0;
    private int strideW = 0;
    private int strideH = 0;
    private int filterWidth = 0;
    private int filterHeight = 0;
    private byte fusedActivationFunction = 0;

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

    public int getFilterWidth() {
        return this.filterWidth;
    }

    public void setFilterWidth(int i) {
        this.filterWidth = i;
    }

    public int getFilterHeight() {
        return this.filterHeight;
    }

    public void setFilterHeight(int i) {
        this.filterHeight = i;
    }

    public byte getFusedActivationFunction() {
        return this.fusedActivationFunction;
    }

    public void setFusedActivationFunction(byte b) {
        this.fusedActivationFunction = b;
    }
}
