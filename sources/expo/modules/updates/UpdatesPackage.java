package expo.modules.updates;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import com.facebook.react.ReactInstanceManager;
import expo.modules.core.interfaces.Package;
import expo.modules.core.interfaces.ReactActivityHandler;
import expo.modules.core.interfaces.ReactNativeHostHandler;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpdatesPackage.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000bH\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lexpo/modules/updates/UpdatesPackage;", "Lexpo/modules/core/interfaces/Package;", "()V", "mShouldAutoSetup", "", "Ljava/lang/Boolean;", "useNativeDebug", "createReactActivityHandlers", "", "Lexpo/modules/core/interfaces/ReactActivityHandler;", "activityContext", "Landroid/content/Context;", "createReactNativeHostHandlers", "Lexpo/modules/core/interfaces/ReactNativeHostHandler;", "context", "shouldAutoSetup", "Companion", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UpdatesPackage implements Package {
    private static final String TAG = "UpdatesPackage";
    private Boolean mShouldAutoSetup;
    private final boolean useNativeDebug;

    @Override // expo.modules.core.interfaces.Package
    public List<ReactNativeHostHandler> createReactNativeHostHandlers(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return CollectionsKt.listOf(new ReactNativeHostHandler() { // from class: expo.modules.updates.UpdatesPackage$createReactNativeHostHandlers$handler$1
            @Override // expo.modules.core.interfaces.ReactNativeHostHandler
            public String getJSBundleFile(boolean useDeveloperSupport) {
                boolean shouldAutoSetup;
                boolean z;
                shouldAutoSetup = UpdatesPackage.this.shouldAutoSetup(context);
                if (shouldAutoSetup) {
                    z = UpdatesPackage.this.useNativeDebug;
                    if (z || !useDeveloperSupport) {
                        return UpdatesController.Companion.getInstance().getLaunchAssetFile();
                    }
                }
                return null;
            }

            @Override // expo.modules.core.interfaces.ReactNativeHostHandler
            public String getBundleAssetName(boolean useDeveloperSupport) {
                boolean shouldAutoSetup;
                boolean z;
                shouldAutoSetup = UpdatesPackage.this.shouldAutoSetup(context);
                if (shouldAutoSetup) {
                    z = UpdatesPackage.this.useNativeDebug;
                    if (z || !useDeveloperSupport) {
                        return UpdatesController.Companion.getInstance().getBundleAssetName();
                    }
                }
                return null;
            }

            @Override // expo.modules.core.interfaces.ReactNativeHostHandler
            public void onWillCreateReactInstanceManager(boolean useDeveloperSupport) {
                boolean shouldAutoSetup;
                boolean z;
                shouldAutoSetup = UpdatesPackage.this.shouldAutoSetup(context);
                if (shouldAutoSetup) {
                    z = UpdatesPackage.this.useNativeDebug;
                    if (z || !useDeveloperSupport) {
                        UpdatesController.Companion.initialize(context);
                    }
                }
            }

            @Override // expo.modules.core.interfaces.ReactNativeHostHandler
            public void onDidCreateReactInstanceManager(ReactInstanceManager reactInstanceManager, boolean useDeveloperSupport) {
                boolean shouldAutoSetup;
                boolean z;
                Intrinsics.checkNotNullParameter(reactInstanceManager, "reactInstanceManager");
                shouldAutoSetup = UpdatesPackage.this.shouldAutoSetup(context);
                if (shouldAutoSetup) {
                    z = UpdatesPackage.this.useNativeDebug;
                    if (z || !useDeveloperSupport) {
                        UpdatesController.Companion.getInstance().onDidCreateReactInstanceManager(reactInstanceManager);
                    }
                }
            }
        });
    }

    @Override // expo.modules.core.interfaces.Package
    public List<ReactActivityHandler> createReactActivityHandlers(Context activityContext) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        return CollectionsKt.listOf(new UpdatesPackage$createReactActivityHandlers$handler$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldAutoSetup(Context context) {
        boolean z;
        if (this.mShouldAutoSetup == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                Intrinsics.checkNotNullExpressionValue(applicationInfo, "pm.getApplicationInfo(co…ageManager.GET_META_DATA)");
                z = Boolean.valueOf(applicationInfo.metaData.getBoolean("expo.modules.updates.AUTO_SETUP", true));
            } catch (Exception e) {
                Log.e(TAG, "Could not read expo-updates configuration data in AndroidManifest", e);
                z = true;
            }
            this.mShouldAutoSetup = z;
        }
        Boolean bool = this.mShouldAutoSetup;
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }
}
