package com.socure.docv.capturesdk.common.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005J\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/socure/docv/capturesdk/common/utils/HeaderUtils;", "", "()V", "getPrimaryHeader", "", "", "publicKey", "getStepHeader", "socureVerificationToken", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HeaderUtils {
    public static final HeaderUtils INSTANCE = new HeaderUtils();

    private HeaderUtils() {
    }

    public final Map<String, String> getPrimaryHeader(String publicKey) {
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Authorization", "SocureApiKey " + publicKey);
        return linkedHashMap;
    }

    public final Map<String, String> getStepHeader(String socureVerificationToken) {
        Intrinsics.checkNotNullParameter(socureVerificationToken, "socureVerificationToken");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(ApiConstant.HEADER_SOCURE_VERIFICATION_TOKEN, socureVerificationToken);
        return linkedHashMap;
    }
}
