package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class PadOptions extends Table {
    public void unpackTo(PadOptionsT padOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static PadOptions getRootAsPadOptions(ByteBuffer byteBuffer) {
        return getRootAsPadOptions(byteBuffer, new PadOptions());
    }

    public static PadOptions getRootAsPadOptions(ByteBuffer byteBuffer, PadOptions padOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return padOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public PadOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startPadOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endPadOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public PadOptions get(int i) {
            return get(new PadOptions(), i);
        }

        public PadOptions get(PadOptions padOptions, int i) {
            return padOptions.__assign(PadOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public PadOptionsT unpack() {
        PadOptionsT padOptionsT = new PadOptionsT();
        unpackTo(padOptionsT);
        return padOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, PadOptionsT padOptionsT) {
        if (padOptionsT == null) {
            return 0;
        }
        startPadOptions(flatBufferBuilder);
        return endPadOptions(flatBufferBuilder);
    }
}
