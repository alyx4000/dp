package sdk.pendo.io.actions;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.Quadruple;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&JF\u0010\f\u001a\u00020\b2,\u0010\r\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00110\u000e0\n2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H&J\b\u0010\u0014\u001a\u00020\u0003H&J$\u0010\u0015\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/actions/GuidesManagerInterface;", "", "addGuideToGuidesMap", "", "guideModel", "Lsdk/pendo/io/models/GuideModel;", "getGuide", "guideId", "", "getGuideActions", "", "Lsdk/pendo/io/actions/PendoCommand;", "show", "guideIdStepIndexActivationEventQuadruples", "Lsdk/pendo/io/models/Quadruple;", "", "Lsdk/pendo/io/actions/ActivationManager$ActivationEvents;", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "guideTriggeredByView", "showPreview", "storeAndActivateSessionGuides", "guideModelList", "guideActions", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface GuidesManagerInterface {
    void addGuideToGuidesMap(GuideModel guideModel);

    GuideModel getGuide(String guideId);

    List<PendoCommand> getGuideActions();

    String show(List<Quadruple<String, Integer, ActivationManager.ActivationEvents, WeakReference<View>>> guideIdStepIndexActivationEventQuadruples, WeakReference<View> guideTriggeredByView);

    void showPreview();

    void storeAndActivateSessionGuides(List<? extends GuideModel> guideModelList, List<PendoCommand> guideActions);
}
