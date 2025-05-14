package com.socure.docv.capturesdk.common.upload;

import com.socure.docv.capturesdk.core.pipeline.model.ApiResponse;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class g<T> {

    public static final class a extends g {

        /* renamed from: a, reason: collision with root package name */
        public final ApiResponse f322a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ApiResponse apiResponse) {
            super(null);
            Intrinsics.checkNotNullParameter(apiResponse, "apiResponse");
            this.f322a = apiResponse;
        }
    }

    public static final class b extends g {

        /* renamed from: a, reason: collision with root package name */
        public static final b f323a = new b();

        public b() {
            super(null);
        }
    }

    public static final class c<T> extends g<T> {

        /* renamed from: a, reason: collision with root package name */
        public final T f324a;

        public c(T t) {
            super(null);
            this.f324a = t;
        }
    }

    public static final class d<T> extends g<T> {

        /* renamed from: a, reason: collision with root package name */
        public final T f325a;

        public d(T t) {
            super(null);
            this.f325a = t;
        }
    }

    public g() {
    }

    public /* synthetic */ g(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
