package com.socure.docv.capturesdk.core.pipeline.model;

import com.socure.docv.capturesdk.common.utils.ApiConstant;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LICENSE_FRONT", "LICENSE_BACK", "PASSPORT", "SELFIE", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum ScanType {
    LICENSE_FRONT("lic_front"),
    LICENSE_BACK("lic_back"),
    PASSPORT(ApiConstant.DOCUMENT_TYPE_PASSPORT),
    SELFIE("selfie");

    private final String value;

    ScanType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
