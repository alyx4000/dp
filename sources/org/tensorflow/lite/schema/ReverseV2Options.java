package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class ReverseV2Options extends Table {
    public void unpackTo(ReverseV2OptionsT reverseV2OptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static ReverseV2Options getRootAsReverseV2Options(ByteBuffer byteBuffer) {
        return getRootAsReverseV2Options(byteBuffer, new ReverseV2Options());
    }

    public static ReverseV2Options getRootAsReverseV2Options(ByteBuffer byteBuffer, ReverseV2Options reverseV2Options) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return reverseV2Options.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public ReverseV2Options __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startReverseV2Options(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endReverseV2Options(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public ReverseV2Options get(int i) {
            return get(new ReverseV2Options(), i);
        }

        public ReverseV2Options get(ReverseV2Options reverseV2Options, int i) {
            return reverseV2Options.__assign(ReverseV2Options.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public ReverseV2OptionsT unpack() {
        ReverseV2OptionsT reverseV2OptionsT = new ReverseV2OptionsT();
        unpackTo(reverseV2OptionsT);
        return reverseV2OptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, ReverseV2OptionsT reverseV2OptionsT) {
        if (reverseV2OptionsT == null) {
            return 0;
        }
        startReverseV2Options(flatBufferBuilder);
        return endReverseV2Options(flatBufferBuilder);
    }
}
