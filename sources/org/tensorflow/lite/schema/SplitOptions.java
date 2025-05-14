package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class SplitOptions extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static SplitOptions getRootAsSplitOptions(ByteBuffer byteBuffer) {
        return getRootAsSplitOptions(byteBuffer, new SplitOptions());
    }

    public static SplitOptions getRootAsSplitOptions(ByteBuffer byteBuffer, SplitOptions splitOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return splitOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public SplitOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public int numSplits() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return this.bb.getInt(__offset + this.bb_pos);
        }
        return 0;
    }

    public static int createSplitOptions(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startTable(1);
        addNumSplits(flatBufferBuilder, i);
        return endSplitOptions(flatBufferBuilder);
    }

    public static void startSplitOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(1);
    }

    public static void addNumSplits(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addInt(0, i, 0);
    }

    public static int endSplitOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public SplitOptions get(int i) {
            return get(new SplitOptions(), i);
        }

        public SplitOptions get(SplitOptions splitOptions, int i) {
            return splitOptions.__assign(SplitOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public SplitOptionsT unpack() {
        SplitOptionsT splitOptionsT = new SplitOptionsT();
        unpackTo(splitOptionsT);
        return splitOptionsT;
    }

    public void unpackTo(SplitOptionsT splitOptionsT) {
        splitOptionsT.setNumSplits(numSplits());
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, SplitOptionsT splitOptionsT) {
        if (splitOptionsT == null) {
            return 0;
        }
        return createSplitOptions(flatBufferBuilder, splitOptionsT.getNumSplits());
    }
}
