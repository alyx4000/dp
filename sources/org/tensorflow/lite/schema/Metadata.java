package org.tensorflow.lite.schema;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes6.dex */
public final class Metadata extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_2_0_0();
    }

    public static Metadata getRootAsMetadata(ByteBuffer byteBuffer) {
        return getRootAsMetadata(byteBuffer, new Metadata());
    }

    public static Metadata getRootAsMetadata(ByteBuffer byteBuffer, Metadata metadata) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return metadata.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public Metadata __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public String name() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer nameAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer nameInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public long buffer() {
        if (__offset(6) != 0) {
            return this.bb.getInt(r0 + this.bb_pos) & BodyPartID.bodyIdMax;
        }
        return 0L;
    }

    public static int createMetadata(FlatBufferBuilder flatBufferBuilder, int i, long j) {
        flatBufferBuilder.startTable(2);
        addBuffer(flatBufferBuilder, j);
        addName(flatBufferBuilder, i);
        return endMetadata(flatBufferBuilder);
    }

    public static void startMetadata(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(2);
    }

    public static void addName(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static void addBuffer(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(1, (int) j, 0);
    }

    public static int endMetadata(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public Metadata get(int i) {
            return get(new Metadata(), i);
        }

        public Metadata get(Metadata metadata, int i) {
            return metadata.__assign(Metadata.__indirect(__element(i), this.bb), this.bb);
        }
    }

    public MetadataT unpack() {
        MetadataT metadataT = new MetadataT();
        unpackTo(metadataT);
        return metadataT;
    }

    public void unpackTo(MetadataT metadataT) {
        metadataT.setName(name());
        metadataT.setBuffer(buffer());
    }

    public static int pack(FlatBufferBuilder flatBufferBuilder, MetadataT metadataT) {
        if (metadataT == null) {
            return 0;
        }
        return createMetadata(flatBufferBuilder, metadataT.getName() != null ? flatBufferBuilder.createString(metadataT.getName()) : 0, metadataT.getBuffer());
    }
}
