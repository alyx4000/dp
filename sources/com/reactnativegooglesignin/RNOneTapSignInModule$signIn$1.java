package com.reactnativegooglesignin;

import android.app.Activity;
import androidx.credentials.CredentialManager;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.exceptions.GetCredentialException;
import com.facebook.react.bridge.Promise;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RNOneTapSignInModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.reactnativegooglesignin.RNOneTapSignInModule$signIn$1", f = "RNOneTapSignInModule.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class RNOneTapSignInModule$signIn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ GetCredentialRequest $request;
    int label;
    final /* synthetic */ RNOneTapSignInModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RNOneTapSignInModule$signIn$1(RNOneTapSignInModule rNOneTapSignInModule, Activity activity, GetCredentialRequest getCredentialRequest, Promise promise, Continuation<? super RNOneTapSignInModule$signIn$1> continuation) {
        super(2, continuation);
        this.this$0 = rNOneTapSignInModule;
        this.$activity = activity;
        this.$request = getCredentialRequest;
        this.$promise = promise;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RNOneTapSignInModule$signIn$1(this.this$0, this.$activity, this.$request, this.$promise, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RNOneTapSignInModule$signIn$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CredentialManager credentialManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                credentialManager = this.this$0.credentialManager;
                this.label = 1;
                obj = credentialManager.getCredential(this.$activity, this.$request, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.handleSignInSuccess((GetCredentialResponse) obj, this.$promise);
        } catch (GetCredentialException e) {
            this.this$0.handleSignInError(e, this.$promise);
        }
        return Unit.INSTANCE;
    }
}
