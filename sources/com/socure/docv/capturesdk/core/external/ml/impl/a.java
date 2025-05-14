package com.socure.docv.capturesdk.core.external.ml.impl;

import android.graphics.Bitmap;
import com.socure.docv.capturesdk.common.config.model.Model;
import com.socure.docv.capturesdk.common.utils.ImageUtils;
import com.socure.docv.capturesdk.common.utils.ModelOutputs;
import com.socure.docv.capturesdk.common.utils.ModelUtilsKt;
import com.socure.docv.capturesdk.common.utils.TensorFlowModelUtilsKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

/* loaded from: classes5.dex */
public final class a implements com.socure.docv.capturesdk.core.processor.interfaces.a {

    /* renamed from: a, reason: collision with root package name */
    public final Model f359a;

    public a(com.socure.docv.capturesdk.di.c dependencyGraph) {
        Intrinsics.checkNotNullParameter(dependencyGraph, "dependencyGraph");
        this.f359a = dependencyGraph.d().a();
    }

    @Override // com.socure.docv.capturesdk.core.processor.interfaces.a
    public void a() {
        this.f359a.getModel().close();
    }

    @Override // com.socure.docv.capturesdk.core.processor.interfaces.a
    public float[] a(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        TensorBuffer createFixedSize = TensorBuffer.createFixedSize(new int[]{1, 3, 180, 300}, DataType.FLOAT32);
        Intrinsics.checkNotNullExpressionValue(createFixedSize, "createFixedSize(intArray….W_BD), DataType.FLOAT32)");
        createFixedSize.loadBuffer(ImageUtils.INSTANCE.convertBitmapToByteBufferBlur(bitmap, 180, 300));
        long currentTimeMillis = System.currentTimeMillis();
        ModelOutputs process = ModelUtilsKt.process(this.f359a, createFixedSize);
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_BD_ML", "BlurDetectorML - timeTaken: " + (System.currentTimeMillis() - currentTimeMillis) + " | output: [" + ArraysKt.joinToString$default(TensorFlowModelUtilsKt.getOutputFeature0AsTensorBufferArray(process), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + "]");
        return TensorFlowModelUtilsKt.getOutputFeature0AsTensorBufferArray(process);
    }
}
