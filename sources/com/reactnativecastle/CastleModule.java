package com.reactnativecastle;

import android.app.Application;
import android.content.Context;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import io.castle.android.Castle;
import io.castle.android.CastleConfiguration;
import io.castle.android.api.model.Event;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CastleModule.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001a\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000eH\u0007J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000bH\u0007J\b\u0010\u0014\u001a\u00020\u0006H\u0007J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u000eH\u0007J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\u001a\u001a\u00020\u0006H\u0007J\b\u0010\u001b\u001a\u00020\u0006H\u0007J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000eH\u0007J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u000eH\u0007J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u000eH\u0007¨\u0006!"}, d2 = {"Lcom/reactnativecastle/CastleModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "baseUrl", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "configure", "options", "Lcom/facebook/react/bridge/ReadableMap;", "configureWithPublishableKey", "publishableKey", "", "createRequestToken", Event.EVENT_TYPE_CUSTOM, "name", "customWithProperties", "properties", "flush", "flushIfNeeded", "url", "getName", "queueSize", "requestTokenHeaderName", "reset", "resetConfiguration", Event.EVENT_TYPE_SCREEN, "setAdvertisingIdentifier", "idfa", "userAgent", "userJwt", "castleio_react-native-castle_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CastleModule extends ReactContextBaseJavaModule {
    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "Castle";
    }

    @ReactMethod
    public final void setAdvertisingIdentifier(String idfa) {
        Intrinsics.checkNotNullParameter(idfa, "idfa");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CastleModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    @ReactMethod
    public final void requestTokenHeaderName(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Castle.requestTokenHeaderName);
    }

    @ReactMethod
    public final void configure(ReadableMap options, Promise promise) {
        ReadableArray array;
        Intrinsics.checkNotNullParameter(promise, "promise");
        if (options != null) {
            CastleConfiguration.Builder builder = new CastleConfiguration.Builder();
            builder.publishableKey(options.getString("publishableKey"));
            builder.screenTrackingEnabled(false);
            if (options.hasKey("debugLoggingEnabled")) {
                builder.debugLoggingEnabled(options.getBoolean("debugLoggingEnabled"));
            }
            if (options.hasKey("maxQueueLimit")) {
                builder.maxQueueLimit(options.getInt("maxQueueLimit"));
            }
            if (options.hasKey("flushLimit")) {
                builder.flushLimit(options.getInt("flushLimit"));
            }
            if (options.hasKey("baseURLAllowList") && (array = options.getArray("baseURLAllowList")) != null) {
                ArrayList arrayList = new ArrayList();
                int size = array.size();
                for (int i = 0; i < size; i++) {
                    String s = array.getString(i);
                    Intrinsics.checkNotNullExpressionValue(s, "s");
                    arrayList.add(s);
                }
                builder.baseURLAllowList(arrayList);
            }
            Context applicationContext = getReactApplicationContext().getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            Castle.configure((Application) applicationContext, builder.build());
            promise.resolve(null);
            return;
        }
        promise.reject("Invalid configuration");
    }

    @ReactMethod
    public final void configureWithPublishableKey(String publishableKey) {
        Intrinsics.checkNotNullParameter(publishableKey, "publishableKey");
        Context applicationContext = getReactApplicationContext().getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        Castle.configure((Application) applicationContext, publishableKey);
    }

    @ReactMethod
    public final void resetConfiguration() {
        Castle.reset();
    }

    @ReactMethod
    public final void userJwt(String userJwt) {
        Intrinsics.checkNotNullParameter(userJwt, "userJwt");
        Castle.userJwt(userJwt);
    }

    @ReactMethod
    public final void custom(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Castle.custom(name);
    }

    @ReactMethod
    public final void customWithProperties(String name, ReadableMap properties) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Castle.custom(name, properties.toHashMap());
    }

    @ReactMethod
    public final void screen(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Castle.screen(name);
    }

    @ReactMethod
    public final void flush() {
        Castle.flush();
    }

    @ReactMethod
    public final void flushIfNeeded(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Castle.flushIfNeeded(url);
    }

    @ReactMethod
    public final void reset() {
        Castle.reset();
    }

    @ReactMethod
    public final void baseUrl(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Castle.baseUrl());
    }

    @ReactMethod
    public final void createRequestToken(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Castle.createRequestToken());
    }

    @ReactMethod
    public final void userJwt(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Castle.userJwt());
    }

    @ReactMethod
    public final void userAgent(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Castle.userAgent());
    }

    @ReactMethod
    public final void queueSize(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        promise.resolve(Integer.valueOf(Castle.queueSize()));
    }
}
