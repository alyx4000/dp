package com.cossacklabs.themis;

/* loaded from: classes.dex */
public class SecureMessage {
    static final int SECURE_MESSAGE_DECRYPT = 2;
    static final int SECURE_MESSAGE_ENCRYPT = 1;
    static final int SECURE_MESSAGE_SIGN = 3;
    static final int SECURE_MESSAGE_VERIFY = 4;
    PublicKey peerPublicKey;
    PrivateKey privateKey;

    static native byte[] process(byte[] bArr, byte[] bArr2, byte[] bArr3, int i);

    static {
        System.loadLibrary("themis_jni");
    }

    public SecureMessage(PrivateKey privateKey) {
        if (privateKey == null) {
            throw new NullArgumentException("Private key was not provided");
        }
        this.privateKey = privateKey;
    }

    public SecureMessage(PublicKey publicKey) {
        if (publicKey == null) {
            throw new NullArgumentException("Peer public key was not provided");
        }
        this.peerPublicKey = publicKey;
    }

    public SecureMessage(PrivateKey privateKey, PublicKey publicKey) {
        if (privateKey == null) {
            throw new NullArgumentException("Private key was not provided");
        }
        if (publicKey == null) {
            throw new NullArgumentException("Peer public key was not provided");
        }
        this.privateKey = privateKey;
        this.peerPublicKey = publicKey;
    }

    public byte[] wrap(byte[] bArr, PublicKey publicKey) throws SecureMessageWrapException {
        if (publicKey == null) {
            throw new NullArgumentException("Peer public key was not provided");
        }
        if (bArr == null) {
            throw new NullArgumentException("No message was provided");
        }
        byte[] process = process(this.privateKey.toByteArray(), publicKey.toByteArray(), bArr, 1);
        if (process != null) {
            return process;
        }
        throw new SecureMessageWrapException();
    }

    public byte[] wrap(byte[] bArr) throws SecureMessageWrapException {
        return wrap(bArr, this.peerPublicKey);
    }

    public byte[] unwrap(byte[] bArr, PublicKey publicKey) throws SecureMessageWrapException {
        if (publicKey == null) {
            throw new NullArgumentException("Peer public key was not provided");
        }
        if (bArr == null) {
            throw new NullArgumentException("No message was provided");
        }
        byte[] process = process(this.privateKey.toByteArray(), publicKey.toByteArray(), bArr, 2);
        if (process != null) {
            return process;
        }
        throw new SecureMessageWrapException();
    }

    public byte[] unwrap(byte[] bArr) throws SecureMessageWrapException {
        return unwrap(bArr, this.peerPublicKey);
    }

    public byte[] sign(byte[] bArr) throws SecureMessageWrapException {
        PrivateKey privateKey = this.privateKey;
        if (privateKey == null) {
            throw new NullArgumentException("Private key was not provided");
        }
        if (bArr == null) {
            throw new NullArgumentException("No message was provided");
        }
        byte[] process = process(privateKey.toByteArray(), null, bArr, 3);
        if (process != null) {
            return process;
        }
        throw new SecureMessageWrapException();
    }

    public byte[] verify(byte[] bArr, PublicKey publicKey) throws SecureMessageWrapException {
        if (publicKey == null) {
            throw new NullArgumentException("Peer public key was not provided");
        }
        if (bArr == null) {
            throw new NullArgumentException("No message was provided");
        }
        byte[] process = process(null, publicKey.toByteArray(), bArr, 4);
        if (process != null) {
            return process;
        }
        throw new SecureMessageWrapException();
    }

    public byte[] verify(byte[] bArr) throws SecureMessageWrapException {
        return verify(bArr, this.peerPublicKey);
    }
}
