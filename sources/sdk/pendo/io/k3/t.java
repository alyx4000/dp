package sdk.pendo.io.k3;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010$\u001a\u00020\"¢\u0006\u0004\b/\u00100J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000eH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0001H\u0016J\b\u0010\u001a\u001a\u00020\u0001H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\nH\u0016R\u0014\u0010$\u001a\u00020\"8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010#R\u0014\u0010&\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010%R\u0016\u0010)\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020\u00028Ö\u0002X\u0096\u0004¢\u0006\f\u0012\u0004\b,\u0010-\u001a\u0004\b*\u0010+¨\u00061"}, d2 = {"Lsdk/pendo/io/k3/t;", "Lsdk/pendo/io/k3/e;", "Lsdk/pendo/io/k3/d;", "source", "", "byteCount", "", "a", "Lsdk/pendo/io/k3/g;", "byteString", "", "string", "", "write", "", "offset", "Ljava/nio/ByteBuffer;", "b", "writeByte", "s", "writeShort", ContextChain.TAG_INFRA, "writeInt", "v", "g", "j", "f", "flush", "", "isOpen", "close", "Lsdk/pendo/io/k3/b0;", "d", "toString", "Lsdk/pendo/io/k3/y;", "Lsdk/pendo/io/k3/y;", "sink", "Lsdk/pendo/io/k3/d;", "bufferField", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Z", "closed", "getBuffer", "()Lokio/Buffer;", "getBuffer$annotations", "()V", "buffer", "<init>", "(Lokio/Sink;)V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class t implements e {

    /* renamed from: A, reason: from kotlin metadata */
    public boolean closed;

    /* renamed from: f, reason: from kotlin metadata */
    public final y sink;

    /* renamed from: s, reason: from kotlin metadata */
    public final d bufferField;

    public t(y sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.sink = sink;
        this.bufferField = new d();
    }

    @Override // sdk.pendo.io.k3.e
    public e a(g byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.a(byteString);
        return j();
    }

    @Override // sdk.pendo.io.k3.e
    public e b(long v) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.b(v);
        return j();
    }

    @Override // sdk.pendo.io.k3.e
    /* renamed from: c, reason: from getter */
    public d getBufferField() {
        return this.bufferField;
    }

    @Override // sdk.pendo.io.k3.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        try {
            if (this.bufferField.getSize() > 0) {
                y yVar = this.sink;
                d dVar = this.bufferField;
                yVar.a(dVar, dVar.getSize());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.sink.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // sdk.pendo.io.k3.y
    /* renamed from: d */
    public b0 getTimeout() {
        return this.sink.getTimeout();
    }

    @Override // sdk.pendo.io.k3.e
    public e f() {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long size = this.bufferField.getSize();
        if (size > 0) {
            this.sink.a(this.bufferField, size);
        }
        return this;
    }

    @Override // sdk.pendo.io.k3.e, sdk.pendo.io.k3.y, java.io.Flushable
    public void flush() {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.bufferField.getSize() > 0) {
            y yVar = this.sink;
            d dVar = this.bufferField;
            yVar.a(dVar, dVar.getSize());
        }
        this.sink.flush();
    }

    @Override // sdk.pendo.io.k3.e
    public e g(long v) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.g(v);
        return j();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // sdk.pendo.io.k3.e
    public e j() {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long o = this.bufferField.o();
        if (o > 0) {
            this.sink.a(this.bufferField, o);
        }
        return this;
    }

    public String toString() {
        return "buffer(" + this.sink + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        int write = this.bufferField.write(source);
        j();
        return write;
    }

    @Override // sdk.pendo.io.k3.e
    public e writeByte(int b) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeByte(b);
        return j();
    }

    @Override // sdk.pendo.io.k3.e
    public e writeInt(int i) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeInt(i);
        return j();
    }

    @Override // sdk.pendo.io.k3.e
    public e writeShort(int s) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.writeShort(s);
        return j();
    }

    @Override // sdk.pendo.io.k3.y
    public void a(d source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.a(source, byteCount);
        j();
    }

    @Override // sdk.pendo.io.k3.e
    public e write(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.write(source);
        return j();
    }

    @Override // sdk.pendo.io.k3.e
    public e a(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.a(string);
        return j();
    }

    @Override // sdk.pendo.io.k3.e
    public e write(byte[] source, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        this.bufferField.write(source, offset, byteCount);
        return j();
    }
}
