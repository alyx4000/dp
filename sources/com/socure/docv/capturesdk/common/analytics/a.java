package com.socure.docv.capturesdk.common.analytics;

import com.socure.docv.capturesdk.common.utils.ApiConstant;

/* loaded from: classes5.dex */
public enum a {
    ID("id_card"),
    PASSPORT(ApiConstant.DOCUMENT_TYPE_PASSPORT);

    private final String value;

    a(String str) {
        this.value = str;
    }

    public final String a() {
        return this.value;
    }
}
