package io.castle.highwind.android;

import android.app.usage.StorageStatsManager;
import io.castle.highwind.android.g;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "io.castle.highwind.android.AndroidSystem$getInternalStorageSize$2", f = "AndroidSystem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
public final class i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super g.a>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f773a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(g gVar, Continuation<? super i> continuation) {
        super(2, continuation);
        this.f773a = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new i(this.f773a, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super g.a> continuation) {
        return ((i) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        StorageStatsManager storageStatsManager = (StorageStatsManager) this.f773a.c.getSystemService("storagestats");
        return new g.a(storageStatsManager != null ? g.a(this.f773a, storageStatsManager) : g.a(this.f773a));
    }
}
