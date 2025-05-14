package sdk.pendo.io.k;

import androidx.core.view.ViewCompat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.b.d;
import sdk.pendo.io.m3.j1;
import sdk.pendo.io.m3.p;
import sdk.pendo.io.m3.v;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001d¢\u0006\u0004\b \u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0018\u0010\u0007\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\f\u0010\u0007\u001a\u00020\u0013*\u00020\u0012H\u0002J\u0018\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u0007\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0014\u0010\u0007\u001a\u00020\u0019*\u00020\u00182\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001e\u0010\u0007\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\fH\u0016J'\u0010\u0007\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001e¨\u0006#"}, d2 = {"Lsdk/pendo/io/k/i;", "", "Ljava/security/cert/X509Certificate;", "preCertificate", "Lsdk/pendo/io/l/c;", "issuerInformation", "Lsdk/pendo/io/e4/h;", "a", "Lsdk/pendo/io/e4/e;", "extensions", "Lsdk/pendo/io/e4/d;", "replacementX509authorityKeyIdentifier", "", "Lsdk/pendo/io/l/e;", "sct", "", "toVerify", "Lsdk/pendo/io/b/d;", "Lsdk/pendo/io/e4/b;", "", "Ljava/security/cert/Certificate;", "certificate", "preCertBytes", "issuerKeyHash", "Ljava/io/OutputStream;", "", "chain", "issuerInfo", "(Lsdk/pendo/io/l/e;Ljava/security/cert/X509Certificate;Lsdk/pendo/io/l/c;)Lsdk/pendo/io/b/d;", "Lsdk/pendo/io/m/d;", "Lsdk/pendo/io/m/d;", "logServer", "<init>", "(Lcom/appmattus/certificatetransparency/loglist/LogServer;)V", "b", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final sdk.pendo.io.m.d logServer;

    public i(sdk.pendo.io.m.d logServer) {
        Intrinsics.checkNotNullParameter(logServer, "logServer");
        this.logServer = logServer;
    }

    private final sdk.pendo.io.e4.h a(X509Certificate preCertificate, sdk.pendo.io.l.c issuerInformation) {
        boolean z = true;
        if (!(preCertificate.getVersion() >= 3)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        p pVar = new p(preCertificate.getEncoded());
        try {
            sdk.pendo.io.e4.b parsedPreCertificate = sdk.pendo.io.e4.b.a(pVar.b());
            Intrinsics.checkNotNullExpressionValue(parsedPreCertificate, "parsedPreCertificate");
            if (a(parsedPreCertificate) && issuerInformation.getIssuedByPreCertificateSigningCert()) {
                if (issuerInformation.getX509authorityKeyIdentifier() == null) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            sdk.pendo.io.e4.e i = parsedPreCertificate.i().i();
            Intrinsics.checkNotNullExpressionValue(i, "parsedPreCertificate.tbsCertificate.extensions");
            List<sdk.pendo.io.e4.d> a2 = a(i, issuerInformation.getX509authorityKeyIdentifier());
            sdk.pendo.io.e4.j jVar = new sdk.pendo.io.e4.j();
            sdk.pendo.io.e4.h i2 = parsedPreCertificate.i();
            jVar.a(i2.l());
            jVar.a(i2.m());
            sdk.pendo.io.c4.c name = issuerInformation.getName();
            if (name == null) {
                name = i2.j();
            }
            jVar.a(name);
            jVar.b(i2.n());
            jVar.a(i2.h());
            jVar.b(i2.o());
            jVar.a(i2.p());
            jVar.a((j1) i2.k());
            jVar.b((j1) i2.q());
            Object[] array = a2.toArray(new sdk.pendo.io.e4.d[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            jVar.a(new sdk.pendo.io.e4.e((sdk.pendo.io.e4.d[]) array));
            sdk.pendo.io.e4.h a3 = jVar.a();
            CloseableKt.closeFinally(pVar, null);
            Intrinsics.checkNotNullExpressionValue(a3, "ASN1InputStream(preCerti…BSCertificate()\n        }");
            return a3;
        } finally {
        }
    }

    private final List<sdk.pendo.io.e4.d> a(sdk.pendo.io.e4.e extensions, sdk.pendo.io.e4.d replacementX509authorityKeyIdentifier) {
        v[] h = extensions.h();
        Intrinsics.checkNotNullExpressionValue(h, "extensions.extensionOIDs");
        ArrayList arrayList = new ArrayList();
        for (v vVar : h) {
            if (!Intrinsics.areEqual(vVar.l(), "1.3.6.1.4.1.11129.2.4.3")) {
                arrayList.add(vVar);
            }
        }
        ArrayList<v> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!Intrinsics.areEqual(((v) obj).l(), "1.3.6.1.4.1.11129.2.4.2")) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (v vVar2 : arrayList2) {
            arrayList3.add((!Intrinsics.areEqual(vVar2.l(), "2.5.29.35") || replacementX509authorityKeyIdentifier == null) ? extensions.a(vVar2) : replacementX509authorityKeyIdentifier);
        }
        return arrayList3;
    }

    private final boolean a(sdk.pendo.io.e4.b bVar) {
        return bVar.i().i().a(new v("2.5.29.35")) != null;
    }

    private final void a(OutputStream outputStream, sdk.pendo.io.l.e eVar) {
        if (!(eVar.getSctVersion() == sdk.pendo.io.l.f.V1)) {
            throw new IllegalArgumentException("Can only serialize SCT v1 for now.".toString());
        }
        sdk.pendo.io.i.c.a(outputStream, eVar.getSctVersion().getNumber(), 1);
        sdk.pendo.io.i.c.a(outputStream, 0L, 1);
        sdk.pendo.io.i.c.a(outputStream, eVar.getTimestamp(), 8);
    }

    private final byte[] a(Certificate certificate, sdk.pendo.io.l.e sct) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a(byteArrayOutputStream, sct);
            sdk.pendo.io.i.c.a(byteArrayOutputStream, 0L, 2);
            byte[] encoded = certificate.getEncoded();
            Intrinsics.checkNotNullExpressionValue(encoded, "certificate.encoded");
            sdk.pendo.io.i.c.a(byteArrayOutputStream, encoded, ViewCompat.MEASURED_SIZE_MASK);
            sdk.pendo.io.i.c.a(byteArrayOutputStream, sct.getExtensions(), 65535);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            CloseableKt.closeFinally(byteArrayOutputStream, null);
            Intrinsics.checkNotNullExpressionValue(byteArray, "ByteArrayOutputStream().…t.toByteArray()\n        }");
            return byteArray;
        } finally {
        }
    }

    private final byte[] a(byte[] preCertBytes, byte[] issuerKeyHash, sdk.pendo.io.l.e sct) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a(byteArrayOutputStream, sct);
            sdk.pendo.io.i.c.a(byteArrayOutputStream, 1L, 2);
            byteArrayOutputStream.write(issuerKeyHash);
            sdk.pendo.io.i.c.a(byteArrayOutputStream, preCertBytes, ViewCompat.MEASURED_SIZE_MASK);
            sdk.pendo.io.i.c.a(byteArrayOutputStream, sct.getExtensions(), 65535);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            CloseableKt.closeFinally(byteArrayOutputStream, null);
            Intrinsics.checkNotNullExpressionValue(byteArray, "ByteArrayOutputStream().…t.toByteArray()\n        }");
            return byteArray;
        } finally {
        }
    }

    public final sdk.pendo.io.b.d a(sdk.pendo.io.l.e sct, X509Certificate certificate, sdk.pendo.io.l.c issuerInfo) {
        b bVar;
        Intrinsics.checkNotNullParameter(sct, "sct");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        Intrinsics.checkNotNullParameter(issuerInfo, "issuerInfo");
        try {
            byte[] g = a(certificate, issuerInfo).g();
            Intrinsics.checkNotNullExpressionValue(g, "preCertificateTBS.encoded");
            return a(sct, a(g, issuerInfo.getKeyHash(), sct));
        } catch (IOException e) {
            bVar = new b(e);
            return bVar;
        } catch (CertificateException e2) {
            bVar = new b(e2);
            return bVar;
        }
    }

    private final sdk.pendo.io.b.d a(sdk.pendo.io.l.e sct, byte[] toVerify) {
        String str;
        sdk.pendo.io.b.d lVar;
        if (Intrinsics.areEqual(this.logServer.getCom.amplitude.reactnative.DatabaseConstants.KEY_FIELD java.lang.String().getAlgorithm(), "EC")) {
            str = "SHA256withECDSA";
        } else {
            if (!Intrinsics.areEqual(this.logServer.getCom.amplitude.reactnative.DatabaseConstants.KEY_FIELD java.lang.String().getAlgorithm(), "RSA")) {
                String algorithm = this.logServer.getCom.amplitude.reactnative.DatabaseConstants.KEY_FIELD java.lang.String().getAlgorithm();
                Intrinsics.checkNotNullExpressionValue(algorithm, "logServer.key.algorithm");
                return new m(algorithm, null, 2, null);
            }
            str = "SHA256withRSA";
        }
        try {
            Signature signature = Signature.getInstance(str);
            signature.initVerify(this.logServer.getCom.amplitude.reactnative.DatabaseConstants.KEY_FIELD java.lang.String());
            signature.update(toVerify);
            return signature.verify(sct.getSignature().getSignature()) ? d.b.f872a : d.a.b.f868a;
        } catch (InvalidKeyException e) {
            lVar = new h(e);
            return lVar;
        } catch (NoSuchAlgorithmException e2) {
            lVar = new m(str, e2);
            return lVar;
        } catch (SignatureException e3) {
            lVar = new l(e3);
            return lVar;
        }
    }

    public sdk.pendo.io.b.d a(sdk.pendo.io.l.e sct, List<? extends Certificate> chain) {
        sdk.pendo.io.l.c d;
        b bVar;
        Intrinsics.checkNotNullParameter(sct, "sct");
        Intrinsics.checkNotNullParameter(chain, "chain");
        long currentTimeMillis = System.currentTimeMillis();
        if (sct.getTimestamp() > currentTimeMillis) {
            return new d.a.C0084d(sct.getTimestamp(), currentTimeMillis);
        }
        if (this.logServer.getValidUntil() != null && sct.getTimestamp() > this.logServer.getValidUntil().longValue()) {
            return new d.a.e(sct.getTimestamp(), this.logServer.getValidUntil().longValue());
        }
        if (!Arrays.equals(this.logServer.getId(), sct.getId().getKeyId())) {
            String a2 = sdk.pendo.io.e5.a.a(sct.getId().getKeyId());
            Intrinsics.checkNotNullExpressionValue(a2, "toBase64String(sct.id.keyId)");
            String a3 = sdk.pendo.io.e5.a.a(this.logServer.getId());
            Intrinsics.checkNotNullExpressionValue(a3, "toBase64String(logServer.id)");
            return new g(a2, a3);
        }
        Certificate certificate = chain.get(0);
        if (!sdk.pendo.io.j.b.b(certificate) && !sdk.pendo.io.j.b.a(certificate)) {
            try {
                return a(sct, a(certificate, sct));
            } catch (IOException e) {
                bVar = new b(e);
                return bVar;
            } catch (CertificateEncodingException e2) {
                bVar = new b(e2);
                return bVar;
            }
        }
        if (chain.size() < 2) {
            return j.f1246a;
        }
        Certificate certificate2 = chain.get(1);
        try {
            if (!sdk.pendo.io.j.b.c(certificate2)) {
                try {
                    d = sdk.pendo.io.j.b.d(certificate2);
                } catch (NoSuchAlgorithmException e3) {
                    return new m("SHA-256", e3);
                }
            } else {
                if (chain.size() < 3) {
                    return k.f1247a;
                }
                try {
                    d = sdk.pendo.io.j.b.a(certificate2, chain.get(2));
                } catch (IOException e4) {
                    return new a(e4);
                } catch (NoSuchAlgorithmException e5) {
                    return new m("SHA-256", e5);
                } catch (CertificateEncodingException e6) {
                    return new b(e6);
                }
            }
            return a(sct, (X509Certificate) certificate, d);
        } catch (CertificateParsingException e7) {
            return new c(e7);
        }
    }
}
