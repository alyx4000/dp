package io.branch.indexing;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;
import io.branch.referral.BranchLogger;
import io.branch.referral.BranchShareSheetBuilder;
import io.branch.referral.BranchShortLinkBuilder;
import io.branch.referral.BranchUtil;
import io.branch.referral.Defines;
import io.branch.referral.TrackingController;
import io.branch.referral.util.BRANCH_STANDARD_EVENT;
import io.branch.referral.util.BranchEvent;
import io.branch.referral.util.ContentMetadata;
import io.branch.referral.util.CurrencyType;
import io.branch.referral.util.LinkProperties;
import io.branch.referral.util.ShareSheetStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BranchUniversalObject implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: io.branch.indexing.BranchUniversalObject.1
        @Override // android.os.Parcelable.Creator
        public BranchUniversalObject createFromParcel(Parcel parcel) {
            return new BranchUniversalObject(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BranchUniversalObject[] newArray(int i) {
            return new BranchUniversalObject[i];
        }
    };
    private String canonicalIdentifier_;
    private String canonicalUrl_;
    private long creationTimeStamp_;
    private String description_;
    private long expirationInMilliSec_;
    private String imageUrl_;
    private CONTENT_INDEX_MODE indexMode_;
    private final ArrayList<String> keywords_;
    private CONTENT_INDEX_MODE localIndexMode_;
    private ContentMetadata metadata_;
    private String title_;

    public enum CONTENT_INDEX_MODE {
        PUBLIC,
        PRIVATE
    }

    public interface RegisterViewStatusListener {
        void onRegisterViewFinished(boolean z, BranchError branchError);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCurrencyType() {
        return null;
    }

    public double getPrice() {
        return 0.0d;
    }

    public String getType() {
        return null;
    }

    public BranchUniversalObject setContentType(String str) {
        return this;
    }

    public BranchUniversalObject setPrice(double d, CurrencyType currencyType) {
        return this;
    }

    public BranchUniversalObject() {
        this.metadata_ = new ContentMetadata();
        this.keywords_ = new ArrayList<>();
        this.canonicalIdentifier_ = "";
        this.canonicalUrl_ = "";
        this.title_ = "";
        this.description_ = "";
        this.indexMode_ = CONTENT_INDEX_MODE.PUBLIC;
        this.localIndexMode_ = CONTENT_INDEX_MODE.PUBLIC;
        this.expirationInMilliSec_ = 0L;
        this.creationTimeStamp_ = System.currentTimeMillis();
    }

    public BranchUniversalObject setCanonicalIdentifier(String str) {
        this.canonicalIdentifier_ = str;
        return this;
    }

    public BranchUniversalObject setCanonicalUrl(String str) {
        this.canonicalUrl_ = str;
        return this;
    }

    public BranchUniversalObject setTitle(String str) {
        this.title_ = str;
        return this;
    }

    public BranchUniversalObject setContentDescription(String str) {
        this.description_ = str;
        return this;
    }

    public BranchUniversalObject setContentImageUrl(String str) {
        this.imageUrl_ = str;
        return this;
    }

    public BranchUniversalObject addContentMetadata(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                this.metadata_.addCustomMetadata(str, hashMap.get(str));
            }
        }
        return this;
    }

    public BranchUniversalObject addContentMetadata(String str, String str2) {
        this.metadata_.addCustomMetadata(str, str2);
        return this;
    }

    public BranchUniversalObject setContentMetadata(ContentMetadata contentMetadata) {
        this.metadata_ = contentMetadata;
        return this;
    }

    public BranchUniversalObject setContentIndexingMode(CONTENT_INDEX_MODE content_index_mode) {
        this.indexMode_ = content_index_mode;
        return this;
    }

    public BranchUniversalObject setLocalIndexMode(CONTENT_INDEX_MODE content_index_mode) {
        this.localIndexMode_ = content_index_mode;
        return this;
    }

    public BranchUniversalObject addKeyWords(ArrayList<String> arrayList) {
        this.keywords_.addAll(arrayList);
        return this;
    }

    public BranchUniversalObject addKeyWord(String str) {
        this.keywords_.add(str);
        return this;
    }

    public BranchUniversalObject setContentExpiration(Date date) {
        this.expirationInMilliSec_ = date.getTime();
        return this;
    }

    public boolean isPublicallyIndexable() {
        return this.indexMode_ == CONTENT_INDEX_MODE.PUBLIC;
    }

    public boolean isLocallyIndexable() {
        return this.localIndexMode_ == CONTENT_INDEX_MODE.PUBLIC;
    }

    public HashMap<String, String> getMetadata() {
        return this.metadata_.getCustomMetadata();
    }

    public ContentMetadata getContentMetadata() {
        return this.metadata_;
    }

    public long getExpirationTime() {
        return this.expirationInMilliSec_;
    }

    public String getCanonicalIdentifier() {
        return this.canonicalIdentifier_;
    }

    public String getCanonicalUrl() {
        return this.canonicalUrl_;
    }

    public String getDescription() {
        return this.description_;
    }

    public String getImageUrl() {
        return this.imageUrl_;
    }

    public String getTitle() {
        return this.title_;
    }

    public JSONArray getKeywordsJsonArray() {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.keywords_.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        return jSONArray;
    }

    public ArrayList<String> getKeywords() {
        return this.keywords_;
    }

    public void registerView() {
        registerView(null);
    }

    public void registerView(RegisterViewStatusListener registerViewStatusListener) {
        if (Branch.getInstance() != null) {
            Branch.getInstance().registerView(this, registerViewStatusListener);
        } else if (registerViewStatusListener != null) {
            registerViewStatusListener.onRegisterViewFinished(false, new BranchError("Register view error", BranchError.ERR_BRANCH_NOT_INSTANTIATED));
        }
    }

    public String getShortUrl(Context context, LinkProperties linkProperties) {
        return getLinkBuilder(context, linkProperties).getShortUrl();
    }

    public String getShortUrl(Context context, LinkProperties linkProperties, boolean z) {
        return ((BranchShortLinkBuilder) getLinkBuilder(context, linkProperties).setDefaultToLongUrl(z)).getShortUrl();
    }

    public void generateShortUrl(Context context, LinkProperties linkProperties, Branch.BranchLinkCreateListener branchLinkCreateListener) {
        if (TrackingController.isTrackingDisabled(context) && branchLinkCreateListener != null) {
            branchLinkCreateListener.onLinkCreate(getLinkBuilder(context, linkProperties).getShortUrl(), null);
        } else {
            getLinkBuilder(context, linkProperties).generateShortUrl(branchLinkCreateListener);
        }
    }

    public void generateShortUrl(Context context, LinkProperties linkProperties, Branch.BranchLinkCreateListener branchLinkCreateListener, boolean z) {
        ((BranchShortLinkBuilder) getLinkBuilder(context, linkProperties).setDefaultToLongUrl(z)).generateShortUrl(branchLinkCreateListener);
    }

    public void showShareSheet(Activity activity, LinkProperties linkProperties, ShareSheetStyle shareSheetStyle, Branch.BranchLinkShareListener branchLinkShareListener) {
        showShareSheet(activity, linkProperties, shareSheetStyle, branchLinkShareListener, null);
    }

    public void showShareSheet(Activity activity, LinkProperties linkProperties, ShareSheetStyle shareSheetStyle, Branch.BranchLinkShareListener branchLinkShareListener, Branch.IChannelProperties iChannelProperties) {
        if (Branch.getInstance() == null) {
            if (branchLinkShareListener != null) {
                branchLinkShareListener.onLinkShareResponse(null, null, new BranchError("Trouble sharing link. ", BranchError.ERR_BRANCH_NOT_INSTANTIATED));
                return;
            } else {
                BranchLogger.v("Sharing error. Branch instance is not created yet. Make sure you have initialised Branch.");
                return;
            }
        }
        BranchShareSheetBuilder branchShareSheetBuilder = new BranchShareSheetBuilder(activity, getLinkBuilder(activity, linkProperties));
        branchShareSheetBuilder.setCallback(new LinkShareListenerWrapper(branchLinkShareListener, branchShareSheetBuilder, linkProperties)).setChannelProperties(iChannelProperties).setSubject(shareSheetStyle.getMessageTitle()).setMessage(shareSheetStyle.getMessageBody());
        if (shareSheetStyle.getCopyUrlIcon() != null) {
            branchShareSheetBuilder.setCopyUrlStyle(shareSheetStyle.getCopyUrlIcon(), shareSheetStyle.getCopyURlText(), shareSheetStyle.getUrlCopiedMessage());
        }
        if (shareSheetStyle.getMoreOptionIcon() != null) {
            branchShareSheetBuilder.setMoreOptionStyle(shareSheetStyle.getMoreOptionIcon(), shareSheetStyle.getMoreOptionText());
        }
        if (shareSheetStyle.getDefaultURL() != null) {
            branchShareSheetBuilder.setDefaultURL(shareSheetStyle.getDefaultURL());
        }
        if (shareSheetStyle.getPreferredOptions().size() > 0) {
            branchShareSheetBuilder.addPreferredSharingOptions(shareSheetStyle.getPreferredOptions());
        }
        if (shareSheetStyle.getStyleResourceID() > 0) {
            branchShareSheetBuilder.setStyleResourceID(shareSheetStyle.getStyleResourceID());
        }
        branchShareSheetBuilder.setDividerHeight(shareSheetStyle.getDividerHeight());
        branchShareSheetBuilder.setAsFullWidthStyle(shareSheetStyle.getIsFullWidthStyle());
        branchShareSheetBuilder.setDialogThemeResourceID(shareSheetStyle.getDialogThemeResourceID());
        branchShareSheetBuilder.setSharingTitle(shareSheetStyle.getSharingTitle());
        branchShareSheetBuilder.setSharingTitle(shareSheetStyle.getSharingTitleView());
        branchShareSheetBuilder.setIconSize(shareSheetStyle.getIconSize());
        if (shareSheetStyle.getIncludedInShareSheet() != null && shareSheetStyle.getIncludedInShareSheet().size() > 0) {
            branchShareSheetBuilder.includeInShareSheet(shareSheetStyle.getIncludedInShareSheet());
        }
        if (shareSheetStyle.getExcludedFromShareSheet() != null && shareSheetStyle.getExcludedFromShareSheet().size() > 0) {
            branchShareSheetBuilder.excludeFromShareSheet(shareSheetStyle.getExcludedFromShareSheet());
        }
        branchShareSheetBuilder.shareLink();
    }

    private BranchShortLinkBuilder getLinkBuilder(Context context, LinkProperties linkProperties) {
        return getLinkBuilder(new BranchShortLinkBuilder(context), linkProperties);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BranchShortLinkBuilder getLinkBuilder(BranchShortLinkBuilder branchShortLinkBuilder, LinkProperties linkProperties) {
        if (linkProperties.getTags() != null) {
            branchShortLinkBuilder.addTags(linkProperties.getTags());
        }
        if (linkProperties.getFeature() != null) {
            branchShortLinkBuilder.setFeature(linkProperties.getFeature());
        }
        if (linkProperties.getAlias() != null) {
            branchShortLinkBuilder.setAlias(linkProperties.getAlias());
        }
        if (linkProperties.getChannel() != null) {
            branchShortLinkBuilder.setChannel(linkProperties.getChannel());
        }
        if (linkProperties.getStage() != null) {
            branchShortLinkBuilder.setStage(linkProperties.getStage());
        }
        if (linkProperties.getCampaign() != null) {
            branchShortLinkBuilder.setCampaign(linkProperties.getCampaign());
        }
        if (linkProperties.getMatchDuration() > 0) {
            branchShortLinkBuilder.setDuration(linkProperties.getMatchDuration());
        }
        if (!TextUtils.isEmpty(this.title_)) {
            branchShortLinkBuilder.addParameters(Defines.Jsonkey.ContentTitle.getKey(), this.title_);
        }
        if (!TextUtils.isEmpty(this.canonicalIdentifier_)) {
            branchShortLinkBuilder.addParameters(Defines.Jsonkey.CanonicalIdentifier.getKey(), this.canonicalIdentifier_);
        }
        if (!TextUtils.isEmpty(this.canonicalUrl_)) {
            branchShortLinkBuilder.addParameters(Defines.Jsonkey.CanonicalUrl.getKey(), this.canonicalUrl_);
        }
        JSONArray keywordsJsonArray = getKeywordsJsonArray();
        if (keywordsJsonArray.length() > 0) {
            branchShortLinkBuilder.addParameters(Defines.Jsonkey.ContentKeyWords.getKey(), keywordsJsonArray);
        }
        if (!TextUtils.isEmpty(this.description_)) {
            branchShortLinkBuilder.addParameters(Defines.Jsonkey.ContentDesc.getKey(), this.description_);
        }
        if (!TextUtils.isEmpty(this.imageUrl_)) {
            branchShortLinkBuilder.addParameters(Defines.Jsonkey.ContentImgUrl.getKey(), this.imageUrl_);
        }
        if (this.expirationInMilliSec_ > 0) {
            branchShortLinkBuilder.addParameters(Defines.Jsonkey.ContentExpiryTime.getKey(), "" + this.expirationInMilliSec_);
        }
        branchShortLinkBuilder.addParameters(Defines.Jsonkey.PublicallyIndexable.getKey(), "" + isPublicallyIndexable());
        JSONObject convertToJson = this.metadata_.convertToJson();
        try {
            Iterator<String> keys = convertToJson.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                branchShortLinkBuilder.addParameters(next, convertToJson.get(next));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap<String, String> controlParams = linkProperties.getControlParams();
        for (String str : controlParams.keySet()) {
            branchShortLinkBuilder.addParameters(str, controlParams.get(str));
        }
        return branchShortLinkBuilder;
    }

    public static BranchUniversalObject getReferredBranchUniversalObject() {
        BranchUniversalObject createInstance;
        Branch branch = Branch.getInstance();
        if (branch == null) {
            return null;
        }
        try {
            if (branch.getLatestReferringParams() == null) {
                return null;
            }
            if (branch.getLatestReferringParams().has("+clicked_branch_link") && branch.getLatestReferringParams().getBoolean("+clicked_branch_link")) {
                createInstance = createInstance(branch.getLatestReferringParams());
            } else {
                if (branch.getDeeplinkDebugParams() == null || branch.getDeeplinkDebugParams().length() <= 0) {
                    return null;
                }
                createInstance = createInstance(branch.getLatestReferringParams());
            }
            return createInstance;
        } catch (Exception e) {
            BranchLogger.d(e.getMessage());
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static BranchUniversalObject createInstance(JSONObject jSONObject) {
        JSONArray jSONArray = null;
        try {
            BranchUniversalObject branchUniversalObject = new BranchUniversalObject();
            try {
                BranchUtil.JsonReader jsonReader = new BranchUtil.JsonReader(jSONObject);
                branchUniversalObject.title_ = jsonReader.readOutString(Defines.Jsonkey.ContentTitle.getKey());
                branchUniversalObject.canonicalIdentifier_ = jsonReader.readOutString(Defines.Jsonkey.CanonicalIdentifier.getKey());
                branchUniversalObject.canonicalUrl_ = jsonReader.readOutString(Defines.Jsonkey.CanonicalUrl.getKey());
                branchUniversalObject.description_ = jsonReader.readOutString(Defines.Jsonkey.ContentDesc.getKey());
                branchUniversalObject.imageUrl_ = jsonReader.readOutString(Defines.Jsonkey.ContentImgUrl.getKey());
                branchUniversalObject.expirationInMilliSec_ = jsonReader.readOutLong(Defines.Jsonkey.ContentExpiryTime.getKey());
                Object readOut = jsonReader.readOut(Defines.Jsonkey.ContentKeyWords.getKey());
                if (readOut instanceof JSONArray) {
                    jSONArray = (JSONArray) readOut;
                } else if (readOut instanceof String) {
                    jSONArray = new JSONArray((String) readOut);
                }
                if (jSONArray != null) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        branchUniversalObject.keywords_.add((String) jSONArray.get(i));
                    }
                }
                Object readOut2 = jsonReader.readOut(Defines.Jsonkey.PublicallyIndexable.getKey());
                if (readOut2 instanceof Boolean) {
                    branchUniversalObject.indexMode_ = ((Boolean) readOut2).booleanValue() ? CONTENT_INDEX_MODE.PUBLIC : CONTENT_INDEX_MODE.PRIVATE;
                } else if (readOut2 instanceof Integer) {
                    branchUniversalObject.indexMode_ = ((Integer) readOut2).intValue() == 1 ? CONTENT_INDEX_MODE.PUBLIC : CONTENT_INDEX_MODE.PRIVATE;
                }
                branchUniversalObject.localIndexMode_ = jsonReader.readOutBoolean(Defines.Jsonkey.LocallyIndexable.getKey()) ? CONTENT_INDEX_MODE.PUBLIC : CONTENT_INDEX_MODE.PRIVATE;
                branchUniversalObject.creationTimeStamp_ = jsonReader.readOutLong(Defines.Jsonkey.CreationTimestamp.getKey());
                branchUniversalObject.metadata_ = ContentMetadata.createFromJson(jsonReader);
                JSONObject jsonObject = jsonReader.getJsonObject();
                Iterator<String> keys = jsonObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    branchUniversalObject.metadata_.addCustomMetadata(next, jsonObject.optString(next));
                }
                return branchUniversalObject;
            } catch (Exception e) {
                e = e;
                jSONArray = branchUniversalObject;
                BranchLogger.d(e.getMessage());
                return jSONArray;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public JSONObject convertToJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject convertToJson = this.metadata_.convertToJson();
            Iterator<String> keys = convertToJson.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, convertToJson.get(next));
            }
            if (!TextUtils.isEmpty(this.title_)) {
                jSONObject.put(Defines.Jsonkey.ContentTitle.getKey(), this.title_);
            }
            if (!TextUtils.isEmpty(this.canonicalIdentifier_)) {
                jSONObject.put(Defines.Jsonkey.CanonicalIdentifier.getKey(), this.canonicalIdentifier_);
            }
            if (!TextUtils.isEmpty(this.canonicalUrl_)) {
                jSONObject.put(Defines.Jsonkey.CanonicalUrl.getKey(), this.canonicalUrl_);
            }
            if (this.keywords_.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = this.keywords_.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put(Defines.Jsonkey.ContentKeyWords.getKey(), jSONArray);
            }
            if (!TextUtils.isEmpty(this.description_)) {
                jSONObject.put(Defines.Jsonkey.ContentDesc.getKey(), this.description_);
            }
            if (!TextUtils.isEmpty(this.imageUrl_)) {
                jSONObject.put(Defines.Jsonkey.ContentImgUrl.getKey(), this.imageUrl_);
            }
            if (this.expirationInMilliSec_ > 0) {
                jSONObject.put(Defines.Jsonkey.ContentExpiryTime.getKey(), this.expirationInMilliSec_);
            }
            jSONObject.put(Defines.Jsonkey.PublicallyIndexable.getKey(), isPublicallyIndexable());
            jSONObject.put(Defines.Jsonkey.LocallyIndexable.getKey(), isLocallyIndexable());
            jSONObject.put(Defines.Jsonkey.CreationTimestamp.getKey(), this.creationTimeStamp_);
        } catch (JSONException e) {
            BranchLogger.d(e.getMessage());
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.creationTimeStamp_);
        parcel.writeString(this.canonicalIdentifier_);
        parcel.writeString(this.canonicalUrl_);
        parcel.writeString(this.title_);
        parcel.writeString(this.description_);
        parcel.writeString(this.imageUrl_);
        parcel.writeLong(this.expirationInMilliSec_);
        parcel.writeInt(this.indexMode_.ordinal());
        parcel.writeSerializable(this.keywords_);
        parcel.writeParcelable(this.metadata_, i);
        parcel.writeInt(this.localIndexMode_.ordinal());
    }

    private BranchUniversalObject(Parcel parcel) {
        this();
        this.creationTimeStamp_ = parcel.readLong();
        this.canonicalIdentifier_ = parcel.readString();
        this.canonicalUrl_ = parcel.readString();
        this.title_ = parcel.readString();
        this.description_ = parcel.readString();
        this.imageUrl_ = parcel.readString();
        this.expirationInMilliSec_ = parcel.readLong();
        this.indexMode_ = CONTENT_INDEX_MODE.values()[parcel.readInt()];
        ArrayList arrayList = (ArrayList) parcel.readSerializable();
        if (arrayList != null) {
            this.keywords_.addAll(arrayList);
        }
        this.metadata_ = (ContentMetadata) parcel.readParcelable(ContentMetadata.class.getClassLoader());
        this.localIndexMode_ = CONTENT_INDEX_MODE.values()[parcel.readInt()];
    }

    private class LinkShareListenerWrapper implements Branch.BranchLinkShareListener {
        private final LinkProperties linkProperties_;
        private final Branch.BranchLinkShareListener originalCallback_;
        private final BranchShareSheetBuilder shareSheetBuilder_;

        LinkShareListenerWrapper(Branch.BranchLinkShareListener branchLinkShareListener, BranchShareSheetBuilder branchShareSheetBuilder, LinkProperties linkProperties) {
            this.originalCallback_ = branchLinkShareListener;
            this.shareSheetBuilder_ = branchShareSheetBuilder;
            this.linkProperties_ = linkProperties;
        }

        @Override // io.branch.referral.Branch.BranchLinkShareListener
        public void onShareLinkDialogLaunched() {
            Branch.BranchLinkShareListener branchLinkShareListener = this.originalCallback_;
            if (branchLinkShareListener != null) {
                branchLinkShareListener.onShareLinkDialogLaunched();
            }
        }

        @Override // io.branch.referral.Branch.BranchLinkShareListener
        public void onShareLinkDialogDismissed() {
            Branch.BranchLinkShareListener branchLinkShareListener = this.originalCallback_;
            if (branchLinkShareListener != null) {
                branchLinkShareListener.onShareLinkDialogDismissed();
            }
        }

        @Override // io.branch.referral.Branch.BranchLinkShareListener
        public void onLinkShareResponse(String str, String str2, BranchError branchError) {
            BranchEvent branchEvent = new BranchEvent(BRANCH_STANDARD_EVENT.SHARE);
            if (branchError == null) {
                branchEvent.addCustomDataProperty(Defines.Jsonkey.SharedLink.getKey(), str);
                branchEvent.addCustomDataProperty(Defines.Jsonkey.SharedChannel.getKey(), str2);
                branchEvent.addContentItems(BranchUniversalObject.this);
            } else {
                branchEvent.addCustomDataProperty(Defines.Jsonkey.ShareError.getKey(), branchError.getMessage());
            }
            branchEvent.logEvent(Branch.getInstance().getApplicationContext());
            Branch.BranchLinkShareListener branchLinkShareListener = this.originalCallback_;
            if (branchLinkShareListener != null) {
                branchLinkShareListener.onLinkShareResponse(str, str2, branchError);
            }
        }

        @Override // io.branch.referral.Branch.BranchLinkShareListener
        public void onChannelSelected(String str) {
            Branch.BranchLinkShareListener branchLinkShareListener = this.originalCallback_;
            if (branchLinkShareListener != null) {
                branchLinkShareListener.onChannelSelected(str);
            }
            Branch.BranchLinkShareListener branchLinkShareListener2 = this.originalCallback_;
            if ((branchLinkShareListener2 instanceof Branch.ExtendedBranchLinkShareListener) && ((Branch.ExtendedBranchLinkShareListener) branchLinkShareListener2).onChannelSelected(str, BranchUniversalObject.this, this.linkProperties_)) {
                BranchShareSheetBuilder branchShareSheetBuilder = this.shareSheetBuilder_;
                branchShareSheetBuilder.setShortLinkBuilderInternal(BranchUniversalObject.this.getLinkBuilder(branchShareSheetBuilder.getShortLinkBuilder(), this.linkProperties_));
            }
        }
    }
}
