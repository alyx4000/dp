package expo.modules.kotlin.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CodedException.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/exception/JavaScriptEvaluateException;", "Lexpo/modules/kotlin/exception/CodedException;", "message", "", "jsStack", "(Ljava/lang/String;Ljava/lang/String;)V", "getJsStack", "()Ljava/lang/String;", "expo-modules-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class JavaScriptEvaluateException extends CodedException {
    private final String jsStack;

    public final String getJsStack() {
        return this.jsStack;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaScriptEvaluateException(String message, String jsStack) {
        super(StringsKt.trimIndent("\n  Cannot evaluate JavaScript code: " + message + "\n  " + jsStack + "\n  "), null, 2, null);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(jsStack, "jsStack");
        this.jsStack = jsStack;
    }
}
