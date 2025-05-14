package com.cossacklabs.themis;

import com.cossacklabs.themis.SecureCell;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
class SecureCellSealWithPassphrase implements SecureCell.Seal {
    private final PassphraseBytes passphrase;

    SecureCellSealWithPassphrase(String str, Charset charset) {
        this.passphrase = new PassphraseBytes(str, charset);
    }

    SecureCellSealWithPassphrase(byte[] bArr) {
        this.passphrase = new PassphraseBytes(bArr);
    }

    @Override // com.cossacklabs.themis.SecureCell.Seal
    public byte[] encrypt(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            throw new NullArgumentException("data cannot be null");
        }
        if (bArr.length == 0) {
            throw new InvalidArgumentException("data cannot be empty");
        }
        byte[][] encrypt = SecureCell.encrypt(this.passphrase.key, bArr2, bArr, 3);
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
        byte[] decrypt = SecureCell.decrypt(this.passphrase.key, bArr2, new byte[][]{bArr, null}, 3);
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
