package sdk.pendo.io.e3;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import com.iterable.iterableapi.IterableConstants;
import io.sentry.ProfilingTraceData;
import io.sentry.SentryEnvelopeItemHeader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.k3.a0;
import sdk.pendo.io.k3.b0;
import sdk.pendo.io.k3.y;
import sdk.pendo.io.w2.u;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 ^2\u00020\u0001:\u0004\u0011\u0007&,B3\b\u0000\u0012\u0006\u0010\u001f\u001a\u00020\u0014\u0012\u0006\u0010$\u001a\u00020 \u0012\u0006\u0010[\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\\\u0010]J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014J\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\u000f\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0018J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0019J\u000f\u0010\u0007\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0007\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u001b\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010$\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010#R*\u0010+\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00198\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b&\u0010*R*\u0010.\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00198\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010'\u001a\u0004\b-\u0010)\"\u0004\b\u0007\u0010*R*\u00101\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00198\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010'\u001a\u0004\b0\u0010)\"\u0004\b,\u0010*R*\u00104\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00198\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010'\u001a\u0004\b2\u0010)\"\u0004\b3\u0010*R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\b058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u00106R\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u00108R\u001e\u0010\u0013\u001a\u00060:R\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001e\u0010C\u001a\u00060?R\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000e\u0010@\u001a\u0004\bA\u0010BR\u001e\u0010I\u001a\u00060DR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001e\u0010L\u001a\u00060DR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\bJ\u0010F\u001a\u0004\bK\u0010HR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028@@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b2\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b0\u0010R\u001a\u0004\b/\u0010S\"\u0004\bT\u0010UR\u0011\u0010X\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0011\u0010Z\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bY\u0010W¨\u0006_"}, d2 = {"Lsdk/pendo/io/e3/i;", "", "Lsdk/pendo/io/e3/b;", "errorCode", "Ljava/io/IOException;", "errorException", "", "b", "Lsdk/pendo/io/w2/u;", "s", "Lsdk/pendo/io/k3/b0;", "r", "u", "Lsdk/pendo/io/k3/y;", "j", "rstStatusCode", "", "a", "Lsdk/pendo/io/k3/f;", "source", "", SentryEnvelopeItemHeader.JsonKeys.LENGTH, "headers", "inFinished", "()V", "", "delta", "t", "I", "f", "()I", "id", "Lsdk/pendo/io/e3/f;", "Lsdk/pendo/io/e3/f;", "getConnection", "()Lokhttp3/internal/http2/Http2Connection;", "connection", "<set-?>", "c", "J", "h", "()J", "(J)V", "readBytesTotal", "d", "g", "readBytesAcknowledged", "e", "n", "writeBytesTotal", "m", "setWriteBytesMaximum$okhttp", "writeBytesMaximum", "Ljava/util/ArrayDeque;", "Ljava/util/ArrayDeque;", "headersQueue", "Z", "hasResponseHeaders", "Lsdk/pendo/io/e3/i$c;", ContextChain.TAG_INFRA, "Lsdk/pendo/io/e3/i$c;", "getSource$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lsdk/pendo/io/e3/i$b;", "Lsdk/pendo/io/e3/i$b;", "getSink$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSink;", "sink", "Lsdk/pendo/io/e3/i$d;", "k", "Lsdk/pendo/io/e3/i$d;", "getReadTimeout$okhttp", "()Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "readTimeout", "l", "getWriteTimeout$okhttp", "writeTimeout", "Lsdk/pendo/io/e3/b;", "getErrorCode$okhttp", "()Lokhttp3/internal/http2/ErrorCode;", "setErrorCode$okhttp", "(Lokhttp3/internal/http2/ErrorCode;)V", "Ljava/io/IOException;", "()Ljava/io/IOException;", "setErrorException$okhttp", "(Ljava/io/IOException;)V", "q", "()Z", "isOpen", ContextChain.TAG_PRODUCT, "isLocallyInitiated", "outFinished", "<init>", "(ILokhttp3/internal/http2/Http2Connection;ZZLokhttp3/Headers;)V", "o", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int id;

    /* renamed from: b, reason: from kotlin metadata */
    private final f connection;

    /* renamed from: c, reason: from kotlin metadata */
    private long readBytesTotal;

    /* renamed from: d, reason: from kotlin metadata */
    private long readBytesAcknowledged;

    /* renamed from: e, reason: from kotlin metadata */
    private long writeBytesTotal;

    /* renamed from: f, reason: from kotlin metadata */
    private long writeBytesMaximum;

    /* renamed from: g, reason: from kotlin metadata */
    private final ArrayDeque<u> headersQueue;

    /* renamed from: h, reason: from kotlin metadata */
    private boolean hasResponseHeaders;

    /* renamed from: i, reason: from kotlin metadata */
    private final c source;

    /* renamed from: j, reason: from kotlin metadata */
    private final b sink;

    /* renamed from: k, reason: from kotlin metadata */
    private final d readTimeout;

    /* renamed from: l, reason: from kotlin metadata */
    private final d writeTimeout;

    /* renamed from: m, reason: from kotlin metadata */
    private sdk.pendo.io.e3.b errorCode;

    /* renamed from: n, reason: from kotlin metadata */
    private IOException errorException;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u000f\u001a\u0004\b\u0005\u0010\u0011\"\u0004\b!\u0010\u0013¨\u0006%"}, d2 = {"Lsdk/pendo/io/e3/i$b;", "Lsdk/pendo/io/k3/y;", "", "outFinishedOnLastFrame", "", "a", "Lsdk/pendo/io/k3/d;", "source", "", "byteCount", "flush", "Lsdk/pendo/io/k3/b0;", "d", "close", "f", "Z", "b", "()Z", "setFinished", "(Z)V", "finished", "s", "Lsdk/pendo/io/k3/d;", "sendBuffer", "Lsdk/pendo/io/w2/u;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lsdk/pendo/io/w2/u;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "trailers", "f0", "setClosed", "closed", "<init>", "(Lokhttp3/internal/http2/Http2Stream;Z)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public final class b implements y {

        /* renamed from: A, reason: from kotlin metadata */
        private u trailers;

        /* renamed from: f, reason: from kotlin metadata */
        private boolean finished;

        /* renamed from: f0, reason: from kotlin metadata */
        private boolean closed;

        /* renamed from: s, reason: from kotlin metadata */
        private final sdk.pendo.io.k3.d sendBuffer = new sdk.pendo.io.k3.d();

        public b(boolean z) {
            this.finished = z;
        }

        private final void a(boolean outFinishedOnLastFrame) {
            long min;
            boolean z;
            i iVar = i.this;
            synchronized (iVar) {
                iVar.getWriteTimeout().l();
                while (iVar.getWriteBytesTotal() >= iVar.getWriteBytesMaximum() && !this.finished && !this.closed && iVar.d() == null) {
                    try {
                        iVar.t();
                    } finally {
                        iVar.getWriteTimeout().o();
                    }
                }
                iVar.getWriteTimeout().o();
                iVar.b();
                min = Math.min(iVar.getWriteBytesMaximum() - iVar.getWriteBytesTotal(), this.sendBuffer.getSize());
                iVar.d(iVar.getWriteBytesTotal() + min);
                z = outFinishedOnLastFrame && min == this.sendBuffer.getSize();
                Unit unit = Unit.INSTANCE;
            }
            i.this.getWriteTimeout().l();
            try {
                i.this.getConnection().a(i.this.getId(), z, this.sendBuffer, min);
            } finally {
                iVar = i.this;
            }
        }

        /* renamed from: b, reason: from getter */
        public final boolean getFinished() {
            return this.finished;
        }

        @Override // sdk.pendo.io.k3.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            i iVar = i.this;
            if (sdk.pendo.io.x2.b.h && Thread.holdsLock(iVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + iVar);
            }
            i iVar2 = i.this;
            synchronized (iVar2) {
                if (this.closed) {
                    return;
                }
                boolean z = iVar2.d() == null;
                Unit unit = Unit.INSTANCE;
                if (!i.this.getSink().finished) {
                    boolean z2 = this.sendBuffer.getSize() > 0;
                    if (this.trailers != null) {
                        while (this.sendBuffer.getSize() > 0) {
                            a(false);
                        }
                        f connection = i.this.getConnection();
                        int id = i.this.getId();
                        u uVar = this.trailers;
                        Intrinsics.checkNotNull(uVar);
                        connection.a(id, z, sdk.pendo.io.x2.b.a(uVar));
                    } else if (z2) {
                        while (this.sendBuffer.getSize() > 0) {
                            a(true);
                        }
                    } else if (z) {
                        i.this.getConnection().a(i.this.getId(), true, (sdk.pendo.io.k3.d) null, 0L);
                    }
                }
                synchronized (i.this) {
                    this.closed = true;
                    Unit unit2 = Unit.INSTANCE;
                }
                i.this.getConnection().flush();
                i.this.a();
            }
        }

        @Override // sdk.pendo.io.k3.y
        /* renamed from: d */
        public b0 getTimeout() {
            return i.this.getWriteTimeout();
        }

        @Override // sdk.pendo.io.k3.y, java.io.Flushable
        public void flush() {
            i iVar = i.this;
            if (sdk.pendo.io.x2.b.h && Thread.holdsLock(iVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + iVar);
            }
            i iVar2 = i.this;
            synchronized (iVar2) {
                iVar2.b();
                Unit unit = Unit.INSTANCE;
            }
            while (this.sendBuffer.getSize() > 0) {
                a(false);
                i.this.getConnection().flush();
            }
        }

        /* renamed from: a, reason: from getter */
        public final boolean getClosed() {
            return this.closed;
        }

        @Override // sdk.pendo.io.k3.y
        public void a(sdk.pendo.io.k3.d source, long byteCount) {
            Intrinsics.checkNotNullParameter(source, "source");
            i iVar = i.this;
            if (sdk.pendo.io.x2.b.h && Thread.holdsLock(iVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + iVar);
            }
            this.sendBuffer.a(source, byteCount);
            while (this.sendBuffer.getSize() >= 16384) {
                a(false);
            }
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0014¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00148\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\f\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\"\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001eR$\u0010*\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010-\u001a\u00020\u00148\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0016\u001a\u0004\b\f\u0010\u0018\"\u0004\b,\u0010\u0019¨\u00060"}, d2 = {"Lsdk/pendo/io/e3/i$c;", "Lsdk/pendo/io/k3/a0;", "", IterableConstants.ITERABLE_IN_APP_READ, "", "h", "Lsdk/pendo/io/k3/d;", "sink", "byteCount", "c", "Lsdk/pendo/io/k3/f;", "source", "a", "(Lsdk/pendo/io/k3/f;J)V", "Lsdk/pendo/io/k3/b0;", "d", "close", "f", "J", "maxByteCount", "", "s", "Z", "b", "()Z", "(Z)V", "finished", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lsdk/pendo/io/k3/d;", "getReceiveBuffer", "()Lokio/Buffer;", "receiveBuffer", "f0", "getReadBuffer", "readBuffer", "Lsdk/pendo/io/w2/u;", "t0", "Lsdk/pendo/io/w2/u;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "trailers", "u0", "setClosed$okhttp", "closed", "<init>", "(Lokhttp3/internal/http2/Http2Stream;JZ)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public final class c implements a0 {

        /* renamed from: f, reason: from kotlin metadata */
        private final long maxByteCount;

        /* renamed from: s, reason: from kotlin metadata */
        private boolean finished;

        /* renamed from: t0, reason: from kotlin metadata */
        private u trailers;

        /* renamed from: u0, reason: from kotlin metadata */
        private boolean closed;

        /* renamed from: A, reason: from kotlin metadata */
        private final sdk.pendo.io.k3.d receiveBuffer = new sdk.pendo.io.k3.d();

        /* renamed from: f0, reason: from kotlin metadata */
        private final sdk.pendo.io.k3.d readBuffer = new sdk.pendo.io.k3.d();

        public c(long j, boolean z) {
            this.maxByteCount = j;
            this.finished = z;
        }

        private final void h(long read) {
            i iVar = i.this;
            if (sdk.pendo.io.x2.b.h && Thread.holdsLock(iVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + iVar);
            }
            i.this.getConnection().i(read);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getClosed() {
            return this.closed;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getFinished() {
            return this.finished;
        }

        @Override // sdk.pendo.io.k3.a0
        public long c(sdk.pendo.io.k3.d sink, long byteCount) {
            IOException iOException;
            long j;
            boolean z;
            Intrinsics.checkNotNullParameter(sink, "sink");
            long j2 = 0;
            if (!(byteCount >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            while (true) {
                i iVar = i.this;
                synchronized (iVar) {
                    iVar.getReadTimeout().l();
                    try {
                        if (iVar.d() == null || this.finished) {
                            iOException = null;
                        } else {
                            iOException = iVar.getErrorException();
                            if (iOException == null) {
                                sdk.pendo.io.e3.b d = iVar.d();
                                Intrinsics.checkNotNull(d);
                                iOException = new n(d);
                            }
                        }
                        if (this.closed) {
                            throw new IOException("stream closed");
                        }
                        if (this.readBuffer.getSize() > j2) {
                            sdk.pendo.io.k3.d dVar = this.readBuffer;
                            j = dVar.c(sink, Math.min(byteCount, dVar.getSize()));
                            iVar.c(iVar.getReadBytesTotal() + j);
                            long readBytesTotal = iVar.getReadBytesTotal() - iVar.getReadBytesAcknowledged();
                            if (iOException == null && readBytesTotal >= iVar.getConnection().getOkHttpSettings().b() / 2) {
                                iVar.getConnection().a(iVar.getId(), readBytesTotal);
                                iVar.b(iVar.getReadBytesTotal());
                            }
                        } else if (this.finished || iOException != null) {
                            j = -1;
                        } else {
                            iVar.t();
                            j = -1;
                            z = true;
                            iVar.getReadTimeout().o();
                            Unit unit = Unit.INSTANCE;
                        }
                        z = false;
                        iVar.getReadTimeout().o();
                        Unit unit2 = Unit.INSTANCE;
                    } finally {
                    }
                }
                if (!z) {
                    if (j != -1) {
                        return j;
                    }
                    if (iOException == null) {
                        return -1L;
                    }
                    throw iOException;
                }
                j2 = 0;
            }
        }

        @Override // sdk.pendo.io.k3.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            long size;
            i iVar = i.this;
            synchronized (iVar) {
                this.closed = true;
                size = this.readBuffer.getSize();
                this.readBuffer.m();
                Intrinsics.checkNotNull(iVar, "null cannot be cast to non-null type java.lang.Object");
                iVar.notifyAll();
                Unit unit = Unit.INSTANCE;
            }
            if (size > 0) {
                h(size);
            }
            i.this.a();
        }

        @Override // sdk.pendo.io.k3.a0
        /* renamed from: d */
        public b0 getTimeout() {
            return i.this.getReadTimeout();
        }

        public final void a(sdk.pendo.io.k3.f source, long byteCount) {
            boolean z;
            boolean z2;
            boolean z3;
            Intrinsics.checkNotNullParameter(source, "source");
            i iVar = i.this;
            if (sdk.pendo.io.x2.b.h && Thread.holdsLock(iVar)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + iVar);
            }
            long j = byteCount;
            while (j > 0) {
                synchronized (i.this) {
                    z = this.finished;
                    z2 = true;
                    z3 = this.readBuffer.getSize() + j > this.maxByteCount;
                    Unit unit = Unit.INSTANCE;
                }
                if (z3) {
                    source.skip(j);
                    i.this.a(sdk.pendo.io.e3.b.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    source.skip(j);
                    return;
                }
                long c = source.c(this.receiveBuffer, j);
                if (c == -1) {
                    throw new EOFException();
                }
                j -= c;
                i iVar2 = i.this;
                synchronized (iVar2) {
                    if (this.closed) {
                        this.receiveBuffer.m();
                    } else {
                        if (this.readBuffer.getSize() != 0) {
                            z2 = false;
                        }
                        this.readBuffer.a((a0) this.receiveBuffer);
                        if (z2) {
                            Intrinsics.checkNotNull(iVar2, "null cannot be cast to non-null type java.lang.Object");
                            iVar2.notifyAll();
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            h(byteCount);
        }

        public final void a(boolean z) {
            this.finished = z;
        }

        public final void a(u uVar) {
            this.trailers = uVar;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u0006\u0010\u0007\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lsdk/pendo/io/e3/i$d;", "Lsdk/pendo/io/k3/c;", "", "n", "Ljava/io/IOException;", "cause", "b", "o", "<init>", "(Lokhttp3/internal/http2/Http2Stream;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public final class d extends sdk.pendo.io.k3.c {
        public d() {
        }

        @Override // sdk.pendo.io.k3.c
        protected IOException b(IOException cause) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT);
            if (cause != null) {
                socketTimeoutException.initCause(cause);
            }
            return socketTimeoutException;
        }

        @Override // sdk.pendo.io.k3.c
        protected void n() {
            i.this.a(sdk.pendo.io.e3.b.CANCEL);
            i.this.getConnection().u();
        }

        public final void o() {
            if (m()) {
                throw b((IOException) null);
            }
        }
    }

    public i(int i, f connection, boolean z, boolean z2, u uVar) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.id = i;
        this.connection = connection;
        this.writeBytesMaximum = connection.getPeerSettings().b();
        ArrayDeque<u> arrayDeque = new ArrayDeque<>();
        this.headersQueue = arrayDeque;
        this.source = new c(connection.getOkHttpSettings().b(), z2);
        this.sink = new b(z);
        this.readTimeout = new d();
        this.writeTimeout = new d();
        if (uVar == null) {
            if (!p()) {
                throw new IllegalStateException("remotely-initiated streams should have headers".toString());
            }
        } else {
            if (!(!p())) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            }
            arrayDeque.add(uVar);
        }
    }

    public final void a(long delta) {
        this.writeBytesMaximum += delta;
        if (delta > 0) {
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final void b() {
        if (this.sink.getClosed()) {
            throw new IOException("stream closed");
        }
        if (this.sink.getFinished()) {
            throw new IOException("stream finished");
        }
        if (this.errorCode != null) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            sdk.pendo.io.e3.b bVar = this.errorCode;
            Intrinsics.checkNotNull(bVar);
            throw new n(bVar);
        }
    }

    /* renamed from: c, reason: from getter */
    public final f getConnection() {
        return this.connection;
    }

    public final synchronized sdk.pendo.io.e3.b d() {
        return this.errorCode;
    }

    /* renamed from: e, reason: from getter */
    public final IOException getErrorException() {
        return this.errorException;
    }

    /* renamed from: f, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: g, reason: from getter */
    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    /* renamed from: h, reason: from getter */
    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    /* renamed from: i, reason: from getter */
    public final d getReadTimeout() {
        return this.readTimeout;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0011 A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:10:0x0011, B:15:0x0017, B:16:0x0022), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0017 A[Catch: all -> 0x0023, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:10:0x0011, B:15:0x0017, B:16:0x0022), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final sdk.pendo.io.k3.y j() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.hasResponseHeaders     // Catch: java.lang.Throwable -> L23
            if (r0 != 0) goto Le
            boolean r0 = r2.p()     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto Lc
            goto Le
        Lc:
            r0 = 0
            goto Lf
        Le:
            r0 = 1
        Lf:
            if (r0 == 0) goto L17
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L23
            monitor-exit(r2)
            sdk.pendo.io.e3.i$b r0 = r2.sink
            return r0
        L17:
            java.lang.String r0 = "reply before requesting the sink"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L23
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L23
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L23
            throw r1     // Catch: java.lang.Throwable -> L23
        L23:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.e3.i.j():sdk.pendo.io.k3.y");
    }

    /* renamed from: k, reason: from getter */
    public final b getSink() {
        return this.sink;
    }

    /* renamed from: l, reason: from getter */
    public final c getSource() {
        return this.source;
    }

    /* renamed from: m, reason: from getter */
    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    /* renamed from: n, reason: from getter */
    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    /* renamed from: o, reason: from getter */
    public final d getWriteTimeout() {
        return this.writeTimeout;
    }

    public final boolean p() {
        return this.connection.getClient() == ((this.id & 1) == 1);
    }

    public final synchronized boolean q() {
        if (this.errorCode != null) {
            return false;
        }
        if ((this.source.getFinished() || this.source.getClosed()) && (this.sink.getFinished() || this.sink.getClosed())) {
            if (this.hasResponseHeaders) {
                return false;
            }
        }
        return true;
    }

    public final b0 r() {
        return this.readTimeout;
    }

    public final synchronized u s() {
        u removeFirst;
        this.readTimeout.l();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            try {
                t();
            } catch (Throwable th) {
                this.readTimeout.o();
                throw th;
            }
        }
        this.readTimeout.o();
        if (!(!this.headersQueue.isEmpty())) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            sdk.pendo.io.e3.b bVar = this.errorCode;
            Intrinsics.checkNotNull(bVar);
            throw new n(bVar);
        }
        removeFirst = this.headersQueue.removeFirst();
        Intrinsics.checkNotNullExpressionValue(removeFirst, "headersQueue.removeFirst()");
        return removeFirst;
    }

    public final void t() {
        try {
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final b0 u() {
        return this.writeTimeout;
    }

    private final boolean b(sdk.pendo.io.e3.b errorCode, IOException errorException) {
        if (sdk.pendo.io.x2.b.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            this.errorCode = errorCode;
            this.errorException = errorException;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            if (this.source.getFinished() && this.sink.getFinished()) {
                return false;
            }
            Unit unit = Unit.INSTANCE;
            this.connection.c(this.id);
            return true;
        }
    }

    public final void a() {
        boolean z;
        boolean q;
        if (sdk.pendo.io.x2.b.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            z = !this.source.getFinished() && this.source.getClosed() && (this.sink.getFinished() || this.sink.getClosed());
            q = q();
            Unit unit = Unit.INSTANCE;
        }
        if (z) {
            a(sdk.pendo.io.e3.b.CANCEL, (IOException) null);
        } else {
            if (q) {
                return;
            }
            this.connection.c(this.id);
        }
    }

    public final void c(long j) {
        this.readBytesTotal = j;
    }

    public final void d(long j) {
        this.writeBytesTotal = j;
    }

    public final void a(sdk.pendo.io.e3.b rstStatusCode, IOException errorException) {
        Intrinsics.checkNotNullParameter(rstStatusCode, "rstStatusCode");
        if (b(rstStatusCode, errorException)) {
            this.connection.b(this.id, rstStatusCode);
        }
    }

    public final synchronized void b(sdk.pendo.io.e3.b errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final void a(sdk.pendo.io.e3.b errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (b(errorCode, null)) {
            this.connection.c(this.id, errorCode);
        }
    }

    public final void b(long j) {
        this.readBytesAcknowledged = j;
    }

    public final void a(sdk.pendo.io.k3.f source, int length) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (sdk.pendo.io.x2.b.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        this.source.a(source, length);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004f A[Catch: all -> 0x006d, TryCatch #0 {, blocks: (B:10:0x0038, B:14:0x0040, B:16:0x004f, B:17:0x0054, B:24:0x0046), top: B:9:0x0038 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(sdk.pendo.io.w2.u r3, boolean r4) {
        /*
            r2 = this;
            java.lang.String r0 = "headers"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            boolean r0 = sdk.pendo.io.x2.b.h
            if (r0 == 0) goto L37
            boolean r0 = java.lang.Thread.holdsLock(r2)
            if (r0 != 0) goto L10
            goto L37
        L10:
            java.lang.AssertionError r3 = new java.lang.AssertionError
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r0 = "Thread "
            r4.<init>(r0)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.String r0 = r0.getName()
            java.lang.StringBuilder r4 = r4.append(r0)
            java.lang.String r0 = " MUST NOT hold lock on "
            java.lang.StringBuilder r4 = r4.append(r0)
            java.lang.StringBuilder r4 = r4.append(r2)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L37:
            monitor-enter(r2)
            boolean r0 = r2.hasResponseHeaders     // Catch: java.lang.Throwable -> L6d
            r1 = 1
            if (r0 == 0) goto L46
            if (r4 != 0) goto L40
            goto L46
        L40:
            sdk.pendo.io.e3.i$c r0 = r2.source     // Catch: java.lang.Throwable -> L6d
            r0.a(r3)     // Catch: java.lang.Throwable -> L6d
            goto L4d
        L46:
            r2.hasResponseHeaders = r1     // Catch: java.lang.Throwable -> L6d
            java.util.ArrayDeque<sdk.pendo.io.w2.u> r0 = r2.headersQueue     // Catch: java.lang.Throwable -> L6d
            r0.add(r3)     // Catch: java.lang.Throwable -> L6d
        L4d:
            if (r4 == 0) goto L54
            sdk.pendo.io.e3.i$c r3 = r2.source     // Catch: java.lang.Throwable -> L6d
            r3.a(r1)     // Catch: java.lang.Throwable -> L6d
        L54:
            boolean r3 = r2.q()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.Object"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r4)     // Catch: java.lang.Throwable -> L6d
            r2.notifyAll()     // Catch: java.lang.Throwable -> L6d
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L6d
            monitor-exit(r2)
            if (r3 != 0) goto L6c
            sdk.pendo.io.e3.f r3 = r2.connection
            int r4 = r2.id
            r3.c(r4)
        L6c:
            return
        L6d:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.e3.i.a(sdk.pendo.io.w2.u, boolean):void");
    }
}
