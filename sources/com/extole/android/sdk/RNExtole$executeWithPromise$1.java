package com.extole.android.sdk;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.Promise;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RNExtole.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.extole.android.sdk.RNExtole$executeWithPromise$1", f = "RNExtole.kt", i = {}, l = {194}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class RNExtole$executeWithPromise$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super T>, Object> $closure;
    final /* synthetic */ Promise $promise;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    RNExtole$executeWithPromise$1(Promise promise, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super RNExtole$executeWithPromise$1> continuation) {
        super(2, continuation);
        this.$promise = promise;
        this.$closure = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RNExtole$executeWithPromise$1(this.$promise, this.$closure, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RNExtole$executeWithPromise$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Promise promise;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Promise promise2 = this.$promise;
                Function1<Continuation<? super T>, Object> function1 = this.$closure;
                this.L$0 = promise2;
                this.label = 1;
                Object invoke = function1.invoke(this);
                if (invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                promise = promise2;
                obj = invoke;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                promise = (Promise) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            promise.resolve(obj);
        } catch (Exception e) {
            Exception exc = e;
            Log.e("Extole", "Exception " + ExceptionsKt.stackTraceToString(exc));
            this.$promise.reject("Extole execution failed", exc);
        }
        return Unit.INSTANCE;
    }
}
