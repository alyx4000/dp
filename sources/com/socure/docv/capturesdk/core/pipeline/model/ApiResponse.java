package com.socure.docv.capturesdk.core.pipeline.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.socure.docv.capturesdk.common.analytics.model.a;
import com.socure.docv.capturesdk.common.network.model.ApiType;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006%"}, d2 = {"Lcom/socure/docv/capturesdk/core/pipeline/model/ApiResponse;", "Landroid/os/Parcelable;", "apiType", "Lcom/socure/docv/capturesdk/common/network/model/ApiType;", "statusCode", "", "statusMsg", "", "httpCode", "httpMsg", "(Lcom/socure/docv/capturesdk/common/network/model/ApiType;ILjava/lang/String;ILjava/lang/String;)V", "getApiType", "()Lcom/socure/docv/capturesdk/common/network/model/ApiType;", "getHttpCode", "()I", "getHttpMsg", "()Ljava/lang/String;", "getStatusCode", "getStatusMsg", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ApiResponse implements Parcelable {
    public static final Parcelable.Creator<ApiResponse> CREATOR = new Creator();
    private final ApiType apiType;
    private final int httpCode;
    private final String httpMsg;
    private final int statusCode;
    private final String statusMsg;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ApiResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ApiResponse createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ApiResponse(ApiType.valueOf(parcel.readString()), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ApiResponse[] newArray(int i) {
            return new ApiResponse[i];
        }
    }

    public ApiResponse(ApiType apiType, int i, String statusMsg, int i2, String httpMsg) {
        Intrinsics.checkNotNullParameter(apiType, "apiType");
        Intrinsics.checkNotNullParameter(statusMsg, "statusMsg");
        Intrinsics.checkNotNullParameter(httpMsg, "httpMsg");
        this.apiType = apiType;
        this.statusCode = i;
        this.statusMsg = statusMsg;
        this.httpCode = i2;
        this.httpMsg = httpMsg;
    }

    public static /* synthetic */ ApiResponse copy$default(ApiResponse apiResponse, ApiType apiType, int i, String str, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            apiType = apiResponse.apiType;
        }
        if ((i3 & 2) != 0) {
            i = apiResponse.statusCode;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            str = apiResponse.statusMsg;
        }
        String str3 = str;
        if ((i3 & 8) != 0) {
            i2 = apiResponse.httpCode;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            str2 = apiResponse.httpMsg;
        }
        return apiResponse.copy(apiType, i4, str3, i5, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final ApiType getApiType() {
        return this.apiType;
    }

    /* renamed from: component2, reason: from getter */
    public final int getStatusCode() {
        return this.statusCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getStatusMsg() {
        return this.statusMsg;
    }

    /* renamed from: component4, reason: from getter */
    public final int getHttpCode() {
        return this.httpCode;
    }

    /* renamed from: component5, reason: from getter */
    public final String getHttpMsg() {
        return this.httpMsg;
    }

    public final ApiResponse copy(ApiType apiType, int statusCode, String statusMsg, int httpCode, String httpMsg) {
        Intrinsics.checkNotNullParameter(apiType, "apiType");
        Intrinsics.checkNotNullParameter(statusMsg, "statusMsg");
        Intrinsics.checkNotNullParameter(httpMsg, "httpMsg");
        return new ApiResponse(apiType, statusCode, statusMsg, httpCode, httpMsg);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiResponse)) {
            return false;
        }
        ApiResponse apiResponse = (ApiResponse) other;
        return this.apiType == apiResponse.apiType && this.statusCode == apiResponse.statusCode && Intrinsics.areEqual(this.statusMsg, apiResponse.statusMsg) && this.httpCode == apiResponse.httpCode && Intrinsics.areEqual(this.httpMsg, apiResponse.httpMsg);
    }

    public final ApiType getApiType() {
        return this.apiType;
    }

    public final int getHttpCode() {
        return this.httpCode;
    }

    public final String getHttpMsg() {
        return this.httpMsg;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public int hashCode() {
        return this.httpMsg.hashCode() + ((Integer.hashCode(this.httpCode) + a.a(this.statusMsg, (Integer.hashCode(this.statusCode) + (this.apiType.hashCode() * 31)) * 31, 31)) * 31);
    }

    public String toString() {
        return "ApiResponse(apiType=" + this.apiType + ", statusCode=" + this.statusCode + ", statusMsg=" + this.statusMsg + ", httpCode=" + this.httpCode + ", httpMsg=" + this.httpMsg + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.apiType.name());
        parcel.writeInt(this.statusCode);
        parcel.writeString(this.statusMsg);
        parcel.writeInt(this.httpCode);
        parcel.writeString(this.httpMsg);
    }
}
