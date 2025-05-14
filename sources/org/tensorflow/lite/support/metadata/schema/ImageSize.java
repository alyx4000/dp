package org.tensorflow.lite.support.metadata.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes6.dex */
public final class ImageSize extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static ImageSize getRootAsImageSize(ByteBuffer byteBuffer) {
        return getRootAsImageSize(byteBuffer, new ImageSize());
    }

    public static ImageSize getRootAsImageSize(ByteBuffer byteBuffer, ImageSize imageSize) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return imageSize.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public ImageSize __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public long width() {
        if (__offset(4) != 0) {
            return this.bb.getInt(r0 + this.bb_pos) & BodyPartID.bodyIdMax;
        }
        return 0L;
    }

    public long height() {
        if (__offset(6) != 0) {
            return this.bb.getInt(r0 + this.bb_pos) & BodyPartID.bodyIdMax;
        }
        return 0L;
    }

    public static int createImageSize(FlatBufferBuilder flatBufferBuilder, long j, long j2) {
        flatBufferBuilder.startTable(2);
        addHeight(flatBufferBuilder, j2);
        addWidth(flatBufferBuilder, j);
        return endImageSize(flatBufferBuilder);
    }

    public static void startImageSize(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(2);
    }

    public static void addWidth(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(0, (int) j, 0);
    }

    public static void addHeight(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(1, (int) j, 0);
    }

    public static int endImageSize(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public ImageSize get(int i) {
            return get(new ImageSize(), i);
        }

        public ImageSize get(ImageSize imageSize, int i) {
            return imageSize.__assign(ImageSize.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public ImageSizeT unpack() {
        ImageSizeT imageSizeT = new ImageSizeT();
        unpackTo(imageSizeT);
        return imageSizeT;
    }

    public void unpackTo(ImageSizeT imageSizeT) {
        imageSizeT.setWidth(width());
        imageSizeT.setHeight(height());
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, ImageSizeT imageSizeT) {
        if (imageSizeT == null) {
            return 0;
        }
        return createImageSize(flatBufferBuilder, imageSizeT.getWidth(), imageSizeT.getHeight());
    }
}
