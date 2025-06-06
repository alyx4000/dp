package expo.modules.updates.logging;

import com.socure.docv.capturesdk.common.utils.ApiConstant;
import kotlin.Metadata;

/* compiled from: UpdatesErrorCode.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lexpo/modules/updates/logging/UpdatesErrorCode;", "", ApiConstant.KEY_CODE, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "None", "NoUpdatesAvailable", "UpdateAssetsNotAvailable", "UpdateServerUnreachable", "UpdateHasInvalidSignature", "UpdateCodeSigningError", "UpdateFailedToLoad", "AssetsFailedToLoad", "JSRuntimeError", "InitializationError", "Unknown", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public enum UpdatesErrorCode {
    None("None"),
    NoUpdatesAvailable("NoUpdatesAvailable"),
    UpdateAssetsNotAvailable("UpdateAssetsNotAvailable"),
    UpdateServerUnreachable("UpdateServerUnreachable"),
    UpdateHasInvalidSignature("UpdateHasInvalidSignature"),
    UpdateCodeSigningError("UpdateCodeSigningError"),
    UpdateFailedToLoad("UpdateFailedToLoad"),
    AssetsFailedToLoad("AssetsFailedToLoad"),
    JSRuntimeError("JSRuntimeError"),
    InitializationError("InitializationError"),
    Unknown("Unknown");

    private final String code;

    UpdatesErrorCode(String str) {
        this.code = str;
    }

    public final String getCode() {
        return this.code;
    }
}
