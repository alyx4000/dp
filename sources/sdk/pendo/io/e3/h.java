package sdk.pendo.io.e3;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import expo.modules.updates.UpdatesConfiguration;
import io.sentry.SentryEnvelopeItemHeader;
import io.sentry.SentryEvent;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import sdk.pendo.io.e3.d;
import sdk.pendo.io.k3.a0;
import sdk.pendo.io.k3.b0;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0003\r\u0013\tB\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010\u001d\u001a\u00020\u0015¢\u0006\u0004\b&\u0010'J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J.\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J(\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\r\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0017\u001a\u00020\bH\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lsdk/pendo/io/e3/h;", "Ljava/io/Closeable;", "Lsdk/pendo/io/e3/h$c;", "handler", "", SentryEnvelopeItemHeader.JsonKeys.LENGTH, NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "streamId", "", "c", ViewProps.PADDING, "", "Lsdk/pendo/io/e3/c;", "a", "e", "g", "h", "f", "d", "b", ContextChain.TAG_INFRA, "", "requireSettings", "close", "Lsdk/pendo/io/k3/f;", "Lsdk/pendo/io/k3/f;", "source", "s", "Z", "client", "Lsdk/pendo/io/e3/h$b;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lsdk/pendo/io/e3/h$b;", "continuation", "Lsdk/pendo/io/e3/d$a;", "f0", "Lsdk/pendo/io/e3/d$a;", "hpackReader", "<init>", "(Lokio/BufferedSource;Z)V", "t0", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class h implements Closeable {

    /* renamed from: t0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Logger u0;

    /* renamed from: A, reason: from kotlin metadata */
    private final b continuation;

    /* renamed from: f, reason: from kotlin metadata */
    private final sdk.pendo.io.k3.f source;

    /* renamed from: f0, reason: from kotlin metadata */
    private final d.a hpackReader;

    /* renamed from: s, reason: from kotlin metadata */
    private final boolean client;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\n¨\u0006\r"}, d2 = {"Lsdk/pendo/io/e3/h$a;", "", "", SentryEnvelopeItemHeader.JsonKeys.LENGTH, NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, ViewProps.PADDING, "a", "Ljava/util/logging/Logger;", SentryEvent.JsonKeys.LOGGER, "Ljava/util/logging/Logger;", "()Ljava/util/logging/Logger;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    /* renamed from: sdk.pendo.io.e3.h$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Logger a() {
            return h.u0;
        }

        public final int a(int length, int flags, int padding) {
            if ((flags & 8) != 0) {
                length--;
            }
            if (padding <= length) {
                return length - padding;
            }
            throw new IOException("PROTOCOL_ERROR padding " + padding + " > remaining length " + length);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\b\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0015R\"\u0010 \u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u0003\u0010\u0015R\"\u0010#\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u0014\"\u0004\b\n\u0010\u0015¨\u0006&"}, d2 = {"Lsdk/pendo/io/e3/h$b;", "Lsdk/pendo/io/k3/a0;", "", "b", "Lsdk/pendo/io/k3/d;", "sink", "", "byteCount", "c", "Lsdk/pendo/io/k3/b0;", "d", "close", "Lsdk/pendo/io/k3/f;", "f", "Lsdk/pendo/io/k3/f;", "source", "", "s", "I", "getLength", "()I", "(I)V", SentryEnvelopeItemHeader.JsonKeys.LENGTH, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getFlags", "a", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "f0", "getStreamId", "e", "streamId", "t0", ViewProps.LEFT, "u0", "getPadding", ViewProps.PADDING, "<init>", "(Lokio/BufferedSource;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class b implements a0 {

        /* renamed from: A, reason: from kotlin metadata */
        private int flags;

        /* renamed from: f, reason: from kotlin metadata */
        private final sdk.pendo.io.k3.f source;

        /* renamed from: f0, reason: from kotlin metadata */
        private int streamId;

        /* renamed from: s, reason: from kotlin metadata */
        private int length;

        /* renamed from: t0, reason: from kotlin metadata */
        private int left;

        /* renamed from: u0, reason: from kotlin metadata */
        private int padding;

        public b(sdk.pendo.io.k3.f source) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
        }

        private final void b() {
            int i = this.streamId;
            int a2 = sdk.pendo.io.x2.b.a(this.source);
            this.left = a2;
            this.length = a2;
            int a3 = sdk.pendo.io.x2.b.a(this.source.readByte(), 255);
            this.flags = sdk.pendo.io.x2.b.a(this.source.readByte(), 255);
            Companion companion = h.INSTANCE;
            if (companion.a().isLoggable(Level.FINE)) {
                companion.a().fine(e.f1015a.a(true, this.streamId, this.length, a3, this.flags));
            }
            int readInt = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = readInt;
            if (a3 != 9) {
                throw new IOException(a3 + " != TYPE_CONTINUATION");
            }
            if (readInt != i) {
                throw new IOException("TYPE_CONTINUATION streamId changed");
            }
        }

        /* renamed from: a, reason: from getter */
        public final int getLeft() {
            return this.left;
        }

        @Override // sdk.pendo.io.k3.a0
        public long c(sdk.pendo.io.k3.d sink, long byteCount) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            while (true) {
                int i = this.left;
                if (i != 0) {
                    long c = this.source.c(sink, Math.min(byteCount, i));
                    if (c == -1) {
                        return -1L;
                    }
                    this.left -= (int) c;
                    return c;
                }
                this.source.skip(this.padding);
                this.padding = 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                b();
            }
        }

        @Override // sdk.pendo.io.k3.a0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public final void d(int i) {
            this.padding = i;
        }

        public final void e(int i) {
            this.streamId = i;
        }

        public final void a(int i) {
            this.flags = i;
        }

        public final void b(int i) {
            this.left = i;
        }

        public final void c(int i) {
            this.length = i;
        }

        @Override // sdk.pendo.io.k3.a0
        /* renamed from: d */
        public b0 getTimeout() {
            return this.source.getTimeout();
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H&J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\n\u001a\u00020\tH&J \u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H&J \u0010\n\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH&J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0002H&J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\fH&¨\u0006!"}, d2 = {"Lsdk/pendo/io/e3/h$c;", "", "", "inFinished", "", "streamId", "Lsdk/pendo/io/k3/f;", "source", SentryEnvelopeItemHeader.JsonKeys.LENGTH, "", "a", "associatedStreamId", "", "Lsdk/pendo/io/e3/c;", "headerBlock", "Lsdk/pendo/io/e3/b;", "errorCode", "clearPrevious", "Lsdk/pendo/io/e3/m;", "settings", "ack", "payload1", "payload2", "lastGoodStreamId", "Lsdk/pendo/io/k3/g;", "debugData", "", "windowSizeIncrement", "streamDependency", "weight", "exclusive", "promisedStreamId", UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, "okhttp"}, k = 1, mv = {1, 8, 0})
    public interface c {
        void a();

        void a(int streamId, int streamDependency, int weight, boolean exclusive);

        void a(int streamId, int promisedStreamId, List<sdk.pendo.io.e3.c> requestHeaders);

        void a(int streamId, long windowSizeIncrement);

        void a(int streamId, sdk.pendo.io.e3.b errorCode);

        void a(int lastGoodStreamId, sdk.pendo.io.e3.b errorCode, sdk.pendo.io.k3.g debugData);

        void a(boolean ack, int payload1, int payload2);

        void a(boolean inFinished, int streamId, int associatedStreamId, List<sdk.pendo.io.e3.c> headerBlock);

        void a(boolean inFinished, int streamId, sdk.pendo.io.k3.f source, int length);

        void a(boolean clearPrevious, m settings);
    }

    static {
        Logger logger = Logger.getLogger(e.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(Http2::class.java.name)");
        u0 = logger;
    }

    public h(sdk.pendo.io.k3.f source, boolean z) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.client = z;
        b bVar = new b(source);
        this.continuation = bVar;
        this.hpackReader = new d.a(bVar, 4096, 0, 4, null);
    }

    private final void b(c handler, int length, int flags, int streamId) {
        if (length < 8) {
            throw new IOException("TYPE_GOAWAY length < 8: " + length);
        }
        if (streamId != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int readInt = this.source.readInt();
        int readInt2 = this.source.readInt();
        int i = length - 8;
        sdk.pendo.io.e3.b a2 = sdk.pendo.io.e3.b.INSTANCE.a(readInt2);
        if (a2 == null) {
            throw new IOException("TYPE_GOAWAY unexpected error code: " + readInt2);
        }
        sdk.pendo.io.k3.g gVar = sdk.pendo.io.k3.g.t0;
        if (i > 0) {
            gVar = this.source.c(i);
        }
        handler.a(readInt, a2, gVar);
    }

    private final void c(c handler, int length, int flags, int streamId) {
        if (streamId == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z = (flags & 1) != 0;
        int a2 = (flags & 8) != 0 ? sdk.pendo.io.x2.b.a(this.source.readByte(), 255) : 0;
        if ((flags & 32) != 0) {
            a(handler, streamId);
            length -= 5;
        }
        handler.a(z, streamId, -1, a(INSTANCE.a(length, flags, a2), a2, flags, streamId));
    }

    private final void d(c handler, int length, int flags, int streamId) {
        if (length != 8) {
            throw new IOException("TYPE_PING length != 8: " + length);
        }
        if (streamId != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        handler.a((flags & 1) != 0, this.source.readInt(), this.source.readInt());
    }

    private final void e(c handler, int length, int flags, int streamId) {
        if (length != 5) {
            throw new IOException("TYPE_PRIORITY length: " + length + " != 5");
        }
        if (streamId == 0) {
            throw new IOException("TYPE_PRIORITY streamId == 0");
        }
        a(handler, streamId);
    }

    private final void f(c handler, int length, int flags, int streamId) {
        if (streamId == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int a2 = (flags & 8) != 0 ? sdk.pendo.io.x2.b.a(this.source.readByte(), 255) : 0;
        handler.a(streamId, this.source.readInt() & Integer.MAX_VALUE, a(INSTANCE.a(length - 4, flags, a2), a2, flags, streamId));
    }

    private final void g(c handler, int length, int flags, int streamId) {
        if (length != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + length + " != 4");
        }
        if (streamId == 0) {
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        int readInt = this.source.readInt();
        sdk.pendo.io.e3.b a2 = sdk.pendo.io.e3.b.INSTANCE.a(readInt);
        if (a2 == null) {
            throw new IOException("TYPE_RST_STREAM unexpected error code: " + readInt);
        }
        handler.a(streamId, a2);
    }

    private final void h(c handler, int length, int flags, int streamId) {
        int readInt;
        if (streamId != 0) {
            throw new IOException("TYPE_SETTINGS streamId != 0");
        }
        if ((flags & 1) != 0) {
            if (length != 0) {
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            }
            handler.a();
            return;
        }
        if (length % 6 != 0) {
            throw new IOException("TYPE_SETTINGS length % 6 != 0: " + length);
        }
        m mVar = new m();
        IntProgression step = RangesKt.step(RangesKt.until(0, length), 6);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                int a2 = sdk.pendo.io.x2.b.a(this.source.readShort(), 65535);
                readInt = this.source.readInt();
                if (a2 != 2) {
                    if (a2 == 3) {
                        a2 = 4;
                    } else if (a2 != 4) {
                        if (a2 == 5 && (readInt < 16384 || readInt > 16777215)) {
                            break;
                        }
                    } else {
                        if (readInt < 0) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        }
                        a2 = 7;
                    }
                } else if (readInt != 0 && readInt != 1) {
                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                }
                mVar.a(a2, readInt);
                if (first == last) {
                    break;
                } else {
                    first += step2;
                }
            }
            throw new IOException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: " + readInt);
        }
        handler.a(false, mVar);
    }

    private final void i(c handler, int length, int flags, int streamId) {
        if (length != 4) {
            throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + length);
        }
        long a2 = sdk.pendo.io.x2.b.a(this.source.readInt(), 2147483647L);
        if (a2 == 0) {
            throw new IOException("windowSizeIncrement was 0");
        }
        handler.a(streamId, a2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.source.close();
    }

    public final boolean a(boolean requireSettings, c handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        try {
            this.source.f(9L);
            int a2 = sdk.pendo.io.x2.b.a(this.source);
            if (a2 > 16384) {
                throw new IOException("FRAME_SIZE_ERROR: " + a2);
            }
            int a3 = sdk.pendo.io.x2.b.a(this.source.readByte(), 255);
            int a4 = sdk.pendo.io.x2.b.a(this.source.readByte(), 255);
            int readInt = this.source.readInt() & Integer.MAX_VALUE;
            Logger logger = u0;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.f1015a.a(true, readInt, a2, a3, a4));
            }
            if (requireSettings && a3 != 4) {
                throw new IOException("Expected a SETTINGS frame but was " + e.f1015a.a(a3));
            }
            switch (a3) {
                case 0:
                    a(handler, a2, a4, readInt);
                    return true;
                case 1:
                    c(handler, a2, a4, readInt);
                    return true;
                case 2:
                    e(handler, a2, a4, readInt);
                    return true;
                case 3:
                    g(handler, a2, a4, readInt);
                    return true;
                case 4:
                    h(handler, a2, a4, readInt);
                    return true;
                case 5:
                    f(handler, a2, a4, readInt);
                    return true;
                case 6:
                    d(handler, a2, a4, readInt);
                    return true;
                case 7:
                    b(handler, a2, a4, readInt);
                    return true;
                case 8:
                    i(handler, a2, a4, readInt);
                    return true;
                default:
                    this.source.skip(a2);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void a(c handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (this.client) {
            if (!a(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        sdk.pendo.io.k3.f fVar = this.source;
        sdk.pendo.io.k3.g gVar = e.CONNECTION_PREFACE;
        sdk.pendo.io.k3.g c2 = fVar.c(gVar.l());
        Logger logger = u0;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(sdk.pendo.io.x2.b.a("<< CONNECTION " + c2.h(), new Object[0]));
        }
        if (!Intrinsics.areEqual(gVar, c2)) {
            throw new IOException("Expected a connection header but was " + c2.o());
        }
    }

    private final void a(c handler, int length, int flags, int streamId) {
        if (streamId == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
        }
        boolean z = (flags & 1) != 0;
        if ((flags & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        int a2 = (flags & 8) != 0 ? sdk.pendo.io.x2.b.a(this.source.readByte(), 255) : 0;
        handler.a(z, streamId, this.source, INSTANCE.a(length, flags, a2));
        this.source.skip(a2);
    }

    private final List<sdk.pendo.io.e3.c> a(int length, int padding, int flags, int streamId) {
        this.continuation.b(length);
        b bVar = this.continuation;
        bVar.c(bVar.getLeft());
        this.continuation.d(padding);
        this.continuation.a(flags);
        this.continuation.e(streamId);
        this.hpackReader.f();
        return this.hpackReader.c();
    }

    private final void a(c handler, int streamId) {
        int readInt = this.source.readInt();
        handler.a(streamId, readInt & Integer.MAX_VALUE, sdk.pendo.io.x2.b.a(this.source.readByte(), 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }
}
