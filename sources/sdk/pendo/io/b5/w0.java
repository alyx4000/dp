package sdk.pendo.io.b5;

import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;

/* loaded from: classes6.dex */
class w0 {
    static String a(String str) {
        int indexOf = str.indexOf(45);
        return (indexOf <= 0 || str.startsWith("SHA3")) ? str : str.substring(0, indexOf) + str.substring(indexOf + 1);
    }

    static AlgorithmParameterSpec a(int i, String str, sdk.pendo.io.p4.b bVar) {
        return new PSSParameterSpec(str, "MGF1", new MGF1ParameterSpec(str), sdk.pendo.io.z4.k.d(i), 1);
    }
}
