package external.sdk.pendo.io.jose4j.jwt.consumer;

import external.sdk.pendo.io.jose4j.jwt.consumer.b;

/* loaded from: classes2.dex */
public class f implements b {
    private static final b.a b = new b.a(13, "The JWT ID (jti) claim is not present.");

    /* renamed from: a, reason: collision with root package name */
    private boolean f755a;

    public f(boolean z) {
        this.f755a = z;
    }

    @Override // external.sdk.pendo.io.jose4j.jwt.consumer.b
    public b.a a(g gVar) {
        if (gVar.c().e() == null && this.f755a) {
            return b;
        }
        return null;
    }
}
