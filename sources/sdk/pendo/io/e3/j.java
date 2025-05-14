package sdk.pendo.io.e3;

import androidx.exifinterface.media.ExifInterface;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import expo.modules.updates.UpdatesConfiguration;
import io.sentry.SentryEnvelopeItemHeader;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.e3.d;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ;2\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010*\u001a\u00020\u0012¢\u0006\u0004\b9\u0010:J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ$\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0006\u0010\u000f\u001a\u00020\u0006J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0007\u001a\u00020\u0002J(\u0010\b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u0002J(\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\tJ\u001e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002J\u001e\u0010\b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001dJ\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0004J&\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002J\b\u0010\"\u001a\u00020\u0006H\u0016J$\u0010\b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010)R\u0017\u00108\u001a\u0002038\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107¨\u0006<"}, d2 = {"Lsdk/pendo/io/e3/j;", "Ljava/io/Closeable;", "", "streamId", "", "byteCount", "", "b", "a", "Lsdk/pendo/io/e3/m;", "peerSettings", "promisedStreamId", "", "Lsdk/pendo/io/e3/c;", UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, "flush", "Lsdk/pendo/io/e3/b;", "errorCode", "", "outFinished", "Lsdk/pendo/io/k3/d;", "source", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "buffer", "settings", "ack", "payload1", "payload2", "lastGoodStreamId", "", "debugData", "windowSizeIncrement", SentryEnvelopeItemHeader.JsonKeys.LENGTH, "type", "close", "headerBlock", "Lsdk/pendo/io/k3/e;", "f", "Lsdk/pendo/io/k3/e;", "sink", "s", "Z", "client", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lsdk/pendo/io/k3/d;", "hpackBuffer", "f0", "I", "maxFrameSize", "t0", "closed", "Lsdk/pendo/io/e3/d$b;", "u0", "Lsdk/pendo/io/e3/d$b;", "getHpackWriter", "()Lokhttp3/internal/http2/Hpack$Writer;", "hpackWriter", "<init>", "(Lokio/BufferedSink;Z)V", "v0", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class j implements Closeable {
    private static final Logger w0 = Logger.getLogger(e.class.getName());

    /* renamed from: A, reason: from kotlin metadata */
    private final sdk.pendo.io.k3.d hpackBuffer;

    /* renamed from: f, reason: from kotlin metadata */
    private final sdk.pendo.io.k3.e sink;

    /* renamed from: f0, reason: from kotlin metadata */
    private int maxFrameSize;

    /* renamed from: s, reason: from kotlin metadata */
    private final boolean client;

    /* renamed from: t0, reason: from kotlin metadata */
    private boolean closed;

    /* renamed from: u0, reason: from kotlin metadata */
    private final d.b hpackWriter;

    public j(sdk.pendo.io.k3.e sink, boolean z) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.sink = sink;
        this.client = z;
        sdk.pendo.io.k3.d dVar = new sdk.pendo.io.k3.d();
        this.hpackBuffer = dVar;
        this.maxFrameSize = 16384;
        this.hpackWriter = new d.b(0, false, dVar, 3, null);
    }

    public final synchronized void a(m peerSettings) {
        Intrinsics.checkNotNullParameter(peerSettings, "peerSettings");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.maxFrameSize = peerSettings.b(this.maxFrameSize);
        if (peerSettings.a() != -1) {
            this.hpackWriter.b(peerSettings.a());
        }
        a(0, 0, 4, 1);
        this.sink.flush();
    }

    /* renamed from: b, reason: from getter */
    public final int getMaxFrameSize() {
        return this.maxFrameSize;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void flush() {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.sink.flush();
    }

    public final synchronized void a() {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (this.client) {
            Logger logger = w0;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(sdk.pendo.io.x2.b.a(">> CONNECTION " + e.CONNECTION_PREFACE.h(), new Object[0]));
            }
            this.sink.a(e.CONNECTION_PREFACE);
            this.sink.flush();
        }
    }

    public final synchronized void b(m settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        if (this.closed) {
            throw new IOException("closed");
        }
        int i = 0;
        a(0, settings.d() * 6, 4, 0);
        while (i < 10) {
            if (settings.c(i)) {
                this.sink.writeShort(i != 4 ? i != 7 ? i : 4 : 3);
                this.sink.writeInt(settings.a(i));
            }
            i++;
        }
        this.sink.flush();
    }

    private final void b(int streamId, long byteCount) {
        while (byteCount > 0) {
            long min = Math.min(this.maxFrameSize, byteCount);
            byteCount -= min;
            a(streamId, (int) min, 9, byteCount == 0 ? 4 : 0);
            this.sink.a(this.hpackBuffer, min);
        }
    }

    public final synchronized void a(boolean outFinished, int streamId, sdk.pendo.io.k3.d source, int byteCount) {
        if (this.closed) {
            throw new IOException("closed");
        }
        a(streamId, outFinished ? 1 : 0, source, byteCount);
    }

    public final void a(int streamId, int flags, sdk.pendo.io.k3.d buffer, int byteCount) {
        a(streamId, byteCount, 0, flags);
        if (byteCount > 0) {
            sdk.pendo.io.k3.e eVar = this.sink;
            Intrinsics.checkNotNull(buffer);
            eVar.a(buffer, byteCount);
        }
    }

    public final void a(int streamId, int length, int type, int flags) {
        Logger logger = w0;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(e.f1015a.a(false, streamId, length, type, flags));
        }
        if (!(length <= this.maxFrameSize)) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + length).toString());
        }
        if (!((Integer.MIN_VALUE & streamId) == 0)) {
            throw new IllegalArgumentException(("reserved bit set: " + streamId).toString());
        }
        sdk.pendo.io.x2.b.a(this.sink, length);
        this.sink.writeByte(type & 255);
        this.sink.writeByte(flags & 255);
        this.sink.writeInt(streamId & Integer.MAX_VALUE);
    }

    public final synchronized void a(int lastGoodStreamId, b errorCode, byte[] debugData) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(debugData, "debugData");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (!(errorCode.getHttpCode() != -1)) {
            throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
        }
        a(0, debugData.length + 8, 7, 0);
        this.sink.writeInt(lastGoodStreamId);
        this.sink.writeInt(errorCode.getHttpCode());
        if (!(debugData.length == 0)) {
            this.sink.write(debugData);
        }
        this.sink.flush();
    }

    public final synchronized void a(boolean outFinished, int streamId, List<c> headerBlock) {
        Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.a(headerBlock);
        long size = this.hpackBuffer.getSize();
        long min = Math.min(this.maxFrameSize, size);
        int i = size == min ? 4 : 0;
        if (outFinished) {
            i |= 1;
        }
        a(streamId, (int) min, 1, i);
        this.sink.a(this.hpackBuffer, min);
        if (size > min) {
            b(streamId, size - min);
        }
    }

    public final synchronized void a(boolean ack, int payload1, int payload2) {
        if (this.closed) {
            throw new IOException("closed");
        }
        a(0, 8, 6, ack ? 1 : 0);
        this.sink.writeInt(payload1);
        this.sink.writeInt(payload2);
        this.sink.flush();
    }

    public final synchronized void a(int streamId, int promisedStreamId, List<c> requestHeaders) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.a(requestHeaders);
        long size = this.hpackBuffer.getSize();
        int min = (int) Math.min(this.maxFrameSize - 4, size);
        long j = min;
        a(streamId, min + 4, 5, size == j ? 4 : 0);
        this.sink.writeInt(promisedStreamId & Integer.MAX_VALUE);
        this.sink.a(this.hpackBuffer, j);
        if (size > j) {
            b(streamId, size - j);
        }
    }

    public final synchronized void a(int streamId, b errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (!(errorCode.getHttpCode() != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        a(streamId, 4, 3, 0);
        this.sink.writeInt(errorCode.getHttpCode());
        this.sink.flush();
    }

    public final synchronized void a(int streamId, long windowSizeIncrement) {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (!(windowSizeIncrement != 0 && windowSizeIncrement <= 2147483647L)) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + windowSizeIncrement).toString());
        }
        a(streamId, 4, 8, 0);
        this.sink.writeInt((int) windowSizeIncrement);
        this.sink.flush();
    }
}
