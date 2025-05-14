package expo.modules.securestore;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AsyncFunctionBuilder.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u0001*\u00020\u00062\u0010\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\bH\u008a@¨\u0006\n"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "Lkotlinx/coroutines/CoroutineScope;", "it", "", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$13", "expo/modules/kotlin/functions/AsyncFunctionBuilderKt$Coroutine$$inlined$SuspendBody$9"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.securestore.SecureStoreModule$definition$lambda$6$$inlined$Coroutine$4", f = "SecureStoreModule.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class SecureStoreModule$definition$lambda$6$$inlined$Coroutine$4 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SecureStoreModule this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SecureStoreModule$definition$lambda$6$$inlined$Coroutine$4(Continuation continuation, SecureStoreModule secureStoreModule) {
        super(3, continuation);
        this.this$0 = secureStoreModule;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, objArr, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        SecureStoreModule$definition$lambda$6$$inlined$Coroutine$4 secureStoreModule$definition$lambda$6$$inlined$Coroutine$4 = new SecureStoreModule$definition$lambda$6$$inlined$Coroutine$4(continuation, this.this$0);
        secureStoreModule$definition$lambda$6$$inlined$Coroutine$4.L$0 = objArr;
        return secureStoreModule$definition$lambda$6$$inlined$Coroutine$4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object itemImpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object[] objArr = (Object[]) this.L$0;
            String str = (String) objArr[0];
            String str2 = (String) objArr[1];
            Object obj2 = objArr[2];
            if (obj2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type expo.modules.securestore.SecureStoreOptions");
            }
            SecureStoreOptions secureStoreOptions = (SecureStoreOptions) obj2;
            if (str2 == null) {
                throw new NullKeyException();
            }
            SecureStoreModule secureStoreModule = this.this$0;
            this.label = 1;
            itemImpl = secureStoreModule.setItemImpl(str2, str, secureStoreOptions, false, this);
            if (itemImpl == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
