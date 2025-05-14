package expo.modules.updates;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.amplitude.reactnative.DatabaseConstants;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.perf.util.Constants;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.loader.LoaderTask;
import expo.modules.updates.manifest.UpdateManifest;
import expo.modules.updates.statemachine.UpdatesStateContext;
import io.sentry.clientreport.DiscardedEvent;
import java.io.File;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IUpdatesController.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001:\u0004$%&'J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H&J\u0016\u0010\u0014\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012H&J\b\u0010\u0016\u001a\u00020\u0017H&J\u0016\u0010\u0018\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00190\u0012H&J\u0016\u0010\u001a\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0012H&J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0016\u0010\u001f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H&J(\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H&J\b\u0010#\u001a\u00020\u0010H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0005R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006("}, d2 = {"Lexpo/modules/updates/IUpdatesController;", "", "bundleAssetName", "", "getBundleAssetName", "()Ljava/lang/String;", "isEmergencyLaunch", "", "()Z", "launchAssetFile", "getLaunchAssetFile", "updatesDirectory", "Ljava/io/File;", "getUpdatesDirectory", "()Ljava/io/File;", "checkForUpdate", "", "callback", "Lexpo/modules/updates/IUpdatesController$ModuleCallback;", "Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult;", "fetchUpdate", "Lexpo/modules/updates/IUpdatesController$FetchUpdateResult;", "getConstantsForModule", "Lexpo/modules/updates/IUpdatesController$UpdatesModuleConstants;", "getExtraParams", "Landroid/os/Bundle;", "getNativeStateMachineContext", "Lexpo/modules/updates/statemachine/UpdatesStateContext;", "onDidCreateReactInstanceManager", "reactInstanceManager", "Lcom/facebook/react/ReactInstanceManager;", "relaunchReactApplicationForModule", "setExtraParam", DatabaseConstants.KEY_FIELD, "value", ViewProps.START, "CheckForUpdateResult", "FetchUpdateResult", "ModuleCallback", "UpdatesModuleConstants", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IUpdatesController {

    /* compiled from: IUpdatesController.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lexpo/modules/updates/IUpdatesController$ModuleCallback;", ExifInterface.GPS_DIRECTION_TRUE, "", "onFailure", "", "exception", "Lexpo/modules/kotlin/exception/CodedException;", "onSuccess", "result", "(Ljava/lang/Object;)V", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ModuleCallback<T> {
        void onFailure(CodedException exception);

        void onSuccess(T result);
    }

    void checkForUpdate(ModuleCallback<CheckForUpdateResult> callback);

    void fetchUpdate(ModuleCallback<FetchUpdateResult> callback);

    String getBundleAssetName();

    UpdatesModuleConstants getConstantsForModule();

    void getExtraParams(ModuleCallback<Bundle> callback);

    String getLaunchAssetFile();

    void getNativeStateMachineContext(ModuleCallback<UpdatesStateContext> callback);

    File getUpdatesDirectory();

    boolean isEmergencyLaunch();

    void onDidCreateReactInstanceManager(ReactInstanceManager reactInstanceManager);

    void relaunchReactApplicationForModule(ModuleCallback<Unit> callback);

    void setExtraParam(String key, String value, ModuleCallback<Unit> callback);

    void start();

    /* compiled from: IUpdatesController.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000f\u0012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0002\u0010\u0014J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fHÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010,\u001a\u00020\rHÆ\u0003J\u0015\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000fHÆ\u0003J¡\u0001\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0006HÆ\u0001J\u0013\u0010/\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\tHÖ\u0001R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0019R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u001f\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019¨\u00064"}, d2 = {"Lexpo/modules/updates/IUpdatesController$UpdatesModuleConstants;", "", "launchedUpdate", "Lexpo/modules/updates/db/entity/UpdateEntity;", "embeddedUpdate", "isEmergencyLaunch", "", Constants.ENABLE_DISABLE, UpdatesConfiguration.UPDATES_CONFIGURATION_RELEASE_CHANNEL_KEY, "", "isUsingEmbeddedAssets", UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY, UpdatesConfiguration.UPDATES_CONFIGURATION_CHECK_ON_LAUNCH_KEY, "Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration;", UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, "", "localAssetFiles", "Lexpo/modules/updates/db/entity/AssetEntity;", "isMissingRuntimeVersion", "shouldDeferToNativeForAPIMethodAvailabilityInDevelopment", "(Lexpo/modules/updates/db/entity/UpdateEntity;Lexpo/modules/updates/db/entity/UpdateEntity;ZZLjava/lang/String;ZLjava/lang/String;Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration;Ljava/util/Map;Ljava/util/Map;ZZ)V", "getCheckOnLaunch", "()Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration;", "getEmbeddedUpdate", "()Lexpo/modules/updates/db/entity/UpdateEntity;", "()Z", "getLaunchedUpdate", "getLocalAssetFiles", "()Ljava/util/Map;", "getReleaseChannel", "()Ljava/lang/String;", "getRequestHeaders", "getRuntimeVersion", "getShouldDeferToNativeForAPIMethodAvailabilityInDevelopment", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class UpdatesModuleConstants {
        private final UpdatesConfiguration.CheckAutomaticallyConfiguration checkOnLaunch;
        private final UpdateEntity embeddedUpdate;
        private final boolean isEmergencyLaunch;
        private final boolean isEnabled;
        private final boolean isMissingRuntimeVersion;
        private final boolean isUsingEmbeddedAssets;
        private final UpdateEntity launchedUpdate;
        private final Map<AssetEntity, String> localAssetFiles;
        private final String releaseChannel;
        private final Map<String, String> requestHeaders;
        private final String runtimeVersion;
        private final boolean shouldDeferToNativeForAPIMethodAvailabilityInDevelopment;

        /* renamed from: component1, reason: from getter */
        public final UpdateEntity getLaunchedUpdate() {
            return this.launchedUpdate;
        }

        public final Map<AssetEntity, String> component10() {
            return this.localAssetFiles;
        }

        /* renamed from: component11, reason: from getter */
        public final boolean getIsMissingRuntimeVersion() {
            return this.isMissingRuntimeVersion;
        }

        /* renamed from: component12, reason: from getter */
        public final boolean getShouldDeferToNativeForAPIMethodAvailabilityInDevelopment() {
            return this.shouldDeferToNativeForAPIMethodAvailabilityInDevelopment;
        }

        /* renamed from: component2, reason: from getter */
        public final UpdateEntity getEmbeddedUpdate() {
            return this.embeddedUpdate;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsEmergencyLaunch() {
            return this.isEmergencyLaunch;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsEnabled() {
            return this.isEnabled;
        }

        /* renamed from: component5, reason: from getter */
        public final String getReleaseChannel() {
            return this.releaseChannel;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsUsingEmbeddedAssets() {
            return this.isUsingEmbeddedAssets;
        }

        /* renamed from: component7, reason: from getter */
        public final String getRuntimeVersion() {
            return this.runtimeVersion;
        }

        /* renamed from: component8, reason: from getter */
        public final UpdatesConfiguration.CheckAutomaticallyConfiguration getCheckOnLaunch() {
            return this.checkOnLaunch;
        }

        public final Map<String, String> component9() {
            return this.requestHeaders;
        }

        public final UpdatesModuleConstants copy(UpdateEntity launchedUpdate, UpdateEntity embeddedUpdate, boolean isEmergencyLaunch, boolean isEnabled, String releaseChannel, boolean isUsingEmbeddedAssets, String runtimeVersion, UpdatesConfiguration.CheckAutomaticallyConfiguration checkOnLaunch, Map<String, String> requestHeaders, Map<AssetEntity, String> localAssetFiles, boolean isMissingRuntimeVersion, boolean shouldDeferToNativeForAPIMethodAvailabilityInDevelopment) {
            Intrinsics.checkNotNullParameter(releaseChannel, "releaseChannel");
            Intrinsics.checkNotNullParameter(checkOnLaunch, "checkOnLaunch");
            Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
            return new UpdatesModuleConstants(launchedUpdate, embeddedUpdate, isEmergencyLaunch, isEnabled, releaseChannel, isUsingEmbeddedAssets, runtimeVersion, checkOnLaunch, requestHeaders, localAssetFiles, isMissingRuntimeVersion, shouldDeferToNativeForAPIMethodAvailabilityInDevelopment);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdatesModuleConstants)) {
                return false;
            }
            UpdatesModuleConstants updatesModuleConstants = (UpdatesModuleConstants) other;
            return Intrinsics.areEqual(this.launchedUpdate, updatesModuleConstants.launchedUpdate) && Intrinsics.areEqual(this.embeddedUpdate, updatesModuleConstants.embeddedUpdate) && this.isEmergencyLaunch == updatesModuleConstants.isEmergencyLaunch && this.isEnabled == updatesModuleConstants.isEnabled && Intrinsics.areEqual(this.releaseChannel, updatesModuleConstants.releaseChannel) && this.isUsingEmbeddedAssets == updatesModuleConstants.isUsingEmbeddedAssets && Intrinsics.areEqual(this.runtimeVersion, updatesModuleConstants.runtimeVersion) && this.checkOnLaunch == updatesModuleConstants.checkOnLaunch && Intrinsics.areEqual(this.requestHeaders, updatesModuleConstants.requestHeaders) && Intrinsics.areEqual(this.localAssetFiles, updatesModuleConstants.localAssetFiles) && this.isMissingRuntimeVersion == updatesModuleConstants.isMissingRuntimeVersion && this.shouldDeferToNativeForAPIMethodAvailabilityInDevelopment == updatesModuleConstants.shouldDeferToNativeForAPIMethodAvailabilityInDevelopment;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            UpdateEntity updateEntity = this.launchedUpdate;
            int hashCode = (updateEntity == null ? 0 : updateEntity.hashCode()) * 31;
            UpdateEntity updateEntity2 = this.embeddedUpdate;
            int hashCode2 = (hashCode + (updateEntity2 == null ? 0 : updateEntity2.hashCode())) * 31;
            boolean z = this.isEmergencyLaunch;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (hashCode2 + i) * 31;
            boolean z2 = this.isEnabled;
            int i3 = z2;
            if (z2 != 0) {
                i3 = 1;
            }
            int hashCode3 = (((i2 + i3) * 31) + this.releaseChannel.hashCode()) * 31;
            boolean z3 = this.isUsingEmbeddedAssets;
            int i4 = z3;
            if (z3 != 0) {
                i4 = 1;
            }
            int i5 = (hashCode3 + i4) * 31;
            String str = this.runtimeVersion;
            int hashCode4 = (((((i5 + (str == null ? 0 : str.hashCode())) * 31) + this.checkOnLaunch.hashCode()) * 31) + this.requestHeaders.hashCode()) * 31;
            Map<AssetEntity, String> map = this.localAssetFiles;
            int hashCode5 = (hashCode4 + (map != null ? map.hashCode() : 0)) * 31;
            boolean z4 = this.isMissingRuntimeVersion;
            int i6 = z4;
            if (z4 != 0) {
                i6 = 1;
            }
            int i7 = (hashCode5 + i6) * 31;
            boolean z5 = this.shouldDeferToNativeForAPIMethodAvailabilityInDevelopment;
            return i7 + (z5 ? 1 : z5 ? 1 : 0);
        }

        public String toString() {
            return "UpdatesModuleConstants(launchedUpdate=" + this.launchedUpdate + ", embeddedUpdate=" + this.embeddedUpdate + ", isEmergencyLaunch=" + this.isEmergencyLaunch + ", isEnabled=" + this.isEnabled + ", releaseChannel=" + this.releaseChannel + ", isUsingEmbeddedAssets=" + this.isUsingEmbeddedAssets + ", runtimeVersion=" + this.runtimeVersion + ", checkOnLaunch=" + this.checkOnLaunch + ", requestHeaders=" + this.requestHeaders + ", localAssetFiles=" + this.localAssetFiles + ", isMissingRuntimeVersion=" + this.isMissingRuntimeVersion + ", shouldDeferToNativeForAPIMethodAvailabilityInDevelopment=" + this.shouldDeferToNativeForAPIMethodAvailabilityInDevelopment + ")";
        }

        public UpdatesModuleConstants(UpdateEntity updateEntity, UpdateEntity updateEntity2, boolean z, boolean z2, String releaseChannel, boolean z3, String str, UpdatesConfiguration.CheckAutomaticallyConfiguration checkOnLaunch, Map<String, String> requestHeaders, Map<AssetEntity, String> map, boolean z4, boolean z5) {
            Intrinsics.checkNotNullParameter(releaseChannel, "releaseChannel");
            Intrinsics.checkNotNullParameter(checkOnLaunch, "checkOnLaunch");
            Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
            this.launchedUpdate = updateEntity;
            this.embeddedUpdate = updateEntity2;
            this.isEmergencyLaunch = z;
            this.isEnabled = z2;
            this.releaseChannel = releaseChannel;
            this.isUsingEmbeddedAssets = z3;
            this.runtimeVersion = str;
            this.checkOnLaunch = checkOnLaunch;
            this.requestHeaders = requestHeaders;
            this.localAssetFiles = map;
            this.isMissingRuntimeVersion = z4;
            this.shouldDeferToNativeForAPIMethodAvailabilityInDevelopment = z5;
        }

        public final UpdateEntity getLaunchedUpdate() {
            return this.launchedUpdate;
        }

        public final UpdateEntity getEmbeddedUpdate() {
            return this.embeddedUpdate;
        }

        public final boolean isEmergencyLaunch() {
            return this.isEmergencyLaunch;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        public final String getReleaseChannel() {
            return this.releaseChannel;
        }

        public final boolean isUsingEmbeddedAssets() {
            return this.isUsingEmbeddedAssets;
        }

        public final String getRuntimeVersion() {
            return this.runtimeVersion;
        }

        public final UpdatesConfiguration.CheckAutomaticallyConfiguration getCheckOnLaunch() {
            return this.checkOnLaunch;
        }

        public final Map<String, String> getRequestHeaders() {
            return this.requestHeaders;
        }

        public final Map<AssetEntity, String> getLocalAssetFiles() {
            return this.localAssetFiles;
        }

        public final boolean isMissingRuntimeVersion() {
            return this.isMissingRuntimeVersion;
        }

        public final boolean getShouldDeferToNativeForAPIMethodAvailabilityInDevelopment() {
            return this.shouldDeferToNativeForAPIMethodAvailabilityInDevelopment;
        }
    }

    /* compiled from: IUpdatesController.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0005\u0006\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0004\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult;", "", "status", "Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult$Status;", "(Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult$Status;)V", "ErrorResult", "NoUpdateAvailable", "RollBackToEmbedded", "Status", "UpdateAvailable", "Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult$ErrorResult;", "Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult$NoUpdateAvailable;", "Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult$RollBackToEmbedded;", "Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult$UpdateAvailable;", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class CheckForUpdateResult {
        private final Status status;

        /* compiled from: IUpdatesController.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult$Status;", "", "(Ljava/lang/String;I)V", "NO_UPDATE_AVAILABLE", "UPDATE_AVAILABLE", "ROLL_BACK_TO_EMBEDDED", "ERROR", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        private enum Status {
            NO_UPDATE_AVAILABLE,
            UPDATE_AVAILABLE,
            ROLL_BACK_TO_EMBEDDED,
            ERROR
        }

        public /* synthetic */ CheckForUpdateResult(Status status, DefaultConstructorMarker defaultConstructorMarker) {
            this(status);
        }

        private CheckForUpdateResult(Status status) {
            this.status = status;
        }

        /* compiled from: IUpdatesController.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult$NoUpdateAvailable;", "Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult;", DiscardedEvent.JsonKeys.REASON, "Lexpo/modules/updates/loader/LoaderTask$RemoteCheckResultNotAvailableReason;", "(Lexpo/modules/updates/loader/LoaderTask$RemoteCheckResultNotAvailableReason;)V", "getReason", "()Lexpo/modules/updates/loader/LoaderTask$RemoteCheckResultNotAvailableReason;", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class NoUpdateAvailable extends CheckForUpdateResult {
            private final LoaderTask.RemoteCheckResultNotAvailableReason reason;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NoUpdateAvailable(LoaderTask.RemoteCheckResultNotAvailableReason reason) {
                super(Status.NO_UPDATE_AVAILABLE, null);
                Intrinsics.checkNotNullParameter(reason, "reason");
                this.reason = reason;
            }

            public final LoaderTask.RemoteCheckResultNotAvailableReason getReason() {
                return this.reason;
            }
        }

        /* compiled from: IUpdatesController.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult$UpdateAvailable;", "Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult;", "updateManifest", "Lexpo/modules/updates/manifest/UpdateManifest;", "(Lexpo/modules/updates/manifest/UpdateManifest;)V", "getUpdateManifest", "()Lexpo/modules/updates/manifest/UpdateManifest;", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class UpdateAvailable extends CheckForUpdateResult {
            private final UpdateManifest updateManifest;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateAvailable(UpdateManifest updateManifest) {
                super(Status.UPDATE_AVAILABLE, null);
                Intrinsics.checkNotNullParameter(updateManifest, "updateManifest");
                this.updateManifest = updateManifest;
            }

            public final UpdateManifest getUpdateManifest() {
                return this.updateManifest;
            }
        }

        /* compiled from: IUpdatesController.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult$RollBackToEmbedded;", "Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult;", "commitTime", "Ljava/util/Date;", "(Ljava/util/Date;)V", "getCommitTime", "()Ljava/util/Date;", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class RollBackToEmbedded extends CheckForUpdateResult {
            private final Date commitTime;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RollBackToEmbedded(Date commitTime) {
                super(Status.ROLL_BACK_TO_EMBEDDED, null);
                Intrinsics.checkNotNullParameter(commitTime, "commitTime");
                this.commitTime = commitTime;
            }

            public final Date getCommitTime() {
                return this.commitTime;
            }
        }

        /* compiled from: IUpdatesController.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult$ErrorResult;", "Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult;", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/Exception;Ljava/lang/String;)V", "getError", "()Ljava/lang/Exception;", "getMessage", "()Ljava/lang/String;", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class ErrorResult extends CheckForUpdateResult {
            private final Exception error;
            private final String message;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ErrorResult(Exception error, String message) {
                super(Status.ERROR, null);
                Intrinsics.checkNotNullParameter(error, "error");
                Intrinsics.checkNotNullParameter(message, "message");
                this.error = error;
                this.message = message;
            }

            public final Exception getError() {
                return this.error;
            }

            public final String getMessage() {
                return this.message;
            }
        }
    }

    /* compiled from: IUpdatesController.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0005\u0006\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0004\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lexpo/modules/updates/IUpdatesController$FetchUpdateResult;", "", "status", "Lexpo/modules/updates/IUpdatesController$FetchUpdateResult$Status;", "(Lexpo/modules/updates/IUpdatesController$FetchUpdateResult$Status;)V", "ErrorResult", "Failure", "RollBackToEmbedded", "Status", "Success", "Lexpo/modules/updates/IUpdatesController$FetchUpdateResult$ErrorResult;", "Lexpo/modules/updates/IUpdatesController$FetchUpdateResult$Failure;", "Lexpo/modules/updates/IUpdatesController$FetchUpdateResult$RollBackToEmbedded;", "Lexpo/modules/updates/IUpdatesController$FetchUpdateResult$Success;", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class FetchUpdateResult {
        private final Status status;

        /* compiled from: IUpdatesController.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/updates/IUpdatesController$FetchUpdateResult$Status;", "", "(Ljava/lang/String;I)V", "SUCCESS", "FAILURE", "ROLL_BACK_TO_EMBEDDED", "ERROR", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        private enum Status {
            SUCCESS,
            FAILURE,
            ROLL_BACK_TO_EMBEDDED,
            ERROR
        }

        public /* synthetic */ FetchUpdateResult(Status status, DefaultConstructorMarker defaultConstructorMarker) {
            this(status);
        }

        private FetchUpdateResult(Status status) {
            this.status = status;
        }

        /* compiled from: IUpdatesController.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/updates/IUpdatesController$FetchUpdateResult$Success;", "Lexpo/modules/updates/IUpdatesController$FetchUpdateResult;", "update", "Lexpo/modules/updates/db/entity/UpdateEntity;", "(Lexpo/modules/updates/db/entity/UpdateEntity;)V", "getUpdate", "()Lexpo/modules/updates/db/entity/UpdateEntity;", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Success extends FetchUpdateResult {
            private final UpdateEntity update;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(UpdateEntity update) {
                super(Status.SUCCESS, null);
                Intrinsics.checkNotNullParameter(update, "update");
                this.update = update;
            }

            public final UpdateEntity getUpdate() {
                return this.update;
            }
        }

        /* compiled from: IUpdatesController.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/updates/IUpdatesController$FetchUpdateResult$Failure;", "Lexpo/modules/updates/IUpdatesController$FetchUpdateResult;", "()V", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Failure extends FetchUpdateResult {
            public Failure() {
                super(Status.FAILURE, null);
            }
        }

        /* compiled from: IUpdatesController.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/updates/IUpdatesController$FetchUpdateResult$RollBackToEmbedded;", "Lexpo/modules/updates/IUpdatesController$FetchUpdateResult;", "()V", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class RollBackToEmbedded extends FetchUpdateResult {
            public RollBackToEmbedded() {
                super(Status.ROLL_BACK_TO_EMBEDDED, null);
            }
        }

        /* compiled from: IUpdatesController.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/updates/IUpdatesController$FetchUpdateResult$ErrorResult;", "Lexpo/modules/updates/IUpdatesController$FetchUpdateResult;", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;)V", "getError", "()Ljava/lang/Exception;", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class ErrorResult extends FetchUpdateResult {
            private final Exception error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ErrorResult(Exception error) {
                super(Status.ERROR, null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final Exception getError() {
                return this.error;
            }
        }
    }
}
