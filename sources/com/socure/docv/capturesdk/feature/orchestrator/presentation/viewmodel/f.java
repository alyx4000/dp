package com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.socure.docv.capturesdk.api.DocumentType;
import com.socure.docv.capturesdk.api.ResponseCode;
import com.socure.docv.capturesdk.common.analytics.model.MetricCaptureData;
import com.socure.docv.capturesdk.common.analytics.model.MetricData;
import com.socure.docv.capturesdk.common.config.model.FragNavActions;
import com.socure.docv.capturesdk.common.network.model.stepup.ConsentPostRequest;
import com.socure.docv.capturesdk.common.network.model.stepup.UploadImage;
import com.socure.docv.capturesdk.common.utils.Screen;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import com.socure.docv.capturesdk.feature.orchestrator.data.Config;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.SharedFlow;

/* loaded from: classes5.dex */
public final class f extends ViewModel implements b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f454a;

    public f(b delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f454a = delegate;
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public FragNavActions a(com.socure.docv.capturesdk.common.view.model.c screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        return this.f454a.a(screen);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public LinkedHashMap<ScanType, UploadImage> a() {
        return this.f454a.a();
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(DocumentType documentType) {
        this.f454a.a(documentType);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(ResponseCode responseCode) {
        Intrinsics.checkNotNullParameter(responseCode, "responseCode");
        this.f454a.a(responseCode);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(MetricCaptureData metricCaptureData) {
        Intrinsics.checkNotNullParameter(metricCaptureData, "metricCaptureData");
        this.f454a.a(metricCaptureData);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(ConsentPostRequest consentBody) {
        Intrinsics.checkNotNullParameter(consentBody, "consentBody");
        this.f454a.a(consentBody);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "apiResponse");
        this.f454a.a(apiResponse);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(ScanType scanType) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        this.f454a.a(scanType);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(Config config) {
        this.f454a.a(config);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(Integer num) {
        this.f454a.a(num);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.f454a.a(key);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(String eventName, Pair<String, String>... args) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(args, "args");
        this.f454a.a(eventName, args);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void a(ArrayList<Screen> screenFlow) {
        Intrinsics.checkNotNullParameter(screenFlow, "screenFlow");
        this.f454a.a(screenFlow);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void b() {
        this.f454a.b();
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void b(com.socure.docv.capturesdk.common.view.model.c screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        this.f454a.b(screen);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void b(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "apiResponse");
        this.f454a.b(apiResponse);
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public Integer c() {
        return this.f454a.c();
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public ArrayList<Screen> d() {
        return this.f454a.d();
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public MetricData e() {
        return this.f454a.e();
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public int f() {
        return this.f454a.f();
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public LiveData<ResponseCode> g() {
        return this.f454a.g();
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void h() {
        this.f454a.h();
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public SharedFlow<ApiResponse> i() {
        return this.f454a.i();
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void j() {
        this.f454a.j();
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public Config k() {
        return this.f454a.k();
    }

    @Override // com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.b
    public void l() {
        this.f454a.l();
    }
}
