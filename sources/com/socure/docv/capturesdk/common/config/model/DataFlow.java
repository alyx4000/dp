package com.socure.docv.capturesdk.common.config.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.socure.docv.capturesdk.common.utils.Screen;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\n\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fHÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/socure/docv/capturesdk/common/config/model/DataFlow;", "Landroid/os/Parcelable;", "screenSequence", "Ljava/util/ArrayList;", "Lcom/socure/docv/capturesdk/common/utils/Screen;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getScreenSequence", "()Ljava/util/ArrayList;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DataFlow implements Parcelable {
    public static final Parcelable.Creator<DataFlow> CREATOR = new Creator();
    private final ArrayList<Screen> screenSequence;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataFlow> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataFlow createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(Screen.CREATOR.createFromParcel(parcel));
            }
            return new DataFlow(arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataFlow[] newArray(int i) {
            return new DataFlow[i];
        }
    }

    public DataFlow(ArrayList<Screen> screenSequence) {
        Intrinsics.checkNotNullParameter(screenSequence, "screenSequence");
        this.screenSequence = screenSequence;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DataFlow copy$default(DataFlow dataFlow, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = dataFlow.screenSequence;
        }
        return dataFlow.copy(arrayList);
    }

    public final ArrayList<Screen> component1() {
        return this.screenSequence;
    }

    public final DataFlow copy(ArrayList<Screen> screenSequence) {
        Intrinsics.checkNotNullParameter(screenSequence, "screenSequence");
        return new DataFlow(screenSequence);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DataFlow) && Intrinsics.areEqual(this.screenSequence, ((DataFlow) other).screenSequence);
    }

    public final ArrayList<Screen> getScreenSequence() {
        return this.screenSequence;
    }

    public int hashCode() {
        return this.screenSequence.hashCode();
    }

    public String toString() {
        return "DataFlow(screenSequence=" + this.screenSequence + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        ArrayList<Screen> arrayList = this.screenSequence;
        parcel.writeInt(arrayList.size());
        Iterator<Screen> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }
}
