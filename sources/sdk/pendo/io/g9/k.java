package sdk.pendo.io.g9;

import android.app.Activity;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.activities.PendoGuideVisualActivity;
import sdk.pendo.io.g9.k;
import sdk.pendo.io.logging.PendoLogger;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\"\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/g9/k;", "", "", "a", "Landroid/app/Activity;", "currentActivity", "Lcom/google/android/play/core/review/ReviewManager;", "manager", "Lcom/google/android/play/core/review/ReviewInfo;", "reviewInfo", "Landroid/content/Context;", "context", "", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f1134a = new k();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/g9/k$a;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/android/gms/tasks/OnCompleteListener;", "Lcom/google/android/gms/tasks/Task;", "task", "", "onComplete", "Lcom/google/android/play/core/review/ReviewManager;", "a", "Lcom/google/android/play/core/review/ReviewManager;", "getManager", "()Lcom/google/android/play/core/review/ReviewManager;", "manager", "<init>", "(Lcom/google/android/play/core/review/ReviewManager;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class a<T> implements OnCompleteListener<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final ReviewManager manager;

        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/f7/a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lsdk/pendo/io/f7/a;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
        /* renamed from: sdk.pendo.io.g9.k$a$a, reason: collision with other inner class name */
        static final class C0147a extends Lambda implements Function1<sdk.pendo.io.f7.a, Boolean> {
            final /* synthetic */ Activity f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0147a(Activity activity) {
                super(1);
                this.f = activity;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(sdk.pendo.io.f7.a aVar) {
                return Boolean.valueOf(!Intrinsics.areEqual(this.f, sdk.pendo.io.n8.c.g().f()));
            }
        }

        public a(ReviewManager manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            this.manager = manager;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean a(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return ((Boolean) tmp0.invoke(obj)).booleanValue();
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(Task<T> task) {
            Intrinsics.checkNotNullParameter(task, "task");
            if (!task.isSuccessful()) {
                PendoLogger.w("GoogleApiUtils Could not display in-app rating dialog. Make sure the user has Google Play Store app installed, and a logged in Google account", new Object[0]);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("GoogleApiUtils In App Rating error in task: %s", Arrays.copyOf(new Object[]{task.getException()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                PendoLogger.w(format, new Object[0]);
                return;
            }
            T result = task.getResult();
            Intrinsics.checkNotNull(result, "null cannot be cast to non-null type com.google.android.play.core.review.ReviewInfo");
            final ReviewInfo reviewInfo = (ReviewInfo) result;
            Activity f = sdk.pendo.io.n8.c.g().f();
            PendoLogger.d("GoogleApiUtils in app rating: current activity is: " + (f != null ? f.getClass().getSimpleName() : null), new Object[0]);
            if (f == null || !(f instanceof PendoGuideVisualActivity)) {
                k.f1134a.a(f, this.manager, reviewInfo);
                return;
            }
            sdk.pendo.io.x5.j<sdk.pendo.io.f7.a> c = sdk.pendo.io.n8.c.g().c();
            final C0147a c0147a = new C0147a(f);
            c.a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.g9.k$a$$ExternalSyntheticLambda0
                @Override // sdk.pendo.io.d6.j
                public final boolean test(Object obj) {
                    boolean a2;
                    a2 = k.a.a(Function1.this, obj);
                    return a2;
                }
            }).f().a(sdk.pendo.io.d9.b.a(new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.g9.k$a$$ExternalSyntheticLambda1
                @Override // sdk.pendo.io.d6.e
                public final void accept(Object obj) {
                    k.a.a(k.a.this, reviewInfo, (sdk.pendo.io.f7.a) obj);
                }
            }, "GoogleApiUtils observing the next onResume"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(a this$0, ReviewInfo reviewInfo, sdk.pendo.io.f7.a aVar) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(reviewInfo, "$reviewInfo");
            k.f1134a.a(sdk.pendo.io.n8.c.g().f(), this$0.manager, reviewInfo);
        }
    }

    private k() {
    }

    public final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable == 0) {
            return true;
        }
        PendoLogger.w("GoogleApiUtils isGooglePlayServicesAvailable - ".concat(isGooglePlayServicesAvailable != 1 ? isGooglePlayServicesAvailable != 2 ? isGooglePlayServicesAvailable != 3 ? isGooglePlayServicesAvailable != 18 ? "service invalid" : "service updating" : "service disabled" : "service version update required" : "service missing"), new Object[0]);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void a(Activity currentActivity, ReviewManager manager, ReviewInfo reviewInfo) {
        if (currentActivity == null) {
            PendoLogger.w("GoogleApiUtils In app rating - current activity is null. Will not display dialog", new Object[0]);
            return;
        }
        Task<Void> launchReviewFlow = manager.launchReviewFlow(currentActivity, reviewInfo);
        Intrinsics.checkNotNullExpressionValue(launchReviewFlow, "launchReviewFlow(...)");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("GoogleApiUtils In app rating  - about to open the dialog. Passing in %s", Arrays.copyOf(new Object[]{currentActivity.getComponentName()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        PendoLogger.d(format, new Object[0]);
        launchReviewFlow.addOnCompleteListener(new OnCompleteListener() { // from class: sdk.pendo.io.g9.k$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                k.a(task);
            }
        });
        launchReviewFlow.addOnFailureListener(new OnFailureListener() { // from class: sdk.pendo.io.g9.k$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                k.a(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Task it) {
        Intrinsics.checkNotNullParameter(it, "it");
        PendoLogger.d("GoogleApiUtils Finished the in app rating task", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Exception ex) {
        Intrinsics.checkNotNullParameter(ex, "ex");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("Make sure the user has Google Play Store app installed, and a logged in Google account. Reason: %s", Arrays.copyOf(new Object[]{ex.getMessage()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        PendoLogger.i("GoogleApiUtils Could not display in-app rating dialog. " + format, new Object[0]);
    }

    @JvmStatic
    public static final void a() {
        k kVar = f1134a;
        Context m = PendoInternal.m();
        Intrinsics.checkNotNullExpressionValue(m, "getApplicationContext(...)");
        if (kVar.a(m)) {
            try {
                ReviewManager create = ReviewManagerFactory.create(PendoInternal.m());
                Intrinsics.checkNotNullExpressionValue(create, "create(...)");
                Task<ReviewInfo> requestReviewFlow = create.requestReviewFlow();
                Intrinsics.checkNotNullExpressionValue(requestReviewFlow, "requestReviewFlow(...)");
                requestReviewFlow.addOnCompleteListener(new a(create));
            } catch (Exception e) {
                PendoLogger.i("GoogleApiUtils Could not display in-app rating dialog. Make sure the user has Google Play Store app installed, and a logged in Google account", new Object[0]);
                PendoLogger.e(e, "GoogleApiUtils In app rating error: " + e.getMessage(), new Object[0]);
            }
        }
    }
}
