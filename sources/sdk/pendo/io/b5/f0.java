package sdk.pendo.io.b5;

import java.security.Provider;
import java.security.Security;
import sdk.pendo.io.y4.h1;
import sdk.pendo.io.y4.i1;

/* loaded from: classes6.dex */
class f0 {
    static String a(i1 i1Var) {
        return sdk.pendo.io.y4.i0.a(i1Var.a()) + "WITH" + sdk.pendo.io.d5.i.d(h1.b(i1Var.b()));
    }

    static boolean a(Provider provider) {
        return provider != null && a(provider.getName());
    }

    static boolean a() {
        return Security.getProvider("SunMSCAPI") != null;
    }

    static boolean a(String str) {
        return "SunMSCAPI".equals(str);
    }
}
