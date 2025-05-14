package expo.modules.localauthentication;

import android.app.KeyguardManager;
import android.os.Build;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.FragmentActivity;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.UnexpectedException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LocalAuthenticationModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.localauthentication.LocalAuthenticationModule$promptDeviceCredentialsFallback$1", f = "LocalAuthenticationModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class LocalAuthenticationModule$promptDeviceCredentialsFallback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $fragmentActivity;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ String $promptMessage;
    final /* synthetic */ boolean $requireConfirmation;
    int label;
    final /* synthetic */ LocalAuthenticationModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocalAuthenticationModule$promptDeviceCredentialsFallback$1(LocalAuthenticationModule localAuthenticationModule, String str, FragmentActivity fragmentActivity, Promise promise, boolean z, Continuation<? super LocalAuthenticationModule$promptDeviceCredentialsFallback$1> continuation) {
        super(2, continuation);
        this.this$0 = localAuthenticationModule;
        this.$promptMessage = str;
        this.$fragmentActivity = fragmentActivity;
        this.$promise = promise;
        this.$requireConfirmation = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalAuthenticationModule$promptDeviceCredentialsFallback$1(this.this$0, this.$promptMessage, this.$fragmentActivity, this.$promise, this.$requireConfirmation, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LocalAuthenticationModule$promptDeviceCredentialsFallback$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BiometricPrompt.AuthenticationCallback authenticationCallback;
        KeyguardManager keyguardManager;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (Build.VERSION.SDK_INT < 30) {
            keyguardManager = this.this$0.getKeyguardManager();
            this.$fragmentActivity.startActivityForResult(keyguardManager.createConfirmDeviceCredentialIntent(this.$promptMessage, ""), 6);
            return Unit.INSTANCE;
        }
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor()");
        FragmentActivity fragmentActivity = this.$fragmentActivity;
        authenticationCallback = this.this$0.authenticationCallback;
        BiometricPrompt biometricPrompt = new BiometricPrompt(fragmentActivity, newSingleThreadExecutor, authenticationCallback);
        this.this$0.biometricPrompt = biometricPrompt;
        BiometricPrompt.PromptInfo.Builder builder = new BiometricPrompt.PromptInfo.Builder();
        String str = this.$promptMessage;
        boolean z = this.$requireConfirmation;
        builder.setTitle(str);
        builder.setAllowedAuthenticators(32768);
        builder.setConfirmationRequired(z);
        BiometricPrompt.PromptInfo build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "promptInfoBuilder.build()");
        try {
            biometricPrompt.authenticate(build);
        } catch (NullPointerException e) {
            this.$promise.reject(new UnexpectedException("Canceled authentication due to an internal error", e));
        }
        return Unit.INSTANCE;
    }
}
