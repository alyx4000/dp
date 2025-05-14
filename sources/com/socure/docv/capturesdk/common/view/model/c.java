package com.socure.docv.capturesdk.common.view.model;

/* loaded from: classes5.dex */
public enum c {
    SELECTOR("selector"),
    SCANNER_FRONT("scanner"),
    PREVIEW_FRONT("preview"),
    SCANNER_BACK("scanner"),
    PREVIEW_BACK("preview"),
    SCANNER_PASSPORT("scanner"),
    PREVIEW_PASSPORT("preview"),
    SCANNER_SELFIE("scanner"),
    PREVIEW_SELFIE("preview");

    private final String screenType;

    c(String str) {
        this.screenType = str;
    }

    public final String a() {
        return this.screenType;
    }
}
