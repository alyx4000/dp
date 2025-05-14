package com.socure.docv.capturesdk.feature.preview.helper;

import android.content.Context;
import android.graphics.Bitmap;
import com.socure.docv.capturesdk.common.logger.b;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import com.socure.docv.capturesdk.core.processor.model.DetectionMetric;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f455a;
    public final ScanType b;
    public final List<DetectionMetric> c;
    public final String d;

    public a(Context context, ScanType scanType, List<DetectionMetric> metrics) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        this.f455a = context;
        this.b = scanType;
        this.c = metrics;
        this.d = "dbg_images";
    }

    public final void a() {
        boolean z;
        com.socure.docv.capturesdk.common.workers.a aVar = new com.socure.docv.capturesdk.common.workers.a(this.f455a, this.d);
        loop0: while (true) {
            for (DetectionMetric detectionMetric : this.c) {
                z = z || aVar.a(detectionMetric.getModelInputImage(), this.b.name() + "_" + detectionMetric.getDetectionType().name() + ".jpg");
            }
        }
        if (z) {
            File externalFilesDir = this.f455a.getExternalFilesDir(this.d);
            b.c("SDLT_DIE", "Files written to disk (" + (externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null) + "), please copy it elsewhere before next scan session as they will be cleaned up.");
        } else {
            b.a("SDLT_DIE", "No image was saved to disk - either done already and cleared, or images not available.", null, 4, null);
        }
        b.b("SDLT_DIE", "Recycling bitmaps and setting them to null");
        for (DetectionMetric detectionMetric2 : this.c) {
            Bitmap modelInputImage = detectionMetric2.getModelInputImage();
            if (modelInputImage != null) {
                modelInputImage.recycle();
            }
            detectionMetric2.setModelInputImage(null);
        }
    }
}
