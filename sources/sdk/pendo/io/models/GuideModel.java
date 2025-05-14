package sdk.pendo.io.models;

import android.text.TextUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.sentry.protocol.SentryThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import sdk.pendo.io.actions.GuideActionConfiguration;
import sdk.pendo.io.actions.VisualGuidesManager;
import sdk.pendo.io.c8.h;
import sdk.pendo.io.k0.f;
import sdk.pendo.io.k0.i;
import sdk.pendo.io.k0.l;
import sdk.pendo.io.l0.c;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.w6.a;
import sdk.pendo.io.x5.j;

/* loaded from: classes6.dex */
public class GuideModel implements Comparable<GuideModel> {
    private static final int COMPARED_TO_ACTION = -1;
    private static final String COULD_NOT_DELIVER_STEP_MESSAGE = "getGuideStepIndex, could not deliver stepId: %s, of the guideId: %s";
    public static final String DEFAULT_GUIDE_STEP_ID = "";
    public static final int FIRST_GUIDES_CHILD_INDEX = 0;
    public static final String FULLSCREEN_WIDGET_NAME = "Fullscreen";
    public static final String INVALID_GUIDE_ID = "";
    public static final String NO_ID = "";
    public static final String PREVIEW_GUIDE_ID = "PREVIEW_GUIDE_ID";
    public static final String PREVIEW_GUIDE_NAME = "DEFAULT_NAME";
    public static final String PREVIEW_GUIDE_STEP_ID = "PREVIEW_GUIDE_STEP_ID";
    private static final int THIS_ACTION = 1;
    public static final String TOOLTIP_WIDGET_NAME = "Tooltip";

    @c("activations")
    private f mActivations;

    @c(RemoteConfigConstants.RequestFieldKey.APP_ID)
    private String mAppId;

    @c("carousels")
    private f mCarousels;

    @c("contentUrl")
    private String mContentUrl;

    @c("control")
    private Boolean mControl;

    @c("configuration")
    private GeneralGuidesConfiguration mGeneralGuideConfiguration;

    @c("guideId")
    private String mGuideId;

    @c("language")
    private String mGuideLanguage;

    @c("guideName")
    private String mGuideName;
    public final transient a<GuideStatus> mGuideStatus;

    @c(SentryThread.JsonKeys.PRIORITY)
    private int mPriority;

    @c("recurrence")
    private long mRecurrence;

    @c("steps")
    private List<StepModel> mSteps;
    private h mTracker;

    public enum VisualGuideType {
        TOOLTIP(GuideModel.TOOLTIP_WIDGET_NAME),
        FULLSCREEN(GuideModel.FULLSCREEN_WIDGET_NAME);

        public final String widgetName;

        VisualGuideType(String str) {
            this.widgetName = str;
        }
    }

    public GuideModel() {
        this.mGeneralGuideConfiguration = new GeneralGuidesConfiguration();
        this.mControl = Boolean.FALSE;
        this.mContentUrl = null;
        this.mGuideLanguage = "";
        this.mGuideStatus = a.b(new ContentNotReady());
    }

    public static GuideModel guideFactory(StepGuideModel stepGuideModel) {
        return VisualGuidesManager.getInstance().createVisualGuide(stepGuideModel);
    }

    private boolean isValidStepIndex(int i, List<StepModel> list) {
        return i >= 0 && i < list.size();
    }

    public void capOut() {
        this.mGeneralGuideConfiguration.getCapping().setMaxSessionImpressions(0);
    }

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof GuideModel) && getGuideId().equals(((GuideModel) obj).getGuideId()));
    }

    public f getActivations() {
        return this.mActivations;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public l getCarouselIndicatorsLayoutView(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<i> it = this.mCarousels.iterator();
        while (it.hasNext()) {
            l e = it.next().e();
            if (str.equals(e.a("carouselId").g())) {
                l e2 = e.b(GuideActionConfiguration.GUIDE_BUILDING_BLOCK_VIEWS).a(0).e();
                l lVar = e2;
                while (e2 != null && !e2.a("widget").g().equals("CarouselIndicatorWrapper")) {
                    lVar = e2;
                    e2 = e2.b(GuideActionConfiguration.GUIDE_BUILDING_BLOCK_VIEWS).a(0).e();
                }
                return lVar;
            }
        }
        return null;
    }

    public f getCarousels() {
        return this.mCarousels;
    }

    public String getContentUrl() {
        return this.mContentUrl;
    }

    public GeneralGuidesConfiguration getGeneralGuideConfiguration() {
        return this.mGeneralGuideConfiguration;
    }

    public String getGuideId() {
        String str = this.mGuideId;
        return str != null ? str : "";
    }

    public String getGuideLanguage() {
        return this.mGuideLanguage;
    }

    public String getGuideName() {
        return this.mGuideName;
    }

    public String getGuideStepCarouselId(String str) {
        StepModel guideStepModel;
        if (TextUtils.isEmpty(str) || (guideStepModel = getGuideStepModel(str)) == null || guideStepModel.getStepContentModel() == null) {
            return null;
        }
        return guideStepModel.getStepContentModel().getCarouselId();
    }

    public String getGuideStepId(int i) {
        StepContentModel stepContentModel = getStepContentModel(i);
        return stepContentModel != null ? stepContentModel.getGuideStepId() : "";
    }

    public Integer getGuideStepIndex(String str) {
        String guideStepId;
        try {
            List<StepModel> steps = getSteps();
            if (steps == null) {
                return null;
            }
            for (int i = 0; i < steps.size(); i++) {
                StepModel stepModel = steps.get(i);
                StepContentModel stepContentModel = stepModel != null ? stepModel.getStepContentModel() : null;
                if (stepContentModel != null && (guideStepId = stepContentModel.getGuideStepId()) != null && guideStepId.equals(str)) {
                    return Integer.valueOf(i);
                }
            }
            PendoLogger.e(String.format(COULD_NOT_DELIVER_STEP_MESSAGE, str, getGuideId()), new Object[0]);
            return null;
        } catch (Exception e) {
            PendoLogger.e(e, String.format(COULD_NOT_DELIVER_STEP_MESSAGE, str, getGuideId()), e.getMessage());
            return null;
        }
    }

    public StepGuideModel getGuideStepModel(int i) {
        List<StepModel> steps = getSteps();
        if (steps == null || !isValidStepIndex(i, steps)) {
            return null;
        }
        return steps.get(i).getStepContent();
    }

    public List<String> getImages() {
        if (this.mControl.booleanValue()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<StepModel> it = this.mSteps.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getImages());
        }
        return arrayList;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public long getRecurrence() {
        return this.mRecurrence;
    }

    public j<GuideStatus> getStatus() {
        return this.mGuideStatus;
    }

    public GuideStatus getStatusValue() {
        return this.mGuideStatus.p() ? new Completed() : this.mGuideStatus.o();
    }

    public StepContentModel getStepContentModel(int i) {
        List<StepModel> steps = getSteps();
        if (steps == null) {
            PendoLogger.d("Guide steps were null in guide " + getGuideId(), new Object[0]);
            return null;
        }
        if (i >= 0 && i < steps.size()) {
            return steps.get(i).getStepContentModel();
        }
        PendoLogger.d("step index in guide: " + getGuideId() + " was: " + i + " there were " + steps.size() + "steps", new Object[0]);
        return null;
    }

    public List<StepModel> getSteps() {
        return this.mSteps;
    }

    public final h getTracker() {
        return this.mTracker;
    }

    public final int hashCode() {
        return getGuideId().hashCode();
    }

    public boolean isCompleted() {
        return this.mGuideStatus.p() || this.mGuideStatus.o().getStatus() == GuideStatus.getGUIDE_SHOWN();
    }

    public boolean isInControlGroup() {
        return this.mControl.booleanValue();
    }

    public boolean isReady() {
        return this.mGuideStatus.o().getStatus() == GuideStatus.getREADY();
    }

    public void setActivations(f fVar) {
        this.mActivations = fVar;
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public void setCancelled() {
        PendoLogger.i("Guide " + this.mGuideId + " setCancelled", new Object[0]);
        this.mGuideStatus.onNext(new Cancelled());
    }

    public void setCarousels(f fVar) {
        this.mCarousels = fVar;
    }

    public void setContentError() {
        PendoLogger.d("Guide " + this.mGuideId + " setContentError", new Object[0]);
        this.mGuideStatus.onNext(new ContentError());
    }

    public void setContentNotReady() {
        PendoLogger.d("Guide " + this.mGuideId + " setContentNotReady", new Object[0]);
        this.mGuideStatus.onNext(new ContentNotReady());
    }

    public void setContentReady() {
        PendoLogger.d("Guide " + this.mGuideId + " setContentReady", new Object[0]);
        this.mGuideStatus.onNext(new ContentReady());
    }

    public void setGeneralGuideConfiguration(GeneralGuidesConfiguration generalGuidesConfiguration) {
        this.mGeneralGuideConfiguration = generalGuidesConfiguration;
    }

    public void setGuideId(String str) {
        this.mGuideId = str;
    }

    public void setGuideLanguage(String str) {
        this.mGuideLanguage = str;
    }

    public void setGuideName(String str) {
        this.mGuideName = str;
    }

    public void setGuideShown() {
        PendoLogger.i("Guide " + this.mGuideId + " setGuideShown", new Object[0]);
        this.mGuideStatus.onNext(new GuideShown());
    }

    public void setImageError() {
        PendoLogger.i("Guide " + this.mGuideId + " setImageError", new Object[0]);
        this.mGuideStatus.onNext(new ImageError());
    }

    public void setImageReady() {
        PendoLogger.i("Guide " + this.mGuideId + " setImageReady", new Object[0]);
        setReady();
    }

    public void setIsInControlGroup(boolean z) {
        this.mControl = Boolean.valueOf(z);
    }

    public void setNeedsImages() {
        this.mGuideStatus.onNext(new ImageNotReady());
    }

    public void setPriority(int i) {
        this.mPriority = i;
    }

    public void setReady() {
        PendoLogger.d("Guide " + this.mGuideId + " setReady", new Object[0]);
        this.mGuideStatus.onNext(new Ready());
    }

    public void setRecurrence(long j) {
        this.mRecurrence = j;
    }

    public void setSteps(List<StepModel> list) {
        this.mSteps = list;
    }

    public final void setTracker(h hVar) {
        this.mTracker = hVar;
    }

    public void terminateStatus() {
        PendoLogger.d("Guide " + this.mGuideId + " terminateStatus", new Object[0]);
        this.mGuideStatus.onComplete();
    }

    public final String toString() {
        return "Guide Model: {[guideId = " + getGuideId() + "], [appId = " + (getAppId() != null ? getAppId() : "") + "], [priority = " + getPriority() + "], [activation = " + (getActivations() != null ? getActivations().toString() : "") + "], [steps = " + (getSteps() != null ? getSteps().toString() : "") + "], [language = " + getGuideLanguage() + "}";
    }

    protected GuideModel(GuideModel guideModel) {
        this.mGeneralGuideConfiguration = new GeneralGuidesConfiguration();
        this.mControl = Boolean.FALSE;
        this.mContentUrl = null;
        this.mGuideLanguage = "";
        a<GuideStatus> b = a.b(new ContentNotReady());
        this.mGuideStatus = b;
        if (guideModel != null) {
            setActivations(guideModel.getActivations());
            setAppId(guideModel.getAppId());
            setGuideId(guideModel.getGuideId());
            setPriority(guideModel.getPriority());
            setSteps(guideModel.getSteps());
            setGuideName(guideModel.getGuideName());
            setGeneralGuideConfiguration(guideModel.getGeneralGuideConfiguration());
            setCarousels(guideModel.getCarousels());
            setGuideLanguage(guideModel.getGuideLanguage());
            if (guideModel.mGuideStatus.p()) {
                b.onComplete();
            } else {
                b.onNext((GuideStatus) Objects.requireNonNull(guideModel.mGuideStatus.o()));
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(GuideModel guideModel) {
        return getPriority() < guideModel.getPriority() ? 1 : -1;
    }

    public StepModel getGuideStepModel(String str) {
        String guideStepId;
        try {
            List<StepModel> steps = getSteps();
            if (steps == null) {
                return null;
            }
            Iterator<StepModel> it = steps.iterator();
            while (it.hasNext()) {
                StepModel next = it.next();
                StepContentModel stepContentModel = next != null ? next.getStepContentModel() : null;
                if (stepContentModel != null && (guideStepId = stepContentModel.getGuideStepId()) != null && guideStepId.equals(str)) {
                    return next;
                }
            }
            PendoLogger.e(String.format(COULD_NOT_DELIVER_STEP_MESSAGE, str, getGuideId()), new Object[0]);
            return null;
        } catch (Exception e) {
            PendoLogger.e(e, String.format(COULD_NOT_DELIVER_STEP_MESSAGE, str, getGuideId()), e.getMessage());
            return null;
        }
    }

    public GuideModel(StepGuideModel stepGuideModel) {
        this.mGeneralGuideConfiguration = new GeneralGuidesConfiguration();
        this.mControl = Boolean.FALSE;
        this.mContentUrl = null;
        this.mGuideLanguage = "";
        this.mGuideStatus = a.b(new ContentNotReady());
        if (stepGuideModel != null) {
            try {
                StepModel stepModel = new StepModel();
                StepContentModel stepContentModel = new StepContentModel();
                stepContentModel.setStepContentModel(stepGuideModel);
                stepContentModel.setGuideId(PREVIEW_GUIDE_ID);
                stepContentModel.setGuideStepId(PREVIEW_GUIDE_STEP_ID);
                stepModel.setStepContentModel(stepContentModel);
                stepModel.setStepLocationModel(new StepLocationModel());
                stepModel.setStepActivations(new ArrayList());
                ArrayList arrayList = new ArrayList();
                arrayList.add(stepModel);
                setSteps(arrayList);
                setGuideId(PREVIEW_GUIDE_ID);
                setPriority(3);
                setActivations(null);
                setGuideName(PREVIEW_GUIDE_NAME);
                setGeneralGuideConfiguration(null);
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), "stepGuideModelId " + stepGuideModel.getId());
            }
        }
    }
}
