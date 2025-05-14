package com.socure.docv.capturesdk.common.stepup;

import com.socure.docv.capturesdk.common.network.model.ApiType;
import com.socure.docv.capturesdk.common.network.model.stepup.StartUploadData;
import com.socure.docv.capturesdk.common.network.model.stepup.StartUploadResponse;
import com.socure.docv.capturesdk.common.utils.ExtensionsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes5.dex */
public final class e implements Callback<StartUploadResponse> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f308a;

    public e(i iVar) {
        this.f308a = iVar;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<StartUploadResponse> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        if (call.isCanceled()) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "onFailure apiType: " + ApiType.START_UPLOAD + " cancelled");
        } else {
            i iVar = this.f308a;
            i.a(iVar, iVar.a(ApiType.START_UPLOAD, t));
        }
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<StartUploadResponse> call, Response<StartUploadResponse> response) {
        Unit unit;
        StartUploadData data;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (!response.isSuccessful()) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "startUploadResponse is not successful");
            i.a(this.f308a, ExtensionsKt.toApiResponse(response, ApiType.START_UPLOAD));
            return;
        }
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "startUploadResponse is successful");
        StartUploadResponse body = response.body();
        if (body == null || (data = body.getData()) == null) {
            unit = null;
        } else {
            i iVar = this.f308a;
            iVar.e.put(ApiType.START_UPLOAD, data);
            i.a(iVar);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            i iVar2 = this.f308a;
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_SUT", "configResponse app is null");
            i.a(iVar2, ExtensionsKt.toUnKnownApiResponse(ApiType.START_UPLOAD));
        }
        i.a(this.f308a);
    }
}
