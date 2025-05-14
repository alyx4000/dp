package com.iterable.iterableapi.ddl;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class DeviceInfo {
    private static final String MOBILE_DEVICE_TYPE = "Android";
    private DeviceFp deviceFp;

    private DeviceInfo(DeviceFp deviceFp) {
        this.deviceFp = deviceFp;
    }

    static class DeviceFp {
        String language;
        String screenHeight;
        String screenScale;
        String screenWidth;
        String timezoneOffsetMinutes;
        String version;

        DeviceFp() {
        }

        JSONObject toJSONObject() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("screenWidth", this.screenWidth);
            jSONObject.putOpt("screenHeight", this.screenHeight);
            jSONObject.putOpt("screenScale", this.screenScale);
            jSONObject.putOpt("version", this.version);
            jSONObject.putOpt("timezoneOffsetMinutes", this.timezoneOffsetMinutes);
            jSONObject.putOpt("language", this.language);
            return jSONObject;
        }
    }

    public static DeviceInfo createDeviceInfo(Context context) {
        return new DeviceInfo(createDeviceFp(context));
    }

    private static DeviceFp createDeviceFp(Context context) {
        DeviceFp deviceFp = new DeviceFp();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        deviceFp.screenWidth = Long.toString(Math.round(Math.ceil(displayMetrics.widthPixels / displayMetrics.density)));
        deviceFp.screenHeight = Long.toString(Math.round(Math.ceil(displayMetrics.heightPixels / displayMetrics.density)));
        deviceFp.screenScale = Float.toString(displayMetrics.density);
        deviceFp.version = Build.VERSION.RELEASE;
        deviceFp.timezoneOffsetMinutes = Integer.toString(((TimeZone.getDefault().getOffset(new Date().getTime()) * (-1)) / 1000) / 60);
        deviceFp.language = Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
        return deviceFp;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mobileDeviceType", "Android");
        jSONObject.put("deviceFp", this.deviceFp.toJSONObject());
        return jSONObject;
    }
}
