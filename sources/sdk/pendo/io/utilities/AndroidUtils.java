package sdk.pendo.io.utilities;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.util.Base64;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.content.pm.PackageInfoCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.common.callercontext.ContextChain;
import com.iterable.iterableapi.IterableConstants;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.g9.i0;
import sdk.pendo.io.g9.j0;
import sdk.pendo.io.logging.PendoLogger;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001d\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b4\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0007J\u0014\u0010\b\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007J\u0006\u0010\b\u001a\u00020\rJ\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u000eR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u000eR\u0018\u0010 \u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010&\u001a\u0004\b\u001c\u0010$R\u001a\u0010*\u001a\u00020\r8FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010&\u001a\u0004\b\u0010\u0010(R\u001c\u0010,\u001a\u0004\u0018\u00010\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010&\u001a\u0004\b\u0013\u0010$R\u001a\u0010/\u001a\u00020\u00188FX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010&\u001a\u0004\b\u001e\u0010-R\u001a\u00101\u001a\u00020\r8FX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010&\u001a\u0004\b\u0016\u0010(R\u001a\u00103\u001a\u00020\r8FX\u0087\u0004¢\u0006\f\u0012\u0004\b2\u0010&\u001a\u0004\b\u0019\u0010(¨\u00065"}, d2 = {"Lsdk/pendo/io/utilities/AndroidUtils;", "", "", "permission", "", "b", "Landroid/app/Activity;", "activity", "a", "string", "Landroid/content/Context;", "context", "Landroid/app/Application;", "", "Ljava/lang/String;", "OS_VERSION", "c", "Ljava/lang/Object;", "LOCK", "d", "I", "sAppVersionCode", "e", "sAppVersionName", "Landroid/graphics/Point;", "f", "Landroid/graphics/Point;", "mScreenSize", "g", "sDeviceId", "h", "Landroid/content/Context;", "sContext", ContextChain.TAG_INFRA, "Z", "isGeneratedDeviceIdAfterAppInstall", "()Ljava/lang/String;", "getDeviceId$annotations", "()V", IterableConstants.DEVICE_ID, "()I", "getAppVersionCode$annotations", "appVersionCode", "getAppVersionName$annotations", "appVersionName", "()Landroid/graphics/Point;", "getScreenSize$annotations", "screenSize", "getApplicationMinSDK$annotations", "applicationMinSDK", "getApplicationTargetSDK$annotations", "applicationTargetSDK", "<init>", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class AndroidUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final AndroidUtils f1644a = new AndroidUtils();

    /* renamed from: b, reason: from kotlin metadata */
    public static final String OS_VERSION;

    /* renamed from: c, reason: from kotlin metadata */
    private static final Object LOCK;

    /* renamed from: d, reason: from kotlin metadata */
    private static int sAppVersionCode;

    /* renamed from: e, reason: from kotlin metadata */
    private static String sAppVersionName;

    /* renamed from: f, reason: from kotlin metadata */
    private static Point mScreenSize;

    /* renamed from: g, reason: from kotlin metadata */
    private static String sDeviceId;

    /* renamed from: h, reason: from kotlin metadata */
    private static Context sContext;

    /* renamed from: i, reason: from kotlin metadata */
    public static boolean isGeneratedDeviceIdAfterAppInstall;

    static {
        String str = Build.VERSION.RELEASE;
        if (str == null) {
            str = "";
        }
        OS_VERSION = str;
        LOCK = new Object();
        sAppVersionCode = -1;
    }

    private AndroidUtils() {
    }

    public static final int c() {
        int i;
        int i2 = sAppVersionCode;
        if (i2 != -1) {
            return i2;
        }
        synchronized (LOCK) {
            int i3 = sAppVersionCode;
            if (i3 == -1) {
                i = f1644a.a();
                sAppVersionCode = i;
            } else {
                i = i3;
            }
            Unit unit = Unit.INSTANCE;
        }
        return i;
    }

    public static final String d() {
        if (sAppVersionName == null) {
            sAppVersionName = f1644a.b();
        }
        return sAppVersionName;
    }

    public static final int e() {
        Context context = sContext;
        if (context != null) {
            return context.getApplicationContext().getApplicationInfo().minSdkVersion;
        }
        return -1;
    }

    public static final int f() {
        Context context = sContext;
        if (context != null) {
            return context.getApplicationContext().getApplicationInfo().targetSdkVersion;
        }
        return -1;
    }

    public static final String g() {
        try {
            if (sDeviceId == null) {
                String a2 = i0.a(IterableConstants.DEVICE_ID, (String) null);
                sDeviceId = a2;
                if (a2 == null) {
                    isGeneratedDeviceIdAfterAppInstall = true;
                    String uuid = UUID.randomUUID().toString();
                    sDeviceId = uuid;
                    i0.b(IterableConstants.DEVICE_ID, uuid);
                }
            }
            return sDeviceId;
        } catch (Exception e) {
            PendoLogger.e(e, "AndroidUtils deviceId " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static final Point h() {
        Point point = mScreenSize;
        if (point != null) {
            return point;
        }
        Point point2 = new Point();
        Context context = sContext;
        WindowManager windowManager = (WindowManager) (context != null ? context.getSystemService("window") : null);
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Intrinsics.checkNotNullExpressionValue(defaultDisplay, "getDefaultDisplay(...)");
            defaultDisplay.getSize(point2);
        }
        mScreenSize = point2;
        return point2;
    }

    public final int a() {
        try {
            Context context = sContext;
            if (context == null) {
                return -1;
            }
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager != null ? packageManager.getPackageInfo(context.getPackageName(), 0) : null;
            if (packageInfo == null) {
                return -1;
            }
            return (int) PackageInfoCompat.getLongVersionCode(packageInfo);
        } catch (PackageManager.NameNotFoundException e) {
            PendoLogger.i(e, "AndroidUtils deviceId " + e.getMessage(), new Object[0]);
            return -1;
        }
    }

    public final String b() {
        try {
            Context context = sContext;
            if (context != null) {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager != null ? packageManager.getPackageInfo(context.getPackageName(), 0) : null;
                if (packageInfo == null || j0.a(packageInfo.versionName)) {
                    return null;
                }
                String versionName = packageInfo.versionName;
                Intrinsics.checkNotNullExpressionValue(versionName, "versionName");
                int length = versionName.length() - 1;
                int i = 0;
                boolean z = false;
                while (i <= length) {
                    boolean z2 = Intrinsics.compare((int) versionName.charAt(!z ? i : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i++;
                    } else {
                        z = true;
                    }
                }
                return versionName.subSequence(i, length + 1).toString();
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            PendoLogger.i(e, "computeAppVersionName -> Name not found " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    @JvmStatic
    public static final String a(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        Charset forName = Charset.forName(StandardCharsets.UTF_8.name());
        Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
        byte[] bytes = string.getBytes(forName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String encodeToString = Base64.encodeToString(bytes, 10);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(...)");
        return encodeToString;
    }

    @JvmStatic
    public static final boolean b(String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Context context = sContext;
        return context != null && context.checkCallingOrSelfPermission(permission) == 0;
    }

    @JvmStatic
    public static final Application a(Context context) {
        if (context == null) {
            return null;
        }
        sContext = context.getApplicationContext();
        if (!(context.getApplicationContext() instanceof Application)) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        return (Application) applicationContext;
    }

    @JvmStatic
    public static final String a(Activity activity) {
        if (activity instanceof FragmentActivity) {
            for (Fragment fragment : ((FragmentActivity) activity).getSupportFragmentManager().getFragments()) {
                if (fragment != null && fragment.isVisible() && fragment.isMenuVisible()) {
                    return fragment.getClass().getSimpleName();
                }
            }
        }
        return null;
    }
}
