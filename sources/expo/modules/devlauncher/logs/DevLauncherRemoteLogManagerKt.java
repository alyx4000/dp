package expo.modules.devlauncher.logs;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevLauncherRemoteLogManager.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toRemoteLogString", "", "", "expo-dev-launcher_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DevLauncherRemoteLogManagerKt {
    public static final String toRemoteLogString(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        StackTraceElement[] stackTrace = th.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
        String str = th + "\n  " + ArraysKt.joinToString$default(stackTrace, "\n  ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<StackTraceElement, CharSequence>() { // from class: expo.modules.devlauncher.logs.DevLauncherRemoteLogManagerKt$toRemoteLogString$baseTrace$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(StackTraceElement stackTraceElement) {
                String stackTraceElement2 = stackTraceElement.toString();
                Intrinsics.checkNotNullExpressionValue(stackTraceElement2, "it.toString()");
                return stackTraceElement2;
            }
        }, 30, (Object) null);
        Throwable cause = th.getCause();
        if (cause == null) {
            return str;
        }
        return str + "\nCaused by " + toRemoteLogString(cause);
    }
}
