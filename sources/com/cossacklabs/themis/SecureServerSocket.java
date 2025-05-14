package com.cossacklabs.themis;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/* loaded from: classes.dex */
public class SecureServerSocket extends ServerSocket {
    ISessionCallbacks callbacks;
    byte[] id;
    PrivateKey signPrivateKey;

    public SecureServerSocket(int i, byte[] bArr, PrivateKey privateKey, ISessionCallbacks iSessionCallbacks) throws IOException {
        super(i);
        this.id = bArr;
        this.signPrivateKey = privateKey;
        this.callbacks = iSessionCallbacks;
    }

    @Override // java.net.ServerSocket
    public Socket accept() throws IOException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
        if (!isBound()) {
            throw new SocketException("Socket is not bound");
        }
        SecureSocket secureSocket = new SecureSocket(this.id, this.signPrivateKey, this.callbacks);
        try {
            implAccept(secureSocket);
            secureSocket.runServerProtocol();
            return secureSocket;
        } catch (IOException e) {
            secureSocket.close();
            throw e;
        }
    }
}
