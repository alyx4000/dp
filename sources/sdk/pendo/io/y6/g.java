package sdk.pendo.io.y6;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.y6.c;
import sdk.pendo.io.y6.g;

/* loaded from: classes4.dex */
final class g extends c.a {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final Executor f1826a;

    class a implements c<Object, sdk.pendo.io.y6.b<?>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f1827a;
        final /* synthetic */ Executor b;

        a(Type type, Executor executor) {
            this.f1827a = type;
            this.b = executor;
        }

        @Override // sdk.pendo.io.y6.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public sdk.pendo.io.y6.b<Object> a(sdk.pendo.io.y6.b<Object> bVar) {
            Executor executor = this.b;
            return executor == null ? bVar : new b(executor, bVar);
        }

        @Override // sdk.pendo.io.y6.c
        public Type a() {
            return this.f1827a;
        }
    }

    static final class b<T> implements sdk.pendo.io.y6.b<T> {
        final Executor f;
        final sdk.pendo.io.y6.b<T> s;

        class a implements d<T> {
            final /* synthetic */ d f;

            a(d dVar) {
                this.f = dVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void a(d dVar, Throwable th) {
                dVar.a(b.this, th);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void a(d dVar, r rVar) {
                if (b.this.s.e()) {
                    dVar.a(b.this, new IOException("Canceled"));
                } else {
                    dVar.a(b.this, rVar);
                }
            }

            @Override // sdk.pendo.io.y6.d
            public void a(sdk.pendo.io.y6.b<T> bVar, final Throwable th) {
                Executor executor = b.this.f;
                final d dVar = this.f;
                executor.execute(new Runnable() { // from class: sdk.pendo.io.y6.g$b$a$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.b.a.this.a(dVar, th);
                    }
                });
            }

            @Override // sdk.pendo.io.y6.d
            public void a(sdk.pendo.io.y6.b<T> bVar, final r<T> rVar) {
                Executor executor = b.this.f;
                final d dVar = this.f;
                executor.execute(new Runnable() { // from class: sdk.pendo.io.y6.g$b$a$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.b.a.this.a(dVar, rVar);
                    }
                });
            }
        }

        b(Executor executor, sdk.pendo.io.y6.b<T> bVar) {
            this.f = executor;
            this.s = bVar;
        }

        @Override // sdk.pendo.io.y6.b
        public void a(d<T> dVar) {
            Objects.requireNonNull(dVar, "callback == null");
            this.s.a(new a(dVar));
        }

        @Override // sdk.pendo.io.y6.b
        public r<T> b() {
            return this.s.b();
        }

        @Override // sdk.pendo.io.y6.b
        public void cancel() {
            this.s.cancel();
        }

        @Override // sdk.pendo.io.y6.b
        public boolean e() {
            return this.s.e();
        }

        @Override // sdk.pendo.io.y6.b
        public b0 a() {
            return this.s.a();
        }

        @Override // sdk.pendo.io.y6.b
        public sdk.pendo.io.y6.b<T> clone() {
            return new b(this.f, this.s.clone());
        }
    }

    g(@Nullable Executor executor) {
        this.f1826a = executor;
    }

    @Override // sdk.pendo.io.y6.c.a
    @Nullable
    public c<?, ?> a(Type type, Annotation[] annotationArr, s sVar) {
        if (c.a.a(type) != sdk.pendo.io.y6.b.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new a(w.b(0, (ParameterizedType) type), w.a(annotationArr, (Class<? extends Annotation>) u.class) ? null : this.f1826a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
