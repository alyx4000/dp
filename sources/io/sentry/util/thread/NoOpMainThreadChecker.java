package io.sentry.util.thread;

import io.sentry.protocol.SentryThread;

/* loaded from: classes2.dex */
public final class NoOpMainThreadChecker implements IMainThreadChecker {
    private static final NoOpMainThreadChecker instance = new NoOpMainThreadChecker();

    @Override // io.sentry.util.thread.IMainThreadChecker
    public boolean isMainThread() {
        return false;
    }

    @Override // io.sentry.util.thread.IMainThreadChecker
    public boolean isMainThread(long j) {
        return false;
    }

    @Override // io.sentry.util.thread.IMainThreadChecker
    public boolean isMainThread(SentryThread sentryThread) {
        return false;
    }

    @Override // io.sentry.util.thread.IMainThreadChecker
    public boolean isMainThread(Thread thread) {
        return false;
    }

    public static NoOpMainThreadChecker getInstance() {
        return instance;
    }
}
