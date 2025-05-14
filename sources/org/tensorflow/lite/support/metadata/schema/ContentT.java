package org.tensorflow.lite.support.metadata.schema;

/* loaded from: classes6.dex */
public class ContentT {
    private ContentPropertiesUnion contentProperties = null;
    private ValueRangeT range = null;

    public ContentPropertiesUnion getContentProperties() {
        return this.contentProperties;
    }

    public void setContentProperties(ContentPropertiesUnion contentPropertiesUnion) {
        this.contentProperties = contentPropertiesUnion;
    }

    public ValueRangeT getRange() {
        return this.range;
    }

    public void setRange(ValueRangeT valueRangeT) {
        this.range = valueRangeT;
    }
}
