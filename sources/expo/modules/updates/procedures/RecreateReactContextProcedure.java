package expo.modules.updates.procedures;

import android.os.Handler;
import android.os.Looper;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import expo.modules.updates.launcher.Launcher;
import expo.modules.updates.procedures.StateMachineProcedure;
import expo.modules.updates.statemachine.UpdatesStateEvent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecreateReactContextProcedure.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lexpo/modules/updates/procedures/RecreateReactContextProcedure;", "Lexpo/modules/updates/procedures/StateMachineProcedure;", "reactNativeHost", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/ReactNativeHost;", "callback", "Lexpo/modules/updates/launcher/Launcher$LauncherCallback;", "(Ljava/lang/ref/WeakReference;Lexpo/modules/updates/launcher/Launcher$LauncherCallback;)V", "run", "", "procedureContext", "Lexpo/modules/updates/procedures/StateMachineProcedure$ProcedureContext;", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RecreateReactContextProcedure extends StateMachineProcedure {
    private final Launcher.LauncherCallback callback;
    private final WeakReference<ReactNativeHost> reactNativeHost;

    public RecreateReactContextProcedure(WeakReference<ReactNativeHost> weakReference, Launcher.LauncherCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.reactNativeHost = weakReference;
        this.callback = callback;
    }

    @Override // expo.modules.updates.procedures.StateMachineProcedure
    public void run(StateMachineProcedure.ProcedureContext procedureContext) {
        Intrinsics.checkNotNullParameter(procedureContext, "procedureContext");
        WeakReference<ReactNativeHost> weakReference = this.reactNativeHost;
        ReactNativeHost reactNativeHost = weakReference != null ? weakReference.get() : null;
        if (reactNativeHost == null) {
            this.callback.onFailure(new Exception("Could not reload application. Ensure you have passed the correct instance of ReactApplication into UpdatesController.initialize()."));
            return;
        }
        procedureContext.processStateEvent(new UpdatesStateEvent.Restart());
        final ReactInstanceManager reactInstanceManager = reactNativeHost.getReactInstanceManager();
        this.callback.onSuccess();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: expo.modules.updates.procedures.RecreateReactContextProcedure$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ReactInstanceManager.this.recreateReactContextInBackground();
            }
        });
        procedureContext.resetState();
        procedureContext.onComplete();
    }
}
