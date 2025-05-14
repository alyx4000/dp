package com.socure.docv.capturesdk.feature.scanner.presentation.ui;

import android.view.View;
import com.socure.docv.capturesdk.feature.scanner.data.Container;
import com.socure.docv.capturesdk.feature.scanner.data.Dimension;
import com.socure.docv.capturesdk.feature.scanner.data.GuidingBox;
import com.socure.docv.capturesdk.feature.scanner.data.ViewDimensions;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@DebugMetadata(c = "com.socure.docv.capturesdk.feature.scanner.presentation.ui.ScannerFragment$passViewDimsWDelay$1", f = "ScannerFragment.kt", i = {}, l = {523}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f521a;
    public final /* synthetic */ long b;
    public final /* synthetic */ ScannerFragment c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(long j, ScannerFragment scannerFragment, Continuation<? super e> continuation) {
        super(2, continuation);
        this.b = j;
        this.c = scannerFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new e(this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return new e(this.b, this.c, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f521a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long j = this.b;
            this.f521a = 1;
            if (DelayKt.delay(j, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ScannerFragment scannerFragment = this.c;
        int i2 = ScannerFragment.C;
        scannerFragment.getClass();
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "passingViewDimensions");
        com.socure.docv.capturesdk.databinding.g gVar = scannerFragment.n;
        if (gVar != null) {
            Intrinsics.checkNotNull(gVar);
            OverlayLayout overlayLayout = gVar.h;
            int[] iArr = new int[2];
            overlayLayout.getGuideView().getLocationOnScreen(iArr);
            com.socure.docv.capturesdk.databinding.g gVar2 = scannerFragment.n;
            Intrinsics.checkNotNull(gVar2);
            int width = gVar2.l.getWidth();
            com.socure.docv.capturesdk.databinding.g gVar3 = scannerFragment.n;
            Intrinsics.checkNotNull(gVar3);
            Container container = new Container(width, gVar3.l.getHeight());
            View guideView = overlayLayout.getGuideView();
            int width2 = guideView.getWidth();
            int height = guideView.getHeight();
            int i3 = iArr[0];
            int i4 = iArr[1];
            com.socure.docv.capturesdk.databinding.g gVar4 = scannerFragment.n;
            Intrinsics.checkNotNull(gVar4);
            double width3 = gVar4.l.getWidth();
            Intrinsics.checkNotNull(scannerFragment.n);
            ViewDimensions viewDimensions = new ViewDimensions(container, new GuidingBox(width2, height, i3, i4, new Dimension(width3, r2.l.getHeight())), false, 4, null);
            com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar = scannerFragment.m;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                cVar = null;
            }
            cVar.getClass();
            Intrinsics.checkNotNullParameter(viewDimensions, "viewDimensions");
            cVar.f529a.a(viewDimensions);
            com.socure.docv.capturesdk.feature.scanner.b bVar = cVar.m;
            if (bVar != null) {
                ViewDimensions viewDimensions2 = cVar.f529a.i();
                Intrinsics.checkNotNullParameter(viewDimensions2, "viewDimensions");
                com.socure.docv.capturesdk.core.provider.interfaces.c cVar2 = bVar.d;
                if (cVar2 != null) {
                    cVar2.updateViewDimensions(viewDimensions2);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
