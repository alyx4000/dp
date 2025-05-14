package io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BranchShortLinkBuilder extends BranchUrlBuilder<BranchShortLinkBuilder> {
    /* JADX WARN: Type inference failed for: r1v1, types: [io.branch.referral.BranchShortLinkBuilder, io.branch.referral.BranchUrlBuilder] */
    @Override // io.branch.referral.BranchUrlBuilder
    public /* bridge */ /* synthetic */ BranchShortLinkBuilder addParameters(String str, Object obj) {
        return super.addParameters(str, obj);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [io.branch.referral.BranchShortLinkBuilder, io.branch.referral.BranchUrlBuilder] */
    @Override // io.branch.referral.BranchUrlBuilder
    public /* bridge */ /* synthetic */ BranchShortLinkBuilder addTag(String str) {
        return super.addTag(str);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [io.branch.referral.BranchShortLinkBuilder, io.branch.referral.BranchUrlBuilder] */
    @Override // io.branch.referral.BranchUrlBuilder
    public /* bridge */ /* synthetic */ BranchShortLinkBuilder addTags(List list) {
        return super.addTags(list);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [io.branch.referral.BranchShortLinkBuilder, io.branch.referral.BranchUrlBuilder] */
    @Override // io.branch.referral.BranchUrlBuilder
    public /* bridge */ /* synthetic */ BranchShortLinkBuilder setDefaultToLongUrl(boolean z) {
        return super.setDefaultToLongUrl(z);
    }

    public BranchShortLinkBuilder(Context context) {
        super(context);
    }

    public BranchShortLinkBuilder setAlias(String str) {
        this.alias_ = str;
        return this;
    }

    public BranchShortLinkBuilder setChannel(String str) {
        this.channel_ = str;
        return this;
    }

    public BranchShortLinkBuilder setDuration(int i) {
        this.duration_ = i;
        return this;
    }

    public BranchShortLinkBuilder setFeature(String str) {
        this.feature_ = str;
        return this;
    }

    public BranchShortLinkBuilder setParameters(JSONObject jSONObject) {
        this.params_ = jSONObject;
        return this;
    }

    public BranchShortLinkBuilder setStage(String str) {
        this.stage_ = str;
        return this;
    }

    public BranchShortLinkBuilder setCampaign(String str) {
        this.campaign_ = str;
        return this;
    }

    public BranchShortLinkBuilder setType(int i) {
        this.type_ = i;
        return this;
    }

    public String getShortUrl() {
        return super.getUrl();
    }

    public void generateShortUrl(Branch.BranchLinkCreateListener branchLinkCreateListener) {
        super.generateUrlInternal(branchLinkCreateListener);
    }
}
