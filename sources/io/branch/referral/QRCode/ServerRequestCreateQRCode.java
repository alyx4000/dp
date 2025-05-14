package io.branch.referral.QRCode;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import io.branch.referral.QRCode.BranchQRCode;
import io.branch.referral.ServerRequest;
import io.branch.referral.ServerResponse;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ServerRequestCreateQRCode extends ServerRequest {
    private BranchQRCode.BranchQRCodeRequestHandler callback_;
    private final Context context_;
    private JSONObject params_;
    private long queueWaitTime_;
    final Defines.RequestPath requestPath_;

    @Override // io.branch.referral.ServerRequest
    public boolean handleErrors(Context context) {
        return false;
    }

    @Override // io.branch.referral.ServerRequest
    public boolean isGetRequest() {
        return false;
    }

    @Override // io.branch.referral.ServerRequest
    protected boolean prepareExecuteWithoutTracking() {
        return true;
    }

    protected ServerRequestCreateQRCode(Defines.RequestPath requestPath, JSONObject jSONObject, Context context, BranchQRCode.BranchQRCodeRequestHandler branchQRCodeRequestHandler) {
        super(Defines.RequestPath.QRCode, jSONObject, context);
        this.queueWaitTime_ = 0L;
        this.context_ = context;
        this.requestPath_ = requestPath;
        this.params_ = jSONObject;
        this.callback_ = branchQRCodeRequestHandler;
    }

    @Override // io.branch.referral.ServerRequest
    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        this.callback_.onDataReceived(serverResponse);
    }

    @Override // io.branch.referral.ServerRequest
    public void handleFailure(int i, String str) {
        this.callback_.onFailure(new Exception("Failed server request: " + i + str));
    }

    @Override // io.branch.referral.ServerRequest
    public void onRequestQueued() {
        this.queueWaitTime_ = System.currentTimeMillis();
    }

    @Override // io.branch.referral.ServerRequest
    public void clearCallbacks() {
        this.callback_ = null;
    }
}
