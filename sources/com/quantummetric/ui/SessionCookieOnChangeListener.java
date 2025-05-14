package com.quantummetric.ui;

/* loaded from: classes5.dex */
public abstract class SessionCookieOnChangeListener {
    protected abstract void onChange(String str, String str2);

    public final void onComplete(String str, String str2) {
        onChange(str, str2);
    }
}
