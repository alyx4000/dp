package io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.BranchUrlBuilder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
abstract class BranchUrlBuilder<T extends BranchUrlBuilder> {
    protected String alias_;
    protected String campaign_;
    protected String channel_;
    private final Context context_;
    protected String feature_;
    protected JSONObject params_;
    protected String stage_;
    protected ArrayList<String> tags_;
    protected int type_ = 0;
    protected int duration_ = 0;
    private boolean defaultToLongUrl_ = true;
    protected Branch branchReferral_ = Branch.getInstance();

    protected BranchUrlBuilder(Context context) {
        this.context_ = context.getApplicationContext();
    }

    public T addTag(String str) {
        if (this.tags_ == null) {
            this.tags_ = new ArrayList<>();
        }
        this.tags_.add(str);
        return this;
    }

    public T addTags(List<String> list) {
        if (this.tags_ == null) {
            this.tags_ = new ArrayList<>();
        }
        this.tags_.addAll(list);
        return this;
    }

    public T addParameters(String str, Object obj) {
        try {
            if (this.params_ == null) {
                this.params_ = new JSONObject();
            }
            this.params_.put(str, obj);
        } catch (JSONException e) {
            BranchLogger.d(e.getMessage());
        }
        return this;
    }

    public T setDefaultToLongUrl(boolean z) {
        this.defaultToLongUrl_ = z;
        return this;
    }

    protected String getUrl() {
        if (this.branchReferral_ == null) {
            return null;
        }
        return this.branchReferral_.generateShortLinkInternal(new ServerRequestCreateUrl(this.context_, this.alias_, this.type_, this.duration_, this.tags_, this.channel_, this.feature_, this.stage_, this.campaign_, this.params_, null, false, this.defaultToLongUrl_));
    }

    protected void generateUrlInternal(Branch.BranchLinkCreateListener branchLinkCreateListener) {
        if (this.branchReferral_ != null) {
            this.branchReferral_.generateShortLinkInternal(new ServerRequestCreateUrl(this.context_, this.alias_, this.type_, this.duration_, this.tags_, this.channel_, this.feature_, this.stage_, this.campaign_, this.params_, branchLinkCreateListener, true, this.defaultToLongUrl_));
        } else {
            if (branchLinkCreateListener != null) {
                branchLinkCreateListener.onLinkCreate(null, new BranchError("session has not been initialized", BranchError.ERR_NO_SESSION));
            }
            BranchLogger.w("Warning: User session has not been initialized");
        }
    }
}
