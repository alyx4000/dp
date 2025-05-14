package com.socure.idplus.device.internal.behavior.model;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/socure/idplus/device/internal/behavior/model/PointerEvent;", "", "clientTime", "", "type", "Lcom/socure/idplus/device/internal/behavior/model/PointerType;", "pressure", "", "offset", "Lcom/socure/idplus/device/internal/behavior/model/Offset;", "(JLcom/socure/idplus/device/internal/behavior/model/PointerType;DLcom/socure/idplus/device/internal/behavior/model/Offset;)V", "getClientTime", "()J", "getOffset", "()Lcom/socure/idplus/device/internal/behavior/model/Offset;", "getPressure", "()D", "getType", "()Lcom/socure/idplus/device/internal/behavior/model/PointerType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PointerEvent {

    @SerializedName("clientTime")
    private final long clientTime;

    @SerializedName("offset")
    private final Offset offset;

    @SerializedName("pressure")
    private final double pressure;

    @SerializedName("type")
    private final PointerType type;

    public PointerEvent(long j, PointerType type, double d, Offset offset) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.clientTime = j;
        this.type = type;
        this.pressure = d;
        this.offset = offset;
    }

    public static /* synthetic */ PointerEvent copy$default(PointerEvent pointerEvent, long j, PointerType pointerType, double d, Offset offset, int i, Object obj) {
        if ((i & 1) != 0) {
            j = pointerEvent.clientTime;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            pointerType = pointerEvent.type;
        }
        PointerType pointerType2 = pointerType;
        if ((i & 4) != 0) {
            d = pointerEvent.pressure;
        }
        double d2 = d;
        if ((i & 8) != 0) {
            offset = pointerEvent.offset;
        }
        return pointerEvent.copy(j2, pointerType2, d2, offset);
    }

    /* renamed from: component1, reason: from getter */
    public final long getClientTime() {
        return this.clientTime;
    }

    /* renamed from: component2, reason: from getter */
    public final PointerType getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final double getPressure() {
        return this.pressure;
    }

    /* renamed from: component4, reason: from getter */
    public final Offset getOffset() {
        return this.offset;
    }

    public final PointerEvent copy(long clientTime, PointerType type, double pressure, Offset offset) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new PointerEvent(clientTime, type, pressure, offset);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PointerEvent)) {
            return false;
        }
        PointerEvent pointerEvent = (PointerEvent) other;
        return this.clientTime == pointerEvent.clientTime && this.type == pointerEvent.type && Double.compare(this.pressure, pointerEvent.pressure) == 0 && Intrinsics.areEqual(this.offset, pointerEvent.offset);
    }

    public final long getClientTime() {
        return this.clientTime;
    }

    public final Offset getOffset() {
        return this.offset;
    }

    public final double getPressure() {
        return this.pressure;
    }

    public final PointerType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = (Double.hashCode(this.pressure) + ((this.type.hashCode() + (Long.hashCode(this.clientTime) * 31)) * 31)) * 31;
        Offset offset = this.offset;
        return hashCode + (offset == null ? 0 : offset.hashCode());
    }

    public String toString() {
        return "PointerEvent(clientTime=" + this.clientTime + ", type=" + this.type + ", pressure=" + this.pressure + ", offset=" + this.offset + ")";
    }
}
