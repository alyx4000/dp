package sdk.pendo.io.k3;

import androidx.exifinterface.media.ExifInterface;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0001¢\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J \u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lsdk/pendo/io/k3/l;", "Lsdk/pendo/io/k3/a0;", "", "a", "b", "Lsdk/pendo/io/k3/d;", "buffer", "", "offset", "byteCount", "", "name", "", "expected", "actual", "sink", "c", "Lsdk/pendo/io/k3/b0;", "d", "close", "", "f", "B", "section", "Lsdk/pendo/io/k3/u;", "s", "Lsdk/pendo/io/k3/u;", "source", "Ljava/util/zip/Inflater;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/util/zip/Inflater;", "inflater", "Lsdk/pendo/io/k3/m;", "f0", "Lsdk/pendo/io/k3/m;", "inflaterSource", "Ljava/util/zip/CRC32;", "t0", "Ljava/util/zip/CRC32;", "crc", "<init>", "(Lokio/Source;)V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class l implements a0 {

    /* renamed from: A, reason: from kotlin metadata */
    private final Inflater inflater;

    /* renamed from: f, reason: from kotlin metadata */
    private byte section;

    /* renamed from: f0, reason: from kotlin metadata */
    private final m inflaterSource;

    /* renamed from: s, reason: from kotlin metadata */
    private final u source;

    /* renamed from: t0, reason: from kotlin metadata */
    private final CRC32 crc;

    public l(a0 source) {
        Intrinsics.checkNotNullParameter(source, "source");
        u uVar = new u(source);
        this.source = uVar;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new m((f) uVar, inflater);
        this.crc = new CRC32();
    }

    private final void a(String name, int expected, int actual) {
        if (actual == expected) {
            return;
        }
        String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{name, Integer.valueOf(actual), Integer.valueOf(expected)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        throw new IOException(format);
    }

    private final void b() {
        a("CRC", this.source.a(), (int) this.crc.getValue());
        a("ISIZE", this.source.a(), (int) this.inflater.getBytesWritten());
    }

    @Override // sdk.pendo.io.k3.a0
    public long c(d sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (byteCount == 0) {
            return 0L;
        }
        if (this.section == 0) {
            a();
            this.section = (byte) 1;
        }
        if (this.section == 1) {
            long size = sink.getSize();
            long c = this.inflaterSource.c(sink, byteCount);
            if (c != -1) {
                a(sink, size, c);
                return c;
            }
            this.section = (byte) 2;
        }
        if (this.section == 2) {
            b();
            this.section = (byte) 3;
            if (!this.source.i()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // sdk.pendo.io.k3.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.inflaterSource.close();
    }

    @Override // sdk.pendo.io.k3.a0
    /* renamed from: d */
    public b0 getTimeout() {
        return this.source.getTimeout();
    }

    private final void a() {
        this.source.f(10L);
        byte h = this.source.bufferField.h(3L);
        boolean z = ((h >> 1) & 1) == 1;
        if (z) {
            a(this.source.bufferField, 0L, 10L);
        }
        a("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8L);
        if (((h >> 2) & 1) == 1) {
            this.source.f(2L);
            if (z) {
                a(this.source.bufferField, 0L, 2L);
            }
            long v = this.source.bufferField.v() & UShort.MAX_VALUE;
            this.source.f(v);
            if (z) {
                a(this.source.bufferField, 0L, v);
            }
            this.source.skip(v);
        }
        if (((h >> 3) & 1) == 1) {
            long a2 = this.source.a((byte) 0);
            if (a2 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.source.bufferField, 0L, a2 + 1);
            }
            this.source.skip(a2 + 1);
        }
        if (((h >> 4) & 1) == 1) {
            long a3 = this.source.a((byte) 0);
            if (a3 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.source.bufferField, 0L, a3 + 1);
            }
            this.source.skip(a3 + 1);
        }
        if (z) {
            a("FHCRC", this.source.b(), (short) this.crc.getValue());
            this.crc.reset();
        }
    }

    private final void a(d buffer, long offset, long byteCount) {
        v vVar = buffer.head;
        while (true) {
            Intrinsics.checkNotNull(vVar);
            long j = vVar.limit - vVar.pos;
            if (offset < j) {
                break;
            }
            offset -= j;
            vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
        }
        while (byteCount > 0) {
            int min = (int) Math.min(vVar.limit - r6, byteCount);
            this.crc.update(vVar.data, (int) (vVar.pos + offset), min);
            byteCount -= min;
            vVar = vVar.external.sdk.pendo.io.mozilla.javascript.ES6Iterator.NEXT_METHOD java.lang.String;
            Intrinsics.checkNotNull(vVar);
            offset = 0;
        }
    }
}
