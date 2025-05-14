package org.tensorflow.lite.schema;

import com.google.flatbuffers.FlatBufferBuilder;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class ModelT {
    private long version = 0;
    private OperatorCodeT[] operatorCodes = null;
    private SubGraphT[] subgraphs = null;
    private String description = null;
    private BufferT[] buffers = null;
    private int[] metadataBuffer = null;
    private MetadataT[] metadata = null;
    private SignatureDefT[] signatureDefs = null;

    public long getVersion() {
        return this.version;
    }

    public void setVersion(long j) {
        this.version = j;
    }

    public OperatorCodeT[] getOperatorCodes() {
        return this.operatorCodes;
    }

    public void setOperatorCodes(OperatorCodeT[] operatorCodeTArr) {
        this.operatorCodes = operatorCodeTArr;
    }

    public SubGraphT[] getSubgraphs() {
        return this.subgraphs;
    }

    public void setSubgraphs(SubGraphT[] subGraphTArr) {
        this.subgraphs = subGraphTArr;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public BufferT[] getBuffers() {
        return this.buffers;
    }

    public void setBuffers(BufferT[] bufferTArr) {
        this.buffers = bufferTArr;
    }

    public int[] getMetadataBuffer() {
        return this.metadataBuffer;
    }

    public void setMetadataBuffer(int[] iArr) {
        this.metadataBuffer = iArr;
    }

    public MetadataT[] getMetadata() {
        return this.metadata;
    }

    public void setMetadata(MetadataT[] metadataTArr) {
        this.metadata = metadataTArr;
    }

    public SignatureDefT[] getSignatureDefs() {
        return this.signatureDefs;
    }

    public void setSignatureDefs(SignatureDefT[] signatureDefTArr) {
        this.signatureDefs = signatureDefTArr;
    }

    public static ModelT deserializeFromBinary(byte[] bArr) {
        return Model.getRootAsModel(ByteBuffer.wrap(bArr)).unpack();
    }

    public byte[] serializeToBinary() {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder();
        Model.finishModelBuffer(flatBufferBuilder, Model.pack(flatBufferBuilder, this));
        return flatBufferBuilder.sizedByteArray();
    }
}
