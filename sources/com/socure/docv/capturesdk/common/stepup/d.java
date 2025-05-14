package com.socure.docv.capturesdk.common.stepup;

import com.socure.docv.capturesdk.common.network.model.stepup.App;
import com.socure.docv.capturesdk.common.network.model.stepup.Consent;
import com.socure.docv.capturesdk.common.network.model.stepup.Data;
import com.socure.docv.capturesdk.common.network.model.stepup.FlowData;
import com.socure.docv.capturesdk.common.network.model.stepup.StartUploadData;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;

/* loaded from: classes5.dex */
public interface d {
    void a(Data data, StartUploadData startUploadData, FlowData flowData, App app, Consent consent, ApiResponse apiResponse);

    void a(Data data, ApiResponse apiResponse);
}
