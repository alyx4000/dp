package expo.modules.updates.logging;

import android.content.Context;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import expo.modules.core.logging.LogType;
import expo.modules.core.logging.Logger;
import expo.modules.core.logging.LoggerOptions;
import external.sdk.pendo.io.daimajia.BuildConfig;
import io.sentry.SentryEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpdatesLogger.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ,\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\nJ$\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011J8\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011J$\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011J8\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ,\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\nJ@\u0010\u0014\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ,\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ,\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lexpo/modules/updates/logging/UpdatesLogger;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", SentryEvent.JsonKeys.LOGGER, "Lexpo/modules/core/logging/Logger;", BuildConfig.BUILD_TYPE, "", "message", "", ApiConstant.KEY_CODE, "Lexpo/modules/updates/logging/UpdatesErrorCode;", "updateId", "assetId", "error", "exception", "Ljava/lang/Exception;", "fatal", "info", "logEntryString", "level", "Lexpo/modules/core/logging/LogType;", "trace", "warn", "Companion", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UpdatesLogger {
    public static final String EXPO_UPDATES_LOGGING_TAG = "dev.expo.updates";
    public static final int MAX_FRAMES_IN_STACKTRACE = 20;
    private final Logger logger;

    /* compiled from: UpdatesLogger.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogType.values().length];
            try {
                iArr[LogType.Error.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogType.Fatal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public UpdatesLogger(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.logger = new Logger(EXPO_UPDATES_LOGGING_TAG, context, LoggerOptions.INSTANCE.union(CollectionsKt.listOf((Object[]) new LoggerOptions[]{LoggerOptions.INSTANCE.getLogToOS(), LoggerOptions.INSTANCE.getLogToFile()})));
    }

    public static /* synthetic */ void trace$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.trace(str, updatesErrorCode);
    }

    public final void trace(String message, UpdatesErrorCode code) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        trace(message, code, null, null);
    }

    public static /* synthetic */ void trace$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.trace(str, updatesErrorCode, str2, str3);
    }

    public final void trace(String message, UpdatesErrorCode code, String updateId, String assetId) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        this.logger.trace(logEntryString$default(this, message, code, LogType.Trace, updateId, assetId, null, 32, null));
    }

    public static /* synthetic */ void debug$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.debug(str, updatesErrorCode);
    }

    public final void debug(String message, UpdatesErrorCode code) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        debug(message, code, null, null);
    }

    public static /* synthetic */ void debug$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.debug(str, updatesErrorCode, str2, str3);
    }

    public final void debug(String message, UpdatesErrorCode code, String updateId, String assetId) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        this.logger.debug(logEntryString$default(this, message, code, LogType.Debug, updateId, assetId, null, 32, null));
    }

    public static /* synthetic */ void info$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.info(str, updatesErrorCode);
    }

    public final void info(String message, UpdatesErrorCode code) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        info(message, code, null, null);
    }

    public static /* synthetic */ void info$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.info(str, updatesErrorCode, str2, str3);
    }

    public final void info(String message, UpdatesErrorCode code, String updateId, String assetId) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        this.logger.info(logEntryString$default(this, message, code, LogType.Info, updateId, assetId, null, 32, null));
    }

    public static /* synthetic */ void warn$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.warn(str, updatesErrorCode);
    }

    public final void warn(String message, UpdatesErrorCode code) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        warn(message, code, null, null);
    }

    public static /* synthetic */ void warn$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        updatesLogger.warn(str, updatesErrorCode, str2, str3);
    }

    public final void warn(String message, UpdatesErrorCode code, String updateId, String assetId) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        Logger.warn$default(this.logger, logEntryString$default(this, message, code, LogType.Warn, updateId, assetId, null, 32, null), null, 2, null);
    }

    public static /* synthetic */ void error$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, Exception exc, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        if ((i & 4) != 0) {
            exc = null;
        }
        updatesLogger.error(str, updatesErrorCode, exc);
    }

    public final void error(String message, UpdatesErrorCode code, Exception exception) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        error(message, code, null, null, exception);
    }

    public static /* synthetic */ void error$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, String str2, String str3, Exception exc, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        UpdatesErrorCode updatesErrorCode2 = updatesErrorCode;
        if ((i & 16) != 0) {
            exc = null;
        }
        updatesLogger.error(str, updatesErrorCode2, str2, str3, exc);
    }

    public final void error(String message, UpdatesErrorCode code, String updateId, String assetId, Exception exception) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        Logger.error$default(this.logger, logEntryString(message, code, LogType.Error, updateId, assetId, exception), null, 2, null);
    }

    public static /* synthetic */ void fatal$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, Exception exc, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        if ((i & 4) != 0) {
            exc = null;
        }
        updatesLogger.fatal(str, updatesErrorCode, exc);
    }

    public final void fatal(String message, UpdatesErrorCode code, Exception exception) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        fatal(message, code, null, null, exception);
    }

    public static /* synthetic */ void fatal$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, String str2, String str3, Exception exc, int i, Object obj) {
        if ((i & 2) != 0) {
            updatesErrorCode = UpdatesErrorCode.None;
        }
        UpdatesErrorCode updatesErrorCode2 = updatesErrorCode;
        if ((i & 16) != 0) {
            exc = null;
        }
        updatesLogger.fatal(str, updatesErrorCode2, str2, str3, exc);
    }

    public final void fatal(String message, UpdatesErrorCode code, String updateId, String assetId, Exception exception) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(code, "code");
        Logger.fatal$default(this.logger, logEntryString(message, code, LogType.Fatal, updateId, assetId, exception), null, 2, null);
    }

    static /* synthetic */ String logEntryString$default(UpdatesLogger updatesLogger, String str, UpdatesErrorCode updatesErrorCode, LogType logType, String str2, String str3, Exception exc, int i, Object obj) {
        if ((i & 32) != 0) {
            exc = null;
        }
        return updatesLogger.logEntryString(str, updatesErrorCode, logType, str2, str3, exc);
    }

    private final String logEntryString(String message, UpdatesErrorCode code, LogType level, String updateId, String assetId, Exception exception) {
        ArrayList arrayList;
        ArrayList arrayList2;
        long time = new Date().getTime();
        Exception exc = exception instanceof Throwable ? exception : null;
        if (exc == null) {
            exc = new Throwable();
        }
        int i = WhenMappings.$EnumSwitchMapping$0[level.ordinal()];
        if (i == 1) {
            StackTraceElement[] stackTrace = exc.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "throwable.stackTrace");
            List take = ArraysKt.take(stackTrace, 20);
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(take, 10));
            Iterator it = take.iterator();
            while (it.hasNext()) {
                arrayList3.add(((StackTraceElement) it.next()).toString());
            }
            arrayList = arrayList3;
        } else if (i == 2) {
            StackTraceElement[] stackTrace2 = exc.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace2, "throwable.stackTrace");
            List take2 = ArraysKt.take(stackTrace2, 20);
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(take2, 10));
            Iterator it2 = take2.iterator();
            while (it2.hasNext()) {
                arrayList4.add(((StackTraceElement) it2.next()).toString());
            }
            arrayList = arrayList4;
        } else {
            arrayList2 = null;
            return new UpdatesLogEntry(time, message, code.getCode(), level.getType(), updateId, assetId, arrayList2).asString();
        }
        arrayList2 = arrayList;
        return new UpdatesLogEntry(time, message, code.getCode(), level.getType(), updateId, assetId, arrayList2).asString();
    }
}
