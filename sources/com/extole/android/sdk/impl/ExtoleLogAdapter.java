package com.extole.android.sdk.impl;

import com.extole.android.sdk.LogLevel;
import com.orhanobut.logger.LogAdapter;
import io.sentry.protocol.SentryThread;
import io.sentry.protocol.ViewHierarchyNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExtoleLogAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001Bx\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012M\u0010\t\u001aI\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\n¢\u0006\u0002\u0010\u0012J\u001a\u0010 \u001a\u00020!2\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J\"\u0010\"\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aRa\u0010\t\u001aI\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014¨\u0006#"}, d2 = {"Lcom/extole/android/sdk/impl/ExtoleLogAdapter;", "Lcom/orhanobut/logger/LogAdapter;", "programDomain", "", "accessToken", "context", "Lcom/extole/android/sdk/impl/ExtoleContext;", "logLevel", "Lcom/extole/android/sdk/LogLevel;", "logSender", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", SentryThread.JsonKeys.PRIORITY, ViewHierarchyNode.JsonKeys.TAG, "message", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/extole/android/sdk/impl/ExtoleContext;Lcom/extole/android/sdk/LogLevel;Lkotlin/jvm/functions/Function3;)V", "getAccessToken", "()Ljava/lang/String;", "getContext", "()Lcom/extole/android/sdk/impl/ExtoleContext;", "getLogLevel", "()Lcom/extole/android/sdk/LogLevel;", "setLogLevel", "(Lcom/extole/android/sdk/LogLevel;)V", "getLogSender", "()Lkotlin/jvm/functions/Function3;", "setLogSender", "(Lkotlin/jvm/functions/Function3;)V", "getProgramDomain", "isLoggable", "", "log", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public class ExtoleLogAdapter implements LogAdapter {
    private final String accessToken;
    private final ExtoleContext context;
    private LogLevel logLevel;
    private Function3<? super Integer, ? super String, ? super String, Unit> logSender;
    private final String programDomain;

    public ExtoleLogAdapter(String programDomain, String str, ExtoleContext context, LogLevel logLevel, Function3<? super Integer, ? super String, ? super String, Unit> logSender) {
        Intrinsics.checkNotNullParameter(programDomain, "programDomain");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(logSender, "logSender");
        this.programDomain = programDomain;
        this.accessToken = str;
        this.context = context;
        this.logLevel = logLevel;
        this.logSender = logSender;
    }

    public final String getProgramDomain() {
        return this.programDomain;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final ExtoleContext getContext() {
        return this.context;
    }

    public /* synthetic */ ExtoleLogAdapter(String str, String str2, ExtoleContext extoleContext, LogLevel logLevel, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, extoleContext, (i & 8) != 0 ? LogLevel.ERROR : logLevel, function3);
    }

    public final LogLevel getLogLevel() {
        return this.logLevel;
    }

    public final void setLogLevel(LogLevel logLevel) {
        Intrinsics.checkNotNullParameter(logLevel, "<set-?>");
        this.logLevel = logLevel;
    }

    public final Function3<Integer, String, String, Unit> getLogSender() {
        return this.logSender;
    }

    public final void setLogSender(Function3<? super Integer, ? super String, ? super String, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "<set-?>");
        this.logSender = function3;
    }

    @Override // com.orhanobut.logger.LogAdapter
    public boolean isLoggable(int priority, String tag) {
        LogLevel logLevel = LogLevel.DISABLE;
        LogLevel logLevel2 = this.logLevel;
        return logLevel != logLevel2 && priority >= logLevel2.getPriority();
    }

    @Override // com.orhanobut.logger.LogAdapter
    public void log(int priority, String tag, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.logSender.invoke(Integer.valueOf(priority), tag, message);
    }
}
