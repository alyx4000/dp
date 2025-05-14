package com.cossacklabs.themis;

import com.cossacklabs.themis.SecureCell;

/* loaded from: classes.dex */
class SecureCellContextImprint implements SecureCell.ContextImprint {
    private final SymmetricKey key;

    SecureCellContextImprint(SymmetricKey symmetricKey) {
        this.key = symmetricKey;
    }

    @Override // com.cossacklabs.themis.SecureCell.ContextImprint
    public byte[] encrypt(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            throw new NullArgumentException("data cannot be null");
        }
        if (bArr.length == 0) {
            throw new InvalidArgumentException("data cannot be empty");
        }
        if (bArr2 == null) {
            throw new NullArgumentException("context cannot be null");
        }
        if (bArr2.length == 0) {
            throw new InvalidArgumentException("context cannot be empty");
        }
        byte[][] encrypt = SecureCell.encrypt(this.key.key, bArr2, bArr, 2);
        if (encrypt == null) {
            throw new RuntimeException(new SecureCellException());
        }
        return encrypt[0];
    }

    @Override // com.cossacklabs.themis.SecureCell.ContextImprint
    public byte[] decrypt(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            throw new NullArgumentException("data cannot be null");
        }
        if (bArr.length == 0) {
            throw new InvalidArgumentException("data cannot be empty");
        }
        if (bArr2 == null) {
            throw new NullArgumentException("context cannot be null");
        }
        if (bArr2.length == 0) {
            throw new InvalidArgumentException("context cannot be empty");
        }
        byte[] decrypt = SecureCell.decrypt(this.key.key, bArr2, new byte[][]{bArr, null}, 2);
        if (decrypt != null) {
            return decrypt;
        }
        throw new RuntimeException(new SecureCellException());
    }
}
