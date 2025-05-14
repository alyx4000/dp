package com.extole.android.sdk;

import androidx.exifinterface.media.ExifInterface;
import com.extole.android.sdk.impl.ExtoleInternal;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.iterable.iterableapi.IterableConstants;
import io.sentry.Session;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RNExtole.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 (2\u00020\u0001:\u0001(B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J>\u0010\f\u001a\u00020\b\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u001e\u0010\u0010\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0014J \u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u001b\u001a\u00020\nH\u0016J \u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J \u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0018H\u0007J\b\u0010$\u001a\u00020\bH\u0007J \u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010'\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/extole/android/sdk/RNExtole;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "extole", "Lcom/extole/android/sdk/impl/ExtoleInternal;", external.sdk.pendo.io.daimajia.BuildConfig.BUILD_TYPE, "", "message", "", "error", "executeWithPromise", ExifInterface.GPS_DIRECTION_TRUE, BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "closure", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lcom/facebook/react/bridge/Promise;Lkotlin/jvm/functions/Function1;)V", "fetchZone", "zoneName", "data", "Lcom/facebook/react/bridge/ReadableMap;", "getAccessToken", "getJsonConfiguration", "getName", "identify", "email", "identifyJwt", "jwt", "info", Session.JsonKeys.INIT, "programDomain", "parameters", "logout", "sendEvent", IterableConstants.KEY_EVENT_NAME, "warn", "Companion", "extole_react-native-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RNExtole extends ReactContextBaseJavaModule {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private volatile ExtoleInternal extole;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "ExtoleMobileSdk";
    }

    public RNExtole(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004b, code lost:
    
        if (r3 == null) goto L12;
     */
    @com.facebook.react.bridge.ReactMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void init(java.lang.String r22, com.facebook.react.bridge.ReadableMap r23) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.extole.android.sdk.RNExtole.init(java.lang.String, com.facebook.react.bridge.ReadableMap):void");
    }

    @ReactMethod
    public final void sendEvent(String eventName, ReadableMap data, Promise promise) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(promise, "promise");
        executeWithPromise(promise, new RNExtole$sendEvent$1(this, data, eventName, null));
    }

    @ReactMethod
    public final void debug(String message) {
        ExtoleLogger logger;
        Intrinsics.checkNotNullParameter(message, "message");
        ExtoleInternal extoleInternal = this.extole;
        if (extoleInternal == null || (logger = extoleInternal.getLogger()) == null) {
            return;
        }
        logger.debug(message, new Object[0]);
    }

    @ReactMethod
    public final void info(String message) {
        ExtoleLogger logger;
        Intrinsics.checkNotNullParameter(message, "message");
        ExtoleInternal extoleInternal = this.extole;
        if (extoleInternal == null || (logger = extoleInternal.getLogger()) == null) {
            return;
        }
        logger.info(message, new Object[0]);
    }

    @ReactMethod
    public final void warn(String message) {
        ExtoleLogger logger;
        Intrinsics.checkNotNullParameter(message, "message");
        ExtoleInternal extoleInternal = this.extole;
        if (extoleInternal == null || (logger = extoleInternal.getLogger()) == null) {
            return;
        }
        logger.warn(message, new Object[0]);
    }

    @ReactMethod
    public final void error(String message) {
        ExtoleLogger logger;
        Intrinsics.checkNotNullParameter(message, "message");
        ExtoleInternal extoleInternal = this.extole;
        if (extoleInternal == null || (logger = extoleInternal.getLogger()) == null) {
            return;
        }
        logger.error(message, new Object[0]);
    }

    @ReactMethod
    public final void logout() {
        ExtoleInternal extoleInternal = this.extole;
        if (extoleInternal != null) {
            extoleInternal.logout();
        }
    }

    @ReactMethod
    public final void fetchZone(String zoneName, ReadableMap data, Promise promise) {
        Intrinsics.checkNotNullParameter(zoneName, "zoneName");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(promise, "promise");
        executeWithPromise(promise, new RNExtole$fetchZone$1(this, zoneName, data, null));
    }

    @ReactMethod
    public final void identify(String email, ReadableMap data, Promise promise) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(promise, "promise");
        executeWithPromise(promise, new RNExtole$identify$1(this, data, email, null));
    }

    @ReactMethod
    public final void identifyJwt(String jwt, ReadableMap data, Promise promise) {
        Intrinsics.checkNotNullParameter(jwt, "jwt");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(promise, "promise");
        executeWithPromise(promise, new RNExtole$identifyJwt$1(this, data, jwt, null));
    }

    @ReactMethod
    public final void getJsonConfiguration(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        ExtoleInternal extoleInternal = this.extole;
        promise.resolve(new JSONArray((Collection) (extoleInternal != null ? extoleInternal.getJsonConfiguration() : null)).toString());
    }

    @ReactMethod
    public final void getAccessToken(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        ExtoleInternal extoleInternal = this.extole;
        promise.resolve(extoleInternal != null ? extoleInternal.getAccessToken() : null);
    }

    private final <T> void executeWithPromise(Promise promise, Function1<? super Continuation<? super T>, ? extends Object> closure) {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new RNExtole$executeWithPromise$1(promise, closure, null), 3, null);
    }

    /* compiled from: RNExtole.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0004J\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u001c\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002¨\u0006\u0016"}, d2 = {"Lcom/extole/android/sdk/RNExtole$Companion;", "", "()V", "convertArrayToJson", "Lorg/json/JSONArray;", "readableArray", "Lcom/facebook/react/bridge/ReadableArray;", "convertJsonToArray", "Lcom/facebook/react/bridge/WritableArray;", "jsonArray", "convertJsonToMap", "Lcom/facebook/react/bridge/WritableMap;", "jsonObject", "Lorg/json/JSONObject;", "convertMapToJson", "readableMap", "Lcom/facebook/react/bridge/ReadableMap;", "recursivelyDeconstructReadableArray", "", "recursivelyDeconstructReadableMap", "", "", "extole_react-native-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        /* compiled from: RNExtole.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ReadableType.values().length];
                try {
                    iArr[ReadableType.Null.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ReadableType.Boolean.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ReadableType.Number.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ReadableType.String.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ReadableType.Map.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ReadableType.Array.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<String, Object> recursivelyDeconstructReadableMap(ReadableMap readableMap) {
            Intrinsics.checkNotNull(readableMap);
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            Intrinsics.checkNotNullExpressionValue(keySetIterator, "readableMap!!.keySetIterator()");
            HashMap hashMap = new HashMap();
            while (keySetIterator.hasNextKey()) {
                String key = keySetIterator.nextKey();
                ReadableType type = readableMap.getType(key);
                Intrinsics.checkNotNullExpressionValue(type, "readableMap.getType(key)");
                switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                    case 1:
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        hashMap.put(key, null);
                        break;
                    case 2:
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        hashMap.put(key, Boolean.valueOf(readableMap.getBoolean(key)));
                        break;
                    case 3:
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        hashMap.put(key, Double.valueOf(readableMap.getDouble(key)));
                        break;
                    case 4:
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        hashMap.put(key, readableMap.getString(key));
                        break;
                    case 5:
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        hashMap.put(key, recursivelyDeconstructReadableMap(readableMap.getMap(key)));
                        break;
                    case 6:
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        hashMap.put(key, recursivelyDeconstructReadableArray(readableMap.getArray(key)));
                        break;
                    default:
                        throw new IllegalArgumentException("Could not convert object with key: " + key + ".");
                }
            }
            return hashMap;
        }

        private final List<Object> recursivelyDeconstructReadableArray(ReadableArray readableArray) {
            if (readableArray == null) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            int size = readableArray.size();
            for (int i = 0; i < size; i++) {
                ReadableType type = readableArray.getType(i);
                Intrinsics.checkNotNullExpressionValue(type, "readableArray.getType(i)");
                switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                    case 1:
                        arrayList.add(i, null);
                        break;
                    case 2:
                        arrayList.add(i, Boolean.valueOf(readableArray.getBoolean(i)));
                        break;
                    case 3:
                        arrayList.add(i, Double.valueOf(readableArray.getDouble(i)));
                        break;
                    case 4:
                        arrayList.add(i, readableArray.getString(i));
                        break;
                    case 5:
                        arrayList.add(i, recursivelyDeconstructReadableMap(readableArray.getMap(i)));
                        break;
                    case 6:
                        arrayList.add(i, recursivelyDeconstructReadableArray(readableArray.getArray(i)));
                        break;
                    default:
                        throw new IllegalArgumentException("Could not convert object at index " + i + ".");
                }
            }
            return arrayList;
        }

        public final WritableMap convertJsonToMap(JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            Iterator<String> keys = jsonObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jsonObject.get(next);
                Intrinsics.checkNotNullExpressionValue(obj, "jsonObject.get(key)");
                if (obj instanceof JSONObject) {
                    writableNativeMap.putMap(next, convertJsonToMap((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    writableNativeMap.putArray(next, convertJsonToArray((JSONArray) obj));
                } else if (obj instanceof Boolean) {
                    writableNativeMap.putBoolean(next, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Integer) {
                    writableNativeMap.putInt(next, ((Number) obj).intValue());
                } else if (obj instanceof Double) {
                    writableNativeMap.putDouble(next, ((Number) obj).doubleValue());
                } else if (obj instanceof String) {
                    writableNativeMap.putString(next, (String) obj);
                } else {
                    writableNativeMap.putString(next, obj.toString());
                }
            }
            return writableNativeMap;
        }

        public final WritableArray convertJsonToArray(JSONArray jsonArray) {
            Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
            WritableNativeArray writableNativeArray = new WritableNativeArray();
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                Object obj = jsonArray.get(i);
                Intrinsics.checkNotNullExpressionValue(obj, "jsonArray.get(i)");
                if (obj instanceof JSONObject) {
                    writableNativeArray.pushMap(convertJsonToMap((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    writableNativeArray.pushArray(convertJsonToArray((JSONArray) obj));
                } else if (obj instanceof Boolean) {
                    writableNativeArray.pushBoolean(((Boolean) obj).booleanValue());
                } else if (obj instanceof Integer) {
                    writableNativeArray.pushInt(((Number) obj).intValue());
                } else if (obj instanceof Double) {
                    writableNativeArray.pushDouble(((Number) obj).doubleValue());
                } else if (obj instanceof String) {
                    writableNativeArray.pushString((String) obj);
                } else {
                    writableNativeArray.pushString(obj.toString());
                }
            }
            return writableNativeArray;
        }

        public final JSONObject convertMapToJson(ReadableMap readableMap) {
            JSONObject jSONObject = new JSONObject();
            Intrinsics.checkNotNull(readableMap);
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            Intrinsics.checkNotNullExpressionValue(keySetIterator, "readableMap!!.keySetIterator()");
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                switch (WhenMappings.$EnumSwitchMapping$0[readableMap.getType(nextKey).ordinal()]) {
                    case 1:
                        jSONObject.put(nextKey, JSONObject.NULL);
                        break;
                    case 2:
                        jSONObject.put(nextKey, readableMap.getBoolean(nextKey));
                        break;
                    case 3:
                        jSONObject.put(nextKey, readableMap.getDouble(nextKey));
                        break;
                    case 4:
                        jSONObject.put(nextKey, readableMap.getString(nextKey));
                        break;
                    case 5:
                        jSONObject.put(nextKey, convertMapToJson(readableMap.getMap(nextKey)));
                        break;
                    case 6:
                        jSONObject.put(nextKey, convertArrayToJson(readableMap.getArray(nextKey)));
                        break;
                }
            }
            return jSONObject;
        }

        public final JSONArray convertArrayToJson(ReadableArray readableArray) {
            JSONArray jSONArray = new JSONArray();
            Intrinsics.checkNotNull(readableArray);
            int size = readableArray.size();
            for (int i = 0; i < size; i++) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[readableArray.getType(i).ordinal()];
                if (i2 == 2) {
                    jSONArray.put(readableArray.getBoolean(i));
                } else if (i2 == 3) {
                    jSONArray.put(readableArray.getDouble(i));
                } else if (i2 == 4) {
                    jSONArray.put(readableArray.getString(i));
                } else if (i2 == 5) {
                    jSONArray.put(convertMapToJson(readableArray.getMap(i)));
                } else if (i2 == 6) {
                    jSONArray.put(convertArrayToJson(readableArray.getArray(i)));
                }
            }
            return jSONArray;
        }
    }
}
