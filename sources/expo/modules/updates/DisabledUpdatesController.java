package expo.modules.updates;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.amplitude.reactnative.DatabaseConstants;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewProps;
import com.iterable.iterableapi.IterableConstants;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.updates.IUpdatesController;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.launcher.Launcher;
import expo.modules.updates.launcher.NoDatabaseLauncher;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.procedures.RecreateReactContextProcedure;
import expo.modules.updates.statemachine.UpdatesStateChangeEventSender;
import expo.modules.updates.statemachine.UpdatesStateContext;
import expo.modules.updates.statemachine.UpdatesStateEventType;
import expo.modules.updates.statemachine.UpdatesStateMachine;
import io.sentry.SentryEvent;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisabledUpdatesController.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0002BCB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016J\u0016\u0010*\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020+0(H\u0016J\b\u0010,\u001a\u00020-H\u0016J\u0016\u0010.\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020/0(H\u0016J\u0016\u00100\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002010(H\u0016J\b\u00102\u001a\u00020&H\u0002J\u0010\u00103\u001a\u00020&2\u0006\u00104\u001a\u000205H\u0016J\u0016\u00106\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0(H\u0016J\"\u00107\u001a\u00020&2\u0006\u00108\u001a\u00020\f2\u0006\u00109\u001a\u00020\f2\b\u0010:\u001a\u0004\u0018\u00010;H\u0002J\u0018\u0010<\u001a\u00020&2\u0006\u00109\u001a\u00020=2\u0006\u0010\u0003\u001a\u000201H\u0016J(\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020\f2\b\u0010@\u001a\u0004\u0018\u00010\f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0(H\u0016J\b\u0010A\u001a\u00020&H\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000eR\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006D"}, d2 = {"Lexpo/modules/updates/DisabledUpdatesController;", "Lexpo/modules/updates/IUpdatesController;", "Lexpo/modules/updates/statemachine/UpdatesStateChangeEventSender;", "context", "Landroid/content/Context;", "fatalException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "isMissingRuntimeVersion", "", "(Landroid/content/Context;Ljava/lang/Exception;Z)V", "bundleAssetName", "", "getBundleAssetName", "()Ljava/lang/String;", "<set-?>", "isEmergencyLaunch", "()Z", "isLoaderTaskFinished", "isStarted", "launchAssetFile", "getLaunchAssetFile", "launcher", "Lexpo/modules/updates/launcher/Launcher;", SentryEvent.JsonKeys.LOGGER, "Lexpo/modules/updates/logging/UpdatesLogger;", "reactNativeHost", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/ReactNativeHost;", "stateMachine", "Lexpo/modules/updates/statemachine/UpdatesStateMachine;", "updatesDirectory", "Ljava/io/File;", "getUpdatesDirectory", "()Ljava/io/File;", "setUpdatesDirectory", "(Ljava/io/File;)V", "checkForUpdate", "", "callback", "Lexpo/modules/updates/IUpdatesController$ModuleCallback;", "Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult;", "fetchUpdate", "Lexpo/modules/updates/IUpdatesController$FetchUpdateResult;", "getConstantsForModule", "Lexpo/modules/updates/IUpdatesController$UpdatesModuleConstants;", "getExtraParams", "Landroid/os/Bundle;", "getNativeStateMachineContext", "Lexpo/modules/updates/statemachine/UpdatesStateContext;", "notifyController", "onDidCreateReactInstanceManager", "reactInstanceManager", "Lcom/facebook/react/ReactInstanceManager;", "relaunchReactApplicationForModule", "sendEventToJS", IterableConstants.KEY_EVENT_NAME, "eventType", "params", "Lcom/facebook/react/bridge/WritableMap;", "sendUpdateStateChangeEventToBridge", "Lexpo/modules/updates/statemachine/UpdatesStateEventType;", "setExtraParam", DatabaseConstants.KEY_FIELD, "value", ViewProps.START, "Companion", "UpdatesDisabledException", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DisabledUpdatesController implements IUpdatesController, UpdatesStateChangeEventSender {
    private static final String TAG = "DisabledUpdatesController";
    private final Context context;
    private final Exception fatalException;
    private boolean isEmergencyLaunch;
    private boolean isLoaderTaskFinished;
    private final boolean isMissingRuntimeVersion;
    private boolean isStarted;
    private Launcher launcher;
    private final UpdatesLogger logger;
    private final WeakReference<ReactNativeHost> reactNativeHost;
    private final UpdatesStateMachine stateMachine;
    private File updatesDirectory;

    @Override // expo.modules.updates.IUpdatesController
    public void onDidCreateReactInstanceManager(ReactInstanceManager reactInstanceManager) {
        Intrinsics.checkNotNullParameter(reactInstanceManager, "reactInstanceManager");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DisabledUpdatesController(Context context, Exception exc, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.fatalException = exc;
        this.isMissingRuntimeVersion = z;
        this.reactNativeHost = context instanceof ReactApplication ? new WeakReference<>(((ReactApplication) context).getReactNativeHost()) : null;
        this.logger = new UpdatesLogger(context);
        this.stateMachine = new UpdatesStateMachine(context, this);
    }

    @Override // expo.modules.updates.IUpdatesController
    public File getUpdatesDirectory() {
        return this.updatesDirectory;
    }

    public void setUpdatesDirectory(File file) {
        this.updatesDirectory = file;
    }

    @Override // expo.modules.updates.IUpdatesController
    /* renamed from: isEmergencyLaunch, reason: from getter */
    public boolean getIsEmergencyLaunch() {
        return this.isEmergencyLaunch;
    }

    @Override // expo.modules.updates.IUpdatesController
    public synchronized String getLaunchAssetFile() {
        Launcher launcher;
        while (!this.isLoaderTaskFinished) {
            try {
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                wait();
            } catch (InterruptedException e) {
                Log.e(TAG, "Interrupted while waiting for launch asset file", e);
            }
        }
        launcher = this.launcher;
        return launcher != null ? launcher.getLaunchAssetFile() : null;
    }

    @Override // expo.modules.updates.IUpdatesController
    public String getBundleAssetName() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.getBundleAssetName();
        }
        return null;
    }

    @Override // expo.modules.updates.IUpdatesController
    public synchronized void start() {
        if (this.isStarted) {
            return;
        }
        boolean z = true;
        this.isStarted = true;
        this.launcher = new NoDatabaseLauncher(this.context, this.fatalException);
        if (this.fatalException == null) {
            z = false;
        }
        this.isEmergencyLaunch = z;
        notifyController();
    }

    /* compiled from: DisabledUpdatesController.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lexpo/modules/updates/DisabledUpdatesController$UpdatesDisabledException;", "Lexpo/modules/kotlin/exception/CodedException;", "message", "", "(Ljava/lang/String;)V", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class UpdatesDisabledException extends CodedException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpdatesDisabledException(String message) {
            super(message, null, 2, null);
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    @Override // expo.modules.updates.IUpdatesController
    public IUpdatesController.UpdatesModuleConstants getConstantsForModule() {
        Launcher launcher = this.launcher;
        UpdateEntity launchedUpdate = launcher != null ? launcher.getLaunchedUpdate() : null;
        boolean isEmergencyLaunch = getIsEmergencyLaunch();
        Launcher launcher2 = this.launcher;
        boolean isUsingEmbeddedAssets = launcher2 != null ? launcher2.getIsUsingEmbeddedAssets() : false;
        UpdatesConfiguration.CheckAutomaticallyConfiguration checkAutomaticallyConfiguration = UpdatesConfiguration.CheckAutomaticallyConfiguration.NEVER;
        Map emptyMap = MapsKt.emptyMap();
        Launcher launcher3 = this.launcher;
        return new IUpdatesController.UpdatesModuleConstants(launchedUpdate, null, isEmergencyLaunch, false, "default", isUsingEmbeddedAssets, null, checkAutomaticallyConfiguration, emptyMap, launcher3 != null ? launcher3.mo1072getLocalAssetFiles() : null, this.isMissingRuntimeVersion, false);
    }

    @Override // expo.modules.updates.IUpdatesController
    public void relaunchReactApplicationForModule(final IUpdatesController.ModuleCallback<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.stateMachine.queueExecution(new RecreateReactContextProcedure(this.reactNativeHost, new Launcher.LauncherCallback() { // from class: expo.modules.updates.DisabledUpdatesController$relaunchReactApplicationForModule$procedure$1
            @Override // expo.modules.updates.launcher.Launcher.LauncherCallback
            public void onFailure(Exception e) {
                UnexpectedException unexpectedException;
                Intrinsics.checkNotNullParameter(e, "e");
                IUpdatesController.ModuleCallback<Unit> moduleCallback = callback;
                Exception exc = e;
                if (exc instanceof CodedException) {
                    unexpectedException = (CodedException) exc;
                } else if (exc instanceof expo.modules.core.errors.CodedException) {
                    String code = ((expo.modules.core.errors.CodedException) exc).getCode();
                    Intrinsics.checkNotNullExpressionValue(code, "this.code");
                    unexpectedException = new CodedException(code, exc.getMessage(), exc.getCause());
                } else {
                    unexpectedException = new UnexpectedException(exc);
                }
                moduleCallback.onFailure(unexpectedException);
            }

            @Override // expo.modules.updates.launcher.Launcher.LauncherCallback
            public void onSuccess() {
                callback.onSuccess(Unit.INSTANCE);
            }
        }));
    }

    @Override // expo.modules.updates.IUpdatesController
    public void getNativeStateMachineContext(IUpdatesController.ModuleCallback<UpdatesStateContext> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onSuccess(this.stateMachine.getContext());
    }

    @Override // expo.modules.updates.IUpdatesController
    public void checkForUpdate(IUpdatesController.ModuleCallback<IUpdatesController.CheckForUpdateResult> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onFailure(new UpdatesDisabledException("You cannot check for updates when expo-updates is not enabled."));
    }

    @Override // expo.modules.updates.IUpdatesController
    public void fetchUpdate(IUpdatesController.ModuleCallback<IUpdatesController.FetchUpdateResult> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onFailure(new UpdatesDisabledException("You cannot fetch update when expo-updates is not enabled."));
    }

    @Override // expo.modules.updates.IUpdatesController
    public void getExtraParams(IUpdatesController.ModuleCallback<Bundle> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onFailure(new UpdatesDisabledException("You cannot use extra params when expo-updates is not enabled."));
    }

    @Override // expo.modules.updates.IUpdatesController
    public void setExtraParam(String key, String value, IUpdatesController.ModuleCallback<Unit> callback) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onFailure(new UpdatesDisabledException("You cannot use extra params when expo-updates is not enabled."));
    }

    private final synchronized void notifyController() {
        if (this.launcher == null) {
            throw new AssertionError("UpdatesController.notifyController was called with a null launcher, which is an error. This method should only be called when an update is ready to launch.");
        }
        this.isLoaderTaskFinished = true;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
        notify();
    }

    @Override // expo.modules.updates.statemachine.UpdatesStateChangeEventSender
    public void sendUpdateStateChangeEventToBridge(UpdatesStateEventType eventType, UpdatesStateContext context) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(context, "context");
        sendEventToJS(EnabledUpdatesController.UPDATES_STATE_CHANGE_EVENT_NAME, eventType.getType(), context.getWritableMap());
    }

    private final void sendEventToJS(String eventName, String eventType, WritableMap params) {
        UpdatesUtils.INSTANCE.sendEventToReactNative(this.reactNativeHost, this.logger, eventName, eventType, params);
    }
}
