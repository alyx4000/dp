package com.extole.android.sdk.impl;

import com.facebook.imageutils.JfifUtil;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ExtoleImpl.kt */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.extole.android.sdk.impl.ExtoleImpl", f = "ExtoleImpl.kt", i = {0}, l = {JfifUtil.MARKER_RST0}, m = "clone", n = {"extole"}, s = {"L$0"})
/* loaded from: classes.dex */
final class ExtoleImpl$clone$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExtoleImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExtoleImpl$clone$1(ExtoleImpl extoleImpl, Continuation<? super ExtoleImpl$clone$1> continuation) {
        super(continuation);
        this.this$0 = extoleImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.clone(null, null, null, null, null, null, null, null, null, null, null, this);
    }
}
