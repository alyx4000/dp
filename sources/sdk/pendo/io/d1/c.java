package sdk.pendo.io.d1;

import io.sentry.protocol.ViewHierarchyNode;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;
import org.bouncycastle.jcajce.spec.XDHParameterSpec;
import sdk.pendo.io.i1.i;
import sdk.pendo.io.k1.g;

/* loaded from: classes6.dex */
public class c extends e {
    static final Set<String> D0 = new HashSet(Arrays.asList(EdDSAParameterSpec.Ed448, EdDSAParameterSpec.Ed25519, "EdDSA", XDHParameterSpec.X25519, XDHParameterSpec.X448, "XDH"));
    private final String C0;

    public c(Map<String, Object> map) {
        this(map, null);
    }

    @Override // sdk.pendo.io.d1.e
    protected void a(Map<String, Object> map) {
        if (this.w0 != null) {
            map.put("d", sdk.pendo.io.u0.b.b(k().a(this.w0)));
        }
    }

    @Override // sdk.pendo.io.d1.e
    protected void b(Map<String, Object> map) {
        byte[] a2 = k().a(this.u0);
        map.put("crv", this.C0);
        map.put(ViewHierarchyNode.JsonKeys.X, sdk.pendo.io.u0.b.b(a2));
    }

    @Override // sdk.pendo.io.d1.b
    public String c() {
        return "OKP";
    }

    i k() {
        return i.a(this.C0, this.x0, null);
    }

    public c(Map<String, Object> map, String str) {
        super(map, str);
        String a2 = b.a(map, "crv", true);
        this.C0 = a2;
        try {
            i k = k();
            if (k == null) {
                throw new sdk.pendo.io.k1.f("\"" + a2 + "\" is an unknown or unsupported subtype value for the \"crv\" parameter.");
            }
            this.u0 = k.b(sdk.pendo.io.u0.b.d(b.a(map, ViewHierarchyNode.JsonKeys.X, true)), a2);
            g();
            if (map.containsKey("d")) {
                this.w0 = k.a(sdk.pendo.io.u0.b.d(b.a(map, "d", false)), a2);
            }
            a("crv", ViewHierarchyNode.JsonKeys.X, "d");
        } catch (NoClassDefFoundError e) {
            throw new g("Unable to instantiate key for OKP JWK with " + this.C0 + ". " + sdk.pendo.io.k1.b.a(e));
        }
    }
}
