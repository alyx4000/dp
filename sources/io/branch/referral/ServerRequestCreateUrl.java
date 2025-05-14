package io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collection;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class ServerRequestCreateUrl extends ServerRequest {
    private static final String DEF_BASE_URL = "https://bnc.lt/a/";
    private Branch.BranchLinkCreateListener callback_;
    private boolean defaultToLongUrl_;
    private boolean isAsync_;
    private BranchLinkData linkPost_;

    @Override // io.branch.referral.ServerRequest
    public boolean isGetRequest() {
        return false;
    }

    @Override // io.branch.referral.ServerRequest
    boolean isPersistable() {
        return false;
    }

    @Override // io.branch.referral.ServerRequest
    protected boolean prepareExecuteWithoutTracking() {
        return true;
    }

    public ServerRequestCreateUrl(Context context, String str, int i, int i2, Collection<String> collection, String str2, String str3, String str4, String str5, JSONObject jSONObject, Branch.BranchLinkCreateListener branchLinkCreateListener, boolean z, boolean z2) {
        super(context, Defines.RequestPath.GetURL);
        this.callback_ = branchLinkCreateListener;
        this.isAsync_ = z;
        this.defaultToLongUrl_ = z2;
        this.linkPost_ = new BranchLinkData();
        try {
            if (!this.prefHelper_.getLinkClickID().equals(PrefHelper.NO_STRING_VALUE)) {
                this.linkPost_.put(Defines.Jsonkey.LinkClickID.getKey(), this.prefHelper_.getLinkClickID());
            }
            this.linkPost_.putType(i);
            this.linkPost_.putDuration(i2);
            this.linkPost_.putTags(collection);
            this.linkPost_.putAlias(str);
            this.linkPost_.putChannel(str2);
            this.linkPost_.putFeature(str3);
            this.linkPost_.putStage(str4);
            this.linkPost_.putCampaign(str5);
            this.linkPost_.putParams(jSONObject);
            this.linkPost_.putSource();
            setPost(this.linkPost_);
            this.linkPost_.remove("anon_id");
            this.linkPost_.remove("is_hardware_id_real");
            this.linkPost_.remove("hardware_id");
        } catch (JSONException e) {
            e.printStackTrace();
            this.constructError_ = true;
        }
    }

    public ServerRequestCreateUrl(Defines.RequestPath requestPath, JSONObject jSONObject, Context context) {
        super(requestPath, jSONObject, context);
        this.isAsync_ = true;
        this.defaultToLongUrl_ = true;
    }

    public BranchLinkData getLinkPost() {
        return this.linkPost_;
    }

    boolean isDefaultToLongUrl() {
        return this.defaultToLongUrl_;
    }

    @Override // io.branch.referral.ServerRequest
    public boolean handleErrors(Context context) {
        if (super.doesAppHasInternetPermission(context)) {
            return false;
        }
        Branch.BranchLinkCreateListener branchLinkCreateListener = this.callback_;
        if (branchLinkCreateListener == null) {
            return true;
        }
        branchLinkCreateListener.onLinkCreate(null, new BranchError("Trouble creating a URL.", BranchError.ERR_NO_INTERNET_PERMISSION));
        return true;
    }

    @Override // io.branch.referral.ServerRequest
    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        try {
            String string = serverResponse.getObject().getString("url");
            Branch.BranchLinkCreateListener branchLinkCreateListener = this.callback_;
            if (branchLinkCreateListener != null) {
                branchLinkCreateListener.onLinkCreate(string, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onUrlAvailable(String str) {
        Branch.BranchLinkCreateListener branchLinkCreateListener = this.callback_;
        if (branchLinkCreateListener != null) {
            branchLinkCreateListener.onLinkCreate(str, null);
        }
    }

    @Override // io.branch.referral.ServerRequest
    public void handleFailure(int i, String str) {
        if (this.callback_ != null) {
            this.callback_.onLinkCreate(this.defaultToLongUrl_ ? getLongUrl() : null, new BranchError("Trouble creating a URL. " + str, i));
        }
    }

    public String getLongUrl() {
        if (!this.prefHelper_.getUserURL().equals(PrefHelper.NO_STRING_VALUE)) {
            return generateLongUrlWithParams(this.prefHelper_.getUserURL());
        }
        return generateLongUrlWithParams(DEF_BASE_URL + this.prefHelper_.getBranchKey());
    }

    public void handleDuplicateURLError() {
        Branch.BranchLinkCreateListener branchLinkCreateListener = this.callback_;
        if (branchLinkCreateListener != null) {
            branchLinkCreateListener.onLinkCreate(null, new BranchError("Trouble creating a URL.", BranchError.ERR_BRANCH_DUPLICATE_URL));
        }
    }

    @Override // io.branch.referral.ServerRequest
    public void clearCallbacks() {
        this.callback_ = null;
    }

    public boolean isAsync() {
        return this.isAsync_;
    }

    private String generateLongUrlWithParams(String str) {
        try {
            if (Branch.getInstance().isTrackingDisabled() && !str.contains(DEF_BASE_URL)) {
                str = str.replace(new URL(str).getQuery(), "");
            }
            String str2 = str + (str.contains("?") ? "" : "?");
            String str3 = str2 + (str2.endsWith("?") ? "" : "&");
            Collection<String> tags = this.linkPost_.getTags();
            if (tags != null) {
                for (String str4 : tags) {
                    if (str4 != null && str4.length() > 0) {
                        str3 = str3 + Defines.LinkParam.Tags + "=" + URLEncoder.encode(str4, "UTF8") + "&";
                    }
                }
            }
            String alias = this.linkPost_.getAlias();
            if (alias != null && alias.length() > 0) {
                str3 = str3 + Defines.LinkParam.Alias + "=" + URLEncoder.encode(alias, "UTF8") + "&";
            }
            String channel = this.linkPost_.getChannel();
            if (channel != null && channel.length() > 0) {
                str3 = str3 + Defines.LinkParam.Channel + "=" + URLEncoder.encode(channel, "UTF8") + "&";
            }
            String feature = this.linkPost_.getFeature();
            if (feature != null && feature.length() > 0) {
                str3 = str3 + Defines.LinkParam.Feature + "=" + URLEncoder.encode(feature, "UTF8") + "&";
            }
            String stage = this.linkPost_.getStage();
            if (stage != null && stage.length() > 0) {
                str3 = str3 + Defines.LinkParam.Stage + "=" + URLEncoder.encode(stage, "UTF8") + "&";
            }
            String campaign = this.linkPost_.getCampaign();
            if (campaign != null && campaign.length() > 0) {
                str3 = str3 + Defines.LinkParam.Campaign + "=" + URLEncoder.encode(campaign, "UTF8") + "&";
            }
            String str5 = ((str3 + Defines.LinkParam.Type + "=" + this.linkPost_.getType() + "&") + Defines.LinkParam.Duration + "=" + this.linkPost_.getDuration()) + "&source=" + Defines.Jsonkey.URLSource.getKey();
            JSONObject params = this.linkPost_.getParams();
            if (params == null || params.length() <= 0) {
                return str5;
            }
            return str5 + "&data=" + URLEncoder.encode(Base64.encodeToString(params.toString().getBytes(), 2), "UTF8");
        } catch (Exception unused) {
            this.callback_.onLinkCreate(null, new BranchError("Trouble creating a URL.", BranchError.ERR_BRANCH_INVALID_REQUEST));
            return str;
        }
    }
}
