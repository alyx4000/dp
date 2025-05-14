package sdk.pendo.io.k;

import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.b.d;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/k/m;", "Lsdk/pendo/io/b/d$a$c;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getAlgorithm", "()Ljava/lang/String;", "algorithm", "Ljava/security/NoSuchAlgorithmException;", "b", "Ljava/security/NoSuchAlgorithmException;", "()Ljava/security/NoSuchAlgorithmException;", "exception", "<init>", "(Ljava/lang/String;Ljava/security/NoSuchAlgorithmException;)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final /* data */ class m extends d.a.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String algorithm;

    /* renamed from: b, reason: from kotlin metadata */
    private final NoSuchAlgorithmException exception;

    public m(String algorithm, NoSuchAlgorithmException noSuchAlgorithmException) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        this.algorithm = algorithm;
        this.exception = noSuchAlgorithmException;
    }

    /* renamed from: a, reason: from getter */
    public NoSuchAlgorithmException getException() {
        return this.exception;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof m)) {
            return false;
        }
        m mVar = (m) other;
        return Intrinsics.areEqual(this.algorithm, mVar.algorithm) && Intrinsics.areEqual(getException(), mVar.getException());
    }

    public int hashCode() {
        return (this.algorithm.hashCode() * 31) + (getException() == null ? 0 : getException().hashCode());
    }

    public String toString() {
        StringBuilder sb;
        String str;
        if (getException() != null) {
            sb = new StringBuilder("Unsupported signature algorithm ").append(this.algorithm).append(" with: ");
            str = sdk.pendo.io.j.c.a(getException());
        } else {
            sb = new StringBuilder("Unsupported signature algorithm ");
            str = this.algorithm;
        }
        return sb.append(str).toString();
    }

    public /* synthetic */ m(String str, NoSuchAlgorithmException noSuchAlgorithmException, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : noSuchAlgorithmException);
    }
}
