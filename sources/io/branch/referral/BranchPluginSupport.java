package io.branch.referral;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import io.branch.referral.Defines;
import io.branch.referral.SystemObserver;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class BranchPluginSupport {
    private final Context context_;
    private final SystemObserver systemObserver_ = new SystemObserverInstance();

    public static BranchPluginSupport getInstance() {
        Branch branch = Branch.getInstance();
        if (branch == null) {
            return null;
        }
        return branch.getBranchPluginSupport();
    }

    BranchPluginSupport(Context context) {
        this.context_ = context;
    }

    public Map<String, Object> deviceDescription() {
        HashMap hashMap = new HashMap();
        String os = SystemObserver.getOS(this.context_);
        if (!isNullOrEmptyOrBlank(os)) {
            hashMap.put(Defines.Jsonkey.OS.getKey(), os);
        }
        hashMap.put(Defines.Jsonkey.OSVersionAndroid.getKey(), SystemObserver.getOSVersion());
        SystemObserver.UniqueId hardwareID = getHardwareID();
        if (!isNullOrEmptyOrBlank(hardwareID.getId())) {
            hashMap.put(Defines.Jsonkey.AndroidID.getKey(), hardwareID.getId());
            hashMap.put(Defines.Jsonkey.IsHardwareIDReal.getKey(), Boolean.valueOf(hardwareID.isReal()));
        } else {
            hashMap.put(Defines.Jsonkey.UnidentifiedDevice.getKey(), true);
        }
        String iSO2CountryCode = SystemObserver.getISO2CountryCode();
        if (!TextUtils.isEmpty(iSO2CountryCode)) {
            hashMap.put(Defines.Jsonkey.Country.getKey(), iSO2CountryCode);
        }
        String iSO2LanguageCode = SystemObserver.getISO2LanguageCode();
        if (!TextUtils.isEmpty(iSO2LanguageCode)) {
            hashMap.put(Defines.Jsonkey.Language.getKey(), iSO2LanguageCode);
        }
        String localIPAddress = SystemObserver.getLocalIPAddress();
        if (!TextUtils.isEmpty(localIPAddress)) {
            hashMap.put(Defines.Jsonkey.LocalIP.getKey(), localIPAddress);
        }
        String phoneBrand = SystemObserver.getPhoneBrand();
        if (!isNullOrEmptyOrBlank(phoneBrand)) {
            hashMap.put(Defines.Jsonkey.Brand.getKey(), phoneBrand);
        }
        hashMap.put(Defines.Jsonkey.AppVersion.getKey(), SystemObserver.getAppVersion(this.context_));
        String phoneModel = SystemObserver.getPhoneModel();
        if (!isNullOrEmptyOrBlank(phoneModel)) {
            hashMap.put(Defines.Jsonkey.Model.getKey(), phoneModel);
        }
        DisplayMetrics screenDisplay = SystemObserver.getScreenDisplay(this.context_);
        hashMap.put(Defines.Jsonkey.ScreenDpi.getKey(), Integer.valueOf(screenDisplay.densityDpi));
        hashMap.put(Defines.Jsonkey.ScreenHeight.getKey(), Integer.valueOf(screenDisplay.heightPixels));
        hashMap.put(Defines.Jsonkey.ScreenWidth.getKey(), Integer.valueOf(screenDisplay.widthPixels));
        return hashMap;
    }

    public SystemObserver.UniqueId getHardwareID() {
        getSystemObserver();
        return SystemObserver.getUniqueID(this.context_, Branch.isDeviceIDFetchDisabled());
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
