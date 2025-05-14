package com.socure.docv.reactnative;

import android.app.Activity;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.iterable.iterableapi.IterableConstants;
import com.socure.docv.capturesdk.api.Keys;
import com.socure.docv.capturesdk.api.Platform;
import com.socure.docv.capturesdk.api.SocureDocVHelper;
import com.socure.docv.capturesdk.common.utils.ResultListener;
import com.socure.docv.capturesdk.common.utils.ScanError;
import com.socure.docv.capturesdk.common.utils.ScannedData;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SocureDocVReactNativeModule.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\tH\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\tH\u0007J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0007J*\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0007J,\u0010 \u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010'\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010&H\u0016J\u0018\u0010)\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/socure/docv/reactnative/SocureDocVReactNativeModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "Lcom/facebook/react/bridge/ActivityEventListener;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "SOCURE_SDK_REQUEST_CODE", "", "TAG", "", "onErrorCallback", "Lcom/facebook/react/bridge/Callback;", "onSuccessCallback", "convertErrorToReadableMap", "Lcom/facebook/react/bridge/ReadableMap;", "scanError", "Lcom/socure/docv/capturesdk/common/utils/ScanError;", "convertResultToReadbleMap", "scannedData", "Lcom/socure/docv/capturesdk/common/utils/ScannedData;", "convertStringToMap", "jsonObject", "Lorg/json/JSONObject;", "getName", "initDocVSdk", "", "socureApiKey", Keys.KEY_FLOW, "launchDocVSdk", "onSuccess", "onError", "launchSocureDocV", "onActivityResult", "activity", "Landroid/app/Activity;", IterableConstants.REQUEST_CODE, "resultCode", "data", "Landroid/content/Intent;", "onNewIntent", "intent", "setupLaunch", "socure-inc_docv-react-native_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocureDocVReactNativeModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    private final int SOCURE_SDK_REQUEST_CODE;
    private final String TAG;
    private Callback onErrorCallback;
    private Callback onSuccessCallback;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "SocureDocVReactNative";
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onNewIntent(Intent intent) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocureDocVReactNativeModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.TAG = "SDLT_RN";
        this.SOCURE_SDK_REQUEST_CODE = 753;
    }

    @ReactMethod
    public final void initDocVSdk(String socureApiKey, String flow) {
        Intrinsics.checkNotNullParameter(socureApiKey, "socureApiKey");
        Log.d(this.TAG, "initDocVSdk - init native sdk");
        SocureDocVHelper socureDocVHelper = SocureDocVHelper.INSTANCE;
        Activity currentActivity = getCurrentActivity();
        Intrinsics.checkNotNull(currentActivity);
        socureDocVHelper.initSdk(currentActivity, socureApiKey, flow);
    }

    @ReactMethod
    public final void launchDocVSdk(Callback onSuccess, Callback onError) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Log.d(this.TAG, "launchDocVSdk - launch using experimental api");
        setupLaunch(onSuccess, onError);
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            SocureDocVHelper socureDocVHelper = SocureDocVHelper.INSTANCE;
            Activity currentActivity2 = getCurrentActivity();
            Intrinsics.checkNotNull(currentActivity2);
            currentActivity.startActivityForResult(socureDocVHelper.getIntent(currentActivity2), this.SOCURE_SDK_REQUEST_CODE);
        }
    }

    @ReactMethod
    public final void launchSocureDocV(String socureApiKey, String flow, Callback onSuccess, Callback onError) {
        Intrinsics.checkNotNullParameter(socureApiKey, "socureApiKey");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Log.d(this.TAG, "launchSocureDocV - launch Socure SDK");
        setupLaunch(onSuccess, onError);
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            SocureDocVHelper socureDocVHelper = SocureDocVHelper.INSTANCE;
            Activity currentActivity2 = getCurrentActivity();
            Intrinsics.checkNotNull(currentActivity2);
            currentActivity.startActivityForResult(socureDocVHelper.getIntent(currentActivity2, socureApiKey, flow), this.SOCURE_SDK_REQUEST_CODE);
        }
    }

    private final void setupLaunch(Callback onSuccess, Callback onError) {
        this.onSuccessCallback = onSuccess;
        this.onErrorCallback = onError;
        Log.d(this.TAG, "launchSocureDocV - registering activity event listener");
        getReactApplicationContext().addActivityEventListener(this);
        SocureDocVHelper.INSTANCE.setSource(Platform.REACT_NATIVE);
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        if (requestCode == this.SOCURE_SDK_REQUEST_CODE) {
            Log.d(this.TAG, "onActivityResult - requestCode matched, removing activity event listener");
            if (data != null) {
                SocureDocVHelper.INSTANCE.getResult(data, new ResultListener() { // from class: com.socure.docv.reactnative.SocureDocVReactNativeModule$onActivityResult$1$1
                    @Override // com.socure.docv.capturesdk.common.utils.ResultListener
                    public void onSuccess(ScannedData scannedData) {
                        Callback callback;
                        ReadableMap convertResultToReadbleMap;
                        Intrinsics.checkNotNullParameter(scannedData, "scannedData");
                        callback = SocureDocVReactNativeModule.this.onSuccessCallback;
                        if (callback != null) {
                            convertResultToReadbleMap = SocureDocVReactNativeModule.this.convertResultToReadbleMap(scannedData);
                            callback.invoke(convertResultToReadbleMap);
                        }
                    }

                    @Override // com.socure.docv.capturesdk.common.utils.ResultListener
                    public void onError(ScanError scanError) {
                        Callback callback;
                        ReadableMap convertErrorToReadableMap;
                        Intrinsics.checkNotNullParameter(scanError, "scanError");
                        callback = SocureDocVReactNativeModule.this.onErrorCallback;
                        if (callback != null) {
                            convertErrorToReadableMap = SocureDocVReactNativeModule.this.convertErrorToReadableMap(scanError);
                            callback.invoke(convertErrorToReadableMap);
                        }
                    }
                });
            }
            getReactApplicationContext().removeActivityEventListener(this);
            return;
        }
        Log.d(this.TAG, "onActivityResult - requestCode does not match: " + requestCode + ", not removing activity event listener");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReadableMap convertResultToReadbleMap(ScannedData scannedData) {
        WritableMap createMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(createMap, "createMap()");
        createMap.putString("docUUID", scannedData.getDocUUID());
        createMap.putString("sessionId", scannedData.getSessionId());
        WritableMap createMap2 = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(createMap2, "createMap()");
        Map<String, String> captureData = scannedData.getCaptureData();
        if (captureData != null) {
            for (Map.Entry<String, String> entry : captureData.entrySet()) {
                createMap2.putString(entry.getKey(), entry.getValue());
            }
        }
        createMap.putMap("captureData", createMap2);
        WritableMap createMap3 = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(createMap3, "createMap()");
        HashMap<String, byte[]> capturedImages = scannedData.getCapturedImages();
        if (capturedImages != null) {
            for (Map.Entry<String, byte[]> entry2 : capturedImages.entrySet()) {
                String key = entry2.getKey();
                String encodeToString = Base64.encodeToString(entry2.getValue(), 0);
                if (encodeToString == null) {
                    encodeToString = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(encodeToString, "Base64.encodeToString(it…ue, Base64.DEFAULT) ?: \"\"");
                }
                createMap3.putString(key, encodeToString);
            }
        }
        createMap.putMap("capturedImages", createMap3);
        String extractedData = scannedData.getExtractedData();
        if (extractedData != null) {
            try {
                createMap.putMap("extractedData", convertStringToMap(new JSONObject(extractedData)));
            } catch (JSONException unused) {
                createMap.putString("extractedData", extractedData);
            }
        }
        return createMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReadableMap convertErrorToReadableMap(ScanError scanError) {
        WritableMap createMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(createMap, "createMap()");
        createMap.putString("statusCode", String.valueOf(scanError.getStatusCode()));
        createMap.putString("errorMessage", scanError.getErrorMessage());
        String sessionId = scanError.getSessionId();
        if (sessionId != null) {
            createMap.putString("sessionId", sessionId);
        }
        WritableMap createMap2 = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(createMap2, "createMap()");
        HashMap<String, byte[]> capturedImages = scanError.getCapturedImages();
        if (capturedImages != null) {
            for (Map.Entry<String, byte[]> entry : capturedImages.entrySet()) {
                String key = entry.getKey();
                String encodeToString = Base64.encodeToString(entry.getValue(), 0);
                if (encodeToString == null) {
                    encodeToString = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(encodeToString, "Base64.encodeToString(it…ue, Base64.DEFAULT) ?: \"\"");
                }
                createMap2.putString(key, encodeToString);
            }
        }
        createMap.putMap("capturedImages", createMap2);
        return createMap;
    }

    private final ReadableMap convertStringToMap(JSONObject jsonObject) {
        WritableMap createMap = Arguments.createMap();
        Intrinsics.checkNotNullExpressionValue(createMap, "createMap()");
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Intrinsics.checkNotNullExpressionValue(next, "jsonIterator.next()");
            String str = next;
            Object obj = jsonObject.get(str);
            if (obj instanceof JSONObject) {
                createMap.putMap(str, convertStringToMap((JSONObject) obj));
            } else if (obj instanceof String) {
                createMap.putString(str, (String) obj);
            }
        }
        return createMap;
    }
}
