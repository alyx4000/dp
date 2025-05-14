package com.iterable.reactnative;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.iterable.iterableapi.InboxSessionManager;
import com.iterable.iterableapi.IterableAction;
import com.iterable.iterableapi.IterableActionContext;
import com.iterable.iterableapi.IterableApi;
import com.iterable.iterableapi.IterableAttributionInfo;
import com.iterable.iterableapi.IterableAuthHandler;
import com.iterable.iterableapi.IterableConfig;
import com.iterable.iterableapi.IterableCustomActionHandler;
import com.iterable.iterableapi.IterableHelper;
import com.iterable.iterableapi.IterableInAppCloseAction;
import com.iterable.iterableapi.IterableInAppHandler;
import com.iterable.iterableapi.IterableInAppLocation;
import com.iterable.iterableapi.IterableInAppManager;
import com.iterable.iterableapi.IterableInAppMessage;
import com.iterable.iterableapi.IterableLogger;
import com.iterable.iterableapi.IterableUrlHandler;
import com.iterable.iterableapi.RNIterableInternal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class RNIterableAPIModule extends ReactContextBaseJavaModule implements IterableUrlHandler, IterableCustomActionHandler, IterableInAppHandler, IterableAuthHandler, IterableInAppManager.Listener {
    private static String TAG = "RNIterableAPIModule";
    private CountDownLatch authHandlerCallbackLatch;
    private IterableInAppHandler.InAppResponse inAppResponse;
    private CountDownLatch jsCallBackLatch;
    private String passedAuthToken;
    private final ReactApplicationContext reactContext;
    private final InboxSessionManager sessionManager;

    @ReactMethod
    public void addListener(String str) {
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNIterableAPI";
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public RNIterableAPIModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.inAppResponse = IterableInAppHandler.InAppResponse.SHOW;
        this.passedAuthToken = null;
        this.sessionManager = new InboxSessionManager();
        this.reactContext = reactApplicationContext;
    }

    @ReactMethod
    public void initializeWithApiKey(String str, ReadableMap readableMap, String str2, Promise promise) {
        IterableLogger.d(TAG, "initializeWithApiKey: " + str);
        IterableConfig.Builder configFromReadableMap = Serialization.getConfigFromReadableMap(readableMap);
        if (readableMap.hasKey("urlHandlerPresent") && readableMap.getBoolean("urlHandlerPresent")) {
            configFromReadableMap.setUrlHandler(this);
        }
        if (readableMap.hasKey("customActionHandlerPresent") && readableMap.getBoolean("customActionHandlerPresent")) {
            configFromReadableMap.setCustomActionHandler(this);
        }
        if (readableMap.hasKey("inAppHandlerPresent") && readableMap.getBoolean("inAppHandlerPresent")) {
            configFromReadableMap.setInAppHandler(this);
        }
        if (readableMap.hasKey("authHandlerPresent") && readableMap.getBoolean("authHandlerPresent")) {
            configFromReadableMap.setAuthHandler(this);
        }
        IterableApi.initialize(this.reactContext, str, configFromReadableMap.build());
        IterableApi.getInstance().setDeviceAttribute("reactNativeSDKVersion", str2);
        IterableApi.getInstance().getInAppManager().addListener(this);
        promise.resolve(true);
    }

    @ReactMethod
    public void setEmail(String str) {
        IterableLogger.d(TAG, "setEmail: " + str);
        IterableApi.getInstance().setEmail(str);
    }

    @ReactMethod
    public void setEmail(String str, String str2) {
        IterableLogger.d(TAG, "setEmail: " + str + " authToken: " + str2);
        IterableApi.getInstance().setEmail(str, str2);
    }

    @ReactMethod
    public void updateEmail(String str) {
        IterableLogger.d(TAG, "updateEmail: " + str);
        IterableApi.getInstance().updateEmail(str);
    }

    @ReactMethod
    public void updateEmail(String str, String str2) {
        IterableLogger.d(TAG, "updateEmail: " + str + " authToken: " + str2);
        IterableApi.getInstance().updateEmail(str, str2);
    }

    @ReactMethod
    public void getEmail(Promise promise) {
        promise.resolve(RNIterableInternal.getEmail());
    }

    @ReactMethod
    public void sampleMethod(String str, int i, Callback callback) {
        callback.invoke("Received numberArgument: " + i + " stringArgument: " + str);
    }

    @ReactMethod
    public void setUserId(String str) {
        IterableLogger.d(TAG, "setUserId: " + str);
        IterableApi.getInstance().setUserId(str);
    }

    @ReactMethod
    public void setUserId(String str, String str2) {
        IterableLogger.d(TAG, "setUserId: " + str + " authToken: " + str2);
        IterableApi.getInstance().setUserId(str, str2);
    }

    @ReactMethod
    public void updateUser(ReadableMap readableMap, Boolean bool) {
        IterableLogger.v(TAG, "updateUser");
        IterableApi.getInstance().updateUser(optSerializedDataFields(readableMap), bool);
    }

    @ReactMethod
    public void getUserId(Promise promise) {
        promise.resolve(RNIterableInternal.getUserId());
    }

    @ReactMethod
    public void trackEvent(String str, ReadableMap readableMap) {
        IterableLogger.v(TAG, "trackEvent");
        IterableApi.getInstance().track(str, optSerializedDataFields(readableMap));
    }

    @ReactMethod
    public void updateCart(ReadableArray readableArray) {
        IterableLogger.v(TAG, "updateCart");
        IterableApi.getInstance().updateCart(Serialization.commerceItemsFromReadableArray(readableArray));
    }

    @ReactMethod
    public void trackPurchase(Double d, ReadableArray readableArray, ReadableMap readableMap) {
        IterableLogger.v(TAG, "trackPurchase");
        IterableApi.getInstance().trackPurchase(d.doubleValue(), Serialization.commerceItemsFromReadableArray(readableArray), optSerializedDataFields(readableMap));
    }

    @ReactMethod
    public void trackPushOpenWithCampaignId(Integer num, Integer num2, String str, Boolean bool, ReadableMap readableMap) {
        RNIterableInternal.trackPushOpenWithCampaignId(num, num2, str, optSerializedDataFields(readableMap));
    }

    @ReactMethod
    public void updateSubscriptions(ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3, ReadableArray readableArray4, Integer num, Integer num2) {
        IterableLogger.v(TAG, "updateSubscriptions");
        IterableApi.getInstance().updateSubscriptions(readableArrayToIntegerArray(readableArray), readableArrayToIntegerArray(readableArray2), readableArrayToIntegerArray(readableArray3), readableArrayToIntegerArray(readableArray4), num.intValue() > 0 ? num : null, num2.intValue() > 0 ? num2 : null);
    }

    @ReactMethod
    public void showMessage(String str, boolean z, final Promise promise) {
        if (str == null || str == "") {
            promise.reject("", "messageId is null or empty");
        } else {
            IterableApi.getInstance().getInAppManager().showMessage(RNIterableInternal.getMessageById(str), z, new IterableHelper.IterableUrlCallback() { // from class: com.iterable.reactnative.RNIterableAPIModule.1
                @Override // com.iterable.iterableapi.IterableHelper.IterableUrlCallback
                public void execute(Uri uri) {
                    promise.resolve(uri.toString());
                }
            });
        }
    }

    @ReactMethod
    public void setReadForMessage(String str, boolean z) {
        IterableLogger.v(TAG, "setReadForMessage");
        IterableApi.getInstance().getInAppManager().setRead(RNIterableInternal.getMessageById(str), z);
    }

    @ReactMethod
    public void removeMessage(String str, Integer num, Integer num2) {
        IterableLogger.v(TAG, "removeMessage");
        IterableApi.getInstance().getInAppManager().removeMessage(RNIterableInternal.getMessageById(str), Serialization.getIterableDeleteActionTypeFromInteger(num2), Serialization.getIterableInAppLocationFromInteger(num));
    }

    @ReactMethod
    public void getHtmlInAppContentForMessage(String str, Promise promise) {
        IterableLogger.printInfo();
        IterableInAppMessage messageById = RNIterableInternal.getMessageById(str);
        if (messageById == null) {
            promise.reject("", "Could not find message with id: " + str);
            return;
        }
        JSONObject messageContentToJsonObject = Serialization.messageContentToJsonObject(messageById.getContent());
        if (messageContentToJsonObject == null) {
            promise.reject("", "messageContent is null for message id: " + str);
            return;
        }
        try {
            promise.resolve(Serialization.convertJsonToMap(messageContentToJsonObject));
        } catch (JSONException unused) {
            promise.reject("", "Failed to convert JSONObject to ReadableMap");
        }
    }

    @ReactMethod
    public void getAttributionInfo(Promise promise) {
        IterableLogger.printInfo();
        IterableAttributionInfo attributionInfo = IterableApi.getInstance().getAttributionInfo();
        if (attributionInfo != null) {
            try {
                promise.resolve(Serialization.convertJsonToMap(attributionInfo.toJSONObject()));
                return;
            } catch (JSONException unused) {
                IterableLogger.e(TAG, "Failed converting attribution info to JSONObject");
                promise.reject("", "Failed to convert AttributionInfo to ReadableMap");
                return;
            }
        }
        promise.resolve(null);
    }

    @ReactMethod
    public void setAttributionInfo(ReadableMap readableMap) {
        IterableLogger.printInfo();
        try {
            RNIterableInternal.setAttributionInfo(IterableAttributionInfo.fromJSONObject(Serialization.convertMapToJson(readableMap)));
        } catch (JSONException unused) {
            IterableLogger.e(TAG, "Failed converting ReadableMap to JSON");
        }
    }

    @ReactMethod
    public void getLastPushPayload(Promise promise) {
        if (IterableApi.getInstance().getPayloadData() != null) {
            promise.resolve(Arguments.fromBundle(IterableApi.getInstance().getPayloadData()));
        } else {
            IterableLogger.d(TAG, "No payload data found");
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void disableDeviceForCurrentUser() {
        IterableLogger.v(TAG, "disableDevice");
        IterableApi.getInstance().disablePush();
    }

    @ReactMethod
    public void handleAppLink(String str, Promise promise) {
        IterableLogger.printInfo();
        promise.resolve(Boolean.valueOf(IterableApi.getInstance().handleAppLink(str)));
    }

    @ReactMethod
    public void trackInAppOpen(String str, Integer num) {
        IterableInAppMessage messageById = RNIterableInternal.getMessageById(str);
        if (messageById == null) {
            IterableLogger.d(TAG, "Failed to get in-app for message ID: " + str);
        } else {
            IterableApi.getInstance().trackInAppOpen(messageById, Serialization.getIterableInAppLocationFromInteger(num));
        }
    }

    @ReactMethod
    public void trackInAppClick(String str, Integer num, String str2) {
        IterableInAppMessage messageById = RNIterableInternal.getMessageById(str);
        IterableInAppLocation iterableInAppLocationFromInteger = Serialization.getIterableInAppLocationFromInteger(num);
        if (messageById == null) {
            IterableLogger.d(TAG, "Failed to get in-app for message ID: " + str);
            return;
        }
        if (str2 == null) {
            IterableLogger.d(TAG, "clickedUrl is null");
        } else if (iterableInAppLocationFromInteger == null) {
            IterableLogger.d(TAG, "in-app open location is null");
        } else {
            IterableApi.getInstance().trackInAppClick(messageById, str2, iterableInAppLocationFromInteger);
        }
    }

    @ReactMethod
    public void trackInAppClose(String str, Integer num, Integer num2, String str2) {
        IterableInAppMessage messageById = RNIterableInternal.getMessageById(str);
        IterableInAppLocation iterableInAppLocationFromInteger = Serialization.getIterableInAppLocationFromInteger(num);
        IterableInAppCloseAction iterableInAppCloseSourceFromInteger = Serialization.getIterableInAppCloseSourceFromInteger(num2);
        if (messageById == null) {
            IterableLogger.d(TAG, "Failed to get in-app for message ID: " + str);
            return;
        }
        if (iterableInAppLocationFromInteger == null) {
            IterableLogger.d(TAG, "in-app close location is null");
        } else if (iterableInAppCloseSourceFromInteger == null) {
            IterableLogger.d(TAG, "in-app close action is null");
        } else {
            IterableApi.getInstance().trackInAppClose(messageById, str2, iterableInAppCloseSourceFromInteger, iterableInAppLocationFromInteger);
        }
    }

    @ReactMethod
    public void inAppConsume(String str, Integer num, Integer num2) {
        if (str == null) {
            return;
        }
        IterableApi.getInstance().inAppConsume(RNIterableInternal.getMessageById(str), Serialization.getIterableDeleteActionTypeFromInteger(num2), Serialization.getIterableInAppLocationFromInteger(num));
    }

    @ReactMethod
    public void getInAppMessages(Promise promise) {
        IterableLogger.d(TAG, "getMessages");
        try {
            promise.resolve(Serialization.convertJsonToArray(Serialization.serializeInAppMessages(IterableApi.getInstance().getInAppManager().getMessages())));
        } catch (JSONException e) {
            IterableLogger.e(TAG, e.getLocalizedMessage());
            promise.reject("", "Failed to fetch messages with error " + e.getLocalizedMessage());
        }
    }

    @ReactMethod
    public void getInboxMessages(Promise promise) {
        IterableLogger.d(TAG, "getInboxMessages");
        try {
            promise.resolve(Serialization.convertJsonToArray(Serialization.serializeInAppMessages(IterableApi.getInstance().getInAppManager().getInboxMessages())));
        } catch (JSONException e) {
            IterableLogger.e(TAG, e.getLocalizedMessage());
            promise.reject("", "Failed to fetch messages with error " + e.getLocalizedMessage());
        }
    }

    @ReactMethod
    public void setInAppShowResponse(Integer num) {
        IterableLogger.printInfo();
        this.inAppResponse = Serialization.getInAppResponse(num);
        CountDownLatch countDownLatch = this.jsCallBackLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    @ReactMethod
    public void setAutoDisplayPaused(final boolean z) {
        IterableLogger.printInfo();
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.iterable.reactnative.RNIterableAPIModule.2
            @Override // java.lang.Runnable
            public void run() {
                IterableApi.getInstance().getInAppManager().setAutoDisplayPaused(z);
            }
        });
    }

    @ReactMethod
    public void wakeApp() {
        Intent mainActivityIntent = getMainActivityIntent(this.reactContext);
        mainActivityIntent.setFlags(872415232);
        if (mainActivityIntent.resolveActivity(this.reactContext.getPackageManager()) != null) {
            this.reactContext.startActivity(mainActivityIntent);
        }
    }

    public Intent getMainActivityIntent(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intent launchIntentForPackage = applicationContext.getPackageManager().getLaunchIntentForPackage(applicationContext.getPackageName());
        if (launchIntentForPackage != null) {
            return launchIntentForPackage;
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(applicationContext.getPackageName());
        return intent;
    }

    @ReactMethod
    public void startSession(ReadableArray readableArray) {
        this.sessionManager.startSession(Serialization.impressionsFromReadableArray(readableArray));
    }

    @ReactMethod
    public void endSession() {
        this.sessionManager.endSession();
    }

    @ReactMethod
    public void updateVisibleRows(ReadableArray readableArray) {
        this.sessionManager.updateVisibleRows(Serialization.impressionsFromReadableArray(readableArray));
    }

    private static Integer[] readableArrayToIntegerArray(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        Integer[] numArr = new Integer[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            numArr[i] = Integer.valueOf(readableArray.getInt(i));
        }
        return numArr;
    }

    private static JSONObject optSerializedDataFields(ReadableMap readableMap) {
        if (readableMap != null) {
            try {
                return Serialization.convertMapToJson(readableMap);
            } catch (JSONException unused) {
                IterableLogger.d(TAG, "Failed to convert dataFields to JSON");
            }
        }
        return null;
    }

    @Override // com.iterable.iterableapi.IterableCustomActionHandler
    public boolean handleIterableCustomAction(IterableAction iterableAction, IterableActionContext iterableActionContext) {
        IterableLogger.printInfo();
        JSONObject actionToJson = Serialization.actionToJson(iterableAction);
        JSONObject actionContextToJson = Serialization.actionContextToJson(iterableActionContext);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", actionToJson);
            jSONObject.put("context", actionContextToJson);
            sendEvent(EventName.handleCustomActionCalled.name(), Serialization.convertJsonToMap(jSONObject));
            return false;
        } catch (JSONException unused) {
            IterableLogger.e(TAG, "Failed handling custom action");
            return false;
        }
    }

    @Override // com.iterable.iterableapi.IterableInAppHandler
    public IterableInAppHandler.InAppResponse onNewInApp(IterableInAppMessage iterableInAppMessage) {
        IterableLogger.printInfo();
        try {
            WritableMap convertJsonToMap = Serialization.convertJsonToMap(RNIterableInternal.getInAppMessageJson(iterableInAppMessage));
            this.jsCallBackLatch = new CountDownLatch(1);
            sendEvent(EventName.handleInAppCalled.name(), convertJsonToMap);
            this.jsCallBackLatch.await(2L, TimeUnit.SECONDS);
            this.jsCallBackLatch = null;
            return this.inAppResponse;
        } catch (InterruptedException | JSONException unused) {
            IterableLogger.e(TAG, "new in-app module failed");
            return IterableInAppHandler.InAppResponse.SHOW;
        }
    }

    @Override // com.iterable.iterableapi.IterableUrlHandler
    public boolean handleIterableURL(Uri uri, IterableActionContext iterableActionContext) {
        IterableLogger.printInfo();
        JSONObject actionContextToJson = Serialization.actionContextToJson(iterableActionContext);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", uri.toString());
            jSONObject.put("context", actionContextToJson);
            sendEvent(EventName.handleUrlCalled.name(), Serialization.convertJsonToMap(jSONObject));
            return true;
        } catch (JSONException e) {
            IterableLogger.e(TAG, e.getLocalizedMessage());
            return true;
        }
    }

    @Override // com.iterable.iterableapi.IterableAuthHandler
    public String onAuthTokenRequested() {
        IterableLogger.printInfo();
        try {
            this.authHandlerCallbackLatch = new CountDownLatch(1);
            sendEvent(EventName.handleAuthCalled.name(), null);
            this.authHandlerCallbackLatch.await(30L, TimeUnit.SECONDS);
            this.authHandlerCallbackLatch = null;
            return this.passedAuthToken;
        } catch (InterruptedException unused) {
            IterableLogger.e(TAG, "auth handler module failed");
            return null;
        }
    }

    @Override // com.iterable.iterableapi.IterableAuthHandler
    public void onTokenRegistrationSuccessful(String str) {
        IterableLogger.v(TAG, "authToken successfully set");
        sendEvent(EventName.handleAuthSuccessCalled.name(), null);
    }

    @Override // com.iterable.iterableapi.IterableAuthHandler
    public void onTokenRegistrationFailed(Throwable th) {
        IterableLogger.v(TAG, "Failed to set authToken");
        sendEvent(EventName.handleAuthFailureCalled.name(), null);
    }

    @ReactMethod
    public void passAlongAuthToken(String str) {
        this.passedAuthToken = str;
        CountDownLatch countDownLatch = this.authHandlerCallbackLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public void sendEvent(String str, Object obj) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, obj);
    }

    @Override // com.iterable.iterableapi.IterableInAppManager.Listener
    public void onInboxUpdated() {
        sendEvent(EventName.receivedIterableInboxChanged.name(), null);
    }
}
