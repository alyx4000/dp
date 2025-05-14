package io.castle.android.api;

import io.castle.android.Castle;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* loaded from: classes2.dex */
class CastleAuthenticationInterceptor implements Interceptor {
    CastleAuthenticationInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder().header("X-Castle-Publishable-Api-Key", Castle.publishableKey()).header(Castle.requestTokenHeaderName, Castle.createRequestToken()).header("User-Agent", Castle.userAgent()).build());
    }
}
