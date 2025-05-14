package com.cossacklabs.themis;

import com.cossacklabs.themis.SecureCell;

/* loaded from: classes.dex */
class SecureCellTokenProtect implements SecureCell.TokenProtect {
    private final SymmetricKey key;

    SecureCellTokenProtect(SymmetricKey symmetricKey) {
        this.key = symmetricKey;
    }

    @Override // com.cossacklabs.themis.SecureCell.TokenProtect
    public SecureCellData encrypt(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            throw new NullArgumentException("data cannot be null");
        }
        if (bArr.length == 0) {
            throw new InvalidArgumentException("data cannot be empty");
        }
        byte[][] encrypt = SecureCell.encrypt(this.key.key, bArr2, bArr, 1);
        if (encrypt == null) {
            throw new RuntimeException(new SecureCellException());
        }
        return new SecureCellData(encrypt[0], encrypt[1]);
    }

    @Override // com.cossacklabs.themis.SecureCell.TokenProtect
    public SecureCellData encrypt(byte[] bArr) {
        return encrypt(bArr, null);
    }

    @Override // com.cossacklabs.themis.SecureCell.TokenProtect
    public byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws SecureCellException {
        if (bArr == null) {
            throw new NullArgumentException("data cannot be null");
        }
        if (bArr.length == 0) {
            throw new InvalidArgumentException("data cannot be empty");
        }
        if (bArr2 == null) {
            throw new NullArgumentException("token cannot be null");
        }
        if (bArr2.length == 0) {
            throw new InvalidArgumentException("token cannot be empty");
        }
        byte[] decrypt = SecureCell.decrypt(this.key.key, bArr3, new byte[][]{bArr, bArr2}, 1);
        if (decrypt != null) {
            return decrypt;
        }
        throw new SecureCellException();
    }

    @Override // com.cossacklabs.themis.SecureCell.TokenProtect
    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws SecureCellException {
        return decrypt(bArr, bArr2, null);
    }
}
