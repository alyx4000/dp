package io.branch.referral;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TrackingController {
    private boolean trackingDisabled = true;

    TrackingController(Context context) {
        updateTrackingState(context);
    }

    void disableTracking(Context context, boolean z) {
        if (this.trackingDisabled != z) {
            this.trackingDisabled = z;
            if (z) {
                onTrackingDisabled(context);
            } else {
                onTrackingEnabled();
            }
            PrefHelper.getInstance(context).setBool("bnc_tracking_state", Boolean.valueOf(z));
        }
    }

    boolean isTrackingDisabled() {
        return this.trackingDisabled;
    }

    public static boolean isTrackingDisabled(Context context) {
        return PrefHelper.getInstance(context).getBool("bnc_tracking_state");
    }

    void updateTrackingState(Context context) {
        this.trackingDisabled = PrefHelper.getInstance(context).getBool("bnc_tracking_state");
    }

    private void onTrackingDisabled(Context context) {
        Branch.getInstance().clearPendingRequests();
        PrefHelper prefHelper = PrefHelper.getInstance(context);
        prefHelper.setSessionID(PrefHelper.NO_STRING_VALUE);
        prefHelper.setLinkClickID(PrefHelper.NO_STRING_VALUE);
        prefHelper.setLinkClickIdentifier(PrefHelper.NO_STRING_VALUE);
        prefHelper.setAppLink(PrefHelper.NO_STRING_VALUE);
        prefHelper.setInstallReferrerParams(PrefHelper.NO_STRING_VALUE);
        prefHelper.setAppStoreReferrer(PrefHelper.NO_STRING_VALUE);
        prefHelper.setAppStoreSource(PrefHelper.NO_STRING_VALUE);
        prefHelper.setGoogleSearchInstallIdentifier(PrefHelper.NO_STRING_VALUE);
        prefHelper.setInitialReferrer(PrefHelper.NO_STRING_VALUE);
        prefHelper.setExternalIntentUri(PrefHelper.NO_STRING_VALUE);
        prefHelper.setExternalIntentExtra(PrefHelper.NO_STRING_VALUE);
        prefHelper.setSessionParams(PrefHelper.NO_STRING_VALUE);
        prefHelper.setAnonID(PrefHelper.NO_STRING_VALUE);
        prefHelper.setReferringUrlQueryParameters(new JSONObject());
        Branch.getInstance().clearPartnerParameters();
    }

    private void onTrackingEnabled() {
        Branch branch = Branch.getInstance();
        if (branch != null) {
            branch.registerAppInit(branch.getInstallOrOpenRequest(null, true), true, false);
        }
    }
}
