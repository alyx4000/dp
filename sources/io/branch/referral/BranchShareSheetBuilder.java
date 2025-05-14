package io.branch.referral;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import io.branch.referral.Branch;
import io.branch.referral.SharingHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BranchShareSheetBuilder {
    private final Activity activity_;
    private Branch.BranchLinkShareListener callback_;
    private Branch.IChannelProperties channelPropertiesCallback_;
    private String copyURlText_;
    private Drawable copyUrlIcon_;
    private String defaultURL_;
    private int dialogThemeResourceID_;
    private int dividerHeight_;
    private List<String> excludeFromShareSheet;
    private int iconSize_;
    private List<String> includeInShareSheet;
    private Drawable moreOptionIcon_;
    private String moreOptionText_;
    private ArrayList<SharingHelper.SHARE_WITH> preferredOptions_;
    private boolean setFullWidthStyle_;
    private String shareMsg_;
    private String shareSub_;
    private View sharingTitleView_;
    private String sharingTitle_;
    private BranchShortLinkBuilder shortLinkBuilder_;
    private int styleResourceID_;
    private String urlCopiedMessage_;

    public BranchShareSheetBuilder(Activity activity, JSONObject jSONObject) {
        this.dividerHeight_ = -1;
        this.sharingTitle_ = null;
        this.sharingTitleView_ = null;
        this.iconSize_ = 50;
        this.includeInShareSheet = new ArrayList();
        this.excludeFromShareSheet = new ArrayList();
        this.activity_ = activity;
        this.shortLinkBuilder_ = new BranchShortLinkBuilder(activity);
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.shortLinkBuilder_.addParameters(next, jSONObject.get(next));
            }
        } catch (Exception e) {
            BranchLogger.d(e.getMessage());
        }
        this.shareMsg_ = "";
        this.callback_ = null;
        this.channelPropertiesCallback_ = null;
        this.preferredOptions_ = new ArrayList<>();
        this.defaultURL_ = null;
        this.moreOptionIcon_ = BranchUtil.getDrawable(activity.getApplicationContext(), android.R.drawable.ic_menu_more);
        this.moreOptionText_ = "More...";
        this.copyUrlIcon_ = BranchUtil.getDrawable(activity.getApplicationContext(), android.R.drawable.ic_menu_save);
        this.copyURlText_ = "Copy link";
        this.urlCopiedMessage_ = "Copied link to clipboard!";
        if (Branch.getInstance().getDeviceInfo().isTV()) {
            excludeFromShareSheet("com.google.android.tv.frameworkpackagestubs");
        }
    }

    public BranchShareSheetBuilder(Activity activity, BranchShortLinkBuilder branchShortLinkBuilder) {
        this(activity, new JSONObject());
        this.shortLinkBuilder_ = branchShortLinkBuilder;
    }

    public BranchShareSheetBuilder setMessage(String str) {
        this.shareMsg_ = str;
        return this;
    }

    public BranchShareSheetBuilder setSubject(String str) {
        this.shareSub_ = str;
        return this;
    }

    public BranchShareSheetBuilder addTag(String str) {
        this.shortLinkBuilder_.addTag(str);
        return this;
    }

    public BranchShareSheetBuilder addTags(ArrayList<String> arrayList) {
        this.shortLinkBuilder_.addTags(arrayList);
        return this;
    }

    public BranchShareSheetBuilder setFeature(String str) {
        this.shortLinkBuilder_.setFeature(str);
        return this;
    }

    public BranchShareSheetBuilder setStage(String str) {
        this.shortLinkBuilder_.setStage(str);
        return this;
    }

    public BranchShareSheetBuilder setCallback(Branch.BranchLinkShareListener branchLinkShareListener) {
        this.callback_ = branchLinkShareListener;
        return this;
    }

    public BranchShareSheetBuilder setChannelProperties(Branch.IChannelProperties iChannelProperties) {
        this.channelPropertiesCallback_ = iChannelProperties;
        return this;
    }

    public BranchShareSheetBuilder addPreferredSharingOption(SharingHelper.SHARE_WITH share_with) {
        this.preferredOptions_.add(share_with);
        return this;
    }

    public BranchShareSheetBuilder addPreferredSharingOptions(ArrayList<SharingHelper.SHARE_WITH> arrayList) {
        this.preferredOptions_.addAll(arrayList);
        return this;
    }

    public BranchShareSheetBuilder addParam(String str, String str2) {
        try {
            this.shortLinkBuilder_.addParameters(str, str2);
        } catch (Exception e) {
            BranchLogger.d(e.getMessage());
        }
        return this;
    }

    public BranchShareSheetBuilder setDefaultURL(String str) {
        this.defaultURL_ = str;
        return this;
    }

    public BranchShareSheetBuilder setMoreOptionStyle(Drawable drawable, String str) {
        this.moreOptionIcon_ = drawable;
        this.moreOptionText_ = str;
        return this;
    }

    public BranchShareSheetBuilder setMoreOptionStyle(int i, int i2) {
        this.moreOptionIcon_ = BranchUtil.getDrawable(this.activity_.getApplicationContext(), i);
        this.moreOptionText_ = this.activity_.getResources().getString(i2);
        return this;
    }

    public BranchShareSheetBuilder setCopyUrlStyle(Drawable drawable, String str, String str2) {
        this.copyUrlIcon_ = drawable;
        this.copyURlText_ = str;
        this.urlCopiedMessage_ = str2;
        return this;
    }

    public BranchShareSheetBuilder setCopyUrlStyle(int i, int i2, int i3) {
        this.copyUrlIcon_ = BranchUtil.getDrawable(this.activity_.getApplicationContext(), i);
        this.copyURlText_ = this.activity_.getResources().getString(i2);
        this.urlCopiedMessage_ = this.activity_.getResources().getString(i3);
        return this;
    }

    public BranchShareSheetBuilder setAlias(String str) {
        this.shortLinkBuilder_.setAlias(str);
        return this;
    }

    public BranchShareSheetBuilder setMatchDuration(int i) {
        this.shortLinkBuilder_.setDuration(i);
        return this;
    }

    public BranchShareSheetBuilder setAsFullWidthStyle(boolean z) {
        this.setFullWidthStyle_ = z;
        return this;
    }

    public BranchShareSheetBuilder setDialogThemeResourceID(int i) {
        this.dialogThemeResourceID_ = i;
        return this;
    }

    public BranchShareSheetBuilder setDividerHeight(int i) {
        this.dividerHeight_ = i;
        return this;
    }

    public BranchShareSheetBuilder setSharingTitle(String str) {
        this.sharingTitle_ = str;
        return this;
    }

    public BranchShareSheetBuilder setSharingTitle(View view) {
        this.sharingTitleView_ = view;
        return this;
    }

    public BranchShareSheetBuilder setIconSize(int i) {
        this.iconSize_ = i;
        return this;
    }

    public BranchShareSheetBuilder excludeFromShareSheet(String str) {
        this.excludeFromShareSheet.add(str);
        return this;
    }

    public BranchShareSheetBuilder excludeFromShareSheet(String[] strArr) {
        this.excludeFromShareSheet.addAll(Arrays.asList(strArr));
        return this;
    }

    public BranchShareSheetBuilder excludeFromShareSheet(List<String> list) {
        this.excludeFromShareSheet.addAll(list);
        return this;
    }

    public BranchShareSheetBuilder includeInShareSheet(String str) {
        this.includeInShareSheet.add(str);
        return this;
    }

    public BranchShareSheetBuilder includeInShareSheet(String[] strArr) {
        this.includeInShareSheet.addAll(Arrays.asList(strArr));
        return this;
    }

    public BranchShareSheetBuilder includeInShareSheet(List<String> list) {
        this.includeInShareSheet.addAll(list);
        return this;
    }

    public void setStyleResourceID(int i) {
        this.styleResourceID_ = i;
    }

    public void setShortLinkBuilderInternal(BranchShortLinkBuilder branchShortLinkBuilder) {
        this.shortLinkBuilder_ = branchShortLinkBuilder;
    }

    public void shareLink() {
        Branch.getInstance().shareLink(this);
    }

    public Activity getActivity() {
        return this.activity_;
    }

    public ArrayList<SharingHelper.SHARE_WITH> getPreferredOptions() {
        return this.preferredOptions_;
    }

    List<String> getExcludedFromShareSheet() {
        return this.excludeFromShareSheet;
    }

    List<String> getIncludedInShareSheet() {
        return this.includeInShareSheet;
    }

    @Deprecated
    public Branch getBranch() {
        return Branch.getInstance();
    }

    public String getShareMsg() {
        return this.shareMsg_;
    }

    public String getShareSub() {
        return this.shareSub_;
    }

    public Branch.BranchLinkShareListener getCallback() {
        return this.callback_;
    }

    public Branch.IChannelProperties getChannelPropertiesCallback() {
        return this.channelPropertiesCallback_;
    }

    public String getDefaultURL() {
        return this.defaultURL_;
    }

    public Drawable getMoreOptionIcon() {
        return this.moreOptionIcon_;
    }

    public String getMoreOptionText() {
        return this.moreOptionText_;
    }

    public Drawable getCopyUrlIcon() {
        return this.copyUrlIcon_;
    }

    public String getCopyURlText() {
        return this.copyURlText_;
    }

    public String getUrlCopiedMessage() {
        return this.urlCopiedMessage_;
    }

    public BranchShortLinkBuilder getShortLinkBuilder() {
        return this.shortLinkBuilder_;
    }

    public boolean getIsFullWidthStyle() {
        return this.setFullWidthStyle_;
    }

    public int getDialogThemeResourceID() {
        return this.dialogThemeResourceID_;
    }

    public int getDividerHeight() {
        return this.dividerHeight_;
    }

    public String getSharingTitle() {
        return this.sharingTitle_;
    }

    public View getSharingTitleView() {
        return this.sharingTitleView_;
    }

    public int getStyleResourceID() {
        return this.styleResourceID_;
    }

    public int getIconSize() {
        return this.iconSize_;
    }
}
