package com.socure.docv.capturesdk.feature.scanner.presentation.ui;

import com.socure.docv.capturesdk.common.analytics.model.EventData;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b implements com.socure.docv.capturesdk.common.upload.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScannerFragment f518a;

    public b(ScannerFragment scannerFragment) {
        this.f518a = scannerFragment;
    }

    @Override // com.socure.docv.capturesdk.common.upload.a
    public void a(EventData eventData) {
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_SF", "triggerEvent called- eventDataName: " + eventData.getEventName());
        ScannerFragment scannerFragment = this.f518a;
        String eventName = eventData.getEventName();
        Object[] array = eventData.getEventAttrList().toArray(new Pair[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Pair[] pairArr = (Pair[]) array;
        Pair<String, String>[] pairArr2 = (Pair[]) Arrays.copyOf(pairArr, pairArr.length);
        int i = ScannerFragment.C;
        scannerFragment.a(eventName, pairArr2);
    }
}
