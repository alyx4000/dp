package com.cossacklabs.themis;

/* loaded from: classes.dex */
public class Keypair {
    PrivateKey privateKey;
    PublicKey publicKey;

    public Keypair(PrivateKey privateKey, PublicKey publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }
}
