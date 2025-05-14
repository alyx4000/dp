package sdk.pendo.io.y6;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import sdk.pendo.io.y6.c;

/* loaded from: classes4.dex */
final class e extends c.a {

    /* renamed from: a, reason: collision with root package name */
    static final c.a f1822a = new e();

    private static final class a<R> implements sdk.pendo.io.y6.c<R, CompletableFuture<R>> {

        /* renamed from: a, reason: collision with root package name */
        private final Type f1823a;

        /* renamed from: sdk.pendo.io.y6.e$a$a, reason: collision with other inner class name */
        private class C0274a implements d<R> {
            private final CompletableFuture<R> f;

            public C0274a(CompletableFuture<R> completableFuture) {
                this.f = completableFuture;
            }

            @Override // sdk.pendo.io.y6.d
            public void a(sdk.pendo.io.y6.b<R> bVar, Throwable th) {
                this.f.completeExceptionally(th);
            }

            @Override // sdk.pendo.io.y6.d
            public void a(sdk.pendo.io.y6.b<R> bVar, r<R> rVar) {
                if (rVar.d()) {
                    this.f.complete(rVar.a());
                } else {
                    this.f.completeExceptionally(new h(rVar));
                }
            }
        }

        a(Type type) {
            this.f1823a = type;
        }

        @Override // sdk.pendo.io.y6.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<R> a(sdk.pendo.io.y6.b<R> bVar) {
            b bVar2 = new b(bVar);
            bVar.a(new C0274a(bVar2));
            return bVar2;
        }

        @Override // sdk.pendo.io.y6.c
        public Type a() {
            return this.f1823a;
        }
    }

    private static final class b<T> extends CompletableFuture<T> {

        /* renamed from: a, reason: collision with root package name */
        private final sdk.pendo.io.y6.b<?> f1824a;

        b(sdk.pendo.io.y6.b<?> bVar) {
            this.f1824a = bVar;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z) {
            if (z) {
                this.f1824a.cancel();
            }
            return super.cancel(z);
        }
    }

    private static final class c<R> implements sdk.pendo.io.y6.c<R, CompletableFuture<r<R>>> {

        /* renamed from: a, reason: collision with root package name */
        private final Type f1825a;

        private class a implements d<R> {
            private final CompletableFuture<r<R>> f;

            public a(CompletableFuture<r<R>> completableFuture) {
                this.f = completableFuture;
            }

            @Override // sdk.pendo.io.y6.d
            public void a(sdk.pendo.io.y6.b<R> bVar, Throwable th) {
                this.f.completeExceptionally(th);
            }

            @Override // sdk.pendo.io.y6.d
            public void a(sdk.pendo.io.y6.b<R> bVar, r<R> rVar) {
                this.f.complete(rVar);
            }
        }

        c(Type type) {
            this.f1825a = type;
        }

        @Override // sdk.pendo.io.y6.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<r<R>> a(sdk.pendo.io.y6.b<R> bVar) {
            b bVar2 = new b(bVar);
            bVar.a(new a(bVar2));
            return bVar2;
        }

        @Override // sdk.pendo.io.y6.c
        public Type a() {
            return this.f1825a;
        }
    }

    e() {
    }

    @Override // sdk.pendo.io.y6.c.a
    @Nullable
    public sdk.pendo.io.y6.c<?, ?> a(Type type, Annotation[] annotationArr, s sVar) {
        if (c.a.a(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type a2 = c.a.a(0, (ParameterizedType) type);
        if (c.a.a(a2) != r.class) {
            return new a(a2);
        }
        if (a2 instanceof ParameterizedType) {
            return new c(c.a.a(0, (ParameterizedType) a2));
        }
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
}
