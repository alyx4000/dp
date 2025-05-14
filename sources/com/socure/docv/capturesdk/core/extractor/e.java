package com.socure.docv.capturesdk.core.extractor;

import android.graphics.Bitmap;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import com.socure.docv.capturesdk.core.processor.model.DetectionMetric;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final ScanType f366a;
    public final Bitmap b;
    public final List<DetectionMetric> c;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f367a;

        static {
            int[] iArr = new int[ScanType.values().length];
            iArr[ScanType.LICENSE_FRONT.ordinal()] = 1;
            iArr[ScanType.LICENSE_BACK.ordinal()] = 2;
            iArr[ScanType.PASSPORT.ordinal()] = 3;
            iArr[ScanType.SELFIE.ordinal()] = 4;
            f367a = iArr;
        }
    }

    public e(ScanType scanType, Bitmap finalBitmap, List<DetectionMetric> metrics) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(finalBitmap, "finalBitmap");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        this.f366a = scanType;
        this.b = finalBitmap;
        this.c = metrics;
    }
}
