package expo.modules.core.logging;

import android.util.Log;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OSLogHandler.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J'\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0010¢\u0006\u0002\b\f¨\u0006\r"}, d2 = {"Lexpo/modules/core/logging/OSLogHandler;", "Lexpo/modules/core/logging/LogHandler;", "category", "", "(Ljava/lang/String;)V", "log", "", "type", "Lexpo/modules/core/logging/LogType;", "message", "cause", "", "log$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OSLogHandler extends LogHandler {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OSLogHandler(String category) {
        super(category);
        Intrinsics.checkNotNullParameter(category, "category");
    }

    @Override // expo.modules.core.logging.LogHandler
    public void log$expo_modules_core_release(LogType type, String message, Throwable cause) {
        boolean z;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        z = OSLogHandlerKt.isAndroid;
        if (!z) {
            System.out.println((Object) ("[" + type.getType() + "] " + getCategory() + "\t" + message));
            if (cause != null) {
                System.out.println((Object) (cause.getLocalizedMessage() + "\n" + ExceptionsKt.stackTraceToString(cause)));
                return;
            }
            return;
        }
        int oSLogType = LogType.INSTANCE.toOSLogType(type);
        if (oSLogType == 3) {
            Log.d(getCategory(), message, cause);
            return;
        }
        if (oSLogType == 4) {
            Log.i(getCategory(), message, cause);
            return;
        }
        if (oSLogType == 5) {
            Log.w(getCategory(), message, cause);
        } else if (oSLogType == 6) {
            Log.e(getCategory(), message, cause);
        } else {
            if (oSLogType != 7) {
                return;
            }
            Log.e(getCategory(), message, cause);
        }
    }
}
