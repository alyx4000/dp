package com.iterable.iterableapi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.iterable.iterableapi.IterableActivityMonitor;
import com.iterable.iterableapi.IterableApiClient;
import com.iterable.iterableapi.IterableConfig;
import com.iterable.iterableapi.IterableHelper;
import com.iterable.iterableapi.IterablePushRegistrationData;
import com.iterable.iterableapi.util.DeviceInfoUtils;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class IterableApi {
    private static final String TAG = "IterableApi";
    static volatile IterableApi sharedInstance = new IterableApi();
    private String _apiKey;
    private Context _applicationContext;
    private String _authToken;
    private boolean _debugMode;
    private String _deviceId;
    private String _email;
    private boolean _firstForegroundHandled;
    private IterableNotificationData _notificationData;
    private Bundle _payloadData;
    private IterableHelper.FailureHandler _setUserFailureCallbackHandler;
    private IterableHelper.SuccessHandler _setUserSuccessCallbackHandler;
    private String _userId;
    private final IterableActivityMonitor.AppStateCallback activityMonitorListener;
    IterableApiClient apiClient;
    private IterableAuthManager authManager;
    IterableConfig config;
    private HashMap<String, String> deviceAttributes;
    private IterableInAppManager inAppManager;
    private String inboxSessionId;
    private IterableKeychain keychain;

    void fetchRemoteConfiguration() {
        this.apiClient.getRemoteConfiguration(new IterableHelper.IterableActionHandler() { // from class: com.iterable.iterableapi.IterableApi.1
            @Override // com.iterable.iterableapi.IterableHelper.IterableActionHandler
            public void execute(String str) {
                if (str == null) {
                    IterableLogger.e(IterableApi.TAG, "Remote configuration returned null");
                    return;
                }
                try {
                    boolean z = new JSONObject(str).getBoolean(IterableConstants.KEY_OFFLINE_MODE);
                    IterableApi.sharedInstance.apiClient.setOfflineProcessingEnabled(z);
                    SharedPreferences.Editor edit = IterableApi.sharedInstance.getMainActivityContext().getSharedPreferences(IterableConstants.SHARED_PREFS_SAVED_CONFIGURATION, 0).edit();
                    edit.putBoolean(IterableConstants.SHARED_PREFS_OFFLINE_MODE_KEY, z);
                    edit.apply();
                } catch (JSONException unused) {
                    IterableLogger.e(IterableApi.TAG, "Failed to read remote configuration");
                }
            }
        });
    }

    public String getEmail() {
        return this._email;
    }

    public String getUserId() {
        return this._userId;
    }

    public String getAuthToken() {
        return this._authToken;
    }

    private void checkAndUpdateAuthToken(String str) {
        if (this.config.authHandler == null || str == null || str == this._authToken) {
            return;
        }
        setAuthToken(str);
    }

    void setAttributionInfo(IterableAttributionInfo iterableAttributionInfo) {
        if (this._applicationContext == null) {
            IterableLogger.e(TAG, "setAttributionInfo: Iterable SDK is not initialized with a context.");
        } else {
            IterableUtil.saveExpirableJsonObject(getPreferences(), IterableConstants.SHARED_PREFS_ATTRIBUTION_INFO_KEY, iterableAttributionInfo.toJSONObject(), DateUtils.MILLIS_PER_DAY);
        }
    }

    HashMap getDeviceAttributes() {
        return this.deviceAttributes;
    }

    Context getMainActivityContext() {
        return this._applicationContext;
    }

    IterableAuthManager getAuthManager() {
        if (this.authManager == null) {
            this.authManager = new IterableAuthManager(this, this.config.authHandler, this.config.expiringAuthTokenRefreshPeriod);
        }
        return this.authManager;
    }

    IterableKeychain getKeychain() {
        if (this.keychain == null) {
            try {
                this.keychain = new IterableKeychain(getMainActivityContext(), this.config.encryptionEnforced);
            } catch (Exception e) {
                IterableLogger.e(TAG, "Failed to create IterableKeychain", e);
            }
        }
        return this.keychain;
    }

    static void loadLastSavedConfiguration(Context context) {
        sharedInstance.apiClient.setOfflineProcessingEnabled(context.getSharedPreferences(IterableConstants.SHARED_PREFS_SAVED_CONFIGURATION, 0).getBoolean(IterableConstants.SHARED_PREFS_OFFLINE_MODE_KEY, false));
    }

    static void setNotificationIcon(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences(IterableConstants.NOTIFICATION_ICON_NAME, 0).edit();
        edit.putString(IterableConstants.NOTIFICATION_ICON_NAME, str);
        edit.commit();
    }

    static String getNotificationIcon(Context context) {
        return context.getSharedPreferences(IterableConstants.NOTIFICATION_ICON_NAME, 0).getString(IterableConstants.NOTIFICATION_ICON_NAME, "");
    }

    void setDebugMode(boolean z) {
        this._debugMode = z;
    }

    boolean getDebugMode() {
        return this._debugMode;
    }

    void setPayloadData(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null || !extras.containsKey(IterableConstants.ITERABLE_DATA_KEY) || IterableNotificationHelper.isGhostPush(extras)) {
            return;
        }
        setPayloadData(extras);
    }

    void setPayloadData(Bundle bundle) {
        this._payloadData = bundle;
    }

    void setNotificationData(IterableNotificationData iterableNotificationData) {
        this._notificationData = iterableNotificationData;
        if (iterableNotificationData != null) {
            setAttributionInfo(new IterableAttributionInfo(iterableNotificationData.getCampaignId(), iterableNotificationData.getTemplateId(), iterableNotificationData.getMessageId()));
        }
    }

    void getInAppMessages(int i, IterableHelper.IterableActionHandler iterableActionHandler) {
        if (checkSDKInitialization()) {
            this.apiClient.getInAppMessages(i, iterableActionHandler);
        }
    }

    void trackInAppDelivery(IterableInAppMessage iterableInAppMessage) {
        if (checkSDKInitialization()) {
            if (iterableInAppMessage == null) {
                IterableLogger.e(TAG, "trackInAppDelivery: message is null");
            } else {
                this.apiClient.trackInAppDelivery(iterableInAppMessage);
            }
        }
    }

    private String getPushIntegrationName() {
        if (this.config.pushIntegrationName != null) {
            return this.config.pushIntegrationName;
        }
        return this._applicationContext.getPackageName();
    }

    private void logoutPreviousUser() {
        if (this.config.autoPushRegistration && isInitialized()) {
            disablePush();
        }
        getInAppManager().reset();
        getAuthManager().clearRefreshTimer();
        this.apiClient.onLogout();
    }

    private void onLogin(String str) {
        if (!isInitialized()) {
            setAuthToken(null);
        } else if (str != null) {
            setAuthToken(str);
        } else {
            getAuthManager().requestNewAuthToken(false);
        }
    }

    private void completeUserLogin() {
        if (isInitialized()) {
            if (this.config.autoPushRegistration) {
                registerForPush();
            } else {
                IterableHelper.SuccessHandler successHandler = this._setUserSuccessCallbackHandler;
                if (successHandler != null) {
                    successHandler.onSuccess(new JSONObject());
                }
            }
            getInAppManager().syncInApp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onForeground() {
        if (this._firstForegroundHandled) {
            return;
        }
        this._firstForegroundHandled = true;
        if (sharedInstance.config.autoPushRegistration && sharedInstance.isInitialized()) {
            IterableLogger.d(TAG, "Performing automatic push registration");
            sharedInstance.registerForPush();
        }
        fetchRemoteConfiguration();
    }

    private boolean isInitialized() {
        return (this._apiKey == null || (this._email == null && this._userId == null)) ? false : true;
    }

    private boolean checkSDKInitialization() {
        if (isInitialized()) {
            return true;
        }
        IterableLogger.w(TAG, "Iterable SDK must be initialized with an API key and user email/userId before calling SDK methods");
        return false;
    }

    private SharedPreferences getPreferences() {
        return this._applicationContext.getSharedPreferences("com.iterable.iterableapi", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDeviceId() {
        if (this._deviceId == null) {
            String string = getPreferences().getString(IterableConstants.SHARED_PREFS_DEVICEID_KEY, null);
            this._deviceId = string;
            if (string == null) {
                this._deviceId = UUID.randomUUID().toString();
                getPreferences().edit().putString(IterableConstants.SHARED_PREFS_DEVICEID_KEY, this._deviceId).apply();
            }
        }
        return this._deviceId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void storeAuthData() {
        IterableKeychain keychain = getKeychain();
        if (keychain != null) {
            keychain.saveEmail(this._email);
            keychain.saveUserId(this._userId);
            keychain.saveAuthToken(this._authToken);
            return;
        }
        IterableLogger.e(TAG, "Shared preference creation failed. ");
    }

    private void retrieveEmailAndUserId() {
        IterableKeychain keychain = getKeychain();
        if (keychain != null) {
            this._email = keychain.getEmail();
            this._userId = keychain.getUserId();
            this._authToken = keychain.getAuthToken();
        } else {
            IterableLogger.e(TAG, "retrieveEmailAndUserId: Shared preference creation failed. Could not retrieve email/userId");
        }
        if (this.config.authHandler != null) {
            if (this._authToken != null) {
                getAuthManager().queueExpirationRefresh(this._authToken);
            } else {
                IterableLogger.d(TAG, "Auth token found as null. Scheduling token refresh in 10 seconds...");
                getAuthManager().scheduleAuthTokenRefresh(DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM);
            }
        }
    }

    private class IterableApiAuthProvider implements IterableApiClient.AuthProvider {
        private IterableApiAuthProvider() {
        }

        @Override // com.iterable.iterableapi.IterableApiClient.AuthProvider
        public String getEmail() {
            return IterableApi.this._email;
        }

        @Override // com.iterable.iterableapi.IterableApiClient.AuthProvider
        public String getUserId() {
            return IterableApi.this._userId;
        }

        @Override // com.iterable.iterableapi.IterableApiClient.AuthProvider
        public String getAuthToken() {
            return IterableApi.this._authToken;
        }

        @Override // com.iterable.iterableapi.IterableApiClient.AuthProvider
        public String getApiKey() {
            return IterableApi.this._apiKey;
        }

        @Override // com.iterable.iterableapi.IterableApiClient.AuthProvider
        public String getDeviceId() {
            return IterableApi.this.getDeviceId();
        }

        @Override // com.iterable.iterableapi.IterableApiClient.AuthProvider
        public Context getContext() {
            return IterableApi.this._applicationContext;
        }

        @Override // com.iterable.iterableapi.IterableApiClient.AuthProvider
        public void resetAuth() {
            IterableLogger.d(IterableApi.TAG, "Resetting authToken");
            IterableApi.this._authToken = null;
        }
    }

    void setAuthToken(String str, boolean z) {
        String str2;
        if (isInitialized()) {
            if ((str == null || str.equalsIgnoreCase(this._authToken)) && ((str2 = this._authToken) == null || str2.equalsIgnoreCase(str))) {
                if (z) {
                    completeUserLogin();
                }
            } else {
                this._authToken = str;
                storeAuthData();
                completeUserLogin();
            }
        }
    }

    protected void registerDeviceToken(final String str, final String str2, final String str3, final String str4, final String str5, final HashMap<String, String> hashMap) {
        if (str5 != null) {
            new Thread(new Runnable() { // from class: com.iterable.iterableapi.IterableApi.3
                @Override // java.lang.Runnable
                public void run() {
                    IterableApi.this.registerDeviceToken(str, str2, str3, str4, str5, null, hashMap);
                }
            }).start();
        }
    }

    protected void disableToken(String str, String str2, String str3) {
        disableToken(str, str2, null, str3, null, null);
    }

    protected void disableToken(String str, String str2, String str3, String str4, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        if (str4 == null) {
            IterableLogger.d(TAG, "device token not available");
        } else {
            this.apiClient.disableToken(str, str2, str3, str4, successHandler, failureHandler);
        }
    }

    protected void registerDeviceToken(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject, HashMap<String, String> hashMap) {
        if (checkSDKInitialization()) {
            if (str5 == null) {
                IterableLogger.e(TAG, "registerDeviceToken: token is null");
                return;
            }
            if (str4 == null) {
                IterableLogger.e(TAG, "registerDeviceToken: applicationName is null, check that pushIntegrationName is set in IterableConfig");
            }
            this.apiClient.registerDeviceToken(str, str2, str3, str4, str5, jSONObject, hashMap, this._setUserSuccessCallbackHandler, this._setUserFailureCallbackHandler);
        }
    }

    public static IterableApi getInstance() {
        return sharedInstance;
    }

    public static void initialize(Context context, String str) {
        initialize(context, str, null);
    }

    public static void initialize(Context context, String str, IterableConfig iterableConfig) {
        sharedInstance._applicationContext = context.getApplicationContext();
        sharedInstance._apiKey = str;
        sharedInstance.config = iterableConfig;
        if (sharedInstance.config == null) {
            sharedInstance.config = new IterableConfig.Builder().build();
        }
        sharedInstance.retrieveEmailAndUserId();
        IterableActivityMonitor.getInstance().registerLifecycleCallbacks(context);
        IterableActivityMonitor.getInstance().addCallback(sharedInstance.activityMonitorListener);
        if (sharedInstance.inAppManager == null) {
            sharedInstance.inAppManager = new IterableInAppManager(sharedInstance, sharedInstance.config.inAppHandler, sharedInstance.config.inAppDisplayInterval, sharedInstance.config.useInMemoryStorageForInApps);
        }
        loadLastSavedConfiguration(context);
        IterablePushNotificationUtil.processPendingAction(context);
        if (DeviceInfoUtils.isFireTV(context.getPackageManager())) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                DeviceInfoUtils.populateDeviceDetails(jSONObject2, context, sharedInstance.getDeviceId());
                jSONObject.put(IterableConstants.KEY_FIRETV, jSONObject2);
                sharedInstance.apiClient.updateUser(jSONObject, false);
            } catch (JSONException e) {
                IterableLogger.e(TAG, "initialize: exception", e);
            }
        }
    }

    public static void setContext(Context context) {
        IterableActivityMonitor.getInstance().registerLifecycleCallbacks(context);
    }

    IterableApi() {
        this.apiClient = new IterableApiClient(new IterableApiAuthProvider());
        this.deviceAttributes = new HashMap<>();
        this.activityMonitorListener = new IterableActivityMonitor.AppStateCallback() { // from class: com.iterable.iterableapi.IterableApi.2
            @Override // com.iterable.iterableapi.IterableActivityMonitor.AppStateCallback
            public void onSwitchToBackground() {
            }

            @Override // com.iterable.iterableapi.IterableActivityMonitor.AppStateCallback
            public void onSwitchToForeground() {
                IterableApi.this.onForeground();
            }
        };
        this.config = new IterableConfig.Builder().build();
    }

    IterableApi(IterableInAppManager iterableInAppManager) {
        this.apiClient = new IterableApiClient(new IterableApiAuthProvider());
        this.deviceAttributes = new HashMap<>();
        this.activityMonitorListener = new IterableActivityMonitor.AppStateCallback() { // from class: com.iterable.iterableapi.IterableApi.2
            @Override // com.iterable.iterableapi.IterableActivityMonitor.AppStateCallback
            public void onSwitchToBackground() {
            }

            @Override // com.iterable.iterableapi.IterableActivityMonitor.AppStateCallback
            public void onSwitchToForeground() {
                IterableApi.this.onForeground();
            }
        };
        this.config = new IterableConfig.Builder().build();
        this.inAppManager = iterableInAppManager;
    }

    IterableApi(IterableApiClient iterableApiClient, IterableInAppManager iterableInAppManager) {
        this.apiClient = new IterableApiClient(new IterableApiAuthProvider());
        this.deviceAttributes = new HashMap<>();
        this.activityMonitorListener = new IterableActivityMonitor.AppStateCallback() { // from class: com.iterable.iterableapi.IterableApi.2
            @Override // com.iterable.iterableapi.IterableActivityMonitor.AppStateCallback
            public void onSwitchToBackground() {
            }

            @Override // com.iterable.iterableapi.IterableActivityMonitor.AppStateCallback
            public void onSwitchToForeground() {
                IterableApi.this.onForeground();
            }
        };
        this.config = new IterableConfig.Builder().build();
        this.apiClient = iterableApiClient;
        this.inAppManager = iterableInAppManager;
    }

    public IterableInAppManager getInAppManager() {
        IterableInAppManager iterableInAppManager = this.inAppManager;
        if (iterableInAppManager != null) {
            return iterableInAppManager;
        }
        throw new RuntimeException("IterableApi must be initialized before calling getInAppManager(). Make sure you call IterableApi#initialize() in Application#onCreate");
    }

    public IterableAttributionInfo getAttributionInfo() {
        return IterableAttributionInfo.fromJSONObject(IterableUtil.retrieveExpirableJsonObject(getPreferences(), IterableConstants.SHARED_PREFS_ATTRIBUTION_INFO_KEY));
    }

    public void setEmail(String str) {
        setEmail(str, null, null, null);
    }

    public void setEmail(String str, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        setEmail(str, null, successHandler, failureHandler);
    }

    public void setEmail(String str, String str2) {
        setEmail(str, str2, null, null);
    }

    public void setEmail(String str, String str2, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        String str3 = this._email;
        if (str3 != null && str3.equals(str)) {
            checkAndUpdateAuthToken(str2);
            return;
        }
        if (this._email == null && this._userId == null && str == null) {
            return;
        }
        logoutPreviousUser();
        this._email = str;
        this._userId = null;
        this._setUserSuccessCallbackHandler = successHandler;
        this._setUserFailureCallbackHandler = failureHandler;
        storeAuthData();
        onLogin(str2);
    }

    public void setUserId(String str) {
        setUserId(str, null, null, null);
    }

    public void setUserId(String str, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        setUserId(str, null, successHandler, failureHandler);
    }

    public void setUserId(String str, String str2) {
        setUserId(str, str2, null, null);
    }

    public void setUserId(String str, String str2, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        String str3 = this._userId;
        if (str3 != null && str3.equals(str)) {
            checkAndUpdateAuthToken(str2);
            return;
        }
        if (this._email == null && this._userId == null && str == null) {
            return;
        }
        logoutPreviousUser();
        this._email = null;
        this._userId = str;
        this._setUserSuccessCallbackHandler = successHandler;
        this._setUserFailureCallbackHandler = failureHandler;
        storeAuthData();
        onLogin(str2);
    }

    public void setAuthToken(String str) {
        setAuthToken(str, false);
    }

    public void setNotificationIcon(String str) {
        setNotificationIcon(this._applicationContext, str);
    }

    public String getPayloadData(String str) {
        Bundle bundle = this._payloadData;
        if (bundle != null) {
            return bundle.getString(str, null);
        }
        return null;
    }

    public Bundle getPayloadData() {
        return this._payloadData;
    }

    public void setDeviceAttribute(String str, String str2) {
        this.deviceAttributes.put(str, str2);
    }

    public void removeDeviceAttribute(String str) {
        this.deviceAttributes.remove(str);
    }

    public void registerDeviceToken(String str) {
        registerDeviceToken(this._email, this._userId, this._authToken, getPushIntegrationName(), str, this.deviceAttributes);
    }

    public void trackPushOpen(int i, int i2, String str) {
        trackPushOpen(i, i2, str, null);
    }

    public void trackPushOpen(int i, int i2, String str, JSONObject jSONObject) {
        if (str == null) {
            IterableLogger.e(TAG, "messageId is null");
        } else {
            this.apiClient.trackPushOpen(i, i2, str, jSONObject);
        }
    }

    public void inAppConsume(String str) {
        IterableInAppMessage messageById = getInAppManager().getMessageById(str);
        if (messageById == null) {
            IterableLogger.e(TAG, "inAppConsume: message is null");
        } else {
            inAppConsume(messageById, null, null, null, null);
            IterableLogger.printInfo();
        }
    }

    public void inAppConsume(String str, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        IterableInAppMessage messageById = getInAppManager().getMessageById(str);
        if (messageById == null) {
            IterableLogger.e(TAG, "inAppConsume: message is null");
            if (failureHandler != null) {
                failureHandler.onFailure("inAppConsume: message is null", null);
                return;
            }
            return;
        }
        inAppConsume(messageById, null, null, successHandler, failureHandler);
        IterableLogger.printInfo();
    }

    public void inAppConsume(IterableInAppMessage iterableInAppMessage, IterableInAppDeleteActionType iterableInAppDeleteActionType, IterableInAppLocation iterableInAppLocation) {
        if (checkSDKInitialization()) {
            this.apiClient.inAppConsume(iterableInAppMessage, iterableInAppDeleteActionType, iterableInAppLocation, this.inboxSessionId, null, null);
        }
    }

    public void inAppConsume(IterableInAppMessage iterableInAppMessage, IterableInAppDeleteActionType iterableInAppDeleteActionType, IterableInAppLocation iterableInAppLocation, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        if (checkSDKInitialization()) {
            this.apiClient.inAppConsume(iterableInAppMessage, iterableInAppDeleteActionType, iterableInAppLocation, this.inboxSessionId, successHandler, failureHandler);
        }
    }

    public void getAndTrackDeepLink(String str, IterableHelper.IterableActionHandler iterableActionHandler) {
        IterableDeeplinkManager.getAndTrackDeeplink(str, iterableActionHandler);
    }

    public boolean handleAppLink(String str) {
        IterableLogger.printInfo();
        if (IterableDeeplinkManager.isIterableDeeplink(str)) {
            IterableDeeplinkManager.getAndTrackDeeplink(str, new IterableHelper.IterableActionHandler() { // from class: com.iterable.iterableapi.IterableApi.4
                @Override // com.iterable.iterableapi.IterableHelper.IterableActionHandler
                public void execute(String str2) {
                    IterableActionRunner.executeAction(IterableApi.getInstance().getMainActivityContext(), IterableAction.actionOpenUrl(str2), IterableActionSource.APP_LINK);
                }
            });
            return true;
        }
        return IterableActionRunner.executeAction(getInstance().getMainActivityContext(), IterableAction.actionOpenUrl(str), IterableActionSource.APP_LINK);
    }

    public static void overrideURLEndpointPath(String str) {
        IterableRequestTask.overrideUrl = str;
    }

    public boolean isIterableIntent(Intent intent) {
        Bundle extras;
        return (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey(IterableConstants.ITERABLE_DATA_KEY)) ? false : true;
    }

    public void track(String str) {
        track(str, 0, 0, null);
    }

    public void track(String str, JSONObject jSONObject) {
        track(str, 0, 0, jSONObject);
    }

    public void track(String str, int i, int i2) {
        track(str, i, i2, null);
    }

    public void track(String str, int i, int i2, JSONObject jSONObject) {
        IterableLogger.printInfo();
        if (checkSDKInitialization()) {
            this.apiClient.track(str, i, i2, jSONObject);
        }
    }

    public void updateCart(List<CommerceItem> list) {
        if (checkSDKInitialization()) {
            this.apiClient.updateCart(list);
        }
    }

    public void trackPurchase(double d, List<CommerceItem> list) {
        trackPurchase(d, list, null);
    }

    public void trackPurchase(double d, List<CommerceItem> list, JSONObject jSONObject) {
        if (checkSDKInitialization()) {
            this.apiClient.trackPurchase(d, list, jSONObject);
        }
    }

    public void updateEmail(String str) {
        updateEmail(str, null, null, null);
    }

    public void updateEmail(String str, String str2) {
        updateEmail(str, str2, null, null);
    }

    public void updateEmail(String str, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        updateEmail(str, null, successHandler, failureHandler);
    }

    public void updateEmail(final String str, final String str2, final IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        if (!checkSDKInitialization()) {
            IterableLogger.e(TAG, "The Iterable SDK must be initialized with email or userId before calling updateEmail");
            if (failureHandler != null) {
                failureHandler.onFailure("The Iterable SDK must be initialized with email or userId before calling updateEmail", null);
                return;
            }
            return;
        }
        this.apiClient.updateEmail(str, new IterableHelper.SuccessHandler() { // from class: com.iterable.iterableapi.IterableApi.5
            @Override // com.iterable.iterableapi.IterableHelper.SuccessHandler
            public void onSuccess(JSONObject jSONObject) {
                if (IterableApi.this._email != null) {
                    IterableApi.this._email = str;
                    IterableApi.this._authToken = str2;
                }
                IterableApi.this.storeAuthData();
                IterableApi.this.getAuthManager().requestNewAuthToken(false);
                IterableHelper.SuccessHandler successHandler2 = successHandler;
                if (successHandler2 != null) {
                    successHandler2.onSuccess(jSONObject);
                }
            }
        }, failureHandler);
    }

    public void updateUser(JSONObject jSONObject) {
        updateUser(jSONObject, false);
    }

    public void updateUser(JSONObject jSONObject, Boolean bool) {
        if (checkSDKInitialization()) {
            this.apiClient.updateUser(jSONObject, bool);
        }
    }

    public void registerForPush() {
        if (checkSDKInitialization()) {
            IterablePushRegistration.executePushRegistrationTask(new IterablePushRegistrationData(this._email, this._userId, this._authToken, getPushIntegrationName(), IterablePushRegistrationData.PushRegistrationAction.ENABLE));
        }
    }

    public void disablePush() {
        IterablePushRegistration.executePushRegistrationTask(new IterablePushRegistrationData(this._email, this._userId, this._authToken, getPushIntegrationName(), IterablePushRegistrationData.PushRegistrationAction.DISABLE));
    }

    public void updateSubscriptions(Integer[] numArr, Integer[] numArr2, Integer[] numArr3) {
        updateSubscriptions(numArr, numArr2, numArr3, null, null, null);
    }

    public void updateSubscriptions(Integer[] numArr, Integer[] numArr2, Integer[] numArr3, Integer[] numArr4, Integer num, Integer num2) {
        if (checkSDKInitialization()) {
            this.apiClient.updateSubscriptions(numArr, numArr2, numArr3, numArr4, num, num2);
        }
    }

    public void trackInAppOpen(IterableInAppMessage iterableInAppMessage, IterableInAppLocation iterableInAppLocation) {
        if (checkSDKInitialization()) {
            if (iterableInAppMessage == null) {
                IterableLogger.e(TAG, "trackInAppOpen: message is null");
            } else {
                this.apiClient.trackInAppOpen(iterableInAppMessage, iterableInAppLocation, this.inboxSessionId);
            }
        }
    }

    public void trackInAppClick(IterableInAppMessage iterableInAppMessage, String str, IterableInAppLocation iterableInAppLocation) {
        if (checkSDKInitialization()) {
            if (iterableInAppMessage == null) {
                IterableLogger.e(TAG, "trackInAppClick: message is null");
            } else {
                this.apiClient.trackInAppClick(iterableInAppMessage, str, iterableInAppLocation, this.inboxSessionId);
            }
        }
    }

    public void trackInAppClose(IterableInAppMessage iterableInAppMessage, String str, IterableInAppCloseAction iterableInAppCloseAction, IterableInAppLocation iterableInAppLocation) {
        if (checkSDKInitialization()) {
            if (iterableInAppMessage == null) {
                IterableLogger.e(TAG, "trackInAppClose: message is null");
            } else {
                this.apiClient.trackInAppClose(iterableInAppMessage, str, iterableInAppCloseAction, iterableInAppLocation, this.inboxSessionId);
            }
        }
    }

    @Deprecated
    public void trackInAppOpen(String str) {
        IterableLogger.printInfo();
        if (checkSDKInitialization()) {
            this.apiClient.trackInAppOpen(str);
        }
    }

    @Deprecated
    void trackInAppOpen(String str, IterableInAppLocation iterableInAppLocation) {
        IterableLogger.printInfo();
        IterableInAppMessage messageById = getInAppManager().getMessageById(str);
        if (messageById != null) {
            trackInAppOpen(messageById, iterableInAppLocation);
        } else {
            IterableLogger.w(TAG, "trackInAppOpen: could not find an in-app message with ID: " + str);
        }
    }

    @Deprecated
    void trackInAppClick(String str, String str2, IterableInAppLocation iterableInAppLocation) {
        IterableLogger.printInfo();
        IterableInAppMessage messageById = getInAppManager().getMessageById(str);
        if (messageById != null) {
            trackInAppClick(messageById, str2, iterableInAppLocation);
        } else {
            trackInAppClick(str, str2);
        }
    }

    @Deprecated
    public void trackInAppClick(String str, String str2) {
        if (checkSDKInitialization()) {
            this.apiClient.trackInAppClick(str, str2);
        }
    }

    @Deprecated
    void trackInAppClose(String str, String str2, IterableInAppCloseAction iterableInAppCloseAction, IterableInAppLocation iterableInAppLocation) {
        IterableInAppMessage messageById = getInAppManager().getMessageById(str);
        if (messageById != null) {
            trackInAppClose(messageById, str2, iterableInAppCloseAction, iterableInAppLocation);
            IterableLogger.printInfo();
        } else {
            IterableLogger.w(TAG, "trackInAppClose: could not find an in-app message with ID: " + str);
        }
    }

    public void trackInboxSession(IterableInboxSession iterableInboxSession) {
        if (checkSDKInitialization()) {
            if (iterableInboxSession == null) {
                IterableLogger.e(TAG, "trackInboxSession: session is null");
            } else if (iterableInboxSession.sessionStartTime == null || iterableInboxSession.sessionEndTime == null) {
                IterableLogger.e(TAG, "trackInboxSession: sessionStartTime and sessionEndTime must be set");
            } else {
                this.apiClient.trackInboxSession(iterableInboxSession, this.inboxSessionId);
            }
        }
    }

    public void setInboxSessionId(String str) {
        this.inboxSessionId = str;
    }

    public void clearInboxSessionId() {
        this.inboxSessionId = null;
    }
}
