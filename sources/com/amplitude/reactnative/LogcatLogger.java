package com.amplitude.reactnative;

import android.util.Log;
import com.amplitude.reactnative.Logger;
import io.sentry.SentryEvent;
import io.sentry.protocol.ViewHierarchyNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidLogger.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/amplitude/reactnative/LogcatLogger;", "Lcom/amplitude/reactnative/Logger;", "()V", "logMode", "Lcom/amplitude/reactnative/Logger$LogMode;", "getLogMode", "()Lcom/amplitude/reactnative/Logger$LogMode;", "setLogMode", "(Lcom/amplitude/reactnative/Logger$LogMode;)V", ViewHierarchyNode.JsonKeys.TAG, "", external.sdk.pendo.io.daimajia.BuildConfig.BUILD_TYPE, "", "message", "error", "info", "warn", "Companion", "amplitude_analytics-react-native_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LogcatLogger implements Logger {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final LogcatLogger logger = new LogcatLogger();
    private Logger.LogMode logMode = Logger.LogMode.INFO;
    private final String tag = "Amplitude";

    @Override // com.amplitude.reactnative.Logger
    public Logger.LogMode getLogMode() {
        return this.logMode;
    }

    @Override // com.amplitude.reactnative.Logger
    public void setLogMode(Logger.LogMode logMode) {
        Intrinsics.checkNotNullParameter(logMode, "<set-?>");
        this.logMode = logMode;
    }

    @Override // com.amplitude.reactnative.Logger
    public void debug(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (getLogMode().compareTo(Logger.LogMode.DEBUG) <= 0) {
            Log.d(this.tag, message);
        }
    }

    @Override // com.amplitude.reactnative.Logger
    public void error(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (getLogMode().compareTo(Logger.LogMode.ERROR) <= 0) {
            Log.e(this.tag, message);
        }
    }

    @Override // com.amplitude.reactnative.Logger
    public void info(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (getLogMode().compareTo(Logger.LogMode.INFO) <= 0) {
            Log.i(this.tag, message);
        }
    }

    @Override // com.amplitude.reactnative.Logger
    public void warn(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (getLogMode().compareTo(Logger.LogMode.WARN) <= 0) {
            Log.w(this.tag, message);
        }
    }

    /* compiled from: AndroidLogger.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/amplitude/reactnative/LogcatLogger$Companion;", "", "()V", SentryEvent.JsonKeys.LOGGER, "Lcom/amplitude/reactnative/LogcatLogger;", "getLogger", "()Lcom/amplitude/reactnative/LogcatLogger;", "amplitude_analytics-react-native_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LogcatLogger getLogger() {
            return LogcatLogger.logger;
        }
    }
}
