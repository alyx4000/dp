package expo.modules.barcodescanner;

import android.os.Bundle;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.iterable.iterableapi.IterableConstants;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BarCodeScannedEvent.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0019\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003JU\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\b\b\u0002\u0010\f\u001a\u00020\nHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R,\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u001c¨\u0006,"}, d2 = {"Lexpo/modules/barcodescanner/BarCodeScannedEvent;", "Lexpo/modules/kotlin/records/Record;", TouchesHelper.TARGET_KEY, "", "data", "", IterableConstants.SOUND_FOLDER_IDENTIFIER, "type", "cornerPoints", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", "bounds", "(ILjava/lang/String;Ljava/lang/String;ILjava/util/ArrayList;Landroid/os/Bundle;)V", "getBounds$annotations", "()V", "getBounds", "()Landroid/os/Bundle;", "getCornerPoints$annotations", "getCornerPoints", "()Ljava/util/ArrayList;", "getData$annotations", "getData", "()Ljava/lang/String;", "getRaw$annotations", "getRaw", "getTarget$annotations", "getTarget", "()I", "getType$annotations", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "expo-barcode-scanner_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BarCodeScannedEvent implements Record {
    private final Bundle bounds;
    private final ArrayList<Bundle> cornerPoints;
    private final String data;
    private final String raw;
    private final int target;
    private final int type;

    public static /* synthetic */ BarCodeScannedEvent copy$default(BarCodeScannedEvent barCodeScannedEvent, int i, String str, String str2, int i2, ArrayList arrayList, Bundle bundle, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = barCodeScannedEvent.target;
        }
        if ((i3 & 2) != 0) {
            str = barCodeScannedEvent.data;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            str2 = barCodeScannedEvent.raw;
        }
        String str4 = str2;
        if ((i3 & 8) != 0) {
            i2 = barCodeScannedEvent.type;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            arrayList = barCodeScannedEvent.cornerPoints;
        }
        ArrayList arrayList2 = arrayList;
        if ((i3 & 32) != 0) {
            bundle = barCodeScannedEvent.bounds;
        }
        return barCodeScannedEvent.copy(i, str3, str4, i4, arrayList2, bundle);
    }

    @Field
    public static /* synthetic */ void getBounds$annotations() {
    }

    @Field
    public static /* synthetic */ void getCornerPoints$annotations() {
    }

    @Field
    public static /* synthetic */ void getData$annotations() {
    }

    @Field
    public static /* synthetic */ void getRaw$annotations() {
    }

    @Field
    public static /* synthetic */ void getTarget$annotations() {
    }

    @Field
    public static /* synthetic */ void getType$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final int getTarget() {
        return this.target;
    }

    /* renamed from: component2, reason: from getter */
    public final String getData() {
        return this.data;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRaw() {
        return this.raw;
    }

    /* renamed from: component4, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final ArrayList<Bundle> component5() {
        return this.cornerPoints;
    }

    /* renamed from: component6, reason: from getter */
    public final Bundle getBounds() {
        return this.bounds;
    }

    public final BarCodeScannedEvent copy(int target, String data, String raw, int type, ArrayList<Bundle> cornerPoints, Bundle bounds) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(raw, "raw");
        Intrinsics.checkNotNullParameter(cornerPoints, "cornerPoints");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        return new BarCodeScannedEvent(target, data, raw, type, cornerPoints, bounds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BarCodeScannedEvent)) {
            return false;
        }
        BarCodeScannedEvent barCodeScannedEvent = (BarCodeScannedEvent) other;
        return this.target == barCodeScannedEvent.target && Intrinsics.areEqual(this.data, barCodeScannedEvent.data) && Intrinsics.areEqual(this.raw, barCodeScannedEvent.raw) && this.type == barCodeScannedEvent.type && Intrinsics.areEqual(this.cornerPoints, barCodeScannedEvent.cornerPoints) && Intrinsics.areEqual(this.bounds, barCodeScannedEvent.bounds);
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.target) * 31) + this.data.hashCode()) * 31) + this.raw.hashCode()) * 31) + Integer.hashCode(this.type)) * 31) + this.cornerPoints.hashCode()) * 31) + this.bounds.hashCode();
    }

    public String toString() {
        return "BarCodeScannedEvent(target=" + this.target + ", data=" + this.data + ", raw=" + this.raw + ", type=" + this.type + ", cornerPoints=" + this.cornerPoints + ", bounds=" + this.bounds + ")";
    }

    public BarCodeScannedEvent(int i, String data, String raw, int i2, ArrayList<Bundle> cornerPoints, Bundle bounds) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(raw, "raw");
        Intrinsics.checkNotNullParameter(cornerPoints, "cornerPoints");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        this.target = i;
        this.data = data;
        this.raw = raw;
        this.type = i2;
        this.cornerPoints = cornerPoints;
        this.bounds = bounds;
    }

    public final int getTarget() {
        return this.target;
    }

    public final String getData() {
        return this.data;
    }

    public final String getRaw() {
        return this.raw;
    }

    public final int getType() {
        return this.type;
    }

    public final ArrayList<Bundle> getCornerPoints() {
        return this.cornerPoints;
    }

    public final Bundle getBounds() {
        return this.bounds;
    }
}
