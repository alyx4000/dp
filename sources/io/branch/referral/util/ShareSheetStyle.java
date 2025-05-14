package io.branch.referral.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import io.branch.referral.SharingHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class ShareSheetStyle {
    final Context context_;
    private final String messageBody_;
    private final String messageTitle_;
    private boolean setFullWidthStyle_;
    private int styleResourceID_ = -1;
    private int dialogThemeResourceID_ = -1;
    private int dividerHeight_ = -1;
    private int iconSize_ = 50;
    private String sharingTitle_ = null;
    private View sharingTitleView_ = null;
    private List<String> includeInShareSheet = new ArrayList();
    private List<String> excludeFromShareSheet = new ArrayList();
    private Drawable moreOptionIcon_ = null;
    private String moreOptionText_ = null;
    private Drawable copyUrlIcon_ = null;
    private String copyURlText_ = null;
    private String urlCopiedMessage_ = null;
    private final ArrayList<SharingHelper.SHARE_WITH> preferredOptions_ = new ArrayList<>();
    private String defaultURL_ = null;

    public ShareSheetStyle(Context context, String str, String str2) {
        this.context_ = context;
        this.messageTitle_ = str;
        this.messageBody_ = str2;
    }

    public ShareSheetStyle setDefaultURL(String str) {
        this.defaultURL_ = str;
        return this;
    }

    public ShareSheetStyle setMoreOptionStyle(Drawable drawable, String str) {
        this.moreOptionIcon_ = drawable;
        this.moreOptionText_ = str;
        return this;
    }

    public ShareSheetStyle setMoreOptionStyle(int i, int i2) {
        this.moreOptionIcon_ = getDrawable(this.context_, i);
        this.moreOptionText_ = this.context_.getResources().getString(i2);
        return this;
    }

    public ShareSheetStyle setCopyUrlStyle(Drawable drawable, String str, String str2) {
        this.copyUrlIcon_ = drawable;
        this.copyURlText_ = str;
        this.urlCopiedMessage_ = str2;
        return this;
    }

    public ShareSheetStyle setCopyUrlStyle(int i, int i2, int i3) {
        this.copyUrlIcon_ = getDrawable(this.context_, i);
        this.copyURlText_ = this.context_.getResources().getString(i2);
        this.urlCopiedMessage_ = this.context_.getResources().getString(i3);
        return this;
    }

    public ShareSheetStyle addPreferredSharingOption(SharingHelper.SHARE_WITH share_with) {
        this.preferredOptions_.add(share_with);
        return this;
    }

    public ShareSheetStyle setStyleResourceID(int i) {
        this.styleResourceID_ = i;
        return this;
    }

    public ShareSheetStyle setDialogThemeResourceID(int i) {
        this.dialogThemeResourceID_ = i;
        return this;
    }

    public ShareSheetStyle setAsFullWidthStyle(boolean z) {
        this.setFullWidthStyle_ = z;
        return this;
    }

    public ShareSheetStyle setDividerHeight(int i) {
        this.dividerHeight_ = i;
        return this;
    }

    public ShareSheetStyle setSharingTitle(String str) {
        this.sharingTitle_ = str;
        return this;
    }

    public ShareSheetStyle setSharingTitle(View view) {
        this.sharingTitleView_ = view;
        return this;
    }

    public ShareSheetStyle excludeFromShareSheet(String str) {
        this.excludeFromShareSheet.add(str);
        return this;
    }

    public ShareSheetStyle excludeFromShareSheet(String[] strArr) {
        this.excludeFromShareSheet.addAll(Arrays.asList(strArr));
        return this;
    }

    public ShareSheetStyle excludeFromShareSheet(List<String> list) {
        this.excludeFromShareSheet.addAll(list);
        return this;
    }

    public ShareSheetStyle includeInShareSheet(String str) {
        this.includeInShareSheet.add(str);
        return this;
    }

    public ShareSheetStyle includeInShareSheet(String[] strArr) {
        this.includeInShareSheet.addAll(Arrays.asList(strArr));
        return this;
    }

    public ShareSheetStyle includeInShareSheet(List<String> list) {
        this.includeInShareSheet.addAll(list);
        return this;
    }

    public ShareSheetStyle setIconSize(int i) {
        this.iconSize_ = i;
        return this;
    }

    public List<String> getExcludedFromShareSheet() {
        return this.excludeFromShareSheet;
    }

    public List<String> getIncludedInShareSheet() {
        return this.includeInShareSheet;
    }

    public ArrayList<SharingHelper.SHARE_WITH> getPreferredOptions() {
        return this.preferredOptions_;
    }

    public Drawable getCopyUrlIcon() {
        return this.copyUrlIcon_;
    }

    public Drawable getMoreOptionIcon() {
        return this.moreOptionIcon_;
    }

    public String getMessageBody() {
        return this.messageBody_;
    }

    public String getMessageTitle() {
        return this.messageTitle_;
    }

    public String getCopyURlText() {
        return this.copyURlText_;
    }

    public String getDefaultURL() {
        return this.defaultURL_;
    }

    public String getMoreOptionText() {
        return this.moreOptionText_;
    }

    public String getUrlCopiedMessage() {
        return this.urlCopiedMessage_;
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

    public boolean getIsFullWidthStyle() {
        return this.setFullWidthStyle_;
    }

    public int getDialogThemeResourceID() {
        return this.dialogThemeResourceID_;
    }

    private Drawable getDrawable(Context context, int i) {
        return context.getResources().getDrawable(i, context.getTheme());
    }

    public int getStyleResourceID() {
        return this.styleResourceID_;
    }

    public int getIconSize() {
        return this.iconSize_;
    }
}
