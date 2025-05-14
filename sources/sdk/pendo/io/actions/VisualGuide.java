package sdk.pendo.io.actions;

import android.R;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import sdk.pendo.io.actions.VisualGuideBase;
import sdk.pendo.io.b6.b;
import sdk.pendo.io.c8.d;
import sdk.pendo.io.d6.e;
import sdk.pendo.io.f7.a;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepGuideModel;
import sdk.pendo.io.models.StepModel;
import sdk.pendo.io.utilities.AndroidUtils;
import sdk.pendo.io.views.GuideViewHolder;
import sdk.pendo.io.views.inserts.VisualGuideLayout;

/* loaded from: classes6.dex */
public class VisualGuide extends VisualGuideBase {
    private static final String TAG = "VisualGuide";
    private b mLifecycleResumeSubscription;

    public VisualGuide(GuideModel guideModel, VisualGuideLifecycleListener visualGuideLifecycleListener, StepSeenManagerInterface stepSeenManagerInterface) {
        super(guideModel, visualGuideLifecycleListener);
        this.mVisualGuideType = VisualGuideBase.VisualGuideType.FULL_SCREEN;
        this.mStepSeenManager = stepSeenManagerInterface;
    }

    private boolean setRootView(View view) {
        if (view == null) {
            PendoLogger.i(TAG, "Cannot show guide, rootView is null. GuideId: " + getGuideId());
            return false;
        }
        View findViewById = view.findViewById(R.id.content);
        if (findViewById instanceof ViewGroup) {
            view = findViewById;
        }
        setRootView((ViewGroup) view);
        return true;
    }

    private void setViewHolder(View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof GuideViewHolder)) {
            PendoLogger.d("Not setting view holder.", new Object[0]);
        } else if (((GuideViewHolder) view.getTag()).mainLayout == null) {
            PendoLogger.d("No main layout, not updating the view holder.", new Object[0]);
        }
    }

    protected boolean inflateContent(Activity activity, int i) {
        setContainerView((ViewGroup) LayoutInflater.from(activity).inflate(this.mVisualGuideType.getLayoutId(), getRootView(), false));
        ViewGroup container = getContainer();
        StepModel stepModel = getSteps().get(i);
        if (container != null) {
            setViewHolder(((VisualGuideLayout) container.findViewById(sdk.pendo.io.R.id.insert_visual_container)).inflateView(stepModel.getStepContent(), container, getGuideId(), this.mStepSeenManager.getCurrentStepId(), this.mVisualGuideType));
            return true;
        }
        PendoLogger.w("Cannot show guide, container is null. Pendo ID: " + getGuideId(), new Object[0]);
        return false;
    }

    public final void init(Activity activity, d dVar, String str) {
        if (activity == null) {
            PendoLogger.i(TAG, "Cannot show guide, activity is null. GuideId: " + getGuideId());
            return;
        }
        super.init(str, dVar);
        this.mActivity = new WeakReference<>(activity);
        int intValue = this.mStepSeenManager.getCurrentStepIndex().intValue();
        if (getSteps() == null || getSteps().get(intValue) == null) {
            PendoLogger.i(TAG, "Cannot show guide, guide step is null. GuideId: " + getGuideId());
            return;
        }
        if (setRootView(activity.getWindow().getDecorView())) {
            initializeTimeoutCounter(intValue);
            if (inflateContent(activity, intValue)) {
                this.mLifecycleResumeSubscription = sdk.pendo.io.n8.b.a().a(activity, a.RESUME, AndroidUtils.a(activity), new e() { // from class: sdk.pendo.io.actions.VisualGuide$$ExternalSyntheticLambda0
                    @Override // sdk.pendo.io.d6.e
                    public final void accept(Object obj) {
                        VisualGuide.this.m3036lambda$init$0$sdkpendoioactionsVisualGuide((a) obj);
                    }
                });
            }
        }
    }

    /* renamed from: lambda$init$0$sdk-pendo-io-actions-VisualGuide, reason: not valid java name */
    /* synthetic */ void m3036lambda$init$0$sdkpendoioactionsVisualGuide(a aVar) {
        if (GuidesActionsManager.getInstance().wasGuideFullyDisplayedAfterAnimation(getGuideId())) {
            GuidesActionsManager.getInstance().removeGuideFullyDisplayedAfterAnimation(getGuideId());
        }
    }

    @Override // sdk.pendo.io.actions.VisualGuideBase
    final void onDestroy() {
        try {
            PendoLogger.d("Pendo destroying.", new Object[0]);
            b bVar = this.mLifecycleResumeSubscription;
            if (bVar != null) {
                bVar.dispose();
                this.mLifecycleResumeSubscription = null;
            }
            cancelDuration();
            VisualGuideLifecycleListener visualGuideLifecycleListener = this.mListener;
            if (visualGuideLifecycleListener != null) {
                visualGuideLifecycleListener.onDestroy(getGuideId());
            }
            getAndSetShowing(false);
            setContainerView(null);
            setRootView((ViewGroup) null);
            WeakReference<Activity> weakReference = this.mActivity;
            if (weakReference != null && weakReference.get() != null) {
                this.mActivity.get().finish();
            }
            this.mActivity = null;
            this.mAdditionalInfo = new JSONObject();
            setTracker(null);
            unsubscribeSubscriptions();
            GuidesActionsManager.removeVisualGuideInitedObservable(getGuideId());
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
    }

    @Override // sdk.pendo.io.actions.VisualGuideBase
    public final boolean show() {
        PendoLogger.d(TAG, "start showing guide");
        try {
            setStartDuration(System.currentTimeMillis());
            StepGuideModel stepGuideModel = getStepGuideModel();
            if (stepGuideModel == null) {
                return true;
            }
            createVisualAnimationManager(stepGuideModel);
            this.mVisualAnimationManager.performShow(this.mActivity.get(), null);
            return true;
        } catch (Exception e) {
            PendoLogger.e(e, "Can't show guide: " + e.getMessage(), new Object[0]);
            onDestroy();
            return false;
        }
    }

    public VisualGuide(StepGuideModel stepGuideModel, VisualGuideLifecycleListener visualGuideLifecycleListener, StepSeenManagerInterface stepSeenManagerInterface) {
        super(stepGuideModel, visualGuideLifecycleListener);
        this.mVisualGuideType = VisualGuideBase.VisualGuideType.FULL_SCREEN;
        this.mStepSeenManager = stepSeenManagerInterface;
    }
}
