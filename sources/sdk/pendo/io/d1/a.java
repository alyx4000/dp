package sdk.pendo.io.d1;

import io.sentry.protocol.ViewHierarchyNode;
import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Map;

/* loaded from: classes6.dex */
public class a extends e {
    private String C0;

    public a(Map<String, Object> map) {
        this(map, null);
    }

    private int k() {
        return (int) Math.ceil(sdk.pendo.io.i1.e.a(l()).getCurve().getField().getFieldSize() / 8.0d);
    }

    @Override // sdk.pendo.io.d1.e
    protected void a(Map<String, Object> map) {
        ECPrivateKey n = n();
        if (n != null) {
            a(map, "d", n.getS(), k());
        }
    }

    @Override // sdk.pendo.io.d1.e
    protected void b(Map<String, Object> map) {
        ECPoint w = m().getW();
        int k = k();
        a(map, ViewHierarchyNode.JsonKeys.X, w.getAffineX(), k);
        a(map, ViewHierarchyNode.JsonKeys.Y, w.getAffineY(), k);
        map.put("crv", l());
    }

    @Override // sdk.pendo.io.d1.b
    public String c() {
        return "EC";
    }

    public String l() {
        return this.C0;
    }

    public ECPublicKey m() {
        return (ECPublicKey) this.u0;
    }

    public ECPrivateKey n() {
        return (ECPrivateKey) this.w0;
    }

    public a(Map<String, Object> map, String str) {
        super(map, str);
        String a2 = b.a(map, "crv", true);
        this.C0 = a2;
        ECParameterSpec a3 = sdk.pendo.io.i1.e.a(a2);
        if (a3 == null) {
            throw new sdk.pendo.io.k1.f("\"" + this.C0 + "\" is an unknown or unsupported value for the \"crv\" parameter.");
        }
        BigInteger b = b(map, ViewHierarchyNode.JsonKeys.X, true);
        BigInteger b2 = b(map, ViewHierarchyNode.JsonKeys.Y, true);
        sdk.pendo.io.i1.c cVar = new sdk.pendo.io.i1.c(str, null);
        this.u0 = cVar.a(b, b2, a3);
        g();
        if (map.containsKey("d")) {
            this.w0 = cVar.a(b(map, "d", false), a3);
        }
        a("crv", ViewHierarchyNode.JsonKeys.X, ViewHierarchyNode.JsonKeys.Y, "d");
    }
}
