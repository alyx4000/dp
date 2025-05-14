package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class PackOptions extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static PackOptions getRootAsPackOptions(ByteBuffer byteBuffer) {
        return getRootAsPackOptions(byteBuffer, new PackOptions());
    }

    public static PackOptions getRootAsPackOptions(ByteBuffer byteBuffer, PackOptions packOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return packOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public PackOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public int valuesCount() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return this.bb.getInt(__offset + this.bb_pos);
        }
        return 0;
    }

    public int axis() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return this.bb.getInt(__offset + this.bb_pos);
        }
        return 0;
    }

    public static int createPackOptions(FlatBufferBuilder flatBufferBuilder, int i, int i2) {
        flatBufferBuilder.startTable(2);
        addAxis(flatBufferBuilder, i2);
        addValuesCount(flatBufferBuilder, i);
        return endPackOptions(flatBufferBuilder);
    }

    public static void startPackOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(2);
    }

    public static void addValuesCount(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addInt(0, i, 0);
    }

    public static void addAxis(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addInt(1, i, 0);
    }

    public static int endPackOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public PackOptions get(int i) {
            return get(new PackOptions(), i);
        }

        public PackOptions get(PackOptions packOptions, int i) {
            return packOptions.__assign(PackOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public PackOptionsT unpack() {
        PackOptionsT packOptionsT = new PackOptionsT();
        unpackTo(packOptionsT);
        return packOptionsT;
    }

    public void unpackTo(PackOptionsT packOptionsT) {
        packOptionsT.setValuesCount(valuesCount());
        packOptionsT.setAxis(axis());
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, PackOptionsT packOptionsT) {
        if (packOptionsT == null) {
            return 0;
        }
        return createPackOptions(flatBufferBuilder, packOptionsT.getValuesCount(), packOptionsT.getAxis());
    }
}
