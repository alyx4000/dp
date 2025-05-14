package sdk.pendo.io.l;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import sdk.pendo.io.events.ConditionData;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\n\u0010B#\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007HÖ\u0001R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\n\u0010\u0018¨\u0006\u001c"}, d2 = {"Lsdk/pendo/io/l/a;", "", "other", "", "equals", "", "hashCode", "", "toString", "Lsdk/pendo/io/l/a$a;", "a", "Lsdk/pendo/io/l/a$a;", "getHashAlgorithm", "()Lcom/appmattus/certificatetransparency/internal/verifier/model/DigitallySigned$HashAlgorithm;", "hashAlgorithm", "Lsdk/pendo/io/l/a$b;", "b", "Lsdk/pendo/io/l/a$b;", "getSignatureAlgorithm", "()Lcom/appmattus/certificatetransparency/internal/verifier/model/DigitallySigned$SignatureAlgorithm;", "signatureAlgorithm", "", "c", "[B", "()[B", "signature", "<init>", "(Lcom/appmattus/certificatetransparency/internal/verifier/model/DigitallySigned$HashAlgorithm;Lcom/appmattus/certificatetransparency/internal/verifier/model/DigitallySigned$SignatureAlgorithm;[B)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final /* data */ class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final EnumC0173a hashAlgorithm;

    /* renamed from: b, reason: from kotlin metadata */
    private final b signatureAlgorithm;

    /* renamed from: c, reason: from kotlin metadata */
    private final byte[] signature;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/l/a$a;", "", "", ConditionData.NUMBER_VALUE, "I", "b", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "NONE", MessageDigestAlgorithms.MD5, "SHA1", "SHA224", "SHA256", "SHA384", "SHA512", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    /* renamed from: sdk.pendo.io.l.a$a, reason: collision with other inner class name */
    public enum EnumC0173a {
        NONE(0),
        MD5(1),
        SHA1(2),
        SHA224(3),
        SHA256(4),
        SHA384(5),
        SHA512(6);


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int number;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lsdk/pendo/io/l/a$a$a;", "", "", ConditionData.NUMBER_VALUE, "Lsdk/pendo/io/l/a$a;", "a", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        /* renamed from: sdk.pendo.io.l.a$a$a, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final EnumC0173a a(int number) {
                for (EnumC0173a enumC0173a : EnumC0173a.values()) {
                    if (enumC0173a.getNumber() == number) {
                        return enumC0173a;
                    }
                }
                return null;
            }
        }

        EnumC0173a(int i) {
            this.number = i;
        }

        /* renamed from: b, reason: from getter */
        public final int getNumber() {
            return this.number;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/l/a$b;", "", "", ConditionData.NUMBER_VALUE, "I", "b", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "ANONYMOUS", "RSA", "DSA", "ECDSA", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    public enum b {
        ANONYMOUS(0),
        RSA(1),
        DSA(2),
        ECDSA(3);


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int number;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lsdk/pendo/io/l/a$b$a;", "", "", ConditionData.NUMBER_VALUE, "Lsdk/pendo/io/l/a$b;", "a", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        /* renamed from: sdk.pendo.io.l.a$b$a, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final b a(int number) {
                for (b bVar : b.values()) {
                    if (bVar.getNumber() == number) {
                        return bVar;
                    }
                }
                return null;
            }
        }

        b(int i) {
            this.number = i;
        }

        /* renamed from: b, reason: from getter */
        public final int getNumber() {
            return this.number;
        }
    }

    public a(EnumC0173a hashAlgorithm, b signatureAlgorithm, byte[] signature) {
        Intrinsics.checkNotNullParameter(hashAlgorithm, "hashAlgorithm");
        Intrinsics.checkNotNullParameter(signatureAlgorithm, "signatureAlgorithm");
        Intrinsics.checkNotNullParameter(signature, "signature");
        this.hashAlgorithm = hashAlgorithm;
        this.signatureAlgorithm = signatureAlgorithm;
        this.signature = signature;
    }

    /* renamed from: a, reason: from getter */
    public final byte[] getSignature() {
        return this.signature;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(a.class, other != null ? other.getClass() : null)) {
            return false;
        }
        if (other == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.appmattus.certificatetransparency.internal.verifier.model.DigitallySigned");
        }
        a aVar = (a) other;
        return this.hashAlgorithm == aVar.hashAlgorithm && this.signatureAlgorithm == aVar.signatureAlgorithm && Arrays.equals(this.signature, aVar.signature);
    }

    public int hashCode() {
        return (((this.hashAlgorithm.hashCode() * 31) + this.signatureAlgorithm.hashCode()) * 31) + Arrays.hashCode(this.signature);
    }

    public String toString() {
        return "DigitallySigned(hashAlgorithm=" + this.hashAlgorithm + ", signatureAlgorithm=" + this.signatureAlgorithm + ", signature=" + Arrays.toString(this.signature) + ')';
    }
}
