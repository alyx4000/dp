package com.quantummetric.reactnative;

import android.app.Activity;
import android.util.Log;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.ViewProps;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class QuantumMetricLibraryModule extends ReactContextBaseJavaModule {
    private static JSONObject config;
    private static WeakReference<QuantumMetricLibraryModule> instance;
    private Class<?> quantumClass;
    private final ReactApplicationContext reactContext;
    private boolean setSessionCallback;

    @ReactMethod
    public void addListener(String str) {
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "QuantumMetricLibrary";
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public QuantumMetricLibraryModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.quantumClass = null;
        this.reactContext = reactApplicationContext;
        instance = new WeakReference<>(this);
        try {
            this.quantumClass = Class.forName("com.quantummetric.instrument.QuantumMetric");
        } catch (Throwable th) {
            Log.d("QM", "Not able to access QuantumMetric class ", th);
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        super.initialize();
        startIfOldSkd();
    }

    @ReactMethod
    public void networkRequestCompleted(String str, int i, String str2, String str3, int i2, String str4, String str5, int i3, String str6, Callback callback) {
        try {
            try {
                try {
                    this.quantumClass.getMethod("logRequest", String.class, String.class, Long.TYPE, Long.TYPE, Integer.TYPE, String.class, String.class, Map.class, Map.class).invoke(null, str, str6, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2), str2, str3, Utilities.stringToMap(str4), Utilities.stringToMap(str5));
                } catch (Throwable th) {
                    th = th;
                    Log.d("QM", th.toString());
                }
            } catch (Exception e) {
                Log.d("QM", "logRequest reflection exception: ", e);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @ReactMethod
    public void sendEventNative(int i, String str, int i2) {
        try {
            Class<?> cls = Class.forName("com.quantummetric.instrument.EventType");
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(Integer.TYPE);
            declaredConstructor.setAccessible(true);
            Object newInstance = declaredConstructor.newInstance(Integer.valueOf(i2));
            Object newInstance2 = Array.newInstance(cls, 1);
            Array.set(newInstance2, 0, newInstance);
            this.quantumClass.getMethod("sendEvent", Integer.TYPE, String.class, newInstance2.getClass()).invoke(null, Integer.valueOf(i), str, newInstance2);
        } catch (Throwable th) {
            Log.d("QM", "Exception while trying to send event " + th);
        }
    }

    @ReactMethod
    public void sendNewPageNamedNative(String str) {
        try {
            this.quantumClass.getDeclaredMethod("sendNewPageNamed", String.class).invoke(null, str);
        } catch (Throwable th) {
            Log.d("QM", "Exception while trying to send new page " + th);
        }
    }

    @ReactMethod
    public void requestConfig() {
        JSONObject jSONObject = config;
        if (jSONObject != null) {
            sendStartConfigToJS(jSONObject);
        }
    }

    @ReactMethod
    public void initializeNative(String str, String str2) {
        try {
            Object invoke = this.quantumClass.getMethod("initialize", String.class, String.class, Activity.class).invoke(null, str, str2, getCurrentActivity());
            invoke.getClass().getDeclaredMethod(ViewProps.START, new Class[0]).invoke(invoke, new Object[0]);
        } catch (Throwable th) {
            Log.d("QM", "Exception while trying to initialize with sub " + th);
        }
    }

    @ReactMethod
    public void initializeWithOptionsNative(String str, String str2, ReadableMap readableMap) {
        try {
            Object invoke = this.quantumClass.getMethod("initialize", String.class, String.class, Activity.class).invoke(null, str, str2, getCurrentActivity());
            Class<?> cls = invoke.getClass();
            if (readableMap != null) {
                HashMap<String, Object> readableMapToHashMap = Utilities.readableMapToHashMap(readableMap);
                Object obj = readableMapToHashMap.get("testModeEnabled");
                Object obj2 = readableMapToHashMap.get("sslPinningEnabled");
                Object obj3 = readableMapToHashMap.get("crashReportingEnabled");
                if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    cls.getDeclaredMethod("enableTestMode", new Class[0]).invoke(invoke, new Object[0]);
                }
                if ((obj2 instanceof Boolean) && ((Boolean) obj2).booleanValue()) {
                    cls.getDeclaredMethod("enableCertificatePinning", new Class[0]).invoke(invoke, new Object[0]);
                }
                if ((obj3 instanceof Boolean) && !((Boolean) obj3).booleanValue()) {
                    cls.getDeclaredMethod("disableCrashReporting", new Class[0]).invoke(invoke, new Object[0]);
                }
            }
            cls.getDeclaredMethod(ViewProps.START, new Class[0]).invoke(invoke, new Object[0]);
        } catch (Throwable th) {
            Log.d("QM", "Exception while trying to initializeWithOptionsNative " + th);
        }
    }

    @ReactMethod
    public void pauseQMNative() {
        try {
            this.quantumClass.getDeclaredMethod("pause", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th) {
            Log.d("QM", "Exception while trying to pause QM: " + th);
        }
    }

    @ReactMethod
    public void resumeQMNative() {
        try {
            this.quantumClass.getDeclaredMethod("resume", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th) {
            Log.d("QM", "Exception while trying to resume QM: " + th);
        }
    }

    @ReactMethod
    public void stopQMNative() {
        try {
            this.quantumClass.getDeclaredMethod("stop", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th) {
            Log.d("QM", "Exception while trying to stop QM: " + th);
        }
    }

    @ReactMethod
    public void resetSessionQMNative(boolean z) {
        try {
            this.quantumClass.getDeclaredMethod("resetSession", Boolean.TYPE).invoke(null, Boolean.valueOf(z));
        } catch (Throwable th) {
            Log.d("QM", "Exception while trying to reset QM: " + th);
        }
    }

    @ReactMethod
    public void enableTestConfigNative(boolean z) {
        Log.d("QM", "enableTestConfig not available just yet");
    }

    @ReactMethod
    public void setSessionCookieCallbackQMNative() {
        this.setSessionCallback = true;
    }

    private void startIfOldSkd() {
        try {
            if (Class.forName("com.quantummetric.instrument.BuildConfig").getDeclaredField("VERSION_CODE").getInt(null) < 54) {
                sendStartConfigToJS(new JSONObject());
            }
        } catch (Exception unused) {
        }
    }

    public static void sendStartConfigToJS(JSONObject jSONObject) {
        config = jSONObject;
        WeakReference<QuantumMetricLibraryModule> weakReference = instance;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) instance.get().reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("QMStartNotification", Utilities.convertJsonToMap(jSONObject));
    }

    public static void onCookieChangeListener(String str, String str2) {
        try {
            WeakReference<QuantumMetricLibraryModule> weakReference = instance;
            if (weakReference == null || weakReference.get() == null || !instance.get().setSessionCallback) {
                return;
            }
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) instance.get().reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("QMSessionCookieCallback", Utilities.convertJsonToMap(new JSONObject().put("sessionCookie", str).put("userString", str2)));
        } catch (Throwable unused) {
        }
    }
}
