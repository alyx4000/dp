package com.socure.docv.capturesdk.common.analytics.model;

import com.iterable.iterableapi.IterableConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/socure/docv/capturesdk/common/analytics/model/Selfie;", "", "captureMode", "", IterableConstants.DEVICE_ID, "faces", "Ljava/util/ArrayList;", "Lcom/socure/docv/capturesdk/common/analytics/model/Face;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getCaptureMode", "()Ljava/lang/String;", "getDeviceId", "getFaces", "()Ljava/util/ArrayList;", "setFaces", "(Ljava/util/ArrayList;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Selfie {
    private final String captureMode;
    private final String deviceId;
    private ArrayList<Face> faces;

    public Selfie() {
        this(null, null, null, 7, null);
    }

    public Selfie(String str, String str2, ArrayList<Face> arrayList) {
        this.captureMode = str;
        this.deviceId = str2;
        this.faces = arrayList;
    }

    public /* synthetic */ Selfie(String str, String str2, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Selfie copy$default(Selfie selfie, String str, String str2, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = selfie.captureMode;
        }
        if ((i & 2) != 0) {
            str2 = selfie.deviceId;
        }
        if ((i & 4) != 0) {
            arrayList = selfie.faces;
        }
        return selfie.copy(str, str2, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCaptureMode() {
        return this.captureMode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    public final ArrayList<Face> component3() {
        return this.faces;
    }

    public final Selfie copy(String captureMode, String deviceId, ArrayList<Face> faces) {
        return new Selfie(captureMode, deviceId, faces);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Selfie)) {
            return false;
        }
        Selfie selfie = (Selfie) other;
        return Intrinsics.areEqual(this.captureMode, selfie.captureMode) && Intrinsics.areEqual(this.deviceId, selfie.deviceId) && Intrinsics.areEqual(this.faces, selfie.faces);
    }

    public final String getCaptureMode() {
        return this.captureMode;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final ArrayList<Face> getFaces() {
        return this.faces;
    }

    public int hashCode() {
        String str = this.captureMode;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deviceId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ArrayList<Face> arrayList = this.faces;
        return hashCode2 + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final void setFaces(ArrayList<Face> arrayList) {
        this.faces = arrayList;
    }

    public String toString() {
        return "Selfie(captureMode=" + this.captureMode + ", deviceId=" + this.deviceId + ", faces=" + this.faces + ")";
    }
}
