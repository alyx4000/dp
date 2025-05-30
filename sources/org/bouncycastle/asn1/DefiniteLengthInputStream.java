package org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

/* loaded from: classes6.dex */
class DefiniteLengthInputStream extends LimitedInputStream {
    private static final byte[] EMPTY_BYTES = new byte[0];
    private final int _originalLength;
    private int _remaining;

    DefiniteLengthInputStream(InputStream inputStream, int i, int i2) {
        super(inputStream, i2);
        if (i <= 0) {
            if (i < 0) {
                throw new IllegalArgumentException("negative lengths not allowed");
            }
            setParentEofDetect(true);
        }
        this._originalLength = i;
        this._remaining = i;
    }

    int getRemaining() {
        return this._remaining;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this._remaining == 0) {
            return -1;
        }
        int read = this._in.read();
        if (read < 0) {
            throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
        }
        int i = this._remaining - 1;
        this._remaining = i;
        if (i == 0) {
            setParentEofDetect(true);
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this._remaining;
        if (i3 == 0) {
            return -1;
        }
        int read = this._in.read(bArr, i, Math.min(i2, i3));
        if (read < 0) {
            throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
        }
        int i4 = this._remaining - read;
        this._remaining = i4;
        if (i4 == 0) {
            setParentEofDetect(true);
        }
        return read;
    }

    void readAllIntoByteArray(byte[] bArr) throws IOException {
        int i = this._remaining;
        if (i != bArr.length) {
            throw new IllegalArgumentException("buffer length not right for data");
        }
        if (i == 0) {
            return;
        }
        int limit = getLimit();
        int i2 = this._remaining;
        if (i2 >= limit) {
            throw new IOException("corrupted stream - out of bounds length found: " + this._remaining + " >= " + limit);
        }
        int readFully = i2 - Streams.readFully(this._in, bArr, 0, bArr.length);
        this._remaining = readFully;
        if (readFully != 0) {
            throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
        }
        setParentEofDetect(true);
    }

    byte[] toByteArray() throws IOException {
        if (this._remaining == 0) {
            return EMPTY_BYTES;
        }
        int limit = getLimit();
        int i = this._remaining;
        if (i >= limit) {
            throw new IOException("corrupted stream - out of bounds length found: " + this._remaining + " >= " + limit);
        }
        byte[] bArr = new byte[i];
        int readFully = i - Streams.readFully(this._in, bArr, 0, i);
        this._remaining = readFully;
        if (readFully != 0) {
            throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
        }
        setParentEofDetect(true);
        return bArr;
    }
}
