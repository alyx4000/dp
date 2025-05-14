package com.socure.docv.capturesdk.common.utils;

import com.socure.docv.capturesdk.common.analytics.model.a;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u0001`\nHÆ\u0003JS\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052(\b\u0002\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u0001`\nHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R4\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u0001`\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/socure/docv/capturesdk/common/utils/ScanError;", "Lcom/socure/docv/capturesdk/common/utils/BaseResultData;", "statusCode", "", "errorMessage", "", "sessionId", "capturedImages", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "getCapturedImages", "()Ljava/util/HashMap;", "getErrorMessage", "()Ljava/lang/String;", "getSessionId", "getStatusCode", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ScanError extends BaseResultData {
    private final HashMap<String, byte[]> capturedImages;
    private final String errorMessage;
    private final String sessionId;
    private final int statusCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScanError(int i, String errorMessage, String str, HashMap<String, byte[]> hashMap) {
        super(str, hashMap);
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        this.statusCode = i;
        this.errorMessage = errorMessage;
        this.sessionId = str;
        this.capturedImages = hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ScanError copy$default(ScanError scanError, int i, String str, String str2, HashMap hashMap, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = scanError.statusCode;
        }
        if ((i2 & 2) != 0) {
            str = scanError.errorMessage;
        }
        if ((i2 & 4) != 0) {
            str2 = scanError.getSessionId();
        }
        if ((i2 & 8) != 0) {
            hashMap = scanError.getCapturedImages();
        }
        return scanError.copy(i, str, str2, hashMap);
    }

    /* renamed from: component1, reason: from getter */
    public final int getStatusCode() {
        return this.statusCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String component3() {
        return getSessionId();
    }

    public final HashMap<String, byte[]> component4() {
        return getCapturedImages();
    }

    public final ScanError copy(int statusCode, String errorMessage, String sessionId, HashMap<String, byte[]> capturedImages) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        return new ScanError(statusCode, errorMessage, sessionId, capturedImages);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScanError)) {
            return false;
        }
        ScanError scanError = (ScanError) other;
        return this.statusCode == scanError.statusCode && Intrinsics.areEqual(this.errorMessage, scanError.errorMessage) && Intrinsics.areEqual(getSessionId(), scanError.getSessionId()) && Intrinsics.areEqual(getCapturedImages(), scanError.getCapturedImages());
    }

    @Override // com.socure.docv.capturesdk.common.utils.BaseResultData
    public HashMap<String, byte[]> getCapturedImages() {
        return this.capturedImages;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @Override // com.socure.docv.capturesdk.common.utils.BaseResultData
    public String getSessionId() {
        return this.sessionId;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public int hashCode() {
        return ((a.a(this.errorMessage, Integer.hashCode(this.statusCode) * 31, 31) + (getSessionId() == null ? 0 : getSessionId().hashCode())) * 31) + (getCapturedImages() != null ? getCapturedImages().hashCode() : 0);
    }

    public String toString() {
        return "ScanError(statusCode=" + this.statusCode + ", errorMessage=" + this.errorMessage + ", sessionId=" + getSessionId() + ", capturedImages=" + getCapturedImages() + ")";
    }
}
