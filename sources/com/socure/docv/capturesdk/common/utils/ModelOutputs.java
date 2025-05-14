package com.socure.docv.capturesdk.common.utils;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.model.Model;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/socure/docv/capturesdk/common/utils/ModelOutputs;", "", "model", "Lorg/tensorflow/lite/support/model/Model;", "numberOfBuffers", "", "(Lorg/tensorflow/lite/support/model/Model;I)V", "buffer", "", "Ljava/nio/ByteBuffer;", "getBuffer", "()Ljava/util/Map;", "tensorBuffers", "Lorg/tensorflow/lite/support/tensorbuffer/TensorBuffer;", "getTensorBuffers", "outputFeatureAsTensorBuffer", "index", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModelOutputs {
    private final Model model;
    private final int numberOfBuffers;
    private final Map<Integer, TensorBuffer> tensorBuffers;

    public ModelOutputs(Model model, int i) {
        Intrinsics.checkNotNullParameter(model, "model");
        this.model = model;
        this.numberOfBuffers = i;
        HashMap hashMap = new HashMap();
        Iterator<Integer> it = RangesKt.until(0, i).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            hashMap.put(Integer.valueOf(nextInt), outputFeatureAsTensorBuffer(nextInt));
        }
        this.tensorBuffers = hashMap;
    }

    private final TensorBuffer outputFeatureAsTensorBuffer(int index) {
        TensorBuffer createFixedSize = TensorBuffer.createFixedSize(this.model.getOutputTensorShape(index), DataType.FLOAT32);
        Intrinsics.checkNotNullExpressionValue(createFixedSize, "createFixedSize(model.ge…index), DataType.FLOAT32)");
        return createFixedSize;
    }

    public final Map<Integer, ByteBuffer> getBuffer() {
        Map<Integer, TensorBuffer> map = this.tensorBuffers;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), ((TensorBuffer) entry.getValue()).getBuffer());
        }
        return linkedHashMap;
    }

    public final Map<Integer, TensorBuffer> getTensorBuffers() {
        return this.tensorBuffers;
    }
}
