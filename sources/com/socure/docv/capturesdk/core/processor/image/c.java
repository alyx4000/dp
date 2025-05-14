package com.socure.docv.capturesdk.core.processor.image;

import android.graphics.Bitmap;
import androidx.core.view.PointerIconCompat;
import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import com.socure.docv.capturesdk.core.processor.model.DetectionMetric;
import com.socure.docv.capturesdk.core.processor.model.DetectionType;
import com.socure.docv.capturesdk.core.processor.model.IResult;
import com.socure.docv.capturesdk.core.processor.model.ProcessOutput;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c implements com.socure.docv.capturesdk.core.processor.interfaces.b {

    /* renamed from: a, reason: collision with root package name */
    public com.socure.docv.capturesdk.core.processor.interfaces.a f389a;

    @Override // com.socure.docv.capturesdk.core.processor.interfaces.b
    public IResult a(Bitmap bitmap, CaptureType captureType) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(captureType, "captureType");
        com.socure.docv.capturesdk.core.external.opencv.impl.a aVar = new com.socure.docv.capturesdk.core.external.opencv.impl.a();
        this.f389a = aVar;
        double b = aVar.b(bitmap);
        return new ProcessOutput(new DetectionMetric(DetectionType.BRIGHTNESS, b >= 0.5d, Double.valueOf(b), null, null, 0.0f, null, null, null, null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null), null, null, 6, null);
    }

    @Override // com.socure.docv.capturesdk.core.processor.interfaces.b
    public void a() {
        com.socure.docv.capturesdk.core.processor.interfaces.a aVar = this.f389a;
        if (aVar != null) {
            aVar.a();
        }
    }
}
