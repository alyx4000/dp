package sdk.pendo.io.f7;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import sdk.pendo.io.d6.j;

/* loaded from: classes6.dex */
public class f {

    /* JADX INFO: Add missing generic type declarations: [R] */
    class a<R> implements j<R> {
        final /* synthetic */ Object f;

        a(Object obj) {
            this.f = obj;
        }

        @Override // sdk.pendo.io.d6.j
        public boolean test(R r) {
            return r.equals(this.f);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    class b<R> implements sdk.pendo.io.d6.b<R, R, Boolean> {
        b() {
        }

        @Override // sdk.pendo.io.d6.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(R r, R r2) {
            return Boolean.valueOf(r2.equals(r));
        }
    }

    @Nonnull
    @CheckReturnValue
    public static <T, R> d<T> a(@Nonnull sdk.pendo.io.x5.j<R> jVar) {
        return new d<>(jVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <R> sdk.pendo.io.x5.j<Boolean> b(sdk.pendo.io.x5.j<R> jVar, sdk.pendo.io.d6.h<R, R> hVar) {
        return sdk.pendo.io.x5.j.a(jVar.c(1L).c((sdk.pendo.io.d6.h<? super R, ? extends R>) hVar), jVar.b(1L), new b()).d(c.f1083a).a((j) c.b);
    }

    @Nonnull
    @CheckReturnValue
    public static <T, R> d<T> a(@Nonnull sdk.pendo.io.x5.j<R> jVar, @Nonnull sdk.pendo.io.d6.h<R, R> hVar) {
        sdk.pendo.io.g7.a.a(jVar, "lifecycle == null");
        sdk.pendo.io.g7.a.a(hVar, "correspondingEvents == null");
        return a(b((sdk.pendo.io.x5.j) jVar.j(), (sdk.pendo.io.d6.h) hVar));
    }

    private static <R> sdk.pendo.io.x5.j<R> b(sdk.pendo.io.x5.j<R> jVar, R r) {
        return jVar.a(new a(r));
    }

    @Nonnull
    @CheckReturnValue
    public static <T, R> d<T> a(@Nonnull sdk.pendo.io.x5.j<R> jVar, @Nonnull R r) {
        sdk.pendo.io.g7.a.a(jVar, "lifecycle == null");
        sdk.pendo.io.g7.a.a(r, "event == null");
        return a(b(jVar, r));
    }
}
