package expo.modules.storereview;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.tracing.Trace;
import com.facebook.react.bridge.BaseJavaModule;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: StoreReviewModule.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lexpo/modules/storereview/StoreReviewModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "isPlayStoreInstalled", "", "requestReview", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "expo-store-review_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class StoreReviewModule extends Module {
    private final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    private final Activity getCurrentActivity() {
        ActivityProvider activityProvider = getAppContext().getActivityProvider();
        Activity currentActivity = activityProvider != null ? activityProvider.getCurrentActivity() : null;
        if (currentActivity != null) {
            return currentActivity;
        }
        throw new MissingCurrentActivityException();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        StoreReviewModule storeReviewModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (storeReviewModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(storeReviewModule);
            moduleDefinitionBuilder.Name("ExpoStoreReview");
            AsyncFunctionComponent asyncFunctionComponent2 = new AsyncFunctionComponent("isAvailableAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.storereview.StoreReviewModule$definition$lambda$2$$inlined$AsyncFunctionWithoutArgs$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    boolean isPlayStoreInstalled;
                    Intrinsics.checkNotNullParameter(it, "it");
                    isPlayStoreInstalled = StoreReviewModule.this.isPlayStoreInstalled();
                    return Boolean.valueOf(isPlayStoreInstalled);
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("isAvailableAsync", asyncFunctionComponent2);
            AsyncFunctionComponent asyncFunctionComponent3 = asyncFunctionComponent2;
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Promise.class == Promise.class) {
                asyncFunctionComponent = new AsyncFunctionWithPromiseComponent("requestReview", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.storereview.StoreReviewModule$definition$lambda$2$$inlined$AsyncFunction$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        StoreReviewModule.this.requestReview(promise);
                    }
                });
            } else {
                asyncFunctionComponent = new AsyncFunctionComponent("requestReview", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.storereview.StoreReviewModule$definition$lambda$2$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))}, new Function1<Object[], Object>() { // from class: expo.modules.storereview.StoreReviewModule$definition$lambda$2$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object obj = it[0];
                        if (obj == null) {
                            throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                        }
                        StoreReviewModule.this.requestReview((Promise) obj);
                        return Unit.INSTANCE;
                    }
                });
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("requestReview", asyncFunctionComponent);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestReview(final Promise promise) {
        final ReviewManager create = ReviewManagerFactory.create(getContext());
        Intrinsics.checkNotNullExpressionValue(create, "create(context)");
        Task<ReviewInfo> requestReviewFlow = create.requestReviewFlow();
        Intrinsics.checkNotNullExpressionValue(requestReviewFlow, "manager.requestReviewFlow()");
        requestReviewFlow.addOnCompleteListener(new OnCompleteListener() { // from class: expo.modules.storereview.StoreReviewModule$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                StoreReviewModule.requestReview$lambda$5(Promise.this, create, this, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestReview$lambda$5(final Promise promise, ReviewManager manager, StoreReviewModule this$0, Task task) {
        Task<Void> task2;
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(manager, "$manager");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            ReviewInfo reviewInfo = (ReviewInfo) task.getResult();
            if (reviewInfo != null) {
                Task<Void> launchReviewFlow = manager.launchReviewFlow(this$0.getCurrentActivity(), reviewInfo);
                Intrinsics.checkNotNullExpressionValue(launchReviewFlow, "manager.launchReviewFlow(currentActivity, it)");
                task2 = launchReviewFlow.addOnCompleteListener(new OnCompleteListener() { // from class: expo.modules.storereview.StoreReviewModule$$ExternalSyntheticLambda1
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task3) {
                        StoreReviewModule.requestReview$lambda$5$lambda$4$lambda$3(Promise.this, task3);
                    }
                });
            } else {
                task2 = null;
            }
            if (task2 == null) {
                promise.reject(new RMTaskException());
                return;
            }
            return;
        }
        promise.reject(new RMUnsuccessfulTaskException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestReview$lambda$5$lambda$4$lambda$3(Promise promise, Task result) {
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.isSuccessful()) {
            promise.resolve(null);
        } else {
            promise.reject(new RMTaskException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPlayStoreInstalled() {
        try {
            getContext().getPackageManager().getPackageInfo("com.android.vending", 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
