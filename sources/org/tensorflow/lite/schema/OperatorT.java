package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class OperatorT {
    private long opcodeIndex = 0;
    private int[] inputs = null;
    private int[] outputs = null;
    private BuiltinOptionsUnion builtinOptions = null;
    private int[] customOptions = null;
    private byte customOptionsFormat = 0;
    private boolean[] mutatingVariableInputs = null;
    private int[] intermediates = null;

    public long getOpcodeIndex() {
        return this.opcodeIndex;
    }

    public void setOpcodeIndex(long j) {
        this.opcodeIndex = j;
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

    public BuiltinOptionsUnion getBuiltinOptions() {
        return this.builtinOptions;
    }

    public void setBuiltinOptions(BuiltinOptionsUnion builtinOptionsUnion) {
        this.builtinOptions = builtinOptionsUnion;
    }

    public int[] getCustomOptions() {
        return this.customOptions;
    }

    public void setCustomOptions(int[] iArr) {
        this.customOptions = iArr;
    }

    public byte getCustomOptionsFormat() {
        return this.customOptionsFormat;
    }

    public void setCustomOptionsFormat(byte b) {
        this.customOptionsFormat = b;
    }

    public boolean[] getMutatingVariableInputs() {
        return this.mutatingVariableInputs;
    }

    public void setMutatingVariableInputs(boolean[] zArr) {
        this.mutatingVariableInputs = zArr;
    }

    public int[] getIntermediates() {
        return this.intermediates;
    }

    public void setIntermediates(int[] iArr) {
        this.intermediates = iArr;
    }
}
