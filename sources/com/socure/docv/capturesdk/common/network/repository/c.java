package com.socure.docv.capturesdk.common.network.repository;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public abstract class c implements com.socure.docv.capturesdk.common.network.repository.b {

    /* renamed from: a, reason: collision with root package name */
    public final Lazy f296a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;

    public static final class a extends Lambda implements Function0<com.socure.docv.capturesdk.common.network.transport.a> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f297a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public com.socure.docv.capturesdk.common.network.transport.a invoke() {
            return new com.socure.docv.capturesdk.common.network.transport.a();
        }
    }

    public static final class b extends Lambda implements Function0<com.socure.docv.capturesdk.common.network.repository.a> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public com.socure.docv.capturesdk.common.network.repository.a invoke() {
            Object create = c.a(c.this).c.create(com.socure.docv.capturesdk.common.network.transport.b.class);
            Intrinsics.checkNotNullExpressionValue(create, "mixPanelRetrofit.create(…elApiService::class.java)");
            return new com.socure.docv.capturesdk.common.network.repository.a((com.socure.docv.capturesdk.common.network.transport.b) create);
        }
    }

    /* renamed from: com.socure.docv.capturesdk.common.network.repository.c$c, reason: collision with other inner class name */
    public static final class C0036c extends Lambda implements Function0<com.socure.docv.capturesdk.common.network.repository.d> {
        public C0036c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public com.socure.docv.capturesdk.common.network.repository.d invoke() {
            Object create = c.a(c.this).b.create(com.socure.docv.capturesdk.common.network.transport.c.class);
            Intrinsics.checkNotNullExpressionValue(create, "stepUpRetrofit.create(St…UpApiService::class.java)");
            return new com.socure.docv.capturesdk.common.network.repository.d((com.socure.docv.capturesdk.common.network.transport.c) create);
        }
    }

    public static final class d extends Lambda implements Function0<e> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public e invoke() {
            Object create = c.a(c.this).f303a.create(com.socure.docv.capturesdk.common.network.transport.d.class);
            Intrinsics.checkNotNullExpressionValue(create, "uploadRetrofit.create(Up…adApiService::class.java)");
            return new e((com.socure.docv.capturesdk.common.network.transport.d) create);
        }
    }

    public c() {
        Lazy lazy = LazyKt.lazy(a.f297a);
        Lazy lazy2 = LazyKt.lazy(new d());
        Lazy lazy3 = LazyKt.lazy(new C0036c());
        Lazy lazy4 = LazyKt.lazy(new b());
        this.f296a = lazy;
        this.b = lazy2;
        this.c = lazy3;
        this.d = lazy4;
    }

    public static final com.socure.docv.capturesdk.common.network.transport.a a(c cVar) {
        return (com.socure.docv.capturesdk.common.network.transport.a) cVar.f296a.getValue();
    }

    @Override // com.socure.docv.capturesdk.common.network.repository.b
    public e a() {
        return (e) this.b.getValue();
    }

    @Override // com.socure.docv.capturesdk.common.network.repository.b
    public com.socure.docv.capturesdk.common.network.repository.d b() {
        return (com.socure.docv.capturesdk.common.network.repository.d) this.c.getValue();
    }

    @Override // com.socure.docv.capturesdk.common.network.repository.b
    public com.socure.docv.capturesdk.common.network.repository.a c() {
        return (com.socure.docv.capturesdk.common.network.repository.a) this.d.getValue();
    }
}
