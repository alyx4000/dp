package sdk.pendo.io.y6;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.Unit;
import sdk.pendo.io.w2.c0;
import sdk.pendo.io.w2.e0;
import sdk.pendo.io.y6.f;

/* loaded from: classes4.dex */
final class a extends f.a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f1815a = true;

    /* renamed from: sdk.pendo.io.y6.a$a, reason: collision with other inner class name */
    static final class C0273a implements sdk.pendo.io.y6.f<e0, e0> {

        /* renamed from: a, reason: collision with root package name */
        static final C0273a f1816a = new C0273a();

        C0273a() {
        }

        @Override // sdk.pendo.io.y6.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e0 convert(e0 e0Var) {
            try {
                return w.a(e0Var);
            } finally {
                e0Var.close();
            }
        }
    }

    static final class b implements sdk.pendo.io.y6.f<c0, c0> {

        /* renamed from: a, reason: collision with root package name */
        static final b f1817a = new b();

        b() {
        }

        @Override // sdk.pendo.io.y6.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c0 convert(c0 c0Var) {
            return c0Var;
        }
    }

    static final class c implements sdk.pendo.io.y6.f<e0, e0> {

        /* renamed from: a, reason: collision with root package name */
        static final c f1818a = new c();

        c() {
        }

        @Override // sdk.pendo.io.y6.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e0 convert(e0 e0Var) {
            return e0Var;
        }
    }

    static final class d implements sdk.pendo.io.y6.f<Object, String> {

        /* renamed from: a, reason: collision with root package name */
        static final d f1819a = new d();

        d() {
        }

        @Override // sdk.pendo.io.y6.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    static final class e implements sdk.pendo.io.y6.f<e0, Unit> {

        /* renamed from: a, reason: collision with root package name */
        static final e f1820a = new e();

        e() {
        }

        @Override // sdk.pendo.io.y6.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit convert(e0 e0Var) {
            e0Var.close();
            return Unit.INSTANCE;
        }
    }

    static final class f implements sdk.pendo.io.y6.f<e0, Void> {

        /* renamed from: a, reason: collision with root package name */
        static final f f1821a = new f();

        f() {
        }

        @Override // sdk.pendo.io.y6.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void convert(e0 e0Var) {
            e0Var.close();
            return null;
        }
    }

    a() {
    }

    @Override // sdk.pendo.io.y6.f.a
    @Nullable
    public sdk.pendo.io.y6.f<?, c0> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
        if (c0.class.isAssignableFrom(w.b(type))) {
            return b.f1817a;
        }
        return null;
    }

    @Override // sdk.pendo.io.y6.f.a
    @Nullable
    public sdk.pendo.io.y6.f<e0, ?> responseBodyConverter(Type type, Annotation[] annotationArr, s sVar) {
        if (type == e0.class) {
            return w.a(annotationArr, (Class<? extends Annotation>) sdk.pendo.io.z6.w.class) ? c.f1818a : C0273a.f1816a;
        }
        if (type == Void.class) {
            return f.f1821a;
        }
        if (!this.f1815a || type != Unit.class) {
            return null;
        }
        try {
            return e.f1820a;
        } catch (NoClassDefFoundError unused) {
            this.f1815a = false;
            return null;
        }
    }
}
