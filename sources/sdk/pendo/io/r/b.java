package sdk.pendo.io.r;

import java.io.FilterInputStream;
import java.io.InputStream;
import kotlin.UByte;
import org.tensorflow.lite.schema.BuiltinOptions;

/* loaded from: classes6.dex */
public final class b extends FilterInputStream {
    private static final byte[] A = {-1, -31, 0, BuiltinOptions.SubOptions, BuiltinOptions.BidirectionalSequenceLSTMOptions, BuiltinOptions.UnsortedSegmentMinOptions, BuiltinOptions.Rfft2dOptions, BuiltinOptions.CumsumOptions, 0, 0, BuiltinOptions.MirrorPadOptions, BuiltinOptions.MirrorPadOptions, 0, 0, 0, 0, 0, 8, 0, 1, 1, BuiltinOptions.SkipGramOptions, 0, 2, 0, 0, 0, 1, 0};
    private static final int f0 = 29;
    private static final int t0 = 31;
    private final byte f;
    private int s;

    public b(InputStream inputStream, int i) {
        super(inputStream);
        if (i < -1 || i > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + i);
        }
        this.f = (byte) i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int i;
        int i2 = this.s;
        int read = (i2 < 2 || i2 > (i = t0)) ? super.read() : i2 == i ? this.f : A[i2 - 2] & UByte.MAX_VALUE;
        if (read != -1) {
            this.s++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        long skip = super.skip(j);
        if (skip > 0) {
            this.s = (int) (this.s + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = this.s;
        int i5 = t0;
        if (i4 > i5) {
            i3 = super.read(bArr, i, i2);
        } else if (i4 == i5) {
            bArr[i] = this.f;
            i3 = 1;
        } else if (i4 < 2) {
            i3 = super.read(bArr, i, 2 - i4);
        } else {
            int min = Math.min(i5 - i4, i2);
            System.arraycopy(A, this.s - 2, bArr, i, min);
            i3 = min;
        }
        if (i3 > 0) {
            this.s += i3;
        }
        return i3;
    }
}
