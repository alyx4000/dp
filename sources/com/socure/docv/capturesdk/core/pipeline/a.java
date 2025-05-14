package com.socure.docv.capturesdk.core.pipeline;

import android.graphics.Bitmap;
import com.socure.docv.capturesdk.common.utils.ImageUtils;
import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import com.socure.docv.capturesdk.core.processor.model.DetectionMetric;
import com.socure.docv.capturesdk.core.processor.model.DetectionType;
import com.socure.docv.capturesdk.core.processor.model.Output;
import com.socure.docv.capturesdk.core.processor.model.ProcessOutput;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final ScanType f376a;
    public final d b;
    public final DetectionType[] c;
    public volatile boolean d;

    /* renamed from: com.socure.docv.capturesdk.core.pipeline.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0038a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f377a;

        static {
            int[] iArr = new int[DetectionType.values().length];
            iArr[DetectionType.CORNER.ordinal()] = 1;
            iArr[DetectionType.BRIGHTNESS.ordinal()] = 2;
            f377a = iArr;
        }
    }

    public a(ScanType scanType, d processorMap, DetectionType[] steps) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(processorMap, "processorMap");
        Intrinsics.checkNotNullParameter(steps, "steps");
        this.f376a = scanType;
        this.b = processorMap;
        this.c = steps;
    }

    public final Output a(Bitmap image, CaptureType captureType) {
        String value;
        String value2;
        String joinToString$default;
        StringBuilder sb;
        com.socure.docv.capturesdk.core.processor.interfaces.b bVar;
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(captureType, "captureType");
        if (captureType == CaptureType.AUTO_ANALYSIS) {
            value = this.f376a.getValue();
            value2 = captureType.getValue();
            joinToString$default = ArraysKt.joinToString$default(this.c, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
            sb = new StringBuilder("process scanType :");
        } else {
            value = this.f376a.getValue();
            value2 = captureType.getValue();
            joinToString$default = ArraysKt.joinToString$default(this.c, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
            sb = new StringBuilder("process scanType :");
        }
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_AP", sb.append(value).append(" | captureType: ").append(value2).append(" | steps: ").append(joinToString$default).toString());
        Output output = new Output(image, captureType, null, false, null, null, 60, null);
        DetectionType[] detectionTypeArr = this.c;
        int length = detectionTypeArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            DetectionType detectionType = detectionTypeArr[i];
            int i3 = i2 + 1;
            if ((!this.d || detectionType != DetectionType.BARCODE) && (bVar = this.b.f382a.get(detectionType)) != null) {
                if (captureType == CaptureType.AUTO) {
                    com.socure.docv.capturesdk.common.logger.b.b("SDLT_AP", "Going to process for " + detectionType + "}");
                }
                ProcessOutput processOutput = (ProcessOutput) bVar.a(output.getFinalBitmap(), captureType);
                output.getMetrics().add(processOutput.getMetric());
                output.setFinalStatus(i2 == 0 ? processOutput.getMetric().getCheckPassed() : output.getFinalStatus() && processOutput.getMetric().getCheckPassed());
                int i4 = C0038a.f377a[detectionType.ordinal()];
                if (i4 != 1) {
                    if (i4 != 2) {
                        com.socure.docv.capturesdk.common.logger.b.b("SDLT_AP", "process detectionType : " + detectionType.name() + " - success: " + processOutput.getMetric().getCheckPassed());
                        if (!processOutput.getMetric().getCheckPassed()) {
                            break;
                        }
                    } else if (a(output)) {
                        com.socure.docv.capturesdk.common.logger.b.a("SDLT_AP", "Aborting and returning output", null, 4, null);
                        break;
                    }
                } else {
                    if (!processOutput.getMetric().getCheckPassed() || processOutput.getBitmap() == null) {
                        break;
                    }
                    com.socure.docv.capturesdk.common.logger.b.b("SDLT_AP", "corner detected");
                    output.setFinalBitmap(processOutput.getBitmap());
                    output.setDebugBitmap(processOutput.getDebugBitmap());
                }
            }
            i++;
            i2 = i3;
        }
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_AP", "corner not detected for analysis frame");
        Bitmap debugBitmap = output.getDebugBitmap();
        if (debugBitmap != null) {
            debugBitmap.recycle();
        }
        output.setDebugBitmap(null);
        Bitmap cropDocWithPaddingIfEnabled = ImageUtils.INSTANCE.cropDocWithPaddingIfEnabled(image, captureType == CaptureType.AUTO, this.b.f382a.containsKey(DetectionType.CORNER), output.getMetrics());
        if (cropDocWithPaddingIfEnabled != null) {
            output.getFinalBitmap().recycle();
            output.setFinalBitmap(cropDocWithPaddingIfEnabled);
        }
        return output;
    }

    public final boolean a(Output output) {
        Object obj;
        Object obj2;
        Iterator<T> it = output.getMetrics().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (((DetectionMetric) obj2).getDetectionType() == DetectionType.CORNER) {
                break;
            }
        }
        DetectionMetric detectionMetric = (DetectionMetric) obj2;
        boolean checkPassed = detectionMetric != null ? detectionMetric.getCheckPassed() : false;
        Iterator<T> it2 = output.getMetrics().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (((DetectionMetric) next).getDetectionType() == DetectionType.BRIGHTNESS) {
                obj = next;
                break;
            }
        }
        DetectionMetric detectionMetric2 = (DetectionMetric) obj;
        boolean checkPassed2 = detectionMetric2 != null ? detectionMetric2.getCheckPassed() : false;
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_AP", "shouldAbort cornerPassed: " + checkPassed + " || brightnessPassed: " + checkPassed2);
        return (checkPassed && checkPassed2) ? false : true;
    }
}
