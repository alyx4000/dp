package sdk.pendo.io.l;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\b\u0080\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0005J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0013\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\t\u0010\n\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0017\u0010\u0013\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0005\u0010\u0012¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/l/b;", "", "", "hostname", "", "a", "other", "equals", "", "hashCode", "toString", "Ljava/lang/String;", "pattern", "b", "canonicalHostname", "c", "Z", "getStartsWithWildcard", "()Z", "startsWithWildcard", "d", "matchAll", "e", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final /* data */ class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String pattern;

    /* renamed from: b, reason: from kotlin metadata */
    private final String canonicalHostname;

    /* renamed from: c, reason: from kotlin metadata */
    private final boolean startsWithWildcard;

    /* renamed from: d, reason: from kotlin metadata */
    private final boolean matchAll;

    /* renamed from: a, reason: from getter */
    public final boolean getMatchAll() {
        return this.matchAll;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof b) {
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.canonicalHostname, bVar.canonicalHostname) && this.startsWithWildcard == bVar.startsWithWildcard) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.canonicalHostname, Boolean.valueOf(this.startsWithWildcard)});
    }

    public String toString() {
        return "Host(pattern=" + this.pattern + ')';
    }

    public final boolean a(String hostname) {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        if (!this.startsWithWildcard) {
            return Intrinsics.areEqual(hostname, this.canonicalHostname);
        }
        int indexOf$default = StringsKt.indexOf$default((CharSequence) hostname, '.', 0, false, 6, (Object) null);
        if (this.matchAll) {
            return true;
        }
        if ((hostname.length() - indexOf$default) - 1 == this.canonicalHostname.length()) {
            String str = this.canonicalHostname;
            if (StringsKt.regionMatches(hostname, indexOf$default + 1, str, 0, str.length(), false)) {
                return true;
            }
        }
        return false;
    }
}
