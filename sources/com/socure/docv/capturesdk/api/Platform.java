package com.socure.docv.capturesdk.api;

import io.sentry.protocol.SentryStackFrame;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/socure/docv/capturesdk/api/Platform;", "", "platformName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getPlatformName", "()Ljava/lang/String;", "NATIVE", "REACT_NATIVE", "FLUTTER", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum Platform {
    NATIVE(SentryStackFrame.JsonKeys.NATIVE),
    REACT_NATIVE("react_native"),
    FLUTTER("flutter");

    private final String platformName;

    Platform(String str) {
        this.platformName = str;
    }

    public final String getPlatformName() {
        return this.platformName;
    }
}
