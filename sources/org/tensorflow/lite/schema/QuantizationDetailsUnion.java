package org.tensorflow.lite.schema;

import com.google.flatbuffers.FlatBufferBuilder;

/* loaded from: classes6.dex */
public class QuantizationDetailsUnion {
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

    public CustomQuantizationT asCustomQuantization() {
        return (CustomQuantizationT) this.value;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, QuantizationDetailsUnion quantizationDetailsUnion) {
        if (quantizationDetailsUnion.type != 1) {
            return 0;
        }
        return CustomQuantization.pack(flatBufferBuilder, quantizationDetailsUnion.asCustomQuantization());
    }
}
