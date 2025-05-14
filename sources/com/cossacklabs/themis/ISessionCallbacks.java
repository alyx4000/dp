package com.cossacklabs.themis;

/* loaded from: classes.dex */
public interface ISessionCallbacks {
    PublicKey getPublicKeyForId(SecureSession secureSession, byte[] bArr);

    void stateChanged(SecureSession secureSession);
}
