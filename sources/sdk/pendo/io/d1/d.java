package sdk.pendo.io.d1;

import java.util.Map;
import javax.crypto.spec.SecretKeySpec;
import sdk.pendo.io.d1.b;

/* loaded from: classes6.dex */
public class d extends b {
    private byte[] v0;

    public d(Map<String, Object> map) {
        super(map);
        this.v0 = new sdk.pendo.io.u0.b().a(b.b(map, "k"));
        this.u0 = new SecretKeySpec(this.v0, "AES");
        a("k");
    }

    private String g() {
        return sdk.pendo.io.u0.b.b(this.v0);
    }

    @Override // sdk.pendo.io.d1.b
    protected void a(Map<String, Object> map, b.EnumC0109b enumC0109b) {
        if (b.EnumC0109b.INCLUDE_SYMMETRIC.compareTo(enumC0109b) >= 0) {
            map.put("k", g());
        }
    }

    @Override // sdk.pendo.io.d1.b
    public String c() {
        return "oct";
    }
}
