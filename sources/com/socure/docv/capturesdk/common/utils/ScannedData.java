package com.socure.docv.capturesdk.common.utils;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J)\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bHÆ\u0003Jo\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072(\b\u0002\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR4\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006\""}, d2 = {"Lcom/socure/docv/capturesdk/common/utils/ScannedData;", "Lcom/socure/docv/capturesdk/common/utils/BaseResultData;", "docUUID", "", "sessionId", "extractedData", "captureData", "", "capturedImages", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/HashMap;)V", "getCaptureData", "()Ljava/util/Map;", "getCapturedImages", "()Ljava/util/HashMap;", "getDocUUID", "()Ljava/lang/String;", "getExtractedData", "getSessionId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ScannedData extends BaseResultData {
    private final Map<String, String> captureData;
    private final HashMap<String, byte[]> capturedImages;
    private final String docUUID;
    private final String extractedData;
    private final String sessionId;

    public ScannedData(String str, String str2, String str3, Map<String, String> map, HashMap<String, byte[]> hashMap) {
        super(str2, hashMap);
        this.docUUID = str;
        this.sessionId = str2;
        this.extractedData = str3;
        this.captureData = map;
        this.capturedImages = hashMap;
    }

    public static /* synthetic */ ScannedData copy$default(ScannedData scannedData, String str, String str2, String str3, Map map, HashMap hashMap, int i, Object obj) {
        if ((i & 1) != 0) {
            str = scannedData.docUUID;
        }
        if ((i & 2) != 0) {
            str2 = scannedData.getSessionId();
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = scannedData.extractedData;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            map = scannedData.captureData;
        }
        Map map2 = map;
        if ((i & 16) != 0) {
            hashMap = scannedData.getCapturedImages();
        }
        return scannedData.copy(str, str4, str5, map2, hashMap);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDocUUID() {
        return this.docUUID;
    }

    public final String component2() {
        return getSessionId();
    }

    /* renamed from: component3, reason: from getter */
    public final String getExtractedData() {
        return this.extractedData;
    }

    public final Map<String, String> component4() {
        return this.captureData;
    }

    public final HashMap<String, byte[]> component5() {
        return getCapturedImages();
    }

    public final ScannedData copy(String docUUID, String sessionId, String extractedData, Map<String, String> captureData, HashMap<String, byte[]> capturedImages) {
        return new ScannedData(docUUID, sessionId, extractedData, captureData, capturedImages);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScannedData)) {
            return false;
        }
        ScannedData scannedData = (ScannedData) other;
        return Intrinsics.areEqual(this.docUUID, scannedData.docUUID) && Intrinsics.areEqual(getSessionId(), scannedData.getSessionId()) && Intrinsics.areEqual(this.extractedData, scannedData.extractedData) && Intrinsics.areEqual(this.captureData, scannedData.captureData) && Intrinsics.areEqual(getCapturedImages(), scannedData.getCapturedImages());
    }

    public final Map<String, String> getCaptureData() {
        return this.captureData;
    }

    @Override // com.socure.docv.capturesdk.common.utils.BaseResultData
    public HashMap<String, byte[]> getCapturedImages() {
        return this.capturedImages;
    }

    public final String getDocUUID() {
        return this.docUUID;
    }

    public final String getExtractedData() {
        return this.extractedData;
    }

    @Override // com.socure.docv.capturesdk.common.utils.BaseResultData
    public String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        String str = this.docUUID;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + (getSessionId() == null ? 0 : getSessionId().hashCode())) * 31;
        String str2 = this.extractedData;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, String> map = this.captureData;
        return ((hashCode2 + (map == null ? 0 : map.hashCode())) * 31) + (getCapturedImages() != null ? getCapturedImages().hashCode() : 0);
    }

    public String toString() {
        return "ScannedData(docUUID=" + this.docUUID + ", sessionId=" + getSessionId() + ", extractedData=" + this.extractedData + ", captureData=" + this.captureData + ", capturedImages=" + getCapturedImages() + ")";
    }
}
