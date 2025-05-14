package com.socure.docv.capturesdk.common.utils;

import com.socure.docv.capturesdk.common.config.model.Model;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"process", "Lcom/socure/docv/capturesdk/common/utils/ModelOutputs;", "Lcom/socure/docv/capturesdk/common/config/model/Model;", "tensorBuffer", "Lorg/tensorflow/lite/support/tensorbuffer/TensorBuffer;", "capturesdk_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModelUtilsKt {
    public static final ModelOutputs process(Model model, TensorBuffer tensorBuffer) {
        Intrinsics.checkNotNullParameter(model, "<this>");
        Intrinsics.checkNotNullParameter(tensorBuffer, "tensorBuffer");
        ModelOutputs modelOutputs = new ModelOutputs(model.getModel(), model.getNumOfBuffers());
        model.getModel().run(new ByteBuffer[]{tensorBuffer.getBuffer()}, modelOutputs.getBuffer());
        return modelOutputs;
    }
}
