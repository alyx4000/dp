package com.socure.docv.capturesdk.common.analytics.model;

import androidx.core.app.FrameMetricsAggregator;
import com.iterable.iterableapi.IterableConstants;
import com.socure.docv.capturesdk.common.utils.ConstantsKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014¢\u0006\u0002\u0010\u0015J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010<\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u001d\u0010A\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014HÆ\u0003J\u008c\u0001\u0010B\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014HÆ\u0001¢\u0006\u0002\u0010CJ\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020HHÖ\u0001J\t\u0010I\u001a\u00020\u000bHÖ\u0001R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010$\"\u0004\b(\u0010&R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R.\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006J"}, d2 = {"Lcom/socure/docv/capturesdk/common/analytics/model/Document;", "", ConstantsKt.GLARE, "Lcom/socure/docv/capturesdk/common/analytics/model/Glare;", "edge", "Lcom/socure/docv/capturesdk/common/analytics/model/Edge;", ConstantsKt.BRIGHTNESS, "", ConstantsKt.BLUR, "Lcom/socure/docv/capturesdk/common/analytics/model/Blur;", "captureMode", "", IterableConstants.DEVICE_ID, "barcode", "Lcom/socure/docv/capturesdk/common/analytics/model/Barcode;", ConstantsKt.MRZ_TYPE, "Lcom/socure/docv/capturesdk/common/analytics/model/Mrz;", "faces", "Ljava/util/ArrayList;", "Lcom/socure/docv/capturesdk/common/analytics/model/Face;", "Lkotlin/collections/ArrayList;", "(Lcom/socure/docv/capturesdk/common/analytics/model/Glare;Lcom/socure/docv/capturesdk/common/analytics/model/Edge;Ljava/lang/Double;Lcom/socure/docv/capturesdk/common/analytics/model/Blur;Ljava/lang/String;Ljava/lang/String;Lcom/socure/docv/capturesdk/common/analytics/model/Barcode;Lcom/socure/docv/capturesdk/common/analytics/model/Mrz;Ljava/util/ArrayList;)V", "getBarcode", "()Lcom/socure/docv/capturesdk/common/analytics/model/Barcode;", "setBarcode", "(Lcom/socure/docv/capturesdk/common/analytics/model/Barcode;)V", "getBlur", "()Lcom/socure/docv/capturesdk/common/analytics/model/Blur;", "setBlur", "(Lcom/socure/docv/capturesdk/common/analytics/model/Blur;)V", "getBrightness", "()Ljava/lang/Double;", "setBrightness", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getCaptureMode", "()Ljava/lang/String;", "setCaptureMode", "(Ljava/lang/String;)V", "getDeviceId", "setDeviceId", "getEdge", "()Lcom/socure/docv/capturesdk/common/analytics/model/Edge;", "setEdge", "(Lcom/socure/docv/capturesdk/common/analytics/model/Edge;)V", "getFaces", "()Ljava/util/ArrayList;", "setFaces", "(Ljava/util/ArrayList;)V", "getGlare", "()Lcom/socure/docv/capturesdk/common/analytics/model/Glare;", "setGlare", "(Lcom/socure/docv/capturesdk/common/analytics/model/Glare;)V", "getMrz", "()Lcom/socure/docv/capturesdk/common/analytics/model/Mrz;", "setMrz", "(Lcom/socure/docv/capturesdk/common/analytics/model/Mrz;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/socure/docv/capturesdk/common/analytics/model/Glare;Lcom/socure/docv/capturesdk/common/analytics/model/Edge;Ljava/lang/Double;Lcom/socure/docv/capturesdk/common/analytics/model/Blur;Ljava/lang/String;Ljava/lang/String;Lcom/socure/docv/capturesdk/common/analytics/model/Barcode;Lcom/socure/docv/capturesdk/common/analytics/model/Mrz;Ljava/util/ArrayList;)Lcom/socure/docv/capturesdk/common/analytics/model/Document;", "equals", "", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Document {
    private Barcode barcode;
    private Blur blur;
    private Double brightness;
    private String captureMode;
    private String deviceId;
    private Edge edge;
    private ArrayList<Face> faces;
    private Glare glare;
    private Mrz mrz;

    public Document() {
        this(null, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public Document(Glare glare, Edge edge, Double d, Blur blur, String str, String str2, Barcode barcode, Mrz mrz, ArrayList<Face> arrayList) {
        this.glare = glare;
        this.edge = edge;
        this.brightness = d;
        this.blur = blur;
        this.captureMode = str;
        this.deviceId = str2;
        this.barcode = barcode;
        this.mrz = mrz;
        this.faces = arrayList;
    }

    public /* synthetic */ Document(Glare glare, Edge edge, Double d, Blur blur, String str, String str2, Barcode barcode, Mrz mrz, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : glare, (i & 2) != 0 ? null : edge, (i & 4) != 0 ? null : d, (i & 8) != 0 ? null : blur, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : barcode, (i & 128) != 0 ? null : mrz, (i & 256) == 0 ? arrayList : null);
    }

    /* renamed from: component1, reason: from getter */
    public final Glare getGlare() {
        return this.glare;
    }

    /* renamed from: component2, reason: from getter */
    public final Edge getEdge() {
        return this.edge;
    }

    /* renamed from: component3, reason: from getter */
    public final Double getBrightness() {
        return this.brightness;
    }

    /* renamed from: component4, reason: from getter */
    public final Blur getBlur() {
        return this.blur;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCaptureMode() {
        return this.captureMode;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component7, reason: from getter */
    public final Barcode getBarcode() {
        return this.barcode;
    }

    /* renamed from: component8, reason: from getter */
    public final Mrz getMrz() {
        return this.mrz;
    }

    public final ArrayList<Face> component9() {
        return this.faces;
    }

    public final Document copy(Glare glare, Edge edge, Double brightness, Blur blur, String captureMode, String deviceId, Barcode barcode, Mrz mrz, ArrayList<Face> faces) {
        return new Document(glare, edge, brightness, blur, captureMode, deviceId, barcode, mrz, faces);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Document)) {
            return false;
        }
        Document document = (Document) other;
        return Intrinsics.areEqual(this.glare, document.glare) && Intrinsics.areEqual(this.edge, document.edge) && Intrinsics.areEqual((Object) this.brightness, (Object) document.brightness) && Intrinsics.areEqual(this.blur, document.blur) && Intrinsics.areEqual(this.captureMode, document.captureMode) && Intrinsics.areEqual(this.deviceId, document.deviceId) && Intrinsics.areEqual(this.barcode, document.barcode) && Intrinsics.areEqual(this.mrz, document.mrz) && Intrinsics.areEqual(this.faces, document.faces);
    }

    public final Barcode getBarcode() {
        return this.barcode;
    }

    public final Blur getBlur() {
        return this.blur;
    }

    public final Double getBrightness() {
        return this.brightness;
    }

    public final String getCaptureMode() {
        return this.captureMode;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final Edge getEdge() {
        return this.edge;
    }

    public final ArrayList<Face> getFaces() {
        return this.faces;
    }

    public final Glare getGlare() {
        return this.glare;
    }

    public final Mrz getMrz() {
        return this.mrz;
    }

    public int hashCode() {
        Glare glare = this.glare;
        int hashCode = (glare == null ? 0 : glare.hashCode()) * 31;
        Edge edge = this.edge;
        int hashCode2 = (hashCode + (edge == null ? 0 : edge.hashCode())) * 31;
        Double d = this.brightness;
        int hashCode3 = (hashCode2 + (d == null ? 0 : d.hashCode())) * 31;
        Blur blur = this.blur;
        int hashCode4 = (hashCode3 + (blur == null ? 0 : blur.hashCode())) * 31;
        String str = this.captureMode;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.deviceId;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Barcode barcode = this.barcode;
        int hashCode7 = (hashCode6 + (barcode == null ? 0 : barcode.hashCode())) * 31;
        Mrz mrz = this.mrz;
        int hashCode8 = (hashCode7 + (mrz == null ? 0 : mrz.hashCode())) * 31;
        ArrayList<Face> arrayList = this.faces;
        return hashCode8 + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final void setBarcode(Barcode barcode) {
        this.barcode = barcode;
    }

    public final void setBlur(Blur blur) {
        this.blur = blur;
    }

    public final void setBrightness(Double d) {
        this.brightness = d;
    }

    public final void setCaptureMode(String str) {
        this.captureMode = str;
    }

    public final void setDeviceId(String str) {
        this.deviceId = str;
    }

    public final void setEdge(Edge edge) {
        this.edge = edge;
    }

    public final void setFaces(ArrayList<Face> arrayList) {
        this.faces = arrayList;
    }

    public final void setGlare(Glare glare) {
        this.glare = glare;
    }

    public final void setMrz(Mrz mrz) {
        this.mrz = mrz;
    }

    public String toString() {
        return "Document(glare=" + this.glare + ", edge=" + this.edge + ", brightness=" + this.brightness + ", blur=" + this.blur + ", captureMode=" + this.captureMode + ", deviceId=" + this.deviceId + ", barcode=" + this.barcode + ", mrz=" + this.mrz + ", faces=" + this.faces + ")";
    }
}
