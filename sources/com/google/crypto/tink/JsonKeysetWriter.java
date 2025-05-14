package com.google.crypto.tink;

import com.amplitude.reactnative.DatabaseConstants;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.subtle.Base64;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Iterator;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes5.dex */
public final class JsonKeysetWriter implements KeysetWriter {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final OutputStream outputStream;

    private long toUnsignedLong(int x) {
        return x & BodyPartID.bodyIdMax;
    }

    private JsonKeysetWriter(OutputStream stream) {
        this.outputStream = stream;
    }

    public static KeysetWriter withOutputStream(OutputStream stream) {
        return new JsonKeysetWriter(stream);
    }

    @Deprecated
    public static KeysetWriter withFile(File file) throws IOException {
        return withOutputStream(new FileOutputStream(file));
    }

    @Deprecated
    public static KeysetWriter withPath(String path) throws IOException {
        return withOutputStream(new FileOutputStream(new File(path)));
    }

    @Deprecated
    public static KeysetWriter withPath(Path path) throws IOException {
        return withOutputStream(new FileOutputStream(path.toFile()));
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(Keyset keyset) throws IOException {
        try {
            try {
                OutputStream outputStream = this.outputStream;
                String jsonObject = toJson(keyset).toString();
                Charset charset = UTF_8;
                outputStream.write(jsonObject.getBytes(charset));
                this.outputStream.write(System.lineSeparator().getBytes(charset));
            } catch (JsonParseException e) {
                throw new IOException(e);
            }
        } finally {
            this.outputStream.close();
        }
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(EncryptedKeyset keyset) throws IOException {
        OutputStream outputStream = this.outputStream;
        String jsonObject = toJson(keyset).toString();
        Charset charset = UTF_8;
        outputStream.write(jsonObject.getBytes(charset));
        this.outputStream.write(System.lineSeparator().getBytes(charset));
        this.outputStream.close();
    }

    private JsonObject toJson(Keyset keyset) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("primaryKeyId", Long.valueOf(toUnsignedLong(keyset.getPrimaryKeyId())));
        JsonArray jsonArray = new JsonArray();
        Iterator<Keyset.Key> it = keyset.getKeyList().iterator();
        while (it.hasNext()) {
            jsonArray.add(toJson(it.next()));
        }
        jsonObject.add(DatabaseConstants.KEY_FIELD, jsonArray);
        return jsonObject;
    }

    private JsonObject toJson(Keyset.Key key) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("keyData", toJson(key.getKeyData()));
        jsonObject.addProperty("status", key.getStatus().name());
        jsonObject.addProperty("keyId", Long.valueOf(toUnsignedLong(key.getKeyId())));
        jsonObject.addProperty("outputPrefixType", key.getOutputPrefixType().name());
        return jsonObject;
    }

    private JsonObject toJson(KeyData keyData) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("typeUrl", keyData.getTypeUrl());
        jsonObject.addProperty("value", Base64.encode(keyData.getValue().toByteArray()));
        jsonObject.addProperty("keyMaterialType", keyData.getKeyMaterialType().name());
        return jsonObject;
    }

    private JsonObject toJson(EncryptedKeyset keyset) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("encryptedKeyset", Base64.encode(keyset.getEncryptedKeyset().toByteArray()));
        jsonObject.add("keysetInfo", toJson(keyset.getKeysetInfo()));
        return jsonObject;
    }

    private JsonObject toJson(KeysetInfo keysetInfo) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("primaryKeyId", Long.valueOf(toUnsignedLong(keysetInfo.getPrimaryKeyId())));
        JsonArray jsonArray = new JsonArray();
        Iterator<KeysetInfo.KeyInfo> it = keysetInfo.getKeyInfoList().iterator();
        while (it.hasNext()) {
            jsonArray.add(toJson(it.next()));
        }
        jsonObject.add("keyInfo", jsonArray);
        return jsonObject;
    }

    private JsonObject toJson(KeysetInfo.KeyInfo keyInfo) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("typeUrl", keyInfo.getTypeUrl());
        jsonObject.addProperty("status", keyInfo.getStatus().name());
        jsonObject.addProperty("keyId", Long.valueOf(toUnsignedLong(keyInfo.getKeyId())));
        jsonObject.addProperty("outputPrefixType", keyInfo.getOutputPrefixType().name());
        return jsonObject;
    }
}
