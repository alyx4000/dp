package expo.modules.updates;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import expo.modules.core.errors.InvalidArgumentException;
import expo.modules.updates.codesigning.CodeSigningConfiguration;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Regex;

/* compiled from: UpdatesConfiguration.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b,\b\u0086\b\u0018\u0000 L2\u00020\u0001:\u0002KLB'\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007B\u009d\u0001\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\t¢\u0006\u0002\u0010\u001bJ\t\u00106\u001a\u00020\tHÆ\u0003J\u0015\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0017\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010:\u001a\u00020\tHÆ\u0003J\t\u0010;\u001a\u00020\tHÂ\u0003J\t\u0010<\u001a\u00020\tHÆ\u0003J\t\u0010=\u001a\u00020\u0006HÆ\u0003J\t\u0010>\u001a\u00020\fHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010A\u001a\u00020\u0006HÆ\u0003J\t\u0010B\u001a\u00020\u0011HÆ\u0003J\t\u0010C\u001a\u00020\u0013HÆ\u0003J\t\u0010D\u001a\u00020\tHÆ\u0003J¿\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\t2\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\tHÆ\u0001J\u0013\u0010F\u001a\u00020\t2\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010H\u001a\u00020\u0006J\t\u0010I\u001a\u00020\u0011HÖ\u0001J\t\u0010J\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0019\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010 \u001a\u0004\u0018\u00010!8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u0011\u0010\u0018\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001f\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u001a\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b+\u0010'R\u0011\u0010\u0014\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010'R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010)R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b4\u00105¨\u0006M"}, d2 = {"Lexpo/modules/updates/UpdatesConfiguration;", "", "context", "Landroid/content/Context;", "overrideMap", "", "", "(Landroid/content/Context;Ljava/util/Map;)V", UpdatesConfiguration.UPDATES_CONFIGURATION_EXPECTS_EXPO_SIGNED_MANIFEST, "", UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY, UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY, "Landroid/net/Uri;", "sdkVersion", "runtimeVersionRaw", UpdatesConfiguration.UPDATES_CONFIGURATION_RELEASE_CHANNEL_KEY, UpdatesConfiguration.UPDATES_CONFIGURATION_LAUNCH_WAIT_MS_KEY, "", UpdatesConfiguration.UPDATES_CONFIGURATION_CHECK_ON_LAUNCH_KEY, "Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration;", UpdatesConfiguration.UPDATES_CONFIGURATION_HAS_EMBEDDED_UPDATE_KEY, UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, UpdatesConfiguration.UPDATES_CONFIGURATION_CODE_SIGNING_CERTIFICATE, UpdatesConfiguration.UPDATES_CONFIGURATION_CODE_SIGNING_METADATA, UpdatesConfiguration.UPDATES_CONFIGURATION_CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN, UpdatesConfiguration.UPDATES_CONFIGURATION_CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS, "enableExpoUpdatesProtocolV0CompatibilityMode", "(ZLjava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration;ZLjava/util/Map;Ljava/lang/String;Ljava/util/Map;ZZZ)V", "getCheckOnLaunch", "()Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration;", "getCodeSigningCertificate", "()Ljava/lang/String;", "codeSigningConfiguration", "Lexpo/modules/updates/codesigning/CodeSigningConfiguration;", "getCodeSigningConfiguration", "()Lexpo/modules/updates/codesigning/CodeSigningConfiguration;", "codeSigningConfiguration$delegate", "Lkotlin/Lazy;", "getCodeSigningIncludeManifestResponseCertificateChain", "()Z", "getCodeSigningMetadata", "()Ljava/util/Map;", "getEnableExpoUpdatesProtocolV0CompatibilityMode", "getExpectsSignedManifest", "getHasEmbeddedUpdate", "getLaunchWaitMs", "()I", "getReleaseChannel", "getRequestHeaders", "getRuntimeVersionRaw", "getScopeKey", "getSdkVersion", "getUpdateUrl", "()Landroid/net/Uri;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getRuntimeVersion", "hashCode", "toString", "CheckAutomaticallyConfiguration", "Companion", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class UpdatesConfiguration {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "UpdatesConfiguration";
    public static final String UPDATES_CONFIGURATION_CHECK_ON_LAUNCH_KEY = "checkOnLaunch";
    public static final String UPDATES_CONFIGURATION_CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS = "codeSigningAllowUnsignedManifests";
    public static final String UPDATES_CONFIGURATION_CODE_SIGNING_CERTIFICATE = "codeSigningCertificate";
    public static final String UPDATES_CONFIGURATION_CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN = "codeSigningIncludeManifestResponseCertificateChain";
    public static final String UPDATES_CONFIGURATION_CODE_SIGNING_METADATA = "codeSigningMetadata";
    public static final String UPDATES_CONFIGURATION_ENABLED_KEY = "enabled";
    public static final String UPDATES_CONFIGURATION_ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE = "enableExpoUpdatesProtocolCompatibilityMode";
    public static final String UPDATES_CONFIGURATION_EXPECTS_EXPO_SIGNED_MANIFEST = "expectsSignedManifest";
    public static final String UPDATES_CONFIGURATION_HAS_EMBEDDED_UPDATE_KEY = "hasEmbeddedUpdate";
    private static final int UPDATES_CONFIGURATION_LAUNCH_WAIT_MS_DEFAULT_VALUE = 0;
    public static final String UPDATES_CONFIGURATION_LAUNCH_WAIT_MS_KEY = "launchWaitMs";
    public static final String UPDATES_CONFIGURATION_RELEASE_CHANNEL_DEFAULT_VALUE = "default";
    public static final String UPDATES_CONFIGURATION_RELEASE_CHANNEL_KEY = "releaseChannel";
    public static final String UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY = "requestHeaders";
    public static final String UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY = "runtimeVersion";
    public static final String UPDATES_CONFIGURATION_SCOPE_KEY_KEY = "scopeKey";
    public static final String UPDATES_CONFIGURATION_SDK_VERSION_KEY = "sdkVersion";
    public static final String UPDATES_CONFIGURATION_UPDATE_URL_KEY = "updateUrl";
    private final CheckAutomaticallyConfiguration checkOnLaunch;
    private final boolean codeSigningAllowUnsignedManifests;
    private final String codeSigningCertificate;

    /* renamed from: codeSigningConfiguration$delegate, reason: from kotlin metadata */
    private final Lazy codeSigningConfiguration;
    private final boolean codeSigningIncludeManifestResponseCertificateChain;
    private final Map<String, String> codeSigningMetadata;
    private final boolean enableExpoUpdatesProtocolV0CompatibilityMode;
    private final boolean expectsSignedManifest;
    private final boolean hasEmbeddedUpdate;
    private final int launchWaitMs;
    private final String releaseChannel;
    private final Map<String, String> requestHeaders;
    private final String runtimeVersionRaw;
    private final String scopeKey;
    private final String sdkVersion;
    private final Uri updateUrl;

    /* renamed from: component14, reason: from getter */
    private final boolean getCodeSigningAllowUnsignedManifests() {
        return this.codeSigningAllowUnsignedManifests;
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getExpectsSignedManifest() {
        return this.expectsSignedManifest;
    }

    public final Map<String, String> component10() {
        return this.requestHeaders;
    }

    /* renamed from: component11, reason: from getter */
    public final String getCodeSigningCertificate() {
        return this.codeSigningCertificate;
    }

    public final Map<String, String> component12() {
        return this.codeSigningMetadata;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getCodeSigningIncludeManifestResponseCertificateChain() {
        return this.codeSigningIncludeManifestResponseCertificateChain;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getEnableExpoUpdatesProtocolV0CompatibilityMode() {
        return this.enableExpoUpdatesProtocolV0CompatibilityMode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getScopeKey() {
        return this.scopeKey;
    }

    /* renamed from: component3, reason: from getter */
    public final Uri getUpdateUrl() {
        return this.updateUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    /* renamed from: component5, reason: from getter */
    public final String getRuntimeVersionRaw() {
        return this.runtimeVersionRaw;
    }

    /* renamed from: component6, reason: from getter */
    public final String getReleaseChannel() {
        return this.releaseChannel;
    }

    /* renamed from: component7, reason: from getter */
    public final int getLaunchWaitMs() {
        return this.launchWaitMs;
    }

    /* renamed from: component8, reason: from getter */
    public final CheckAutomaticallyConfiguration getCheckOnLaunch() {
        return this.checkOnLaunch;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getHasEmbeddedUpdate() {
        return this.hasEmbeddedUpdate;
    }

    public final UpdatesConfiguration copy(boolean expectsSignedManifest, String scopeKey, Uri updateUrl, String sdkVersion, String runtimeVersionRaw, String releaseChannel, int launchWaitMs, CheckAutomaticallyConfiguration checkOnLaunch, boolean hasEmbeddedUpdate, Map<String, String> requestHeaders, String codeSigningCertificate, Map<String, String> codeSigningMetadata, boolean codeSigningIncludeManifestResponseCertificateChain, boolean codeSigningAllowUnsignedManifests, boolean enableExpoUpdatesProtocolV0CompatibilityMode) {
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        Intrinsics.checkNotNullParameter(updateUrl, "updateUrl");
        Intrinsics.checkNotNullParameter(releaseChannel, "releaseChannel");
        Intrinsics.checkNotNullParameter(checkOnLaunch, "checkOnLaunch");
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        return new UpdatesConfiguration(expectsSignedManifest, scopeKey, updateUrl, sdkVersion, runtimeVersionRaw, releaseChannel, launchWaitMs, checkOnLaunch, hasEmbeddedUpdate, requestHeaders, codeSigningCertificate, codeSigningMetadata, codeSigningIncludeManifestResponseCertificateChain, codeSigningAllowUnsignedManifests, enableExpoUpdatesProtocolV0CompatibilityMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdatesConfiguration)) {
            return false;
        }
        UpdatesConfiguration updatesConfiguration = (UpdatesConfiguration) other;
        return this.expectsSignedManifest == updatesConfiguration.expectsSignedManifest && Intrinsics.areEqual(this.scopeKey, updatesConfiguration.scopeKey) && Intrinsics.areEqual(this.updateUrl, updatesConfiguration.updateUrl) && Intrinsics.areEqual(this.sdkVersion, updatesConfiguration.sdkVersion) && Intrinsics.areEqual(this.runtimeVersionRaw, updatesConfiguration.runtimeVersionRaw) && Intrinsics.areEqual(this.releaseChannel, updatesConfiguration.releaseChannel) && this.launchWaitMs == updatesConfiguration.launchWaitMs && this.checkOnLaunch == updatesConfiguration.checkOnLaunch && this.hasEmbeddedUpdate == updatesConfiguration.hasEmbeddedUpdate && Intrinsics.areEqual(this.requestHeaders, updatesConfiguration.requestHeaders) && Intrinsics.areEqual(this.codeSigningCertificate, updatesConfiguration.codeSigningCertificate) && Intrinsics.areEqual(this.codeSigningMetadata, updatesConfiguration.codeSigningMetadata) && this.codeSigningIncludeManifestResponseCertificateChain == updatesConfiguration.codeSigningIncludeManifestResponseCertificateChain && this.codeSigningAllowUnsignedManifests == updatesConfiguration.codeSigningAllowUnsignedManifests && this.enableExpoUpdatesProtocolV0CompatibilityMode == updatesConfiguration.enableExpoUpdatesProtocolV0CompatibilityMode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r2v16, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v24, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v26, types: [boolean] */
    public int hashCode() {
        boolean z = this.expectsSignedManifest;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = ((((r0 * 31) + this.scopeKey.hashCode()) * 31) + this.updateUrl.hashCode()) * 31;
        String str = this.sdkVersion;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.runtimeVersionRaw;
        int hashCode3 = (((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.releaseChannel.hashCode()) * 31) + Integer.hashCode(this.launchWaitMs)) * 31) + this.checkOnLaunch.hashCode()) * 31;
        ?? r2 = this.hasEmbeddedUpdate;
        int i = r2;
        if (r2 != 0) {
            i = 1;
        }
        int hashCode4 = (((hashCode3 + i) * 31) + this.requestHeaders.hashCode()) * 31;
        String str3 = this.codeSigningCertificate;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Map<String, String> map = this.codeSigningMetadata;
        int hashCode6 = (hashCode5 + (map != null ? map.hashCode() : 0)) * 31;
        ?? r22 = this.codeSigningIncludeManifestResponseCertificateChain;
        int i2 = r22;
        if (r22 != 0) {
            i2 = 1;
        }
        int i3 = (hashCode6 + i2) * 31;
        ?? r23 = this.codeSigningAllowUnsignedManifests;
        int i4 = r23;
        if (r23 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z2 = this.enableExpoUpdatesProtocolV0CompatibilityMode;
        return i5 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "UpdatesConfiguration(expectsSignedManifest=" + this.expectsSignedManifest + ", scopeKey=" + this.scopeKey + ", updateUrl=" + this.updateUrl + ", sdkVersion=" + this.sdkVersion + ", runtimeVersionRaw=" + this.runtimeVersionRaw + ", releaseChannel=" + this.releaseChannel + ", launchWaitMs=" + this.launchWaitMs + ", checkOnLaunch=" + this.checkOnLaunch + ", hasEmbeddedUpdate=" + this.hasEmbeddedUpdate + ", requestHeaders=" + this.requestHeaders + ", codeSigningCertificate=" + this.codeSigningCertificate + ", codeSigningMetadata=" + this.codeSigningMetadata + ", codeSigningIncludeManifestResponseCertificateChain=" + this.codeSigningIncludeManifestResponseCertificateChain + ", codeSigningAllowUnsignedManifests=" + this.codeSigningAllowUnsignedManifests + ", enableExpoUpdatesProtocolV0CompatibilityMode=" + this.enableExpoUpdatesProtocolV0CompatibilityMode + ")";
    }

    public UpdatesConfiguration(boolean z, String scopeKey, Uri updateUrl, String str, String str2, String releaseChannel, int i, CheckAutomaticallyConfiguration checkOnLaunch, boolean z2, Map<String, String> requestHeaders, String str3, Map<String, String> map, boolean z3, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(scopeKey, "scopeKey");
        Intrinsics.checkNotNullParameter(updateUrl, "updateUrl");
        Intrinsics.checkNotNullParameter(releaseChannel, "releaseChannel");
        Intrinsics.checkNotNullParameter(checkOnLaunch, "checkOnLaunch");
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        this.expectsSignedManifest = z;
        this.scopeKey = scopeKey;
        this.updateUrl = updateUrl;
        this.sdkVersion = str;
        this.runtimeVersionRaw = str2;
        this.releaseChannel = releaseChannel;
        this.launchWaitMs = i;
        this.checkOnLaunch = checkOnLaunch;
        this.hasEmbeddedUpdate = z2;
        this.requestHeaders = requestHeaders;
        this.codeSigningCertificate = str3;
        this.codeSigningMetadata = map;
        this.codeSigningIncludeManifestResponseCertificateChain = z3;
        this.codeSigningAllowUnsignedManifests = z4;
        this.enableExpoUpdatesProtocolV0CompatibilityMode = z5;
        this.codeSigningConfiguration = LazyKt.lazy(new Function0<CodeSigningConfiguration>() { // from class: expo.modules.updates.UpdatesConfiguration$codeSigningConfiguration$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CodeSigningConfiguration invoke() {
                boolean z6;
                String codeSigningCertificate = UpdatesConfiguration.this.getCodeSigningCertificate();
                if (codeSigningCertificate == null) {
                    return null;
                }
                UpdatesConfiguration updatesConfiguration = UpdatesConfiguration.this;
                Map<String, String> codeSigningMetadata = updatesConfiguration.getCodeSigningMetadata();
                boolean codeSigningIncludeManifestResponseCertificateChain = updatesConfiguration.getCodeSigningIncludeManifestResponseCertificateChain();
                z6 = updatesConfiguration.codeSigningAllowUnsignedManifests;
                return new CodeSigningConfiguration(codeSigningCertificate, codeSigningMetadata, codeSigningIncludeManifestResponseCertificateChain, z6);
            }
        });
    }

    public final boolean getExpectsSignedManifest() {
        return this.expectsSignedManifest;
    }

    public final String getScopeKey() {
        return this.scopeKey;
    }

    public final Uri getUpdateUrl() {
        return this.updateUrl;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final String getRuntimeVersionRaw() {
        return this.runtimeVersionRaw;
    }

    public final String getReleaseChannel() {
        return this.releaseChannel;
    }

    public final int getLaunchWaitMs() {
        return this.launchWaitMs;
    }

    public final CheckAutomaticallyConfiguration getCheckOnLaunch() {
        return this.checkOnLaunch;
    }

    public final boolean getHasEmbeddedUpdate() {
        return this.hasEmbeddedUpdate;
    }

    public final Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    public final String getCodeSigningCertificate() {
        return this.codeSigningCertificate;
    }

    public final Map<String, String> getCodeSigningMetadata() {
        return this.codeSigningMetadata;
    }

    public final boolean getCodeSigningIncludeManifestResponseCertificateChain() {
        return this.codeSigningIncludeManifestResponseCertificateChain;
    }

    public final boolean getEnableExpoUpdatesProtocolV0CompatibilityMode() {
        return this.enableExpoUpdatesProtocolV0CompatibilityMode;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: UpdatesConfiguration.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration;", "", "(Ljava/lang/String;I)V", "toJSString", "", "NEVER", "ERROR_RECOVERY_ONLY", "WIFI_ONLY", "ALWAYS", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CheckAutomaticallyConfiguration {
        public static final CheckAutomaticallyConfiguration NEVER = new NEVER("NEVER", 0);
        public static final CheckAutomaticallyConfiguration ERROR_RECOVERY_ONLY = new ERROR_RECOVERY_ONLY("ERROR_RECOVERY_ONLY", 1);
        public static final CheckAutomaticallyConfiguration WIFI_ONLY = new WIFI_ONLY("WIFI_ONLY", 2);
        public static final CheckAutomaticallyConfiguration ALWAYS = new ALWAYS("ALWAYS", 3);
        private static final /* synthetic */ CheckAutomaticallyConfiguration[] $VALUES = $values();

        private static final /* synthetic */ CheckAutomaticallyConfiguration[] $values() {
            return new CheckAutomaticallyConfiguration[]{NEVER, ERROR_RECOVERY_ONLY, WIFI_ONLY, ALWAYS};
        }

        public /* synthetic */ CheckAutomaticallyConfiguration(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        public static CheckAutomaticallyConfiguration valueOf(String str) {
            return (CheckAutomaticallyConfiguration) Enum.valueOf(CheckAutomaticallyConfiguration.class, str);
        }

        public static CheckAutomaticallyConfiguration[] values() {
            return (CheckAutomaticallyConfiguration[]) $VALUES.clone();
        }

        /* compiled from: UpdatesConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration$NEVER;", "Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration;", "toJSString", "", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class NEVER extends CheckAutomaticallyConfiguration {
            @Override // expo.modules.updates.UpdatesConfiguration.CheckAutomaticallyConfiguration
            public String toJSString() {
                return "NEVER";
            }

            NEVER(String str, int i) {
                super(str, i, null);
            }
        }

        private CheckAutomaticallyConfiguration(String str, int i) {
        }

        /* compiled from: UpdatesConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration$ERROR_RECOVERY_ONLY;", "Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration;", "toJSString", "", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class ERROR_RECOVERY_ONLY extends CheckAutomaticallyConfiguration {
            @Override // expo.modules.updates.UpdatesConfiguration.CheckAutomaticallyConfiguration
            public String toJSString() {
                return "ERROR_RECOVERY_ONLY";
            }

            ERROR_RECOVERY_ONLY(String str, int i) {
                super(str, i, null);
            }
        }

        /* compiled from: UpdatesConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration$WIFI_ONLY;", "Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration;", "toJSString", "", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class WIFI_ONLY extends CheckAutomaticallyConfiguration {
            @Override // expo.modules.updates.UpdatesConfiguration.CheckAutomaticallyConfiguration
            public String toJSString() {
                return "WIFI_ONLY";
            }

            WIFI_ONLY(String str, int i) {
                super(str, i, null);
            }
        }

        /* compiled from: UpdatesConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration$ALWAYS;", "Lexpo/modules/updates/UpdatesConfiguration$CheckAutomaticallyConfiguration;", "toJSString", "", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        static final class ALWAYS extends CheckAutomaticallyConfiguration {
            @Override // expo.modules.updates.UpdatesConfiguration.CheckAutomaticallyConfiguration
            public String toJSString() {
                return "ALWAYS";
            }

            ALWAYS(String str, int i) {
                super(str, i, null);
            }
        }

        public String toJSString() {
            throw new InvalidArgumentException("Unsupported CheckAutomaticallyConfiguration value");
        }
    }

    public final CodeSigningConfiguration getCodeSigningConfiguration() {
        return (CodeSigningConfiguration) this.codeSigningConfiguration.getValue();
    }

    public final String getRuntimeVersion() {
        String str = this.runtimeVersionRaw;
        if (!(str == null || str.length() == 0)) {
            return this.runtimeVersionRaw;
        }
        String str2 = this.sdkVersion;
        if (!(str2 == null || str2.length() == 0)) {
            return this.sdkVersion;
        }
        throw new Exception("No runtime version or SDK version provided in configuration");
    }

    /* compiled from: UpdatesConfiguration.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001eH\u0002J*\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001eH\u0002J*\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001eH\u0002J&\u0010!\u001a\u00020\"2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001eJ*\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001eH\u0002J&\u0010%\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001eR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lexpo/modules/updates/UpdatesConfiguration$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "UPDATES_CONFIGURATION_CHECK_ON_LAUNCH_KEY", "UPDATES_CONFIGURATION_CODE_SIGNING_ALLOW_UNSIGNED_MANIFESTS", "UPDATES_CONFIGURATION_CODE_SIGNING_CERTIFICATE", "UPDATES_CONFIGURATION_CODE_SIGNING_INCLUDE_MANIFEST_RESPONSE_CERTIFICATE_CHAIN", "UPDATES_CONFIGURATION_CODE_SIGNING_METADATA", "UPDATES_CONFIGURATION_ENABLED_KEY", "UPDATES_CONFIGURATION_ENABLE_EXPO_UPDATES_PROTOCOL_V0_COMPATIBILITY_MODE", "UPDATES_CONFIGURATION_EXPECTS_EXPO_SIGNED_MANIFEST", "UPDATES_CONFIGURATION_HAS_EMBEDDED_UPDATE_KEY", "UPDATES_CONFIGURATION_LAUNCH_WAIT_MS_DEFAULT_VALUE", "", "UPDATES_CONFIGURATION_LAUNCH_WAIT_MS_KEY", "UPDATES_CONFIGURATION_RELEASE_CHANNEL_DEFAULT_VALUE", "UPDATES_CONFIGURATION_RELEASE_CHANNEL_KEY", "UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY", "UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY", "UPDATES_CONFIGURATION_SCOPE_KEY_KEY", "UPDATES_CONFIGURATION_SDK_VERSION_KEY", "UPDATES_CONFIGURATION_UPDATE_URL_KEY", "getIsEnabled", "", "context", "Landroid/content/Context;", "overrideMap", "", "getRuntimeVersion", "getSDKVersion", "getUpdatesConfigurationValidationResult", "Lexpo/modules/updates/UpdatesConfigurationValidationResult;", "getUpdatesUrl", "Landroid/net/Uri;", "isMissingRuntimeVersion", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isMissingRuntimeVersion(Context context, Map<String, ? extends Object> overrideMap) {
            String sDKVersion = getSDKVersion(context, overrideMap);
            String runtimeVersion = getRuntimeVersion(context, overrideMap);
            String str = sDKVersion;
            if (!(str == null || str.length() == 0)) {
                return false;
            }
            String str2 = runtimeVersion;
            return str2 == null || str2.length() == 0;
        }

        public final UpdatesConfigurationValidationResult getUpdatesConfigurationValidationResult(Context context, Map<String, ? extends Object> overrideMap) {
            if (!getIsEnabled(context, overrideMap)) {
                return UpdatesConfigurationValidationResult.INVALID_NOT_ENABLED;
            }
            if (getUpdatesUrl(context, overrideMap) == null) {
                return UpdatesConfigurationValidationResult.INVALID_MISSING_URL;
            }
            if (isMissingRuntimeVersion(context, overrideMap)) {
                return UpdatesConfigurationValidationResult.INVALID_MISSING_RUNTIME_VERSION;
            }
            return UpdatesConfigurationValidationResult.VALID;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Uri getUpdatesUrl(Context context, Map<String, ? extends Object> overrideMap) {
            String str;
            Object obj;
            if (overrideMap != null) {
                if (overrideMap.containsKey(UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY)) {
                    obj = overrideMap.get(UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY);
                    if (!(obj instanceof Uri)) {
                        Intrinsics.checkNotNull(obj);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key updateUrl");
                    }
                } else {
                    obj = null;
                }
                Uri uri = (Uri) obj;
                if (uri != null) {
                    return uri;
                }
            }
            if (context == null) {
                return null;
            }
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle.containsKey("expo.modules.updates.EXPO_UPDATE_URL")) {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    str = bundle.getString("expo.modules.updates.EXPO_UPDATE_URL");
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    str = (String) Boolean.valueOf(bundle.getBoolean("expo.modules.updates.EXPO_UPDATE_URL"));
                } else {
                    str = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE)) ? (String) Integer.valueOf(bundle.getInt("expo.modules.updates.EXPO_UPDATE_URL")) : (String) bundle.get("expo.modules.updates.EXPO_UPDATE_URL");
                }
            } else {
                str = null;
            }
            if (str != null) {
                return Uri.parse(str);
            }
            return null;
        }

        private final boolean getIsEnabled(Context context, Map<String, ? extends Object> overrideMap) {
            Boolean bool;
            Object obj;
            Boolean bool2 = null;
            if (overrideMap != null) {
                if (overrideMap.containsKey("enabled")) {
                    obj = overrideMap.get("enabled");
                    if (!(obj instanceof Boolean)) {
                        Intrinsics.checkNotNull(obj);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key enabled");
                    }
                } else {
                    obj = null;
                }
                Boolean bool3 = (Boolean) obj;
                if (bool3 != null) {
                    return bool3.booleanValue();
                }
            }
            if (context != null) {
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle.containsKey("expo.modules.updates.ENABLED")) {
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        bool = (Boolean) bundle.getString("expo.modules.updates.ENABLED");
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        bool = Boolean.valueOf(bundle.getBoolean("expo.modules.updates.ENABLED"));
                    } else {
                        bool = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE)) ? (Boolean) Integer.valueOf(bundle.getInt("expo.modules.updates.ENABLED")) : (Boolean) bundle.get("expo.modules.updates.ENABLED");
                    }
                    bool2 = bool;
                }
            }
            if (bool2 != null) {
                return bool2.booleanValue();
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getSDKVersion(Context context, Map<String, ? extends Object> overrideMap) {
            String str;
            Object obj;
            if (overrideMap != null) {
                if (overrideMap.containsKey("sdkVersion")) {
                    obj = overrideMap.get("sdkVersion");
                    if (!(obj instanceof String)) {
                        Intrinsics.checkNotNull(obj);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj.getClass().getSimpleName() + " provided for key sdkVersion");
                    }
                } else {
                    obj = null;
                }
                String str2 = (String) obj;
                if (str2 != null) {
                    return str2;
                }
            }
            if (context == null) {
                return null;
            }
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (!bundle.containsKey("expo.modules.updates.EXPO_SDK_VERSION")) {
                return null;
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                str = bundle.getString("expo.modules.updates.EXPO_SDK_VERSION");
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                str = (String) Boolean.valueOf(bundle.getBoolean("expo.modules.updates.EXPO_SDK_VERSION"));
            } else {
                str = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE)) ? (String) Integer.valueOf(bundle.getInt("expo.modules.updates.EXPO_SDK_VERSION")) : (String) bundle.get("expo.modules.updates.EXPO_SDK_VERSION");
            }
            return str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getRuntimeVersion(Context context, Map<String, ? extends Object> overrideMap) {
            Integer valueOf;
            String obj;
            Object obj2;
            if (overrideMap != null) {
                if (overrideMap.containsKey(UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY)) {
                    obj2 = overrideMap.get(UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY);
                    if (!(obj2 instanceof String)) {
                        Intrinsics.checkNotNull(obj2);
                        throw new AssertionError("UpdatesConfiguration failed to initialize: bad value of type " + obj2.getClass().getSimpleName() + " provided for key runtimeVersion");
                    }
                } else {
                    obj2 = null;
                }
                String str = (String) obj2;
                if (str != null) {
                    return str;
                }
            }
            if (context == null) {
                return null;
            }
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle.containsKey("expo.modules.updates.EXPO_RUNTIME_VERSION")) {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                    valueOf = bundle.getString("expo.modules.updates.EXPO_RUNTIME_VERSION");
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    valueOf = Boolean.valueOf(bundle.getBoolean("expo.modules.updates.EXPO_RUNTIME_VERSION"));
                } else {
                    valueOf = Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE)) ? Integer.valueOf(bundle.getInt("expo.modules.updates.EXPO_RUNTIME_VERSION")) : bundle.get("expo.modules.updates.EXPO_RUNTIME_VERSION");
                }
            } else {
                valueOf = null;
            }
            if (valueOf == null || (obj = valueOf.toString()) == null) {
                return null;
            }
            return new Regex("^string:").replaceFirst(obj, "");
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(47:0|1|(4:3|(1:5)(2:328|(2:330|331))|6|(43:8|9|(3:11|(1:13)(2:310|(2:312|313))|14)|(2:315|(40:317|(1:319)(2:320|(1:322)(2:323|(1:325)(1:326)))|16|(3:18|(1:20)(2:290|(2:292|293))|21)|(2:295|(36:297|(1:299)(2:302|(1:304)(2:305|(1:307)(1:308)))|(1:301)|(3:24|(1:26)(2:270|(2:272|273))|27)|(2:275|(32:277|(1:279)(2:282|(1:284)(2:285|(1:287)(1:288)))|(29:281|(4:31|(1:33)(2:245|(2:247|248))|34|(2:36|37))|(2:250|(1:252)(2:259|(1:261)(2:262|(1:264)(2:265|(1:267)(1:268)))))|269|254|255|256|(3:40|(1:42)(2:222|(2:224|225))|43)|(2:227|(21:229|(1:231)(2:234|(1:236)(2:237|(1:239)(1:240)))|(18:233|46|(4:48|(1:50)(2:200|(2:202|203))|51|(13:53|(4:55|(1:57)(2:182|(2:184|185))|58|(11:60|61|(4:63|(1:65)(2:160|(2:162|163))|66|(6:68|69|(4:71|(1:73)(2:139|(2:141|142))|74|(10:76|77|(4:79|(1:81)(2:118|(2:120|121))|82|(5:84|(4:86|(1:88)(2:96|(2:98|99))|89|(4:91|92|93|94))|(2:101|(4:103|(1:105)(2:110|(1:112)(2:113|(1:115)(1:116)))|106|(4:108|92|93|94)(3:109|93|94)))|117|(0)(0)))|(2:123|(7:125|(1:127)(2:131|(1:133)(2:134|(1:136)(1:137)))|(1:129)(1:130)|(0)|(0)|117|(0)(0)))|138|(0)(0)|(0)|(0)|117|(0)(0)))|(2:144|(3:146|(1:148)(2:152|(1:154)(2:155|(1:157)(1:158)))|(10:150|77|(0)|(0)|138|(0)(0)|(0)|(0)|117|(0)(0))(9:151|(0)|(0)|138|(0)(0)|(0)|(0)|117|(0)(0))))|159|(0)(0)))|(2:165|(1:167)(2:171|(1:173)(2:174|(1:176)(2:177|(1:179)(1:180)))))(1:181)|170|169|69|(0)|(0)|159|(0)(0)))|(2:187|(12:189|(1:191)(2:192|(1:194)(2:195|(1:197)(1:198)))|61|(0)|(0)(0)|170|169|69|(0)|(0)|159|(0)(0)))|199|(0)|(0)(0)|170|169|69|(0)|(0)|159|(0)(0)))|(2:205|(1:207)(2:211|(1:213)(2:214|(1:216)(2:217|(1:219)(1:220)))))(1:221)|210|209|(0)|(0)|199|(0)|(0)(0)|170|169|69|(0)|(0)|159|(0)(0))|45|46|(0)|(0)(0)|210|209|(0)|(0)|199|(0)|(0)(0)|170|169|69|(0)|(0)|159|(0)(0)))|241|(0)|45|46|(0)|(0)(0)|210|209|(0)|(0)|199|(0)|(0)(0)|170|169|69|(0)|(0)|159|(0)(0))|29|(0)|(0)|269|254|255|256|(0)|(0)|241|(0)|45|46|(0)|(0)(0)|210|209|(0)|(0)|199|(0)|(0)(0)|170|169|69|(0)|(0)|159|(0)(0)))|289|(0)|29|(0)|(0)|269|254|255|256|(0)|(0)|241|(0)|45|46|(0)|(0)(0)|210|209|(0)|(0)|199|(0)|(0)(0)|170|169|69|(0)|(0)|159|(0)(0)))|309|(0)|(0)|(0)|289|(0)|29|(0)|(0)|269|254|255|256|(0)|(0)|241|(0)|45|46|(0)|(0)(0)|210|209|(0)|(0)|199|(0)|(0)(0)|170|169|69|(0)|(0)|159|(0)(0)))|327|16|(0)|(0)|309|(0)|(0)|(0)|289|(0)|29|(0)|(0)|269|254|255|256|(0)|(0)|241|(0)|45|46|(0)|(0)(0)|210|209|(0)|(0)|199|(0)|(0)(0)|170|169|69|(0)|(0)|159|(0)(0)))|332|9|(0)|(0)|327|16|(0)|(0)|309|(0)|(0)|(0)|289|(0)|29|(0)|(0)|269|254|255|256|(0)|(0)|241|(0)|45|46|(0)|(0)(0)|210|209|(0)|(0)|199|(0)|(0)(0)|170|169|69|(0)|(0)|159|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0060, code lost:
    
        if (r7 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0609, code lost:
    
        if (r2 == null) goto L253;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x049f, code lost:
    
        if (r2 == null) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x011f, code lost:
    
        if (r11 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x031f, code lost:
    
        if (r2 == null) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0328, code lost:
    
        android.util.Log.e(expo.modules.updates.UpdatesConfiguration.TAG, "Invalid value " + r2 + " for expo.modules.updates.EXPO_UPDATES_CHECK_ON_LAUNCH in AndroidManifest; defaulting to ALWAYS");
        r2 = expo.modules.updates.UpdatesConfiguration.CheckAutomaticallyConfiguration.ALWAYS;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x01c6, code lost:
    
        if (r12 != null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0278, code lost:
    
        if (r13 == null) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x035b, code lost:
    
        if (r2 != null) goto L162;
     */
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:101:0x07d1  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x083a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0841  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0718  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0784  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x078b  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x065d  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x06c9  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x06cf  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x060c  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x055f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0619  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x06d2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x078f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public UpdatesConfiguration(android.content.Context r23, java.util.Map<java.lang.String, ? extends java.lang.Object> r24) {
        /*
            Method dump skipped, instructions count: 2138
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.updates.UpdatesConfiguration.<init>(android.content.Context, java.util.Map):void");
    }
}
