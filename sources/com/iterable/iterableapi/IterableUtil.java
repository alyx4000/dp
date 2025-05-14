package com.iterable.iterableapi;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class IterableUtil {
    static IterableUtilImpl instance = new IterableUtilImpl();

    private IterableUtil() {
    }

    static long currentTimeMillis() {
        return instance.currentTimeMillis();
    }

    public static String getAppVersion(Context context) {
        return instance.getAppVersion(context);
    }

    public static String getAppVersionCode(Context context) {
        return instance.getAppVersionCode(context);
    }

    static int convertVersionStringToInt(String str) {
        return instance.convertVersionStringToInt(str);
    }

    static void saveExpirableJsonObject(SharedPreferences sharedPreferences, String str, JSONObject jSONObject, long j) {
        instance.saveExpirableJsonObject(sharedPreferences, str, jSONObject, j);
    }

    static void saveExpirableValue(SharedPreferences sharedPreferences, String str, String str2, long j) {
        instance.saveExpirableValue(sharedPreferences, str, str2, j);
    }

    static String retrieveExpirableValue(SharedPreferences sharedPreferences, String str) {
        return instance.retrieveExpirableValue(sharedPreferences, str);
    }

    static JSONObject retrieveExpirableJsonObject(SharedPreferences sharedPreferences, String str) {
        return instance.retrieveExpirableJsonObject(sharedPreferences, str);
    }

    static Long retrieveValidCampaignIdOrNull(JSONObject jSONObject, String str) {
        return instance.retrieveValidCampaignIdOrNull(jSONObject, str);
    }

    static boolean isValidCampaignId(long j) {
        return instance.isValidCampaignId(j);
    }

    static File getSdkCacheDir(Context context) {
        return instance.getSdkCacheDir(context);
    }

    static File getSDKFilesDirectory(Context context) {
        return instance.getSDKFilesDirectory(context);
    }

    static File getDirectory(File file, String str) {
        return instance.getDirectory(file, str);
    }

    static String readFile(File file) {
        return instance.readFile(file);
    }

    static boolean writeFile(File file, String str) {
        return instance.writeFile(file, str);
    }

    static boolean isUrlOpenAllowed(String str) {
        return IterableUtilImpl.isUrlOpenAllowed(str);
    }
}
