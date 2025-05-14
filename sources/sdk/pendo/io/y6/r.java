package sdk.pendo.io.y6;

import java.util.Objects;
import javax.annotation.Nullable;
import sdk.pendo.io.w2.a0;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.e0;
import sdk.pendo.io.y6.l;

/* loaded from: classes4.dex */
public final class r<T> {

    /* renamed from: a, reason: collision with root package name */
    private final d0 f1855a;

    @Nullable
    private final T b;

    @Nullable
    private final e0 c;

    private r(d0 d0Var, @Nullable T t, @Nullable e0 e0Var) {
        this.f1855a = d0Var;
        this.b = t;
        this.c = e0Var;
    }

    @Nullable
    public T a() {
        return this.b;
    }

    public int b() {
        return this.f1855a.getCode();
    }

    @Nullable
    public e0 c() {
        return this.c;
    }

    public boolean d() {
        return this.f1855a.s();
    }

    public String e() {
        return this.f1855a.getMessage();
    }

    public String toString() {
        return this.f1855a.toString();
    }

    public static <T> r<T> a(int i, e0 e0Var) {
        Objects.requireNonNull(e0Var, "body == null");
        if (i >= 400) {
            return a(e0Var, new d0.a().a(new l.c(e0Var.getS(), e0Var.getA())).a(i).a("Response.error()").a(a0.HTTP_1_1).a(new b0.a().b("http://localhost/").a()).a());
        }
        throw new IllegalArgumentException("code < 400: " + i);
    }

    public static <T> r<T> a(e0 e0Var, d0 d0Var) {
        Objects.requireNonNull(e0Var, "body == null");
        Objects.requireNonNull(d0Var, "rawResponse == null");
        if (d0Var.s()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new r<>(d0Var, null, e0Var);
    }

    public static <T> r<T> a(@Nullable T t, d0 d0Var) {
        Objects.requireNonNull(d0Var, "rawResponse == null");
        if (d0Var.s()) {
            return new r<>(d0Var, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }
}
