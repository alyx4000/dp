package com.socure.docv.capturesdk.feature.scanner.presentation.ui;

import io.sentry.protocol.ViewHierarchyNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class h extends Lambda implements Function2<Boolean, Exception, Unit> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScannerFragment f524a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(ScannerFragment scannerFragment) {
        super(2);
        this.f524a = scannerFragment;
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(Boolean bool, Exception exc) {
        Exception exc2 = exc;
        if (bool.booleanValue()) {
            com.socure.docv.capturesdk.common.logger.b.c("SDLT_SF", "cameraStarted callback received");
        } else {
            Intrinsics.checkNotNullParameter("SDLT_SF", ViewHierarchyNode.JsonKeys.TAG);
            Intrinsics.checkNotNullParameter("Use case binding failed", "msg");
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "Use case binding failed", 1, exc2);
            ScannerFragment scannerFragment = this.f524a;
            String localizedMessage = exc2 != null ? exc2.getLocalizedMessage() : null;
            if (localizedMessage == null) {
                localizedMessage = "Camera Binding Failed With Empty Exception Message";
            }
            int i = ScannerFragment.C;
            scannerFragment.b(localizedMessage);
        }
        return Unit.INSTANCE;
    }
}
