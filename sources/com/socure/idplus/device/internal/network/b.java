package com.socure.idplus.device.internal.network;

import com.socure.docv.capturesdk.common.utils.ApiConstant;
import io.sentry.Session;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes5.dex */
public final class b implements Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f581a;
    public final /* synthetic */ Function1 b;

    public b(Function1 function1, Function1 function12) {
        this.f581a = function1;
        this.b = function12;
    }

    @Override // retrofit2.Callback
    public final void onFailure(Call call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        this.b.invoke(new a(null, null, t.getMessage()));
    }

    @Override // retrofit2.Callback
    public final void onResponse(Call call, Response response) {
        a aVar;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        Object body = response.body();
        if (response.isSuccessful() && body != null) {
            this.f581a.invoke(body);
            return;
        }
        ResponseBody errorBody = response.errorBody();
        if (errorBody != null) {
            try {
                JSONArray jSONArray = new JSONObject(errorBody.string()).getJSONArray(Session.JsonKeys.ERRORS);
                aVar = new a(Integer.valueOf(response.code()), jSONArray.getJSONObject(0).get(ApiConstant.KEY_CODE).toString(), jSONArray.getJSONObject(0).get("description").toString());
            } catch (JSONException e) {
                com.socure.idplus.device.internal.common.utils.a.a("DataHandler", "Cannot parse error response");
                aVar = new a(null, null, e.getMessage());
            } catch (Exception e2) {
                com.socure.idplus.device.internal.common.utils.a.a("DataHandler", "Encountered error when parsing request");
                aVar = new a(null, null, e2.getMessage());
            }
        } else {
            aVar = null;
        }
        if (aVar == null) {
            this.b.invoke(new a(Integer.valueOf(response.code()), null, null));
        } else {
            this.b.invoke(aVar);
        }
    }
}
