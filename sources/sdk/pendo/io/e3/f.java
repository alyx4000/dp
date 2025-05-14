package sdk.pendo.io.e3;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.iterable.iterableapi.IterableConstants;
import expo.modules.updates.UpdatesConfiguration;
import io.sentry.SentryEnvelopeItemHeader;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import sdk.pendo.io.e3.h;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ©\u00012\u00020\u0001:\u0004\n \u0010SB\u0015\b\u0000\u0012\b\u0010¦\u0001\u001a\u00030¥\u0001¢\u0006\u0006\b§\u0001\u0010¨\u0001J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\n\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u0002J\u0019\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\n\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007J-\u0010\n\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\n\u0010\u0018J(\u0010\n\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u0012J\u001f\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\u0010\u0010\u001eJ\u001f\u0010 \u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001cH\u0000¢\u0006\u0004\b \u0010\u001eJ\u001f\u0010\n\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\n\u0010\"J\u001e\u0010\n\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0002J\u0006\u0010&\u001a\u00020\rJ\u000e\u0010\n\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001cJ\b\u0010'\u001a\u00020\rH\u0016J)\u0010\n\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0004\b\n\u0010+J\u001c\u0010\n\u001a\u00020\r2\b\b\u0002\u0010,\u001a\u00020\u00072\b\b\u0002\u0010.\u001a\u00020-H\u0007J\u000e\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0012J\u000f\u00101\u001a\u00020\rH\u0000¢\u0006\u0004\b1\u00102J\u0017\u0010 \u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b \u00103J%\u0010\n\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\b\n\u00104J-\u0010 \u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u00105\u001a\u00020\u0007H\u0000¢\u0006\u0004\b \u00106J/\u0010\n\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u00108\u001a\u0002072\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u00109J\u001f\u0010\n\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\n\u0010\u001eR\u001a\u0010=\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b \u0010<R\u001a\u0010C\u001a\u00020>8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR&\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0D8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001a\u0010N\u001a\u00020J8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\b\f\u0010MR\"\u0010U\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\"\u0010Y\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bV\u0010P\u001a\u0004\bW\u0010R\"\u0004\bX\u0010TR\u0016\u0010[\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010;R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010a\u001a\u00020^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010c\u001a\u00020^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010`R\u0014\u0010e\u001a\u00020^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010`R\u0014\u0010i\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010l\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010n\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010kR\u0016\u0010p\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010kR\u0016\u0010r\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010kR\u0016\u0010t\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010kR\u0016\u0010v\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010kR\u0017\u0010|\u001a\u00020w8\u0006¢\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{R$\u0010\u0081\u0001\u001a\u00020w8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b}\u0010y\u001a\u0004\b~\u0010{\"\u0005\b\u007f\u0010\u0080\u0001R)\u0010\u0086\u0001\u001a\u00020\u00122\u0007\u0010\u0082\u0001\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0005\b\u0083\u0001\u0010k\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R)\u0010\u0089\u0001\u001a\u00020\u00122\u0007\u0010\u0082\u0001\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0005\b\u0087\u0001\u0010k\u001a\u0006\b\u0088\u0001\u0010\u0085\u0001R)\u0010\u008c\u0001\u001a\u00020\u00122\u0007\u0010\u0082\u0001\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0005\b\u008a\u0001\u0010k\u001a\u0006\b\u008b\u0001\u0010\u0085\u0001R(\u0010\u008e\u0001\u001a\u00020\u00122\u0007\u0010\u0082\u0001\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\u000e\n\u0005\b\u008d\u0001\u0010k\u001a\u0005\b?\u0010\u0085\u0001R \u0010\u0094\u0001\u001a\u00030\u008f\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001d\u0010\u009a\u0001\u001a\u00030\u0095\u00018\u0006¢\u0006\u0010\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R!\u0010 \u0001\u001a\u00070\u009b\u0001R\u00020\u00008\u0006¢\u0006\u0010\n\u0006\b\u009c\u0001\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001e\u0010¤\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020¡\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001¨\u0006ª\u0001"}, d2 = {"Lsdk/pendo/io/e3/f;", "Ljava/io/Closeable;", "", "associatedStreamId", "", "Lsdk/pendo/io/e3/c;", UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, "", "out", "Lsdk/pendo/io/e3/i;", "a", "Ljava/io/IOException;", "e", "", "id", "streamId", "c", "(I)Lsdk/pendo/io/e3/i;", "", IterableConstants.ITERABLE_IN_APP_READ, ContextChain.TAG_INFRA, "(J)V", "outFinished", "alternating", "(IZLjava/util/List;)V", "Lsdk/pendo/io/k3/d;", "buffer", "byteCount", "Lsdk/pendo/io/e3/b;", "errorCode", "(ILsdk/pendo/io/e3/b;)V", "statusCode", "b", "unacknowledgedBytesRead", "(IJ)V", "reply", "payload1", "payload2", "flush", "close", "connectionCode", "streamCode", "cause", "(Lsdk/pendo/io/e3/b;Lsdk/pendo/io/e3/b;Ljava/io/IOException;)V", "sendConnectionPreface", "Lsdk/pendo/io/a3/e;", "taskRunner", "nowNs", "h", "u", "()V", "(I)Z", "(ILjava/util/List;)V", "inFinished", "(ILjava/util/List;Z)V", "Lsdk/pendo/io/k3/f;", "source", "(ILsdk/pendo/io/k3/f;IZ)V", "f", "Z", "()Z", "client", "Lsdk/pendo/io/e3/f$c;", "s", "Lsdk/pendo/io/e3/f$c;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/util/Map;", "r", "()Ljava/util/Map;", "streams", "", "f0", "Ljava/lang/String;", "()Ljava/lang/String;", "connectionName", "t0", "I", "m", "()I", "d", "(I)V", "lastGoodStreamId", "u0", "o", "setNextStreamId$okhttp", "nextStreamId", "v0", "isShutdown", "w0", "Lsdk/pendo/io/a3/e;", "Lsdk/pendo/io/a3/d;", "x0", "Lsdk/pendo/io/a3/d;", "writerQueue", "y0", "pushQueue", "z0", "settingsListenerQueue", "Lsdk/pendo/io/e3/l;", "A0", "Lsdk/pendo/io/e3/l;", "pushObserver", "B0", "J", "intervalPingsSent", "C0", "intervalPongsReceived", "D0", "degradedPingsSent", "E0", "degradedPongsReceived", "F0", "awaitPongsReceived", "G0", "degradedPongDeadlineNs", "Lsdk/pendo/io/e3/m;", "H0", "Lsdk/pendo/io/e3/m;", "getOkHttpSettings", "()Lokhttp3/internal/http2/Settings;", "okHttpSettings", "I0", "getPeerSettings", "setPeerSettings", "(Lokhttp3/internal/http2/Settings;)V", "peerSettings", "<set-?>", "J0", "getReadBytesTotal", "()J", "readBytesTotal", "K0", "getReadBytesAcknowledged", "readBytesAcknowledged", "L0", "getWriteBytesTotal", "writeBytesTotal", "M0", "writeBytesMaximum", "Ljava/net/Socket;", "N0", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "socket", "Lsdk/pendo/io/e3/j;", "O0", "Lsdk/pendo/io/e3/j;", "getWriter", "()Lokhttp3/internal/http2/Http2Writer;", "writer", "Lsdk/pendo/io/e3/f$d;", "P0", "Lsdk/pendo/io/e3/f$d;", "getReaderRunnable", "()Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "readerRunnable", "", "Q0", "Ljava/util/Set;", "currentPushRequests", "Lsdk/pendo/io/e3/f$a;", "builder", "<init>", "(Lokhttp3/internal/http2/Http2Connection$Builder;)V", "R0", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class f implements Closeable {

    /* renamed from: R0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final m S0;

    /* renamed from: A, reason: from kotlin metadata */
    private final Map<Integer, sdk.pendo.io.e3.i> streams;

    /* renamed from: A0, reason: from kotlin metadata */
    private final sdk.pendo.io.e3.l pushObserver;

    /* renamed from: B0, reason: from kotlin metadata */
    private long intervalPingsSent;

    /* renamed from: C0, reason: from kotlin metadata */
    private long intervalPongsReceived;

    /* renamed from: D0, reason: from kotlin metadata */
    private long degradedPingsSent;

    /* renamed from: E0, reason: from kotlin metadata */
    private long degradedPongsReceived;

    /* renamed from: F0, reason: from kotlin metadata */
    private long awaitPongsReceived;

    /* renamed from: G0, reason: from kotlin metadata */
    private long degradedPongDeadlineNs;

    /* renamed from: H0, reason: from kotlin metadata */
    private final m okHttpSettings;

    /* renamed from: I0, reason: from kotlin metadata */
    private m peerSettings;

    /* renamed from: J0, reason: from kotlin metadata */
    private long readBytesTotal;

    /* renamed from: K0, reason: from kotlin metadata */
    private long readBytesAcknowledged;

    /* renamed from: L0, reason: from kotlin metadata */
    private long writeBytesTotal;

    /* renamed from: M0, reason: from kotlin metadata */
    private long writeBytesMaximum;

    /* renamed from: N0, reason: from kotlin metadata */
    private final Socket socket;

    /* renamed from: O0, reason: from kotlin metadata */
    private final sdk.pendo.io.e3.j writer;

    /* renamed from: P0, reason: from kotlin metadata */
    private final d readerRunnable;

    /* renamed from: Q0, reason: from kotlin metadata */
    private final Set<Integer> currentPushRequests;

    /* renamed from: f, reason: from kotlin metadata */
    private final boolean client;

    /* renamed from: f0, reason: from kotlin metadata */
    private final String connectionName;

    /* renamed from: s, reason: from kotlin metadata */
    private final c listener;

    /* renamed from: t0, reason: from kotlin metadata */
    private int lastGoodStreamId;

    /* renamed from: u0, reason: from kotlin metadata */
    private int nextStreamId;

    /* renamed from: v0, reason: from kotlin metadata */
    private boolean isShutdown;

    /* renamed from: w0, reason: from kotlin metadata */
    private final sdk.pendo.io.a3.e taskRunner;

    /* renamed from: x0, reason: from kotlin metadata */
    private final sdk.pendo.io.a3.d writerQueue;

    /* renamed from: y0, reason: from kotlin metadata */
    private final sdk.pendo.io.a3.d pushQueue;

    /* renamed from: z0, reason: from kotlin metadata */
    private final sdk.pendo.io.a3.d settingsListenerQueue;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0017¢\u0006\u0004\bD\u0010EJ.\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\n\u001a\u00020\u000fR\"\u0010\u0016\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001b\u001a\u00020\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b\n\u0010 R\"\u0010%\u001a\u00020\u00048\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u001c\u0010#\"\u0004\b\n\u0010$R\"\u0010\u0007\u001a\u00020\u00068\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010\t\u001a\u00020\b8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010\f\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010>\u001a\u0002088\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010\u000e\u001a\u00020\r8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\b&\u0010A\"\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lsdk/pendo/io/e3/f$a;", "", "Ljava/net/Socket;", "socket", "", "peerName", "Lsdk/pendo/io/k3/f;", "source", "Lsdk/pendo/io/k3/e;", "sink", "a", "Lsdk/pendo/io/e3/f$c;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "pingIntervalMillis", "Lsdk/pendo/io/e3/f;", "", "Z", "b", "()Z", "setClient$okhttp", "(Z)V", "client", "Lsdk/pendo/io/a3/e;", "Lsdk/pendo/io/a3/e;", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "c", "Ljava/net/Socket;", "h", "()Ljava/net/Socket;", "(Ljava/net/Socket;)V", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "connectionName", "e", "Lsdk/pendo/io/k3/f;", "getSource$okhttp", "()Lokio/BufferedSource;", "setSource$okhttp", "(Lokio/BufferedSource;)V", "f", "Lsdk/pendo/io/k3/e;", "getSink$okhttp", "()Lokio/BufferedSink;", "setSink$okhttp", "(Lokio/BufferedSink;)V", "g", "Lsdk/pendo/io/e3/f$c;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "setListener$okhttp", "(Lokhttp3/internal/http2/Http2Connection$Listener;)V", "Lsdk/pendo/io/e3/l;", "Lsdk/pendo/io/e3/l;", "getPushObserver$okhttp", "()Lokhttp3/internal/http2/PushObserver;", "setPushObserver$okhttp", "(Lokhttp3/internal/http2/PushObserver;)V", "pushObserver", ContextChain.TAG_INFRA, "I", "()I", "setPingIntervalMillis$okhttp", "(I)V", "<init>", "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean client;

        /* renamed from: b, reason: from kotlin metadata */
        private final sdk.pendo.io.a3.e taskRunner;

        /* renamed from: c, reason: from kotlin metadata */
        public Socket socket;

        /* renamed from: d, reason: from kotlin metadata */
        public String connectionName;

        /* renamed from: e, reason: from kotlin metadata */
        public sdk.pendo.io.k3.f source;

        /* renamed from: f, reason: from kotlin metadata */
        public sdk.pendo.io.k3.e sink;

        /* renamed from: g, reason: from kotlin metadata */
        private c listener;

        /* renamed from: h, reason: from kotlin metadata */
        private sdk.pendo.io.e3.l pushObserver;

        /* renamed from: i, reason: from kotlin metadata */
        private int pingIntervalMillis;

        public a(boolean z, sdk.pendo.io.a3.e taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            this.client = z;
            this.taskRunner = taskRunner;
            this.listener = c.b;
            this.pushObserver = sdk.pendo.io.e3.l.b;
        }

        public final f a() {
            return new f(this);
        }

        /* renamed from: b, reason: from getter */
        public final boolean getClient() {
            return this.client;
        }

        public final String c() {
            String str = this.connectionName;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("connectionName");
            return null;
        }

        /* renamed from: d, reason: from getter */
        public final c getListener() {
            return this.listener;
        }

        /* renamed from: e, reason: from getter */
        public final int getPingIntervalMillis() {
            return this.pingIntervalMillis;
        }

        /* renamed from: f, reason: from getter */
        public final sdk.pendo.io.e3.l getPushObserver() {
            return this.pushObserver;
        }

        public final sdk.pendo.io.k3.e g() {
            sdk.pendo.io.k3.e eVar = this.sink;
            if (eVar != null) {
                return eVar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("sink");
            return null;
        }

        public final Socket h() {
            Socket socket = this.socket;
            if (socket != null) {
                return socket;
            }
            Intrinsics.throwUninitializedPropertyAccessException("socket");
            return null;
        }

        public final sdk.pendo.io.k3.f i() {
            sdk.pendo.io.k3.f fVar = this.source;
            if (fVar != null) {
                return fVar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("source");
            return null;
        }

        /* renamed from: j, reason: from getter */
        public final sdk.pendo.io.a3.e getTaskRunner() {
            return this.taskRunner;
        }

        public final a a(c listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listener = listener;
            return this;
        }

        public final a a(int pingIntervalMillis) {
            this.pingIntervalMillis = pingIntervalMillis;
            return this;
        }

        public final void a(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.connectionName = str;
        }

        public final void a(sdk.pendo.io.k3.e eVar) {
            Intrinsics.checkNotNullParameter(eVar, "<set-?>");
            this.sink = eVar;
        }

        public final void a(Socket socket) {
            Intrinsics.checkNotNullParameter(socket, "<set-?>");
            this.socket = socket;
        }

        public final void a(sdk.pendo.io.k3.f fVar) {
            Intrinsics.checkNotNullParameter(fVar, "<set-?>");
            this.source = fVar;
        }

        public final a a(Socket socket, String peerName, sdk.pendo.io.k3.f source, sdk.pendo.io.k3.e sink) {
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(peerName, "peerName");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(sink, "sink");
            a(socket);
            a((this.client ? new StringBuilder().append(sdk.pendo.io.x2.b.i).append(' ') : new StringBuilder("MockWebServer ")).append(peerName).toString());
            a(source);
            a(sink);
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0004¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/e3/f$b;", "", "", "AWAIT_PING", "I", "Lsdk/pendo/io/e3/m;", "DEFAULT_SETTINGS", "Lsdk/pendo/io/e3/m;", "getDEFAULT_SETTINGS", "()Lokhttp3/internal/http2/Settings;", "DEGRADED_PING", "DEGRADED_PONG_TIMEOUT_NS", "INTERVAL_PING", "OKHTTP_CLIENT_WINDOW_SIZE", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    /* renamed from: sdk.pendo.io.e3.f$b, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final m a() {
            return f.S0;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00052\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\r"}, d2 = {"Lsdk/pendo/io/e3/f$c;", "", "Lsdk/pendo/io/e3/i;", "stream", "", "a", "Lsdk/pendo/io/e3/f;", "connection", "Lsdk/pendo/io/e3/m;", "settings", "<init>", "()V", "b", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static abstract class c {
        public static final c b = new a();

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"sdk/pendo/io/e3/f$c$a", "Lsdk/pendo/io/e3/f$c;", "Lsdk/pendo/io/e3/i;", "stream", "", "a", "okhttp"}, k = 1, mv = {1, 8, 0})
        public static final class a extends c {
            a() {
            }

            @Override // sdk.pendo.io.e3.f.c
            public void a(sdk.pendo.io.e3.i stream) {
                Intrinsics.checkNotNullParameter(stream, "stream");
                stream.a(b.REFUSED_STREAM, (IOException) null);
            }
        }

        public void a(f connection, m settings) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            Intrinsics.checkNotNullParameter(settings, "settings");
        }

        public abstract void a(sdk.pendo.io.e3.i stream);
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0011\b\u0000\u0012\u0006\u0010(\u001a\u00020#¢\u0006\u0004\b)\u0010*J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J.\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\f\u001a\u00020\u0003H\u0016J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0005H\u0016J&\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016R\u001a\u0010(\u001a\u00020#8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lsdk/pendo/io/e3/f$d;", "Lsdk/pendo/io/e3/h$c;", "Lkotlin/Function0;", "", "b", "", "inFinished", "", "streamId", "Lsdk/pendo/io/k3/f;", "source", SentryEnvelopeItemHeader.JsonKeys.LENGTH, "a", "associatedStreamId", "", "Lsdk/pendo/io/e3/c;", "headerBlock", "Lsdk/pendo/io/e3/b;", "errorCode", "clearPrevious", "Lsdk/pendo/io/e3/m;", "settings", "ack", "payload1", "payload2", "lastGoodStreamId", "Lsdk/pendo/io/k3/g;", "debugData", "", "windowSizeIncrement", "streamDependency", "weight", "exclusive", "promisedStreamId", UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, "Lsdk/pendo/io/e3/h;", "f", "Lsdk/pendo/io/e3/h;", "getReader$okhttp", "()Lokhttp3/internal/http2/Http2Reader;", "reader", "<init>", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Http2Reader;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public final class d implements h.c, Function0<Unit> {

        /* renamed from: f, reason: from kotlin metadata */
        private final sdk.pendo.io.e3.h reader;
        final /* synthetic */ f s;

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/a3/c", "Lsdk/pendo/io/a3/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
        public static final class a extends sdk.pendo.io.a3.a {
            final /* synthetic */ f e;
            final /* synthetic */ Ref.ObjectRef f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, boolean z, f fVar, Ref.ObjectRef objectRef) {
                super(str, z);
                this.e = fVar;
                this.f = objectRef;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // sdk.pendo.io.a3.a
            public long e() {
                this.e.getListener().a(this.e, (m) this.f.element);
                return -1L;
            }
        }

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/a3/c", "Lsdk/pendo/io/a3/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
        public static final class b extends sdk.pendo.io.a3.a {
            final /* synthetic */ f e;
            final /* synthetic */ sdk.pendo.io.e3.i f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, boolean z, f fVar, sdk.pendo.io.e3.i iVar) {
                super(str, z);
                this.e = fVar;
                this.f = iVar;
            }

            @Override // sdk.pendo.io.a3.a
            public long e() {
                try {
                    this.e.getListener().a(this.f);
                    return -1L;
                } catch (IOException e) {
                    sdk.pendo.io.f3.h.INSTANCE.d().a("Http2Connection.Listener failure for " + this.e.getConnectionName(), 4, e);
                    try {
                        this.f.a(sdk.pendo.io.e3.b.PROTOCOL_ERROR, e);
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/a3/c", "Lsdk/pendo/io/a3/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
        public static final class c extends sdk.pendo.io.a3.a {
            final /* synthetic */ f e;
            final /* synthetic */ int f;
            final /* synthetic */ int g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, boolean z, f fVar, int i, int i2) {
                super(str, z);
                this.e = fVar;
                this.f = i;
                this.g = i2;
            }

            @Override // sdk.pendo.io.a3.a
            public long e() {
                this.e.a(true, this.f, this.g);
                return -1L;
            }
        }

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/a3/c", "Lsdk/pendo/io/a3/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
        /* renamed from: sdk.pendo.io.e3.f$d$d, reason: collision with other inner class name */
        public static final class C0118d extends sdk.pendo.io.a3.a {
            final /* synthetic */ d e;
            final /* synthetic */ boolean f;
            final /* synthetic */ m g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0118d(String str, boolean z, d dVar, boolean z2, m mVar) {
                super(str, z);
                this.e = dVar;
                this.f = z2;
                this.g = mVar;
            }

            @Override // sdk.pendo.io.a3.a
            public long e() {
                this.e.b(this.f, this.g);
                return -1L;
            }
        }

        public d(f fVar, sdk.pendo.io.e3.h reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            this.s = fVar;
            this.reader = reader;
        }

        @Override // sdk.pendo.io.e3.h.c
        public void a() {
        }

        @Override // sdk.pendo.io.e3.h.c
        public void a(int streamId, int streamDependency, int weight, boolean exclusive) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v1 */
        /* JADX WARN: Type inference failed for: r13v2, types: [T, sdk.pendo.io.e3.m] */
        /* JADX WARN: Type inference failed for: r13v3 */
        public final void b(boolean clearPrevious, m settings) {
            ?? r13;
            long b2;
            int i;
            sdk.pendo.io.e3.i[] iVarArr;
            Intrinsics.checkNotNullParameter(settings, "settings");
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            sdk.pendo.io.e3.j writer = this.s.getWriter();
            f fVar = this.s;
            synchronized (writer) {
                synchronized (fVar) {
                    m peerSettings = fVar.getPeerSettings();
                    if (clearPrevious) {
                        r13 = settings;
                    } else {
                        m mVar = new m();
                        mVar.a(peerSettings);
                        mVar.a(settings);
                        r13 = mVar;
                    }
                    objectRef.element = r13;
                    b2 = r13.b() - peerSettings.b();
                    if (b2 != 0 && !fVar.r().isEmpty()) {
                        iVarArr = (sdk.pendo.io.e3.i[]) fVar.r().values().toArray(new sdk.pendo.io.e3.i[0]);
                        fVar.a((m) objectRef.element);
                        fVar.settingsListenerQueue.a(new a(fVar.getConnectionName() + " onSettings", true, fVar, objectRef), 0L);
                        Unit unit = Unit.INSTANCE;
                    }
                    iVarArr = null;
                    fVar.a((m) objectRef.element);
                    fVar.settingsListenerQueue.a(new a(fVar.getConnectionName() + " onSettings", true, fVar, objectRef), 0L);
                    Unit unit2 = Unit.INSTANCE;
                }
                try {
                    fVar.getWriter().a((m) objectRef.element);
                } catch (IOException e) {
                    fVar.a(e);
                }
                Unit unit3 = Unit.INSTANCE;
            }
            if (iVarArr != null) {
                for (sdk.pendo.io.e3.i iVar : iVarArr) {
                    synchronized (iVar) {
                        iVar.a(b2);
                        Unit unit4 = Unit.INSTANCE;
                    }
                }
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            b();
            return Unit.INSTANCE;
        }

        @Override // sdk.pendo.io.e3.h.c
        public void a(boolean inFinished, int streamId, sdk.pendo.io.k3.f source, int length) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (this.s.b(streamId)) {
                this.s.a(streamId, source, length, inFinished);
                return;
            }
            sdk.pendo.io.e3.i a2 = this.s.a(streamId);
            if (a2 == null) {
                this.s.c(streamId, sdk.pendo.io.e3.b.PROTOCOL_ERROR);
                long j = length;
                this.s.i(j);
                source.skip(j);
                return;
            }
            a2.a(source, length);
            if (inFinished) {
                a2.a(sdk.pendo.io.x2.b.b, true);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [sdk.pendo.io.e3.b] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable, sdk.pendo.io.e3.h] */
        public void b() {
            Throwable th;
            sdk.pendo.io.e3.b bVar;
            sdk.pendo.io.e3.b bVar2;
            sdk.pendo.io.e3.b bVar3 = sdk.pendo.io.e3.b.INTERNAL_ERROR;
            IOException e = null;
            try {
                try {
                    this.reader.a(this);
                    while (this.reader.a(false, (h.c) this)) {
                    }
                    bVar2 = sdk.pendo.io.e3.b.NO_ERROR;
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th2) {
                    th = th2;
                    bVar = bVar3;
                    this.s.a(bVar, bVar3, e);
                    sdk.pendo.io.x2.b.a(this.reader);
                    throw th;
                }
                try {
                    this.s.a(bVar2, sdk.pendo.io.e3.b.CANCEL, (IOException) null);
                    bVar = bVar2;
                } catch (IOException e3) {
                    e = e3;
                    sdk.pendo.io.e3.b bVar4 = sdk.pendo.io.e3.b.PROTOCOL_ERROR;
                    f fVar = this.s;
                    fVar.a(bVar4, bVar4, e);
                    bVar = fVar;
                    bVar3 = this.reader;
                    sdk.pendo.io.x2.b.a((Closeable) bVar3);
                }
                bVar3 = this.reader;
                sdk.pendo.io.x2.b.a((Closeable) bVar3);
            } catch (Throwable th3) {
                th = th3;
                this.s.a(bVar, bVar3, e);
                sdk.pendo.io.x2.b.a(this.reader);
                throw th;
            }
        }

        @Override // sdk.pendo.io.e3.h.c
        public void a(int lastGoodStreamId, sdk.pendo.io.e3.b errorCode, sdk.pendo.io.k3.g debugData) {
            int i;
            Object[] array;
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            Intrinsics.checkNotNullParameter(debugData, "debugData");
            debugData.l();
            f fVar = this.s;
            synchronized (fVar) {
                array = fVar.r().values().toArray(new sdk.pendo.io.e3.i[0]);
                fVar.isShutdown = true;
                Unit unit = Unit.INSTANCE;
            }
            for (sdk.pendo.io.e3.i iVar : (sdk.pendo.io.e3.i[]) array) {
                if (iVar.getId() > lastGoodStreamId && iVar.p()) {
                    iVar.b(sdk.pendo.io.e3.b.REFUSED_STREAM);
                    this.s.c(iVar.getId());
                }
            }
        }

        @Override // sdk.pendo.io.e3.h.c
        public void a(boolean inFinished, int streamId, int associatedStreamId, List<sdk.pendo.io.e3.c> headerBlock) {
            Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
            if (this.s.b(streamId)) {
                this.s.b(streamId, headerBlock, inFinished);
                return;
            }
            f fVar = this.s;
            synchronized (fVar) {
                sdk.pendo.io.e3.i a2 = fVar.a(streamId);
                if (a2 != null) {
                    Unit unit = Unit.INSTANCE;
                    a2.a(sdk.pendo.io.x2.b.a(headerBlock), inFinished);
                    return;
                }
                if (fVar.isShutdown) {
                    return;
                }
                if (streamId <= fVar.getLastGoodStreamId()) {
                    return;
                }
                if (streamId % 2 == fVar.getNextStreamId() % 2) {
                    return;
                }
                sdk.pendo.io.e3.i iVar = new sdk.pendo.io.e3.i(streamId, fVar, false, inFinished, sdk.pendo.io.x2.b.a(headerBlock));
                fVar.d(streamId);
                fVar.r().put(Integer.valueOf(streamId), iVar);
                fVar.taskRunner.e().a(new b(fVar.getConnectionName() + '[' + streamId + "] onStream", true, fVar, iVar), 0L);
            }
        }

        @Override // sdk.pendo.io.e3.h.c
        public void a(boolean ack, int payload1, int payload2) {
            if (!ack) {
                this.s.writerQueue.a(new c(this.s.getConnectionName() + " ping", true, this.s, payload1, payload2), 0L);
                return;
            }
            f fVar = this.s;
            synchronized (fVar) {
                if (payload1 == 1) {
                    fVar.intervalPongsReceived++;
                } else if (payload1 != 2) {
                    if (payload1 == 3) {
                        fVar.awaitPongsReceived++;
                        Intrinsics.checkNotNull(fVar, "null cannot be cast to non-null type java.lang.Object");
                        fVar.notifyAll();
                    }
                    Unit unit = Unit.INSTANCE;
                } else {
                    fVar.degradedPongsReceived++;
                }
            }
        }

        @Override // sdk.pendo.io.e3.h.c
        public void a(int streamId, int promisedStreamId, List<sdk.pendo.io.e3.c> requestHeaders) {
            Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
            this.s.a(promisedStreamId, requestHeaders);
        }

        @Override // sdk.pendo.io.e3.h.c
        public void a(int streamId, sdk.pendo.io.e3.b errorCode) {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            if (this.s.b(streamId)) {
                this.s.a(streamId, errorCode);
                return;
            }
            sdk.pendo.io.e3.i c2 = this.s.c(streamId);
            if (c2 != null) {
                c2.b(errorCode);
            }
        }

        @Override // sdk.pendo.io.e3.h.c
        public void a(boolean clearPrevious, m settings) {
            Intrinsics.checkNotNullParameter(settings, "settings");
            this.s.writerQueue.a(new C0118d(this.s.getConnectionName() + " applyAndAckSettings", true, this, clearPrevious, settings), 0L);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // sdk.pendo.io.e3.h.c
        public void a(int streamId, long windowSizeIncrement) {
            sdk.pendo.io.e3.i iVar;
            if (streamId == 0) {
                f fVar = this.s;
                synchronized (fVar) {
                    fVar.writeBytesMaximum = fVar.getWriteBytesMaximum() + windowSizeIncrement;
                    Intrinsics.checkNotNull(fVar, "null cannot be cast to non-null type java.lang.Object");
                    fVar.notifyAll();
                    Unit unit = Unit.INSTANCE;
                    iVar = fVar;
                }
            } else {
                sdk.pendo.io.e3.i a2 = this.s.a(streamId);
                if (a2 == null) {
                    return;
                }
                synchronized (a2) {
                    a2.a(windowSizeIncrement);
                    Unit unit2 = Unit.INSTANCE;
                    iVar = a2;
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/a3/c", "Lsdk/pendo/io/a3/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class e extends sdk.pendo.io.a3.a {
        final /* synthetic */ f e;
        final /* synthetic */ int f;
        final /* synthetic */ sdk.pendo.io.k3.d g;
        final /* synthetic */ int h;
        final /* synthetic */ boolean i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, boolean z, f fVar, int i, sdk.pendo.io.k3.d dVar, int i2, boolean z2) {
            super(str, z);
            this.e = fVar;
            this.f = i;
            this.g = dVar;
            this.h = i2;
            this.i = z2;
        }

        @Override // sdk.pendo.io.a3.a
        public long e() {
            try {
                boolean a2 = this.e.pushObserver.a(this.f, this.g, this.h, this.i);
                if (a2) {
                    this.e.getWriter().a(this.f, b.CANCEL);
                }
                if (!a2 && !this.i) {
                    return -1L;
                }
                synchronized (this.e) {
                    this.e.currentPushRequests.remove(Integer.valueOf(this.f));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/a3/c", "Lsdk/pendo/io/a3/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    /* renamed from: sdk.pendo.io.e3.f$f, reason: collision with other inner class name */
    public static final class C0119f extends sdk.pendo.io.a3.a {
        final /* synthetic */ f e;
        final /* synthetic */ int f;
        final /* synthetic */ List g;
        final /* synthetic */ boolean h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0119f(String str, boolean z, f fVar, int i, List list, boolean z2) {
            super(str, z);
            this.e = fVar;
            this.f = i;
            this.g = list;
            this.h = z2;
        }

        @Override // sdk.pendo.io.a3.a
        public long e() {
            boolean a2 = this.e.pushObserver.a(this.f, this.g, this.h);
            if (a2) {
                try {
                    this.e.getWriter().a(this.f, b.CANCEL);
                } catch (IOException unused) {
                    return -1L;
                }
            }
            if (!a2 && !this.h) {
                return -1L;
            }
            synchronized (this.e) {
                this.e.currentPushRequests.remove(Integer.valueOf(this.f));
            }
            return -1L;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/a3/c", "Lsdk/pendo/io/a3/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class g extends sdk.pendo.io.a3.a {
        final /* synthetic */ f e;
        final /* synthetic */ int f;
        final /* synthetic */ List g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, boolean z, f fVar, int i, List list) {
            super(str, z);
            this.e = fVar;
            this.f = i;
            this.g = list;
        }

        @Override // sdk.pendo.io.a3.a
        public long e() {
            if (!this.e.pushObserver.a(this.f, this.g)) {
                return -1L;
            }
            try {
                this.e.getWriter().a(this.f, b.CANCEL);
                synchronized (this.e) {
                    this.e.currentPushRequests.remove(Integer.valueOf(this.f));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/a3/c", "Lsdk/pendo/io/a3/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class h extends sdk.pendo.io.a3.a {
        final /* synthetic */ f e;
        final /* synthetic */ int f;
        final /* synthetic */ b g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, boolean z, f fVar, int i, b bVar) {
            super(str, z);
            this.e = fVar;
            this.f = i;
            this.g = bVar;
        }

        @Override // sdk.pendo.io.a3.a
        public long e() {
            this.e.pushObserver.a(this.f, this.g);
            synchronized (this.e) {
                this.e.currentPushRequests.remove(Integer.valueOf(this.f));
                Unit unit = Unit.INSTANCE;
            }
            return -1L;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/a3/c", "Lsdk/pendo/io/a3/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class i extends sdk.pendo.io.a3.a {
        final /* synthetic */ f e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str, boolean z, f fVar) {
            super(str, z);
            this.e = fVar;
        }

        @Override // sdk.pendo.io.a3.a
        public long e() {
            this.e.a(false, 2, 0);
            return -1L;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"sdk/pendo/io/e3/f$j", "Lsdk/pendo/io/a3/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class j extends sdk.pendo.io.a3.a {
        final /* synthetic */ f e;
        final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, f fVar, long j) {
            super(str, false, 2, null);
            this.e = fVar;
            this.f = j;
        }

        @Override // sdk.pendo.io.a3.a
        public long e() {
            boolean z;
            synchronized (this.e) {
                if (this.e.intervalPongsReceived < this.e.intervalPingsSent) {
                    z = true;
                } else {
                    this.e.intervalPingsSent++;
                    z = false;
                }
            }
            f fVar = this.e;
            if (z) {
                fVar.a((IOException) null);
                return -1L;
            }
            fVar.a(false, 1, 0);
            return this.f;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/a3/c", "Lsdk/pendo/io/a3/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class k extends sdk.pendo.io.a3.a {
        final /* synthetic */ f e;
        final /* synthetic */ int f;
        final /* synthetic */ b g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(String str, boolean z, f fVar, int i, b bVar) {
            super(str, z);
            this.e = fVar;
            this.f = i;
            this.g = bVar;
        }

        @Override // sdk.pendo.io.a3.a
        public long e() {
            try {
                this.e.b(this.f, this.g);
                return -1L;
            } catch (IOException e) {
                this.e.a(e);
                return -1L;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"sdk/pendo/io/a3/c", "Lsdk/pendo/io/a3/a;", "", "e", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class l extends sdk.pendo.io.a3.a {
        final /* synthetic */ f e;
        final /* synthetic */ int f;
        final /* synthetic */ long g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str, boolean z, f fVar, int i, long j) {
            super(str, z);
            this.e = fVar;
            this.f = i;
            this.g = j;
        }

        @Override // sdk.pendo.io.a3.a
        public long e() {
            try {
                this.e.getWriter().a(this.f, this.g);
                return -1L;
            } catch (IOException e) {
                this.e.a(e);
                return -1L;
            }
        }
    }

    static {
        m mVar = new m();
        mVar.a(7, 65535);
        mVar.a(5, 16384);
        S0 = mVar;
    }

    public f(a builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        boolean client = builder.getClient();
        this.client = client;
        this.listener = builder.getListener();
        this.streams = new LinkedHashMap();
        String c2 = builder.c();
        this.connectionName = c2;
        this.nextStreamId = builder.getClient() ? 3 : 2;
        sdk.pendo.io.a3.e taskRunner = builder.getTaskRunner();
        this.taskRunner = taskRunner;
        sdk.pendo.io.a3.d e2 = taskRunner.e();
        this.writerQueue = e2;
        this.pushQueue = taskRunner.e();
        this.settingsListenerQueue = taskRunner.e();
        this.pushObserver = builder.getPushObserver();
        m mVar = new m();
        if (builder.getClient()) {
            mVar.a(7, 16777216);
        }
        this.okHttpSettings = mVar;
        this.peerSettings = S0;
        this.writeBytesMaximum = r2.b();
        this.socket = builder.h();
        this.writer = new sdk.pendo.io.e3.j(builder.g(), client);
        this.readerRunnable = new d(this, new sdk.pendo.io.e3.h(builder.i(), client));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(builder.getPingIntervalMillis());
            e2.a(new j(c2 + " ping", this, nanos), nanos);
        }
    }

    public final boolean b(int streamId) {
        return streamId != 0 && (streamId & 1) == 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a(b.NO_ERROR, b.CANCEL, (IOException) null);
    }

    public final void flush() {
        this.writer.flush();
    }

    /* renamed from: m, reason: from getter */
    public final int getLastGoodStreamId() {
        return this.lastGoodStreamId;
    }

    /* renamed from: n, reason: from getter */
    public final c getListener() {
        return this.listener;
    }

    /* renamed from: o, reason: from getter */
    public final int getNextStreamId() {
        return this.nextStreamId;
    }

    /* renamed from: p, reason: from getter */
    public final m getOkHttpSettings() {
        return this.okHttpSettings;
    }

    /* renamed from: q, reason: from getter */
    public final m getPeerSettings() {
        return this.peerSettings;
    }

    public final Map<Integer, sdk.pendo.io.e3.i> r() {
        return this.streams;
    }

    /* renamed from: s, reason: from getter */
    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    /* renamed from: t, reason: from getter */
    public final sdk.pendo.io.e3.j getWriter() {
        return this.writer;
    }

    public final void u() {
        synchronized (this) {
            long j2 = this.degradedPongsReceived;
            long j3 = this.degradedPingsSent;
            if (j2 < j3) {
                return;
            }
            this.degradedPingsSent = j3 + 1;
            this.degradedPongDeadlineNs = System.nanoTime() + 1000000000;
            Unit unit = Unit.INSTANCE;
            this.writerQueue.a(new i(this.connectionName + " ping", true, this), 0L);
        }
    }

    public final synchronized boolean h(long nowNs) {
        if (this.isShutdown) {
            return false;
        }
        if (this.degradedPongsReceived < this.degradedPingsSent) {
            if (nowNs >= this.degradedPongDeadlineNs) {
                return false;
            }
        }
        return true;
    }

    public final synchronized void i(long read) {
        long j2 = this.readBytesTotal + read;
        this.readBytesTotal = j2;
        long j3 = j2 - this.readBytesAcknowledged;
        if (j3 >= this.okHttpSettings.b() / 2) {
            a(0, j3);
            this.readBytesAcknowledged += j3;
        }
    }

    /* renamed from: b, reason: from getter */
    public final boolean getClient() {
        return this.client;
    }

    public final synchronized sdk.pendo.io.e3.i c(int streamId) {
        sdk.pendo.io.e3.i remove;
        remove = this.streams.remove(Integer.valueOf(streamId));
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return remove;
    }

    public final void d(int i2) {
        this.lastGoodStreamId = i2;
    }

    /* renamed from: e, reason: from getter */
    public final String getConnectionName() {
        return this.connectionName;
    }

    public final void b(int streamId, List<sdk.pendo.io.e3.c> requestHeaders, boolean inFinished) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        this.pushQueue.a(new C0119f(this.connectionName + '[' + streamId + "] onHeaders", true, this, streamId, requestHeaders, inFinished), 0L);
    }

    public final void c(int streamId, b errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.writerQueue.a(new k(this.connectionName + '[' + streamId + "] writeSynReset", true, this, streamId, errorCode), 0L);
    }

    public final void a(b connectionCode, b streamCode, IOException cause) {
        int i2;
        Object[] objArr;
        Intrinsics.checkNotNullParameter(connectionCode, "connectionCode");
        Intrinsics.checkNotNullParameter(streamCode, "streamCode");
        if (sdk.pendo.io.x2.b.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        try {
            a(connectionCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (!this.streams.isEmpty()) {
                objArr = this.streams.values().toArray(new sdk.pendo.io.e3.i[0]);
                this.streams.clear();
            } else {
                objArr = null;
            }
            Unit unit = Unit.INSTANCE;
        }
        sdk.pendo.io.e3.i[] iVarArr = (sdk.pendo.io.e3.i[]) objArr;
        if (iVarArr != null) {
            for (sdk.pendo.io.e3.i iVar : iVarArr) {
                try {
                    iVar.a(streamCode, cause);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException unused3) {
        }
        try {
            this.socket.close();
        } catch (IOException unused4) {
        }
        this.writerQueue.i();
        this.pushQueue.i();
        this.settingsListenerQueue.i();
    }

    public final void b(int streamId, b statusCode) {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        this.writer.a(streamId, statusCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(IOException e2) {
        b bVar = b.PROTOCOL_ERROR;
        a(bVar, bVar, e2);
    }

    public final synchronized sdk.pendo.io.e3.i a(int id) {
        return this.streams.get(Integer.valueOf(id));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0048 A[Catch: all -> 0x0083, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000e, B:9:0x0013, B:11:0x0017, B:13:0x002a, B:15:0x0032, B:19:0x0042, B:21:0x0048, B:22:0x0051, B:38:0x007d, B:39:0x0082), top: B:5:0x0007, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final sdk.pendo.io.e3.i a(int r11, java.util.List<sdk.pendo.io.e3.c> r12, boolean r13) {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            sdk.pendo.io.e3.j r7 = r10.writer
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L86
            int r0 = r10.nextStreamId     // Catch: java.lang.Throwable -> L83
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L13
            sdk.pendo.io.e3.b r0 = sdk.pendo.io.e3.b.REFUSED_STREAM     // Catch: java.lang.Throwable -> L83
            r10.a(r0)     // Catch: java.lang.Throwable -> L83
        L13:
            boolean r0 = r10.isShutdown     // Catch: java.lang.Throwable -> L83
            if (r0 != 0) goto L7d
            int r8 = r10.nextStreamId     // Catch: java.lang.Throwable -> L83
            int r0 = r8 + 2
            r10.nextStreamId = r0     // Catch: java.lang.Throwable -> L83
            sdk.pendo.io.e3.i r9 = new sdk.pendo.io.e3.i     // Catch: java.lang.Throwable -> L83
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L83
            r0 = 1
            if (r13 == 0) goto L41
            long r1 = r10.writeBytesTotal     // Catch: java.lang.Throwable -> L83
            long r3 = r10.writeBytesMaximum     // Catch: java.lang.Throwable -> L83
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 >= 0) goto L41
            long r1 = r9.getWriteBytesTotal()     // Catch: java.lang.Throwable -> L83
            long r3 = r9.getWriteBytesMaximum()     // Catch: java.lang.Throwable -> L83
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 < 0) goto L3f
            goto L41
        L3f:
            r13 = 0
            goto L42
        L41:
            r13 = r0
        L42:
            boolean r1 = r9.q()     // Catch: java.lang.Throwable -> L83
            if (r1 == 0) goto L51
            java.util.Map<java.lang.Integer, sdk.pendo.io.e3.i> r1 = r10.streams     // Catch: java.lang.Throwable -> L83
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L83
            r1.put(r2, r9)     // Catch: java.lang.Throwable -> L83
        L51:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L83
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L86
            if (r11 != 0) goto L5c
            sdk.pendo.io.e3.j r11 = r10.writer     // Catch: java.lang.Throwable -> L86
            r11.a(r6, r8, r12)     // Catch: java.lang.Throwable -> L86
            goto L66
        L5c:
            boolean r1 = r10.client     // Catch: java.lang.Throwable -> L86
            r0 = r0 ^ r1
            if (r0 == 0) goto L71
            sdk.pendo.io.e3.j r0 = r10.writer     // Catch: java.lang.Throwable -> L86
            r0.a(r11, r8, r12)     // Catch: java.lang.Throwable -> L86
        L66:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L86
            monitor-exit(r7)
            if (r13 == 0) goto L70
            sdk.pendo.io.e3.j r11 = r10.writer
            r11.flush()
        L70:
            return r9
        L71:
            java.lang.String r11 = "client streams shouldn't have associated stream IDs"
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L86
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> L86
            r12.<init>(r11)     // Catch: java.lang.Throwable -> L86
            throw r12     // Catch: java.lang.Throwable -> L86
        L7d:
            sdk.pendo.io.e3.a r11 = new sdk.pendo.io.e3.a     // Catch: java.lang.Throwable -> L83
            r11.<init>()     // Catch: java.lang.Throwable -> L83
            throw r11     // Catch: java.lang.Throwable -> L83
        L83:
            r11 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L86
            throw r11     // Catch: java.lang.Throwable -> L86
        L86:
            r11 = move-exception
            monitor-exit(r7)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.e3.f.a(int, java.util.List, boolean):sdk.pendo.io.e3.i");
    }

    public final sdk.pendo.io.e3.i a(List<sdk.pendo.io.e3.c> requestHeaders, boolean out) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        return a(0, requestHeaders, out);
    }

    public final void a(int streamId, sdk.pendo.io.k3.f source, int byteCount, boolean inFinished) {
        Intrinsics.checkNotNullParameter(source, "source");
        sdk.pendo.io.k3.d dVar = new sdk.pendo.io.k3.d();
        long j2 = byteCount;
        source.f(j2);
        source.c(dVar, j2);
        this.pushQueue.a(new e(this.connectionName + '[' + streamId + "] onData", true, this, streamId, dVar, byteCount, inFinished), 0L);
    }

    public final void a(int streamId, List<sdk.pendo.io.e3.c> requestHeaders) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(streamId))) {
                c(streamId, b.PROTOCOL_ERROR);
            } else {
                this.currentPushRequests.add(Integer.valueOf(streamId));
                this.pushQueue.a(new g(this.connectionName + '[' + streamId + "] onRequest", true, this, streamId, requestHeaders), 0L);
            }
        }
    }

    public final void a(int streamId, b errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.pushQueue.a(new h(this.connectionName + '[' + streamId + "] onReset", true, this, streamId, errorCode), 0L);
    }

    public final void a(m mVar) {
        Intrinsics.checkNotNullParameter(mVar, "<set-?>");
        this.peerSettings = mVar;
    }

    public final void a(b statusCode) {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        synchronized (this.writer) {
            Ref.IntRef intRef = new Ref.IntRef();
            synchronized (this) {
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                int i2 = this.lastGoodStreamId;
                intRef.element = i2;
                Unit unit = Unit.INSTANCE;
                this.writer.a(i2, statusCode, sdk.pendo.io.x2.b.f1746a);
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    public final void a(boolean sendConnectionPreface, sdk.pendo.io.a3.e taskRunner) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        if (sendConnectionPreface) {
            this.writer.a();
            this.writer.b(this.okHttpSettings);
            if (this.okHttpSettings.b() != 65535) {
                this.writer.a(0, r5 - 65535);
            }
        }
        taskRunner.e().a(new sdk.pendo.io.a3.c(this.connectionName, true, this.readerRunnable), 0L);
    }

    public static /* synthetic */ void a(f fVar, boolean z, sdk.pendo.io.a3.e eVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            eVar = sdk.pendo.io.a3.e.i;
        }
        fVar.a(z, eVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r6 - r4), r8.writer.b());
        r6 = r2;
        r8.writeBytesTotal += r6;
        r4 = kotlin.Unit.INSTANCE;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(int r9, boolean r10, sdk.pendo.io.k3.d r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            sdk.pendo.io.e3.j r12 = r8.writer
            r12.a(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L71
            monitor-enter(r8)
        L12:
            long r4 = r8.writeBytesTotal     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L62
            long r6 = r8.writeBytesMaximum     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L62
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L37
            java.util.Map<java.lang.Integer, sdk.pendo.io.e3.i> r2 = r8.streams     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L62
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L62
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L62
            if (r2 == 0) goto L2f
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.Object"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8, r2)     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L62
            r8.wait()     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L62
            goto L12
        L2f:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L62
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L62
            throw r9     // Catch: java.lang.Throwable -> L60 java.lang.InterruptedException -> L62
        L37:
            long r6 = r6 - r4
            long r4 = java.lang.Math.min(r12, r6)     // Catch: java.lang.Throwable -> L60
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L60
            sdk.pendo.io.e3.j r4 = r8.writer     // Catch: java.lang.Throwable -> L60
            int r4 = r4.getMaxFrameSize()     // Catch: java.lang.Throwable -> L60
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L60
            long r4 = r8.writeBytesTotal     // Catch: java.lang.Throwable -> L60
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L60
            long r4 = r4 + r6
            r8.writeBytesTotal = r4     // Catch: java.lang.Throwable -> L60
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L60
            monitor-exit(r8)
            long r12 = r12 - r6
            sdk.pendo.io.e3.j r4 = r8.writer
            if (r10 == 0) goto L5b
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L5b
            r5 = 1
            goto L5c
        L5b:
            r5 = r3
        L5c:
            r4.a(r5, r9, r11, r2)
            goto Ld
        L60:
            r9 = move-exception
            goto L6f
        L62:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L60
            r9.interrupt()     // Catch: java.lang.Throwable -> L60
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L60
            r9.<init>()     // Catch: java.lang.Throwable -> L60
            throw r9     // Catch: java.lang.Throwable -> L60
        L6f:
            monitor-exit(r8)
            throw r9
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.e3.f.a(int, boolean, sdk.pendo.io.k3.d, long):void");
    }

    public final void a(int streamId, boolean outFinished, List<sdk.pendo.io.e3.c> alternating) {
        Intrinsics.checkNotNullParameter(alternating, "alternating");
        this.writer.a(outFinished, streamId, alternating);
    }

    public final void a(boolean reply, int payload1, int payload2) {
        try {
            this.writer.a(reply, payload1, payload2);
        } catch (IOException e2) {
            a(e2);
        }
    }

    public final void a(int streamId, long unacknowledgedBytesRead) {
        this.writerQueue.a(new l(this.connectionName + '[' + streamId + "] windowUpdate", true, this, streamId, unacknowledgedBytesRead), 0L);
    }
}
