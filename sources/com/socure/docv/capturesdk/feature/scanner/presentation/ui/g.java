package com.socure.docv.capturesdk.feature.scanner.presentation.ui;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class g extends Lambda implements Function0<Unit> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScannerFragment f523a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(ScannerFragment scannerFragment) {
        super(0);
        this.f523a = scannerFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        ScannerFragment scannerFragment = this.f523a;
        int i = ScannerFragment.C;
        scannerFragment.c(false);
        return Unit.INSTANCE;
    }
}
