package sdk.pendo.io.j;

import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.m3.p;
import sdk.pendo.io.m3.v;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\u001f\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\u0000\u0082\u0002\u0010\n\u000e\b\u0000\u0012\u0002\u0018\u0000\u001a\u0006\u0010\u0000\"\u00020\u0002\u001a\u001f\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0000\u0082\u0002\u0010\n\u000e\b\u0000\u0012\u0002\u0018\u0000\u001a\u0006\u0010\u0000\"\u00020\u0002\u001a\u001f\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0000\u0082\u0002\u0010\n\u000e\b\u0000\u0012\u0002\u0018\u0000\u001a\u0006\u0010\u0000\"\u00020\u0002\u001a\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0000H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0000\u001a\f\u0010\n\u001a\u00020\t*\u00020\u0000H\u0002¨\u0006\u000b"}, d2 = {"Ljava/security/cert/Certificate;", "", "Ljava/security/cert/X509Certificate;", "c", "b", "a", "Lsdk/pendo/io/l/c;", "d", "preCertificate", "", "e", "certificatetransparency"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class b {
    public static final boolean a(Certificate certificate) {
        Intrinsics.checkNotNullParameter(certificate, "<this>");
        if (!(certificate instanceof X509Certificate)) {
            return false;
        }
        Set<String> nonCriticalExtensionOIDs = ((X509Certificate) certificate).getNonCriticalExtensionOIDs();
        return nonCriticalExtensionOIDs != null && nonCriticalExtensionOIDs.contains("1.3.6.1.4.1.11129.2.4.2");
    }

    public static final boolean b(Certificate certificate) {
        Intrinsics.checkNotNullParameter(certificate, "<this>");
        if (!(certificate instanceof X509Certificate)) {
            return false;
        }
        Set<String> criticalExtensionOIDs = ((X509Certificate) certificate).getCriticalExtensionOIDs();
        return criticalExtensionOIDs != null && criticalExtensionOIDs.contains("1.3.6.1.4.1.11129.2.4.3");
    }

    public static final boolean c(Certificate certificate) {
        Intrinsics.checkNotNullParameter(certificate, "<this>");
        if (!(certificate instanceof X509Certificate)) {
            return false;
        }
        List<String> extendedKeyUsage = ((X509Certificate) certificate).getExtendedKeyUsage();
        return extendedKeyUsage != null && extendedKeyUsage.contains("1.3.6.1.4.1.11129.2.4.4");
    }

    public static final sdk.pendo.io.l.c d(Certificate certificate) {
        Intrinsics.checkNotNullParameter(certificate, "<this>");
        return new sdk.pendo.io.l.c(null, e(certificate), null, false, 5, null);
    }

    private static final byte[] e(Certificate certificate) {
        PublicKey publicKey = certificate.getPublicKey();
        Intrinsics.checkNotNullExpressionValue(publicKey, "publicKey");
        return g.a(publicKey);
    }

    public static final sdk.pendo.io.l.c a(Certificate certificate, Certificate preCertificate) {
        Intrinsics.checkNotNullParameter(certificate, "<this>");
        Intrinsics.checkNotNullParameter(preCertificate, "preCertificate");
        p pVar = new p(certificate.getEncoded());
        try {
            sdk.pendo.io.e4.b a2 = sdk.pendo.io.e4.b.a(pVar.b());
            sdk.pendo.io.e4.e i = a2.i().i();
            sdk.pendo.io.l.c cVar = new sdk.pendo.io.l.c(a2.h(), e(preCertificate), i != null ? i.a(new v("2.5.29.35")) : null, true);
            CloseableKt.closeFinally(pVar, null);
            return cVar;
        } finally {
        }
    }
}
