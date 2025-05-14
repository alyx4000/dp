package sdk.pendo.io.a9;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.d6.e;
import sdk.pendo.io.d9.c;
import sdk.pendo.io.g9.d;
import sdk.pendo.io.y6.h;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/a9/a;", "Lsdk/pendo/io/d6/e;", "", "t", "", "a", "", "f", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "description", "<init>", "(Ljava/lang/String;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class a implements e<Throwable> {

    /* renamed from: f, reason: from kotlin metadata */
    private final String description;

    public a(String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.description = description;
    }

    @Override // sdk.pendo.io.d6.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(Throwable t) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(t, "t");
        if (c.a(t)) {
            if (t instanceof Exception) {
                str = this.description;
                str2 = "UnexpectedException";
            } else if (t instanceof h) {
                str = this.description;
                str2 = "HttpException";
            } else {
                str = this.description;
                str2 = "PossibleCrash_androidX";
            }
            d.a(t, str, str2);
        }
    }
}
