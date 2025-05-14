package com.extole.android.sdk.impl.app.action;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: NativeShareAction.kt */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.extole.android.sdk.impl.app.action.NativeShareAction", f = "NativeShareAction.kt", i = {0}, l = {31}, m = "getShareMessage", n = {"this"}, s = {"L$0"})
/* loaded from: classes.dex */
final class NativeShareAction$getShareMessage$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NativeShareAction this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NativeShareAction$getShareMessage$1(NativeShareAction nativeShareAction, Continuation<? super NativeShareAction$getShareMessage$1> continuation) {
        super(continuation);
        this.this$0 = nativeShareAction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object shareMessage;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        shareMessage = this.this$0.getShareMessage(null, this);
        return shareMessage;
    }
}
