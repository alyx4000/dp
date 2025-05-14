package com.socure.docv.capturesdk.common.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"outputFeature0AsTensorBufferArray", "", "Lcom/socure/docv/capturesdk/common/utils/ModelOutputs;", "getOutputFeature0AsTensorBufferArray", "(Lcom/socure/docv/capturesdk/common/utils/ModelOutputs;)[F", "outputFeature1AsTensorBufferArray", "getOutputFeature1AsTensorBufferArray", "capturesdk_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TensorFlowModelUtilsKt {
    public static final float[] getOutputFeature0AsTensorBufferArray(ModelOutputs modelOutputs) {
        Intrinsics.checkNotNullParameter(modelOutputs, "<this>");
        TensorBuffer tensorBuffer = modelOutputs.getTensorBuffers().get(0);
        float[] floatArray = tensorBuffer != null ? tensorBuffer.getFloatArray() : null;
        return floatArray == null ? NumberUtilsKt.floatArrayOf(new double[0]) : floatArray;
    }

    public static final float[] getOutputFeature1AsTensorBufferArray(ModelOutputs modelOutputs) {
        Intrinsics.checkNotNullParameter(modelOutputs, "<this>");
        TensorBuffer tensorBuffer = modelOutputs.getTensorBuffers().get(1);
        float[] floatArray = tensorBuffer != null ? tensorBuffer.getFloatArray() : null;
        return floatArray == null ? NumberUtilsKt.floatArrayOf(new double[0]) : floatArray;
    }
}
