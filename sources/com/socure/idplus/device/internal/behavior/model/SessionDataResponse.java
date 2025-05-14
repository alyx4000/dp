package com.socure.idplus.device.internal.behavior.model;

import com.google.gson.annotations.SerializedName;
import io.sentry.Session;
import java.util.List;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u000bJ.\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Lcom/socure/idplus/device/internal/behavior/model/SessionDataResponse;", "", Session.JsonKeys.ERRORS, "", "success", "Lkotlin/Result;", "", "(Ljava/util/List;Ljava/lang/Object;)V", "getErrors", "()Ljava/util/List;", "getSuccess-d1pmJ48", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component2-d1pmJ48", "copy", "(Ljava/util/List;Ljava/lang/Object;)Lcom/socure/idplus/device/internal/behavior/model/SessionDataResponse;", "equals", "other", "hashCode", "", "toString", "", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SessionDataResponse {

    @SerializedName(Session.JsonKeys.ERRORS)
    private final List<Object> errors;

    @SerializedName("success")
    private final Object success;

    public SessionDataResponse(List<? extends Object> errors, Object obj) {
        Intrinsics.checkNotNullParameter(errors, "errors");
        this.errors = errors;
        this.success = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SessionDataResponse copy$default(SessionDataResponse sessionDataResponse, List list, Result result, int i, Object obj) {
        if ((i & 1) != 0) {
            list = sessionDataResponse.errors;
        }
        if ((i & 2) != 0) {
            result = Result.m1226boximpl(sessionDataResponse.success);
        }
        return sessionDataResponse.copy(list, result.getValue());
    }

    public final List<Object> component1() {
        return this.errors;
    }

    /* renamed from: component2-d1pmJ48, reason: not valid java name and from getter */
    public final Object getSuccess() {
        return this.success;
    }

    public final SessionDataResponse copy(List<? extends Object> errors, Object success) {
        Intrinsics.checkNotNullParameter(errors, "errors");
        return new SessionDataResponse(errors, success);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionDataResponse)) {
            return false;
        }
        SessionDataResponse sessionDataResponse = (SessionDataResponse) other;
        return Intrinsics.areEqual(this.errors, sessionDataResponse.errors) && Result.m1229equalsimpl0(this.success, sessionDataResponse.success);
    }

    public final List<Object> getErrors() {
        return this.errors;
    }

    /* renamed from: getSuccess-d1pmJ48, reason: not valid java name */
    public final Object m965getSuccessd1pmJ48() {
        return this.success;
    }

    public int hashCode() {
        return Result.m1232hashCodeimpl(this.success) + (this.errors.hashCode() * 31);
    }

    public String toString() {
        return "SessionDataResponse(errors=" + this.errors + ", success=" + Result.m1235toStringimpl(this.success) + ")";
    }
}
