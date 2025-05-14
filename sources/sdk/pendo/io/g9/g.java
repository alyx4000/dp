package sdk.pendo.io.g9;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.logging.PendoLogger;

/* loaded from: classes6.dex */
public final class g {
    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cpuUsage", Float.toString(l()));
            jSONObject.put("cpuCount", Integer.toString(j()));
            jSONObject.put("availableMemory", Long.toString(e()));
            jSONObject.put("appUsedMemorySize", Long.toString(d()));
            jSONObject.put("appFreeMemorySize", Long.toString(b()));
            jSONObject.put("appTotalMemorySize", Long.toString(c()));
            jSONObject.put("systemUpTime", Long.toString(k()));
            jSONObject.put("batterUsage", Float.toString(f()));
            jSONObject.put("networkType", i());
            jSONObject.put("deviceOrientation", g());
        } catch (JSONException e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
        return jSONObject;
    }

    public static long b() {
        try {
            return Runtime.getRuntime().freeMemory();
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
            return 0L;
        }
    }

    public static long c() {
        try {
            return Runtime.getRuntime().totalMemory();
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
            return 0L;
        }
    }

    public static long d() {
        try {
            Runtime runtime = Runtime.getRuntime();
            return runtime.totalMemory() - runtime.freeMemory();
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
            return -1L;
        }
    }

    public static long e() {
        return h().availMem / 1048576;
    }

    public static float f() {
        int i;
        int i2;
        Intent registerReceiver = PendoInternal.m().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            i2 = registerReceiver.getIntExtra("level", -1);
            i = registerReceiver.getIntExtra("scale", -1);
        } else {
            i = -1;
            i2 = -1;
        }
        if (i2 == -1 || i == -1) {
            return 0.0f;
        }
        return (i2 / i) * 100.0f;
    }

    public static String g() {
        return g0.a(PendoInternal.m().getResources().getConfiguration().orientation);
    }

    private static ActivityManager.MemoryInfo h() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) PendoInternal.m().getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public static String i() {
        switch (((TelephonyManager) PendoInternal.m().getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getNetworkType()) {
            case 0:
                return "Unknown";
            case 1:
                return "GPRS";
            case 2:
                return "EDGE";
            case 3:
                return "UMTS";
            case 4:
                return "CDMA";
            case 5:
                return "EVDO rev. 0";
            case 6:
                return "EVDO rev. A";
            case 7:
                return "1xRTT";
            case 8:
                return "HSDPA";
            case 9:
                return "HSUPA";
            case 10:
                return "HSPA";
            case 11:
                return "iDen";
            case 12:
                return "EVDO rev. B";
            case 13:
                return "LTE";
            case 14:
                return "eHRPD";
            case 15:
                return "HSPA+";
            case 16:
                return "GSM";
            case 17:
                return "TD_SCDMA";
            case 18:
                return "IWLAN";
            default:
                return "Unknown network type";
        }
    }

    public static int j() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static long k() {
        return SystemClock.uptimeMillis();
    }

    public static float l() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/stat", "r");
            try {
                String[] split = randomAccessFile.readLine().split(" ");
                long parseLong = Long.parseLong(split[5]);
                long parseLong2 = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
                try {
                    Thread.sleep(360L);
                } catch (Exception e) {
                    PendoLogger.i(e, e.getMessage(), new Object[0]);
                }
                randomAccessFile.seek(0L);
                String[] split2 = randomAccessFile.readLine().split(" ");
                long parseLong3 = Long.parseLong(split2[5]);
                long parseLong4 = Long.parseLong(split2[2]) + Long.parseLong(split2[3]) + Long.parseLong(split2[4]) + Long.parseLong(split2[6]) + Long.parseLong(split2[7]) + Long.parseLong(split2[8]);
                float f = (parseLong4 - parseLong2) / ((parseLong4 + parseLong3) - (parseLong2 + parseLong));
                randomAccessFile.close();
                return f;
            } finally {
            }
        } catch (IOException e2) {
            PendoLogger.e(e2, e2.getMessage(), new Object[0]);
            return 0.0f;
        }
    }
}
