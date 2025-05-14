package io.sentry;

import io.sentry.protocol.SentryTransaction;

/* loaded from: classes2.dex */
public interface EventProcessor {
    default SentryEvent process(SentryEvent sentryEvent, Hint hint) {
        return sentryEvent;
    }

    default SentryTransaction process(SentryTransaction sentryTransaction, Hint hint) {
        return sentryTransaction;
    }
}
