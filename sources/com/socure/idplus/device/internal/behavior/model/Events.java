package com.socure.idplus.device.internal.behavior.model;

import com.facebook.react.uimanager.ViewProps;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

@kotlin.Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001BE\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/socure/idplus/device/internal/behavior/model/Events;", "", "focusChangeEvents", "", "Lcom/socure/idplus/device/internal/behavior/model/FocusChangeEvent;", "inputChangeEvents", "Lcom/socure/idplus/device/internal/behavior/model/InputChangeEvent;", "keyPressEvents", "Lcom/socure/idplus/device/internal/behavior/model/KeyPressEvent;", ViewProps.POINTER_EVENTS, "Lcom/socure/idplus/device/internal/behavior/model/PointerEvent;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getFocusChangeEvents", "()Ljava/util/List;", "getInputChangeEvents", "getKeyPressEvents", "getPointerEvents", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Events {

    @SerializedName("focusChangeEvents")
    private final List<FocusChangeEvent> focusChangeEvents;

    @SerializedName("inputChangeEvents")
    private final List<InputChangeEvent> inputChangeEvents;

    @SerializedName("keyPressEvents")
    private final List<KeyPressEvent> keyPressEvents;

    @SerializedName(ViewProps.POINTER_EVENTS)
    private final List<PointerEvent> pointerEvents;

    public Events(List<FocusChangeEvent> list, List<InputChangeEvent> list2, List<KeyPressEvent> list3, List<PointerEvent> list4) {
        this.focusChangeEvents = list;
        this.inputChangeEvents = list2;
        this.keyPressEvents = list3;
        this.pointerEvents = list4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Events copy$default(Events events, List list, List list2, List list3, List list4, int i, Object obj) {
        if ((i & 1) != 0) {
            list = events.focusChangeEvents;
        }
        if ((i & 2) != 0) {
            list2 = events.inputChangeEvents;
        }
        if ((i & 4) != 0) {
            list3 = events.keyPressEvents;
        }
        if ((i & 8) != 0) {
            list4 = events.pointerEvents;
        }
        return events.copy(list, list2, list3, list4);
    }

    public final List<FocusChangeEvent> component1() {
        return this.focusChangeEvents;
    }

    public final List<InputChangeEvent> component2() {
        return this.inputChangeEvents;
    }

    public final List<KeyPressEvent> component3() {
        return this.keyPressEvents;
    }

    public final List<PointerEvent> component4() {
        return this.pointerEvents;
    }

    public final Events copy(List<FocusChangeEvent> focusChangeEvents, List<InputChangeEvent> inputChangeEvents, List<KeyPressEvent> keyPressEvents, List<PointerEvent> pointerEvents) {
        return new Events(focusChangeEvents, inputChangeEvents, keyPressEvents, pointerEvents);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Events)) {
            return false;
        }
        Events events = (Events) other;
        return Intrinsics.areEqual(this.focusChangeEvents, events.focusChangeEvents) && Intrinsics.areEqual(this.inputChangeEvents, events.inputChangeEvents) && Intrinsics.areEqual(this.keyPressEvents, events.keyPressEvents) && Intrinsics.areEqual(this.pointerEvents, events.pointerEvents);
    }

    public final List<FocusChangeEvent> getFocusChangeEvents() {
        return this.focusChangeEvents;
    }

    public final List<InputChangeEvent> getInputChangeEvents() {
        return this.inputChangeEvents;
    }

    public final List<KeyPressEvent> getKeyPressEvents() {
        return this.keyPressEvents;
    }

    public final List<PointerEvent> getPointerEvents() {
        return this.pointerEvents;
    }

    public int hashCode() {
        List<FocusChangeEvent> list = this.focusChangeEvents;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<InputChangeEvent> list2 = this.inputChangeEvents;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<KeyPressEvent> list3 = this.keyPressEvents;
        int hashCode3 = (hashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<PointerEvent> list4 = this.pointerEvents;
        return hashCode3 + (list4 != null ? list4.hashCode() : 0);
    }

    public String toString() {
        return "Events(focusChangeEvents=" + this.focusChangeEvents + ", inputChangeEvents=" + this.inputChangeEvents + ", keyPressEvents=" + this.keyPressEvents + ", pointerEvents=" + this.pointerEvents + ")";
    }
}
