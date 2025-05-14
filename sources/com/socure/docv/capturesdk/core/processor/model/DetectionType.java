package com.socure.docv.capturesdk.core.processor.model;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/socure/docv/capturesdk/core/processor/model/DetectionType;", "", "manualCaptureMandatory", "", "weight", "", "(Ljava/lang/String;IZD)V", "getManualCaptureMandatory", "()Z", "getWeight", "()D", "CORNER", "BLUR", "GLARE", "BRIGHTNESS", "SELFIE", "BARCODE", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum DetectionType {
    CORNER(false, 0.0d),
    BLUR(false, 0.3d),
    GLARE(false, 0.3d),
    BRIGHTNESS(true, 0.4d),
    SELFIE(true, 0.0d),
    BARCODE(true, 0.0d);

    private final boolean manualCaptureMandatory;
    private final double weight;

    DetectionType(boolean z, double d) {
        this.manualCaptureMandatory = z;
        this.weight = d;
    }

    public final boolean getManualCaptureMandatory() {
        return this.manualCaptureMandatory;
    }

    public final double getWeight() {
        return this.weight;
    }
}
