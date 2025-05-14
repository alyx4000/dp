package com.iterable.iterableapi.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.iterable.iterableapi.IterableConstants;
import com.iterable.iterableapi.IterableUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class DeviceInfoUtils {
    private DeviceInfoUtils() {
    }

    public static boolean isFireTV(PackageManager packageManager) {
        return Build.MODEL.matches("AFTN") || packageManager.hasSystemFeature("amazon.hardware.fire_tv");
    }

    public static void populateDeviceDetails(JSONObject jSONObject, Context context, String str) throws JSONException {
        jSONObject.put("brand", Build.BRAND);
        jSONObject.put("manufacturer", Build.MANUFACTURER);
        jSONObject.put(IterableConstants.DEVICE_SYSTEM_NAME, Build.DEVICE);
        jSONObject.put("systemVersion", Build.VERSION.RELEASE);
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("sdkVersion", Build.VERSION.SDK_INT);
        jSONObject.put(IterableConstants.DEVICE_ID, str);
        jSONObject.put(IterableConstants.DEVICE_APP_PACKAGE_NAME, context.getPackageName());
        jSONObject.put("appVersion", IterableUtil.getAppVersion(context));
        jSONObject.put("appBuild", IterableUtil.getAppVersionCode(context));
        jSONObject.put(IterableConstants.DEVICE_ITERABLE_SDK_VERSION, "3.4.16");
    }
}
