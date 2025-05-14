package expo.modules.securestore;

import android.content.Context;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthenticationPrompt.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lexpo/modules/securestore/AuthenticationPrompt;", "", "currentActivity", "Landroidx/fragment/app/FragmentActivity;", "context", "Landroid/content/Context;", "title", "", "(Landroidx/fragment/app/FragmentActivity;Landroid/content/Context;Ljava/lang/String;)V", "executor", "Ljava/util/concurrent/Executor;", "promptInfo", "Landroidx/biometric/BiometricPrompt$PromptInfo;", "authenticate", "Landroidx/biometric/BiometricPrompt$AuthenticationResult;", "cipher", "Ljavax/crypto/Cipher;", "(Ljavax/crypto/Cipher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-secure-store_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AuthenticationPrompt {
    private final FragmentActivity currentActivity;
    private Executor executor;
    private BiometricPrompt.PromptInfo promptInfo;

    public AuthenticationPrompt(FragmentActivity currentActivity, Context context, String title) {
        Intrinsics.checkNotNullParameter(currentActivity, "currentActivity");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        this.currentActivity = currentActivity;
        Executor mainExecutor = ContextCompat.getMainExecutor(context);
        Intrinsics.checkNotNullExpressionValue(mainExecutor, "getMainExecutor(context)");
        this.executor = mainExecutor;
        BiometricPrompt.PromptInfo build = new BiometricPrompt.PromptInfo.Builder().setTitle(title).setNegativeButtonText(context.getString(android.R.string.cancel)).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n    .setTitle(…ing.cancel))\n    .build()");
        this.promptInfo = build;
    }

    public final Object authenticate(Cipher cipher, Continuation<? super BiometricPrompt.AuthenticationResult> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        new BiometricPrompt(this.currentActivity, this.executor, new BiometricPrompt.AuthenticationCallback() { // from class: expo.modules.securestore.AuthenticationPrompt$authenticate$2$1
            @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
            public void onAuthenticationError(int errorCode, CharSequence errString) {
                Intrinsics.checkNotNullParameter(errString, "errString");
                super.onAuthenticationError(errorCode, errString);
                if (errorCode == 10 || errorCode == 13) {
                    Continuation<BiometricPrompt.AuthenticationResult> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1227constructorimpl(ResultKt.createFailure(new AuthenticationException("User canceled the authentication", null, 2, null))));
                } else {
                    Continuation<BiometricPrompt.AuthenticationResult> continuation3 = safeContinuation2;
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation3.resumeWith(Result.m1227constructorimpl(ResultKt.createFailure(new AuthenticationException("Could not authenticate the user", null, 2, null))));
                }
            }

            @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
            public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.onAuthenticationSucceeded(result);
                Continuation<BiometricPrompt.AuthenticationResult> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m1227constructorimpl(result));
            }
        }).authenticate(this.promptInfo, new BiometricPrompt.CryptoObject(cipher));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
