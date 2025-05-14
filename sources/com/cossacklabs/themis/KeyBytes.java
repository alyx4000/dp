package com.cossacklabs.themis;

/* loaded from: classes.dex */
abstract class KeyBytes implements IKey {
    final byte[] key;

    public KeyBytes(byte[] bArr) {
        if (bArr == null) {
            throw new NullArgumentException("key cannot be null");
        }
        if (bArr.length == 0) {
            throw new InvalidArgumentException("key cannot be empty");
        }
        this.key = (byte[]) bArr.clone();
    }

    @Override // com.cossacklabs.themis.IKey
    public byte[] toByteArray() {
        return (byte[]) this.key.clone();
    }
}
