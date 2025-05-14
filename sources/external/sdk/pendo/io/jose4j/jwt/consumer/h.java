package external.sdk.pendo.io.jose4j.jwt.consumer;

import external.sdk.pendo.io.jose4j.jwt.consumer.b;

/* loaded from: classes2.dex */
public class h implements b {
    private static final b.a i = new b.a(2, "No Expiration Time (exp) claim present.");
    private static final b.a j = new b.a(3, "No Issued At (iat) claim present.");
    private static final b.a k = new b.a(4, "No Not Before (nbf) claim present.");

    /* renamed from: a, reason: collision with root package name */
    private boolean f757a;
    private boolean b;
    private boolean c;
    private sdk.pendo.io.f1.d d;
    private int e = 0;
    private int f = 0;
    private Integer g;
    private Integer h;

    private String a() {
        return this.e > 0 ? " (even when providing " + this.e + " seconds of leeway to account for clock skew)." : ".";
    }

    @Override // external.sdk.pendo.io.jose4j.jwt.consumer.b
    public b.a a(g gVar) {
        sdk.pendo.io.f1.b c = gVar.c();
        sdk.pendo.io.f1.d b = c.b();
        sdk.pendo.io.f1.d c2 = c.c();
        sdk.pendo.io.f1.d f = c.f();
        if (this.f757a && b == null) {
            return i;
        }
        if (this.b && c2 == null) {
            return j;
        }
        if (this.c && f == null) {
            return k;
        }
        sdk.pendo.io.f1.d dVar = this.d;
        if (dVar == null) {
            dVar = sdk.pendo.io.f1.d.d();
        }
        if (b != null) {
            if (sdk.pendo.io.k1.i.b(dVar.b(), this.e) >= b.b()) {
                return new b.a(1, "The JWT is no longer valid - the evaluation time " + dVar + " is on or after the Expiration Time (exp=" + b + ") claim value" + a());
            }
            if (c2 != null && b.a(c2)) {
                return new b.a(17, "The Expiration Time (exp=" + b + ") claim value cannot be before the Issued At (iat=" + c2 + ") claim value.");
            }
            if (f != null && b.a(f)) {
                return new b.a(17, "The Expiration Time (exp=" + b + ") claim value cannot be before the Not Before (nbf=" + f + ") claim value.");
            }
            if (this.f > 0 && sdk.pendo.io.k1.i.b(sdk.pendo.io.k1.i.b(b.b(), this.e), dVar.b()) > this.f * 60) {
                return new b.a(5, "The Expiration Time (exp=" + b + ") claim value cannot be more than " + this.f + " minutes in the future relative to the evaluation time " + dVar + a());
            }
        }
        if (f != null && sdk.pendo.io.k1.i.a(dVar.b(), this.e) < f.b()) {
            return new b.a(6, "The JWT is not yet valid as the evaluation time " + dVar + " is before the Not Before (nbf=" + f + ") claim time" + a());
        }
        if (c2 == null) {
            return null;
        }
        if (this.g != null && sdk.pendo.io.k1.i.b(sdk.pendo.io.k1.i.b(c2.b(), dVar.b()), this.e) > this.g.intValue()) {
            return new b.a(23, "iat " + c2 + " is more than " + this.g + " second(s) ahead of now " + dVar + a());
        }
        if (this.h == null || sdk.pendo.io.k1.i.b(sdk.pendo.io.k1.i.b(dVar.b(), c2.b()), this.e) <= this.h.intValue()) {
            return null;
        }
        return new b.a(24, "As of now " + dVar + " iat " + c2 + " is more than " + this.h + " second(s) in the past" + a());
    }
}
