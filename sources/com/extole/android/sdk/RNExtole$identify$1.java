package com.extole.android.sdk;

import com.extole.android.sdk.impl.ExtoleInternal;
import com.facebook.react.bridge.ReadableMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: RNExtole.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.extole.android.sdk.RNExtole$identify$1", f = "RNExtole.kt", i = {}, l = {152}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class RNExtole$identify$1 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ ReadableMap $data;
    final /* synthetic */ String $email;
    int label;
    final /* synthetic */ RNExtole this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RNExtole$identify$1(RNExtole rNExtole, ReadableMap readableMap, String str, Continuation<? super RNExtole$identify$1> continuation) {
        super(1, continuation);
        this.this$0 = rNExtole;
        this.$data = readableMap;
        this.$email = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new RNExtole$identify$1(this.this$0, this.$data, this.$email, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super String> continuation) {
        return ((RNExtole$identify$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ExtoleInternal extoleInternal;
        Map recursivelyDeconstructReadableMap;
        LinkedHashMap emptyMap;
        ExtoleInternal extoleInternal2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            extoleInternal = this.this$0.extole;
            if (extoleInternal == null) {
                throw new Exception("Extole is not initialized");
            }
            recursivelyDeconstructReadableMap = RNExtole.INSTANCE.recursivelyDeconstructReadableMap(this.$data);
            if (recursivelyDeconstructReadableMap == null) {
                emptyMap = MapsKt.emptyMap();
            } else {
                emptyMap = new LinkedHashMap(MapsKt.mapCapacity(recursivelyDeconstructReadableMap.size()));
                for (Map.Entry entry : recursivelyDeconstructReadableMap.entrySet()) {
                    emptyMap.put(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            extoleInternal2 = this.this$0.extole;
            if (extoleInternal2 != 0) {
                this.label = 1;
                obj = extoleInternal2.identify(this.$email, emptyMap, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return null;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Id id = (Id) obj;
        if (id != null) {
            return id.getId();
        }
        return null;
    }
}
