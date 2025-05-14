package sdk.pendo.io.u8;

import android.text.TextUtils;
import com.facebook.common.callercontext.ContextChain;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.l7.b;
import sdk.pendo.io.l7.e;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.m7.a;
import sdk.pendo.io.utilities.AndroidUtils;
import sdk.pendo.io.views.listener.FloatingListenerButton;
import sdk.pendo.io.w2.z;
import sdk.pendo.io.x8.b;
import sdk.pendo.io.x8.c;
import sdk.pendo.io.x8.d;
import sdk.pendo.io.x8.f;
import sdk.pendo.io.x8.h;
import sdk.pendo.io.x8.i;
import sdk.pendo.io.x8.j;
import sdk.pendo.io.x8.k;
import sdk.pendo.io.x8.l;
import sdk.pendo.io.x8.m;
import sdk.pendo.io.x8.n;
import sdk.pendo.io.x8.o;
import sdk.pendo.io.x8.p;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bL\u0010MJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J1\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\"\u0004\u0018\u00010\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\f\u001a\u00020\u0002J\u001c\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006N"}, d2 = {"Lsdk/pendo/io/u8/a;", "", "", "d", "f", "", "event", "", "args", "Lsdk/pendo/io/m7/a;", "a", "(Ljava/lang/String;[Ljava/lang/Object;)Lsdk/pendo/io/m7/a;", "e", "Lsdk/pendo/io/m7/a$a;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "b", "c", "Lsdk/pendo/io/l7/e;", "Lsdk/pendo/io/l7/e;", "mSocket", "Lsdk/pendo/io/x8/l;", "Lsdk/pendo/io/x8/l;", "mOnConnectedListener", "Lsdk/pendo/io/x8/m;", "Lsdk/pendo/io/x8/m;", "mOnDisconnectedListener", "Lsdk/pendo/io/x8/n;", "Lsdk/pendo/io/x8/n;", "mOnTerminateListener", "Lsdk/pendo/io/x8/i;", "Lsdk/pendo/io/x8/i;", "mPairedModeUpdateListener", "Lsdk/pendo/io/x8/k;", "g", "Lsdk/pendo/io/x8/k;", "mResetStateListener", "Lsdk/pendo/io/x8/j;", "h", "Lsdk/pendo/io/x8/j;", "mPreviewOnDeviceListener", "Lsdk/pendo/io/x8/a;", ContextChain.TAG_INFRA, "Lsdk/pendo/io/x8/a;", "mCaptureModeEnterListener", "Lsdk/pendo/io/x8/b;", "j", "Lsdk/pendo/io/x8/b;", "mCaptureModeExitListener", "Lsdk/pendo/io/x8/c;", "k", "Lsdk/pendo/io/x8/c;", "mCaptureModeScreenRecievedListener", "Lsdk/pendo/io/x8/o;", "l", "Lsdk/pendo/io/x8/o;", "mOnTestModeEnterListener", "Lsdk/pendo/io/x8/p;", "m", "Lsdk/pendo/io/x8/p;", "mOnTestModeExitListener", "Lsdk/pendo/io/x8/e;", "n", "Lsdk/pendo/io/x8/e;", "mDebugModeEnterListener", "Lsdk/pendo/io/x8/f;", "o", "Lsdk/pendo/io/x8/f;", "mDebugModeExitListener", "Lsdk/pendo/io/x8/h;", ContextChain.TAG_PRODUCT, "Lsdk/pendo/io/x8/h;", "mOnErrorListener", "Lsdk/pendo/io/x8/d;", "q", "Lsdk/pendo/io/x8/d;", "mOnConnectionErrorListener", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: b, reason: from kotlin metadata */
    private static volatile e mSocket;

    /* renamed from: a, reason: collision with root package name */
    public static final a f1643a = new a();

    /* renamed from: c, reason: from kotlin metadata */
    private static final l mOnConnectedListener = new l();

    /* renamed from: d, reason: from kotlin metadata */
    private static final m mOnDisconnectedListener = new m();

    /* renamed from: e, reason: from kotlin metadata */
    private static final n mOnTerminateListener = new n();

    /* renamed from: f, reason: from kotlin metadata */
    private static final i mPairedModeUpdateListener = new i();

    /* renamed from: g, reason: from kotlin metadata */
    private static final k mResetStateListener = new k();

    /* renamed from: h, reason: from kotlin metadata */
    private static final j mPreviewOnDeviceListener = new j();

    /* renamed from: i, reason: from kotlin metadata */
    private static final sdk.pendo.io.x8.a mCaptureModeEnterListener = new sdk.pendo.io.x8.a();

    /* renamed from: j, reason: from kotlin metadata */
    private static final b mCaptureModeExitListener = new b();

    /* renamed from: k, reason: from kotlin metadata */
    private static final c mCaptureModeScreenRecievedListener = new c();

    /* renamed from: l, reason: from kotlin metadata */
    private static final o mOnTestModeEnterListener = new o();

    /* renamed from: m, reason: from kotlin metadata */
    private static final p mOnTestModeExitListener = new p();

    /* renamed from: n, reason: from kotlin metadata */
    private static final sdk.pendo.io.x8.e mDebugModeEnterListener = new sdk.pendo.io.x8.e();

    /* renamed from: o, reason: from kotlin metadata */
    private static final f mDebugModeExitListener = new f();

    /* renamed from: p, reason: from kotlin metadata */
    private static final h mOnErrorListener = new h();

    /* renamed from: q, reason: from kotlin metadata */
    private static final d mOnConnectionErrorListener = new d();

    static {
        sdk.pendo.io.y8.a.d();
    }

    private a() {
    }

    private final void d() {
        if (sdk.pendo.io.n8.c.g().f() != null) {
            FloatingListenerButton.Builder.removeActiveInstances();
        }
    }

    public final sdk.pendo.io.m7.a a(String event, a.InterfaceC0197a listener) {
        e eVar = mSocket;
        if (eVar != null) {
            return eVar.b(event, listener);
        }
        return null;
    }

    public final synchronized void b() {
        e eVar = mSocket;
        if (eVar != null) {
            eVar.e();
            f1643a.c();
        }
    }

    public final void c() {
        e eVar = mSocket;
        if (eVar != null) {
            eVar.a();
            eVar.b();
            mSocket = null;
        }
    }

    public final synchronized void e() {
        e eVar;
        b();
        if (mSocket != null && (eVar = mSocket) != null) {
            eVar.a();
        }
        b.a aVar = new b.a();
        aVar.r = true;
        aVar.t = TimeUnit.SECONDS.toMillis(2L);
        aVar.z = false;
        String str = "token=" + sdk.pendo.io.network.interfaces.a.b() + "&sessionToken=" + sdk.pendo.io.z8.b.c() + "&version=v2&appVersion=" + AndroidUtils.d();
        PendoLogger.d("sending this query to the socket " + str, new Object[0]);
        aVar.p = str;
        try {
            URI uri = new URI(sdk.pendo.io.z8.b.b().toString());
            String scheme = uri.getScheme();
            if (!TextUtils.isEmpty(scheme) && Intrinsics.areEqual(scheme, "https")) {
                aVar.d = true;
                try {
                    z f = sdk.pendo.io.network.interfaces.a.f();
                    aVar.k = f;
                    aVar.j = f;
                } catch (Exception e) {
                    PendoLogger.e(e, e.getMessage(), new Object[0]);
                }
            }
            aVar.l = new String[]{"websocket"};
            aVar.y = DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM;
            aVar.b = "/ws/socket.io";
            PendoLogger.d("opening socket to " + uri, new Object[0]);
            mSocket = sdk.pendo.io.l7.b.a(uri, aVar);
            e eVar2 = mSocket;
            if (eVar2 != null) {
                l lVar = mOnConnectedListener;
                eVar2.b("connect", lVar);
                eVar2.b("reconnect", lVar);
                h hVar = mOnErrorListener;
                eVar2.b("connect_timeout", hVar);
                eVar2.b("disconnect", mOnDisconnectedListener);
                d dVar = mOnConnectionErrorListener;
                eVar2.b("connect_error", dVar);
                eVar2.b("reconnect_error", dVar);
                eVar2.b("reconnect_failed", dVar);
                eVar2.b("error", hVar);
                eVar2.b(sdk.pendo.io.w8.a.EVENT_PAIRED_MODE_UPDATE.b(), mPairedModeUpdateListener);
                eVar2.b(sdk.pendo.io.w8.a.EVENT_RESET_STATE.b(), mResetStateListener);
                eVar2.b(sdk.pendo.io.w8.a.EVENT_PREVIEW_ON_DEVICE.b(), mPreviewOnDeviceListener);
                eVar2.b(sdk.pendo.io.w8.a.EVENT_CAPTURE_MODE_ENTER.b(), mCaptureModeEnterListener);
                eVar2.b(sdk.pendo.io.w8.a.EVENT_CAPTURE_MODE_EXIT.b(), mCaptureModeExitListener);
                eVar2.b(sdk.pendo.io.w8.a.EVENT_CAPTURE_MODE_SCREEN_RECEIVED.b(), mCaptureModeScreenRecievedListener);
                eVar2.b(sdk.pendo.io.w8.a.EVENT_TEST_MODE_ENTER.b(), mOnTestModeEnterListener);
                eVar2.b(sdk.pendo.io.w8.a.EVENT_TEST_MODE_EXIT.b(), mOnTestModeExitListener);
                eVar2.b(sdk.pendo.io.w8.a.EVENT_TERMINATE.b(), mOnTerminateListener);
                eVar2.b(sdk.pendo.io.w8.a.EVENT_INVALID.b(), hVar);
                eVar2.b(sdk.pendo.io.w8.a.EVENT_DEBUG_MODE_ENTER.b(), mDebugModeEnterListener);
                eVar2.b(sdk.pendo.io.w8.a.EVENT_DEBUG_MODE_EXIT.b(), mDebugModeExitListener);
            }
        } catch (Exception e2) {
            PendoLogger.e(e2, "setupSocket():" + e2.getMessage(), new Object[0]);
        }
    }

    public final void f() {
        d();
        sdk.pendo.io.y8.a.d().w();
    }

    public final synchronized void a() {
        try {
            e();
        } catch (URISyntaxException e) {
            PendoLogger.e(e, "Error while trying to setup socket", new Object[0]);
        }
        e eVar = mSocket;
        if (eVar != null) {
            eVar.c();
        }
    }

    public final sdk.pendo.io.m7.a a(String event, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        e eVar = mSocket;
        if (eVar != null) {
            return eVar.a(event, Arrays.copyOf(args, args.length));
        }
        return null;
    }

    public final sdk.pendo.io.m7.a a(String event) {
        e eVar = mSocket;
        if (eVar != null) {
            return eVar.a(event);
        }
        return null;
    }
}
