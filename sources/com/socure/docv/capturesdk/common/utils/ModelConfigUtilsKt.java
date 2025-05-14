package com.socure.docv.capturesdk.common.utils;

import com.socure.docv.capturesdk.common.config.model.ModelConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"numberOfBuffers", "", "Lcom/socure/docv/capturesdk/common/config/model/ModelConfig$Type;", "getNumberOfBuffers", "(Lcom/socure/docv/capturesdk/common/config/model/ModelConfig$Type;)I", "capturesdk_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModelConfigUtilsKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ModelConfig.Type.values().length];
            iArr[ModelConfig.Type.BLUR.ordinal()] = 1;
            iArr[ModelConfig.Type.CORNER.ordinal()] = 2;
            iArr[ModelConfig.Type.GLARE.ordinal()] = 3;
            iArr[ModelConfig.Type.GLARE_INTENSITY.ordinal()] = 4;
            iArr[ModelConfig.Type.UNKNOWN.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int getNumberOfBuffers(ModelConfig.Type type) {
        Intrinsics.checkNotNullParameter(type, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2 || i == 3) {
            return 2;
        }
        if (i == 4 || i == 5) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }
}
