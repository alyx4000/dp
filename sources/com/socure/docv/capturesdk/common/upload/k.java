package com.socure.docv.capturesdk.common.upload;

import com.socure.docv.capturesdk.common.network.model.stepup.UploadImage;
import com.socure.docv.capturesdk.common.network.model.stepup.UploadResult;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;

/* loaded from: classes5.dex */
public interface k {
    void a(UploadImage uploadImage, UploadResult uploadResult, int i);

    void a(UploadImage uploadImage, ApiResponse apiResponse);
}
