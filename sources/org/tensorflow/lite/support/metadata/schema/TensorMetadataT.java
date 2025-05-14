package org.tensorflow.lite.support.metadata.schema;

/* loaded from: classes6.dex */
public class TensorMetadataT {
    private String name = null;
    private String description = null;
    private String[] dimensionNames = null;
    private ContentT content = null;
    private ProcessUnitT[] processUnits = null;
    private StatsT stats = null;
    private AssociatedFileT[] associatedFiles = null;

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

    public String[] getDimensionNames() {
        return this.dimensionNames;
    }

    public void setDimensionNames(String[] strArr) {
        this.dimensionNames = strArr;
    }

    public ContentT getContent() {
        return this.content;
    }

    public void setContent(ContentT contentT) {
        this.content = contentT;
    }

    public ProcessUnitT[] getProcessUnits() {
        return this.processUnits;
    }

    public void setProcessUnits(ProcessUnitT[] processUnitTArr) {
        this.processUnits = processUnitTArr;
    }

    public StatsT getStats() {
        return this.stats;
    }

    public void setStats(StatsT statsT) {
        this.stats = statsT;
    }

    public AssociatedFileT[] getAssociatedFiles() {
        return this.associatedFiles;
    }

    public void setAssociatedFiles(AssociatedFileT[] associatedFileTArr) {
        this.associatedFiles = associatedFileTArr;
    }
}
