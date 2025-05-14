package com.extole.android.sdk;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SendError.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/extole/android/sdk/SendError;", "Lcom/extole/android/sdk/RestException;", "uniqueId", "", "errorCode", "httpStatusCode", "message", "parameters", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getErrorCode", "()Ljava/lang/String;", "getHttpStatusCode", "getMessage", "getParameters", "()Ljava/util/Map;", "getUniqueId", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SendError extends RestException {
    private final String errorCode;
    private final String httpStatusCode;
    private final String message;
    private final Map<String, Object> parameters;
    private final String uniqueId;

    @Override // com.extole.android.sdk.RestException
    public String getUniqueId() {
        return this.uniqueId;
    }

    @Override // com.extole.android.sdk.RestException
    public String getErrorCode() {
        return this.errorCode;
    }

    @Override // com.extole.android.sdk.RestException
    public String getHttpStatusCode() {
        return this.httpStatusCode;
    }

    @Override // com.extole.android.sdk.RestException, java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    @Override // com.extole.android.sdk.RestException
    public Map<String, Object> getParameters() {
        return this.parameters;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendError(String uniqueId, String errorCode, String httpStatusCode, String message, Map<String, ? extends Object> parameters) {
        super(uniqueId, errorCode, httpStatusCode, message, parameters);
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(httpStatusCode, "httpStatusCode");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        this.uniqueId = uniqueId;
        this.errorCode = errorCode;
        this.httpStatusCode = httpStatusCode;
        this.message = message;
        this.parameters = parameters;
    }
}
