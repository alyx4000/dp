package com.google.crypto.tink;

import com.google.crypto.tink.internal.KeyTypeManager;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import java.security.GeneralSecurityException;

/* loaded from: classes5.dex */
class KeyManagerImpl<PrimitiveT, KeyProtoT extends MessageLite> implements KeyManager<PrimitiveT> {
    private final KeyTypeManager<KeyProtoT> keyTypeManager;
    private final Class<PrimitiveT> primitiveClass;

    public KeyManagerImpl(KeyTypeManager<KeyProtoT> keyTypeManager, Class<PrimitiveT> primitiveClass) {
        if (!keyTypeManager.supportedPrimitives().contains(primitiveClass) && !Void.class.equals(primitiveClass)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", keyTypeManager.toString(), primitiveClass.getName()));
        }
        this.keyTypeManager = keyTypeManager;
        this.primitiveClass = primitiveClass;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <CastedT> CastedT castOrThrowSecurityException(Object objectToCast, String exceptionText, Class<CastedT> classObject) throws GeneralSecurityException {
        if (classObject.isInstance(objectToCast)) {
            return objectToCast;
        }
        throw new GeneralSecurityException(exceptionText);
    }

    @Override // com.google.crypto.tink.KeyManager
    public final PrimitiveT getPrimitive(ByteString byteString) throws GeneralSecurityException {
        try {
            return validateKeyAndGetPrimitive(this.keyTypeManager.parseKey(byteString));
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Failures parsing proto of type " + this.keyTypeManager.getKeyClass().getName(), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.KeyManager
    public final PrimitiveT getPrimitive(MessageLite messageLite) throws GeneralSecurityException {
        return (PrimitiveT) validateKeyAndGetPrimitive((MessageLite) castOrThrowSecurityException(messageLite, "Expected proto of type " + this.keyTypeManager.getKeyClass().getName(), this.keyTypeManager.getKeyClass()));
    }

    @Override // com.google.crypto.tink.KeyManager
    public final MessageLite newKey(ByteString serializedKeyFormat) throws GeneralSecurityException {
        try {
            return keyFactoryHelper().parseValidateCreate(serializedKeyFormat);
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Failures parsing proto of type " + this.keyTypeManager.keyFactory().getKeyFormatClass().getName(), e);
        }
    }

    @Override // com.google.crypto.tink.KeyManager
    public final MessageLite newKey(MessageLite keyFormat) throws GeneralSecurityException {
        return keyFactoryHelper().castValidateCreate(keyFormat);
    }

    @Override // com.google.crypto.tink.KeyManager
    public final boolean doesSupport(String typeUrl) {
        return typeUrl.equals(getKeyType());
    }

    @Override // com.google.crypto.tink.KeyManager
    public final String getKeyType() {
        return this.keyTypeManager.getKeyType();
    }

    @Override // com.google.crypto.tink.KeyManager
    public int getVersion() {
        return this.keyTypeManager.getVersion();
    }

    @Override // com.google.crypto.tink.KeyManager
    public final KeyData newKeyData(ByteString serializedKeyFormat) throws GeneralSecurityException {
        try {
            return (KeyData) KeyData.newBuilder().setTypeUrl(getKeyType()).setValue(keyFactoryHelper().parseValidateCreate(serializedKeyFormat).toByteString()).setKeyMaterialType(this.keyTypeManager.keyMaterialType()).build();
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }

    @Override // com.google.crypto.tink.KeyManager
    public final Class<PrimitiveT> getPrimitiveClass() {
        return this.primitiveClass;
    }

    private PrimitiveT validateKeyAndGetPrimitive(KeyProtoT keyprotot) throws GeneralSecurityException {
        if (Void.class.equals(this.primitiveClass)) {
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        }
        this.keyTypeManager.validateKey(keyprotot);
        return (PrimitiveT) this.keyTypeManager.getPrimitive(keyprotot, this.primitiveClass);
    }

    private static class KeyFactoryHelper<KeyFormatProtoT extends MessageLite, KeyProtoT extends MessageLite> {
        final KeyTypeManager.KeyFactory<KeyFormatProtoT, KeyProtoT> keyFactory;

        KeyFactoryHelper(KeyTypeManager.KeyFactory<KeyFormatProtoT, KeyProtoT> keyFactory) {
            this.keyFactory = keyFactory;
        }

        private KeyProtoT validateCreate(KeyFormatProtoT keyFormat) throws GeneralSecurityException {
            this.keyFactory.validateKeyFormat(keyFormat);
            return this.keyFactory.createKey(keyFormat);
        }

        KeyProtoT parseValidateCreate(ByteString byteString) throws GeneralSecurityException, InvalidProtocolBufferException {
            return validateCreate(this.keyFactory.parseKeyFormat(byteString));
        }

        /* JADX WARN: Multi-variable type inference failed */
        KeyProtoT castValidateCreate(MessageLite messageLite) throws GeneralSecurityException {
            return (KeyProtoT) validateCreate((MessageLite) KeyManagerImpl.castOrThrowSecurityException(messageLite, "Expected proto of type " + this.keyFactory.getKeyFormatClass().getName(), this.keyFactory.getKeyFormatClass()));
        }
    }

    private KeyFactoryHelper<?, KeyProtoT> keyFactoryHelper() {
        return new KeyFactoryHelper<>(this.keyTypeManager.keyFactory());
    }
}
