package com.amplitude.reactnative;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import io.branch.referral.util.DependencyUtilsKt;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidContextProvider.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 .2\u00020\u0001:\u0002-.B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010)\u001a\u00020\u0005J\u0006\u0010*\u001a\u00020\u0005J\u0006\u0010+\u001a\u00020,R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u001c\u0010\u000f\u001a\b\u0018\u00010\u0010R\u00020\u00008BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\nR\u0011\u0010\u0017\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\nR\u0011\u0010\u0019\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\nR\u0011\u0010\u001b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\nR\u0011\u0010\u001d\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\nR\u0011\u0010\u001f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b \u0010\nR\u0011\u0010!\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\"\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0013\u0010'\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b(\u0010\n¨\u0006/"}, d2 = {"Lcom/amplitude/reactnative/AndroidContextProvider;", "", "context", "Landroid/content/Context;", "shouldTrackAdid", "", "(Landroid/content/Context;Z)V", "advertisingId", "", "getAdvertisingId", "()Ljava/lang/String;", "appSetId", "getAppSetId", "brand", "getBrand", "cachedInfo", "Lcom/amplitude/reactnative/AndroidContextProvider$CachedInfo;", "getCachedInfo", "()Lcom/amplitude/reactnative/AndroidContextProvider$CachedInfo;", "carrier", "getCarrier", "country", "getCountry", "language", "getLanguage", "manufacturer", "getManufacturer", "model", "getModel", "osName", "getOsName", "osVersion", "getOsVersion", "platform", "getPlatform", "getShouldTrackAdid", "()Z", "setShouldTrackAdid", "(Z)V", "versionName", "getVersionName", "isGooglePlayServicesEnabled", "isLimitAdTrackingEnabled", "prefetch", "", "CachedInfo", "Companion", "amplitude_analytics-react-native_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidContextProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String OS_NAME = "android";
    public static final String PLATFORM = "Android";
    public static final String SETTING_ADVERTISING_ID = "advertising_id";
    public static final String SETTING_LIMIT_AD_TRACKING = "limit_ad_tracking";
    private CachedInfo cachedInfo;
    private final Context context;
    private boolean shouldTrackAdid;

    public AndroidContextProvider(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.shouldTrackAdid = z;
    }

    public final boolean getShouldTrackAdid() {
        return this.shouldTrackAdid;
    }

    public final void setShouldTrackAdid(boolean z) {
        this.shouldTrackAdid = z;
    }

    private final CachedInfo getCachedInfo() {
        if (this.cachedInfo == null) {
            this.cachedInfo = new CachedInfo();
        }
        return this.cachedInfo;
    }

    /* compiled from: AndroidContextProvider.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00104\u001a\u00020\u001bH\u0002J\n\u00105\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u00106\u001a\u00020\u0004H\u0002J\b\u00107\u001a\u00020\u0004H\u0002J\n\u00108\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u00109\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010:\u001a\u00020\u0004H\u0002J\b\u0010;\u001a\u00020\u0004H\u0002J\b\u0010<\u001a\u00020\u0004H\u0002J\b\u0010=\u001a\u00020\u0004H\u0002J\n\u0010>\u001a\u0004\u0018\u00010\u0004H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u0014\u0010\u0012\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0006R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0006R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006R\u001a\u0010 \u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0006R\u0011\u0010*\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0006R\u0011\u0010,\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0006R\u0011\u0010.\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0006R\u0011\u00100\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0006R\u0013\u00102\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0006¨\u0006?"}, d2 = {"Lcom/amplitude/reactnative/AndroidContextProvider$CachedInfo;", "", "(Lcom/amplitude/reactnative/AndroidContextProvider;)V", "advertisingId", "", "getAdvertisingId", "()Ljava/lang/String;", "setAdvertisingId", "(Ljava/lang/String;)V", "appSetId", "getAppSetId", "setAppSetId", "brand", "getBrand", "carrier", "getCarrier", "country", "getCountry", "countryFromLocale", "getCountryFromLocale", "countryFromNetwork", "getCountryFromNetwork", "fetchAndCacheAmazonAdvertisingId", "getFetchAndCacheAmazonAdvertisingId", "fetchAndCacheGoogleAdvertisingId", "getFetchAndCacheGoogleAdvertisingId", "gpsEnabled", "", "getGpsEnabled", "()Z", "language", "getLanguage", "limitAdTrackingEnabled", "getLimitAdTrackingEnabled", "setLimitAdTrackingEnabled", "(Z)V", "locale", "Ljava/util/Locale;", "getLocale", "()Ljava/util/Locale;", "manufacturer", "getManufacturer", "model", "getModel", "osName", "getOsName", "osVersion", "getOsVersion", "platform", "getPlatform", "versionName", "getVersionName", "checkGPSEnabled", "fetchAdvertisingId", "fetchAppSetId", "fetchBrand", "fetchCarrier", "fetchCountry", "fetchLanguage", "fetchManufacturer", "fetchModel", "fetchOsVersion", "fetchVersionName", "amplitude_analytics-react-native_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class CachedInfo {
        private boolean limitAdTrackingEnabled = true;
        private String advertisingId = fetchAdvertisingId();
        private final String versionName = fetchVersionName();
        private final String osName = AndroidContextProvider.OS_NAME;
        private final String platform = "Android";
        private final String osVersion = fetchOsVersion();
        private final String brand = fetchBrand();
        private final String manufacturer = fetchManufacturer();
        private final String model = fetchModel();
        private final String carrier = fetchCarrier();
        private final String country = fetchCountry();
        private final String language = fetchLanguage();
        private final boolean gpsEnabled = checkGPSEnabled();
        private String appSetId = fetchAppSetId();

        public CachedInfo() {
        }

        public final String getAdvertisingId() {
            return this.advertisingId;
        }

        public final void setAdvertisingId(String str) {
            this.advertisingId = str;
        }

        public final String getCountry() {
            return this.country;
        }

        public final String getVersionName() {
            return this.versionName;
        }

        public final String getOsName() {
            return this.osName;
        }

        public final String getPlatform() {
            return this.platform;
        }

        public final String getOsVersion() {
            return this.osVersion;
        }

        public final String getBrand() {
            return this.brand;
        }

        public final String getManufacturer() {
            return this.manufacturer;
        }

        public final String getModel() {
            return this.model;
        }

        public final String getCarrier() {
            return this.carrier;
        }

        public final String getLanguage() {
            return this.language;
        }

        public final boolean getLimitAdTrackingEnabled() {
            return this.limitAdTrackingEnabled;
        }

        public final void setLimitAdTrackingEnabled(boolean z) {
            this.limitAdTrackingEnabled = z;
        }

        public final boolean getGpsEnabled() {
            return this.gpsEnabled;
        }

        public final String getAppSetId() {
            return this.appSetId;
        }

        public final void setAppSetId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.appSetId = str;
        }

        private final String fetchVersionName() {
            try {
                PackageInfo packageInfo = AndroidContextProvider.this.context.getPackageManager().getPackageInfo(AndroidContextProvider.this.context.getPackageName(), 0);
                Intrinsics.checkNotNullExpressionValue(packageInfo, "context.packageManager.g…o(context.packageName, 0)");
                return packageInfo.versionName;
            } catch (PackageManager.NameNotFoundException | Exception unused) {
                return null;
            }
        }

        private final String fetchOsVersion() {
            String RELEASE = Build.VERSION.RELEASE;
            Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
            return RELEASE;
        }

        private final String fetchBrand() {
            String BRAND = Build.BRAND;
            Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
            return BRAND;
        }

        private final String fetchManufacturer() {
            String MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            return MANUFACTURER;
        }

        private final String fetchModel() {
            String MODEL = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            return MODEL;
        }

        private final String fetchCarrier() {
            try {
                Object systemService = AndroidContextProvider.this.context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
                return ((TelephonyManager) systemService).getNetworkOperatorName();
            } catch (Exception unused) {
                return null;
            }
        }

        private final String fetchCountry() {
            String countryFromNetwork = getCountryFromNetwork();
            String str = countryFromNetwork;
            return !(str == null || str.length() == 0) ? countryFromNetwork : getCountryFromLocale();
        }

        private final String getCountryFromNetwork() {
            String networkCountryIso;
            try {
                Object systemService = AndroidContextProvider.this.context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
                TelephonyManager telephonyManager = (TelephonyManager) systemService;
                if (telephonyManager.getPhoneType() == 2 || (networkCountryIso = telephonyManager.getNetworkCountryIso()) == null) {
                    return null;
                }
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String upperCase = networkCountryIso.toUpperCase(US);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                return upperCase;
            } catch (Exception unused) {
                return null;
            }
        }

        private final Locale getLocale() {
            LocaleList locales = Resources.getSystem().getConfiguration().getLocales();
            Intrinsics.checkNotNullExpressionValue(locales, "configuration.locales");
            if (locales.isEmpty()) {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                return locale;
            }
            Locale locale2 = locales.get(0);
            Intrinsics.checkNotNullExpressionValue(locale2, "localeList.get(0)");
            return locale2;
        }

        private final String getCountryFromLocale() {
            String country = getLocale().getCountry();
            Intrinsics.checkNotNullExpressionValue(country, "locale.country");
            return country;
        }

        private final String fetchLanguage() {
            String language = getLocale().getLanguage();
            Intrinsics.checkNotNullExpressionValue(language, "locale.language");
            return language;
        }

        private final String fetchAdvertisingId() {
            if (!AndroidContextProvider.this.getShouldTrackAdid()) {
                return null;
            }
            if (Intrinsics.areEqual("Amazon", fetchManufacturer())) {
                return getFetchAndCacheAmazonAdvertisingId();
            }
            return getFetchAndCacheGoogleAdvertisingId();
        }

        private final String fetchAppSetId() {
            try {
                Object invoke = Class.forName("com.google.android.gms.appset.AppSet").getMethod("getClient", Context.class).invoke(null, AndroidContextProvider.this.context);
                Object invoke2 = Class.forName("com.google.android.gms.tasks.Tasks").getMethod("await", Class.forName("com.google.android.gms.tasks.Task")).invoke(null, invoke.getClass().getMethod("getAppSetIdInfo", new Class[0]).invoke(invoke, new Object[0]));
                Object invoke3 = invoke2.getClass().getMethod("getId", new Class[0]).invoke(invoke2, new Object[0]);
                Intrinsics.checkNotNull(invoke3, "null cannot be cast to non-null type kotlin.String");
                this.appSetId = (String) invoke3;
            } catch (ClassNotFoundException unused) {
                LogcatLogger.INSTANCE.getLogger().warn("Google Play Services SDK not found for app set id!");
            } catch (InvocationTargetException unused2) {
                LogcatLogger.INSTANCE.getLogger().warn("Google Play Services not available for app set id");
            } catch (Exception unused3) {
                LogcatLogger.INSTANCE.getLogger().error("Encountered an error connecting to Google Play Services for app set id");
            }
            return this.appSetId;
        }

        private final String getFetchAndCacheAmazonAdvertisingId() {
            ContentResolver contentResolver = AndroidContextProvider.this.context.getContentResolver();
            this.limitAdTrackingEnabled = Settings.Secure.getInt(contentResolver, AndroidContextProvider.SETTING_LIMIT_AD_TRACKING, 0) == 1;
            String string = Settings.Secure.getString(contentResolver, AndroidContextProvider.SETTING_ADVERTISING_ID);
            this.advertisingId = string;
            return string;
        }

        private final String getFetchAndCacheGoogleAdvertisingId() {
            try {
                boolean z = true;
                Object invoke = Class.forName(DependencyUtilsKt.playStoreAdvertisingIdClientClass).getMethod("getAdvertisingIdInfo", Context.class).invoke(null, AndroidContextProvider.this.context);
                Object invoke2 = invoke.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(invoke, new Object[0]);
                Intrinsics.checkNotNull(invoke2, "null cannot be cast to non-null type kotlin.Boolean");
                if (!((Boolean) invoke2).booleanValue()) {
                    z = false;
                }
                this.limitAdTrackingEnabled = z;
                Object invoke3 = invoke.getClass().getMethod("getId", new Class[0]).invoke(invoke, new Object[0]);
                Intrinsics.checkNotNull(invoke3, "null cannot be cast to non-null type kotlin.String");
                this.advertisingId = (String) invoke3;
            } catch (ClassNotFoundException unused) {
                LogcatLogger.INSTANCE.getLogger().warn("Google Play Services SDK not found for advertising id!");
            } catch (InvocationTargetException unused2) {
                LogcatLogger.INSTANCE.getLogger().warn("Google Play Services not available for advertising id");
            } catch (Exception unused3) {
                LogcatLogger.INSTANCE.getLogger().error("Encountered an error connecting to Google Play Services for advertising id");
            }
            return this.advertisingId;
        }

        private final boolean checkGPSEnabled() {
            try {
                Object invoke = Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", Context.class).invoke(null, AndroidContextProvider.this.context);
                Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Int");
                return ((Integer) invoke).intValue() == 0;
            } catch (ClassNotFoundException unused) {
                LogcatLogger.INSTANCE.getLogger().warn("Google Play Services Util not found!");
                return false;
            } catch (IllegalAccessException unused2) {
                LogcatLogger.INSTANCE.getLogger().warn("Google Play Services not available");
                return false;
            } catch (NoSuchMethodException unused3) {
                LogcatLogger.INSTANCE.getLogger().warn("Google Play Services not available");
                return false;
            } catch (InvocationTargetException unused4) {
                LogcatLogger.INSTANCE.getLogger().warn("Google Play Services not available");
                return false;
            } catch (Exception e) {
                LogcatLogger.INSTANCE.getLogger().warn("Error when checking for Google Play Services: " + e);
                return false;
            } catch (NoClassDefFoundError unused5) {
                LogcatLogger.INSTANCE.getLogger().warn("Google Play Services Util not found!");
                return false;
            }
        }
    }

    public final void prefetch() {
        getCachedInfo();
    }

    public final boolean isGooglePlayServicesEnabled() {
        CachedInfo cachedInfo = getCachedInfo();
        Intrinsics.checkNotNull(cachedInfo);
        return cachedInfo.getGpsEnabled();
    }

    public final boolean isLimitAdTrackingEnabled() {
        CachedInfo cachedInfo = getCachedInfo();
        Intrinsics.checkNotNull(cachedInfo);
        return cachedInfo.getLimitAdTrackingEnabled();
    }

    public final String getVersionName() {
        CachedInfo cachedInfo = getCachedInfo();
        Intrinsics.checkNotNull(cachedInfo);
        return cachedInfo.getVersionName();
    }

    public final String getOsName() {
        CachedInfo cachedInfo = getCachedInfo();
        Intrinsics.checkNotNull(cachedInfo);
        return cachedInfo.getOsName();
    }

    public final String getPlatform() {
        CachedInfo cachedInfo = getCachedInfo();
        Intrinsics.checkNotNull(cachedInfo);
        return cachedInfo.getPlatform();
    }

    public final String getOsVersion() {
        CachedInfo cachedInfo = getCachedInfo();
        Intrinsics.checkNotNull(cachedInfo);
        return cachedInfo.getOsVersion();
    }

    public final String getBrand() {
        CachedInfo cachedInfo = getCachedInfo();
        Intrinsics.checkNotNull(cachedInfo);
        return cachedInfo.getBrand();
    }

    public final String getManufacturer() {
        CachedInfo cachedInfo = getCachedInfo();
        Intrinsics.checkNotNull(cachedInfo);
        return cachedInfo.getManufacturer();
    }

    public final String getModel() {
        CachedInfo cachedInfo = getCachedInfo();
        Intrinsics.checkNotNull(cachedInfo);
        return cachedInfo.getModel();
    }

    public final String getCarrier() {
        CachedInfo cachedInfo = getCachedInfo();
        Intrinsics.checkNotNull(cachedInfo);
        return cachedInfo.getCarrier();
    }

    public final String getCountry() {
        CachedInfo cachedInfo = getCachedInfo();
        Intrinsics.checkNotNull(cachedInfo);
        return cachedInfo.getCountry();
    }

    public final String getLanguage() {
        CachedInfo cachedInfo = getCachedInfo();
        Intrinsics.checkNotNull(cachedInfo);
        return cachedInfo.getLanguage();
    }

    public final String getAdvertisingId() {
        CachedInfo cachedInfo = getCachedInfo();
        Intrinsics.checkNotNull(cachedInfo);
        return cachedInfo.getAdvertisingId();
    }

    public final String getAppSetId() {
        CachedInfo cachedInfo = getCachedInfo();
        Intrinsics.checkNotNull(cachedInfo);
        return cachedInfo.getAppSetId();
    }

    /* compiled from: AndroidContextProvider.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/amplitude/reactnative/AndroidContextProvider$Companion;", "", "()V", "OS_NAME", "", "PLATFORM", "SETTING_ADVERTISING_ID", "SETTING_LIMIT_AD_TRACKING", "generateUUID", "amplitude_analytics-react-native_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String generateUUID() {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            return uuid;
        }
    }
}
