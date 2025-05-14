package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class AssignVariableOptions extends Table {
    public void unpackTo(AssignVariableOptionsT assignVariableOptionsT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static AssignVariableOptions getRootAsAssignVariableOptions(ByteBuffer byteBuffer) {
        return getRootAsAssignVariableOptions(byteBuffer, new AssignVariableOptions());
    }

    public static AssignVariableOptions getRootAsAssignVariableOptions(ByteBuffer byteBuffer, AssignVariableOptions assignVariableOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return assignVariableOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public AssignVariableOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startAssignVariableOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endAssignVariableOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public AssignVariableOptions get(int i) {
            return get(new AssignVariableOptions(), i);
        }

        public AssignVariableOptions get(AssignVariableOptions assignVariableOptions, int i) {
            return assignVariableOptions.__assign(AssignVariableOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public AssignVariableOptionsT unpack() {
        AssignVariableOptionsT assignVariableOptionsT = new AssignVariableOptionsT();
        unpackTo(assignVariableOptionsT);
        return assignVariableOptionsT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, AssignVariableOptionsT assignVariableOptionsT) {
        if (assignVariableOptionsT == null) {
            return 0;
        }
        startAssignVariableOptions(flatBufferBuilder);
        return endAssignVariableOptions(flatBufferBuilder);
    }
}
