package sdk.pendo.io.f;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.f.k;
import sdk.pendo.io.m.b;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/f/w;", "Lsdk/pendo/io/m/b$a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lsdk/pendo/io/f/k$a;", "a", "Lsdk/pendo/io/f/k$a;", "getSignatureResult", "()Lcom/appmattus/certificatetransparency/internal/loglist/LogServerSignatureResult$Invalid;", "signatureResult", "<init>", "(Lcom/appmattus/certificatetransparency/internal/loglist/LogServerSignatureResult$Invalid;)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final /* data */ class w extends b.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final k.a signatureResult;

    public w(k.a signatureResult) {
        Intrinsics.checkNotNullParameter(signatureResult, "signatureResult");
        this.signatureResult = signatureResult;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof w) && Intrinsics.areEqual(this.signatureResult, ((w) other).signatureResult);
    }

    public int hashCode() {
        return this.signatureResult.hashCode();
    }

    public String toString() {
        return "SignatureVerificationFailed(signatureResult=" + this.signatureResult + ')';
    }
}
