package com.extole.android.sdk.impl.app;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AppEngine.kt */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.extole.android.sdk.impl.app.AppEngine", f = "AppEngine.kt", i = {0, 0}, l = {13}, m = "execute", n = {"appEvent", "extole"}, s = {"L$0", "L$1"})
/* loaded from: classes.dex */
final class AppEngine$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppEngine$execute$1(AppEngine appEngine, Continuation<? super AppEngine$execute$1> continuation) {
        super(continuation);
        this.this$0 = appEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, null, this);
    }
}
