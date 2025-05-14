package org.tensorflow.lite.support.metadata.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
public final class Content extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static Content getRootAsContent(ByteBuffer byteBuffer) {
        return getRootAsContent(byteBuffer, new Content());
    }

    public static Content getRootAsContent(ByteBuffer byteBuffer, Content content) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return content.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public Content __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public byte contentPropertiesType() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return this.bb.get(__offset + this.bb_pos);
        }
        return (byte) 0;
    }

    public Table contentProperties(Table table) {
        int __offset = __offset(6);
        if (__offset != 0) {
            return __union(table, __offset + this.bb_pos);
        }
        return null;
    }

    public ValueRange range() {
        return range(new ValueRange());
    }

    public ValueRange range(ValueRange valueRange) {
        int __offset = __offset(8);
        if (__offset != 0) {
            return valueRange.__assign(__indirect(__offset + this.bb_pos), this.bb);
        }
        return null;
    }

    public static int createContent(FlatBufferBuilder flatBufferBuilder, byte b, int i, int i2) {
        flatBufferBuilder.startTable(3);
        addRange(flatBufferBuilder, i2);
        addContentProperties(flatBufferBuilder, i);
        addContentPropertiesType(flatBufferBuilder, b);
        return endContent(flatBufferBuilder);
    }

    public static void startContent(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(3);
    }

    public static void addContentPropertiesType(FlatBufferBuilder flatBufferBuilder, byte b) {
        flatBufferBuilder.addByte(0, b, 0);
    }

    public static void addContentProperties(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static void addRange(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(2, i, 0);
    }

    public static int endContent(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public Content get(int i) {
            return get(new Content(), i);
        }

        public Content get(Content content, int i) {
            return content.__assign(Content.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public ContentT unpack() {
        ContentT contentT = new ContentT();
        unpackTo(contentT);
        return contentT;
    }

    public void unpackTo(ContentT contentT) {
        ContentPropertiesUnion contentPropertiesUnion = new ContentPropertiesUnion();
        byte contentPropertiesType = contentPropertiesType();
        contentPropertiesUnion.setType(contentPropertiesType);
        if (contentPropertiesType == 1) {
            Table contentProperties = contentProperties(new FeatureProperties());
            contentPropertiesUnion.setValue(contentProperties != null ? ((FeatureProperties) contentProperties).unpack() : null);
        } else if (contentPropertiesType == 2) {
            Table contentProperties2 = contentProperties(new ImageProperties());
            contentPropertiesUnion.setValue(contentProperties2 != null ? ((ImageProperties) contentProperties2).unpack() : null);
        } else if (contentPropertiesType == 3) {
            Table contentProperties3 = contentProperties(new BoundingBoxProperties());
            contentPropertiesUnion.setValue(contentProperties3 != null ? ((BoundingBoxProperties) contentProperties3).unpack() : null);
        } else if (contentPropertiesType == 4) {
            Table contentProperties4 = contentProperties(new AudioProperties());
            contentPropertiesUnion.setValue(contentProperties4 != null ? ((AudioProperties) contentProperties4).unpack() : null);
        }
        contentT.setContentProperties(contentPropertiesUnion);
        if (range() != null) {
            contentT.setRange(range().unpack());
        } else {
            contentT.setRange(null);
        }
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, ContentT contentT) {
        if (contentT == null) {
            return 0;
        }
        return createContent(flatBufferBuilder, contentT.getContentProperties() == null ? (byte) 0 : contentT.getContentProperties().getType(), contentT.getContentProperties() == null ? 0 : ContentPropertiesUnion.pack(flatBufferBuilder, contentT.getContentProperties()), contentT.getRange() != null ? ValueRange.pack(flatBufferBuilder, contentT.getRange()) : 0);
    }
}
