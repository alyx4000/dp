package org.tensorflow.lite.support.metadata.schema;

/* loaded from: classes6.dex */
public class ImagePropertiesT {
    private byte colorSpace = 0;
    private ImageSizeT defaultSize = null;

    public byte getColorSpace() {
        return this.colorSpace;
    }

    public void setColorSpace(byte b) {
        this.colorSpace = b;
    }

    public ImageSizeT getDefaultSize() {
        return this.defaultSize;
    }

    public void setDefaultSize(ImageSizeT imageSizeT) {
        this.defaultSize = imageSizeT;
    }
}
