package com.reactnativedevicerisk;

import android.app.Activity;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.reactnativedevicerisk.util.Constants;
import com.socure.idplus.device.SigmaDevice;
import com.socure.idplus.device.SigmaDeviceOptions;
import com.socure.idplus.device.callback.SessionTokenCallback;
import com.socure.idplus.device.callback.SigmaDeviceCallback;
import com.socure.idplus.device.context.SigmaDeviceContext;
import com.socure.idplus.device.error.SigmaDeviceError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SigmaDeviceModule.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0007J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\"\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\bH\u0007J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\bH\u0007J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/reactnativedevicerisk/SigmaDeviceModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "handler", "Landroid/os/Handler;", "sendDataPromise", "Lcom/facebook/react/bridge/Promise;", "getContextFromString", "Lcom/socure/idplus/device/context/SigmaDeviceContext;", "contextString", "", "getName", "getSessionToken", "", BaseJavaModule.METHOD_TYPE_PROMISE, "getSigmaDeviceOptions", "Lcom/socure/idplus/device/SigmaDeviceOptions;", "sigmaDeviceOptions", "Lcom/facebook/react/bridge/ReadableMap;", "initializeSDK", "sdkKey", "processDevice", "sigmaDeviceContext", "sendSessionToken", "sessionToken", "Companion", "react-native-device-risk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SigmaDeviceModule extends ReactContextBaseJavaModule {
    private static final String RN_SIGMA_DEVICE = "RnSigmaDevice";
    private final Handler handler;
    private Promise sendDataPromise;

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return RN_SIGMA_DEVICE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SigmaDeviceModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.handler = new Handler(reactContext.getMainLooper());
    }

    @ReactMethod
    public final void initializeSDK(final String sdkKey, final ReadableMap sigmaDeviceOptions, Promise promise) {
        Intrinsics.checkNotNullParameter(sdkKey, "sdkKey");
        Intrinsics.checkNotNullParameter(promise, "promise");
        final Activity currentActivity = getCurrentActivity();
        this.sendDataPromise = promise;
        if (currentActivity != null) {
            this.handler.post(new Runnable() { // from class: com.reactnativedevicerisk.SigmaDeviceModule$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    SigmaDeviceModule.initializeSDK$lambda$0(currentActivity, sdkKey, this, sigmaDeviceOptions);
                }
            });
        } else if (promise != null) {
            promise.reject(new Throwable("Aborting since app activity object is null"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initializeSDK$lambda$0(Activity activity, String sdkKey, final SigmaDeviceModule this$0, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(sdkKey, "$sdkKey");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SigmaDevice sigmaDevice = SigmaDevice.INSTANCE;
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        sigmaDevice.initializeSDK((AppCompatActivity) activity, sdkKey, this$0.getSigmaDeviceOptions(readableMap), new SigmaDeviceCallback() { // from class: com.reactnativedevicerisk.SigmaDeviceModule$initializeSDK$1$1
            @Override // com.socure.idplus.device.callback.SigmaDeviceCallback
            public void onError(SigmaDeviceError errorType, String errorMessage) {
                Promise promise;
                Intrinsics.checkNotNullParameter(errorType, "errorType");
                promise = SigmaDeviceModule.this.sendDataPromise;
                if (promise != null) {
                    promise.reject(new Throwable(errorType.name() + ": " + errorMessage));
                }
            }

            @Override // com.socure.idplus.device.callback.SigmaDeviceCallback
            public void onSessionCreated(String sessionToken) {
                Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
                SigmaDeviceModule.this.sendSessionToken(sessionToken);
            }
        });
    }

    @ReactMethod
    public final void getSessionToken(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        this.sendDataPromise = promise;
        this.handler.post(new Runnable() { // from class: com.reactnativedevicerisk.SigmaDeviceModule$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SigmaDeviceModule.getSessionToken$lambda$1(SigmaDeviceModule.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSessionToken$lambda$1(final SigmaDeviceModule this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SigmaDevice.INSTANCE.getSessionToken(new SessionTokenCallback() { // from class: com.reactnativedevicerisk.SigmaDeviceModule$getSessionToken$1$1
            @Override // com.socure.idplus.device.callback.SessionTokenCallback
            public void onComplete(String sessionToken) {
                Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
                SigmaDeviceModule.this.sendSessionToken(sessionToken);
            }

            @Override // com.socure.idplus.device.callback.SessionTokenCallback
            public void onError(SigmaDeviceError errorType, String errorMessage) {
                Promise promise;
                Intrinsics.checkNotNullParameter(errorType, "errorType");
                promise = SigmaDeviceModule.this.sendDataPromise;
                if (promise != null) {
                    promise.reject(new Throwable(errorType.name() + ": " + errorMessage));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendSessionToken(String sessionToken) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("sessionToken", sessionToken);
        Promise promise = this.sendDataPromise;
        if (promise != null) {
            promise.resolve(createMap);
        }
    }

    private final SigmaDeviceOptions getSigmaDeviceOptions(ReadableMap sigmaDeviceOptions) {
        SigmaDeviceOptions sigmaDeviceOptions2 = new SigmaDeviceOptions(false, null, false, 7, null);
        if (sigmaDeviceOptions != null) {
            return new SigmaDeviceOptions(sigmaDeviceOptions.hasKey("omitLocationData") ? sigmaDeviceOptions.getBoolean("omitLocationData") : false, sigmaDeviceOptions.hasKey("advertisingID") ? sigmaDeviceOptions.getString("advertisingID") : null, sigmaDeviceOptions.hasKey("useSocureGov") ? sigmaDeviceOptions.getBoolean("useSocureGov") : false);
        }
        return sigmaDeviceOptions2;
    }

    @ReactMethod
    public final void processDevice(String sigmaDeviceContext, Promise promise) {
        Intrinsics.checkNotNullParameter(sigmaDeviceContext, "sigmaDeviceContext");
        Intrinsics.checkNotNullParameter(promise, "promise");
        final SigmaDeviceContext contextFromString = getContextFromString(sigmaDeviceContext);
        this.sendDataPromise = promise;
        this.handler.post(new Runnable() { // from class: com.reactnativedevicerisk.SigmaDeviceModule$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SigmaDeviceModule.processDevice$lambda$2(SigmaDeviceContext.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processDevice$lambda$2(SigmaDeviceContext context, final SigmaDeviceModule this$0) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SigmaDevice.INSTANCE.processDevice(context, new SessionTokenCallback() { // from class: com.reactnativedevicerisk.SigmaDeviceModule$processDevice$1$1
            @Override // com.socure.idplus.device.callback.SessionTokenCallback
            public void onComplete(String sessionToken) {
                Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
                SigmaDeviceModule.this.sendSessionToken(sessionToken);
            }

            @Override // com.socure.idplus.device.callback.SessionTokenCallback
            public void onError(SigmaDeviceError errorType, String errorMessage) {
                Promise promise;
                Intrinsics.checkNotNullParameter(errorType, "errorType");
                promise = SigmaDeviceModule.this.sendDataPromise;
                if (promise != null) {
                    promise.reject(new Throwable(errorType.name() + ": " + errorMessage));
                }
            }
        });
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    private final SigmaDeviceContext getContextFromString(String contextString) {
        switch (contextString.hashCode()) {
            case -902467304:
                if (contextString.equals(Constants.SIGNUP)) {
                    return new SigmaDeviceContext.SignUp();
                }
                break;
            case -485371922:
                if (contextString.equals(Constants.HOMEPAGE)) {
                    return new SigmaDeviceContext.Home();
                }
                break;
            case -309425751:
                if (contextString.equals("profile")) {
                    return new SigmaDeviceContext.Profile();
                }
                break;
            case 103149417:
                if (contextString.equals(Constants.LOGIN)) {
                    return new SigmaDeviceContext.Login();
                }
                break;
            case 1216985755:
                if (contextString.equals("password")) {
                    return new SigmaDeviceContext.Password();
                }
                break;
            case 1536904518:
                if (contextString.equals(Constants.CHECKOUT)) {
                    return new SigmaDeviceContext.CheckOut();
                }
                break;
            case 1544803905:
                if (contextString.equals("default")) {
                    return new SigmaDeviceContext.Default();
                }
                break;
            case 2141246174:
                if (contextString.equals("transaction")) {
                    return new SigmaDeviceContext.Transaction();
                }
                break;
        }
        return new SigmaDeviceContext.Other("unknown");
    }
}
