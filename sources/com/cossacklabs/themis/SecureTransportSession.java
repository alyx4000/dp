package com.cossacklabs.themis;

import com.cossacklabs.themis.SecureSession;

/* loaded from: classes.dex */
public class SecureTransportSession extends SecureSession {
    public SecureTransportSession(byte[] bArr, PrivateKey privateKey, ITransportSessionCallbacks iTransportSessionCallbacks) {
        super(bArr, privateKey, iTransportSessionCallbacks);
    }

    public SecureTransportSession(String str, PrivateKey privateKey, ITransportSessionCallbacks iTransportSessionCallbacks) {
        super(str, privateKey, iTransportSessionCallbacks);
    }

    public void connect() {
        ((ITransportSessionCallbacks) this.callbacks).write(generateConnectRequest());
    }

    public void write(byte[] bArr) throws SecureSessionException {
        ((ITransportSessionCallbacks) this.callbacks).write(wrap(bArr));
    }

    public byte[] read() throws SecureSessionException {
        SecureSession.UnwrapResult unwrap = unwrap(((ITransportSessionCallbacks) this.callbacks).read());
        return SecureSession.SessionDataType.USER_DATA == unwrap.getDataType() ? unwrap.getData() : new byte[0];
    }
}
