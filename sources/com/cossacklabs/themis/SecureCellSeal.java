package com.cossacklabs.themis;

import com.cossacklabs.themis.SecureCell;

/* loaded from: classes.dex */
class SecureCellSeal implements SecureCell.Seal {
    private final SymmetricKey key;

    SecureCellSeal(SymmetricKey symmetricKey) {
        this.key = symmetricKey;
    }

    @Override // com.cossacklabs.themis.SecureCell.Seal
    public byte[] encrypt(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            throw new NullArgumentException("data cannot be null");
        }
        if (bArr.length == 0) {
            throw new InvalidArgumentException("data cannot be empty");
        }
        byte[][] encrypt = SecureCell.encrypt(this.key.key, bArr2, bArr, 0);
        if (encrypt == null) {
            throw new RuntimeException(new SecureCellException());
        }
        return encrypt[0];
    }

    @Override // com.cossacklabs.themis.SecureCell.Seal
    public byte[] encrypt(byte[] bArr) {
        return encrypt(bArr, null);
    }

    @Override // com.cossacklabs.themis.SecureCell.Seal
    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws SecureCellException {
        if (bArr == null) {
            throw new NullArgumentException("data cannot be null");
        }
        if (bArr.length == 0) {
            throw new InvalidArgumentException("data cannot be empty");
        }
        byte[] decrypt = SecureCell.decrypt(this.key.key, bArr2, new byte[][]{bArr, null}, 0);
        if (decrypt != null) {
            return decrypt;
        }
        throw new SecureCellException();
    }

    @Override // com.cossacklabs.themis.SecureCell.Seal
    public byte[] decrypt(byte[] bArr) throws SecureCellException {
        return decrypt(bArr, null);
    }
}
