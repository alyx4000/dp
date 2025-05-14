package io.branch.referral;

import android.app.UiModeManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.amplitude.reactnative.AndroidContextProvider;
import io.branch.referral.Defines;
import io.branch.referral.SystemObserver;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class DeviceInfo {
    private final Context context_;
    private final SystemObserver systemObserver_ = new SystemObserverInstance();

    static DeviceInfo getInstance() {
        Branch branch = Branch.getInstance();
        if (branch == null) {
            return null;
        }
        return branch.getDeviceInfo();
    }

    DeviceInfo(Context context) {
        this.context_ = context;
    }

    void updateRequestWithV1Params(ServerRequest serverRequest, JSONObject jSONObject) {
        try {
            SystemObserver.UniqueId hardwareID = getHardwareID();
            if (!isNullOrEmptyOrBlank(hardwareID.getId())) {
                jSONObject.put(Defines.Jsonkey.HardwareID.getKey(), hardwareID.getId());
                jSONObject.put(Defines.Jsonkey.IsHardwareIDReal.getKey(), hardwareID.isReal());
            }
            String anonID = SystemObserver.getAnonID(this.context_);
            if (!isNullOrEmptyOrBlank(anonID)) {
                jSONObject.put(Defines.Jsonkey.AnonID.getKey(), anonID);
            }
            String phoneBrand = SystemObserver.getPhoneBrand();
            if (!isNullOrEmptyOrBlank(phoneBrand)) {
                jSONObject.put(Defines.Jsonkey.Brand.getKey(), phoneBrand);
            }
            String phoneModel = SystemObserver.getPhoneModel();
            if (!isNullOrEmptyOrBlank(phoneModel)) {
                jSONObject.put(Defines.Jsonkey.Model.getKey(), phoneModel);
            }
            DisplayMetrics screenDisplay = SystemObserver.getScreenDisplay(this.context_);
            jSONObject.put(Defines.Jsonkey.ScreenDpi.getKey(), screenDisplay.densityDpi);
            jSONObject.put(Defines.Jsonkey.ScreenHeight.getKey(), screenDisplay.heightPixels);
            jSONObject.put(Defines.Jsonkey.ScreenWidth.getKey(), screenDisplay.widthPixels);
            jSONObject.put(Defines.Jsonkey.WiFi.getKey(), SystemObserver.getWifiConnected(this.context_));
            jSONObject.put(Defines.Jsonkey.UIMode.getKey(), SystemObserver.getUIMode(this.context_));
            String os = SystemObserver.getOS(this.context_);
            if (!isNullOrEmptyOrBlank(os)) {
                jSONObject.put(Defines.Jsonkey.OS.getKey(), os);
            }
            jSONObject.put(Defines.Jsonkey.APILevel.getKey(), SystemObserver.getAPILevel());
            if (Branch.getPluginName() != null) {
                jSONObject.put(Defines.Jsonkey.PluginName.getKey(), Branch.getPluginName());
                jSONObject.put(Defines.Jsonkey.PluginVersion.getKey(), Branch.getPluginVersion());
            }
            String iSO2CountryCode = SystemObserver.getISO2CountryCode();
            if (!TextUtils.isEmpty(iSO2CountryCode)) {
                jSONObject.put(Defines.Jsonkey.Country.getKey(), iSO2CountryCode);
            }
            String iSO2LanguageCode = SystemObserver.getISO2LanguageCode();
            if (!TextUtils.isEmpty(iSO2LanguageCode)) {
                jSONObject.put(Defines.Jsonkey.Language.getKey(), iSO2LanguageCode);
            }
            String localIPAddress = SystemObserver.getLocalIPAddress();
            if (!TextUtils.isEmpty(localIPAddress)) {
                jSONObject.put(Defines.Jsonkey.LocalIP.getKey(), localIPAddress);
            }
            if (serverRequest.isInitializationOrEventRequest()) {
                jSONObject.put(Defines.Jsonkey.CPUType.getKey(), SystemObserver.getCPUType());
                jSONObject.put(Defines.Jsonkey.DeviceBuildId.getKey(), SystemObserver.getDeviceBuildId());
                jSONObject.put(Defines.Jsonkey.Locale.getKey(), SystemObserver.getLocale());
                jSONObject.put(Defines.Jsonkey.ConnectionType.getKey(), SystemObserver.getConnectionType(this.context_));
                jSONObject.put(Defines.Jsonkey.DeviceCarrier.getKey(), SystemObserver.getCarrier(this.context_));
                jSONObject.put(Defines.Jsonkey.OSVersionAndroid.getKey(), SystemObserver.getOSVersion());
            }
        } catch (JSONException e) {
            BranchLogger.d(e.getMessage());
        }
    }

    boolean isTV() {
        UiModeManager uiModeManager = (UiModeManager) this.context_.getSystemService("uimode");
        if (uiModeManager != null) {
            return uiModeManager.getCurrentModeType() == 4;
        }
        BranchLogger.v("uiModeManager is null, mark this as a non-TV device by default.");
        return false;
    }

    void updateRequestWithV2Params(ServerRequest serverRequest, PrefHelper prefHelper, JSONObject jSONObject) {
        try {
            SystemObserver.UniqueId hardwareID = getHardwareID();
            if (!isNullOrEmptyOrBlank(hardwareID.getId())) {
                jSONObject.put(Defines.Jsonkey.AndroidID.getKey(), hardwareID.getId());
            }
            String anonID = SystemObserver.getAnonID(this.context_);
            if (!isNullOrEmptyOrBlank(anonID)) {
                jSONObject.put(Defines.Jsonkey.AnonID.getKey(), anonID);
            }
            String phoneBrand = SystemObserver.getPhoneBrand();
            if (!isNullOrEmptyOrBlank(phoneBrand)) {
                jSONObject.put(Defines.Jsonkey.Brand.getKey(), phoneBrand);
            }
            String phoneModel = SystemObserver.getPhoneModel();
            if (!isNullOrEmptyOrBlank(phoneModel)) {
                jSONObject.put(Defines.Jsonkey.Model.getKey(), phoneModel);
            }
            DisplayMetrics screenDisplay = SystemObserver.getScreenDisplay(this.context_);
            jSONObject.put(Defines.Jsonkey.ScreenDpi.getKey(), screenDisplay.densityDpi);
            jSONObject.put(Defines.Jsonkey.ScreenHeight.getKey(), screenDisplay.heightPixels);
            jSONObject.put(Defines.Jsonkey.ScreenWidth.getKey(), screenDisplay.widthPixels);
            jSONObject.put(Defines.Jsonkey.UIMode.getKey(), SystemObserver.getUIMode(this.context_));
            String os = SystemObserver.getOS(this.context_);
            if (!isNullOrEmptyOrBlank(os)) {
                jSONObject.put(Defines.Jsonkey.OS.getKey(), os);
            }
            jSONObject.put(Defines.Jsonkey.APILevel.getKey(), SystemObserver.getAPILevel());
            if (Branch.getPluginName() != null) {
                jSONObject.put(Defines.Jsonkey.PluginName.getKey(), Branch.getPluginName());
                jSONObject.put(Defines.Jsonkey.PluginVersion.getKey(), Branch.getPluginVersion());
            }
            String iSO2CountryCode = SystemObserver.getISO2CountryCode();
            if (!TextUtils.isEmpty(iSO2CountryCode)) {
                jSONObject.put(Defines.Jsonkey.Country.getKey(), iSO2CountryCode);
            }
            String iSO2LanguageCode = SystemObserver.getISO2LanguageCode();
            if (!TextUtils.isEmpty(iSO2LanguageCode)) {
                jSONObject.put(Defines.Jsonkey.Language.getKey(), iSO2LanguageCode);
            }
            String localIPAddress = SystemObserver.getLocalIPAddress();
            if (!TextUtils.isEmpty(localIPAddress)) {
                jSONObject.put(Defines.Jsonkey.LocalIP.getKey(), localIPAddress);
            }
            if (prefHelper != null) {
                if (!isNullOrEmptyOrBlank(prefHelper.getRandomizedDeviceToken())) {
                    jSONObject.put(Defines.Jsonkey.RandomizedDeviceToken.getKey(), prefHelper.getRandomizedDeviceToken());
                }
                String identity = prefHelper.getIdentity();
                if (!isNullOrEmptyOrBlank(identity)) {
                    jSONObject.put(Defines.Jsonkey.DeveloperIdentity.getKey(), identity);
                }
                Object appStoreSource = prefHelper.getAppStoreSource();
                if (!PrefHelper.NO_STRING_VALUE.equals(appStoreSource)) {
                    jSONObject.put(Defines.Jsonkey.App_Store.getKey(), appStoreSource);
                }
            }
            jSONObject.put(Defines.Jsonkey.AppVersion.getKey(), getAppVersion());
            jSONObject.put(Defines.Jsonkey.SDK.getKey(), AndroidContextProvider.OS_NAME);
            jSONObject.put(Defines.Jsonkey.SdkVersion.getKey(), Branch.getSdkVersionNumber());
            jSONObject.put(Defines.Jsonkey.UserAgent.getKey(), getDefaultBrowserAgent(this.context_));
            if (serverRequest instanceof ServerRequestGetLATD) {
                jSONObject.put(Defines.Jsonkey.LATDAttributionWindow.getKey(), ((ServerRequestGetLATD) serverRequest).getAttributionWindow());
            }
            if (serverRequest.isInitializationOrEventRequest()) {
                jSONObject.put(Defines.Jsonkey.CPUType.getKey(), SystemObserver.getCPUType());
                jSONObject.put(Defines.Jsonkey.DeviceBuildId.getKey(), SystemObserver.getDeviceBuildId());
                jSONObject.put(Defines.Jsonkey.Locale.getKey(), SystemObserver.getLocale());
                jSONObject.put(Defines.Jsonkey.ConnectionType.getKey(), SystemObserver.getConnectionType(this.context_));
                jSONObject.put(Defines.Jsonkey.DeviceCarrier.getKey(), SystemObserver.getCarrier(this.context_));
                jSONObject.put(Defines.Jsonkey.OSVersionAndroid.getKey(), SystemObserver.getOSVersion());
            }
        } catch (JSONException e) {
            BranchLogger.d(e.getMessage());
        }
    }

    public String getPackageName() {
        return SystemObserver.getPackageName(this.context_);
    }

    public String getAppVersion() {
        return SystemObserver.getAppVersion(this.context_);
    }

    public long getFirstInstallTime() {
        return SystemObserver.getFirstInstallTime(this.context_);
    }

    public long getLastUpdateTime() {
        return SystemObserver.getLastUpdateTime(this.context_);
    }

    public boolean isPackageInstalled() {
        return SystemObserver.isPackageInstalled(this.context_);
    }

    public SystemObserver.UniqueId getHardwareID() {
        getSystemObserver();
        return SystemObserver.getUniqueID(this.context_, Branch.isDeviceIDFetchDisabled());
    }

    public String getOsName() {
        return SystemObserver.getOS(this.context_);
    }

    String getDefaultBrowserAgent(Context context) {
        if (!TextUtils.isEmpty(Branch._userAgentString)) {
            return Branch._userAgentString;
        }
        try {
            BranchLogger.v("Retrieving user agent string from WebSettings");
            Branch._userAgentString = WebSettings.getDefaultUserAgent(context);
        } catch (Exception e) {
            BranchLogger.v(e.getMessage());
        }
        return Branch._userAgentString;
    }

    String getUserAgentStringSync(final Context context) {
        if (!TextUtils.isEmpty(Branch._userAgentString)) {
            return Branch._userAgentString;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.branch.referral.DeviceInfo.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BranchLogger.v("Running WebView initialization for user agent on thread " + Thread.currentThread());
                    WebView webView = new WebView(context);
                    Branch._userAgentString = webView.getSettings().getUserAgentString();
                    webView.destroy();
                } catch (Exception e) {
                    BranchLogger.v(e.getMessage());
                }
            }
        });
        return Branch._userAgentString;
    }

    private class SystemObserverInstance extends SystemObserver {
        public SystemObserverInstance() {
        }
    }

    SystemObserver getSystemObserver() {
        return this.systemObserver_;
    }

    public static boolean isNullOrEmptyOrBlank(String str) {
        return TextUtils.isEmpty(str) || str.equals(PrefHelper.NO_STRING_VALUE);
    }
}
