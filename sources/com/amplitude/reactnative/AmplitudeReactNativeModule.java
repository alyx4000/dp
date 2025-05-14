package com.amplitude.reactnative;

import android.content.Context;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.iterable.iterableapi.IterableConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AmplitudeReactNativeModule.kt */
@ReactModule(name = AmplitudeReactNativeModuleKt.MODULE_NAME)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0003J\"\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0003J\u001f\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0003J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\"\u0010\u001a\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/amplitude/reactnative/AmplitudeReactNativeModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "androidContextProvider", "Lcom/amplitude/reactnative/AndroidContextProvider;", "getApplicationContext", "", "options", "Lcom/facebook/react/bridge/ReadableMap;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "getLegacyEvents", "instanceName", "", "eventKind", "getLegacyLongValue", "", "storage", "Lcom/amplitude/reactnative/LegacyDatabaseStorage;", DatabaseConstants.KEY_FIELD, "(Lcom/amplitude/reactnative/LegacyDatabaseStorage;Ljava/lang/String;)Ljava/lang/Long;", "getLegacySessionData", "getLegacyValue", "getName", "removeLegacyEvent", "eventId", "", "Companion", "amplitude_analytics-react-native_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AmplitudeReactNativeModule extends ReactContextBaseJavaModule {
    public static final String DEVICE_ID_KEY = "device_id";
    public static final String LAST_EVENT_ID_KEY = "last_event_id";
    public static final String LAST_EVENT_TIME_KEY = "last_event_time";
    public static final String PREVIOUS_SESSION_ID_KEY = "previous_session_id";
    public static final String USER_ID_KEY = "user_id";
    private AndroidContextProvider androidContextProvider;
    private final ReactApplicationContext reactContext;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return AmplitudeReactNativeModuleKt.MODULE_NAME;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmplitudeReactNativeModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
    }

    @ReactMethod
    private final void getApplicationContext(ReadableMap options, Promise promise) {
        boolean z = options.hasKey("adid") ? options.getBoolean("adid") : false;
        if (this.androidContextProvider == null) {
            Context applicationContext = this.reactContext.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "reactContext.applicationContext");
            this.androidContextProvider = new AndroidContextProvider(applicationContext, z);
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        AndroidContextProvider androidContextProvider = this.androidContextProvider;
        Intrinsics.checkNotNull(androidContextProvider);
        writableNativeMap.putString("version", androidContextProvider.getVersionName());
        AndroidContextProvider androidContextProvider2 = this.androidContextProvider;
        Intrinsics.checkNotNull(androidContextProvider2);
        writableNativeMap.putString("platform", androidContextProvider2.getPlatform());
        AndroidContextProvider androidContextProvider3 = this.androidContextProvider;
        Intrinsics.checkNotNull(androidContextProvider3);
        writableNativeMap.putString("language", androidContextProvider3.getLanguage());
        AndroidContextProvider androidContextProvider4 = this.androidContextProvider;
        Intrinsics.checkNotNull(androidContextProvider4);
        writableNativeMap.putString("country", androidContextProvider4.getCountry());
        AndroidContextProvider androidContextProvider5 = this.androidContextProvider;
        Intrinsics.checkNotNull(androidContextProvider5);
        writableNativeMap.putString("osName", androidContextProvider5.getOsName());
        AndroidContextProvider androidContextProvider6 = this.androidContextProvider;
        Intrinsics.checkNotNull(androidContextProvider6);
        writableNativeMap.putString("osVersion", androidContextProvider6.getOsVersion());
        AndroidContextProvider androidContextProvider7 = this.androidContextProvider;
        Intrinsics.checkNotNull(androidContextProvider7);
        writableNativeMap.putString("deviceBrand", androidContextProvider7.getBrand());
        AndroidContextProvider androidContextProvider8 = this.androidContextProvider;
        Intrinsics.checkNotNull(androidContextProvider8);
        writableNativeMap.putString("deviceManufacturer", androidContextProvider8.getManufacturer());
        AndroidContextProvider androidContextProvider9 = this.androidContextProvider;
        Intrinsics.checkNotNull(androidContextProvider9);
        writableNativeMap.putString("deviceModel", androidContextProvider9.getModel());
        AndroidContextProvider androidContextProvider10 = this.androidContextProvider;
        Intrinsics.checkNotNull(androidContextProvider10);
        writableNativeMap.putString("carrier", androidContextProvider10.getCarrier());
        if (z) {
            AndroidContextProvider androidContextProvider11 = this.androidContextProvider;
            Intrinsics.checkNotNull(androidContextProvider11);
            writableNativeMap.putString("adid", androidContextProvider11.getAdvertisingId());
        }
        AndroidContextProvider androidContextProvider12 = this.androidContextProvider;
        Intrinsics.checkNotNull(androidContextProvider12);
        writableNativeMap.putString("appSetId", androidContextProvider12.getAppSetId());
        promise.resolve(writableNativeMap);
    }

    @ReactMethod
    private final void getLegacySessionData(String instanceName, Promise promise) {
        try {
            LegacyDatabaseStorageProvider legacyDatabaseStorageProvider = LegacyDatabaseStorageProvider.INSTANCE;
            Context applicationContext = this.reactContext.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "reactContext.applicationContext");
            LegacyDatabaseStorage storage = legacyDatabaseStorageProvider.getStorage(applicationContext, instanceName);
            String legacyValue = getLegacyValue(storage, DEVICE_ID_KEY);
            String legacyValue2 = getLegacyValue(storage, "user_id");
            Long legacyLongValue = getLegacyLongValue(storage, PREVIOUS_SESSION_ID_KEY);
            Long legacyLongValue2 = getLegacyLongValue(storage, LAST_EVENT_TIME_KEY);
            Long legacyLongValue3 = getLegacyLongValue(storage, LAST_EVENT_ID_KEY);
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            if (legacyValue != null) {
                writableNativeMap.putString(IterableConstants.DEVICE_ID, legacyValue);
            }
            if (legacyValue2 != null) {
                writableNativeMap.putString(IterableConstants.KEY_USER_ID, legacyValue2);
            }
            if (legacyLongValue != null) {
                writableNativeMap.putDouble("sessionId", legacyLongValue.longValue());
            }
            if (legacyLongValue2 != null) {
                writableNativeMap.putDouble("lastEventTime", legacyLongValue2.longValue());
            }
            if (legacyLongValue3 != null) {
                writableNativeMap.putDouble("lastEventId", legacyLongValue3.longValue());
            }
            promise.resolve(writableNativeMap);
        } catch (Exception e) {
            LogcatLogger.INSTANCE.getLogger().error("can't get legacy session data: " + e);
        }
    }

    private final String getLegacyValue(LegacyDatabaseStorage storage, String key) {
        try {
            return storage.getValue(key);
        } catch (Exception e) {
            LogcatLogger.INSTANCE.getLogger().error("can't get legacy " + key + ": " + e);
            return null;
        }
    }

    private final Long getLegacyLongValue(LegacyDatabaseStorage storage, String key) {
        try {
            return storage.getLongValue(key);
        } catch (Exception e) {
            LogcatLogger.INSTANCE.getLogger().error("can't get legacy " + key + ": " + e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0063 A[Catch: Exception -> 0x0075, LOOP:0: B:11:0x005d->B:13:0x0063, LOOP_END, TryCatch #0 {Exception -> 0x0075, blocks: (B:2:0x0000, B:9:0x0049, B:10:0x0052, B:11:0x005d, B:13:0x0063, B:15:0x0071, B:19:0x0025, B:22:0x002e, B:23:0x0033, B:26:0x003c, B:27:0x0041, B:29:0x004e), top: B:1:0x0000 }] */
    @com.facebook.react.bridge.ReactMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getLegacyEvents(java.lang.String r4, java.lang.String r5, com.facebook.react.bridge.Promise r6) {
        /*
            r3 = this;
            com.amplitude.reactnative.LegacyDatabaseStorageProvider r0 = com.amplitude.reactnative.LegacyDatabaseStorageProvider.INSTANCE     // Catch: java.lang.Exception -> L75
            com.facebook.react.bridge.ReactApplicationContext r1 = r3.reactContext     // Catch: java.lang.Exception -> L75
            android.content.Context r1 = r1.getApplicationContext()     // Catch: java.lang.Exception -> L75
            java.lang.String r2 = "reactContext.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch: java.lang.Exception -> L75
            com.amplitude.reactnative.LegacyDatabaseStorage r4 = r0.getStorage(r1, r4)     // Catch: java.lang.Exception -> L75
            int r0 = r5.hashCode()     // Catch: java.lang.Exception -> L75
            r1 = -267163891(0xfffffffff013670d, float:-1.824755E29)
            if (r0 == r1) goto L41
            r1 = -135762164(0xfffffffff7e86f0c, float:-9.428634E33)
            if (r0 == r1) goto L33
            r1 = 96891546(0x5c6729a, float:1.8661928E-35)
            if (r0 == r1) goto L25
            goto L49
        L25:
            java.lang.String r0 = "event"
            boolean r0 = r5.equals(r0)     // Catch: java.lang.Exception -> L75
            if (r0 != 0) goto L2e
            goto L49
        L2e:
            java.util.List r4 = r4.readEvents()     // Catch: java.lang.Exception -> L75
            goto L52
        L33:
            java.lang.String r0 = "identify"
            boolean r0 = r5.equals(r0)     // Catch: java.lang.Exception -> L75
            if (r0 != 0) goto L3c
            goto L49
        L3c:
            java.util.List r4 = r4.readIdentifies()     // Catch: java.lang.Exception -> L75
            goto L52
        L41:
            java.lang.String r0 = "interceptedIdentify"
            boolean r0 = r5.equals(r0)     // Catch: java.lang.Exception -> L75
            if (r0 != 0) goto L4e
        L49:
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()     // Catch: java.lang.Exception -> L75
            goto L52
        L4e:
            java.util.List r4 = r4.readInterceptedIdentifies()     // Catch: java.lang.Exception -> L75
        L52:
            com.facebook.react.bridge.WritableNativeArray r0 = new com.facebook.react.bridge.WritableNativeArray     // Catch: java.lang.Exception -> L75
            r0.<init>()     // Catch: java.lang.Exception -> L75
            java.lang.Iterable r4 = (java.lang.Iterable) r4     // Catch: java.lang.Exception -> L75
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Exception -> L75
        L5d:
            boolean r1 = r4.hasNext()     // Catch: java.lang.Exception -> L75
            if (r1 == 0) goto L71
            java.lang.Object r1 = r4.next()     // Catch: java.lang.Exception -> L75
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch: java.lang.Exception -> L75
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L75
            r0.pushString(r1)     // Catch: java.lang.Exception -> L75
            goto L5d
        L71:
            r6.resolve(r0)     // Catch: java.lang.Exception -> L75
            goto La0
        L75:
            r4 = move-exception
            com.amplitude.reactnative.LogcatLogger$Companion r0 = com.amplitude.reactnative.LogcatLogger.INSTANCE
            com.amplitude.reactnative.LogcatLogger r0 = r0.getLogger()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "can't get legacy "
            r1.<init>(r2)
            java.lang.StringBuilder r5 = r1.append(r5)
            java.lang.String r1 = "s: "
            java.lang.StringBuilder r5 = r5.append(r1)
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.String r4 = r4.toString()
            r0.error(r4)
            com.facebook.react.bridge.WritableNativeArray r4 = new com.facebook.react.bridge.WritableNativeArray
            r4.<init>()
            r6.resolve(r4)
        La0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.reactnative.AmplitudeReactNativeModule.getLegacyEvents(java.lang.String, java.lang.String, com.facebook.react.bridge.Promise):void");
    }

    @ReactMethod
    private final void removeLegacyEvent(String instanceName, String eventKind, int eventId) {
        try {
            LegacyDatabaseStorageProvider legacyDatabaseStorageProvider = LegacyDatabaseStorageProvider.INSTANCE;
            Context applicationContext = this.reactContext.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "reactContext.applicationContext");
            LegacyDatabaseStorage storage = legacyDatabaseStorageProvider.getStorage(applicationContext, instanceName);
            int hashCode = eventKind.hashCode();
            if (hashCode != -267163891) {
                if (hashCode != -135762164) {
                    if (hashCode == 96891546 && eventKind.equals("event")) {
                        storage.removeEvent(eventId);
                    }
                } else if (eventKind.equals("identify")) {
                    storage.removeIdentify(eventId);
                }
            } else if (eventKind.equals("interceptedIdentify")) {
                storage.removeInterceptedIdentify(eventId);
            }
        } catch (Exception e) {
            LogcatLogger.INSTANCE.getLogger().error("can't remove legacy " + eventKind + " with id=" + eventId + ": " + e);
        }
    }
}
