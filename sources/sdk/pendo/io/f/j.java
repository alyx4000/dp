package sdk.pendo.io.f;

import com.amplitude.reactnative.DatabaseConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.m.b;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0010\u001a\u00060\nj\u0002`\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u001b\u0010\u0010\u001a\u00060\nj\u0002`\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/f/j;", "Lsdk/pendo/io/m/b$a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/Exception;", "Lkotlin/Exception;", "a", "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", "exception", "b", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", DatabaseConstants.KEY_FIELD, "<init>", "(Ljava/lang/Exception;Ljava/lang/String;)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final /* data */ class j extends b.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Exception exception;

    /* renamed from: b, reason: from kotlin metadata */
    private final String key;

    public j(Exception exception, String key) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(key, "key");
        this.exception = exception;
        this.key = key;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof j)) {
            return false;
        }
        j jVar = (j) other;
        return Intrinsics.areEqual(this.exception, jVar.exception) && Intrinsics.areEqual(this.key, jVar.key);
    }

    public int hashCode() {
        return (this.exception.hashCode() * 31) + this.key.hashCode();
    }

    public String toString() {
        return "Public key for log server " + this.key + " cannot be used with " + sdk.pendo.io.j.c.a(this.exception);
    }
}
