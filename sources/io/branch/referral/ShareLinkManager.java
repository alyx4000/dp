package io.branch.referral;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import io.branch.referral.Branch;
import io.branch.referral.SharingHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
class ShareLinkManager {
    private static int ICON_SIZER = 2;
    private static int viewItemMinHeight_ = 100;
    private BranchShareSheetBuilder builder_;
    Branch.BranchLinkShareListener callback_;
    Branch.IChannelProperties channelPropertiesCallback_;
    Context context_;
    private List<ResolveInfo> displayedAppList_;
    AnimatedDialog shareDlg_;
    private Intent shareLinkIntent_;
    private final int BG_COLOR_ENABLED = Color.argb(60, 17, 4, 56);
    private final int BG_COLOR_DISABLED = Color.argb(20, 17, 4, 56);
    private boolean isShareInProgress_ = false;
    private int shareDialogThemeID_ = -1;
    private int iconSize_ = 50;
    final int padding = 5;
    final int leftMargin = 100;
    private List<String> includeInShareSheet = new ArrayList();
    private List<String> excludeFromShareSheet = new ArrayList();

    ShareLinkManager() {
    }

    Dialog shareLink(BranchShareSheetBuilder branchShareSheetBuilder) {
        this.builder_ = branchShareSheetBuilder;
        this.context_ = branchShareSheetBuilder.getActivity();
        this.callback_ = branchShareSheetBuilder.getCallback();
        this.channelPropertiesCallback_ = branchShareSheetBuilder.getChannelPropertiesCallback();
        Intent intent = new Intent("android.intent.action.SEND");
        this.shareLinkIntent_ = intent;
        intent.setType("text/plain");
        this.shareDialogThemeID_ = branchShareSheetBuilder.getStyleResourceID();
        this.includeInShareSheet = branchShareSheetBuilder.getIncludedInShareSheet();
        this.excludeFromShareSheet = branchShareSheetBuilder.getExcludedFromShareSheet();
        this.iconSize_ = branchShareSheetBuilder.getIconSize();
        try {
            createShareDialog(branchShareSheetBuilder.getPreferredOptions());
        } catch (Exception e) {
            e.printStackTrace();
            Branch.BranchLinkShareListener branchLinkShareListener = this.callback_;
            if (branchLinkShareListener != null) {
                branchLinkShareListener.onLinkShareResponse(null, null, new BranchError("Trouble sharing link", BranchError.ERR_BRANCH_NO_SHARE_OPTION));
            } else {
                BranchLogger.v("Unable create share options. Couldn't find applications on device to share the link.");
            }
        }
        return this.shareDlg_;
    }

    void cancelShareLinkDialog(boolean z) {
        AnimatedDialog animatedDialog = this.shareDlg_;
        if (animatedDialog == null || !animatedDialog.isShowing()) {
            return;
        }
        if (z) {
            this.shareDlg_.cancel();
        } else {
            this.shareDlg_.dismiss();
        }
    }

    private void createShareDialog(List<SharingHelper.SHARE_WITH> list) {
        final ListView listView;
        List<ResolveInfo> queryIntentActivities = this.context_.getPackageManager().queryIntentActivities(this.shareLinkIntent_, 65536);
        final ArrayList arrayList = new ArrayList(getExplicitlyIncludedMatchingApps(queryIntentActivities));
        List<ResolveInfo> preferredMatchingApps = getPreferredMatchingApps(queryIntentActivities, list);
        arrayList.removeAll(preferredMatchingApps);
        arrayList.addAll(0, preferredMatchingApps);
        arrayList.add(new CopyLinkItem());
        preferredMatchingApps.add(new CopyLinkItem());
        filterOutExplicitlyExcludedApps(arrayList);
        if (preferredMatchingApps.size() > 1) {
            if (arrayList.size() > preferredMatchingApps.size()) {
                preferredMatchingApps.add(new MoreShareItem());
            }
            this.displayedAppList_ = preferredMatchingApps;
        } else {
            this.displayedAppList_ = arrayList;
        }
        final ChooserArrayAdapter chooserArrayAdapter = new ChooserArrayAdapter();
        if (this.shareDialogThemeID_ > 1) {
            listView = new ListView(this.context_, null, 0, this.shareDialogThemeID_);
        } else {
            listView = new ListView(this.context_);
        }
        listView.setHorizontalFadingEdgeEnabled(false);
        listView.setBackgroundColor(-1);
        listView.setSelector(new ColorDrawable(0));
        if (this.builder_.getSharingTitleView() != null) {
            listView.addHeaderView(this.builder_.getSharingTitleView(), null, false);
        } else if (!TextUtils.isEmpty(this.builder_.getSharingTitle())) {
            TextView textView = new TextView(this.context_);
            textView.setText(this.builder_.getSharingTitle());
            textView.setBackgroundColor(this.BG_COLOR_DISABLED);
            textView.setTextColor(this.BG_COLOR_DISABLED);
            textView.setTextAppearance(this.context_, android.R.style.TextAppearance.Medium);
            textView.setTextColor(this.context_.getResources().getColor(android.R.color.darker_gray));
            textView.setPadding(100, 5, 5, 5);
            listView.addHeaderView(textView, null, false);
        }
        listView.setAdapter((ListAdapter) chooserArrayAdapter);
        if (this.builder_.getDividerHeight() >= 0) {
            listView.setDividerHeight(this.builder_.getDividerHeight());
        } else if (this.builder_.getIsFullWidthStyle()) {
            listView.setDividerHeight(0);
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: io.branch.referral.ShareLinkManager.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (view == null) {
                    return;
                }
                if (view.getTag() instanceof MoreShareItem) {
                    ShareLinkManager.this.displayedAppList_ = arrayList;
                    chooserArrayAdapter.notifyDataSetChanged();
                    return;
                }
                if (view.getTag() instanceof ResolveInfo) {
                    ResolveInfo resolveInfo = (ResolveInfo) view.getTag();
                    if (ShareLinkManager.this.callback_ != null) {
                        PackageManager packageManager = ShareLinkManager.this.context_.getPackageManager();
                        String obj = (ShareLinkManager.this.context_ == null || resolveInfo.loadLabel(packageManager) == null) ? "" : resolveInfo.loadLabel(packageManager).toString();
                        ShareLinkManager.this.builder_.getShortLinkBuilder().setChannel(resolveInfo.loadLabel(packageManager).toString());
                        ShareLinkManager.this.callback_.onChannelSelected(obj);
                    }
                    chooserArrayAdapter.selectedPos = i - listView.getHeaderViewsCount();
                    chooserArrayAdapter.notifyDataSetChanged();
                    ShareLinkManager.this.invokeSharingClient(resolveInfo);
                    if (ShareLinkManager.this.shareDlg_ != null) {
                        ShareLinkManager.this.shareDlg_.cancel();
                    }
                }
            }
        });
        if (this.builder_.getDialogThemeResourceID() > 0) {
            this.shareDlg_ = new AnimatedDialog(this.context_, this.builder_.getDialogThemeResourceID());
        } else {
            this.shareDlg_ = new AnimatedDialog(this.context_, this.builder_.getIsFullWidthStyle());
        }
        this.shareDlg_.setContentView(listView);
        this.shareDlg_.show();
        Branch.BranchLinkShareListener branchLinkShareListener = this.callback_;
        if (branchLinkShareListener != null) {
            branchLinkShareListener.onShareLinkDialogLaunched();
        }
        this.shareDlg_.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: io.branch.referral.ShareLinkManager.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (ShareLinkManager.this.callback_ != null) {
                    ShareLinkManager.this.callback_.onShareLinkDialogDismissed();
                    ShareLinkManager.this.callback_ = null;
                }
                if (!ShareLinkManager.this.isShareInProgress_) {
                    ShareLinkManager.this.context_ = null;
                    ShareLinkManager.this.builder_ = null;
                }
                ShareLinkManager.this.shareDlg_ = null;
            }
        });
        this.shareDlg_.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: io.branch.referral.ShareLinkManager.3
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 1) {
                    return false;
                }
                if (i == 4) {
                    ShareLinkManager.this.shareDlg_.dismiss();
                } else {
                    if (i == 23 || i == 66) {
                        if (chooserArrayAdapter.selectedPos < 0 || chooserArrayAdapter.selectedPos >= chooserArrayAdapter.getCount()) {
                            return false;
                        }
                        ListView listView2 = listView;
                        ChooserArrayAdapter chooserArrayAdapter2 = chooserArrayAdapter;
                        listView2.performItemClick(chooserArrayAdapter2.getView(chooserArrayAdapter2.selectedPos, null, null), chooserArrayAdapter.selectedPos, listView.getItemIdAtPosition(chooserArrayAdapter.selectedPos));
                        return false;
                    }
                    if (i != 19) {
                        if (i != 20) {
                            return false;
                        }
                        if (chooserArrayAdapter.selectedPos < chooserArrayAdapter.getCount() - 1) {
                            chooserArrayAdapter.selectedPos++;
                            chooserArrayAdapter.notifyDataSetChanged();
                        }
                    } else if (chooserArrayAdapter.selectedPos > 0) {
                        chooserArrayAdapter.selectedPos--;
                        chooserArrayAdapter.notifyDataSetChanged();
                    }
                }
                return true;
            }
        });
    }

    private List<ResolveInfo> getPreferredMatchingApps(List<ResolveInfo> list, List<SharingHelper.SHARE_WITH> list2) {
        SharingHelper.SHARE_WITH share_with;
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : list) {
            if (resolveInfo != null && resolveInfo.activityInfo != null) {
                String str = resolveInfo.activityInfo.packageName;
                Iterator<SharingHelper.SHARE_WITH> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        share_with = null;
                        break;
                    }
                    share_with = it.next();
                    if (str.toLowerCase().contains(share_with.toString().toLowerCase())) {
                        break;
                    }
                }
                if (share_with != null) {
                    arrayList.add(resolveInfo);
                }
            }
        }
        return arrayList;
    }

    private List<ResolveInfo> getExplicitlyIncludedMatchingApps(List<ResolveInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (this.includeInShareSheet.size() <= 0) {
            return list;
        }
        for (ResolveInfo resolveInfo : list) {
            if (this.includeInShareSheet.contains(resolveInfo.activityInfo.packageName)) {
                arrayList.add(resolveInfo);
            }
        }
        return arrayList;
    }

    private void filterOutExplicitlyExcludedApps(List<ResolveInfo> list) {
        Iterator<ResolveInfo> it = list.iterator();
        while (it.hasNext()) {
            ResolveInfo next = it.next();
            if (next != null && next.activityInfo != null && this.excludeFromShareSheet.contains(next.activityInfo.packageName)) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeSharingClient(final ResolveInfo resolveInfo) {
        this.isShareInProgress_ = true;
        final String obj = resolveInfo.loadLabel(this.context_.getPackageManager()).toString();
        this.builder_.getShortLinkBuilder().generateShortUrl(new Branch.BranchLinkCreateListener() { // from class: io.branch.referral.ShareLinkManager.4
            @Override // io.branch.referral.Branch.BranchLinkCreateListener
            public void onLinkCreate(String str, BranchError branchError) {
                if (branchError == null) {
                    ShareLinkManager.this.shareWithClient(resolveInfo, str, obj);
                    return;
                }
                String defaultURL = ShareLinkManager.this.builder_.getDefaultURL();
                if (defaultURL != null && defaultURL.trim().length() > 0) {
                    ShareLinkManager.this.shareWithClient(resolveInfo, defaultURL, obj);
                    return;
                }
                if (ShareLinkManager.this.callback_ != null) {
                    ShareLinkManager.this.callback_.onLinkShareResponse(str, obj, branchError);
                } else {
                    BranchLogger.v("Unable to share link " + branchError.getMessage());
                }
                if (branchError.getErrorCode() == -113 || branchError.getErrorCode() == -117) {
                    ShareLinkManager.this.shareWithClient(resolveInfo, str, obj);
                } else {
                    ShareLinkManager.this.cancelShareLinkDialog(false);
                    ShareLinkManager.this.isShareInProgress_ = false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shareWithClient(ResolveInfo resolveInfo, String str, String str2) {
        Branch.BranchLinkShareListener branchLinkShareListener = this.callback_;
        if (branchLinkShareListener != null) {
            branchLinkShareListener.onLinkShareResponse(str, str2, null);
        } else {
            BranchLogger.v("Shared link with " + str2);
        }
        if (resolveInfo instanceof CopyLinkItem) {
            addLinkToClipBoard(str, this.builder_.getShareMsg());
            return;
        }
        this.shareLinkIntent_.setPackage(resolveInfo.activityInfo.packageName);
        String shareSub = this.builder_.getShareSub();
        String shareMsg = this.builder_.getShareMsg();
        Branch.IChannelProperties iChannelProperties = this.channelPropertiesCallback_;
        if (iChannelProperties != null) {
            String sharingTitleForChannel = iChannelProperties.getSharingTitleForChannel(str2);
            String sharingMessageForChannel = this.channelPropertiesCallback_.getSharingMessageForChannel(str2);
            if (!TextUtils.isEmpty(sharingTitleForChannel)) {
                shareSub = sharingTitleForChannel;
            }
            if (!TextUtils.isEmpty(sharingMessageForChannel)) {
                shareMsg = sharingMessageForChannel;
            }
        }
        if (shareSub != null && shareSub.trim().length() > 0) {
            this.shareLinkIntent_.putExtra("android.intent.extra.SUBJECT", shareSub);
        }
        this.shareLinkIntent_.putExtra("android.intent.extra.TEXT", shareMsg + "\n" + str);
        this.context_.startActivity(this.shareLinkIntent_);
    }

    private void addLinkToClipBoard(String str, String str2) {
        ((ClipboardManager) this.context_.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str2, str));
        Toast.makeText(this.context_, this.builder_.getUrlCopiedMessage(), 0).show();
    }

    private class ChooserArrayAdapter extends BaseAdapter {
        public int selectedPos;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private ChooserArrayAdapter() {
            this.selectedPos = -1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ShareLinkManager.this.displayedAppList_.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ShareLinkManager.this.displayedAppList_.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ShareItemView shareItemView;
            if (view == null) {
                ShareLinkManager shareLinkManager = ShareLinkManager.this;
                shareItemView = shareLinkManager.new ShareItemView(shareLinkManager.context_);
            } else {
                shareItemView = (ShareItemView) view;
            }
            ResolveInfo resolveInfo = (ResolveInfo) ShareLinkManager.this.displayedAppList_.get(i);
            shareItemView.setLabel(resolveInfo.loadLabel(ShareLinkManager.this.context_.getPackageManager()).toString(), resolveInfo.loadIcon(ShareLinkManager.this.context_.getPackageManager()), i == this.selectedPos);
            shareItemView.setTag(resolveInfo);
            return shareItemView;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i) {
            return this.selectedPos < 0;
        }
    }

    private class ShareItemView extends TextView {
        Context context_;
        int iconSizeDP_;

        public ShareItemView(Context context) {
            super(context);
            this.context_ = context;
            setPadding(100, 5, 5, 5);
            setGravity(8388627);
            setMinWidth(this.context_.getResources().getDisplayMetrics().widthPixels);
            this.iconSizeDP_ = ShareLinkManager.this.iconSize_ != 0 ? BranchUtil.dpToPx(context, ShareLinkManager.this.iconSize_) : 0;
        }

        public void setLabel(String str, Drawable drawable, boolean z) {
            setText("\t" + str);
            setTag(str);
            if (drawable == null) {
                setTextAppearance(this.context_, android.R.style.TextAppearance.Large);
                setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                int i = this.iconSizeDP_;
                if (i != 0) {
                    drawable.setBounds(0, 0, i, i);
                    setCompoundDrawables(drawable, null, null, null);
                } else {
                    setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                setTextAppearance(this.context_, android.R.style.TextAppearance.Medium);
                int unused = ShareLinkManager.viewItemMinHeight_ = Math.max(ShareLinkManager.viewItemMinHeight_, (drawable.getCurrent().getBounds().centerY() * ShareLinkManager.ICON_SIZER) + 5);
            }
            setMinHeight(ShareLinkManager.viewItemMinHeight_);
            setTextColor(this.context_.getResources().getColor(android.R.color.black));
            if (z) {
                setBackgroundColor(ShareLinkManager.this.BG_COLOR_ENABLED);
            } else {
                setBackgroundColor(ShareLinkManager.this.BG_COLOR_DISABLED);
            }
        }
    }

    private class MoreShareItem extends ResolveInfo {
        private MoreShareItem() {
        }

        @Override // android.content.pm.ResolveInfo
        public CharSequence loadLabel(PackageManager packageManager) {
            return ShareLinkManager.this.builder_.getMoreOptionText();
        }

        @Override // android.content.pm.ResolveInfo
        public Drawable loadIcon(PackageManager packageManager) {
            return ShareLinkManager.this.builder_.getMoreOptionIcon();
        }
    }

    private class CopyLinkItem extends ResolveInfo {
        private CopyLinkItem() {
        }

        @Override // android.content.pm.ResolveInfo
        public CharSequence loadLabel(PackageManager packageManager) {
            return ShareLinkManager.this.builder_.getCopyURlText();
        }

        @Override // android.content.pm.ResolveInfo
        public Drawable loadIcon(PackageManager packageManager) {
            return ShareLinkManager.this.builder_.getCopyUrlIcon();
        }
    }
}
