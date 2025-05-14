package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class HardSwishOptions extends Table {
    public void unpackTo(HardSwishOptionsT hardSwishOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static HardSwishOptions getRootAsHardSwishOptions(ByteBuffer byteBuffer) {
        return getRootAsHardSwishOptions(byteBuffer, new HardSwishOptions());
    }

    public static HardSwishOptions getRootAsHardSwishOptions(ByteBuffer byteBuffer, HardSwishOptions hardSwishOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return hardSwishOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public HardSwishOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startHardSwishOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endHardSwishOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public HardSwishOptions get(int i) {
            return get(new HardSwishOptions(), i);
        }

        public HardSwishOptions get(HardSwishOptions hardSwishOptions, int i) {
            return hardSwishOptions.__assign(HardSwishOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public HardSwishOptionsT unpack() {
        HardSwishOptionsT hardSwishOptionsT = new HardSwishOptionsT();
        unpackTo(hardSwishOptionsT);
        return hardSwishOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, HardSwishOptionsT hardSwishOptionsT) {
        if (hardSwishOptionsT == null) {
            return 0;
        }
        startHardSwishOptions(flatBufferBuilder);
        return endHardSwishOptions(flatBufferBuilder);
    }
}
