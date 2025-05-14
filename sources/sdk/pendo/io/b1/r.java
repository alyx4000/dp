package sdk.pendo.io.b1;

import java.security.Key;
import java.security.PrivateKey;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import sdk.pendo.io.d1.b;

/* loaded from: classes6.dex */
public class r extends t {

    public static class a extends r {
        public a() {
            super("RSA/ECB/PKCS1Padding", "RSA1_5");
        }
    }

    public static class b extends r {
        public b() {
            super("RSA/ECB/OAEPWithSHA-256AndMGF1Padding", "RSA-OAEP-256");
            a(new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
        }

        @Override // sdk.pendo.io.b1.r, sdk.pendo.io.a1.a
        public boolean d() {
            try {
                return a(b.a.a("{\"kty\":\"RSA\",\"n\":\"sXchDaQebHnPiGvyDOAT4saGEUetSyo9MKLOoWFsueri23bOdgWp4Dy1WlUzewbgBHod5pcM9H95GQRV3JDXboIRROSBigeC5yjU1hGzHHyXss8UDprecbAYxknTcQkhslANGRUZmdTOQ5qTRsLAt6BTYuyvVRdhS8exSZEy_c4gs_7svlJJQ4H9_NxsiIoLwAEk7-Q3UXERGYw_75IDrGA84-lA_-Ct4eTlXHBIY2EaV7t7LjJaynVJCpkv4LKjTTAumiGUIuQhrNhZLuF_RJLqHpM2kgWFLU7-VTdL1VbC2tejvcI2BlMkEpk1BzBZI0KQB0GaDWFLN-aEAw3vRw\",\"e\":\"AQAB\"}").a(), new i(16, "AES"), (sdk.pendo.io.h1.b) null, (byte[]) null, new sdk.pendo.io.w0.a()) != null;
            } catch (sdk.pendo.io.k1.g e) {
                this.f.a(c() + " is not available due to " + sdk.pendo.io.k1.b.a(e));
                return false;
            }
        }
    }

    public static class c extends r {
        public c() {
            super("RSA/ECB/OAEPWithSHA-1AndMGF1Padding", "RSA-OAEP");
        }
    }

    public r(String str, String str2) {
        super(str, str2);
        c("RSA");
        a(sdk.pendo.io.i1.h.ASYMMETRIC);
    }

    @Override // sdk.pendo.io.b1.p
    public void a(Key key, g gVar) {
        sdk.pendo.io.h1.d.a((PrivateKey) sdk.pendo.io.h1.d.a(key, PrivateKey.class));
    }

    @Override // sdk.pendo.io.a1.a
    public boolean d() {
        try {
            return f.a(e(), null) != null;
        } catch (sdk.pendo.io.k1.g unused) {
            return false;
        }
    }
}
