package com.iterable.iterableapi;

import com.iterable.iterableapi.IterableInAppHandler;

/* loaded from: classes5.dex */
public class IterableDefaultInAppHandler implements IterableInAppHandler {
    @Override // com.iterable.iterableapi.IterableInAppHandler
    public IterableInAppHandler.InAppResponse onNewInApp(IterableInAppMessage iterableInAppMessage) {
        return IterableInAppHandler.InAppResponse.SHOW;
    }
}
