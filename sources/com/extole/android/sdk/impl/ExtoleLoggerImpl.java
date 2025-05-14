package com.extole.android.sdk.impl;

import com.extole.android.sdk.ExtoleLogger;
import com.extole.android.sdk.LogLevel;
import com.extole.android.sdk.impl.ExtoleLoggerImpl;
import com.extole.android.sdk.impl.http.CreativeLoggingEndpoints;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import external.sdk.pendo.io.daimajia.BuildConfig;
import io.sentry.protocol.OperatingSystem;
import io.sentry.protocol.SentryThread;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* compiled from: ExtoleLoggerImpl.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ-\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ5\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0003H\u0016J-\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ-\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/extole/android/sdk/impl/ExtoleLoggerImpl;", "Lcom/extole/android/sdk/ExtoleLogger;", "logLevel", "Lcom/extole/android/sdk/LogLevel;", "(Lcom/extole/android/sdk/LogLevel;)V", BuildConfig.BUILD_TYPE, "", "message", "", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "error", "exception", "", "(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "getLogLevel", "info", "warn", "Builder", "Companion", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExtoleLoggerImpl implements ExtoleLogger {
    private static final CoroutineExceptionHandler handler = new ExtoleLoggerImpl$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE);
    private final LogLevel logLevel;

    public ExtoleLoggerImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ExtoleLoggerImpl(LogLevel logLevel) {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        this.logLevel = logLevel;
    }

    public /* synthetic */ ExtoleLoggerImpl(LogLevel logLevel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? LogLevel.ERROR : logLevel);
    }

    @Override // com.extole.android.sdk.ExtoleLogger
    public void debug(String message, Object... args) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        Logger.d(message, args);
    }

    @Override // com.extole.android.sdk.ExtoleLogger
    public void info(String message, Object... args) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        Logger.i(message, args);
    }

    @Override // com.extole.android.sdk.ExtoleLogger
    public void warn(String message, Object... args) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        Logger.w(message, args);
    }

    @Override // com.extole.android.sdk.ExtoleLogger
    public void error(String message, Object... args) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        Logger.e(message, args);
    }

    @Override // com.extole.android.sdk.ExtoleLogger
    public void error(Throwable exception, String message, Object... args) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        Logger.e(exception, message, args);
    }

    @Override // com.extole.android.sdk.ExtoleLogger
    public LogLevel getLogLevel() {
        return this.logLevel;
    }

    /* compiled from: ExtoleLoggerImpl.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 92\u00020\u0001:\u00019B\u0084\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012Q\b\u0002\u0010\t\u001aK\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\n¢\u0006\u0002\u0010\u0012J\u0006\u0010%\u001a\u00020&J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003JR\u0010+\u001aK\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nHÆ\u0003J\u0088\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2Q\b\u0002\u0010\t\u001aK\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nHÆ\u0001J_\u0010-\u001aI\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u000bHÖ\u0001J\u0010\u00102\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\t\u00103\u001a\u00020\u0003HÖ\u0001J\u0010\u00104\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u000e\u00105\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u00106\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJU\u00107\u001a\u00020\u00002M\u0010\t\u001aI\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\nJ\u0010\u00108\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eRc\u0010\t\u001aK\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016¨\u0006:"}, d2 = {"Lcom/extole/android/sdk/impl/ExtoleLoggerImpl$Builder;", "", "programDomain", "", "accessToken", "context", "Lcom/extole/android/sdk/impl/ExtoleContext;", "logLevel", "Lcom/extole/android/sdk/LogLevel;", "logSender", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", SentryThread.JsonKeys.PRIORITY, ViewHierarchyNode.JsonKeys.TAG, "message", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/extole/android/sdk/impl/ExtoleContext;Lcom/extole/android/sdk/LogLevel;Lkotlin/jvm/functions/Function3;)V", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "getContext", "()Lcom/extole/android/sdk/impl/ExtoleContext;", "setContext", "(Lcom/extole/android/sdk/impl/ExtoleContext;)V", "getLogLevel", "()Lcom/extole/android/sdk/LogLevel;", "setLogLevel", "(Lcom/extole/android/sdk/LogLevel;)V", "getLogSender", "()Lkotlin/jvm/functions/Function3;", "setLogSender", "(Lkotlin/jvm/functions/Function3;)V", "getProgramDomain", "setProgramDomain", OperatingSystem.JsonKeys.BUILD, "Lcom/extole/android/sdk/ExtoleLogger;", "component1", "component2", "component3", "component4", "component5", "copy", "createLogSender", "equals", "", "other", "hashCode", "toCreativeLogLevel", "toString", "withAccessToken", "withContext", "withLogLevel", "withLogSender", "withProgramDomain", "Companion", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final /* data */ class Builder {
        private static final int MAX_LOGS_TO_SEND = 100;
        private String accessToken;
        private ExtoleContext context;
        private LogLevel logLevel;
        private Function3<? super Integer, ? super String, ? super String, Unit> logSender;
        private String programDomain;
        private static final AtomicInteger sentLogCount = new AtomicInteger();

        public Builder() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ Builder copy$default(Builder builder, String str, String str2, ExtoleContext extoleContext, LogLevel logLevel, Function3 function3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = builder.programDomain;
            }
            if ((i & 2) != 0) {
                str2 = builder.accessToken;
            }
            String str3 = str2;
            if ((i & 4) != 0) {
                extoleContext = builder.context;
            }
            ExtoleContext extoleContext2 = extoleContext;
            if ((i & 8) != 0) {
                logLevel = builder.logLevel;
            }
            LogLevel logLevel2 = logLevel;
            if ((i & 16) != 0) {
                function3 = builder.logSender;
            }
            return builder.copy(str, str3, extoleContext2, logLevel2, function3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String toCreativeLogLevel(int priority) {
            return priority != 3 ? priority != 4 ? priority != 5 ? priority != 6 ? "DEBUG" : "ERROR" : "WARN" : "INFO" : "DEBUG";
        }

        /* renamed from: component1, reason: from getter */
        public final String getProgramDomain() {
            return this.programDomain;
        }

        /* renamed from: component2, reason: from getter */
        public final String getAccessToken() {
            return this.accessToken;
        }

        /* renamed from: component3, reason: from getter */
        public final ExtoleContext getContext() {
            return this.context;
        }

        /* renamed from: component4, reason: from getter */
        public final LogLevel getLogLevel() {
            return this.logLevel;
        }

        public final Function3<Integer, String, String, Unit> component5() {
            return this.logSender;
        }

        public final Builder copy(String programDomain, String accessToken, ExtoleContext context, LogLevel logLevel, Function3<? super Integer, ? super String, ? super String, Unit> logSender) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(logLevel, "logLevel");
            return new Builder(programDomain, accessToken, context, logLevel, logSender);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) other;
            return Intrinsics.areEqual(this.programDomain, builder.programDomain) && Intrinsics.areEqual(this.accessToken, builder.accessToken) && Intrinsics.areEqual(this.context, builder.context) && this.logLevel == builder.logLevel && Intrinsics.areEqual(this.logSender, builder.logSender);
        }

        public int hashCode() {
            String str = this.programDomain;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.accessToken;
            int hashCode2 = (((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.context.hashCode()) * 31) + this.logLevel.hashCode()) * 31;
            Function3<? super Integer, ? super String, ? super String, Unit> function3 = this.logSender;
            return hashCode2 + (function3 != null ? function3.hashCode() : 0);
        }

        public String toString() {
            return "Builder(programDomain=" + this.programDomain + ", accessToken=" + this.accessToken + ", context=" + this.context + ", logLevel=" + this.logLevel + ", logSender=" + this.logSender + ')';
        }

        public Builder(String str, String str2, ExtoleContext context, LogLevel logLevel, Function3<? super Integer, ? super String, ? super String, Unit> function3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(logLevel, "logLevel");
            this.programDomain = str;
            this.accessToken = str2;
            this.context = context;
            this.logLevel = logLevel;
            this.logSender = function3;
        }

        public final String getProgramDomain() {
            return this.programDomain;
        }

        public final void setProgramDomain(String str) {
            this.programDomain = str;
        }

        public final String getAccessToken() {
            return this.accessToken;
        }

        public final void setAccessToken(String str) {
            this.accessToken = str;
        }

        public /* synthetic */ Builder(String str, String str2, ExtoleContext extoleContext, LogLevel logLevel, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? new ExtoleContext() : extoleContext, (i & 8) != 0 ? LogLevel.ERROR : logLevel, (i & 16) != 0 ? null : function3);
        }

        public final ExtoleContext getContext() {
            return this.context;
        }

        public final void setContext(ExtoleContext extoleContext) {
            Intrinsics.checkNotNullParameter(extoleContext, "<set-?>");
            this.context = extoleContext;
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
            this.logSender = function3;
        }

        public final Builder withProgramDomain(String programDomain) {
            this.programDomain = programDomain;
            return this;
        }

        public final Builder withAccessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public final Builder withContext(ExtoleContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            return this;
        }

        public final Builder withLogLevel(LogLevel logLevel) {
            Intrinsics.checkNotNullParameter(logLevel, "logLevel");
            this.logLevel = logLevel;
            return this;
        }

        public final Builder withLogSender(Function3<? super Integer, ? super String, ? super String, Unit> logSender) {
            Intrinsics.checkNotNullParameter(logSender, "logSender");
            this.logSender = logSender;
            return this;
        }

        public final ExtoleLogger build() {
            String str = this.programDomain;
            if (str != null) {
                Logger.clearLogAdapters();
                Logger.addLogAdapter(new AndroidLogAdapter());
                String str2 = this.accessToken;
                ExtoleContext extoleContext = this.context;
                LogLevel logLevel = this.logLevel;
                Function3 function3 = this.logSender;
                if (function3 == null) {
                    function3 = createLogSender(str, str2);
                }
                Logger.addLogAdapter(new ExtoleLogAdapter(str, str2, extoleContext, logLevel, function3));
            } else {
                Logger.w("ExtoleLogger not registered because programDomain is missing", new Object[0]);
            }
            return new ExtoleLoggerImpl(this.logLevel);
        }

        public final Function3<Integer, String, String, Unit> createLogSender(final String programDomain, String accessToken) {
            Intrinsics.checkNotNullParameter(programDomain, "programDomain");
            final CreativeLoggingEndpoints creativeLoggingEndpoints = new CreativeLoggingEndpoints(programDomain, accessToken);
            return new Function3<Integer, String, String, Unit>() { // from class: com.extole.android.sdk.impl.ExtoleLoggerImpl$Builder$createLogSender$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, String str2) {
                    invoke(num.intValue(), str, str2);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i, String str, String message) {
                    String creativeLogLevel;
                    AtomicInteger atomicInteger;
                    CoroutineExceptionHandler coroutineExceptionHandler;
                    Intrinsics.checkNotNullParameter(message, "message");
                    creativeLogLevel = ExtoleLoggerImpl.Builder.this.toCreativeLogLevel(i);
                    StringBuilder append = new StringBuilder().append(programDomain).append(' ');
                    if (str == null) {
                        str = "";
                    }
                    String sb = append.append(str).append(' ').append(message).append(", context: ").append(ExtoleLoggerImpl.Builder.this.getContext()).toString();
                    atomicInteger = ExtoleLoggerImpl.Builder.sentLogCount;
                    if (atomicInteger.incrementAndGet() < 100) {
                        GlobalScope globalScope = GlobalScope.INSTANCE;
                        coroutineExceptionHandler = ExtoleLoggerImpl.handler;
                        BuildersKt__Builders_commonKt.launch$default(globalScope, coroutineExceptionHandler, null, new AnonymousClass1(creativeLoggingEndpoints, creativeLogLevel, sb, null), 2, null);
                    }
                }

                /* compiled from: ExtoleLoggerImpl.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "com.extole.android.sdk.impl.ExtoleLoggerImpl$Builder$createLogSender$1$1", f = "ExtoleLoggerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.extole.android.sdk.impl.ExtoleLoggerImpl$Builder$createLogSender$1$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ String $level;
                    final /* synthetic */ String $logMessage;
                    final /* synthetic */ CreativeLoggingEndpoints $loggingEndpoints;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(CreativeLoggingEndpoints creativeLoggingEndpoints, String str, String str2, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$loggingEndpoints = creativeLoggingEndpoints;
                        this.$level = str;
                        this.$logMessage = str2;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$loggingEndpoints, this.$level, this.$logMessage, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.$loggingEndpoints.create(this.$level, this.$logMessage);
                        return Unit.INSTANCE;
                    }
                }
            };
        }
    }
}
