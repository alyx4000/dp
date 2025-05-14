package io.branch.referral;

import io.branch.indexing.BranchUniversalObject;
import io.branch.referral.Branch;
import io.branch.referral.util.LinkProperties;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class BranchUniversalReferralInitWrapper implements Branch.BranchReferralInitListener {
    private final Branch.BranchUniversalReferralInitListener universalReferralInitListener_;

    public BranchUniversalReferralInitWrapper(Branch.BranchUniversalReferralInitListener branchUniversalReferralInitListener) {
        this.universalReferralInitListener_ = branchUniversalReferralInitListener;
    }

    @Override // io.branch.referral.Branch.BranchReferralInitListener
    public void onInitFinished(JSONObject jSONObject, BranchError branchError) {
        Branch.BranchUniversalReferralInitListener branchUniversalReferralInitListener = this.universalReferralInitListener_;
        if (branchUniversalReferralInitListener != null) {
            if (branchError != null) {
                branchUniversalReferralInitListener.onInitFinished(null, null, branchError);
                return;
            }
            this.universalReferralInitListener_.onInitFinished(BranchUniversalObject.getReferredBranchUniversalObject(), LinkProperties.getReferredLinkProperties(), branchError);
        }
    }
}
