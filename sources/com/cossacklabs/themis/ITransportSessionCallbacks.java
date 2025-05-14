package com.cossacklabs.themis;

/* loaded from: classes.dex */
public interface ITransportSessionCallbacks extends ISessionCallbacks {
    byte[] read();

    void write(byte[] bArr);
}
