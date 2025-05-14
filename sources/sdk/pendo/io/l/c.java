package sdk.pendo.io.l;

import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007HÖ\u0001R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\n\u0010\u001c¨\u0006 "}, d2 = {"Lsdk/pendo/io/l/c;", "", "other", "", "equals", "", "hashCode", "", "toString", "Lsdk/pendo/io/c4/c;", "a", "Lsdk/pendo/io/c4/c;", "getName", "()Lorg/bouncycastle/asn1/x500/X500Name;", "name", "", "b", "[B", "()[B", "keyHash", "Lsdk/pendo/io/e4/d;", "c", "Lsdk/pendo/io/e4/d;", "getX509authorityKeyIdentifier", "()Lorg/bouncycastle/asn1/x509/Extension;", "x509authorityKeyIdentifier", "d", "Z", "()Z", "issuedByPreCertificateSigningCert", "<init>", "(Lorg/bouncycastle/asn1/x500/X500Name;[BLorg/bouncycastle/asn1/x509/Extension;Z)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final /* data */ class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final sdk.pendo.io.c4.c name;

    /* renamed from: b, reason: from kotlin metadata */
    private final byte[] keyHash;

    /* renamed from: c, reason: from kotlin metadata */
    private final sdk.pendo.io.e4.d x509authorityKeyIdentifier;

    /* renamed from: d, reason: from kotlin metadata */
    private final boolean issuedByPreCertificateSigningCert;

    public c(sdk.pendo.io.c4.c cVar, byte[] keyHash, sdk.pendo.io.e4.d dVar, boolean z) {
        Intrinsics.checkNotNullParameter(keyHash, "keyHash");
        this.name = cVar;
        this.keyHash = keyHash;
        this.x509authorityKeyIdentifier = dVar;
        this.issuedByPreCertificateSigningCert = z;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getIssuedByPreCertificateSigningCert() {
        return this.issuedByPreCertificateSigningCert;
    }

    /* renamed from: b, reason: from getter */
    public final byte[] getKeyHash() {
        return this.keyHash;
    }

    /* renamed from: c, reason: from getter */
    public final sdk.pendo.io.c4.c getName() {
        return this.name;
    }

    /* renamed from: d, reason: from getter */
    public final sdk.pendo.io.e4.d getX509authorityKeyIdentifier() {
        return this.x509authorityKeyIdentifier;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(c.class, other != null ? other.getClass() : null)) {
            return false;
        }
        if (other == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.appmattus.certificatetransparency.internal.verifier.model.IssuerInformation");
        }
        c cVar = (c) other;
        return Objects.equals(this.name, cVar.name) && Arrays.equals(this.keyHash, cVar.keyHash) && Objects.equals(this.x509authorityKeyIdentifier, cVar.x509authorityKeyIdentifier) && this.issuedByPreCertificateSigningCert == cVar.issuedByPreCertificateSigningCert;
    }

    public int hashCode() {
        sdk.pendo.io.c4.c cVar = this.name;
        int hashCode = (((cVar != null ? cVar.hashCode() : 0) * 31) + Arrays.hashCode(this.keyHash)) * 31;
        sdk.pendo.io.e4.d dVar = this.x509authorityKeyIdentifier;
        return ((hashCode + (dVar != null ? dVar.hashCode() : 0)) * 31) + Boolean.hashCode(this.issuedByPreCertificateSigningCert);
    }

    public String toString() {
        return "IssuerInformation(name=" + this.name + ", keyHash=" + Arrays.toString(this.keyHash) + ", x509authorityKeyIdentifier=" + this.x509authorityKeyIdentifier + ", issuedByPreCertificateSigningCert=" + this.issuedByPreCertificateSigningCert + ')';
    }

    public /* synthetic */ c(sdk.pendo.io.c4.c cVar, byte[] bArr, sdk.pendo.io.e4.d dVar, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : cVar, bArr, (i & 4) != 0 ? null : dVar, z);
    }
}
