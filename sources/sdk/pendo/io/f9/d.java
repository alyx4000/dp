package sdk.pendo.io.f9;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lsdk/pendo/io/f9/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "fragmentName", "I", "()I", "fragmentLevel", "c", "rootViewHashCode", "<init>", "(Ljava/lang/String;II)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final /* data */ class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String fragmentName;

    /* renamed from: b, reason: from kotlin metadata */
    private final int fragmentLevel;

    /* renamed from: c, reason: from kotlin metadata */
    private final int rootViewHashCode;

    public d(String fragmentName, int i, int i2) {
        Intrinsics.checkNotNullParameter(fragmentName, "fragmentName");
        this.fragmentName = fragmentName;
        this.fragmentLevel = i;
        this.rootViewHashCode = i2;
    }

    /* renamed from: a, reason: from getter */
    public final int getFragmentLevel() {
        return this.fragmentLevel;
    }

    /* renamed from: b, reason: from getter */
    public final String getFragmentName() {
        return this.fragmentName;
    }

    /* renamed from: c, reason: from getter */
    public final int getRootViewHashCode() {
        return this.rootViewHashCode;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof d)) {
            return false;
        }
        d dVar = (d) other;
        return Intrinsics.areEqual(this.fragmentName, dVar.fragmentName) && this.fragmentLevel == dVar.fragmentLevel && this.rootViewHashCode == dVar.rootViewHashCode;
    }

    public int hashCode() {
        return (((this.fragmentName.hashCode() * 31) + Integer.hashCode(this.fragmentLevel)) * 31) + Integer.hashCode(this.rootViewHashCode);
    }

    public String toString() {
        return "FragmentInfo(fragmentName=" + this.fragmentName + ", fragmentLevel=" + this.fragmentLevel + ", rootViewHashCode=" + this.rootViewHashCode + ")";
    }
}
