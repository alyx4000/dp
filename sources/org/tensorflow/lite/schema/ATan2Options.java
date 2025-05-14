package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class ATan2Options extends Table {
    public void unpackTo(ATan2OptionsT aTan2OptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static ATan2Options getRootAsATan2Options(ByteBuffer byteBuffer) {
        return getRootAsATan2Options(byteBuffer, new ATan2Options());
    }

    public static ATan2Options getRootAsATan2Options(ByteBuffer byteBuffer, ATan2Options aTan2Options) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return aTan2Options.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public ATan2Options __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startATan2Options(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endATan2Options(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public ATan2Options get(int i) {
            return get(new ATan2Options(), i);
        }

        public ATan2Options get(ATan2Options aTan2Options, int i) {
            return aTan2Options.__assign(ATan2Options.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public ATan2OptionsT unpack() {
        ATan2OptionsT aTan2OptionsT = new ATan2OptionsT();
        unpackTo(aTan2OptionsT);
        return aTan2OptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, ATan2OptionsT aTan2OptionsT) {
        if (aTan2OptionsT == null) {
            return 0;
        }
        startATan2Options(flatBufferBuilder);
        return endATan2Options(flatBufferBuilder);
    }
}
