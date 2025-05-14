package sdk.pendo.io.j;

import java.io.ByteArrayInputStream;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.m3.a0;
import sdk.pendo.io.m3.s1;
import sdk.pendo.io.m3.w;
import sdk.pendo.io.y4.l3;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0000\u001a\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¨\u0006\u0006"}, d2 = {"Ljava/security/cert/X509Certificate;", "", "Lsdk/pendo/io/l/e;", "a", "", "extensionValue", "certificatetransparency"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class j {
    private static final List<sdk.pendo.io.l.e> a(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        l3.d(byteArrayInputStream);
        while (byteArrayInputStream.available() > 2) {
            byte[] sctBytes = l3.b(byteArrayInputStream);
            sdk.pendo.io.i.a aVar = sdk.pendo.io.i.a.f1170a;
            Intrinsics.checkNotNullExpressionValue(sctBytes, "sctBytes");
            arrayList.add(aVar.b(new ByteArrayInputStream(sctBytes)));
        }
        return CollectionsKt.toList(arrayList);
    }

    public static final List<sdk.pendo.io.l.e> a(X509Certificate x509Certificate) {
        Intrinsics.checkNotNullParameter(x509Certificate, "<this>");
        a0 a2 = a0.a(w.a((Object) x509Certificate.getExtensionValue("1.3.6.1.4.1.11129.2.4.2")).k());
        if (a2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type org.bouncycastle.asn1.DEROctetString");
        }
        byte[] k = ((s1) a2).k();
        Intrinsics.checkNotNullExpressionValue(k, "p.octets");
        return a(k);
    }
}
