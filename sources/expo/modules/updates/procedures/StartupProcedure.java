package expo.modules.updates.procedures;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.facebook.react.ReactInstanceManager;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.DatabaseHolder;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.errorrecovery.ErrorRecovery;
import expo.modules.updates.errorrecovery.ErrorRecoveryDelegate;
import expo.modules.updates.launcher.Launcher;
import expo.modules.updates.launcher.NoDatabaseLauncher;
import expo.modules.updates.loader.FileDownloader;
import expo.modules.updates.loader.LoaderTask;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import expo.modules.updates.manifest.UpdateManifest;
import expo.modules.updates.procedures.StartupProcedure;
import expo.modules.updates.procedures.StateMachineProcedure;
import expo.modules.updates.selectionpolicy.SelectionPolicy;
import expo.modules.updates.statemachine.UpdatesStateEvent;
import expo.modules.updates.statemachine.UpdatesStateValue;
import io.sentry.SentryEvent;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: StartupProcedure.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001BBE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u000208H\u0002J\b\u0010:\u001a\u000208H\u0002J\u000e\u0010;\u001a\u0002082\u0006\u0010<\u001a\u00020=J\u0010\u0010>\u001a\u0002082\u0006\u00103\u001a\u000204H\u0016J\u000e\u0010?\u001a\u0002082\u0006\u0010)\u001a\u00020(J\u0010\u0010@\u001a\u0002082\u0006\u0010A\u001a\u000206H\u0002R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b!\u0010 R\u0013\u0010\"\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b#\u0010\u0016R\u0013\u0010$\u001a\u0004\u0018\u00010%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\"\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u001d\u001a\u0004\u0018\u00010(@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010.\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0014\u0018\u00010/8F¢\u0006\u0006\u001a\u0004\b1\u00102R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lexpo/modules/updates/procedures/StartupProcedure;", "Lexpo/modules/updates/procedures/StateMachineProcedure;", "context", "Landroid/content/Context;", "updatesConfiguration", "Lexpo/modules/updates/UpdatesConfiguration;", "databaseHolder", "Lexpo/modules/updates/db/DatabaseHolder;", "updatesDirectory", "Ljava/io/File;", "fileDownloader", "Lexpo/modules/updates/loader/FileDownloader;", "selectionPolicy", "Lexpo/modules/updates/selectionpolicy/SelectionPolicy;", SentryEvent.JsonKeys.LOGGER, "Lexpo/modules/updates/logging/UpdatesLogger;", "callback", "Lexpo/modules/updates/procedures/StartupProcedure$StartupProcedureCallback;", "(Landroid/content/Context;Lexpo/modules/updates/UpdatesConfiguration;Lexpo/modules/updates/db/DatabaseHolder;Ljava/io/File;Lexpo/modules/updates/loader/FileDownloader;Lexpo/modules/updates/selectionpolicy/SelectionPolicy;Lexpo/modules/updates/logging/UpdatesLogger;Lexpo/modules/updates/procedures/StartupProcedure$StartupProcedureCallback;)V", "bundleAssetName", "", "getBundleAssetName", "()Ljava/lang/String;", "databaseHandler", "Landroid/os/Handler;", "databaseHandlerThread", "Landroid/os/HandlerThread;", "errorRecovery", "Lexpo/modules/updates/errorrecovery/ErrorRecovery;", "<set-?>", "", "isEmergencyLaunch", "()Z", "isUsingEmbeddedAssets", "launchAssetFile", "getLaunchAssetFile", "launchedUpdate", "Lexpo/modules/updates/db/entity/UpdateEntity;", "getLaunchedUpdate", "()Lexpo/modules/updates/db/entity/UpdateEntity;", "Lexpo/modules/updates/launcher/Launcher;", "launcher", "getLauncher", "()Lexpo/modules/updates/launcher/Launcher;", "loaderTask", "Lexpo/modules/updates/loader/LoaderTask;", "localAssetFiles", "", "Lexpo/modules/updates/db/entity/AssetEntity;", "getLocalAssetFiles", "()Ljava/util/Map;", "procedureContext", "Lexpo/modules/updates/procedures/StateMachineProcedure$ProcedureContext;", "remoteLoadStatus", "Lexpo/modules/updates/errorrecovery/ErrorRecoveryDelegate$RemoteLoadStatus;", "initializeDatabaseHandler", "", "initializeErrorRecovery", "notifyController", "onDidCreateReactInstanceManager", "reactInstanceManager", "Lcom/facebook/react/ReactInstanceManager;", "run", "setLauncher", "setRemoteLoadStatus", "status", "StartupProcedureCallback", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class StartupProcedure extends StateMachineProcedure {
    private final StartupProcedureCallback callback;
    private final Context context;
    private Handler databaseHandler;
    private final HandlerThread databaseHandlerThread;
    private final DatabaseHolder databaseHolder;
    private final ErrorRecovery errorRecovery;
    private final FileDownloader fileDownloader;
    private boolean isEmergencyLaunch;
    private Launcher launcher;
    private final LoaderTask loaderTask;
    private final UpdatesLogger logger;
    private StateMachineProcedure.ProcedureContext procedureContext;
    private ErrorRecoveryDelegate.RemoteLoadStatus remoteLoadStatus;
    private final SelectionPolicy selectionPolicy;
    private final UpdatesConfiguration updatesConfiguration;
    private final File updatesDirectory;

    public StartupProcedure(Context context, UpdatesConfiguration updatesConfiguration, DatabaseHolder databaseHolder, File updatesDirectory, FileDownloader fileDownloader, SelectionPolicy selectionPolicy, UpdatesLogger logger, StartupProcedureCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(updatesConfiguration, "updatesConfiguration");
        Intrinsics.checkNotNullParameter(databaseHolder, "databaseHolder");
        Intrinsics.checkNotNullParameter(updatesDirectory, "updatesDirectory");
        Intrinsics.checkNotNullParameter(fileDownloader, "fileDownloader");
        Intrinsics.checkNotNullParameter(selectionPolicy, "selectionPolicy");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.context = context;
        this.updatesConfiguration = updatesConfiguration;
        this.databaseHolder = databaseHolder;
        this.updatesDirectory = updatesDirectory;
        this.fileDownloader = fileDownloader;
        this.selectionPolicy = selectionPolicy;
        this.logger = logger;
        this.callback = callback;
        this.errorRecovery = new ErrorRecovery(context);
        this.remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.IDLE;
        this.databaseHandlerThread = new HandlerThread("expo-updates-database");
        this.loaderTask = new LoaderTask(updatesConfiguration, databaseHolder, updatesDirectory, fileDownloader, selectionPolicy, new LoaderTask.LoaderTaskCallback() { // from class: expo.modules.updates.procedures.StartupProcedure$loaderTask$1

            /* compiled from: StartupProcedure.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;
                public static final /* synthetic */ int[] $EnumSwitchMapping$1;

                static {
                    int[] iArr = new int[UpdatesStateValue.values().length];
                    try {
                        iArr[UpdatesStateValue.Idle.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[UpdatesStateValue.Checking.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                    int[] iArr2 = new int[LoaderTask.RemoteUpdateStatus.values().length];
                    try {
                        iArr2[LoaderTask.RemoteUpdateStatus.ERROR.ordinal()] = 1;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr2[LoaderTask.RemoteUpdateStatus.UPDATE_AVAILABLE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr2[LoaderTask.RemoteUpdateStatus.NO_UPDATE_AVAILABLE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused5) {
                    }
                    $EnumSwitchMapping$1 = iArr2;
                }
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public boolean onCachedUpdateLoaded(UpdateEntity update) {
                Intrinsics.checkNotNullParameter(update, "update");
                return true;
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onFailure(Exception e) {
                UpdatesLogger updatesLogger;
                Context context2;
                Intrinsics.checkNotNullParameter(e, "e");
                updatesLogger = StartupProcedure.this.logger;
                UpdatesLogger.error$default(updatesLogger, "UpdatesController loaderTask onFailure: " + e.getLocalizedMessage(), UpdatesErrorCode.None, null, 4, null);
                StartupProcedure startupProcedure = StartupProcedure.this;
                context2 = StartupProcedure.this.context;
                startupProcedure.launcher = new NoDatabaseLauncher(context2, e);
                StartupProcedure.this.isEmergencyLaunch = true;
                StartupProcedure.this.notifyController();
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onSuccess(Launcher launcher, boolean isUpToDate) {
                ErrorRecoveryDelegate.RemoteLoadStatus remoteLoadStatus;
                Intrinsics.checkNotNullParameter(launcher, "launcher");
                remoteLoadStatus = StartupProcedure.this.remoteLoadStatus;
                if (remoteLoadStatus == ErrorRecoveryDelegate.RemoteLoadStatus.NEW_UPDATE_LOADING && isUpToDate) {
                    StartupProcedure.this.remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.IDLE;
                }
                StartupProcedure.this.launcher = launcher;
                StartupProcedure.this.notifyController();
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onFinishedAllLoading() {
                StateMachineProcedure.ProcedureContext procedureContext;
                procedureContext = StartupProcedure.this.procedureContext;
                if (procedureContext == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                    procedureContext = null;
                }
                procedureContext.onComplete();
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onRemoteCheckForUpdateStarted() {
                StateMachineProcedure.ProcedureContext procedureContext;
                procedureContext = StartupProcedure.this.procedureContext;
                if (procedureContext == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                    procedureContext = null;
                }
                procedureContext.processStateEvent(new UpdatesStateEvent.Check());
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onRemoteCheckForUpdateFinished(LoaderTask.RemoteCheckResult result) {
                UpdatesStateEvent.CheckCompleteWithRollback checkCompleteWithRollback;
                StateMachineProcedure.ProcedureContext procedureContext;
                Intrinsics.checkNotNullParameter(result, "result");
                if (result instanceof LoaderTask.RemoteCheckResult.NoUpdateAvailable) {
                    checkCompleteWithRollback = new UpdatesStateEvent.CheckCompleteUnavailable();
                } else if (result instanceof LoaderTask.RemoteCheckResult.UpdateAvailable) {
                    checkCompleteWithRollback = new UpdatesStateEvent.CheckCompleteWithUpdate(((LoaderTask.RemoteCheckResult.UpdateAvailable) result).getManifest());
                } else {
                    if (!(result instanceof LoaderTask.RemoteCheckResult.RollBackToEmbedded)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    checkCompleteWithRollback = new UpdatesStateEvent.CheckCompleteWithRollback(((LoaderTask.RemoteCheckResult.RollBackToEmbedded) result).getCommitTime());
                }
                procedureContext = StartupProcedure.this.procedureContext;
                if (procedureContext == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                    procedureContext = null;
                }
                procedureContext.processStateEvent(checkCompleteWithRollback);
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onRemoteUpdateManifestResponseManifestLoaded(UpdateManifest updateManifest) {
                Intrinsics.checkNotNullParameter(updateManifest, "updateManifest");
                StartupProcedure.this.remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.NEW_UPDATE_LOADING;
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onRemoteUpdateLoadStarted() {
                StateMachineProcedure.ProcedureContext procedureContext;
                procedureContext = StartupProcedure.this.procedureContext;
                if (procedureContext == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                    procedureContext = null;
                }
                procedureContext.processStateEvent(new UpdatesStateEvent.Download());
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onRemoteUpdateAssetLoaded(AssetEntity asset, int successfulAssetCount, int failedAssetCount, int totalAssetCount) {
                UpdatesLogger updatesLogger;
                Intrinsics.checkNotNullParameter(asset, "asset");
                Map mapOf = MapsKt.mapOf(TuplesKt.to("assetInfo", MapsKt.mapOf(TuplesKt.to("name", asset.getEmbeddedAssetFilename()), TuplesKt.to("successfulAssetCount", Integer.valueOf(successfulAssetCount)), TuplesKt.to("failedAssetCount", Integer.valueOf(failedAssetCount)), TuplesKt.to("totalAssetCount", Integer.valueOf(totalAssetCount)))));
                updatesLogger = StartupProcedure.this.logger;
                updatesLogger.info("AppController appLoaderTask didLoadAsset: " + mapOf, UpdatesErrorCode.None, null, asset.getExpectedHash());
            }

            @Override // expo.modules.updates.loader.LoaderTask.LoaderTaskCallback
            public void onRemoteUpdateFinished(LoaderTask.RemoteUpdateStatus status, UpdateEntity update, Exception exception) {
                UpdatesLogger updatesLogger;
                StartupProcedure.StartupProcedureCallback startupProcedureCallback;
                StateMachineProcedure.ProcedureContext procedureContext;
                StateMachineProcedure.ProcedureContext procedureContext2;
                StateMachineProcedure.ProcedureContext procedureContext3;
                StateMachineProcedure.ProcedureContext procedureContext4;
                StateMachineProcedure.ProcedureContext procedureContext5;
                ErrorRecovery errorRecovery;
                ErrorRecoveryDelegate.RemoteLoadStatus remoteLoadStatus;
                UpdatesLogger updatesLogger2;
                StartupProcedure.StartupProcedureCallback startupProcedureCallback2;
                StateMachineProcedure.ProcedureContext procedureContext6;
                UpdatesLogger updatesLogger3;
                StartupProcedure.StartupProcedureCallback startupProcedureCallback3;
                StateMachineProcedure.ProcedureContext procedureContext7;
                StateMachineProcedure.ProcedureContext procedureContext8;
                Intrinsics.checkNotNullParameter(status, "status");
                int i = WhenMappings.$EnumSwitchMapping$1[status.ordinal()];
                StateMachineProcedure.ProcedureContext procedureContext9 = null;
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            StartupProcedure.this.remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.IDLE;
                            updatesLogger3 = StartupProcedure.this.logger;
                            UpdatesLogger.error$default(updatesLogger3, "UpdatesController onBackgroundUpdateFinished: No update available", UpdatesErrorCode.NoUpdatesAvailable, null, 4, null);
                            startupProcedureCallback3 = StartupProcedure.this.callback;
                            startupProcedureCallback3.onLegacyJSEvent(new StartupProcedure.StartupProcedureCallback.LegacyJSEvent.NoUpdateAvailable());
                            procedureContext7 = StartupProcedure.this.procedureContext;
                            if (procedureContext7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                                procedureContext7 = null;
                            }
                            if (procedureContext7.getCurrentState() == UpdatesStateValue.Downloading) {
                                procedureContext8 = StartupProcedure.this.procedureContext;
                                if (procedureContext8 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                                } else {
                                    procedureContext9 = procedureContext8;
                                }
                                procedureContext9.processStateEvent(new UpdatesStateEvent.DownloadComplete());
                            }
                        }
                    } else if (update != null) {
                        StartupProcedure.this.remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.NEW_UPDATE_LOADED;
                        updatesLogger2 = StartupProcedure.this.logger;
                        updatesLogger2.info("UpdatesController onBackgroundUpdateFinished: Update available", UpdatesErrorCode.None);
                        startupProcedureCallback2 = StartupProcedure.this.callback;
                        startupProcedureCallback2.onLegacyJSEvent(new StartupProcedure.StartupProcedureCallback.LegacyJSEvent.UpdateAvailable(update.getManifest()));
                        procedureContext6 = StartupProcedure.this.procedureContext;
                        if (procedureContext6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                        } else {
                            procedureContext9 = procedureContext6;
                        }
                        procedureContext9.processStateEvent(new UpdatesStateEvent.DownloadCompleteWithUpdate(update.getManifest()));
                    } else {
                        throw new AssertionError("Background update with error status must have a nonnull update object");
                    }
                } else if (exception != null) {
                    updatesLogger = StartupProcedure.this.logger;
                    updatesLogger.error("UpdatesController onBackgroundUpdateFinished: Error: " + exception.getLocalizedMessage(), UpdatesErrorCode.Unknown, exception);
                    StartupProcedure.this.remoteLoadStatus = ErrorRecoveryDelegate.RemoteLoadStatus.IDLE;
                    startupProcedureCallback = StartupProcedure.this.callback;
                    startupProcedureCallback.onLegacyJSEvent(new StartupProcedure.StartupProcedureCallback.LegacyJSEvent.Error(exception));
                    procedureContext = StartupProcedure.this.procedureContext;
                    if (procedureContext == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                        procedureContext = null;
                    }
                    int i2 = WhenMappings.$EnumSwitchMapping$0[procedureContext.getCurrentState().ordinal()];
                    if (i2 == 1) {
                        procedureContext2 = StartupProcedure.this.procedureContext;
                        if (procedureContext2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                            procedureContext2 = null;
                        }
                        procedureContext2.processStateEvent(new UpdatesStateEvent.Download());
                        procedureContext3 = StartupProcedure.this.procedureContext;
                        if (procedureContext3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                        } else {
                            procedureContext9 = procedureContext3;
                        }
                        String message = exception.getMessage();
                        procedureContext9.processStateEvent(new UpdatesStateEvent.DownloadError(message != null ? message : ""));
                    } else if (i2 != 2) {
                        procedureContext5 = StartupProcedure.this.procedureContext;
                        if (procedureContext5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                        } else {
                            procedureContext9 = procedureContext5;
                        }
                        String message2 = exception.getMessage();
                        procedureContext9.processStateEvent(new UpdatesStateEvent.DownloadError(message2 != null ? message2 : ""));
                    } else {
                        procedureContext4 = StartupProcedure.this.procedureContext;
                        if (procedureContext4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("procedureContext");
                        } else {
                            procedureContext9 = procedureContext4;
                        }
                        String message3 = exception.getMessage();
                        procedureContext9.processStateEvent(new UpdatesStateEvent.CheckError(message3 != null ? message3 : ""));
                    }
                } else {
                    throw new AssertionError("Background update with error status must have a nonnull exception object");
                }
                errorRecovery = StartupProcedure.this.errorRecovery;
                remoteLoadStatus = StartupProcedure.this.remoteLoadStatus;
                errorRecovery.notifyNewRemoteLoadStatus(remoteLoadStatus);
            }
        });
    }

    /* compiled from: StartupProcedure.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\fJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lexpo/modules/updates/procedures/StartupProcedure$StartupProcedureCallback;", "", "onFinished", "", "onLegacyJSEvent", "event", "Lexpo/modules/updates/procedures/StartupProcedure$StartupProcedureCallback$LegacyJSEvent;", "onRequestRelaunch", "shouldRunReaper", "", "callback", "Lexpo/modules/updates/launcher/Launcher$LauncherCallback;", "LegacyJSEvent", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface StartupProcedureCallback {
        void onFinished();

        void onLegacyJSEvent(LegacyJSEvent event);

        void onRequestRelaunch(boolean shouldRunReaper, Launcher.LauncherCallback callback);

        /* compiled from: StartupProcedure.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0005\u0006\u0007\bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/updates/procedures/StartupProcedure$StartupProcedureCallback$LegacyJSEvent;", "", "type", "Lexpo/modules/updates/procedures/StartupProcedure$StartupProcedureCallback$LegacyJSEvent$Type;", "(Lexpo/modules/updates/procedures/StartupProcedure$StartupProcedureCallback$LegacyJSEvent$Type;)V", "Error", "NoUpdateAvailable", "Type", "UpdateAvailable", "Lexpo/modules/updates/procedures/StartupProcedure$StartupProcedureCallback$LegacyJSEvent$Error;", "Lexpo/modules/updates/procedures/StartupProcedure$StartupProcedureCallback$LegacyJSEvent$NoUpdateAvailable;", "Lexpo/modules/updates/procedures/StartupProcedure$StartupProcedureCallback$LegacyJSEvent$UpdateAvailable;", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static abstract class LegacyJSEvent {
            private final Type type;

            /* compiled from: StartupProcedure.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/updates/procedures/StartupProcedure$StartupProcedureCallback$LegacyJSEvent$Type;", "", "(Ljava/lang/String;I)V", "ERROR", "UPDATE_AVAILABLE", "NO_UPDATE_AVAILABLE", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            private enum Type {
                ERROR,
                UPDATE_AVAILABLE,
                NO_UPDATE_AVAILABLE
            }

            public /* synthetic */ LegacyJSEvent(Type type, DefaultConstructorMarker defaultConstructorMarker) {
                this(type);
            }

            private LegacyJSEvent(Type type) {
                this.type = type;
            }

            /* compiled from: StartupProcedure.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/updates/procedures/StartupProcedure$StartupProcedureCallback$LegacyJSEvent$NoUpdateAvailable;", "Lexpo/modules/updates/procedures/StartupProcedure$StartupProcedureCallback$LegacyJSEvent;", "()V", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class NoUpdateAvailable extends LegacyJSEvent {
                public NoUpdateAvailable() {
                    super(Type.NO_UPDATE_AVAILABLE, null);
                }
            }

            /* compiled from: StartupProcedure.kt */
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/updates/procedures/StartupProcedure$StartupProcedureCallback$LegacyJSEvent$UpdateAvailable;", "Lexpo/modules/updates/procedures/StartupProcedure$StartupProcedureCallback$LegacyJSEvent;", "manifest", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getManifest", "()Lorg/json/JSONObject;", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class UpdateAvailable extends LegacyJSEvent {
                private final JSONObject manifest;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public UpdateAvailable(JSONObject manifest) {
                    super(Type.UPDATE_AVAILABLE, null);
                    Intrinsics.checkNotNullParameter(manifest, "manifest");
                    this.manifest = manifest;
                }

                public final JSONObject getManifest() {
                    return this.manifest;
                }
            }

            /* compiled from: StartupProcedure.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/updates/procedures/StartupProcedure$StartupProcedureCallback$LegacyJSEvent$Error;", "Lexpo/modules/updates/procedures/StartupProcedure$StartupProcedureCallback$LegacyJSEvent;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;)V", "getException", "()Ljava/lang/Exception;", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
            public static final class Error extends LegacyJSEvent {
                private final Exception exception;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Error(Exception exception) {
                    super(Type.ERROR, null);
                    Intrinsics.checkNotNullParameter(exception, "exception");
                    this.exception = exception;
                }

                public final Exception getException() {
                    return this.exception;
                }
            }
        }
    }

    public final Launcher getLauncher() {
        return this.launcher;
    }

    public final void setLauncher(Launcher launcher) {
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        this.launcher = launcher;
    }

    public final String getLaunchAssetFile() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.getLaunchAssetFile();
        }
        return null;
    }

    public final String getBundleAssetName() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.getBundleAssetName();
        }
        return null;
    }

    public final Map<AssetEntity, String> getLocalAssetFiles() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.mo1072getLocalAssetFiles();
        }
        return null;
    }

    public final boolean isUsingEmbeddedAssets() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.isUsingEmbeddedAssets();
        }
        return false;
    }

    public final UpdateEntity getLaunchedUpdate() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.getLaunchedUpdate();
        }
        return null;
    }

    /* renamed from: isEmergencyLaunch, reason: from getter */
    public final boolean getIsEmergencyLaunch() {
        return this.isEmergencyLaunch;
    }

    private final void initializeDatabaseHandler() {
        if (this.databaseHandler == null) {
            this.databaseHandlerThread.start();
            this.databaseHandler = new Handler(this.databaseHandlerThread.getLooper());
        }
    }

    @Override // expo.modules.updates.procedures.StateMachineProcedure
    public void run(StateMachineProcedure.ProcedureContext procedureContext) {
        Intrinsics.checkNotNullParameter(procedureContext, "procedureContext");
        this.procedureContext = procedureContext;
        initializeDatabaseHandler();
        initializeErrorRecovery();
        this.loaderTask.start(this.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void notifyController() {
        if (this.launcher == null) {
            throw new AssertionError("UpdatesController.notifyController was called with a null launcher, which is an error. This method should only be called when an update is ready to launch.");
        }
        this.callback.onFinished();
    }

    public final void onDidCreateReactInstanceManager(ReactInstanceManager reactInstanceManager) {
        Intrinsics.checkNotNullParameter(reactInstanceManager, "reactInstanceManager");
        if (this.isEmergencyLaunch) {
            return;
        }
        this.errorRecovery.startMonitoring(reactInstanceManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRemoteLoadStatus(ErrorRecoveryDelegate.RemoteLoadStatus status) {
        this.remoteLoadStatus = status;
        this.errorRecovery.notifyNewRemoteLoadStatus(status);
    }

    private final void initializeErrorRecovery() {
        this.errorRecovery.initialize(new StartupProcedure$initializeErrorRecovery$1(this));
    }
}
