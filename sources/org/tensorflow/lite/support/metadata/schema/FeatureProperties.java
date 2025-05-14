package org.tensorflow.lite.support.metadata.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class FeatureProperties extends Table {
    public void unpackTo(FeaturePropertiesT featurePropertiesT) {
    }

    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static FeatureProperties getRootAsFeatureProperties(ByteBuffer byteBuffer) {
        return getRootAsFeatureProperties(byteBuffer, new FeatureProperties());
    }

    public static FeatureProperties getRootAsFeatureProperties(ByteBuffer byteBuffer, FeatureProperties featureProperties) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return featureProperties.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public FeatureProperties __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public static void startFeatureProperties(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(0);
    }

    public static int endFeatureProperties(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public FeatureProperties get(int i) {
            return get(new FeatureProperties(), i);
        }

        public FeatureProperties get(FeatureProperties featureProperties, int i) {
            return featureProperties.__assign(FeatureProperties.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public FeaturePropertiesT unpack() {
        FeaturePropertiesT featurePropertiesT = new FeaturePropertiesT();
        unpackTo(featurePropertiesT);
        return featurePropertiesT;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, FeaturePropertiesT featurePropertiesT) {
        if (featurePropertiesT == null) {
            return 0;
        }
        startFeatureProperties(flatBufferBuilder);
        return endFeatureProperties(flatBufferBuilder);
    }
}
