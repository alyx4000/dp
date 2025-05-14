package sdk.pendo.io.f9;

import android.app.Activity;
import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.actions.ElementInfoAndViewRef;
import sdk.pendo.io.listeners.views.PendoDrawerListener;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H&J\b\u0010\u0007\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H&J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J\u0016\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000eH&J\b\u0010\u0011\u001a\u00020\u0005H&J\u0012\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0014\u001a\u00020\u000eH&J\b\u0010\r\u001a\u00020\u0015H&J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H&J\b\u0010\u0019\u001a\u00020\u0002H&J\b\u0010\u001a\u001a\u00020\u0002H&J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H&J\b\u0010\u001c\u001a\u00020\u0002H&J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u001dH&J\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH&¨\u0006\""}, d2 = {"Lsdk/pendo/io/f9/f;", "", "", ViewProps.START, "Lsdk/pendo/io/x5/j;", "", "r", "m", "d", "Ljava/lang/ref/WeakReference;", "Lsdk/pendo/io/listeners/views/PendoDrawerListener;", "e", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "a", "Lorg/json/JSONObject;", "n", ContextChain.TAG_PRODUCT, "o", "", "shouldForceScan", "j", "Lorg/json/JSONArray;", "Landroid/app/Activity;", "activity", "onActivityPaused", "f", "k", "onActivityResumed", "l", "Lsdk/pendo/io/h9/c;", "", "Lsdk/pendo/io/actions/ActivationManager$Trigger;", "triggerList", "Lsdk/pendo/io/actions/ElementInfoAndViewRef;", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public interface f {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ void a(f fVar, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleGlobalLayoutChanges");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            fVar.a(z);
        }
    }

    List<ElementInfoAndViewRef> a(List<ActivationManager.Trigger> triggerList);

    JSONArray a();

    void a(Activity activity, sdk.pendo.io.h9.c listener);

    void a(WeakReference<PendoDrawerListener> listener);

    void a(boolean shouldForceScan);

    sdk.pendo.io.x5.j<String> d();

    WeakReference<PendoDrawerListener> e();

    void f();

    JSONObject j();

    void k();

    void l();

    void m();

    JSONObject n();

    String o();

    void onActivityPaused(Activity activity);

    void onActivityResumed(Activity activity);

    JSONObject p();

    sdk.pendo.io.x5.j<String> r();

    void start();
}
