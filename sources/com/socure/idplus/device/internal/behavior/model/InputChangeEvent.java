package com.socure.idplus.device.internal.behavior.model;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/socure/idplus/device/internal/behavior/model/InputChangeEvent;", "", "clientTime", "", "focus", "", "action", "Lcom/socure/idplus/device/internal/behavior/model/InputChangeAction;", "(JZLcom/socure/idplus/device/internal/behavior/model/InputChangeAction;)V", "getAction", "()Lcom/socure/idplus/device/internal/behavior/model/InputChangeAction;", "getClientTime", "()J", "getFocus", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class InputChangeEvent {

    @SerializedName("action")
    private final InputChangeAction action;

    @SerializedName("clientTime")
    private final long clientTime;

    @SerializedName("focus")
    private final boolean focus;

    public InputChangeEvent(long j, boolean z, InputChangeAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.clientTime = j;
        this.focus = z;
        this.action = action;
    }

    public static /* synthetic */ InputChangeEvent copy$default(InputChangeEvent inputChangeEvent, long j, boolean z, InputChangeAction inputChangeAction, int i, Object obj) {
        if ((i & 1) != 0) {
            j = inputChangeEvent.clientTime;
        }
        if ((i & 2) != 0) {
            z = inputChangeEvent.focus;
        }
        if ((i & 4) != 0) {
            inputChangeAction = inputChangeEvent.action;
        }
        return inputChangeEvent.copy(j, z, inputChangeAction);
    }

    /* renamed from: component1, reason: from getter */
    public final long getClientTime() {
        return this.clientTime;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getFocus() {
        return this.focus;
    }

    /* renamed from: component3, reason: from getter */
    public final InputChangeAction getAction() {
        return this.action;
    }

    public final InputChangeEvent copy(long clientTime, boolean focus, InputChangeAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return new InputChangeEvent(clientTime, focus, action);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputChangeEvent)) {
            return false;
        }
        InputChangeEvent inputChangeEvent = (InputChangeEvent) other;
        return this.clientTime == inputChangeEvent.clientTime && this.focus == inputChangeEvent.focus && this.action == inputChangeEvent.action;
    }

    public final InputChangeAction getAction() {
        return this.action;
    }

    public final long getClientTime() {
        return this.clientTime;
    }

    public final boolean getFocus() {
        return this.focus;
    }

    public int hashCode() {
        return this.action.hashCode() + ((Boolean.hashCode(this.focus) + (Long.hashCode(this.clientTime) * 31)) * 31);
    }

    public String toString() {
        return "InputChangeEvent(clientTime=" + this.clientTime + ", focus=" + this.focus + ", action=" + this.action + ")";
    }
}
