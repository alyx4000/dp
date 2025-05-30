package com.amplitude.reactnative;

import com.facebook.common.callercontext.ContextChain;
import kotlin.Metadata;

/* compiled from: AndroidLogger.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/amplitude/reactnative/Logger;", "", "logMode", "Lcom/amplitude/reactnative/Logger$LogMode;", "getLogMode", "()Lcom/amplitude/reactnative/Logger$LogMode;", "setLogMode", "(Lcom/amplitude/reactnative/Logger$LogMode;)V", external.sdk.pendo.io.daimajia.BuildConfig.BUILD_TYPE, "", "message", "", "error", "info", "warn", "LogMode", "amplitude_analytics-react-native_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Logger {
    void debug(String message);

    void error(String message);

    LogMode getLogMode();

    void info(String message);

    void setLogMode(LogMode logMode);

    void warn(String message);

    /* compiled from: AndroidLogger.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/amplitude/reactnative/Logger$LogMode;", "", ContextChain.TAG_INFRA, "", "(Ljava/lang/String;II)V", "DEBUG", "INFO", "WARN", "ERROR", "OFF", "amplitude_analytics-react-native_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum LogMode {
        DEBUG(1),
        INFO(2),
        WARN(3),
        ERROR(4),
        OFF(5);

        LogMode(int i) {
        }
    }
}
