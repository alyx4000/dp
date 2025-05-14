package com.quantummetric.ui.internal;

import com.quantummetric.ui.QuantumMetric;
import com.quantummetric.ui.internal.bk;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSource;

/* loaded from: classes5.dex */
public final class bn implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    private static bn f124a;

    private bn() {
    }

    public static bn a() {
        if (f124a == null) {
            f124a = new bn();
        }
        return f124a;
    }

    private static Buffer a(Response response, boolean z) {
        if (response.body() == null || z) {
            return null;
        }
        try {
            BufferedSource bodySource = response.body().getBodySource();
            bodySource.request(2147483647L);
            return bodySource.getBufferField().clone();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        Object obj;
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        if (bk.a(proceed.headers().toMultimap().get(ApiConstant.HEADER_CONTENT_TYPE))) {
            z = true;
            obj = bk.a(bk.a.c);
        } else {
            z = false;
            obj = proceed;
        }
        if (QuantumMetric.b != null && QuantumMetric.f9a != null) {
            try {
                if (de.l().a(request.url().getUrl())) {
                    bk.a(bk.a(request.url().getUrl(), request.method(), proceed.receivedResponseAtMillis() - proceed.sentRequestAtMillis(), proceed.sentRequestAtMillis(), proceed.code(), request, obj, a(proceed, z), request.headers().toMultimap(), proceed.headers().toMultimap()));
                }
            } catch (Exception unused) {
            }
        }
        return proceed;
    }
}
