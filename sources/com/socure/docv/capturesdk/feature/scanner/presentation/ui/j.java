package com.socure.docv.capturesdk.feature.scanner.presentation.ui;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.socure.docv.capturesdk.common.utils.ExtensionsKt;
import com.socure.docv.capturesdk.common.utils.Utils;
import io.castle.android.api.model.Event;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class j implements com.socure.docv.capturesdk.common.view.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScannerFragment f526a;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f527a;

        static {
            int[] iArr = new int[com.socure.docv.capturesdk.common.view.model.a.values().length];
            iArr[com.socure.docv.capturesdk.common.view.model.a.CONTINUE.ordinal()] = 1;
            f527a = iArr;
        }
    }

    public j(ScannerFragment scannerFragment) {
        this.f526a = scannerFragment;
    }

    @Override // com.socure.docv.capturesdk.common.view.a
    public void a(com.socure.docv.capturesdk.common.view.model.a bsCallbackType, String str) {
        Intrinsics.checkNotNullParameter(bsCallbackType, "bsCallbackType");
        if (a.f527a[bsCallbackType.ordinal()] != 1) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SF", "unsupported callback from help: " + bsCallbackType);
            return;
        }
        ScannerFragment scannerFragment = this.f526a;
        Utils utils = Utils.INSTANCE;
        ScannerFragment scannerFragment2 = this.f526a;
        int i = ScannerFragment.C;
        scannerFragment.a("clicked", new Pair<>(Event.EVENT_TYPE_SCREEN, "help"), new Pair<>("facet_type", utils.getDocSelFacet$capturesdk_productionRelease(scannerFragment2.b().d(), this.f526a.c())), new Pair<>("type", "continue_button"));
        BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior = this.f526a.f();
        Intrinsics.checkNotNullExpressionValue(bottomSheetBehavior, "bottomSheetBehavior");
        ExtensionsKt.hide(bottomSheetBehavior);
        this.f526a.r();
    }
}
