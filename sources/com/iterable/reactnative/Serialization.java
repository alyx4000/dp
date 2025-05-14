package com.iterable.reactnative;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.iterable.iterableapi.CommerceItem;
import com.iterable.iterableapi.IterableAction;
import com.iterable.iterableapi.IterableActionContext;
import com.iterable.iterableapi.IterableConfig;
import com.iterable.iterableapi.IterableConstants;
import com.iterable.iterableapi.IterableDataRegion;
import com.iterable.iterableapi.IterableInAppCloseAction;
import com.iterable.iterableapi.IterableInAppDeleteActionType;
import com.iterable.iterableapi.IterableInAppHandler;
import com.iterable.iterableapi.IterableInAppLocation;
import com.iterable.iterableapi.IterableInAppMessage;
import com.iterable.iterableapi.IterableInboxSession;
import com.iterable.iterableapi.IterableLogger;
import com.iterable.iterableapi.RNIterableInternal;
import io.sentry.clientreport.DiscardedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
class Serialization {
    static String TAG = "Serialization";

    Serialization() {
    }

    static IterableInAppLocation getIterableInAppLocationFromInteger(Integer num) {
        if (num == null || num.intValue() >= IterableInAppLocation.values().length || num.intValue() < 0) {
            return null;
        }
        return IterableInAppLocation.values()[num.intValue()];
    }

    static IterableInAppCloseAction getIterableInAppCloseSourceFromInteger(Integer num) {
        if (num == null || num.intValue() >= IterableInAppCloseAction.values().length || num.intValue() < 0) {
            return null;
        }
        return IterableInAppCloseAction.values()[num.intValue()];
    }

    static IterableInAppDeleteActionType getIterableDeleteActionTypeFromInteger(Integer num) {
        if (num == null || num.intValue() >= IterableInAppCloseAction.values().length || num.intValue() < 0) {
            return null;
        }
        return IterableInAppDeleteActionType.values()[num.intValue()];
    }

    static IterableInAppHandler.InAppResponse getInAppResponse(Integer num) {
        if (num == null || num.intValue() >= IterableInAppCloseAction.values().length || num.intValue() < 0) {
            return null;
        }
        return IterableInAppHandler.InAppResponse.values()[num.intValue()];
    }

    static List<CommerceItem> commerceItemsFromReadableArray(ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray convertArrayToJson = convertArrayToJson(readableArray);
            for (int i = 0; i < convertArrayToJson.length(); i++) {
                arrayList.add(commerceItemFromMap(convertArrayToJson.getJSONObject(i)));
            }
        } catch (JSONException unused) {
            IterableLogger.e(TAG, "Failed converting to JSONObject");
        }
        return arrayList;
    }

    static CommerceItem commerceItemFromMap(JSONObject jSONObject) throws JSONException {
        String[] strArr;
        JSONArray optJSONArray = jSONObject.optJSONArray("categories");
        if (optJSONArray != null) {
            String[] strArr2 = null;
            for (int i = 0; i < optJSONArray.length(); i++) {
                if (strArr2 == null) {
                    strArr2 = new String[optJSONArray.length()];
                }
                strArr2[i] = optJSONArray.getString(i);
            }
            strArr = strArr2;
        } else {
            strArr = null;
        }
        return new CommerceItem(jSONObject.getString("id"), jSONObject.getString("name"), jSONObject.getDouble("price"), jSONObject.getInt(DiscardedEvent.JsonKeys.QUANTITY), jSONObject.optString("sku", null), jSONObject.optString("description", null), jSONObject.optString("url", null), jSONObject.optString("imageUrl", null), strArr, jSONObject.optJSONObject(IterableConstants.KEY_DATA_FIELDS));
    }

    static JSONObject messageContentToJsonObject(IterableInAppMessage.Content content) {
        if (content == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("edgeInsets", content.padding);
            jSONObject.put(IterableConstants.ITERABLE_IN_APP_HTML, content.html);
            if (jSONObject.length() == 0) {
                return null;
            }
            return jSONObject;
        } catch (JSONException e) {
            IterableLogger.e(TAG, "Failed to serialize message content\n" + e.getLocalizedMessage());
            return null;
        }
    }

    static JSONArray serializeInAppMessages(List<IterableInAppMessage> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<IterableInAppMessage> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(RNIterableInternal.getInAppMessageJson(it.next()));
        }
        return jSONArray;
    }

    static IterableConfig.Builder getConfigFromReadableMap(ReadableMap readableMap) {
        IterableDataRegion iterableDataRegion;
        int i;
        try {
            JSONObject convertMapToJson = convertMapToJson(readableMap);
            IterableConfig.Builder builder = new IterableConfig.Builder();
            if (convertMapToJson.has("allowedProtocols")) {
                WritableArray convertJsonToArray = convertJsonToArray(convertMapToJson.getJSONArray("allowedProtocols"));
                String[] strArr = new String[convertJsonToArray.size()];
                for (int i2 = 0; i2 < convertJsonToArray.size(); i2++) {
                    strArr[i2] = convertJsonToArray.getString(i2);
                }
                builder.setAllowedProtocols(strArr);
            }
            if (convertMapToJson.has("pushIntegrationName")) {
                builder.setPushIntegrationName(convertMapToJson.optString("pushIntegrationName"));
            }
            if (convertMapToJson.has("autoPushRegistration")) {
                builder.setAutoPushRegistration(convertMapToJson.optBoolean("autoPushRegistration"));
            }
            if (convertMapToJson.has("inAppDisplayInterval")) {
                builder.setInAppDisplayInterval(convertMapToJson.optDouble("inAppDisplayInterval"));
            }
            if (convertMapToJson.has("expiringAuthTokenRefreshPeriod")) {
                builder.setExpiringAuthTokenRefreshPeriod(Long.valueOf(convertMapToJson.optLong("expiringAuthTokenRefreshPeriod")));
            }
            if (convertMapToJson.has("useInMemoryStorageForInApps") || convertMapToJson.has("androidSdkUseInMemoryStorageForInApps")) {
                builder.setUseInMemoryStorageForInApps(convertMapToJson.optBoolean("useInMemoryStorageForInApps"));
            }
            if (convertMapToJson.has("logLevel")) {
                int i3 = convertMapToJson.getInt("logLevel");
                if (i3 != 1) {
                    i = 2;
                    if (i3 != 2) {
                        i = 6;
                    }
                } else {
                    i = 3;
                }
                builder.setLogLevel(i);
            }
            if (convertMapToJson.has("dataRegion")) {
                int i4 = convertMapToJson.getInt("dataRegion");
                IterableDataRegion iterableDataRegion2 = IterableDataRegion.US;
                if (i4 == 0) {
                    iterableDataRegion = IterableDataRegion.US;
                } else if (i4 == 1) {
                    iterableDataRegion = IterableDataRegion.EU;
                } else {
                    iterableDataRegion = IterableDataRegion.US;
                }
                builder.setDataRegion(iterableDataRegion);
            }
            if (convertMapToJson.has("encryptionEnforced")) {
                builder.setEncryptionEnforced(convertMapToJson.optBoolean("encryptionEnforced"));
            }
            return builder;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    static JSONObject actionToJson(IterableAction iterableAction) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", iterableAction.getType());
            if (iterableAction.getData() != null && iterableAction.getData() != "") {
                jSONObject.put("data", iterableAction.getData());
            }
            if (iterableAction.userInput == null && iterableAction.userInput != "") {
                jSONObject.put(IterableConstants.USER_INPUT, iterableAction.userInput);
            }
        } catch (JSONException e) {
            IterableLogger.e(TAG, e.getLocalizedMessage());
        }
        return jSONObject;
    }

    static JSONObject actionContextToJson(IterableActionContext iterableActionContext) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", actionToJson(iterableActionContext.action));
            jSONObject.put("source", iterableActionContext.source.ordinal());
        } catch (JSONException e) {
            IterableLogger.e(TAG, e.getLocalizedMessage());
        }
        return jSONObject;
    }

    static IterableInboxSession.Impression inboxImpressionFromMap(JSONObject jSONObject) throws JSONException {
        return new IterableInboxSession.Impression(jSONObject.getString(IterableConstants.KEY_MESSAGE_ID), jSONObject.getBoolean(IterableConstants.ITERABLE_IN_APP_SILENT_INBOX), jSONObject.optInt(IterableConstants.ITERABLE_INBOX_IMP_DISPLAY_COUNT, 0), (float) jSONObject.optDouble("duration", 0.0d));
    }

    static List<IterableInboxSession.Impression> impressionsFromReadableArray(ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray convertArrayToJson = convertArrayToJson(readableArray);
            for (int i = 0; i < convertArrayToJson.length(); i++) {
                arrayList.add(inboxImpressionFromMap(convertArrayToJson.getJSONObject(i)));
            }
        } catch (JSONException unused) {
            IterableLogger.e(TAG, "Failed converting to JSONObject");
        }
        return arrayList;
    }

    static WritableMap convertJsonToMap(JSONObject jSONObject) throws JSONException {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONObject) {
                writableNativeMap.putMap(next, convertJsonToMap((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                writableNativeMap.putArray(next, convertJsonToArray((JSONArray) obj));
            } else if (obj instanceof Boolean) {
                writableNativeMap.putBoolean(next, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                writableNativeMap.putInt(next, ((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                writableNativeMap.putDouble(next, ((Double) obj).doubleValue());
            } else if (obj instanceof String) {
                writableNativeMap.putString(next, (String) obj);
            } else {
                writableNativeMap.putString(next, obj.toString());
            }
        }
        return writableNativeMap;
    }

    static WritableArray convertJsonToArray(JSONArray jSONArray) throws JSONException {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONObject) {
                writableNativeArray.pushMap(convertJsonToMap((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                writableNativeArray.pushArray(convertJsonToArray((JSONArray) obj));
            } else if (obj instanceof Boolean) {
                writableNativeArray.pushBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                writableNativeArray.pushInt(((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                writableNativeArray.pushDouble(((Double) obj).doubleValue());
            } else if (obj instanceof String) {
                writableNativeArray.pushString((String) obj);
            } else {
                writableNativeArray.pushString(obj.toString());
            }
        }
        return writableNativeArray;
    }

    static JSONObject convertMapToJson(ReadableMap readableMap) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(nextKey).ordinal()]) {
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

    /* renamed from: com.iterable.reactnative.Serialization$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$facebook$react$bridge$ReadableType = iArr;
            try {
                iArr[ReadableType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Boolean.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Number.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.String.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static JSONArray convertArrayToJson(ReadableArray readableArray) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < readableArray.size(); i++) {
            int i2 = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i).ordinal()];
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
