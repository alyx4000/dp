package sdk.pendo.io.t4;

import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.List;

/* loaded from: classes6.dex */
interface i1 {
    String a(List<String> list);

    sdk.pendo.io.r4.l a(String[] strArr, Principal[] principalArr);

    void a(o0 o0Var);

    void a(x0 x0Var, sdk.pendo.io.y4.a1 a1Var, y yVar, v0 v0Var);

    sdk.pendo.io.r4.l b(String[] strArr, Principal[] principalArr);

    e b();

    void checkClientTrusted(X509Certificate[] x509CertificateArr, String str);

    void checkServerTrusted(X509Certificate[] x509CertificateArr, String str);

    String e();

    boolean getEnableSessionCreation();

    String getPeerHost();

    int getPeerPort();
}
