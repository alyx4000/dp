package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class IfOptionsT {
    private int thenSubgraphIndex = 0;
    private int elseSubgraphIndex = 0;

    public int getThenSubgraphIndex() {
        return this.thenSubgraphIndex;
    }

    public void setThenSubgraphIndex(int i) {
        this.thenSubgraphIndex = i;
    }

    public int getElseSubgraphIndex() {
        return this.elseSubgraphIndex;
    }

    public void setElseSubgraphIndex(int i) {
        this.elseSubgraphIndex = i;
    }
}
