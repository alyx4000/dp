package com.socure.docv.capturesdk.api;

import com.socure.docv.capturesdk.common.utils.ApiConstant;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/socure/docv/capturesdk/api/DocumentType;", "", "label", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "LICENSE", "PASSPORT", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum DocumentType {
    LICENSE(ApiConstant.DOCUMENT_TYPE_LICENSE),
    PASSPORT(ApiConstant.DOCUMENT_TYPE_PASSPORT);

    private final String label;

    DocumentType(String str) {
        this.label = str;
    }

    public final String getLabel() {
        return this.label;
    }
}
