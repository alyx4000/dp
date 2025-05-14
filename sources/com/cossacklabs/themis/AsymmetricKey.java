package com.cossacklabs.themis;

/* loaded from: classes.dex */
public abstract class AsymmetricKey extends KeyBytes {
    public static final int KEYTYPE_EC = 0;
    public static final int KEYTYPE_RSA = 1;

    @Override // com.cossacklabs.themis.KeyBytes, com.cossacklabs.themis.IKey
    public /* bridge */ /* synthetic */ byte[] toByteArray() {
        return super.toByteArray();
    }

    public AsymmetricKey(byte[] bArr) {
        super(bArr);
    }
}
