package sdk.pendo.io.i1;

import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes6.dex */
public class a extends SecretKeySpec {
    public a(byte[] bArr) {
        super(bArr, "AES");
    }

    public String toString() {
        return sdk.pendo.io.k1.a.a(getEncoded().length) + " bit AES key";
    }
}
