package com.socure.docv.capturesdk.common.config.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/socure/docv/capturesdk/common/config/model/Model;", "", "model", "Lorg/tensorflow/lite/support/model/Model;", "confidence", "", "numOfBuffers", "", "(Lorg/tensorflow/lite/support/model/Model;FI)V", "getConfidence", "()F", "getModel", "()Lorg/tensorflow/lite/support/model/Model;", "getNumOfBuffers", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Model {
    private final float confidence;
    private final org.tensorflow.lite.support.model.Model model;
    private final int numOfBuffers;

    public Model(org.tensorflow.lite.support.model.Model model, float f, int i) {
        Intrinsics.checkNotNullParameter(model, "model");
        this.model = model;
        this.confidence = f;
        this.numOfBuffers = i;
    }

    public static /* synthetic */ Model copy$default(Model model, org.tensorflow.lite.support.model.Model model2, float f, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            model2 = model.model;
        }
        if ((i2 & 2) != 0) {
            f = model.confidence;
        }
        if ((i2 & 4) != 0) {
            i = model.numOfBuffers;
        }
        return model.copy(model2, f, i);
    }

    /* renamed from: component1, reason: from getter */
    public final org.tensorflow.lite.support.model.Model getModel() {
        return this.model;
    }

    /* renamed from: component2, reason: from getter */
    public final float getConfidence() {
        return this.confidence;
    }

    /* renamed from: component3, reason: from getter */
    public final int getNumOfBuffers() {
        return this.numOfBuffers;
    }

    public final Model copy(org.tensorflow.lite.support.model.Model model, float confidence, int numOfBuffers) {
        Intrinsics.checkNotNullParameter(model, "model");
        return new Model(model, confidence, numOfBuffers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Model)) {
            return false;
        }
        Model model = (Model) other;
        return Intrinsics.areEqual(this.model, model.model) && Intrinsics.areEqual((Object) Float.valueOf(this.confidence), (Object) Float.valueOf(model.confidence)) && this.numOfBuffers == model.numOfBuffers;
    }

    public final float getConfidence() {
        return this.confidence;
    }

    public final org.tensorflow.lite.support.model.Model getModel() {
        return this.model;
    }

    public final int getNumOfBuffers() {
        return this.numOfBuffers;
    }

    public int hashCode() {
        return Integer.hashCode(this.numOfBuffers) + ((Float.hashCode(this.confidence) + (this.model.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "Model(model=" + this.model + ", confidence=" + this.confidence + ", numOfBuffers=" + this.numOfBuffers + ")";
    }
}
