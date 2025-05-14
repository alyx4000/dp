package com.socure.docv.capturesdk.common.network.model.stepup;

import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import com.socure.docv.capturesdk.feature.scanner.data.Dimension;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00063"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadImage;", "", "()V", "captureType", "Lcom/socure/docv/capturesdk/core/pipeline/model/CaptureType;", "getCaptureType", "()Lcom/socure/docv/capturesdk/core/pipeline/model/CaptureType;", "setCaptureType", "(Lcom/socure/docv/capturesdk/core/pipeline/model/CaptureType;)V", "dimension", "Lcom/socure/docv/capturesdk/feature/scanner/data/Dimension;", "getDimension", "()Lcom/socure/docv/capturesdk/feature/scanner/data/Dimension;", "setDimension", "(Lcom/socure/docv/capturesdk/feature/scanner/data/Dimension;)V", "documentBody", "Lokhttp3/MultipartBody$Part;", "getDocumentBody", "()Lokhttp3/MultipartBody$Part;", "setDocumentBody", "(Lokhttp3/MultipartBody$Part;)V", "extractedData", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ExtractedStepUpData;", "getExtractedData", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/ExtractedStepUpData;", "setExtractedData", "(Lcom/socure/docv/capturesdk/common/network/model/stepup/ExtractedStepUpData;)V", "image", "", "getImage", "()[B", "setImage", "([B)V", "scanType", "Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;", "getScanType", "()Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;", "setScanType", "(Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;)V", "selfieMetrics", "Lcom/socure/docv/capturesdk/common/network/model/stepup/SelfieMetrics;", "getSelfieMetrics", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/SelfieMetrics;", "setSelfieMetrics", "(Lcom/socure/docv/capturesdk/common/network/model/stepup/SelfieMetrics;)V", "uploadStatus", "Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadStatus;", "getUploadStatus", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadStatus;", "setUploadStatus", "(Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadStatus;)V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UploadImage {
    public CaptureType captureType;
    public Dimension dimension;
    private MultipartBody.Part documentBody;
    private ExtractedStepUpData extractedData;
    public byte[] image;
    public ScanType scanType;
    private SelfieMetrics selfieMetrics;
    private UploadStatus uploadStatus = UploadStatus.NONE;

    public final CaptureType getCaptureType() {
        CaptureType captureType = this.captureType;
        if (captureType != null) {
            return captureType;
        }
        Intrinsics.throwUninitializedPropertyAccessException("captureType");
        return null;
    }

    public final Dimension getDimension() {
        Dimension dimension = this.dimension;
        if (dimension != null) {
            return dimension;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dimension");
        return null;
    }

    public final MultipartBody.Part getDocumentBody() {
        return this.documentBody;
    }

    public final ExtractedStepUpData getExtractedData() {
        return this.extractedData;
    }

    public final byte[] getImage() {
        byte[] bArr = this.image;
        if (bArr != null) {
            return bArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("image");
        return null;
    }

    public final ScanType getScanType() {
        ScanType scanType = this.scanType;
        if (scanType != null) {
            return scanType;
        }
        Intrinsics.throwUninitializedPropertyAccessException("scanType");
        return null;
    }

    public final SelfieMetrics getSelfieMetrics() {
        return this.selfieMetrics;
    }

    public final UploadStatus getUploadStatus() {
        return this.uploadStatus;
    }

    public final void setCaptureType(CaptureType captureType) {
        Intrinsics.checkNotNullParameter(captureType, "<set-?>");
        this.captureType = captureType;
    }

    public final void setDimension(Dimension dimension) {
        Intrinsics.checkNotNullParameter(dimension, "<set-?>");
        this.dimension = dimension;
    }

    public final void setDocumentBody(MultipartBody.Part part) {
        this.documentBody = part;
    }

    public final void setExtractedData(ExtractedStepUpData extractedStepUpData) {
        this.extractedData = extractedStepUpData;
    }

    public final void setImage(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.image = bArr;
    }

    public final void setScanType(ScanType scanType) {
        Intrinsics.checkNotNullParameter(scanType, "<set-?>");
        this.scanType = scanType;
    }

    public final void setSelfieMetrics(SelfieMetrics selfieMetrics) {
        this.selfieMetrics = selfieMetrics;
    }

    public final void setUploadStatus(UploadStatus uploadStatus) {
        Intrinsics.checkNotNullParameter(uploadStatus, "<set-?>");
        this.uploadStatus = uploadStatus;
    }
}
