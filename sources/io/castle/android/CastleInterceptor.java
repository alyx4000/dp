package io.castle.android;

import java.io.IOException;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes2.dex */
class CastleInterceptor implements Interceptor {
    CastleInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (Castle.isUrlAllowlisted(request.url().getUrl())) {
            Request.Builder newBuilder = request.newBuilder();
            for (Map.Entry<String, String> entry : Castle.headers(chain.request().url().getUrl()).entrySet()) {
                newBuilder.addHeader(entry.getKey(), entry.getValue());
            }
            request = newBuilder.build();
            Castle.flush();
        }
        return chain.proceed(request);
    }
}
