package org.tensorflow.lite.support.metadata.schema;

import com.google.flatbuffers.FlatBufferBuilder;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class ModelMetadataT {
    private String name = null;
    private String description = null;
    private String version = null;
    private SubGraphMetadataT[] subgraphMetadata = null;
    private String author = null;
    private String license = null;
    private AssociatedFileT[] associatedFiles = null;
    private String minParserVersion = null;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public SubGraphMetadataT[] getSubgraphMetadata() {
        return this.subgraphMetadata;
    }

    public void setSubgraphMetadata(SubGraphMetadataT[] subGraphMetadataTArr) {
        this.subgraphMetadata = subGraphMetadataTArr;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public String getLicense() {
        return this.license;
    }

    public void setLicense(String str) {
        this.license = str;
    }

    public AssociatedFileT[] getAssociatedFiles() {
        return this.associatedFiles;
    }

    public void setAssociatedFiles(AssociatedFileT[] associatedFileTArr) {
        this.associatedFiles = associatedFileTArr;
    }

    public String getMinParserVersion() {
        return this.minParserVersion;
    }

    public void setMinParserVersion(String str) {
        this.minParserVersion = str;
    }

    public static ModelMetadataT deserializeFromBinary(byte[] bArr) {
        return ModelMetadata.getRootAsModelMetadata(ByteBuffer.wrap(bArr)).unpack();
    }

    public byte[] serializeToBinary() {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder();
        ModelMetadata.finishModelMetadataBuffer(flatBufferBuilder, ModelMetadata.pack(flatBufferBuilder, this));
        return flatBufferBuilder.sizedByteArray();
    }
}
