package sdk.pendo.io.network.responses.converters.gson;

import external.sdk.pendo.io.gson.Gson;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.q0.a;
import sdk.pendo.io.w2.c0;
import sdk.pendo.io.w2.e0;
import sdk.pendo.io.y6.f;
import sdk.pendo.io.y6.s;

/* loaded from: classes6.dex */
public final class PendoGsonConverterFactory extends f.a {
    private final Gson mGson;

    private PendoGsonConverterFactory(Gson gson) {
        if (gson == null) {
            throw new NullPointerException("gson == null");
        }
        this.mGson = gson;
    }

    public static PendoGsonConverterFactory create() {
        return create(PendoInternal.l);
    }

    @Override // sdk.pendo.io.y6.f.a
    public f<?, c0> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
        return new PendoGsonRequestBodyConverter(this.mGson, this.mGson.a(a.a(type)));
    }

    @Override // sdk.pendo.io.y6.f.a
    public f<e0, ?> responseBodyConverter(Type type, Annotation[] annotationArr, s sVar) {
        return new PendoGsonResponseBodyConverter(this.mGson.a(a.a(type)), type);
    }

    public static PendoGsonConverterFactory create(Gson gson) {
        return new PendoGsonConverterFactory(gson);
    }
}
