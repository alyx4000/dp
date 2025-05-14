package com.socure.docv.capturesdk.core.processor.model;

import android.graphics.Bitmap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/socure/docv/capturesdk/core/processor/model/ProcessResult;", "", "outputBitmap", "Landroid/graphics/Bitmap;", "modelList", "", "", "modelProcessedBitmap", "modelProcessedRawData", "Lkotlin/Pair;", "", "(Landroid/graphics/Bitmap;Ljava/util/List;Landroid/graphics/Bitmap;Lkotlin/Pair;)V", "getModelList", "()Ljava/util/List;", "getModelProcessedBitmap", "()Landroid/graphics/Bitmap;", "getModelProcessedRawData", "()Lkotlin/Pair;", "getOutputBitmap", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ProcessResult {
    private final List<Float> modelList;
    private final Bitmap modelProcessedBitmap;
    private final Pair<float[], float[]> modelProcessedRawData;
    private final Bitmap outputBitmap;

    public ProcessResult(Bitmap outputBitmap, List<Float> modelList, Bitmap modelProcessedBitmap, Pair<float[], float[]> pair) {
        Intrinsics.checkNotNullParameter(outputBitmap, "outputBitmap");
        Intrinsics.checkNotNullParameter(modelList, "modelList");
        Intrinsics.checkNotNullParameter(modelProcessedBitmap, "modelProcessedBitmap");
        this.outputBitmap = outputBitmap;
        this.modelList = modelList;
        this.modelProcessedBitmap = modelProcessedBitmap;
        this.modelProcessedRawData = pair;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProcessResult copy$default(ProcessResult processResult, Bitmap bitmap, List list, Bitmap bitmap2, Pair pair, int i, Object obj) {
        if ((i & 1) != 0) {
            bitmap = processResult.outputBitmap;
        }
        if ((i & 2) != 0) {
            list = processResult.modelList;
        }
        if ((i & 4) != 0) {
            bitmap2 = processResult.modelProcessedBitmap;
        }
        if ((i & 8) != 0) {
            pair = processResult.modelProcessedRawData;
        }
        return processResult.copy(bitmap, list, bitmap2, pair);
    }

    /* renamed from: component1, reason: from getter */
    public final Bitmap getOutputBitmap() {
        return this.outputBitmap;
    }

    public final List<Float> component2() {
        return this.modelList;
    }

    /* renamed from: component3, reason: from getter */
    public final Bitmap getModelProcessedBitmap() {
        return this.modelProcessedBitmap;
    }

    public final Pair<float[], float[]> component4() {
        return this.modelProcessedRawData;
    }

    public final ProcessResult copy(Bitmap outputBitmap, List<Float> modelList, Bitmap modelProcessedBitmap, Pair<float[], float[]> modelProcessedRawData) {
        Intrinsics.checkNotNullParameter(outputBitmap, "outputBitmap");
        Intrinsics.checkNotNullParameter(modelList, "modelList");
        Intrinsics.checkNotNullParameter(modelProcessedBitmap, "modelProcessedBitmap");
        return new ProcessResult(outputBitmap, modelList, modelProcessedBitmap, modelProcessedRawData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProcessResult)) {
            return false;
        }
        ProcessResult processResult = (ProcessResult) other;
        return Intrinsics.areEqual(this.outputBitmap, processResult.outputBitmap) && Intrinsics.areEqual(this.modelList, processResult.modelList) && Intrinsics.areEqual(this.modelProcessedBitmap, processResult.modelProcessedBitmap) && Intrinsics.areEqual(this.modelProcessedRawData, processResult.modelProcessedRawData);
    }

    public final List<Float> getModelList() {
        return this.modelList;
    }

    public final Bitmap getModelProcessedBitmap() {
        return this.modelProcessedBitmap;
    }

    public final Pair<float[], float[]> getModelProcessedRawData() {
        return this.modelProcessedRawData;
    }

    public final Bitmap getOutputBitmap() {
        return this.outputBitmap;
    }

    public int hashCode() {
        int hashCode = (this.modelProcessedBitmap.hashCode() + ((this.modelList.hashCode() + (this.outputBitmap.hashCode() * 31)) * 31)) * 31;
        Pair<float[], float[]> pair = this.modelProcessedRawData;
        return hashCode + (pair == null ? 0 : pair.hashCode());
    }

    public String toString() {
        return "ProcessResult(outputBitmap=" + this.outputBitmap + ", modelList=" + this.modelList + ", modelProcessedBitmap=" + this.modelProcessedBitmap + ", modelProcessedRawData=" + this.modelProcessedRawData + ")";
    }
}
