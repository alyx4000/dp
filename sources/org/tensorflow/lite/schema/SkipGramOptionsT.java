package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class SkipGramOptionsT {
    private int ngramSize = 0;
    private int maxSkipSize = 0;
    private boolean includeAllNgrams = false;

    public int getNgramSize() {
        return this.ngramSize;
    }

    public void setNgramSize(int i) {
        this.ngramSize = i;
    }

    public int getMaxSkipSize() {
        return this.maxSkipSize;
    }

    public void setMaxSkipSize(int i) {
        this.maxSkipSize = i;
    }

    public boolean getIncludeAllNgrams() {
        return this.includeAllNgrams;
    }

    public void setIncludeAllNgrams(boolean z) {
        this.includeAllNgrams = z;
    }
}
