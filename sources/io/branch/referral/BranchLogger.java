package io.branch.referral;

import android.util.Log;
import com.facebook.common.callercontext.ContextChain;
import io.branch.interfaces.IBranchLoggingCallbacks;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BranchLogger.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J \u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u000e\u0010\u001a\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001cH\u0007J\b\u0010\u001d\u001a\u00020\rH\u0002J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lio/branch/referral/BranchLogger;", "", "()V", "TAG", "", "loggerCallback", "Lio/branch/interfaces/IBranchLoggingCallbacks;", "getLoggerCallback$annotations", "getLoggerCallback", "()Lio/branch/interfaces/IBranchLoggingCallbacks;", "setLoggerCallback", "(Lio/branch/interfaces/IBranchLoggingCallbacks;)V", "loggingEnabled", "", "getLoggingEnabled$annotations", "getLoggingEnabled", "()Z", "setLoggingEnabled", "(Z)V", "d", "", "message", "e", ContextChain.TAG_INFRA, "logAlways", "logException", "t", "Ljava/lang/Exception;", "Lkotlin/Exception;", "useCustomLogger", "v", "w", "Branch-SDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BranchLogger {
    public static final BranchLogger INSTANCE = new BranchLogger();
    private static final String TAG = "BranchSDK";
    private static IBranchLoggingCallbacks loggerCallback;
    private static boolean loggingEnabled;

    @JvmStatic
    public static /* synthetic */ void getLoggerCallback$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLoggingEnabled$annotations() {
    }

    private BranchLogger() {
    }

    public static final boolean getLoggingEnabled() {
        return loggingEnabled;
    }

    public static final void setLoggingEnabled(boolean z) {
        loggingEnabled = z;
    }

    public static final IBranchLoggingCallbacks getLoggerCallback() {
        return loggerCallback;
    }

    public static final void setLoggerCallback(IBranchLoggingCallbacks iBranchLoggingCallbacks) {
        loggerCallback = iBranchLoggingCallbacks;
    }

    @JvmStatic
    public static final void e(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        BranchLogger branchLogger = INSTANCE;
        if (loggingEnabled) {
            if (message.length() > 0) {
                if (branchLogger.useCustomLogger()) {
                    IBranchLoggingCallbacks iBranchLoggingCallbacks = loggerCallback;
                    if (iBranchLoggingCallbacks != null) {
                        iBranchLoggingCallbacks.onBranchLog(message, "ERROR");
                        return;
                    }
                    return;
                }
                Log.e(TAG, message);
            }
        }
    }

    @JvmStatic
    public static final void w(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        BranchLogger branchLogger = INSTANCE;
        if (loggingEnabled) {
            if (message.length() > 0) {
                if (branchLogger.useCustomLogger()) {
                    IBranchLoggingCallbacks iBranchLoggingCallbacks = loggerCallback;
                    if (iBranchLoggingCallbacks != null) {
                        iBranchLoggingCallbacks.onBranchLog(message, "WARN");
                        return;
                    }
                    return;
                }
                Log.w(TAG, message);
            }
        }
    }

    @JvmStatic
    public static final void i(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        BranchLogger branchLogger = INSTANCE;
        if (loggingEnabled) {
            if (message.length() > 0) {
                if (branchLogger.useCustomLogger()) {
                    IBranchLoggingCallbacks iBranchLoggingCallbacks = loggerCallback;
                    if (iBranchLoggingCallbacks != null) {
                        iBranchLoggingCallbacks.onBranchLog(message, "INFO");
                        return;
                    }
                    return;
                }
                Log.i(TAG, message);
            }
        }
    }

    @JvmStatic
    public static final void d(String message) {
        BranchLogger branchLogger = INSTANCE;
        if (loggingEnabled) {
            boolean z = false;
            if (message != null) {
                if (message.length() > 0) {
                    z = true;
                }
            }
            if (z) {
                if (branchLogger.useCustomLogger()) {
                    IBranchLoggingCallbacks iBranchLoggingCallbacks = loggerCallback;
                    if (iBranchLoggingCallbacks != null) {
                        iBranchLoggingCallbacks.onBranchLog(message, "DEBUG");
                        return;
                    }
                    return;
                }
                Log.d(TAG, message);
            }
        }
    }

    @JvmStatic
    public static final void v(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        BranchLogger branchLogger = INSTANCE;
        if (loggingEnabled) {
            if (message.length() > 0) {
                if (branchLogger.useCustomLogger()) {
                    IBranchLoggingCallbacks iBranchLoggingCallbacks = loggerCallback;
                    if (iBranchLoggingCallbacks != null) {
                        iBranchLoggingCallbacks.onBranchLog(message, "VERBOSE");
                        return;
                    }
                    return;
                }
                Log.v(TAG, message);
            }
        }
    }

    @JvmStatic
    public static final void logAlways(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.length() > 0) {
            if (INSTANCE.useCustomLogger()) {
                IBranchLoggingCallbacks iBranchLoggingCallbacks = loggerCallback;
                if (iBranchLoggingCallbacks != null) {
                    iBranchLoggingCallbacks.onBranchLog(message, "INFO");
                    return;
                }
                return;
            }
            Log.i(TAG, message);
        }
    }

    @JvmStatic
    public static final void logException(String message, Exception t) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (message.length() > 0) {
            if (INSTANCE.useCustomLogger()) {
                IBranchLoggingCallbacks iBranchLoggingCallbacks = loggerCallback;
                if (iBranchLoggingCallbacks != null) {
                    iBranchLoggingCallbacks.onBranchLog(message, "ERROR");
                    return;
                }
                return;
            }
            Log.e(TAG, message, t);
        }
    }

    private final boolean useCustomLogger() {
        return loggerCallback != null;
    }
}
