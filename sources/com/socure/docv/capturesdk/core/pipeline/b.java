package com.socure.docv.capturesdk.core.pipeline;

import android.graphics.Bitmap;
import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import com.socure.docv.capturesdk.core.processor.model.DetectionType;
import com.socure.docv.capturesdk.core.processor.model.Output;
import com.socure.docv.capturesdk.core.processor.model.ProcessOutput;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final ScanType f378a;
    public final d b;
    public final DetectionType[] c;

    public b(ScanType scanType, d processorMap, DetectionType[] steps) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(processorMap, "processorMap");
        Intrinsics.checkNotNullParameter(steps, "steps");
        this.f378a = scanType;
        this.b = processorMap;
        this.c = steps;
    }

    public final Output a(Bitmap image, CaptureType captureType) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(captureType, "captureType");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_MCP", "process scanType :" + this.f378a.getValue() + " || steps: " + ArraysKt.joinToString$default(this.c, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
        Output output = new Output(image, captureType, null, false, null, null, 60, null);
        for (DetectionType detectionType : this.c) {
            com.socure.docv.capturesdk.core.processor.interfaces.b bVar = this.b.f382a.get(detectionType);
            if (bVar != null) {
                output.getMetrics().add(((ProcessOutput) bVar.a(output.getFinalBitmap(), captureType)).getMetric());
            }
        }
        return output;
    }
}
