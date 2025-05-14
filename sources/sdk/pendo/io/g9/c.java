package sdk.pendo.io.g9;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.util.Patterns;
import android.widget.Toast;
import sdk.pendo.io.R;
import sdk.pendo.io.actions.GuidePreparationManager;
import sdk.pendo.io.actions.GuidesManager;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1124a = "c";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Activity a(Activity activity, Boolean bool) {
        return activity;
    }

    public static Activity a(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean b(final Intent intent, final Activity activity) {
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return false;
        }
        String dataString = intent.getDataString();
        if (intent.resolveActivity(activity.getPackageManager()) != null || Patterns.WEB_URL.matcher(dataString).matches()) {
            activity.runOnUiThread(new Runnable() { // from class: sdk.pendo.io.g9.c$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    c.a(activity, intent);
                }
            });
            return true;
        }
        PendoLogger.w("An incorrect link was used.", new Object[0]);
        if (sdk.pendo.io.y8.a.d().o() || sdk.pendo.io.y8.a.d().t() || sdk.pendo.io.y8.a.d().i()) {
            Toast.makeText(activity, R.string.pnd_wrong_link_used, 1).show();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Activity activity, Intent intent) {
        try {
            activity.startActivity(intent);
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), f1124a + " -> Failed to start the activity");
        }
    }

    public static boolean a(final Intent intent, String str, Integer num, Boolean bool) {
        sdk.pendo.io.x5.g<Activity> f = (sdk.pendo.io.n8.c.g().f() != null ? sdk.pendo.io.x5.j.a(sdk.pendo.io.n8.c.g().f()) : sdk.pendo.io.n8.c.g().a(sdk.pendo.io.f7.a.PAUSE)).f();
        GuideModel e = bool.booleanValue() ? sdk.pendo.io.y8.a.d().e() : GuidesManager.INSTANCE.getGuide(str);
        if (e == null) {
            return false;
        }
        String guideStepId = e.getGuideStepId(num.intValue());
        if (!guideStepId.equals("") && GuidePreparationManager.getInstance().getHasImages(guideStepId)) {
            f = sdk.pendo.io.x5.g.a(f, GuidePreparationManager.getInstance().getImagesLoadedAsObservable(guideStepId).a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.g9.c$$ExternalSyntheticLambda0
                @Override // sdk.pendo.io.d6.j
                public final boolean test(Object obj) {
                    boolean booleanValue;
                    booleanValue = ((Boolean) obj).booleanValue();
                    return booleanValue;
                }
            }).f(), new sdk.pendo.io.d6.b() { // from class: sdk.pendo.io.g9.c$$ExternalSyntheticLambda1
                @Override // sdk.pendo.io.d6.b
                public final Object apply(Object obj, Object obj2) {
                    Activity a2;
                    a2 = c.a((Activity) obj, (Boolean) obj2);
                    return a2;
                }
            });
        }
        f.a(sdk.pendo.io.a6.a.a()).a(sdk.pendo.io.d9.b.a(new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.g9.c$$ExternalSyntheticLambda2
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                ((Activity) obj).startActivity(intent);
            }
        }, "ActivityUtils visible activity and images loaded observer"));
        return true;
    }
}
