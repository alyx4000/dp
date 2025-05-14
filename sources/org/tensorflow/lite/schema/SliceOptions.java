package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class SliceOptions extends Table {
    public void unpackTo(SliceOptionsT sliceOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static SliceOptions getRootAsSliceOptions(ByteBuffer byteBuffer) {
        return getRootAsSliceOptions(byteBuffer, new SliceOptions());
    }

    public static SliceOptions getRootAsSliceOptions(ByteBuffer byteBuffer, SliceOptions sliceOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return sliceOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public SliceOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startSliceOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endSliceOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public SliceOptions get(int i) {
            return get(new SliceOptions(), i);
        }

        public SliceOptions get(SliceOptions sliceOptions, int i) {
            return sliceOptions.__assign(SliceOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public SliceOptionsT unpack() {
        SliceOptionsT sliceOptionsT = new SliceOptionsT();
        unpackTo(sliceOptionsT);
        return sliceOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, SliceOptionsT sliceOptionsT) {
        if (sliceOptionsT == null) {
            return 0;
        }
        startSliceOptions(flatBufferBuilder);
        return endSliceOptions(flatBufferBuilder);
    }
}
