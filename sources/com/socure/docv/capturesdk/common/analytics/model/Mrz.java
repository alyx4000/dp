package com.socure.docv.capturesdk.common.analytics.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/socure/docv/capturesdk/common/analytics/model/Mrz;", "", "mrzDetected", "", "(Ljava/lang/Boolean;)V", "getMrzDetected", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/socure/docv/capturesdk/common/analytics/model/Mrz;", "equals", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Mrz {
    private final Boolean mrzDetected;

    public Mrz() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public Mrz(Boolean bool) {
        this.mrzDetected = bool;
    }

    public /* synthetic */ Mrz(Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool);
    }

    public static /* synthetic */ Mrz copy$default(Mrz mrz, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = mrz.mrzDetected;
        }
        return mrz.copy(bool);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getMrzDetected() {
        return this.mrzDetected;
    }

    public final Mrz copy(Boolean mrzDetected) {
        return new Mrz(mrzDetected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Mrz) && Intrinsics.areEqual(this.mrzDetected, ((Mrz) other).mrzDetected);
    }

    public final Boolean getMrzDetected() {
        return this.mrzDetected;
    }

    public int hashCode() {
        Boolean bool = this.mrzDetected;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    public String toString() {
        return "Mrz(mrzDetected=" + this.mrzDetected + ")";
    }
}
