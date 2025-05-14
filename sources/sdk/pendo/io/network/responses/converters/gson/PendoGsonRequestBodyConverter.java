package sdk.pendo.io.network.responses.converters.gson;

import com.socure.docv.capturesdk.common.utils.ApiConstant;
import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import sdk.pendo.io.k3.d;
import sdk.pendo.io.r0.c;
import sdk.pendo.io.w2.c0;
import sdk.pendo.io.w2.x;
import sdk.pendo.io.y6.f;

/* loaded from: classes6.dex */
public final class PendoGsonRequestBodyConverter<T> implements f<T, c0> {
    public static final x JSON_MEDIA_TYPE = x.c(ApiConstant.HEADER_CONTENT_TYPE_VALUE);
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    private final TypeAdapter<T> mAdapter;
    private final Gson mGson;

    public PendoGsonRequestBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.mGson = gson;
        this.mAdapter = typeAdapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // sdk.pendo.io.y6.f
    public /* bridge */ /* synthetic */ c0 convert(Object obj) {
        return convert2((PendoGsonRequestBodyConverter<T>) obj);
    }

    @Override // sdk.pendo.io.y6.f
    /* renamed from: convert, reason: avoid collision after fix types in other method */
    public c0 convert2(T t) {
        d dVar = new d();
        c a2 = this.mGson.a(new OutputStreamWriter(dVar.s(), UTF_8));
        this.mAdapter.a(a2, t);
        a2.close();
        return c0.a(JSON_MEDIA_TYPE, dVar.t());
    }
}
