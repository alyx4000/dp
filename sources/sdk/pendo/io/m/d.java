package sdk.pendo.io.m;

import com.amplitude.reactnative.DatabaseConstants;
import java.security.PublicKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.j.g;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u000fB\u001b\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003J&\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018¨\u0006\u001d"}, d2 = {"Lsdk/pendo/io/m/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/security/PublicKey;", DatabaseConstants.KEY_FIELD, "", "validUntil", "copy", "(Ljava/security/PublicKey;Ljava/lang/Long;)Lcom/appmattus/certificatetransparency/loglist/LogServer;", "a", "Ljava/security/PublicKey;", "b", "()Ljava/security/PublicKey;", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "", "[B", "()[B", "id", "<init>", "(Ljava/security/PublicKey;Ljava/lang/Long;)V", "d", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final /* data */ class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final PublicKey key;

    /* renamed from: b, reason: from kotlin metadata */
    private final Long validUntil;

    /* renamed from: c, reason: from kotlin metadata */
    private final byte[] id;

    public d(PublicKey key, Long l) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.validUntil = l;
        this.id = g.a(key);
    }

    /* renamed from: a, reason: from getter */
    public final byte[] getId() {
        return this.id;
    }

    /* renamed from: b, reason: from getter */
    public final PublicKey getKey() {
        return this.key;
    }

    /* renamed from: c, reason: from getter */
    public final Long getValidUntil() {
        return this.validUntil;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof d)) {
            return false;
        }
        d dVar = (d) other;
        return Intrinsics.areEqual(this.key, dVar.key) && Intrinsics.areEqual(this.validUntil, dVar.validUntil);
    }

    public int hashCode() {
        int hashCode = this.key.hashCode() * 31;
        Long l = this.validUntil;
        return hashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        return "LogServer(key=" + this.key + ", validUntil=" + this.validUntil + ')';
    }
}
