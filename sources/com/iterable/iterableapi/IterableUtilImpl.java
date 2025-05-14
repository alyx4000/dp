package com.iterable.iterableapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.iterable.iterableapi.util.IOUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
class IterableUtilImpl {
    private static final String TAG = "IterableUtilImpl";

    boolean isValidCampaignId(long j) {
        return j >= 0;
    }

    IterableUtilImpl() {
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    String getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            IterableLogger.e(TAG, "Error while retrieving app version", e);
            return null;
        }
    }

    String getAppVersionCode(Context context) {
        try {
            return Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            IterableLogger.e(TAG, "Error while retrieving app version code", e);
            return null;
        }
    }

    int convertVersionStringToInt(String str) {
        String[] split = str.split("\\.");
        int i = 0;
        for (int i2 = 0; i2 < split.length; i2++) {
            i += ((int) Math.pow(10.0d, (2 - i2) * 3)) * Integer.parseInt(split[i2]);
        }
        return i;
    }

    void saveExpirableJsonObject(SharedPreferences sharedPreferences, String str, JSONObject jSONObject, long j) {
        saveExpirableValue(sharedPreferences, str, jSONObject.toString(), j);
    }

    void saveExpirableValue(SharedPreferences sharedPreferences, String str, String str2, long j) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(str + IterableConstants.SHARED_PREFS_OBJECT_SUFFIX, str2);
        edit.putLong(str + IterableConstants.SHARED_PREFS_EXPIRATION_SUFFIX, currentTimeMillis() + j);
        edit.apply();
    }

    String retrieveExpirableValue(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(str + IterableConstants.SHARED_PREFS_OBJECT_SUFFIX, null);
        long j = sharedPreferences.getLong(str + IterableConstants.SHARED_PREFS_EXPIRATION_SUFFIX, 0L);
        if (string == null || j < currentTimeMillis()) {
            return null;
        }
        return string;
    }

    JSONObject retrieveExpirableJsonObject(SharedPreferences sharedPreferences, String str) {
        try {
            String retrieveExpirableValue = retrieveExpirableValue(sharedPreferences, str);
            if (retrieveExpirableValue != null) {
                return new JSONObject(retrieveExpirableValue);
            }
            return null;
        } catch (Exception e) {
            IterableLogger.e(TAG, "Error while parsing an expirable object for key: " + str, e);
            return null;
        }
    }

    Long retrieveValidCampaignIdOrNull(JSONObject jSONObject, String str) {
        try {
            long j = jSONObject.getLong(str);
            if (isValidCampaignId(j)) {
                return Long.valueOf(j);
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    File getSdkCacheDir(Context context) {
        File file = new File(context.getCacheDir(), "com.iterable.sdk");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    File getSDKFilesDirectory(Context context) {
        File file = new File(context.getFilesDir(), "com.iterable.sdk");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    File getDirectory(File file, String str) {
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.io.BufferedReader, java.io.Closeable] */
    String readFile(File file) {
        InputStreamReader inputStreamReader;
        Closeable closeable;
        FileInputStream fileInputStream;
        ?? r3;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    r3 = new BufferedReader(inputStreamReader);
                } catch (Exception e) {
                    e = e;
                    r3 = 0;
                } catch (Throwable th) {
                    th = th;
                    r3 = 0;
                    fileInputStream2 = fileInputStream;
                    closeable = r3;
                    IOUtils.closeQuietly(fileInputStream2);
                    IOUtils.closeQuietly(inputStreamReader);
                    IOUtils.closeQuietly(closeable);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                inputStreamReader = null;
                r3 = inputStreamReader;
                IterableLogger.e(TAG, "Error while reading file: " + file.toString(), e);
                IOUtils.closeQuietly(fileInputStream);
                IOUtils.closeQuietly(inputStreamReader);
                IOUtils.closeQuietly(r3);
                return null;
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
                r3 = 0;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            inputStreamReader = null;
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
            closeable = null;
            IOUtils.closeQuietly(fileInputStream2);
            IOUtils.closeQuietly(inputStreamReader);
            IOUtils.closeQuietly(closeable);
            throw th;
        }
        try {
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = r3.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        String sb2 = sb.toString();
                        IOUtils.closeQuietly(fileInputStream);
                        IOUtils.closeQuietly(inputStreamReader);
                        IOUtils.closeQuietly(r3);
                        return sb2;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream2 = fileInputStream;
                closeable = r3;
                IOUtils.closeQuietly(fileInputStream2);
                IOUtils.closeQuietly(inputStreamReader);
                IOUtils.closeQuietly(closeable);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            IterableLogger.e(TAG, "Error while reading file: " + file.toString(), e);
            IOUtils.closeQuietly(fileInputStream);
            IOUtils.closeQuietly(inputStreamReader);
            IOUtils.closeQuietly(r3);
            return null;
        }
    }

    boolean writeFile(File file, String str) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
            outputStreamWriter.write(str);
            outputStreamWriter.close();
            return true;
        } catch (Exception e) {
            IterableLogger.e(TAG, "Error while writing to file: " + file.toString(), e);
            return false;
        }
    }

    static boolean isUrlOpenAllowed(String str) {
        String str2 = str.split("://")[0];
        if (str2.equals("https")) {
            return true;
        }
        for (String str3 : IterableApi.sharedInstance.config.allowedProtocols) {
            if (str2.equals(str3)) {
                return true;
            }
        }
        IterableLogger.d(TAG, str2 + " is not in the allowed protocols");
        return false;
    }
}
