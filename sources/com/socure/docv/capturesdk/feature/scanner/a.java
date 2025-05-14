package com.socure.docv.capturesdk.feature.scanner;

import com.socure.docv.capturesdk.core.pipeline.c;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final c f478a;

    public a(c pipeline) {
        Intrinsics.checkNotNullParameter(pipeline, "pipeline");
        this.f478a = pipeline;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0096, code lost:
    
        if (r7 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.Pair<java.util.List<com.socure.docv.capturesdk.core.processor.model.DetectionMetric>, com.socure.docv.capturesdk.feature.scanner.data.DetectionCallback> a(android.graphics.Bitmap r7) {
        /*
            r6 = this;
            java.lang.String r0 = "bitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            java.lang.String r2 = r2.getName()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Starting process on thread: "
            r3.<init>(r4)
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "SDLT_FA"
            com.socure.docv.capturesdk.common.logger.b.b(r3, r2)
            com.socure.docv.capturesdk.core.pipeline.c r2 = r6.f478a
            com.socure.docv.capturesdk.core.pipeline.model.CaptureType r4 = com.socure.docv.capturesdk.core.pipeline.model.CaptureType.AUTO_ANALYSIS
            com.socure.docv.capturesdk.core.processor.model.Output r2 = r2.a(r7, r4)
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "totalTimeTaken: "
            r0.<init>(r1)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.socure.docv.capturesdk.common.logger.b.b(r3, r0)
            r7.recycle()
            boolean r7 = r2.getFinalStatus()
            if (r7 == 0) goto L55
            java.lang.String r7 = "output.finalStatus is success - going for auto capture"
            com.socure.docv.capturesdk.common.logger.b.c(r3, r7)
            com.socure.docv.capturesdk.feature.scanner.data.DetectionCallback r7 = com.socure.docv.capturesdk.feature.scanner.data.DetectionCallback.CAPTURING
            goto L9f
        L55:
            java.lang.String r7 = "status failed, sending not processing"
            r0 = 4
            r1 = 0
            com.socure.docv.capturesdk.common.logger.b.a(r3, r7, r1, r0, r1)
            java.util.List r7 = r2.getMetrics()
            java.util.Iterator r7 = r7.iterator()
        L64:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L7a
            java.lang.Object r0 = r7.next()
            r4 = r0
            com.socure.docv.capturesdk.core.processor.model.DetectionMetric r4 = (com.socure.docv.capturesdk.core.processor.model.DetectionMetric) r4
            boolean r4 = r4.getCheckPassed()
            r4 = r4 ^ 1
            if (r4 == 0) goto L64
            r1 = r0
        L7a:
            com.socure.docv.capturesdk.core.processor.model.DetectionMetric r1 = (com.socure.docv.capturesdk.core.processor.model.DetectionMetric) r1
            if (r1 == 0) goto L98
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "sending specific warning for "
            r7.<init>(r0)
            java.lang.StringBuilder r7 = r7.append(r1)
            java.lang.String r7 = r7.toString()
            com.socure.docv.capturesdk.common.logger.b.b(r3, r7)
            com.socure.docv.capturesdk.common.utils.Utils r7 = com.socure.docv.capturesdk.common.utils.Utils.INSTANCE
            com.socure.docv.capturesdk.feature.scanner.data.DetectionCallback r7 = r7.getDetectionCallback$capturesdk_productionRelease(r1)
            if (r7 != 0) goto L9f
        L98:
            java.lang.String r7 = "sending generic warning"
            com.socure.docv.capturesdk.common.logger.b.b(r3, r7)
            com.socure.docv.capturesdk.feature.scanner.data.DetectionCallback r7 = com.socure.docv.capturesdk.feature.scanner.data.DetectionCallback.NOT_PROCESSING
        L9f:
            kotlin.Pair r0 = new kotlin.Pair
            java.util.List r1 = r2.getMetrics()
            java.util.List r1 = kotlin.collections.CollectionsKt.toList(r1)
            r0.<init>(r1, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socure.docv.capturesdk.feature.scanner.a.a(android.graphics.Bitmap):kotlin.Pair");
    }
}
