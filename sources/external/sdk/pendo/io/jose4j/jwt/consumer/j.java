package external.sdk.pendo.io.jose4j.jwt.consumer;

import external.sdk.pendo.io.jose4j.jwt.consumer.b;

/* loaded from: classes2.dex */
public class j implements b {
    private static final b.a c = new b.a(14, "No Subject (sub) claim is present.");

    /* renamed from: a, reason: collision with root package name */
    private boolean f759a;
    private String b;

    public j(String str) {
        this(true);
        this.b = str;
    }

    @Override // external.sdk.pendo.io.jose4j.jwt.consumer.b
    public b.a a(g gVar) {
        String h = gVar.c().h();
        if (h == null && this.f759a) {
            return c;
        }
        String str = this.b;
        if (str == null || str.equals(h)) {
            return null;
        }
        return new b.a(15, "Subject (sub) claim value (" + h + ") doesn't match expected value of " + this.b);
    }

    public j(boolean z) {
        this.f759a = z;
    }
}
