package com.cossacklabs.themis;

/* loaded from: classes.dex */
public abstract class KeypairGenerator {
    static native byte[][] generateKeys(int i);

    static {
        System.loadLibrary("themis_jni");
    }

    private KeypairGenerator() {
    }

    public static Keypair generateKeypair() {
        try {
            return generateKeypair(0);
        } catch (InvalidArgumentException e) {
            throw new KeyGenerationException("failed to generate key pair", e);
        }
    }

    public static Keypair generateKeypair(int i) {
        if (i != 0 && i != 1) {
            throw new InvalidArgumentException("keyType is invalid");
        }
        byte[][] generateKeys = generateKeys(i);
        if (generateKeys == null) {
            throw new KeyGenerationException("failed to generate key pair");
        }
        return new Keypair(new PrivateKey(generateKeys[0]), new PublicKey(generateKeys[1]));
    }
}
