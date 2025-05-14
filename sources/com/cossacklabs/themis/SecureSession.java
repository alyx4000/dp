package com.cossacklabs.themis;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public class SecureSession {
    static final Charset CHARSET;
    protected ISessionCallbacks callbacks;
    private long sessionPtr;
    private State sessionState;

    public enum State {
        IDLE,
        NEGOTIATING,
        ESTABLISHED
    }

    static native long jniLoad(byte[] bArr);

    native long create(byte[] bArr, byte[] bArr2);

    native void destroy();

    native byte[] jniGenerateConnect();

    native boolean jniIsEstablished();

    native byte[] jniSave();

    native byte[][] jniUnwrap(byte[] bArr);

    native byte[] jniWrap(byte[] bArr);

    static {
        System.loadLibrary("themis_jni");
        CHARSET = StandardCharsets.UTF_16;
    }

    public enum SessionDataType {
        NO_DATA,
        PROTOCOL_DATA,
        USER_DATA;

        public static SessionDataType fromByte(byte b) throws SecureSessionException {
            if (b == 0) {
                return NO_DATA;
            }
            if (b == 1) {
                return PROTOCOL_DATA;
            }
            if (b == 2) {
                return USER_DATA;
            }
            throw new SecureSessionException();
        }
    }

    public class UnwrapResult {
        private byte[] data;
        private SessionDataType dataType;

        private UnwrapResult(SessionDataType sessionDataType, byte[] bArr) {
            this.dataType = sessionDataType;
            this.data = bArr;
        }

        public SessionDataType getDataType() {
            return this.dataType;
        }

        public byte[] getData() {
            return this.data;
        }
    }

    public SecureSession(byte[] bArr, PrivateKey privateKey, ISessionCallbacks iSessionCallbacks) {
        this.sessionState = State.IDLE;
        if (bArr == null) {
            throw new NullArgumentException("peer ID cannot be null");
        }
        if (bArr.length == 0) {
            throw new InvalidArgumentException("peer ID cannot be empty");
        }
        long create = create(bArr, privateKey.toByteArray());
        this.sessionPtr = create;
        if (0 == create) {
            throw new RuntimeException("failed to create Secure Session", new SecureSessionException());
        }
        this.callbacks = iSessionCallbacks;
    }

    public SecureSession(String str, PrivateKey privateKey, ISessionCallbacks iSessionCallbacks) {
        this(str.getBytes(CHARSET), privateKey, iSessionCallbacks);
    }

    private SecureSession() {
        this.sessionState = State.IDLE;
    }

    public synchronized byte[] generateConnectRequest() {
        byte[] jniGenerateConnect;
        if (0 == this.sessionPtr) {
            throw new IllegalStateException("Secure Session is closed");
        }
        jniGenerateConnect = jniGenerateConnect();
        if (jniGenerateConnect == null) {
            throw new RuntimeException("Secure Session cannot generate connection request", new SecureSessionException());
        }
        return jniGenerateConnect;
    }

    public synchronized byte[] wrap(byte[] bArr) throws SecureSessionException {
        byte[] jniWrap;
        if (0 == this.sessionPtr) {
            throw new IllegalStateException("Secure Session is closed");
        }
        if (bArr == null) {
            throw new NullArgumentException();
        }
        jniWrap = jniWrap(bArr);
        if (jniWrap == null) {
            throw new SecureSessionException("Secure Session failed to wrap data");
        }
        return jniWrap;
    }

    public synchronized UnwrapResult unwrap(byte[] bArr) throws SecureSessionException {
        if (0 == this.sessionPtr) {
            throw new IllegalStateException("Secure Session is closed");
        }
        if (bArr == null) {
            throw new NullArgumentException();
        }
        byte[][] jniUnwrap = jniUnwrap(bArr);
        if (jniUnwrap == null) {
            throw new SecureSessionException("Secure Session failed to unwrap data");
        }
        SessionDataType fromByte = SessionDataType.fromByte(jniUnwrap[0][0]);
        if (SessionDataType.NO_DATA == fromByte) {
            return new UnwrapResult(fromByte, new byte[0]);
        }
        return new UnwrapResult(fromByte, jniUnwrap[1]);
    }

    public void close() {
        if (0 != this.sessionPtr) {
            destroy();
        }
        this.sessionPtr = 0L;
    }

    protected void finalize() {
        close();
    }

    private byte[] getPublicKeyForId(byte[] bArr) {
        PublicKey publicKeyForId = this.callbacks.getPublicKeyForId(this, bArr);
        if (publicKeyForId == null) {
            return null;
        }
        return publicKeyForId.toByteArray();
    }

    private void stateChanged(int i) {
        if (i == 0) {
            this.sessionState = State.IDLE;
        } else if (i == 1) {
            this.sessionState = State.NEGOTIATING;
        } else if (i == 2) {
            this.sessionState = State.ESTABLISHED;
        }
        this.callbacks.stateChanged(this);
    }

    public synchronized boolean isEstablished() {
        if (0 == this.sessionPtr) {
            throw new IllegalStateException("Secure Session is closed");
        }
        return jniIsEstablished();
    }

    @Deprecated
    public synchronized byte[] save() {
        byte[] jniSave;
        if (0 == this.sessionPtr) {
            throw new IllegalStateException("Secure Session is closed");
        }
        jniSave = jniSave();
        if (jniSave == null) {
            throw new RuntimeException(new SecureSessionException("failed to serialize Secure Session"));
        }
        return jniSave;
    }

    @Deprecated
    public static SecureSession restore(byte[] bArr, ISessionCallbacks iSessionCallbacks) throws SecureSessionException {
        SecureSession secureSession = new SecureSession();
        long jniLoad = jniLoad(bArr);
        secureSession.sessionPtr = jniLoad;
        if (0 == jniLoad) {
            throw new SecureSessionException("failed to restore Secure Session");
        }
        secureSession.callbacks = iSessionCallbacks;
        return secureSession;
    }

    public State getState() {
        return this.sessionState;
    }
}
