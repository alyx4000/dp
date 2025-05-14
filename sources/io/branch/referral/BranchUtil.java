package io.branch.referral;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import io.branch.referral.BranchJsonConfig;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BranchUtil {
    private static boolean isTestModeEnabled_ = false;
    private static Boolean testModeEnabledViaCompileTimeConfiguration;

    static void shutDown() {
        isTestModeEnabled_ = false;
        testModeEnabledViaCompileTimeConfiguration = null;
    }

    static boolean checkTestMode(Context context) {
        if (!isTestModeEnabled_ && testModeEnabledViaCompileTimeConfiguration == null) {
            BranchJsonConfig branchJsonConfig = BranchJsonConfig.getInstance(context);
            if (branchJsonConfig.isValid(BranchJsonConfig.BranchJsonKey.useTestInstance)) {
                Boolean useTestInstance = branchJsonConfig.getUseTestInstance();
                isTestModeEnabled_ = useTestInstance != null ? useTestInstance.booleanValue() : false;
            } else {
                isTestModeEnabled_ = readTestMode(context);
            }
            testModeEnabledViaCompileTimeConfiguration = Boolean.valueOf(isTestModeEnabled_);
        }
        return isTestModeEnabled_;
    }

    private static boolean readTestMode(Context context) {
        boolean parseBoolean;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData != null && applicationInfo.metaData.containsKey("io.branch.sdk.TestMode")) {
                parseBoolean = applicationInfo.metaData.getBoolean("io.branch.sdk.TestMode", false);
            } else {
                Resources resources = context.getResources();
                parseBoolean = Boolean.parseBoolean(resources.getString(resources.getIdentifier("io.branch.sdk.TestMode", "string", context.getPackageName())));
            }
            return parseBoolean;
        } catch (Exception unused) {
            return isTestModeEnabled_;
        }
    }

    public static String readBranchKey(Context context) {
        BranchJsonConfig branchJsonConfig = BranchJsonConfig.getInstance(context);
        String branchKey = branchJsonConfig.isValid() ? branchJsonConfig.getBranchKey() : null;
        if (branchKey != null) {
            return branchKey;
        }
        String str = isTestModeEnabled() ? "io.branch.sdk.BranchKey.test" : "io.branch.sdk.BranchKey";
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData != null && (branchKey = applicationInfo.metaData.getString(str)) == null && isTestModeEnabled()) {
                branchKey = applicationInfo.metaData.getString("io.branch.sdk.BranchKey");
            }
        } catch (PackageManager.NameNotFoundException e) {
            BranchLogger.d(e.getMessage());
        }
        if (branchKey != null) {
            return branchKey;
        }
        Resources resources = context.getResources();
        return resources.getString(resources.getIdentifier(str, "string", context.getPackageName()));
    }

    public static boolean getEnableLoggingConfig(Context context) {
        BranchJsonConfig branchJsonConfig = BranchJsonConfig.getInstance(context);
        if (branchJsonConfig.isValid()) {
            return Boolean.TRUE.equals(branchJsonConfig.getEnableLogging());
        }
        return false;
    }

    public static boolean getDeferInitForPluginRuntimeConfig(Context context) {
        BranchJsonConfig branchJsonConfig = BranchJsonConfig.getInstance(context);
        if (branchJsonConfig.isValid()) {
            return Boolean.TRUE.equals(branchJsonConfig.getDeferInitForPluginRuntime());
        }
        return false;
    }

    public static boolean isTestModeEnabled() {
        return isTestModeEnabled_;
    }

    static void setTestMode(boolean z) {
        isTestModeEnabled_ = z;
    }

    public static String decodeResourceId(Context context, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return context.getResources().getString(i);
        } catch (Exception e) {
            BranchLogger.d(e.getMessage());
            return null;
        }
    }

    public static class JsonReader {
        private final JSONObject jsonObject;

        public JsonReader(JSONObject jSONObject) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2 = new JSONObject(jSONObject.toString());
            } catch (JSONException e) {
                BranchLogger.d(e.getMessage());
            }
            this.jsonObject = jSONObject2;
        }

        public JSONObject getJsonObject() {
            return this.jsonObject;
        }

        public int readOutInt(String str) {
            int optInt = this.jsonObject.optInt(str);
            this.jsonObject.remove(str);
            return optInt;
        }

        public Integer readOutInt(String str, Integer num) {
            if (!this.jsonObject.has(str)) {
                return num;
            }
            Integer valueOf = Integer.valueOf(this.jsonObject.optInt(str));
            this.jsonObject.remove(str);
            return valueOf;
        }

        public String readOutString(String str) {
            String optString = this.jsonObject.optString(str);
            this.jsonObject.remove(str);
            return optString;
        }

        public String readOutString(String str, String str2) {
            String optString = this.jsonObject.optString(str, str2);
            this.jsonObject.remove(str);
            return optString;
        }

        public long readOutLong(String str) {
            long optLong = this.jsonObject.optLong(str);
            this.jsonObject.remove(str);
            return optLong;
        }

        public double readOutDouble(String str) {
            double optDouble = this.jsonObject.optDouble(str);
            this.jsonObject.remove(str);
            return optDouble;
        }

        public Double readOutDouble(String str, Double d) {
            if (!this.jsonObject.has(str)) {
                return d;
            }
            Double valueOf = Double.valueOf(this.jsonObject.optDouble(str));
            this.jsonObject.remove(str);
            return valueOf;
        }

        public boolean readOutBoolean(String str) {
            boolean optBoolean = this.jsonObject.optBoolean(str);
            this.jsonObject.remove(str);
            return optBoolean;
        }

        public JSONArray readOutJsonArray(String str) {
            JSONArray optJSONArray = this.jsonObject.optJSONArray(str);
            this.jsonObject.remove(str);
            return optJSONArray;
        }

        public Object readOut(String str) {
            Object opt = this.jsonObject.opt(str);
            this.jsonObject.remove(str);
            return opt;
        }

        public boolean has(String str) {
            return this.jsonObject.has(str);
        }

        public Iterator<String> keys() {
            return this.jsonObject.keys();
        }
    }

    public static Drawable getDrawable(Context context, int i) {
        return context.getResources().getDrawable(i, context.getTheme());
    }

    public static int dpToPx(Context context, int i) {
        return Math.round(i * (context.getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    public static boolean isLowOnMemory(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0076 A[Catch: IOException -> 0x0072, TRY_LEAVE, TryCatch #3 {IOException -> 0x0072, blocks: (B:34:0x006e, B:27:0x0076), top: B:33:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject getDeepLinkSchemes(android.content.Context r5) {
        /*
            boolean r0 = isLowOnMemory(r5)
            r1 = 0
            if (r0 != 0) goto L82
            java.util.jar.JarFile r0 = new java.util.jar.JarFile     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
            android.content.pm.PackageManager r2 = r5.getPackageManager()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
            java.lang.String r3 = r5.getPackageName()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
            r4 = 0
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo(r3, r4)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
            java.lang.String r2 = r2.publicSourceDir     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
            java.lang.String r2 = "AndroidManifest.xml"
            java.util.zip.ZipEntry r2 = r0.getEntry(r2)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.io.InputStream r2 = r0.getInputStream(r2)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            int r3 = r2.available()     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L6a
            byte[] r3 = new byte[r3]     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L6a
            r2.read(r3)     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L6a
            io.branch.referral.ApkParser r4 = new io.branch.referral.ApkParser     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L6a
            r4.<init>()     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L6a
            org.json.JSONObject r1 = r4.decompressXMLForValidator(r3, r5)     // Catch: java.lang.Exception -> L4b java.lang.Throwable -> L6a
            if (r2 == 0) goto L3f
            r2.close()     // Catch: java.io.IOException -> L3d
            goto L3f
        L3d:
            r5 = move-exception
            goto L43
        L3f:
            r0.close()     // Catch: java.io.IOException -> L3d
            goto L82
        L43:
            java.lang.String r5 = r5.getMessage()
            io.branch.referral.BranchLogger.d(r5)
            goto L82
        L4b:
            r5 = move-exception
            goto L58
        L4d:
            r5 = move-exception
            goto L6c
        L4f:
            r5 = move-exception
            r2 = r1
            goto L58
        L52:
            r5 = move-exception
            r0 = r1
            goto L6c
        L55:
            r5 = move-exception
            r0 = r1
            r2 = r0
        L58:
            java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Throwable -> L6a
            io.branch.referral.BranchLogger.d(r5)     // Catch: java.lang.Throwable -> L6a
            if (r2 == 0) goto L64
            r2.close()     // Catch: java.io.IOException -> L3d
        L64:
            if (r0 == 0) goto L82
            r0.close()     // Catch: java.io.IOException -> L3d
            goto L82
        L6a:
            r5 = move-exception
            r1 = r2
        L6c:
            if (r1 == 0) goto L74
            r1.close()     // Catch: java.io.IOException -> L72
            goto L74
        L72:
            r0 = move-exception
            goto L7a
        L74:
            if (r0 == 0) goto L81
            r0.close()     // Catch: java.io.IOException -> L72
            goto L81
        L7a:
            java.lang.String r0 = r0.getMessage()
            io.branch.referral.BranchLogger.d(r0)
        L81:
            throw r5
        L82:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.BranchUtil.getDeepLinkSchemes(android.content.Context):org.json.JSONObject");
    }
}
