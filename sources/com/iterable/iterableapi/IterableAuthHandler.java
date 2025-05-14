package com.iterable.iterableapi;

/* loaded from: classes5.dex */
public interface IterableAuthHandler {
    String onAuthTokenRequested();

    void onTokenRegistrationFailed(Throwable th);

    void onTokenRegistrationSuccessful(String str);
}
