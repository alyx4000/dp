package com.socure.docv.capturesdk.common.utils;

import android.os.Parcel;
import android.os.Parcelable;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lcom/socure/docv/capturesdk/common/utils/Screen;", "Landroid/os/Parcelable;", "index", "", "state", "Lcom/socure/docv/capturesdk/common/utils/State;", "scanType", "Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;", "(ILcom/socure/docv/capturesdk/common/utils/State;Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;)V", "getIndex", "()I", "getScanType", "()Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;", "getState", "()Lcom/socure/docv/capturesdk/common/utils/State;", "setState", "(Lcom/socure/docv/capturesdk/common/utils/State;)V", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Screen implements Parcelable {
    public static final Parcelable.Creator<Screen> CREATOR = new Creator();
    private final int index;
    private final ScanType scanType;
    private State state;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Screen> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Screen createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Screen(parcel.readInt(), State.valueOf(parcel.readString()), ScanType.valueOf(parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Screen[] newArray(int i) {
            return new Screen[i];
        }
    }

    public Screen(int i, State state, ScanType scanType) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        this.index = i;
        this.state = state;
        this.scanType = scanType;
    }

    public /* synthetic */ Screen(int i, State state, ScanType scanType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? State.INCOMPLETE : state, scanType);
    }

    public static /* synthetic */ Screen copy$default(Screen screen, int i, State state, ScanType scanType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = screen.index;
        }
        if ((i2 & 2) != 0) {
            state = screen.state;
        }
        if ((i2 & 4) != 0) {
            scanType = screen.scanType;
        }
        return screen.copy(i, state, scanType);
    }

    /* renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: component2, reason: from getter */
    public final State getState() {
        return this.state;
    }

    /* renamed from: component3, reason: from getter */
    public final ScanType getScanType() {
        return this.scanType;
    }

    public final Screen copy(int index, State state, ScanType scanType) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        return new Screen(index, state, scanType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Screen)) {
            return false;
        }
        Screen screen = (Screen) other;
        return this.index == screen.index && this.state == screen.state && this.scanType == screen.scanType;
    }

    public final int getIndex() {
        return this.index;
    }

    public final ScanType getScanType() {
        return this.scanType;
    }

    public final State getState() {
        return this.state;
    }

    public int hashCode() {
        return this.scanType.hashCode() + ((this.state.hashCode() + (Integer.hashCode(this.index) * 31)) * 31);
    }

    public final void setState(State state) {
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        this.state = state;
    }

    public String toString() {
        return "Screen(index=" + this.index + ", state=" + this.state + ", scanType=" + this.scanType + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.index);
        parcel.writeString(this.state.name());
        parcel.writeString(this.scanType.name());
    }
}
