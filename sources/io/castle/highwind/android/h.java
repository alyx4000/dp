package io.castle.highwind.android;

import io.castle.highwind.android.g;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@DebugMetadata(c = "io.castle.highwind.android.AndroidSystem", f = "AndroidSystem.kt", i = {}, l = {173}, m = "getInternalStorageSize-7fBkFjM", n = {}, s = {})
/* loaded from: classes2.dex */
public final class h extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f772a;
    public final /* synthetic */ g b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, Continuation<? super h> continuation) {
        super(continuation);
        this.b = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f772a = obj;
        this.c |= Integer.MIN_VALUE;
        Object a2 = g.a(this.b, this);
        return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : new g.a((Pair) a2);
    }
}
