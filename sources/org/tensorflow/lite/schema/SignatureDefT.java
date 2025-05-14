package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class SignatureDefT {
    private TensorMapT[] inputs = null;
    private TensorMapT[] outputs = null;
    private String signatureKey = null;
    private long subgraphIndex = 0;

    public TensorMapT[] getInputs() {
        return this.inputs;
    }

    public void setInputs(TensorMapT[] tensorMapTArr) {
        this.inputs = tensorMapTArr;
    }

    public TensorMapT[] getOutputs() {
        return this.outputs;
    }

    public void setOutputs(TensorMapT[] tensorMapTArr) {
        this.outputs = tensorMapTArr;
    }

    public String getSignatureKey() {
        return this.signatureKey;
    }

    public void setSignatureKey(String str) {
        this.signatureKey = str;
    }

    public long getSubgraphIndex() {
        return this.subgraphIndex;
    }

    public void setSubgraphIndex(long j) {
        this.subgraphIndex = j;
    }
}
