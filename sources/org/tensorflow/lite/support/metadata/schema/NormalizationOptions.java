package org.tensorflow.lite.support.metadata.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.FloatVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class NormalizationOptions extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static NormalizationOptions getRootAsNormalizationOptions(ByteBuffer byteBuffer) {
        return getRootAsNormalizationOptions(byteBuffer, new NormalizationOptions());
    }

    public static NormalizationOptions getRootAsNormalizationOptions(ByteBuffer byteBuffer, NormalizationOptions normalizationOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return normalizationOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public NormalizationOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public float mean(int i) {
        int __offset = __offset(4);
        if (__offset != 0) {
            return this.bb.getFloat(__vector(__offset) + (i * 4));
        }
        return 0.0f;
    }

    public int meanLength() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public FloatVector meanVector() {
        return meanVector(new FloatVector());
    }

    public FloatVector meanVector(FloatVector floatVector) {
        int __offset = __offset(4);
        if (__offset != 0) {
            return floatVector.__assign(__vector(__offset), this.bb);
        }
        return null;
    }

    public ByteBuffer meanAsByteBuffer() {
        return __vector_as_bytebuffer(4, 4);
    }

    public ByteBuffer meanInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 4);
    }

    public float std(int i) {
        int __offset = __offset(6);
        if (__offset != 0) {
            return this.bb.getFloat(__vector(__offset) + (i * 4));
        }
        return 0.0f;
    }

    public int stdLength() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public FloatVector stdVector() {
        return stdVector(new FloatVector());
    }

    public FloatVector stdVector(FloatVector floatVector) {
        int __offset = __offset(6);
        if (__offset != 0) {
            return floatVector.__assign(__vector(__offset), this.bb);
        }
        return null;
    }

    public ByteBuffer stdAsByteBuffer() {
        return __vector_as_bytebuffer(6, 4);
    }

    public ByteBuffer stdInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 4);
    }

    public static int createNormalizationOptions(FlatBufferBuilder flatBufferBuilder, int i, int i2) {
        flatBufferBuilder.startTable(2);
        addStd(flatBufferBuilder, i2);
        addMean(flatBufferBuilder, i);
        return endNormalizationOptions(flatBufferBuilder);
    }

    public static void startNormalizationOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(2);
    }

    public static void addMean(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static int createMeanVector(FlatBufferBuilder flatBufferBuilder, float[] fArr) {
        flatBufferBuilder.startVector(4, fArr.length, 4);
        for (int length = fArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addFloat(fArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startMeanVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static void addStd(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static int createStdVector(FlatBufferBuilder flatBufferBuilder, float[] fArr) {
        flatBufferBuilder.startVector(4, fArr.length, 4);
        for (int length = fArr.length - 1; length >= 0; length--) {
            flatBufferBuilder.addFloat(fArr[length]);
        }
        return flatBufferBuilder.endVector();
    }

    public static void startStdVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(4, i, 4);
    }

    public static int endNormalizationOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public NormalizationOptions get(int i) {
            return get(new NormalizationOptions(), i);
        }

        public NormalizationOptions get(NormalizationOptions normalizationOptions, int i) {
            return normalizationOptions.__assign(NormalizationOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public NormalizationOptionsT unpack() {
        NormalizationOptionsT normalizationOptionsT = new NormalizationOptionsT();
        unpackTo(normalizationOptionsT);
        return normalizationOptionsT;
    }

    public void unpackTo(NormalizationOptionsT normalizationOptionsT) {
        float[] fArr = new float[meanLength()];
        for (int i = 0; i < meanLength(); i++) {
            fArr[i] = mean(i);
        }
        normalizationOptionsT.setMean(fArr);
        float[] fArr2 = new float[stdLength()];
        for (int i2 = 0; i2 < stdLength(); i2++) {
            fArr2[i2] = std(i2);
        }
        normalizationOptionsT.setStd(fArr2);
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, NormalizationOptionsT normalizationOptionsT) {
        if (normalizationOptionsT == null) {
            return 0;
        }
        return createNormalizationOptions(flatBufferBuilder, normalizationOptionsT.getMean() != null ? createMeanVector(flatBufferBuilder, normalizationOptionsT.getMean()) : 0, normalizationOptionsT.getStd() != null ? createStdVector(flatBufferBuilder, normalizationOptionsT.getStd()) : 0);
    }
}
