package sdk.pendo.io.d1;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sdk.pendo.io.d1.b;
import sdk.pendo.io.i1.k;
import sdk.pendo.io.k1.g;
import sdk.pendo.io.k1.h;

/* loaded from: classes6.dex */
public abstract class e extends b {
    private String A0;
    private String B0;
    protected boolean v0;
    protected PrivateKey w0;
    protected String x0;
    private List<X509Certificate> y0;
    private String z0;

    public static class a {
        public static e a(String str) {
            return a(str, (String) null);
        }

        public static e a(String str, String str2) {
            return a(sdk.pendo.io.x0.a.a(str), str2);
        }

        public static e a(Map<String, Object> map, String str) {
            String b;
            b = b.b(map, "kty");
            b.hashCode();
            b.hashCode();
            switch (b) {
                case "EC":
                    return new sdk.pendo.io.d1.a(map, str);
                case "OKP":
                    return new c(map, str);
                case "RSA":
                    return new f(map, str);
                default:
                    throw new g("Unknown key type (for public keys): '" + b + "'");
            }
        }
    }

    protected e(PublicKey publicKey) {
        super(publicKey);
    }

    protected abstract void a(Map<String, Object> map);

    @Override // sdk.pendo.io.d1.b
    protected void a(Map<String, Object> map, b.EnumC0109b enumC0109b) {
        b(map);
        if (this.y0 != null) {
            k kVar = new k();
            ArrayList arrayList = new ArrayList(this.y0.size());
            Iterator<X509Certificate> it = this.y0.iterator();
            while (it.hasNext()) {
                arrayList.add(kVar.a(it.next()));
            }
            map.put("x5c", arrayList);
        }
        a("x5t", this.z0, map);
        a("x5t#S256", this.A0, map);
        a("x5u", this.B0, map);
        if (this.v0 || enumC0109b == b.EnumC0109b.INCLUDE_PRIVATE) {
            a(map);
        }
    }

    BigInteger b(Map<String, Object> map, String str, boolean z) {
        return sdk.pendo.io.i1.b.a(b.a(map, str, z));
    }

    protected abstract void b(Map<String, Object> map);

    void g() {
        X509Certificate h = h();
        if ((h == null || h.getPublicKey().equals(j())) ? false : true) {
            throw new IllegalArgumentException("The key in the first certificate MUST match the bare public key represented by other members of the JWK. Public key = " + j() + " cert = " + h);
        }
    }

    public X509Certificate h() {
        List<X509Certificate> list = this.y0;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.y0.get(0);
    }

    public PrivateKey i() {
        return this.w0;
    }

    public PublicKey j() {
        return (PublicKey) this.u0;
    }

    protected e(Map<String, Object> map, String str) {
        super(map);
        this.x0 = str;
        if (map.containsKey("x5c")) {
            List<String> c = h.c(map, "x5c");
            this.y0 = new ArrayList(c.size());
            k b = k.b(str);
            Iterator<String> it = c.iterator();
            while (it.hasNext()) {
                this.y0.add(b.a(it.next()));
            }
        }
        this.z0 = b.a(map, "x5t");
        this.A0 = b.a(map, "x5t#S256");
        this.B0 = b.a(map, "x5u");
        a("x5c", "x5t#S256", "x5t", "x5u");
    }

    void a(Map<String, Object> map, String str, BigInteger bigInteger) {
        map.put(str, sdk.pendo.io.i1.b.a(bigInteger));
    }

    void a(Map<String, Object> map, String str, BigInteger bigInteger, int i) {
        map.put(str, sdk.pendo.io.i1.b.a(bigInteger, i));
    }
}
