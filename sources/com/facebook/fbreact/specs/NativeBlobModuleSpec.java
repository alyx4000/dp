package com.facebook.fbreact.specs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public abstract class NativeBlobModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "BlobModule";

    @ReactMethod
    public abstract void addNetworkingHandler();

    @ReactMethod
    public abstract void addWebSocketHandler(double d);

    @ReactMethod
    public abstract void createFromParts(ReadableArray readableArray, String str);

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return NAME;
    }

    protected abstract Map<String, Object> getTypedExportedConstants();

    @ReactMethod
    public abstract void release(String str);

    @ReactMethod
    public abstract void removeWebSocketHandler(double d);

    @ReactMethod
    public abstract void sendOverSocket(ReadableMap readableMap, double d);

    public NativeBlobModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    @Nullable
    public final Map<String, Object> getConstants() {
        return getTypedExportedConstants();
    }
}
