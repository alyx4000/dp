package io.branch.referral;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.URLUtil;
import io.branch.referral.Defines;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class PrefHelper {
    static final String BRANCH_BASE_URL_V1 = "https://api.branch.io/";
    static final String BRANCH_BASE_URL_V2 = "https://api2.branch.io/";
    static final String BRANCH_CDN_BASE_URL = "https://cdn.branch.io/";
    static final String BRANCH_EU_BASE_URL_V3 = "https://api3-eu.branch.io/";
    static final int CONNECT_TIMEOUT = 10000;
    static final int DEFAULT_NO_CONNECTION_RETRY_MAX = 3;
    static final long DEFAULT_VALID_WINDOW_FOR_REFERRER_GCLID = 2592000000L;
    private static final int INTERVAL_RETRY = 1000;
    private static final String KEY_ACTIONS = "bnc_actions";
    static final String KEY_AD_NETWORK_CALLOUTS_DISABLED = "bnc_ad_network_callouts_disabled";
    static final String KEY_ANON_ID = "bnc_anon_id";
    private static final String KEY_APP_LINK = "bnc_app_link";
    private static final String KEY_APP_STORE_SOURCE = "bnc_app_store_source";
    private static final String KEY_APP_VERSION = "bnc_app_version";
    private static final String KEY_BRANCH_KEY = "bnc_branch_key";
    private static final String KEY_BRANCH_VIEW_NUM_OF_USE = "bnc_branch_view_use";
    private static final String KEY_CONNECT_TIMEOUT = "bnc_connect_timeout";
    private static final String KEY_DEVICE_FINGERPRINT_ID = "bnc_device_fingerprint_id";
    private static final String KEY_DMA_AD_PERSONALIZATION = "bnc_dma_ad_personalization";
    private static final String KEY_DMA_AD_USER_DATA = "bnc_dma_ad_user_data";
    private static final String KEY_DMA_EEA = "bnc_dma_eea";
    private static final String KEY_EXTERNAL_INTENT_EXTRA = "bnc_external_intent_extra";
    private static final String KEY_EXTERNAL_INTENT_URI = "bnc_external_intent_uri";
    private static final String KEY_GCLID_EXPIRATION_DATE = "bnc_gclid_expiration_date";
    private static final String KEY_GCLID_JSON_OBJECT = "bnc_gclid_json_object";
    private static final String KEY_GCLID_VALID_FOR_WINDOW = "bnc_gclid_expiration_window";
    private static final String KEY_GCLID_VALUE = "bnc_gclid_value";
    private static final String KEY_GOOGLE_PLAY_INSTALL_REFERRER_EXTRA = "bnc_google_play_install_referrer_extras";
    private static final String KEY_GOOGLE_SEARCH_INSTALL_IDENTIFIER = "bnc_google_search_install_identifier";
    private static final String KEY_IDENTITY = "bnc_identity";
    private static final String KEY_IDENTITY_ID = "bnc_identity_id";
    private static final String KEY_INITIAL_REFERRER = "bnc_initial_referrer";
    static final String KEY_INSTALL_BEGIN_TS = "bnc_install_begin_ts";
    private static final String KEY_INSTALL_PARAMS = "bnc_install_params";
    private static final String KEY_INSTALL_REFERRER = "bnc_install_referrer";
    private static final String KEY_IS_FULL_APP_CONVERSION = "bnc_is_full_app_conversion";
    static final String KEY_LAST_KNOWN_UPDATE_TIME = "bnc_last_known_update_time";
    private static final String KEY_LAST_READ_SYSTEM = "bnc_system_read_date";
    private static final String KEY_LATD_ATTRIBUTION_WINDOW = "bnc_latd_attributon_window";
    private static final String KEY_LIMIT_FACEBOOK_TRACKING = "bnc_limit_facebook_tracking";
    private static final String KEY_LINK_CLICK_ID = "bnc_link_click_id";
    private static final String KEY_LINK_CLICK_IDENTIFIER = "bnc_link_click_identifier";
    private static final String KEY_LOG_IAP_AS_EVENTS = "bnc_log_iap_as_events";
    private static final String KEY_NO_CONNECTION_RETRY_MAX = "bnc_no_connection_retry_max";
    static final String KEY_ORIGINAL_INSTALL_TIME = "bnc_original_install_time";
    static final String KEY_PREVIOUS_UPDATE_TIME = "bnc_previous_update_time";
    private static final String KEY_PUSH_IDENTIFIER = "bnc_push_identifier";
    private static final String KEY_RANDOMIZED_BUNDLE_TOKEN = "bnc_randomized_bundle_token";
    private static final String KEY_RANDOMIZED_DEVICE_TOKEN = "bnc_randomized_device_token";
    static final String KEY_RANDOMLY_GENERATED_UUID = "bnc_randomly_generated_uuid";
    static final String KEY_REFERRER_CLICK_TS = "bnc_referrer_click_ts";
    static final String KEY_REFERRING_URL_QUERY_PARAMETERS = "bnc_referringUrlQueryParameters";
    private static final String KEY_RETRY_COUNT = "bnc_retry_count";
    private static final String KEY_RETRY_INTERVAL = "bnc_retry_interval";
    private static final String KEY_SESSION_ID = "bnc_session_id";
    private static final String KEY_SESSION_PARAMS = "bnc_session_params";
    private static final String KEY_TASK_TIMEOUT = "bnc_task_timeout";
    private static final String KEY_TIMEOUT = "bnc_timeout";
    private static final String KEY_TOTAL_BASE = "bnc_total_base_";
    static final String KEY_TRACKING_STATE = "bnc_tracking_state";
    private static final String KEY_UNIQUE_BASE = "bnc_balance_base_";
    private static final String KEY_USER_URL = "bnc_user_url";
    private static final int MAX_RETRIES = 3;
    static final long MAX_VALID_WINDOW_FOR_REFERRER_GCLID = 100000000000L;
    static final long MIN_VALID_WINDOW_FOR_REFERRER_GCLID = 0;
    public static final String NO_STRING_VALUE = "bnc_no_value";
    private static final String SHARED_PREF_FILE = "branch_referral_shared_pref";
    private static final String TAG = "BranchSDK";
    static final int TASK_TIMEOUT = 15500;
    static final int TIMEOUT = 5500;
    private static String customCDNBaseURL_ = null;
    private static String customServerURL_ = null;
    private static boolean enableLogging_ = false;
    private static PrefHelper prefHelper_ = null;
    private static boolean useEUEndpoint_ = false;
    private final SharedPreferences appSharedPrefs_;
    private SharedPreferences.Editor prefsEditor_;
    private final JSONObject requestMetadata = new JSONObject();
    private final JSONObject installMetadata = new JSONObject();
    private final JSONObject secondaryRequestMetadata = new JSONObject();
    final BranchPartnerParameters partnerParams_ = new BranchPartnerParameters();

    private PrefHelper(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_FILE, 0);
        this.appSharedPrefs_ = sharedPreferences;
        this.prefsEditor_ = sharedPreferences.edit();
    }

    public static PrefHelper getInstance(Context context) {
        if (prefHelper_ == null) {
            prefHelper_ = new PrefHelper(context);
        }
        return prefHelper_;
    }

    static void shutDown() {
        PrefHelper prefHelper = prefHelper_;
        if (prefHelper != null) {
            prefHelper.prefsEditor_ = null;
        }
        enableLogging_ = false;
        prefHelper_ = null;
        customCDNBaseURL_ = null;
        customServerURL_ = null;
        useEUEndpoint_ = false;
    }

    static void setAPIUrl(String str) {
        customServerURL_ = str;
    }

    public String getAPIBaseUrl() {
        if (URLUtil.isHttpsUrl(customServerURL_)) {
            return customServerURL_;
        }
        return useEUEndpoint_ ? BRANCH_EU_BASE_URL_V3 : BRANCH_BASE_URL_V2;
    }

    static void setCDNBaseUrl(String str) {
        customCDNBaseURL_ = str;
    }

    static String getCDNBaseUrl() {
        return !TextUtils.isEmpty(customCDNBaseURL_) ? customCDNBaseURL_ : BRANCH_CDN_BASE_URL;
    }

    public void setTimeout(int i) {
        setInteger(KEY_TIMEOUT, i);
    }

    public int getTimeout() {
        return getInteger(KEY_TIMEOUT, TIMEOUT);
    }

    public int getTaskTimeout() {
        return getInteger(KEY_TIMEOUT, TIMEOUT) + getInteger(KEY_CONNECT_TIMEOUT, 10000);
    }

    public void setConnectTimeout(int i) {
        setInteger(KEY_CONNECT_TIMEOUT, i);
    }

    public int getConnectTimeout() {
        return getInteger(KEY_CONNECT_TIMEOUT, 10000);
    }

    public void setRetryCount(int i) {
        setInteger(KEY_RETRY_COUNT, i);
    }

    public int getRetryCount() {
        return getInteger(KEY_RETRY_COUNT, 3);
    }

    public void setRetryInterval(int i) {
        setInteger(KEY_RETRY_INTERVAL, i);
    }

    public int getRetryInterval() {
        return getInteger(KEY_RETRY_INTERVAL, 1000);
    }

    public void setNoConnectionRetryMax(int i) {
        setInteger(KEY_NO_CONNECTION_RETRY_MAX, i);
    }

    public int getNoConnectionRetryMax() {
        return getInteger(KEY_NO_CONNECTION_RETRY_MAX, 3);
    }

    public void setAppVersion(String str) {
        setString(KEY_APP_VERSION, str);
    }

    public String getAppVersion() {
        return getString(KEY_APP_VERSION);
    }

    public boolean setBranchKey(String str) {
        if (getString(KEY_BRANCH_KEY).equals(str)) {
            return false;
        }
        clearPrefOnBranchKeyChange();
        setString(KEY_BRANCH_KEY, str);
        if (Branch.getInstance() == null) {
            return true;
        }
        Branch.getInstance().linkCache_.clear();
        Branch.getInstance().requestQueue_.clear();
        return true;
    }

    public String getBranchKey() {
        return getString(KEY_BRANCH_KEY);
    }

    public void setRandomizedDeviceToken(String str) {
        setString(KEY_RANDOMIZED_DEVICE_TOKEN, str);
    }

    public String getRandomizedDeviceToken() {
        String string = getString(KEY_RANDOMIZED_DEVICE_TOKEN);
        return (TextUtils.isEmpty(string) || string.equals(NO_STRING_VALUE)) ? getString(KEY_DEVICE_FINGERPRINT_ID) : string;
    }

    public void setSessionID(String str) {
        setString(KEY_SESSION_ID, str);
    }

    public String getSessionID() {
        return getString(KEY_SESSION_ID);
    }

    public void setRandomizedBundleToken(String str) {
        setString(KEY_RANDOMIZED_BUNDLE_TOKEN, str);
    }

    public String getRandomizedBundleToken() {
        String string = getString(KEY_RANDOMIZED_BUNDLE_TOKEN);
        return (TextUtils.isEmpty(string) || string.equals(NO_STRING_VALUE)) ? getString(KEY_IDENTITY_ID) : string;
    }

    public void setIdentity(String str) {
        setString(KEY_IDENTITY, str);
    }

    public String getIdentity() {
        return getString(KEY_IDENTITY);
    }

    public void setLinkClickID(String str) {
        setString(KEY_LINK_CLICK_ID, str);
    }

    public void setRandomlyGeneratedUuid(String str) {
        setString(KEY_RANDOMLY_GENERATED_UUID, str);
    }

    public String getRandomlyGeneratedUuid() {
        return getString(KEY_RANDOMLY_GENERATED_UUID);
    }

    public void setAnonID(String str) {
        setString(KEY_ANON_ID, str);
    }

    public String getAnonID() {
        return getString(KEY_ANON_ID);
    }

    public String getLinkClickID() {
        return getString(KEY_LINK_CLICK_ID);
    }

    public void setAdNetworkCalloutsDisabled(boolean z) {
        setBool(KEY_AD_NETWORK_CALLOUTS_DISABLED, Boolean.valueOf(z));
    }

    public boolean getAdNetworkCalloutsDisabled() {
        return getBool(KEY_AD_NETWORK_CALLOUTS_DISABLED);
    }

    public void setExternalIntentUri(String str) {
        setString(KEY_EXTERNAL_INTENT_URI, str);
    }

    public String getExternalIntentUri() {
        return getString(KEY_EXTERNAL_INTENT_URI);
    }

    public void setExternalIntentExtra(String str) {
        setString(KEY_EXTERNAL_INTENT_EXTRA, str);
    }

    public String getExternalIntentExtra() {
        return getString(KEY_EXTERNAL_INTENT_EXTRA);
    }

    public void setLinkClickIdentifier(String str) {
        setString(KEY_LINK_CLICK_IDENTIFIER, str);
    }

    public String getLinkClickIdentifier() {
        return getString(KEY_LINK_CLICK_IDENTIFIER);
    }

    public void setGoogleSearchInstallIdentifier(String str) {
        setString(KEY_GOOGLE_SEARCH_INSTALL_IDENTIFIER, str);
    }

    public String getGoogleSearchInstallIdentifier() {
        return getString(KEY_GOOGLE_SEARCH_INSTALL_IDENTIFIER);
    }

    public void setAppStoreReferrer(String str) {
        setString(KEY_GOOGLE_PLAY_INSTALL_REFERRER_EXTRA, str);
    }

    public String getAppStoreReferrer() {
        return getString(KEY_GOOGLE_PLAY_INSTALL_REFERRER_EXTRA);
    }

    public void setAppStoreSource(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setString(KEY_APP_STORE_SOURCE, str);
    }

    public String getAppStoreSource() {
        return getString(KEY_APP_STORE_SOURCE);
    }

    public void setReferringUrlQueryParameters(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            setString(KEY_REFERRING_URL_QUERY_PARAMETERS, NO_STRING_VALUE);
        } else {
            setString(KEY_REFERRING_URL_QUERY_PARAMETERS, jSONObject.toString());
        }
    }

    public JSONObject getReferringURLQueryParameters() {
        String string = getString(KEY_REFERRING_URL_QUERY_PARAMETERS);
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(string) || NO_STRING_VALUE.equals(string)) {
            return jSONObject;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException e) {
            BranchLogger.w("Unable to get URL query parameters as string: " + e);
            return jSONObject;
        }
    }

    public void setReferrerGclid(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_GCLID_VALUE, str);
            jSONObject.put(KEY_GCLID_EXPIRATION_DATE, System.currentTimeMillis() + getReferrerGclidValidForWindow());
            setString(KEY_GCLID_JSON_OBJECT, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getReferrerGclid() {
        String str = KEY_GCLID_JSON_OBJECT;
        String string = getString(KEY_GCLID_JSON_OBJECT);
        if (string.equals(NO_STRING_VALUE)) {
            return NO_STRING_VALUE;
        }
        String str2 = null;
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (((Long) jSONObject.get(KEY_GCLID_EXPIRATION_DATE)).longValue() - System.currentTimeMillis() > 0) {
                str = jSONObject.getString(KEY_GCLID_VALUE);
                str2 = str;
            } else {
                removePrefValue(KEY_GCLID_JSON_OBJECT);
            }
        } catch (JSONException e) {
            removePrefValue(str);
            e.printStackTrace();
        }
        return str2;
    }

    public void clearGclid() {
        removePrefValue(KEY_GCLID_JSON_OBJECT);
    }

    public void setReferrerGclidValidForWindow(long j) {
        if (MAX_VALID_WINDOW_FOR_REFERRER_GCLID <= j || j < 0) {
            return;
        }
        setLong(KEY_GCLID_VALID_FOR_WINDOW, j);
    }

    public long getReferrerGclidValidForWindow() {
        return getLong(KEY_GCLID_VALID_FOR_WINDOW, DEFAULT_VALID_WINDOW_FOR_REFERRER_GCLID);
    }

    public void setAppLink(String str) {
        setString(KEY_APP_LINK, str);
    }

    public String getAppLink() {
        return getString(KEY_APP_LINK);
    }

    public void setIsFullAppConversion(boolean z) {
        setBool(KEY_IS_FULL_APP_CONVERSION, Boolean.valueOf(z));
    }

    public boolean isFullAppConversion() {
        return getBool(KEY_IS_FULL_APP_CONVERSION);
    }

    public void setPushIdentifier(String str) {
        setString(KEY_PUSH_IDENTIFIER, str);
    }

    public String getPushIdentifier() {
        return getString(KEY_PUSH_IDENTIFIER);
    }

    public String getSessionParams() {
        return getString(KEY_SESSION_PARAMS);
    }

    public void setSessionParams(String str) {
        setString(KEY_SESSION_PARAMS, str);
    }

    public String getInstallParams() {
        return getString(KEY_INSTALL_PARAMS);
    }

    public void setInstallParams(String str) {
        setString(KEY_INSTALL_PARAMS, str);
    }

    public void setInstallReferrerParams(String str) {
        setString(KEY_INSTALL_REFERRER, str);
    }

    public String getInstallReferrerParams() {
        return getString(KEY_INSTALL_REFERRER);
    }

    public void setUserURL(String str) {
        setString(KEY_USER_URL, str);
    }

    public String getUserURL() {
        return getString(KEY_USER_URL);
    }

    public void clearSystemReadStatus() {
        setLong(KEY_LAST_READ_SYSTEM, Calendar.getInstance().getTimeInMillis() / 1000);
    }

    void setLimitFacebookTracking(boolean z) {
        setBool(KEY_LIMIT_FACEBOOK_TRACKING, Boolean.valueOf(z));
    }

    boolean isAppTrackingLimited() {
        return getBool(KEY_LIMIT_FACEBOOK_TRACKING);
    }

    boolean isDMAParamsInitialized() {
        return hasPrefValue(KEY_DMA_EEA);
    }

    void setEEARegion(boolean z) {
        setBool(KEY_DMA_EEA, Boolean.valueOf(z));
    }

    boolean getEEARegion() {
        return getBool(KEY_DMA_EEA);
    }

    void setAdPersonalizationConsent(boolean z) {
        setBool(KEY_DMA_AD_PERSONALIZATION, Boolean.valueOf(z));
    }

    boolean getAdPersonalizationConsent() {
        return getBool(KEY_DMA_AD_PERSONALIZATION);
    }

    void setAdUserDataUsageConsent(boolean z) {
        setBool(KEY_DMA_AD_USER_DATA, Boolean.valueOf(z));
    }

    boolean getAdUserDataUsageConsent() {
        return getBool(KEY_DMA_AD_USER_DATA);
    }

    public void clearUserValues() {
        Iterator<String> it = getActions().iterator();
        while (it.hasNext()) {
            String next = it.next();
            setActionTotalCount(next, 0);
            setActionUniqueCount(next, 0);
        }
        setActions(new ArrayList<>());
    }

    private ArrayList<String> getActions() {
        String string = getString(KEY_ACTIONS);
        if (string.equals(NO_STRING_VALUE)) {
            return new ArrayList<>();
        }
        return deserializeString(string);
    }

    private void setActions(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            setString(KEY_ACTIONS, NO_STRING_VALUE);
        } else {
            setString(KEY_ACTIONS, serializeArrayList(arrayList));
        }
    }

    public void setActionTotalCount(String str, int i) {
        ArrayList<String> actions = getActions();
        if (!actions.contains(str)) {
            actions.add(str);
            setActions(actions);
        }
        setInteger(KEY_TOTAL_BASE + str, i);
    }

    public void setActionUniqueCount(String str, int i) {
        setInteger(KEY_UNIQUE_BASE + str, i);
    }

    public int getActionTotalCount(String str) {
        return getInteger(KEY_TOTAL_BASE + str);
    }

    public int getActionUniqueCount(String str) {
        return getInteger(KEY_UNIQUE_BASE + str);
    }

    public void setLATDAttributionWindow(int i) {
        setInteger(KEY_LATD_ATTRIBUTION_WINDOW, i);
    }

    public int getLATDAttributionWindow() {
        return getInteger(KEY_LATD_ATTRIBUTION_WINDOW, -1);
    }

    public void setInitialReferrer(String str) {
        setString(KEY_INITIAL_REFERRER, str);
    }

    public String getInitialReferrer() {
        return getString(KEY_INITIAL_REFERRER);
    }

    private String serializeArrayList(ArrayList<String> arrayList) {
        Iterator<String> it = arrayList.iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + it.next() + ",";
        }
        return str.substring(0, str.length() - 1);
    }

    private ArrayList<String> deserializeString(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, str.split(","));
        return arrayList;
    }

    public boolean hasPrefValue(String str) {
        return this.appSharedPrefs_.contains(str);
    }

    public void removePrefValue(String str) {
        this.prefsEditor_.remove(str).apply();
    }

    public int getInteger(String str) {
        return getInteger(str, 0);
    }

    public int getInteger(String str, int i) {
        return this.appSharedPrefs_.getInt(str, i);
    }

    public long getLong(String str) {
        return getLong(str, 0L);
    }

    public long getLong(String str, long j) {
        return this.appSharedPrefs_.getLong(str, j);
    }

    public float getFloat(String str) {
        return this.appSharedPrefs_.getFloat(str, 0.0f);
    }

    public String getString(String str) {
        return this.appSharedPrefs_.getString(str, NO_STRING_VALUE);
    }

    public boolean getBool(String str) {
        return this.appSharedPrefs_.getBoolean(str, false);
    }

    public void setInteger(String str, int i) {
        this.prefsEditor_.putInt(str, i).apply();
    }

    public void setLong(String str, long j) {
        this.prefsEditor_.putLong(str, j).apply();
    }

    public void setFloat(String str, float f) {
        this.prefsEditor_.putFloat(str, f).apply();
    }

    public void setString(String str, String str2) {
        this.prefsEditor_.putString(str, str2).apply();
    }

    public void setBool(String str, Boolean bool) {
        this.prefsEditor_.putBoolean(str, bool.booleanValue()).apply();
    }

    private void clearPrefOnBranchKeyChange() {
        String linkClickID = getLinkClickID();
        String linkClickIdentifier = getLinkClickIdentifier();
        String appLink = getAppLink();
        String pushIdentifier = getPushIdentifier();
        this.prefsEditor_.clear();
        setLinkClickID(linkClickID);
        setLinkClickIdentifier(linkClickIdentifier);
        setAppLink(appLink);
        setPushIdentifier(pushIdentifier);
        this.prefsEditor_.apply();
    }

    public void setRequestMetadata(String str, String str2) {
        if (str == null) {
            return;
        }
        if (this.requestMetadata.has(str) && str2 == null) {
            this.requestMetadata.remove(str);
        }
        try {
            this.requestMetadata.put(str, str2);
        } catch (JSONException unused) {
        }
    }

    public JSONObject getRequestMetadata() {
        return this.requestMetadata;
    }

    void addInstallMetadata(String str, String str2) {
        if (str == null) {
            return;
        }
        try {
            this.installMetadata.putOpt(str, str2);
        } catch (JSONException e) {
            BranchLogger.d(e.getMessage());
        }
    }

    String getInstallMetaData(String str) {
        if (str == null) {
            return null;
        }
        try {
            return this.installMetadata.get(str).toString();
        } catch (JSONException e) {
            BranchLogger.d(e.getMessage());
            return null;
        }
    }

    public JSONObject getInstallMetadata() {
        return this.installMetadata;
    }

    boolean shouldAddModules() {
        try {
            return this.secondaryRequestMetadata.length() != 0;
        } catch (Exception e) {
            BranchLogger.d(e.getMessage());
            return false;
        }
    }

    static void enableLogging(boolean z) {
        enableLogging_ = z;
    }

    static void useEUEndpoint(boolean z) {
        useEUEndpoint_ = z;
    }

    boolean hasValidBranchKey() {
        return isValidBranchKey(getBranchKey());
    }

    static boolean isValidBranchKey(String str) {
        if (str != null) {
            if (str.startsWith(BranchUtil.isTestModeEnabled() ? "key_test_" : "key_")) {
                return true;
            }
        }
        return false;
    }

    public void loadPartnerParams(JSONObject jSONObject) throws JSONException {
        loadPartnerParams(jSONObject, this.partnerParams_);
    }

    static void loadPartnerParams(JSONObject jSONObject, BranchPartnerParameters branchPartnerParameters) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, ConcurrentHashMap<String, String>> entry : branchPartnerParameters.allParams().entrySet()) {
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry<String, String> entry2 : entry.getValue().entrySet()) {
                jSONObject3.put(entry2.getKey(), entry2.getValue());
            }
            jSONObject2.put(entry.getKey(), jSONObject3);
        }
        jSONObject.put(Defines.Jsonkey.PartnerData.getKey(), jSONObject2);
    }
}
