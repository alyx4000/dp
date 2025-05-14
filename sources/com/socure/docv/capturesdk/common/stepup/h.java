package com.socure.docv.capturesdk.common.stepup;

import com.socure.docv.capturesdk.common.network.model.ApiType;
import com.socure.docv.capturesdk.common.network.model.stepup.Consent;
import com.socure.docv.capturesdk.common.network.model.stepup.ConsentGetResponse;
import com.socure.docv.capturesdk.common.utils.ExtensionsKt;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes5.dex */
public final class h implements Callback<ConsentGetResponse> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f311a;

    public h(i iVar) {
        this.f311a = iVar;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<ConsentGetResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        if (call.isCanceled()) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "onFailure apiType: " + ApiType.FETCH_CONSENT + " cancelled");
        } else {
            i iVar = this.f311a;
            i.a(iVar, iVar.a(ApiType.FETCH_CONSENT, t));
        }
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<ConsentGetResponse> call, Response<ConsentGetResponse> consentResponse) {
        i iVar;
        ApiResponse apiResponse;
        Unit unit;
        Consent data;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(consentResponse, "consentResponse");
        if (consentResponse.isSuccessful()) {
            ConsentGetResponse body = consentResponse.body();
            if (body == null || (data = body.getData()) == null) {
                unit = null;
            } else {
                i iVar2 = this.f311a;
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "consentResponse is successful");
                if (UtilsKt.consentValidated(data)) {
                    iVar2.e.put(ApiType.FETCH_CONSENT, data);
                    i.a(iVar2);
                } else {
                    i.a(iVar2, iVar2.a(ApiType.FETCH_CONSENT, new Exception("Consent data is invalid")));
                }
                unit = Unit.INSTANCE;
            }
            if (unit != null) {
                return;
            }
            iVar = this.f311a;
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "consentResponse data is null");
            apiResponse = ExtensionsKt.toUnKnownApiResponse(ApiType.FETCH_CONSENT);
        } else {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "fetchConsent is not successful");
            iVar = this.f311a;
            apiResponse = ExtensionsKt.toApiResponse(consentResponse, ApiType.FETCH_CONSENT);
        }
        i.a(iVar, apiResponse);
    }
}
