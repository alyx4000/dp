package com.socure.docv.capturesdk.common.upload;

import com.socure.docv.capturesdk.api.ResponseCode;
import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class m<T> {

    public static final class a extends m {

        /* renamed from: a, reason: collision with root package name */
        public final ApiResponse f330a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ApiResponse apiResponse) {
            super(null);
            Intrinsics.checkNotNullParameter(apiResponse, "apiResponse");
            this.f330a = apiResponse;
        }
    }

    public static final class b extends m {

        /* renamed from: a, reason: collision with root package name */
        public final ResponseCode f331a;
        public final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ResponseCode responseCode, String msg) {
            super(null);
            Intrinsics.checkNotNullParameter(responseCode, "responseCode");
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.f331a = responseCode;
            this.b = msg;
        }
    }

    public static final class c<T> extends m<T> {

        /* renamed from: a, reason: collision with root package name */
        public final f f332a;
        public final T b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(f uploadApiType, T t) {
            super(null);
            Intrinsics.checkNotNullParameter(uploadApiType, "uploadApiType");
            this.f332a = uploadApiType;
            this.b = t;
        }
    }

    public m() {
    }

    public /* synthetic */ m(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
