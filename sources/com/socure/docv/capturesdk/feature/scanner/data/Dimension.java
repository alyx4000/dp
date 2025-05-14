package com.socure.docv.capturesdk.feature.scanner.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/socure/docv/capturesdk/feature/scanner/data/Dimension;", "", "w", "", "h", "(DD)V", "getH", "()D", "getW", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Dimension {
    private final double h;
    private final double w;

    public Dimension(double d, double d2) {
        this.w = d;
        this.h = d2;
    }

    public static /* synthetic */ Dimension copy$default(Dimension dimension, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = dimension.w;
        }
        if ((i & 2) != 0) {
            d2 = dimension.h;
        }
        return dimension.copy(d, d2);
    }

    /* renamed from: component1, reason: from getter */
    public final double getW() {
        return this.w;
    }

    /* renamed from: component2, reason: from getter */
    public final double getH() {
        return this.h;
    }

    public final Dimension copy(double w, double h) {
        return new Dimension(w, h);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Dimension)) {
            return false;
        }
        Dimension dimension = (Dimension) other;
        return Intrinsics.areEqual((Object) Double.valueOf(this.w), (Object) Double.valueOf(dimension.w)) && Intrinsics.areEqual((Object) Double.valueOf(this.h), (Object) Double.valueOf(dimension.h));
    }

    public final double getH() {
        return this.h;
    }

    public final double getW() {
        return this.w;
    }

    public int hashCode() {
        return Double.hashCode(this.h) + (Double.hashCode(this.w) * 31);
    }

    public String toString() {
        return "Dimension(w=" + this.w + ", h=" + this.h + ")";
    }
}
