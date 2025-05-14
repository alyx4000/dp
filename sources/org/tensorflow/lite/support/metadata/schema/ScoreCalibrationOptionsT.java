package org.tensorflow.lite.support.metadata.schema;

/* loaded from: classes6.dex */
public class ScoreCalibrationOptionsT {
    private byte scoreTransformation = 0;
    private float defaultScore = 0.0f;

    public byte getScoreTransformation() {
        return this.scoreTransformation;
    }

    public void setScoreTransformation(byte b) {
        this.scoreTransformation = b;
    }

    public float getDefaultScore() {
        return this.defaultScore;
    }

    public void setDefaultScore(float f) {
        this.defaultScore = f;
    }
}
