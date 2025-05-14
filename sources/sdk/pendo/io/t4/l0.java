package sdk.pendo.io.t4;

import java.util.Set;

/* loaded from: classes6.dex */
class l0 extends x {
    static final l0 d = new l0(true);
    static final l0 e = new l0(false);
    private final boolean c;

    private l0(boolean z) {
        this.c = z;
    }

    @Override // sdk.pendo.io.t4.x, sdk.pendo.io.t4.b
    public Set<String> a(String str) {
        d a2;
        return (!str.startsWith("TLS_") || (a2 = p0.a(str)) == null || sdk.pendo.io.y4.r.a(a2.a())) ? super.a(str) : this.c ? a2.b() : a2.c();
    }
}
