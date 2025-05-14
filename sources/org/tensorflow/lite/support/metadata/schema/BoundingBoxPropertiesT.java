package org.tensorflow.lite.support.metadata.schema;

/* loaded from: classes6.dex */
public class BoundingBoxPropertiesT {
    private long[] index = null;
    private byte type = 0;
    private byte coordinateType = 0;

    public long[] getIndex() {
        return this.index;
    }

    public void setIndex(long[] jArr) {
        this.index = jArr;
    }

    public byte getType() {
        return this.type;
    }

    public void setType(byte b) {
        this.type = b;
    }

    public byte getCoordinateType() {
        return this.coordinateType;
    }

    public void setCoordinateType(byte b) {
        this.coordinateType = b;
    }
}
