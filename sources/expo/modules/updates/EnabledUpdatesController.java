package expo.modules.updates;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import com.amplitude.reactnative.DatabaseConstants;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ViewProps;
import com.iterable.iterableapi.IterableConstants;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.updates.IUpdatesController;
import expo.modules.updates.db.BuildData;
import expo.modules.updates.db.DatabaseHolder;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.launcher.Launcher;
import expo.modules.updates.loader.FileDownloader;
import expo.modules.updates.logging.UpdatesLogReader;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.manifest.BareUpdateManifest;
import expo.modules.updates.manifest.EmbeddedManifest;
import expo.modules.updates.manifest.ManifestMetadata;
import expo.modules.updates.procedures.CheckForUpdateProcedure;
import expo.modules.updates.procedures.FetchUpdateProcedure;
import expo.modules.updates.procedures.RelaunchProcedure;
import expo.modules.updates.procedures.StartupProcedure;
import expo.modules.updates.selectionpolicy.SelectionPolicy;
import expo.modules.updates.selectionpolicy.SelectionPolicyFactory;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnabledUpdatesController.kt */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0001RB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u00100\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u00020403H\u0016J\u0016\u00105\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u00020603H\u0016J\b\u00107\u001a\u000208H\u0016J\u0016\u00109\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u00020:03H\u0016J\u0016\u0010;\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u00020<03H\u0016J\u0010\u0010=\u001a\u0002012\u0006\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u000201H\u0002J\b\u0010A\u001a\u000201H\u0002J\u0018\u0010B\u001a\u0002012\u0006\u0010C\u001a\u00020\u00132\u0006\u00102\u001a\u00020DH\u0002J\u0016\u0010E\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u00020103H\u0016J\"\u0010F\u001a\u0002012\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u000b2\b\u0010I\u001a\u0004\u0018\u00010JH\u0002J\u001a\u0010K\u001a\u0002012\u0006\u0010H\u001a\u00020\u000b2\b\u0010I\u001a\u0004\u0018\u00010JH\u0002J\u0018\u0010L\u001a\u0002012\u0006\u0010H\u001a\u00020M2\u0006\u0010\u0003\u001a\u00020<H\u0016J(\u0010N\u001a\u0002012\u0006\u0010O\u001a\u00020\u000b2\b\u0010P\u001a\u0004\u0018\u00010\u000b2\f\u00102\u001a\b\u0012\u0004\u0012\u00020103H\u0016J\b\u0010Q\u001a\u000201H\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006S"}, d2 = {"Lexpo/modules/updates/EnabledUpdatesController;", "Lexpo/modules/updates/IUpdatesController;", "Lexpo/modules/updates/statemachine/UpdatesStateChangeEventSender;", "context", "Landroid/content/Context;", "updatesConfiguration", "Lexpo/modules/updates/UpdatesConfiguration;", "updatesDirectory", "Ljava/io/File;", "(Landroid/content/Context;Lexpo/modules/updates/UpdatesConfiguration;Ljava/io/File;)V", "bundleAssetName", "", "getBundleAssetName", "()Ljava/lang/String;", "databaseHolder", "Lexpo/modules/updates/db/DatabaseHolder;", "fileDownloader", "Lexpo/modules/updates/loader/FileDownloader;", "isEmergencyLaunch", "", "()Z", "isStarted", "isStartupFinished", "isUsingEmbeddedAssets", "launchAssetFile", "getLaunchAssetFile", "launchedUpdate", "Lexpo/modules/updates/db/entity/UpdateEntity;", "getLaunchedUpdate", "()Lexpo/modules/updates/db/entity/UpdateEntity;", "localAssetFiles", "", "Lexpo/modules/updates/db/entity/AssetEntity;", "getLocalAssetFiles", "()Ljava/util/Map;", SentryEvent.JsonKeys.LOGGER, "Lexpo/modules/updates/logging/UpdatesLogger;", "reactNativeHost", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/ReactNativeHost;", "selectionPolicy", "Lexpo/modules/updates/selectionpolicy/SelectionPolicy;", "startupProcedure", "Lexpo/modules/updates/procedures/StartupProcedure;", "stateMachine", "Lexpo/modules/updates/statemachine/UpdatesStateMachine;", "getUpdatesDirectory", "()Ljava/io/File;", "checkForUpdate", "", "callback", "Lexpo/modules/updates/IUpdatesController$ModuleCallback;", "Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult;", "fetchUpdate", "Lexpo/modules/updates/IUpdatesController$FetchUpdateResult;", "getConstantsForModule", "Lexpo/modules/updates/IUpdatesController$UpdatesModuleConstants;", "getExtraParams", "Landroid/os/Bundle;", "getNativeStateMachineContext", "Lexpo/modules/updates/statemachine/UpdatesStateContext;", "onDidCreateReactInstanceManager", "reactInstanceManager", "Lcom/facebook/react/ReactInstanceManager;", "onStartupProcedureFinished", "purgeUpdatesLogsOlderThanOneDay", "relaunchReactApplication", "shouldRunReaper", "Lexpo/modules/updates/launcher/Launcher$LauncherCallback;", "relaunchReactApplicationForModule", "sendEventToJS", IterableConstants.KEY_EVENT_NAME, "eventType", "params", "Lcom/facebook/react/bridge/WritableMap;", "sendLegacyUpdateEventToJS", "sendUpdateStateChangeEventToBridge", "Lexpo/modules/updates/statemachine/UpdatesStateEventType;", "setExtraParam", DatabaseConstants.KEY_FIELD, "value", ViewProps.START, "Companion", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EnabledUpdatesController implements IUpdatesController, UpdatesStateChangeEventSender {
    private static final String TAG = "EnabledUpdatesController";
    public static final String UPDATES_EVENT_NAME = "Expo.nativeUpdatesEvent";
    public static final String UPDATES_STATE_CHANGE_EVENT_NAME = "Expo.nativeUpdatesStateChangeEvent";
    private static final String UPDATE_AVAILABLE_EVENT = "updateAvailable";
    private static final String UPDATE_ERROR_EVENT = "error";
    private static final String UPDATE_NO_UPDATE_AVAILABLE_EVENT = "noUpdateAvailable";
    private final Context context;
    private final DatabaseHolder databaseHolder;
    private final FileDownloader fileDownloader;
    private boolean isStarted;
    private boolean isStartupFinished;
    private final UpdatesLogger logger;
    private final WeakReference<ReactNativeHost> reactNativeHost;
    private final SelectionPolicy selectionPolicy;
    private final StartupProcedure startupProcedure;
    private final UpdatesStateMachine stateMachine;
    private final UpdatesConfiguration updatesConfiguration;
    private final File updatesDirectory;

    /* JADX WARN: Multi-variable type inference failed */
    public EnabledUpdatesController(Context context, UpdatesConfiguration updatesConfiguration, File updatesDirectory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(updatesConfiguration, "updatesConfiguration");
        Intrinsics.checkNotNullParameter(updatesDirectory, "updatesDirectory");
        this.context = context;
        this.updatesConfiguration = updatesConfiguration;
        this.updatesDirectory = updatesDirectory;
        this.reactNativeHost = context instanceof ReactApplication ? new WeakReference<>(((ReactApplication) context).getReactNativeHost()) : null;
        UpdatesLogger updatesLogger = new UpdatesLogger(context);
        this.logger = updatesLogger;
        FileDownloader fileDownloader = new FileDownloader(context);
        this.fileDownloader = fileDownloader;
        SelectionPolicy createFilterAwarePolicy = SelectionPolicyFactory.createFilterAwarePolicy(updatesConfiguration.getRuntimeVersion());
        this.selectionPolicy = createFilterAwarePolicy;
        this.stateMachine = new UpdatesStateMachine(context, this);
        DatabaseHolder databaseHolder = new DatabaseHolder(UpdatesDatabase.INSTANCE.getInstance(context));
        this.databaseHolder = databaseHolder;
        this.startupProcedure = new StartupProcedure(context, updatesConfiguration, databaseHolder, getUpdatesDirectory(), fileDownloader, createFilterAwarePolicy, updatesLogger, new StartupProcedure.StartupProcedureCallback() { // from class: expo.modules.updates.EnabledUpdatesController$startupProcedure$1
            @Override // expo.modules.updates.procedures.StartupProcedure.StartupProcedureCallback
            public void onFinished() {
                EnabledUpdatesController.this.onStartupProcedureFinished();
            }

            @Override // expo.modules.updates.procedures.StartupProcedure.StartupProcedureCallback
            public void onLegacyJSEvent(StartupProcedure.StartupProcedureCallback.LegacyJSEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (event instanceof StartupProcedure.StartupProcedureCallback.LegacyJSEvent.Error) {
                    EnabledUpdatesController enabledUpdatesController = EnabledUpdatesController.this;
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("message", ((StartupProcedure.StartupProcedureCallback.LegacyJSEvent.Error) event).getException().getMessage());
                    Unit unit = Unit.INSTANCE;
                    enabledUpdatesController.sendLegacyUpdateEventToJS("error", createMap);
                    return;
                }
                if (event instanceof StartupProcedure.StartupProcedureCallback.LegacyJSEvent.NoUpdateAvailable) {
                    EnabledUpdatesController.this.sendLegacyUpdateEventToJS("noUpdateAvailable", null);
                    return;
                }
                if (event instanceof StartupProcedure.StartupProcedureCallback.LegacyJSEvent.UpdateAvailable) {
                    EnabledUpdatesController enabledUpdatesController2 = EnabledUpdatesController.this;
                    WritableMap createMap2 = Arguments.createMap();
                    createMap2.putString("manifestString", ((StartupProcedure.StartupProcedureCallback.LegacyJSEvent.UpdateAvailable) event).getManifest().toString());
                    Unit unit2 = Unit.INSTANCE;
                    enabledUpdatesController2.sendLegacyUpdateEventToJS("updateAvailable", createMap2);
                }
            }

            @Override // expo.modules.updates.procedures.StartupProcedure.StartupProcedureCallback
            public void onRequestRelaunch(boolean shouldRunReaper, Launcher.LauncherCallback callback) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                EnabledUpdatesController.this.relaunchReactApplication(shouldRunReaper, callback);
            }
        });
    }

    @Override // expo.modules.updates.IUpdatesController
    public File getUpdatesDirectory() {
        return this.updatesDirectory;
    }

    private final void purgeUpdatesLogsOlderThanOneDay() {
        UpdatesLogReader.purgeLogEntries$default(new UpdatesLogReader(this.context), null, new Function1<Error, Unit>() { // from class: expo.modules.updates.EnabledUpdatesController$purgeUpdatesLogsOlderThanOneDay$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                String str;
                if (error != null) {
                    str = EnabledUpdatesController.TAG;
                    Log.e(str, "UpdatesLogReader: error in purgeLogEntries", error);
                }
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void onStartupProcedureFinished() {
        this.isStartupFinished = true;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
        notify();
    }

    private final UpdateEntity getLaunchedUpdate() {
        return this.startupProcedure.getLaunchedUpdate();
    }

    private final boolean isUsingEmbeddedAssets() {
        return this.startupProcedure.isUsingEmbeddedAssets();
    }

    private final Map<AssetEntity, String> getLocalAssetFiles() {
        return this.startupProcedure.getLocalAssetFiles();
    }

    @Override // expo.modules.updates.IUpdatesController
    /* renamed from: isEmergencyLaunch */
    public boolean getIsEmergencyLaunch() {
        return this.startupProcedure.getIsEmergencyLaunch();
    }

    @Override // expo.modules.updates.IUpdatesController
    public synchronized String getLaunchAssetFile() {
        while (!this.isStartupFinished) {
            try {
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                wait();
            } catch (InterruptedException e) {
                Log.e(TAG, "Interrupted while waiting for launch asset file", e);
            }
        }
        return this.startupProcedure.getLaunchAssetFile();
    }

    @Override // expo.modules.updates.IUpdatesController
    public String getBundleAssetName() {
        return this.startupProcedure.getBundleAssetName();
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onDidCreateReactInstanceManager(ReactInstanceManager reactInstanceManager) {
        Intrinsics.checkNotNullParameter(reactInstanceManager, "reactInstanceManager");
        this.startupProcedure.onDidCreateReactInstanceManager(reactInstanceManager);
    }

    @Override // expo.modules.updates.IUpdatesController
    public synchronized void start() {
        if (this.isStarted) {
            return;
        }
        this.isStarted = true;
        purgeUpdatesLogsOlderThanOneDay();
        BuildData.INSTANCE.ensureBuildDataIsConsistent(this.updatesConfiguration, this.databaseHolder.getDatabase());
        this.databaseHolder.releaseDatabase();
        this.stateMachine.queueExecution(this.startupProcedure);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void relaunchReactApplication(boolean shouldRunReaper, Launcher.LauncherCallback callback) {
        this.stateMachine.queueExecution(new RelaunchProcedure(this.context, this.updatesConfiguration, this.databaseHolder, getUpdatesDirectory(), this.fileDownloader, this.selectionPolicy, this.reactNativeHost, new Function0<Launcher>() { // from class: expo.modules.updates.EnabledUpdatesController$relaunchReactApplication$procedure$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Launcher invoke() {
                StartupProcedure startupProcedure;
                startupProcedure = EnabledUpdatesController.this.startupProcedure;
                Launcher launcher = startupProcedure.getLauncher();
                Intrinsics.checkNotNull(launcher);
                return launcher;
            }
        }, new Function1<Launcher, Unit>() { // from class: expo.modules.updates.EnabledUpdatesController$relaunchReactApplication$procedure$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Launcher launcher) {
                invoke2(launcher);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Launcher currentLauncher) {
                StartupProcedure startupProcedure;
                Intrinsics.checkNotNullParameter(currentLauncher, "currentLauncher");
                startupProcedure = EnabledUpdatesController.this.startupProcedure;
                startupProcedure.setLauncher(currentLauncher);
            }
        }, shouldRunReaper, callback));
    }

    @Override // expo.modules.updates.statemachine.UpdatesStateChangeEventSender
    public void sendUpdateStateChangeEventToBridge(UpdatesStateEventType eventType, UpdatesStateContext context) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(context, "context");
        sendEventToJS(UPDATES_STATE_CHANGE_EVENT_NAME, eventType.getType(), context.getWritableMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendLegacyUpdateEventToJS(String eventType, WritableMap params) {
        sendEventToJS(UPDATES_EVENT_NAME, eventType, params);
    }

    private final void sendEventToJS(String eventName, String eventType, WritableMap params) {
        UpdatesUtils.INSTANCE.sendEventToReactNative(this.reactNativeHost, this.logger, eventName, eventType, params);
    }

    @Override // expo.modules.updates.IUpdatesController
    public IUpdatesController.UpdatesModuleConstants getConstantsForModule() {
        UpdateEntity launchedUpdate = getLaunchedUpdate();
        BareUpdateManifest bareUpdateManifest = EmbeddedManifest.INSTANCE.get(this.context, this.updatesConfiguration);
        return new IUpdatesController.UpdatesModuleConstants(launchedUpdate, bareUpdateManifest != null ? bareUpdateManifest.getUpdateEntity() : null, getIsEmergencyLaunch(), true, this.updatesConfiguration.getReleaseChannel(), isUsingEmbeddedAssets(), this.updatesConfiguration.getRuntimeVersionRaw(), this.updatesConfiguration.getCheckOnLaunch(), this.updatesConfiguration.getRequestHeaders(), getLocalAssetFiles(), false, false);
    }

    @Override // expo.modules.updates.IUpdatesController
    public void relaunchReactApplicationForModule(final IUpdatesController.ModuleCallback<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(getLaunchedUpdate() != null)) {
            callback.onFailure(new CodedException() { // from class: expo.modules.updates.EnabledUpdatesController$relaunchReactApplicationForModule$1
            });
        } else {
            relaunchReactApplication(true, new Launcher.LauncherCallback() { // from class: expo.modules.updates.EnabledUpdatesController$relaunchReactApplicationForModule$2
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
            });
        }
    }

    @Override // expo.modules.updates.IUpdatesController
    public void getNativeStateMachineContext(IUpdatesController.ModuleCallback<UpdatesStateContext> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onSuccess(this.stateMachine.getContext());
    }

    @Override // expo.modules.updates.IUpdatesController
    public void checkForUpdate(final IUpdatesController.ModuleCallback<IUpdatesController.CheckForUpdateResult> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.stateMachine.queueExecution(new CheckForUpdateProcedure(this.context, this.updatesConfiguration, this.databaseHolder, this.logger, this.fileDownloader, this.selectionPolicy, getLaunchedUpdate(), new Function1<IUpdatesController.CheckForUpdateResult, Unit>() { // from class: expo.modules.updates.EnabledUpdatesController$checkForUpdate$procedure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IUpdatesController.CheckForUpdateResult checkForUpdateResult) {
                invoke2(checkForUpdateResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IUpdatesController.CheckForUpdateResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                callback.onSuccess(it);
            }
        }));
    }

    @Override // expo.modules.updates.IUpdatesController
    public void fetchUpdate(final IUpdatesController.ModuleCallback<IUpdatesController.FetchUpdateResult> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.stateMachine.queueExecution(new FetchUpdateProcedure(this.context, this.updatesConfiguration, this.databaseHolder, getUpdatesDirectory(), this.fileDownloader, this.selectionPolicy, getLaunchedUpdate(), new Function1<IUpdatesController.FetchUpdateResult, Unit>() { // from class: expo.modules.updates.EnabledUpdatesController$fetchUpdate$procedure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IUpdatesController.FetchUpdateResult fetchUpdateResult) {
                invoke2(fetchUpdateResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IUpdatesController.FetchUpdateResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                callback.onSuccess(it);
            }
        }));
    }

    @Override // expo.modules.updates.IUpdatesController
    public void getExtraParams(final IUpdatesController.ModuleCallback<Bundle> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AsyncTask.execute(new Runnable() { // from class: expo.modules.updates.EnabledUpdatesController$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                EnabledUpdatesController.getExtraParams$lambda$2(EnabledUpdatesController.this, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getExtraParams$lambda$2(EnabledUpdatesController this$0, IUpdatesController.ModuleCallback callback) {
        UnexpectedException unexpectedException;
        Bundle bundle;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        try {
            Map<String, String> extraParams = ManifestMetadata.INSTANCE.getExtraParams(this$0.databaseHolder.getDatabase(), this$0.updatesConfiguration);
            this$0.databaseHolder.releaseDatabase();
            if (extraParams == null) {
                bundle = new Bundle();
            } else {
                Bundle bundle2 = new Bundle();
                for (Map.Entry<String, String> entry : extraParams.entrySet()) {
                    bundle2.putString(entry.getKey(), entry.getValue());
                }
                bundle = bundle2;
            }
            callback.onSuccess(bundle);
        } catch (Exception e) {
            this$0.databaseHolder.releaseDatabase();
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
            callback.onFailure(unexpectedException);
        }
    }

    @Override // expo.modules.updates.IUpdatesController
    public void setExtraParam(final String key, final String value, final IUpdatesController.ModuleCallback<Unit> callback) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AsyncTask.execute(new Runnable() { // from class: expo.modules.updates.EnabledUpdatesController$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                EnabledUpdatesController.setExtraParam$lambda$3(EnabledUpdatesController.this, key, value, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setExtraParam$lambda$3(EnabledUpdatesController this$0, String key, String str, IUpdatesController.ModuleCallback callback) {
        UnexpectedException unexpectedException;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(key, "$key");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        try {
            ManifestMetadata.INSTANCE.setExtraParam(this$0.databaseHolder.getDatabase(), this$0.updatesConfiguration, key, str);
            this$0.databaseHolder.releaseDatabase();
            callback.onSuccess(Unit.INSTANCE);
        } catch (Exception e) {
            this$0.databaseHolder.releaseDatabase();
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
            callback.onFailure(unexpectedException);
        }
    }
}
