package expo.modules.updates.procedures;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.JSBundleLoader;
import expo.modules.updates.db.DatabaseHolder;
import expo.modules.updates.launcher.DatabaseLauncher;
import expo.modules.updates.launcher.Launcher;
import expo.modules.updates.procedures.StateMachineProcedure;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RelaunchProcedure.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"expo/modules/updates/procedures/RelaunchProcedure$run$1", "Lexpo/modules/updates/launcher/Launcher$LauncherCallback;", "onFailure", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onSuccess", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RelaunchProcedure$run$1 implements Launcher.LauncherCallback {
    final /* synthetic */ ReactNativeHost $host;
    final /* synthetic */ DatabaseLauncher $newLauncher;
    final /* synthetic */ String $oldLaunchAssetFile;
    final /* synthetic */ StateMachineProcedure.ProcedureContext $procedureContext;
    final /* synthetic */ RelaunchProcedure this$0;

    RelaunchProcedure$run$1(RelaunchProcedure relaunchProcedure, StateMachineProcedure.ProcedureContext procedureContext, DatabaseLauncher databaseLauncher, ReactNativeHost reactNativeHost, String str) {
        this.this$0 = relaunchProcedure;
        this.$procedureContext = procedureContext;
        this.$newLauncher = databaseLauncher;
        this.$host = reactNativeHost;
        this.$oldLaunchAssetFile = str;
    }

    @Override // expo.modules.updates.launcher.Launcher.LauncherCallback
    public void onFailure(Exception e) {
        Launcher.LauncherCallback launcherCallback;
        Intrinsics.checkNotNullParameter(e, "e");
        launcherCallback = this.this$0.callback;
        launcherCallback.onFailure(e);
        this.$procedureContext.onComplete();
    }

    @Override // expo.modules.updates.launcher.Launcher.LauncherCallback
    public void onSuccess() {
        Function1 function1;
        DatabaseHolder databaseHolder;
        Function0 function0;
        Launcher.LauncherCallback launcherCallback;
        boolean z;
        String str;
        function1 = this.this$0.setCurrentLauncher;
        function1.invoke(this.$newLauncher);
        databaseHolder = this.this$0.databaseHolder;
        databaseHolder.releaseDatabase();
        final ReactInstanceManager reactInstanceManager = this.$host.getReactInstanceManager();
        function0 = this.this$0.getCurrentLauncher;
        String launchAssetFile = ((Launcher) function0.invoke()).getLaunchAssetFile();
        if (launchAssetFile != null && !Intrinsics.areEqual(launchAssetFile, this.$oldLaunchAssetFile)) {
            try {
                JSBundleLoader createFileLoader = JSBundleLoader.createFileLoader(launchAssetFile);
                Field declaredField = reactInstanceManager.getClass().getDeclaredField("mBundleLoader");
                declaredField.setAccessible(true);
                declaredField.set(reactInstanceManager, createFileLoader);
            } catch (Exception e) {
                str = RelaunchProcedure.TAG;
                Log.e(str, "Could not reset JSBundleLoader in ReactInstanceManager", e);
            }
        }
        launcherCallback = this.this$0.callback;
        launcherCallback.onSuccess();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: expo.modules.updates.procedures.RelaunchProcedure$run$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ReactInstanceManager.this.recreateReactContextInBackground();
            }
        });
        z = this.this$0.shouldRunReaper;
        if (z) {
            this.this$0.runReaper();
        }
        this.$procedureContext.resetState();
        this.$procedureContext.onComplete();
    }
}
