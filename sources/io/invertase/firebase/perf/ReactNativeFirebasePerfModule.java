package io.invertase.firebase.perf;

import android.app.Activity;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import java.util.Map;

/* loaded from: classes2.dex */
public class ReactNativeFirebasePerfModule extends ReactNativeFirebaseModule {
    private static final String SERVICE_NAME = "Perf";
    private final UniversalFirebasePerfModule module;

    ReactNativeFirebasePerfModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, SERVICE_NAME);
        this.module = new UniversalFirebasePerfModule(reactApplicationContext, SERVICE_NAME);
    }

    @Override // io.invertase.firebase.common.ReactNativeFirebaseModule, com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        this.module.onTearDown();
    }

    @ReactMethod
    public void setPerformanceCollectionEnabled(Boolean bool, final Promise promise) {
        this.module.setPerformanceCollectionEnabled(bool).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.perf.ReactNativeFirebasePerfModule$$ExternalSyntheticLambda4
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebasePerfModule.lambda$setPerformanceCollectionEnabled$0(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$setPerformanceCollectionEnabled$0(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void startTrace(int i, String str, final Promise promise) {
        this.module.startTrace(i, str).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.perf.ReactNativeFirebasePerfModule$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebasePerfModule.lambda$startTrace$1(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$startTrace$1(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void stopTrace(int i, ReadableMap readableMap, final Promise promise) {
        this.module.stopTrace(i, Arguments.toBundle(readableMap.getMap("metrics")), Arguments.toBundle(readableMap.getMap("attributes"))).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.perf.ReactNativeFirebasePerfModule$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebasePerfModule.lambda$stopTrace$2(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$stopTrace$2(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void startScreenTrace(int i, String str, final Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            promise.resolve(null);
        } else {
            this.module.startScreenTrace(currentActivity, i, str).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.perf.ReactNativeFirebasePerfModule$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    ReactNativeFirebasePerfModule.lambda$startScreenTrace$3(Promise.this, task);
                }
            });
        }
    }

    static /* synthetic */ void lambda$startScreenTrace$3(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void stopScreenTrace(int i, final Promise promise) {
        this.module.stopScreenTrace(i).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.perf.ReactNativeFirebasePerfModule$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebasePerfModule.lambda$stopScreenTrace$4(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$stopScreenTrace$4(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void startHttpMetric(int i, String str, String str2, final Promise promise) {
        this.module.startHttpMetric(i, str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.perf.ReactNativeFirebasePerfModule$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebasePerfModule.lambda$startHttpMetric$5(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$startHttpMetric$5(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void stopHttpMetric(int i, ReadableMap readableMap, final Promise promise) {
        this.module.stopHttpMetric(i, Arguments.toBundle(readableMap), Arguments.toBundle(readableMap.getMap("attributes"))).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.perf.ReactNativeFirebasePerfModule$$ExternalSyntheticLambda6
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebasePerfModule.lambda$stopHttpMetric$6(Promise.this, task);
            }
        });
    }

    static /* synthetic */ void lambda$stopHttpMetric$6(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // io.invertase.firebase.common.ReactNativeFirebaseModule, com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        return this.module.getConstants();
    }
}
