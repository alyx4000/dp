package org.tensorflow.lite.support.metadata.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class ProcessUnit extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static ProcessUnit getRootAsProcessUnit(ByteBuffer byteBuffer) {
        return getRootAsProcessUnit(byteBuffer, new ProcessUnit());
    }

    public static ProcessUnit getRootAsProcessUnit(ByteBuffer byteBuffer, ProcessUnit processUnit) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return processUnit.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public ProcessUnit __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public byte optionsType() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return this.bb.get(__offset + this.bb_pos);
        }
        return (byte) 0;
    }

    public Table options(Table table) {
        int __offset = __offset(6);
        if (__offset != 0) {
            return __union(table, __offset + this.bb_pos);
        }
        return null;
    }

    public static int createProcessUnit(FlatBufferBuilder flatBufferBuilder, byte b, int i) {
        flatBufferBuilder.startTable(2);
        addOptions(flatBufferBuilder, i);
        addOptionsType(flatBufferBuilder, b);
        return endProcessUnit(flatBufferBuilder);
    }

    public static void startProcessUnit(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(2);
    }

    public static void addOptionsType(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.addByte(0, b, 0);
    }

    public static void addOptions(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static int endProcessUnit(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public ProcessUnit get(int i) {
            return get(new ProcessUnit(), i);
        }

        public ProcessUnit get(ProcessUnit processUnit, int i) {
            return processUnit.__assign(ProcessUnit.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public ProcessUnitT unpack() {
        ProcessUnitT processUnitT = new ProcessUnitT();
        unpackTo(processUnitT);
        return processUnitT;
    }

    public void unpackTo(ProcessUnitT processUnitT) {
        ProcessUnitOptionsUnion processUnitOptionsUnion = new ProcessUnitOptionsUnion();
        byte optionsType = optionsType();
        processUnitOptionsUnion.setType(optionsType);
        switch (optionsType) {
            case 1:
                Table options = options(new NormalizationOptions());
                processUnitOptionsUnion.setValue(options != null ? ((NormalizationOptions) options).unpack() : null);
                break;
            case 2:
                Table options2 = options(new ScoreCalibrationOptions());
                processUnitOptionsUnion.setValue(options2 != null ? ((ScoreCalibrationOptions) options2).unpack() : null);
                break;
            case 3:
                Table options3 = options(new ScoreThresholdingOptions());
                processUnitOptionsUnion.setValue(options3 != null ? ((ScoreThresholdingOptions) options3).unpack() : null);
                break;
            case 4:
                Table options4 = options(new BertTokenizerOptions());
                processUnitOptionsUnion.setValue(options4 != null ? ((BertTokenizerOptions) options4).unpack() : null);
                break;
            case 5:
                Table options5 = options(new SentencePieceTokenizerOptions());
                processUnitOptionsUnion.setValue(options5 != null ? ((SentencePieceTokenizerOptions) options5).unpack() : null);
                break;
            case 6:
                Table options6 = options(new RegexTokenizerOptions());
                processUnitOptionsUnion.setValue(options6 != null ? ((RegexTokenizerOptions) options6).unpack() : null);
                break;
        }
        processUnitT.setOptions(processUnitOptionsUnion);
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, ProcessUnitT processUnitT) {
        if (processUnitT == null) {
            return 0;
        }
        return createProcessUnit(flatBufferBuilder, processUnitT.getOptions() == null ? (byte) 0 : processUnitT.getOptions().getType(), processUnitT.getOptions() != null ? ProcessUnitOptionsUnion.pack(flatBufferBuilder, processUnitT.getOptions()) : 0);
    }
}
