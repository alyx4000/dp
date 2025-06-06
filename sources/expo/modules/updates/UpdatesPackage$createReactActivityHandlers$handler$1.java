package expo.modules.updates;

import android.content.Context;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactNativeHost;
import expo.modules.core.interfaces.ReactActivityHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: UpdatesPackage.kt */
@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0083@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0083@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"expo/modules/updates/UpdatesPackage$createReactActivityHandlers$handler$1", "Lexpo/modules/core/interfaces/ReactActivityHandler;", "getDelayLoadAppHandler", "Lexpo/modules/core/interfaces/ReactActivityHandler$DelayLoadAppHandler;", "activity", "Lcom/facebook/react/ReactActivity;", "reactNativeHost", "Lcom/facebook/react/ReactNativeHost;", "invokeReadyRunnable", "", "whenReadyRunnable", "Ljava/lang/Runnable;", "(Ljava/lang/Runnable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startUpdatesController", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UpdatesPackage$createReactActivityHandlers$handler$1 implements ReactActivityHandler {
    final /* synthetic */ UpdatesPackage this$0;

    UpdatesPackage$createReactActivityHandlers$handler$1(UpdatesPackage updatesPackage) {
        this.this$0 = updatesPackage;
    }

    @Override // expo.modules.core.interfaces.ReactActivityHandler
    public ReactActivityHandler.DelayLoadAppHandler getDelayLoadAppHandler(ReactActivity activity, ReactNativeHost reactNativeHost) {
        boolean shouldAutoSetup;
        boolean z;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(reactNativeHost, "reactNativeHost");
        final Context context = activity.getApplicationContext();
        boolean useDeveloperSupport = reactNativeHost.getUseDeveloperSupport();
        UpdatesPackage updatesPackage = this.this$0;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        shouldAutoSetup = updatesPackage.shouldAutoSetup(context);
        if (!shouldAutoSetup) {
            return null;
        }
        z = this.this$0.useNativeDebug;
        if (z || !useDeveloperSupport) {
            return new ReactActivityHandler.DelayLoadAppHandler() { // from class: expo.modules.updates.UpdatesPackage$createReactActivityHandlers$handler$1$$ExternalSyntheticLambda0
                @Override // expo.modules.core.interfaces.ReactActivityHandler.DelayLoadAppHandler
                public final void whenReady(Runnable runnable) {
                    UpdatesPackage$createReactActivityHandlers$handler$1.getDelayLoadAppHandler$lambda$0(UpdatesPackage$createReactActivityHandlers$handler$1.this, context, runnable);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDelayLoadAppHandler$lambda$0(UpdatesPackage$createReactActivityHandlers$handler$1 this$0, Context context, Runnable runnable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new UpdatesPackage$createReactActivityHandlers$handler$1$getDelayLoadAppHandler$1$1(this$0, context, runnable, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object startUpdatesController(Context context, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new UpdatesPackage$createReactActivityHandlers$handler$1$startUpdatesController$2(context, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object invokeReadyRunnable(Runnable runnable, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new UpdatesPackage$createReactActivityHandlers$handler$1$invokeReadyRunnable$2(runnable, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
