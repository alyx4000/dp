package com.iterable.iterableapi;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
class IterableNotificationData {
    static final String TAG = "IterableNoticationData";
    private List<Button> actionButtons;
    private int campaignId;
    private IterableAction defaultAction;
    private boolean isGhostPush;
    private String messageId;
    private int templateId;

    IterableNotificationData(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.campaignId = jSONObject.optInt(IterableConstants.KEY_CAMPAIGN_ID);
            this.templateId = jSONObject.optInt(IterableConstants.KEY_TEMPLATE_ID);
            this.messageId = jSONObject.optString(IterableConstants.KEY_MESSAGE_ID);
            this.isGhostPush = jSONObject.optBoolean(IterableConstants.IS_GHOST_PUSH);
            this.defaultAction = IterableAction.from(jSONObject.optJSONObject(IterableConstants.ITERABLE_DATA_DEFAULT_ACTION));
            JSONArray optJSONArray = jSONObject.optJSONArray(IterableConstants.ITERABLE_DATA_ACTION_BUTTONS);
            if (optJSONArray != null) {
                this.actionButtons = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.actionButtons.add(new Button(optJSONArray.getJSONObject(i)));
                }
            }
        } catch (JSONException e) {
            IterableLogger.e(TAG, e.toString());
        }
    }

    IterableNotificationData(Bundle bundle) {
        this(bundle.getString(IterableConstants.ITERABLE_DATA_KEY));
    }

    public int getCampaignId() {
        return this.campaignId;
    }

    public int getTemplateId() {
        return this.templateId;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public boolean getIsGhostPush() {
        return this.isGhostPush;
    }

    public IterableAction getDefaultAction() {
        return this.defaultAction;
    }

    public List<Button> getActionButtons() {
        return this.actionButtons;
    }

    public Button getActionButton(String str) {
        for (Button button : this.actionButtons) {
            if (button.identifier.equals(str)) {
                return button;
            }
        }
        return null;
    }

    public static class Button {
        public static final String BUTTON_TYPE_DEFAULT = "default";
        public static final String BUTTON_TYPE_DESTRUCTIVE = "destructive";
        public static final String BUTTON_TYPE_TEXT_INPUT = "textInput";
        public final IterableAction action;
        public final int buttonIcon;
        public final String buttonType;
        public final String identifier;
        public final String inputPlaceholder;
        public final String inputTitle;
        public final boolean openApp;
        public final boolean requiresUnlock;
        public final String title;

        Button(JSONObject jSONObject) {
            this.identifier = jSONObject.optString("identifier");
            this.title = jSONObject.optString("title");
            this.buttonType = jSONObject.optString(IterableConstants.ITBL_BUTTON_TYPE, "default");
            this.openApp = jSONObject.optBoolean(IterableConstants.ITBL_BUTTON_OPEN_APP, true);
            this.requiresUnlock = jSONObject.optBoolean(IterableConstants.ITBL_BUTTON_REQUIRES_UNLOCK, true);
            this.buttonIcon = jSONObject.optInt("icon", 0);
            this.inputPlaceholder = jSONObject.optString(IterableConstants.ITBL_BUTTON_INPUT_PLACEHOLDER);
            this.inputTitle = jSONObject.optString(IterableConstants.ITBL_BUTTON_INPUT_TITLE);
            this.action = IterableAction.from(jSONObject.optJSONObject("action"));
        }
    }
}
