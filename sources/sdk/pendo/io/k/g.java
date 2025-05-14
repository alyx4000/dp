package sdk.pendo.io.k;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.b.d;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/k/g;", "Lsdk/pendo/io/b/d$a$a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getSctLogId", "()Ljava/lang/String;", "sctLogId", "b", "getLogServerId", "logServerId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final /* data */ class g extends d.a.C0083a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String sctLogId;

    /* renamed from: b, reason: from kotlin metadata */
    private final String logServerId;

    public g(String sctLogId, String logServerId) {
        Intrinsics.checkNotNullParameter(sctLogId, "sctLogId");
        Intrinsics.checkNotNullParameter(logServerId, "logServerId");
        this.sctLogId = sctLogId;
        this.logServerId = logServerId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof g)) {
            return false;
        }
        g gVar = (g) other;
        return Intrinsics.areEqual(this.sctLogId, gVar.sctLogId) && Intrinsics.areEqual(this.logServerId, gVar.logServerId);
    }

    public int hashCode() {
        return (this.sctLogId.hashCode() * 31) + this.logServerId.hashCode();
    }

    public String toString() {
        return "Log ID of SCT, " + this.sctLogId + ", does not match this log's ID, " + this.logServerId;
    }
}
