package sdk.pendo.io.l;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007HÖ\u0001R\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/l/d;", "", "other", "", "equals", "", "hashCode", "", "toString", "", "a", "[B", "()[B", "keyId", "<init>", "([B)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final /* data */ class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final byte[] keyId;

    public d(byte[] keyId) {
        Intrinsics.checkNotNullParameter(keyId, "keyId");
        this.keyId = keyId;
    }

    /* renamed from: a, reason: from getter */
    public final byte[] getKeyId() {
        return this.keyId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(d.class, other != null ? other.getClass() : null)) {
            return false;
        }
        if (other != null) {
            return Arrays.equals(this.keyId, ((d) other).keyId);
        }
        throw new NullPointerException("null cannot be cast to non-null type com.appmattus.certificatetransparency.internal.verifier.model.LogId");
    }

    public int hashCode() {
        return Arrays.hashCode(this.keyId);
    }

    public String toString() {
        return "LogId(keyId=" + Arrays.toString(this.keyId) + ')';
    }
}
