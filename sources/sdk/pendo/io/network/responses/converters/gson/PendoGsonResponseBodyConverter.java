package sdk.pendo.io.network.responses.converters.gson;

import external.sdk.pendo.io.gson.TypeAdapter;
import external.sdk.pendo.io.jose4j.jwt.consumer.c;
import io.sentry.Session;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Scanner;
import sdk.pendo.io.g9.d;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.InitModel;
import sdk.pendo.io.network.responses.validators.JsonWebTokenValidator;
import sdk.pendo.io.q0.a;
import sdk.pendo.io.w2.e0;
import sdk.pendo.io.y6.f;

/* loaded from: classes6.dex */
final class PendoGsonResponseBodyConverter<T> implements f<e0, T> {
    private static final String TAG = "PendoGsonResponseBodyConverter";
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private final TypeAdapter<T> mAdapter;
    private final Type mType;

    PendoGsonResponseBodyConverter(TypeAdapter<T> typeAdapter, Type type) {
        this.mAdapter = typeAdapter;
        this.mType = type;
    }

    private T validateAndParseResponse(String str, boolean z) {
        try {
            return this.mAdapter.a(JsonWebTokenValidator.INSTANCE.validate(str));
        } catch (c e) {
            PendoLogger.d(e, TAG + " ->" + e.getMessage(), new Object[0]);
            if (!z) {
                return null;
            }
            d.a(str, Session.JsonKeys.INIT, e.getMessage());
            return null;
        }
    }

    @Override // sdk.pendo.io.y6.f
    public T convert(e0 e0Var) {
        Throwable th;
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(e0Var.a(), UTF8);
        } catch (Throwable th2) {
            th = th2;
            inputStreamReader = null;
        }
        try {
            Scanner useDelimiter = new Scanner(inputStreamReader).useDelimiter("\\A");
            String next = useDelimiter.hasNext() ? useDelimiter.next() : "";
            Type type = this.mType;
            T validateAndParseResponse = validateAndParseResponse(next, type != null ? a.a(type).a().equals(InitModel.class) : false);
            try {
                inputStreamReader.close();
            } catch (IOException unused) {
            }
            e0Var.close();
            return validateAndParseResponse;
        } catch (Throwable th3) {
            th = th3;
            try {
                PendoLogger.d(th, TAG + " ->" + th.getMessage(), new Object[0]);
                return null;
            } finally {
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException unused2) {
                    }
                }
                e0Var.close();
            }
        }
    }
}
