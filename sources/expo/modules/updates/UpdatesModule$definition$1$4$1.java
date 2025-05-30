package expo.modules.updates;

import android.os.Bundle;
import android.util.Log;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.updates.IUpdatesController;
import io.sentry.clientreport.DiscardedEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpdatesModule.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"expo/modules/updates/UpdatesModule$definition$1$4$1", "Lexpo/modules/updates/IUpdatesController$ModuleCallback;", "Lexpo/modules/updates/IUpdatesController$CheckForUpdateResult;", "onFailure", "", "exception", "Lexpo/modules/kotlin/exception/CodedException;", "onSuccess", "result", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UpdatesModule$definition$1$4$1 implements IUpdatesController.ModuleCallback<IUpdatesController.CheckForUpdateResult> {
    final /* synthetic */ Promise $promise;

    UpdatesModule$definition$1$4$1(Promise promise) {
        this.$promise = promise;
    }

    @Override // expo.modules.updates.IUpdatesController.ModuleCallback
    public void onSuccess(IUpdatesController.CheckForUpdateResult result) {
        String str;
        Intrinsics.checkNotNullParameter(result, "result");
        if (result instanceof IUpdatesController.CheckForUpdateResult.ErrorResult) {
            IUpdatesController.CheckForUpdateResult.ErrorResult errorResult = (IUpdatesController.CheckForUpdateResult.ErrorResult) result;
            this.$promise.reject("ERR_UPDATES_CHECK", errorResult.getMessage(), errorResult.getError());
            str = UpdatesModule.TAG;
            Log.e(str, errorResult.getMessage(), errorResult.getError());
            return;
        }
        if (result instanceof IUpdatesController.CheckForUpdateResult.NoUpdateAvailable) {
            Promise promise = this.$promise;
            Bundle bundle = new Bundle();
            bundle.putBoolean("isRollBackToEmbedded", false);
            bundle.putBoolean("isAvailable", false);
            bundle.putString(DiscardedEvent.JsonKeys.REASON, ((IUpdatesController.CheckForUpdateResult.NoUpdateAvailable) result).getReason().getValue());
            promise.resolve(bundle);
            return;
        }
        if (result instanceof IUpdatesController.CheckForUpdateResult.RollBackToEmbedded) {
            Promise promise2 = this.$promise;
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("isRollBackToEmbedded", true);
            bundle2.putBoolean("isAvailable", false);
            promise2.resolve(bundle2);
            return;
        }
        if (result instanceof IUpdatesController.CheckForUpdateResult.UpdateAvailable) {
            Promise promise3 = this.$promise;
            Bundle bundle3 = new Bundle();
            bundle3.putBoolean("isRollBackToEmbedded", false);
            bundle3.putBoolean("isAvailable", true);
            bundle3.putString("manifestString", ((IUpdatesController.CheckForUpdateResult.UpdateAvailable) result).getUpdateManifest().getManifest().toString());
            promise3.resolve(bundle3);
        }
    }

    @Override // expo.modules.updates.IUpdatesController.ModuleCallback
    public void onFailure(CodedException exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.$promise.reject(exception);
    }
}
