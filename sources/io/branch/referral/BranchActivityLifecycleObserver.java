package io.branch.referral;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import io.branch.referral.Branch;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
class BranchActivityLifecycleObserver implements Application.ActivityLifecycleCallbacks {
    private int activityCnt_ = 0;
    private Set<String> activitiesOnStack_ = new HashSet();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    BranchActivityLifecycleObserver() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        BranchLogger.v("onActivityCreated, activity = " + activity);
        Branch branch = Branch.getInstance();
        if (branch == null) {
            return;
        }
        branch.setIntentState(Branch.INTENT_STATE.PENDING);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        BranchLogger.v("onActivityStarted, activity = " + activity);
        Branch branch = Branch.getInstance();
        if (branch == null) {
            return;
        }
        branch.currentActivityReference_ = new WeakReference<>(activity);
        branch.setIntentState(Branch.INTENT_STATE.PENDING);
        this.activityCnt_++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        BranchLogger.v("onActivityResumed, activity = " + activity);
        Branch branch = Branch.getInstance();
        if (branch == null) {
            return;
        }
        if (!Branch.bypassCurrentActivityIntentState()) {
            branch.onIntentReady(activity);
        }
        if (branch.getInitState() == Branch.SESSION_STATE.UNINITIALISED && !Branch.disableAutoSessionInitialization) {
            if (Branch.getPluginName() == null) {
                BranchLogger.v("initializing session on user's behalf (onActivityResumed called but SESSION_STATE = UNINITIALISED)");
                Branch.sessionBuilder(activity).isAutoInitialization(true).init();
            } else {
                BranchLogger.v("onActivityResumed called and SESSION_STATE = UNINITIALISED, however this is a " + Branch.getPluginName() + " plugin, so we are NOT initializing session on user's behalf");
            }
        }
        this.activitiesOnStack_.add(activity.toString());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        BranchLogger.v("onActivityPaused, activity = " + activity);
        Branch branch = Branch.getInstance();
        if (branch == null || branch.getShareLinkManager() == null) {
            return;
        }
        branch.getShareLinkManager().cancelShareLinkDialog(true);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        BranchLogger.v("onActivityStopped, activity = " + activity);
        Branch branch = Branch.getInstance();
        if (branch == null) {
            return;
        }
        int i = this.activityCnt_ - 1;
        this.activityCnt_ = i;
        if (i < 1) {
            branch.setInstantDeepLinkPossible(false);
            branch.closeSessionInternal();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        BranchLogger.v("onActivityDestroyed, activity = " + activity);
        Branch branch = Branch.getInstance();
        if (branch == null) {
            return;
        }
        if (branch.getCurrentActivity() == activity) {
            branch.currentActivityReference_.clear();
        }
        this.activitiesOnStack_.remove(activity.toString());
    }

    boolean isCurrentActivityLaunchedFromStack() {
        Branch branch = Branch.getInstance();
        if (branch == null || branch.getCurrentActivity() == null) {
            return false;
        }
        return this.activitiesOnStack_.contains(branch.getCurrentActivity().toString());
    }
}
