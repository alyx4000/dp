package expo.modules.localauthentication;

import androidx.fragment.app.FragmentActivity;
import expo.modules.kotlin.Promise;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LocalAuthenticationModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.localauthentication.LocalAuthenticationModule$definition$1$5$1", f = "LocalAuthenticationModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class LocalAuthenticationModule$definition$1$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $fragmentActivity;
    final /* synthetic */ AuthOptions $options;
    final /* synthetic */ Promise $promise;
    int label;
    final /* synthetic */ LocalAuthenticationModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocalAuthenticationModule$definition$1$5$1(LocalAuthenticationModule localAuthenticationModule, FragmentActivity fragmentActivity, AuthOptions authOptions, Promise promise, Continuation<? super LocalAuthenticationModule$definition$1$5$1> continuation) {
        super(2, continuation);
        this.this$0 = localAuthenticationModule;
        this.$fragmentActivity = fragmentActivity;
        this.$options = authOptions;
        this.$promise = promise;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalAuthenticationModule$definition$1$5$1(this.this$0, this.$fragmentActivity, this.$options, this.$promise, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LocalAuthenticationModule$definition$1$5$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.authenticate(this.$fragmentActivity, this.$options, this.$promise);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
