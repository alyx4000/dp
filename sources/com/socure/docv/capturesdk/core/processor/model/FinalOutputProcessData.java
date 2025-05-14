package com.socure.docv.capturesdk.core.processor.model;

import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.socure.docv.capturesdk.common.analytics.model.Face;
import com.socure.docv.capturesdk.core.extractor.model.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\u001c\b\u0002\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b1\u00102J\u0006\u0010\u0003\u001a\u00020\u0002J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u001d\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\t\u0010\f\u001a\u00020\nHÆ\u0003J\t\u0010\u000e\u001a\u00020\rHÆ\u0003JQ\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u001c\b\u0002\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\rHÆ\u0001J\t\u0010\u0016\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR6\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010%\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/socure/docv/capturesdk/core/processor/model/FinalOutputProcessData;", "", "", "clear", "Lcom/socure/docv/capturesdk/core/extractor/model/a;", "component1", "Ljava/util/ArrayList;", "Lcom/socure/docv/capturesdk/common/analytics/model/Face;", "Lkotlin/collections/ArrayList;", "component2", "", "component3", "component4", "", "component5", "data", OptionalModuleUtils.FACE, "found", "faceFound", "duration", "copy", "", "toString", "", "hashCode", "other", "equals", "Lcom/socure/docv/capturesdk/core/extractor/model/a;", "getData", "()Lcom/socure/docv/capturesdk/core/extractor/model/a;", "setData", "(Lcom/socure/docv/capturesdk/core/extractor/model/a;)V", "Ljava/util/ArrayList;", "getFace", "()Ljava/util/ArrayList;", "setFace", "(Ljava/util/ArrayList;)V", "Z", "getFound", "()Z", "setFound", "(Z)V", "getFaceFound", "setFaceFound", "J", "getDuration", "()J", "setDuration", "(J)V", "<init>", "(Lcom/socure/docv/capturesdk/core/extractor/model/a;Ljava/util/ArrayList;ZZJ)V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final /* data */ class FinalOutputProcessData {
    private a data;
    private long duration;
    private ArrayList<Face> face;
    private boolean faceFound;
    private boolean found;

    public FinalOutputProcessData() {
        this(null, null, false, false, 0L, 31, null);
    }

    public FinalOutputProcessData(a aVar, ArrayList<Face> arrayList, boolean z, boolean z2, long j) {
        this.data = aVar;
        this.face = arrayList;
        this.found = z;
        this.faceFound = z2;
        this.duration = j;
    }

    public /* synthetic */ FinalOutputProcessData(a aVar, ArrayList arrayList, boolean z, boolean z2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : aVar, (i & 2) == 0 ? arrayList : null, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? 0L : j);
    }

    public static /* synthetic */ FinalOutputProcessData copy$default(FinalOutputProcessData finalOutputProcessData, a aVar, ArrayList arrayList, boolean z, boolean z2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            aVar = finalOutputProcessData.data;
        }
        if ((i & 2) != 0) {
            arrayList = finalOutputProcessData.face;
        }
        ArrayList arrayList2 = arrayList;
        if ((i & 4) != 0) {
            z = finalOutputProcessData.found;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = finalOutputProcessData.faceFound;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            j = finalOutputProcessData.duration;
        }
        return finalOutputProcessData.copy(aVar, arrayList2, z3, z4, j);
    }

    public final void clear() {
        this.data = null;
        this.face = null;
        this.found = false;
        this.faceFound = false;
    }

    /* renamed from: component1, reason: from getter */
    public final a getData() {
        return this.data;
    }

    public final ArrayList<Face> component2() {
        return this.face;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getFound() {
        return this.found;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getFaceFound() {
        return this.faceFound;
    }

    /* renamed from: component5, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    public final FinalOutputProcessData copy(a data, ArrayList<Face> face, boolean found, boolean faceFound, long duration) {
        return new FinalOutputProcessData(data, face, found, faceFound, duration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FinalOutputProcessData)) {
            return false;
        }
        FinalOutputProcessData finalOutputProcessData = (FinalOutputProcessData) other;
        return Intrinsics.areEqual(this.data, finalOutputProcessData.data) && Intrinsics.areEqual(this.face, finalOutputProcessData.face) && this.found == finalOutputProcessData.found && this.faceFound == finalOutputProcessData.faceFound && this.duration == finalOutputProcessData.duration;
    }

    public final a getData() {
        return this.data;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final ArrayList<Face> getFace() {
        return this.face;
    }

    public final boolean getFaceFound() {
        return this.faceFound;
    }

    public final boolean getFound() {
        return this.found;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        a aVar = this.data;
        int hashCode = (aVar == null ? 0 : aVar.hashCode()) * 31;
        ArrayList<Face> arrayList = this.face;
        int hashCode2 = (hashCode + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        boolean z = this.found;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z2 = this.faceFound;
        return Long.hashCode(this.duration) + ((i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31);
    }

    public final void setData(a aVar) {
        this.data = aVar;
    }

    public final void setDuration(long j) {
        this.duration = j;
    }

    public final void setFace(ArrayList<Face> arrayList) {
        this.face = arrayList;
    }

    public final void setFaceFound(boolean z) {
        this.faceFound = z;
    }

    public final void setFound(boolean z) {
        this.found = z;
    }

    public String toString() {
        return "FinalOutputProcessData(data=" + this.data + ", face=" + this.face + ", found=" + this.found + ", faceFound=" + this.faceFound + ", duration=" + this.duration + ")";
    }
}
