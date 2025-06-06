package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class DensifyOptions extends Table {
    public void unpackTo(DensifyOptionsT densifyOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static DensifyOptions getRootAsDensifyOptions(ByteBuffer byteBuffer) {
        return getRootAsDensifyOptions(byteBuffer, new DensifyOptions());
    }

    public static DensifyOptions getRootAsDensifyOptions(ByteBuffer byteBuffer, DensifyOptions densifyOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return densifyOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public DensifyOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startDensifyOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endDensifyOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public DensifyOptions get(int i) {
            return get(new DensifyOptions(), i);
        }

        public DensifyOptions get(DensifyOptions densifyOptions, int i) {
            return densifyOptions.__assign(DensifyOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public DensifyOptionsT unpack() {
        DensifyOptionsT densifyOptionsT = new DensifyOptionsT();
        unpackTo(densifyOptionsT);
        return densifyOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, DensifyOptionsT densifyOptionsT) {
        if (densifyOptionsT == null) {
            return 0;
        }
        startDensifyOptions(flatBufferBuilder);
        return endDensifyOptions(flatBufferBuilder);
    }
}
