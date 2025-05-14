package com.extole.android.sdk.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ExtoleImpl.kt */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.extole.android.sdk.impl.ExtoleImpl", f = "ExtoleImpl.kt", i = {0, 0}, l = {93}, m = "fetchZone", n = {"this", "zoneName"}, s = {"L$0", "L$1"})
/* loaded from: classes.dex */
final class ExtoleImpl$fetchZone$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExtoleImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExtoleImpl$fetchZone$1(ExtoleImpl extoleImpl, Continuation<? super ExtoleImpl$fetchZone$1> continuation) {
        super(continuation);
        this.this$0 = extoleImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchZone(null, null, this);
    }
}
