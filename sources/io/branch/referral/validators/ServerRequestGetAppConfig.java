package io.branch.referral.validators;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import io.branch.referral.ServerRequest;
import io.branch.referral.ServerResponse;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class ServerRequestGetAppConfig extends ServerRequest {
    private final IGetAppConfigEvents callback;

    public interface IGetAppConfigEvents {
        void onAppConfigAvailable(JSONObject jSONObject);
    }

    @Override // io.branch.referral.ServerRequest
    public void clearCallbacks() {
    }

    @Override // io.branch.referral.ServerRequest
    public boolean handleErrors(Context context) {
        return false;
    }

    @Override // io.branch.referral.ServerRequest
    public boolean isGetRequest() {
        return true;
    }

    public ServerRequestGetAppConfig(Context context, IGetAppConfigEvents iGetAppConfigEvents) {
        super(context, Defines.RequestPath.GetApp);
        this.callback = iGetAppConfigEvents;
    }

    @Override // io.branch.referral.ServerRequest
    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        IGetAppConfigEvents iGetAppConfigEvents = this.callback;
        if (iGetAppConfigEvents != null) {
            iGetAppConfigEvents.onAppConfigAvailable(serverResponse.getObject());
        }
    }

    @Override // io.branch.referral.ServerRequest
    public void handleFailure(int i, String str) {
        IGetAppConfigEvents iGetAppConfigEvents = this.callback;
        if (iGetAppConfigEvents != null) {
            iGetAppConfigEvents.onAppConfigAvailable(null);
        }
    }

    @Override // io.branch.referral.ServerRequest
    public String getRequestUrl() {
        return this.prefHelper_.getAPIBaseUrl() + getRequestPath() + "/" + this.prefHelper_.getBranchKey();
    }
}
