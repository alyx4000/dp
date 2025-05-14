package sdk.pendo.io.views.inserts;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import sdk.pendo.io.actions.GuideActionConfiguration;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandDispatcher;
import sdk.pendo.io.actions.VisualGuideBase;
import sdk.pendo.io.i8.c;
import sdk.pendo.io.k0.i;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.StepGuideModel;
import sdk.pendo.io.n.a;
import sdk.pendo.io.n.d;
import sdk.pendo.io.views.GuideViewHolder;

/* loaded from: classes4.dex */
public class VisualGuideLayout extends FrameLayout {
    public static final String TAG = "VisualGuideLayout";
    private String mGuideId;

    public VisualGuideLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private static void logFailure(Exception exc, String str, String str2, VisualGuideBase.VisualGuideType visualGuideType) {
        String message = exc.getMessage();
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder("guideId: ");
        if (!TextUtils.isEmpty(str)) {
            str = "no guide id";
        }
        StringBuilder append = sb.append(str).append(" stepId: ");
        if (!TextUtils.isEmpty(str2)) {
            str2 = "no step id";
        }
        objArr[0] = append.append(str2).append(" guideType: ").append(visualGuideType.name()).toString();
        PendoLogger.e(exc, message, objArr);
    }

    public View inflateView(StepGuideModel stepGuideModel, ViewGroup viewGroup, String str, String str2, VisualGuideBase.VisualGuideType visualGuideType) {
        this.mGuideId = str;
        try {
            i screenContents = GuideActionConfiguration.getScreenContents(stepGuideModel);
            if (screenContents != null && screenContents.j()) {
                View a2 = d.a(getContext(), screenContents.e(), viewGroup, GuideViewHolder.class, str, str2);
                if (a2 == null) {
                    throw new c("Couldn't create a view out of JSON.");
                }
                a.a(a2);
                addView(a2);
                return a2;
            }
            PendoLogger.w("Cannot inflate the main screen, bad content.", new Object[0]);
            return null;
        } catch (Exception e) {
            if (e instanceof c) {
                throw e;
            }
            logFailure(e, str, str2, visualGuideType);
            return null;
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                setPaddingAccordingToWindowInsetsIfNeeded();
            }
        } catch (Exception e) {
            PendoLogger.w(TAG, "Failed to set padding to guide root view " + e);
        }
        return super.onApplyWindowInsets(windowInsets);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        setFocusableInTouchMode(false);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        try {
            super.onFinishInflate();
            setFocusableInTouchMode(true);
            requestFocus();
            setClickable(true);
            setFocusable(true);
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
    }

    @Override // android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4) {
            try {
                if (keyEvent.getAction() == 0) {
                    PendoCommand pendoCommand = PendoCommandDispatcher.PredefinedCommands.BACK_PRESSED;
                    pendoCommand.setParameters(PendoCommandAction.PendoCommandGlobalAction.PendoInfoConsts.createPendoMetadataParams(this.mGuideId));
                    PendoCommandDispatcher.getInstance().dispatchCommand(pendoCommand, true);
                    return true;
                }
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), new Object[0]);
            }
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    protected void setPaddingAccordingToWindowInsetsIfNeeded() {
        WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(this);
        if (rootWindowInsets != null) {
            int i = rootWindowInsets.getInsets(WindowInsetsCompat.Type.ime()).bottom;
            setPadding(0, 0, 0, i > 0 ? i - rootWindowInsets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom : 0);
        }
    }

    public VisualGuideLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public VisualGuideLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public VisualGuideLayout(Context context, boolean z) {
        super(context);
    }
}
