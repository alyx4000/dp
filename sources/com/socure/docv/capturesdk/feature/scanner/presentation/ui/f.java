package com.socure.docv.capturesdk.feature.scanner.presentation.ui;

import com.socure.docv.capturesdk.common.utils.Utils;
import com.socure.docv.capturesdk.feature.scanner.data.FrameGeneratorCallback;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class f implements FrameGeneratorCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScannerFragment f522a;

    public f(ScannerFragment scannerFragment) {
        this.f522a = scannerFragment;
    }

    @Override // com.socure.docv.capturesdk.feature.scanner.data.FrameGeneratorCallback
    public void onCompletion() {
        Utils utils = Utils.INSTANCE;
        ScannerFragment scannerFragment = this.f522a;
        int i = ScannerFragment.C;
        if (utils.isSelfie$capturesdk_productionRelease(scannerFragment.c()) && utils.isAutomationFlavor$capturesdk_productionRelease()) {
            com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.c cVar = this.f522a.m;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                cVar = null;
            }
            cVar.d();
        }
    }

    @Override // com.socure.docv.capturesdk.feature.scanner.data.FrameGeneratorCallback
    public void onStreaming() {
        com.socure.docv.capturesdk.common.logger.b.a("TAG", "onStreaming called for video - not doing anything");
    }
}
