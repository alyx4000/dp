package io.branch.referral;

import android.content.Context;
import io.branch.indexing.BranchUniversalObject;
import io.branch.referral.Defines;
import io.branch.referral.ServerRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ServerRequestLogEvent extends ServerRequest {
    @Override // io.branch.referral.ServerRequest
    public void clearCallbacks() {
    }

    @Override // io.branch.referral.ServerRequest
    public boolean handleErrors(Context context) {
        return false;
    }

    @Override // io.branch.referral.ServerRequest
    public void handleFailure(int i, String str) {
    }

    @Override // io.branch.referral.ServerRequest
    public boolean isGetRequest() {
        return false;
    }

    @Override // io.branch.referral.ServerRequest
    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
    }

    @Override // io.branch.referral.ServerRequest
    protected boolean shouldAddDMAParams() {
        return true;
    }

    @Override // io.branch.referral.ServerRequest
    public boolean shouldRetryOnFail() {
        return true;
    }

    @Override // io.branch.referral.ServerRequest
    protected boolean shouldUpdateLimitFacebookTracking() {
        return true;
    }

    public ServerRequestLogEvent(Context context, Defines.RequestPath requestPath, String str, HashMap<String, Object> hashMap, JSONObject jSONObject, JSONObject jSONObject2, List<BranchUniversalObject> list) {
        super(context, requestPath);
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put(Defines.Jsonkey.Name.getKey(), str);
            if (jSONObject2.length() > 0) {
                jSONObject3.put(Defines.Jsonkey.CustomData.getKey(), jSONObject2);
            }
            if (jSONObject.length() > 0) {
                jSONObject3.put(Defines.Jsonkey.EventData.getKey(), jSONObject);
            }
            if (hashMap.size() > 0) {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    jSONObject3.put(entry.getKey(), entry.getValue());
                }
            }
            if (list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                jSONObject3.put(Defines.Jsonkey.ContentItems.getKey(), jSONArray);
                Iterator<BranchUniversalObject> it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().convertToJson());
                }
            }
            setPost(jSONObject3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        updateEnvironment(context, jSONObject3);
    }

    @Override // io.branch.referral.ServerRequest
    protected void setPost(JSONObject jSONObject) throws JSONException {
        super.setPost(jSONObject);
        this.prefHelper_.loadPartnerParams(jSONObject);
    }

    @Override // io.branch.referral.ServerRequest
    public ServerRequest.BRANCH_API_VERSION getBranchRemoteAPIVersion() {
        return ServerRequest.BRANCH_API_VERSION.V2;
    }
}
