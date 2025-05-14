package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class ConcatEmbeddingsOptionsT {
    private int numChannels = 0;
    private int[] numColumnsPerChannel = null;
    private int[] embeddingDimPerChannel = null;

    public int getNumChannels() {
        return this.numChannels;
    }

    public void setNumChannels(int i) {
        this.numChannels = i;
    }

    public int[] getNumColumnsPerChannel() {
        return this.numColumnsPerChannel;
    }

    public void setNumColumnsPerChannel(int[] iArr) {
        this.numColumnsPerChannel = iArr;
    }

    public int[] getEmbeddingDimPerChannel() {
        return this.embeddingDimPerChannel;
    }

    public void setEmbeddingDimPerChannel(int[] iArr) {
        this.embeddingDimPerChannel = iArr;
    }
}
