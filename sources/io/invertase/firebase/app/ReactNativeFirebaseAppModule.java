package io.invertase.firebase.app;

import android.util.Log;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.firebase.FirebaseApp;
import io.invertase.firebase.common.RCTConvertFirebase;
import io.invertase.firebase.common.ReactNativeFirebaseEvent;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.ReactNativeFirebaseJSON;
import io.invertase.firebase.common.ReactNativeFirebaseMeta;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import io.invertase.firebase.common.ReactNativeFirebasePreferences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class ReactNativeFirebaseAppModule extends ReactNativeFirebaseModule {
    private static final String TAG = "App";
    public static Map<String, String> authDomains = new HashMap();

    @ReactMethod
    public void addListener(String str) {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    ReactNativeFirebaseAppModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, TAG);
    }

    @Override // io.invertase.firebase.common.ReactNativeFirebaseModule, com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        super.initialize();
        ReactNativeFirebaseEventEmitter.getSharedInstance().attachReactContext(getContext());
    }

    @ReactMethod
    public void initializeApp(ReadableMap readableMap, ReadableMap readableMap2, Promise promise) {
        FirebaseApp readableMapToFirebaseApp = RCTConvertFirebase.readableMapToFirebaseApp(readableMap, readableMap2, getContext());
        configureAuthDomain(readableMap2.getString("name"), readableMap.getString("authDomain"));
        promise.resolve(RCTConvertFirebase.firebaseAppToWritableMap(readableMapToFirebaseApp));
    }

    public static void configureAuthDomain(String str, String str2) {
        if (str2 != null) {
            Log.d(TAG, str + " custom authDomain " + str2);
            authDomains.put(str, str2);
        } else {
            authDomains.remove(str);
        }
    }

    @ReactMethod
    public void setAutomaticDataCollectionEnabled(String str, Boolean bool) {
        FirebaseApp.getInstance(str).setDataCollectionDefaultEnabled(bool);
    }

    @ReactMethod
    public void deleteApp(String str, Promise promise) {
        FirebaseApp firebaseApp = FirebaseApp.getInstance(str);
        if (firebaseApp != null) {
            firebaseApp.delete();
        }
        promise.resolve(null);
    }

    @ReactMethod
    public void eventsNotifyReady(Boolean bool) {
        ReactNativeFirebaseEventEmitter.getSharedInstance().notifyJsReady(bool);
    }

    @ReactMethod
    public void eventsGetListeners(Promise promise) {
        promise.resolve(ReactNativeFirebaseEventEmitter.getSharedInstance().getListenersMap());
    }

    @ReactMethod
    public void eventsPing(String str, ReadableMap readableMap, Promise promise) {
        ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(new ReactNativeFirebaseEvent(str, RCTConvertFirebase.readableMapToWritableMap(readableMap)));
        promise.resolve(RCTConvertFirebase.readableMapToWritableMap(readableMap));
    }

    @ReactMethod
    public void eventsAddListener(String str) {
        ReactNativeFirebaseEventEmitter.getSharedInstance().addListener(str);
    }

    @ReactMethod
    public void eventsRemoveListener(String str, Boolean bool) {
        ReactNativeFirebaseEventEmitter.getSharedInstance().removeListener(str, bool);
    }

    @ReactMethod
    public void metaGetAll(Promise promise) {
        promise.resolve(ReactNativeFirebaseMeta.getSharedInstance().getAll());
    }

    @ReactMethod
    public void jsonGetAll(Promise promise) {
        promise.resolve(ReactNativeFirebaseJSON.getSharedInstance().getAll());
    }

    @ReactMethod
    public void preferencesSetBool(String str, boolean z, Promise promise) {
        ReactNativeFirebasePreferences.getSharedInstance().setBooleanValue(str, z);
        promise.resolve(null);
    }

    @ReactMethod
    public void preferencesSetString(String str, String str2, Promise promise) {
        ReactNativeFirebasePreferences.getSharedInstance().setStringValue(str, str2);
        promise.resolve(null);
    }

    @ReactMethod
    public void preferencesGetAll(Promise promise) {
        promise.resolve(ReactNativeFirebasePreferences.getSharedInstance().getAll());
    }

    @ReactMethod
    public void preferencesClearAll(Promise promise) {
        ReactNativeFirebasePreferences.getSharedInstance().clearAll();
        promise.resolve(null);
    }

    @Override // io.invertase.firebase.common.ReactNativeFirebaseModule, com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<FirebaseApp> it = FirebaseApp.getApps(getReactApplicationContext()).iterator();
        while (it.hasNext()) {
            arrayList.add(RCTConvertFirebase.firebaseAppToMap(it.next()));
        }
        hashMap.put("NATIVE_FIREBASE_APPS", arrayList);
        hashMap.put("FIREBASE_RAW_JSON", ReactNativeFirebaseJSON.getSharedInstance().getRawJSON());
        return hashMap;
    }
}
