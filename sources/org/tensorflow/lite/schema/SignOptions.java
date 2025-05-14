package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class SignOptions extends Table {
    public void unpackTo(SignOptionsT signOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static SignOptions getRootAsSignOptions(ByteBuffer byteBuffer) {
        return getRootAsSignOptions(byteBuffer, new SignOptions());
    }

    public static SignOptions getRootAsSignOptions(ByteBuffer byteBuffer, SignOptions signOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return signOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public SignOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startSignOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endSignOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public SignOptions get(int i) {
            return get(new SignOptions(), i);
        }

        public SignOptions get(SignOptions signOptions, int i) {
            return signOptions.__assign(SignOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public SignOptionsT unpack() {
        SignOptionsT signOptionsT = new SignOptionsT();
        unpackTo(signOptionsT);
        return signOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, SignOptionsT signOptionsT) {
        if (signOptionsT == null) {
            return 0;
        }
        startSignOptions(flatBufferBuilder);
        return endSignOptions(flatBufferBuilder);
    }
}
