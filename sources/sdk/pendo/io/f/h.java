package sdk.pendo.io.f;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.m.b;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0010\u001a\u00060\nj\u0002`\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u001b\u0010\u0010\u001a\u00060\nj\u0002`\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/f/h;", "Lsdk/pendo/io/m/b$a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/Exception;", "Lkotlin/Exception;", "a", "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", "exception", "<init>", "(Ljava/lang/Exception;)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final /* data */ class h extends b.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Exception exception;

    public h(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.exception = exception;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof h) && Intrinsics.areEqual(this.exception, ((h) other).exception);
    }

    public int hashCode() {
        return this.exception.hashCode();
    }

    public String toString() {
        return "log-list.sig failed to load with " + sdk.pendo.io.j.c.a(this.exception);
    }
}
