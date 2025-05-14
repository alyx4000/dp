package expo.modules.securestore;

import android.app.Activity;
import android.content.Context;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.FragmentActivity;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.interfaces.ActivityProvider;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: AuthenticationHelper.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ)\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J!\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lexpo/modules/securestore/AuthenticationHelper;", "", "context", "Landroid/content/Context;", "moduleRegistry", "Lexpo/modules/core/ModuleRegistry;", "(Landroid/content/Context;Lexpo/modules/core/ModuleRegistry;)V", "isAuthenticating", "", "assertBiometricsSupport", "", "authenticateCipher", "Ljavax/crypto/Cipher;", "cipher", "requiresAuthentication", "title", "", "(Ljavax/crypto/Cipher;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentActivity", "Landroid/app/Activity;", "openAuthenticationPrompt", "Landroidx/biometric/BiometricPrompt$AuthenticationResult;", "(Ljavax/crypto/Cipher;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "expo-secure-store_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AuthenticationHelper {
    public static final String REQUIRE_AUTHENTICATION_PROPERTY = "requireAuthentication";
    private final Context context;
    private boolean isAuthenticating;
    private final ModuleRegistry moduleRegistry;

    public AuthenticationHelper(Context context, ModuleRegistry moduleRegistry) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(moduleRegistry, "moduleRegistry");
        this.context = context;
        this.moduleRegistry = moduleRegistry;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object authenticateCipher(javax.crypto.Cipher r5, boolean r6, java.lang.String r7, kotlin.coroutines.Continuation<? super javax.crypto.Cipher> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof expo.modules.securestore.AuthenticationHelper$authenticateCipher$1
            if (r0 == 0) goto L14
            r0 = r8
            expo.modules.securestore.AuthenticationHelper$authenticateCipher$1 r0 = (expo.modules.securestore.AuthenticationHelper$authenticateCipher$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            expo.modules.securestore.AuthenticationHelper$authenticateCipher$1 r0 = new expo.modules.securestore.AuthenticationHelper$authenticateCipher$1
            r0.<init>(r4, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L40
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r8)
            if (r6 == 0) goto L5b
            r0.label = r3
            java.lang.Object r8 = r4.openAuthenticationPrompt(r5, r7, r0)
            if (r8 != r1) goto L40
            return r1
        L40:
            androidx.biometric.BiometricPrompt$AuthenticationResult r8 = (androidx.biometric.BiometricPrompt.AuthenticationResult) r8
            androidx.biometric.BiometricPrompt$CryptoObject r5 = r8.getCryptoObject()
            r6 = 0
            if (r5 == 0) goto L4e
            javax.crypto.Cipher r5 = r5.getCipher()
            goto L4f
        L4e:
            r5 = r6
        L4f:
            if (r5 == 0) goto L52
            return r5
        L52:
            expo.modules.securestore.AuthenticationException r5 = new expo.modules.securestore.AuthenticationException
            java.lang.String r7 = "Couldn't get cipher from authentication result"
            r8 = 2
            r5.<init>(r7, r6, r8, r6)
            throw r5
        L5b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.securestore.AuthenticationHelper.authenticateCipher(javax.crypto.Cipher, boolean, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object openAuthenticationPrompt(Cipher cipher, String str, Continuation<? super BiometricPrompt.AuthenticationResult> continuation) {
        if (this.isAuthenticating) {
            throw new AuthenticationException("Authentication is already in progress", null, 2, null);
        }
        this.isAuthenticating = true;
        assertBiometricsSupport();
        Activity currentActivity = getCurrentActivity();
        FragmentActivity fragmentActivity = currentActivity instanceof FragmentActivity ? (FragmentActivity) currentActivity : null;
        if (fragmentActivity == null) {
            throw new AuthenticationException("Cannot display biometric prompt when the app is not in the foreground", null, 2, null);
        }
        return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new AuthenticationHelper$openAuthenticationPrompt$2(new AuthenticationPrompt(fragmentActivity, this.context, str), cipher, this, null), continuation);
    }

    public final void assertBiometricsSupport() {
        BiometricManager from = BiometricManager.from(this.context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        int canAuthenticate = from.canAuthenticate(15);
        if (canAuthenticate == -2) {
            throw new AuthenticationException("Biometric authentication is unsupported", null, 2, null);
        }
        if (canAuthenticate != -1) {
            if (canAuthenticate != 1) {
                if (canAuthenticate == 15) {
                    throw new AuthenticationException("An update is required before the biometrics can be used", null, 2, null);
                }
                if (canAuthenticate == 11) {
                    throw new AuthenticationException("No biometrics are currently enrolled", null, 2, null);
                }
                if (canAuthenticate != 12) {
                    return;
                }
            }
            throw new AuthenticationException("No hardware available for biometric authentication. Use expo-local-authentication to check if the device supports it", null, 2, null);
        }
        throw new AuthenticationException("Biometric authentication status is unknown", null, 2, null);
    }

    private final Activity getCurrentActivity() {
        Object module = this.moduleRegistry.getModule(ActivityProvider.class);
        Intrinsics.checkNotNullExpressionValue(module, "moduleRegistry.getModule…vityProvider::class.java)");
        return ((ActivityProvider) module).getCurrentActivity();
    }
}
