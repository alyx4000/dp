package com.socure.idplus.device.internal.behavior.model;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/socure/idplus/device/internal/behavior/model/KeyPressEvent;", "", "clientTime", "", "type", "Lcom/socure/idplus/device/internal/behavior/model/KeyPressType;", "(JLcom/socure/idplus/device/internal/behavior/model/KeyPressType;)V", "getClientTime", "()J", "getType", "()Lcom/socure/idplus/device/internal/behavior/model/KeyPressType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KeyPressEvent {

    @SerializedName("clientTime")
    private final long clientTime;

    @SerializedName("type")
    private final KeyPressType type;

    public KeyPressEvent(long j, KeyPressType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.clientTime = j;
        this.type = type;
    }

    public static /* synthetic */ KeyPressEvent copy$default(KeyPressEvent keyPressEvent, long j, KeyPressType keyPressType, int i, Object obj) {
        if ((i & 1) != 0) {
            j = keyPressEvent.clientTime;
        }
        if ((i & 2) != 0) {
            keyPressType = keyPressEvent.type;
        }
        return keyPressEvent.copy(j, keyPressType);
    }

    /* renamed from: component1, reason: from getter */
    public final long getClientTime() {
        return this.clientTime;
    }

    /* renamed from: component2, reason: from getter */
    public final KeyPressType getType() {
        return this.type;
    }

    public final KeyPressEvent copy(long clientTime, KeyPressType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new KeyPressEvent(clientTime, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyPressEvent)) {
            return false;
        }
        KeyPressEvent keyPressEvent = (KeyPressEvent) other;
        return this.clientTime == keyPressEvent.clientTime && this.type == keyPressEvent.type;
    }

    public final long getClientTime() {
        return this.clientTime;
    }

    public final KeyPressType getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type.hashCode() + (Long.hashCode(this.clientTime) * 31);
    }

    public String toString() {
        return "KeyPressEvent(clientTime=" + this.clientTime + ", type=" + this.type + ")";
    }
}
