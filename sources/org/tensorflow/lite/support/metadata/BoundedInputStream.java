package org.tensorflow.lite.support.metadata;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* loaded from: classes6.dex */
final class BoundedInputStream extends InputStream {
    private final SeekableByteChannelCompat channel;
    private final long end;
    private long position;
    private final ByteBuffer singleByteBuffer = ByteBuffer.allocate(1);

    BoundedInputStream(SeekableByteChannelCompat seekableByteChannelCompat, long j, long j2) {
        Preconditions.checkArgument(j2 >= 0 && j >= 0, String.format("Invalid length of stream at offset=%d, length=%d", Long.valueOf(j), Long.valueOf(j2)));
        this.end = j2 + j;
        this.channel = seekableByteChannelCompat;
        this.position = j;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return (int) (Math.min(this.end, this.channel.size()) - this.position);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.position >= this.end) {
            return -1;
        }
        this.singleByteBuffer.rewind();
        int read = read(this.position, this.singleByteBuffer);
        if (read < 0) {
            return read;
        }
        this.position++;
        return this.singleByteBuffer.get() & UByte.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkElementIndex(i, bArr.length, "The start offset");
        Preconditions.checkElementIndex(i2, (bArr.length - i) + 1, "The maximumn number of bytes to read");
        if (i2 == 0) {
            return 0;
        }
        long j = i2;
        long j2 = this.end;
        long j3 = this.position;
        if (j > j2 - j3) {
            if (j3 >= j2) {
                return -1;
            }
            i2 = (int) (j2 - j3);
        }
        int read = read(this.position, ByteBuffer.wrap(bArr, i, i2));
        if (read > 0) {
            this.position += read;
        }
        return read;
    }

    private int read(long j, ByteBuffer byteBuffer) throws IOException {
        int read;
        synchronized (this.channel) {
            this.channel.position(j);
            read = this.channel.read(byteBuffer);
        }
        byteBuffer.flip();
        return read;
    }
}
