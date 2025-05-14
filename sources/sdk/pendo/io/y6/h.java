package sdk.pendo.io.y6;

import java.util.Objects;

/* loaded from: classes4.dex */
public class h extends RuntimeException {
    private final transient r<?> A;
    private final int f;
    private final String s;

    public h(r<?> rVar) {
        super(a(rVar));
        this.f = rVar.b();
        this.s = rVar.e();
        this.A = rVar;
    }

    private static String a(r<?> rVar) {
        Objects.requireNonNull(rVar, "response == null");
        return "HTTP " + rVar.b() + " " + rVar.e();
    }
}
