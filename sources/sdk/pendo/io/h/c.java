package sdk.pendo.io.h;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.f.k;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\b¨\u0006\f"}, d2 = {"Lsdk/pendo/io/h/c;", "", "", "message", "signature", "Lsdk/pendo/io/f/k;", "a", "Ljava/security/PublicKey;", "Ljava/security/PublicKey;", "publicKey", "<init>", "(Ljava/security/PublicKey;)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final PublicKey publicKey;

    public c(PublicKey publicKey) {
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        this.publicKey = publicKey;
    }

    public final k a(byte[] message, byte[] signature) {
        k dVar;
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(signature, "signature");
        try {
            Signature signature2 = Signature.getInstance("SHA256withRSA");
            signature2.initVerify(this.publicKey);
            signature2.update(message);
            return signature2.verify(signature) ? k.b.f1055a : k.a.c.f1053a;
        } catch (InvalidKeyException e) {
            dVar = new k.a.b(e);
            return dVar;
        } catch (NoSuchAlgorithmException e2) {
            dVar = new k.a.C0129a(e2);
            return dVar;
        } catch (SignatureException e3) {
            dVar = new k.a.d(e3);
            return dVar;
        }
    }

    public /* synthetic */ c(PublicKey publicKey, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? sdk.pendo.io.f.b.a() : publicKey);
    }
}
