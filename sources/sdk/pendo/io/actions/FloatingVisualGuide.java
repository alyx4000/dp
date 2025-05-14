package sdk.pendo.io.actions;

import android.view.View;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.uimanager.ViewProps;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import sdk.pendo.io.actions.GuideActionConfiguration;
import sdk.pendo.io.actions.VisualGuideBase;
import sdk.pendo.io.c8.d;
import sdk.pendo.io.g9.k0;
import sdk.pendo.io.k0.f;
import sdk.pendo.io.k0.i;
import sdk.pendo.io.k0.l;
import sdk.pendo.io.models.GuideModel;

/* loaded from: classes6.dex */
public abstract class FloatingVisualGuide extends VisualGuideBase {
    protected static final String BACKDROP_ENABLED_KEY = "hasMobileBackdrop";
    private static final String DEFAULT_WHITE = "#FFFFFFFF";
    protected static final String IS_MOBILE_BANNER_KEY = "isMobileBanner";
    protected d mAnalyticsData;
    protected final HashMap<String, Object> mViewPropertiesToBePopulated;

    protected FloatingVisualGuide(VisualGuideBase.VisualGuideType visualGuideType, GuideModel guideModel, VisualGuideLifecycleListener visualGuideLifecycleListener, StepSeenManagerInterface stepSeenManagerInterface) {
        super(guideModel, visualGuideLifecycleListener);
        this.mViewPropertiesToBePopulated = new HashMap<>();
        this.mVisualGuideType = visualGuideType;
        this.mStepSeenManager = stepSeenManagerInterface;
    }

    protected static void extractProperties(f fVar, HashMap<String, Object> hashMap, HashSet<String> hashSet) {
        Iterator<i> it = fVar.iterator();
        while (it.hasNext()) {
            i next = it.next();
            if (next.j()) {
                l e = next.e();
                String g = e.a("name").g();
                if (hashSet.contains(g)) {
                    String g2 = e.a("type").g();
                    i a2 = e.a("value");
                    hashMap.put(g, "json".equals(g2) ? a2.e() : a2.g());
                    if (hashMap.size() == hashSet.size()) {
                        return;
                    }
                } else {
                    continue;
                }
            }
        }
    }

    protected String getBackground() {
        String str = (String) this.mViewPropertiesToBePopulated.get(AppStateModule.APP_STATE_BACKGROUND);
        return str == null ? DEFAULT_WHITE : k0.a(str);
    }

    String getDimenViewStringPropertyClean(String str) {
        String str2 = (String) this.mViewPropertiesToBePopulated.get(str);
        if (str2 != null) {
            return k0.b(str2);
        }
        return null;
    }

    public f getFloatingViewProperties() {
        if (getSteps() == null || getSteps().isEmpty()) {
            return null;
        }
        return GuideActionConfiguration.getTooltipProperties(getSteps().get(this.mStepSeenManager.getCurrentStepIndex().intValue()));
    }

    protected int getGravity() {
        try {
            return PendoFloatingVisualGuideManager.valueOfGravity(((String) this.mViewPropertiesToBePopulated.get("gravity")).toUpperCase(Locale.US)).intValue();
        } catch (Exception unused) {
            return 2;
        }
    }

    protected int getPosition() {
        try {
            return PendoFloatingVisualGuideManager.valueOfGravity(((String) this.mViewPropertiesToBePopulated.get(ViewProps.POSITION)).toUpperCase(Locale.US)).intValue();
        } catch (Exception unused) {
            return 2;
        }
    }

    protected String getPropertyValuefromViewProperties(String str) {
        return (String) this.mViewPropertiesToBePopulated.get(str);
    }

    protected String getStrokeColor() {
        return (String) this.mViewPropertiesToBePopulated.get("frameColor");
    }

    public l getViewContentJson(GuideActionConfiguration.VisualGuideType visualGuideType) {
        Integer currentStepIndex = this.mStepSeenManager.getCurrentStepIndex();
        if (currentStepIndex != null) {
            return GuideActionConfiguration.getFloatingGuideContent(getSteps().get(currentStepIndex.intValue()), visualGuideType);
        }
        return null;
    }

    public abstract void init(WeakReference<View> weakReference, d dVar, String str);

    @Override // sdk.pendo.io.actions.VisualGuideBase
    synchronized void onDestroy() {
        super.onDestroy();
        cancelDuration();
        VisualGuideLifecycleListener visualGuideLifecycleListener = this.mListener;
        if (visualGuideLifecycleListener != null) {
            visualGuideLifecycleListener.onDestroy(getGuideId());
        }
        getAndSetShowing(false);
        setContainerView(null);
        setRootView(null);
        setTracker(null);
        GuidesActionsManager.removeVisualGuideInitedObservable(getGuideId());
        this.mAnalyticsData = null;
        this.mActivity = null;
        GuidesManager.INSTANCE.setCurrentGuideAsNull();
    }

    @Override // sdk.pendo.io.actions.VisualGuideBase
    public abstract boolean show();
}
