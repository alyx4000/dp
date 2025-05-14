package sdk.pendo.io.j;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001H\u0000¨\u0006\u0004"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "", "a", "certificatetransparency"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class e {
    public static final boolean a(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "<this>");
        String message = exc.getMessage();
        return message != null && StringsKt.startsWith$default(message, "InputStream exceeded maximum size", false, 2, (Object) null);
    }
}
