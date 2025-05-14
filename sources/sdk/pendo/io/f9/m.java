package sdk.pendo.io.f9;

import android.app.Activity;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.actions.ElementInfoAndViewRef;
import sdk.pendo.io.listeners.views.PendoDrawerListener;
import sdk.pendo.io.logging.PendoLogger;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b7\u00108J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\u0010\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016J\u0016\u0010\u000e\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010\u000e\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u001eH\u0016JP\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00132\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0013H\u0016J\b\u0010)\u001a\u00020\u0013H\u0016J\b\u0010*\u001a\u00020\u0013H\u0016J\b\u0010+\u001a\u00020\u0013H\u0016J\b\u0010,\u001a\u00020\u0013H\u0016J\b\u0010-\u001a\u00020\u0013H\u0016J\b\u0010.\u001a\u00020\u0013H\u0016J\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010/2\f\u00101\u001a\b\u0012\u0004\u0012\u0002000/H\u0016R\u001c\u00105\u001a\n 3*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u00104R\u0014\u00106\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b.\u00104¨\u00069"}, d2 = {"Lsdk/pendo/io/f9/m;", "Lsdk/pendo/io/f9/f;", "Lsdk/pendo/io/e9/c;", "", ViewProps.START, "Lsdk/pendo/io/x5/j;", "", "r", "m", "d", "Ljava/lang/ref/WeakReference;", "Lsdk/pendo/io/listeners/views/PendoDrawerListener;", "e", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "a", "Lorg/json/JSONObject;", "n", ContextChain.TAG_PRODUCT, "o", "", "shouldForceScan", "j", "Lorg/json/JSONArray;", "Landroid/app/Activity;", "activity", "onActivityPaused", "f", "k", "onActivityResumed", "l", "Lsdk/pendo/io/h9/c;", "includePageViewTexts", "includeFeatureClickTexts", "includeFeatureClickNestedTexts", "includeRetroElementCompatibilityHashes", "isOldScreenIdFormat", "ignoreDynamicFragmentsInScrollView", "isRespondToScrollChangeEventsForScreenId", "", "globalLayoutChangeDebouncer", "shouldDetectClicksForAccessibility", "c", "h", "q", "g", ContextChain.TAG_INFRA, "b", "", "Lsdk/pendo/io/actions/ActivationManager$Trigger;", "triggerList", "Lsdk/pendo/io/actions/ElementInfoAndViewRef;", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "TAG", "EMPTY_STRING", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class m implements f, sdk.pendo.io.e9.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "m";

    /* renamed from: b, reason: from kotlin metadata */
    private final String EMPTY_STRING = "";

    @Override // sdk.pendo.io.f9.f
    public void a(Activity activity, sdk.pendo.io.h9.c listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // sdk.pendo.io.f9.f
    public void a(boolean shouldForceScan) {
    }

    @Override // sdk.pendo.io.e9.c
    public void a(boolean includePageViewTexts, boolean includeFeatureClickTexts, boolean includeFeatureClickNestedTexts, boolean includeRetroElementCompatibilityHashes, boolean isOldScreenIdFormat, boolean ignoreDynamicFragmentsInScrollView, boolean isRespondToScrollChangeEventsForScreenId, long globalLayoutChangeDebouncer, boolean shouldDetectClicksForAccessibility) {
    }

    @Override // sdk.pendo.io.e9.c
    public boolean b() {
        return false;
    }

    @Override // sdk.pendo.io.e9.c
    public boolean c() {
        return false;
    }

    @Override // sdk.pendo.io.f9.f
    public sdk.pendo.io.x5.j<String> d() {
        return null;
    }

    @Override // sdk.pendo.io.f9.f
    public WeakReference<PendoDrawerListener> e() {
        return null;
    }

    @Override // sdk.pendo.io.f9.f
    public void f() {
    }

    @Override // sdk.pendo.io.e9.c
    public boolean g() {
        return false;
    }

    @Override // sdk.pendo.io.e9.c
    public boolean h() {
        return false;
    }

    @Override // sdk.pendo.io.e9.c
    public boolean i() {
        return false;
    }

    @Override // sdk.pendo.io.f9.f
    public JSONObject j() {
        return new JSONObject();
    }

    @Override // sdk.pendo.io.f9.f
    public void k() {
    }

    @Override // sdk.pendo.io.f9.f
    public void l() {
    }

    @Override // sdk.pendo.io.f9.f
    public void m() {
    }

    @Override // sdk.pendo.io.f9.f
    public JSONObject n() {
        return null;
    }

    @Override // sdk.pendo.io.f9.f
    /* renamed from: o, reason: from getter */
    public String getEMPTY_STRING() {
        return this.EMPTY_STRING;
    }

    @Override // sdk.pendo.io.f9.f
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // sdk.pendo.io.f9.f
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // sdk.pendo.io.f9.f
    public JSONObject p() {
        return null;
    }

    @Override // sdk.pendo.io.e9.c
    public boolean q() {
        return false;
    }

    @Override // sdk.pendo.io.f9.f
    public sdk.pendo.io.x5.j<String> r() {
        return null;
    }

    @Override // sdk.pendo.io.f9.f
    public void start() {
        PendoLogger.d(this.TAG, "Initializing ScreenManagerTrackEventOnly");
    }

    @Override // sdk.pendo.io.f9.f
    public List<ElementInfoAndViewRef> a(List<ActivationManager.Trigger> triggerList) {
        Intrinsics.checkNotNullParameter(triggerList, "triggerList");
        return null;
    }

    @Override // sdk.pendo.io.f9.f
    public JSONArray a() {
        return new JSONArray();
    }

    @Override // sdk.pendo.io.f9.f
    public void a(WeakReference<PendoDrawerListener> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }
}
