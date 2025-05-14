package sdk.pendo.io.l;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\u0006\u0010$\u001a\u00020!¢\u0006\u0004\b%\u0010&J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007HÖ\u0001R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010 \u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010$\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\"\u001a\u0004\b\n\u0010#¨\u0006'"}, d2 = {"Lsdk/pendo/io/l/e;", "", "other", "", "equals", "", "hashCode", "", "toString", "Lsdk/pendo/io/l/f;", "a", "Lsdk/pendo/io/l/f;", "getSctVersion", "()Lcom/appmattus/certificatetransparency/internal/verifier/model/Version;", "sctVersion", "Lsdk/pendo/io/l/d;", "b", "Lsdk/pendo/io/l/d;", "getId", "()Lcom/appmattus/certificatetransparency/internal/verifier/model/LogId;", "id", "", "c", "J", "e", "()J", "timestamp", "Lsdk/pendo/io/l/a;", "d", "Lsdk/pendo/io/l/a;", "getSignature", "()Lcom/appmattus/certificatetransparency/internal/verifier/model/DigitallySigned;", "signature", "", "[B", "()[B", "extensions", "<init>", "(Lcom/appmattus/certificatetransparency/internal/verifier/model/Version;Lcom/appmattus/certificatetransparency/internal/verifier/model/LogId;JLcom/appmattus/certificatetransparency/internal/verifier/model/DigitallySigned;[B)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final /* data */ class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final f sctVersion;

    /* renamed from: b, reason: from kotlin metadata */
    private final d id;

    /* renamed from: c, reason: from kotlin metadata */
    private final long timestamp;

    /* renamed from: d, reason: from kotlin metadata */
    private final a signature;

    /* renamed from: e, reason: from kotlin metadata */
    private final byte[] extensions;

    public e(f sctVersion, d id, long j, a signature, byte[] extensions) {
        Intrinsics.checkNotNullParameter(sctVersion, "sctVersion");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(extensions, "extensions");
        this.sctVersion = sctVersion;
        this.id = id;
        this.timestamp = j;
        this.signature = signature;
        this.extensions = extensions;
    }

    /* renamed from: a, reason: from getter */
    public final byte[] getExtensions() {
        return this.extensions;
    }

    /* renamed from: b, reason: from getter */
    public final d getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public final f getSctVersion() {
        return this.sctVersion;
    }

    /* renamed from: d, reason: from getter */
    public final a getSignature() {
        return this.signature;
    }

    /* renamed from: e, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(e.class, other != null ? other.getClass() : null)) {
            return false;
        }
        if (other == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.appmattus.certificatetransparency.internal.verifier.model.SignedCertificateTimestamp");
        }
        e eVar = (e) other;
        return this.sctVersion == eVar.sctVersion && Intrinsics.areEqual(this.id, eVar.id) && this.timestamp == eVar.timestamp && Intrinsics.areEqual(this.signature, eVar.signature) && Arrays.equals(this.extensions, eVar.extensions);
    }

    public int hashCode() {
        return (((((((this.sctVersion.hashCode() * 31) + this.id.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31) + this.signature.hashCode()) * 31) + Arrays.hashCode(this.extensions);
    }

    public String toString() {
        return "SignedCertificateTimestamp(sctVersion=" + this.sctVersion + ", id=" + this.id + ", timestamp=" + this.timestamp + ", signature=" + this.signature + ", extensions=" + Arrays.toString(this.extensions) + ')';
    }
}
