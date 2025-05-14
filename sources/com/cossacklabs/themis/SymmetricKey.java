package com.cossacklabs.themis;

/* loaded from: classes.dex */
public class SymmetricKey extends KeyBytes {
    private static native byte[] generateSymmetricKey();

    @Override // com.cossacklabs.themis.KeyBytes, com.cossacklabs.themis.IKey
    public /* bridge */ /* synthetic */ byte[] toByteArray() {
        return super.toByteArray();
    }

    static {
        System.loadLibrary("themis_jni");
    }

    public SymmetricKey() {
        super(newSymmetricKey());
    }

    public SymmetricKey(byte[] bArr) {
        super(bArr);
    }

    private static byte[] newSymmetricKey() {
        byte[] generateSymmetricKey = generateSymmetricKey();
        if (generateSymmetricKey == null || generateSymmetricKey.length == 0) {
            throw new KeyGenerationException("failed to generate symmetric key");
        }
        return generateSymmetricKey;
    }
}
