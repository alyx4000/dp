package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class BatchToSpaceNDOptions extends Table {
    public void unpackTo(BatchToSpaceNDOptionsT batchToSpaceNDOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static BatchToSpaceNDOptions getRootAsBatchToSpaceNDOptions(ByteBuffer byteBuffer) {
        return getRootAsBatchToSpaceNDOptions(byteBuffer, new BatchToSpaceNDOptions());
    }

    public static BatchToSpaceNDOptions getRootAsBatchToSpaceNDOptions(ByteBuffer byteBuffer, BatchToSpaceNDOptions batchToSpaceNDOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return batchToSpaceNDOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public BatchToSpaceNDOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startBatchToSpaceNDOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endBatchToSpaceNDOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public BatchToSpaceNDOptions get(int i) {
            return get(new BatchToSpaceNDOptions(), i);
        }

        public BatchToSpaceNDOptions get(BatchToSpaceNDOptions batchToSpaceNDOptions, int i) {
            return batchToSpaceNDOptions.__assign(BatchToSpaceNDOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public BatchToSpaceNDOptionsT unpack() {
        BatchToSpaceNDOptionsT batchToSpaceNDOptionsT = new BatchToSpaceNDOptionsT();
        unpackTo(batchToSpaceNDOptionsT);
        return batchToSpaceNDOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, BatchToSpaceNDOptionsT batchToSpaceNDOptionsT) {
        if (batchToSpaceNDOptionsT == null) {
            return 0;
        }
        startBatchToSpaceNDOptions(flatBufferBuilder);
        return endBatchToSpaceNDOptions(flatBufferBuilder);
    }
}
