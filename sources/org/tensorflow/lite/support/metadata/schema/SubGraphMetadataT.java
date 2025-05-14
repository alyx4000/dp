package org.tensorflow.lite.support.metadata.schema;

/* loaded from: classes6.dex */
public class SubGraphMetadataT {
    private String name = null;
    private String description = null;
    private TensorMetadataT[] inputTensorMetadata = null;
    private TensorMetadataT[] outputTensorMetadata = null;
    private AssociatedFileT[] associatedFiles = null;
    private ProcessUnitT[] inputProcessUnits = null;
    private ProcessUnitT[] outputProcessUnits = null;
    private TensorGroupT[] inputTensorGroups = null;
    private TensorGroupT[] outputTensorGroups = null;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public TensorMetadataT[] getInputTensorMetadata() {
        return this.inputTensorMetadata;
    }

    public void setInputTensorMetadata(TensorMetadataT[] tensorMetadataTArr) {
        this.inputTensorMetadata = tensorMetadataTArr;
    }

    public TensorMetadataT[] getOutputTensorMetadata() {
        return this.outputTensorMetadata;
    }

    public void setOutputTensorMetadata(TensorMetadataT[] tensorMetadataTArr) {
        this.outputTensorMetadata = tensorMetadataTArr;
    }

    public AssociatedFileT[] getAssociatedFiles() {
        return this.associatedFiles;
    }

    public void setAssociatedFiles(AssociatedFileT[] associatedFileTArr) {
        this.associatedFiles = associatedFileTArr;
    }

    public ProcessUnitT[] getInputProcessUnits() {
        return this.inputProcessUnits;
    }

    public void setInputProcessUnits(ProcessUnitT[] processUnitTArr) {
        this.inputProcessUnits = processUnitTArr;
    }

    public ProcessUnitT[] getOutputProcessUnits() {
        return this.outputProcessUnits;
    }

    public void setOutputProcessUnits(ProcessUnitT[] processUnitTArr) {
        this.outputProcessUnits = processUnitTArr;
    }

    public TensorGroupT[] getInputTensorGroups() {
        return this.inputTensorGroups;
    }

    public void setInputTensorGroups(TensorGroupT[] tensorGroupTArr) {
        this.inputTensorGroups = tensorGroupTArr;
    }

    public TensorGroupT[] getOutputTensorGroups() {
        return this.outputTensorGroups;
    }

    public void setOutputTensorGroups(TensorGroupT[] tensorGroupTArr) {
        this.outputTensorGroups = tensorGroupTArr;
    }
}
