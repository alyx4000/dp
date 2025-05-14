package com.socure.docv.capturesdk.feature.scanner.presentation.ui;

import com.socure.docv.capturesdk.common.utils.ConstantsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

@DebugMetadata(c = "com.socure.docv.capturesdk.feature.scanner.presentation.ui.ScannerFragment$launchUploadDelayMsg$1", f = "ScannerFragment.kt", i = {0}, l = {1231}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes5.dex */
public final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f520a;
    public /* synthetic */ Object b;
    public final /* synthetic */ ScannerFragment c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ScannerFragment scannerFragment, Continuation<? super d> continuation) {
        super(2, continuation);
        this.c = scannerFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        d dVar = new d(this.c, continuation);
        dVar.b = obj;
        return dVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        d dVar = new d(this.c, continuation);
        dVar.b = coroutineScope;
        return dVar.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f520a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.b;
            this.b = coroutineScope2;
            this.f520a = 1;
            if (DelayKt.delay(ConstantsKt.PREVIEW_UPLOAD_DELAY, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope = coroutineScope2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.b;
            ResultKt.throwOnFailure(obj);
        }
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            ScannerFragment scannerFragment = this.c;
            com.socure.docv.capturesdk.common.session.a aVar = com.socure.docv.capturesdk.common.session.a.f305a;
            String pleaseWait = aVar.b().getNewLabels().getPleaseWait();
            int i2 = ScannerFragment.C;
            scannerFragment.a(pleaseWait, true);
            com.socure.docv.capturesdk.databinding.g gVar = this.c.n;
            Intrinsics.checkNotNull(gVar);
            gVar.d.d.b(aVar.b().getNewLabels().getPleaseWait());
        }
        return Unit.INSTANCE;
    }
}
