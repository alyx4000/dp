package expo.modules.devlauncher.helpers;

import android.content.Context;
import android.net.Uri;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updatesinterface.UpdatesInterface;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: DevLauncherUpdatesHelper.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a<\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u001ad\u0010\t\u001a\u00020\n*\u00020\u000b2\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\r\u001a\u00020\u000e2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"createUpdatesConfigurationWithUrl", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "url", "Landroid/net/Uri;", "projectUrl", "installationID", "loadUpdate", "Lexpo/modules/updatesinterface/UpdatesInterface$Update;", "Lexpo/modules/updatesinterface/UpdatesInterface;", "configuration", "context", "Landroid/content/Context;", "shouldContinue", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "manifest", "", "(Lexpo/modules/updatesinterface/UpdatesInterface;Ljava/util/HashMap;Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-dev-launcher_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DevLauncherUpdatesHelperKt {
    public static final Object loadUpdate(UpdatesInterface updatesInterface, HashMap<String, Object> hashMap, Context context, final Function1<? super JSONObject, Boolean> function1, Continuation<? super UpdatesInterface.Update> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        updatesInterface.fetchUpdateWithConfiguration(hashMap, context, new UpdatesInterface.UpdateCallback() { // from class: expo.modules.devlauncher.helpers.DevLauncherUpdatesHelperKt$loadUpdate$2$1
            @Override // expo.modules.updatesinterface.UpdatesInterface.UpdateCallback
            public void onProgress(int successfulAssetCount, int failedAssetCount, int totalAssetCount) {
            }

            @Override // expo.modules.updatesinterface.UpdatesInterface.UpdateCallback
            public void onSuccess(UpdatesInterface.Update update) {
                if (update != null) {
                    Continuation<UpdatesInterface.Update> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1227constructorimpl(update));
                }
            }

            @Override // expo.modules.updatesinterface.UpdatesInterface.UpdateCallback
            public void onFailure(Exception e) {
                Continuation<UpdatesInterface.Update> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                if (e == null) {
                    e = new Exception("There was an unexpected error loading the update.");
                }
                continuation2.resumeWith(Result.m1227constructorimpl(ResultKt.createFailure(e)));
            }

            @Override // expo.modules.updatesinterface.UpdatesInterface.UpdateCallback
            public boolean onManifestLoaded(final JSONObject manifest) {
                Intrinsics.checkNotNullParameter(manifest, "manifest");
                if (function1.invoke(manifest).booleanValue()) {
                    return true;
                }
                Continuation<UpdatesInterface.Update> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m1227constructorimpl(new UpdatesInterface.Update() { // from class: expo.modules.devlauncher.helpers.DevLauncherUpdatesHelperKt$loadUpdate$2$1$onManifestLoaded$1
                    @Override // expo.modules.updatesinterface.UpdatesInterface.Update
                    public String getLaunchAssetPath() {
                        throw new Exception("Tried to access launch asset path for a manifest that was not loaded");
                    }

                    @Override // expo.modules.updatesinterface.UpdatesInterface.Update
                    /* renamed from: getManifest, reason: from getter */
                    public JSONObject get$manifest() {
                        return manifest;
                    }
                }));
                return false;
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final HashMap<String, Object> createUpdatesConfigurationWithUrl(Uri url, Uri projectUrl, String str) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(projectUrl, "projectUrl");
        HashMap hashMapOf = MapsKt.hashMapOf(TuplesKt.to("Expo-Updates-Environment", "DEVELOPMENT"));
        if (str != null) {
            hashMapOf.put("Expo-Dev-Client-ID", str);
        }
        return MapsKt.hashMapOf(TuplesKt.to(UpdatesConfiguration.UPDATES_CONFIGURATION_UPDATE_URL_KEY, url), TuplesKt.to(UpdatesConfiguration.UPDATES_CONFIGURATION_SCOPE_KEY_KEY, projectUrl.toString()), TuplesKt.to(UpdatesConfiguration.UPDATES_CONFIGURATION_HAS_EMBEDDED_UPDATE_KEY, false), TuplesKt.to(UpdatesConfiguration.UPDATES_CONFIGURATION_LAUNCH_WAIT_MS_KEY, 60000), TuplesKt.to(UpdatesConfiguration.UPDATES_CONFIGURATION_CHECK_ON_LAUNCH_KEY, "ALWAYS"), TuplesKt.to("enabled", true), TuplesKt.to(UpdatesConfiguration.UPDATES_CONFIGURATION_REQUEST_HEADERS_KEY, hashMapOf), TuplesKt.to(UpdatesConfiguration.UPDATES_CONFIGURATION_EXPECTS_EXPO_SIGNED_MANIFEST, false));
    }
}
