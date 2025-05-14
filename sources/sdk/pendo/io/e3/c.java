package sdk.pendo.io.e3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Header;
import sdk.pendo.io.k3.g;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0005B\u0019\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0014B\u0019\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/e3/c;", "", "", "toString", "Lsdk/pendo/io/k3/g;", "a", "b", "", "hashCode", "other", "", "equals", "Lsdk/pendo/io/k3/g;", "name", "value", "c", "I", "hpackSize", "<init>", "(Lokio/ByteString;Ljava/lang/String;)V", "(Lokio/ByteString;Lokio/ByteString;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "d", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final /* data */ class c {
    public static final sdk.pendo.io.k3.g e;
    public static final sdk.pendo.io.k3.g f;
    public static final sdk.pendo.io.k3.g g;
    public static final sdk.pendo.io.k3.g h;
    public static final sdk.pendo.io.k3.g i;
    public static final sdk.pendo.io.k3.g j;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final sdk.pendo.io.k3.g name;

    /* renamed from: b, reason: from kotlin metadata */
    public final sdk.pendo.io.k3.g value;

    /* renamed from: c, reason: from kotlin metadata */
    public final int hpackSize;

    static {
        g.Companion companion = sdk.pendo.io.k3.g.INSTANCE;
        e = companion.b(":");
        f = companion.b(Header.RESPONSE_STATUS_UTF8);
        g = companion.b(Header.TARGET_METHOD_UTF8);
        h = companion.b(Header.TARGET_PATH_UTF8);
        i = companion.b(Header.TARGET_SCHEME_UTF8);
        j = companion.b(Header.TARGET_AUTHORITY_UTF8);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            sdk.pendo.io.k3.g$a r0 = sdk.pendo.io.k3.g.INSTANCE
            sdk.pendo.io.k3.g r2 = r0.b(r2)
            sdk.pendo.io.k3.g r3 = r0.b(r3)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.e3.c.<init>(java.lang.String, java.lang.String):void");
    }

    /* renamed from: a, reason: from getter */
    public final sdk.pendo.io.k3.g getName() {
        return this.name;
    }

    /* renamed from: b, reason: from getter */
    public final sdk.pendo.io.k3.g getValue() {
        return this.value;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        return Intrinsics.areEqual(this.name, cVar.name) && Intrinsics.areEqual(this.value, cVar.value);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return this.name.o() + ": " + this.value.o();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(sdk.pendo.io.k3.g name, String value) {
        this(name, sdk.pendo.io.k3.g.INSTANCE.b(value));
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    public c(sdk.pendo.io.k3.g name, sdk.pendo.io.k3.g value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.name = name;
        this.value = value;
        this.hpackSize = name.l() + 32 + value.l();
    }
}
