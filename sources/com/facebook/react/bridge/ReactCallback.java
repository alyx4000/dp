package com.facebook.react.bridge;

/* loaded from: classes3.dex */
interface ReactCallback {
    void decrementPendingJSCalls();

    void incrementPendingJSCalls();

    void onBatchComplete();
}
