package com.socure.docv.capturesdk.common.config.model;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/socure/docv/capturesdk/common/config/model/MemoryInfo;", "", "totalRam", "", "availRam", "thresholdRam", "currentlyLowMemory", "", "(JJJZ)V", "getAvailRam", "()J", "getCurrentlyLowMemory", "()Z", "getThresholdRam", "getTotalRam", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MemoryInfo {
    private final long availRam;
    private final boolean currentlyLowMemory;
    private final long thresholdRam;
    private final long totalRam;

    public MemoryInfo(long j, long j2, long j3, boolean z) {
        this.totalRam = j;
        this.availRam = j2;
        this.thresholdRam = j3;
        this.currentlyLowMemory = z;
    }

    /* renamed from: component1, reason: from getter */
    public final long getTotalRam() {
        return this.totalRam;
    }

    /* renamed from: component2, reason: from getter */
    public final long getAvailRam() {
        return this.availRam;
    }

    /* renamed from: component3, reason: from getter */
    public final long getThresholdRam() {
        return this.thresholdRam;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getCurrentlyLowMemory() {
        return this.currentlyLowMemory;
    }

    public final MemoryInfo copy(long totalRam, long availRam, long thresholdRam, boolean currentlyLowMemory) {
        return new MemoryInfo(totalRam, availRam, thresholdRam, currentlyLowMemory);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MemoryInfo)) {
            return false;
        }
        MemoryInfo memoryInfo = (MemoryInfo) other;
        return this.totalRam == memoryInfo.totalRam && this.availRam == memoryInfo.availRam && this.thresholdRam == memoryInfo.thresholdRam && this.currentlyLowMemory == memoryInfo.currentlyLowMemory;
    }

    public final long getAvailRam() {
        return this.availRam;
    }

    public final boolean getCurrentlyLowMemory() {
        return this.currentlyLowMemory;
    }

    public final long getThresholdRam() {
        return this.thresholdRam;
    }

    public final long getTotalRam() {
        return this.totalRam;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = (Long.hashCode(this.thresholdRam) + ((Long.hashCode(this.availRam) + (Long.hashCode(this.totalRam) * 31)) * 31)) * 31;
        boolean z = this.currentlyLowMemory;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "MemoryInfo(totalRam=" + this.totalRam + ", availRam=" + this.availRam + ", thresholdRam=" + this.thresholdRam + ", currentlyLowMemory=" + this.currentlyLowMemory + ")";
    }
}
