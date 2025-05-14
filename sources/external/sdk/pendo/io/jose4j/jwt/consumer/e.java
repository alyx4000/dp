package external.sdk.pendo.io.jose4j.jwt.consumer;

import external.sdk.pendo.io.jose4j.jwt.consumer.b;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes2.dex */
public class e implements b {

    /* renamed from: a, reason: collision with root package name */
    private Set<String> f754a;
    private boolean b;

    public e(String str, boolean z) {
        if (str != null) {
            this.f754a = Collections.singleton(str);
        }
        this.b = z;
    }

    private String a() {
        return this.f754a.size() == 1 ? this.f754a.iterator().next() : "one of " + this.f754a;
    }

    @Override // external.sdk.pendo.io.jose4j.jwt.consumer.b
    public b.a a(g gVar) {
        String d = gVar.c().d();
        if (d == null) {
            if (this.b) {
                return new b.a(11, "No Issuer (iss) claim present.");
            }
            return null;
        }
        Set<String> set = this.f754a;
        if (set == null || set.contains(d)) {
            return null;
        }
        return new b.a(12, "Issuer (iss) claim value (" + d + ") doesn't match expected value of " + a());
    }
}
