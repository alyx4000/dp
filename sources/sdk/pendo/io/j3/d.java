package sdk.pendo.io.j3;

import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import androidx.exifinterface.media.ExifInterface;
import com.amplitude.reactnative.DatabaseConstants;
import com.facebook.common.callercontext.ContextChain;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.iterable.iterableapi.IterableConstants;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import io.sentry.clientreport.DiscardedEvent;
import io.sentry.protocol.Response;
import io.sentry.protocol.ViewHierarchyNode;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.lang3.time.DateUtils;
import sdk.pendo.io.j3.g;
import sdk.pendo.io.k3.g;
import sdk.pendo.io.w2.a0;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.h0;
import sdk.pendo.io.w2.i0;
import sdk.pendo.io.w2.r;
import sdk.pendo.io.w2.z;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 o2\u00020\u00012\u00020\u0002:\u0005\u0005\u0019\u0017\u000b BA\u0012\u0006\u0010l\u001a\u00020k\u0012\u0006\u0010(\u001a\u00020&\u0012\u0006\u0010-\u001a\u00020)\u0012\u0006\u00100\u001a\u00020.\u0012\u0006\u00102\u001a\u00020\u001e\u0012\b\u00104\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u00105\u001a\u00020\u001e¢\u0006\u0004\bm\u0010nJ\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0003H\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0005\u001a\u00020\nH\u0016J\u000e\u0010\u0005\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ!\u0010\u0005\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0004\b\u0005\u0010\u0012J\u0016\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\nJ\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\u0010\u0010\u0005\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0013H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\u001a\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0013H\u0016J \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001f\u001a\u00020\u001eJ\u000f\u0010 \u001a\u00020\u0004H\u0000¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\nH\u0000¢\u0006\u0004\b\"\u0010#J\u001c\u0010\u0005\u001a\u00020\n2\n\u0010 \u001a\u00060$j\u0002`%2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010'R\u001a\u0010-\u001a\u00020)8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0019\u0010*\u001a\u0004\b+\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010/R\u0014\u00102\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u00103R\u0016\u00105\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u00101R\u0014\u00108\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u00107R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00060P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020T0P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010RR\u0016\u0010X\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u00101R\u0016\u0010[\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010`\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u00107R\u0016\u0010b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010ZR\u0016\u0010d\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010]R\u0016\u0010f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010]R\u0016\u0010h\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010]R\u0016\u0010j\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010Z¨\u0006p"}, d2 = {"Lsdk/pendo/io/j3/d;", "Lsdk/pendo/io/w2/h0;", "Lsdk/pendo/io/j3/g$a;", "Lsdk/pendo/io/j3/e;", "", "a", "Lsdk/pendo/io/k3/g;", "data", "", "formatOpcode", "", "d", "Lsdk/pendo/io/w2/z;", "client", "Lsdk/pendo/io/w2/d0;", Response.TYPE, "Lsdk/pendo/io/b3/c;", "exchange", "(Lsdk/pendo/io/w2/d0;Lsdk/pendo/io/b3/c;)V", "", "name", "Lsdk/pendo/io/j3/d$d;", "streams", "c", "text", "b", "bytes", IterableConstants.ITERABLE_IN_APP_LEGACY_PAYLOAD, ApiConstant.KEY_CODE, DiscardedEvent.JsonKeys.REASON, "", "cancelAfterCloseMillis", "e", "()Z", "f", "()V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lsdk/pendo/io/w2/b0;", "Lsdk/pendo/io/w2/b0;", "originalRequest", "Lsdk/pendo/io/w2/i0;", "Lsdk/pendo/io/w2/i0;", "getListener$okhttp", "()Lokhttp3/WebSocketListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Ljava/util/Random;", "Ljava/util/Random;", "random", "J", "pingIntervalMillis", "Lsdk/pendo/io/j3/e;", "extensions", "minimumDeflateSize", "g", "Ljava/lang/String;", DatabaseConstants.KEY_FIELD, "Lsdk/pendo/io/w2/e;", "h", "Lsdk/pendo/io/w2/e;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/a3/a;", ContextChain.TAG_INFRA, "Lsdk/pendo/io/a3/a;", "writerTask", "Lsdk/pendo/io/j3/g;", "j", "Lsdk/pendo/io/j3/g;", "reader", "Lsdk/pendo/io/j3/h;", "k", "Lsdk/pendo/io/j3/h;", "writer", "Lsdk/pendo/io/a3/d;", "l", "Lsdk/pendo/io/a3/d;", "taskQueue", "m", "n", "Lsdk/pendo/io/j3/d$d;", "Ljava/util/ArrayDeque;", "o", "Ljava/util/ArrayDeque;", "pongQueue", "", ContextChain.TAG_PRODUCT, "messageAndCloseQueue", "q", "queueSize", "r", "Z", "enqueuedClose", "s", "I", "receivedCloseCode", "t", "receivedCloseReason", "u", "failed", "v", "sentPingCount", "w", "receivedPingCount", ViewHierarchyNode.JsonKeys.X, "receivedPongCount", ViewHierarchyNode.JsonKeys.Y, "awaitingPong", "Lsdk/pendo/io/a3/e;", "taskRunner", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/Request;Lokhttp3/WebSocketListener;Ljava/util/Random;JLokhttp3/internal/ws/WebSocketExtensions;J)V", "z", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class d implements h0, g.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b0 originalRequest;

    /* renamed from: b, reason: from kotlin metadata */
    private final i0 listener;

    /* renamed from: c, reason: from kotlin metadata */
    private final Random random;

    /* renamed from: d, reason: from kotlin metadata */
    private final long pingIntervalMillis;

    /* renamed from: e, reason: from kotlin metadata */
    private sdk.pendo.io.j3.e extensions;

    /* renamed from: f, reason: from kotlin metadata */
    private long minimumDeflateSize;

    /* renamed from: g, reason: from kotlin metadata */
    private final String key;

    /* renamed from: h, reason: from kotlin metadata */
    private sdk.pendo.io.w2.e call;

    /* renamed from: i, reason: from kotlin metadata */
    private sdk.pendo.io.a3.a writerTask;

    /* renamed from: j, reason: from kotlin metadata */
    private sdk.pendo.io.j3.g reader;

    /* renamed from: k, reason: from kotlin metadata */
    private sdk.pendo.io.j3.h writer;

    /* renamed from: l, reason: from kotlin metadata */
    private sdk.pendo.io.a3.d taskQueue;

    /* renamed from: m, reason: from kotlin metadata */
    private String name;

    /* renamed from: n, reason: from kotlin metadata */
    private AbstractC0159d streams;

    /* renamed from: o, reason: from kotlin metadata */
    private final ArrayDeque<sdk.pendo.io.k3.g> pongQueue;

    /* renamed from: p, reason: from kotlin metadata */
    private final ArrayDeque<Object> messageAndCloseQueue;

    /* renamed from: q, reason: from kotlin metadata */
    private long queueSize;

    /* renamed from: r, reason: from kotlin metadata */
    private boolean enqueuedClose;

    /* renamed from: s, reason: from kotlin metadata */
    private int receivedCloseCode;

    /* renamed from: t, reason: from kotlin metadata */
    private String receivedCloseReason;

    /* renamed from: u, reason: from kotlin metadata */
    private boolean failed;

    /* renamed from: v, reason: from kotlin metadata */
    private int sentPingCount;

    /* renamed from: w, reason: from kotlin metadata */
    private int receivedPingCount;

    /* renamed from: x, reason: from kotlin metadata */
    private int receivedPongCount;

    /* renamed from: y, reason: from kotlin metadata */
    private boolean awaitingPong;
    private static final List<a0> A = CollectionsKt.listOf(a0.HTTP_1_1);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0003\u0010\u0010¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/j3/d$a;", "", "", "a", "I", "b", "()I", ApiConstant.KEY_CODE, "Lsdk/pendo/io/k3/g;", "Lsdk/pendo/io/k3/g;", "getReason", "()Lokio/ByteString;", DiscardedEvent.JsonKeys.REASON, "", "c", "J", "()J", "cancelAfterCloseMillis", "<init>", "(ILokio/ByteString;J)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int code;

        /* renamed from: b, reason: from kotlin metadata */
        private final sdk.pendo.io.k3.g reason;

        /* renamed from: c, reason: from kotlin metadata */
        private final long cancelAfterCloseMillis;

        public a(int i, sdk.pendo.io.k3.g gVar, long j) {
            this.code = i;
            this.reason = gVar;
            this.cancelAfterCloseMillis = j;
        }

        /* renamed from: a, reason: from getter */
        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        /* renamed from: b, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        /* renamed from: c, reason: from getter */
        public final sdk.pendo.io.k3.g getReason() {
            return this.reason;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/j3/d$c;", "", "", "a", "I", "b", "()I", "formatOpcode", "Lsdk/pendo/io/k3/g;", "Lsdk/pendo/io/k3/g;", "getData", "()Lokio/ByteString;", "data", "<init>", "(ILokio/ByteString;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int formatOpcode;

        /* renamed from: b, reason: from kotlin metadata */
        private final sdk.pendo.io.k3.g data;

        public c(int i, sdk.pendo.io.k3.g data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.formatOpcode = i;
            this.data = data;
        }

        /* renamed from: a, reason: from getter */
        public final sdk.pendo.io.k3.g getData() {
            return this.data;
        }

        /* renamed from: b, reason: from getter */
        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/j3/d$d;", "Ljava/io/Closeable;", "", "f", "Z", "a", "()Z", "client", "Lsdk/pendo/io/k3/f;", "s", "Lsdk/pendo/io/k3/f;", "getSource", "()Lokio/BufferedSource;", "source", "Lsdk/pendo/io/k3/e;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lsdk/pendo/io/k3/e;", "getSink", "()Lokio/BufferedSink;", "sink", "<init>", "(ZLokio/BufferedSource;Lokio/BufferedSink;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    /* renamed from: sdk.pendo.io.j3.d$d, reason: collision with other inner class name */
    public static abstract class AbstractC0159d implements Closeable {

        /* renamed from: A, reason: from kotlin metadata */
        private final sdk.pendo.io.k3.e sink;

        /* renamed from: f, reason: from kotlin metadata */
        private final boolean client;

        /* renamed from: s, reason: from kotlin metadata */
        private final sdk.pendo.io.k3.f source;

        public AbstractC0159d(boolean z, sdk.pendo.io.k3.f source, sdk.pendo.io.k3.e sink) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(sink, "sink");
            this.client = z;
            this.source = source;
            this.sink = sink;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getClient() {
            return this.client;
        }

        /* renamed from: b, reason: from getter */
        public final sdk.pendo.io.k3.e getSink() {
            return this.sink;
        }

        /* renamed from: e, reason: from getter */
        public final sdk.pendo.io.k3.f getSource() {
            return this.source;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lsdk/pendo/io/j3/d$e;", "Lsdk/pendo/io/a3/a;", "", "e", "<init>", "(Lokhttp3/internal/ws/RealWebSocket;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    private final class e extends sdk.pendo.io.a3.a {
        public e() {
            super(d.this.name + " writer", false, 2, null);
        }

        @Override // sdk.pendo.io.a3.a
        public long e() {
            try {
                return d.this.e() ? 0L : -1L;
            } catch (IOException e) {
                d.this.a(e, (d0) null);
                return -1L;
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"sdk/pendo/io/j3/d$f", "Lsdk/pendo/io/w2/f;", "Lsdk/pendo/io/w2/e;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/w2/d0;", Response.TYPE, "", "a", "Ljava/io/IOException;", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class f implements sdk.pendo.io.w2.f {
        final /* synthetic */ b0 b;

        f(b0 b0Var) {
            this.b = b0Var;
        }

        @Override // sdk.pendo.io.w2.f
        public void a(sdk.pendo.io.w2.e call, IOException e) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e, "e");
            d.this.a(e, (d0) null);
        }

        @Override // sdk.pendo.io.w2.f
        public void a(sdk.pendo.io.w2.e call, d0 response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            sdk.pendo.io.b3.c exchange = response.getExchange();
            try {
                d.this.a(response, exchange);
                Intrinsics.checkNotNull(exchange);
                AbstractC0159d l = exchange.l();
                sdk.pendo.io.j3.e a2 = sdk.pendo.io.j3.e.INSTANCE.a(response.getHeaders());
                d.this.extensions = a2;
                if (!d.this.a(a2)) {
                    d dVar = d.this;
                    synchronized (dVar) {
                        dVar.messageAndCloseQueue.clear();
                        dVar.a(PointerIconCompat.TYPE_ALIAS, "unexpected Sec-WebSocket-Extensions in response header");
                    }
                }
                try {
                    d.this.a(sdk.pendo.io.x2.b.i + " WebSocket " + this.b.i().n(), l);
                    d.this.getListener().a(d.this, response);
                    d.this.c();
                } catch (Exception e) {
                    d.this.a(e, (d0) null);
                }
            } catch (IOException e2) {
                d.this.a(e2, response);
                sdk.pendo.io.x2.b.a((Closeable) response);
                if (exchange != null) {
                    exchange.p();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"sdk/pendo/io/j3/d$g", "Lsdk/pendo/io/a3/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class g extends sdk.pendo.io.a3.a {
        final /* synthetic */ d e;
        final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, d dVar, long j) {
            super(str, false, 2, null);
            this.e = dVar;
            this.f = j;
        }

        @Override // sdk.pendo.io.a3.a
        public long e() {
            this.e.f();
            return this.f;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/a3/c", "Lsdk/pendo/io/a3/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class h extends sdk.pendo.io.a3.a {
        final /* synthetic */ d e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, boolean z, d dVar) {
            super(str, z);
            this.e = dVar;
        }

        @Override // sdk.pendo.io.a3.a
        public long e() {
            this.e.a();
            return -1L;
        }
    }

    public d(sdk.pendo.io.a3.e taskRunner, b0 originalRequest, i0 listener, Random random, long j, sdk.pendo.io.j3.e eVar, long j2) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(random, "random");
        this.originalRequest = originalRequest;
        this.listener = listener;
        this.random = random;
        this.pingIntervalMillis = j;
        this.extensions = eVar;
        this.minimumDeflateSize = j2;
        this.taskQueue = taskRunner.e();
        this.pongQueue = new ArrayDeque<>();
        this.messageAndCloseQueue = new ArrayDeque<>();
        this.receivedCloseCode = -1;
        if (!Intrinsics.areEqual("GET", originalRequest.getIo.sentry.protocol.Request.JsonKeys.METHOD java.lang.String())) {
            throw new IllegalArgumentException(("Request must be GET: " + originalRequest.getIo.sentry.protocol.Request.JsonKeys.METHOD java.lang.String()).toString());
        }
        g.Companion companion = sdk.pendo.io.k3.g.INSTANCE;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        Unit unit = Unit.INSTANCE;
        this.key = g.Companion.a(companion, bArr, 0, 0, 3, null).a();
    }

    public final void c() {
        while (this.receivedCloseCode == -1) {
            sdk.pendo.io.j3.g gVar = this.reader;
            Intrinsics.checkNotNull(gVar);
            gVar.a();
        }
    }

    @Override // sdk.pendo.io.j3.g.a
    public synchronized void d(sdk.pendo.io.k3.g payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
            this.pongQueue.add(payload);
            d();
            this.receivedPingCount++;
        }
    }

    public final boolean e() {
        String str;
        sdk.pendo.io.j3.g gVar;
        sdk.pendo.io.j3.h hVar;
        int i;
        AbstractC0159d abstractC0159d;
        synchronized (this) {
            if (this.failed) {
                return false;
            }
            sdk.pendo.io.j3.h hVar2 = this.writer;
            sdk.pendo.io.k3.g poll = this.pongQueue.poll();
            Object obj = null;
            if (poll == null) {
                Object poll2 = this.messageAndCloseQueue.poll();
                if (poll2 instanceof a) {
                    i = this.receivedCloseCode;
                    str = this.receivedCloseReason;
                    if (i != -1) {
                        abstractC0159d = this.streams;
                        this.streams = null;
                        gVar = this.reader;
                        this.reader = null;
                        hVar = this.writer;
                        this.writer = null;
                        this.taskQueue.i();
                    } else {
                        long cancelAfterCloseMillis = ((a) poll2).getCancelAfterCloseMillis();
                        this.taskQueue.a(new h(this.name + " cancel", true, this), TimeUnit.MILLISECONDS.toNanos(cancelAfterCloseMillis));
                        abstractC0159d = null;
                        gVar = null;
                        hVar = null;
                    }
                } else {
                    if (poll2 == null) {
                        return false;
                    }
                    str = null;
                    gVar = null;
                    hVar = null;
                    i = -1;
                    abstractC0159d = null;
                }
                obj = poll2;
            } else {
                str = null;
                gVar = null;
                hVar = null;
                i = -1;
                abstractC0159d = null;
            }
            Unit unit = Unit.INSTANCE;
            try {
                if (poll != null) {
                    Intrinsics.checkNotNull(hVar2);
                    hVar2.c(poll);
                } else if (obj instanceof c) {
                    c cVar = (c) obj;
                    Intrinsics.checkNotNull(hVar2);
                    hVar2.c(cVar.getFormatOpcode(), cVar.getData());
                    synchronized (this) {
                        this.queueSize -= cVar.getData().l();
                        Unit unit2 = Unit.INSTANCE;
                    }
                } else {
                    if (!(obj instanceof a)) {
                        throw new AssertionError();
                    }
                    a aVar = (a) obj;
                    Intrinsics.checkNotNull(hVar2);
                    hVar2.a(aVar.getCode(), aVar.getReason());
                    if (abstractC0159d != null) {
                        i0 i0Var = this.listener;
                        Intrinsics.checkNotNull(str);
                        i0Var.a(this, i, str);
                    }
                }
                return true;
            } finally {
                if (abstractC0159d != null) {
                    sdk.pendo.io.x2.b.a(abstractC0159d);
                }
                if (gVar != null) {
                    sdk.pendo.io.x2.b.a(gVar);
                }
                if (hVar != null) {
                    sdk.pendo.io.x2.b.a(hVar);
                }
            }
        }
    }

    public final void f() {
        synchronized (this) {
            if (this.failed) {
                return;
            }
            sdk.pendo.io.j3.h hVar = this.writer;
            if (hVar == null) {
                return;
            }
            int i = this.awaitingPong ? this.sentPingCount : -1;
            this.sentPingCount++;
            this.awaitingPong = true;
            Unit unit = Unit.INSTANCE;
            if (i != -1) {
                a(new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (i - 1) + " successful ping/pongs)"), (d0) null);
                return;
            }
            try {
                hVar.b(sdk.pendo.io.k3.g.t0);
            } catch (IOException e2) {
                a(e2, (d0) null);
            }
        }
    }

    private final void d() {
        if (sdk.pendo.io.x2.b.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        sdk.pendo.io.a3.a aVar = this.writerTask;
        if (aVar != null) {
            sdk.pendo.io.a3.d.a(this.taskQueue, aVar, 0L, 2, null);
        }
    }

    @Override // sdk.pendo.io.w2.h0
    public boolean c(sdk.pendo.io.k3.g bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return a(bytes, 2);
    }

    public void a() {
        sdk.pendo.io.w2.e eVar = this.call;
        Intrinsics.checkNotNull(eVar);
        eVar.cancel();
    }

    /* renamed from: b, reason: from getter */
    public final i0 getListener() {
        return this.listener;
    }

    public final void a(d0 response, sdk.pendo.io.b3.c exchange) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.getCom.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.getCom.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String() + ' ' + response.getMessage() + '\'');
        }
        String a2 = d0.a(response, "Connection", null, 2, null);
        if (!StringsKt.equals("Upgrade", a2, true)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + a2 + '\'');
        }
        String a3 = d0.a(response, "Upgrade", null, 2, null);
        if (!StringsKt.equals("websocket", a3, true)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + a3 + '\'');
        }
        String a4 = d0.a(response, "Sec-WebSocket-Accept", null, 2, null);
        String a5 = sdk.pendo.io.k3.g.INSTANCE.b(this.key + WebSocketProtocol.ACCEPT_MAGIC).j().a();
        if (!Intrinsics.areEqual(a5, a4)) {
            throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + a5 + "' but was '" + a4 + '\'');
        }
        if (exchange == null) {
            throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
        }
    }

    @Override // sdk.pendo.io.j3.g.a
    public void b(int code, String reason) {
        AbstractC0159d abstractC0159d;
        sdk.pendo.io.j3.g gVar;
        sdk.pendo.io.j3.h hVar;
        Intrinsics.checkNotNullParameter(reason, "reason");
        boolean z = true;
        if (!(code != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        synchronized (this) {
            if (this.receivedCloseCode != -1) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("already closed".toString());
            }
            this.receivedCloseCode = code;
            this.receivedCloseReason = reason;
            abstractC0159d = null;
            if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                AbstractC0159d abstractC0159d2 = this.streams;
                this.streams = null;
                gVar = this.reader;
                this.reader = null;
                hVar = this.writer;
                this.writer = null;
                this.taskQueue.i();
                abstractC0159d = abstractC0159d2;
            } else {
                gVar = null;
                hVar = null;
            }
            Unit unit = Unit.INSTANCE;
        }
        try {
            this.listener.b(this, code, reason);
            if (abstractC0159d != null) {
                this.listener.a(this, code, reason);
            }
        } finally {
            if (abstractC0159d != null) {
                sdk.pendo.io.x2.b.a(abstractC0159d);
            }
            if (gVar != null) {
                sdk.pendo.io.x2.b.a(gVar);
            }
            if (hVar != null) {
                sdk.pendo.io.x2.b.a(hVar);
            }
        }
    }

    @Override // sdk.pendo.io.w2.h0
    public boolean a(int code, String reason) {
        return a(code, reason, DateUtils.MILLIS_PER_MINUTE);
    }

    @Override // sdk.pendo.io.j3.g.a
    public void b(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.listener.a(this, text);
    }

    public final synchronized boolean a(int code, String reason, long cancelAfterCloseMillis) {
        sdk.pendo.io.k3.g gVar;
        sdk.pendo.io.j3.f.f1225a.b(code);
        if (reason != null) {
            gVar = sdk.pendo.io.k3.g.INSTANCE.b(reason);
            if (!(((long) gVar.l()) <= 123)) {
                throw new IllegalArgumentException(("reason.size() > 123: " + reason).toString());
            }
        } else {
            gVar = null;
        }
        if (!this.failed && !this.enqueuedClose) {
            this.enqueuedClose = true;
            this.messageAndCloseQueue.add(new a(code, gVar, cancelAfterCloseMillis));
            d();
            return true;
        }
        return false;
    }

    @Override // sdk.pendo.io.j3.g.a
    public synchronized void b(sdk.pendo.io.k3.g payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public final void a(z client) {
        Intrinsics.checkNotNullParameter(client, "client");
        if (this.originalRequest.a("Sec-WebSocket-Extensions") != null) {
            a(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), (d0) null);
            return;
        }
        z a2 = client.y().a(r.b).a(A).a();
        b0 a3 = this.originalRequest.h().b("Upgrade", "websocket").b("Connection", "Upgrade").b("Sec-WebSocket-Key", this.key).b("Sec-WebSocket-Version", "13").b("Sec-WebSocket-Extensions", "permessage-deflate").a();
        sdk.pendo.io.b3.e eVar = new sdk.pendo.io.b3.e(a2, a3, true);
        this.call = eVar;
        Intrinsics.checkNotNull(eVar);
        eVar.a(new f(a3));
    }

    public final void a(Exception e2, d0 response) {
        Intrinsics.checkNotNullParameter(e2, "e");
        synchronized (this) {
            if (this.failed) {
                return;
            }
            this.failed = true;
            AbstractC0159d abstractC0159d = this.streams;
            this.streams = null;
            sdk.pendo.io.j3.g gVar = this.reader;
            this.reader = null;
            sdk.pendo.io.j3.h hVar = this.writer;
            this.writer = null;
            this.taskQueue.i();
            Unit unit = Unit.INSTANCE;
            try {
                this.listener.a(this, e2, response);
            } finally {
                if (abstractC0159d != null) {
                    sdk.pendo.io.x2.b.a(abstractC0159d);
                }
                if (gVar != null) {
                    sdk.pendo.io.x2.b.a(gVar);
                }
                if (hVar != null) {
                    sdk.pendo.io.x2.b.a(hVar);
                }
            }
        }
    }

    public final void a(String name, AbstractC0159d streams) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(streams, "streams");
        sdk.pendo.io.j3.e eVar = this.extensions;
        Intrinsics.checkNotNull(eVar);
        synchronized (this) {
            this.name = name;
            this.streams = streams;
            this.writer = new sdk.pendo.io.j3.h(streams.getClient(), streams.getSink(), this.random, eVar.perMessageDeflate, eVar.a(streams.getClient()), this.minimumDeflateSize);
            this.writerTask = new e();
            long j = this.pingIntervalMillis;
            if (j != 0) {
                long nanos = TimeUnit.MILLISECONDS.toNanos(j);
                this.taskQueue.a(new g(name + " ping", this, nanos), nanos);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                d();
            }
            Unit unit = Unit.INSTANCE;
        }
        this.reader = new sdk.pendo.io.j3.g(streams.getClient(), streams.getSource(), this, eVar.perMessageDeflate, eVar.a(!streams.getClient()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(sdk.pendo.io.j3.e eVar) {
        if (!eVar.unknownValues && eVar.clientMaxWindowBits == null) {
            return eVar.serverMaxWindowBits == null || new IntRange(8, 15).contains(eVar.serverMaxWindowBits.intValue());
        }
        return false;
    }

    @Override // sdk.pendo.io.j3.g.a
    public void a(sdk.pendo.io.k3.g bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.listener.a(this, bytes);
    }

    @Override // sdk.pendo.io.w2.h0
    public boolean a(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return a(sdk.pendo.io.k3.g.INSTANCE.b(text), 1);
    }

    private final synchronized boolean a(sdk.pendo.io.k3.g data, int formatOpcode) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + data.l() > 16777216) {
                a(1001, (String) null);
                return false;
            }
            this.queueSize += data.l();
            this.messageAndCloseQueue.add(new c(formatOpcode, data));
            d();
            return true;
        }
        return false;
    }
}
