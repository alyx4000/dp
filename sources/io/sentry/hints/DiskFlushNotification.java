package io.sentry.hints;

import io.sentry.protocol.SentryId;

/* loaded from: classes2.dex */
public interface DiskFlushNotification {
    boolean isFlushable(SentryId sentryId);

    void markFlushed();

    void setFlushable(SentryId sentryId);
}
