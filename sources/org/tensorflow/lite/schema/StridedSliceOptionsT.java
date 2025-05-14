package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class StridedSliceOptionsT {
    private int beginMask = 0;
    private int endMask = 0;
    private int ellipsisMask = 0;
    private int newAxisMask = 0;
    private int shrinkAxisMask = 0;

    public int getBeginMask() {
        return this.beginMask;
    }

    public void setBeginMask(int i) {
        this.beginMask = i;
    }

    public int getEndMask() {
        return this.endMask;
    }

    public void setEndMask(int i) {
        this.endMask = i;
    }

    public int getEllipsisMask() {
        return this.ellipsisMask;
    }

    public void setEllipsisMask(int i) {
        this.ellipsisMask = i;
    }

    public int getNewAxisMask() {
        return this.newAxisMask;
    }

    public void setNewAxisMask(int i) {
        this.newAxisMask = i;
    }

    public int getShrinkAxisMask() {
        return this.shrinkAxisMask;
    }

    public void setShrinkAxisMask(int i) {
        this.shrinkAxisMask = i;
    }
}
