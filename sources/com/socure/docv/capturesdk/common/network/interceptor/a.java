package com.socure.docv.capturesdk.common.network.interceptor;

import com.socure.docv.capturesdk.common.utils.ApiConstant;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;

/* loaded from: classes5.dex */
public final class a implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return chain.proceed(chain.request().newBuilder().addHeader(ApiConstant.HEADER_CONTENT_TYPE, ApiConstant.HEADER_CONTENT_TYPE_VALUE).addHeader("User-Agent", ApiConstant.USER_AGENT_VALUE).addHeader(ApiConstant.HEADER_CLIENT_NAME, ApiConstant.CLIENT_NAME).addHeader(ApiConstant.HEADER_CLIENT_VERSION, "4.3.0").build());
    }
}
