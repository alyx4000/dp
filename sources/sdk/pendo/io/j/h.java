package sdk.pendo.io.j;

import java.io.StringReader;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.m3.d0;
import sdk.pendo.io.m3.k2;
import sdk.pendo.io.m3.v;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004¨\u0006\f"}, d2 = {"Lsdk/pendo/io/j/h;", "", "", "keyBytes", "", "a", "bytes", "Ljava/security/PublicKey;", "b", "keyText", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f1214a = new h();

    private h() {
    }

    private final String a(byte[] keyBytes) {
        Object nextElement = d0.a((Object) keyBytes).m().nextElement();
        if (nextElement == null) {
            throw new NullPointerException("null cannot be cast to non-null type org.bouncycastle.asn1.DLSequence");
        }
        Object nextElement2 = ((k2) nextElement).m().nextElement();
        if (nextElement2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type org.bouncycastle.asn1.ASN1ObjectIdentifier");
        }
        v vVar = (v) nextElement2;
        if (Intrinsics.areEqual(vVar, sdk.pendo.io.y3.a.b)) {
            return "RSA";
        }
        if (Intrinsics.areEqual(vVar, sdk.pendo.io.f4.h.l)) {
            return "EC";
        }
        throw new IllegalArgumentException("Unsupported key type " + vVar);
    }

    public final PublicKey b(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        PublicKey generatePublic = KeyFactory.getInstance(a(bytes)).generatePublic(new X509EncodedKeySpec(bytes));
        Intrinsics.checkNotNullExpressionValue(generatePublic, "keyFactory.generatePubli…509EncodedKeySpec(bytes))");
        return generatePublic;
    }

    public final PublicKey a(String keyText) {
        Intrinsics.checkNotNullParameter(keyText, "keyText");
        byte[] pemContent = new sdk.pendo.io.g5.c(new StringReader(keyText)).a().a();
        Intrinsics.checkNotNullExpressionValue(pemContent, "pemContent");
        return b(pemContent);
    }
}
