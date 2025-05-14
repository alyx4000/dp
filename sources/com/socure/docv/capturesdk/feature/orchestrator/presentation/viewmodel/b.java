package com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel;

import androidx.lifecycle.LiveData;
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
import kotlinx.coroutines.flow.SharedFlow;

/* loaded from: classes5.dex */
public interface b {
    FragNavActions a(com.socure.docv.capturesdk.common.view.model.c cVar);

    LinkedHashMap<ScanType, UploadImage> a();

    void a(DocumentType documentType);

    void a(ResponseCode responseCode);

    void a(MetricCaptureData metricCaptureData);

    void a(ConsentPostRequest consentPostRequest);

    void a(ApiResponse apiResponse);

    void a(ScanType scanType);

    void a(Config config);

    void a(Integer num);

    void a(String str);

    void a(String str, Pair<String, String>... pairArr);

    void a(ArrayList<Screen> arrayList);

    void b();

    void b(com.socure.docv.capturesdk.common.view.model.c cVar);

    void b(ApiResponse apiResponse);

    Integer c();

    ArrayList<Screen> d();

    MetricData e();

    int f();

    LiveData<ResponseCode> g();

    void h();

    SharedFlow<ApiResponse> i();

    void j();

    Config k();

    void l();
}
