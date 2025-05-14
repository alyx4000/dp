package sdk.pendo.io.j;

import java.security.PublicKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¨\u0006\u0003"}, d2 = {"Ljava/security/PublicKey;", "", "a", "certificatetransparency"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class g {
    public static final byte[] a(PublicKey publicKey) {
        Intrinsics.checkNotNullParameter(publicKey, "<this>");
        byte[] digest = new sdk.pendo.io.n4.b().digest(publicKey.getEncoded());
        Intrinsics.checkNotNullExpressionValue(digest, "Digest().digest(encoded)");
        return digest;
    }
}
