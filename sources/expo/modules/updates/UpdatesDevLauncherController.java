package expo.modules.updates;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import com.amplitude.reactnative.DatabaseConstants;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.updates.IUpdatesController;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.DatabaseHolder;
import expo.modules.updates.db.Reaper;
import expo.modules.updates.db.UpdatesDatabase;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.launcher.DatabaseLauncher;
import expo.modules.updates.launcher.Launcher;
import expo.modules.updates.loader.FileDownloader;
import expo.modules.updates.loader.Loader;
import expo.modules.updates.loader.RemoteLoader;
import expo.modules.updates.loader.UpdateDirective;
import expo.modules.updates.loader.UpdateResponse;
import expo.modules.updates.loader.UpdateResponsePart;
import expo.modules.updates.manifest.UpdateManifest;
import expo.modules.updates.selectionpolicy.LauncherSelectionPolicySingleUpdate;
import expo.modules.updates.selectionpolicy.ReaperSelectionPolicyDevelopmentClient;
import expo.modules.updates.selectionpolicy.SelectionPolicy;
import expo.modules.updates.selectionpolicy.SelectionPolicyFactory;
import expo.modules.updates.statemachine.UpdatesStateContext;
import expo.modules.updatesinterface.UpdatesInterface;
import expo.modules.updatesinterface.UpdatesInterfaceCallbacks;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: UpdatesDevLauncherController.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002:\u0001YBA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0016\u00103\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u00020706H\u0016J\u0016\u00108\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u00020906H\u0016J<\u0010:\u001a\u0002042\"\u0010;\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020=0<j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020=`>2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00105\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020AH\u0016J\b\u0010B\u001a\u00020CH\u0002J\u0016\u0010D\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u00020E06H\u0016J\u0016\u0010F\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u00020G06H\u0016J(\u0010H\u001a\u0002042\u0006\u0010I\u001a\u00020!2\u0006\u0010;\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00105\u001a\u00020?H\u0002J\u0010\u0010J\u001a\u0002042\u0006\u0010K\u001a\u00020LH\u0016J\u0016\u0010M\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u00020406H\u0016J\b\u0010N\u001a\u000204H\u0002J\b\u0010O\u001a\u000204H\u0016J\b\u0010P\u001a\u000204H\u0002J\b\u0010Q\u001a\u000204H\u0002J\u0010\u0010R\u001a\u0002042\u0006\u0010-\u001a\u00020\u0018H\u0002J\b\u0010S\u001a\u000204H\u0002J(\u0010T\u001a\u0002042\u0006\u0010U\u001a\u00020\u00122\b\u0010V\u001a\u0004\u0018\u00010\u00122\f\u00105\u001a\b\u0012\u0004\u0012\u00020406H\u0016J\u0012\u0010W\u001a\u0002042\b\u0010-\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010X\u001a\u000204H\u0016R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014R\u0013\u0010 \u001a\u0004\u0018\u00010!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010&\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u0012\u0018\u00010'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0010\u00100\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0016\u0010\t\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lexpo/modules/updates/UpdatesDevLauncherController;", "Lexpo/modules/updates/IUpdatesController;", "Lexpo/modules/updatesinterface/UpdatesInterface;", "context", "Landroid/content/Context;", "initialUpdatesConfiguration", "Lexpo/modules/updates/UpdatesConfiguration;", "updatesDirectory", "Ljava/io/File;", "updatesDirectoryException", "Ljava/lang/Exception;", "Lkotlin/Exception;", "isMissingRuntimeVersion", "", "callbacks", "Lexpo/modules/updatesinterface/UpdatesInterfaceCallbacks;", "(Landroid/content/Context;Lexpo/modules/updates/UpdatesConfiguration;Ljava/io/File;Ljava/lang/Exception;ZLexpo/modules/updatesinterface/UpdatesInterfaceCallbacks;)V", "bundleAssetName", "", "getBundleAssetName", "()Ljava/lang/String;", "databaseHolder", "Lexpo/modules/updates/db/DatabaseHolder;", "defaultSelectionPolicy", "Lexpo/modules/updates/selectionpolicy/SelectionPolicy;", "fileDownloader", "Lexpo/modules/updates/loader/FileDownloader;", "isEmergencyLaunch", "()Z", "isUsingEmbeddedAssets", "launchAssetFile", "getLaunchAssetFile", "launchedUpdate", "Lexpo/modules/updates/db/entity/UpdateEntity;", "getLaunchedUpdate", "()Lexpo/modules/updates/db/entity/UpdateEntity;", "launcher", "Lexpo/modules/updates/launcher/Launcher;", "localAssetFiles", "", "Lexpo/modules/updates/db/entity/AssetEntity;", "getLocalAssetFiles", "()Ljava/util/Map;", "mSelectionPolicy", "previousUpdatesConfiguration", "selectionPolicy", "getSelectionPolicy", "()Lexpo/modules/updates/selectionpolicy/SelectionPolicy;", "updatesConfiguration", "getUpdatesDirectory", "()Ljava/io/File;", "checkForUpdate", "", "callback", "Lexpo/modules/updates/IUpdatesController$ModuleCallback;", "Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult;", "fetchUpdate", "Lexpo/modules/updates/IUpdatesController$FetchUpdateResult;", "fetchUpdateWithConfiguration", "configuration", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Lexpo/modules/updatesinterface/UpdatesInterface$UpdateCallback;", "getConstantsForModule", "Lexpo/modules/updates/IUpdatesController$UpdatesModuleConstants;", "getDatabase", "Lexpo/modules/updates/db/UpdatesDatabase;", "getExtraParams", "Landroid/os/Bundle;", "getNativeStateMachineContext", "Lexpo/modules/updates/statemachine/UpdatesStateContext;", "launchUpdate", "update", "onDidCreateReactInstanceManager", "reactInstanceManager", "Lcom/facebook/react/ReactInstanceManager;", "relaunchReactApplicationForModule", "releaseDatabase", "reset", "resetSelectionPolicyToDefault", "runReaper", "setDefaultSelectionPolicy", "setDevelopmentSelectionPolicy", "setExtraParam", DatabaseConstants.KEY_FIELD, "value", "setNextSelectionPolicy", ViewProps.START, "NotAvailableInDevClientException", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UpdatesDevLauncherController implements IUpdatesController, UpdatesInterface {
    private final UpdatesInterfaceCallbacks callbacks;
    private final Context context;
    private final DatabaseHolder databaseHolder;
    private SelectionPolicy defaultSelectionPolicy;
    private final FileDownloader fileDownloader;
    private final boolean isEmergencyLaunch;
    private final boolean isMissingRuntimeVersion;
    private Launcher launcher;
    private SelectionPolicy mSelectionPolicy;
    private UpdatesConfiguration previousUpdatesConfiguration;
    private UpdatesConfiguration updatesConfiguration;
    private final File updatesDirectory;
    private final Exception updatesDirectoryException;

    /* compiled from: UpdatesDevLauncherController.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UpdatesConfigurationValidationResult.values().length];
            try {
                iArr[UpdatesConfigurationValidationResult.VALID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UpdatesConfigurationValidationResult.INVALID_NOT_ENABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UpdatesConfigurationValidationResult.INVALID_MISSING_URL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UpdatesConfigurationValidationResult.INVALID_MISSING_RUNTIME_VERSION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // expo.modules.updates.IUpdatesController
    public void onDidCreateReactInstanceManager(ReactInstanceManager reactInstanceManager) {
        Intrinsics.checkNotNullParameter(reactInstanceManager, "reactInstanceManager");
    }

    public UpdatesDevLauncherController(Context context, UpdatesConfiguration updatesConfiguration, File file, Exception exc, boolean z, UpdatesInterfaceCallbacks callbacks) {
        String runtimeVersion;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        this.context = context;
        this.updatesDirectory = file;
        this.updatesDirectoryException = exc;
        this.isMissingRuntimeVersion = z;
        this.callbacks = callbacks;
        this.isEmergencyLaunch = exc != null;
        this.updatesConfiguration = updatesConfiguration;
        this.databaseHolder = new DatabaseHolder(UpdatesDatabase.INSTANCE.getInstance(context));
        this.fileDownloader = new FileDownloader(context);
        this.defaultSelectionPolicy = SelectionPolicyFactory.createFilterAwarePolicy((updatesConfiguration == null || (runtimeVersion = updatesConfiguration.getRuntimeVersion()) == null) ? "1" : runtimeVersion);
    }

    @Override // expo.modules.updates.IUpdatesController
    public File getUpdatesDirectory() {
        return this.updatesDirectory;
    }

    @Override // expo.modules.updates.IUpdatesController
    /* renamed from: isEmergencyLaunch, reason: from getter */
    public boolean getIsEmergencyLaunch() {
        return this.isEmergencyLaunch;
    }

    private final SelectionPolicy getSelectionPolicy() {
        SelectionPolicy selectionPolicy = this.mSelectionPolicy;
        return selectionPolicy == null ? this.defaultSelectionPolicy : selectionPolicy;
    }

    private final void setNextSelectionPolicy(SelectionPolicy selectionPolicy) {
        this.mSelectionPolicy = selectionPolicy;
    }

    private final void resetSelectionPolicyToDefault() {
        this.mSelectionPolicy = null;
    }

    private final void setDefaultSelectionPolicy(SelectionPolicy selectionPolicy) {
        this.defaultSelectionPolicy = selectionPolicy;
    }

    @Override // expo.modules.updates.IUpdatesController
    public synchronized String getLaunchAssetFile() {
        throw new Exception("IUpdatesController.launchAssetFile should not be called in dev client");
    }

    @Override // expo.modules.updates.IUpdatesController
    public String getBundleAssetName() {
        throw new Exception("IUpdatesController.bundleAssetName should not be called in dev client");
    }

    @Override // expo.modules.updates.IUpdatesController
    public void start() {
        throw new Exception("IUpdatesController.start should not be called in dev client");
    }

    public final UpdateEntity getLaunchedUpdate() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.getLaunchedUpdate();
        }
        return null;
    }

    private final Map<AssetEntity, String> getLocalAssetFiles() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.mo1072getLocalAssetFiles();
        }
        return null;
    }

    private final boolean isUsingEmbeddedAssets() {
        Launcher launcher = this.launcher;
        if (launcher != null) {
            return launcher.getIsUsingEmbeddedAssets();
        }
        return false;
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    public void reset() {
        this.launcher = null;
    }

    @Override // expo.modules.updatesinterface.UpdatesInterface
    public void fetchUpdateWithConfiguration(HashMap<String, Object> configuration, final Context context, final UpdatesInterface.UpdateCallback callback) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (getUpdatesDirectory() == null) {
            Exception exc = this.updatesDirectoryException;
            Intrinsics.checkNotNull(exc);
            callback.onFailure(exc);
            return;
        }
        HashMap<String, Object> hashMap = configuration;
        int i = WhenMappings.$EnumSwitchMapping$0[UpdatesConfiguration.INSTANCE.getUpdatesConfigurationValidationResult(context, hashMap).ordinal()];
        if (i == 1) {
            UpdatesConfiguration updatesConfiguration = new UpdatesConfiguration(context, hashMap);
            this.previousUpdatesConfiguration = this.updatesConfiguration;
            this.updatesConfiguration = updatesConfiguration;
            setDevelopmentSelectionPolicy();
            UpdatesConfiguration updatesConfiguration2 = this.updatesConfiguration;
            Intrinsics.checkNotNull(updatesConfiguration2);
            new RemoteLoader(context, updatesConfiguration2, this.databaseHolder.getDatabase(), this.fileDownloader, getUpdatesDirectory(), null).start(new Loader.LoaderCallback() { // from class: expo.modules.updates.UpdatesDevLauncherController$fetchUpdateWithConfiguration$1
                @Override // expo.modules.updates.loader.Loader.LoaderCallback
                public void onFailure(Exception e) {
                    DatabaseHolder databaseHolder;
                    UpdatesConfiguration updatesConfiguration3;
                    Intrinsics.checkNotNullParameter(e, "e");
                    databaseHolder = UpdatesDevLauncherController.this.databaseHolder;
                    databaseHolder.releaseDatabase();
                    UpdatesDevLauncherController updatesDevLauncherController = UpdatesDevLauncherController.this;
                    updatesConfiguration3 = updatesDevLauncherController.previousUpdatesConfiguration;
                    updatesDevLauncherController.updatesConfiguration = updatesConfiguration3;
                    callback.onFailure(e);
                }

                @Override // expo.modules.updates.loader.Loader.LoaderCallback
                public void onSuccess(Loader.LoaderResult loaderResult) {
                    DatabaseHolder databaseHolder;
                    UpdatesConfiguration updatesConfiguration3;
                    Intrinsics.checkNotNullParameter(loaderResult, "loaderResult");
                    databaseHolder = UpdatesDevLauncherController.this.databaseHolder;
                    databaseHolder.releaseDatabase();
                    if (loaderResult.getUpdateEntity() == null) {
                        callback.onSuccess(null);
                        return;
                    }
                    UpdatesDevLauncherController updatesDevLauncherController = UpdatesDevLauncherController.this;
                    UpdateEntity updateEntity = loaderResult.getUpdateEntity();
                    updatesConfiguration3 = UpdatesDevLauncherController.this.updatesConfiguration;
                    Intrinsics.checkNotNull(updatesConfiguration3);
                    updatesDevLauncherController.launchUpdate(updateEntity, updatesConfiguration3, context, callback);
                }

                @Override // expo.modules.updates.loader.Loader.LoaderCallback
                public void onAssetLoaded(AssetEntity asset, int successfulAssetCount, int failedAssetCount, int totalAssetCount) {
                    Intrinsics.checkNotNullParameter(asset, "asset");
                    callback.onProgress(successfulAssetCount, failedAssetCount, totalAssetCount);
                }

                @Override // expo.modules.updates.loader.Loader.LoaderCallback
                public Loader.OnUpdateResponseLoadedResult onUpdateResponseLoaded(UpdateResponse updateResponse) {
                    UpdateManifest updateManifest;
                    Intrinsics.checkNotNullParameter(updateResponse, "updateResponse");
                    UpdateResponsePart.DirectiveUpdateResponsePart directiveUpdateResponsePart = updateResponse.getDirectiveUpdateResponsePart();
                    UpdateDirective updateDirective = directiveUpdateResponsePart != null ? directiveUpdateResponsePart.getUpdateDirective() : null;
                    if (updateDirective != null) {
                        if ((updateDirective instanceof UpdateDirective.RollBackToEmbeddedUpdateDirective) || (updateDirective instanceof UpdateDirective.NoUpdateAvailableUpdateDirective)) {
                            return new Loader.OnUpdateResponseLoadedResult(false);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    UpdateResponsePart.ManifestUpdateResponsePart manifestUpdateResponsePart = updateResponse.getManifestUpdateResponsePart();
                    if (manifestUpdateResponsePart == null || (updateManifest = manifestUpdateResponsePart.getUpdateManifest()) == null) {
                        return new Loader.OnUpdateResponseLoadedResult(false);
                    }
                    return new Loader.OnUpdateResponseLoadedResult(callback.onManifestLoaded(updateManifest.getManifest().getRawJson()));
                }
            });
            return;
        }
        if (i == 2) {
            callback.onFailure(new Exception("Failed to load update: UpdatesConfiguration object is not enabled"));
        } else if (i == 3) {
            callback.onFailure(new Exception("Failed to load update: UpdatesConfiguration object must include a valid update URL"));
        } else {
            if (i == 4) {
                callback.onFailure(new Exception("Failed to load update: UpdatesConfiguration object must include a valid runtime version"));
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void setDevelopmentSelectionPolicy() {
        resetSelectionPolicyToDefault();
        SelectionPolicy selectionPolicy = getSelectionPolicy();
        setDefaultSelectionPolicy(new SelectionPolicy(selectionPolicy.getLauncherSelectionPolicy(), selectionPolicy.getLoaderSelectionPolicy(), new ReaperSelectionPolicyDevelopmentClient(0, 1, null)));
        resetSelectionPolicyToDefault();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchUpdate(UpdateEntity update, UpdatesConfiguration configuration, Context context, final UpdatesInterface.UpdateCallback callback) {
        SelectionPolicy selectionPolicy = getSelectionPolicy();
        setNextSelectionPolicy(new SelectionPolicy(new LauncherSelectionPolicySingleUpdate(update.getId()), selectionPolicy.getLoaderSelectionPolicy(), selectionPolicy.getReaperSelectionPolicy()));
        File updatesDirectory = getUpdatesDirectory();
        Intrinsics.checkNotNull(updatesDirectory);
        final DatabaseLauncher databaseLauncher = new DatabaseLauncher(configuration, updatesDirectory, this.fileDownloader, getSelectionPolicy());
        databaseLauncher.launch(this.databaseHolder.getDatabase(), context, new Launcher.LauncherCallback() { // from class: expo.modules.updates.UpdatesDevLauncherController$launchUpdate$1
            @Override // expo.modules.updates.launcher.Launcher.LauncherCallback
            public void onFailure(Exception e) {
                DatabaseHolder databaseHolder;
                UpdatesConfiguration updatesConfiguration;
                Intrinsics.checkNotNullParameter(e, "e");
                databaseHolder = UpdatesDevLauncherController.this.databaseHolder;
                databaseHolder.releaseDatabase();
                UpdatesDevLauncherController updatesDevLauncherController = UpdatesDevLauncherController.this;
                updatesConfiguration = updatesDevLauncherController.previousUpdatesConfiguration;
                updatesDevLauncherController.updatesConfiguration = updatesConfiguration;
                callback.onFailure(e);
            }

            @Override // expo.modules.updates.launcher.Launcher.LauncherCallback
            public void onSuccess() {
                DatabaseHolder databaseHolder;
                databaseHolder = UpdatesDevLauncherController.this.databaseHolder;
                databaseHolder.releaseDatabase();
                UpdatesDevLauncherController.this.launcher = databaseLauncher;
                UpdatesInterface.UpdateCallback updateCallback = callback;
                final DatabaseLauncher databaseLauncher2 = databaseLauncher;
                updateCallback.onSuccess(new UpdatesInterface.Update() { // from class: expo.modules.updates.UpdatesDevLauncherController$launchUpdate$1$onSuccess$1
                    @Override // expo.modules.updatesinterface.UpdatesInterface.Update
                    /* renamed from: getManifest */
                    public JSONObject get$manifest() {
                        UpdateEntity launchedUpdate = DatabaseLauncher.this.getLaunchedUpdate();
                        Intrinsics.checkNotNull(launchedUpdate);
                        return launchedUpdate.getManifest();
                    }

                    @Override // expo.modules.updatesinterface.UpdatesInterface.Update
                    public String getLaunchAssetPath() {
                        String launchAssetFile = DatabaseLauncher.this.getLaunchAssetFile();
                        Intrinsics.checkNotNull(launchAssetFile);
                        return launchAssetFile;
                    }
                });
                UpdatesDevLauncherController.this.runReaper();
            }
        });
    }

    private final UpdatesDatabase getDatabase() {
        return this.databaseHolder.getDatabase();
    }

    private final void releaseDatabase() {
        this.databaseHolder.releaseDatabase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runReaper() {
        AsyncTask.execute(new Runnable() { // from class: expo.modules.updates.UpdatesDevLauncherController$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                UpdatesDevLauncherController.runReaper$lambda$1(UpdatesDevLauncherController.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runReaper$lambda$1(UpdatesDevLauncherController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UpdatesConfiguration updatesConfiguration = this$0.updatesConfiguration;
        if (updatesConfiguration != null) {
            Reaper.reapUnusedUpdates(updatesConfiguration, this$0.getDatabase(), this$0.getUpdatesDirectory(), this$0.getLaunchedUpdate(), this$0.getSelectionPolicy());
            this$0.releaseDatabase();
        }
    }

    /* compiled from: UpdatesDevLauncherController.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lexpo/modules/updates/UpdatesDevLauncherController$NotAvailableInDevClientException;", "Lexpo/modules/kotlin/exception/CodedException;", "message", "", "(Ljava/lang/String;)V", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class NotAvailableInDevClientException extends CodedException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NotAvailableInDevClientException(String message) {
            super(message, null, 2, null);
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    @Override // expo.modules.updates.IUpdatesController
    public IUpdatesController.UpdatesModuleConstants getConstantsForModule() {
        String str;
        String str2;
        UpdatesConfiguration.CheckAutomaticallyConfiguration checkAutomaticallyConfiguration;
        Map<String, String> emptyMap;
        UpdateEntity launchedUpdate = getLaunchedUpdate();
        boolean isEmergencyLaunch = getIsEmergencyLaunch();
        UpdatesConfiguration updatesConfiguration = this.updatesConfiguration;
        if (updatesConfiguration == null || (str = updatesConfiguration.getReleaseChannel()) == null) {
            str = "default";
        }
        String str3 = str;
        boolean isUsingEmbeddedAssets = isUsingEmbeddedAssets();
        UpdatesConfiguration updatesConfiguration2 = this.updatesConfiguration;
        if (updatesConfiguration2 == null || (str2 = updatesConfiguration2.getRuntimeVersionRaw()) == null) {
            str2 = "1";
        }
        String str4 = str2;
        UpdatesConfiguration updatesConfiguration3 = this.updatesConfiguration;
        if (updatesConfiguration3 == null || (checkAutomaticallyConfiguration = updatesConfiguration3.getCheckOnLaunch()) == null) {
            checkAutomaticallyConfiguration = UpdatesConfiguration.CheckAutomaticallyConfiguration.ALWAYS;
        }
        UpdatesConfiguration.CheckAutomaticallyConfiguration checkAutomaticallyConfiguration2 = checkAutomaticallyConfiguration;
        UpdatesConfiguration updatesConfiguration4 = this.updatesConfiguration;
        if (updatesConfiguration4 == null || (emptyMap = updatesConfiguration4.getRequestHeaders()) == null) {
            emptyMap = MapsKt.emptyMap();
        }
        return new IUpdatesController.UpdatesModuleConstants(launchedUpdate, null, isEmergencyLaunch, true, str3, isUsingEmbeddedAssets, str4, checkAutomaticallyConfiguration2, emptyMap, getLocalAssetFiles(), this.isMissingRuntimeVersion, true);
    }

    @Override // expo.modules.updates.IUpdatesController
    public void relaunchReactApplicationForModule(IUpdatesController.ModuleCallback<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callbacks.onRequestRelaunch();
        callback.onSuccess(Unit.INSTANCE);
    }

    @Override // expo.modules.updates.IUpdatesController
    public void getNativeStateMachineContext(IUpdatesController.ModuleCallback<UpdatesStateContext> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onSuccess(new UpdatesStateContext(false, false, false, false, false, null, null, null, null, null, null, 2047, null));
    }

    @Override // expo.modules.updates.IUpdatesController
    public void checkForUpdate(IUpdatesController.ModuleCallback<IUpdatesController.CheckForUpdateResult> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onFailure(new NotAvailableInDevClientException("Cannot check for update in a development client. A non-development build should be used to test this functionality."));
    }

    @Override // expo.modules.updates.IUpdatesController
    public void fetchUpdate(IUpdatesController.ModuleCallback<IUpdatesController.FetchUpdateResult> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onFailure(new NotAvailableInDevClientException("Cannot fetch update in a development client. A non-development build should be used to test this functionality."));
    }

    @Override // expo.modules.updates.IUpdatesController
    public void getExtraParams(IUpdatesController.ModuleCallback<Bundle> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onFailure(new NotAvailableInDevClientException("Cannot get extra params in a development client. A non-development build should be used to test this functionality."));
    }

    @Override // expo.modules.updates.IUpdatesController
    public void setExtraParam(String key, String value, IUpdatesController.ModuleCallback<Unit> callback) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onFailure(new NotAvailableInDevClientException("Cannot set extra params in a development client. A non-development build should be used to test this functionality."));
    }
}
