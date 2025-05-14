package sdk.pendo.io.k;

import java.security.cert.CertificateParsingException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.b.d;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u001a\u0010\u000e\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/k/c;", "Lsdk/pendo/io/b/d$a$c;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/security/cert/CertificateParsingException;", "a", "Ljava/security/cert/CertificateParsingException;", "()Ljava/security/cert/CertificateParsingException;", "exception", "<init>", "(Ljava/security/cert/CertificateParsingException;)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final /* data */ class c extends d.a.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CertificateParsingException exception;

    public c(CertificateParsingException exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.exception = exception;
    }

    /* renamed from: a, reason: from getter */
    public CertificateParsingException getException() {
        return this.exception;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof c) && Intrinsics.areEqual(getException(), ((c) other).getException());
    }

    public int hashCode() {
        return getException().hashCode();
    }

    public String toString() {
        return "Error parsing cert with: " + sdk.pendo.io.j.c.a(getException());
    }
}
