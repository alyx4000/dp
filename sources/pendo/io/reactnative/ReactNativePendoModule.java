package pendo.io.reactnative;

import android.app.Activity;
import android.util.Log;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.util.ReactFindViewUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.sdk.react.PlatformStateManager;

/* loaded from: classes6.dex */
public class ReactNativePendoModule extends ReactContextBaseJavaModule {
    private static final String ACCOUNT_DATA = "accountData";
    private static final String ACCOUNT_ID = "accountId";
    private static final String DEBUG_MODE = "debugMode";
    private static final String ENVIRONMENT_NAME = "environmentName";
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final String NAME = "ReactNativePendo";
    private static final String ON_MODAL_STATE_HIDDEN = "onModalStateHidden";
    private static final String ON_MODAL_STATE_VISIBLE = "onModalStateVisible";
    private static final String ON_SCREEN_CONTENT_CHANGED = "onScreenContentChange";
    private static final String OPTIONS = "options";
    private static final String REACT_NATIVE_VERSION = "reactNativeVersion";
    private static final String SPACING = " - ";
    private static final String TAG = "ReactNativePendoModule";
    private static final String USE_CLICKABLE_ELEMENTS_FROM_JS = "useClickableElementsFromJS";
    private static final String VISITOR_DATA = "visitorData";
    private static final String VISITOR_ID = "visitorId";
    private boolean isDebugModeEnabled;

    private enum LogLevel {
        DEBUG
    }

    @ReactMethod
    public void addListener(String str) {
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    @ReactMethod
    public void shouldScanForDynamicElements(Boolean bool) {
    }

    public ReactNativePendoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.isDebugModeEnabled = false;
    }

    public static List<Integer> toIntList(ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        if (readableArray != null && readableArray.size() != 0) {
            try {
                ArrayList<Object> arrayList2 = readableArray.toArrayList();
                for (int i = 0; i < arrayList2.size(); i++) {
                    Object obj = arrayList2.get(i);
                    if (obj instanceof Integer) {
                        arrayList.add((Integer) obj);
                    } else if (obj instanceof Double) {
                        arrayList.add(Integer.valueOf(((Double) obj).intValue()));
                    } else if (obj instanceof Float) {
                        arrayList.add(Integer.valueOf(((Float) obj).intValue()));
                    }
                }
            } catch (Exception e) {
                sendFailureInfo(createErrorMessageMap("toIntList", e), false);
            }
        }
        return arrayList;
    }

    private static Map<String, Object> toMap(ReadableMap readableMap) {
        HashMap hashMap = new HashMap();
        if (readableMap == null) {
            return hashMap;
        }
        try {
            return readableMap.toHashMap();
        } catch (Exception e) {
            sendFailureInfo(createErrorMessageMap("toMap", e), false);
            return hashMap;
        }
    }

    private static boolean isNullOrWhiteSpace(String str) {
        return str == null || str.trim().isEmpty();
    }

    private static Map<String, Object> createErrorMessageMap(String str, Exception exc) {
        HashMap hashMap = new HashMap();
        if (exc != null) {
            hashMap.put("errorMessage", str + SPACING + exc.getMessage());
        }
        return hashMap;
    }

    private static void sendFailureInfo(Map<String, Object> map, boolean z) {
        PlatformStateManager.INSTANCE.sendFailureInfo(map);
    }

    @ReactMethod
    public void sendFailureInfo(ReadableMap readableMap, boolean z) {
        sendFailureInfo(toMap(readableMap), z);
    }

    @ReactMethod
    public void setup(String str, int i) {
        setup(str, i, null);
    }

    @ReactMethod
    public void setup(String str, int i, ReadableMap readableMap) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(Pendo.PendoOptions.FRAMEWORK, Pendo.PendoOptions.Framework.REACT_NATIVE);
            if (i == 1) {
                hashMap.put(Pendo.PendoOptions.FRAMEWORK_TYPE, Pendo.PendoOptions.FrameworkType.REACT_NATIVE_NAVIGATION);
            } else if (i == 2) {
                hashMap.put(Pendo.PendoOptions.FRAMEWORK_TYPE, Pendo.PendoOptions.FrameworkType.REACT_NAVIGATION);
            } else {
                hashMap.put(Pendo.PendoOptions.FRAMEWORK_TYPE, Pendo.PendoOptions.FrameworkType.TRACK);
            }
            Pendo.PendoOptions.Builder builder = new Pendo.PendoOptions.Builder();
            if (readableMap != null) {
                Map<String, Object> map = toMap(readableMap);
                if (map.containsKey(ENVIRONMENT_NAME)) {
                    builder.setEnvironmentDebugOnly((String) map.get(ENVIRONMENT_NAME));
                }
                if (map.containsKey(USE_CLICKABLE_ELEMENTS_FROM_JS)) {
                    builder.setUseClickableElementsFromJS(((Boolean) map.get(USE_CLICKABLE_ELEMENTS_FROM_JS)).booleanValue());
                }
                if (map.containsKey(REACT_NATIVE_VERSION)) {
                    hashMap.put(Pendo.PendoOptions.FRAMEWORK_VERSION, (String) map.get(REACT_NATIVE_VERSION));
                }
            }
            builder.setAdditionalOptions(hashMap);
            Pendo.setup(currentActivity, str, builder.build(), null);
            return;
        }
        printDebugLog(TAG, "Cannot call setup() due to activity being null", LogLevel.DEBUG);
    }

    @ReactMethod
    public void endSession() {
        Pendo.endSession();
    }

    @ReactMethod
    public void startSession(String str, String str2, ReadableMap readableMap, ReadableMap readableMap2) {
        Pendo.startSession(str, str2, toMap(readableMap), toMap(readableMap2));
    }

    @ReactMethod
    public void setVisitorData(ReadableMap readableMap) {
        Pendo.setVisitorData(toMap(readableMap));
    }

    @ReactMethod
    public void setAccountData(ReadableMap readableMap) {
        Pendo.setAccountData(toMap(readableMap));
    }

    @ReactMethod
    public void track(String str, ReadableMap readableMap) {
        if (isNullOrWhiteSpace(str)) {
            throw new IllegalArgumentException("Event name is required");
        }
        Pendo.track(str, toMap(readableMap));
    }

    @ReactMethod
    public void pauseGuides(boolean z) {
        Pendo.pauseGuides(z);
    }

    @ReactMethod
    public void resumeGuides() {
        Pendo.resumeGuides();
    }

    @ReactMethod
    public void dismissVisibleGuides() {
        Pendo.dismissVisibleGuides();
    }

    @ReactMethod
    public void getVisitorId(Promise promise) {
        try {
            promise.resolve(Pendo.getVisitorId());
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAccountId(Promise promise) {
        try {
            promise.resolve(Pendo.getAccountId());
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDeviceId(Promise promise) {
        try {
            promise.resolve(Pendo.getDeviceId());
        } catch (Exception e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void screenChanged(String str, ReadableArray readableArray, ReadableArray readableArray2, ReadableMap readableMap) {
        if (str != null) {
            try {
                if (readableArray.size() > 0) {
                    printDebugLog(TAG, "screenChanged, screenName: " + str + " rootTag: " + readableArray.toString() + " clickableElements: " + readableArray2.toString() + " info: " + readableMap, LogLevel.DEBUG);
                    PlatformStateManager.INSTANCE.newScreenIdentified(str, toIntList(readableArray), toMap(readableMap), readableArray2.toArrayList());
                }
            } catch (Exception e) {
                sendFailureInfo(createErrorMessageMap("screenChanged", e), false);
                return;
            }
        }
        printDebugLog(TAG, "screenChanged, either screenName is null or rootTag <= 0", LogLevel.DEBUG);
    }

    @ReactMethod
    public void setDebugMode(boolean z) {
        this.isDebugModeEnabled = z;
        Pendo.setDebugMode(z);
    }

    @ReactMethod
    public void sendClickAnalytic(final String str) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.runOnUiThread(new Runnable() { // from class: pendo.io.reactnative.ReactNativePendoModule.1
                @Override // java.lang.Runnable
                public void run() {
                    Pendo.sendClickAnalytic(ReactFindViewUtil.findView(currentActivity.getWindow().getDecorView().getRootView(), str));
                }
            });
        } else {
            printDebugLog(TAG, "Cannot call sendClickAnalytic() due to activity being null", LogLevel.DEBUG);
        }
    }

    private void printDebugLog(String str, String str2, LogLevel logLevel) {
        if (this.isDebugModeEnabled) {
            if (AnonymousClass2.$SwitchMap$pendo$io$reactnative$ReactNativePendoModule$LogLevel[logLevel.ordinal()] == 1) {
                Log.d(str, str2);
            } else {
                Log.d(str, str2);
            }
        }
    }

    /* renamed from: pendo.io.reactnative.ReactNativePendoModule$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$pendo$io$reactnative$ReactNativePendoModule$LogLevel;

        static {
            int[] iArr = new int[LogLevel.values().length];
            $SwitchMap$pendo$io$reactnative$ReactNativePendoModule$LogLevel = iArr;
            try {
                iArr[LogLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @ReactMethod
    public void screenContentChanged() {
        sendEvent(ON_SCREEN_CONTENT_CHANGED, null);
    }

    @ReactMethod
    public void modalStateChanged(boolean z) {
        if (z) {
            sendEvent(ON_MODAL_STATE_VISIBLE, null);
        } else {
            sendEvent(ON_MODAL_STATE_HIDDEN, null);
        }
    }

    private void sendEvent(String str, WritableMap writableMap) {
        try {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
        } catch (Exception e) {
            sendFailureInfo(createErrorMessageMap("sendEvent", e), false);
        }
    }
}
