package sdk.pendo.io.e1;

import java.security.PublicKey;
import java.security.Security;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;

/* loaded from: classes6.dex */
public class g extends sdk.pendo.io.e1.a {

    public static class a extends g {
        public a() {
            super("PS256", g.d("SHA256withRSAandMGF1"));
            if (e().equals("RSASSA-PSS")) {
                MGF1ParameterSpec mGF1ParameterSpec = MGF1ParameterSpec.SHA256;
                a(new PSSParameterSpec(mGF1ParameterSpec.getDigestAlgorithm(), "MGF1", mGF1ParameterSpec, 32, 1));
            }
        }
    }

    public static class b extends g {
        public b() {
            super("PS384", g.d("SHA384withRSAandMGF1"));
            if (e().equals("RSASSA-PSS")) {
                MGF1ParameterSpec mGF1ParameterSpec = MGF1ParameterSpec.SHA384;
                a(new PSSParameterSpec(mGF1ParameterSpec.getDigestAlgorithm(), "MGF1", mGF1ParameterSpec, 48, 1));
            }
        }
    }

    public static class c extends g {
        public c() {
            super("PS512", g.d("SHA512withRSAandMGF1"));
            if (e().equals("RSASSA-PSS")) {
                MGF1ParameterSpec mGF1ParameterSpec = MGF1ParameterSpec.SHA512;
                a(new PSSParameterSpec(mGF1ParameterSpec.getDigestAlgorithm(), "MGF1", mGF1ParameterSpec, 64, 1));
            }
        }
    }

    public static class d extends g {
        public d() {
            super("RS256", "SHA256withRSA");
        }
    }

    public static class e extends g {
        public e() {
            super("RS384", "SHA384withRSA");
        }
    }

    public static class f extends g {
        public f() {
            super("RS512", "SHA512withRSA");
        }
    }

    public g(String str, String str2) {
        super(str, str2, "RSA");
    }

    static String d(String str) {
        return (!Security.getAlgorithms("Signature").contains("RSASSA-PSS") || Boolean.getBoolean("external.sdk.pendo.io.jose4j.jws.use-legacy-rsapss-alg-names")) ? str : "RSASSA-PSS";
    }

    @Override // sdk.pendo.io.e1.a
    public void a(PublicKey publicKey) {
        sdk.pendo.io.h1.d.a(publicKey);
    }
}
