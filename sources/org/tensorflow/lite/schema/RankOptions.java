package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class RankOptions extends Table {
    public void unpackTo(RankOptionsT rankOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static RankOptions getRootAsRankOptions(ByteBuffer byteBuffer) {
        return getRootAsRankOptions(byteBuffer, new RankOptions());
    }

    public static RankOptions getRootAsRankOptions(ByteBuffer byteBuffer, RankOptions rankOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return rankOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public RankOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startRankOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endRankOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public RankOptions get(int i) {
            return get(new RankOptions(), i);
        }

        public RankOptions get(RankOptions rankOptions, int i) {
            return rankOptions.__assign(RankOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public RankOptionsT unpack() {
        RankOptionsT rankOptionsT = new RankOptionsT();
        unpackTo(rankOptionsT);
        return rankOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, RankOptionsT rankOptionsT) {
        if (rankOptionsT == null) {
            return 0;
        }
        startRankOptions(flatBufferBuilder);
        return endRankOptions(flatBufferBuilder);
    }
}
