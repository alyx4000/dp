package sdk.pendo.io.d1;

import com.facebook.common.callercontext.ContextChain;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;
import sdk.pendo.io.i1.j;

/* loaded from: classes6.dex */
public class f extends e {
    public f(RSAPublicKey rSAPublicKey) {
        super(rSAPublicKey);
    }

    @Override // sdk.pendo.io.d1.e
    protected void a(Map<String, Object> map) {
        RSAPrivateKey k = k();
        if (k != null) {
            a(map, "d", k.getPrivateExponent());
            if (k instanceof RSAPrivateCrtKey) {
                RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) k;
                a(map, ContextChain.TAG_PRODUCT, rSAPrivateCrtKey.getPrimeP());
                a(map, "q", rSAPrivateCrtKey.getPrimeQ());
                a(map, "dp", rSAPrivateCrtKey.getPrimeExponentP());
                a(map, "dq", rSAPrivateCrtKey.getPrimeExponentQ());
                a(map, "qi", rSAPrivateCrtKey.getCrtCoefficient());
            }
        }
    }

    @Override // sdk.pendo.io.d1.e
    protected void b(Map<String, Object> map) {
        RSAPublicKey l = l();
        a(map, "n", l.getModulus());
        a(map, "e", l.getPublicExponent());
    }

    @Override // sdk.pendo.io.d1.b
    public String c() {
        return "RSA";
    }

    public RSAPrivateKey k() {
        return (RSAPrivateKey) this.w0;
    }

    public RSAPublicKey l() {
        return (RSAPublicKey) this.u0;
    }

    public f(Map<String, Object> map) {
        this(map, null);
    }

    public f(Map<String, Object> map, String str) {
        super(map, str);
        BigInteger b = b(map, "n", true);
        BigInteger b2 = b(map, "e", true);
        j jVar = new j(str, null);
        this.u0 = jVar.b(b, b2);
        g();
        if (map.containsKey("d")) {
            BigInteger b3 = b(map, "d", false);
            this.w0 = map.containsKey(ContextChain.TAG_PRODUCT) ? jVar.a(b, b2, b3, b(map, ContextChain.TAG_PRODUCT, false), b(map, "q", false), b(map, "dp", false), b(map, "dq", false), b(map, "qi", false)) : jVar.a(b, b3);
        }
        a("n", "e", "d", ContextChain.TAG_PRODUCT, "q", "dp", "dq", "qi");
    }
}
