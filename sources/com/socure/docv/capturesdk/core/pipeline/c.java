package com.socure.docv.capturesdk.core.pipeline;

import android.graphics.Bitmap;
import android.util.Log;
import com.socure.docv.capturesdk.common.utils.ConstantsKt;
import com.socure.docv.capturesdk.common.utils.Utils;
import com.socure.docv.capturesdk.core.pipeline.d;
import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import com.socure.docv.capturesdk.core.processor.model.DetectionType;
import com.socure.docv.capturesdk.core.processor.model.Output;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final ScanType f379a;
    public final DetectionType[] b;
    public final DetectionType[] c;
    public d d;
    public final Lazy e;
    public final Lazy f;

    public static final class a extends Lambda implements Function0<com.socure.docv.capturesdk.core.pipeline.a> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public com.socure.docv.capturesdk.core.pipeline.a invoke() {
            c cVar = c.this;
            return new com.socure.docv.capturesdk.core.pipeline.a(cVar.f379a, cVar.d, cVar.b);
        }
    }

    public static final class b extends Lambda implements Function0<com.socure.docv.capturesdk.core.pipeline.b> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public com.socure.docv.capturesdk.core.pipeline.b invoke() {
            c cVar = c.this;
            return new com.socure.docv.capturesdk.core.pipeline.b(cVar.f379a, cVar.d, cVar.c);
        }
    }

    public c(com.socure.docv.capturesdk.di.c dependencyGraph, ScanType scanType, com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.a dic) {
        Intrinsics.checkNotNullParameter(dependencyGraph, "dependencyGraph");
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(dic, "dic");
        this.f379a = scanType;
        Utils utils = Utils.INSTANCE;
        DetectionType[] detectionTypeArr = utils.isSelfie$capturesdk_productionRelease(scanType) ? new DetectionType[]{DetectionType.SELFIE} : scanType == ScanType.LICENSE_BACK ? new DetectionType[]{DetectionType.CORNER, DetectionType.BARCODE, DetectionType.BRIGHTNESS, DetectionType.BLUR, DetectionType.GLARE} : new DetectionType[]{DetectionType.CORNER, DetectionType.BRIGHTNESS, DetectionType.BLUR, DetectionType.GLARE};
        this.b = detectionTypeArr;
        DetectionType[] detectionTypeArr2 = utils.isSelfie$capturesdk_productionRelease(scanType) ? new DetectionType[]{DetectionType.SELFIE} : ConstantsKt.getOPEN_CV_SUPPORTED() ? new DetectionType[]{DetectionType.BRIGHTNESS, DetectionType.BLUR, DetectionType.GLARE} : new DetectionType[]{DetectionType.BLUR, DetectionType.GLARE};
        this.c = detectionTypeArr2;
        DetectionType[] superSetSteps$capturesdk_productionRelease = utils.getSuperSetSteps$capturesdk_productionRelease(detectionTypeArr, detectionTypeArr2);
        this.d = new d.a(dependencyGraph, scanType).a((DetectionType[]) Arrays.copyOf(superSetSteps$capturesdk_productionRelease, superSetSteps$capturesdk_productionRelease.length)).a(dic).a();
        this.e = LazyKt.lazy(new b());
        this.f = LazyKt.lazy(new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [android.graphics.Bitmap, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v4, types: [com.socure.docv.capturesdk.core.processor.model.Output] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    public final Output a(Bitmap bitmap, CaptureType captureType) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(captureType, "captureType");
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_PLM", "process captureType: " + captureType.getValue());
        try {
            bitmap = captureType == CaptureType.MANUAL ? ((com.socure.docv.capturesdk.core.pipeline.b) this.e.getValue()).a(bitmap, captureType) : ((com.socure.docv.capturesdk.core.pipeline.a) this.f.getValue()).a(bitmap, captureType);
            return bitmap;
        } catch (Throwable th) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_PLM", "!!!FATAL EXCEPTION WAS CAUGHT: " + th.getLocalizedMessage(), null, 4, null);
            com.socure.docv.capturesdk.common.logger.b.b("SDLT_PLM", "Stacktrace: " + Log.getStackTraceString(th));
            return new Output(bitmap, captureType, null, false, null, null, 60, null);
        }
    }

    public final void a(boolean z) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_PLM", "updateAutoPipelineForLicenceBack called - skipBarcode: " + z + " ");
        ((com.socure.docv.capturesdk.core.pipeline.a) this.f.getValue()).d = z;
    }
}
