package com.socure.docv.capturesdk.core.external.ml.impl;

import android.graphics.Bitmap;
import com.socure.docv.capturesdk.common.config.model.Model;
import com.socure.docv.capturesdk.common.utils.ImageUtils;
import com.socure.docv.capturesdk.common.utils.ModelOutputs;
import com.socure.docv.capturesdk.common.utils.ModelUtilsKt;
import com.socure.docv.capturesdk.common.utils.TensorFlowModelUtilsKt;
import com.socure.docv.capturesdk.common.utils.Utils;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

/* loaded from: classes5.dex */
public final class b implements com.socure.docv.capturesdk.core.processor.interfaces.a {

    /* renamed from: a, reason: collision with root package name */
    public final Model f360a;

    public b(com.socure.docv.capturesdk.di.c dependencyGraph) {
        Intrinsics.checkNotNullParameter(dependencyGraph, "dependencyGraph");
        this.f360a = dependencyGraph.a().a();
    }

    @Override // com.socure.docv.capturesdk.core.processor.interfaces.a
    public void a() {
        this.f360a.getModel().close();
    }

    @Override // com.socure.docv.capturesdk.core.processor.interfaces.a
    public float[] a(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        boolean z = true;
        TensorBuffer createFixedSize = TensorBuffer.createFixedSize(new int[]{1, 3, 256, 256}, DataType.FLOAT32);
        Intrinsics.checkNotNullExpressionValue(createFixedSize, "createFixedSize(intArray….H_CD), DataType.FLOAT32)");
        createFixedSize.loadBuffer(ImageUtils.INSTANCE.bitmapToByteBufferIdd(bitmap));
        try {
            ModelOutputs process = ModelUtilsKt.process(this.f360a, createFixedSize);
            float[] outputFeature0AsTensorBufferArray = TensorFlowModelUtilsKt.getOutputFeature0AsTensorBufferArray(process);
            float[] outputFeature1AsTensorBufferArray = TensorFlowModelUtilsKt.getOutputFeature1AsTensorBufferArray(process);
            if (outputFeature0AsTensorBufferArray.length == 1 && outputFeature1AsTensorBufferArray.length == 12) {
                com.socure.docv.capturesdk.common.logger.b.b("SDLT_CD_ML", "horizontal object detected with confidence: " + ArraysKt.joinToString$default(outputFeature0AsTensorBufferArray, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + " | and four corners found: " + ArraysKt.joinToString$default(outputFeature1AsTensorBufferArray, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
                return Utils.INSTANCE.appendResultAndHorizontalConf$capturesdk_productionRelease(outputFeature1AsTensorBufferArray, outputFeature0AsTensorBufferArray[0]);
            }
            boolean z2 = outputFeature0AsTensorBufferArray.length == 0;
            String joinToString$default = ArraysKt.joinToString$default(outputFeature0AsTensorBufferArray, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
            if (outputFeature0AsTensorBufferArray[0] >= this.f360a.getConfidence() || !Utils.INSTANCE.cornersFound$capturesdk_productionRelease(outputFeature1AsTensorBufferArray)) {
                z = false;
            }
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_CD_ML", "horizontal object not detected: " + z2 + " - (" + joinToString$default + ") || four corners not found: " + z + " - (" + ArraysKt.joinToString$default(outputFeature1AsTensorBufferArray, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + ")", null, 4, null);
            return null;
        } catch (Throwable th) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_CD_ML", "Ex trying to detect corners: " + th.getLocalizedMessage(), null, 4, null);
            return null;
        }
    }
}
