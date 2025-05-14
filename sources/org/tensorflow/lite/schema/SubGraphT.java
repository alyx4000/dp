package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class SubGraphT {
    private TensorT[] tensors = null;
    private int[] inputs = null;
    private int[] outputs = null;
    private OperatorT[] operators = null;
    private String name = null;

    public TensorT[] getTensors() {
        return this.tensors;
    }

    public void setTensors(TensorT[] tensorTArr) {
        this.tensors = tensorTArr;
    }

    public int[] getInputs() {
        return this.inputs;
    }

    public void setInputs(int[] iArr) {
        this.inputs = iArr;
    }

    public int[] getOutputs() {
        return this.outputs;
    }

    public void setOutputs(int[] iArr) {
        this.outputs = iArr;
    }

    public OperatorT[] getOperators() {
        return this.operators;
    }

    public void setOperators(OperatorT[] operatorTArr) {
        this.operators = operatorTArr;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
