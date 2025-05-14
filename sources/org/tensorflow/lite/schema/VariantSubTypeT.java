package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class VariantSubTypeT {
    private int[] shape = null;
    private byte type = 0;
    private boolean hasRank = false;

    public int[] getShape() {
        return this.shape;
    }

    public void setShape(int[] iArr) {
        this.shape = iArr;
    }

    public byte getType() {
        return this.type;
    }

    public void setType(byte b) {
        this.type = b;
    }

    public boolean getHasRank() {
        return this.hasRank;
    }

    public void setHasRank(boolean z) {
        this.hasRank = z;
    }
}
