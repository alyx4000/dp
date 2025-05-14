package org.tensorflow.lite.support.metadata.schema;

import com.google.flatbuffers.FlatBufferBuilder;

/* loaded from: classes6.dex */
public class ProcessUnitOptionsUnion {
    private byte type = 0;
    private Object value = null;

    public byte getType() {
        return this.type;
    }

    public void setType(byte b) {
        this.type = b;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object obj) {
        this.value = obj;
    }

    public NormalizationOptionsT asNormalizationOptions() {
        return (NormalizationOptionsT) this.value;
    }

    public ScoreCalibrationOptionsT asScoreCalibrationOptions() {
        return (ScoreCalibrationOptionsT) this.value;
    }

    public ScoreThresholdingOptionsT asScoreThresholdingOptions() {
        return (ScoreThresholdingOptionsT) this.value;
    }

    public BertTokenizerOptionsT asBertTokenizerOptions() {
        return (BertTokenizerOptionsT) this.value;
    }

    public SentencePieceTokenizerOptionsT asSentencePieceTokenizerOptions() {
        return (SentencePieceTokenizerOptionsT) this.value;
    }

    public RegexTokenizerOptionsT asRegexTokenizerOptions() {
        return (RegexTokenizerOptionsT) this.value;
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, ProcessUnitOptionsUnion processUnitOptionsUnion) {
        switch (processUnitOptionsUnion.type) {
            case 1:
                return NormalizationOptions.pack(flatBufferBuilder, processUnitOptionsUnion.asNormalizationOptions());
            case 2:
                return ScoreCalibrationOptions.pack(flatBufferBuilder, processUnitOptionsUnion.asScoreCalibrationOptions());
            case 3:
                return ScoreThresholdingOptions.pack(flatBufferBuilder, processUnitOptionsUnion.asScoreThresholdingOptions());
            case 4:
                return BertTokenizerOptions.pack(flatBufferBuilder, processUnitOptionsUnion.asBertTokenizerOptions());
            case 5:
                return SentencePieceTokenizerOptions.pack(flatBufferBuilder, processUnitOptionsUnion.asSentencePieceTokenizerOptions());
            case 6:
                return RegexTokenizerOptions.pack(flatBufferBuilder, processUnitOptionsUnion.asRegexTokenizerOptions());
            default:
                return 0;
        }
    }
}
