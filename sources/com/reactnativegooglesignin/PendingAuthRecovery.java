package com.reactnativegooglesignin;

import com.facebook.react.bridge.WritableMap;

/* loaded from: classes5.dex */
public class PendingAuthRecovery {
    private final WritableMap userProperties;

    public PendingAuthRecovery(WritableMap writableMap) {
        this.userProperties = writableMap;
    }

    public WritableMap getUserProperties() {
        return this.userProperties;
    }
}
