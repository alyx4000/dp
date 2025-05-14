package com.cossacklabs.themis;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public class SecureCell {
    static final Charset CHARSET;

    @Deprecated
    public static final int MODE_CONTEXT_IMPRINT = 2;

    @Deprecated
    public static final int MODE_SEAL = 0;
    static final int MODE_SEAL_PASSPHRASE = 3;

    @Deprecated
    public static final int MODE_TOKEN_PROTECT = 1;
    byte[] key;
    int mode;

    public interface ContextImprint {
        byte[] decrypt(byte[] bArr, byte[] bArr2);

        byte[] encrypt(byte[] bArr, byte[] bArr2);
    }

    public interface Seal {
        byte[] decrypt(byte[] bArr) throws SecureCellException;

        byte[] decrypt(byte[] bArr, byte[] bArr2) throws SecureCellException;

        byte[] encrypt(byte[] bArr);

        byte[] encrypt(byte[] bArr, byte[] bArr2);
    }

    public interface TokenProtect {
        byte[] decrypt(byte[] bArr, byte[] bArr2) throws SecureCellException;

        byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws SecureCellException;

        SecureCellData encrypt(byte[] bArr);

        SecureCellData encrypt(byte[] bArr, byte[] bArr2);
    }

    static native byte[] decrypt(byte[] bArr, byte[] bArr2, byte[][] bArr3, int i);

    static native byte[][] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, int i);

    static {
        System.loadLibrary("themis_jni");
        CHARSET = StandardCharsets.UTF_16;
    }

    public static Seal SealWithKey(SymmetricKey symmetricKey) {
        if (symmetricKey == null) {
            throw new NullArgumentException("key cannot be null");
        }
        return new SecureCellSeal(symmetricKey);
    }

    public static Seal SealWithKey(byte[] bArr) {
        return new SecureCellSeal(new SymmetricKey(bArr));
    }

    public static Seal SealWithPassphrase(String str) {
        return new SecureCellSealWithPassphrase(str, StandardCharsets.UTF_8);
    }

    public static Seal SealWithPassphrase(String str, Charset charset) {
        return new SecureCellSealWithPassphrase(str, charset);
    }

    public static Seal SealWithPassphrase(byte[] bArr) {
        return new SecureCellSealWithPassphrase(bArr);
    }

    public static TokenProtect TokenProtectWithKey(SymmetricKey symmetricKey) {
        if (symmetricKey == null) {
            throw new NullArgumentException("key cannot be null");
        }
        return new SecureCellTokenProtect(symmetricKey);
    }

    public static TokenProtect TokenProtectWithKey(byte[] bArr) {
        return new SecureCellTokenProtect(new SymmetricKey(bArr));
    }

    public static ContextImprint ContextImprintWithKey(SymmetricKey symmetricKey) {
        if (symmetricKey == null) {
            throw new NullArgumentException("key cannot be null");
        }
        return new SecureCellContextImprint(symmetricKey);
    }

    public static ContextImprint ContextImprintWithKey(byte[] bArr) {
        return new SecureCellContextImprint(new SymmetricKey(bArr));
    }

    @Deprecated
    public SecureCell(int i) {
        this.mode = 0;
        if (i < 0 || i > 2) {
            throw new InvalidArgumentException("invalid mode");
        }
        this.mode = i;
    }

    @Deprecated
    public SecureCell(byte[] bArr) {
        this.mode = 0;
        this.key = bArr;
    }

    @Deprecated
    public SecureCell(byte[] bArr, int i) {
        this(i);
        this.key = bArr;
    }

    @Deprecated
    public SecureCell(String str) {
        this(str.getBytes(CHARSET));
    }

    @Deprecated
    public SecureCell(String str, int i) {
        this(i);
        this.key = str.getBytes(CHARSET);
    }

    static SecureCellData protect(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) throws SecureCellException {
        if (bArr == null) {
            throw new NullArgumentException("Master key was not provided");
        }
        if (bArr3 == null) {
            throw new NullArgumentException("Data was not provided");
        }
        if (2 == i && bArr2 == null) {
            throw new NullArgumentException("Context is mandatory for context imprint mode");
        }
        byte[][] encrypt = encrypt(bArr, bArr2, bArr3, i);
        if (encrypt == null) {
            throw new SecureCellException();
        }
        return new SecureCellData(encrypt[0], encrypt[1]);
    }

    static byte[] unprotect(byte[] bArr, byte[] bArr2, SecureCellData secureCellData, int i) throws SecureCellException {
        if (bArr == null) {
            throw new NullArgumentException("Master key was not provided");
        }
        if (secureCellData == null) {
            throw new NullArgumentException("Protected data was not provided");
        }
        if (2 == i && bArr2 == null) {
            throw new NullArgumentException("Context is mandatory for context imprint mode");
        }
        if (secureCellData.getProtectedData() == null) {
            throw new InvalidArgumentException("protectedData");
        }
        if (1 == i && secureCellData.getAdditionalData() == null) {
            throw new InvalidArgumentException("additionalData");
        }
        byte[] decrypt = decrypt(bArr, bArr2, new byte[][]{secureCellData.getProtectedData(), secureCellData.getAdditionalData()}, i);
        if (decrypt != null) {
            return decrypt;
        }
        throw new SecureCellException();
    }

    @Deprecated
    public SecureCellData protect(byte[] bArr, byte[] bArr2, byte[] bArr3) throws SecureCellException {
        return protect(bArr, bArr2, bArr3, this.mode);
    }

    @Deprecated
    public SecureCellData protect(byte[] bArr, byte[] bArr2) throws SecureCellException {
        return protect(this.key, bArr, bArr2);
    }

    @Deprecated
    public SecureCellData protect(String str, String str2, byte[] bArr) throws SecureCellException {
        Charset charset = CHARSET;
        return protect(str.getBytes(charset), str2.getBytes(charset), bArr);
    }

    @Deprecated
    public SecureCellData protect(String str, byte[] bArr) throws SecureCellException {
        return protect(this.key, str.getBytes(CHARSET), bArr);
    }

    @Deprecated
    public byte[] unprotect(byte[] bArr, byte[] bArr2, SecureCellData secureCellData) throws SecureCellException {
        return unprotect(bArr, bArr2, secureCellData, this.mode);
    }

    @Deprecated
    public byte[] unprotect(byte[] bArr, SecureCellData secureCellData) throws SecureCellException {
        return unprotect(this.key, bArr, secureCellData);
    }

    @Deprecated
    public byte[] unprotect(String str, String str2, SecureCellData secureCellData) throws SecureCellException {
        Charset charset = CHARSET;
        return unprotect(str.getBytes(charset), str2.getBytes(charset), secureCellData);
    }

    @Deprecated
    public byte[] unprotect(String str, SecureCellData secureCellData) throws SecureCellException {
        return unprotect(this.key, str.getBytes(CHARSET), secureCellData);
    }
}
