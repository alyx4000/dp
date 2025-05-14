package com.cossacklabs.themis;

import androidx.core.internal.view.SupportMenu;
import com.cossacklabs.themis.SecureSession;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import org.tensorflow.lite.schema.BuiltinOptions;

/* loaded from: classes.dex */
public class SecureSocket extends Socket {
    static final byte[] HDR_TAG = {BuiltinOptions.CosOptions, BuiltinOptions.GatherNdOptions, BuiltinOptions.UniqueOptions, BuiltinOptions.MirrorPadOptions};
    ISessionCallbacks callbacks;
    byte[] id;
    InputStream inStream;
    OutputStream outStream;
    private SecureInputStream secureInputStream;
    private SecureOutputStream secureOutputStream;
    SecureSession session;
    PrivateKey signPrivateKey;

    public SecureSocket(byte[] bArr, PrivateKey privateKey, ISessionCallbacks iSessionCallbacks) {
        this.id = bArr;
        this.signPrivateKey = privateKey;
        this.callbacks = iSessionCallbacks;
    }

    public SecureSocket(InetAddress inetAddress, int i, byte[] bArr, PrivateKey privateKey, ISessionCallbacks iSessionCallbacks) throws IOException {
        this.id = bArr;
        this.signPrivateKey = privateKey;
        this.callbacks = iSessionCallbacks;
        connect(new InetSocketAddress(inetAddress, i));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0061, code lost:
    
        r0 = r7.session.unwrap(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        if (com.cossacklabs.themis.SecureSession.SessionDataType.PROTOCOL_DATA != r0.getDataType()) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
    
        r2.writeInt(r0.getData().length | androidx.core.internal.view.SupportMenu.CATEGORY_MASK);
        r2.write(r0.getData());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void runClientProtocol() throws java.io.IOException {
        /*
            r7 = this;
            java.io.InputStream r0 = super.getInputStream()
            r7.inStream = r0
            java.io.OutputStream r0 = super.getOutputStream()
            r7.outStream = r0
            com.cossacklabs.themis.SecureSession r0 = new com.cossacklabs.themis.SecureSession     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            byte[] r1 = r7.id     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            com.cossacklabs.themis.PrivateKey r2 = r7.signPrivateKey     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            com.cossacklabs.themis.ISessionCallbacks r3 = r7.callbacks     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            r0.<init>(r1, r2, r3)     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            r7.session = r0     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            byte[] r0 = r0.generateConnectRequest()     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            java.io.DataInputStream r1 = new java.io.DataInputStream     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            java.io.InputStream r2 = r7.inStream     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            r1.<init>(r2)     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            java.io.OutputStream r3 = r7.outStream     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            r2.<init>(r3)     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            int r3 = r0.length     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            r4 = -65536(0xffffffffffff0000, float:NaN)
            r3 = r3 | r4
            r2.writeInt(r3)     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            r2.write(r0)     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
        L35:
            int r0 = r1.readInt()     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            r3 = r0 & r4
            if (r4 != r3) goto L90
            r3 = 65535(0xffff, float:9.1834E-41)
            r0 = r0 & r3
            r3 = 12
            if (r0 < r3) goto L88
            byte[] r3 = new byte[r0]     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            r5 = 0
            r1.readFully(r3, r5, r0)     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
        L4b:
            byte[] r0 = com.cossacklabs.themis.SecureSocket.HDR_TAG     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            int r6 = r0.length     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            if (r5 >= r6) goto L61
            r6 = r3[r5]     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            r0 = r0[r5]     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            if (r6 != r0) goto L59
            int r5 = r5 + 1
            goto L4b
        L59:
            java.io.IOException r0 = new java.io.IOException     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            java.lang.String r1 = "wrong protocol data3"
            r0.<init>(r1)     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            throw r0     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
        L61:
            com.cossacklabs.themis.SecureSession r0 = r7.session     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            com.cossacklabs.themis.SecureSession$UnwrapResult r0 = r0.unwrap(r3)     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            com.cossacklabs.themis.SecureSession$SessionDataType r3 = com.cossacklabs.themis.SecureSession.SessionDataType.PROTOCOL_DATA     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            com.cossacklabs.themis.SecureSession$SessionDataType r5 = r0.getDataType()     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            if (r3 != r5) goto L7f
            byte[] r3 = r0.getData()     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            int r3 = r3.length     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            r3 = r3 | r4
            r2.writeInt(r3)     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            byte[] r0 = r0.getData()     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            r2.write(r0)     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
        L7f:
            com.cossacklabs.themis.SecureSession r0 = r7.session     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            boolean r0 = r0.isEstablished()     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            if (r0 == 0) goto L35
            return
        L88:
            java.io.IOException r0 = new java.io.IOException     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            java.lang.String r1 = "wrong protocol data4"
            r0.<init>(r1)     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            throw r0     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
        L90:
            java.io.IOException r0 = new java.io.IOException     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            java.lang.String r1 = "wrong protocol data"
            r0.<init>(r1)     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
            throw r0     // Catch: com.cossacklabs.themis.NullArgumentException -> L98 com.cossacklabs.themis.SecureSessionException -> L9a
        L98:
            r0 = move-exception
            goto L9b
        L9a:
            r0 = move-exception
        L9b:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cossacklabs.themis.SecureSocket.runClientProtocol():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
    
        r2 = r7.session.unwrap(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
    
        if (com.cossacklabs.themis.SecureSession.SessionDataType.PROTOCOL_DATA != r2.getDataType()) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
    
        r1.writeInt((-65536) | r2.getData().length);
        r1.write(r2.getData());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void runServerProtocol() throws java.io.IOException {
        /*
            r7 = this;
            java.io.InputStream r0 = super.getInputStream()
            r7.inStream = r0
            java.io.OutputStream r0 = super.getOutputStream()
            r7.outStream = r0
            com.cossacklabs.themis.SecureSession r0 = new com.cossacklabs.themis.SecureSession     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            byte[] r1 = r7.id     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            com.cossacklabs.themis.PrivateKey r2 = r7.signPrivateKey     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            com.cossacklabs.themis.ISessionCallbacks r3 = r7.callbacks     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            r0.<init>(r1, r2, r3)     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            r7.session = r0     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            java.io.DataInputStream r0 = new java.io.DataInputStream     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            java.io.InputStream r1 = r7.inStream     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            r0.<init>(r1)     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            java.io.OutputStream r2 = r7.outStream     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            r1.<init>(r2)     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
        L27:
            int r2 = r0.readInt()     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            r3 = -65536(0xffffffffffff0000, float:NaN)
            r4 = r2 & r3
            if (r3 != r4) goto L84
            r4 = 65535(0xffff, float:9.1834E-41)
            r2 = r2 & r4
            r4 = 12
            if (r2 < r4) goto L7c
            byte[] r4 = new byte[r2]     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            r5 = 0
            r0.readFully(r4, r5, r2)     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
        L3f:
            byte[] r2 = com.cossacklabs.themis.SecureSocket.HDR_TAG     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            int r6 = r2.length     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            if (r5 >= r6) goto L55
            r6 = r4[r5]     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            r2 = r2[r5]     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            if (r6 != r2) goto L4d
            int r5 = r5 + 1
            goto L3f
        L4d:
            java.io.IOException r0 = new java.io.IOException     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            java.lang.String r1 = "wrong protocol data3"
            r0.<init>(r1)     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            throw r0     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
        L55:
            com.cossacklabs.themis.SecureSession r2 = r7.session     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            com.cossacklabs.themis.SecureSession$UnwrapResult r2 = r2.unwrap(r4)     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            com.cossacklabs.themis.SecureSession$SessionDataType r4 = com.cossacklabs.themis.SecureSession.SessionDataType.PROTOCOL_DATA     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            com.cossacklabs.themis.SecureSession$SessionDataType r5 = r2.getDataType()     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            if (r4 != r5) goto L73
            byte[] r4 = r2.getData()     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            int r4 = r4.length     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            r3 = r3 | r4
            r1.writeInt(r3)     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            byte[] r2 = r2.getData()     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            r1.write(r2)     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
        L73:
            com.cossacklabs.themis.SecureSession r2 = r7.session     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            boolean r2 = r2.isEstablished()     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            if (r2 == 0) goto L27
            return
        L7c:
            java.io.IOException r0 = new java.io.IOException     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            java.lang.String r1 = "wrong protocol data4"
            r0.<init>(r1)     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            throw r0     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
        L84:
            java.io.IOException r0 = new java.io.IOException     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            java.lang.String r1 = "wrong protocol data"
            r0.<init>(r1)     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
            throw r0     // Catch: com.cossacklabs.themis.NullArgumentException -> L8c com.cossacklabs.themis.SecureSessionException -> L8e
        L8c:
            r0 = move-exception
            goto L8f
        L8e:
            r0 = move-exception
        L8f:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cossacklabs.themis.SecureSocket.runServerProtocol():void");
    }

    @Override // java.net.Socket
    public void connect(SocketAddress socketAddress, int i) throws IOException {
        super.connect(socketAddress, i);
        runClientProtocol();
    }

    @Override // java.net.Socket
    public void connect(SocketAddress socketAddress) throws IOException {
        connect(socketAddress, 0);
    }

    @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        SecureSession secureSession = this.session;
        if (secureSession != null) {
            secureSession.close();
        }
        super.close();
    }

    @Override // java.net.Socket
    public OutputStream getOutputStream() throws IOException {
        if (this.secureOutputStream == null) {
            synchronized (this) {
                if (this.secureOutputStream == null) {
                    this.secureOutputStream = new SecureOutputStream(this.outStream, this.session);
                }
            }
        }
        return this.secureOutputStream;
    }

    private class SecureOutputStream extends FilterOutputStream {
        public SecureOutputStream(OutputStream outputStream, SecureSession secureSession) {
            super(new DataOutputStream(outputStream));
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            try {
                byte[] wrap = SecureSocket.this.session.wrap(bArr2);
                ((DataOutputStream) this.out).writeInt(wrap.length | SupportMenu.CATEGORY_MASK);
                this.out.write(wrap);
            } catch (NullArgumentException | SecureSessionException e) {
                throw new IOException(e);
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            write(new byte[]{(byte) (i & 255)});
        }
    }

    @Override // java.net.Socket
    public InputStream getInputStream() {
        if (this.secureInputStream == null) {
            synchronized (this) {
                if (this.secureInputStream == null) {
                    this.secureInputStream = new SecureInputStream(this.inStream, this.session);
                }
            }
        }
        return this.secureInputStream;
    }

    private class SecureInputStream extends FilterInputStream {
        ByteArrayInputStream bufferInputStream;

        protected SecureInputStream(InputStream inputStream, SecureSession secureSession) {
            super(new DataInputStream(inputStream));
            this.bufferInputStream = new ByteArrayInputStream(new byte[0]);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            byte[] bArr = new byte[1];
            if (1 == read(bArr)) {
                return bArr[0];
            }
            throw new IOException();
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            synchronized (this.in) {
                if (this.bufferInputStream.available() > 0) {
                    return this.bufferInputStream.read(bArr, i, i2);
                }
                DataInputStream dataInputStream = (DataInputStream) this.in;
                int readInt = dataInputStream.readInt();
                if (-65536 != (readInt & SupportMenu.CATEGORY_MASK)) {
                    throw new IOException("wrong protocol data");
                }
                byte[] bArr2 = new byte[readInt & 65535];
                dataInputStream.readFully(bArr2);
                try {
                    SecureSession.UnwrapResult unwrap = SecureSocket.this.session.unwrap(bArr2);
                    if (SecureSession.SessionDataType.USER_DATA != unwrap.getDataType()) {
                        throw new IOException("wrong protocol data");
                    }
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(unwrap.getData());
                    this.bufferInputStream = byteArrayInputStream;
                    return byteArrayInputStream.read(bArr, i, i2);
                } catch (NullArgumentException | SecureSessionException e) {
                    throw new IOException(e);
                }
            }
        }
    }
}
