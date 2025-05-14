package com.iterable.iterableapi;

/* loaded from: classes5.dex */
public interface IterableInAppHandler {

    public enum InAppResponse {
        SHOW,
        SKIP
    }

    InAppResponse onNewInApp(IterableInAppMessage iterableInAppMessage);
}
