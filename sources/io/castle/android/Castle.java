package io.castle.android;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import io.castle.android.CastleConfiguration;
import io.castle.android.api.model.CustomEvent;
import io.castle.android.api.model.Event;
import io.castle.android.api.model.ScreenEvent;
import io.castle.android.api.model.UserJwt;
import io.castle.android.queue.EventQueue;
import io.castle.highwind.android.Highwind;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public class Castle {
    private static Castle instance = null;
    public static final String requestTokenHeaderName = "X-Castle-Request-Token";
    private CastleActivityLifecycleCallbacks activityLifecycleCallbacks;
    private int appBuild;
    private String appName;
    private String appVersion;
    private CastleComponentCallback componentCallbacks;
    private CastleConfiguration configuration;
    private EventQueue eventQueue;
    private Highwind highwind;
    private StorageHelper storageHelper;

    private Castle(Application application, CastleConfiguration castleConfiguration) {
        setup(application, castleConfiguration);
    }

    public static String encodeEvent(Event event) {
        if (event instanceof ScreenEvent) {
            return getInstance().highwind.encodeScreenEvent(event.getToken(), Utils.getGsonInstance().toJson(event));
        }
        return getInstance().highwind.encodeCustomEvent(event.getToken(), Utils.getGsonInstance().toJson(event));
    }

    public static String encodeUser(String str) {
        return getInstance().highwind.encodeUserJwtPayloadSet(Utils.getGsonInstance().toJson(new UserJwt(str)));
    }

    public static String encodePayload(String str, List<String> list) {
        return getInstance().highwind.encodePayload(publishableKey(), str, list);
    }

    private void setup(Application application, CastleConfiguration castleConfiguration) {
        Context applicationContext = application.getApplicationContext();
        this.appVersion = Utils.getApplicationVersion(application);
        this.appBuild = Utils.getApplicationVersionCode(application);
        this.appName = Utils.getApplicationName(application);
        this.storageHelper = new StorageHelper(applicationContext);
        this.configuration = castleConfiguration;
        this.eventQueue = new EventQueue(applicationContext);
        this.highwind = new Highwind(applicationContext, BuildConfig.VERSION_NAME, this.storageHelper.getDeviceId(), buildUserAgent(), castleConfiguration.publishableKey(), this.storageHelper.getDeviceIdSource().intValue());
    }

    private void registerLifeCycleCallbacks(Application application) {
        CastleActivityLifecycleCallbacks castleActivityLifecycleCallbacks = new CastleActivityLifecycleCallbacks();
        this.activityLifecycleCallbacks = castleActivityLifecycleCallbacks;
        application.registerActivityLifecycleCallbacks(castleActivityLifecycleCallbacks);
        CastleComponentCallback castleComponentCallback = new CastleComponentCallback();
        this.componentCallbacks = castleComponentCallback;
        application.registerComponentCallbacks(castleComponentCallback);
        this.storageHelper.getVersion();
        int build = this.storageHelper.getBuild();
        if (build == -1) {
            custom("Application Installed");
        } else if (this.appBuild != build) {
            custom("Application Updated");
        }
        custom("Application Opened");
        flush();
        this.storageHelper.setVersion(this.appVersion);
        this.storageHelper.setBuild(this.appBuild);
    }

    private String id() {
        return this.highwind.token();
    }

    public static void configure(Application application, CastleConfiguration castleConfiguration) {
        if (instance == null) {
            if (castleConfiguration.publishableKey() == null || !castleConfiguration.publishableKey().startsWith("pk_") || castleConfiguration.publishableKey().length() != 35) {
                throw new RuntimeException("You must provide a valid Castle publishable key when initializing the SDK.");
            }
            Castle castle = new Castle(application, castleConfiguration);
            instance = castle;
            castle.registerLifeCycleCallbacks(application);
        }
    }

    public static void configure(Application application, String str) {
        if (instance == null) {
            Castle castle = new Castle(application, new CastleConfiguration.Builder().publishableKey(str).build());
            instance = castle;
            castle.registerLifeCycleCallbacks(application);
        }
    }

    public static void configure(Application application, String str, CastleConfiguration castleConfiguration) {
        if (instance == null) {
            Castle castle = new Castle(application, new CastleConfiguration.Builder(castleConfiguration).publishableKey(str).build());
            instance = castle;
            castle.registerLifeCycleCallbacks(application);
        }
    }

    public static void configure(Application application) {
        try {
            configure(application, new CastleConfiguration.Builder().publishableKey(application.getPackageManager().getApplicationInfo(application.getPackageName(), 128).metaData.getString("castle_publishable_key")).build());
        } catch (PackageManager.NameNotFoundException e) {
            CastleLogger.e("Failed to load meta-data, NameNotFound: " + e.getMessage());
        } catch (NullPointerException e2) {
            CastleLogger.e("Failed to load meta-data, NullPointer: " + e2.getMessage());
        }
    }

    public static void custom(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        track(new CustomEvent(str));
    }

    public static void custom(String str, Map<String, Object> map) {
        if (str == null || str.isEmpty()) {
            return;
        }
        track(new CustomEvent(str, map));
    }

    private static void track(Event event) {
        getInstance().eventQueue.add(event);
    }

    private static Castle getInstance() {
        Castle castle = instance;
        if (castle != null) {
            return castle;
        }
        throw new CastleError("Castle SDK must be configured before calling this method");
    }

    public static void userJwt(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        getInstance().storageHelper.setUserJwt(str);
    }

    public static String userJwt() {
        return getInstance().storageHelper.getUserJwt();
    }

    public static void reset() {
        flush();
        userJwt(null);
    }

    public static void screen(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        track(new ScreenEvent(str));
    }

    public static void screen(Activity activity) {
        track(new ScreenEvent(activity));
    }

    public static String publishableKey() {
        return getInstance().configuration.publishableKey();
    }

    public static boolean debugLoggingEnabled() {
        return getInstance().configuration.debugLoggingEnabled();
    }

    public static String baseUrl() {
        return getInstance().configuration.baseUrl();
    }

    public static String createRequestToken() {
        return getInstance().id();
    }

    public static CastleConfiguration configuration() {
        return getInstance().configuration;
    }

    public static void flush() {
        getInstance().eventQueue.flush();
    }

    public static boolean flushIfNeeded(String str) {
        if (!isUrlAllowlisted(str)) {
            return false;
        }
        flush();
        return true;
    }

    public static Map<String, String> headers(String str) {
        HashMap hashMap = new HashMap();
        if (isUrlAllowlisted(str)) {
            hashMap.put(requestTokenHeaderName, createRequestToken());
        }
        return hashMap;
    }

    public static CastleInterceptor castleInterceptor() {
        return new CastleInterceptor();
    }

    static boolean isUrlAllowlisted(String str) {
        try {
            URL url = new URL(str);
            String str2 = url.getProtocol() + "://" + url.getHost() + "/";
            if (configuration().baseURLAllowList() == null || configuration().baseURLAllowList().isEmpty()) {
                return false;
            }
            return configuration().baseURLAllowList().contains(str2);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int queueSize() {
        return getInstance().eventQueue.size();
    }

    static boolean isFlushing() {
        return getInstance().eventQueue.isFlushing();
    }

    public static void destroy(Application application) {
        Castle castle = instance;
        if (castle != null) {
            castle.eventQueue.destroy();
            instance.unregisterLifeCycleCallbacks(application);
            instance.unregisterComponentCallbacks(application);
            instance = null;
        }
    }

    static int getCurrentBuild() {
        return getInstance().appBuild;
    }

    public static String userAgent() {
        return getInstance().buildUserAgent();
    }

    private String buildUserAgent() {
        return Utils.sanitizeHeader(String.format(Locale.US, "%s/%s (%d) (Castle %s; Android %s; %s %s)", this.appName, this.appVersion, Integer.valueOf(this.appBuild), BuildConfig.VERSION_NAME, Build.VERSION.RELEASE, Build.MANUFACTURER, Build.MODEL));
    }

    static String getCurrentVersion() {
        return getInstance().appVersion;
    }

    private void unregisterLifeCycleCallbacks(Application application) {
        application.unregisterActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
    }

    private void unregisterComponentCallbacks(Application application) {
        application.unregisterComponentCallbacks(this.componentCallbacks);
    }
}
