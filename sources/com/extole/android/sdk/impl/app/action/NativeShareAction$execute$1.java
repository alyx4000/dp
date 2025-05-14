package com.extole.android.sdk.impl.app.action;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: NativeShareAction.kt */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.extole.android.sdk.impl.app.action.NativeShareAction", f = "NativeShareAction.kt", i = {0, 0, 0}, l = {19}, m = "execute", n = {"extole", "imageUri", "shareIntent"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes.dex */
final class NativeShareAction$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NativeShareAction this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NativeShareAction$execute$1(NativeShareAction nativeShareAction, Continuation<? super NativeShareAction$execute$1> continuation) {
        super(continuation);
        this.this$0 = nativeShareAction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, null, this);
    }
}
