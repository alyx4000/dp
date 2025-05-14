package com.extole.android.sdk.impl.app.action;

import com.extole.android.sdk.impl.ExtoleInternal;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LoadOperationsAction.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.extole.android.sdk.impl.app.action.LoadOperationsAction$execute$2", f = "LoadOperationsAction.kt", i = {}, l = {31, 53}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class LoadOperationsAction$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ExtoleInternal $extole;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LoadOperationsAction this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoadOperationsAction$execute$2(LoadOperationsAction loadOperationsAction, ExtoleInternal extoleInternal, Continuation<? super LoadOperationsAction$execute$2> continuation) {
        super(2, continuation);
        this.this$0 = loadOperationsAction;
        this.$extole = extoleInternal;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoadOperationsAction$execute$2(this.this$0, this.$extole, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoadOperationsAction$execute$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0078  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.extole.android.sdk.impl.app.action.LoadOperationsAction$execute$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
