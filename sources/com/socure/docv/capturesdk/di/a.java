package com.socure.docv.capturesdk.di;

import android.app.Application;
import com.socure.docv.capturesdk.common.config.model.Model;
import com.socure.docv.capturesdk.common.utils.ConstantsKt;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.socure.docv.capturesdk.core.pipeline.model.SelfieRange;
import com.socure.docv.capturesdk.di.a;
import com.socure.docv.capturesdk.feature.scanner.data.Container;
import com.socure.docv.capturesdk.feature.scanner.data.Dimension;
import com.socure.docv.capturesdk.feature.scanner.data.GuidingBox;
import com.socure.docv.capturesdk.feature.scanner.data.ViewDimensions;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class a implements com.socure.docv.capturesdk.di.c {

    /* renamed from: a, reason: collision with root package name */
    public final Application f402a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public ViewDimensions l;
    public List<SelfieRange> m;

    /* renamed from: com.socure.docv.capturesdk.di.a$a, reason: collision with other inner class name */
    public static final class C0040a extends Lambda implements Function0<com.socure.docv.capturesdk.core.provider.interfaces.d<Float>> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0040a f403a = new C0040a();

        public C0040a() {
            super(0);
        }

        public static final float b() {
            return 0.45f;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.socure.docv.capturesdk.core.provider.interfaces.d<Float> invoke() {
            return new com.socure.docv.capturesdk.core.provider.interfaces.d() { // from class: com.socure.docv.capturesdk.di.a$a$$ExternalSyntheticLambda0
                @Override // com.socure.docv.capturesdk.core.provider.interfaces.d
                public final Object a() {
                    return Float.valueOf(a.C0040a.b());
                }
            };
        }
    }

    public static final class b extends Lambda implements Function0<com.socure.docv.capturesdk.core.provider.a> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public com.socure.docv.capturesdk.core.provider.a invoke() {
            a aVar = a.this;
            return new com.socure.docv.capturesdk.core.provider.a(aVar.f402a, ConstantsKt.DEFAULT_BLUR_MODEL_FILE_NAME, (com.socure.docv.capturesdk.core.provider.interfaces.d) aVar.d.getValue(), 1);
        }
    }

    public static final class c extends Lambda implements Function0<com.socure.docv.capturesdk.core.provider.interfaces.d<Float>> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f405a = new c();

        public c() {
            super(0);
        }

        public static final float b() {
            return 0.5f;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.socure.docv.capturesdk.core.provider.interfaces.d<Float> invoke() {
            return new com.socure.docv.capturesdk.core.provider.interfaces.d() { // from class: com.socure.docv.capturesdk.di.a$c$$ExternalSyntheticLambda0
                @Override // com.socure.docv.capturesdk.core.provider.interfaces.d
                public final Object a() {
                    return Float.valueOf(a.c.b());
                }
            };
        }
    }

    public static final class d extends Lambda implements Function0<com.socure.docv.capturesdk.core.provider.a> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public com.socure.docv.capturesdk.core.provider.a invoke() {
            a aVar = a.this;
            return new com.socure.docv.capturesdk.core.provider.a(aVar.f402a, ConstantsKt.DEFAULT_CORNER_MODEL_FILE_NAME, (com.socure.docv.capturesdk.core.provider.interfaces.d) aVar.b.getValue(), 2);
        }
    }

    public static final class e extends Lambda implements Function0<com.socure.docv.capturesdk.core.provider.interfaces.d<Float>> {

        /* renamed from: a, reason: collision with root package name */
        public static final e f407a = new e();

        public e() {
            super(0);
        }

        public static final float b() {
            return 0.0f;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.socure.docv.capturesdk.core.provider.interfaces.d<Float> invoke() {
            return new com.socure.docv.capturesdk.core.provider.interfaces.d() { // from class: com.socure.docv.capturesdk.di.a$e$$ExternalSyntheticLambda0
                @Override // com.socure.docv.capturesdk.core.provider.interfaces.d
                public final Object a() {
                    return Float.valueOf(a.e.b());
                }
            };
        }
    }

    public static final class f extends Lambda implements Function0<com.socure.docv.capturesdk.core.provider.a> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public com.socure.docv.capturesdk.core.provider.a invoke() {
            a aVar = a.this;
            return new com.socure.docv.capturesdk.core.provider.a(aVar.f402a, ConstantsKt.DEFAULT_GLARE_INTENSITY_MODEL_FILE_NAME, (com.socure.docv.capturesdk.core.provider.interfaces.d) aVar.i.getValue(), 1);
        }
    }

    public static final class g extends Lambda implements Function0<com.socure.docv.capturesdk.core.provider.interfaces.d<Float>> {

        /* renamed from: a, reason: collision with root package name */
        public static final g f409a = new g();

        public g() {
            super(0);
        }

        public static final float b() {
            return 0.5f;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.socure.docv.capturesdk.core.provider.interfaces.d<Float> invoke() {
            return new com.socure.docv.capturesdk.core.provider.interfaces.d() { // from class: com.socure.docv.capturesdk.di.a$g$$ExternalSyntheticLambda0
                @Override // com.socure.docv.capturesdk.core.provider.interfaces.d
                public final Object a() {
                    return Float.valueOf(a.g.b());
                }
            };
        }
    }

    public static final class h extends Lambda implements Function0<com.socure.docv.capturesdk.core.provider.a> {
        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public com.socure.docv.capturesdk.core.provider.a invoke() {
            a aVar = a.this;
            return new com.socure.docv.capturesdk.core.provider.a(aVar.f402a, ConstantsKt.DEFAULT_GLARE_MODEL_FILE_NAME, (com.socure.docv.capturesdk.core.provider.interfaces.d) aVar.f.getValue(), 2);
        }
    }

    public static final class i extends Lambda implements Function0<com.socure.docv.capturesdk.feature.orchestrator.a> {
        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public com.socure.docv.capturesdk.feature.orchestrator.a invoke() {
            return new com.socure.docv.capturesdk.feature.orchestrator.a(new com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.e(new com.socure.docv.capturesdk.feature.orchestrator.presentation.viewmodel.c(a.this.f402a)));
        }
    }

    public static final class j extends Lambda implements Function0<com.socure.docv.capturesdk.di.b> {

        /* renamed from: a, reason: collision with root package name */
        public static final j f412a = new j();

        public j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public com.socure.docv.capturesdk.di.b invoke() {
            return new com.socure.docv.capturesdk.di.b();
        }
    }

    public a(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.f402a = application;
        this.b = LazyKt.lazy(c.f405a);
        this.c = LazyKt.lazy(new d());
        this.d = LazyKt.lazy(C0040a.f403a);
        this.e = LazyKt.lazy(new b());
        this.f = LazyKt.lazy(g.f409a);
        this.g = LazyKt.lazy(new h());
        this.h = LazyKt.lazy(new f());
        this.i = LazyKt.lazy(e.f407a);
        MapsKt.emptyMap();
        this.j = LazyKt.lazy(new i());
        this.k = LazyKt.lazy(j.f412a);
        this.l = new ViewDimensions(new Container(1, 1), new GuidingBox(1, 1, 0, 0, new Dimension(1.0d, 1.0d)), true);
        this.m = UtilsKt.getDefaultSelfieRangeValues();
    }

    @Override // com.socure.docv.capturesdk.di.c
    public com.socure.docv.capturesdk.core.provider.interfaces.d<Model> a() {
        return (com.socure.docv.capturesdk.core.provider.interfaces.d) this.c.getValue();
    }

    @Override // com.socure.docv.capturesdk.di.c
    public void a(ViewDimensions viewDimensions) {
        Intrinsics.checkNotNullParameter(viewDimensions, "<set-?>");
        this.l = viewDimensions;
    }

    @Override // com.socure.docv.capturesdk.di.c
    public void a(List<SelfieRange> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.m = list;
    }

    @Override // com.socure.docv.capturesdk.di.c
    public com.socure.docv.capturesdk.core.provider.interfaces.d<Model> b() {
        return (com.socure.docv.capturesdk.core.provider.interfaces.d) this.g.getValue();
    }

    @Override // com.socure.docv.capturesdk.di.c
    public Application c() {
        return this.f402a;
    }

    @Override // com.socure.docv.capturesdk.di.c
    public com.socure.docv.capturesdk.core.provider.interfaces.d<Model> d() {
        return (com.socure.docv.capturesdk.core.provider.interfaces.d) this.e.getValue();
    }

    @Override // com.socure.docv.capturesdk.di.c
    public com.socure.docv.capturesdk.feature.orchestrator.a e() {
        return (com.socure.docv.capturesdk.feature.orchestrator.a) this.j.getValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && Intrinsics.areEqual(this.f402a, ((a) obj).f402a);
    }

    @Override // com.socure.docv.capturesdk.di.c
    public List<SelfieRange> f() {
        return this.m;
    }

    @Override // com.socure.docv.capturesdk.di.c
    public com.socure.docv.capturesdk.common.network.repository.b g() {
        return (com.socure.docv.capturesdk.common.network.repository.b) this.k.getValue();
    }

    @Override // com.socure.docv.capturesdk.di.c
    public com.socure.docv.capturesdk.core.provider.interfaces.d<Model> h() {
        return (com.socure.docv.capturesdk.core.provider.interfaces.d) this.h.getValue();
    }

    public int hashCode() {
        return this.f402a.hashCode();
    }

    @Override // com.socure.docv.capturesdk.di.c
    public ViewDimensions i() {
        return this.l;
    }

    public String toString() {
        return "AppDependencyGraph(application=" + this.f402a + ")";
    }
}
