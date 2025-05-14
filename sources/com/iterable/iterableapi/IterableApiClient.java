package com.iterable.iterableapi;

import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import com.google.android.gms.stats.CodePackage;
import com.iterable.iterableapi.IterableHelper;
import com.iterable.iterableapi.IterableInboxSession;
import com.iterable.iterableapi.util.DeviceInfoUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
class IterableApiClient {
    private static final String TAG = "IterableApiClient";
    private final AuthProvider authProvider;
    private RequestProcessor requestProcessor;

    interface AuthProvider {
        String getApiKey();

        String getAuthToken();

        Context getContext();

        String getDeviceId();

        String getEmail();

        String getUserId();

        void resetAuth();
    }

    IterableApiClient(AuthProvider authProvider) {
        this.authProvider = authProvider;
    }

    private RequestProcessor getRequestProcessor() {
        if (this.requestProcessor == null) {
            this.requestProcessor = new OnlineRequestProcessor();
        }
        return this.requestProcessor;
    }

    void setOfflineProcessingEnabled(boolean z) {
        if (z) {
            RequestProcessor requestProcessor = this.requestProcessor;
            if (requestProcessor == null || requestProcessor.getClass() != OfflineRequestProcessor.class) {
                this.requestProcessor = new OfflineRequestProcessor(this.authProvider.getContext());
                return;
            }
            return;
        }
        RequestProcessor requestProcessor2 = this.requestProcessor;
        if (requestProcessor2 == null || requestProcessor2.getClass() != OnlineRequestProcessor.class) {
            this.requestProcessor = new OnlineRequestProcessor();
        }
    }

    void getRemoteConfiguration(IterableHelper.IterableActionHandler iterableActionHandler) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("platform", "Android");
            jSONObject.putOpt(IterableConstants.DEVICE_APP_PACKAGE_NAME, this.authProvider.getContext().getPackageName());
            jSONObject.put(IterableConstants.ITBL_KEY_SDK_VERSION, "3.4.16");
            jSONObject.put("systemVersion", Build.VERSION.RELEASE);
            sendGetRequest(IterableConstants.ENDPOINT_GET_REMOTE_CONFIGURATION, jSONObject, iterableActionHandler);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void track(String str, int i, int i2, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            addEmailOrUserIdToJson(jSONObject2);
            jSONObject2.put(IterableConstants.KEY_EVENT_NAME, str);
            if (i != 0) {
                jSONObject2.put(IterableConstants.KEY_CAMPAIGN_ID, i);
            }
            if (i2 != 0) {
                jSONObject2.put(IterableConstants.KEY_TEMPLATE_ID, i2);
            }
            jSONObject2.put(IterableConstants.KEY_DATA_FIELDS, jSONObject);
            sendPostRequest(IterableConstants.ENDPOINT_TRACK, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void updateCart(List<CommerceItem> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<CommerceItem> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJSONObject());
            }
            JSONObject jSONObject2 = new JSONObject();
            addEmailOrUserIdToJson(jSONObject2);
            jSONObject.put("user", jSONObject2);
            jSONObject.put(IterableConstants.KEY_ITEMS, jSONArray);
            sendPostRequest(IterableConstants.ENDPOINT_UPDATE_CART, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void trackPurchase(double d, List<CommerceItem> list, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<CommerceItem> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJSONObject());
            }
            JSONObject jSONObject3 = new JSONObject();
            addEmailOrUserIdToJson(jSONObject3);
            jSONObject2.put("user", jSONObject3);
            jSONObject2.put(IterableConstants.KEY_ITEMS, jSONArray);
            jSONObject2.put(IterableConstants.KEY_TOTAL, d);
            if (jSONObject != null) {
                jSONObject2.put(IterableConstants.KEY_DATA_FIELDS, jSONObject);
            }
            sendPostRequest(IterableConstants.ENDPOINT_TRACK_PURCHASE, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void updateEmail(String str, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.authProvider.getEmail() != null) {
                jSONObject.put(IterableConstants.KEY_CURRENT_EMAIL, this.authProvider.getEmail());
            } else {
                jSONObject.put(IterableConstants.KEY_CURRENT_USERID, this.authProvider.getUserId());
            }
            jSONObject.put(IterableConstants.KEY_NEW_EMAIL, str);
            sendPostRequest(IterableConstants.ENDPOINT_UPDATE_EMAIL, jSONObject, successHandler, failureHandler);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(JSONObject jSONObject, Boolean bool) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            addEmailOrUserIdToJson(jSONObject2);
            if (this.authProvider.getEmail() == null && this.authProvider.getUserId() != null) {
                jSONObject2.put(IterableConstants.KEY_PREFER_USER_ID, true);
            }
            jSONObject2.put(IterableConstants.KEY_DATA_FIELDS, jSONObject);
            jSONObject2.put(IterableConstants.KEY_MERGE_NESTED_OBJECTS, bool);
            sendPostRequest(IterableConstants.ENDPOINT_UPDATE_USER, jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void updateSubscriptions(Integer[] numArr, Integer[] numArr2, Integer[] numArr3, Integer[] numArr4, Integer num, Integer num2) {
        JSONObject jSONObject = new JSONObject();
        addEmailOrUserIdToJson(jSONObject);
        tryAddArrayToJSON(jSONObject, IterableConstants.KEY_EMAIL_LIST_IDS, numArr);
        tryAddArrayToJSON(jSONObject, IterableConstants.KEY_UNSUB_CHANNEL, numArr2);
        tryAddArrayToJSON(jSONObject, IterableConstants.KEY_UNSUB_MESSAGE, numArr3);
        tryAddArrayToJSON(jSONObject, IterableConstants.KEY_SUB_MESSAGE, numArr4);
        if (num != null) {
            try {
                if (num.intValue() != 0) {
                    jSONObject.putOpt(IterableConstants.KEY_CAMPAIGN_ID, num);
                }
            } catch (JSONException e) {
                IterableLogger.e(TAG, e.toString());
            }
        }
        if (num2 != null && num2.intValue() != 0) {
            jSONObject.putOpt(IterableConstants.KEY_TEMPLATE_ID, num2);
        }
        sendPostRequest(IterableConstants.ENDPOINT_UPDATE_USER_SUBS, jSONObject);
    }

    public void getInAppMessages(int i, IterableHelper.IterableActionHandler iterableActionHandler) {
        JSONObject jSONObject = new JSONObject();
        addEmailOrUserIdToJson(jSONObject);
        try {
            addEmailOrUserIdToJson(jSONObject);
            jSONObject.put("count", i);
            jSONObject.put("platform", DeviceInfoUtils.isFireTV(this.authProvider.getContext().getPackageManager()) ? IterableConstants.ITBL_PLATFORM_OTT : "Android");
            jSONObject.put(IterableConstants.ITBL_KEY_SDK_VERSION, "3.4.16");
            jSONObject.put("systemVersion", Build.VERSION.RELEASE);
            jSONObject.put("packageName", this.authProvider.getContext().getPackageName());
            sendGetRequest(IterableConstants.ENDPOINT_GET_INAPP_MESSAGES, jSONObject, iterableActionHandler);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void trackInAppOpen(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            addEmailOrUserIdToJson(jSONObject);
            jSONObject.put(IterableConstants.KEY_MESSAGE_ID, str);
            sendPostRequest(IterableConstants.ENDPOINT_TRACK_INAPP_OPEN, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void trackInAppOpen(IterableInAppMessage iterableInAppMessage, IterableInAppLocation iterableInAppLocation, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            addEmailOrUserIdToJson(jSONObject);
            jSONObject.put(IterableConstants.KEY_MESSAGE_ID, iterableInAppMessage.getMessageId());
            jSONObject.put(IterableConstants.KEY_MESSAGE_CONTEXT, getInAppMessageContext(iterableInAppMessage, iterableInAppLocation));
            jSONObject.put(IterableConstants.KEY_DEVICE_INFO, getDeviceInfoJson());
            if (iterableInAppLocation == IterableInAppLocation.INBOX) {
                addInboxSessionID(jSONObject, str);
            }
            sendPostRequest(IterableConstants.ENDPOINT_TRACK_INAPP_OPEN, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void trackInAppClick(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            addEmailOrUserIdToJson(jSONObject);
            jSONObject.put(IterableConstants.KEY_MESSAGE_ID, str);
            jSONObject.put(IterableConstants.ITERABLE_IN_APP_CLICKED_URL, str2);
            sendPostRequest(IterableConstants.ENDPOINT_TRACK_INAPP_CLICK, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void trackInAppClick(IterableInAppMessage iterableInAppMessage, String str, IterableInAppLocation iterableInAppLocation, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            addEmailOrUserIdToJson(jSONObject);
            jSONObject.put(IterableConstants.KEY_MESSAGE_ID, iterableInAppMessage.getMessageId());
            jSONObject.put(IterableConstants.ITERABLE_IN_APP_CLICKED_URL, str);
            jSONObject.put(IterableConstants.KEY_MESSAGE_CONTEXT, getInAppMessageContext(iterableInAppMessage, iterableInAppLocation));
            jSONObject.put(IterableConstants.KEY_DEVICE_INFO, getDeviceInfoJson());
            if (iterableInAppLocation == IterableInAppLocation.INBOX) {
                addInboxSessionID(jSONObject, str2);
            }
            sendPostRequest(IterableConstants.ENDPOINT_TRACK_INAPP_CLICK, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    void trackInAppClose(IterableInAppMessage iterableInAppMessage, String str, IterableInAppCloseAction iterableInAppCloseAction, IterableInAppLocation iterableInAppLocation, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            addEmailOrUserIdToJson(jSONObject);
            jSONObject.put(IterableConstants.KEY_MESSAGE_ID, iterableInAppMessage.getMessageId());
            jSONObject.putOpt(IterableConstants.ITERABLE_IN_APP_CLICKED_URL, str);
            jSONObject.put(IterableConstants.ITERABLE_IN_APP_CLOSE_ACTION, iterableInAppCloseAction.toString());
            jSONObject.put(IterableConstants.KEY_MESSAGE_CONTEXT, getInAppMessageContext(iterableInAppMessage, iterableInAppLocation));
            jSONObject.put(IterableConstants.KEY_DEVICE_INFO, getDeviceInfoJson());
            if (iterableInAppLocation == IterableInAppLocation.INBOX) {
                addInboxSessionID(jSONObject, str2);
            }
            sendPostRequest(IterableConstants.ENDPOINT_TRACK_INAPP_CLOSE, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    void trackInAppDelivery(IterableInAppMessage iterableInAppMessage) {
        JSONObject jSONObject = new JSONObject();
        try {
            addEmailOrUserIdToJson(jSONObject);
            jSONObject.put(IterableConstants.KEY_MESSAGE_ID, iterableInAppMessage.getMessageId());
            jSONObject.put(IterableConstants.KEY_MESSAGE_CONTEXT, getInAppMessageContext(iterableInAppMessage, null));
            jSONObject.put(IterableConstants.KEY_DEVICE_INFO, getDeviceInfoJson());
            sendPostRequest(IterableConstants.ENDPOINT_TRACK_INAPP_DELIVERY, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void inAppConsume(IterableInAppMessage iterableInAppMessage, IterableInAppDeleteActionType iterableInAppDeleteActionType, IterableInAppLocation iterableInAppLocation, String str, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        JSONObject jSONObject = new JSONObject();
        try {
            addEmailOrUserIdToJson(jSONObject);
            jSONObject.put(IterableConstants.KEY_MESSAGE_ID, iterableInAppMessage.getMessageId());
            if (iterableInAppDeleteActionType != null) {
                jSONObject.put(IterableConstants.ITERABLE_IN_APP_DELETE_ACTION, iterableInAppDeleteActionType.toString());
            }
            if (iterableInAppLocation != null) {
                jSONObject.put(IterableConstants.KEY_MESSAGE_CONTEXT, getInAppMessageContext(iterableInAppMessage, iterableInAppLocation));
                jSONObject.put(IterableConstants.KEY_DEVICE_INFO, getDeviceInfoJson());
            }
            if (iterableInAppLocation == IterableInAppLocation.INBOX) {
                addInboxSessionID(jSONObject, str);
            }
            sendPostRequest(IterableConstants.ENDPOINT_INAPP_CONSUME, jSONObject, successHandler, failureHandler);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void trackInboxSession(IterableInboxSession iterableInboxSession, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            addEmailOrUserIdToJson(jSONObject);
            jSONObject.put(IterableConstants.ITERABLE_INBOX_SESSION_START, iterableInboxSession.sessionStartTime.getTime());
            jSONObject.put(IterableConstants.ITERABLE_INBOX_SESSION_END, iterableInboxSession.sessionEndTime.getTime());
            jSONObject.put(IterableConstants.ITERABLE_INBOX_START_TOTAL_MESSAGE_COUNT, iterableInboxSession.startTotalMessageCount);
            jSONObject.put(IterableConstants.ITERABLE_INBOX_START_UNREAD_MESSAGE_COUNT, iterableInboxSession.startUnreadMessageCount);
            jSONObject.put(IterableConstants.ITERABLE_INBOX_END_TOTAL_MESSAGE_COUNT, iterableInboxSession.endTotalMessageCount);
            jSONObject.put(IterableConstants.ITERABLE_INBOX_END_UNREAD_MESSAGE_COUNT, iterableInboxSession.endUnreadMessageCount);
            if (iterableInboxSession.impressions != null) {
                JSONArray jSONArray = new JSONArray();
                for (IterableInboxSession.Impression impression : iterableInboxSession.impressions) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(IterableConstants.KEY_MESSAGE_ID, impression.messageId);
                    jSONObject2.put(IterableConstants.ITERABLE_IN_APP_SILENT_INBOX, impression.silentInbox);
                    jSONObject2.put(IterableConstants.ITERABLE_INBOX_IMP_DISPLAY_COUNT, impression.displayCount);
                    jSONObject2.put(IterableConstants.ITERABLE_INBOX_IMP_DISPLAY_DURATION, impression.duration);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put(IterableConstants.ITERABLE_INBOX_IMPRESSIONS, jSONArray);
            }
            jSONObject.putOpt(IterableConstants.KEY_DEVICE_INFO, getDeviceInfoJson());
            addInboxSessionID(jSONObject, str);
            sendPostRequest(IterableConstants.ENDPOINT_TRACK_INBOX_SESSION, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected void trackPushOpen(int i, int i2, String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        addEmailOrUserIdToJson(jSONObject2);
        jSONObject2.put(IterableConstants.KEY_CAMPAIGN_ID, i);
        jSONObject2.put(IterableConstants.KEY_TEMPLATE_ID, i2);
        jSONObject2.put(IterableConstants.KEY_MESSAGE_ID, str);
        jSONObject2.putOpt(IterableConstants.KEY_DATA_FIELDS, jSONObject);
        sendPostRequest(IterableConstants.ENDPOINT_TRACK_PUSH_OPEN, jSONObject2);
    }

    protected void disableToken(String str, String str2, String str3, String str4, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IterableConstants.KEY_TOKEN, str4);
            if (str != null) {
                jSONObject.put("email", str);
            } else if (str2 != null) {
                jSONObject.put(IterableConstants.KEY_USER_ID, str2);
            }
            sendPostRequest(IterableConstants.ENDPOINT_DISABLE_DEVICE, jSONObject, str3, successHandler, failureHandler);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected void registerDeviceToken(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject, HashMap<String, String> hashMap, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        Context context = this.authProvider.getContext();
        JSONObject jSONObject2 = new JSONObject();
        try {
            addEmailOrUserIdToJson(jSONObject2);
            JSONObject jSONObject3 = jSONObject == null ? new JSONObject() : jSONObject;
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                jSONObject3.put(entry.getKey(), entry.getValue());
            }
            jSONObject3.put(IterableConstants.FIREBASE_TOKEN_TYPE, "FCM");
            jSONObject3.put(IterableConstants.FIREBASE_COMPATIBLE, true);
            DeviceInfoUtils.populateDeviceDetails(jSONObject3, context, this.authProvider.getDeviceId());
            jSONObject3.put(IterableConstants.DEVICE_NOTIFICATIONS_ENABLED, NotificationManagerCompat.from(context).areNotificationsEnabled());
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(IterableConstants.KEY_TOKEN, str5);
            jSONObject4.put("platform", CodePackage.GCM);
            jSONObject4.put(IterableConstants.KEY_APPLICATION_NAME, str4);
            jSONObject4.putOpt(IterableConstants.KEY_DATA_FIELDS, jSONObject3);
            jSONObject2.put("device", jSONObject4);
            if (str == null && str2 != null) {
                jSONObject2.put(IterableConstants.KEY_PREFER_USER_ID, true);
            }
            sendPostRequest(IterableConstants.ENDPOINT_REGISTER_DEVICE_TOKEN, jSONObject2, str3, successHandler, failureHandler);
        } catch (JSONException e) {
            IterableLogger.e(TAG, "registerDeviceToken: exception", e);
        }
    }

    private void addEmailOrUserIdToJson(JSONObject jSONObject) {
        try {
            if (this.authProvider.getEmail() != null) {
                jSONObject.put("email", this.authProvider.getEmail());
            } else {
                jSONObject.put(IterableConstants.KEY_USER_ID, this.authProvider.getUserId());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void addInboxSessionID(JSONObject jSONObject, String str) throws JSONException {
        if (str != null) {
            jSONObject.put(IterableConstants.KEY_INBOX_SESSION_ID, str);
        }
    }

    private JSONObject getInAppMessageContext(IterableInAppMessage iterableInAppMessage, IterableInAppLocation iterableInAppLocation) {
        JSONObject jSONObject = new JSONObject();
        try {
            boolean isSilentInboxMessage = iterableInAppMessage.isSilentInboxMessage();
            jSONObject.putOpt(IterableConstants.ITERABLE_IN_APP_SAVE_TO_INBOX, Boolean.valueOf(iterableInAppMessage.isInboxMessage()));
            jSONObject.putOpt(IterableConstants.ITERABLE_IN_APP_SILENT_INBOX, Boolean.valueOf(isSilentInboxMessage));
            if (iterableInAppLocation != null) {
                jSONObject.putOpt(IterableConstants.ITERABLE_IN_APP_LOCATION, iterableInAppLocation.toString());
            }
        } catch (Exception e) {
            IterableLogger.e(TAG, "Could not populate messageContext JSON", e);
        }
        return jSONObject;
    }

    private JSONObject getDeviceInfoJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(IterableConstants.DEVICE_ID, this.authProvider.getDeviceId());
            jSONObject.putOpt("platform", "Android");
            jSONObject.putOpt(IterableConstants.DEVICE_APP_PACKAGE_NAME, this.authProvider.getContext().getPackageName());
        } catch (Exception e) {
            IterableLogger.e(TAG, "Could not populate deviceInfo JSON", e);
        }
        return jSONObject;
    }

    void tryAddArrayToJSON(JSONObject jSONObject, String str, Object[] objArr) {
        if (jSONObject == null || str == null || objArr == null) {
            return;
        }
        try {
            jSONObject.put(str, new JSONArray((Collection) Arrays.asList(objArr)));
        } catch (JSONException e) {
            IterableLogger.e(TAG, e.toString());
        }
    }

    void sendPostRequest(String str, JSONObject jSONObject) {
        sendPostRequest(str, jSONObject, this.authProvider.getAuthToken());
    }

    void sendPostRequest(String str, JSONObject jSONObject, String str2) {
        sendPostRequest(str, jSONObject, str2, null, null);
    }

    void sendPostRequest(String str, JSONObject jSONObject, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        sendPostRequest(str, jSONObject, this.authProvider.getAuthToken(), successHandler, failureHandler);
    }

    void sendPostRequest(String str, JSONObject jSONObject, String str2, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        getRequestProcessor().processPostRequest(this.authProvider.getApiKey(), str, jSONObject, str2, successHandler, failureHandler);
    }

    void sendGetRequest(String str, JSONObject jSONObject, IterableHelper.IterableActionHandler iterableActionHandler) {
        getRequestProcessor().processGetRequest(this.authProvider.getApiKey(), str, jSONObject, this.authProvider.getAuthToken(), iterableActionHandler);
    }

    void onLogout() {
        getRequestProcessor().onLogout(this.authProvider.getContext());
        this.authProvider.resetAuth();
    }
}
