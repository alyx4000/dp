package sdk.pendo.io.g9;

import android.app.Activity;
import android.view.View;
import java.lang.ref.WeakReference;
import sdk.pendo.io.actions.FloatingVisualGuide;
import sdk.pendo.io.actions.GuidesActionsManager;
import sdk.pendo.io.actions.StepSeenManager;
import sdk.pendo.io.actions.VisualGuide;
import sdk.pendo.io.activities.PendoGuideVisualActivity;
import sdk.pendo.io.logging.PendoLogger;

/* loaded from: classes6.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1137a = "l";

    public static boolean a(String str) {
        return str.endsWith(PendoGuideVisualActivity.class.getName());
    }

    public static boolean a(WeakReference<View> weakReference, FloatingVisualGuide floatingVisualGuide, sdk.pendo.io.c8.d dVar, String str) {
        String currentStepId = StepSeenManager.getInstance().getCurrentStepId();
        if (currentStepId == null) {
            PendoLogger.w(f1137a, "Not showing floating guide due to stepId being null");
            return false;
        }
        floatingVisualGuide.init(weakReference, dVar, str);
        GuidesActionsManager.setVisualGuideStepInited(currentStepId, true);
        return floatingVisualGuide.show();
    }

    public static boolean a(Activity activity, VisualGuide visualGuide, sdk.pendo.io.c8.d dVar, String str, String str2) {
        try {
            visualGuide.init(activity, dVar, str);
            GuidesActionsManager.setVisualGuideStepInited(str2, true);
            visualGuide.show();
            return true;
        } catch (sdk.pendo.io.i8.c e) {
            PendoLogger.e(e, (activity != null ? activity.getLocalClassName() + " " : "") + "guide id: '" + visualGuide.getGuideId() + "'.", new Object[0]);
            return false;
        }
    }
}
