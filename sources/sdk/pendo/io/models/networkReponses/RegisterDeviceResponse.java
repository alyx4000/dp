package sdk.pendo.io.models.networkReponses;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.network.responses.AuthTokenErrorResponse;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001b"}, d2 = {"Lsdk/pendo/io/models/networkReponses/RegisterDeviceResponse;", "", "id", "", AuthTokenErrorResponse.AUTHTOKEN_ERROR_ID, "errorMessage", "", "(IILjava/lang/String;)V", "getErrorId", "()I", "setErrorId", "(I)V", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "getId", "setId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class RegisterDeviceResponse {
    private int errorId;
    private String errorMessage;
    private int id;

    public RegisterDeviceResponse() {
        this(0, 0, null, 7, null);
    }

    public static /* synthetic */ RegisterDeviceResponse copy$default(RegisterDeviceResponse registerDeviceResponse, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = registerDeviceResponse.id;
        }
        if ((i3 & 2) != 0) {
            i2 = registerDeviceResponse.errorId;
        }
        if ((i3 & 4) != 0) {
            str = registerDeviceResponse.errorMessage;
        }
        return registerDeviceResponse.copy(i, i2, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getErrorId() {
        return this.errorId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final RegisterDeviceResponse copy(int id, int errorId, String errorMessage) {
        return new RegisterDeviceResponse(id, errorId, errorMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegisterDeviceResponse)) {
            return false;
        }
        RegisterDeviceResponse registerDeviceResponse = (RegisterDeviceResponse) other;
        return this.id == registerDeviceResponse.id && this.errorId == registerDeviceResponse.errorId && Intrinsics.areEqual(this.errorMessage, registerDeviceResponse.errorMessage);
    }

    public final int getErrorId() {
        return this.errorId;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final int getId() {
        return this.id;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.errorId)) * 31;
        String str = this.errorMessage;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setErrorId(int i) {
        this.errorId = i;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public String toString() {
        return "RegisterDeviceResponse(id=" + this.id + ", errorId=" + this.errorId + ", errorMessage=" + this.errorMessage + ")";
    }

    public RegisterDeviceResponse(int i, int i2, String str) {
        this.id = i;
        this.errorId = i2;
        this.errorMessage = str;
    }

    public /* synthetic */ RegisterDeviceResponse(int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? null : str);
    }
}
