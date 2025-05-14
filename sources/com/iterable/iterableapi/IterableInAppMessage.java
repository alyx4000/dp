package com.iterable.iterableapi;

import android.graphics.Rect;
import androidx.core.util.ObjectsCompat;
import com.facebook.react.uimanager.ViewProps;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class IterableInAppMessage {
    private static final String TAG = "IterableInAppMessage";
    private final Long campaignId;
    private final Content content;
    private final Date createdAt;
    private final JSONObject customPayload;
    private final Date expiresAt;
    private IterableInAppStorage inAppStorageInterface;
    private final InboxMetadata inboxMetadata;
    private final String messageId;
    private OnChangeListener onChangeListener;
    private final double priorityLevel;
    private final Boolean saveToInbox;
    private final Trigger trigger;
    private boolean processed = false;
    private boolean consumed = false;
    private boolean read = false;
    private boolean loadedHtmlFromJson = false;
    private boolean markedForDeletion = false;

    interface OnChangeListener {
        void onInAppMessageChanged(IterableInAppMessage iterableInAppMessage);
    }

    IterableInAppMessage(String str, Content content, JSONObject jSONObject, Date date, Date date2, Trigger trigger, Double d, Boolean bool, InboxMetadata inboxMetadata, Long l) {
        this.messageId = str;
        this.content = content;
        this.customPayload = jSONObject;
        this.createdAt = date;
        this.expiresAt = date2;
        this.trigger = trigger;
        this.priorityLevel = d.doubleValue();
        this.saveToInbox = bool;
        this.inboxMetadata = inboxMetadata;
        this.campaignId = l;
    }

    static class Trigger {
        final JSONObject triggerJson;
        final TriggerType type;

        enum TriggerType {
            IMMEDIATE,
            EVENT,
            NEVER
        }

        private Trigger(JSONObject jSONObject) {
            this.triggerJson = jSONObject;
            String optString = jSONObject.optString("type");
            optString.hashCode();
            if (optString.equals("never")) {
                this.type = TriggerType.NEVER;
            } else if (optString.equals("immediate")) {
                this.type = TriggerType.IMMEDIATE;
            } else {
                this.type = TriggerType.NEVER;
            }
        }

        Trigger(TriggerType triggerType) {
            this.triggerJson = null;
            this.type = triggerType;
        }

        static Trigger fromJSONObject(JSONObject jSONObject) {
            if (jSONObject == null) {
                return new Trigger(TriggerType.IMMEDIATE);
            }
            return new Trigger(jSONObject);
        }

        JSONObject toJSONObject() {
            return this.triggerJson;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Trigger) {
                return ObjectsCompat.equals(this.triggerJson, ((Trigger) obj).triggerJson);
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.triggerJson);
        }
    }

    public static class Content {
        public final double backgroundAlpha;
        public String html;
        public final InAppDisplaySettings inAppDisplaySettings;
        public final Rect padding;

        Content(String str, Rect rect, double d, boolean z, InAppDisplaySettings inAppDisplaySettings) {
            this.html = str;
            this.padding = rect;
            this.backgroundAlpha = d;
            this.inAppDisplaySettings = inAppDisplaySettings;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Content)) {
                return false;
            }
            Content content = (Content) obj;
            return ObjectsCompat.equals(this.html, content.html) && ObjectsCompat.equals(this.padding, content.padding) && this.backgroundAlpha == content.backgroundAlpha;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.html, this.padding, Double.valueOf(this.backgroundAlpha));
        }
    }

    public static class InAppDisplaySettings {
        InAppBgColor inAppBgColor;
        boolean shouldAnimate;

        public InAppDisplaySettings(boolean z, InAppBgColor inAppBgColor) {
            this.shouldAnimate = z;
            this.inAppBgColor = inAppBgColor;
        }
    }

    public static class InAppBgColor {
        double bgAlpha;
        String bgHexColor;

        public InAppBgColor(String str, double d) {
            this.bgHexColor = str;
            this.bgAlpha = d;
        }
    }

    public static class InboxMetadata {
        public final String icon;
        public final String subtitle;
        public final String title;

        public InboxMetadata(String str, String str2, String str3) {
            this.title = str;
            this.subtitle = str2;
            this.icon = str3;
        }

        static InboxMetadata fromJSONObject(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new InboxMetadata(jSONObject.optString("title"), jSONObject.optString(IterableConstants.ITERABLE_IN_APP_INBOX_SUBTITLE), jSONObject.optString("icon"));
        }

        JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("title", this.title);
                jSONObject.putOpt(IterableConstants.ITERABLE_IN_APP_INBOX_SUBTITLE, this.subtitle);
                jSONObject.putOpt("icon", this.icon);
            } catch (JSONException e) {
                IterableLogger.e(IterableInAppMessage.TAG, "Error while serializing inbox metadata", e);
            }
            return jSONObject;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof InboxMetadata)) {
                return false;
            }
            InboxMetadata inboxMetadata = (InboxMetadata) obj;
            return ObjectsCompat.equals(this.title, inboxMetadata.title) && ObjectsCompat.equals(this.subtitle, inboxMetadata.subtitle) && ObjectsCompat.equals(this.icon, inboxMetadata.icon);
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.title, this.subtitle, this.icon);
        }
    }

    public String getMessageId() {
        return this.messageId;
    }

    public Long getCampaignId() {
        return this.campaignId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public Date getExpiresAt() {
        return this.expiresAt;
    }

    public Content getContent() {
        if (this.content.html == null) {
            this.content.html = this.inAppStorageInterface.getHTML(this.messageId);
        }
        return this.content;
    }

    public JSONObject getCustomPayload() {
        return this.customPayload;
    }

    boolean isProcessed() {
        return this.processed;
    }

    void setProcessed(boolean z) {
        this.processed = z;
        onChanged();
    }

    boolean isConsumed() {
        return this.consumed;
    }

    void setConsumed(boolean z) {
        this.consumed = z;
        onChanged();
    }

    Trigger.TriggerType getTriggerType() {
        return this.trigger.type;
    }

    public double getPriorityLevel() {
        return this.priorityLevel;
    }

    public boolean isInboxMessage() {
        Boolean bool = this.saveToInbox;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public boolean isSilentInboxMessage() {
        return isInboxMessage() && getTriggerType() == Trigger.TriggerType.NEVER;
    }

    public InboxMetadata getInboxMetadata() {
        return this.inboxMetadata;
    }

    public boolean isRead() {
        return this.read;
    }

    void setRead(boolean z) {
        this.read = z;
        onChanged();
    }

    boolean hasLoadedHtmlFromJson() {
        return this.loadedHtmlFromJson;
    }

    void setLoadedHtmlFromJson(boolean z) {
        this.loadedHtmlFromJson = z;
    }

    public boolean isMarkedForDeletion() {
        return this.markedForDeletion;
    }

    public void markForDeletion(boolean z) {
        this.markedForDeletion = z;
    }

    static IterableInAppMessage fromJSONObject(JSONObject jSONObject, IterableInAppStorage iterableInAppStorage) {
        JSONObject optJSONObject;
        String str;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("content")) == null) {
            return null;
        }
        String optString = jSONObject.optString(IterableConstants.KEY_MESSAGE_ID);
        Long retrieveValidCampaignIdOrNull = IterableUtil.retrieveValidCampaignIdOrNull(jSONObject, IterableConstants.KEY_CAMPAIGN_ID);
        long optLong = jSONObject.optLong("createdAt");
        Date date = optLong != 0 ? new Date(optLong) : null;
        long optLong2 = jSONObject.optLong(IterableConstants.ITERABLE_IN_APP_EXPIRES_AT);
        Date date2 = optLong2 != 0 ? new Date(optLong2) : null;
        String optString2 = optJSONObject.optString(IterableConstants.ITERABLE_IN_APP_HTML, null);
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(IterableConstants.ITERABLE_IN_APP_DISPLAY_SETTINGS);
        Rect paddingFromPayload = getPaddingFromPayload(optJSONObject2);
        double d = 0.0d;
        double optDouble = optJSONObject.optDouble(IterableConstants.ITERABLE_IN_APP_BACKGROUND_ALPHA, 0.0d);
        boolean optBoolean = optJSONObject2.optBoolean(IterableConstants.ITERABLE_IN_APP_SHOULD_ANIMATE, false);
        JSONObject optJSONObject3 = optJSONObject2.optJSONObject(IterableConstants.ITERABLE_IN_APP_BGCOLOR);
        if (optJSONObject3 != null) {
            str = optJSONObject3.optString(IterableConstants.ITERABLE_IN_APP_BGCOLOR_HEX);
            d = optJSONObject3.optDouble("alpha");
        } else {
            str = null;
        }
        InAppDisplaySettings inAppDisplaySettings = new InAppDisplaySettings(optBoolean, new InAppBgColor(str, d));
        Trigger fromJSONObject = Trigger.fromJSONObject(jSONObject.optJSONObject(IterableConstants.ITERABLE_IN_APP_TRIGGER));
        JSONObject optJSONObject4 = jSONObject.optJSONObject(IterableConstants.ITERABLE_IN_APP_CUSTOM_PAYLOAD);
        if (optJSONObject4 == null) {
            optJSONObject4 = optJSONObject.optJSONObject(IterableConstants.ITERABLE_IN_APP_LEGACY_PAYLOAD);
        }
        if (optJSONObject4 == null) {
            optJSONObject4 = new JSONObject();
        }
        IterableInAppMessage iterableInAppMessage = new IterableInAppMessage(optString, new Content(optString2, paddingFromPayload, optDouble, optBoolean, inAppDisplaySettings), optJSONObject4, date, date2, fromJSONObject, Double.valueOf(jSONObject.optDouble(IterableConstants.ITERABLE_IN_APP_PRIORITY_LEVEL, 300.5d)), jSONObject.has(IterableConstants.ITERABLE_IN_APP_SAVE_TO_INBOX) ? Boolean.valueOf(jSONObject.optBoolean(IterableConstants.ITERABLE_IN_APP_SAVE_TO_INBOX)) : null, InboxMetadata.fromJSONObject(jSONObject.optJSONObject(IterableConstants.ITERABLE_IN_APP_INBOX_METADATA)), retrieveValidCampaignIdOrNull);
        iterableInAppMessage.inAppStorageInterface = iterableInAppStorage;
        if (optString2 != null) {
            iterableInAppMessage.setLoadedHtmlFromJson(true);
        }
        iterableInAppMessage.processed = jSONObject.optBoolean(IterableConstants.ITERABLE_IN_APP_PROCESSED, false);
        iterableInAppMessage.consumed = jSONObject.optBoolean("consumed", false);
        iterableInAppMessage.read = jSONObject.optBoolean(IterableConstants.ITERABLE_IN_APP_READ, false);
        return iterableInAppMessage;
    }

    JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.putOpt(IterableConstants.KEY_MESSAGE_ID, this.messageId);
            Long l = this.campaignId;
            if (l != null && IterableUtil.isValidCampaignId(l.longValue())) {
                jSONObject.put(IterableConstants.KEY_CAMPAIGN_ID, this.campaignId);
            }
            Date date = this.createdAt;
            if (date != null) {
                jSONObject.putOpt("createdAt", Long.valueOf(date.getTime()));
            }
            Date date2 = this.expiresAt;
            if (date2 != null) {
                jSONObject.putOpt(IterableConstants.ITERABLE_IN_APP_EXPIRES_AT, Long.valueOf(date2.getTime()));
            }
            jSONObject.putOpt(IterableConstants.ITERABLE_IN_APP_TRIGGER, this.trigger.toJSONObject());
            jSONObject.putOpt(IterableConstants.ITERABLE_IN_APP_PRIORITY_LEVEL, Double.valueOf(this.priorityLevel));
            JSONObject encodePaddingRectToJson = encodePaddingRectToJson(this.content.padding);
            encodePaddingRectToJson.put(IterableConstants.ITERABLE_IN_APP_SHOULD_ANIMATE, this.content.inAppDisplaySettings.shouldAnimate);
            if (this.content.inAppDisplaySettings.inAppBgColor != null && this.content.inAppDisplaySettings.inAppBgColor.bgHexColor != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("alpha", this.content.inAppDisplaySettings.inAppBgColor.bgAlpha);
                jSONObject3.putOpt(IterableConstants.ITERABLE_IN_APP_BGCOLOR_HEX, this.content.inAppDisplaySettings.inAppBgColor.bgHexColor);
                encodePaddingRectToJson.put(IterableConstants.ITERABLE_IN_APP_BGCOLOR, jSONObject3);
            }
            jSONObject2.putOpt(IterableConstants.ITERABLE_IN_APP_DISPLAY_SETTINGS, encodePaddingRectToJson);
            if (this.content.backgroundAlpha != 0.0d) {
                jSONObject2.putOpt(IterableConstants.ITERABLE_IN_APP_BACKGROUND_ALPHA, Double.valueOf(this.content.backgroundAlpha));
            }
            jSONObject.putOpt("content", jSONObject2);
            jSONObject.putOpt(IterableConstants.ITERABLE_IN_APP_CUSTOM_PAYLOAD, this.customPayload);
            Object obj = this.saveToInbox;
            if (obj != null) {
                jSONObject.putOpt(IterableConstants.ITERABLE_IN_APP_SAVE_TO_INBOX, obj);
            }
            InboxMetadata inboxMetadata = this.inboxMetadata;
            if (inboxMetadata != null) {
                jSONObject.putOpt(IterableConstants.ITERABLE_IN_APP_INBOX_METADATA, inboxMetadata.toJSONObject());
            }
            jSONObject.putOpt(IterableConstants.ITERABLE_IN_APP_PROCESSED, Boolean.valueOf(this.processed));
            jSONObject.putOpt("consumed", Boolean.valueOf(this.consumed));
            jSONObject.putOpt(IterableConstants.ITERABLE_IN_APP_READ, Boolean.valueOf(this.read));
        } catch (JSONException e) {
            IterableLogger.e(TAG, "Error while serializing an in-app message", e);
        }
        return jSONObject;
    }

    void setOnChangeListener(OnChangeListener onChangeListener) {
        this.onChangeListener = onChangeListener;
    }

    private void onChanged() {
        OnChangeListener onChangeListener = this.onChangeListener;
        if (onChangeListener != null) {
            onChangeListener.onInAppMessageChanged(this);
        }
    }

    static Rect getPaddingFromPayload(JSONObject jSONObject) {
        Rect rect = new Rect();
        rect.top = decodePadding(jSONObject.optJSONObject(ViewProps.TOP));
        rect.left = decodePadding(jSONObject.optJSONObject(ViewProps.LEFT));
        rect.bottom = decodePadding(jSONObject.optJSONObject(ViewProps.BOTTOM));
        rect.right = decodePadding(jSONObject.optJSONObject(ViewProps.RIGHT));
        return rect;
    }

    static JSONObject encodePaddingRectToJson(Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt(ViewProps.TOP, encodePadding(rect.top));
        jSONObject.putOpt(ViewProps.LEFT, encodePadding(rect.left));
        jSONObject.putOpt(ViewProps.BOTTOM, encodePadding(rect.bottom));
        jSONObject.putOpt(ViewProps.RIGHT, encodePadding(rect.right));
        return jSONObject;
    }

    static int decodePadding(JSONObject jSONObject) {
        if (jSONObject == null) {
            return 0;
        }
        if ("AutoExpand".equalsIgnoreCase(jSONObject.optString("displayOption"))) {
            return -1;
        }
        return jSONObject.optInt("percentage", 0);
    }

    static JSONObject encodePadding(int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (i == -1) {
            jSONObject.putOpt("displayOption", "AutoExpand");
        } else {
            jSONObject.putOpt("percentage", Integer.valueOf(i));
        }
        return jSONObject;
    }
}
