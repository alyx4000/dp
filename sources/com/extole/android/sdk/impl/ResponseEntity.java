package com.extole.android.sdk.impl;

import androidx.exifinterface.media.ExifInterface;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResponseEntity.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/extole/android/sdk/impl/ResponseEntity;", ExifInterface.GPS_DIRECTION_TRUE, "", "entity", "headers", "", "", "", ApiConstant.KEY_CODE, "", "(Ljava/lang/Object;Ljava/util/Map;I)V", "getCode", "()I", "getEntity", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getHeaders", "()Ljava/util/Map;", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ResponseEntity<T> {
    private final int code;
    private final T entity;
    private final Map<String, Collection<String>> headers;

    /* JADX WARN: Multi-variable type inference failed */
    public ResponseEntity(T t, Map<String, ? extends Collection<String>> headers, int i) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.entity = t;
        this.headers = headers;
        this.code = i;
    }

    public final T getEntity() {
        return this.entity;
    }

    public final Map<String, Collection<String>> getHeaders() {
        return this.headers;
    }

    public final int getCode() {
        return this.code;
    }
}
