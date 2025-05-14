package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class SelectOptions extends Table {
    public void unpackTo(SelectOptionsT selectOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static SelectOptions getRootAsSelectOptions(ByteBuffer byteBuffer) {
        return getRootAsSelectOptions(byteBuffer, new SelectOptions());
    }

    public static SelectOptions getRootAsSelectOptions(ByteBuffer byteBuffer, SelectOptions selectOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return selectOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public SelectOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startSelectOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endSelectOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public SelectOptions get(int i) {
            return get(new SelectOptions(), i);
        }

        public SelectOptions get(SelectOptions selectOptions, int i) {
            return selectOptions.__assign(SelectOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public SelectOptionsT unpack() {
        SelectOptionsT selectOptionsT = new SelectOptionsT();
        unpackTo(selectOptionsT);
        return selectOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, SelectOptionsT selectOptionsT) {
        if (selectOptionsT == null) {
            return 0;
        }
        startSelectOptions(flatBufferBuilder);
        return endSelectOptions(flatBufferBuilder);
    }
}
