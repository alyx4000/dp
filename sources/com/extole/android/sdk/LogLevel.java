package com.extole.android.sdk;

import io.sentry.protocol.SentryThread;
import kotlin.Metadata;

/* compiled from: LogLevel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/extole/android/sdk/LogLevel;", "", SentryThread.JsonKeys.PRIORITY, "", "(Ljava/lang/String;II)V", "getPriority", "()I", "DISABLE", "DEBUG", "INFO", "WARN", "ERROR", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public enum LogLevel {
    DISABLE(0),
    DEBUG(3),
    INFO(4),
    WARN(5),
    ERROR(6);

    private final int priority;

    LogLevel(int i) {
        this.priority = i;
    }

    public final int getPriority() {
        return this.priority;
    }
}
