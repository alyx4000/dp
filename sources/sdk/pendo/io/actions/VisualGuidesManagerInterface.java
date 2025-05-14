package sdk.pendo.io.actions;

import java.util.List;
import sdk.pendo.io.models.StepGuideModel;
import sdk.pendo.io.x5.j;

/* loaded from: classes6.dex */
public interface VisualGuidesManagerInterface extends VisualGuideLifecycleListener {
    void addVisualGuide(VisualGuideBase visualGuideBase);

    void clearAllVisualGuides();

    VisualGuide createVisualGuide(StepGuideModel stepGuideModel);

    j<Boolean> getIsFullScreenGuideShowingObservable();

    List<VisualGuideBase> getShowingGuides();

    VisualGuideBase getVisualGuide(String str);

    boolean isAnyFullScreenGuideShowing();

    boolean isAnyGuideShowing();

    boolean isGuideShowing(String str);

    void removeShowingGuide();

    void removeVisualGuide(String str);

    void setIsFullScreenGuideShowing(boolean z);
}
