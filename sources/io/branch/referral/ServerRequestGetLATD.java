package io.branch.referral;

import android.content.Context;
import io.branch.referral.Defines;
import io.branch.referral.ServerRequest;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ServerRequestGetLATD extends ServerRequest {
    protected static final int defaultAttributionWindow = -1;
    private int attributionWindow;
    private BranchLastAttributedTouchDataListener callback;

    public interface BranchLastAttributedTouchDataListener {
        void onDataFetched(JSONObject jSONObject, BranchError branchError);
    }

    @Override // io.branch.referral.ServerRequest
    public boolean handleErrors(Context context) {
        return false;
    }

    @Override // io.branch.referral.ServerRequest
    public boolean isGetRequest() {
        return false;
    }

    @Override // io.branch.referral.ServerRequest
    protected boolean shouldUpdateLimitFacebookTracking() {
        return true;
    }

    ServerRequestGetLATD(Context context, Defines.RequestPath requestPath, BranchLastAttributedTouchDataListener branchLastAttributedTouchDataListener) {
        this(context, requestPath, branchLastAttributedTouchDataListener, PrefHelper.getInstance(context).getLATDAttributionWindow());
    }

    ServerRequestGetLATD(Context context, Defines.RequestPath requestPath, BranchLastAttributedTouchDataListener branchLastAttributedTouchDataListener, int i) {
        super(context, requestPath);
        this.callback = branchLastAttributedTouchDataListener;
        this.attributionWindow = i;
        JSONObject jSONObject = new JSONObject();
        try {
            setPost(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        updateEnvironment(context, jSONObject);
    }

    protected int getAttributionWindow() {
        return this.attributionWindow;
    }

    @Override // io.branch.referral.ServerRequest
    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        BranchLastAttributedTouchDataListener branchLastAttributedTouchDataListener = this.callback;
        if (branchLastAttributedTouchDataListener == null) {
            return;
        }
        if (serverResponse != null) {
            branchLastAttributedTouchDataListener.onDataFetched(serverResponse.getObject(), null);
        } else {
            handleFailure(BranchError.ERR_BRANCH_INVALID_REQUEST, "Failed to get last attributed touch data");
        }
    }

    @Override // io.branch.referral.ServerRequest
    public void handleFailure(int i, String str) {
        BranchLastAttributedTouchDataListener branchLastAttributedTouchDataListener = this.callback;
        if (branchLastAttributedTouchDataListener != null) {
            branchLastAttributedTouchDataListener.onDataFetched(null, new BranchError("Failed to get last attributed touch data", i));
        }
    }

    @Override // io.branch.referral.ServerRequest
    public void clearCallbacks() {
        this.callback = null;
    }

    @Override // io.branch.referral.ServerRequest
    public ServerRequest.BRANCH_API_VERSION getBranchRemoteAPIVersion() {
        return ServerRequest.BRANCH_API_VERSION.V1_LATD;
    }
}
