package com.socure.docv.capturesdk.common.utils;

import com.socure.docv.capturesdk.common.logger.b;
import kotlin.Metadata;
import kotlin.Pair;
import okhttp3.ResponseBody;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"TAG", "", "getErrorSocureSdkResponseHttpInfo", "Lkotlin/Pair;", "", "errorResponseBody", "Lokhttp3/ResponseBody;", "capturesdk_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ErrorHandlerKt {
    private static final String TAG = "SDLT_ErrorHandler";

    public static final Pair<Integer, String> getErrorSocureSdkResponseHttpInfo(ResponseBody responseBody) {
        String string;
        String str = ConstantsKt.MESSAGE_NOT_AVAILABLE;
        if (responseBody != null) {
            try {
                string = responseBody.string();
            } catch (Throwable th) {
                String localizedMessage = th.getLocalizedMessage();
                if (localizedMessage != null) {
                    str = localizedMessage;
                }
                return new Pair<>(-1, str);
            }
        } else {
            string = null;
        }
        b.b(TAG, "getErrorSocureSdkResponseHttpInfo " + string);
        if (string == null) {
            return new Pair<>(-1, ConstantsKt.MESSAGE_NOT_AVAILABLE);
        }
        JSONObject jSONObject = new JSONObject(string);
        if (!jSONObject.has("data")) {
            return new Pair<>(Integer.valueOf(jSONObject.optInt(ApiConstant.KEY_CODE, -1)), jSONObject.optString("message", jSONObject.optString("msg", ConstantsKt.MESSAGE_NOT_AVAILABLE)));
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        return new Pair<>(Integer.valueOf(jSONObject2.optInt(ApiConstant.KEY_CODE, -1)), jSONObject2.optString("message", jSONObject2.optString("msg", jSONObject.optString("msg", ConstantsKt.MESSAGE_NOT_AVAILABLE))));
    }
}
