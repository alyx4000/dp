package com.socure.docv.capturesdk.core.external.ml.model;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.socure.core.d;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/socure/docv/capturesdk/core/external/ml/model/LineInfo;", "", "Lorg/socure/core/d;", "component1", "component2", ViewProps.START, ViewProps.END, "copy", "", "toString", "", "hashCode", "other", "", "equals", "Lorg/socure/core/d;", "getStart", "()Lorg/socure/core/d;", "setStart", "(Lorg/socure/core/d;)V", "getEnd", "setEnd", "<init>", "(Lorg/socure/core/d;Lorg/socure/core/d;)V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final /* data */ class LineInfo {
    private d end;
    private d start;

    public LineInfo(d start, d end) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        this.start = start;
        this.end = end;
    }

    public static /* synthetic */ LineInfo copy$default(LineInfo lineInfo, d dVar, d dVar2, int i, Object obj) {
        if ((i & 1) != 0) {
            dVar = lineInfo.start;
        }
        if ((i & 2) != 0) {
            dVar2 = lineInfo.end;
        }
        return lineInfo.copy(dVar, dVar2);
    }

    /* renamed from: component1, reason: from getter */
    public final d getStart() {
        return this.start;
    }

    /* renamed from: component2, reason: from getter */
    public final d getEnd() {
        return this.end;
    }

    public final LineInfo copy(d start, d end) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        return new LineInfo(start, end);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LineInfo)) {
            return false;
        }
        LineInfo lineInfo = (LineInfo) other;
        return Intrinsics.areEqual(this.start, lineInfo.start) && Intrinsics.areEqual(this.end, lineInfo.end);
    }

    public final d getEnd() {
        return this.end;
    }

    public final d getStart() {
        return this.start;
    }

    public int hashCode() {
        return this.end.hashCode() + (this.start.hashCode() * 31);
    }

    public final void setEnd(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<set-?>");
        this.end = dVar;
    }

    public final void setStart(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "<set-?>");
        this.start = dVar;
    }

    public String toString() {
        return "LineInfo(start=" + this.start + ", end=" + this.end + ")";
    }
}
