package com.socure.docv.capturesdk.common.stepup;

import com.socure.docv.capturesdk.common.network.model.stepup.App;
import com.socure.docv.capturesdk.common.network.model.stepup.Consent;
import com.socure.docv.capturesdk.common.network.model.stepup.FlowData;
import com.socure.docv.capturesdk.common.network.model.stepup.StartUploadData;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;

/* loaded from: classes5.dex */
public interface j {
    void a(StartUploadData startUploadData, FlowData flowData, App app, Consent consent);

    void a(ApiResponse apiResponse);
}
