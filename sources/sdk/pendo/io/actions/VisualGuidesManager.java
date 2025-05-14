package sdk.pendo.io.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sdk.pendo.io.models.StepGuideModel;
import sdk.pendo.io.w6.a;
import sdk.pendo.io.x5.j;

/* loaded from: classes6.dex */
public class VisualGuidesManager implements VisualGuidesManagerInterface {
    private static volatile VisualGuidesManager INSTANCE;
    private Map<String, VisualGuideBase> mVisualGuides = new HashMap();
    private a<Boolean> mIsFullScreenGuideShowing = a.b(Boolean.FALSE);

    private VisualGuidesManager() {
    }

    public static synchronized VisualGuidesManagerInterface getInstance() {
        VisualGuidesManager visualGuidesManager;
        synchronized (VisualGuidesManager.class) {
            if (INSTANCE == null) {
                INSTANCE = new VisualGuidesManager();
            }
            visualGuidesManager = INSTANCE;
        }
        return visualGuidesManager;
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public synchronized void addVisualGuide(VisualGuideBase visualGuideBase) {
        this.mVisualGuides.put(visualGuideBase.getGuideId(), visualGuideBase);
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public synchronized void clearAllVisualGuides() {
        this.mVisualGuides = new HashMap();
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public VisualGuide createVisualGuide(StepGuideModel stepGuideModel) {
        return new VisualGuide(stepGuideModel, this, StepSeenManager.getInstance());
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public j<Boolean> getIsFullScreenGuideShowingObservable() {
        return this.mIsFullScreenGuideShowing;
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public List<VisualGuideBase> getShowingGuides() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, VisualGuideBase>> it = this.mVisualGuides.entrySet().iterator();
        while (it.hasNext()) {
            VisualGuideBase value = it.next().getValue();
            if (value.isShowing()) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public final synchronized VisualGuideBase getVisualGuide(String str) {
        return this.mVisualGuides.get(str);
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public boolean isAnyFullScreenGuideShowing() {
        return this.mIsFullScreenGuideShowing.o().booleanValue();
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public synchronized boolean isAnyGuideShowing() {
        return !getShowingGuides().isEmpty();
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public boolean isGuideShowing(String str) {
        Iterator<VisualGuideBase> it = getShowingGuides().iterator();
        while (it.hasNext()) {
            if (it.next().getGuideId().equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // sdk.pendo.io.actions.VisualGuideLifecycleListener
    public void onCreate(VisualGuideBase visualGuideBase) {
        addVisualGuide(visualGuideBase);
    }

    @Override // sdk.pendo.io.actions.VisualGuideLifecycleListener
    public void onDestroy(String str) {
        removeVisualGuide(str);
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public synchronized void removeShowingGuide() {
        for (VisualGuideBase visualGuideBase : getShowingGuides()) {
            if (visualGuideBase instanceof ToolTipVisualGuide) {
                ((ToolTipVisualGuide) visualGuideBase).removeOnMainThread();
            }
        }
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public synchronized void removeVisualGuide(String str) {
        if (GuidesManager.INSTANCE.getGuide(str) != null && r0.getSteps().size() - 1 == StepSeenManager.getInstance().getCurrentStepIndex().intValue()) {
            this.mVisualGuides.remove(str);
        }
    }

    @Override // sdk.pendo.io.actions.VisualGuidesManagerInterface
    public void setIsFullScreenGuideShowing(boolean z) {
        this.mIsFullScreenGuideShowing.onNext(Boolean.valueOf(z));
    }
}
