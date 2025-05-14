package com.socure.docv.capturesdk.feature.scanner.presentation.ui;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.socure.docv.capturesdk.feature.scanner.presentation.ui.ScannerFragment$setupManualButtonVisibility$1", f = "ScannerFragment.kt", i = {0, 0, 0, 1, 1, 1}, l = {771, 785}, m = "invokeSuspend", n = {"$this$launch", "remainingTimeOut", "timeBeforeHalf", "$this$launch", "remainingTimeOut", "delay"}, s = {"L$0", "J$0", "J$1", "L$0", "J$0", "J$1"})
/* loaded from: classes5.dex */
public final class i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public long f525a;
    public long b;
    public int c;
    public /* synthetic */ Object d;
    public final /* synthetic */ ScannerFragment e;
    public final /* synthetic */ long f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(ScannerFragment scannerFragment, long j, Continuation<? super i> continuation) {
        super(2, continuation);
        this.e = scannerFragment;
        this.f = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        i iVar = new i(this.e, this.f, continuation);
        iVar.d = obj;
        return iVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        i iVar = new i(this.e, this.f, continuation);
        iVar.d = coroutineScope;
        return iVar.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0113 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x011b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 606
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socure.docv.capturesdk.feature.scanner.presentation.ui.i.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
