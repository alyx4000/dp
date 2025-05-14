package org.tensorflow.lite.schema;

import com.google.flatbuffers.FlatBufferBuilder;

/* loaded from: classes6.dex */
public class SparseIndexVectorUnion {
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

    public Int32VectorT asInt32Vector() {
        return (Int32VectorT) this.value;
    }

    public Uint16VectorT asUint16Vector() {
        return (Uint16VectorT) this.value;
    }

    public Uint8VectorT asUint8Vector() {
        return (Uint8VectorT) this.value;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, SparseIndexVectorUnion sparseIndexVectorUnion) {
        byte b = sparseIndexVectorUnion.type;
        if (b == 1) {
            return Int32Vector.pack(flatBufferBuilder, sparseIndexVectorUnion.asInt32Vector());
        }
        if (b == 2) {
            return Uint16Vector.pack(flatBufferBuilder, sparseIndexVectorUnion.asUint16Vector());
        }
        if (b != 3) {
            return 0;
        }
        return Uint8Vector.pack(flatBufferBuilder, sparseIndexVectorUnion.asUint8Vector());
    }
}
