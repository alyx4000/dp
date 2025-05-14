package org.tensorflow.lite.support.metadata.schema;

import com.google.flatbuffers.FlatBufferBuilder;

/* loaded from: classes6.dex */
public class ContentPropertiesUnion {
    private byte type = 0;
    private Object value = null;

    public byte getType() {
        return this.type;
    }

    public void setType(byte b) {
        this.type = b;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }

    public FeaturePropertiesT asFeatureProperties() {
        return (FeaturePropertiesT) this.value;
    }

    public ImagePropertiesT asImageProperties() {
        return (ImagePropertiesT) this.value;
    }

    public BoundingBoxPropertiesT asBoundingBoxProperties() {
        return (BoundingBoxPropertiesT) this.value;
    }

    public AudioPropertiesT asAudioProperties() {
        return (AudioPropertiesT) this.value;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, ContentPropertiesUnion contentPropertiesUnion) {
        byte b = contentPropertiesUnion.type;
        if (b == 1) {
            return FeatureProperties.pack(flatBufferBuilder, contentPropertiesUnion.asFeatureProperties());
        }
        if (b == 2) {
            return ImageProperties.pack(flatBufferBuilder, contentPropertiesUnion.asImageProperties());
        }
        if (b == 3) {
            return BoundingBoxProperties.pack(flatBufferBuilder, contentPropertiesUnion.asBoundingBoxProperties());
        }
        if (b != 4) {
            return 0;
        }
        return AudioProperties.pack(flatBufferBuilder, contentPropertiesUnion.asAudioProperties());
    }
}
