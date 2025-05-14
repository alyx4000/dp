package com.cossacklabs.themis;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public class SecureCompare {
    static final Charset CHARSET;
    private long nativeCtx;

    public enum CompareResult {
        NOT_READY,
        NO_MATCH,
        MATCH
    }

    public enum ProtocolResult {
        NO_OUTPUT,
        SEND_TO_PEER
    }

    native long create();

    native void destroy();

    native int jniAppend(byte[] bArr);

    native byte[] jniBegin();

    native int jniGetResult();

    native byte[] jniProceed(byte[] bArr);

    native int scompareMatch();

    native int scompareNoMatch();

    native int scompareNotReady();

    static {
        System.loadLibrary("themis_jni");
        CHARSET = StandardCharsets.UTF_16;
    }

    public SecureCompare() {
        this.nativeCtx = 0L;
        long create = create();
        this.nativeCtx = create;
        if (0 == create) {
            throw new RuntimeException("failed to create Secure Comparator", new SecureCompareException());
        }
    }

    public SecureCompare(byte[] bArr) {
        this();
        appendSecret(bArr);
    }

    public SecureCompare(String str) {
        this(str.getBytes(CHARSET));
    }

    public void close() {
        if (0 != this.nativeCtx) {
            destroy();
        }
    }

    protected void finalize() {
        close();
    }

    public void appendSecret(byte[] bArr) {
        if (bArr == null) {
            throw new NullArgumentException("secret cannot be null");
        }
        if (bArr.length == 0) {
            throw new InvalidArgumentException("secret cannot be empty");
        }
        if (jniAppend(bArr) != 0) {
            throw new RuntimeException("failed to append secret data", new SecureCompareException());
        }
    }

    CompareResult parseResult(int i) {
        if (i == scompareNotReady()) {
            return CompareResult.NOT_READY;
        }
        if (i == scompareNoMatch()) {
            return CompareResult.NO_MATCH;
        }
        if (i == scompareMatch()) {
            return CompareResult.MATCH;
        }
        throw new RuntimeException("unexpected comparison result: " + i, new SecureCompareException());
    }

    public byte[] begin() {
        byte[] jniBegin = jniBegin();
        if (jniBegin != null) {
            return jniBegin;
        }
        throw new RuntimeException("failed to begin comparison", new SecureCompareException());
    }

    public byte[] proceed(byte[] bArr) throws SecureCompareException {
        return jniProceed(bArr);
    }

    public CompareResult getResult() {
        return parseResult(jniGetResult());
    }
}
