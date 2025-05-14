package io.castle.highwind.android;

import external.sdk.pendo.io.mozilla.javascript.Token;
import io.castle.highwind.android.g;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

@DebugMetadata(c = "io.castle.highwind.android.AndroidSystem$updateStorageInfo$1", f = "AndroidSystem.kt", i = {}, l = {Token.METHOD}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f774a;
    public final /* synthetic */ g b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(g gVar, Continuation<? super j> continuation) {
        super(2, continuation);
        this.b = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new j(this.b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((j) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object a2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f774a;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                g gVar = this.b;
                this.f774a = 1;
                a2 = g.a(gVar, this);
                if (a2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                a2 = ((g.a) obj).f771a;
            }
            g gVar2 = this.b;
            gVar2.d = (Pair) a2;
            Mutex.DefaultImpls.unlock$default(gVar2.e, null, 1, null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            Mutex.DefaultImpls.unlock$default(this.b.e, null, 1, null);
            throw th;
        }
    }
}
