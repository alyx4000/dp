package com.google.crypto.tink.subtle;

import java.security.InvalidKeyException;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;
import org.tensorflow.lite.schema.BuiltinOptions;

/* loaded from: classes5.dex */
public final class X25519 {
    public static byte[] generatePrivateKey() {
        byte[] randBytes = Random.randBytes(32);
        randBytes[0] = (byte) (randBytes[0] | 7);
        byte b = (byte) (randBytes[31] & 63);
        randBytes[31] = b;
        randBytes[31] = (byte) (b | ByteCompanionObject.MIN_VALUE);
        return randBytes;
    }

    public static byte[] computeSharedSecret(byte[] privateKey, byte[] peersPublicValue) throws InvalidKeyException {
        if (privateKey.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        long[] jArr = new long[11];
        byte[] copyOf = Arrays.copyOf(privateKey, 32);
        copyOf[0] = (byte) (copyOf[0] & 248);
        byte b = (byte) (copyOf[31] & ByteCompanionObject.MAX_VALUE);
        copyOf[31] = b;
        copyOf[31] = (byte) (b | BuiltinOptions.UnpackOptions);
        Curve25519.curveMult(jArr, copyOf, peersPublicValue);
        return Field25519.contract(jArr);
    }

    public static byte[] publicFromPrivate(byte[] privateKey) throws InvalidKeyException {
        if (privateKey.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        byte[] bArr = new byte[32];
        bArr[0] = 9;
        return computeSharedSecret(privateKey, bArr);
    }

    private X25519() {
    }
}
