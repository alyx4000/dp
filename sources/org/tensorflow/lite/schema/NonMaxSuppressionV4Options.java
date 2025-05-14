package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class NonMaxSuppressionV4Options extends Table {
    public void unpackTo(NonMaxSuppressionV4OptionsT nonMaxSuppressionV4OptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static NonMaxSuppressionV4Options getRootAsNonMaxSuppressionV4Options(ByteBuffer byteBuffer) {
        return getRootAsNonMaxSuppressionV4Options(byteBuffer, new NonMaxSuppressionV4Options());
    }

    public static NonMaxSuppressionV4Options getRootAsNonMaxSuppressionV4Options(ByteBuffer byteBuffer, NonMaxSuppressionV4Options nonMaxSuppressionV4Options) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return nonMaxSuppressionV4Options.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public NonMaxSuppressionV4Options __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startNonMaxSuppressionV4Options(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endNonMaxSuppressionV4Options(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public NonMaxSuppressionV4Options get(int i) {
            return get(new NonMaxSuppressionV4Options(), i);
        }

        public NonMaxSuppressionV4Options get(NonMaxSuppressionV4Options nonMaxSuppressionV4Options, int i) {
            return nonMaxSuppressionV4Options.__assign(NonMaxSuppressionV4Options.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public NonMaxSuppressionV4OptionsT unpack() {
        NonMaxSuppressionV4OptionsT nonMaxSuppressionV4OptionsT = new NonMaxSuppressionV4OptionsT();
        unpackTo(nonMaxSuppressionV4OptionsT);
        return nonMaxSuppressionV4OptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, NonMaxSuppressionV4OptionsT nonMaxSuppressionV4OptionsT) {
        if (nonMaxSuppressionV4OptionsT == null) {
            return 0;
        }
        startNonMaxSuppressionV4Options(flatBufferBuilder);
        return endNonMaxSuppressionV4Options(flatBufferBuilder);
    }
}
