package sdk.pendo.io.actions;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.R;
import sdk.pendo.io.g9.o0;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.n8.c;
import sdk.pendo.io.w6.a;
import sdk.pendo.io.x5.j;

/* loaded from: classes6.dex */
public final class GuideTapOnManager {
    private static final int DEFAULT_ALPHA = 204;
    private static final int DEFAULT_TRANSPARENT_COLOR = -872415232;
    private static final String TAP_ON_SPINNER_DESCRIPTION = "TAP_ON_SPINNER";
    private static final int TAP_ON_TIMEOUT = 10000;
    private static WeakReference<LinearLayout> sTapOnLinearLayout;
    private static Handler sTimeoutExpiredHandler;
    private static Runnable sTimeoutExpiredRunnable;
    private static final a<Boolean> IS_TAP_ON_TIME_EXPIRED = a.b(Boolean.FALSE);
    private static AtomicBoolean sIsTapIndicationRunning = new AtomicBoolean(false);

    private GuideTapOnManager() {
    }

    public static j<Boolean> getTapOnTimeExpiredObservable() {
        return IS_TAP_ON_TIME_EXPIRED;
    }

    public static boolean getsIsTapIndicationRunning() {
        return sIsTapIndicationRunning.get();
    }

    public static boolean isTapOnLayoutExist() {
        WeakReference<LinearLayout> weakReference = sTapOnLinearLayout;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public static boolean isTapOnTimeoutExpired() {
        return isTapOnLayoutExist() && IS_TAP_ON_TIME_EXPIRED.o().booleanValue();
    }

    static /* synthetic */ void lambda$removeAddedTapOnLayouts$0(ViewGroup viewGroup) {
        WeakReference<LinearLayout> weakReference = sTapOnLinearLayout;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        sTapOnLinearLayout.get().setVisibility(8);
        viewGroup.removeView(sTapOnLinearLayout.get());
    }

    private static void removeAddedTapOnLayouts() {
        Activity f;
        final ViewGroup viewGroup = (ViewGroup) c.g().f().getWindow().getDecorView().getRootView();
        if (viewGroup != null && (f = c.g().f()) != null) {
            f.runOnUiThread(new Runnable() { // from class: sdk.pendo.io.actions.GuideTapOnManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    GuideTapOnManager.lambda$removeAddedTapOnLayouts$0(viewGroup);
                }
            });
        }
        WeakReference<LinearLayout> weakReference = sTapOnLinearLayout;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        sTapOnLinearLayout.clear();
    }

    public static void removeSpinnerFromLayout() {
        LinearLayout linearLayout;
        WeakReference<LinearLayout> weakReference = sTapOnLinearLayout;
        if (weakReference == null || (linearLayout = weakReference.get()) == null) {
            return;
        }
        View findViewById = linearLayout.findViewById(R.id.pnd_tapOnDialogProgressBar);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        sIsTapIndicationRunning.set(false);
    }

    public static synchronized void resetTapOn() {
        Runnable runnable;
        synchronized (GuideTapOnManager.class) {
            try {
                if (isTapOnLayoutExist()) {
                    Handler handler = sTimeoutExpiredHandler;
                    if (handler != null && (runnable = sTimeoutExpiredRunnable) != null) {
                        handler.removeCallbacks(runnable);
                    }
                    removeAddedTapOnLayouts();
                }
                removeAddedTapOnLayouts();
                sIsTapIndicationRunning.set(false);
            } catch (Exception e) {
                PendoLogger.e(e.getMessage(), new Object[0]);
            }
        }
    }

    public static void runTapOnIndication() {
        try {
            Activity f = c.g().f();
            ColorDrawable colorDrawable = new ColorDrawable(DEFAULT_TRANSPARENT_COLOR);
            colorDrawable.setAlpha(204);
            LinearLayout linearLayout = new LinearLayout(PendoInternal.m());
            sTapOnLinearLayout = new WeakReference<>(linearLayout);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            linearLayout.setId(R.id.pnd_tapOnDialogLayout);
            linearLayout.setBackground(colorDrawable);
            ProgressBar progressBar = new ProgressBar(f, null, android.R.attr.progressBarStyle);
            progressBar.setId(R.id.pnd_tapOnDialogProgressBar);
            progressBar.setContentDescription(TAP_ON_SPINNER_DESCRIPTION);
            progressBar.setIndeterminate(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            RelativeLayout relativeLayout = new RelativeLayout(PendoInternal.m());
            relativeLayout.setGravity(17);
            relativeLayout.addView(progressBar);
            linearLayout.addView(relativeLayout, layoutParams);
            if (f == null || f.getWindow() == null) {
                return;
            }
            q0.b a2 = o0.f1142a.a(f);
            View view = a2 != null ? a2.f1145a.get() : null;
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).addView(linearLayout);
            }
            setTimeoutForTapOn();
        } catch (Exception e) {
            PendoLogger.e(e.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setTapOnTimeExpired(boolean z) {
        IS_TAP_ON_TIME_EXPIRED.onNext(Boolean.valueOf(z));
    }

    private static void setTimeoutForTapOn() {
        setTapOnTimeExpired(false);
        sTimeoutExpiredHandler = new Handler();
        Runnable runnable = new Runnable() { // from class: sdk.pendo.io.actions.GuideTapOnManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                GuideTapOnManager.setTapOnTimeExpired(true);
            }
        };
        sTimeoutExpiredRunnable = runnable;
        sTimeoutExpiredHandler.postDelayed(runnable, DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM);
    }

    public static void setsIsTapIndicationRunning(boolean z) {
        sIsTapIndicationRunning.set(z);
    }
}
