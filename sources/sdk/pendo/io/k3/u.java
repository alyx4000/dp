package sdk.pendo.io.k3;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.exifinterface.media.ExifInterface;
import com.extole.android.sdk.impl.http.HttpRequest;
import com.facebook.common.callercontext.ContextChain;
import com.iterable.iterableapi.IterableConstants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00100\u001a\u00020.¢\u0006\u0004\b<\u0010=J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0016H\u0016J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0019H\u0016J\u0010\u0010\u000b\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\u0018\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016J\b\u0010\u000b\u001a\u00020\u0011H\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\u0010\u0010%\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\fH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020(H\u0016J\b\u0010*\u001a\u00020\u0007H\u0016J\b\u0010+\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u001cH\u0016R\u0014\u00100\u001a\u00020.8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010/R\u0014\u00103\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001b\u0010;\u001a\u00020\u00028Ö\u0002X\u0096\u0004¢\u0006\f\u0012\u0004\b9\u0010:\u001a\u0004\b7\u00108¨\u0006>"}, d2 = {"Lsdk/pendo/io/k3/u;", "Lsdk/pendo/io/k3/f;", "Lsdk/pendo/io/k3/d;", "sink", "", "byteCount", "c", "", ContextChain.TAG_INFRA, "", "f", "a", "", "readByte", "Lsdk/pendo/io/k3/g;", "Lsdk/pendo/io/k3/r;", "options", "", "", "h", "d", "readFully", "Ljava/nio/ByteBuffer;", IterableConstants.ITERABLE_IN_APP_READ, "b", "Lsdk/pendo/io/k3/y;", "Ljava/nio/charset/Charset;", HttpRequest.PARAM_CHARSET, "", "g", "limit", "e", "", "readShort", "readInt", "readLong", "k", "skip", "fromIndex", "toIndex", "Ljava/io/InputStream;", "l", "isOpen", "close", "Lsdk/pendo/io/k3/b0;", "toString", "Lsdk/pendo/io/k3/a0;", "Lsdk/pendo/io/k3/a0;", "source", "s", "Lsdk/pendo/io/k3/d;", "bufferField", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Z", "closed", "getBuffer", "()Lokio/Buffer;", "getBuffer$annotations", "()V", "buffer", "<init>", "(Lokio/Source;)V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class u implements f {

    /* renamed from: A, reason: from kotlin metadata */
    public boolean closed;

    /* renamed from: f, reason: from kotlin metadata */
    public final a0 source;

    /* renamed from: s, reason: from kotlin metadata */
    public final d bufferField;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"sdk/pendo/io/k3/u$a", "Ljava/io/InputStream;", "", IterableConstants.ITERABLE_IN_APP_READ, "", "data", "offset", "byteCount", "available", "", "close", "", "toString", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
    public static final class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() {
            u uVar = u.this;
            if (uVar.closed) {
                throw new IOException("closed");
            }
            return (int) Math.min(uVar.bufferField.getSize(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            u.this.close();
        }

        @Override // java.io.InputStream
        public int read() {
            u uVar = u.this;
            if (uVar.closed) {
                throw new IOException("closed");
            }
            if (uVar.bufferField.getSize() == 0) {
                u uVar2 = u.this;
                if (uVar2.source.c(uVar2.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
            }
            return u.this.bufferField.readByte() & UByte.MAX_VALUE;
        }

        public String toString() {
            return u.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] data, int offset, int byteCount) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (u.this.closed) {
                throw new IOException("closed");
            }
            b.a(data.length, offset, byteCount);
            if (u.this.bufferField.getSize() == 0) {
                u uVar = u.this;
                if (uVar.source.c(uVar.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
            }
            return u.this.bufferField.read(data, offset, byteCount);
        }
    }

    public u(a0 source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.bufferField = new d();
    }

    public long a(byte b) {
        return a(b, 0L, Long.MAX_VALUE);
    }

    @Override // sdk.pendo.io.k3.f
    public void b(d sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            f(byteCount);
            this.bufferField.b(sink, byteCount);
        } catch (EOFException e) {
            sink.a((a0) this.bufferField);
            throw e;
        }
    }

    @Override // sdk.pendo.io.k3.f, sdk.pendo.io.k3.e
    /* renamed from: c, reason: from getter */
    public d getBufferField() {
        return this.bufferField;
    }

    @Override // sdk.pendo.io.k3.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.bufferField.m();
    }

    @Override // sdk.pendo.io.k3.f
    public byte[] d(long byteCount) {
        f(byteCount);
        return this.bufferField.d(byteCount);
    }

    @Override // sdk.pendo.io.k3.f
    public String e(long limit) {
        if (!(limit >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + limit).toString());
        }
        long j = limit == Long.MAX_VALUE ? Long.MAX_VALUE : limit + 1;
        long a2 = a((byte) 10, 0L, j);
        if (a2 != -1) {
            return sdk.pendo.io.l3.a.a(this.bufferField, a2);
        }
        if (j < Long.MAX_VALUE && a(j) && this.bufferField.h(j - 1) == 13 && a(1 + j) && this.bufferField.h(j) == 10) {
            return sdk.pendo.io.l3.a.a(this.bufferField, j);
        }
        d dVar = new d();
        d dVar2 = this.bufferField;
        dVar2.a(dVar, 0L, Math.min(32, dVar2.getSize()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.getSize(), limit) + " content=" + dVar.t().h() + Typography.ellipsis);
    }

    @Override // sdk.pendo.io.k3.f
    public void f(long byteCount) {
        if (!a(byteCount)) {
            throw new EOFException();
        }
    }

    @Override // sdk.pendo.io.k3.f
    public String g() {
        return e(Long.MAX_VALUE);
    }

    @Override // sdk.pendo.io.k3.f
    public byte[] h() {
        this.bufferField.a(this.source);
        return this.bufferField.h();
    }

    @Override // sdk.pendo.io.k3.f
    public boolean i() {
        if (!this.closed) {
            return this.bufferField.i() && this.source.c(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        if (r0 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        r1 = new java.lang.StringBuilder("Expected leading [0-9a-fA-F] character but was 0x");
        r2 = java.lang.Integer.toString(r2, kotlin.text.CharsKt.checkRadix(kotlin.text.CharsKt.checkRadix(16)));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "toString(this, checkRadix(radix))");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
    
        throw new java.lang.NumberFormatException(r1.append(r2).toString());
     */
    @Override // sdk.pendo.io.k3.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long k() {
        /*
            r5 = this;
            r0 = 1
            r5.f(r0)
            r0 = 0
        L6:
            int r1 = r0 + 1
            long r2 = (long) r1
            boolean r2 = r5.a(r2)
            if (r2 == 0) goto L5c
            sdk.pendo.io.k3.d r2 = r5.bufferField
            long r3 = (long) r0
            byte r2 = r2.h(r3)
            r3 = 48
            if (r2 < r3) goto L1e
            r3 = 57
            if (r2 <= r3) goto L2f
        L1e:
            r3 = 97
            if (r2 < r3) goto L26
            r3 = 102(0x66, float:1.43E-43)
            if (r2 <= r3) goto L2f
        L26:
            r3 = 65
            if (r2 < r3) goto L31
            r3 = 70
            if (r2 <= r3) goto L2f
            goto L31
        L2f:
            r0 = r1
            goto L6
        L31:
            if (r0 == 0) goto L34
            goto L5c
        L34:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.<init>(r3)
            r3 = 16
            int r3 = kotlin.text.CharsKt.checkRadix(r3)
            int r3 = kotlin.text.CharsKt.checkRadix(r3)
            java.lang.String r2 = java.lang.Integer.toString(r2, r3)
            java.lang.String r3 = "toString(this, checkRadix(radix))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L5c:
            sdk.pendo.io.k3.d r0 = r5.bufferField
            long r0 = r0.k()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.k3.u.k():long");
    }

    @Override // sdk.pendo.io.k3.f
    public InputStream l() {
        return new a();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (this.bufferField.getSize() == 0 && this.source.c(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.bufferField.read(sink);
    }

    @Override // sdk.pendo.io.k3.f
    public byte readByte() {
        f(1L);
        return this.bufferField.readByte();
    }

    @Override // sdk.pendo.io.k3.f
    public void readFully(byte[] sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            f(sink.length);
            this.bufferField.readFully(sink);
        } catch (EOFException e) {
            int i = 0;
            while (this.bufferField.getSize() > 0) {
                d dVar = this.bufferField;
                int read = dVar.read(sink, i, (int) dVar.getSize());
                if (read == -1) {
                    throw new AssertionError();
                }
                i += read;
            }
            throw e;
        }
    }

    @Override // sdk.pendo.io.k3.f
    public int readInt() {
        f(4L);
        return this.bufferField.readInt();
    }

    @Override // sdk.pendo.io.k3.f
    public long readLong() {
        f(8L);
        return this.bufferField.readLong();
    }

    @Override // sdk.pendo.io.k3.f
    public short readShort() {
        f(2L);
        return this.bufferField.readShort();
    }

    @Override // sdk.pendo.io.k3.f
    public void skip(long byteCount) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (byteCount > 0) {
            if (this.bufferField.getSize() == 0 && this.source.c(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long min = Math.min(byteCount, this.bufferField.getSize());
            this.bufferField.skip(min);
            byteCount -= min;
        }
    }

    public String toString() {
        return "buffer(" + this.source + ')';
    }

    public long a(byte b, long fromIndex, long toIndex) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= fromIndex && fromIndex <= toIndex)) {
            throw new IllegalArgumentException(("fromIndex=" + fromIndex + " toIndex=" + toIndex).toString());
        }
        while (fromIndex < toIndex) {
            long a2 = this.bufferField.a(b, fromIndex, toIndex);
            if (a2 != -1) {
                return a2;
            }
            long size = this.bufferField.getSize();
            if (size >= toIndex || this.source.c(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return -1L;
            }
            fromIndex = Math.max(fromIndex, size);
        }
        return -1L;
    }

    public short b() {
        f(2L);
        return this.bufferField.v();
    }

    @Override // sdk.pendo.io.k3.a0
    public long c(d sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.bufferField.getSize() == 0 && this.source.c(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1L;
        }
        return this.bufferField.c(sink, Math.min(byteCount, this.bufferField.getSize()));
    }

    @Override // sdk.pendo.io.k3.a0
    /* renamed from: d */
    public b0 getTimeout() {
        return this.source.getTimeout();
    }

    @Override // sdk.pendo.io.k3.f
    public long a(y sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j = 0;
        while (this.source.c(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
            long o = this.bufferField.o();
            if (o > 0) {
                j += o;
                sink.a(this.bufferField, o);
            }
        }
        if (this.bufferField.getSize() <= 0) {
            return j;
        }
        long size = j + this.bufferField.getSize();
        d dVar = this.bufferField;
        sink.a(dVar, dVar.getSize());
        return size;
    }

    @Override // sdk.pendo.io.k3.f
    public g c(long byteCount) {
        f(byteCount);
        return this.bufferField.c(byteCount);
    }

    public int a() {
        f(4L);
        return this.bufferField.u();
    }

    @Override // sdk.pendo.io.k3.f
    public String a(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        this.bufferField.a(this.source);
        return this.bufferField.a(charset);
    }

    @Override // sdk.pendo.io.k3.f
    public boolean a(long byteCount) {
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (this.bufferField.getSize() < byteCount) {
            if (this.source.c(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // sdk.pendo.io.k3.f
    public int a(r options) {
        Intrinsics.checkNotNullParameter(options, "options");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            int a2 = sdk.pendo.io.l3.a.a(this.bufferField, options, true);
            if (a2 != -2) {
                if (a2 != -1) {
                    this.bufferField.skip(options.getByteStrings()[a2].l());
                    return a2;
                }
            } else if (this.source.c(this.bufferField, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                break;
            }
        }
        return -1;
    }
}
