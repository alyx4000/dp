package com.socure.docv.capturesdk.common.utils;

import com.socure.docv.capturesdk.common.config.model.Model;
import com.socure.docv.capturesdk.common.config.model.ModelConfig;
import com.socure.docv.capturesdk.core.provider.interfaces.d;
import com.socure.docv.capturesdk.core.storage.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001aJ\u0010\n\u001a\u00020\t*2\u0012\u0004\u0012\u00020\u0001\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0005\u001aJ\u0010\n\u001a\u00020\t*2\u0012\u0004\u0012\u00020\u0001\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0004\u001aB\u0010\f\u001a\u00020\u0005*2\u0012\u0004\u0012\u00020\u0001\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0001*j\u0010\r\"2\u0012\u0004\u0012\u00020\u0001\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00020\u000022\u0012\u0004\u0012\u00020\u0001\u0012(\u0012&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u00020\u0000¨\u0006\u000e"}, d2 = {"", "Lcom/socure/docv/capturesdk/common/config/model/ModelConfig$Type;", "Lkotlin/Triple;", "Lcom/socure/docv/capturesdk/core/storage/a;", "Lcom/socure/docv/capturesdk/common/config/model/Model;", "", "Lcom/socure/docv/capturesdk/core/provider/interfaces/d;", "type", "confidence", "", "cache", "model", "getConfidence", "DynamicModelDependencies", "capturesdk_productionRelease"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class DynamicModelDependenciesUtilsKt {
    public static final void cache(Map<ModelConfig.Type, ? extends Triple<? extends a<Model>, ? extends a<Float>, ? extends d<Float>>> map, ModelConfig.Type type, float f) {
        a<Float> second;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        Triple<? extends a<Model>, ? extends a<Float>, ? extends d<Float>> triple = map.get(type);
        if (triple == null || (second = triple.getSecond()) == null) {
            return;
        }
        second.a(Float.valueOf(f));
    }

    public static final void cache(Map<ModelConfig.Type, ? extends Triple<? extends a<Model>, ? extends a<Float>, ? extends d<Float>>> map, ModelConfig.Type type, Model model) {
        a<Model> first;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(model, "model");
        Triple<? extends a<Model>, ? extends a<Float>, ? extends d<Float>> triple = map.get(type);
        if (triple == null || (first = triple.getFirst()) == null) {
            return;
        }
        first.a(model);
    }

    public static final float getConfidence(Map<ModelConfig.Type, ? extends Triple<? extends a<Model>, ? extends a<Float>, ? extends d<Float>>> map, ModelConfig.Type type) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return ((Number) ((d) ((Triple) MapsKt.getValue(map, type)).getThird()).a()).floatValue();
    }
}
