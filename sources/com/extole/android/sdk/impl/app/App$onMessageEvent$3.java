package com.extole.android.sdk.impl.app;

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

/* compiled from: App.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.extole.android.sdk.impl.app.App$onMessageEvent$3", f = "App.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class App$onMessageEvent$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppEvent $queuedEvent;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    App$onMessageEvent$3(AppEvent appEvent, Continuation<? super App$onMessageEvent$3> continuation) {
        super(2, continuation);
        this.$queuedEvent = appEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new App$onMessageEvent$3(this.$queuedEvent, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((App$onMessageEvent$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            App.INSTANCE.getExtole().getLogger().debug("Received event " + this.$queuedEvent, new Object[0]);
            if (this.$queuedEvent != null) {
                AppEngine appEngine = new AppEngine(App.INSTANCE.getExtole().getOperations());
                AppEvent queuedEvent = this.$queuedEvent;
                Intrinsics.checkNotNullExpressionValue(queuedEvent, "queuedEvent");
                this.label = 1;
                if (appEngine.execute(queuedEvent, App.INSTANCE.getExtole(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
