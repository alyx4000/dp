package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class SoftmaxOptions extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static SoftmaxOptions getRootAsSoftmaxOptions(ByteBuffer byteBuffer) {
        return getRootAsSoftmaxOptions(byteBuffer, new SoftmaxOptions());
    }

    public static SoftmaxOptions getRootAsSoftmaxOptions(ByteBuffer byteBuffer, SoftmaxOptions softmaxOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return softmaxOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public SoftmaxOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public float beta() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return this.bb.getFloat(__offset + this.bb_pos);
        }
        return 0.0f;
    }

    public static int createSoftmaxOptions(FlatBufferBuilder flatBufferBuilder, float f) {
        flatBufferBuilder.startTable(1);
        addBeta(flatBufferBuilder, f);
        return endSoftmaxOptions(flatBufferBuilder);
    }

    public static void startSoftmaxOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(1);
    }

    public static void addBeta(FlatBufferBuilder flatBufferBuilder, float f) {
        flatBufferBuilder.addFloat(0, f, 0.0d);
    }

    public static int endSoftmaxOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public SoftmaxOptions get(int i) {
            return get(new SoftmaxOptions(), i);
        }

        public SoftmaxOptions get(SoftmaxOptions softmaxOptions, int i) {
            return softmaxOptions.__assign(SoftmaxOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public SoftmaxOptionsT unpack() {
        SoftmaxOptionsT softmaxOptionsT = new SoftmaxOptionsT();
        unpackTo(softmaxOptionsT);
        return softmaxOptionsT;
    }

    public void unpackTo(SoftmaxOptionsT softmaxOptionsT) {
        softmaxOptionsT.setBeta(beta());
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, SoftmaxOptionsT softmaxOptionsT) {
        if (softmaxOptionsT == null) {
            return 0;
        }
        return createSoftmaxOptions(flatBufferBuilder, softmaxOptionsT.getBeta());
    }
}
