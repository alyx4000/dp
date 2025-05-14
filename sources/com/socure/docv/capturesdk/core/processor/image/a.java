package com.socure.docv.capturesdk.core.processor.image;

import android.graphics.Bitmap;
import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import com.socure.docv.capturesdk.core.processor.model.DetectionMetric;
import com.socure.docv.capturesdk.core.processor.model.DetectionType;
import com.socure.docv.capturesdk.core.processor.model.IResult;
import com.socure.docv.capturesdk.core.processor.model.ProcessOutput;
import com.socure.docv.capturesdk.feature.scanner.data.DetectionCallback;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a implements com.socure.docv.capturesdk.core.processor.interfaces.b {

    /* renamed from: a, reason: collision with root package name */
    public final com.socure.docv.capturesdk.core.extractor.a f387a = new com.socure.docv.capturesdk.core.extractor.a();

    @Override // com.socure.docv.capturesdk.core.processor.interfaces.b
    public IResult a(Bitmap bitmap, CaptureType captureType) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(captureType, "captureType");
        Pair<com.socure.docv.capturesdk.core.extractor.model.b, Boolean> a2 = this.f387a.a(bitmap, 500L);
        return new ProcessOutput(new DetectionMetric(DetectionType.BARCODE, a2.getSecond().booleanValue(), null, null, null, 0.0f, null, a2.getSecond().booleanValue() ? null : DetectionCallback.BARCODE_NOT_FOUND, null, null, 892, null), null, null, 6, null);
    }

    @Override // com.socure.docv.capturesdk.core.processor.interfaces.b
    public void a() {
        this.f387a.f363a.close();
    }
}
